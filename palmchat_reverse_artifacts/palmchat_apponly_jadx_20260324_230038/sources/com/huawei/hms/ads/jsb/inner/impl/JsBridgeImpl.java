package com.huawei.hms.ads.jsb.inner.impl;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ae;
import com.huawei.hms.ads.ah;
import com.huawei.hms.ads.aj;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.jsb.JsbConfig;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.bl;
import com.huawei.openalliance.ad.utils.i;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@AllApi
public class JsBridgeImpl {
    private static final String Code = "JsBridgeImpl";

    /* JADX INFO: compiled from: SearchBox */
    public static class a<T> implements Runnable {
        private ae B;
        private final Context Code;
        private final String I;
        private final String V;
        private final RemoteCallResultCallback<String> Z;

        public a(Context context, ae aeVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
            this.Code = context;
            this.V = str;
            this.I = str2;
            this.Z = remoteCallResultCallback;
            this.B = aeVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            JsBridgeImpl.V(this.Code, this.B, this.V, this.I, this.Z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, ae aeVar, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (aeVar == null) {
            String str3 = "api for " + str + " is not found";
            fh.V(Code, "call " + str3);
            ah.Code(remoteCallResultCallback, str, 1011, str3, true);
            return;
        }
        fh.V(Code, "call method: " + str);
        if (fh.Code()) {
            fh.Code(Code, "param: %s", bl.Code(str2));
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            String strOptString = jSONObject.optString("content");
            aeVar.Code(jSONObject.optString("url"));
            aeVar.V(jSONObject.optString("cid"));
            aeVar.execute(context, strOptString, remoteCallResultCallback);
        } catch (Throwable th) {
            fh.I(Code, "call method %s, ex: %s", str, th.getClass().getSimpleName());
            ah.Code(remoteCallResultCallback, str, 1011, th.getClass().getSimpleName() + ":" + th.getMessage(), true);
            fh.Code(3, th);
        }
    }

    @AllApi
    public static void initConfig(Context context, JsbConfig jsbConfig) {
        com.huawei.hms.ads.jsb.a.Code(context).Code(jsbConfig);
    }

    @AllApi
    public static String invoke(Context context, String str, String str2) {
        Object objCode;
        JSONObject jSONObject = new JSONObject();
        int i = 1011;
        if (context != null) {
            try {
            } catch (Throwable th) {
                fh.I(Code, "call method : " + th.getClass().getSimpleName());
                objCode = "call " + str + " " + th.getClass().getSimpleName() + ":" + th.getMessage();
            }
            if (!TextUtils.isEmpty(str2)) {
                ae aeVarCode = aj.Code().Code(str);
                if (aeVarCode != null) {
                    fh.V(Code, "call api: " + str);
                    objCode = aeVarCode.Code(context.getApplicationContext(), new JSONObject(str2).optString("content"));
                    i = 1000;
                } else {
                    objCode = null;
                }
                try {
                    jSONObject.put("code", i);
                    jSONObject.put("data", objCode);
                } catch (Throwable th2) {
                    fh.I(Code, "call method : " + th2.getClass().getSimpleName());
                }
                return jSONObject.toString();
            }
        }
        fh.Z(Code, "param is invalid, please check it!");
        jSONObject.put("msg", "invalid params");
        jSONObject.put("code", 1011);
        return jSONObject.toString();
    }

    @AllApi
    public static void invoke(Context context, String str, String str2, RemoteCallResultCallback<String> remoteCallResultCallback, Class<String> cls) throws IllegalAccessException, InstantiationException {
        if (context == null || TextUtils.isEmpty(str2)) {
            fh.Z(Code, "param is invalid, please check it!");
            ah.Code(remoteCallResultCallback, str, 1001, null, true);
            return;
        }
        ae aeVarCode = aj.Code().Code(str);
        i.a aVarCode = i.a.IO;
        if (aeVarCode != null) {
            aVarCode = aeVarCode.Code();
            if (aj.Code().Code(str, context)) {
                aeVarCode.Code((Activity) context);
            }
        }
        i.Code(new a(context.getApplicationContext(), aeVarCode, str, str2, remoteCallResultCallback), aVarCode, false);
    }
}
