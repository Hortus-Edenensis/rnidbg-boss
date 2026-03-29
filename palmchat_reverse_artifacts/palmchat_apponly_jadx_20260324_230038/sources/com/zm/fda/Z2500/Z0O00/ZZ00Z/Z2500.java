package com.zm.fda.Z2500.Z0O00.ZZ00Z;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.kuaishou.weapon.p0.g;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class Z2500 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16691a;
    public int b;
    public String c;

    public Z2500(Context context) {
        if (a(context)) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                this.f16691a = telephonyManager.getPhoneType();
                this.c = telephonyManager.getNetworkOperatorName();
                this.b = telephonyManager.getNetworkType();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                return context.checkSelfPermission(g.c) == 0;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void a(JSONObject jSONObject) {
        try {
            String str = this.c;
            if (str != null) {
                jSONObject.put("networkName", str);
            }
            jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, this.f16691a);
            jSONObject.put("networkType", this.b);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
