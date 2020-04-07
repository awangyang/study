package com.example.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Wang Yang
 * @date 2020/4/6 15:40
 */
public class GroupChatServer {

    /**
     * 选择器
     */
    private Selector selector;
    /**
     * 通道
     */
    private ServerSocketChannel listenChannel;

    private static final int PORT = 6667;

    public GroupChatServer() {
        try {
            selector = Selector.open();
            listenChannel = ServerSocketChannel.open();
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            listenChannel.configureBlocking(false);
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        try {
            System.out.println("服务器启动了！！！");
            while (true) {
                int count = selector.select();
                //有事件处理
                if (count > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        if (key.isAcceptable()) {
                            SocketChannel sc = listenChannel.accept();
                            sc.configureBlocking(false);
                            sc.register(selector, SelectionKey.OP_READ);
                            System.out.println(sc.getRemoteAddress() + " 上线了！！！");
                        }
                        if (key.isReadable()) {
                            read(key);
                        }
                        iterator.remove();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(SelectionKey key) {
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int i = channel.read(buffer);
            if (i > 0) {
                String msg = new String(buffer.array());
                System.out.println("from 客户端：" + msg);
                sendMsgToOther(msg, channel);
            }
        } catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + " 离线了....");
                key.cancel();
                channel.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    private void sendMsgToOther(String msg, SocketChannel self) throws IOException {
        Set<SelectionKey> selectionKeys = selector.keys();
        for (SelectionKey selectionKey : selectionKeys) {
            Channel target = selectionKey.channel();
            if (target instanceof SocketChannel && target != self) {
                ByteBuffer wrap = ByteBuffer.wrap(msg.getBytes());
                ((SocketChannel) target).write(wrap);
            }
        }
    }


    public static void main(String[] args) {
        new GroupChatServer().listen();
    }
}
