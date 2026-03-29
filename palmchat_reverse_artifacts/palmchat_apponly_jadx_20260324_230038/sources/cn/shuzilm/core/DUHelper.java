package cn.shuzilm.core;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.ProxyInfo;
import android.os.Build;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.oplus.tblplayer.monitor.ErrorCode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class DUHelper extends PhoneStateListener {
    public static final int MAIN_DU_ASYNCHRONOUS = 1;
    public static final int MAIN_DU_SYNCHRONOUS = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2461a = "du.lock";
    private static final String b = "du";
    private static AIClient c;
    public static Context mContext;
    public static int mMeic;
    public static int mPopu;
    public static int mPort;
    public static int mSplt;
    private static Timer y;
    private static t z;
    private int C = 2;
    private boolean D = false;
    private long E = 0;
    private static final DUHelper d = new DUHelper();
    private static int e = 0;
    private static int f = 0;
    private static final Lock g = new ReentrantLock();
    private static final Lock h = new ReentrantLock();
    private static final ReentrantReadWriteLock i = new ReentrantReadWriteLock();
    private static boolean j = false;
    private static String k = null;
    private static String l = null;
    private static final JSONObject m = new JSONObject();
    private static final JSONObject n = new JSONObject();
    private static JSONObject o = null;
    private static final ThreadLocal p = new ThreadLocal();
    private static String q = null;
    private static JSONObject r = new JSONObject();
    private static final ExecutorService s = Executors.newSingleThreadExecutor();
    private static final ExecutorService t = Executors.newSingleThreadExecutor();
    private static final ExecutorService u = Executors.newSingleThreadExecutor();
    private static long v = 0;
    private static long w = 0;
    private static volatile boolean x = false;
    private static Timer A = null;
    private static TimerTask B = new f();

    private DUHelper() {
    }

    public static void ZVTFJRA(Context context, Listener listener, int i2, boolean z2) {
        try {
            t.execute(new e(d(context), z2, i2, listener, context));
        } catch (Exception e2) {
            if (listener != null) {
                listener.handler("NA");
            }
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void aXZlZWNl(Context context, Intent intent);

    public static void bm(Context context, String str) {
        try {
            s.execute(new g(d(context), str));
        } catch (Exception unused) {
        }
    }

    private static native String c6M2YmYQ(Context context, int i2);

    private static native String c6M3YmYQ(Context context, int i2, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void dGZvcmRQ(Context context, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(Context context) {
        String packageName = context.getPackageName();
        try {
            int i2 = ((int) context.getPackageManager().getPackageInfo(packageName, 0).firstInstallTime) % 10000;
            int iHashCode = (packageName + Build.MODEL).hashCode();
            if (iHashCode < 0) {
                iHashCode = -iHashCode;
            }
            mPort = (iHashCode % 5000) + ErrorCode.REASON_TEE + i2;
            return 0;
        } catch (Exception e2) {
            mPort = 17835;
            e2.printStackTrace();
            return -1;
        }
    }

    private boolean f(Context context) {
        return true;
    }

    public static void f2c071(int i2, Listener listener) {
        try {
            Context contextD = d(mContext);
            if (contextD == null || k == null) {
                Log.e("[shuzilm]", "[20005] sdk init error.");
                if (listener != null) {
                    listener.handler(null);
                }
            } else if (i2 == 1) {
                getQueryID(mContext, "NA", "", false, 1, new s(contextD, i2, listener), i2 + 100);
            } else {
                String strB = d.b(contextD, i2);
                if (listener != null) {
                    listener.handler(strB);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static /* synthetic */ int g() {
        int i2 = e;
        e = i2 + 1;
        return i2;
    }

    public static String getQueryID(Context context, String str, String str2, boolean z2) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference();
        try {
            getQueryID(context, str, str2, z2, 1, new p(atomicReference, countDownLatch), 2);
            countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
            return (String) atomicReference.get();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return null;
        } catch (NullPointerException unused2) {
            return null;
        }
    }

    public static void go(Context context, String str, String str2) {
        try {
            Context contextD = d(context);
            if (!d.f(contextD)) {
                Log.e("[shuzilm]", "[20002] network is unavailable.");
            } else if (g.tryLock()) {
                try {
                    s.execute(new n(contextD, str, str2));
                } catch (Exception unused) {
                }
                g.unlock();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void init(Context context, String str, boolean z2) {
        mContext = d(context);
        k = str;
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
        } catch (Throwable unused) {
        }
        s.execute(new l(context, z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String j(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_dna", 0);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("device_id", null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Context context) {
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(9);
        if (defaultSensor != null) {
            a(context, sensorManager, defaultSensor);
        }
        Sensor defaultSensor2 = sensorManager.getDefaultSensor(3);
        if (defaultSensor2 != null) {
            a(context, sensorManager, defaultSensor2);
        }
        Sensor defaultSensor3 = sensorManager.getDefaultSensor(11);
        if (defaultSensor3 != null) {
            a(context, sensorManager, defaultSensor3);
        }
        Sensor defaultSensor4 = sensorManager.getDefaultSensor(6);
        if (defaultSensor4 != null) {
            a(context, sensorManager, defaultSensor4);
        }
        Sensor defaultSensor5 = sensorManager.getDefaultSensor(1);
        if (defaultSensor5 != null) {
            a(context, sensorManager, defaultSensor5);
        }
        Sensor defaultSensor6 = sensorManager.getDefaultSensor(4);
        if (defaultSensor6 != null) {
            a(context, sensorManager, defaultSensor6);
        }
        Sensor defaultSensor7 = sensorManager.getDefaultSensor(5);
        if (defaultSensor7 != null) {
            a(context, sensorManager, defaultSensor7);
        }
        Sensor defaultSensor8 = sensorManager.getDefaultSensor(2);
        if (defaultSensor8 != null) {
            a(context, sensorManager, defaultSensor8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void l(Context context) {
        try {
            if (x) {
                return;
            }
            if (e > 0) {
                return;
            }
            x = true;
            Timer timer = new Timer();
            y = timer;
            timer.schedule(new d(context), 30000L);
        } catch (Throwable unused) {
        }
    }

    public static void loadLibrary() {
        s.execute(new k());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(Context context) {
        if (d.f(context)) {
            try {
                if (u.a(mContext, "android.permission.CHANGE_NETWORK_STATE") && u.a(context)) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService("connectivity");
                    NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
                    h hVar = new h(context);
                    oxlbmV0d(context, hVar, 2);
                    connectivityManager.requestNetwork(networkRequestBuild, hVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String n(Context context) {
        String str;
        DUHelper dUHelper = d;
        String strC = dUHelper.D ? c(context, 501, (String) null) : "";
        try {
            JSONObject jSONObject = new JSONObject();
            if (strC == null) {
                strC = "0";
            }
            jSONObject.put("x1", strC);
            jSONObject.put("x2", dUHelper.D ? o(context) : "");
            jSONObject.put("x3", Build.MANUFACTURER + "," + Build.MODEL);
            jSONObject.put("x4", Locale.getDefault().getCountry());
            jSONObject.put("x5", dUHelper.g(context));
            jSONObject.put("x6", u.a(context));
            jSONObject.put("x7", f(context, "660252AEC9476C1C43EF3FB903B3A60E"));
            jSONObject.put("x8", p(context));
            jSONObject.put("x9", Build.VERSION.SDK_INT);
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j2 = w;
            if (j2 > 0) {
                long j3 = v;
                if (j3 > 0) {
                    str = "1," + (j2 - j3);
                } else if (j2 == 0) {
                    long j4 = v;
                    if (j4 > 0) {
                        str = "2," + (jCurrentTimeMillis - j4);
                    } else {
                        str = (j2 == 0 && v == 0) ? "3" : "0";
                    }
                }
            }
            jSONObject.put("x10", str);
            jSONObject.put("x0", String.valueOf(jCurrentTimeMillis));
            jSONObject.put("x11", f(context, "2C281B48F6E872759F787C4106451E4D"));
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "0";
        }
    }

    private static native String nYfbIIFp(Context context, String str, String str2);

    private static native String ntERIJNQ(Context context, int i2, String str);

    public static void o(Context context, String str, String str2, boolean z2, int i2, Listener listener, int i3) {
        c(context, 601, str2);
        getQueryID(context, str, str2, z2, i2, listener, i3);
    }

    private static native String onEvent(Context context, String str, String str2, String str3);

    public static Map onEvent(Context context, String str, String str2, int i2, Listener listener) {
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
        } catch (Throwable unused) {
        }
        if (str == null) {
            return null;
        }
        try {
            Context contextD = d(context);
            if (i2 == 1) {
                d.a(contextD, str, (String) null, str2, listener);
                return null;
            }
            HashMap map = new HashMap();
            Lock lock = g;
            if (!lock.tryLock()) {
                d.a(contextD, str, (String) null, str2, listener);
                return null;
            }
            map.put("SessionID", d.b(contextD, str, null, str2));
            map.put("QueryID", q);
            lock.unlock();
            return map;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native String onIEvent(Context context, String str, String str2, String str3);

    public static void onIEvent(Context context, String str) {
        try {
            s.execute(new c(str, d(context)));
        } catch (Exception unused) {
        }
    }

    private static native void onSSChanged(Context context, SignalStrength signalStrength);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void onSensorChanged(Context context, SensorEvent sensorEvent);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void oxlbmV0d(Context context, Object obj, int i2);

    private static String p(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        if (Build.VERSION.SDK_INT < 23) {
            return "0";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            LinkProperties linkProperties = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork());
            String interfaceName = linkProperties.getInterfaceName();
            ProxyInfo httpProxy = linkProperties.getHttpProxy();
            List<InetAddress> dnsServers = linkProperties.getDnsServers();
            int size = dnsServers.size();
            if (interfaceName == null || interfaceName.isEmpty()) {
                stringBuffer.append("0,");
            } else {
                stringBuffer.append(interfaceName + ",");
            }
            if (httpProxy != null) {
                stringBuffer.append(httpProxy.getHost().toString() + ",");
            } else {
                stringBuffer.append("0,");
            }
            for (int i2 = 0; i2 < size; i2++) {
                stringBuffer.append(dnsServers.get(i2).getHostAddress().toString() + "-");
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return stringBuffer.toString().length() > 0 ? stringBuffer.toString() : "0";
        }
    }

    private static native String query(Context context, String str, String str2, int i2);

    public static void report(Context context, String str, String str2) {
        try {
            Context contextD = d(context);
            if (!d.f(contextD)) {
                Log.e("[shuzilm]", "[20003] network is unavailable.");
            } else if (g.tryLock()) {
                try {
                    s.execute(new o(contextD, str, str2));
                } catch (Exception unused) {
                }
                g.unlock();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native String reportRun(Context context, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native String run(Context context, String str, String str2);

    public static String s(Context context, int i2) {
        try {
            String str = "i" + String.valueOf(i2);
            SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_dna", 0);
            return sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int setConfig(String str, String str2) {
        if (str == null || str2 == null) {
            return -1;
        }
        try {
            d.a(n, str, str2);
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int setData(String str, String str2) throws JSONException {
        d.a(m, str, str2);
        return 0;
    }

    public static int sl(Context context, IntentFilter intentFilter) {
        try {
            if (z == null) {
                z = new t(null);
            }
            if (A != null) {
                return 0;
            }
            context.registerReceiver(z, intentFilter);
            Timer timer = new Timer();
            A = timer;
            timer.schedule(B, 10000L);
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static native String ttERIJNQ(Context context, String str, String str2);

    public static int ul(int i2) {
        try {
            mContext.unregisterReceiver(z);
        } catch (Exception unused) {
        }
        if (i2 != 0) {
            return -1;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("MTZiMjcx");
            aXZlZWNl(mContext, intent);
            Timer timer = A;
            if (timer == null) {
                return -1;
            }
            timer.cancel();
            A = null;
            return -1;
        } catch (Exception unused2) {
            return -1;
        }
    }

    public static int unResListener() {
        try {
            ((TelephonyManager) mContext.getSystemService("phone")).listen(d, 0);
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native String zZVTFJRA(Context context, String str);

    @Override // android.telephony.PhoneStateListener
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        try {
            onSSChanged(mContext, signalStrength);
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        }
    }

    private static Context d(Context context) {
        Context applicationContext;
        try {
            applicationContext = context.getApplicationContext();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return applicationContext != null ? applicationContext : context;
    }

    private boolean g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        try {
            if (Build.VERSION.SDK_INT > 23) {
                if (connectivityManager.getActiveNetwork() != null) {
                    return true;
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return false;
    }

    private JSONObject h(Context context) {
        String strC = c(context, "cn.shuzilm.config.json");
        if (strC != null) {
            return new JSONObject(strC);
        }
        return null;
    }

    private String i(Context context) {
        try {
            DUHelper dUHelper = d;
            Object objD = dUHelper.d(context, "store");
            if (objD instanceof String) {
                return null;
            }
            return dUHelper.e(context, new JSONObject(objD.toString()).getJSONObject("metadata").getString("name"));
        } catch (Exception unused) {
            return null;
        }
    }

    private static String f(Context context, String str) {
        String strB = b(context, str);
        return strB != null ? strB : "0";
    }

    private static String o(Context context) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference();
        try {
            ZVTFJRA(context, new i(atomicReference, countDownLatch), 0, false);
            countDownLatch.await(100L, TimeUnit.MILLISECONDS);
            String str = (String) atomicReference.get();
            return str != null ? str : "0";
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            return "0";
        } catch (NullPointerException unused2) {
            return "0";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i2) {
        if (j) {
            return;
        }
        try {
            t.execute(new m(i2));
            if (i2 == 2) {
                j = true;
            }
        } catch (Throwable unused) {
        }
    }

    private String c(Context context, String str) {
        try {
            InputStream inputStreamOpen = context.getAssets().open(str);
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpen));
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                } else {
                    bufferedReader.close();
                    inputStreamOpen.close();
                    return sb.toString();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private Object d(Context context, String str) {
        try {
            JSONObject jSONObjectH = o;
            if (jSONObjectH == null) {
                jSONObjectH = h(context);
                o = jSONObjectH;
            }
            return jSONObjectH.opt(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private void a(Context context, int i2) {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.E > 7000) {
                s.execute(new RunnableC1320r(this, i2));
                this.E = jCurrentTimeMillis;
            }
        } catch (Exception unused) {
        }
    }

    public static Map getQueryID(Context context, String str, String str2, boolean z2, int i2, Listener listener, int i3) {
        try {
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
        } catch (Throwable unused) {
        }
        String str3 = "0";
        if (z2) {
            b(2);
            setConfig("l_o", "0");
        } else {
            setConfig("l_o", "1");
        }
        try {
            HashMap map = new HashMap();
            Context contextD = d(context);
            DUHelper dUHelper = d;
            dUHelper.C = i3;
            if (i2 == 1) {
                dUHelper.a(contextD, str, str2, listener, i3);
                return null;
            }
            Lock lock = g;
            if (!lock.tryLock()) {
                String strJ = dUHelper.j(contextD);
                if (strJ == null) {
                    dUHelper.a(contextD, str, str2, listener, i3);
                }
                map.put("device_id", strJ);
                map.put("valid", "0");
                return map;
            }
            String strA = dUHelper.a(contextD, str, str2, i3);
            if (strA != null) {
                q = strA;
                str3 = "1";
            }
            if (strA == null && (strA = q) == null) {
                strA = dUHelper.j(contextD);
            }
            map.put("device_id", strA);
            map.put("valid", str3);
            lock.unlock();
            return map;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String b(Context context, String str) {
        if (str == null) {
            return null;
        }
        return context.getSharedPreferences(context.getPackageName() + "_prefs", 0).getString(str, null);
    }

    private String e(Context context, String str) {
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str);
            if (obj != null) {
                return obj.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void m(Context context, int i2, Listener listener) {
        if (i2 == 2) {
            u.execute(new j(context, listener));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(Context context, String str, String str2, String str3) {
        String strOnEvent = null;
        try {
            if (!d.f(context)) {
                Log.e("[shuzilm]", "[20004] network is unavailable.");
                return null;
            }
            a("pEventCode", str);
            if (str2 != null) {
                a("mEventCode", str2);
            }
            ThreadLocal threadLocal = p;
            String string = threadLocal.get() != null ? ((JSONObject) threadLocal.get()).toString() : null;
            String string2 = m.toString();
            synchronized (this) {
                strOnEvent = onEvent(context, string, string2, str3);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (UnsatisfiedLinkError e3) {
            e3.printStackTrace();
        }
        return strOnEvent;
    }

    public static synchronized String c(Context context, int i2, String str) {
        try {
        } catch (Throwable unused) {
            return null;
        }
        return c6M3YmYQ(context, i2, str);
    }

    private String c(Context context, int i2) {
        if (i2 >= 12) {
            return null;
        }
        if (i2 == 0) {
            try {
                Thread.sleep(20L);
            } catch (Throwable unused) {
                return null;
            }
        }
        synchronized (this) {
            String strNYfbIIFp = nYfbIIFp(context, "{}", "{}");
            if (strNYfbIIFp != null && !strNYfbIIFp.isEmpty()) {
                return strNYfbIIFp;
            }
            Thread.sleep(120L);
            return c(context, i2 + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(Context context, int i2) {
        String strC6M2YmYQ;
        try {
            strC6M2YmYQ = c6M2YmYQ(context, i2);
        } catch (Exception unused) {
            strC6M2YmYQ = null;
        }
        if (i2 != 1) {
            a(context, i2);
        }
        return strC6M2YmYQ;
    }

    private void a(Context context, String str, String str2, String str3, Listener listener) {
        s.execute(new q(this, context, str, str2, str3, listener));
    }

    private void a(String str, String str2) {
        try {
            ThreadLocal threadLocal = p;
            JSONObject jSONObject = (JSONObject) threadLocal.get();
            if (jSONObject != null) {
                jSONObject.put(str, str2);
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(str, str2);
            threadLocal.set(jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        jSONObject.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str) throws JSONException {
        a(jSONObject, MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, JSONObject jSONObject, String str) {
        String str2;
        try {
            if (jSONObject.isNull("store")) {
                if (str == null && (str = i(context)) == null) {
                    str = (String) d(context, "store");
                }
                if (str != null) {
                    jSONObject.put("store", str);
                }
            }
            if (!jSONObject.isNull("apiKey") || (str2 = (String) d(context, "apiKey")) == null) {
                return;
            }
            jSONObject.put("apiKey", str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(Context context, String str, String str2, int i2) {
        try {
            try {
                w = 0L;
                v = 0L;
                v = System.currentTimeMillis();
                if (!d.f(context)) {
                    Log.e("[shuzilm]", "[20006] network is unavailable.");
                    return null;
                }
                setConfig("apiKey", k);
                JSONObject jSONObject = n;
                a(context, jSONObject, str);
                JSONObject jSONObject2 = m;
                a(jSONObject2, str2);
                String strQuery = query(context, jSONObject.toString(), jSONObject2.toString(), i2);
                if (strQuery != null) {
                    try {
                        if (!strQuery.isEmpty()) {
                            if (jSONObject.optString("location").equals("1")) {
                                mPopu = 10001;
                            }
                            dl.d(mContext, strQuery, jSONObject.optString("operation").equals("1"));
                        }
                    } catch (Exception unused) {
                    }
                }
                w = System.currentTimeMillis();
                return strQuery;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } catch (UnsatisfiedLinkError e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, Listener listener, int i2) {
        try {
            e++;
            s.execute(new a(this, context, str, str2, i2, listener));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, SensorManager sensorManager, Sensor sensor) {
        sensorManager.registerListener(new b(this, context, sensorManager), sensor, 1);
    }
}
