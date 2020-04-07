package com.example.nio;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Wang Yang
 * @date 2020/4/6 11:17
 */
public class Nio02FileChannelWrite {

    public static void main(String[] args) throws Exception {
        String txt = "Wang Yang 真帅！！！！！";

        FileOutputStream fos = new FileOutputStream("1.txt");
        //通过FileOutputStream获取对应的FileChannel
        FileChannel channel = fos.getChannel();
        //创建缓冲区buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //byteBuffer
        byteBuffer.put(txt.getBytes());
        //对byteBuffer进行flip
        byteBuffer.flip();
        //将byteBuffer写入到FileChannel
        channel.write(byteBuffer);
        channel.close();
        fos.close();
    }
}
