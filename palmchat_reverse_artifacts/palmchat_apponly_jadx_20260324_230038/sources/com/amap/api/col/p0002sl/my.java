package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationOption;
import com.umeng.analytics.pro.f;
import org.apache.cordova.jssdk.general.Action;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class my {
    private static int m = 200;
    private static boolean n = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f3020a;
    Handler f;
    Inner_3dMap_locationOption i;
    mr b = null;
    mz c = null;
    b d = null;
    Handler e = null;
    boolean g = false;
    boolean h = false;
    final int j = 500;
    final int k = 30;
    private JSONArray o = null;
    Object l = new Object();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            my.this.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            super.onLooperPrepared();
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public my(Context context, Handler handler) {
        this.f3020a = null;
        this.f = null;
        this.i = null;
        try {
            if (context == null) {
                throw new IllegalArgumentException("Context参数不能为null");
            }
            this.f3020a = context.getApplicationContext();
            this.f = handler;
            this.i = new Inner_3dMap_locationOption();
            f();
            e();
        } catch (Throwable th) {
            nl.a(th, "LocationService", "<init>");
        }
    }

    private void e() {
        b bVar = new b("locServiceAction");
        this.d = bVar;
        bVar.setPriority(5);
        this.d.start();
        this.e = new a(this.d.getLooper());
    }

    private void f() {
        try {
            if (this.i == null) {
                this.i = new Inner_3dMap_locationOption();
            }
            if (this.h) {
                return;
            }
            this.b = new mr(this.f3020a);
            mz mzVar = new mz(this.f3020a);
            this.c = mzVar;
            mzVar.a(this.i);
            g();
            this.h = true;
        } catch (Throwable th) {
            nl.a(th, "LocationService", "init");
        }
    }

    private void g() {
        try {
            n = no.b(this.f3020a, "maploc", "ue");
            int iA = no.a(this.f3020a, "maploc", "opn");
            m = iA;
            if (iA > 500) {
                m = 500;
            }
            if (m < 30) {
                m = 30;
            }
        } catch (Throwable th) {
            nl.a(th, "LocationService", "getSPConfig");
        }
    }

    private synchronized void h() {
        try {
            JSONArray jSONArray = this.o;
            if (jSONArray != null && jSONArray.length() > 0) {
                ij.a(new ii(this.f3020a, nl.b(), this.o.toString()), this.f3020a);
                this.o = null;
            }
        } catch (Throwable th) {
            nl.a(th, "LocationService", "writeOfflineLog");
        }
    }

    private void i() {
        synchronized (this.l) {
            Handler handler = this.e;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.e = null;
        }
    }

    private void j() {
        synchronized (this.l) {
            Handler handler = this.e;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
    }

    public final void a() {
        try {
            f();
            if (!this.i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving) && !this.g) {
                this.g = true;
                this.b.a();
            }
            Handler handler = this.e;
            if (handler != null) {
                handler.sendEmptyMessage(1);
            }
        } catch (Throwable th) {
            nl.a(th, "LocationService", Action.ACTION_GET_LOCATION);
        }
    }

    public final void b() {
        try {
            if (this.i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Battery_Saving) && this.g) {
                this.b.b();
                this.g = false;
            }
            Inner_3dMap_location inner_3dMap_locationD = this.b.c() ? this.b.d() : !this.i.getLocationMode().equals(Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Device_Sensors) ? this.c.a() : null;
            if (this.f != null && inner_3dMap_locationD != null) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = inner_3dMap_locationD;
                messageObtain.what = 1;
                this.f.sendMessage(messageObtain);
            }
            a(inner_3dMap_locationD);
        } catch (Throwable th) {
            nl.a(th, "LocationService", "doGetLocation");
        }
    }

    public final void c() {
        this.g = false;
        try {
            j();
            mr mrVar = this.b;
            if (mrVar != null) {
                mrVar.b();
            }
        } catch (Throwable th) {
            nl.a(th, "LocationService", "stopLocation");
        }
    }

    public final void d() {
        try {
            c();
            i();
            b bVar = this.d;
            if (bVar != null) {
                try {
                    nn.a(bVar, (Class<?>) HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused) {
                    this.d.quit();
                }
            }
            this.d = null;
            this.c.b();
            this.g = false;
            this.h = false;
            h();
        } catch (Throwable th) {
            nl.a(th, "LocationService", "destroy");
        }
    }

    private void a(Inner_3dMap_location inner_3dMap_location) {
        try {
            if (n && inner_3dMap_location != null && inner_3dMap_location.getErrorCode() == 0 && inner_3dMap_location.getLocationType() == 1) {
                if (this.o == null) {
                    this.o = new JSONArray();
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("lon", inner_3dMap_location.getLongitude());
                jSONObject.put(f.C, inner_3dMap_location.getLatitude());
                jSONObject.put("type", 0);
                jSONObject.put("timestamp", np.a());
                JSONArray jSONArrayPut = this.o.put(jSONObject);
                this.o = jSONArrayPut;
                if (jSONArrayPut.length() >= m) {
                    h();
                }
            }
        } catch (Throwable th) {
            nl.a(th, "LocationService", "recordOfflineLocLog");
        }
    }

    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.i = inner_3dMap_locationOption;
        if (inner_3dMap_locationOption == null) {
            this.i = new Inner_3dMap_locationOption();
        }
        mz mzVar = this.c;
        if (mzVar != null) {
            mzVar.a(inner_3dMap_locationOption);
        }
    }
}
