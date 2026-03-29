package defpackage;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.APayEntranceActivity;
import com.alipay.sdk.app.AlipayResultActivity;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.umeng.analytics.pro.f;
import defpackage.qh7;
import defpackage.ru6;
import defpackage.vt6;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class zd7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f22398a;
    public volatile IAlixPay b;
    public boolean d;
    public e e;
    public final ru6 f;
    public final Object c = IAlixPay.class;
    public boolean g = false;
    public String h = null;
    public String i = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements AlipayResultActivity.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f22399a;

        public a(CountDownLatch countDownLatch) {
            this.f22399a = countDownLatch;
        }

        @Override // com.alipay.sdk.app.AlipayResultActivity.a
        public void a(int i, String str, String str2) {
            zd7.this.h = xz6.b(i, str, str2);
            this.f22399a.countDown();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements APayEntranceActivity.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f22400a;

        public b(Object obj) {
            this.f22400a = obj;
        }

        @Override // com.alipay.sdk.app.APayEntranceActivity.a
        public void a(String str) {
            zd7.this.i = str;
            synchronized (this.f22400a) {
                try {
                    this.f22400a.notify();
                } finally {
                }
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c extends IRemoteServiceCallback.Stub {
        public c() {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public int getVersion() throws RemoteException {
            return 4;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public boolean isHideLoadingScreen() throws RemoteException {
            return false;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void r03(String str, String str2, Map map) throws RemoteException {
            xt6.b(zd7.this.f, "wlt", str, str2);
            if (TextUtils.equals(str2, "ActivityStartSuccess")) {
                if (zd7.this.e != null) {
                    zd7.this.e.a();
                }
                if (zd7.this.f != null) {
                    zd7.this.f.g(true);
                }
            }
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void startActivity(String str, String str2, int i, Bundle bundle) throws RemoteException {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                bundle.putInt("CallingPid", i);
                intent.putExtras(bundle);
            } catch (Exception e) {
                xt6.c(zd7.this.f, "biz", "ErrIntentEx", e);
            }
            intent.setClassName(str, str2);
            try {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                ActivityManager.getMyMemoryState(runningAppProcessInfo);
                xt6.b(zd7.this.f, "biz", "isFg", runningAppProcessInfo.processName + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + runningAppProcessInfo.importance + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            } catch (Throwable unused) {
            }
            try {
                if (zd7.this.f22398a == null) {
                    xt6.g(zd7.this.f, "biz", "ErrActNull", "");
                    Context contextA = zd7.this.f.a();
                    if (contextA != null) {
                        contextA.startActivity(intent);
                        return;
                    }
                    return;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                zd7.this.f22398a.startActivity(intent);
                xt6.b(zd7.this.f, "biz", "stAct2", "" + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            } catch (Throwable th) {
                xt6.c(zd7.this.f, "biz", "ErrActNull", th);
                throw th;
            }
        }

        public /* synthetic */ c(zd7 zd7Var, a aVar) {
            this();
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void payEnd(boolean z, String str) throws RemoteException {
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class d implements ServiceConnection {
        public d() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            xt6.a(zd7.this.f, "biz", "srvCon");
            synchronized (zd7.this.c) {
                zd7.this.b = IAlixPay.Stub.asInterface(iBinder);
                zd7.this.c.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            xt6.a(zd7.this.f, "biz", "srvDis");
            zd7.this.b = null;
        }

        public /* synthetic */ d(zd7 zd7Var, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface e {
        void a();

        void b();
    }

    public zd7(Activity activity, ru6 ru6Var, e eVar) {
        this.f22398a = activity;
        this.f = ru6Var;
        this.e = eVar;
        w97.h("mspl", "alipaySdk");
    }

    public static boolean k(String str, Context context, ru6 ru6Var) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            xt6.a(ru6Var, "biz", "BSPDetectFail");
            return false;
        } catch (Throwable th) {
            xt6.c(ru6Var, "biz", "BSPDetectFail", th);
            return false;
        }
    }

    public static boolean o(String str, Context context, ru6 ru6Var) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            xt6.a(ru6Var, "biz", "BSADetectFail");
            return false;
        } catch (Throwable th) {
            xt6.c(ru6Var, "biz", "BSADetectFail", th);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Pair<String, Boolean> b(String str, String str2, ru6 ru6Var) {
        int i;
        d dVar;
        IRemoteServiceCallback cVar;
        Activity activity;
        int version;
        String strA;
        Activity activity2;
        Activity activity3;
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction(qh7.J(str2));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(jElapsedRealtime);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append(str != null ? str.length() : 0);
        xt6.b(ru6Var, "biz", "PgBindStarting", sb.toString());
        xt6.f(this.f22398a, ru6Var, str, ru6Var.d);
        try {
            try {
                if (vt6.I().o()) {
                    xt6.b(ru6Var, "biz", "stSrv", "skipped");
                } else {
                    ComponentName componentNameStartService = this.f22398a.getApplication().startService(intent);
                    xt6.b(ru6Var, "biz", "stSrv", componentNameStartService != null ? componentNameStartService.getPackageName() : com.igexin.push.core.b.m);
                }
            } catch (Throwable th) {
                xt6.c(ru6Var, "biz", "ClientBindServiceFailed", th);
                qh7.t("alipaySdk", "bindServiceFail", this.f22398a, this.f);
                return new Pair<>("failed", Boolean.TRUE);
            }
        } catch (Throwable th2) {
            xt6.c(ru6Var, "biz", "TryStartServiceEx", th2);
        }
        if (vt6.I().k()) {
            xt6.b(ru6Var, "biz", "bindFlg", "imp");
            i = 65;
        } else {
            i = 1;
        }
        a aVar = null;
        d dVar2 = new d(this, aVar);
        if (!this.f22398a.getApplicationContext().bindService(intent, dVar2, i)) {
            throw new Throwable("bindService fail");
        }
        synchronized (this.c) {
            if (this.b == null) {
                try {
                    this.c.wait(vt6.I().t());
                } catch (InterruptedException e2) {
                    xt6.c(ru6Var, "biz", "BindWaitTimeoutEx", e2);
                }
            }
        }
        IAlixPay iAlixPay = this.b;
        try {
            if (iAlixPay == null) {
                xt6.g(ru6Var, "biz", "ClientBindFailed", "");
                qh7.t("alipaySdk", "bindServiceTimeout", this.f22398a, this.f);
                Pair<String, Boolean> pair = new Pair<>("failed", Boolean.TRUE);
                try {
                    this.f22398a.getApplicationContext().unbindService(dVar2);
                } catch (Throwable th3) {
                    w97.d(th3);
                }
                xt6.b(ru6Var, "biz", "PgBindEnd", "" + SystemClock.elapsedRealtime());
                xt6.f(this.f22398a, ru6Var, str, ru6Var.d);
                this.b = null;
                if (this.d && (activity3 = this.f22398a) != null) {
                    activity3.setRequestedOrientation(0);
                    this.d = false;
                }
                return pair;
            }
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            xt6.b(ru6Var, "biz", "PgBinded", "" + jElapsedRealtime2);
            e eVar = this.e;
            if (eVar != null) {
                eVar.b();
            }
            if (this.f22398a.getRequestedOrientation() == 0) {
                this.f22398a.setRequestedOrientation(1);
                this.d = true;
            }
            try {
                version = iAlixPay.getVersion();
            } catch (Throwable th4) {
                w97.d(th4);
                version = 0;
            }
            cVar = new c(this, aVar);
            try {
                if (version >= 3) {
                    iAlixPay.registerCallback03(cVar, str, null);
                } else {
                    iAlixPay.registerCallback(cVar);
                }
                long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                StringBuilder sb2 = new StringBuilder();
                try {
                    sb2.append("");
                    sb2.append(jElapsedRealtime3);
                    xt6.b(ru6Var, "biz", "PgBindPay", sb2.toString());
                    if (version >= 3) {
                        iAlixPay.r03("biz", "bind_pay", null);
                    }
                    try {
                        if (version >= 2) {
                            Map mapF = ru6.f(ru6Var);
                            mapF.put("ts_bind", String.valueOf(jElapsedRealtime));
                            mapF.put("ts_bend", String.valueOf(jElapsedRealtime2));
                            mapF.put("ts_pay", String.valueOf(jElapsedRealtime3));
                            strA = iAlixPay.pay02(str, mapF);
                        } else {
                            strA = iAlixPay.Pay(str);
                        }
                    } catch (Throwable th5) {
                        ru6 ru6Var2 = this.f;
                        if (ru6Var2 != null && !ru6Var2.o()) {
                            xt6.c(ru6Var, "biz", "ClientBindException", th5);
                            qh7.t("alipaySdk", "bindServiceEx", this.f22398a, this.f);
                        }
                        strA = xz6.a();
                    }
                    String str3 = strA;
                    try {
                        iAlixPay.unregisterCallback(cVar);
                    } catch (Throwable th6) {
                        w97.d(th6);
                    }
                    try {
                        this.f22398a.getApplicationContext().unbindService(dVar2);
                    } catch (Throwable th7) {
                        w97.d(th7);
                    }
                    xt6.b(ru6Var, "biz", "PgBindEnd", "" + SystemClock.elapsedRealtime());
                    xt6.f(this.f22398a, ru6Var, str, ru6Var.d);
                    this.b = null;
                    if (this.d && (activity2 = this.f22398a) != null) {
                        activity2.setRequestedOrientation(0);
                        this.d = false;
                    }
                    return new Pair<>(str3, Boolean.FALSE);
                } catch (Throwable th8) {
                    th = th8;
                    dVar = dVar2;
                }
            } catch (Throwable th9) {
                th = th9;
                dVar = dVar2;
            }
        } catch (Throwable th10) {
            th = th10;
            dVar = dVar2;
            cVar = null;
        }
        try {
            xt6.d(ru6Var, "biz", "ClientBindFailed", th, "in_bind");
            Pair<String, Boolean> pair2 = new Pair<>("failed", Boolean.TRUE);
            if (cVar != null) {
                try {
                    iAlixPay.unregisterCallback(cVar);
                } catch (Throwable th11) {
                    w97.d(th11);
                }
            }
            try {
                this.f22398a.getApplicationContext().unbindService(dVar);
            } catch (Throwable th12) {
                w97.d(th12);
            }
            xt6.b(ru6Var, "biz", "PgBindEnd", "" + SystemClock.elapsedRealtime());
            xt6.f(this.f22398a, ru6Var, str, ru6Var.d);
            this.b = null;
            if (this.d && (activity = this.f22398a) != null) {
                activity.setRequestedOrientation(0);
                this.d = false;
            }
            return pair2;
        } finally {
        }
    }

    public final String e(String str, String str2) {
        String str3;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String strG = qh7.g(32);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        xt6.b(this.f, "biz", "BSPStart", strG + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + jElapsedRealtime);
        ru6.a.d(this.f, strG);
        AlipayResultActivity.f2574a.put(strG, new a(countDownLatch));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sourcePid", Binder.getCallingPid());
            jSONObject.put("external_info", str);
            jSONObject.put("pkgName", this.f22398a.getPackageName());
            jSONObject.put(f.aC, strG);
            String strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 2);
            Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path(com.igexin.push.core.b.q).appendQueryParameter("appId", "20000125");
            builderAppendQueryParameter.appendQueryParameter("mqpSchemePay", strEncodeToString);
            try {
                HashMap<String, String> mapF = ru6.f(this.f);
                mapF.put("ts_scheme", String.valueOf(jElapsedRealtime));
                builderAppendQueryParameter.appendQueryParameter("mqpLoc", new JSONObject(mapF).toString());
            } catch (Throwable th) {
                xt6.c(this.f, "biz", "BSPLocEx", th);
            }
            String string = builderAppendQueryParameter.build().toString();
            Intent intent = new Intent();
            intent.setPackage(str2);
            intent.addFlags(268435456);
            intent.setData(Uri.parse(string));
            Activity activity = this.f22398a;
            ru6 ru6Var = this.f;
            xt6.f(activity, ru6Var, str, ru6Var.d);
            this.f22398a.startActivity(intent);
            w97.h("mspl", "pay scheme waiting " + string);
            countDownLatch.await();
            String str4 = this.h;
            try {
                str3 = eg7.c(this.f, str4).get("resultStatus");
                if (str3 == null) {
                    str3 = com.igexin.push.core.b.m;
                }
            } catch (Throwable th2) {
                xt6.c(this.f, "biz", "BSPStatEx", th2);
                str3 = "unknown";
            }
            xt6.a(this.f, "biz", "BSPDone-" + str3);
            if (!TextUtils.isEmpty(str4)) {
                return str4;
            }
            xt6.a(this.f, "biz", "BSPEmpty");
            return "scheme_failed";
        } catch (InterruptedException e2) {
            xt6.c(this.f, "biz", "BSPWaiting", e2);
            com.alipay.sdk.m.j.c cVar = com.alipay.sdk.m.j.c.PAY_WAITTING;
            return xz6.b(cVar.b(), cVar.a(), "");
        } catch (Throwable th3) {
            xt6.c(this.f, "biz", "BSPEx", th3);
            return "scheme_failed";
        }
    }

    public final String f(String str, String str2, PackageInfo packageInfo) {
        String str3 = packageInfo != null ? packageInfo.versionName : "";
        w97.h("mspl", "pay payInvokeAct");
        xt6.b(this.f, "biz", "PgWltVer", str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str3);
        Activity activity = this.f22398a;
        ru6 ru6Var = this.f;
        xt6.f(activity, ru6Var, str, ru6Var.d);
        return n(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String g(String str, String str2, PackageInfo packageInfo, qh7.c cVar) {
        String str3;
        ru6 ru6Var;
        boolean zContains = false;
        int i = packageInfo != null ? packageInfo.versionCode : 0;
        w97.h("mspl", "pay bind or scheme");
        ru6 ru6Var2 = this.f;
        if (ru6Var2 != null && !TextUtils.isEmpty(ru6Var2.g)) {
            zContains = this.f.g.toLowerCase().contains("auth");
        }
        if (!zContains && qh7.c0()) {
            if (cVar != null) {
                try {
                    if (vt6.I().G()) {
                        j(cVar);
                    }
                } catch (Throwable unused) {
                }
            }
            xt6.a(this.f, "biz", "BindSkipByModel");
        } else {
            if (zContains || !qh7.N(this.f, str2)) {
                if (cVar != null) {
                    try {
                        if (!vt6.I().y()) {
                            j(cVar);
                        }
                    } catch (Throwable unused2) {
                    }
                }
                Pair<String, Boolean> pairB = b(str, str2, this.f);
                str3 = (String) pairB.first;
                try {
                    if ("failed".equals(str3) && ((Boolean) pairB.second).booleanValue() && vt6.I().w()) {
                        xt6.a(this.f, "biz", "BindRetry");
                        str3 = (String) b(str, str2, this.f).first;
                    }
                } catch (Throwable th) {
                    xt6.c(this.f, "biz", "BindRetryEx", th);
                }
                w97.h("mspl", "pay bind result: " + str3);
                Activity activity = this.f22398a;
                ru6 ru6Var3 = this.f;
                xt6.f(activity, ru6Var3, str, ru6Var3.d);
                if ("failed".equals(str3)) {
                    if (!vt6.I().r()) {
                        xt6.b(this.f, "biz", "BSPNotStartByConfig", "");
                        return str3;
                    }
                    if ("com.eg.android.AlipayGphone".equals(str2) && i > 125) {
                        if (!vt6.I().v() || (ru6Var = this.f) == null || qh7.A(ru6Var.f) == 0) {
                            Activity activity2 = this.f22398a;
                            return (activity2 == null || !k(str2, activity2, this.f)) ? "scheme_failed" : e(str, str2);
                        }
                        xt6.a(this.f, "biz", "BSPNotStartByUsr");
                        return str3;
                    }
                    xt6.b(this.f, "biz", "BSPNotStartByPkg", str2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + i);
                }
                return str3;
            }
            if (cVar != null) {
                try {
                    if (vt6.I().G()) {
                        j(cVar);
                    }
                } catch (Throwable unused3) {
                }
            }
            xt6.a(this.f, "biz", "BindSkipByL");
        }
        str3 = "failed";
        w97.h("mspl", "pay bind result: " + str3);
        Activity activity3 = this.f22398a;
        ru6 ru6Var32 = this.f;
        xt6.f(activity3, ru6Var32, str, ru6Var32.d);
        if ("failed".equals(str3)) {
        }
        return str3;
    }

    public String h(String str, boolean z) {
        qh7.c cVarQ;
        String strB = "";
        try {
            List<vt6.b> listU = vt6.I().u();
            if (!vt6.I().g || listU == null) {
                listU = fu6.d;
            }
            cVarQ = qh7.q(this.f, this.f22398a, listU);
        } catch (Throwable th) {
            th = th;
            cVarQ = null;
        }
        if (cVarQ != null) {
            try {
                if (cVarQ.b(this.f) || cVarQ.a() || qh7.z(cVarQ.f20254a)) {
                    return "failed";
                }
                PackageInfo packageInfo = cVarQ.f20254a;
                strB = (packageInfo == null || "com.eg.android.AlipayGphone".equals(packageInfo.packageName)) ? qh7.B() : cVarQ.f20254a.packageName;
                PackageInfo packageInfo2 = cVarQ.f20254a;
                packageInfo = packageInfo2 != null ? packageInfo2 : null;
                String strL = vt6.I().l();
                if (strL != null) {
                    if (strL.length() > 0) {
                        try {
                            JSONObject jSONObjectOptJSONObject = new JSONObject(strL).optJSONObject(strB);
                            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                                while (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    int i = Integer.parseInt(next);
                                    if (packageInfo != null && packageInfo.versionCode >= i) {
                                        try {
                                            boolean zJ = vt6.I().j(this.f22398a, Integer.parseInt(jSONObjectOptJSONObject.getString(next)));
                                            this.g = zJ;
                                            if (zJ) {
                                                break;
                                            }
                                        } catch (Exception unused) {
                                            continue;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                xt6.c(this.f, "biz", "CheckClientSignEx", th);
            }
            return ((z || this.g) && !qh7.G(this.f) && o(strB, this.f22398a, this.f)) ? f(str, strB, packageInfo) : g(str, strB, packageInfo, cVarQ);
        }
        return "failed";
    }

    public void i() {
        this.f22398a = null;
        this.e = null;
    }

    public final void j(qh7.c cVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (cVar == null || (packageInfo = cVar.f20254a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.f22398a.startActivity(intent);
        } catch (Throwable th) {
            xt6.c(this.f, "biz", "StartLaunchAppTransEx", th);
        }
        Thread.sleep(200L);
    }

    public final String n(String str, String str2) {
        JSONObject jSONObject;
        Object obj = new Object();
        String strG = qh7.g(32);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        xt6.b(this.f, "biz", "BSAStart", strG + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + jElapsedRealtime);
        ru6.a.d(this.f, strG);
        APayEntranceActivity.d.put(strG, new b(obj));
        try {
            try {
                HashMap<String, String> mapF = ru6.f(this.f);
                mapF.put("ts_intent", String.valueOf(jElapsedRealtime));
                jSONObject = new JSONObject(mapF);
            } catch (Throwable th) {
                xt6.c(this.f, "biz", "BSALocEx", th);
                jSONObject = null;
            }
            Intent intent = new Intent(this.f22398a, (Class<?>) APayEntranceActivity.class);
            intent.putExtra("ap_order_info", str);
            intent.putExtra("ap_target_packagename", str2);
            intent.putExtra("ap_session", strG);
            if (jSONObject != null) {
                intent.putExtra("ap_local_info", jSONObject.toString());
            }
            Activity activity = this.f22398a;
            ru6 ru6Var = this.f;
            xt6.f(activity, ru6Var, str, ru6Var.d);
            try {
                Activity activity2 = this.f22398a;
                if (activity2 != null) {
                    activity2.startActivity(intent);
                } else {
                    xt6.g(this.f, "biz", "ErrActNull", "");
                    Context contextA = this.f.a();
                    if (contextA != null) {
                        contextA.startActivity(intent);
                    }
                }
                synchronized (obj) {
                    obj.wait();
                }
                String str3 = this.i;
                String str4 = "unknown";
                try {
                    String str5 = eg7.c(this.f, str3).get("resultStatus");
                    str4 = str5 == null ? com.igexin.push.core.b.m : str5;
                } catch (Throwable th2) {
                    xt6.c(this.f, "biz", "BSAStatEx", th2);
                }
                xt6.a(this.f, "biz", "BSADone-" + str4);
                if (!TextUtils.isEmpty(str3)) {
                    return str3;
                }
                xt6.a(this.f, "biz", "BSAEmpty");
                return "scheme_failed";
            } catch (Throwable th3) {
                xt6.c(this.f, "biz", "ErrActNull", th3);
                throw th3;
            }
        } catch (InterruptedException e2) {
            xt6.c(this.f, "biz", "BSAWaiting", e2);
            com.alipay.sdk.m.j.c cVar = com.alipay.sdk.m.j.c.PAY_WAITTING;
            return xz6.b(cVar.b(), cVar.a(), "");
        } catch (Throwable th4) {
            xt6.c(this.f, "biz", "BSAEx", th4);
            qh7.t("alipaySdk", "startActivityEx", this.f22398a, this.f);
            return "scheme_failed";
        }
    }
}
