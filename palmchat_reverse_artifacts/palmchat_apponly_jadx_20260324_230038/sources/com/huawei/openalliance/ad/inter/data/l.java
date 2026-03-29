package com.huawei.openalliance.ad.inter.data;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.DefaultTemplate;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.cm;
import com.huawei.hms.ads.ex;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.jg;
import com.huawei.hms.ads.ji;
import com.huawei.hms.ads.jk;
import com.huawei.hms.ads.kk;
import com.huawei.hms.ads.kr;
import com.huawei.hms.ads.ks;
import com.huawei.hms.ads.ky;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.hms.ads.w;
import com.huawei.openalliance.ad.beans.metadata.ContentExt;
import com.huawei.openalliance.ad.beans.metadata.ImpEX;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.ad.constant.be;
import com.huawei.openalliance.ad.constant.v;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.utils.ad;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class l extends c implements g {
    private boolean B;
    private String C;
    private ImageInfo D;
    private List<ImageInfo> L;
    private String S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private VideoInfo f6942a;
    private List<String> b;
    private List<String> c;
    private boolean d;
    private boolean e;
    private boolean f;
    private int g;
    private String h;
    private NativeAdConfiguration i;

    @com.huawei.openalliance.ad.annotations.d
    private long j;
    private String k;
    private Integer l;
    private String m;
    private String n;
    private transient VideoConfiguration q;
    private MaterialClickInfo r;

    public l(AdContentData adContentData) {
        super(adContentData);
        this.B = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = 0;
        this.l = Integer.valueOf(adContentData.aF());
        this.m = adContentData.aE();
    }

    private void F(Context context, Bundle bundle) {
        fh.V("INativeAd", "api adShow called.");
        jk.V(context, q(), new ji.a().Z(bc.Code(bundle)).Code(Long.valueOf(Math.min(System.currentTimeMillis() - this.j, x()))).Code(Integer.valueOf(y())).V((Integer) 7).Code(ky.Code(bundle)).B(ky.V(bundle)).I(com.huawei.openalliance.ad.utils.b.Code(context)).Code());
    }

    private void S(Context context, Bundle bundle) {
        fh.V("INativeAd", "api report adShowStart event.");
        jk.Code(context, q(), bc.Code(bundle));
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<ImageInfo> B() {
        MetaData metaDataI_;
        if (this.L == null && (metaDataI_ = i_()) != null) {
            this.L = c.Code(metaDataI_.d());
        }
        return this.L;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public VideoInfo C() {
        AdContentData adContentData = this.I;
        if (adContentData == null || adContentData.t() == null) {
            return null;
        }
        if (this.f6942a == null) {
            VideoInfo videoInfo = new VideoInfo(this.I.t());
            this.f6942a = videoInfo;
            videoInfo.Code(this.I.H());
        }
        return this.f6942a;
    }

    public String Code() {
        MetaData metaDataI_;
        if (this.C == null && (metaDataI_ = i_()) != null) {
            this.C = bc.V(metaDataI_.Z());
        }
        return this.C;
    }

    public void I(boolean z) {
        this.e = z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<String> L() {
        AdContentData adContentData;
        List<String> listO;
        if (this.b == null && (adContentData = this.I) != null && (listO = adContentData.o()) != null && listO.size() > 0) {
            this.b = listO;
        }
        return this.b;
    }

    public MaterialClickInfo V(Bundle bundle) {
        JSONObject jSONObjectV = bc.V(bundle);
        Integer numValueOf = Integer.valueOf(jSONObjectV.optInt(be.al, -111111));
        Integer numValueOf2 = Integer.valueOf(jSONObjectV.optInt(be.am, -111111));
        String strOptString = jSONObjectV.optString(be.an, "");
        Float fCode = bc.Code(jSONObjectV.optString(be.ar, "-111111"), Float.valueOf(-111111.0f));
        Integer numValueOf3 = Integer.valueOf(jSONObjectV.optInt("upX", -111111));
        Integer numValueOf4 = Integer.valueOf(jSONObjectV.optInt("upY", -111111));
        Integer numValueOf5 = Integer.valueOf(jSONObjectV.optInt(be.ao, -111111));
        Long lValueOf = Long.valueOf(jSONObjectV.optLong(be.aR));
        Long lValueOf2 = Long.valueOf(jSONObjectV.optLong(be.aS));
        String strOptString2 = jSONObjectV.optString(be.aT, "");
        if (numValueOf.intValue() == -111111) {
            numValueOf = null;
        }
        if (numValueOf2.intValue() == -111111) {
            numValueOf2 = null;
        }
        if (!bc.L(strOptString)) {
            strOptString = null;
        }
        if (fCode.floatValue() == -111111.0f) {
            fCode = null;
        }
        if (numValueOf3.intValue() == -111111) {
            numValueOf3 = null;
        }
        if (numValueOf4.intValue() == -111111) {
            numValueOf4 = null;
        }
        if (numValueOf5.intValue() == -111111) {
            numValueOf5 = null;
        }
        if (lValueOf.longValue() == 0) {
            lValueOf = null;
        }
        if (lValueOf2.longValue() == 0) {
            lValueOf2 = null;
        }
        if (bc.Code(strOptString2)) {
            strOptString2 = null;
        }
        return new MaterialClickInfo.a().Code(numValueOf).V(numValueOf2).V(strOptString).Code(fCode).I(numValueOf5).Z(numValueOf3).B(numValueOf4).V(lValueOf).Code(lValueOf2).Z(strOptString2).Code();
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public ImageInfo Z() {
        MetaData metaDataI_;
        List<com.huawei.openalliance.ad.beans.metadata.ImageInfo> listS;
        if (this.D == null && (metaDataI_ = i_()) != null && (listS = metaDataI_.S()) != null && !listS.isEmpty()) {
            this.D = new ImageInfo(listS.get(0));
        }
        return this.D;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<String> a() {
        AdContentData adContentData;
        if (this.c == null && (adContentData = this.I) != null) {
            List<String> listW = adContentData.W();
            if (!ag.Code(listW) && listW.size() > 0) {
                this.c = listW;
            }
        }
        return this.c;
    }

    public String aA() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.ao();
        }
        return null;
    }

    public String aB() {
        return this.k;
    }

    public String aC() {
        return this.n;
    }

    public DefaultTemplate aD() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.aV();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c, com.huawei.openalliance.ad.inter.data.d
    public PromoteInfo ag() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.z();
        }
        return null;
    }

    public VideoInfo ai() {
        return this.f6942a;
    }

    public boolean aj() {
        return this.d;
    }

    public boolean ak() {
        return this.e;
    }

    public boolean al() {
        return this.f;
    }

    public String am() {
        MetaData metaDataI_ = i_();
        return metaDataI_ != null ? metaDataI_.a() : "";
    }

    public String an() {
        return h();
    }

    public Double ao() {
        return null;
    }

    public String ap() {
        return null;
    }

    public String aq() {
        return null;
    }

    public Bundle ar() {
        return new Bundle();
    }

    public NativeAdConfiguration at() {
        return this.i;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Map<String, String> au() {
        int iL;
        VideoInfo videoInfoC;
        String str;
        AdContentData adContentData;
        String str2;
        String str3;
        HashMap map = new HashMap();
        map.put("appId", z());
        map.put(kk.V, am());
        Integer numAy = ay();
        String str4 = ex.Code;
        if (numAy == null || ay().intValue() != 3) {
            if (C() == null) {
                str = "getVideoInfo is null";
            } else {
                iL = C().L();
                if (!C().h()) {
                    str4 = ex.V;
                }
                map.put(be.s, str4);
                map.put(be.r, C().a());
                map.put(be.q, String.valueOf(iL));
                videoInfoC = C();
                map.put(be.aV, videoInfoC.k());
                map.put(be.m, u());
                map.put(be.p, String.valueOf(az()));
                if (f_() != null) {
                    map.put(be.n, String.valueOf(f_().getAutoPlayNetwork()));
                    map.put(be.o, Boolean.toString(f_().isStartMuted()));
                }
                adContentData = this.I;
                if (adContentData != null) {
                    Map<String, String> mapBh = adContentData.bh();
                    if (mapBh != null) {
                        str2 = mapBh.get("videoAutoPlay");
                        str3 = mapBh.get("videoPlaySound");
                    } else {
                        str2 = null;
                        str3 = null;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = "y";
                    }
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "n";
                    }
                    map.put("videoAutoPlay", str2);
                    map.put("videoPlaySound", str3);
                }
                str = "buildLinkedAdConfig, set progress from native view " + iL;
            }
        } else if (ai() == null) {
            str = "getVideoInfoForV3 is null";
        } else {
            if (fh.Code()) {
                fh.Code("INativeAd", "video_info: %s", ad.V(ai()));
                fh.Code("INativeAd", "preview_image_info: %s", ad.V(B()));
            }
            iL = ai().L();
            if (!this.I.H()) {
                str4 = ex.V;
            }
            map.put(be.s, str4);
            map.put(be.aO, ad.V(ai()));
            map.put(be.aP, ad.V(B()));
            map.put(be.aQ, aB());
            map.put(be.r, ai().a());
            map.put(be.q, String.valueOf(iL));
            videoInfoC = ai();
            map.put(be.aV, videoInfoC.k());
            map.put(be.m, u());
            map.put(be.p, String.valueOf(az()));
            if (f_() != null) {
            }
            adContentData = this.I;
            if (adContentData != null) {
            }
            str = "buildLinkedAdConfig, set progress from native view " + iL;
        }
        fh.V("INativeAd", str);
        return map;
    }

    public String av() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.aE();
        }
        return null;
    }

    public Integer ay() {
        return this.l;
    }

    public int az() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            this.g = adContentData.J();
        }
        return this.g;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public boolean b_() {
        AdContentData adContentData = this.I;
        return adContentData != null && adContentData.al() == 1;
    }

    public boolean d_() {
        if (this.I != null) {
            return !ag.Code(r0.aL());
        }
        return false;
    }

    public VideoConfiguration f_() {
        return this.q;
    }

    public MaterialClickInfo g_() {
        return this.r;
    }

    public Map<String, String> p() {
        AdContentData adContentData = this.I;
        if (adContentData == null) {
            return null;
        }
        List<ImpEX> listAy = adContentData.ay();
        List<ContentExt> listAz = this.I.az();
        HashMap map = new HashMap();
        if (!ag.Code(listAz)) {
            for (ContentExt contentExt : listAz) {
                map.put(contentExt.Code(), bc.V(contentExt.V()));
            }
        }
        if (!ag.Code(listAy)) {
            for (ImpEX impEX : listAy) {
                map.put(impEX.Code(), bc.V(impEX.V()));
            }
        }
        return map;
    }

    @Override // com.huawei.openalliance.ad.inter.data.g
    public List<FeedbackInfo> t() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.aC();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.c
    public String u() {
        return this.h;
    }

    public List<AdvertiserInfo> w() {
        if (this.I == null || !d_()) {
            return null;
        }
        return this.I.aL();
    }

    public void B(String str) {
        this.h = str;
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            adContentData.I(str);
        }
    }

    public void C(String str) {
        this.k = str;
    }

    public void Code(Context context, MaterialClickInfo materialClickInfo) {
        cm.Code(context, this.I, materialClickInfo);
    }

    public boolean I(Context context, Bundle bundle) {
        if (context == null || !H()) {
            fh.V("INativeAd", "record click event failed.");
            return false;
        }
        Code(context, v.D, bundle);
        return true;
    }

    public void S(String str) {
        this.n = str;
    }

    public String V() {
        MetaData metaDataS;
        if (this.S == null && (metaDataS = this.I.S()) != null) {
            this.S = bc.V(metaDataS.B());
        }
        return this.S;
    }

    public void Z(boolean z) {
        this.f = z;
    }

    private boolean C(Context context, Bundle bundle) {
        if (context == null || !H()) {
            return false;
        }
        return B(context, bundle);
    }

    private void Code(Context context, String str, Bundle bundle) {
        fh.V("INativeAd", "api report click event.");
        MaterialClickInfo materialClickInfoV = V(bundle);
        if (materialClickInfoV.L() == null && materialClickInfoV.D() == null) {
            materialClickInfoV.B((Integer) 1);
        }
        jk.Code(context, q(), bc.Code(bundle), 0, 0, str, 12, com.huawei.openalliance.ad.utils.b.Code(context), materialClickInfoV);
    }

    public boolean B(Context context, Bundle bundle) {
        if (context == null) {
            return false;
        }
        Code(true);
        kr krVarCode = ks.Code(context, q(), au());
        boolean zCode = krVarCode.Code();
        if (zCode) {
            Code(context, krVarCode.Z(), bundle);
        }
        return zCode;
    }

    public void V(long j) {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            adContentData.Z(j);
        }
    }

    public boolean Z(Context context, Bundle bundle) {
        return C(context, bundle);
    }

    public void Code(Context context, List<String> list) {
        if (context == null || !H()) {
            return;
        }
        new w(context, this).Code(list);
    }

    public void V(Context context) {
        cm.Code(context, this.I, (MaterialClickInfo) null);
    }

    public void Code(Bundle bundle) {
    }

    public void V(List<ImageInfo> list) {
        this.L = list;
    }

    public void Code(VideoConfiguration videoConfiguration) {
        this.q = videoConfiguration;
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            adContentData.Code(videoConfiguration);
        }
        if (HiAd.Code() != null) {
            HiAd.Code().reportSetVideoConfigMedia(this.I, jg.c(K()), jg.d(K()), 3);
        }
    }

    public void V(boolean z) {
        this.d = z;
    }

    public void Code(NativeAdConfiguration nativeAdConfiguration) {
        this.i = nativeAdConfiguration;
    }

    public boolean V(Context context, Bundle bundle) {
        if (context == null || !H()) {
            return false;
        }
        F(context, bundle);
        return true;
    }

    public void Code(MaterialClickInfo materialClickInfo) {
        if (materialClickInfo != null) {
            this.r = materialClickInfo;
        }
    }

    public void Code(VideoInfo videoInfo) {
        this.f6942a = videoInfo;
    }

    public void Code(boolean z) {
        this.B = z;
    }

    public boolean Code(Context context, Bundle bundle) {
        if (context == null || !H()) {
            return false;
        }
        this.j = System.currentTimeMillis();
        B(String.valueOf(z.Code()));
        V(this.j);
        S(context, bundle);
        return true;
    }

    public void as() {
    }
}
