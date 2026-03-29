package com.zenmen.palmchat.modulemanager.module;

import android.app.Application;
import cn.fly.verify.FlyVerify;
import com.zenmen.palmchat.deamon.mob.MobReportHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.b05;
import defpackage.ot0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LXMobModule extends AbsModule {
    public static final String TAG = "LXMobModule";

    private void init(Application application) {
        if (!ot0.f().c("mob", false)) {
            MobReportHelper.getInstance().reportInit(3);
            return;
        }
        LogUtil.i(TAG, "init");
        try {
            b05.d("FlyVerify.getVersion=" + FlyVerify.getVersion());
            FlyVerify.submitPolicyGrantResult(true);
            MobReportHelper.getInstance().reportInit(1);
        } catch (Exception e) {
            e.printStackTrace();
            MobReportHelper.getInstance().reportInit(2);
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
    public void onApplicationCreate(Application application) {
        init(application);
    }

    @Override // com.zenmen.palmchat.modulemanager.module.IModule
    public void onApplicationAttach(Application application) {
    }
}
