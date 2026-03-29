package com.zenmen.palmchat.miniwidget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.afollestad.materialdialogs.MaterialDialog;
import com.zenmen.palmchat.activity.webview.CordovaWebActivity;
import com.zenmen.palmchat.contacts.UserDetailActivity;
import com.zenmen.palmchat.contacts.UserDetailActivityV2;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.miniwidget.WidgetGuideConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.hs;
import defpackage.ir5;
import defpackage.lg6;
import defpackage.sd3;
import defpackage.t5;
import defpackage.vm0;
import defpackage.vp3;
import defpackage.vs0;
import defpackage.zn6;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {
    public static volatile a b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WidgetGuideConfig f14767a;

    /* JADX INFO: renamed from: com.zenmen.palmchat.miniwidget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C1081a extends MaterialDialog.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14768a;
        public final /* synthetic */ Activity b;
        public final /* synthetic */ WidgetGuideConfig.a c;

        public C1081a(int i, Activity activity, WidgetGuideConfig.a aVar) {
            this.f14768a = i;
            this.b = activity;
            this.c = aVar;
        }

        @Override // com.afollestad.materialdialogs.MaterialDialog.e
        public void onPositive(MaterialDialog materialDialog) {
            super.onPositive(materialDialog);
            HashMap map = new HashMap();
            map.put("type", String.valueOf(this.f14768a));
            zn6.h("widget_setting_alert", "click", map);
            if (lg6.c() || vp3.e() || Build.MANUFACTURER.equalsIgnoreCase("oppo") || Build.MODEL.contains("oppo")) {
                a.this.k(this.b);
            } else {
                a.this.a(this.b, this.c.f14766a, false);
            }
        }
    }

    public static a f() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public boolean a(Context context, int i, boolean z) {
        if (z) {
            HashMap map = new HashMap();
            map.put("type", String.valueOf(i));
            zn6.h("widget_setting_page", "view", map);
        }
        Class<? extends hs> cls = RecommendWidgetProvider.class;
        if (i != 1) {
            if (i == 2) {
                cls = ChatWidgetProvider.class;
            } else if (i == 3) {
                cls = FriendWidgetProvider.class;
            }
        }
        return b(context, cls);
    }

    @SuppressLint({"WrongConstant"})
    public final boolean b(Context context, Class<? extends hs> cls) {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        ComponentName componentName = new ComponentName(context, cls);
        if (Build.VERSION.SDK_INT < 26 || !appWidgetManager.isRequestPinAppWidgetSupported()) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        intent.addFlags(270532608);
        context.startActivity(intent);
        return appWidgetManager.requestPinAppWidget(componentName, null, PendingIntent.getBroadcast(context, 0, new Intent(context, cls), 134217728));
    }

    public boolean c(Activity activity, int i) {
        if (!h() || g() || activity == null || !i(i)) {
            return false;
        }
        l();
        j(activity, i, e().getGuideSceneConfig(i));
        return true;
    }

    public boolean d(Activity activity) {
        Class clsG;
        if (activity == null || (clsG = t5.f().g()) == null) {
            return false;
        }
        if (!clsG.equals(UserDetailActivity.class) && !clsG.equals(UserDetailActivityV2.class)) {
            return false;
        }
        LogUtil.i("LXWidgetManager", "checkNeedOpenGuideForRec start");
        return c(activity, 1);
    }

    public final WidgetGuideConfig e() {
        if (this.f14767a == null) {
            JSONObject config = vs0.a().getConfig("widget_setting_android");
            if (config != null) {
                this.f14767a = (WidgetGuideConfig) az2.a(config.toString(), WidgetGuideConfig.class);
            } else {
                this.f14767a = new WidgetGuideConfig();
            }
        }
        return this.f14767a;
    }

    public final boolean g() {
        boolean zA = SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, "key_widget_has_show", false);
        LogUtil.i("LXWidgetManager", "hasShowWidget" + zA);
        return zA;
    }

    public boolean h() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public final boolean i(int i) {
        WidgetGuideConfig widgetGuideConfigE = e();
        int i2 = widgetGuideConfigE.widget_validtime;
        int i3 = widgetGuideConfigE.widget_popwinrate;
        int i4 = widgetGuideConfigE.widget_maxtime;
        WidgetGuideConfig.a guideSceneConfig = widgetGuideConfigE.getGuideSceneConfig(i);
        boolean z = false;
        if (guideSceneConfig != null && guideSceneConfig.b) {
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
            int iF = sPUtil.f(scene, "key_widget_guide_count", 0);
            long jI = sPUtil.i(scene, "key_widget_guide_time", 0L);
            if (Math.abs(jI - ir5.b()) > ((long) (i2 * 24 * 60 * 60)) * 1000 && iF != 0) {
                sPUtil.t(scene, "key_widget_guide_count", 0);
                iF = 0;
            }
            if (iF < i4 && Math.abs(jI - ir5.b()) > ((long) (i3 * 24 * 60 * 60)) * 1000) {
                z = true;
            }
        }
        LogUtil.i("LXWidgetManager", "isNeedGuide" + i + " " + z);
        return z;
    }

    public final void j(Activity activity, int i, WidgetGuideConfig.a aVar) {
        HashMap map = new HashMap();
        map.put("type", String.valueOf(i));
        zn6.h("widget_setting_alert", "view", map);
        new sd3(activity).U(aVar.c).k(aVar.d).h(false).L("放弃").P(aVar.e).f(new C1081a(i, activity, aVar)).e().show();
    }

    public void k(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, CordovaWebActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("web_url", vm0.F);
        bundle.putBoolean("web_show_right_menu", false);
        bundle.putBoolean("hide_toolbar", true);
        bundle.putBoolean("hide_progressbar", true);
        bundle.putInt("BackgroundColor", -1);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public final void l() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        sPUtil.t(scene, "key_widget_guide_count", Integer.valueOf(sPUtil.f(scene, "key_widget_guide_count", 0) + 1));
        sPUtil.t(scene, "key_widget_guide_time", Long.valueOf(ir5.b()));
    }
}
