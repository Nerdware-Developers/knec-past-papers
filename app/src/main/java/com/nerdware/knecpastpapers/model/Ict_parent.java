package com.nerdware.knecpastpapers.model;

import java.util.List;

public class Ict_parent {
    List<Ict_child> childList;
    String title;

    public Ict_parent(List<Ict_child> childList, String title) {
        this.childList = childList;
        this.title = title;
    }

    public List<Ict_child> getChildList() {
        return childList;
    }

    public void setChildList(List<Ict_child> childList) {
        this.childList = childList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
