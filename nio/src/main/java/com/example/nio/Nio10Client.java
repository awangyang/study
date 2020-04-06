package com.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author Wang Yang
 * @date 2020/4/6 14:06
 */
public class Nio10Client {

    public static void main(String[] args) throws IOException {
        //得到一个网络通道
        SocketChannel socketChannel = SocketChannel.open();
        //设置非阻塞
        socketChannel.configureBlocking(false);
        //提供服务的的IP和端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        if (!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("--因为连接需要时间，客户端不会阻塞，可以做其他工作--");
            }
        }

        String str = "wangyang 真帅！！！！";
        ByteBuffer wrap = ByteBuffer.wrap(str.getBytes());
        //发送数据，将buffer数据写入channel
        socketChannel.write(wrap);
         System.in.read();
//        socketChannel.close();
    }
}
