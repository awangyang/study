package com.example.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @author Wang Yang
 * @date 2020/4/6 11:48
 */
public class Nio05FileChannelTransferFrom {

    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("1.txt");
        FileChannel fisChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("3.txt");
        FileChannel fosChannel = fos.getChannel();

        fosChannel.transferFrom(fisChannel,0,fisChannel.size());

        fosChannel.close();
        fisChannel.close();
        fis.close();
        fos.close();
    }


}
