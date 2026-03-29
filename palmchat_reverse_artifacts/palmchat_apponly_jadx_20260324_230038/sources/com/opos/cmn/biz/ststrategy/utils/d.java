package com.opos.cmn.biz.ststrategy.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d {
    public static long a(Context context) {
        long j = 30;
        if (context == null) {
            return 30L;
        }
        SharedPreferences sharedPreferencesG = g(context);
        if (sharedPreferencesG != null) {
            try {
                j = sharedPreferencesG.getLong("nxLimitNew", 30L);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("SPUtil", "", e);
                return 30L;
            }
        }
        long j2 = 15;
        if (j >= 15) {
            j2 = 10080;
            if (j <= 10080) {
                return j;
            }
        }
        return j2;
    }

    public static long b(Context context, String str) {
        SharedPreferences sharedPreferencesG;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferencesG = g(context)) == null) {
            return 0L;
        }
        return sharedPreferencesG.getLong("lastTime_" + str, 0L);
    }

    public static int c(Context context) {
        SharedPreferences sharedPreferencesG;
        int i = (context == null || (sharedPreferencesG = g(context)) == null) ? 60 : sharedPreferencesG.getInt("dtLimit", 60);
        if (i < 60) {
            return 60;
        }
        return i;
    }

    public static int d(Context context) {
        SharedPreferences sharedPreferencesG;
        if (context == null || (sharedPreferencesG = g(context)) == null) {
            return 2880;
        }
        return sharedPreferencesG.getInt("blackListLimit", 2880);
    }

    public static long e(Context context, String str) {
        SharedPreferences sharedPreferencesG;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferencesG = g(context)) == null) {
            return 0L;
        }
        return sharedPreferencesG.getLong("firDTLimit_" + str, 0L);
    }

    public static boolean f(Context context) {
        SharedPreferences sharedPreferencesG;
        if (context == null || (sharedPreferencesG = g(context)) == null) {
            return false;
        }
        return sharedPreferencesG.getBoolean("isWbsVer", false);
    }

    private static final SharedPreferences g(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("com.opos.st.strategy.prefs", 0);
    }

    public static void a(Context context, int i) {
        SharedPreferences sharedPreferencesG;
        if (context == null || (sharedPreferencesG = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesG.edit();
        editorEdit.putInt("dtLimit", i);
        editorEdit.apply();
    }

    public static String b(Context context) {
        SharedPreferences sharedPreferencesG = g(context);
        String string = sharedPreferencesG != null ? sharedPreferencesG.getString("lastRegion", "") : "";
        com.opos.cmn.an.f.a.b("SPUtil", "getLastRegion=" + string);
        return string;
    }

    public static long c(Context context, String str) {
        SharedPreferences sharedPreferencesG;
        if (context == null) {
            return 0L;
        }
        try {
            if (TextUtils.isEmpty(str) || (sharedPreferencesG = g(context)) == null) {
                return 0L;
            }
            return sharedPreferencesG.getLong("curr_" + str, 0L);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("SPUtil", "", e);
            return 0L;
        }
    }

    public static long d(Context context, String str) {
        SharedPreferences sharedPreferencesG;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferencesG = g(context)) == null) {
            return 0L;
        }
        return sharedPreferencesG.getLong("firReq_" + str, 0L);
    }

    public static void e(Context context) {
        SharedPreferences sharedPreferencesG;
        if (context == null || (sharedPreferencesG = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesG.edit();
        editorEdit.putBoolean("isWbsVer", true);
        editorEdit.apply();
    }

    public static void a(Context context, long j) {
        SharedPreferences sharedPreferencesG;
        if (context == null || (sharedPreferencesG = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesG.edit();
        if (j < 15 || j > 10080) {
            j = j < 15 ? 15L : j > 10080 ? 10080L : 30L;
        }
        editorEdit.putLong("nxLimitNew", j);
        editorEdit.apply();
    }

    public static void b(Context context, int i) {
        SharedPreferences sharedPreferencesG;
        if (context == null || (sharedPreferencesG = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesG.edit();
        editorEdit.putInt("blackListLimit", i);
        editorEdit.apply();
    }

    public static void c(Context context, String str, long j) {
        SharedPreferences sharedPreferencesG;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferencesG = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesG.edit();
        editorEdit.putLong("firReq_" + str, j);
        editorEdit.apply();
    }

    public static void d(Context context, String str, long j) {
        SharedPreferences sharedPreferencesG;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferencesG = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesG.edit();
        editorEdit.putLong("firDTLimit_" + str, j);
        editorEdit.apply();
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferencesG = g(context);
        if (context == null || sharedPreferencesG == null || str == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("SPUtil", "setLastRegion=" + str);
        SharedPreferences.Editor editorEdit = sharedPreferencesG.edit();
        editorEdit.putString("lastRegion", str);
        editorEdit.apply();
    }

    public static void b(Context context, String str, long j) {
        SharedPreferences sharedPreferencesG;
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str) || (sharedPreferencesG = g(context)) == null) {
                    return;
                }
                SharedPreferences.Editor editorEdit = sharedPreferencesG.edit();
                editorEdit.putLong("curr_" + str, j);
                editorEdit.apply();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("SPUtil", "", e);
            }
        }
    }

    public static void a(Context context, String str, long j) {
        SharedPreferences sharedPreferencesG;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferencesG = g(context)) == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesG.edit();
        editorEdit.putLong("lastTime_" + str, j);
        editorEdit.apply();
    }
}
