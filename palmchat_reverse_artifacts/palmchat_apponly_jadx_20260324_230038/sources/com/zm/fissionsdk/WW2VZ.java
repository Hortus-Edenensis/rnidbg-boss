package com.zm.fissionsdk;

import com.zm.adxsdk.protocol.api.interfaces.IWfLoadManager;
import com.zm.adxsdk.protocol.bridge.AdxSdkBridge;
import com.zm.adxsdk.protocol.bridge.IPluginBridge;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class WW2VZ implements IPluginBridge {
    public static WW2VZ b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IPluginBridge f16737a;

    public WW2VZ() {
        a();
    }

    public static WW2VZ b() {
        if (b == null) {
            synchronized (WW2VZ.class) {
                if (b == null) {
                    b = new WW2VZ();
                }
            }
        }
        return b;
    }

    public final void a() {
        if (this.f16737a == null) {
            this.f16737a = (IPluginBridge) AdxSdkBridge.getService(IPluginBridge.class);
        }
    }

    @Override // com.zm.adxsdk.protocol.bridge.IPluginBridge
    public long getPluginVersionCode() {
        a();
        IPluginBridge iPluginBridge = this.f16737a;
        if (iPluginBridge != null) {
            return iPluginBridge.getPluginVersionCode();
        }
        return 0L;
    }

    @Override // com.zm.adxsdk.protocol.bridge.IPluginBridge
    public String getPluginVersionName() {
        a();
        IPluginBridge iPluginBridge = this.f16737a;
        if (iPluginBridge != null) {
            return iPluginBridge.getPluginVersionName();
        }
        return null;
    }

    @Override // com.zm.adxsdk.protocol.bridge.IPluginBridge
    public IWfLoadManager getWfLoadManager() {
        a();
        IPluginBridge iPluginBridge = this.f16737a;
        if (iPluginBridge != null) {
            return iPluginBridge.getWfLoadManager();
        }
        return null;
    }
}
