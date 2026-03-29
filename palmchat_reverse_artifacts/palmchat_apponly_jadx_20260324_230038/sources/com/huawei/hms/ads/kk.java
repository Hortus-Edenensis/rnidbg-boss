package com.huawei.hms.ads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.huawei.hms.ads.kw;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class kk extends kr {
    public static final String Code = "appId";
    private static final String D = "com.huawei.appmarket";
    private static final String F = "com.huawei.appmarket.appmarket.intent.action.AppDetail.withid";
    private static final String S = "HwMarketAction";
    public static final String V = "thirdId";
    private String L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6596a;

    public kk(Context context, AdContentData adContentData, Map<String, String> map) {
        super(context, adContentData);
        this.L = map.get("appId");
        this.f6596a = map.get(V);
    }

    private void B() {
        jk.Code(this.I, this.Z, com.huawei.openalliance.ad.constant.aj.D, (Integer) 3, Integer.valueOf(com.huawei.openalliance.ad.utils.h.Code(this.I, "com.huawei.appmarket") ? 2 : 1));
    }

    @Override // com.huawei.hms.ads.kr
    public boolean Code() {
        Context context;
        String str;
        fh.V(S, "handle hw app market action");
        Intent intent = new Intent(F);
        intent.setPackage("com.huawei.appmarket");
        intent.putExtra("appId", this.L);
        intent.putExtra(V, this.f6596a);
        intent.addFlags(268435456);
        kw.a aVar = new kw.a();
        aVar.Code(this.Z).Code(intent);
        kw kwVarCode = aVar.Code();
        try {
            PackageManager packageManager = this.I.getPackageManager();
            if (packageManager == null) {
                context = this.I;
                str = com.huawei.openalliance.ad.constant.as.F;
            } else {
                if (!packageManager.queryIntentActivities(intent, 65536).isEmpty()) {
                    com.huawei.openalliance.ad.utils.h.Code(this.I, intent, kwVarCode);
                    Code(com.huawei.openalliance.ad.constant.v.Code);
                    jk.Code(this.I, this.Z, "intentSuccess", (Integer) 3, (Integer) null);
                    return true;
                }
                context = this.I;
                str = com.huawei.openalliance.ad.constant.as.Code;
            }
            com.huawei.openalliance.ad.utils.av.Code(context, kwVarCode, str);
        } catch (ActivityNotFoundException unused) {
            com.huawei.openalliance.ad.utils.av.Code(this.I, kwVarCode, com.huawei.openalliance.ad.constant.as.V);
            fh.Z(S, "fail to open market detail page");
        }
        B();
        return I();
    }

    @Override // com.huawei.hms.ads.kr
    public void V() {
        Code(com.huawei.openalliance.ad.constant.v.Code);
    }
}
