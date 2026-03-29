package com.zenmen.palmchat.modulemanager.module;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import com.wifi.ad.core.WifiNestAd;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.gp3;
import defpackage.ns5;
import defpackage.tu3;
import defpackage.v4;
import defpackage.v5;
import defpackage.wv3;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LXADSDKModule extends AbsModule {
    public static final AtomicBoolean isActivityInit = new AtomicBoolean(false);

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public boolean isNeedCheckPrivacyAgree() {
        return true;
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public boolean isOnlyInitOnMainProcess() {
        return true;
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationCreate(Application application) {
        LogUtil.d("", "AAAAA LXADSDKModule onApplicationCreate start");
        if (TextUtils.isEmpty(v4.e(AppContext.getContext()))) {
            return;
        }
        LogUtil.d("", "AAAAA LXADSDKModule onApplicationCreate uid done");
        v5.n();
        tu3.s(application);
    }

    @Override // com.zenmen.palmchat.modulemanager.module.AbsModule, com.zenmen.palmchat.modulemanager.module.IModule
    public void onLogin() {
        super.onLogin();
        LogUtil.d("", "AAAAA LXADSDKModule onLogin start");
        v5.n();
        tu3.s(AppContext.getContext());
    }

    @Override // com.zenmen.palmchat.modulemanager.module.AbsModule, com.zenmen.palmchat.modulemanager.module.IModule
    public void onMainTabUIReady(Activity activity) {
        super.onMainTabUIReady(activity);
        LXAdRequestInitManager.isMainTabUIReady = true;
        LogUtil.d("", "AAAAA initAd onMainTabUIReady LXAdRequestInitManager.isMainTabUIReady true ");
        AtomicBoolean atomicBoolean = isActivityInit;
        if (!atomicBoolean.get()) {
            atomicBoolean.set(true);
            LogUtil.d("", "initAd WifiNestAd.INSTANCE.initSDKActivity");
            WifiNestAd.INSTANCE.initSDKActivity(AppContext.getContext());
        }
        if (LXAdRequestInitManager.isAllowUIReadyRequestAd()) {
            wv3.e(activity);
            ns5.g(activity, true, "");
            gp3.j(activity, 1, "");
        }
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }
}
