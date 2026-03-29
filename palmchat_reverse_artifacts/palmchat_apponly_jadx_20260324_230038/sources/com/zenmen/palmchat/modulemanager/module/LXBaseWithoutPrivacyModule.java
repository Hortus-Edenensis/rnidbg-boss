package com.zenmen.palmchat.modulemanager.module;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.chat.ChatBreakHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.palmchat.webplatform.b;
import com.zenmen.square.support.SquareSingleton;
import defpackage.ac1;
import defpackage.di6;
import defpackage.ec3;
import defpackage.ot0;
import defpackage.r75;
import defpackage.s34;
import defpackage.wm;
import defpackage.y63;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LXBaseWithoutPrivacyModule extends AbsModule {
    public static final String TAG = "LXBaseWithoutPrivacyModule";

    /* JADX INFO: Access modifiers changed from: private */
    public void initLastVersionCode() {
        String strI = r75.i(AppContext.getContext(), "sp_current_version_code");
        String str = ac1.f;
        if (!TextUtils.equals(strI, str)) {
            r75.r(AppContext.getContext(), "sp_current_version_code", str);
        }
        if (TextUtils.isEmpty(strI)) {
            r75.r(AppContext.getContext(), "sp_last_version_code", "0");
        } else {
            String strI2 = r75.i(AppContext.getContext(), "sp_last_version_code");
            if (!TextUtils.equals(strI, str) || TextUtils.isEmpty(strI2)) {
                r75.r(AppContext.getContext(), "sp_last_version_code", strI);
            }
        }
        LogUtil.i(TAG, "initLastVersionCode    currentVersionCode = " + str + "; versionCode = " + strI);
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
        asyncExecute(TAG, new Runnable() { // from class: com.zenmen.palmchat.modulemanager.module.LXBaseWithoutPrivacyModule.1
            @Override // java.lang.Runnable
            public void run() {
                ec3.j().y(application, "update_type_app_create");
                b.n().r(new b.d() { // from class: com.zenmen.palmchat.modulemanager.module.LXBaseWithoutPrivacyModule.1.1
                    @Override // com.zenmen.palmchat.webplatform.b.d
                    public boolean canUpdateWhenNotBuiltIn() {
                        return true;
                    }
                });
                wm.c().g(application);
                LXBaseWithoutPrivacyModule.this.initLastVersionCode();
                s34.h();
                di6.d(application);
                SquareSingleton.getInstance().onAppCreate();
                ChatBreakHelper.q().A(false);
                ot0.f().k();
            }
        });
    }

    @Override // com.zenmen.palmchat.modulemanager.module.AbsModule, com.zenmen.palmchat.modulemanager.module.IModule
    public void onMainTabUIReady(Activity activity) {
        super.onMainTabUIReady(activity);
        asyncExecute("LXBaseWithoutPrivacyModuleonMainTabUIReady", new Runnable() { // from class: com.zenmen.palmchat.modulemanager.module.LXBaseWithoutPrivacyModule.2
            @Override // java.lang.Runnable
            public void run() {
                y63.C(false);
                y63.B(false, AccountUtils.p(AppContext.getContext()), null);
            }
        });
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }
}
