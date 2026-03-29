package com.zm.fissionsdk;

import com.zm.adxsdk.protocol.api.interfaces.IWfSplash;
import com.zm.fissionsdk.api.interfaces.FissionConstant;
import com.zm.fissionsdk.api.interfaces.IFissionLoadManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class W2Zzz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IFissionLoadManager.SplashLoadListener f16731a;

    public W2Zzz(IFissionLoadManager.SplashLoadListener splashLoadListener) {
        this.f16731a = splashLoadListener;
    }

    public void onError(int i, String str) {
        IFissionLoadManager.SplashLoadListener splashLoadListener = this.f16731a;
        if (splashLoadListener != null) {
            splashLoadListener.onError(i, str);
        }
    }

    public void onLoad(List<IWfSplash> list) {
        if (list == null || list.size() <= 0) {
            onError(0, FissionConstant.RESPONSE_IN_VILDE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (IWfSplash iWfSplash : list) {
            if (iWfSplash != null) {
                arrayList.add(new WWV2V(iWfSplash));
            }
        }
        if (arrayList.size() == 0) {
            onError(0, FissionConstant.RESPONSE_IN_VILDE);
            return;
        }
        IFissionLoadManager.SplashLoadListener splashLoadListener = this.f16731a;
        if (splashLoadListener != null) {
            splashLoadListener.onLoad(arrayList);
        }
    }

    public void onMaterialCacheFailed(int i, String str) {
        IFissionLoadManager.SplashLoadListener splashLoadListener = this.f16731a;
        if (splashLoadListener != null) {
            splashLoadListener.onMaterialCacheFailed(i, str);
        }
    }

    public void onMaterialCached() {
        IFissionLoadManager.SplashLoadListener splashLoadListener = this.f16731a;
        if (splashLoadListener != null) {
            splashLoadListener.onMaterialCached();
        }
    }
}
