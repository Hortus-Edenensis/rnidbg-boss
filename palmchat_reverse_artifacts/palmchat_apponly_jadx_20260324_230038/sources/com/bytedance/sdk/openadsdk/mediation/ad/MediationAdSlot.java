package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MediationAdSlot implements IMediationAdSlot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5420a;
    private int b;
    private String fx;
    private boolean iz;
    private String jk;
    private String k;
    private MediationNativeToBannerListener l;
    private float mv;
    private MediationSplashRequestInfo my;
    private Map<String, Object> n;
    private boolean nr;
    private float pn;
    private float s;
    private boolean t;
    private boolean u;
    private boolean x;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private float b;
        private boolean fx;
        private int jk;
        private String k;
        private MediationNativeToBannerListener l;
        private MediationSplashRequestInfo my;
        private String n;
        private boolean nr;
        private boolean pn;
        private boolean t;
        private boolean u;
        private boolean x;
        private Map<String, Object> iz = new HashMap();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5421a = "";
        private float mv = 80.0f;
        private float s = 80.0f;

        public MediationAdSlot build() {
            MediationAdSlot mediationAdSlot = new MediationAdSlot();
            mediationAdSlot.u = this.u;
            mediationAdSlot.nr = this.nr;
            mediationAdSlot.x = this.fx;
            mediationAdSlot.pn = this.b;
            mediationAdSlot.iz = this.pn;
            mediationAdSlot.n = this.iz;
            mediationAdSlot.f5420a = this.x;
            mediationAdSlot.jk = this.n;
            mediationAdSlot.fx = this.f5421a;
            mediationAdSlot.b = this.jk;
            mediationAdSlot.t = this.t;
            mediationAdSlot.l = this.l;
            mediationAdSlot.mv = this.mv;
            mediationAdSlot.s = this.s;
            mediationAdSlot.k = this.k;
            mediationAdSlot.my = this.my;
            return mediationAdSlot;
        }

        public Builder setAllowShowCloseBtn(boolean z) {
            this.t = z;
            return this;
        }

        public Builder setBidNotify(boolean z) {
            this.x = z;
            return this;
        }

        public Builder setExtraObject(String str, Object obj) {
            Map<String, Object> map = this.iz;
            if (map != null) {
                map.put(str, obj);
            }
            return this;
        }

        public Builder setMediationNativeToBannerListener(MediationNativeToBannerListener mediationNativeToBannerListener) {
            this.l = mediationNativeToBannerListener;
            return this;
        }

        public Builder setMediationSplashRequestInfo(MediationSplashRequestInfo mediationSplashRequestInfo) {
            this.my = mediationSplashRequestInfo;
            return this;
        }

        public Builder setMuted(boolean z) {
            this.fx = z;
            return this;
        }

        @Deprecated
        public Builder setRewardAmount(int i) {
            this.jk = i;
            return this;
        }

        @Deprecated
        public Builder setRewardName(String str) {
            this.f5421a = str;
            return this;
        }

        public Builder setScenarioId(String str) {
            this.n = str;
            return this;
        }

        public Builder setShakeViewSize(float f, float f2) {
            this.mv = f;
            this.s = f2;
            return this;
        }

        public Builder setSplashPreLoad(boolean z) {
            this.nr = z;
            return this;
        }

        public Builder setSplashShakeButton(boolean z) {
            this.u = z;
            return this;
        }

        public Builder setUseSurfaceView(boolean z) {
            this.pn = z;
            return this;
        }

        public Builder setVolume(float f) {
            this.b = f;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.k = str;
            return this;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public Map<String, Object> getExtraObject() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public int getRewardAmount() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getRewardName() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getScenarioId() {
        return this.jk;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewHeight() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getShakeViewWidth() {
        return this.mv;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public float getVolume() {
        return this.pn;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public String getWxAppId() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isAllowShowCloseBtn() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isBidNotify() {
        return this.f5420a;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isMuted() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashPreLoad() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isSplashShakeButton() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public boolean isUseSurfaceView() {
        return this.iz;
    }

    private MediationAdSlot() {
        this.fx = "";
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationNativeToBannerListener getMediationNativeToBannerListener() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot
    public MediationSplashRequestInfo getMediationSplashRequestInfo() {
        return this.my;
    }
}
