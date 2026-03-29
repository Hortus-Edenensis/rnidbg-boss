package com.zm.fissionsdk;

import com.zm.adxsdk.protocol.api.interfaces.IWfInterstitial;
import com.zm.fissionsdk.api.interfaces.FissionConstant;
import com.zm.fissionsdk.api.interfaces.IFissionLoadManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZW2V2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IFissionLoadManager.InterstitialLoadListener f16752a;

    public ZW2V2(IFissionLoadManager.InterstitialLoadListener interstitialLoadListener) {
        this.f16752a = interstitialLoadListener;
    }

    public void onError(int i, String str) {
        IFissionLoadManager.InterstitialLoadListener interstitialLoadListener = this.f16752a;
        if (interstitialLoadListener != null) {
            interstitialLoadListener.onError(i, str);
        }
    }

    public void onLoad(List<IWfInterstitial> list) {
        if (list == null || list.size() <= 0) {
            onError(0, FissionConstant.RESPONSE_IN_VILDE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (IWfInterstitial iWfInterstitial : list) {
            if (iWfInterstitial != null) {
                arrayList.add(new ZVWz2(iWfInterstitial));
            }
        }
        if (arrayList.size() == 0) {
            onError(0, FissionConstant.RESPONSE_IN_VILDE);
            return;
        }
        IFissionLoadManager.InterstitialLoadListener interstitialLoadListener = this.f16752a;
        if (interstitialLoadListener != null) {
            interstitialLoadListener.onLoad(arrayList);
        }
    }

    public void onMaterialCacheFailed(int i, String str) {
        IFissionLoadManager.InterstitialLoadListener interstitialLoadListener = this.f16752a;
        if (interstitialLoadListener != null) {
            interstitialLoadListener.onMaterialCacheFailed(i, str);
        }
    }

    public void onMaterialCached() {
        IFissionLoadManager.InterstitialLoadListener interstitialLoadListener = this.f16752a;
        if (interstitialLoadListener != null) {
            interstitialLoadListener.onMaterialCached();
        }
    }
}
