package com.zm.fissionsdk;

import com.zm.adxsdk.protocol.api.interfaces.IWfReward;
import com.zm.fissionsdk.api.interfaces.FissionConstant;
import com.zm.fissionsdk.api.interfaces.IFissionLoadManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class VWWVz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IFissionLoadManager.RewardVideoLoadListener f16727a;

    public VWWVz(IFissionLoadManager.RewardVideoLoadListener rewardVideoLoadListener) {
        this.f16727a = rewardVideoLoadListener;
    }

    public void onError(int i, String str) {
        IFissionLoadManager.RewardVideoLoadListener rewardVideoLoadListener = this.f16727a;
        if (rewardVideoLoadListener != null) {
            rewardVideoLoadListener.onError(i, str);
        }
    }

    public void onLoad(List<IWfReward> list) {
        if (list == null || list.size() <= 0) {
            onError(0, FissionConstant.RESPONSE_IN_VILDE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (IWfReward iWfReward : list) {
            if (iWfReward != null) {
                arrayList.add(new zVZVW(iWfReward));
            }
        }
        if (arrayList.size() == 0) {
            onError(0, FissionConstant.RESPONSE_IN_VILDE);
            return;
        }
        IFissionLoadManager.RewardVideoLoadListener rewardVideoLoadListener = this.f16727a;
        if (rewardVideoLoadListener != null) {
            rewardVideoLoadListener.onLoad(arrayList);
        }
    }

    public void onMaterialCacheFailed(int i, String str) {
        IFissionLoadManager.RewardVideoLoadListener rewardVideoLoadListener = this.f16727a;
        if (rewardVideoLoadListener != null) {
            rewardVideoLoadListener.onMaterialCacheFailed(i, str);
        }
    }

    public void onMaterialCached() {
        IFissionLoadManager.RewardVideoLoadListener rewardVideoLoadListener = this.f16727a;
        if (rewardVideoLoadListener != null) {
            rewardVideoLoadListener.onMaterialCached();
        }
    }
}
