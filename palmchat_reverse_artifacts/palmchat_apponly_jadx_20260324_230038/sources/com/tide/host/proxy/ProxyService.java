package com.tide.host.proxy;

import com.tide.host.HostManager;
import com.tide.protocol.context.ITideService;
import com.tide.protocol.context.base.ProxyBaseService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class ProxyService extends ProxyBaseService {
    public ProxyService() {
        ITideService iTideServiceLoadPluginService = HostManager.getInstance().loadPluginService(this, getClass().getName());
        this.mTideService = iTideServiceLoadPluginService;
        if (iTideServiceLoadPluginService != null) {
            iTideServiceLoadPluginService.attachProxy(this);
        }
    }

    @Override // com.tide.protocol.context.base.ProxyBaseService, android.app.Service
    public void onCreate() {
        super.onCreate();
        if (this.mTideService == null) {
            stopSelf();
        }
    }
}
