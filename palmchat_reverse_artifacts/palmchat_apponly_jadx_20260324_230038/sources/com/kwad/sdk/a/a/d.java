package com.kwad.sdk.a.a;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d {
    public static String EM() {
        String strHN = com.kwad.sdk.core.config.e.HN();
        return TextUtils.isEmpty(strHN) ? "安装" : strHN;
    }

    public static String EN() {
        String strHO = com.kwad.sdk.core.config.e.HO();
        return TextUtils.isEmpty(strHO) ? "取消" : strHO;
    }

    public static String G(AdInfo adInfo) {
        return com.kwad.sdk.core.config.e.HM().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", com.kwad.components.core.s.e.a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }
}
