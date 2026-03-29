package com.huawei.hms.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import j$.util.Map;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class kl extends kr {
    private static final String V = "InnerWebAction";
    protected ex Code;
    private boolean F;
    private final boolean S;

    public kl(Context context, AdContentData adContentData, boolean z) {
        super(context, adContentData);
        this.Code = new ex();
        this.F = false;
        this.S = z;
    }

    private void B() {
        AdContentData adContentData;
        String str;
        String str2;
        if (this.Code == null || (adContentData = this.Z) == null) {
            return;
        }
        Map<String, String> mapBh = adContentData.bh();
        if (mapBh != null) {
            str = mapBh.get("videoAutoPlay");
            str2 = mapBh.get("videoPlaySound");
        } else {
            str = null;
            str2 = null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "y";
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "n";
        }
        this.Code.S(str);
        this.Code.F(str2);
    }

    public void Code(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Object orDefault;
        fh.Code(V, "buildLinkedAdConfig");
        if (map == null || map.isEmpty()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            str = (String) Map.EL.getOrDefault(map, com.huawei.openalliance.ad.constant.be.p, String.valueOf(0));
            str2 = (String) Map.EL.getOrDefault(map, com.huawei.openalliance.ad.constant.be.m, String.valueOf(0));
            str3 = (String) Map.EL.getOrDefault(map, com.huawei.openalliance.ad.constant.be.s, ex.V);
            str4 = (String) Map.EL.getOrDefault(map, com.huawei.openalliance.ad.constant.be.q, null);
            str5 = (String) Map.EL.getOrDefault(map, com.huawei.openalliance.ad.constant.be.r, "n");
            str6 = (String) Map.EL.getOrDefault(map, com.huawei.openalliance.ad.constant.be.aO, null);
            str7 = (String) Map.EL.getOrDefault(map, com.huawei.openalliance.ad.constant.be.aP, null);
            str8 = (String) Map.EL.getOrDefault(map, com.huawei.openalliance.ad.constant.be.aQ, null);
            orDefault = Map.EL.getOrDefault(map, com.huawei.openalliance.ad.constant.be.aV, ex.V);
        } else {
            str = map.get(com.huawei.openalliance.ad.constant.be.p);
            str2 = map.get(com.huawei.openalliance.ad.constant.be.m);
            str3 = map.get(com.huawei.openalliance.ad.constant.be.s);
            str4 = map.get(com.huawei.openalliance.ad.constant.be.q);
            str5 = map.get(com.huawei.openalliance.ad.constant.be.r);
            str6 = map.get(com.huawei.openalliance.ad.constant.be.aO);
            str7 = map.get(com.huawei.openalliance.ad.constant.be.aP);
            str8 = map.get(com.huawei.openalliance.ad.constant.be.aQ);
            orDefault = map.get(com.huawei.openalliance.ad.constant.be.aV);
        }
        String str9 = (String) orDefault;
        Integer numF = com.huawei.openalliance.ad.utils.bc.F(str);
        if (numF != null) {
            this.Code.V(numF.intValue());
        } else {
            this.Code.V(0);
        }
        this.Code.I(str2);
        Integer numF2 = com.huawei.openalliance.ad.utils.bc.F(str4);
        if (numF2 != null) {
            this.Code.Code(numF2.intValue());
            fh.V(V, "set progress from native view " + numF2);
        } else {
            this.Code.Code(0);
        }
        if (!TextUtils.isEmpty(str9)) {
            this.Code.Code(str9);
        }
        this.Code.V(str5);
        ex exVar = this.Code;
        String str10 = ex.Code;
        exVar.Code(ex.Code.equals(str3));
        this.Code.B(str6);
        this.Code.C(str7);
        this.Code.Z(str8);
        B();
        String strValueOf = map.containsKey(com.huawei.openalliance.ad.constant.be.n) ? map.get(com.huawei.openalliance.ad.constant.be.n) : null;
        String str11 = map.containsKey(com.huawei.openalliance.ad.constant.be.o) ? map.get(com.huawei.openalliance.ad.constant.be.o) : null;
        if (strValueOf == null && str11 == null) {
            return;
        }
        if (com.huawei.openalliance.ad.utils.bc.Code(strValueOf)) {
            strValueOf = String.valueOf(0);
        }
        if (!com.huawei.openalliance.ad.utils.bc.Code(str11)) {
            str10 = str11;
        }
        this.Code.Code(new VideoConfiguration.Builder().setAutoPlayNetwork(com.huawei.openalliance.ad.utils.bc.Code(strValueOf, 0)).setStartMuted(Boolean.parseBoolean(str10)).build());
    }

    @Override // com.huawei.hms.ads.kr
    public void V() {
        Code(com.huawei.openalliance.ad.constant.v.B);
    }

    public kl(Context context, AdContentData adContentData, boolean z, java.util.Map<String, String> map) {
        super(context, adContentData);
        this.Code = new ex();
        this.F = false;
        this.S = z;
        Code(map);
    }

    public void Code(boolean z) {
        this.F = z;
    }

    @Override // com.huawei.hms.ads.kr
    public boolean Code() {
        if (this.Z == null) {
            return I();
        }
        fh.V(V, "handle inner web action");
        this.Z.I(this.S);
        fh.V(V, "needAppDownload: %s", Boolean.valueOf(this.S));
        return TextUtils.isEmpty(this.Z.i()) ? I() : Code(this.Z);
    }

    private boolean Code(AdContentData adContentData) {
        if (!jg.Code(this.Z.v()) && !com.huawei.openalliance.ad.utils.ap.Z(this.I)) {
            return I();
        }
        Code(com.huawei.openalliance.ad.constant.v.B);
        cm.Code(this.I, adContentData, this.Code, this.F);
        return true;
    }
}
