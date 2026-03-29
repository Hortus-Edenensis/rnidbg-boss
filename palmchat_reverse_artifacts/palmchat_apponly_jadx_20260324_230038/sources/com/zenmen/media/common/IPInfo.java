package com.zenmen.media.common;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class IPInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11944a;
    public int b;
    public IP_Type c;

    /* JADX INFO: compiled from: SearchBox */
    public enum IP_Type {
        Notify,
        Cmd
    }

    public IPInfo(IP_Type iP_Type, String str, int i) {
        this.c = iP_Type;
        this.f11944a = str;
        this.b = i;
    }

    public String a() {
        return this.f11944a;
    }

    public int b() {
        return this.b;
    }
}
