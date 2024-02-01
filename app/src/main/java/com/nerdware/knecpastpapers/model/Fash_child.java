package com.nerdware.knecpastpapers.model;

public class Fash_child {
    String fileName;
    int image;

    public Fash_child(String fileName, int image) {
        this.fileName = fileName;
        this.image = image;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
