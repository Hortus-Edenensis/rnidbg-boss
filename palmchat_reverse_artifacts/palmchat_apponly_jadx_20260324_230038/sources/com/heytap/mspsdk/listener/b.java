package com.heytap.mspsdk.listener;

import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f6403a;
    private String b;
    private HashMap<String, String> c;

    public int a() {
        return this.f6403a;
    }

    public HashMap<String, String> b() {
        return this.c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Result{code='");
        sb.append(this.f6403a);
        sb.append('\'');
        sb.append(", message='");
        sb.append(this.b);
        sb.append('\'');
        sb.append(", item='");
        HashMap<String, String> map = this.c;
        sb.append(map != null ? map.toString() : null);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }

    public void a(int i) {
        this.f6403a = i;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(HashMap<String, String> map) {
        this.c = map;
    }
}
