package com.zenmen.palmchat.modulemanager.module;

import android.app.Activity;
import android.app.Application;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public interface IModule {
    boolean isNeedCheckPrivacyAgree();

    boolean isOnlyInitOnMainProcess();

    void onAppMove2BackGround();

    void onAppMove2Front();

    void onApplicationAttach(Application application);

    void onApplicationCreate(Application application);

    void onLogin();

    void onLogout();

    void onMainTabUIReady(Activity activity);

    void onNetAvailable();
}
