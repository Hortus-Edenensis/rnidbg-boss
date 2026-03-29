package com.lantern.core;

import com.lantern.core.business.IPubParams;
import com.wifi.utils.ServerConstantMix;
import defpackage.co2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class AbsPubParams implements IPubParams {
    @Override // com.lantern.core.business.IPubParams
    public List<String> getAdvancedPresetEventList() {
        return new ArrayList();
    }

    @Override // com.lantern.core.business.IPubParams
    public String getConfigPid() {
        return "06001001";
    }

    @Override // com.lantern.core.business.IPubParams
    public String getConfigUrl() {
        return ServerConstantMix.EVENT_CONFIG_DEFAULT_URL;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getEventPid() {
        return "00500201";
    }

    @Override // com.lantern.core.business.IPubParams
    public String getInstEventUrl() {
        return ServerConstantMix.INSERT_EVENT_DEFAULT_HOST;
    }

    @Override // com.lantern.core.business.IPubParams
    public /* synthetic */ int getIpv6Config() {
        return co2.a(this);
    }

    @Override // com.lantern.core.business.IPubParams
    public int getKv() {
        return 0;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getOfflineEventUrl() {
        return ServerConstantMix.OFFLINE_EVENT_DEFAULT_HOST;
    }

    @Override // com.lantern.core.business.IPubParams
    public String getOnceEventUrl() {
        return ServerConstantMix.ONCE_EVENT_DEFAULT_HOST;
    }

    @Override // com.lantern.core.business.IPubParams
    public List<String> getPresetEventList() {
        return new ArrayList();
    }

    @Override // com.lantern.core.business.IPubParams
    public String getWifiEventUrl() {
        return ServerConstantMix.WIFI_EVENT_DEFAULT_HOST;
    }
}
