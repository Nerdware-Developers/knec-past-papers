package com.nerdware.knecpastpapers.model;

import java.util.List;

public class Building_parent {
    List<Building_child> childList;
    String title;

    public Building_parent(List<Building_child> childList, String title) {
        this.childList = childList;
        this.title = title;
    }

    public List<Building_child> getChildList() {
        return childList;
    }

    public void setChildList(List<Building_child> childList) {
        this.childList = childList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
