package com.xiaomi.push;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class fb implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f11566a = "wcc-ml-test10.bj";
    public static String b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private fe f448a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f449a = fa.f432a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private boolean f450b = true;
    private String c;
    private String d;
    private String e;

    public fb(Map<String, Integer> map, int i, String str, fe feVar) {
        a(map, i, str, feVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] mo446a() {
        return null;
    }

    public void b(String str) {
        this.e = str;
    }

    public String c() {
        if (this.d == null) {
            this.d = a();
        }
        return this.d;
    }

    public static final String a() {
        String str = b;
        return str != null ? str : x.m790a() ? "sandbox.xmpush.xiaomi.com" : x.b() ? "10.38.162.35" : "app.chat.xiaomi.net";
    }

    public String b() {
        return this.e;
    }

    public void c(String str) {
        this.d = str;
    }

    public static final void a(String str) {
        if (x.b()) {
            return;
        }
        b = str;
    }

    private void a(Map<String, Integer> map, int i, String str, fe feVar) {
        this.f447a = i;
        this.c = str;
        this.f448a = feVar;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m444a() {
        return this.f447a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m445a() {
        return this.f449a;
    }

    public void a(boolean z) {
        this.f449a = z;
    }
}
