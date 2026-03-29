package com.huawei.hms.ads.inter.data;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.f;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.jf;
import com.huawei.hms.ads.jg;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.openalliance.ad.beans.metadata.ImageInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.VideoInfo;
import com.huawei.openalliance.ad.constant.be;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.z;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a extends com.huawei.openalliance.ad.inter.data.a implements IInterstitialAd {
    private transient IInterstitialAdStatusListener C;
    private VideoInfo D;
    private RewardAdListener F;
    private VideoConfiguration L;
    private transient INonwifiActionListener S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<ImageInfo> f6582a;
    private boolean b;

    public a(AdContentData adContentData) {
        super(adContentData);
        this.b = false;
        this.I = adContentData;
    }

    private void V(Context context) {
        fh.V("InnerInterstitialAd", "startInterstitialViaAidl");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("content_id", d());
            jSONObject.put("sdk_version", "13.4.80.301");
            jSONObject.put(be.g, j_());
            jSONObject.put("show_id", u());
            jSONObject.put(be.P, N());
            jSONObject.put(be.Q, O());
            jSONObject.put("slotid", r());
            jSONObject.put(be.j, B());
            jSONObject.put(be.M, Z());
            jSONObject.put("apiVer", this.I.aF());
            jSONObject.put("templateId", af());
            if (getVideoConfiguration() != null) {
                jSONObject.put(be.n, getVideoConfiguration().getAutoPlayNetwork());
                jSONObject.put(be.o, getVideoConfiguration().isStartMuted());
            }
            if (this.S != null) {
                if (ai() != null) {
                    jSONObject.put("reward_key_nonwifi_action_play", this.S.Code(r2.B()));
                }
                AppInfo appInfoE = E();
                if (appInfoE != null) {
                    jSONObject.put("reward_key_nonwifi_action_download", this.S.Code(appInfoE, appInfoE.B()));
                }
            }
            AppInfo appInfoE2 = E();
            jSONObject.put("unique_id", A());
            Object[] objArr = new Object[2];
            objArr[0] = appInfoE2 == null ? "noAppInfo" : appInfoE2.e();
            objArr[1] = A();
            fh.V("InnerInterstitialAd", "startInterstitialViaAidl, appInfo.uniqueId: %s, ad.uniqueId: %s", objArr);
            g.V(context).Code("interstitial_ad_show", jSONObject.toString(), null, null);
        } catch (JSONException e) {
            fh.I("InnerInterstitialAd", "startInterstitialViaAidl, e:" + e.getClass().getSimpleName());
        }
    }

    private VideoInfo ai() {
        MetaData metaDataI_;
        if (this.D == null && (metaDataI_ = i_()) != null) {
            this.D = metaDataI_.V();
        }
        return this.D;
    }

    public boolean B() {
        if ((jg.d(K()) || this.L == null) && !this.b) {
            D();
        }
        return ((com.huawei.openalliance.ad.inter.data.a) this).V;
    }

    public RewardAdListener Code() {
        return this.F;
    }

    public IInterstitialAdStatusListener I() {
        return this.C;
    }

    public boolean Z() {
        if ((jg.c(K()) || this.L == null) && !this.b) {
            L();
        }
        return this.Code;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public VideoConfiguration getVideoConfiguration() {
        return this.L;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void setMobileDataAlertSwitch(boolean z) {
        this.Code = z;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void setNonwifiActionListener(INonwifiActionListener iNonwifiActionListener) {
        this.S = iNonwifiActionListener;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void setRewardAdListener(RewardAdListener rewardAdListener) {
        this.F = rewardAdListener;
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void setVideoConfiguration(VideoConfiguration videoConfiguration) {
        if (videoConfiguration == null) {
            return;
        }
        if (HiAd.Code() != null) {
            HiAd.Code().reportSetVideoConfigMedia(this.I, jg.c(K()), jg.d(K()), 12);
        }
        if (videoConfiguration.getAutoPlayNetwork() == 1) {
            setMobileDataAlertSwitch(false);
        } else {
            setMobileDataAlertSwitch(true);
        }
        this.L = videoConfiguration;
        Code(videoConfiguration.isStartMuted());
    }

    @Override // com.huawei.hms.ads.inter.data.IInterstitialAd
    public void show(Context context, IInterstitialAdStatusListener iInterstitialAdStatusListener) {
        if (context == null) {
            return;
        }
        Z(true);
        Code(iInterstitialAdStatusListener);
        f.Code(context).Code();
        com.huawei.hms.ads.g.Code(this);
        AppInfo appInfoE = E();
        if (appInfoE != null) {
            fh.Code("InnerInterstitialAd", "appName:" + appInfoE.L() + ", uniqueId:" + A() + ", appuniqueId:" + appInfoE.e());
        }
        if (!(context instanceof Activity)) {
            V(context);
        } else {
            Code((Activity) context);
            jf.Code(context).V(context);
        }
    }

    private void Code(Activity activity) {
        fh.V("InnerInterstitialAd", "startInterstitialViaActivity");
        SafeIntent safeIntent = new SafeIntent(x.aq);
        safeIntent.setPackage(z.Z(activity));
        safeIntent.putExtra("content_id", d());
        safeIntent.putExtra("sdk_version", "13.4.80.301");
        safeIntent.putExtra(be.g, j_());
        safeIntent.putExtra("show_id", u());
        safeIntent.putExtra(be.P, N());
        safeIntent.putExtra(be.Q, O());
        safeIntent.putExtra("slotid", r());
        safeIntent.putExtra(be.j, B());
        safeIntent.putExtra(be.M, Z());
        safeIntent.putExtra("apiVer", this.I.aF());
        safeIntent.putExtra("templateId", af());
        if (getVideoConfiguration() != null) {
            safeIntent.putExtra(be.n, getVideoConfiguration().getAutoPlayNetwork());
            safeIntent.putExtra(be.o, getVideoConfiguration().isStartMuted());
        }
        if (this.S != null) {
            if (ai() != null) {
                safeIntent.putExtra("reward_key_nonwifi_action_play", this.S.Code(r2.B()));
            }
            AppInfo appInfoE = E();
            if (appInfoE != null) {
                safeIntent.putExtra("reward_key_nonwifi_action_download", this.S.Code(appInfoE, appInfoE.B()));
            }
        }
        AppInfo appInfoE2 = E();
        safeIntent.putExtra("unique_id", A());
        Object[] objArr = new Object[2];
        objArr[0] = appInfoE2 == null ? "noAppInfo" : appInfoE2.e();
        objArr[1] = A();
        fh.V("InnerInterstitialAd", "startInterstitialViaActivity, appInfo.uniqueId: %s, ad.uniqueId: %s", objArr);
        safeIntent.setClipData(x.cS);
        activity.startActivityForResult(safeIntent, 1);
    }

    public void V(boolean z) {
        this.b = z;
    }

    private void Code(IInterstitialAdStatusListener iInterstitialAdStatusListener) {
        this.C = iInterstitialAdStatusListener;
    }

    @Override // com.huawei.openalliance.ad.inter.data.a, com.huawei.openalliance.ad.inter.data.e
    public boolean V() {
        AdContentData adContentData = this.I;
        if (adContentData == null) {
            return false;
        }
        if (3 == adContentData.aF()) {
            return true;
        }
        this.D = this.I.t();
        MetaData metaDataS = this.I.S();
        if (metaDataS != null) {
            this.f6582a = metaDataS.d();
        }
        if (this.I.l() == 9) {
            return this.D != null;
        }
        if (this.I.l() == 2 || this.I.l() == 4) {
            return !ag.Code(this.f6582a);
        }
        return false;
    }

    public void Code(boolean z) {
        ((com.huawei.openalliance.ad.inter.data.a) this).V = z;
    }
}
