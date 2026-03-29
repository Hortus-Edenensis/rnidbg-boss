package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.kw;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class kd extends kr {
    private static final String Code = "AppEnterAction";

    public kd(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    @Override // com.huawei.hms.ads.kr
    public boolean Code() {
        boolean zCode;
        ApkInfo apkInfoE;
        fh.V(Code, "handle app enter action");
        MetaData metaDataS = this.Z.S();
        if (metaDataS == null || (apkInfoE = metaDataS.e()) == null) {
            zCode = false;
        } else {
            String strCode = apkInfoE.Code();
            kw.a aVar = new kw.a();
            aVar.Code(apkInfoE).Code(this.Z);
            zCode = com.huawei.openalliance.ad.utils.h.Code(this.I, strCode, aVar.Code());
        }
        if (!zCode) {
            return I();
        }
        Code("app");
        jk.Code(this.I, this.Z, (Integer) 1);
        return true;
    }

    @Override // com.huawei.hms.ads.kr
    public void V() {
        Code("app");
    }
}
