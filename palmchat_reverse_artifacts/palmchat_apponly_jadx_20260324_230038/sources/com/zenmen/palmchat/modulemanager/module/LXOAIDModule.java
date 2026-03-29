package com.zenmen.palmchat.modulemanager.module;

import android.app.Activity;
import android.app.Application;
import com.zenmen.palmchat.utils.MdidSdkConfigHelper;
import defpackage.z53;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LXOAIDModule extends AbsModule {
    public static final String TAG = "LXOAIDModule";
    private boolean hasInit = false;

    private void init(Application application) {
        if (this.hasInit) {
            return;
        }
        this.hasInit = true;
        MdidSdkConfigHelper.getInstance().initSdk(application);
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
    public void onAppMove2BackGround() {
        super.onAppMove2BackGround();
        if (this.hasInit) {
            MdidSdkConfigHelper.getInstance().checkOaidOnBack();
        }
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
        z53.a(TAG, "onApplicationAttach");
        System.loadLibrary(MdidSdkConfigHelper.msaoaidsec);
        init(application);
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationCreate(Application application) {
        z53.a(TAG, "onApplicationCreate");
    }

    @Override // com.zenmen.palmchat.modulemanager.module.AbsModule, com.zenmen.palmchat.modulemanager.module.IModule
    public void onMainTabUIReady(Activity activity) {
        super.onMainTabUIReady(activity);
        if (this.hasInit) {
            MdidSdkConfigHelper.getInstance().checkOaidOnMainTab();
        }
    }
}
