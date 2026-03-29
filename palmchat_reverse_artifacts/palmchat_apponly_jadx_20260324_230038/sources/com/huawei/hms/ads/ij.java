package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.hms.ads.ji;
import com.huawei.openalliance.ad.inter.d;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ij extends ga<lq> implements iv {
    private com.huawei.openalliance.ad.inter.data.k B;
    private com.huawei.openalliance.ad.inter.listeners.a C;
    private Context Z;
    private boolean S = false;
    private boolean F = false;
    private boolean D = false;

    public ij(Context context, lq lqVar) {
        this.Z = context.getApplicationContext();
        Code(lqVar);
    }

    private void Z(boolean z) {
        this.S = z;
    }

    private boolean b() {
        return this.S;
    }

    @Override // com.huawei.hms.ads.iv
    public void Code(long j, int i) {
        jk.Code(this.Z, this.Code, j, i);
    }

    @Override // com.huawei.hms.ads.iv
    public void D() {
        jk.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.aj.B, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.iv
    public void L() {
        jk.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.aj.S, (Long) null, (Long) null, (Integer) null, (Integer) null);
    }

    @Override // com.huawei.hms.ads.iv
    public void S() {
        jk.Code(this.Z, this.Code);
    }

    @Override // com.huawei.hms.ads.ga, com.huawei.hms.ads.gb
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public lq I() {
        return (lq) super.I();
    }

    @Override // com.huawei.hms.ads.iv
    public void Code(long j, long j2, long j3, long j4) {
        jk.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.aj.Z, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf((int) j3), Integer.valueOf((int) j4));
    }

    @Override // com.huawei.hms.ads.iv
    public void V(long j, long j2, long j3, long j4) {
        jk.Code(this.Z, this.Code, com.huawei.openalliance.ad.constant.aj.C, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf((int) j3), Integer.valueOf((int) j4));
    }

    private void Code(kr krVar, int i, MaterialClickInfo materialClickInfo) {
        jk.Code(this.Z, this.Code, 0, 0, krVar.Z(), i, materialClickInfo, com.huawei.openalliance.ad.utils.b.Code(I()), com.huawei.openalliance.ad.utils.bg.V(I()));
    }

    @Override // com.huawei.hms.ads.iv
    public void V(boolean z) {
        jk.Code(this.Z, this.Code, z);
    }

    @Override // com.huawei.hms.ads.iv
    public void Code(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.C = aVar;
    }

    @Override // com.huawei.hms.ads.iv
    public void Code(Long l, Integer num, Integer num2, boolean z) {
        String splashViewSlotPosition;
        com.huawei.openalliance.ad.inter.data.k kVar = this.B;
        boolean zCode = com.huawei.openalliance.ad.utils.c.Code(kVar != null ? kVar.h_() : null, num2);
        if (b() && (!zCode || Code())) {
            fh.I("PPSLinkedVideoViewPresenter", "show event already reported before, ignore this");
            return;
        }
        ji.a aVar = new ji.a();
        if (z) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.z.Code()));
        }
        lq lqVarI = I();
        if (lqVarI != null) {
            splashViewSlotPosition = lqVarI.getSplashViewSlotPosition();
            com.huawei.openalliance.ad.inter.data.k kVar2 = this.B;
            if (kVar2 != null) {
                fh.Code("PPSLinkedVideoViewPresenter", "slotId: %s, contentId: %s, slot pos: %s", kVar2.r(), this.B.d(), splashViewSlotPosition);
            }
        } else {
            splashViewSlotPosition = "";
        }
        if (!com.huawei.openalliance.ad.utils.bc.Code(splashViewSlotPosition)) {
            aVar.B(splashViewSlotPosition);
        }
        aVar.Code(l).Code(num).V(num2).Code(C()).I(com.huawei.openalliance.ad.utils.b.Code(I()));
        jk.Code(this.Z, this.Code, aVar.Code());
        if (zCode) {
            Code(true);
        }
        if (b()) {
            return;
        }
        Z(true);
        com.huawei.openalliance.ad.inter.listeners.a aVar2 = this.C;
        if (aVar2 != null) {
            aVar2.Code();
        }
    }

    @Override // com.huawei.hms.ads.ga, com.huawei.hms.ads.iv
    public void Code(String str) {
        super.Code(str);
        Z(false);
        Code(false);
    }

    private void Code(Map<String, String> map) {
        com.huawei.openalliance.ad.inter.data.k kVar;
        if (map == null || map.isEmpty() || (kVar = this.B) == null || kVar.C() == null) {
            return;
        }
        int iL = this.B.C().L();
        if (Math.abs(this.B.C().I() - iL) < 1000) {
            iL = 0;
        }
        fh.V("PPSLinkedVideoViewPresenter", "buildLinkedAdConfig, duration: %s, set progress from LinkedSplash view:%s ", Integer.valueOf(this.B.C().I()), Integer.valueOf(iL));
        map.put(com.huawei.openalliance.ad.constant.be.s, this.B.C().h() ? ex.Code : ex.V);
        map.put(com.huawei.openalliance.ad.constant.be.r, this.B.C().a());
        map.put(com.huawei.openalliance.ad.constant.be.q, String.valueOf(iL));
        map.put(com.huawei.openalliance.ad.constant.be.t, this.B.L());
        map.put(com.huawei.openalliance.ad.constant.be.m, this.B.u());
        map.put(com.huawei.openalliance.ad.constant.be.p, String.valueOf(10));
    }

    public void Code(boolean z) {
        this.F = z;
    }

    public boolean Code() {
        return this.F;
    }

    @Override // com.huawei.hms.ads.iv
    public boolean Code(int i, MaterialClickInfo materialClickInfo) {
        com.huawei.openalliance.ad.inter.data.k kVar = this.B;
        if (kVar == null) {
            return false;
        }
        kVar.V(true);
        fh.V("PPSLinkedVideoViewPresenter", "begin to deal click");
        HashMap map = new HashMap();
        map.put("appId", this.B.as());
        map.put(kk.V, this.B.ar());
        Code(map);
        com.huawei.openalliance.ad.inter.listeners.a aVar = this.C;
        if (aVar != null) {
            aVar.V();
        }
        kr krVarCode = ks.Code(I() instanceof View ? ((View) I()).getContext() : this.Z, this.Code, map);
        boolean zCode = krVarCode.Code();
        if (zCode) {
            Code(krVarCode, i, materialClickInfo);
        }
        d.Code(this.Z).Code(false);
        return zCode;
    }
}
