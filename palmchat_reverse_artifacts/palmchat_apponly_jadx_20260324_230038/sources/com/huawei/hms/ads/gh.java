package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class gh {
    private static final String B = "AppNotificationEvtProcessor";
    private static final String C = "AppNotificationExceptionCmd";
    public static final String Code = "70";
    public static final String I = "1";
    public static final String V = "0";
    public static final String Z = "2";

    public static void Code(Context context, AdContentData adContentData) {
        Code(context, adContentData, Code, "2", null, null);
    }

    public static void I(Context context, AdContentData adContentData) {
        Code(context, adContentData, Code, "0", null, null);
    }

    public static void V(Context context, AdContentData adContentData) {
        Code(context, adContentData, Code, "1", null, null);
    }

    private static <T> void Code(Context context, AdContentData adContentData, String str, String str2, RemoteCallResultCallback<T> remoteCallResultCallback, Class<T> cls) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", adContentData.a());
            jSONObject.put("templateId", adContentData.aE());
            jSONObject.put("slotid", adContentData.L());
            jSONObject.put("apiVer", adContentData.aF());
            jSONObject.put(com.huawei.openalliance.ad.constant.be.f6920a, str);
            jSONObject.put("action", str2);
            fh.V(B, "analysisEventReport, adContentData.uniqueId: %s", adContentData.aa());
            jSONObject.put("unique_id", adContentData.aa());
            com.huawei.openalliance.ad.ipc.g.V(context).Code(C, jSONObject.toString(), remoteCallResultCallback, cls);
        } catch (JSONException unused) {
            fh.I(B, "reportAnalysisEvent JSONException");
            if (remoteCallResultCallback != null) {
                CallResult<T> callResult = new CallResult<>();
                callResult.setCode(-1);
                callResult.setMsg("reportAnalysisEvent JSONException");
                remoteCallResultCallback.onRemoteCallResult(C, callResult);
            }
        }
    }
}
