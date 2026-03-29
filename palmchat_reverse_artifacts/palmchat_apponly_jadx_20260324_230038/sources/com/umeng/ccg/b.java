package com.umeng.ccg;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f11002a = true;
    private static volatile boolean b = true;
    private static volatile boolean c = true;
    private static volatile boolean d = true;
    private static volatile boolean e = true;
    private static volatile boolean f = true;
    private static Map<String, Boolean> h = new HashMap();
    private static Object g = new Object();

    public static boolean a() {
        boolean z;
        synchronized (g) {
            z = f11002a;
        }
        return z;
    }

    public static boolean b() {
        boolean z;
        synchronized (g) {
            z = b;
        }
        return z;
    }

    public static boolean c() {
        boolean z;
        synchronized (g) {
            z = c;
        }
        return z;
    }

    public static boolean d() {
        boolean z;
        synchronized (g) {
            z = d;
        }
        return z;
    }

    public static boolean e() {
        boolean z;
        synchronized (g) {
            z = f;
        }
        return z;
    }

    public static void a(boolean z) {
        synchronized (g) {
            d = z;
            h.put(a.e, Boolean.valueOf(z));
        }
    }

    public static void b(boolean z) {
        synchronized (g) {
            e = z;
            h.put(a.i, Boolean.valueOf(z));
        }
    }

    public static void c(boolean z) {
        synchronized (g) {
            f = z;
            h.put(a.n, Boolean.valueOf(z));
        }
    }

    public static boolean a(String str) {
        boolean zBooleanValue;
        synchronized (g) {
            zBooleanValue = h.containsKey(str) ? h.get(str).booleanValue() : true;
        }
        return zBooleanValue;
    }
}
