package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.instreamad.InstreamAdLoadListener;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class aa implements z, com.huawei.openalliance.ad.inter.listeners.p {
    private InstreamAdLoadListener B;
    private int C;
    private boolean D = false;
    private q.a F;
    private Context I;
    private int L;
    private int S;
    private String V;
    private com.huawei.openalliance.ad.inter.q Z;

    public aa(Context context, String str) {
        this.V = str;
        Context applicationContext = context.getApplicationContext();
        this.I = applicationContext;
        this.F = new q.a(applicationContext);
        this.L = com.huawei.openalliance.ad.utils.q.I(this.I);
    }

    private void Z(int i) {
        InstreamAdLoadListener instreamAdLoadListener = this.B;
        if (instreamAdLoadListener != null) {
            instreamAdLoadListener.onAdFailed(i);
        }
    }

    @Override // com.huawei.hms.ads.z
    public void Code(int i) {
        this.C = i;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.p
    public void I(int i) {
        Z(com.huawei.hms.ads.utils.b.Code(i));
        this.D = false;
    }

    @Override // com.huawei.hms.ads.z
    public void V(int i) {
        this.S = i;
    }

    private void V(AdParam adParam) {
        q.a aVar;
        if (adParam == null || (aVar = this.F) == null) {
            return;
        }
        aVar.Code(com.huawei.hms.ads.utils.c.Code(adParam.V())).Code(new String[]{this.V}).Code(this.L).Code(false).V(true);
        com.huawei.openalliance.ad.inter.q qVarCode = this.F.Code();
        this.Z = qVarCode;
        qVarCode.V(adParam.getTargetingContentUrl());
        this.Z.V(adParam.getGender());
        this.Z.Code(adParam.getKeywords());
        this.Z.I(adParam.I());
        this.Z.Code(adParam.C());
        HiAd.getInstance(this.I).setCountryCode(adParam.Z());
    }

    @Override // com.huawei.hms.ads.z
    public void Code(AdParam adParam) {
        String str;
        if (TextUtils.isEmpty(this.V)) {
            Z(1);
            str = "ad unit id is invalid.";
        } else if (this.C <= 0) {
            Z(1);
            str = "totalDuration is invalid.";
        } else {
            if (!this.D) {
                k.Code().Code(this.I);
                V(adParam);
                com.huawei.openalliance.ad.inter.q qVar = this.Z;
                if (qVar != null) {
                    this.D = true;
                    qVar.Code(this, this.C, this.S);
                    return;
                }
                return;
            }
            Z(4);
            str = "ad is loading.";
        }
        fh.V("InstreamAdLoadMediator", str);
    }

    @Override // com.huawei.hms.ads.z
    public void Code(InstreamAdLoadListener instreamAdLoadListener) {
        this.B = instreamAdLoadListener;
    }

    @Override // com.huawei.openalliance.ad.inter.listeners.p
    public void Code(Map<String, List<com.huawei.openalliance.ad.inter.data.h>> map) {
        this.D = false;
        if (!map.keySet().contains(this.V)) {
            Z(3);
            return;
        }
        List<com.huawei.openalliance.ad.inter.data.h> list = map.get(this.V);
        if (list == null || list.size() <= 0) {
            Z(3);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<com.huawei.openalliance.ad.inter.data.h> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new y(this.I, it.next()));
        }
        InstreamAdLoadListener instreamAdLoadListener = this.B;
        if (instreamAdLoadListener != null) {
            instreamAdLoadListener.onAdLoaded(arrayList);
        }
    }

    @Override // com.huawei.hms.ads.z
    public boolean Code() {
        return this.D;
    }
}
