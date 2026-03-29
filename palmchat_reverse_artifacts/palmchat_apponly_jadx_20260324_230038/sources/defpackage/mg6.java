package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class mg6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f19215a = null;
    public static boolean b = false;
    public static mg6 c;
    public static kg6 d;
    public static Object e = new Object();
    public static HandlerThread f;
    public static Handler g;
    public static String h;
    public static String i;
    public static String j;
    public static String k;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 11) {
                p63.a("VivoIdManager", "message type valid");
                return;
            }
            try {
                String unused = mg6.h = mg6.d.a(message.getData().getInt("type"), message.getData().getString("appid"));
            } catch (Throwable th) {
                String unused2 = mg6.h = "";
                p63.f("VivoIdManager", "vv getIds, exception" + th.getMessage());
            }
            synchronized (mg6.e) {
                mg6.e.notify();
            }
        }
    }

    public static void d() {
        b = "1".equals(h("persist.sys.identifierid.supported", "0"));
    }

    public static mg6 f(Context context) {
        if (c == null) {
            c = new mg6();
            f19215a = context;
            j();
            d = new kg6(f19215a);
            d();
        }
        return c;
    }

    public static String h(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void j() {
        HandlerThread handlerThread = new HandlerThread("jg_vvdb_thread");
        f = handlerThread;
        handlerThread.start();
        g = new a(f.getLooper());
    }

    public String e(String str) {
        if (!k()) {
            return null;
        }
        String str2 = k;
        if (str2 != null) {
            return str2;
        }
        l(2, str);
        return k;
    }

    public String g() {
        if (!k()) {
            return null;
        }
        String str = i;
        if (str != null) {
            return str;
        }
        l(0, null);
        return i;
    }

    public String i(String str) {
        if (!k()) {
            return null;
        }
        String str2 = j;
        if (str2 != null) {
            return str2;
        }
        l(1, str);
        return j;
    }

    public boolean k() {
        return b;
    }

    public void l(int i2, String str) {
        synchronized (e) {
            m(i2, str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                e.wait(2000L);
            } catch (InterruptedException e2) {
                p63.f("VivoIdManager", "lock wait error: " + e2.getMessage());
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis >= 2000) {
                p63.a("VivoIdManager", "query timeout");
            } else if (i2 == 0) {
                i = h;
                h = null;
            } else if (i2 == 1) {
                String str2 = h;
                if (str2 == null) {
                    p63.a("VivoIdManager", "get vaid failed");
                } else {
                    j = str2;
                    h = null;
                }
            } else if (i2 == 2) {
                String str3 = h;
                if (str3 == null) {
                    p63.a("VivoIdManager", "get aaid failed");
                } else {
                    k = str3;
                    h = null;
                }
            }
        }
    }

    public final void m(int i2, String str) {
        Message messageObtainMessage = g.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        messageObtainMessage.setData(bundle);
        g.sendMessage(messageObtainMessage);
    }
}
