package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MediationViewBinder implements IMediationViewBinder {
    public final int callToActionId;
    public final int decriptionTextId;
    public final Map<String, Integer> extras;
    public final int groupImage1Id;
    public final int groupImage2Id;
    public final int groupImage3Id;
    public final int iconImageId;
    public final int layoutId;
    public final int logoLayoutId;
    public final int mainImageId;
    public final int mediaViewId;
    public final int shakeViewContainerId;
    public final int sourceId;
    public final int titleId;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int f5423a;
        protected int b;
        protected int fx;
        protected int iz;
        protected int jk;
        protected int l;
        protected int mv;
        protected int n;
        protected int nr;
        protected int pn;
        protected Map<String, Integer> s;
        protected int t;
        protected int u;
        protected int x;

        public Builder(int i) {
            this.s = Collections.emptyMap();
            this.u = i;
            this.s = new HashMap();
        }

        public Builder addExtra(String str, int i) {
            this.s.put(str, Integer.valueOf(i));
            return this;
        }

        public Builder addExtras(Map<String, Integer> map) {
            this.s = new HashMap(map);
            return this;
        }

        public MediationViewBinder build() {
            return new MediationViewBinder(this);
        }

        public Builder callToActionId(int i) {
            this.b = i;
            return this;
        }

        public Builder descriptionTextId(int i) {
            this.fx = i;
            return this;
        }

        public Builder groupImage1Id(int i) {
            this.jk = i;
            return this;
        }

        public Builder groupImage2Id(int i) {
            this.t = i;
            return this;
        }

        public Builder groupImage3Id(int i) {
            this.l = i;
            return this;
        }

        public Builder iconImageId(int i) {
            this.pn = i;
            return this;
        }

        public Builder logoLayoutId(int i) {
            this.f5423a = i;
            return this;
        }

        public Builder mainImageId(int i) {
            this.iz = i;
            return this;
        }

        public Builder mediaViewIdId(int i) {
            this.x = i;
            return this;
        }

        public Builder shakeViewContainerId(int i) {
            this.mv = i;
            return this;
        }

        public Builder sourceId(int i) {
            this.n = i;
            return this;
        }

        public Builder titleId(int i) {
            this.nr = i;
            return this;
        }
    }

    public MediationViewBinder(Builder builder) {
        this.layoutId = builder.u;
        this.titleId = builder.nr;
        this.decriptionTextId = builder.fx;
        this.callToActionId = builder.b;
        this.iconImageId = builder.pn;
        this.mainImageId = builder.iz;
        this.mediaViewId = builder.x;
        this.sourceId = builder.n;
        this.extras = builder.s;
        this.groupImage1Id = builder.jk;
        this.groupImage2Id = builder.t;
        this.groupImage3Id = builder.l;
        this.logoLayoutId = builder.f5423a;
        this.shakeViewContainerId = builder.mv;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getCallToActionId() {
        return this.callToActionId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getDecriptionTextId() {
        return this.decriptionTextId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public Map<String, Integer> getExtras() {
        return this.extras;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage1Id() {
        return this.groupImage1Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage2Id() {
        return this.groupImage2Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getGroupImage3Id() {
        return this.groupImage3Id;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getIconImageId() {
        return this.iconImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLayoutId() {
        return this.layoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getLogoLayoutId() {
        return this.logoLayoutId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMainImageId() {
        return this.mainImageId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getMediaViewId() {
        return this.mediaViewId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getShakeViewContainerId() {
        return this.shakeViewContainerId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getSourceId() {
        return this.sourceId;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.IMediationViewBinder
    public int getTitleId() {
        return this.titleId;
    }
}
