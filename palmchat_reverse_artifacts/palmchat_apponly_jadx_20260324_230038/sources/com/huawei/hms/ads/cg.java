package com.huawei.hms.ads;

import com.huawei.hms.ads.reward.Reward;
import com.huawei.openalliance.ad.inter.data.RewardItem;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cg implements Reward {
    private String Code;
    private int V;

    public cg() {
    }

    public cg(RewardItem rewardItem) {
        if (rewardItem != null) {
            this.Code = rewardItem.Code();
            this.V = rewardItem.V();
        }
    }

    @Override // com.huawei.hms.ads.reward.Reward
    public int getAmount() {
        return this.V;
    }

    @Override // com.huawei.hms.ads.reward.Reward
    public String getName() {
        return this.Code;
    }
}
