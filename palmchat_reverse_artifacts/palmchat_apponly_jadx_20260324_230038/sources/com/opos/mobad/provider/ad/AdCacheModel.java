package com.opos.mobad.provider.ad;

import android.content.Context;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.IBridgeHandler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class AdCacheModel implements IBridgeHandler {
    public static final IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.opos.mobad.provider.ad.AdCacheModel.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public IBridgeHandler getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return AdCacheModel.b(context.getApplicationContext());
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile AdCacheModel f9160a;
    private b b;

    private AdCacheModel(Context context) {
        this.b = new b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AdCacheModel b(Context context) {
        if (f9160a != null) {
            return f9160a;
        }
        synchronized (AdCacheModel.class) {
            if (f9160a == null) {
                f9160a = new AdCacheModel(context);
            }
        }
        return f9160a;
    }

    @BridgeMethod(methodId = 2)
    public AdEntity a(String str) {
        return this.b.a(str);
    }

    @BridgeMethod(methodId = 1)
    public void a(String str, AdEntity adEntity) {
        this.b.a(str, adEntity);
    }
}
