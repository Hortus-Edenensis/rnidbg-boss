package defpackage;

import android.app.Activity;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ob4 {
    public static void a(Activity activity, boolean z) {
        if (z) {
            return;
        }
        if (activity instanceof ChatterActivity) {
            ChatterActivity chatterActivity = (ChatterActivity) activity;
            if (chatterActivity.R3()) {
                String strN3 = chatterActivity.n3();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("fromuid", strN3);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LogUtil.uploadInfoImmediate(!z ? "return-msg" : "service1-out", null, null, jSONObject.toString());
                return;
            }
            return;
        }
        if (activity instanceof CordovaWebActivity) {
            CordovaWebActivity cordovaWebActivity = (CordovaWebActivity) activity;
            if (cordovaWebActivity.C2()) {
                String strP2 = cordovaWebActivity.p2();
                String strO2 = cordovaWebActivity.o2();
                String strQ2 = cordovaWebActivity.q2();
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("fromuid", strP2);
                    jSONObject2.put("mid", strO2);
                    jSONObject2.put("url", strQ2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                LogUtil.uploadInfoImmediate(!z ? "return-service1" : "service2-out", null, null, jSONObject2.toString());
            }
        }
    }

    public static void b(Activity activity, boolean z) {
        if (z) {
            if (activity instanceof ChatterActivity) {
                ChatterActivity chatterActivity = (ChatterActivity) activity;
                if (chatterActivity.R3()) {
                    String strN3 = chatterActivity.n3();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("fromuid", strN3);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    LogUtil.uploadInfoImmediate(!z ? "return-msg" : "service1-out", null, null, jSONObject.toString());
                    return;
                }
                return;
            }
            if (activity instanceof CordovaWebActivity) {
                CordovaWebActivity cordovaWebActivity = (CordovaWebActivity) activity;
                if (cordovaWebActivity.C2()) {
                    String strP2 = cordovaWebActivity.p2();
                    String strO2 = cordovaWebActivity.o2();
                    String strQ2 = cordovaWebActivity.q2();
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("fromuid", strP2);
                        jSONObject2.put("mid", strO2);
                        jSONObject2.put("url", strQ2);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    LogUtil.uploadInfoImmediate(!z ? "return-service1" : "service2-out", null, null, jSONObject2.toString());
                }
            }
        }
    }
}
