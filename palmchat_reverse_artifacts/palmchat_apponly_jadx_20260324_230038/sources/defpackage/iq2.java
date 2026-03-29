package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.huawei.openalliance.ad.constant.x;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class iq2 {
    public static int A = 0;
    public static int B = 0;
    public static int C = 0;
    public static Object b = new Object();
    public static Context c = null;
    public static boolean d = false;
    public static jq2 e;
    public static jq2 f;
    public static jq2 g;
    public static HandlerThread h;
    public static Handler i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public static String n;
    public static String o;
    public static volatile iq2 p;
    public static volatile gu0 q;
    public static int r;
    public static int s;
    public static int t;
    public static int u;
    public static int v;
    public static int w;
    public static int x;
    public static int y;
    public static int z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18226a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (iq2.r + iq2.s + iq2.x + iq2.A + iq2.t + iq2.u + iq2.z + iq2.A + iq2.v + iq2.w + iq2.B + iq2.C > 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("oaid", iq2.this.h(iq2.r, iq2.s, iq2.x, iq2.y));
                contentValues.put("vaid", iq2.this.h(iq2.t, iq2.u, iq2.z, iq2.A));
                contentValues.put("aaid", iq2.this.h(iq2.v, iq2.w, iq2.B, iq2.C));
                iq2.q.b(7, "vivo", new ContentValues[]{contentValues});
                int unused = iq2.r = iq2.s = iq2.t = iq2.u = iq2.v = iq2.w = 0;
                int unused2 = iq2.x = iq2.y = iq2.z = iq2.A = iq2.B = iq2.C = 0;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) throws Throwable {
            if (message.what != 11) {
                Log.e("VMS_SDK_Client", "message type valid");
                return;
            }
            int i = message.getData().getInt("type");
            try {
                String strA = iq2.q.a(i, message.getData().getString("appid"));
                if (i == 0) {
                    String unused = iq2.j = strA;
                    iq2.w(8, iq2.j);
                } else if (i == 1) {
                    if (strA != null) {
                        String unused2 = iq2.k = strA;
                    } else {
                        Log.e("VMS_SDK_Client", "get vaid failed");
                    }
                    iq2.w(9, iq2.k);
                } else if (i == 2) {
                    if (strA != null) {
                        String unused3 = iq2.l = strA;
                    } else {
                        Log.e("VMS_SDK_Client", "get aaid failed");
                    }
                    iq2.w(10, iq2.l);
                } else if (i != 3) {
                    if (i == 4) {
                        String unused4 = iq2.n = strA;
                    } else if (i == 5) {
                        if (strA != null) {
                            String unused5 = iq2.o = strA;
                        } else {
                            Log.e("VMS_SDK_Client", "get guid failed");
                        }
                    }
                } else if (strA != null) {
                    String unused6 = iq2.m = strA;
                } else {
                    Log.e("VMS_SDK_Client", "get udid failed");
                }
            } catch (Exception e) {
                Log.e("VMS_SDK_Client", "readException:" + e.toString());
            }
            synchronized (iq2.b) {
                iq2.b.notify();
            }
        }
    }

    public iq2() {
        d();
        q = new gu0(c);
        this.f18226a = t(c);
    }

    public static void d() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        h = handlerThread;
        handlerThread.start();
        i = new b(h.getLooper());
    }

    public static void e() {
        d = "1".equals(k("persist.sys.identifierid.supported", "0")) || "1".equals(k("persist.sys.identifierid", "0"));
    }

    public static iq2 g(Context context) {
        if (c == null) {
            if (context == null) {
                return null;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                context = applicationContext;
            }
            c = context;
        }
        if (p == null) {
            synchronized (iq2.class) {
                if (p == null) {
                    p = new iq2();
                    p.c();
                }
            }
        }
        return p;
    }

    public static String k(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "0");
            } catch (Exception e2) {
                Log.e("VMS_SDK_Client", "getProperty: invoke is error" + e2.getMessage());
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static synchronized void m(Context context, int i2, String str) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    if (g == null) {
                        g = new jq2(p, 2, str);
                        context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, g);
                    }
                }
            } else if (f == null) {
                f = new jq2(p, 1, str);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, f);
            }
        } else if (e == null) {
            e = new jq2(p, 0, null);
            context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, e);
        }
    }

    public static boolean n() {
        if (!d) {
            e();
        }
        return d;
    }

    public static iq2 p(Context context) {
        if (n()) {
            return g(context);
        }
        return null;
    }

    public static int t(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.vivo.vms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static void w(int i2, String str) {
        if (i2 == 0) {
            if (str == null) {
                s++;
                return;
            }
            r++;
        }
        if (i2 == 1) {
            if (str == null) {
                u++;
                return;
            } else {
                t++;
                return;
            }
        }
        if (i2 == 2) {
            if (str == null) {
                w++;
                return;
            } else {
                v++;
                return;
            }
        }
        switch (i2) {
            case 8:
                if (str != null) {
                    x++;
                } else {
                    y++;
                }
                break;
            case 9:
                if (str != null) {
                    z++;
                } else {
                    A++;
                }
                break;
            case 10:
                if (str != null) {
                    B++;
                } else {
                    C++;
                }
                break;
        }
    }

    public final void B(int i2, String str) {
        synchronized (b) {
            l(i2, str);
            long jUptimeMillis = SystemClock.uptimeMillis();
            try {
                b.wait(2000L);
            } catch (InterruptedException unused) {
                Log.e("VMS_SDK_Client", "queryId: lock error");
            }
            if (SystemClock.uptimeMillis() - jUptimeMillis >= 2000) {
                Log.d("VMS_SDK_Client", "query timeout");
            }
        }
    }

    public final void c() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new a(), 600L, 600L, TimeUnit.SECONDS);
    }

    public final String h(int i2, int i3, int i4, int i5) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i2);
        stringBuffer.append(",");
        stringBuffer.append(i3);
        stringBuffer.append(x.aQ);
        stringBuffer.append(i4);
        stringBuffer.append(",");
        stringBuffer.append(i5);
        return stringBuffer.toString();
    }

    public void l(int i2, String str) {
        Message messageObtainMessage = i.obtainMessage();
        messageObtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i2);
        if (i2 == 1 || i2 == 2 || i2 == 6) {
            bundle.putString("appid", str);
        }
        messageObtainMessage.setData(bundle);
        i.sendMessage(messageObtainMessage);
    }

    public String u() {
        String str = j;
        if (str != null) {
            w(0, str);
            return j;
        }
        B(0, null);
        if (e == null) {
            m(c, 0, null);
        }
        w(0, j);
        return j;
    }
}
