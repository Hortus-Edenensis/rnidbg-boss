package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.qq.gdt.action.ActionUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class hn3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f18000a = null;
    public static boolean b = false;
    public static hn3 c;
    public static gn3 d;
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
                p63.a("MeizuIdManager", "message type valid");
                return;
            }
            try {
                String unused = hn3.h = hn3.d.a(message.getData().getString("type"));
            } catch (Throwable th) {
                String unused2 = hn3.h = "";
                p63.a("MeizuIdManager", "getID exception, " + th.getMessage());
            }
            synchronized (hn3.e) {
                hn3.e.notify();
            }
        }
    }

    public static void d() {
        Context context = null;
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
            method.setAccessible(true);
            context = (Context) method.invoke(null, new Object[0]);
        } catch (Exception e2) {
            p63.f("MeizuIdManager", "ActivityThread:currentApplication --> " + e2.toString());
        }
        if (context == null) {
            b = false;
        } else {
            PackageManager packageManager = context.getPackageManager();
            String strH = rv2.h("rIjLIWp9yd1+l2BByOWYjPjGCBlvF2tDounrABnhodw=");
            if (packageManager == null || packageManager.resolveContentProvider(strH, 0) == null) {
                b = false;
            } else {
                try {
                    Cursor cursorQuery = context.getContentResolver().query(Uri.parse(rv2.h("SyfFpc71r1BITMlIo0m1Vt2cR3sdiPGnMd0WMSsF4yU8+J95KN/jHVtZShu2ONYO")), null, null, new String[]{"supported"}, null);
                    if (cursorQuery != null) {
                        cursorQuery.moveToFirst();
                        int columnIndex = cursorQuery.getColumnIndex(ActionUtils.PAYMENT_AMOUNT);
                        if (columnIndex >= 0) {
                            b = "0".equals(cursorQuery.getString(columnIndex));
                        } else {
                            b = false;
                        }
                        cursorQuery.close();
                    }
                } catch (Throwable unused) {
                    p63.a("MeizuIdManager", "mz not support");
                    b = false;
                }
            }
        }
        p63.a("MeizuIdManager", "check meizu supported:" + b);
    }

    public static hn3 f(Context context) {
        if (c == null) {
            c = new hn3();
            f18000a = context;
            i();
            d = new gn3(f18000a);
            d();
        }
        return c;
    }

    public static void i() {
        HandlerThread handlerThread = new HandlerThread("jg_mzdb_thread");
        f = handlerThread;
        handlerThread.start();
        g = new a(f.getLooper());
    }

    public String e(String str) {
        if (!j()) {
            return null;
        }
        String str2 = k;
        if (str2 != null) {
            return str2;
        }
        k(2);
        return k;
    }

    public String g() {
        if (!j()) {
            return null;
        }
        String str = i;
        if (str != null) {
            return str;
        }
        k(0);
        return i;
    }

    public String h(String str) {
        if (!j()) {
            return null;
        }
        String str2 = j;
        if (str2 != null) {
            return str2;
        }
        k(1);
        return j;
    }

    public boolean j() {
        return b;
    }

    public void k(int i2) {
        synchronized (e) {
            l(i2);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                e.wait(2000L);
            } catch (InterruptedException e2) {
                p63.f("MeizuIdManager", "lock wait err: " + e2.getMessage());
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis >= 2000) {
                p63.a("MeizuIdManager", "query timeout");
            } else if (i2 == 0) {
                i = h;
                h = null;
                p63.a("MeizuIdManager", "query aaid: " + i);
            } else if (i2 == 1) {
                String str = h;
                if (str == null) {
                    p63.a("MeizuIdManager", "get ids-va failed");
                } else {
                    j = str;
                    h = null;
                    p63.a("MeizuIdManager", "query aaid: " + j);
                }
            } else if (i2 == 2) {
                String str2 = h;
                if (str2 == null) {
                    p63.a("MeizuIdManager", "get ids-aa failed");
                } else {
                    k = str2;
                    h = null;
                    p63.a("MeizuIdManager", "query aaid: " + k);
                }
            }
        }
    }

    public final void l(int i2) {
        Message messageObtainMessage = g.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        if (i2 == 0) {
            bundle.putString("type", rv2.h("ggTIEepvzybHoO4C7/s5eQ=="));
        } else if (i2 == 1) {
            bundle.putString("type", rv2.h("QlAKJNz4iTmDadRoCSAs4A=="));
        } else if (i2 == 2) {
            bundle.putString("type", rv2.h("bRmfYSLDPlLJ9XQro1+/dQ=="));
        }
        messageObtainMessage.setData(bundle);
        g.sendMessage(messageObtainMessage);
    }
}
