package com.nerdware.knecpastpapers.model;

public class Catering_child {
   String fileName;
   int img;

    public Catering_child(String fileName, int img) {
        this.fileName = fileName;
        this.img = img;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
