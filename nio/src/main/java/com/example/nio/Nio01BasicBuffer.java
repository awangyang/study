package com.example.nio;

import java.nio.IntBuffer;

/**
 * @author Wang Yang
 * @date 2020/4/6 11:09
 */
public class Nio01BasicBuffer {

    public static void main(String[] args) {

        //指定capacity put 超过报 java.nio.BufferOverflowException
        IntBuffer intBuffer = IntBuffer.allocate(5);

        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i);
        }

        intBuffer.flip();
        intBuffer.position(2);
        intBuffer.limit(3);
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
