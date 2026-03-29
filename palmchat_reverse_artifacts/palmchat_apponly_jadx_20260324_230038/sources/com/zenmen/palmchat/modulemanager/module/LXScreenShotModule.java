package com.zenmen.palmchat.modulemanager.module;

import android.app.Application;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import defpackage.v35;
import defpackage.v4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LXScreenShotModule extends AbsModule {
    private boolean hasInit = false;

    private void initModule() {
        if (this.hasInit) {
            return;
        }
        this.hasInit = true;
        v35.f().h();
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
        if (TextUtils.isEmpty(v4.e(AppContext.getContext()))) {
            return;
        }
        initModule();
    }

    @Override // com.zenmen.palmchat.modulemanager.module.AbsModule, com.zenmen.palmchat.modulemanager.module.IModule
    public void onLogin() {
        super.onLogin();
        if (TextUtils.isEmpty(v4.e(AppContext.getContext()))) {
            return;
        }
        initModule();
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }
}
