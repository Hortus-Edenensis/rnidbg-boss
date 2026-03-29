package com.zm.fissionsdk;

import com.zm.adxsdk.protocol.api.interfaces.IWfNative;
import com.zm.fissionsdk.api.interfaces.FissionConstant;
import com.zm.fissionsdk.api.interfaces.IFissionLoadManager;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ZzzW2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IFissionLoadManager.NativeLoadListener f16756a;

    public ZzzW2(IFissionLoadManager.NativeLoadListener nativeLoadListener) {
        this.f16756a = nativeLoadListener;
    }

    public void onError(int i, String str) {
        IFissionLoadManager.NativeLoadListener nativeLoadListener = this.f16756a;
        if (nativeLoadListener != null) {
            nativeLoadListener.onError(i, str);
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
                arrayList.add(new Z2V2W(iWfNative));
            }
        }
        if (arrayList.size() == 0) {
            onError(0, FissionConstant.RESPONSE_IN_VILDE);
            return;
        }
        IFissionLoadManager.NativeLoadListener nativeLoadListener = this.f16756a;
        if (nativeLoadListener != null) {
            nativeLoadListener.onLoad(arrayList);
        }
    }
}
