package com.huawei.openalliance.ad.jsb;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ah;
import com.huawei.hms.ads.aj;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.eo;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.i;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@AllApi
public class JsbNativeProxy extends ah {
    @AllApi
    public JsbNativeProxy() {
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    @AllApi
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        String strV = aj.V(str);
        if (context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(strV)) {
            i.Code(new aj.a(context, eo.Code().Code(strV), strV, str, remoteCallResultCallback));
        } else {
            fh.Z("JsbNativeProxy", "param is invalid, please check it!");
            ah.Code(remoteCallResultCallback, strV, -1, null, true);
        }
    }
}
