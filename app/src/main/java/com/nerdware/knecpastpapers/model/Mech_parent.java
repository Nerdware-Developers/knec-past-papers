package com.nerdware.knecpastpapers.model;

import java.util.ArrayList;
import java.util.List;

public class Mech_parent {
    ArrayList<Mech_child> childList;
    String title;

    public Mech_parent(ArrayList<Mech_child> childList, String title) {
        this.childList = childList;
        this.title = title;
    }

    public List<Mech_child> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<Mech_child> childList) {
        this.childList = childList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
