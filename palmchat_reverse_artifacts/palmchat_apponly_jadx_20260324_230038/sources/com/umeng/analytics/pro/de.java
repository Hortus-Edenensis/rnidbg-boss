package com.umeng.analytics.pro;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class de {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10929a;
    public final byte b;
    public final int c;

    public de() {
        this("", (byte) 0, 0);
    }

    public boolean a(de deVar) {
        return this.f10929a.equals(deVar.f10929a) && this.b == deVar.b && this.c == deVar.c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof de) {
            return a((de) obj);
        }
        return false;
    }

    public String toString() {
        return "<TMessage name:'" + this.f10929a + "' type: " + ((int) this.b) + " seqid:" + this.c + ">";
    }

    public de(String str, byte b, int i) {
        this.f10929a = str;
        this.b = b;
        this.c = i;
    }
}
