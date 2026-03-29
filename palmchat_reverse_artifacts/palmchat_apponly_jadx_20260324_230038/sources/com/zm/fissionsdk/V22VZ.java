package com.zm.fissionsdk;

import com.zm.adxsdk.protocol.api.interfaces.IWfNative;
import com.zm.fissionsdk.api.interfaces.FissionConstant;
import com.zm.fissionsdk.api.interfaces.IFissionLoadManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class V22VZ {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IFissionLoadManager.DrawLoadListener f16723a;

    public V22VZ(IFissionLoadManager.DrawLoadListener drawLoadListener) {
        this.f16723a = drawLoadListener;
    }

    public void onError(int i, String str) {
        IFissionLoadManager.DrawLoadListener drawLoadListener = this.f16723a;
        if (drawLoadListener != null) {
            drawLoadListener.onError(i, str);
        }
    }

    public void onLoad(List<IWfNative> list) {
        if (list == null || list.size() <= 0) {
            onError(0, FissionConstant.RESPONSE_IN_VILDE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (IWfNative iWfNative : list) {
            if (iWfNative != null) {
                arrayList.add(new zzV2V(iWfNative));
            }
        }
        if (arrayList.size() == 0) {
            onError(0, FissionConstant.RESPONSE_IN_VILDE);
            return;
        }
        IFissionLoadManager.DrawLoadListener drawLoadListener = this.f16723a;
        if (drawLoadListener != null) {
            drawLoadListener.onLoad(arrayList);
        }
    }
}
