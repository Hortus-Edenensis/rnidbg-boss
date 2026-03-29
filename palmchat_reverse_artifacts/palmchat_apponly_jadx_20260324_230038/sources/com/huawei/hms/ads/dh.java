package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.inner.SourceParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.utils.ac;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class dh extends ga<com.huawei.openalliance.ad.augreality.views.a> implements di<com.huawei.openalliance.ad.augreality.views.a> {
    private static final String V = "com.huawei.hms.ads.dh";
    private Context I;

    public dh(Context context, com.huawei.openalliance.ad.augreality.views.a aVar) {
        this.I = context;
        Code(aVar);
    }

    private void V(ImageInfo imageInfo, com.huawei.openalliance.ad.utils.aq aqVar) {
        String strA;
        String strL;
        if (imageInfo == null) {
            fh.I(V, "loadImage imageInfo is null");
            aqVar.Code();
            return;
        }
        SourceParam sourceParam = new SourceParam();
        sourceParam.I(imageInfo.Z());
        sourceParam.Code(52428800L);
        sourceParam.V(imageInfo.I());
        sourceParam.V(imageInfo.S());
        sourceParam.I(true);
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            strA = adContentData.a();
            strL = this.Code.L();
        } else {
            strA = null;
            strL = null;
        }
        ac.Code(this.I, sourceParam, strA, strL, aqVar);
    }

    @Override // com.huawei.hms.ads.di
    public void Code(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        this.Code = adContentData;
    }

    private void V(String str) {
        if (this.Code == null) {
            return;
        }
        MaterialClickInfo materialClickInfo = new MaterialClickInfo();
        materialClickInfo.B((Integer) 1);
        jk.Code(this.I, this.Code, (String) null, 0, 0, str, 1, com.huawei.openalliance.ad.utils.b.Code(I()), materialClickInfo);
    }

    @Override // com.huawei.hms.ads.di
    public void Code(ImageInfo imageInfo, com.huawei.openalliance.ad.utils.aq aqVar) {
        String str = V;
        fh.V(str, "checkArImageHashAndLoad " + imageInfo);
        if (imageInfo == null) {
            fh.I(str, "checkArImageHashAndLoad imageInfo is null");
        } else {
            V(imageInfo, aqVar);
        }
    }

    @Override // com.huawei.hms.ads.di
    public boolean Code() {
        kr krVarCode = ks.Code(this.I, this.Code, new HashMap(0));
        if (!krVarCode.Code()) {
            return true;
        }
        V(krVarCode.Z());
        return true;
    }

    @Override // com.huawei.hms.ads.di
    public boolean V() {
        return false;
    }
}
