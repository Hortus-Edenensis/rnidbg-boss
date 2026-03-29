package com.opos.mobad.downloader.a;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8765a;
    public final String b;
    public final int c;
    public int d = 0;
    public int e;
    public d f;

    public b(String str, String str2, int i, d dVar) {
        this.f8765a = str;
        this.b = str2;
        this.c = i;
        this.f = dVar;
    }

    public boolean a(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.b) || !str.equals(this.b)) ? false : true;
    }
}
