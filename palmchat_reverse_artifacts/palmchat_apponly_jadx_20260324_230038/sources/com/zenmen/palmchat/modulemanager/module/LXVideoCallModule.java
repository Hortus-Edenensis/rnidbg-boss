package com.zenmen.palmchat.modulemanager.module;

import android.app.Activity;
import android.app.Application;
import defpackage.pa6;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LXVideoCallModule extends AbsModule {
    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public boolean isNeedCheckPrivacyAgree() {
        return true;
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public boolean isOnlyInitOnMainProcess() {
        return true;
    }

    @Override // com.zenmen.palmchat.modulemanager.module.AbsModule, com.zenmen.palmchat.modulemanager.module.IModule
    public void onMainTabUIReady(Activity activity) {
        super.onMainTabUIReady(activity);
        pa6.p().x();
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationCreate(Application application) {
    }
}
