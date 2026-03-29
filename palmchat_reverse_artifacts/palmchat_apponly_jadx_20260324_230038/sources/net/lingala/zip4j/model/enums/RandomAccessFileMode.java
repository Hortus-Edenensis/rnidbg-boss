package net.lingala.zip4j.model.enums;

import com.kuaishou.weapon.p0.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public enum RandomAccessFileMode {
    READ(t.k),
    WRITE("rw");

    private String value;

    RandomAccessFileMode(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
