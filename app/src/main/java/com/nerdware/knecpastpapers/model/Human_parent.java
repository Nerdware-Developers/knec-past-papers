package com.nerdware.knecpastpapers.model;

import java.util.List;

public class Human_parent {
    List<Human_child> childList;
    String title;

    public Human_parent(List<Human_child> childList, String title) {
        this.childList = childList;
        this.title = title;
    }

    public List<Human_child> getChildList() {
        return childList;
    }

    public void setChildList(List<Human_child> childList) {
        this.childList = childList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
