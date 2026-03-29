package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class gg extends gf {
    private static final String Z = "AppNotificationDelete";

    @Override // com.huawei.hms.ads.gf
    public void Code(Context context, com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, int i) {
        if (adContentData == null) {
            fh.V(Z, "contentRecord is empty");
        } else {
            gh.Code(context, adContentData);
        }
    }
}
