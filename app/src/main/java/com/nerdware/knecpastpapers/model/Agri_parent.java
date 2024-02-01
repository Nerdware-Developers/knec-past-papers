package com.nerdware.knecpastpapers.model;

import java.util.List;

public class Agri_parent {
    List<agriChild> childList;
    String title;

    public Agri_parent(List<agriChild> childList, String title) {
        this.childList = childList;
        this.title = title;
    }

    public List<agriChild> getChildList() {
        return childList;
    }

    public void setChildList(List<agriChild> childList) {
        this.childList = childList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
