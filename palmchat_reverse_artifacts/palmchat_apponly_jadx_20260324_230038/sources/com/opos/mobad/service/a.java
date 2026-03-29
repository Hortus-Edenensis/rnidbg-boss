package com.opos.mobad.service;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f9191a;
    private static volatile Context b;

    public static Context a(Context context) {
        return f9191a != null ? f9191a : context;
    }

    public static Context b(Context context) {
        return b != null ? b : context;
    }

    public static void a() {
        f9191a = null;
        b = null;
    }

    public static void a(Context context, Context context2) {
        f9191a = context;
        b = context2;
    }
}
