package com.zenmen.palmchat.widget.picker.model;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class PickerData implements Serializable {
    public int id;
    public String name;

    public PickerData() {
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public PickerData(int i, String str) {
        this.id = i;
        this.name = str;
    }
}
