package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jpush.android.service.DataShare;
import cn.jpush.android.service.JCommonService;
import cn.jpush.android.service.PushReceiver;
import com.igexin.sdk.PushConsts;
import defpackage.ll2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class wv2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f21809a = ".permission.JPUSH_MESSAGE";
    public static String b = "2.4.7";
    public static int c = 247;
    public static Boolean d;
    public static Boolean e;
    public static ServiceConnection f = new a();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            k63.a("JCoreGobal", "action - onServiceConnected, ComponentName:" + componentName);
            k63.g("JCoreGobal", "Remote Service bind success.");
            try {
                DataShare.init(ll2.a.asInterface(iBinder), sv2.d(tv2.a(null)));
                Context context = tv2.p;
                if (context != null) {
                    JCoreManager.init(context);
                }
            } catch (Throwable th) {
                k63.c("JCoreGobal", "onServiceConnected e:" + th);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            k63.a("JCoreGobal", "action - onServiceDisconnected, ComponentName:" + componentName);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends xw2 {
        public Context c;
        public boolean d;
        public String e;
        public Bundle f;

        public b(Context context, boolean z, String str, Bundle bundle) {
            this.c = context;
            this.d = z;
            this.e = str;
            this.f = bundle;
            this.f22065a = "JCoreGlobal";
        }

        @Override // defpackage.xw2
        public void a() {
            try {
                if (!this.d) {
                    if (wv2.c(this.c)) {
                        sv2.c().e(this.c, this.e, this.f);
                        return;
                    }
                    return;
                }
                if (this.e.equals("a5")) {
                    zd1.e().b(this.c, 2001, 1, "");
                    lg5.h(this.c, zz2.C().a0(Boolean.TRUE));
                    String string = this.f.getString("appkey");
                    if (TextUtils.isEmpty(string)) {
                        zd1.e().b(this.c, 0, 10003, "appkey is empty");
                        return;
                    }
                    String strG = m50.g(this.c);
                    if (!TextUtils.isEmpty(strG) && !strG.equals(string)) {
                        zd1.e().b(this.c, 0, 10002, "appkey not same with meta appkey");
                        return;
                    }
                    ad.b(this.c);
                    tv2.f21077a = string;
                    if (vs2.a(this.c)) {
                        this.e = "tcp_a24";
                    } else {
                        String strK = fv2.k(this.c);
                        if (!TextUtils.isEmpty(strK)) {
                            zd1.e().b(this.c, 2001, 0, strK);
                        }
                        this.e = "tcp_a1";
                    }
                } else if (this.e.equals("tcp_a23")) {
                    zd1.e().b(this.c, 2000, 0, "success");
                }
                if (wv2.g(this.c)) {
                    sv2.c().a(this.c, this.e, this.f);
                }
            } catch (Throwable th) {
                k63.c("JCoreGobal", "do action error:" + th.getMessage());
            }
        }
    }

    public static void a(Context context) {
        String strB = sv2.b(context);
        if (TextUtils.isEmpty(strB)) {
            k63.g("JCoreGobal", "not found commonServiceClass（JCommonService）");
            return;
        }
        if (DataShare.isBinding()) {
            k63.a("JCoreGobal", "is binding service");
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setClass(context, Class.forName(strB));
            if (context.bindService(intent, f, 1)) {
                k63.j("JCoreGobal", "Remote Service on binding...");
                DataShare.setBinding();
            } else {
                k63.j("JCoreGobal", "Remote Service bind failed");
            }
        } catch (SecurityException unused) {
            k63.n("JCoreGobal", "Remote Service bind failed caused by SecurityException!");
        } catch (Throwable th) {
            k63.n("JCoreGobal", "Remote Service bind failed :" + th);
        }
    }

    public static void b(Context context, String str, Bundle bundle) {
        wz4.a("SDK_SERVICE_INIT", new b(context, true, str, bundle));
    }

    public static synchronized boolean c(Context context) {
        Boolean bool = d;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            k63.e("JCoreGobal", "init failed,context is null");
            return false;
        }
        k63.h("JCoreGobal", "action:init jcore,version:" + b + ",build id:1,l:" + tv2.d);
        k63.a("JCoreGobal", "build type:release");
        tv2.p = context.getApplicationContext();
        Context applicationContext = context.getApplicationContext();
        gv2.a();
        String strB = sv2.b(applicationContext);
        if ((!gv2.a().g() && !gv2.a().e()) || !TextUtils.isEmpty(strB)) {
            tw2.e().l();
            a(applicationContext);
            Boolean bool2 = Boolean.TRUE;
            d = bool2;
            return bool2.booleanValue();
        }
        d = Boolean.FALSE;
        k63.e("JCoreGobal", "AndroidManifest.xml missing required service:" + JCommonService.class.getCanonicalName() + ",please custom one service and extends JCommonService");
        return false;
    }

    public static void d(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            PushReceiver pushReceiver = new PushReceiver();
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
            context.registerReceiver(pushReceiver, intentFilter, context.getPackageName() + f21809a, null);
        } catch (Throwable th) {
            k63.c("JCoreGobal", "registerPushReceiver fail:" + th);
        }
    }

    public static void e(Context context, boolean z, long j) {
        try {
            Bundle bundle = new Bundle();
            bundle.putBoolean("force", z);
            bundle.putLong("delay_time", j);
            f(context, "tcp_a2", bundle);
        } catch (Throwable th) {
            k63.n("JCoreGobal", "sendHeartBeat error:" + th);
        }
    }

    public static void f(Context context, String str, Bundle bundle) {
        if (TextUtils.isEmpty(sv2.b(context)) || !context.getPackageName().equals(ad.i(context))) {
            b(context, str, bundle);
        } else {
            wz4.a("SDK_INIT", new b(context, false, str, bundle));
        }
    }

    public static synchronized boolean g(Context context) {
        Boolean bool = e;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context == null) {
            k63.e("JCoreGobal", "init failed,context is null");
            return false;
        }
        k63.a("JCoreGobal", "serviceInit...");
        tv2.p = context.getApplicationContext();
        Context applicationContext = context.getApplicationContext();
        if (!m50.a(applicationContext)) {
            return false;
        }
        if (!m50.b(applicationContext)) {
            e = Boolean.FALSE;
            return false;
        }
        gv2.a();
        try {
            tv2.h.set(true);
        } catch (Throwable unused) {
        }
        d(applicationContext);
        e = Boolean.TRUE;
        tw2.e().j(applicationContext);
        qv2.a(applicationContext, "service_create", null);
        return e.booleanValue();
    }
}
