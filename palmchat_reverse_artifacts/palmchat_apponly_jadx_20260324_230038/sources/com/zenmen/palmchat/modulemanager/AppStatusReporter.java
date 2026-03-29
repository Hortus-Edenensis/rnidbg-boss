package com.zenmen.palmchat.modulemanager;

import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import com.zenmen.palmchat.location.LocationEx;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.ft5;
import defpackage.nl0;
import defpackage.v4;
import defpackage.yw4;
import defpackage.yy2;
import defpackage.zw4;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class AppStatusReporter {
    public static final String TAG = "AppStatusReporter";
    private static long mLastRequestTime;

    public static void onAppOpen() {
        if (TextUtils.isEmpty(v4.e(AppContext.getContext()))) {
            return;
        }
        if (Math.abs(System.currentTimeMillis() - mLastRequestTime) < ft5.c("heart_beat_freq")) {
            LogUtil.i("RequestFreq", "心跳接口被限频了");
            return;
        }
        LogUtil.i("RequestFreq", "心跳接口未被限频");
        mLastRequestTime = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            ContactInfoItem contactInfoItemF = v4.f();
            if (contactInfoItemF != null) {
                jSONObject.put("gender", contactInfoItemF.getGender());
                jSONObject.put("age", contactInfoItemF.getAge());
            }
            LocationEx locationExI = d.g().i(86400000L);
            if (locationExI != null) {
                jSONObject.put("longitude", locationExI.getLongitude());
                jSONObject.put("latitude", locationExI.getLatitude());
                jSONObject.put("cityCode", locationExI.getCityCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        zw4.f(nl0.z + "/heartbeat.ext.v1", 1, jSONObject, new yw4() { // from class: com.zenmen.palmchat.modulemanager.AppStatusReporter.1
            @Override // defpackage.yw4
            public void onFail(Exception exc) {
                LogUtil.e(AppStatusReporter.TAG, "onFail", exc);
            }

            @Override // defpackage.yw4
            public void onSuccess(JSONObject jSONObject2, yy2 yy2Var) {
                LogUtil.i(AppStatusReporter.TAG, "onSuccess" + jSONObject2);
            }
        });
    }
}
