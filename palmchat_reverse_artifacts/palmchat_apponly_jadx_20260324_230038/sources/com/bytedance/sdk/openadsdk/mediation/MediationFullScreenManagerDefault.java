package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.fx;
import com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.u;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MediationFullScreenManagerDefault extends fx {
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

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.nr
    public boolean isReady() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.u.nr.u.fx
    public void destroy() {
    }
}
