package com.baidu.location.e.b;

import com.baidu.location.e.b.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f3521a = -1;
    private static int b = -1;
    private static int c = -1;
    private static int d = -1;
    private static int e = -1;
    private static int f = -1;

    /* JADX INFO: renamed from: com.baidu.location.e.b.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.baidu.location.e.b.b$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3522a;

        static {
            int[] iArr = new int[EnumC0069b.values().length];
            f3522a = iArr;
            try {
                iArr[EnumC0069b.SUBWAY_STATIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3522a[EnumC0069b.TRAFFIC_STATUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3522a[EnumC0069b.VDR_INDOOR_SPEED_STATUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3522a[EnumC0069b.INDOOR_POI_DATA_STATUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3522a[EnumC0069b.OUTDOOR_POI_DATA_STATUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3522a[EnumC0069b.GPS_CHECKER_STATUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f3523a = new b(null);
    }

    /* JADX INFO: renamed from: com.baidu.location.e.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public enum EnumC0069b {
        SUBWAY_STATIC,
        TRAFFIC_STATUS,
        VDR_INDOOR_SPEED_STATUS,
        INDOOR_POI_DATA_STATUS,
        OUTDOOR_POI_DATA_STATUS,
        GPS_CHECKER_STATUS
    }

    private b() {
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        return a.f3523a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String a(EnumC0069b enumC0069b) {
        switch (AnonymousClass2.f3522a[enumC0069b.ordinal()]) {
            case 1:
                if (f3521a == 0) {
                    return a.e.b;
                }
                return null;
            case 2:
                if (b == 0) {
                    return a.f.b;
                }
                return null;
            case 3:
                if (c == 0) {
                    return a.c.b;
                }
                return null;
            case 4:
                if (d == 0) {
                    return a.b.f3516a;
                }
                return null;
            case 5:
                if (e == 0) {
                    return a.d.f3518a;
                }
                return null;
            case 6:
                if (f == 0) {
                    return a.C0068a.f3515a;
                }
                return null;
            default:
                return null;
        }
    }
}
