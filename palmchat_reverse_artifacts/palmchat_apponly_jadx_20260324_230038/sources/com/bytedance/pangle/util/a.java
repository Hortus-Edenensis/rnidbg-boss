package com.bytedance.pangle.util;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    public static boolean a() {
        int i = Build.VERSION.SDK_INT;
        return i >= 29 && i <= 30;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean bg() {
        int i = Build.VERSION.SDK_INT;
        if (i < 31) {
            return i == 30 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean bq() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "huawei");
    }

    public static boolean dw() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "samsung");
    }

    public static boolean fx() {
        return false;
    }

    public static boolean iz() {
        return Build.VERSION.SDK_INT < 23;
    }

    public static boolean jk() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean k() {
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            return i == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean l() {
        int i = Build.VERSION.SDK_INT;
        return i >= 24 && i <= 25;
    }

    public static boolean mv() {
        int i = Build.VERSION.SDK_INT;
        return i >= 24 && i <= 28;
    }

    public static boolean my() {
        int i = Build.VERSION.SDK_INT;
        if (i < 29) {
            return i == 28 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean n() {
        int i = Build.VERSION.SDK_INT;
        return i >= 26 && i <= 28;
    }

    public static boolean nr() {
        return Build.VERSION.SDK_INT > 22;
    }

    public static boolean o() {
        return Build.VERSION.SDK_INT == 29;
    }

    public static boolean pn() {
        return Build.VERSION.SDK_INT <= 23;
    }

    public static boolean s() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static boolean sx() {
        int i = Build.VERSION.SDK_INT;
        if (i < 30) {
            return i == 29 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean t() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static boolean u() {
        return true;
    }

    public static boolean x() {
        return Build.VERSION.SDK_INT <= 25;
    }
}
