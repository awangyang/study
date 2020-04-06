package com.example.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Wang Yang
 * @date 2020/4/6 12:03
 * <p>
 * MappedByteBuffer 可以让文件直接在内存中修改（堆外内存），操作系统不需要拷贝一次
 */
public class Nio08MappedByteBuffer {

    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");

        FileChannel channel = randomAccessFile.getChannel();


        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());

        map.put(1, (byte) 'Y');
        channel.close();
        randomAccessFile.close();


    }
}
