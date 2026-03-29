package com.zenmen.palmchat.modulemanager.module;

import android.app.Application;
import android.text.TextUtils;
import cn.jiguang.api.JCoreInterface;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.jiguang.JKeepLiveReportHelper;
import defpackage.ac1;
import defpackage.n44;
import defpackage.ot0;
import defpackage.v4;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LXJGModule extends AbsModule {
    private static final AtomicBoolean isInit = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: private */
    public void initJiguang(Application application) {
        AtomicBoolean atomicBoolean = isInit;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        if (!ot0.f().b("jiguang")) {
            JKeepLiveReportHelper.getInstance().reportInit(3);
            return;
        }
        if (ac1.G()) {
            return;
        }
        try {
            JCoreInterface.setDebugMode(n44.m());
            JCoreInterface.init(application.getApplicationContext());
            JKeepLiveReportHelper.getInstance().reportInit(1);
        } catch (Throwable unused) {
            JKeepLiveReportHelper.getInstance().reportInit(2);
        }
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
    public void onApplicationCreate(final Application application) {
        asyncExecute("LXJGModule", new Runnable() { // from class: com.zenmen.palmchat.modulemanager.module.LXJGModule.1
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(v4.e(AppContext.getContext()))) {
                    return;
                }
                LXJGModule.this.initJiguang(application);
            }
        });
    }

    @Override // com.zenmen.palmchat.modulemanager.module.AbsModule, com.zenmen.palmchat.modulemanager.module.IModule
    public void onLogin() {
        super.onLogin();
        asyncExecute("LXJGModule", new Runnable() { // from class: com.zenmen.palmchat.modulemanager.module.LXJGModule.2
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(v4.e(AppContext.getContext()))) {
                    return;
                }
                LXJGModule.this.initJiguang(AppContext.getContext());
            }
        });
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }
}
