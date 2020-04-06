package com.example.nio.groupchat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Wang Yang
 * @date 2020/4/6 15:59
 */
public class GroupChatClient {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6667;
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    public GroupChatClient() throws IOException {
        selector = Selector.open();
        socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        username = socketChannel.getLocalAddress().toString();
        System.out.println(socketChannel.getLocalAddress() + " is OK!!!");
    }


    public void send(String msg) {
        msg = username + " 说：" + msg;
        try {

            socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void read() {
        try {
            int select = selector.select();
            if (select > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        channel.read(buffer);
                        System.out.println(new String(buffer.array()).trim());
                    }
                    iterator.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        GroupChatClient chatClient = new GroupChatClient();
        new Thread(() -> {
            while (true) {
                try {
                    chatClient.read();
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            chatClient.send(s);
        }
    }
}
