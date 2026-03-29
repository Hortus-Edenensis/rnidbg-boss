package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ge extends gf {
    private static final String Z = "AppNotificationActivate";

    @Override // com.huawei.hms.ads.gf
    public void Code(Context context, com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, int i) {
        if (adContentData == null || appInfo == null) {
            fh.V(Z, "contentRecord is empty");
        } else {
            new com.huawei.openalliance.ad.download.app.h().Code(context, appInfo, adContentData, Integer.valueOf(i), false);
            gh.V(context, adContentData);
        }
    }
}
