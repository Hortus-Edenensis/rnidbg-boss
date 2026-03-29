package com.huawei.openalliance.ad.utils;

import android.content.Context;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bk {
    private static final String Code = "HUAApi";
    private static final String V = "handleUriAction";

    public static <T> T Code(final Context context, final AdContentData adContentData, final int i, final Class<T> cls) {
        if (adContentData != null) {
            return (T) be.Code(new Callable<T>() { // from class: com.huawei.openalliance.ad.utils.bk.1
                @Override // java.util.concurrent.Callable
                public T call() {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("content_id", adContentData.a());
                        jSONObject.put("templateId", adContentData.aE());
                        jSONObject.put("slotid", adContentData.L());
                        jSONObject.put("apiVer", adContentData.aF());
                        jSONObject.put(com.huawei.openalliance.ad.constant.be.U, i);
                        jSONObject.put(com.huawei.openalliance.ad.constant.be.aa, bk.V(adContentData));
                        fh.V(bk.Code, "call:handleUriAction, uniqueId: %s", adContentData.aa());
                        jSONObject.put("unique_id", adContentData.aa());
                        return com.huawei.openalliance.ad.ipc.b.Code(context).Code(bk.V, jSONObject.toString(), cls).getData();
                    } catch (Throwable unused) {
                        fh.I(bk.Code, "handle harmony service enter action fail");
                        return null;
                    }
                }
            }, null);
        }
        fh.V(Code, "contentRecord is null");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject V(AdContentData adContentData) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.huawei.openalliance.ad.constant.be.ab, adContentData.D());
            jSONObject.put(com.huawei.openalliance.ad.constant.be.Q, adContentData.au());
            jSONObject.put(com.huawei.openalliance.ad.constant.be.P, adContentData.at());
        } catch (Throwable th) {
            fh.I(Code, "getParamContent ex:%s", th.getClass().getSimpleName());
        }
        return jSONObject;
    }
}
