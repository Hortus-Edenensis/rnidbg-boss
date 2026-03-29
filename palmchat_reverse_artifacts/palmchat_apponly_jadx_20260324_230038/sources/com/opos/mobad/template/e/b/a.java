package com.opos.mobad.template.e.b;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {
    public static int A = 116;
    public static int B = 116;
    public static int C = 35;
    public static int c = 1500;
    public static int d = 7500;
    public static int e = 18;
    public static int f = 1000;
    public static int g = 18;
    public static int h = 500;
    public static int i = 70;
    public static int j = 70;
    public static int k = 1500;
    public static int l = 7500;
    public static int m = 70;
    public static int n = 70;
    public static int o = 18;
    public static int p = 3000;
    public static int q = 15000;
    public static int r = 30;
    public static int s = 2000;
    public static boolean t = true;
    public static int u = 30;
    public static int v = 1000;
    public static int w = 116;
    public static int x = 116;
    public static int y = 3000;
    public static int z = 15000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.opos.mobad.template.e.a f9428a;
    public final String b;

    /* JADX INFO: renamed from: com.opos.mobad.template.e.b.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9429a;

        static {
            int[] iArr = new int[com.opos.mobad.template.e.a.values().length];
            f9429a = iArr;
            try {
                iArr[com.opos.mobad.template.e.a.SHAKE_AND_UP_SLIDE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9429a[com.opos.mobad.template.e.a.SHAKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9429a[com.opos.mobad.template.e.a.TILT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9429a[com.opos.mobad.template.e.a.FORWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9429a[com.opos.mobad.template.e.a.UP_SLIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9429a[com.opos.mobad.template.e.a.FULLSCREEN_SLIDE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f9429a[com.opos.mobad.template.e.a.SLIDE_LAYER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public a(com.opos.mobad.template.d.b bVar) {
        String str;
        if (bVar == null) {
            this.f9428a = com.opos.mobad.template.e.a.UNKNOWN;
            str = "";
        } else {
            this.f9428a = bVar.L;
            str = bVar.j;
        }
        this.b = str;
    }

    public static a a(com.opos.mobad.template.d.b bVar) {
        if (bVar == null) {
            return new a(bVar);
        }
        switch (AnonymousClass1.f9429a[bVar.L.ordinal()]) {
        }
        return new a(bVar);
    }

    public String a(com.opos.mobad.template.d.b bVar, String str) {
        Map<String, String> map;
        if (bVar != null && (map = bVar.J) != null) {
            try {
                if (map.containsKey(str)) {
                    return map.get(str);
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.d("BaseInteractiveInfo", "getValueSafe", e2);
            }
        }
        return null;
    }
}
