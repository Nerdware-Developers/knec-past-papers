package com.nerdware.knecpastpapers.model;

import java.util.List;

public class Catering_parent {
    List<Catering_child> childList;
    String title;

    public Catering_parent(List<Catering_child> childList, String title) {
        this.childList = childList;
        this.title = title;
    }

    public List<Catering_child> getChildList() {
        return childList;
    }

    public void setChildList(List<Catering_child> childList) {
        this.childList = childList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
