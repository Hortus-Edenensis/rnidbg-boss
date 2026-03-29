package com.huawei.hms.ads;

import android.content.Context;
import android.content.Intent;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class gf implements gj {
    public static final String Code = "appInfo";
    public static final String I = "downloadSource";
    public static final String V = "contentRecord";
    private static final String Z = "AppNotificationBaseAction";

    @Override // com.huawei.hms.ads.gj
    public void Code(Context context, Intent intent) {
        StringBuilder sb;
        String str;
        try {
            com.huawei.openalliance.ad.inter.data.AppInfo appInfo = (com.huawei.openalliance.ad.inter.data.AppInfo) intent.getSerializableExtra("appInfo");
            AdContentData adContentData = (AdContentData) intent.getSerializableExtra("contentRecord");
            int intExtra = intent.getIntExtra(I, 1);
            if (appInfo != null && adContentData != null) {
                if (gk.Code(context).I(appInfo.Code())) {
                    Code(context, appInfo, adContentData, intExtra);
                    gk.Code(context).V(appInfo.Code());
                } else {
                    fh.V(Z, "packageName may be illegal:" + appInfo.Code());
                }
            }
        } catch (IllegalStateException e) {
            e = e;
            sb = new StringBuilder();
            str = "AppNotificationBaseAction.onReceive IllegalStateException:";
            sb.append(str);
            sb.append(e.getClass().getSimpleName());
            fh.I(Z, sb.toString());
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder();
            str = "AppNotificationBaseAction.onReceive Exception:";
            sb.append(str);
            sb.append(e.getClass().getSimpleName());
            fh.I(Z, sb.toString());
        }
    }

    public void Code(Context context, com.huawei.openalliance.ad.inter.data.AppInfo appInfo, AdContentData adContentData, int i) {
        fh.V(Z, "do nothing at base action!");
    }
}
