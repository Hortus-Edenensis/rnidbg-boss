package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.common.inter.LoaderSpHandlerInter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class eg implements LoaderSpHandlerInter {
    private static eg Code;
    private static final byte[] I = new byte[0];
    private static eh V;

    private eg(Context context) {
        V = eh.Code(context);
    }

    public static eg Code(Context context) {
        return V(context);
    }

    private static eg V(Context context) {
        eg egVar;
        synchronized (I) {
            if (Code == null) {
                Code = new eg(context);
            }
            egVar = Code;
        }
        return egVar;
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderSpHandlerInter
    public long getKitloaderLastCheckTime() {
        return V.aq();
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderSpHandlerInter
    public int getLoaderEngin2KitUpdate(String str) {
        return V.L(str);
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderSpHandlerInter
    public int getLoaderEngineInterval(String str) {
        return V.a(str);
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderSpHandlerInter
    public boolean getLoaderEngineUpdate(String str) {
        return V.D(str);
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderSpHandlerInter
    public void setKitloaderLastCheckTime(long j) {
        V.Z(j);
    }
}
