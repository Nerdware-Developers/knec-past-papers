package com.nerdware.knecpastpapers.model;

import java.util.List;

public class fashParent {
    List<Fash_child> childList;
    String title;

    public fashParent(List<Fash_child> childList, String title) {
        this.childList = childList;
        this.title = title;
    }

    public List<Fash_child> getChildList() {
        return childList;
    }

    public void setChildList(List<Fash_child> childList) {
        this.childList = childList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
