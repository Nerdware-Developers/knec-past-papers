package com.nerdware.knecpastpapers.model;

import java.util.List;

public class Auto_parent {
    List<Auto_child> childList;
    String title;

    public Auto_parent(List<Auto_child> childList, String title) {
        this.childList = childList;
        this.title = title;
    }

    public List<Auto_child> getChildList() {
        return childList;
    }

    public void setChildList(List<Auto_child> childList) {
        this.childList = childList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
