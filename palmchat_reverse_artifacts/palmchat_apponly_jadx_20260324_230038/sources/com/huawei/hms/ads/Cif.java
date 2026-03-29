package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.ji;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.ImageInfo;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.inter.data.VideoInfo;
import com.huawei.openalliance.ad.views.PPSNativeView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.huawei.hms.ads.if, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class Cif extends ga<lr> implements is<lr> {
    private static final String V = "if";
    private PPSNativeView.e B;
    private kh C;
    private Context I;
    private com.huawei.openalliance.ad.inter.data.l Z;

    public Cif(Context context, lr lrVar) {
        this.I = context;
        Code(lrVar);
    }

    @Override // com.huawei.hms.ads.is
    public void Code() {
        jk.Code(this.I, this.Code);
    }

    @Override // com.huawei.hms.ads.is
    public void I(String str) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.Z;
        if (lVar == null) {
            return;
        }
        lVar.C(str);
    }

    @Override // com.huawei.hms.ads.is
    public void V() {
        jk.V(this.I, this.Code);
    }

    @Override // com.huawei.hms.ads.is
    public void Code(long j, int i) {
        jk.Code(this.I, this.Code, j, i);
    }

    @Override // com.huawei.hms.ads.is
    public void V(String str) {
        AdContentData adContentData = this.Code;
        if (adContentData == null) {
            return;
        }
        adContentData.c(str);
    }

    @Override // com.huawei.hms.ads.is
    public void Code(kh khVar) {
        this.C = khVar;
    }

    @Override // com.huawei.hms.ads.is
    public void V(List<String> list) {
        jk.Code(this.I, this.Code, 0, 0, list);
    }

    @Override // com.huawei.hms.ads.is
    public void Code(VideoInfo videoInfo) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.Z;
        if (lVar == null) {
            return;
        }
        lVar.Code(videoInfo);
    }

    @Override // com.huawei.hms.ads.is
    public void Code(com.huawei.openalliance.ad.inter.data.l lVar) {
        this.Z = lVar;
        this.Code = lVar != null ? lVar.q() : null;
    }

    @Override // com.huawei.hms.ads.is
    public void Code(PPSNativeView.e eVar) {
        this.B = eVar;
    }

    @Override // com.huawei.hms.ads.is
    public void Code(Long l, Integer num, Integer num2, boolean z, String str) {
        String strB = B();
        com.huawei.openalliance.ad.inter.data.l lVar = this.Z;
        if (lVar != null) {
            fh.Code(V, "slotId: %s, contentId: %s, slot pos: %s", lVar.r(), this.Z.d(), strB);
        }
        ji.a aVar = new ji.a();
        if (z) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.z.Code()));
        }
        aVar.Code(l).Code(num).V(num2).B(strB).Code(C()).V(str).I(com.huawei.openalliance.ad.utils.b.Code(I()));
        jk.Code(this.I, this.Code, aVar.Code());
    }

    private void Code(String str, MaterialClickInfo materialClickInfo, Integer num, ji jiVar) {
        jk.Code(this.I, this.Code, 0, 0, str, num, materialClickInfo, com.huawei.openalliance.ad.utils.b.Code(I()), com.huawei.openalliance.ad.utils.bg.V(I()), jiVar);
    }

    private void Code(HashMap<String, String> map) {
        MetaData metaDataS;
        if (map == null || (metaDataS = this.Code.S()) == null) {
            return;
        }
        ApkInfo apkInfoE = metaDataS.e();
        if (apkInfoE != null) {
            String strS = com.huawei.openalliance.ad.utils.bc.S(map.get(com.huawei.openalliance.ad.constant.be.aM));
            if (!TextUtils.isEmpty(strS)) {
                apkInfoE.i(strS);
            }
            String strS2 = com.huawei.openalliance.ad.utils.bc.S(map.get(com.huawei.openalliance.ad.constant.be.aN));
            if (!TextUtils.isEmpty(strS2)) {
                apkInfoE.j(strS2);
            }
        }
        this.Code.V(com.huawei.openalliance.ad.utils.ad.V(metaDataS));
    }

    @Override // com.huawei.hms.ads.is
    public void Code(List<ImageInfo> list) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.Z;
        if (lVar == null) {
            return;
        }
        lVar.V(list);
    }

    @Override // com.huawei.hms.ads.is
    public boolean Code(MaterialClickInfo materialClickInfo, Integer num, String str, String str2, HashMap<String, String> map) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.Z;
        if (lVar == null) {
            return false;
        }
        lVar.Code(true);
        fh.Code(V, "begin to deal click with destination");
        Code(map);
        ji jiVar = new ji();
        jiVar.B(str);
        Code(str2, materialClickInfo, num, jiVar);
        return true;
    }

    @Override // com.huawei.hms.ads.is
    public boolean Code(MaterialClickInfo materialClickInfo, Integer num, String str, boolean z) {
        return Code(materialClickInfo, num, str, z, (HashMap<String, String>) null);
    }

    @Override // com.huawei.hms.ads.is
    public boolean Code(MaterialClickInfo materialClickInfo, Integer num, String str, boolean z, HashMap<String, String> map) {
        com.huawei.openalliance.ad.inter.data.l lVar = this.Z;
        if (lVar == null) {
            return false;
        }
        lVar.Code(true);
        fh.Code(V, "deal click");
        Map<String, String> mapAu = this.Z.au();
        Code(map);
        ji jiVar = new ji();
        jiVar.B(str);
        kr krVarCode = ks.Code(this.I, this.Code, mapAu);
        krVarCode.Code(this.C);
        if (!z) {
            Code(com.huawei.openalliance.ad.constant.v.f, materialClickInfo, num, jiVar);
            return true;
        }
        boolean zCode = krVarCode.Code();
        if (zCode) {
            Code(krVarCode.Z(), materialClickInfo, num, jiVar);
            PPSNativeView.e eVar = this.B;
            if (eVar != null) {
                eVar.V();
                this.B.I();
            }
        }
        krVarCode.V(zCode);
        return zCode;
    }
}
