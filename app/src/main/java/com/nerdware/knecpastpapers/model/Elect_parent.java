package com.nerdware.knecpastpapers.model;

import java.util.List;

public class Elect_parent {
    List<Elect_child> childList;
    String title;

    public Elect_parent(List<Elect_child> childList, String title) {
        this.childList = childList;
        this.title = title;
    }

    public List<Elect_child> getChildList() {
        return childList;
    }

    public void setChildList(List<Elect_child> childList) {
        this.childList = childList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
