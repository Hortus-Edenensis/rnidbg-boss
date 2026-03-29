package com.zenmen.palmchat.modulemanager.module;

import android.app.Application;
import com.zenmen.palmchat.giftkit.a;
import defpackage.ba2;
import defpackage.vb2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class GiftModule extends AbsModule {
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
        a.a().e(new vb2());
        asyncExecute(getClass().getName(), new Runnable() { // from class: com.zenmen.palmchat.modulemanager.module.GiftModule.1
            @Override // java.lang.Runnable
            public void run() {
                ba2.a(application, false);
            }
        });
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }
}
