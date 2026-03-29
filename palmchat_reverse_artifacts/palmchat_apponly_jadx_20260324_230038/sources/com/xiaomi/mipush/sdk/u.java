package com.xiaomi.mipush.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.au;
import com.xiaomi.push.aw;
import com.xiaomi.push.ba;
import com.xiaomi.push.cs;
import com.xiaomi.push.dt;
import com.xiaomi.push.gf;
import com.xiaomi.push.gg;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import com.xiaomi.push.gp;
import com.xiaomi.push.gs;
import com.xiaomi.push.hb;
import com.xiaomi.push.he;
import com.xiaomi.push.hf;
import com.xiaomi.push.hl;
import com.xiaomi.push.hp;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.ah;
import com.xiaomi.push.service.aj;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static u f11387a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final ArrayList<a> f71a = new ArrayList<>();
    private static boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f72a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f73a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f75a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Messenger f76a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f80a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<Message> f79a = new ArrayList();
    private boolean c = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f81b = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Intent f74a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Integer f77a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f78a = null;

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.u$5, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11392a;

        static {
            int[] iArr = new int[v.values().length];
            f11392a = iArr;
            try {
                iArr[v.DISABLE_PUSH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11392a[v.ENABLE_PUSH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11392a[v.UPLOAD_HUAWEI_TOKEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11392a[v.UPLOAD_FCM_TOKEN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11392a[v.UPLOAD_COS_TOKEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f11392a[v.UPLOAD_FTOS_TOKEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a<T extends hq<T, ?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        gf f11393a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        T f82a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        boolean f83a;
    }

    private u(Context context) {
        this.f80a = false;
        this.f75a = null;
        this.f73a = context.getApplicationContext();
        this.f80a = m137c();
        b = m138d();
        this.f75a = new Handler(Looper.getMainLooper()) { // from class: com.xiaomi.mipush.sdk.u.1
            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                if (message.what != 19) {
                    return;
                }
                String str = (String) message.obj;
                int i = message.arg1;
                synchronized (p.class) {
                    if (p.a(u.this.f73a).m129a(str)) {
                        if (p.a(u.this.f73a).a(str) < 10) {
                            String string = message.getData() != null ? message.getData().getString("third_sync_reason") : "";
                            v vVar = v.DISABLE_PUSH;
                            if (vVar.ordinal() == i && "syncing".equals(p.a(u.this.f73a).a(vVar))) {
                                u.this.a(str, vVar, true, (HashMap<String, String>) null);
                            } else {
                                v vVar2 = v.ENABLE_PUSH;
                                if (vVar2.ordinal() == i && "syncing".equals(p.a(u.this.f73a).a(vVar2))) {
                                    u.this.a(str, vVar2, true, (HashMap<String, String>) null);
                                } else {
                                    v vVar3 = v.UPLOAD_HUAWEI_TOKEN;
                                    if (vVar3.ordinal() == i && "syncing".equals(p.a(u.this.f73a).a(vVar3))) {
                                        HashMap<String, String> mapM118a = f.m118a(u.this.f73a, d.ASSEMBLE_PUSH_HUAWEI);
                                        mapM118a.put("third_sync_reason", string);
                                        u.this.a(str, vVar3, false, mapM118a);
                                    } else {
                                        v vVar4 = v.UPLOAD_FCM_TOKEN;
                                        if (vVar4.ordinal() == i && "syncing".equals(p.a(u.this.f73a).a(vVar4))) {
                                            u uVar = u.this;
                                            uVar.a(str, vVar4, false, f.m118a(uVar.f73a, d.ASSEMBLE_PUSH_FCM));
                                        } else {
                                            v vVar5 = v.UPLOAD_COS_TOKEN;
                                            if (vVar5.ordinal() == i && "syncing".equals(p.a(u.this.f73a).a(vVar5))) {
                                                HashMap<String, String> mapM118a2 = f.m118a(u.this.f73a, d.ASSEMBLE_PUSH_COS);
                                                mapM118a2.put("third_sync_reason", string);
                                                u.this.a(str, vVar5, false, mapM118a2);
                                            } else {
                                                v vVar6 = v.UPLOAD_FTOS_TOKEN;
                                                if (vVar6.ordinal() == i && "syncing".equals(p.a(u.this.f73a).a(vVar6))) {
                                                    HashMap<String, String> mapM118a3 = f.m118a(u.this.f73a, d.ASSEMBLE_PUSH_FTOS);
                                                    mapM118a3.put("third_sync_reason", string);
                                                    u.this.a(str, vVar6, false, mapM118a3);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            p.a(u.this.f73a).b(str);
                        } else {
                            p.a(u.this.f73a).c(str);
                        }
                    }
                }
            }
        };
        if (com.xiaomi.push.j.m651a(context)) {
            com.xiaomi.push.service.g.a(new g.b() { // from class: com.xiaomi.mipush.sdk.u.2
            });
        }
        Intent intentB = b();
        if (intentB != null) {
            b(intentB);
        }
    }

    private synchronized void c(int i) {
        this.f73a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i).commit();
    }

    private Intent d() {
        Intent intent = new Intent();
        String packageName = this.f73a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m135a());
        intent.putExtra("mipush_app_package", packageName);
        h();
        return intent;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f73a.getPackageName();
        i();
        intent.setComponent(new ComponentName(this.f73a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    private void g() {
        this.f72a = SystemClock.elapsedRealtime();
    }

    private void h() {
        try {
            PackageManager packageManager = this.f73a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f73a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            PackageManager packageManager = this.f73a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f73a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public final void m146b() {
        Intent intentM132a = m132a();
        intentM132a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(intentM132a);
    }

    public void f() {
        Intent intentM132a = m132a();
        intentM132a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        intentM132a.putExtra(an.F, this.f73a.getPackageName());
        intentM132a.putExtra(an.K, ba.b(this.f73a.getPackageName()));
        c(intentM132a);
    }

    private Intent b() {
        if (!"com.xiaomi.xmsf".equals(this.f73a.getPackageName())) {
            return c();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel xmsf create own channel");
        return e();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private boolean m137c() {
        try {
            PackageInfo packageInfo = this.f73a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public void m150e() {
        Intent intentM132a = m132a();
        intentM132a.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        Application application = (Application) aw.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        String packageName = (application == null || application.getApplicationContext() == null) ? null : application.getApplicationContext().getPackageName();
        String packageName2 = this.f73a.getPackageName();
        if (TextUtils.isEmpty(packageName) || packageName.equals(packageName2)) {
            packageName = packageName2;
        } else {
            com.xiaomi.channel.commonutils.logger.b.m74a("application package name: " + packageName + ", not equals context package name: " + packageName2);
        }
        intentM132a.putExtra(an.F, packageName);
        c(intentM132a);
    }

    private Intent c() {
        if (m144a()) {
            com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.channel.commonutils.logger.b.c("pushChannel app start  own channel");
        return e();
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public void m149d() {
        ArrayList<a> arrayList = f71a;
        synchronized (arrayList) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            for (a aVar : arrayList) {
                a(aVar.f82a, aVar.f11393a, aVar.f83a, false, null, true);
                if (!z) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f71a.clear();
        }
    }

    public void b(int i) {
        Intent intentM132a = m132a();
        intentM132a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        intentM132a.putExtra(an.F, this.f73a.getPackageName());
        intentM132a.putExtra(an.I, i);
        intentM132a.putExtra(an.K, ba.b(this.f73a.getPackageName() + i));
        c(intentM132a);
    }

    public static synchronized u a(Context context) {
        if (f11387a == null) {
            f11387a = new u(context);
        }
        return f11387a;
    }

    private synchronized int a() {
        return this.f73a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m148c() {
        if (this.f74a != null) {
            g();
            c(this.f74a);
            this.f74a = null;
        }
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    private boolean m138d() {
        if (m144a()) {
            try {
                return this.f73a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m147b() {
        if (!m144a() || !m139e()) {
            return true;
        }
        if (this.f77a == null) {
            Integer numValueOf = Integer.valueOf(ap.a(this.f73a).a());
            this.f77a = numValueOf;
            if (numValueOf.intValue() == 0) {
                this.f73a.getContentResolver().registerContentObserver(ap.a(this.f73a).m724a(), false, new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.xiaomi.mipush.sdk.u.3
                    @Override // android.database.ContentObserver
                    public void onChange(boolean z) {
                        u uVar = u.this;
                        uVar.f77a = Integer.valueOf(ap.a(uVar.f73a).a());
                        if (u.this.f77a.intValue() != 0) {
                            u.this.f73a.getContentResolver().unregisterContentObserver(this);
                            if (au.m175a(u.this.f73a)) {
                                u.this.m148c();
                            }
                        }
                    }
                });
            }
        }
        return this.f77a.intValue() != 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m140a() {
        return this.f72a;
    }

    private void c(Intent intent) {
        ah ahVarA = ah.a(this.f73a);
        int iA = gk.ServiceBootMode.a();
        gg ggVar = gg.START;
        int iA2 = ahVarA.a(iA, ggVar.a());
        int iA3 = a();
        gg ggVar2 = gg.BIND;
        boolean z = iA2 == ggVar2.a() && b;
        int iA4 = z ? ggVar2.a() : ggVar.a();
        if (iA4 != iA3) {
            m145a(iA4);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    private boolean m139e() {
        String packageName = this.f73a.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.f73a.getApplicationInfo().flags & 1) != 0;
    }

    public final void a(hf hfVar, boolean z) {
        dt.a(this.f73a.getApplicationContext()).a(this.f73a.getPackageName(), "E100003", hfVar.a(), 6001, null);
        this.f74a = null;
        b.m99a(this.f73a).f46a = hfVar.a();
        Intent intentM132a = m132a();
        byte[] bArrA = hp.a(r.a(this.f73a, hfVar, gf.Registration));
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.b.m74a("register fail, because msgBytes is null.");
            return;
        }
        intentM132a.setAction("com.xiaomi.mipush.REGISTER_APP");
        intentM132a.putExtra("mipush_app_id", b.m99a(this.f73a).m100a());
        intentM132a.putExtra("mipush_payload", bArrA);
        intentM132a.putExtra("mipush_session", this.f78a);
        intentM132a.putExtra("mipush_env_chanage", z);
        intentM132a.putExtra("mipush_env_type", b.m99a(this.f73a).a());
        if (au.m175a(this.f73a) && m147b()) {
            g();
            c(intentM132a);
        } else {
            this.f74a = intentM132a;
        }
    }

    private synchronized void d(Intent intent) {
        if (this.c) {
            Message messageA = a(intent);
            if (this.f79a.size() >= 50) {
                this.f79a.remove(0);
            }
            this.f79a.add(messageA);
            return;
        }
        if (this.f76a == null) {
            this.f73a.bindService(intent, new ServiceConnection() { // from class: com.xiaomi.mipush.sdk.u.4
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (u.this) {
                        u.this.f76a = new Messenger(iBinder);
                        u.this.c = false;
                        Iterator it = u.this.f79a.iterator();
                        while (it.hasNext()) {
                            try {
                                u.this.f76a.send((Message) it.next());
                            } catch (RemoteException e) {
                                com.xiaomi.channel.commonutils.logger.b.a(e);
                            }
                        }
                        u.this.f79a.clear();
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    u.this.f76a = null;
                    u.this.c = false;
                }
            }, 1);
            this.c = true;
            this.f79a.clear();
            this.f79a.add(a(intent));
        } else {
            try {
                this.f76a.send(a(intent));
            } catch (RemoteException unused) {
                this.f76a = null;
                this.c = false;
            }
        }
    }

    private void b(Intent intent) {
        try {
            if (!com.xiaomi.push.j.m650a() && Build.VERSION.SDK_INT >= 26) {
                d(intent);
            } else {
                this.f73a.startService(intent);
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m141a() {
        b(m132a());
    }

    public final void a(hl hlVar) {
        byte[] bArrA = hp.a(r.a(this.f73a, hlVar, gf.UnRegistration));
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.b.m74a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent intentM132a = m132a();
        intentM132a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        intentM132a.putExtra("mipush_app_id", b.m99a(this.f73a).m100a());
        intentM132a.putExtra("mipush_payload", bArrA);
        c(intentM132a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        if (z) {
            p pVarA = p.a(this.f73a);
            v vVar = v.DISABLE_PUSH;
            pVarA.a(vVar, "syncing");
            p.a(this.f73a).a(v.ENABLE_PUSH, "");
            a(str, vVar, true, (HashMap<String, String>) null);
            return;
        }
        p pVarA2 = p.a(this.f73a);
        v vVar2 = v.ENABLE_PUSH;
        pVarA2.a(vVar2, "syncing");
        p.a(this.f73a).a(v.DISABLE_PUSH, "");
        a(str, vVar2, true, (HashMap<String, String>) null);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m142a(Context context) {
        if (com.xiaomi.push.j.m650a()) {
            return;
        }
        q qVarA = h.a(context);
        if (q.HUAWEI.equals(qVarA)) {
            a((String) null, v.UPLOAD_HUAWEI_TOKEN, d.ASSEMBLE_PUSH_HUAWEI, "update");
        }
        if (q.OPPO.equals(qVarA)) {
            a((String) null, v.UPLOAD_COS_TOKEN, d.ASSEMBLE_PUSH_COS, "update");
        }
        if (q.VIVO.equals(qVarA)) {
            a((String) null, v.UPLOAD_FTOS_TOKEN, d.ASSEMBLE_PUSH_FTOS, "update");
        }
    }

    public final void a(String str, v vVar, d dVar, String str2) {
        p.a(this.f73a).a(vVar, "syncing");
        HashMap<String, String> mapM118a = f.m118a(this.f73a, dVar);
        mapM118a.put("third_sync_reason", str2);
        a(str, vVar, false, mapM118a);
    }

    public void a(int i, String str) {
        Intent intentM132a = m132a();
        intentM132a.setAction("com.xiaomi.mipush.thirdparty");
        intentM132a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i);
        intentM132a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(intentM132a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, v vVar, boolean z, HashMap<String, String> map) {
        he heVar;
        String strA = str;
        if (b.m99a(this.f73a).m106b() && au.m175a(this.f73a)) {
            he heVar2 = new he();
            heVar2.a(true);
            Intent intentM132a = m132a();
            if (TextUtils.isEmpty(str)) {
                strA = aj.a();
                heVar2.a(strA);
                heVar = z ? new he(strA, true) : null;
                synchronized (p.class) {
                    p.a(this.f73a).m128a(strA);
                }
            } else {
                heVar2.a(strA);
                heVar = z ? new he(strA, true) : null;
            }
            switch (AnonymousClass5.f11392a[vVar.ordinal()]) {
                case 1:
                    gp gpVar = gp.DisablePushMessage;
                    heVar2.c(gpVar.f535a);
                    heVar.c(gpVar.f535a);
                    if (map != null) {
                        heVar2.a(map);
                        heVar.a(map);
                    }
                    intentM132a.setAction("com.xiaomi.mipush.DISABLE_PUSH_MESSAGE");
                    break;
                case 2:
                    gp gpVar2 = gp.EnablePushMessage;
                    heVar2.c(gpVar2.f535a);
                    heVar.c(gpVar2.f535a);
                    if (map != null) {
                        heVar2.a(map);
                        heVar.a(map);
                    }
                    intentM132a.setAction("com.xiaomi.mipush.ENABLE_PUSH_MESSAGE");
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    heVar2.c(gp.ThirdPartyRegUpdate.f535a);
                    if (map != null) {
                        heVar2.a(map);
                    }
                    break;
            }
            com.xiaomi.channel.commonutils.logger.b.e("type:" + vVar + ", " + strA);
            heVar2.b(b.m99a(this.f73a).m100a());
            heVar2.d(this.f73a.getPackageName());
            gf gfVar = gf.Notification;
            a(heVar2, gfVar, false, (gs) null);
            if (z) {
                heVar.b(b.m99a(this.f73a).m100a());
                heVar.d(this.f73a.getPackageName());
                Context context = this.f73a;
                byte[] bArrA = hp.a(r.a(context, heVar, gfVar, false, context.getPackageName(), b.m99a(this.f73a).m100a()));
                if (bArrA != null) {
                    cs.a(this.f73a.getPackageName(), this.f73a, heVar, gfVar, bArrA.length);
                    intentM132a.putExtra("mipush_payload", bArrA);
                    intentM132a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    intentM132a.putExtra("mipush_app_id", b.m99a(this.f73a).m100a());
                    intentM132a.putExtra("mipush_app_token", b.m99a(this.f73a).b());
                    c(intentM132a);
                }
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 19;
            int iOrdinal = vVar.ordinal();
            messageObtain.obj = strA;
            messageObtain.arg1 = iOrdinal;
            if (map != null && map.get("third_sync_reason") != null) {
                Bundle bundle = new Bundle();
                bundle.putString("third_sync_reason", map.get("third_sync_reason"));
                messageObtain.setData(bundle);
            }
            this.f75a.sendMessageDelayed(messageObtain, 5000L);
        }
    }

    public final <T extends hq<T, ?>> void a(T t, gf gfVar, gs gsVar) {
        a(t, gfVar, !gfVar.equals(gf.Registration), gsVar);
    }

    public final <T extends hq<T, ?>> void a(T t, gf gfVar, boolean z, gs gsVar, boolean z2) {
        a(t, gfVar, z, true, gsVar, z2);
    }

    public final <T extends hq<T, ?>> void a(T t, gf gfVar, boolean z, gs gsVar) {
        a(t, gfVar, z, true, gsVar, true);
    }

    public final <T extends hq<T, ?>> void a(T t, gf gfVar, boolean z, boolean z2, gs gsVar, boolean z3) {
        a(t, gfVar, z, z2, gsVar, z3, this.f73a.getPackageName(), b.m99a(this.f73a).m100a());
    }

    public final <T extends hq<T, ?>> void a(T t, gf gfVar, boolean z, boolean z2, gs gsVar, boolean z3, String str, String str2) {
        a(t, gfVar, z, z2, gsVar, z3, str, str2, true);
    }

    public final <T extends hq<T, ?>> void a(T t, gf gfVar, boolean z, boolean z2, gs gsVar, boolean z3, String str, String str2, boolean z4) {
        a(t, gfVar, z, z2, gsVar, z3, str, str2, z4, true);
    }

    public final <T extends hq<T, ?>> void a(T t, gf gfVar, boolean z, boolean z2, gs gsVar, boolean z3, String str, String str2, boolean z4, boolean z5) {
        hb hbVarB;
        if (z5 && !b.m99a(this.f73a).m108c()) {
            if (z2) {
                a(t, gfVar, z);
                return;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m74a("drop the message before initialization.");
                return;
            }
        }
        if (z4) {
            hbVarB = r.a(this.f73a, t, gfVar, z, str, str2);
        } else {
            hbVarB = r.b(this.f73a, t, gfVar, z, str, str2);
        }
        if (gsVar != null) {
            hbVarB.a(gsVar);
        }
        byte[] bArrA = hp.a(hbVarB);
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.b.m74a("send message fail, because msgBytes is null.");
            return;
        }
        cs.a(this.f73a.getPackageName(), this.f73a, t, gfVar, bArrA.length);
        Intent intentM132a = m132a();
        intentM132a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        intentM132a.putExtra("mipush_payload", bArrA);
        intentM132a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(intentM132a);
    }

    public final void a(gj gjVar) {
        Intent intentM132a = m132a();
        byte[] bArrA = hp.a(gjVar);
        if (bArrA == null) {
            com.xiaomi.channel.commonutils.logger.b.m74a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        intentM132a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        intentM132a.putExtra("mipush_payload", bArrA);
        b(intentM132a);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private Intent m132a() {
        if (m144a() && !"com.xiaomi.xmsf".equals(this.f73a.getPackageName())) {
            return d();
        }
        return e();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private String m135a() {
        String str = this.f81b;
        if (str != null) {
            return str;
        }
        try {
            if (this.f73a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106) {
                this.f81b = "com.xiaomi.push.service.XMPushService";
                return "com.xiaomi.push.service.XMPushService";
            }
        } catch (Exception unused) {
        }
        this.f81b = "com.xiaomi.xmsf.push.service.XMPushService";
        return "com.xiaomi.xmsf.push.service.XMPushService";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m144a() {
        return this.f80a && 1 == b.m99a(this.f73a).a();
    }

    public <T extends hq<T, ?>> void a(T t, gf gfVar, boolean z) {
        a aVar = new a();
        aVar.f82a = t;
        aVar.f11393a = gfVar;
        aVar.f83a = z;
        ArrayList<a> arrayList = f71a;
        synchronized (arrayList) {
            arrayList.add(aVar);
            if (arrayList.size() > 10) {
                arrayList.remove(0);
            }
        }
    }

    public void a(int i) {
        a(i, 0);
    }

    public void a(int i, int i2) {
        Intent intentM132a = m132a();
        intentM132a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        intentM132a.putExtra(an.F, this.f73a.getPackageName());
        intentM132a.putExtra(an.G, i);
        intentM132a.putExtra(an.H, i2);
        c(intentM132a);
    }

    public void a(String str, String str2) {
        Intent intentM132a = m132a();
        intentM132a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        intentM132a.putExtra(an.F, this.f73a.getPackageName());
        intentM132a.putExtra(an.L, str);
        intentM132a.putExtra(an.M, str2);
        c(intentM132a);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m143a(Intent intent) {
        intent.fillIn(m132a(), 24);
        c(intent);
    }

    private Message a(Intent intent) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 17;
        messageObtain.obj = intent;
        return messageObtain;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m145a(int i) {
        if (!b.m99a(this.f73a).m106b()) {
            return false;
        }
        c(i);
        he heVar = new he();
        heVar.a(aj.a());
        heVar.b(b.m99a(this.f73a).m100a());
        heVar.d(this.f73a.getPackageName());
        heVar.c(gp.ClientABTest.f535a);
        HashMap map = new HashMap();
        heVar.f674a = map;
        map.put("boot_mode", i + "");
        a(this.f73a).a(heVar, gf.Notification, false, (gs) null);
        return true;
    }
}
