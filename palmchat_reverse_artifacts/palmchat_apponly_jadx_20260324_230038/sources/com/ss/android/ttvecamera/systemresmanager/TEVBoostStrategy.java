package com.ss.android.ttvecamera.systemresmanager;

import android.content.Context;
import com.ss.android.ttvecamera.TEVBoostInterface;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class TEVBoostStrategy implements ITESystemResourceStrategy {
    @Override // com.ss.android.ttvecamera.systemresmanager.ITESystemResourceStrategy
    public void boostCpuFreq(int i) {
        TEVBoostInterface.VBoostCapabilityType vBoostCapabilityType = TEVBoostInterface.VBoostCapabilityType.CPU_FREQ_MIN;
        if (TEVBoostInterface.isSupportCapability(vBoostCapabilityType)) {
            TEVBoostInterface.requestCustomBoost(vBoostCapabilityType, 9, i);
        }
        TEVBoostInterface.VBoostCapabilityType vBoostCapabilityType2 = TEVBoostInterface.VBoostCapabilityType.CPU_FREQ_MAX;
        if (TEVBoostInterface.isSupportCapability(vBoostCapabilityType2)) {
            TEVBoostInterface.requestCustomBoost(vBoostCapabilityType2, 9, i);
        }
    }

    @Override // com.ss.android.ttvecamera.systemresmanager.ITESystemResourceStrategy
    public void init(Context context) {
        TEVBoostInterface.init(context);
    }

    @Override // com.ss.android.ttvecamera.systemresmanager.ITESystemResourceStrategy
    public void restoreCpuFreq() {
        TEVBoostInterface.VBoostCapabilityType vBoostCapabilityType = TEVBoostInterface.VBoostCapabilityType.CPU_FREQ_MIN;
        if (TEVBoostInterface.isSupportCapability(vBoostCapabilityType)) {
            TEVBoostInterface.cancelRequest(vBoostCapabilityType);
        }
        TEVBoostInterface.VBoostCapabilityType vBoostCapabilityType2 = TEVBoostInterface.VBoostCapabilityType.CPU_FREQ_MAX;
        if (TEVBoostInterface.isSupportCapability(vBoostCapabilityType2)) {
            TEVBoostInterface.cancelRequest(vBoostCapabilityType2);
        }
    }
}
