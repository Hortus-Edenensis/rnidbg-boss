package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.mediation.ad.u.nr.u.fx;
import com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b;
import com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MediationNativeManagerDefault extends b {
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.nr
    public List<Object> getAdLoadInfo() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.nr
    public u getBestEcpm() {
        return new MediationAdEcpmInfoDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.nr
    public List<u> getCacheList() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.nr
    public List<u> getMultiBiddingEcpm() {
        return new LinkedList();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.nr
    public u getShowEcpm() {
        return new MediationAdEcpmInfoDefault();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b
    public boolean hasDislike() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b
    public boolean isExpress() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.nr
    public boolean isReady() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b
    public void onPause() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b
    public void onResume() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b
    public void setShakeViewListener(fx fxVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.b
    public void setUseCustomVideo(boolean z) {
    }
}
