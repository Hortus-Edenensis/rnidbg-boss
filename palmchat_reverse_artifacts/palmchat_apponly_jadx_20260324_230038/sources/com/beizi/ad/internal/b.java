package com.beizi.ad.internal;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static HashSet<String> f4376a;
    private String c;
    private WeakReference<Context> m;
    private String n;
    private f b = f.PREFETCH;
    private int d = 3;
    private boolean e = false;
    private int f = -1;
    private int g = -1;
    private int h = -1;
    private int i = -1;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;

    public b(Context context, String str) {
        this.n = "";
        this.m = new WeakReference<>(context);
        this.n = str;
    }

    public void a(String str) {
        this.n = str;
    }

    public void b(String str) {
        this.c = str;
    }

    public void a(f fVar) {
        this.b = fVar;
    }

    public f a() {
        return this.b;
    }
}
