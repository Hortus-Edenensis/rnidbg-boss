package com.ss.android.downloadlib.addownload.nr;

import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx {
    public static int fx = 2;
    public static int nr = 1;
    public static int u;
    private int b = u;
    private long pn = 0;
    private JSONObject iz = null;
    private int x = 0;
    private String n = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f10588a = "";

    public int nr() {
        return this.x;
    }

    public boolean u() {
        return this.b == nr;
    }

    public fx nr(int i) {
        this.x = i;
        return this;
    }

    public fx u(int i) {
        this.b = i;
        return this;
    }
}
