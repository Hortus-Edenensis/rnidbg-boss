package com.wifi.csj.ad;

import com.bytedance.sdk.openadsdk.TTCustomController;
import com.wifi.ad.core.sensitive.NestInfoTaker;
import com.wifi.ad.core.utils.WifiLog;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/wifi/csj/ad/CsjSpecialController;", "Lcom/bytedance/sdk/openadsdk/TTCustomController;", "()V", "getDevOaid", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
public final class CsjSpecialController extends TTCustomController {
    @Override // com.bytedance.sdk.openadsdk.TTCustomController
    public String getDevOaid() {
        StringBuilder sb = new StringBuilder();
        sb.append("CsjSpecialController getDevOaid() = ");
        NestInfoTaker nestInfoTaker = NestInfoTaker.INSTANCE;
        sb.append(nestInfoTaker.getOaId());
        WifiLog.d(sb.toString());
        String oaId = nestInfoTaker.getOaId();
        return oaId != null ? oaId : "";
    }
}
