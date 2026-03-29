package com.zenmen.palmchat.modulemanager.lifecircle;

import android.app.Activity;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.MainTabsActivity;
import com.zenmen.palmchat.Vo.DaemonConfig;
import com.zenmen.palmchat.daemon.WakeActivity;
import com.zenmen.palmchat.database.DBUriManager;
import com.zenmen.palmchat.database.b;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.d;
import com.zenmen.palmchat.modulemanager.TaskExecutorHelper;
import com.zenmen.palmchat.modulemanager.module.LXAdRequestInitManager;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.vip.a;
import defpackage.dg2;
import defpackage.gp3;
import defpackage.ir5;
import defpackage.k86;
import defpackage.ly4;
import defpackage.ns5;
import defpackage.p05;
import defpackage.q42;
import defpackage.qu3;
import defpackage.r75;
import defpackage.r92;
import defpackage.rl0;
import defpackage.rp3;
import defpackage.rq4;
import defpackage.ux3;
import defpackage.vm0;
import defpackage.wv3;
import defpackage.yb0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class MainTabLifeCircleCallback implements LifeCircleCallback {

    /* JADX INFO: renamed from: com.zenmen.palmchat.modulemanager.lifecircle.MainTabLifeCircleCallback$3, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUpdateUser() {
        if (SPUtil.f14322a.i(SPUtil.SCENE.CONTACT, k86.a("key_inited_time"), -1L) == -1 || r75.d(AppContext.getContext(), "update_user", false)) {
            Log.d("logcontact", "checkUpdateUser");
            r75.o(AppContext.getContext(), "update_user", false);
            new r92().n();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkUploadContactDialog() {
        SPUtil.f14322a.t(SPUtil.SCENE.CONTACT, k86.a("key_contact_one_key_recommend_friend_switch"), Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveFirstShowTime() {
        if (r75.h(AppContext.getContext(), k86.a("is_first_show_home")) == 0 && r75.d(AppContext.getContext(), k86.a("is_first_login"), false)) {
            r75.q(AppContext.getContext(), k86.a("is_first_show_home"), System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadMsgCount() {
        String strA = k86.a("uploadUserMsgCount");
        if (Math.abs(r75.h(AppContext.getContext(), strA) - ir5.b()) > 432000000) {
            r75.q(AppContext.getContext(), strA, ir5.b());
            int iR = b.r(DBUriManager.MsgSaveType.COMMON);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("count", iR);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            LogUtil.onEvent(LogUtil.LogType.LOG_TYPE_MESSAGE_COMMON, null, "Msg0", null, null, jSONObject.toString());
        }
    }

    @Override // com.zenmen.palmchat.modulemanager.lifecircle.LifeCircleCallback
    public boolean filter(Activity activity) {
        return activity instanceof MainTabsActivity;
    }

    @Override // com.zenmen.palmchat.modulemanager.lifecircle.LifeCircleCallback
    public void onStatusChange(final Activity activity, Lifecycle.Event event) {
        int i = AnonymousClass3.$SwitchMap$androidx$lifecycle$Lifecycle$Event[event.ordinal()];
        if (i == 1) {
            TaskExecutorHelper.safeRun(MainTabLifeCircleCallback.class.getName() + event, new Runnable() { // from class: com.zenmen.palmchat.modulemanager.lifecircle.MainTabLifeCircleCallback.1
                @Override // java.lang.Runnable
                public void run() throws Throwable {
                    if (a.c().e() == null) {
                        a.c().f();
                    }
                    if (!LXAdRequestInitManager.isAllowUIReadyRequestAd()) {
                        LogUtil.d("LXAdRequestInitManager", "MainTabLifeCircleCallback isAllowUIReadyRequestAd false 提前请求:");
                        wv3.e(activity);
                        ns5.g(activity, true, "");
                        gp3.j(activity, 1, "");
                    }
                    MainTabLifeCircleCallback.this.checkUploadContactDialog();
                    if (!com.zenmen.palmchat.utils.a.E().R()) {
                        com.zenmen.palmchat.utils.a.E().s();
                    }
                    MainTabLifeCircleCallback.this.saveFirstShowTime();
                    DaemonConfig.m();
                    LogUtil.uploadInfoImmediate("ar05", null, null, DaemonConfig.b(AppContext.getContext()));
                    MainTabLifeCircleCallback.this.checkUpdateUser();
                    WakeActivity.c();
                    DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.KDY_FLOWCONTROL);
                    if (dynamicConfig != null && dynamicConfig.isEnable() && dynamicConfig.getExtra() != null) {
                        q42.d(dynamicConfig.getExtra());
                    }
                    q42.e(vm0.f1);
                    MainTabLifeCircleCallback.this.uploadMsgCount();
                    com.zenmen.palmchat.pullwake.pulldialog.a.b().e(false);
                    yb0.a().c("onMainCreate");
                }
            });
            return;
        }
        if (i == 2) {
            rp3.f().b();
        } else {
            if (i != 3) {
                return;
            }
            TaskExecutorHelper.safeRun(MainTabLifeCircleCallback.class.getName() + event, new Runnable() { // from class: com.zenmen.palmchat.modulemanager.lifecircle.MainTabLifeCircleCallback.2
                @Override // java.lang.Runnable
                public void run() {
                    ux3.h().f();
                    dg2.f().i();
                    if (!p05.c()) {
                        rq4.l().w();
                    }
                    qu3.c(d.g().h());
                    ly4.d().p("Main_ON_RESUME");
                }
            });
        }
    }
}
