package com.huawei.hms.ads.reward;

import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.cg;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@GlobalApi
public interface Reward {
    public static final Reward DEFAULT = new cg();

    int getAmount();

    String getName();
}
