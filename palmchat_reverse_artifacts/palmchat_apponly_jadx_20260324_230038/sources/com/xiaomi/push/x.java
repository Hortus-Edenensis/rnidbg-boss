package com.xiaomi.push;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f11797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f1045a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f1046a;

    static {
        String str = aa.f11397a ? "ONEBOX" : "@SHIP.TO.2A2FE0D7@";
        f1045a = str;
        f1046a = false;
        f11797a = 1;
        if (str.equalsIgnoreCase("SANDBOX")) {
            f11797a = 2;
        } else if (str.equalsIgnoreCase("ONEBOX")) {
            f11797a = 3;
        } else {
            f11797a = 1;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m790a() {
        return f11797a == 2;
    }

    public static boolean b() {
        return f11797a == 3;
    }

    public static int a() {
        return f11797a;
    }

    public static void a(int i) {
        f11797a = i;
    }
}
