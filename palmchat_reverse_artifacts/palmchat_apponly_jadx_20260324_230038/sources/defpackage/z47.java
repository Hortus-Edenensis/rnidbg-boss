package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.cdadata.sdk.api.ZMDataSDKManager;
import com.qq.gdt.action.ActionUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class z47 implements Application.ActivityLifecycleCallbacks, q57 {
    public Handler b;
    public int d;
    public int g;
    public long h;
    public Context j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<Integer> f22349a = new HashSet();
    public long c = 0;
    public boolean e = false;
    public boolean f = true;
    public Handler i = new Handler(Looper.getMainLooper());
    public String k = "";
    public JSONObject l = new JSONObject();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c57.l().a() == 0) {
                z47.this.f("AppStart", false);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String[] strArrE;
            int i = message.what;
            if (i == 0) {
                if (z47.this.c == 0 || SystemClock.elapsedRealtime() - z47.this.c >= ZMDataSDKManager.getInstance().zmConfigOptions.sessionTime) {
                    z47.this.c = SystemClock.elapsedRealtime();
                    Bundle data = message.getData();
                    String string = data.getString("app_end_data");
                    z47.this.e = true;
                    if (!data.getBoolean("app_reset_state") || c57.l().a() <= 0) {
                        z47.e(z47.this, string);
                        return;
                    }
                    return;
                }
                return;
            }
            int i2 = 0;
            if (i != 100) {
                if (i != 200) {
                    if (i != 400) {
                        return;
                    }
                    z47 z47Var = z47.this;
                    if (z47Var.d <= 0 || z47Var.g <= 0) {
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SystemClock.elapsedRealtime();
                    z47Var.d(jCurrentTimeMillis);
                    if (p67.b()) {
                        z47.this.f("AppLive", true);
                    }
                    z47.this.b.sendEmptyMessageDelayed(400, 2000L);
                    return;
                }
                z47 z47Var2 = z47.this;
                z47Var2.getClass();
                try {
                    int i3 = z47Var2.d - 1;
                    z47Var2.d = i3;
                    if (i3 <= 0) {
                        z47Var2.b.removeMessages(400);
                        z47Var2.d = 0;
                    }
                    int iA = c57.l().a();
                    z47Var2.g = iA;
                    if (iA > 0) {
                        i2 = iA - 1;
                        z47Var2.g = i2;
                    }
                    z47Var2.g = i2;
                    c57.l().d(z47Var2.g);
                    if (z47Var2.g <= 0) {
                        z47Var2.f("AppStop", true);
                        z47Var2.k = null;
                        Bundle data2 = message.getData();
                        long j = data2.getLong("time");
                        data2.getLong("elapse_time");
                        z47Var2.d(j);
                        z47Var2.b.sendMessageDelayed(z47Var2.a(true), ZMDataSDKManager.getInstance().zmConfigOptions.sessionTime);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    g57.a(e);
                    return;
                }
            }
            z47 z47Var3 = z47.this;
            z47Var3.getClass();
            try {
                z47Var3.g = c57.l().a();
                c57 c57VarL = c57.l();
                int i4 = z47Var3.g + 1;
                z47Var3.g = i4;
                c57VarL.d(i4);
                if (z47Var3.g == 1) {
                    z47Var3.b.removeMessages(0);
                    if (z47Var3.i()) {
                        z47Var3.b.sendMessage(z47Var3.a(false));
                        c57 c57VarL2 = c57.l();
                        String strReplace = UUID.randomUUID().toString().replace("-", "");
                        c57VarL2.getClass();
                        if (!TextUtils.isEmpty(strReplace)) {
                            try {
                                c57VarL2.c.b(o57.a().u, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, strReplace), true);
                            } catch (JSONException e2) {
                                g57.a(e2);
                            }
                        }
                        c57 c57VarL3 = c57.l();
                        c57VarL3.getClass();
                        try {
                            strArrE = c57VarL3.c.e(c57VarL3.f1896a.e, 1, true);
                        } catch (Exception e3) {
                            g57.a(e3);
                        }
                        int i5 = (strArrE == null || strArrE.length <= 0) ? 0 : Integer.parseInt(strArrE[0]);
                        Bundle data3 = message.getData();
                        try {
                            if (i5 == 0) {
                                c57 c57VarL4 = c57.l();
                                c57VarL4.getClass();
                                try {
                                    c57VarL4.c.b(c57VarL4.f1896a.e, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, 1), true);
                                } catch (JSONException e4) {
                                    g57.a(e4);
                                }
                            } else {
                                z47Var3.f = false;
                            }
                            z47Var3.f("AppStart", true);
                        } catch (Exception e5) {
                            g57.d("ZMDataActivityLifecycleCallbacks", e5);
                        }
                        z47Var3.h(data3.getLong("elapse_time"));
                        z47Var3.e = true;
                    }
                }
                z47Var3.f("AppOpen", true);
            } catch (Exception e6) {
                g57.a(e6);
                z47Var3.h(SystemClock.elapsedRealtime());
            }
            try {
                int i6 = z47Var3.d;
                z47Var3.d = i6 + 1;
                if (i6 == 0) {
                    z47Var3.b.sendEmptyMessage(400);
                }
            } catch (Exception e7) {
                g57.a(e7);
            }
        }
    }

    public z47(Context context) {
        this.j = context;
        b();
        f("AppInit", false);
        this.i.postDelayed(new a(), 10000L);
    }

    public static void e(z47 z47Var, String str) {
        z47Var.getClass();
        try {
            g57.b("=======>>>>>>", "30秒后发送AppEnd" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            z47Var.f("AppEnd", true);
            c57.l().e(0L);
            c57.l().f("");
        } catch (Exception e) {
            g57.a(e);
        }
    }

    public final Message a(boolean z) {
        Message messageObtain = Message.obtain(this.b);
        messageObtain.what = 0;
        Bundle bundle = new Bundle();
        bundle.putString("app_end_data", c57.l().h());
        bundle.putBoolean("app_reset_state", z);
        messageObtain.setData(bundle);
        return messageObtain;
    }

    public final void b() {
        try {
            HandlerThread handlerThread = new HandlerThread("ZM_DATA_THREAD", -1);
            handlerThread.start();
            this.b = new b(handlerThread.getLooper());
        } catch (Exception e) {
            g57.a(e);
        }
    }

    public final void c(int i) {
        Message messageObtainMessage = this.b.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putLong("time", System.currentTimeMillis());
        bundle.putLong("elapse_time", SystemClock.elapsedRealtime());
        messageObtainMessage.what = i;
        messageObtainMessage.setData(bundle);
        this.b.sendMessage(messageObtainMessage);
    }

    public final void d(long j) {
        try {
            if (this.h == 0) {
                this.h = c57.l().k();
            }
            c57.l().e(j);
            try {
                this.l.put("eventName", "AppEnd");
                if (!TextUtils.isEmpty(this.k)) {
                    this.l.put("screenName", this.k);
                }
                this.l.put("sid", c57.l().m());
                this.l.put("eventDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j)));
                this.l.put("eventTime", j);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            c57.l().f(this.l.toString());
        } catch (Throwable th) {
            g57.b("ZMDataActivityLifecycleCallbacks", th.getMessage());
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void f(String str, boolean z) {
        JSONException e;
        JSONObject jSONObject;
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case -1853223252:
                if (str.equals("AppNetChange")) {
                    b2 = 0;
                }
                break;
            case 788572250:
                if (str.equals("AppInstall")) {
                    b2 = 1;
                }
                break;
            case 870380209:
                if (str.equals("AppInit")) {
                    b2 = 2;
                }
                break;
            case 870465165:
                if (str.equals("AppLive")) {
                    b2 = 3;
                }
                break;
            case 870560747:
                if (str.equals("AppOpen")) {
                    b2 = 4;
                }
                break;
            case 870684067:
                if (str.equals("AppStop")) {
                    b2 = 5;
                }
                break;
            case 1221389025:
                if (str.equals("AppStart")) {
                    b2 = 6;
                }
                break;
            case 1967735578:
                if (str.equals("AppEnd")) {
                    b2 = 7;
                }
                break;
            case 1999723618:
                if (str.equals("AppScreenOff")) {
                    b2 = 8;
                }
                break;
            case 2004169868:
                if (str.equals("AppScreenOn")) {
                    b2 = 9;
                }
                break;
        }
        JSONObject jSONObject2 = null;
        try {
            switch (b2) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 5:
                case 8:
                case 9:
                    jSONObject2 = new JSONObject();
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        jSONObject2.put("eventName", str);
                        jSONObject2.put("eventDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(jCurrentTimeMillis)));
                        jSONObject2.put("eventTime", jCurrentTimeMillis);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    if (("AppLive".equals(str) || "AppStop".equals(str)) && !TextUtils.isEmpty(this.k)) {
                        jSONObject2.put("screenName", this.k);
                    }
                    break;
                case 4:
                case 6:
                    jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("eventName", str);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        jSONObject2.put("eventDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(jCurrentTimeMillis2)));
                        jSONObject2.put("eventTime", jCurrentTimeMillis2);
                        jSONObject2.put("isFirstStart", this.f);
                        jSONObject2.put("resumeFromBackground", this.e);
                        jSONObject2.put("isInitiative", z);
                    } catch (JSONException e3) {
                        e3.printStackTrace();
                    }
                    if (!TextUtils.isEmpty(this.k)) {
                        jSONObject2.put("screenName", this.k);
                    }
                    break;
                case 7:
                    String strH = c57.l().h();
                    if (!TextUtils.isEmpty(strH)) {
                        try {
                            jSONObject2 = new JSONObject(strH);
                        } catch (JSONException e4) {
                            e4.printStackTrace();
                        }
                    } else {
                        try {
                            jSONObject = new JSONObject();
                        } catch (JSONException e5) {
                            e = e5;
                        }
                        try {
                            jSONObject.put("eventName", str);
                            long jCurrentTimeMillis3 = System.currentTimeMillis();
                            jSONObject.put("eventDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(jCurrentTimeMillis3)));
                            jSONObject.put("eventTime", jCurrentTimeMillis3);
                            jSONObject2 = jSONObject;
                        } catch (JSONException e6) {
                            e = e6;
                            jSONObject2 = jSONObject;
                            e.printStackTrace();
                        }
                    }
                    break;
            }
        } catch (Exception unused) {
        }
        h57.a().b(new u57(this, jSONObject2, str));
    }

    public final void h(long j) {
        try {
            try {
                this.h = j;
                c57.l().i(j > 0 ? j : SystemClock.elapsedRealtime());
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            c57 c57VarL = c57.l();
            if (j <= 0) {
                j = SystemClock.elapsedRealtime();
            }
            c57VarL.i(j);
        }
    }

    public final boolean i() {
        long jMax = Math.max(System.currentTimeMillis(), 946656000000L);
        long j = 0;
        try {
            if (this.h == 0) {
                h(c57.l().k());
            }
            c57 c57VarL = c57.l();
            c57VarL.getClass();
            try {
                String[] strArrE = c57VarL.c.e(c57VarL.f1896a.d, 1, true);
                if (strArrE != null && strArrE.length > 0) {
                    j = Long.parseLong(strArrE[0]);
                }
            } catch (Exception e) {
                g57.a(e);
            }
        } catch (Exception e2) {
            g57.a(e2);
        }
        return Math.abs(jMax - j) > ZMDataSDKManager.getInstance().zmConfigOptions.sessionTime;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        try {
            this.k = activity.getClass().getName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        try {
            this.k = activity.getClass().getName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (activity != null ? this.f22349a.contains(Integer.valueOf(activity.hashCode())) : false) {
            return;
        }
        c(100);
        if (activity != null) {
            this.f22349a.add(Integer.valueOf(activity.hashCode()));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity != null ? this.f22349a.contains(Integer.valueOf(activity.hashCode())) : false) {
            c(200);
            if (activity != null) {
                this.f22349a.remove(Integer.valueOf(activity.hashCode()));
            }
        }
    }

    @Override // defpackage.q57
    public void uncaughtException(Thread thread, Throwable th) {
        if (TextUtils.isEmpty(c57.l().h())) {
            c57.l().i(SystemClock.elapsedRealtime());
        }
        c57.l().g(false);
        c57.l().d(0);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
