package com.zenmen.palmchat.modulemanager.module;

import android.app.Application;
import defpackage.ms;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BatteryCanaryModule extends AbsModule {
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
        ms.c(application);
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }
}
