package com.zenmen.palmchat.circle.ui.config;

import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import defpackage.rl0;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class GroupVersionConfig implements Serializable {
    private int AndroidMax;

    public static GroupVersionConfig getConfig() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.GROUP_VERSION);
        return (dynamicConfig == null || !dynamicConfig.isEnable()) ? new GroupVersionConfig() : (GroupVersionConfig) dynamicConfig.parseExtra(GroupVersionConfig.class);
    }

    public int getAndroidMax() {
        return this.AndroidMax;
    }

    public boolean isShowCircleRedPacket() {
        return getAndroidMax() < 260304;
    }

    public void setAndroidMax(int i) {
        this.AndroidMax = i;
    }
}
