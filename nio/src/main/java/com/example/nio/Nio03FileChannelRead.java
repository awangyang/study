package com.example.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Wang Yang
 * @date 2020/4/6 11:38
 */
public class Nio03FileChannelRead {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("1.txt");


        FileChannel channel = fis.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size());

        channel.read(byteBuffer);
//        byteBuffer.flip();
        System.out.println(new String(byteBuffer.array()));
        channel.close();
        fis.close();
    }
}
