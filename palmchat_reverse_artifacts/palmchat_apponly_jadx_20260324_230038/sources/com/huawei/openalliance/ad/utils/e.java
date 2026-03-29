package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.constant.ce;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e {
    private static final String Code = "AdSourceUtil";

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements RemoteCallResultCallback<String> {
        private final WeakReference<Context> Code;

        public a(Context context) {
            this.Code = new WeakReference<>(context);
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, CallResult<String> callResult) {
            String data = callResult.getData();
            Context context = this.Code.get();
            if (context == null || TextUtils.isEmpty(data) || !data.startsWith(ce.CONTENT.toString())) {
                return;
            }
            SourceParam sourceParam = new SourceParam();
            sourceParam.V(false);
            sourceParam.I(true);
            sourceParam.I(data);
            ac.Code(context, sourceParam, (aq) null);
        }
    }

    public static void Code(Context context, AdContentData adContentData) {
        AdSource adSourceCode;
        if (adContentData != null) {
            try {
                if (adContentData.S() == null || adContentData.S().l() == null || (adSourceCode = AdSource.Code(adContentData.S().l())) == null || adSourceCode.V() == null) {
                    return;
                }
                fh.V(Code, "preloadDspLogo");
                String strV = adSourceCode.V();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(com.huawei.openalliance.ad.constant.be.E, strV);
                com.huawei.openalliance.ad.ipc.g.V(context).Code(com.huawei.openalliance.ad.constant.s.i, jSONObject.toString(), new a(context), String.class);
            } catch (Throwable unused) {
                fh.I(Code, "preloadDspLogo error");
            }
        }
    }
}
