package com.huawei.hms.ads;

import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.VideoInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class jl {
    public static com.huawei.openalliance.ad.inter.data.k Code(AdContentData adContentData) {
        com.huawei.openalliance.ad.inter.data.k kVar = new com.huawei.openalliance.ad.inter.data.k(adContentData);
        kVar.Code(adContentData);
        kVar.S(1);
        kVar.Code(adContentData.y());
        kVar.Z(adContentData.q());
        kVar.V(adContentData.o());
        kVar.F(adContentData.l());
        kVar.n(adContentData.a());
        kVar.I(adContentData.W());
        kVar.a(adContentData.i());
        kVar.i(adContentData.L());
        kVar.m(adContentData.D());
        kVar.j(adContentData.w());
        kVar.Z(adContentData.j());
        kVar.Code(adContentData.S());
        kVar.C(adContentData.X());
        kVar.e(adContentData.Y());
        kVar.f(adContentData.v());
        kVar.Code(new VideoInfo(adContentData.t()));
        MetaData metaDataS = adContentData.S();
        if (metaDataS != null) {
            kVar.D(com.huawei.openalliance.ad.utils.bc.V(metaDataS.Z()));
            kVar.L(com.huawei.openalliance.ad.utils.bc.V(metaDataS.B()));
            kVar.V(metaDataS.F());
            kVar.B(metaDataS.D());
            kVar.p(com.huawei.openalliance.ad.utils.bc.V(adContentData.S().L()));
            kVar.b(metaDataS.a());
            kVar.c(metaDataS.b());
            kVar.o(com.huawei.openalliance.ad.utils.bc.V(metaDataS.Code()));
            ApkInfo apkInfoE = metaDataS.e();
            if (apkInfoE != null) {
                com.huawei.openalliance.ad.inter.data.AppInfo appInfo = new com.huawei.openalliance.ad.inter.data.AppInfo(apkInfoE);
                appInfo.Code(kVar.o());
                appInfo.V(kVar.A());
                appInfo.a(metaDataS.I());
                kVar.Code(appInfo);
            }
        }
        kVar.Code(adContentData.c());
        kVar.Z(adContentData.s());
        kVar.I(adContentData.r());
        kVar.C(adContentData.B());
        kVar.S(adContentData.p());
        kVar.V(adContentData.ag());
        kVar.I(adContentData.ah());
        kVar.B(adContentData.h());
        kVar.q(adContentData.av());
        return kVar;
    }
}
