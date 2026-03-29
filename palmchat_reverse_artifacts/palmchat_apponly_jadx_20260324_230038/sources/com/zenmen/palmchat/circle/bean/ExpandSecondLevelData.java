package com.zenmen.palmchat.circle.bean;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ExpandSecondLevelData {
    private String cateIcon;
    public String cateName;
    private int delStatus;
    public int id;
    public boolean isSelected;
    private int orderNo;
    public int parentId;

    public String getCateIcon() {
        return this.cateIcon;
    }

    public String getCateName() {
        return this.cateName;
    }

    public int getDelStatus() {
        return this.delStatus;
    }

    public int getId() {
        return this.id;
    }

    public int getOrderNo() {
        return this.orderNo;
    }

    public int getParentId() {
        return this.parentId;
    }

    public void setCateIcon(String str) {
        this.cateIcon = str;
    }

    public void setCateName(String str) {
        this.cateName = str;
    }

    public void setDelStatus(int i) {
        this.delStatus = i;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setOrderNo(int i) {
        this.orderNo = i;
    }

    public void setParentId(int i) {
        this.parentId = i;
    }
}
