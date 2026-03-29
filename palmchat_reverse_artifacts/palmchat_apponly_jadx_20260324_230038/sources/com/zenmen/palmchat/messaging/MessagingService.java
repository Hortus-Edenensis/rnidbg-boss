package com.zenmen.palmchat.messaging;

import android.app.AlarmManager;
import android.app.KeyguardManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.huawei.openalliance.ad.constant.az;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.Vo.GlobalConfig;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.daemon.CoreService;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.bp4;
import defpackage.dp4;
import defpackage.ns;
import defpackage.rl0;
import defpackage.s35;
import defpackage.u93;
import defpackage.x63;
import defpackage.zn6;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class MessagingService extends Service {
    public static final String c = MessagingService.class.getSimpleName() + "_CONNECT";
    public static Integer d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public s35 f14686a;
    public ServiceConnection b = new c();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("action", "MessagingService");
            put("status", "onCreate");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if ("WDY-AN00".equals(Build.MODEL)) {
                    return;
                }
                Intent intent = new Intent(MessagingService.this, (Class<?>) CoreService.class);
                MessagingService messagingService = MessagingService.this;
                messagingService.bindService(intent, messagingService.b, 1);
            } catch (Exception e) {
                LogUtil.e("MessagingService", "bindCoreService exception = " + e);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements ServiceConnection {
        public c() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LogUtil.d("MessagingService", "onServiceConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtil.d("MessagingService", "onServiceDisconnected");
            MessagingService.this.c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements s35.b {
        public d() {
        }

        @Override // s35.b
        public void a() {
            if (ns.c().b().isMoveFrontSwitch()) {
                return;
            }
            LogUtil.d("MessagingService", "onScreenOn");
            if (((KeyguardManager) AppContext.getContext().getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
                return;
            }
            bp4.E();
        }

        @Override // s35.b
        public void b() {
            LogUtil.d("MessagingService", "onUserPresent");
            if (ns.c().b().isMoveFrontSwitch()) {
                return;
            }
            bp4.E();
        }

        @Override // s35.b
        public void c() {
            LogUtil.d("MessagingService", "onScreenOff");
            dp4.a().e();
        }
    }

    public static int d() {
        GlobalConfig globalConfigE;
        if (d == null) {
            d = 240000;
            if (!TextUtils.isEmpty(AccountUtils.p(AppContext.getContext())) && (globalConfigE = rl0.h().e()) != null) {
                int iA = (int) (globalConfigE.a() * 240000.0d);
                d = Integer.valueOf(iA > 0 ? iA : 240000);
            }
        }
        return d.intValue();
    }

    public static native Pair<byte[], byte[]> getSecretKeys();

    public static native void setSecretKeys(String str, String str2);

    public final void c() {
        LogUtil.d("MessagingService", "bindCoreService");
        u93.b(5000, new b());
    }

    public final void e() {
        try {
            AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent(this, (Class<?>) MessagingService.class);
            intent.putExtra("extra_reason", "AlarmManagerFire");
            alarmManager.setRepeating(0, System.currentTimeMillis() + 10000, d(), PendingIntent.getService(getApplicationContext(), 0, intent, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void f() {
        this.f14686a.b(new d());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        LogUtil.d("MessagingService", "onBind");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        LogUtil.i("MessagingService", "MessagingService on create");
        com.zenmen.palmchat.messaging.b.d().f(this);
        this.f14686a = new s35(this);
        f();
        if (ns.c().b().isAlarmManagerSwitch()) {
            LogUtil.i("BatterySaveManager", "disable registerAutoStartAlarm");
        } else {
            e();
        }
        LogUtil.i("MessagingService", 3, new a(), (Throwable) null);
        c();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d("MessagingService", "MessagingService onDestroy");
        com.zenmen.palmchat.messaging.b.d().g();
        this.f14686a.d();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        LogUtil.i("MessagingService", "onStartCommand");
        String stringExtra = "";
        boolean booleanExtra = false;
        if (intent != null) {
            try {
                String stringExtra2 = intent.getStringExtra(az.at);
                if (!TextUtils.isEmpty(stringExtra2)) {
                    if (stringExtra2.equals("com.snda.wifilocating")) {
                        LogUtil.uploadInfoImmediate(PhoneNumberUtil.REGION_CODE_FOR_NON_GEO_ENTITY, null, null, null);
                    } else {
                        JSONObject jSONObjectG = x63.g();
                        try {
                            jSONObjectG.put(az.at, stringExtra2);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        zn6.d("lx_client_app_205151", null, jSONObjectG.toString());
                    }
                }
                String action = intent.getAction();
                booleanExtra = intent.getBooleanExtra("extra_reset_sk", false);
                stringExtra = intent.getStringExtra("extra_reason");
                LogUtil.i("MessagingService", "onStartCommand action = " + action + "; reason = " + stringExtra);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        com.zenmen.palmchat.messaging.b.d().c().p(booleanExtra, stringExtra);
        return 1;
    }
}
