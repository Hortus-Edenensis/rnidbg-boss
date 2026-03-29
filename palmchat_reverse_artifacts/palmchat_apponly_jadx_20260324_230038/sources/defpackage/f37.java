package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class f37 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f17430a = null;
    public static boolean b = false;
    public static r77 c;
    public static r77 d;
    public static r77 e;
    public static Object f = new Object();
    public static HandlerThread g;
    public static Handler h;
    public static String i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public static volatile f37 n;
    public static volatile f07 o;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 11) {
                Log.e("VMS_IDLG_SDK_Client", "message type valid");
                return;
            }
            String unused = f37.i = f37.o.a(message.getData().getInt("type"), message.getData().getString("appid"));
            synchronized (f37.f) {
                f37.f.notify();
            }
        }
    }

    public static f37 a(Context context) {
        if (n == null) {
            synchronized (f37.class) {
                f17430a = context.getApplicationContext();
                n = new f37();
            }
        }
        if (o == null) {
            synchronized (f37.class) {
                f17430a = context.getApplicationContext();
                l();
                o = new f07(f17430a);
                k();
            }
        }
        return n;
    }

    public static String c(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
            } catch (Exception e2) {
                e2.printStackTrace();
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void e(Context context, int i2, String str) {
        if (i2 == 0) {
            c = new r77(n, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, c);
            return;
        }
        if (i2 == 1) {
            d = new r77(n, 1, str);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, d);
            return;
        }
        if (i2 != 2) {
            return;
        }
        e = new r77(n, 2, str);
        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str), false, e);
    }

    public static void k() {
        b = "1".equals(c("persist.sys.identifierid.supported", "0"));
    }

    public static void l() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        g = handlerThread;
        handlerThread.start();
        h = new a(g.getLooper());
    }

    public String b() {
        if (!h()) {
            return null;
        }
        String str = j;
        if (str != null) {
            return str;
        }
        d(0, null);
        if (c == null) {
            e(f17430a, 0, null);
        }
        return j;
    }

    public void d(int i2, String str) {
        synchronized (f) {
            f(i2, str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                f.wait(2000L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis >= 2000) {
                Log.d("VMS_IDLG_SDK_Client", "query timeout");
            } else if (i2 == 0) {
                j = i;
                i = null;
            } else if (i2 != 1) {
                if (i2 == 2) {
                    String str2 = i;
                    if (str2 != null) {
                        l = str2;
                        i = null;
                    } else {
                        Log.e("VMS_IDLG_SDK_Client", "get aaid failed");
                    }
                } else if (i2 != 4) {
                }
                m = i;
                i = null;
            } else {
                String str3 = i;
                if (str3 != null) {
                    k = str3;
                    i = null;
                } else {
                    Log.e("VMS_IDLG_SDK_Client", "get vaid failed");
                }
            }
        }
    }

    public final void f(int i2, String str) {
        Message messageObtainMessage = h.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2) {
            bundle.putString("appid", str);
        }
        messageObtainMessage.setData(bundle);
        h.sendMessage(messageObtainMessage);
    }

    public boolean h() {
        return b;
    }
}
