package com.example.designpattern.strategy;

/**
 * @author wangyang
 * @date 2020/03/12
 */
public class Test {
    public static void main(String[] args) {
        FileContent fileContent = new FileContent(new TaskFileService());

        System.out.println(fileContent.saveFile("111"));
    }
}
