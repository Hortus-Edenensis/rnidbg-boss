package com.opos.mobad.activity.webview;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f8512a;
    public final int b;
    public final boolean c;
    public final boolean d;

    public d(Map<String, Object> map, int i, boolean z, boolean z2) {
        this.f8512a = map;
        this.b = i;
        this.c = z;
        this.d = z2;
    }

    public String toString() {
        return "WebViewInitParams{, jsInterfaceMap=" + this.f8512a + ", actionType=" + this.b + '}';
    }
}
