package com.xiaomi.push;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f11640a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f835a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final short f836a;

    public hx() {
        this("", (byte) 0, (short) 0);
    }

    public String toString() {
        return "<TField name:'" + this.f835a + "' type:" + ((int) this.f11640a) + " field-id:" + ((int) this.f836a) + ">";
    }

    public hx(String str, byte b, short s) {
        this.f835a = str;
        this.f11640a = b;
        this.f836a = s;
    }
}
