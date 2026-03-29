package com.zenmen.palmchat.modulemanager.module;

import android.app.Application;
import com.lantern.auth.stub.WkSDKFeature;
import defpackage.t66;
import defpackage.u93;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UserDivideModule extends AbsModule {
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
        t66.h().m("onAppMove2Front", false);
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationCreate(Application application) {
        asyncExecute("UserDivideModule_init", new Runnable() { // from class: com.zenmen.palmchat.modulemanager.module.UserDivideModule.1
            @Override // java.lang.Runnable
            public void run() {
                t66.h().l();
            }
        });
    }

    @Override // com.zenmen.palmchat.modulemanager.module.AbsModule, com.zenmen.palmchat.modulemanager.module.IModule
    public void onLogin() {
        super.onLogin();
        t66.h().m(WkSDKFeature.WHAT_LOGIN, true);
    }

    @Override // com.zenmen.palmchat.modulemanager.module.AbsModule, com.zenmen.palmchat.modulemanager.module.IModule
    public void onLogout() {
        super.onLogout();
        u93.b(2000, new Runnable() { // from class: com.zenmen.palmchat.modulemanager.module.UserDivideModule.2
            @Override // java.lang.Runnable
            public void run() {
                t66.h().m("logout", true);
            }
        });
    }

    @Override // com.zenmen.palmchat.modulemanager.module.AbsModule, com.zenmen.palmchat.modulemanager.module.IModule
    public void onNetAvailable() {
        super.onNetAvailable();
        t66.h().m("onNetAvailable", false);
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }
}
