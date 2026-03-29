package com.huawei.openalliance.ad.inter;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.utils.z;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class g implements h {
    private static final byte[] I = new byte[0];
    private static g V;
    private eh B;
    private AdSlotParam C;
    private com.huawei.openalliance.ad.inter.listeners.f F;
    private Integer S = null;
    private Context Z;

    private g(Context context) {
        this.Z = context.getApplicationContext();
        this.B = eh.Code(context);
        if (cn.V(this.Z)) {
            IntentFilter intentFilter = new IntentFilter(x.bv);
            Intent intentCode = z.Code(this.Z, null, intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            if (intentCode != null && intentCode.getAction() != null && intentCode.getAction().equals(x.bv)) {
                Log.d("HiAdSplash", "HiAd: getIntent");
                new c(this.Z).onReceive(this.Z, intentCode);
            }
            z.Code(this.Z, new c(this.Z), intentFilter, "com.huawei.permission.app.DOWNLOAD", null);
            d.Code(this.Z).V();
        }
    }

    public static h Code(Context context) {
        return I(context);
    }

    @Override // com.huawei.openalliance.ad.inter.h
    public com.huawei.openalliance.ad.inter.listeners.f C() {
        return this.F;
    }

    public void Z(final AdSlotParam adSlotParam) {
        fh.V("HiAdSplash", "preloadAd request");
        if (adSlotParam != null) {
            fh.V("HiAdSplash", "request preload splash ad");
            com.huawei.openalliance.ad.utils.i.V(new Runnable() { // from class: com.huawei.openalliance.ad.inter.g.2
                @Override // java.lang.Runnable
                public void run() {
                    adSlotParam.Code(true);
                    adSlotParam.I(g.this.S);
                    AdSlotParam adSlotParam2 = adSlotParam;
                    adSlotParam2.Code(com.huawei.hms.ads.utils.c.Code(adSlotParam2.B()));
                    if (cn.Code(g.this.Z).V()) {
                        adSlotParam.I(com.huawei.openalliance.ad.utils.a.Code(g.this.Z));
                    }
                    adSlotParam.a(com.huawei.openalliance.ad.utils.d.d(g.this.Z));
                    adSlotParam.Z(com.huawei.hms.ads.h.Code());
                    com.huawei.openalliance.ad.ipc.g.V(g.this.Z).Code("reqPreSplashAd", ad.V(adSlotParam), null, null);
                }
            });
            ai.Code(this.Z, adSlotParam.B());
        }
    }

    private static h I(Context context) {
        g gVar;
        synchronized (I) {
            if (V == null) {
                V = new g(context);
            }
            gVar = V;
        }
        return gVar;
    }

    @Override // com.huawei.openalliance.ad.inter.h
    public void C(int i) {
        if (1 == i || 2 == i) {
            eh.Code(this.Z).S(i);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.h
    public void Code() {
        Z(this.C);
    }

    @Override // com.huawei.openalliance.ad.inter.h
    public Integer I() {
        return this.S;
    }

    public void I(AdSlotParam adSlotParam) {
        if (adSlotParam != null) {
            this.C = adSlotParam.g();
        }
    }
}
