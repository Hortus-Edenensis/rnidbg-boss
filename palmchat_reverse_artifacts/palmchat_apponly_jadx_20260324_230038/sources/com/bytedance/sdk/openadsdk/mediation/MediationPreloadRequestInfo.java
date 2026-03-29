package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MediationPreloadRequestInfo implements IMediationPreloadRequestInfo {
    private List<String> fx;
    private AdSlot nr;
    private int u;

    public MediationPreloadRequestInfo(int i, AdSlot adSlot, List<String> list) {
        this.u = i;
        this.nr = adSlot;
        this.fx = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public AdSlot getAdSlot() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public int getAdType() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.IMediationPreloadRequestInfo
    public List<String> getPrimeRitList() {
        return this.fx;
    }
}
