package com.opos.mobad.template.i.a;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: com.opos.mobad.template.i.a.a$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f10099a;

        static {
            int[] iArr = new int[com.opos.mobad.template.e.a.values().length];
            f10099a = iArr;
            try {
                iArr[com.opos.mobad.template.e.a.TILT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10099a[com.opos.mobad.template.e.a.SHAKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10099a[com.opos.mobad.template.e.a.SHAKE_AND_UP_SLIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10099a[com.opos.mobad.template.e.a.FORWARD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int a(int i) {
        com.opos.cmn.an.f.a.b("ImageSplashUtil", "getBigButtonBottomMarginInDp() splashType=", Integer.valueOf(i));
        switch (i) {
            case 0:
            case 1:
            case 5:
            case 9:
            case 10:
            case 11:
                return 42;
            case 2:
                return 87;
            case 3:
                return 28;
            case 4:
                return 30;
            case 6:
            case 7:
            case 8:
            default:
                return 81;
            case 12:
                return 24;
        }
    }

    public static int b(int i) {
        int i2;
        switch (i) {
            case 0:
            case 1:
            case 5:
            case 9:
            case 10:
                i2 = 78;
                break;
            case 2:
                i2 = 79;
                break;
            case 3:
                i2 = 28;
                break;
            case 4:
            case 11:
            case 12:
                i2 = 24;
                break;
            case 6:
            case 7:
            case 8:
            default:
                i2 = 81;
                break;
        }
        com.opos.cmn.an.f.a.b("ImageSplashUtil", "getClickViewBottomMarginInDp() splashType=", Integer.valueOf(i), "bottomMarginInDp=", Integer.valueOf(i2));
        return i2;
    }

    public static boolean c(int i) {
        return i == 71 || i == 2073 || i == 2024 || i == 59 || i == 68 || i == 2053 || i == 2061 || i == 2041;
    }

    public static boolean d(int i) {
        return i == 2073 || i == 59 || i == 68 || i == 2061;
    }

    public static boolean e(int i) {
        return i == 59 || i == 68 || i == 71 || i == 2024 || i == 2041 || i == 2053 || i == 2058 || i == 2061 || i == 2073;
    }

    public static boolean f(int i) {
        return i == 59 || i == 60;
    }

    public static boolean g(int i) {
        return i == 60;
    }

    public static int a(boolean z, int i) {
        if (!z) {
            if (i != 2) {
                if (i == 3 || i == 4) {
                    return 37;
                }
                return (i == 11 || i == 12) ? 28 : 81;
            }
            return 87;
        }
        if (i != 0) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return 28;
                    }
                    if (i != 5) {
                        switch (i) {
                        }
                        return 28;
                    }
                }
                return 18;
            }
            return 87;
        }
        return 46;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(com.opos.mobad.template.d.b bVar, boolean z) {
        String str;
        com.opos.mobad.template.e.a aVar = com.opos.mobad.template.e.a.UNKNOWN;
        String str2 = "点击";
        if (bVar != null) {
            aVar = bVar.L;
            if (z) {
                int i = AnonymousClass1.f10099a[aVar.ordinal()];
                if (i == 1) {
                    str = "倾斜或";
                } else if (i == 2 || i == 3) {
                    str = "摇动或";
                } else if (i == 4) {
                    str = "前倾或";
                }
                if (TextUtils.isEmpty(bVar.j)) {
                    str2 = str + "点击" + bVar.j;
                }
            } else {
                str = "";
                if (TextUtils.isEmpty(bVar.j) && bVar.j.contains("点击")) {
                    str2 = str + bVar.j;
                } else {
                    str2 = str + "点击" + bVar.j;
                }
            }
        }
        com.opos.cmn.an.f.a.b("ImageSplashUtil", "getClickBtnText()", "btnText=", str2, "isSupport=", Boolean.valueOf(z), "mode=", aVar);
        return str2;
    }
}
