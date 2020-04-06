package com.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Wang Yang
 * @date 2020/4/6 13:44
 */
public class Nio10Server {
    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //得到一个Selector对象
        Selector selector = Selector.open();
        //绑定一个端口，在服务器监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //非阻塞模式
        serverSocketChannel.configureBlocking(false);

        //把serverSocketChannel注册到Selector 关心事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        //循环等待客户端连接
        while (true) {
            //等待1秒，如果没有时间发生就返回
            if (selector.select(1000) == 0) {
                System.out.println("服务器等待了1秒，无连接");
                continue;
            }
            //如果返回的大于0，就获取相关的selectionKey集合
            //1.如果大于0，表示已经获取到关注的事件
            //2.selector.selectedKeys()返回关注事件集合
            //通过selectionKeys反向获取通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

            while (keyIterator.hasNext()) {
                //获取到SelectionKey
                SelectionKey key = keyIterator.next();
                //根据key对应的通道发生的事件做相应的处理
                if (key.isAcceptable()) {
                    //如果是OP_ACCEPT，有新的客户端连接
                    //为客户端生成一个SocketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    //将SocketChannel注册到selector,关注事件为OP_READ，同时给
                    //socketChannel关联一个Buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                if (key.isReadable()) {
                    //如果是OP_READ
                    //通过key反向获取到对应的channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    //获取到channel的buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("from 客户端 ：" + new String(buffer.array()));
                }
                keyIterator.remove();
            }
        }
    }

}
