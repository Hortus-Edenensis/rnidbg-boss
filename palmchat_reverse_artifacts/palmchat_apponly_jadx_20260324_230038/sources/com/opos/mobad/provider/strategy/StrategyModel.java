package com.opos.mobad.provider.strategy;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.IBridgeHandler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class StrategyModel implements IBridgeHandler {
    public static final IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.opos.mobad.provider.strategy.StrategyModel.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public IBridgeHandler getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return StrategyModel.b(context);
        }
    };
    private static volatile StrategyModel b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9179a;
    private a c;

    private StrategyModel(Context context) {
        this.f9179a = context;
        this.c = new a(context);
        b();
    }

    private void c(String str) {
        d("dispatch_strategy_" + str);
    }

    private void d(String str) {
        Context context = this.f9179a;
        if (context != null && Build.VERSION.SDK_INT >= 24) {
            context.deleteSharedPreferences(str);
        }
    }

    @BridgeMethod(methodId = 3)
    public Bundle a(String str) {
        return this.c.b(str);
    }

    @BridgeMethod(methodId = 4)
    public AppInfo b(String str) {
        return this.c.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrategyModel b(Context context) {
        if (b != null) {
            return b;
        }
        synchronized (StrategyModel.class) {
            if (b == null) {
                b = new StrategyModel(context);
            }
        }
        return b;
    }

    @BridgeMethod(methodId = 5)
    public AppInfo a() {
        return this.c.a();
    }

    private void b() {
        d("dispatch_strategy");
    }

    @BridgeMethod(methodId = 2)
    public void a(String str, StrategyInfo strategyInfo) {
        this.c.a(str, strategyInfo.b, strategyInfo.f9178a);
    }

    @BridgeMethod(methodId = 1)
    public void a(String str, String str2, AppInfo appInfo) {
        c(str);
        this.c.a(str2, appInfo.b, appInfo.f9176a);
    }
}
