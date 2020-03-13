package com.example.thread.unasfe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author wangyang
 * @date 2020/03/12
 */
public class UnsafeTest {

    private static Unsafe unsafe = null;
    private static long stateOffset = 0;

    private volatile long state = 0;

    public UnsafeTest() {

    }

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UnsafeTest unsafeTest = new UnsafeTest();
        boolean b = unsafe.compareAndSwapLong(unsafeTest, stateOffset, 0, 2);
        System.out.println(b);
        System.out.println(unsafeTest.state);


        String[] strings = new String[]{"1afafasfdasdfasfdasfdfs", "2", "3"};
        int i = unsafe.arrayBaseOffset(String[].class);
        System.out.println("string[] base offset is :" + i);


        long scale = unsafe.arrayIndexScale(String[].class);
        System.out.println("string[] index scale is :" + scale);


        System.out.println("first element is :" + unsafe.getObject(strings, (long) i));

        //set 100 to first string
        unsafe.putObject(strings, (long) i, "100");

        //print first string in strings[] again
        System.out.println("after set ,first element is :" + unsafe.getObject(strings, (long) i));
        System.out.println("after set ,first element is :" + unsafe.getObject(strings, (long) 20));
        System.out.println("after set ,first element is :" + unsafe.getObject(strings, (long) 24));
        System.out.println("after set ,first element is :" + unsafe.getObject(strings, (long) 28));
    }
}
