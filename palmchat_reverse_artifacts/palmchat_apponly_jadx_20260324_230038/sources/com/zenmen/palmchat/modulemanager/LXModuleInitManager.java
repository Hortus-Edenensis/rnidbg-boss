package com.zenmen.palmchat.modulemanager;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.modulemanager.module.BatteryCanaryModule;
import com.zenmen.palmchat.modulemanager.module.GiftModule;
import com.zenmen.palmchat.modulemanager.module.IModule;
import com.zenmen.palmchat.modulemanager.module.LXADSDKModule;
import com.zenmen.palmchat.modulemanager.module.LXBaseWithoutPrivacyModule;
import com.zenmen.palmchat.modulemanager.module.LXInitFileProcessModule;
import com.zenmen.palmchat.modulemanager.module.LXJGModule;
import com.zenmen.palmchat.modulemanager.module.LXMobModule;
import com.zenmen.palmchat.modulemanager.module.LXOAIDModule;
import com.zenmen.palmchat.modulemanager.module.LXRTCModule;
import com.zenmen.palmchat.modulemanager.module.LXScreenShotModule;
import com.zenmen.palmchat.modulemanager.module.LXSpecialAttentionModule;
import com.zenmen.palmchat.modulemanager.module.LXUMengModule;
import com.zenmen.palmchat.modulemanager.module.LxCrashWhiteListModule;
import com.zenmen.palmchat.modulemanager.module.ThirdPushModule;
import com.zenmen.palmchat.modulemanager.module.UserDivideModule;
import com.zenmen.palmchat.modulemanager.module.WalletModule;
import com.zenmen.palmchat.modulemanager.module.ZMDataSDKModule;
import com.zenmen.palmchat.utils.SmidHelper;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.da3;
import defpackage.gf2;
import defpackage.gu2;
import defpackage.ir5;
import defpackage.k86;
import defpackage.v4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LXModuleInitManager {
    private static final LXModuleInitManager self = new LXModuleInitManager();
    private List<BaseModule> modules;

    /* JADX INFO: compiled from: SearchBox */
    public static class BaseModule implements IModule {
        public static final String TAG = "LXINIT_BaseModule";
        private IModule module;
        private boolean hasApplicationCreated = false;
        private boolean hasApplicationAttached = false;

        public BaseModule(IModule iModule) {
            this.module = iModule;
        }

        @Override // com.zenmen.palmchat.modulemanager.module.IModule
        public boolean isNeedCheckPrivacyAgree() {
            return this.module.isNeedCheckPrivacyAgree();
        }

        @Override // com.zenmen.palmchat.modulemanager.module.IModule
        public boolean isOnlyInitOnMainProcess() {
            return this.module.isOnlyInitOnMainProcess();
        }

        @Override // com.zenmen.palmchat.modulemanager.module.IModule
        public void onAppMove2BackGround() {
            long jB = ir5.b();
            try {
                this.module.onAppMove2BackGround();
            } catch (Throwable th) {
                th.printStackTrace();
                InitExceptionHelper.onException(InitExceptionHelper.TYPE_MODULE_ONMOVE2BACKGROUND + this.module.getClass().getName(), th);
            }
            LogUtil.i(TAG, "module name=" + this.module.getClass().getName() + " onAppMove2BackGround cost" + ir5.e(jB));
        }

        @Override // com.zenmen.palmchat.modulemanager.module.IModule
        public void onAppMove2Front() {
            long jB = ir5.b();
            try {
                this.module.onAppMove2Front();
            } catch (Throwable th) {
                th.printStackTrace();
                InitExceptionHelper.onException(InitExceptionHelper.TYPE_MODULE_ONMOVE2FRONT + this.module.getClass().getName(), th);
            }
            LogUtil.i(TAG, "module name=" + this.module.getClass().getName() + " onAppMove2Front cost" + ir5.e(jB));
        }

        @Override // com.zenmen.palmchat.modulemanager.module.IModule
        public void onApplicationAttach(Application application) {
            this.hasApplicationAttached = true;
            long jB = ir5.b();
            try {
                this.module.onApplicationAttach(application);
            } catch (Throwable th) {
                th.printStackTrace();
                InitExceptionHelper.onException(InitExceptionHelper.TYPE_MODULE_ATTACH + this.module.getClass().getName(), th);
            }
            Log.d(TAG, "module name=" + this.module.getClass().getName() + " onApplicationAttach cost" + ir5.e(jB));
        }

        @Override // com.zenmen.palmchat.modulemanager.module.IModule
        public void onApplicationCreate(Application application) {
            this.hasApplicationCreated = true;
            long jB = ir5.b();
            try {
                this.module.onApplicationCreate(application);
            } catch (Throwable th) {
                th.printStackTrace();
                InitExceptionHelper.onException(InitExceptionHelper.TYPE_MODULE_CREATE + this.module.getClass().getName(), th);
            }
            LogUtil.i(TAG, "module name=" + this.module.getClass().getName() + " onApplicationCreate cost" + ir5.e(jB));
        }

        @Override // com.zenmen.palmchat.modulemanager.module.IModule
        public void onLogin() {
            long jB = ir5.b();
            try {
                this.module.onLogin();
            } catch (Throwable th) {
                th.printStackTrace();
                InitExceptionHelper.onException(InitExceptionHelper.TYPE_MODULE_ONLOGIN + this.module.getClass().getName(), th);
            }
            LogUtil.i(TAG, "module name=" + this.module.getClass().getName() + " onLogin cost" + ir5.e(jB));
        }

        @Override // com.zenmen.palmchat.modulemanager.module.IModule
        public void onLogout() {
            long jB = ir5.b();
            try {
                this.module.onLogout();
            } catch (Throwable th) {
                th.printStackTrace();
                InitExceptionHelper.onException(InitExceptionHelper.TYPE_MODULE_ONLOGOUT + this.module.getClass().getName(), th);
            }
            LogUtil.i(TAG, "module name=" + this.module.getClass().getName() + " onLogout cost" + ir5.e(jB));
        }

        @Override // com.zenmen.palmchat.modulemanager.module.IModule
        public void onMainTabUIReady(Activity activity) {
            long jB = ir5.b();
            try {
                this.module.onMainTabUIReady(activity);
            } catch (Throwable th) {
                th.printStackTrace();
                InitExceptionHelper.onException("TYPE_MODULE_ONMAINUIREADY" + this.module.getClass().getName(), th);
            }
            LogUtil.i(TAG, "module name=" + this.module.getClass().getName() + " onMainTabUIReady cost" + ir5.e(jB));
        }

        @Override // com.zenmen.palmchat.modulemanager.module.IModule
        public void onNetAvailable() {
            long jB = ir5.b();
            try {
                this.module.onNetAvailable();
            } catch (Throwable th) {
                th.printStackTrace();
                InitExceptionHelper.onException("TYPE_MODULE_ONMAINUIREADY" + this.module.getClass().getName(), th);
            }
            LogUtil.i(TAG, "module name=" + this.module.getClass().getName() + " onNetAvailable cost" + ir5.e(jB));
        }
    }

    private LXModuleInitManager() {
        ArrayList arrayList = new ArrayList(8);
        this.modules = arrayList;
        arrayList.add(new BaseModule(new LXInitFileProcessModule()));
        this.modules.add(new BaseModule(new LXBaseWithoutPrivacyModule()));
        this.modules.add(new BaseModule(new GiftModule()));
        this.modules.add(new BaseModule(new LXScreenShotModule()));
        this.modules.add(new BaseModule(new LXMobModule()));
        this.modules.add(new BaseModule(new LXSpecialAttentionModule()));
        this.modules.add(new BaseModule(new UserDivideModule()));
        this.modules.add(new BaseModule(new BatteryCanaryModule()));
        this.modules.add(new BaseModule(new LXADSDKModule()));
        this.modules.add(new BaseModule(new LXOAIDModule()));
        this.modules.add(new BaseModule(new ThirdPushModule()));
        this.modules.add(new BaseModule(new WalletModule()));
        this.modules.add(new BaseModule(new LxCrashWhiteListModule()));
        this.modules.add(new BaseModule(new LXJGModule()));
        this.modules.add(new BaseModule(new ZMDataSDKModule()));
        this.modules.add(new BaseModule(new LXRTCModule()));
        this.modules.add(new BaseModule(new LXUMengModule()));
    }

    public static LXModuleInitManager getInstance() {
        return self;
    }

    private boolean isMainProcess(Application application) {
        String strM = k86.m(application);
        return TextUtils.isEmpty(strM) || strM.equals(application.getPackageName());
    }

    private boolean isPrivacyAgree() {
        return AppContext.getContext().isPrivacyAgreeBeforInit();
    }

    public void onAppMove2BackGround() {
        Iterator<BaseModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().onAppMove2BackGround();
        }
    }

    public void onAppMove2Front() {
        Iterator<BaseModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().onAppMove2Front();
        }
        da3.b().c();
    }

    public void onApplicationAttach(Application application) {
        for (BaseModule baseModule : this.modules) {
            if (!baseModule.hasApplicationAttached && (!baseModule.isOnlyInitOnMainProcess() || isMainProcess(application))) {
                if (!baseModule.isNeedCheckPrivacyAgree() || isPrivacyAgree()) {
                    baseModule.onApplicationAttach(application);
                }
            }
        }
    }

    public void onApplicationCreate(Application application) {
        for (BaseModule baseModule : this.modules) {
            if (!baseModule.hasApplicationCreated && (!baseModule.isOnlyInitOnMainProcess() || isMainProcess(application))) {
                if (!baseModule.isNeedCheckPrivacyAgree() || isPrivacyAgree() || !TextUtils.isEmpty(v4.e(AppContext.getContext()))) {
                    baseModule.onApplicationCreate(application);
                }
            }
        }
    }

    public void onLogin() {
        Iterator<BaseModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().onLogin();
        }
        AppStatusReporter.onAppOpen();
        SmidHelper.x(SmidHelper.SMScene.Login);
        da3.b().c();
    }

    public void onLogout() {
        Iterator<BaseModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().onLogout();
        }
        SmidHelper.w();
    }

    public void onMainTabUIReady(Activity activity) {
        Iterator<BaseModule> it = this.modules.iterator();
        while (it.hasNext()) {
            it.next().onMainTabUIReady(activity);
        }
        gu2.h();
    }

    public void onPrivacyAgree(Application application) {
        for (BaseModule baseModule : this.modules) {
            if (!baseModule.hasApplicationAttached) {
                baseModule.onApplicationAttach(application);
            }
            if (!baseModule.hasApplicationCreated) {
                baseModule.onApplicationCreate(application);
            }
        }
        gf2.g();
    }

    public void onNetAvailable() {
    }
}
