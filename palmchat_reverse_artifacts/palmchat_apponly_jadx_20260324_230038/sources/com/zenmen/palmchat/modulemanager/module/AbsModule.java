package com.zenmen.palmchat.modulemanager.module;

import android.app.Activity;
import com.zenmen.palmchat.modulemanager.IAsyncExecutor;
import com.zenmen.palmchat.modulemanager.TaskExecutorHelper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class AbsModule implements IModule, IAsyncExecutor {
    public static final String TAG = "AbsModule";

    @Override // com.zenmen.palmchat.modulemanager.IAsyncExecutor
    public final void asyncExecute(String str, Runnable runnable) {
        TaskExecutorHelper.safeRun(str, runnable);
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onMainTabUIReady(Activity activity) {
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onAppMove2BackGround() {
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onAppMove2Front() {
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onLogin() {
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onLogout() {
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onNetAvailable() {
    }
}
