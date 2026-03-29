package com.huawei.openalliance.ad.inter.data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.dj;
import com.huawei.hms.ads.dl;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.jf;
import com.huawei.hms.ads.jg;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.be;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.z;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class q extends a implements i {
    private transient com.huawei.openalliance.ad.inter.listeners.g D;
    private boolean F;
    private transient INonwifiActionListener L;
    private com.huawei.openalliance.ad.beans.metadata.VideoInfo S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6944a;
    private RewardItem b;
    private com.huawei.openalliance.ad.inter.listeners.h e;
    private int f;
    private VideoConfiguration g;
    private boolean h;

    public q(AdContentData adContentData) {
        super(adContentData);
        this.F = false;
        this.f = 1;
        this.h = false;
        this.I = adContentData;
        if (adContentData.N() == null || adContentData.O() == 0) {
            return;
        }
        this.b = new RewardItem(adContentData.N(), adContentData.O());
    }

    private void V(Context context) {
        if (!(context instanceof Activity)) {
            I(context);
        } else {
            Code((Activity) context);
            jf.Code(context).V(context);
        }
    }

    private com.huawei.openalliance.ad.beans.metadata.VideoInfo ai() {
        MetaData metaDataI_;
        if (this.S == null && (metaDataI_ = i_()) != null) {
            this.S = metaDataI_.V();
        }
        return this.S;
    }

    public boolean B() {
        if (jg.c(K()) || !this.h) {
            L();
        }
        return this.Code;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public boolean C() {
        return this.F;
    }

    public void Code(int i) {
        this.f = i;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a
    public boolean F() {
        return this.f6944a;
    }

    public com.huawei.openalliance.ad.inter.listeners.h I() {
        return this.e;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public RewardItem S() {
        return this.b;
    }

    public com.huawei.openalliance.ad.inter.listeners.g Z() {
        return this.D;
    }

    public void a_(boolean z) {
        this.h = z;
    }

    private void Code(Activity activity) {
        fh.V("RewardAd", "startRewardViaActivity");
        SafeIntent safeIntent = new SafeIntent(x.am);
        safeIntent.setPackage(z.Z(activity));
        safeIntent.putExtra("content_id", d());
        safeIntent.putExtra("slotid", r());
        safeIntent.putExtra("sdk_version", "13.4.80.301");
        safeIntent.putExtra(be.g, j_());
        safeIntent.putExtra(be.i, this.f);
        safeIntent.putExtra(be.j, Code());
        safeIntent.putExtra("show_id", u());
        safeIntent.putExtra(be.M, B());
        safeIntent.putExtra(be.P, N());
        safeIntent.putExtra(be.Q, O());
        safeIntent.putExtra("apiVer", this.I.aF());
        safeIntent.putExtra("templateId", af());
        if (this.L != null) {
            if (ai() != null) {
                safeIntent.putExtra("reward_key_nonwifi_action_play", this.L.Code(r2.B()));
            }
            AppInfo appInfoE = E();
            if (appInfoE != null) {
                safeIntent.putExtra("reward_key_nonwifi_action_download", this.L.Code(appInfoE, appInfoE.B()));
            }
        }
        Code(activity, safeIntent);
        AppInfo appInfoE2 = E();
        safeIntent.putExtra("unique_id", A());
        Object[] objArr = new Object[2];
        objArr[0] = appInfoE2 == null ? "noAppInfo" : appInfoE2.e();
        objArr[1] = A();
        fh.V("RewardAd", "startRewardViaActivity, appInfo.uniqueId: %s, ad.uniqueId: %s", objArr);
        safeIntent.setClipData(x.cS);
        activity.startActivityForResult(safeIntent, 1);
    }

    private void I(Context context) {
        fh.V("RewardAd", "startRewardViaAidl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", d());
            jSONObject.put("slotid", r());
            jSONObject.put("sdk_version", "13.4.80.301");
            jSONObject.put(be.g, j_());
            jSONObject.put(be.i, this.f);
            jSONObject.put(be.j, Code());
            jSONObject.put("show_id", u());
            jSONObject.put(be.P, N());
            jSONObject.put(be.M, B());
            jSONObject.put(be.Q, O());
            jSONObject.put("apiVer", this.I.aF());
            jSONObject.put("templateId", af());
            if (this.L != null) {
                if (ai() != null) {
                    jSONObject.put("reward_key_nonwifi_action_play", this.L.Code(r2.B()));
                }
                AppInfo appInfoE = E();
                if (appInfoE != null) {
                    jSONObject.put("reward_key_nonwifi_action_download", this.L.Code(appInfoE, appInfoE.B()));
                }
            }
            AppInfo appInfoE2 = E();
            jSONObject.put("unique_id", A());
            Object[] objArr = new Object[2];
            objArr[0] = appInfoE2 == null ? "noAppInfo" : appInfoE2.e();
            objArr[1] = A();
            fh.V("RewardAd", "startRewardViaAidl, appInfo.uniqueId: %s, ad.uniqueId: %s", objArr);
            com.huawei.openalliance.ad.ipc.g.V(context).Code("showReward", jSONObject.toString(), null, null);
        } catch (JSONException e) {
            fh.I("RewardAd", "startRewardViaAidl, e:" + e.getClass().getSimpleName());
        }
    }

    private void V(Context context, com.huawei.openalliance.ad.inter.listeners.g gVar) {
        fh.V("RewardAd", "showAd");
        if (context == null) {
            return;
        }
        Code(gVar);
        dj.Code(this);
        AppInfo appInfoE = E();
        if (appInfoE != null) {
            fh.Code("RewardAd", "appName:" + appInfoE.L() + ", uniqueId:" + A() + ", appuniqueId:" + appInfoE.e());
        }
        dl.Code(context).Code();
        V(context);
    }

    @Override // com.huawei.openalliance.ad.inter.data.a
    public void Z(boolean z) {
        this.F = z;
    }

    public void Code(Activity activity, com.huawei.openalliance.ad.inter.listeners.g gVar) {
        V(activity, gVar);
    }

    @Override // com.huawei.openalliance.ad.inter.data.a
    public void I(boolean z) {
        this.f6944a = z;
    }

    public void V(boolean z) {
        this.Code = z;
    }

    private void Code(Context context, Intent intent) {
        String strV = this.I.v();
        if (z.B(context) && strV != null && jg.F(strV)) {
            intent.addFlags(268959744);
            intent.putExtra(be.ai, true);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public boolean V() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            this.S = adContentData.t();
        }
        return this.S != null || ae();
    }

    public void Code(Context context, com.huawei.openalliance.ad.inter.listeners.g gVar) {
        V(context, gVar);
    }

    public void Code(VideoConfiguration videoConfiguration) {
        if (videoConfiguration == null) {
            return;
        }
        if (HiAd.Code() != null) {
            HiAd.Code().reportSetVideoConfigMedia(this.I, jg.c(K()), jg.d(K()), 7);
        }
        if (videoConfiguration.getAutoPlayNetwork() == 1) {
            V(false);
        } else {
            V(true);
        }
        this.g = videoConfiguration;
        Code(videoConfiguration.isStartMuted());
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.g gVar) {
        this.D = gVar;
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.h hVar) {
        this.e = hVar;
    }

    public void Code(boolean z) {
        ((a) this).V = z;
    }

    public boolean Code() {
        if (jg.d(K()) || !this.h) {
            D();
        }
        return ((a) this).V;
    }
}
