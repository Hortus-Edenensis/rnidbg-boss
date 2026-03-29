package com.ss.bytertc.engine;

import com.bytedance.realx.base.CalledByNative;
import com.ss.bytertc.engine.data.CloudProxyInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class InternalCloudProxyInfo {
    public String cloudProxyIp;
    public int cloudProxyPort;

    public InternalCloudProxyInfo(String str, int i) {
        this.cloudProxyIp = str;
        this.cloudProxyPort = i;
    }

    @CalledByNative
    public String getCloudProxyIp() {
        String str = this.cloudProxyIp;
        return str == null ? "" : str;
    }

    @CalledByNative
    public int getCloudProxyPort() {
        return this.cloudProxyPort;
    }

    public InternalCloudProxyInfo(CloudProxyInfo cloudProxyInfo) {
        this.cloudProxyIp = cloudProxyInfo.cloudProxyIp;
        this.cloudProxyPort = cloudProxyInfo.cloudProxyPort;
    }
}
