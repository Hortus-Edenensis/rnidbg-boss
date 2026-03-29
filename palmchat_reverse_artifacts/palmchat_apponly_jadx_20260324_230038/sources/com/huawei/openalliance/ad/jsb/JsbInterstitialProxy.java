package com.huawei.openalliance.ad.jsb;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ae;
import com.huawei.hms.ads.ah;
import com.huawei.hms.ads.aj;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.en;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.i;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@AllApi
public class JsbInterstitialProxy extends ah {
    @AllApi
    public JsbInterstitialProxy() {
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    @AllApi
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) throws IllegalAccessException, InstantiationException {
        String strV = aj.V(str);
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(strV)) {
            fh.Z("JsbInterstitialProxy", "param is invalid, please check it!");
            ah.Code(remoteCallResultCallback, strV, -1, null, true);
            return;
        }
        ae aeVarCode = en.Code().Code(strV);
        if (aeVarCode != null) {
            if (aj.Code().Code(strV, Code(context))) {
                aeVarCode.Code((Activity) Code(context));
            }
            aeVarCode.Code(this.V);
        }
        i.Code(new aj.a(context, aeVarCode, strV, str, remoteCallResultCallback));
    }
}
