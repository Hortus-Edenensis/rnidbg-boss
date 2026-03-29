package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.ji;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class il extends ga<ls> implements iy<ls> {
    private Context I;
    private com.huawei.openalliance.ad.inter.data.n Z;

    public il(Context context, ls lsVar) {
        this.I = context;
        Code(lsVar);
    }

    @Override // com.huawei.hms.ads.iy
    public void Code() {
        jk.Code(this.I, this.Code, 0, 0, (List<String>) null);
    }

    @Override // com.huawei.hms.ads.iy
    public void V() {
        jk.Code(this.I, this.Code);
    }

    @Override // com.huawei.hms.ads.iy
    public void Code(long j, int i, int i2) {
        AdContentData adContentData = this.Code;
        if (adContentData != null) {
            adContentData.V(Integer.valueOf(i2));
        }
        jk.Code(this.I, this.Code, j, i);
    }

    @Override // com.huawei.hms.ads.iy
    public void Code(long j, int i, Integer num) {
        String strB = B();
        com.huawei.openalliance.ad.inter.data.n nVar = this.Z;
        if (nVar != null) {
            fh.Code("PlacementAdPresenter", "slotId: %s, contentId: %s, slot pos: %s", nVar.r(), this.Z.d(), strB);
        }
        ji.a aVar = new ji.a();
        if (num != null) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.z.Code()));
        }
        aVar.Code(Long.valueOf(j)).Code(Integer.valueOf(i)).V(num).B(strB).Code(C()).I(com.huawei.openalliance.ad.utils.b.Code(I()));
        jk.Code(this.I, this.Code, aVar.Code());
    }

    private void Code(kr krVar, MaterialClickInfo materialClickInfo) {
        jk.Code(this.I, this.Code, 0, 0, krVar.Z(), materialClickInfo, com.huawei.openalliance.ad.utils.b.Code(I()), com.huawei.openalliance.ad.utils.bg.V(I()));
    }

    @Override // com.huawei.hms.ads.iy
    public void Code(MaterialClickInfo materialClickInfo) {
        com.huawei.openalliance.ad.inter.data.n nVar = this.Z;
        if (nVar == null) {
            return;
        }
        nVar.Code(true);
        fh.Code("PlacementAdPresenter", "begin to deal click");
        HashMap map = new HashMap();
        map.put("appId", this.Z.z());
        map.put(kk.V, this.Z.Code());
        kr krVarCode = ks.Code(this.I, this.Code, map);
        if (krVarCode.Code()) {
            Code(krVarCode, materialClickInfo);
        }
    }

    @Override // com.huawei.hms.ads.iy
    public void Code(com.huawei.openalliance.ad.inter.data.n nVar) {
        this.Z = nVar;
        this.Code = nVar != null ? nVar.q() : null;
    }

    @Override // com.huawei.hms.ads.iy
    public void Code(String str, int i, int i2, com.huawei.openalliance.ad.inter.data.n nVar) {
        AdContentData adContentDataQ = nVar.q();
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(str);
        analysisEventReport.Code(i);
        analysisEventReport.V(i2);
        analysisEventReport.Code(adContentDataQ);
        if (adContentDataQ != null) {
            analysisEventReport.d(adContentDataQ.aE());
            analysisEventReport.e(adContentDataQ.L());
            analysisEventReport.c(adContentDataQ.a());
            analysisEventReport.I(adContentDataQ.aF());
        }
        com.huawei.openalliance.ad.ipc.g.V(this.I).Code("rptPlacePlayErr", com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
    }

    @Override // com.huawei.hms.ads.iy
    public void Code(boolean z) {
        jk.Code(this.I, this.Code, z);
    }
}
