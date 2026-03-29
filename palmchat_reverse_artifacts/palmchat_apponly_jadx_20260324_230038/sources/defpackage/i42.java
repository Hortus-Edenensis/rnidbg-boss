package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.vv3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class i42 {
    public static boolean a(Context context, vv3 vv3Var, String str) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("nest_interstitial_ad_sp_request", 0);
            long j = sharedPreferences.getLong("nest_interstitial_inter_time_stamp_" + str, System.currentTimeMillis());
            int i = sharedPreferences.getInt("nest_interstitial_inter_times_" + str, 0);
            if (!by5.k(j)) {
                i = 0;
            }
            int iG = vv3Var.g(str);
            return iG <= 0 || i >= iG;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean b(Context context, vv3 vv3Var, String str, String str2, String str3) {
        if (context == null) {
            pu3.c(9, str2, str3);
            return false;
        }
        if (il5.l(str)) {
            pu3.c(11, str2, str3);
            return false;
        }
        if (vv3Var == null) {
            pu3.c(10, str2, str3);
            return false;
        }
        if (!a(context, vv3Var, str)) {
            pu3.c(17, str2, str3);
            return false;
        }
        vv3.a aVarD = vv3Var.d();
        if (aVarD == null) {
            return true;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("nest_interstitial_ad_sp_request", 0);
        int iE = aVarD.e();
        int iD = aVarD.d();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i = sharedPreferences.getInt("nest_interstitial_ad_last_show_time_", iCurrentTimeMillis);
        int i2 = sharedPreferences.getInt("nest_interstitial_ad_showed_times_", 0);
        if (iCurrentTimeMillis - i > iE) {
            return true;
        }
        if (i2 >= iD) {
            pu3.c(4, str2, str3);
        }
        return i2 < iD;
    }

    public static void c(Context context, String str) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("nest_interstitial_ad_sp_request", 0);
            int i = by5.k(sharedPreferences.getLong("nest_interstitial_inter_time_stamp_" + str, System.currentTimeMillis())) ? 1 + sharedPreferences.getInt("nest_interstitial_inter_times_" + str, 0) : 1;
            sharedPreferences.edit().putLong("nest_interstitial_inter_time_stamp_" + str, System.currentTimeMillis()).apply();
            sharedPreferences.edit().putInt("nest_interstitial_inter_times_" + str, i).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void d(Context context, vv3 vv3Var, String str) {
        if (context == null || vv3Var == null || il5.l(str)) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("nest_interstitial_ad_sp_request", 0);
        vv3.a aVarD = vv3Var.d();
        vv3.a aVarH = vv3Var.h(str);
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (sharedPreferences != null) {
            if (aVarD != null) {
                int i = iCurrentTimeMillis - sharedPreferences.getInt("nest_interstitial_ad_last_show_time_", iCurrentTimeMillis) <= aVarD.e() ? sharedPreferences.getInt("nest_interstitial_ad_showed_times_", 0) + 1 : 1;
                if (i == 1) {
                    sharedPreferences.edit().putInt("nest_interstitial_ad_last_show_time_", iCurrentTimeMillis).apply();
                }
                sharedPreferences.edit().putInt("nest_interstitial_ad_showed_times_", i).apply();
            }
            if (aVarH != null) {
                int iE = aVarH.e();
                int i2 = sharedPreferences.getInt("nest_interstitial_ad_showed_times_" + str, 0);
                StringBuilder sb = new StringBuilder();
                sb.append("nest_interstitial_ad_last_show_time_");
                sb.append(str);
                int i3 = iCurrentTimeMillis - sharedPreferences.getInt(sb.toString(), iCurrentTimeMillis) <= iE ? i2 + 1 : 1;
                if (i3 == 1) {
                    sharedPreferences.edit().putInt("nest_interstitial_ad_last_show_time_" + str, iCurrentTimeMillis).apply();
                }
                sharedPreferences.edit().putInt("nest_interstitial_ad_showed_times_" + str, i3).apply();
                return;
            }
            vv3.a aVarI = vv3Var.i(str);
            LogUtil.d("", "SEEMEPOP saveShowFrequencyInfo tabPageOtherInfo " + aVarI);
            if (aVarI != null) {
                int iE2 = aVarI.e();
                int i4 = sharedPreferences.getInt("nest_interstitial_ad_showed_times_" + aVarI.f(), 0);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("nest_interstitial_ad_last_show_time_");
                sb2.append(aVarI.f());
                int i5 = iCurrentTimeMillis - sharedPreferences.getInt(sb2.toString(), iCurrentTimeMillis) <= iE2 ? i4 + 1 : 1;
                if (i5 == 1) {
                    sharedPreferences.edit().putInt("nest_interstitial_ad_last_show_time_" + aVarI.f(), iCurrentTimeMillis).apply();
                }
                sharedPreferences.edit().putInt("nest_interstitial_ad_showed_times_" + aVarI.f(), i5).apply();
                LogUtil.d("", "SEEMEPOP saveShowFrequencyInfo tabPageShowTimes " + i5 + " curTime " + iCurrentTimeMillis + " tabPageFrequencyTimeSeconds " + iE2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean e(Context context, vv3 vv3Var, String str, String str2, String str3) {
        boolean z;
        boolean z2;
        if (context == null) {
            pu3.d(9, str2, str3, 1);
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            pu3.d(11, str2, str3, 1);
            return false;
        }
        if (vv3Var == null) {
            pu3.d(10, str2, str3, 1);
            return false;
        }
        if (!a(context, vv3Var, str)) {
            pu3.d(17, str2, str3, 1);
            return false;
        }
        vv3.a aVarD = vv3Var.d();
        vv3.a aVarH = vv3Var.h(str);
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        SharedPreferences sharedPreferences = context.getSharedPreferences("nest_interstitial_ad_sp_request", 0);
        if (aVarD != null) {
            int iE = aVarD.e();
            int iD = aVarD.d();
            int i = sharedPreferences.getInt("nest_interstitial_ad_last_show_time_", iCurrentTimeMillis);
            int i2 = sharedPreferences.getInt("nest_interstitial_ad_showed_times_", 0);
            if (iCurrentTimeMillis - i <= iE) {
                z = i2 < iD;
                if (!z) {
                    pu3.d(15, str2, str3, 1);
                }
            } else {
                z = true;
            }
        }
        if (aVarH != null) {
            int iE2 = aVarH.e();
            int iD2 = aVarH.d();
            int i3 = sharedPreferences.getInt("nest_interstitial_ad_last_show_time_" + str, iCurrentTimeMillis);
            int i4 = sharedPreferences.getInt("nest_interstitial_ad_showed_times_" + str, 0);
            if (iCurrentTimeMillis - i3 <= iE2) {
                z2 = i4 < iD2;
                if (!z2) {
                    pu3.e(16, str2, str3, 1, str);
                }
            } else {
                z2 = true;
            }
        } else {
            vv3.a aVarI = vv3Var.i(str);
            LogUtil.d("", "SEEMEPOP showFrequencyAllow tabPageOtherInfo " + aVarI);
            if (aVarI != null) {
                int iE3 = aVarI.e();
                int iD3 = aVarI.d();
                int i5 = sharedPreferences.getInt("nest_interstitial_ad_last_show_time_" + aVarI.f(), iCurrentTimeMillis);
                int i6 = sharedPreferences.getInt("nest_interstitial_ad_showed_times_" + aVarI.f(), 0);
                int i7 = iCurrentTimeMillis - i5;
                LogUtil.d("", "SEEMEPOP showFrequencyAllow tabPageFreqTimeSeconds " + iE3 + " tabPageFreqPv " + iD3 + " tabPageLastTime " + i5 + " tabPageAlreadyShowTimes " + i6 + " tabPageIntervalTime " + i7);
                if (i7 <= iE3) {
                    z2 = i6 < iD3;
                    LogUtil.d("", "SEEMEPOP showFrequencyAllow !tabPageFreqAllow " + z2);
                    if (!z2) {
                        pu3.e(16, str2, str3, 1, str);
                    }
                } else {
                    LogUtil.d("", "SEEMEPOP showFrequencyAllow 超过频控时间，直接允许请求 " + aVarI);
                }
            } else {
                LogUtil.d("", "SEEMEPOP showFrequencyAllow tabPageOtherInfo null " + aVarI);
            }
            z2 = true;
        }
        LogUtil.d("", "SEEMEPOP showFrequencyAllow end globalFreqAllow " + z + " tabPageFreqAllow " + z2);
        return z && z2;
    }
}
