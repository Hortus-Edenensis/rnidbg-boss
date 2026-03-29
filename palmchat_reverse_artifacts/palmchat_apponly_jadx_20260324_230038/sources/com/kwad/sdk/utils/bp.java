package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class bp {
    private static final SimpleDateFormat bfJ;
    private static final SimpleDateFormat bfK;
    private static final SimpleDateFormat bfL;
    private static final SimpleDateFormat bfM;
    private static final SimpleDateFormat bfN;
    private static final SimpleDateFormat bfO;
    private static final SimpleDateFormat bfP;

    static {
        Locale locale = Locale.US;
        bfJ = new SimpleDateFormat("MM/dd", locale);
        bfK = new SimpleDateFormat("yyyy/MM/dd", locale);
        bfL = new SimpleDateFormat("MM月dd日", locale);
        bfM = new SimpleDateFormat("yyyy年MM月dd日", locale);
        bfN = new SimpleDateFormat("HH:mm", locale);
        bfO = new SimpleDateFormat("MM-dd", locale);
        bfP = new SimpleDateFormat("yyyy-MM-dd", locale);
    }

    public static boolean hG(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches(".*\\.kpg.*");
    }

    public static boolean isEquals(String str, String str2) {
        return !TextUtils.isEmpty(str) && str.equals(str2);
    }

    public static boolean isNullString(String str) {
        return TextUtils.isEmpty(str) || com.igexin.push.core.b.m.equalsIgnoreCase(str);
    }
}
