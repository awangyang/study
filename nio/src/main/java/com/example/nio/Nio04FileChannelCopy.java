package com.example.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Wang Yang
 * @date 2020/4/6 11:42
 */
public class Nio04FileChannelCopy {

    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("1.txt");
        FileChannel fisChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("2.txt");
        FileChannel fosChannel = fos.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {
            byteBuffer.clear();
            int read = fisChannel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            fosChannel.write(byteBuffer);
        }
        fosChannel.close();
        fisChannel.close();
        fis.close();
        fos.close();

    }
}
