package com.example.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author Wang Yang
 * @date 2020/4/6 12:13
 */
public class Nio09ScatteringAndGathering {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();

        InetSocketAddress inetSocketAddress = new InetSocketAddress(6666);

        channel.bind(inetSocketAddress);
        ByteBuffer[] byteBuffers = new ByteBuffer[2];

        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        SocketChannel socketChannel = channel.accept();
        int messageLength = 8;
        while (true) {
            int read = 0;
            while (read < messageLength) {
                long l = socketChannel.read(byteBuffers);
                read += l;
                Arrays.asList(byteBuffers).stream().map(byteBuffer -> " pos = "+ byteBuffer.position()+" limit = "+ byteBuffer.limit()).forEach(System.out::println);
            }
            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.flip());
            int write = 0;
            while (write < messageLength) {
                long l = socketChannel.read(byteBuffers);
                write += l;

            }
            Arrays.asList(byteBuffers).forEach(byteBuffer -> {
                System.out.print(new String(byteBuffer.array()));
                byteBuffer.clear();
            });
            Arrays.asList(byteBuffers).stream().map(byteBuffer -> " pos = "+ byteBuffer.position()+" limit = "+ byteBuffer.limit()).forEach(System.out::println);
        }

    }
}
