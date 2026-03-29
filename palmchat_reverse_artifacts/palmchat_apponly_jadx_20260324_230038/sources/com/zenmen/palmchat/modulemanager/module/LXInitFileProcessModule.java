package com.zenmen.palmchat.modulemanager.module;

import android.app.Application;
import defpackage.pu1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LXInitFileProcessModule extends AbsModule {
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
        pu1.s();
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }
}
