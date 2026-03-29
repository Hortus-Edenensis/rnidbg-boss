package com.zenmen.palmchat.circle.bean;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleCateItem implements Serializable {
    private String cateName;
    public int delStatus;
    private int id;

    public String getCateName() {
        return this.cateName;
    }

    public int getId() {
        return this.id;
    }

    public void setCateName(String str) {
        this.cateName = str;
    }

    public void setId(int i) {
        this.id = i;
    }
}
