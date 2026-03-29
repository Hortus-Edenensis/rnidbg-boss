package com.zenmen.palmchat.modulemanager.module;

import android.app.Application;
import com.zenmen.palmchat.AppContext;
import defpackage.n36;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LXUMengModule extends AbsModule {
    private static final AtomicBoolean isInit = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public void checkNeedInit() {
        AtomicBoolean atomicBoolean = isInit;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        n36.b(AppContext.getContext());
    }

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
        n36.d(application);
        asyncExecute("LXUMengModule", new Runnable() { // from class: com.zenmen.palmchat.modulemanager.module.LXUMengModule.1
            @Override // java.lang.Runnable
            public void run() {
                LXUMengModule.this.checkNeedInit();
            }
        });
    }

    @Override // com.zenmen.palmchat.modulemanager.module.AbsModule, com.zenmen.palmchat.modulemanager.module.IModule
    public void onLogin() {
        super.onLogin();
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }
}
