package com.unicom.online.account.kernel;

import com.unicom.online.account.shield.ResultListener;
import com.unicom.online.account.shield.UniAccountHelper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f11154a = "";
    public static UniAccountHelper.Language b = UniAccountHelper.Language.SIMPLECHINESE;
    public static ResultListener c = null;
    private static String d = "";
    private static String e = "";
    private static String f = "";
    private static long g = 0;
    private static long h = 0;
    private static String i = "CU";

    public static String a() {
        return i;
    }

    public static void b() {
        d = "";
        e = "";
        h = 0L;
        g = 0L;
    }

    public static void c(String str) {
        d = str;
    }

    public static void d(String str) {
        f = str;
    }

    public static Boolean e(String str) {
        return (str == null || str.length() == 0 || str.trim().length() == 0 || com.igexin.push.core.b.m.equals(str) || str.equals("")) ? Boolean.FALSE : Boolean.TRUE;
    }

    public static void a(long j) {
        h = j;
    }

    public static void b(long j) {
        g = j;
    }

    public static void a(String str) {
        i = str;
    }

    public static void b(String str) {
        e = str;
    }
}
