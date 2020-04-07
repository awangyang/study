package com.example.nio;

import java.nio.ByteBuffer;

/**
 * @author Wang Yang
 * @date 2020/4/6 11:52
 */
public class Nio06ByteBufferPutGet {

    public static void main(String[] args) {

        //指定capacity put 超过报 java.nio.BufferOverflowException
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);

        byteBuffer.putInt(10);
        byteBuffer.putLong(12L);
        byteBuffer.putDouble(1.2);
        byteBuffer.putChar('汪');

        byteBuffer.flip();
        //必须按类型顺序读取，否则报 java.nio.BufferUnderflowException
//        System.out.println(byteBuffer.getInt());
//        System.out.println(byteBuffer.getLong());
//        System.out.println(byteBuffer.getInt());
//        System.out.println(byteBuffer.getLong());

    }
}
