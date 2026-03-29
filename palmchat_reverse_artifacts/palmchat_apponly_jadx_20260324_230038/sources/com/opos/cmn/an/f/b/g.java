package com.opos.cmn.an.f.b;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f7772a = false;

    public static synchronized void a(Context context, boolean z) {
        f7772a = z;
    }

    public static synchronized boolean a(Context context) {
        return f7772a;
    }
}
