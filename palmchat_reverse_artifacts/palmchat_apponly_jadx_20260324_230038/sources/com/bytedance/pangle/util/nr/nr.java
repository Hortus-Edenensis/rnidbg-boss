package com.bytedance.pangle.util.nr;

import com.bytedance.pangle.b.nr;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.sdk.openadsdk.api.iz;
import com.qiniu.android.collect.ReportItem;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public static boolean u(String str, boolean z, boolean z2, String str2, int i, int i2) {
        int i3;
        int i4;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            new u(new com.bytedance.pangle.util.nr.u.u().u(str)).u(z, z2);
            if (i2 == 0) {
                return true;
            }
            if (i2 == 1) {
                i4 = nr.u.u;
            } else {
                if (i2 != 2) {
                    i3 = 0;
                    String str3 = "rmSo:" + z2 + " rmDex:" + z;
                    ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str3)));
                    u(i3, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, (Throwable) null, str3);
                    return true;
                }
                i4 = nr.u.nr;
            }
            i3 = i4;
            String str32 = "rmSo:" + z2 + " rmDex:" + z;
            ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str32)));
            u(i3, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, (Throwable) null, str32);
            return true;
        } catch (Throwable th) {
            try {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "rmEntries failed. zipFile:" + str + " rmDex:" + z + " rmSO:" + z2, th);
                if (i2 != 0) {
                    int i5 = i2 == 1 ? nr.u.fx : i2 == 2 ? nr.u.b : 0;
                    String str4 = "rmSo:" + z2 + " rmDex:" + z;
                    ZeusLogger.d(ZeusLogger.TAG, "[shootsTag]".concat(String.valueOf(str4)));
                    u(i5, str2, i, System.currentTimeMillis() - jCurrentTimeMillis, th, str4);
                }
                return false;
            } finally {
            }
        }
    }

    private static void u(int i, String str, int i2, long j, Throwable th, String str2) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.putOpt(ReportItem.RequestKeyStatusCode, com.bytedance.pangle.log.nr.u(Integer.valueOf(i)));
            jSONObject.putOpt("plugin_package_name", com.bytedance.pangle.log.nr.u(str));
            jSONObject.putOpt("version_code", com.bytedance.pangle.log.nr.u(Integer.valueOf(i2)));
            jSONObject3.putOpt("duration", Integer.valueOf(com.bytedance.pangle.log.nr.nr(Long.valueOf(j))));
            jSONObject2.putOpt("message", str2 + com.bytedance.pangle.log.nr.u(th));
        } catch (JSONException e) {
            iz.u(e);
        }
        com.bytedance.pangle.b.nr.u().u(com.bytedance.pangle.b.nr.jk, jSONObject, jSONObject3, jSONObject2);
    }
}
