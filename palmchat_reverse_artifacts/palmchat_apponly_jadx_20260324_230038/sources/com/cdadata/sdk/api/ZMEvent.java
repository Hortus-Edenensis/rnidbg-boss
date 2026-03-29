package com.cdadata.sdk.api;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.download.api.constant.BaseConstants;
import defpackage.c57;
import defpackage.e67;
import defpackage.h57;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class ZMEvent {
    private static final String TAG = "ZMEvent";
    private static ZMEvent instances;

    public static ZMEvent getInstance() {
        if (instances == null) {
            synchronized (ZMEvent.class) {
                if (instances == null) {
                    instances = new ZMEvent();
                }
            }
        }
        return instances;
    }

    public void sendEvent(final String str, final JSONObject jSONObject) {
        if (jSONObject == null) {
            new Throwable("自定义事件json不能为空");
        } else {
            h57.a().b(new Runnable() { // from class: com.cdadata.sdk.api.ZMEvent.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("eventName", str);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        jSONObject2.put("eventTime", jCurrentTimeMillis);
                        jSONObject2.put("eventDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(jCurrentTimeMillis)));
                        jSONObject2.put(BaseConstants.EVENT_LABEL_EXTRA, jSONObject.toString());
                        jSONObject2.put("isFlush", 0);
                        jSONObject2.put("eventType", MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
                        JSONObject jSONObject3 = new JSONObject();
                        e67.s(ZMDataSDKManager.getInstance().getContext(), jSONObject3);
                        e67.h(jSONObject3, jSONObject2);
                        c57.l().b(jSONObject2, true);
                        ZMDataSDKManager.getInstance().getZmUploadEvent().a();
                    } catch (JSONException | Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void sendEventDelay(final String str, final JSONObject jSONObject) {
        if (jSONObject == null) {
            new Throwable("自定义事件json不能为空");
        } else {
            h57.a().b(new Runnable() { // from class: com.cdadata.sdk.api.ZMEvent.2
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("eventName", str);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        jSONObject2.put("eventTime", jCurrentTimeMillis);
                        jSONObject2.put("eventDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(jCurrentTimeMillis)));
                        jSONObject2.put(BaseConstants.EVENT_LABEL_EXTRA, jSONObject.toString());
                        jSONObject2.put("isFlush", 1);
                        jSONObject2.put("eventType", MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
                        JSONObject jSONObject3 = new JSONObject();
                        e67.s(ZMDataSDKManager.getInstance().getContext(), jSONObject3);
                        e67.h(jSONObject3, jSONObject2);
                        c57.l().b(jSONObject2, false);
                        ZMDataSDKManager.getInstance().getZmUploadEvent().c();
                    } catch (JSONException | Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
