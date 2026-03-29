package com.zenmen.palmchat.modulemanager.module;

import android.app.Application;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.thirdpush.PushTokenManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ThirdPushModule extends AbsModule {
    public static final String TAG = "ThirdPushModule";

    private void checkPushTokenUpload() {
        asyncExecute("ThirdPushModulecheckPushTokenUpload", new Runnable() { // from class: com.zenmen.palmchat.modulemanager.module.ThirdPushModule.2
            @Override // java.lang.Runnable
            public void run() {
                PushTokenManager.c(AppContext.getContext());
            }
        });
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public boolean isNeedCheckPrivacyAgree() {
        return true;
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public boolean isOnlyInitOnMainProcess() {
        return true;
    }

    @Override // com.zenmen.palmchat.modulemanager.module.AbsModule, com.zenmen.palmchat.modulemanager.module.IModule
    public void onAppMove2Front() {
        super.onAppMove2Front();
        checkPushTokenUpload();
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationCreate(final Application application) {
        asyncExecute(TAG, new Runnable() { // from class: com.zenmen.palmchat.modulemanager.module.ThirdPushModule.1
            @Override // java.lang.Runnable
            public void run() {
                PushTokenManager.j(application);
            }
        });
    }

    @Override // com.zenmen.palmchat.modulemanager.module.AbsModule, com.zenmen.palmchat.modulemanager.module.IModule
    public void onLogin() {
        super.onLogin();
        checkPushTokenUpload();
    }

    @Override // com.zenmen.palmchat.modulemanager.module.AbsModule, com.zenmen.palmchat.modulemanager.module.IModule
    public void onLogout() {
        super.onLogout();
        PushTokenManager.d();
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }
}
