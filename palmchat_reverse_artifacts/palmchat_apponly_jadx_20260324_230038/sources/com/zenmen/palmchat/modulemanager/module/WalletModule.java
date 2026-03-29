package com.zenmen.palmchat.modulemanager.module;

import android.app.Application;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class WalletModule extends AbsModule {
    public static final String TAG = "WalletModule";

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public boolean isNeedCheckPrivacyAgree() {
        return true;
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public boolean isOnlyInitOnMainProcess() {
        return true;
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationCreate(Application application) {
    }
}
