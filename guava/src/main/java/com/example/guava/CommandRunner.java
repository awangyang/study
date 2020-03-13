package com.example.guava;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author wangyang
 * @date 2020/03/04
 */
@Component
public class CommandRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println(args[0]);
        System.out.println("--------");
    }
}
