package com.zenmen.palmchat.contacts.widget;

import defpackage.az2;
import defpackage.q05;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f13742a = new c();
    public b b = new b();
    public int[] c = {30, 20, 10};
    public C1036a d = new C1036a();

    /* JADX INFO: renamed from: com.zenmen.palmchat.contacts.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C1036a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13743a = "能量越高，曝光和打招呼机会越多";
        public int b = 5;
        public int c = 3;
        public int d = 1;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f13744a = "超越Ta";
        public String b = "查看";
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13745a = 2;
        public int b = 2;
    }

    public static a a() {
        a aVar;
        try {
            aVar = (a) az2.a(q05.f("profile_energy").toString(), a.class);
        } catch (Exception e) {
            e.printStackTrace();
            aVar = null;
        }
        return aVar == null ? new a() : aVar;
    }

    public static boolean b() {
        a aVarA = a();
        if (aVarA == null || aVarA.c == null) {
            return false;
        }
        int riskLevel = q05.e().getRiskLevel();
        if (riskLevel != 0) {
            for (int i : aVarA.c) {
                if (i != riskLevel) {
                }
            }
            return false;
        }
        for (int i2 : aVarA.c) {
            if (i2 != 10 && i2 != 20) {
            }
        }
        return false;
        return true;
    }
}
