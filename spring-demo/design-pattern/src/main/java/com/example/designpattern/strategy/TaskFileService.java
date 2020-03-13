package com.example.designpattern.strategy;

/**
 * @author wangyang
 * @date 2020/03/12
 */
public class TaskFileService extends AbstractFileService {

    @Override
    public String saveAttach(String fid) {

        return "taskAttach";
    }
}
