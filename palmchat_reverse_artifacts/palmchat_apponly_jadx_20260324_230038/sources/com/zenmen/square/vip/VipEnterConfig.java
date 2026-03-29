package com.zenmen.square.vip;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public class VipEnterConfig {
    public BaseVipConfig discover;
    public BaseVipConfig friend;
    public VipCenter vipCenter;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class BaseVipConfig {
        public String bannerBg;
        public String bannerUrl;
        public int priority;
        public int urlType;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class VipCenter extends BaseVipConfig {
        public String campaign;
        public String viptext;
    }
}
