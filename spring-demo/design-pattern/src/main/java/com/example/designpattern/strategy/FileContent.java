package com.example.designpattern.strategy;

/**
 * @author wangyang
 * @date 2020/03/12
 */
public class FileContent {

    private AbstractFileService abstractFileService;

    public FileContent(AbstractFileService abstractFileService) {
        this.abstractFileService = abstractFileService;
    }

    public String saveFile(String fid) {
        String tempFile = getTempFile(fid);
        String tqFile = tempFile2TqFile(tempFile);
        String s = saveTqFile(tqFile);
        abstractFileService.saveAttach(s);

        return fid;
    }


    private String saveTqFile(String fid) {
        return "saveTqFile";
    }

    private String getTempFile(String fid) {
        return "TempFile";
    }

    private String tempFile2TqFile(String fid) {
        return "TqFile";
    }
}
