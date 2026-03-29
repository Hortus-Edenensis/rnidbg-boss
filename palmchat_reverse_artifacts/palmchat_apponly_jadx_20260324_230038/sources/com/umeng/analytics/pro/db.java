package com.umeng.analytics.pro;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class db {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10926a;
    public final byte b;
    public final short c;

    public db() {
        this("", (byte) 0, (short) 0);
    }

    public boolean a(db dbVar) {
        return this.b == dbVar.b && this.c == dbVar.c;
    }

    public String toString() {
        return "<TField name:'" + this.f10926a + "' type:" + ((int) this.b) + " field-id:" + ((int) this.c) + ">";
    }

    public db(String str, byte b, short s) {
        this.f10926a = str;
        this.b = b;
        this.c = s;
    }
}
