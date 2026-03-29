package com.xiaomi.push;

import java.net.InetSocketAddress;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class ce {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11467a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f191a;

    public ce(String str, int i) {
        this.f191a = str;
        this.f11467a = i;
    }

    public int a() {
        return this.f11467a;
    }

    public String toString() {
        if (this.f11467a <= 0) {
            return this.f191a;
        }
        return this.f191a + ":" + this.f11467a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m250a() {
        return this.f191a;
    }

    public static ce a(String str, int i) {
        int iLastIndexOf = str.lastIndexOf(":");
        if (iLastIndexOf != -1) {
            String strSubstring = str.substring(0, iLastIndexOf);
            try {
                int i2 = Integer.parseInt(str.substring(iLastIndexOf + 1));
                if (i2 > 0) {
                    i = i2;
                }
            } catch (NumberFormatException unused) {
            }
            str = strSubstring;
        }
        return new ce(str, i);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static InetSocketAddress m249a(String str, int i) {
        ce ceVarA = a(str, i);
        return new InetSocketAddress(ceVarA.m250a(), ceVarA.a());
    }
}
