package com.bytedance.sdk.openadsdk;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.ad.IMediationAdSlot;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class AdSlot implements SlotType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5187a;
    private float b;
    private String bg;
    private String bq;
    private String c;
    private String dw;
    private int fx;
    private String gi;
    private int iz;
    private String jk;
    private boolean k;
    private IMediationAdSlot kj;
    private int l;
    private int mv;
    private int[] my;
    private boolean n;
    private int nr;
    private int o;
    private float pn;
    private String q;
    private TTAdLoadType qq;
    private int s;
    private String sx;
    private String t;
    private String u;
    private boolean x;
    private int z;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {
        private String bg;
        private String bq;
        private String c;
        private String gi;
        private IMediationAdSlot kj;
        private int l;
        private float mv;
        private int[] my;
        private String n;
        private int o;
        private String q;
        private String qq;
        private float s;
        private String sx;
        private int t;
        private String u;
        private int z;
        private int nr = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        private int fx = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        private boolean b = true;
        private boolean pn = false;
        private boolean iz = false;
        private int x = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5188a = "defaultUser";
        private int jk = 2;
        private boolean k = true;
        private TTAdLoadType dw = TTAdLoadType.UNKNOWN;

        public AdSlot build() {
            AdSlot adSlot = new AdSlot();
            adSlot.u = this.u;
            adSlot.iz = this.x;
            adSlot.x = this.b;
            adSlot.n = this.pn;
            adSlot.f5187a = this.iz;
            adSlot.nr = this.nr;
            adSlot.fx = this.fx;
            adSlot.b = this.mv;
            adSlot.pn = this.s;
            adSlot.jk = this.n;
            adSlot.t = this.f5188a;
            adSlot.l = this.jk;
            adSlot.s = this.t;
            adSlot.k = this.k;
            adSlot.my = this.my;
            adSlot.o = this.o;
            adSlot.sx = this.sx;
            adSlot.bq = this.c;
            adSlot.dw = this.q;
            adSlot.c = this.qq;
            adSlot.mv = this.l;
            adSlot.bg = this.bg;
            adSlot.q = this.bq;
            adSlot.qq = this.dw;
            adSlot.gi = this.gi;
            adSlot.z = this.z;
            adSlot.kj = this.kj;
            return adSlot;
        }

        public Builder setAdCount(int i) {
            if (i <= 0) {
                i = 1;
            }
            if (i > 20) {
                i = 20;
            }
            this.x = i;
            return this;
        }

        public Builder setAdId(String str) {
            this.c = str;
            return this;
        }

        public Builder setAdLoadType(TTAdLoadType tTAdLoadType) {
            this.dw = tTAdLoadType;
            return this;
        }

        public Builder setAdType(int i) {
            this.l = i;
            return this;
        }

        public Builder setAdloadSeq(int i) {
            this.o = i;
            return this;
        }

        public Builder setCodeId(String str) {
            this.u = str;
            return this;
        }

        public Builder setCreativeId(String str) {
            this.q = str;
            return this;
        }

        public Builder setExpressViewAcceptedSize(float f, float f2) {
            this.mv = f;
            this.s = f2;
            return this;
        }

        public Builder setExt(String str) {
            this.qq = str;
            return this;
        }

        public Builder setExternalABVid(int... iArr) {
            this.my = iArr;
            return this;
        }

        public Builder setImageAcceptedSize(int i, int i2) {
            this.nr = i;
            this.fx = i2;
            return this;
        }

        public Builder setIsAutoPlay(boolean z) {
            this.k = z;
            return this;
        }

        public Builder setMediaExtra(String str) {
            this.n = str;
            return this;
        }

        public Builder setMediationAdSlot(IMediationAdSlot iMediationAdSlot) {
            this.kj = iMediationAdSlot;
            return this;
        }

        @Deprecated
        public Builder setNativeAdType(int i) {
            this.t = i;
            return this;
        }

        public Builder setOrientation(int i) {
            this.jk = i;
            return this;
        }

        public Builder setPrimeRit(String str) {
            this.sx = str;
            return this;
        }

        public Builder setRewardAmount(int i) {
            this.z = i;
            return this;
        }

        public Builder setRewardName(String str) {
            this.gi = str;
            return this;
        }

        public Builder setSupportDeepLink(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setUserData(String str) {
            this.bq = str;
            return this;
        }

        public Builder setUserID(String str) {
            this.f5188a = str;
            return this;
        }

        public Builder supportIconStyle() {
            this.iz = true;
            return this;
        }

        public Builder supportRenderControl() {
            this.pn = true;
            return this;
        }

        public Builder withBid(String str) {
            if (str == null) {
                return this;
            }
            this.bg = str;
            return this;
        }
    }

    public int getAdCount() {
        return this.iz;
    }

    public String getAdId() {
        return this.bq;
    }

    public TTAdLoadType getAdLoadType() {
        return this.qq;
    }

    public int getAdType() {
        return this.mv;
    }

    public int getAdloadSeq() {
        return this.o;
    }

    public String getBidAdm() {
        return this.bg;
    }

    public String getCodeId() {
        return this.u;
    }

    public String getCreativeId() {
        return this.dw;
    }

    public float getExpressViewAcceptedHeight() {
        return this.pn;
    }

    public float getExpressViewAcceptedWidth() {
        return this.b;
    }

    public String getExt() {
        return this.c;
    }

    public int[] getExternalABVid() {
        return this.my;
    }

    public int getImgAcceptedHeight() {
        return this.fx;
    }

    public int getImgAcceptedWidth() {
        return this.nr;
    }

    public String getMediaExtra() {
        return this.jk;
    }

    public IMediationAdSlot getMediationAdSlot() {
        return this.kj;
    }

    @Deprecated
    public int getNativeAdType() {
        return this.s;
    }

    public int getOrientation() {
        return this.l;
    }

    public String getPrimeRit() {
        String str = this.sx;
        return str == null ? "" : str;
    }

    public int getRewardAmount() {
        return this.z;
    }

    public String getRewardName() {
        return this.gi;
    }

    public String getUserData() {
        return this.q;
    }

    public String getUserID() {
        return this.t;
    }

    public boolean isAutoPlay() {
        return this.k;
    }

    public boolean isSupportDeepLink() {
        return this.x;
    }

    public boolean isSupportIconStyle() {
        return this.f5187a;
    }

    public boolean isSupportRenderConrol() {
        return this.n;
    }

    public void setAdCount(int i) {
        this.iz = i;
    }

    public void setAdLoadType(TTAdLoadType tTAdLoadType) {
        this.qq = tTAdLoadType;
    }

    public void setExternalABVid(int... iArr) {
        this.my = iArr;
    }

    public void setNativeAdType(int i) {
        this.s = i;
    }

    public void setUserData(String str) {
        this.q = str;
    }

    public JSONObject toJsonObj() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mCodeId", this.u);
            jSONObject.put("mIsAutoPlay", this.k);
            jSONObject.put("mImgAcceptedWidth", this.nr);
            jSONObject.put("mImgAcceptedHeight", this.fx);
            jSONObject.put("mExpressViewAcceptedWidth", this.b);
            jSONObject.put("mExpressViewAcceptedHeight", this.pn);
            jSONObject.put("mAdCount", this.iz);
            jSONObject.put("mSupportDeepLink", this.x);
            jSONObject.put("mSupportRenderControl", this.n);
            jSONObject.put("mSupportIconStyle", this.f5187a);
            jSONObject.put("mMediaExtra", this.jk);
            jSONObject.put("mUserID", this.t);
            jSONObject.put("mOrientation", this.l);
            jSONObject.put("mNativeAdType", this.s);
            jSONObject.put("mAdloadSeq", this.o);
            jSONObject.put("mPrimeRit", this.sx);
            jSONObject.put("mAdId", this.bq);
            jSONObject.put("mCreativeId", this.dw);
            jSONObject.put("mExt", this.c);
            jSONObject.put("mBidAdm", this.bg);
            jSONObject.put("mUserData", this.q);
            jSONObject.put("mAdLoadType", this.qq);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public String toString() {
        return "AdSlot{mCodeId='" + this.u + "', mImgAcceptedWidth=" + this.nr + ", mImgAcceptedHeight=" + this.fx + ", mExpressViewAcceptedWidth=" + this.b + ", mExpressViewAcceptedHeight=" + this.pn + ", mAdCount=" + this.iz + ", mSupportDeepLink=" + this.x + ", mSupportRenderControl=" + this.n + ", mSupportIconStyle=" + this.f5187a + ", mMediaExtra='" + this.jk + "', mUserID='" + this.t + "', mOrientation=" + this.l + ", mNativeAdType=" + this.s + ", mIsAutoPlay=" + this.k + ", mPrimeRit" + this.sx + ", mAdloadSeq" + this.o + ", mAdId" + this.bq + ", mCreativeId" + this.dw + ", mExt" + this.c + ", mUserData" + this.q + ", mAdLoadType" + this.qq + '}';
    }

    private AdSlot() {
        this.l = 2;
        this.k = true;
    }
}
