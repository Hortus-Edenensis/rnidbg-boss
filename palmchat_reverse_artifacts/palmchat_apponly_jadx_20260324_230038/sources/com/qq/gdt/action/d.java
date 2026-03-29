package com.qq.gdt.action;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.mspsdk.constants.MspSdkCode;
import com.qq.gdt.action.GDTAction;
import com.qq.gdt.action.j.h;
import com.qq.gdt.action.j.j;
import com.qq.gdt.action.j.n;
import com.qq.gdt.action.j.o;
import com.qq.gdt.action.j.q;
import com.qq.gdt.action.j.t;
import com.qq.gdt.action.j.u;
import com.qq.gdt.action.j.v;
import com.qq.gdt.action.multioprocess.UserMessageChangeReceiver;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d {
    private static volatile d c;
    private static Handler q;
    private volatile JSONObject F;
    private volatile PrivateController G;
    private volatile Context H;
    private String K;
    private volatile Context l;
    private volatile String m;
    private volatile String n;
    private volatile SecretKey o;
    private volatile SecretKey p;
    private volatile String v;
    private static final String b = "GDTAction初始化成功（sdkv: " + e.a() + ", sdkvc: " + e.b() + "）";
    private static volatile boolean d = false;
    private static volatile boolean e = false;
    private static volatile boolean f = false;
    private static volatile boolean g = false;
    private static volatile boolean h = false;
    private static volatile String i = "";
    private static volatile boolean j = false;
    private static volatile boolean k = false;
    private static final Pattern x = Pattern.compile("^[a-zA-Z0-9_]{1,32}$", 2);
    private static volatile boolean C = true;
    private final String r = UUID.randomUUID().toString().replaceAll("-", "");
    private AtomicLong s = new AtomicLong(0);
    private AtomicLong t = new AtomicLong(0);
    private String u = "";
    private volatile ChannelType w = ChannelType.CHANNEL_TENCENT;
    private long y = -1;
    private long z = -1;
    private boolean A = true;
    private long B = -1;
    private volatile String D = "";
    private volatile boolean E = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile long f10471a = 0;
    private volatile boolean I = false;
    private volatile boolean J = true;

    private d() {
        q = new Handler(Looper.getMainLooper()) { // from class: com.qq.gdt.action.d.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    d.this.I();
                    GDTAction.logAction("TICKET", d.this.H());
                    d.this.B = SystemClock.elapsedRealtime();
                }
            }
        };
    }

    private String D() {
        return com.qq.gdt.action.multioprocess.a.a.a().b();
    }

    private void E() {
        if (h) {
            return;
        }
        UserMessageChangeReceiver userMessageChangeReceiver = new UserMessageChangeReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(UserMessageChangeReceiver.f10540a);
        intentFilter.addCategory("android.intent.category.DEFAULT");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                g().registerReceiver(userMessageChangeReceiver, intentFilter, 4);
            } else {
                g().registerReceiver(userMessageChangeReceiver, intentFilter, UserMessageChangeReceiver.b, null);
            }
            h = true;
        } catch (Exception e2) {
            o.c("Error registering receiver: " + e2.getMessage());
        }
        h = true;
    }

    private void F() {
        j.a().b().execute(new Runnable() { // from class: com.qq.gdt.action.d.3
            @Override // java.lang.Runnable
            public void run() {
                o.a("initedPersistent = " + d.g, new Object[0]);
                if (!d.g) {
                    d dVar = d.this;
                    dVar.f(dVar.l);
                    h.f(d.this.l);
                    d.this.G();
                    com.qq.gdt.action.j.d.b(d.this.l);
                    a.a(d.this.l).b();
                }
                boolean unused = d.g = true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        this.D = System.getProperty("http.agent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject H() {
        long jElapsedRealtime = (SystemClock.elapsedRealtime() - this.B) / 1000;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("begin_time", Long.valueOf(this.z));
            jSONObject.putOpt("duration", Long.valueOf(jElapsedRealtime));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (q.hasMessages(1) || !this.A) {
            return;
        }
        q.sendEmptyMessageDelayed(1, b.a(this.l).c());
    }

    private void e(Context context) {
        Context applicationContext;
        if (context != null) {
            try {
                if (context.getApplicationContext() == null) {
                    applicationContext = com.qq.gdt.action.j.d.e();
                    this.l = applicationContext;
                } else {
                    applicationContext = context.getApplicationContext();
                    this.l = applicationContext;
                }
            } catch (Throwable th) {
                o.c("getApplicationContext ex = " + th);
            }
        } else {
            applicationContext = com.qq.gdt.action.j.d.e();
            this.l = applicationContext;
        }
        if (g() != null) {
            E();
        } else {
            o.a("registerUserMessageBroadcast fail , ApplicationContext null", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Context context) {
        String strQ = q();
        if (v.a(q())) {
            strQ = UUID.randomUUID().toString().replaceAll("-", "");
            SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences("com.qq.gdt.action.DeviceIdPref", 0).edit();
            editorEdit.putString("device_id", strQ);
            editorEdit.apply();
        }
        o.a("Set device id: " + strQ, new Object[0]);
    }

    public static boolean w() {
        return C;
    }

    public boolean A() {
        o.a("last vister cp inveter time" + (System.currentTimeMillis() - this.f10471a) + "ms", new Object[0]);
        o.a("network time " + b.a(g()).o() + "ms", new Object[0]);
        return System.currentTimeMillis() - this.f10471a > ((long) b.a(g()).o());
    }

    public boolean B() {
        return this.J;
    }

    public String b(Context context) {
        return context.getApplicationContext().getSharedPreferences("com.qq.gdt.action.DeviceIdPref", 0).getString("gdt_traceid", "");
    }

    public String c(Context context) {
        return context.getApplicationContext().getSharedPreferences("com.qq.gdt.action.DeviceIdPref", 0).getString(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, "");
    }

    public Context g() {
        return this.l;
    }

    public String h() {
        return this.m;
    }

    public String i() {
        return this.n;
    }

    public String j() {
        return "event_encrypt";
    }

    public SecretKey k() {
        return this.o;
    }

    public SecretKey l() {
        try {
            if (this.p == null) {
                try {
                    this.p = com.qq.gdt.action.j.a.a(j());
                } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Exception e3) {
            o.c("getAesSecretKeyByEvent" + e3.getMessage());
        }
        return this.p;
    }

    public void m() {
        this.A = false;
        this.y = SystemClock.elapsedRealtime();
        GDTAction.logAction("ENTER_BACKGROUND", c(true));
        t.c(this.l, System.currentTimeMillis());
        a.a(this.l).a();
        GDTAction.logAction("TICKET", H());
        q.removeMessages(1);
        com.qq.gdt.action.g.e.c(this.l);
    }

    public String n() {
        return this.r;
    }

    public long o() {
        return this.s.incrementAndGet();
    }

    public long p() {
        return this.t.incrementAndGet();
    }

    public String q() {
        if (v.a(this.K)) {
            this.K = this.l.getApplicationContext().getSharedPreferences("com.qq.gdt.action.DeviceIdPref", 0).getString("device_id", "");
        }
        return this.K;
    }

    public String r() {
        if (v.a(this.u)) {
            this.u = com.qq.gdt.action.j.d.a(this.l);
        }
        return this.u;
    }

    public String s() {
        return this.w.name();
    }

    public String t() {
        return this.v;
    }

    public String u() {
        return com.qq.gdt.action.multioprocess.d.a().d();
    }

    public String v() {
        return com.qq.gdt.action.multioprocess.d.a().f();
    }

    public String x() {
        return this.D;
    }

    public JSONObject y() {
        return this.F;
    }

    public boolean z() {
        return this.I;
    }

    public static d a() {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d();
                }
            }
        }
        return c;
    }

    private void d(Context context) {
        o.a("initOnce = " + f, new Object[0]);
        if (f) {
            o.a("initOnce has executed", new Object[0]);
            return;
        }
        a(this.l);
        t.f(context);
        com.qq.gdt.action.j.c.a().a(this.l);
        f = true;
    }

    public boolean f() {
        return d() || e();
    }

    private void b(Activity activity) {
        if (activity != null) {
            try {
                if (activity.getIntent() == null || activity.getIntent().getData() == null) {
                    return;
                }
                Uri data = activity.getIntent().getData();
                String dataString = activity.getIntent().getDataString();
                o.a("getIntentData:" + data, new Object[0]);
                if (!v.a(data.getQueryParameter("gdt_traceid"))) {
                    a(this.l, data.getQueryParameter("gdt_traceid"));
                }
                if (v.a(dataString)) {
                    return;
                }
                b(this.l, dataString);
            } catch (Throwable th) {
                o.a("setTraceId err:" + th.getMessage(), new Object[0]);
            }
        }
    }

    private JSONObject c(boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = z ? this.z : this.y;
        long j3 = j2 < 0 ? -1L : (jElapsedRealtime - j2) / 1000;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("duration", Long.valueOf(j3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public boolean d() {
        return d;
    }

    public boolean e() {
        return e;
    }

    public JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("ainit", e);
            jSONObject.put("byAutoInit", j);
            jSONObject.put("byAutoInitFinal", k);
            jSONObject.put("ifrom", i);
            jSONObject.put("sinit", d);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public void b(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences("com.qq.gdt.action.DeviceIdPref", 0).edit();
        editorEdit.putString(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        editorEdit.apply();
        t.e(context, System.currentTimeMillis());
    }

    public void c() {
        e((Context) null);
    }

    private void b(String str) {
        int i2;
        o.a("ReadConfigChannelId channelId  = " + str, new Object[0]);
        if (v.a(str)) {
            return;
        }
        new ArrayList();
        if (com.qq.gdt.action.multioprocess.d.a().c() != null) {
            List<String> listQ = com.qq.gdt.action.multioprocess.d.a().c().q();
            if (listQ.size() <= 0) {
                o.a("not read channleIds", new Object[0]);
                i2 = 410401;
            } else if (listQ.contains(str)) {
                o.a("you set " + str + " in remote channelid list ，remote channelid list" + TextUtils.join(",", listQ), new Object[0]);
                i2 = 41041;
            } else {
                o.a("you set " + str + " not in remote channelid list ，remote channelid list " + TextUtils.join(",", listQ) + " ，please set", new Object[0]);
                i2 = 41042;
            }
        } else {
            o.a("not read UserMessageSyncByMemory", new Object[0]);
            i2 = 410402;
        }
        com.qq.gdt.action.h.a.a(i2);
    }

    public void a(Activity activity) {
        this.A = true;
        this.z = SystemClock.elapsedRealtime();
        GDTAction.logAction("ENTER_FOREGROUND", c(false));
        t.b(this.l, System.currentTimeMillis());
        b(activity);
        this.B = SystemClock.elapsedRealtime();
        I();
        com.qq.gdt.action.g.e.b(this.l);
    }

    public void a(Context context) {
        e(context);
        this.u = com.qq.gdt.action.j.d.a(this.l);
    }

    public void b(JSONObject jSONObject) {
        if (n.a(jSONObject)) {
            return;
        }
        this.F = jSONObject;
    }

    public void a(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences("com.qq.gdt.action.DeviceIdPref", 0).edit();
        editorEdit.putString("gdt_traceid", str);
        editorEdit.apply();
        t.d(context, System.currentTimeMillis());
    }

    public synchronized boolean b() {
        try {
            if (this.H != null && this.m != null && this.n != null) {
                if (!this.I) {
                    F();
                    this.I = true;
                }
                return true;
            }
            o.c("请先完成初始化，再调用start或logAction方法");
            return false;
        } catch (Throwable th) {
            o.b("gdt start error ", th);
            return false;
        }
    }

    public synchronized void a(Context context, String str, String str2, ChannelType channelType, String str3, GDTAction.a aVar) {
        a(context, str, str2, channelType, str3, aVar, "0", true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final GDTAction.a aVar) {
        if (!j) {
            o.a(b);
        }
        if (aVar != null) {
            q.post(new Runnable() { // from class: com.qq.gdt.action.d.4
                @Override // java.lang.Runnable
                public void run() {
                    aVar.a();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final GDTAction.a aVar, final String str) {
        o.c(str);
        if (aVar != null) {
            q.post(new Runnable() { // from class: com.qq.gdt.action.d.5
                @Override // java.lang.Runnable
                public void run() {
                    aVar.a(str);
                }
            });
        }
    }

    public void a(PrivateController privateController) {
        this.G = privateController;
    }

    public void a(com.qq.gdt.action.c.a aVar) {
        a.a(a().g()).a(aVar);
    }

    public synchronized void a(com.qq.gdt.action.multioprocess.b bVar, JSONObject jSONObject, String str) {
        String strD;
        int i2;
        int i3;
        try {
            o.a("package name gcheckUserMessageAndInit  from  = " + str + " userMessage = " + bVar + " eventObject = " + jSONObject, new Object[0]);
            if (bVar == null) {
                o.a("package name get from remote success  usermessage is null ", new Object[0]);
                if (str.equals("auto_init_by_logaction")) {
                    com.qq.gdt.action.h.a.a(40031, jSONObject);
                } else if (str.equals("auto_init_by_start")) {
                    com.qq.gdt.action.h.a.a(41031);
                }
            } else if (bVar.k()) {
                if (str.equals("auto_init_by_logaction")) {
                    com.qq.gdt.action.h.a.a(40034, jSONObject, bVar);
                } else if (str.equals("auto_init_by_start")) {
                    com.qq.gdt.action.h.a.a(41034, bVar);
                }
                String strB = bVar.b();
                String strC = bVar.c();
                ChannelType channelTypeE = bVar.e();
                String strD2 = bVar.d();
                i = "0";
                o.a("init from last user set", new Object[0]);
                boolean zA = a(g(), strB, strC, channelTypeE, strD2, null, i, false, true);
                if (zA) {
                    com.qq.gdt.action.multioprocess.d.a().a(strB, strC, channelTypeE, strD2, false);
                    b();
                }
                o.a("logActon remote fill result = " + zA, new Object[0]);
                if (str.equals("auto_init_by_logaction")) {
                    i3 = zA ? 40036 : 40035;
                    com.qq.gdt.action.h.a.a(i3, jSONObject, bVar);
                } else if (str.equals("auto_init_by_start")) {
                    i2 = zA ? 41036 : 41035;
                    com.qq.gdt.action.h.a.a(i2, bVar);
                }
            } else if (bVar.l()) {
                o.a("logActon user set not complete", new Object[0]);
                if (str.equals("auto_init_by_logaction")) {
                    com.qq.gdt.action.h.a.a(40032, jSONObject, bVar);
                } else if (str.equals("auto_init_by_start")) {
                    com.qq.gdt.action.h.a.a(41032, bVar);
                }
                String strH = bVar.h();
                String strI = bVar.i();
                ChannelType channelTypeM = bVar.m();
                String strN = bVar.n();
                try {
                    strD = (TextUtils.isEmpty(strN) || !strN.equals("2")) ? D() : bVar.q().get(0);
                } catch (Exception e2) {
                    o.a("channelIdRemote e = " + e2, new Object[0]);
                    strD = "";
                }
                o.a("init from last remote set", new Object[0]);
                boolean zA2 = a(g(), strH, strI, channelTypeM, strD, null, strN, false, true);
                if (zA2) {
                    com.qq.gdt.action.multioprocess.d.a().a(strH, strI, channelTypeM, strD, strN, false);
                    b();
                }
                o.a("logActon remote fill result = " + zA2, new Object[0]);
                if (str.equals("auto_init_by_logaction")) {
                    i3 = zA2 ? 400361 : 400351;
                    com.qq.gdt.action.h.a.a(i3, jSONObject, bVar);
                } else if (str.equals("auto_init_by_start")) {
                    i2 = zA2 ? 410361 : 410351;
                    com.qq.gdt.action.h.a.a(i2, bVar);
                }
            } else {
                o.a("logActon remote set not complete", new Object[0]);
                if (str.equals("auto_init_by_logaction")) {
                    com.qq.gdt.action.h.a.a(400321, jSONObject, bVar);
                } else if (str.equals("auto_init_by_start")) {
                    com.qq.gdt.action.h.a.a(410321, bVar);
                }
            }
        } catch (Throwable th) {
            o.a("checkUserMessageAndInit fill exception", th);
            if (str.equals("auto_init_by_logaction")) {
                com.qq.gdt.action.h.a.a(40033, jSONObject, bVar);
            } else if (str.equals("auto_init_by_start")) {
                com.qq.gdt.action.h.a.a(41033, bVar);
            }
        }
    }

    public void a(String str) {
        if (v.a(str) || x.matcher(str).matches()) {
            com.qq.gdt.action.multioprocess.d.a().a(str);
        } else {
            o.c("userUniqueId参数格式不正确");
        }
    }

    public void a(boolean z) {
        this.J = z;
    }

    public synchronized boolean a(Context context, String str, final String str2, ChannelType channelType, String str3, final GDTAction.a aVar, String str4, boolean z, boolean z2) {
        String strD = str3;
        synchronized (this) {
            try {
                o.a("init byAuto = " + z2 + " initfrom = " + str4 + " needSaveUserSetInfo = " + z + " userActionSetId = " + str + " appKey = " + str2 + " channel = " + channelType + " channelId = " + strD, new Object[0]);
                j = z2;
                k = z2;
                i = str4;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("byAutoInit", z2);
                jSONObject.put("ifrom", str4);
                if (d) {
                    o.b("GDTAction已经初始化过，不需要再次初始化");
                    return false;
                }
                if (context == null) {
                    a(aVar, "GDTAction初始化失败，init方法的context参数不能为null");
                    return false;
                }
                this.l = context.getApplicationContext();
                com.qq.gdt.action.h.a.a(3005, jSONObject);
                if (v.a(str)) {
                    com.qq.gdt.action.h.a.a(3002, jSONObject);
                    a(aVar, "GDTAction初始化失败，init方法的userActionSetId参数不能为空");
                    return false;
                }
                this.m = str.trim();
                if (v.a(str2)) {
                    com.qq.gdt.action.h.a.a(3007, jSONObject);
                    a(aVar, "GDTAction初始化失败，init方法的appKey参数不能为空");
                    return false;
                }
                this.n = str2.trim();
                if (!v.a(str3) && !x.matcher(strD).matches()) {
                    com.qq.gdt.action.h.a.a(3008, jSONObject);
                    a(aVar, "GDTAction初始化失败，init方法的channelId参数格式不正确");
                    return false;
                }
                this.v = strD;
                if (v.a(str3)) {
                    strD = D();
                }
                String str5 = strD;
                b(str5);
                this.w = channelType;
                this.H = context;
                if (!q.a(this.l)) {
                    com.qq.gdt.action.h.a.a(3009, jSONObject);
                }
                try {
                    boolean zEquals = h.d().equals(this.u);
                    o.a("isMainProcess = " + zEquals + " getApplicationContext().getPackageName() = " + g().getPackageName() + " processName = " + this.u, new Object[0]);
                    com.qq.gdt.action.h.a.a(zEquals ? 3010 : MspSdkCode.CODE_METHOD_CALL_EXCEPTION, jSONObject);
                } catch (Exception e2) {
                    o.c("getAppPackageName " + e2.getMessage());
                    com.qq.gdt.action.h.a.a(MspSdkCode.CODE_REFLECT_EXCEPTION, jSONObject);
                }
                d(context);
                j.a().b().execute(new Runnable() { // from class: com.qq.gdt.action.d.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            com.qq.gdt.action.j.e.a();
                            d.this.o = com.qq.gdt.action.j.a.a(str2);
                            o.a("aesKey = " + u.c(d.this.o.getEncoded()), new Object[0]);
                            com.qq.gdt.action.i.b.a();
                            b.a(d.this.l);
                            d.this.a(aVar);
                        } catch (Exception e3) {
                            o.c("GDTAction初始化失败，ErrorCode:01，请联系广点通运营" + e3.getMessage());
                            d.this.a(aVar, "GDTAction初始化失败，ErrorCode:01，请联系广点通运营" + e3.getMessage());
                        }
                    }
                });
                com.qq.gdt.action.h.a.a(3013, jSONObject);
                if (z2) {
                    e = true;
                } else {
                    d = true;
                    com.qq.gdt.action.multioprocess.d.a().a(str, str2, channelType, str5, z);
                }
                k = z2;
                jSONObject.put("byAutoInitFinal", k);
                jSONObject.put("ainit", e);
                jSONObject.put("sinit", d);
                com.qq.gdt.action.h.a.a(3014, jSONObject);
                return true;
            } catch (Throwable th) {
                o.b("init e ", th);
                return false;
            }
        }
    }
}
