package com.opos.cmn.an.f.c;

import android.content.Context;
import defpackage.vw6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f7773a = false;

    public static String a(Context context) {
        try {
            b(context);
            return vw6.b() ? vw6.e(context) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static void b(Context context) {
        if (f7773a) {
            return;
        }
        vw6.c(context);
        f7773a = true;
    }
}
