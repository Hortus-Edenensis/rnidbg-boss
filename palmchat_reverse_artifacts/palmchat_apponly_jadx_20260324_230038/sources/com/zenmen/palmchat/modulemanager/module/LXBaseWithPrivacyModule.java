package com.zenmen.palmchat.modulemanager.module;

import android.app.Application;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LXBaseWithPrivacyModule extends AbsModule {
    public static final String TAG = "LXBaseWithPrivacyModule";

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
        asyncExecute(TAG, new Runnable() { // from class: com.zenmen.palmchat.modulemanager.module.LXBaseWithPrivacyModule.1
            @Override // java.lang.Runnable
            public void run() {
            }
        });
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }
}
