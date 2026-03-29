package com.heytap.msp.opos.sv.b.a;

import android.content.Context;
import com.heytap.msp.opos.sv.interapi.bean.commonad.deeplink.DeepLinkRequest;
import com.heytap.msp.opos.sv.interapi.bean.commonad.deeplink.DeepLinkResult;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface b {
    DeepLinkResult executeDeepLink(Context context, DeepLinkRequest deepLinkRequest);

    int getSDKVerCode();

    String getSDKVerName();
}
