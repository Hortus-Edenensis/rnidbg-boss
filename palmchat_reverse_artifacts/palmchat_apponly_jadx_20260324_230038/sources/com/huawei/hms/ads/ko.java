package com.huawei.hms.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.ads.kw;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ko extends kr {
    private static final String Code = "OuterWebAction";

    public ko(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    private String B() {
        for (String str : eh.Code(this.I).n()) {
            if (com.huawei.openalliance.ad.utils.h.Code(this.I, str)) {
                return str;
            }
        }
        return "";
    }

    @Override // com.huawei.hms.ads.kr
    public boolean Code() {
        Context context;
        String str;
        AdContentData adContentData = this.Z;
        if (adContentData == null || !(jg.Code(adContentData.v()) || com.huawei.openalliance.ad.utils.ap.Z(this.I))) {
            return I();
        }
        fh.V(Code, "handle outer browser action");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        String strI = this.Z.i();
        if (!com.huawei.openalliance.ad.utils.bc.Code(strI)) {
            intent.setData(Uri.parse(strI));
            if (!(this.I instanceof Activity)) {
                intent.addFlags(268435456);
            }
            kw.a aVar = new kw.a();
            aVar.Code(this.Z).Code(intent);
            kw kwVarCode = aVar.Code();
            try {
                if (jg.V(this.Z.v())) {
                    fh.Code(Code, "handleUri, use default browser");
                    String strB = B();
                    if (TextUtils.isEmpty(strB)) {
                        fh.I(Code, "can not find default browser");
                    } else {
                        intent.setPackage(strB);
                    }
                }
                PackageManager packageManager = this.I.getPackageManager();
                if (packageManager == null) {
                    context = this.I;
                    str = com.huawei.openalliance.ad.constant.as.F;
                } else {
                    if (!packageManager.queryIntentActivities(intent, 65536).isEmpty()) {
                        Code(com.huawei.openalliance.ad.constant.v.B);
                        com.huawei.openalliance.ad.utils.h.Code(this.I, intent, kwVarCode);
                        return true;
                    }
                    context = this.I;
                    str = com.huawei.openalliance.ad.constant.as.Code;
                }
                com.huawei.openalliance.ad.utils.av.Code(context, kwVarCode, str);
            } catch (ActivityNotFoundException unused) {
                com.huawei.openalliance.ad.utils.av.Code(this.I, kwVarCode, com.huawei.openalliance.ad.constant.as.V);
                fh.Z(Code, "fail to open uri");
            } catch (Throwable th) {
                com.huawei.openalliance.ad.utils.av.Code(this.I, kwVarCode, "unknown exception : " + th.getClass().getSimpleName());
                fh.Z(Code, "handle uri exception: %s", th.getClass().getSimpleName());
            }
        }
        return I();
    }

    @Override // com.huawei.hms.ads.kr
    public void V() {
        Code(com.huawei.openalliance.ad.constant.v.B);
    }
}
