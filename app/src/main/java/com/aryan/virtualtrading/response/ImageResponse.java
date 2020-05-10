package com.aryan.virtualtrading.response;

public class ImageResponse {

    private String filename;

    public ImageResponse(String filename) {
        this.filename = filename;
    }

    public String getFileName() {
        return filename;
    }

    public void setFileName(String filename) {
        this.filename = filename;
    }
}
