package com.wifi.ad.core;

import com.qq.e.comm.managers.setting.GlobalSetting;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/wifi/ad/core/SDKAlias;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "GDT", "CSJ", GlobalSetting.KS_SDK_WRAPPER, "WIFI", "OPPO", "HUAWEI", "BEIZI", "FEISUO", "LXAD", "core_release"}, k = 1, mv = {1, 1, 16})
public enum SDKAlias {
    GDT("gdt"),
    CSJ("csj"),
    KS("ks"),
    WIFI("wifi"),
    OPPO("oppo"),
    HUAWEI("huawei"),
    BEIZI("beizi"),
    FEISUO("feisuo"),
    LXAD("lxad");

    private final String type;

    SDKAlias(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
