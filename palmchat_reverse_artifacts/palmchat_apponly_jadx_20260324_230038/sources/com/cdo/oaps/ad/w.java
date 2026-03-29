package com.cdo.oaps.ad;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5459a = "utf-8";
    private static final String b = "?&scheme=gamecenter";
    private static final String c = "&jump_from_where=from_gc_sdk_start_up";
    private static final String d = "&params=";
    private static final String e = "&detailId=";
    private static final String f = "&url=";
    private static final String g = "&host=goto_maintab_page";
    private static final String h = "&host=goto_gamedetail";
    private static final String i = "&host=goto_special";
    private static final String j = "&host=goto_strategy";
    private static final String k = "&host=goto_gift_detail";
    private static final String l = "&host=goto_gift_detail_without_related_game";
    private static final String m = "&host=goto_active_detail";
    private static final String n = "&host=goto_active_detail_without_related_game";
    private static final String o = "&host=goto_earn_nbean";
    private static final String p = "&host=goto_duiba";

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "-1";
        }
        try {
            return URLEncoder.encode("&jump_from_where=" + str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static float b(Context context) {
        return y.b(context.getPackageManager(), b);
    }

    public static boolean c(Context context, long j2, String str) {
        String strA = a(e + String.valueOf(j2), str);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return y.a(context, b + j + d + strA);
    }

    private static String a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "-1";
        }
        try {
            return URLEncoder.encode("&jump_from_where=" + str2 + str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean b(Context context, long j2, String str) {
        String strA = a(e + String.valueOf(j2), str);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return y.a(context, b + i + d + strA);
    }

    public static boolean c(Context context, String str) {
        String strA = a(str);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return y.a(context, b + p + d + strA);
    }

    public static boolean a(Context context) {
        return y.a(context.getPackageManager(), b);
    }

    public static boolean b(Context context, String str) {
        String strA = a(str);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return y.a(context, b + o + d + strA);
    }

    public static boolean a(Context context, long j2, String str) {
        String strA = a(e + String.valueOf(j2), str);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return y.a(context, b + h + d + strA);
    }

    public static boolean b(Context context, String str, long j2, String str2) {
        String strA = a(e + String.valueOf(j2) + f + str, str2);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return y.a(context, b + m + d + strA);
    }

    public static boolean a(Context context, String str) {
        String strA = a(str);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return y.a(context, b + g + d + strA);
    }

    public static boolean b(Context context, String str, String str2) {
        String strA = a(f + str, str2);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return y.a(context, b + n + d + strA);
    }

    public static boolean a(Context context, String str, long j2, String str2) {
        String strA = a(e + String.valueOf(j2) + f + str, str2);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return y.a(context, b + k + d + strA);
    }

    public static boolean a(Context context, String str, String str2) {
        String strA = a(f + str, str2);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return y.a(context, b + l + d + strA);
    }
}
