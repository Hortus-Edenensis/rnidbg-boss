package com.bytedance.sdk.openadsdk.core;

import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMModuleRegister;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5274a = "6.6.0.0";
    public static String b = "7.2.3.2";
    public static int fx = 7232;
    public static boolean iz = true;
    public static boolean n = false;
    public static boolean nr = false;
    public static int pn = 999;
    public static final int u = 7232;
    public static String x = "main";

    public static boolean b() {
        return com.bytedance.sdk.component.l.nr.nr.bq();
    }

    public static boolean fx() {
        return com.bytedance.sdk.openadsdk.gi.iz.nr();
    }

    public static String iz() {
        return u("com.byted.pangle", 7232);
    }

    public static boolean nr() {
        return false;
    }

    public static String pn() {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.append(u() ? "_plugin" : "");
        sb.append(n ? "_open" : "_close");
        return sb.toString();
    }

    public static String u(String str, int i) {
        return "";
    }

    public static boolean x() {
        return TextUtils.equals(UMModuleRegister.INNER, x);
    }

    public static boolean u() {
        return true;
    }
}
