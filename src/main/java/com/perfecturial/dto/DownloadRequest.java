package com.perfecturial.dto;

/**
 * @author Reza Safarpour (rsafarpour1991@gmail.com) on 9/24/2015
 */
public class DownloadRequest {
    private String fileId;
    private int size;
    private long from;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getFrom() {
        return from;
    }

    public void setFrom(long from) {
        this.from = from;
    }
}
