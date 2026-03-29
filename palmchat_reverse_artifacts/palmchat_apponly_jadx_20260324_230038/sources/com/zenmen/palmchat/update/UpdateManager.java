package com.zenmen.palmchat.update;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.lantern.auth.app.WkConstants;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.chat.ChatterActivity;
import com.zenmen.palmchat.daemon.WakeActivity;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.login.AdSplaseActivity;
import com.zenmen.palmchat.modulemanager.TaskExecutorHelper;
import com.zenmen.palmchat.update.b;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.ch;
import defpackage.hx3;
import defpackage.ir5;
import defpackage.pu1;
import defpackage.r75;
import defpackage.rb3;
import defpackage.sd3;
import defpackage.sy5;
import defpackage.sz3;
import defpackage.vs0;
import defpackage.xk5;
import defpackage.zn6;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class UpdateManager implements b.a {
    public static long A = 28800000;
    public static long B = 300000;
    public static long C = 172800000;
    public static long D = 3600000;
    public static final String y = "UpdateManager";
    public static UpdateManager z;
    public com.zenmen.palmchat.update.b b;
    public RemoteViews c;
    public PendingIntent d;
    public NotificationManager e;
    public Notification f;
    public ProgressBar g;
    public TextView h;
    public MaterialDialog i;
    public TimerTask j;
    public Timer k;
    public int l;
    public boolean m;
    public UpdateInfo n;
    public Context p;
    public SharedPreferences q;
    public boolean s;
    public boolean t;
    public int u;
    public BroadcastReceiver v;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UpdateScene f15666a = null;
    public Object o = new Object();
    public boolean r = false;
    public boolean w = false;
    public boolean x = false;

    /* JADX INFO: compiled from: SearchBox */
    public enum UpdateScene {
        AUTO_CHECK(1),
        USER_CLICK(2),
        LOGIN_FORBIDDEN(4),
        FUNCTION_FORBIDDEN(5);

        private int code;

        UpdateScene(int i) {
            this.code = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            UpdateManager.this.x();
            UpdateManager.this.x = false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UpdateInfo f15668a;

        public b(UpdateInfo updateInfo) {
            this.f15668a = updateInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UpdateManager.this.L(this.f15668a);
            UpdateManager.this.Q(this.f15668a);
            if (UpdateManager.this.t) {
                UpdateManager.this.h.setText(R.string.update_downloading);
                UpdateManager.this.h.setEnabled(false);
                UpdateManager.this.g.setVisibility(0);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UpdateInfo f15669a;

        public c(UpdateInfo updateInfo) {
            this.f15669a = updateInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UpdateManager.this.K(this.f15669a);
            UpdateManager.this.O(this.f15669a);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f15670a;
        public final /* synthetic */ UpdateInfo b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
                super.onNegative(materialDialog);
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                d dVar = d.this;
                UpdateManager.this.K(dVar.b);
                UpdateManager.this.D();
            }
        }

        public d(Activity activity, UpdateInfo updateInfo) {
            this.f15670a = activity;
            this.b = updateInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new sd3(this.f15670a).T(R.string.update_install_dialog_title).j(R.string.update_stop_install).M(AppContext.getContext().getResources().getColor(R.color.material_dialog_positive_color)).O(R.string.update_cancel_yes).K(R.string.update_cancel_no).f(new a()).h(false).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f15672a;
        public final /* synthetic */ UpdateInfo b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
                super.onNegative(materialDialog);
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                e eVar = e.this;
                UpdateManager.this.K(eVar.b);
                UpdateManager.this.D();
            }
        }

        public e(Activity activity, UpdateInfo updateInfo) {
            this.f15672a = activity;
            this.b = updateInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new sd3(this.f15672a).T(R.string.update_install_dialog_title).j(R.string.update_stop_install).O(R.string.update_cancel_yes).M(AppContext.getContext().getResources().getColor(R.color.material_dialog_positive_color)).K(R.string.update_cancel_no).f(new a()).h(false).e().show();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f15674a;
        public final /* synthetic */ UpdateInfo b;

        /* JADX INFO: compiled from: SearchBox */
        public class a extends MaterialDialog.e {
            public a() {
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onNegative(MaterialDialog materialDialog) {
                super.onNegative(materialDialog);
            }

            @Override // com.afollestad.materialdialogs.MaterialDialog.e
            public void onPositive(MaterialDialog materialDialog) {
                f fVar = f.this;
                UpdateManager.this.K(fVar.b);
                UpdateManager.this.t = false;
                UpdateManager.this.b.b(f.this.b);
                UpdateManager.this.D();
                UpdateManager.this.z();
            }
        }

        public f(Activity activity, UpdateInfo updateInfo) {
            this.f15674a = activity;
            this.b = updateInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (UpdateManager.this.t) {
                new sd3(this.f15674a).T(R.string.update_install_dialog_title).j(R.string.update_stop_download).O(R.string.dialog_confirm).M(AppContext.getContext().getResources().getColor(R.color.material_dialog_positive_color)).K(R.string.alert_dialog_cancel).f(new a()).h(false).e().show();
            } else {
                UpdateManager.this.K(this.b);
                UpdateManager.this.D();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UpdateInfo f15676a;

        public g(UpdateInfo updateInfo) {
            this.f15676a = updateInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UpdateManager.this.L(this.f15676a);
            UpdateManager.this.Q(this.f15676a);
            if (!UpdateManager.this.t || UpdateManager.this.w) {
                return;
            }
            UpdateManager.this.h.setText(R.string.update_downloading);
            UpdateManager.this.g.setVisibility(0);
            UpdateManager.this.h.setEnabled(false);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class h extends BroadcastReceiver {
        public h() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            UpdateManager.this.f = null;
            UpdateManager updateManager = UpdateManager.this;
            updateManager.Q(updateManager.H());
            if (UpdateManager.this.v != null) {
                UpdateManager.this.p.unregisterReceiver(UpdateManager.this.v);
                UpdateManager.this.v = null;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15678a;

        public i(int i) {
            this.f15678a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (UpdateManager.this.g == null || UpdateManager.this.h == null) {
                return;
            }
            UpdateManager.this.g.setProgress(this.f15678a);
            UpdateManager.this.h.setText(AppContext.getContext().getString(R.string.update_downloading) + this.f15678a + "%");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class j extends TimerTask {
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LogUtil.d(UpdateManager.y, "update: " + String.valueOf(UpdateManager.this.l));
            if (Math.abs(UpdateManager.this.l) > 100) {
                return;
            }
            UpdateManager updateManager = UpdateManager.this;
            updateManager.c0(updateManager.l);
        }

        public j() {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static HashMap<String, UpdateScene> f15680a = new a();

        /* JADX INFO: compiled from: SearchBox */
        public class a extends HashMap<String, UpdateScene> {
            public a() {
                UpdateScene updateScene = UpdateScene.LOGIN_FORBIDDEN;
                put(WkConstants.LxLoginConst.API_AUTH_AUTO, updateScene);
                put(WkConstants.LxLoginConst.API_SEND_SMS, updateScene);
                put(WkConstants.LxLoginConst.API_COMMIT_SMS, updateScene);
                put(WkConstants.LxLoginConst.API_AUTH_TOKEN, updateScene);
                put("user/v3/update.json", UpdateScene.FUNCTION_FORBIDDEN);
            }
        }

        public static void a(String str, String str2) {
            UpdateScene updateSceneB;
            if (str == null || str2 == null || (updateSceneB = b(str)) == null || !c(str2)) {
                return;
            }
            LogUtil.i("OldClientChecker", "url=" + str + " response=" + str2 + " UpdateScene=" + updateSceneB);
            UpdateManager.G().a0(updateSceneB);
        }

        public static UpdateScene b(String str) {
            UpdateScene updateScene = UpdateScene.FUNCTION_FORBIDDEN;
            for (String str2 : f15680a.keySet()) {
                if (str.contains(str2)) {
                    return f15680a.get(str2);
                }
            }
            return updateScene;
        }

        public static boolean c(String str) {
            try {
                return new JSONObject(str).optInt("resultCode") == 1136;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    public UpdateManager() {
        AppContext context = AppContext.getContext();
        this.p = context;
        this.q = PreferenceManager.getDefaultSharedPreferences(context);
        com.zenmen.palmchat.update.a aVar = new com.zenmen.palmchat.update.a(this.p);
        this.b = aVar;
        aVar.c(this);
    }

    public static String A(Context context) {
        NotificationManager notificationManager;
        if (Build.VERSION.SDK_INT >= 26 && (notificationManager = (NotificationManager) context.getSystemService("notification")) != null && notificationManager.getNotificationChannel("NOTIFICATION_CHANNEL_UPDATE") == null) {
            String string = context.getString(R.string.string_notify_channel_name_update);
            String string2 = context.getString(R.string.string_notify_channel_des);
            NotificationChannel notificationChannelA = sz3.a("NOTIFICATION_CHANNEL_UPDATE", string, 4);
            notificationChannelA.setDescription(string2);
            notificationChannelA.enableVibration(false);
            notificationChannelA.enableLights(false);
            notificationChannelA.setSound(null, null);
            notificationChannelA.setLockscreenVisibility(1);
            notificationManager.createNotificationChannel(notificationChannelA);
        }
        return "NOTIFICATION_CHANNEL_UPDATE";
    }

    public static UpdateManager G() {
        if (z == null) {
            z = new UpdateManager();
        }
        return z;
    }

    public final void B(File file) {
        try {
            file.delete();
        } catch (SecurityException e2) {
            e2.printStackTrace();
        }
    }

    public final void C() {
        MaterialDialog materialDialog = this.i;
        if (materialDialog != null && materialDialog.isShowing()) {
            try {
                this.i.dismiss();
            } catch (Exception unused) {
            }
        }
        S();
    }

    public final void D() {
        try {
            MaterialDialog materialDialog = this.i;
            if (materialDialog != null) {
                materialDialog.dismiss();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        S();
    }

    public final long E() {
        long j2 = A;
        JSONObject config = vs0.a().getConfig("update_checkt");
        if (config == null) {
            return j2;
        }
        long jOptLong = config.optLong("interval_time", 0L);
        return jOptLong > 0 ? 1000 * jOptLong : j2;
    }

    public final int F(long j2, long j3) {
        long j4 = j3 - j2;
        if (j4 < 86400000 && j3 >= j2) {
            return 1;
        }
        if (j4 >= 172800000 || j3 < j2) {
            return (j4 >= 259200000 || j3 < j2) ? -1 : 3;
        }
        return 2;
    }

    public UpdateInfo H() {
        UpdateInfo updateInfo;
        UpdateInfo updateInfo2 = new UpdateInfo();
        String string = this.q.getString("key_update_info_json", "");
        return (TextUtils.isEmpty(string) || (updateInfo = (UpdateInfo) az2.a(string, UpdateInfo.class)) == null) ? updateInfo2 : updateInfo;
    }

    public final void I(File file) {
        LogUtil.i(y, "installAPK file=" + file);
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            if (Build.VERSION.SDK_INT < 24) {
                intent.setDataAndType(Uri.fromFile(file), AdBaseConstants.MIME_APK);
            } else {
                intent.setDataAndType(FileProvider.getUriForFile(this.p, "com.zenmen.palmchat.webplatform.file.provider", file), AdBaseConstants.MIME_APK);
                intent.addFlags(3);
            }
            intent.addFlags(268435456);
            this.p.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("updateInstall", null, null, null);
    }

    public boolean J() {
        return hx3.n();
    }

    public final void K(UpdateInfo updateInfo) {
        if (updateInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            UpdateScene updateScene = this.f15666a;
            if (updateScene != null) {
                jSONObject.put("from", updateScene.code);
            }
            jSONObject.put("type", updateInfo.updateType == UpdateInfo.TYPE_FORCE ? "force" : "noforce");
            jSONObject.put("ver", AppInfo.getVersionCode(this.p));
            String str = updateInfo.channel;
            if (str == null) {
                str = "";
            }
            jSONObject.put("channel", str);
            jSONObject.put("up_ver", updateInfo.vcode);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.f("lx_versionupgrade_popclose", "click", jSONObject);
    }

    public final void L(UpdateInfo updateInfo) {
        if (updateInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            UpdateScene updateScene = this.f15666a;
            if (updateScene != null) {
                jSONObject.put("from", updateScene.code);
            }
            jSONObject.put("type", updateInfo.updateType == UpdateInfo.TYPE_FORCE ? "force" : "noforce");
            jSONObject.put("ver", AppInfo.getVersionCode(this.p));
            String str = updateInfo.channel;
            if (str == null) {
                str = "";
            }
            jSONObject.put("channel", str);
            jSONObject.put("up_ver", updateInfo.vcode);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.f("lx_versionupgrade_poplick", "click", jSONObject);
    }

    public final void M(UpdateInfo updateInfo) {
        if (updateInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            UpdateScene updateScene = this.f15666a;
            if (updateScene != null) {
                jSONObject.put("from", updateScene.code);
            }
            jSONObject.put("type", updateInfo.updateType == UpdateInfo.TYPE_FORCE ? "force" : "noforce");
            jSONObject.put("ver", AppInfo.getVersionCode(this.p));
            String str = updateInfo.channel;
            if (str == null) {
                str = "";
            }
            jSONObject.put("channel", str);
            jSONObject.put("up_ver", updateInfo.vcode);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        zn6.f("lx_versionupgrade_popshow", "view", jSONObject);
    }

    public final boolean N(String str, File file) throws Throwable {
        if (!file.exists()) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            B(file);
            return false;
        }
        String strB = rb3.b(file);
        if (!TextUtils.isEmpty(strB) && strB.equals(str)) {
            return true;
        }
        B(file);
        return false;
    }

    public void O(UpdateInfo updateInfo) {
        if (updateInfo.updateType == UpdateInfo.TYPE_FORCE) {
            C();
            AppContext.getContext().exitApp();
        }
    }

    public final void P(UpdateInfo updateInfo) {
        LogUtil.i(y, "onCheckFinished");
        if (updateInfo.vcode <= AppInfo.getVersionCode(this.p)) {
            return;
        }
        if (N(updateInfo.pmd5, new File(pu1.r(updateInfo.vname)))) {
            this.r = false;
            ch.s().K0(1, true);
            return;
        }
        if (!this.w || !J() || updateInfo.updateType != UpdateInfo.TYPE_SELECT) {
            if (updateInfo.updateType != UpdateInfo.TYPE_DELAY) {
                this.r = false;
                ch.s().K0(1, true);
                return;
            }
            return;
        }
        if (this.t && updateInfo.vcode == this.u) {
            return;
        }
        this.r = true;
        this.t = true;
        this.u = updateInfo.vcode;
        this.b.c(this);
        this.b.a(updateInfo);
    }

    public void Q(UpdateInfo updateInfo) {
        LogUtil.i(y, "onOkClick");
        if (updateInfo.vcode <= AppInfo.getVersionCode(this.p)) {
            return;
        }
        File file = new File(pu1.r(updateInfo.vname));
        if (file.exists()) {
            I(file);
            return;
        }
        if (!this.t || updateInfo.vcode != this.u) {
            if (!new File(pu1.p(updateInfo.vname)).exists()) {
                this.l = 0;
            }
            this.t = true;
            this.u = updateInfo.vcode;
            this.b.c(this);
            this.b.a(updateInfo);
        } else if (hx3.m(this.p)) {
            sy5.e(this.p, R.string.update_running, 0).g();
        } else {
            sy5.e(this.p, R.string.default_response_error, 0).g();
        }
        if (this.f == null) {
            W();
        }
    }

    public void R() {
        if (this.x) {
            w();
        }
    }

    public final void S() {
        this.g = null;
        this.i = null;
    }

    public final void T() {
        this.q.edit().putLong("tray_preference_update_dot_time", 0L).apply();
        this.q.edit().putString("system_preference_mine_dot", "0").apply();
        this.q.edit().putString("system_preference_about_zx", "0").apply();
        ch.s().B0();
    }

    public void U(boolean z2) {
        synchronized (this.o) {
            this.m = z2;
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void V() {
        Context context = this.p;
        if (this.v == null) {
            this.v = new h();
            this.p.registerReceiver(this.v, new IntentFilter("action_youni_update_download_fail"));
        }
        this.e = (NotificationManager) context.getSystemService("notification");
        z();
        Notification notificationBuild = new NotificationCompat.Builder(context, A(this.p)).setAutoCancel(true).setContentTitle(context.getString(R.string.app_name)).setContentText(context.getString(R.string.update_download_fail)).setContentIntent(PendingIntent.getBroadcast(context, 0, new Intent("action_youni_update_download_fail"), 134217728)).setSmallIcon(R.drawable.ic_launcher).setWhen(System.currentTimeMillis()).setOngoing(true).build();
        this.f = notificationBuild;
        notificationBuild.tickerText = context.getString(R.string.update_download_fail);
        Notification notification = this.f;
        notification.flags = 16;
        this.e.notify(16, notification);
        ((Vibrator) context.getSystemService("vibrator")).vibrate(200L);
    }

    public final void W() {
        Context context = this.p;
        this.e = (NotificationManager) context.getSystemService("notification");
        z();
        this.c = new RemoteViews(context.getPackageName(), R.layout.update_remote);
        this.d = PendingIntent.getService(context, 0, new Intent(context, (Class<?>) Notification.class), 134217728);
        this.f = new NotificationCompat.Builder(context, A(this.p)).setAutoCancel(true).setSmallIcon(android.R.drawable.stat_sys_download).setOngoing(true).build();
        this.c.setImageViewResource(R.id.update_image, R.drawable.ic_launcher);
        Timer timer = this.k;
        if (timer != null) {
            timer.cancel();
        }
        this.k = new Timer();
        j jVar = new j();
        this.j = jVar;
        this.k.schedule(jVar, 0L, 2000L);
    }

    public final boolean X(UpdateInfo updateInfo) {
        Class<WakeActivity> cls;
        try {
            cls = WakeActivity.class;
            int i2 = WakeActivity.b;
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            cls = null;
        }
        if (cls != null) {
            LogUtil.d("logupdate", "wake founded, return");
            return false;
        }
        long j2 = this.q.getLong("last_select_dialog_show_time", 0L);
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.UPDATE;
        long jI = sPUtil.i(scene, updateInfo.vcode + "first_check_time", 0L);
        int iF = sPUtil.f(scene, "last_select_dialog_show_count", 0);
        long jC = ir5.c(false);
        LogUtil.d("logupdate", "firstCheckTime = " + jI);
        LogUtil.d("logupdate", "lastShowTime = " + j2);
        LogUtil.d("logupdate", "lastShowCount = " + iF);
        LogUtil.d("logupdate", "curTime = " + jC);
        long j3 = j2 > jC ? 0L : j2;
        if (jC - j3 < D) {
            LogUtil.d("logupdate", "< 1 hour, return");
            return false;
        }
        int iF2 = F(jI, jC);
        int iF3 = F(jI, j3);
        if (iF2 == 1) {
            if (iF3 != iF2) {
                iF = 0;
            } else if (iF < 1) {
                iF = 1;
            }
            if (iF >= 2) {
                LogUtil.d("logupdate", "count >= 2, return");
                return false;
            }
            this.q.edit().putLong("last_select_dialog_show_time", jC).apply();
            sPUtil.t(scene, "last_select_dialog_show_count", Integer.valueOf(iF + 1));
            LogUtil.d("logupdate", "count < 2, show");
            return true;
        }
        if (iF2 != 2 && iF2 != 3) {
            LogUtil.d("logupdate", "day >= 4, return");
            return false;
        }
        if (iF3 == iF2) {
            LogUtil.d("logupdate", "count == 1, return");
            return false;
        }
        this.q.edit().putLong("last_select_dialog_show_time", jC).apply();
        sPUtil.t(scene, "last_select_dialog_show_count", 1);
        LogUtil.d("logupdate", "count < 1, show");
        return true;
    }

    public void Y(Activity activity) {
        boolean z2;
        UpdateInfo updateInfoH = H();
        synchronized (this.o) {
            if (this.m) {
                this.n = updateInfoH;
                return;
            }
            if (AppInfo.getVersionCode(this.p) >= Integer.valueOf(updateInfoH.vcode).intValue()) {
                return;
            }
            boolean zIsPaused = activity instanceof FrameworkBaseActivity ? ((FrameworkBaseActivity) activity).isPaused() : true;
            if (activity == null || activity.isFinishing() || zIsPaused) {
                return;
            }
            int i2 = updateInfoH.updateType;
            if ((i2 == UpdateInfo.TYPE_SELECT || i2 == UpdateInfo.TYPE_DELAY) && this.w) {
                boolean z3 = activity instanceof AdSplaseActivity;
                LogUtil.d("logupdate", "AdSplaseActivity = " + z3);
                boolean z4 = activity instanceof ChatterActivity;
                if (z4) {
                    z2 = false;
                } else {
                    boolean zX = X(updateInfoH);
                    this.x = zX && z3;
                    z2 = zX & (!z3);
                }
                if (!z2) {
                    long j2 = this.q.getLong("last_select_dialog_show_time", 0L);
                    int i3 = updateInfoH.promptFrequency;
                    if (Math.abs(j2 - ir5.b()) < (i3 > 0 ? ((long) (i3 * 60 * 60)) * 1000 : C) || z4) {
                        return;
                    }
                    if (z3) {
                        this.x = true;
                        return;
                    }
                    this.q.edit().putLong("last_select_dialog_show_time", System.currentTimeMillis()).apply();
                }
            } else {
                z2 = false;
            }
            C();
            MaterialDialog materialDialogE = new sd3(activity).b(false).h(false).c(0).q(0.7f).o(R.layout.layout_dialog_update, false).e();
            this.i = materialDialogE;
            View viewJ = materialDialogE.j();
            TextView textView = (TextView) viewJ.findViewById(R.id.title);
            TextView textView2 = (TextView) viewJ.findViewById(R.id.content);
            this.h = (TextView) viewJ.findViewById(R.id.buttonPositive);
            TextView textView3 = (TextView) viewJ.findViewById(R.id.buttonNegative);
            boolean z5 = updateInfoH.updateType == UpdateInfo.TYPE_FORCE;
            String string = z2 ? "重要升级：\n为了避免遗漏好友申请和互动消息，请您尽快升级版本" : !TextUtils.isEmpty(updateInfoH.desc) ? updateInfoH.desc : AppContext.getContext().getString(R.string.update_content_default);
            if (!this.w) {
                string = string + AppContext.getContext().getString(R.string.update_apk_size) + xk5.a(updateInfoH.psize);
            }
            textView2.setText(string);
            textView.setText(!TextUtils.isEmpty(updateInfoH.title) ? updateInfoH.title : AppContext.getContext().getString(R.string.update_title_default));
            ProgressBar progressBar = (ProgressBar) this.i.findViewById(R.id.update_dialog_progress);
            this.g = progressBar;
            if (this.t && (!this.w || z5)) {
                progressBar.setVisibility(0);
            }
            boolean zExists = new File(pu1.r(updateInfoH.vname)).exists();
            if (z5) {
                this.h.setOnClickListener(new b(updateInfoH));
                textView3.setOnClickListener(new c(updateInfoH));
                if (zExists) {
                    this.h.setText(R.string.update_install);
                } else {
                    this.h.setText(R.string.update_download_update);
                }
                if (this.t) {
                    this.h.setText(R.string.update_downloading);
                    this.h.setEnabled(false);
                }
                textView3.setVisibility(8);
            } else {
                if (!this.w) {
                    textView3.setText(R.string.update_quit);
                    if (zExists) {
                        this.h.setText(R.string.update_install);
                        textView3.setOnClickListener(new e(activity, updateInfoH));
                    } else {
                        if (this.t) {
                            this.h.setText(R.string.update_downloading);
                            this.g.setVisibility(0);
                            this.h.setEnabled(false);
                            W();
                        } else {
                            this.h.setText(R.string.update_download_update);
                            this.h.setEnabled(true);
                        }
                        textView3.setOnClickListener(new f(activity, updateInfoH));
                    }
                } else {
                    if (!zExists) {
                        return;
                    }
                    this.h.setText(R.string.update_install);
                    textView3.setText(R.string.update_quit);
                    textView3.setOnClickListener(new d(activity, updateInfoH));
                }
                this.h.setOnClickListener(new g(updateInfoH));
            }
            this.i.show();
            M(updateInfoH);
        }
    }

    public void Z() {
        a0(UpdateScene.USER_CLICK);
    }

    @Override // com.zenmen.palmchat.update.b.a
    public void a(int i2) {
        LogUtil.d(y, "onDownloadProgress  progress: " + i2);
        if (i2 >= 0) {
            this.l = i2;
        }
    }

    public void a0(UpdateScene updateScene) {
        LogUtil.i(y, "update");
        this.w = false;
        boolean z2 = this.s;
        if (!z2 && !this.t) {
            if (updateScene == UpdateScene.USER_CLICK) {
                Context context = this.p;
                sy5.f(context, context.getString(R.string.update_waiting), 0).g();
            }
            U(false);
            this.s = true;
            this.b.d(this.p, 2, updateScene);
            this.f15666a = updateScene;
            return;
        }
        if (!z2) {
            this.r = false;
            ch.s().K0(1, true);
        } else if (updateScene == UpdateScene.USER_CLICK) {
            Context context2 = this.p;
            sy5.f(context2, context2.getString(R.string.update_running), 0).g();
        }
    }

    @Override // com.zenmen.palmchat.update.b.a
    public void b(int i2, UpdateInfo updateInfo) {
        LogUtil.d(y, "onCheck  rst: " + i2 + "   info: " + updateInfo);
        try {
            this.q.edit().putLong("last_check_time", System.currentTimeMillis()).apply();
        } catch (Exception unused) {
        }
        this.s = false;
        if (i2 != 0 || updateInfo == null) {
            if (!this.w) {
                Context context = this.p;
                sy5.h(context, context.getString(R.string.update_network_error), 0);
            }
            z();
            LogUtil.i(y, "ONCHECK  removeUpdateDot");
            T();
            return;
        }
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.UPDATE;
        long jI = sPUtil.i(scene, updateInfo.vcode + "first_check_time", 0L);
        if (jI <= 0 || jI > ir5.b()) {
            sPUtil.t(scene, updateInfo.vcode + "first_check_time", Long.valueOf(ir5.b()));
        }
        int i3 = this.q.getInt("update_versioncode", 0);
        String str = y;
        LogUtil.d(str, "onCheck versionCode is " + i3);
        LogUtil.d(str, "onCheck current_versionCode is " + AppInfo.getVersionCode(this.p));
        b0(updateInfo);
        LocalBroadcastManager.getInstance(this.p).sendBroadcast(new Intent("action_update_check_result"));
        if (updateInfo.updateType > 0) {
            y();
            if (updateInfo.vcode > i3) {
                this.q.edit().remove("apk_remind_count").remove("apk_remind_last_time").remove("apk_remind_d_count").remove("apk_remind_d_last_time").apply();
            }
            P(updateInfo);
            return;
        }
        if (!this.w) {
            Context context2 = this.p;
            sy5.h(context2, context2.getString(R.string.update_no), 0);
            LogUtil.i(str, "timee cancel");
        }
        z();
        ch.s().K0(0, false);
        LogUtil.i(str, "ONCHECK  removeUpdateDot");
        T();
    }

    public final void b0(UpdateInfo updateInfo) {
        SharedPreferences.Editor editorEdit = this.q.edit();
        editorEdit.putInt("update_versioncode", updateInfo.vcode);
        editorEdit.putString("key_update_dialog_title", updateInfo.title);
        editorEdit.putString("update_versionname", updateInfo.vname);
        editorEdit.putString("update_downloaduir", updateInfo.downloadUrl);
        editorEdit.putString("update_description", updateInfo.desc);
        editorEdit.putInt(HiAnalyticsConstant.BI_KEY_UPDATE_TYPE, updateInfo.updateType);
        editorEdit.putBoolean("update_force", updateInfo.updateType == UpdateInfo.TYPE_FORCE);
        editorEdit.putString("update_apk_md5", updateInfo.pmd5);
        editorEdit.putInt("update_full_size", updateInfo.psize);
        editorEdit.putInt("key_update_dialog_interval", updateInfo.promptFrequency);
        editorEdit.putString("key_update_info_json", az2.c(updateInfo));
        editorEdit.apply();
    }

    @Override // com.zenmen.palmchat.update.b.a
    public void c(int i2, File file, UpdateInfo updateInfo) {
        String str = y;
        LogUtil.d(str, "onDownloadFinish: rst = " + i2);
        this.t = false;
        if (this.r) {
            if (i2 == 0) {
                ch.s().K0(1, true);
            }
        } else {
            if (i2 != 0) {
                C();
                V();
                return;
            }
            LogUtil.i(str, "download finish installAPK " + file);
            I(file);
            z();
            C();
            int i3 = updateInfo.updateType;
            int i4 = UpdateInfo.TYPE_NONEED;
        }
    }

    public final void c0(int i2) {
        if (this.f == null) {
            Context context = this.p;
            this.f = new NotificationCompat.Builder(context, A(context)).setAutoCancel(true).setSmallIcon(android.R.drawable.stat_sys_download).setWhen(System.currentTimeMillis()).setOngoing(true).build();
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            this.c.setProgressBar(R.id.update_pb, 100, i2, true);
        } else {
            this.c.setProgressBar(R.id.update_pb, 100, i2, false);
        }
        this.c.setTextViewText(R.id.update_tv, i2 + "%");
        Notification notification = this.f;
        notification.contentView = this.c;
        notification.contentIntent = this.d;
        try {
            this.e.notify(16, notification);
        } catch (Exception unused) {
        }
        ProgressBar progressBar = this.g;
        if (progressBar != null) {
            progressBar.post(new i(i2));
        }
    }

    public void w() {
        TaskExecutorHelper.safeRun("UpdateManager_autoUpdate", new a());
    }

    public final void x() throws Throwable {
        if (!hx3.m(this.p) || !r75.l()) {
            LogUtil.i(y, "autoUpdate network not available");
            return;
        }
        LogUtil.i(y, "autoUpdate mIsChecking=" + this.s + " mIsDownloading=" + this.t);
        this.w = true;
        if (this.s) {
            return;
        }
        int i2 = this.q.getInt("update_versioncode", 0);
        int versionCode = AppInfo.getVersionCode(AppContext.getContext());
        long j2 = this.q.getLong("last_check_time", 0L);
        int i3 = this.q.getInt(HiAnalyticsConstant.BI_KEY_UPDATE_TYPE, UpdateInfo.TYPE_NONEED);
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jE = E();
        boolean zN = N(this.q.getString("update_apk_md5", ""), new File(pu1.r(this.q.getString("update_versionname", ""))));
        int i4 = UpdateInfo.TYPE_DELAY;
        if (i3 == i4 && !zN) {
            jE = B;
        }
        if ((i2 <= versionCode || i3 == i4) && Math.abs(jCurrentTimeMillis - j2) <= jE && !this.x) {
            if (i3 != UpdateInfo.TYPE_DELAY) {
                T();
                return;
            }
            return;
        }
        U(false);
        this.s = true;
        com.zenmen.palmchat.update.b bVar = this.b;
        Context context = this.p;
        UpdateScene updateScene = UpdateScene.AUTO_CHECK;
        bVar.d(context, 1, updateScene);
        this.f15666a = updateScene;
    }

    public final void y() {
        if (Math.abs(this.q.getLong("tray_preference_update_dot_time", 0L) - ir5.b()) < 86400000) {
            return;
        }
        this.q.edit().putLong("tray_preference_update_dot_time", System.currentTimeMillis()).apply();
        this.q.edit().putString("system_preference_mine_dot", "2").apply();
        this.q.edit().putString("system_preference_about_zx", "2").apply();
        ch.s().B0();
    }

    public final void z() {
        if (LogUtil.isDDBG()) {
            LogUtil.d(y, "clearNotification");
        }
        TimerTask timerTask = this.j;
        if (timerTask != null) {
            timerTask.cancel();
            if (LogUtil.isDDBG()) {
                LogUtil.d(y, "canceled timer task");
            }
        }
        Timer timer = this.k;
        if (timer != null) {
            timer.cancel();
            this.k.purge();
            if (LogUtil.isDDBG()) {
                LogUtil.d(y, "canceled and purged timer");
            }
        }
        NotificationManager notificationManager = this.e;
        if (notificationManager != null) {
            notificationManager.cancel(16);
            if (LogUtil.isDDBG()) {
                LogUtil.d(y, "canceled notification manager");
            }
        }
        this.f = null;
    }
}
