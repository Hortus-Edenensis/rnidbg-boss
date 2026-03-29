package defpackage;

import android.graphics.Point;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1163a = "";
    public static String b = "";

    public static int a(s7 s7Var) {
        if (s7Var != null) {
            int iR = s7Var.r();
            if (iR == 122) {
                return 2;
            }
            switch (iR) {
                case 101:
                    return 3;
                case 102:
                    return 4;
                case 103:
                    return 1;
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Point b(int i, int i2) {
        int iG;
        int iB;
        int i3;
        int iG2 = 0;
        if (i != 122) {
            switch (i) {
                case 101:
                case 102:
                    iG2 = (me1.g() - me1.b(c.b(), 40)) / 3;
                    i3 = (iG2 * 15) / 23;
                    break;
                case 103:
                    if (i2 == 1) {
                        iG = me1.g();
                        iB = me1.b(c.b(), 20);
                    } else if (i2 != 2) {
                        if (i2 == 3) {
                            iG = me1.g();
                            iB = me1.b(c.b(), 8);
                        }
                        i3 = (int) ((((double) iG2) * 9.0d) / 16.0d);
                    } else {
                        iG = me1.g();
                        iB = me1.b(c.b(), 84);
                    }
                    iG2 = iG - iB;
                    i3 = (int) ((((double) iG2) * 9.0d) / 16.0d);
                    break;
                default:
                    i3 = 0;
                    break;
            }
        }
        LogUtil.d("AdViewManager", "getImgSize w = " + iG2 + ", height = " + i3);
        return new Point(iG2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Point c(s7 s7Var, int i) {
        int iG;
        int iB;
        int i2;
        if (s7Var == null) {
            return new Point();
        }
        int iR = s7Var.r();
        int iG2 = 0;
        if (iR != 122) {
            switch (iR) {
                case 101:
                case 102:
                    iG2 = (me1.g() - me1.b(c.b(), 40)) / 3;
                    i2 = (iG2 * 15) / 23;
                    break;
                case 103:
                    if (i == 1) {
                        iG = me1.g();
                        iB = me1.b(c.b(), 20);
                    } else if (i != 2) {
                        if (i == 3) {
                            iG = me1.g();
                            iB = me1.b(c.b(), 8);
                        }
                        i2 = (int) ((((double) iG2) * 9.0d) / 16.0d);
                    } else {
                        iG = me1.g();
                        iB = me1.b(c.b(), 84);
                    }
                    iG2 = iG - iB;
                    i2 = (int) ((((double) iG2) * 9.0d) / 16.0d);
                    break;
                default:
                    i2 = 0;
                    break;
            }
        }
        LogUtil.d("AdViewManager", "getImgSize w = " + iG2 + ", height = " + i2);
        return new Point(iG2, i2);
    }

    public static String d() {
        return b;
    }

    public static boolean e() {
        LogUtil.d("AdViewManager", "delete channel = " + ac1.m);
        String str = ac1.m;
        return str != null && str.startsWith("SAMS");
    }

    public static String f(int i) {
        if (i >= 1000) {
            i /= 1000;
        }
        int i2 = i / 3600;
        int i3 = (i % 3600) / 60;
        int i4 = i % 60;
        String.valueOf(i2);
        String strValueOf = String.valueOf(i3);
        if (i3 < 10) {
            strValueOf = "0" + strValueOf;
        }
        String strValueOf2 = String.valueOf(i4);
        if (i4 < 10) {
            strValueOf2 = "0" + strValueOf2;
        }
        return strValueOf + ":" + strValueOf2;
    }

    public static void g() {
        SPUtil.f14322a.t(SPUtil.SCENE.AD, k86.a("key_delete_ad_info_mine"), Long.valueOf(ir5.b()));
    }

    public static void h(String str) {
        LogUtil.d("AdViewManager", "updatePmAdConfig = " + str);
        b = str;
    }

    public static void i(String str) {
        LogUtil.d("AdViewManager", "updateSpeedConfig = " + str);
        f1163a = str;
    }
}
