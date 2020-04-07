package com.example.nio;

import java.nio.ByteBuffer;

/**
 * @author Wang Yang
 * @date 2020/4/6 11:58
 */
public class Nio07ByteBufferReadOnly {

    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);

        byteBuffer.put("婷婷玉立".getBytes());


        ByteBuffer byteBuffer1 = byteBuffer.asReadOnlyBuffer();
        byteBuffer1.flip();
        System.out.println(new String(byteBuffer.array()));
        //只读，继续put报java.nio.ReadOnlyBufferException
        byteBuffer1.put((byte) 123);
    }
}
