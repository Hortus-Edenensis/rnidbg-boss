package com.huawei.openalliance.ad.inter.data;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.utils.bc;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
@com.huawei.openalliance.ad.annotations.b
public class RewardItem implements Serializable {
    private static final long serialVersionUID = 30424300;
    int amount;
    String type;

    public RewardItem(String str, int i) {
        this.type = bc.V(str);
        this.amount = i;
    }

    @com.huawei.openalliance.ad.annotations.b
    public String Code() {
        return this.type;
    }

    @com.huawei.openalliance.ad.annotations.b
    public int V() {
        return this.amount;
    }

    public void Code(int i) {
        this.amount = i;
    }

    public void Code(String str) {
        this.type = str;
    }
}
