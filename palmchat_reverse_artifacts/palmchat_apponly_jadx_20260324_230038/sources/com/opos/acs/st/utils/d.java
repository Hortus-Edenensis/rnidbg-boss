package com.opos.acs.st.utils;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f7717a = false;
    private static String b = null;
    private static String c = null;
    private static volatile boolean d = false;

    public static String a(Context context) {
        if (TextUtils.isEmpty(b)) {
            b = com.opos.cmn.biz.a.d.a(context);
        }
        return b;
    }

    public static String b(Context context) {
        return TextUtils.isEmpty(c) ? com.opos.cmn.biz.a.b.a(context) : c;
    }

    public static void c(Context context) {
        if (context != null) {
            try {
                com.opos.cmn.g.a.b.d(context);
            } catch (Exception e) {
                f.c("InitUtil", "", e);
            }
        }
    }

    public static void a() {
        d = true;
    }

    public static void b(Context context, String str) {
        com.opos.cmn.biz.a.b.a(context, str);
    }

    public static void a(Context context, String str) {
        com.opos.cmn.biz.a.d.a(context, "CN");
    }

    public static boolean b() {
        return d;
    }

    public static void a(boolean z) {
        f7717a = z;
    }
}
