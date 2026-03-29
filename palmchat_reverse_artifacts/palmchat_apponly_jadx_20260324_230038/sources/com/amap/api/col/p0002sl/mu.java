package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationListener;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase;
import com.autonavi.amap.mapcore2d.Inner_3dMap_locationOption;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class mu implements Inner_3dMap_locationManagerBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f3015a;
    ArrayList<Inner_3dMap_locationListener> b = new ArrayList<>();
    Object c = new Object();
    Handler d = null;
    a e = null;
    Handler f = null;
    Inner_3dMap_locationOption g = new Inner_3dMap_locationOption();
    my h = null;
    Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode i = Inner_3dMap_locationOption.Inner_3dMap_Enum_LocationMode.Hight_Accuracy;
    boolean j = false;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        mu f3016a;

        public a(String str, mu muVar) {
            super(str);
            this.f3016a = muVar;
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            try {
                mu muVar = this.f3016a;
                mu muVar2 = this.f3016a;
                muVar.h = new my(muVar2.f3015a, muVar2.d);
                super.onLooperPrepared();
            } catch (Throwable unused) {
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable unused) {
            }
        }
    }

    public mu(Context context) {
        this.f3015a = null;
        if (context == null) {
            throw new IllegalArgumentException("Context参数不能为null");
        }
        this.f3015a = context.getApplicationContext();
        e();
    }

    private Handler a(Looper looper) {
        mv mvVar;
        synchronized (this.c) {
            mvVar = new mv(looper, this);
            this.f = mvVar;
        }
        return mvVar;
    }

    private void e() {
        try {
            this.d = Looper.myLooper() == null ? new mw(this.f3015a.getMainLooper(), this) : new mw(this);
        } catch (Throwable th) {
            nl.a(th, "MapLocationManager", "initResultHandler");
        }
        try {
            a aVar = new a("locaitonClientActionThread", this);
            this.e = aVar;
            aVar.setPriority(5);
            this.e.start();
            this.f = a(this.e.getLooper());
        } catch (Throwable th2) {
            nl.a(th2, "MapLocationManager", "initActionThreadAndActionHandler");
        }
    }

    private void f() {
        synchronized (this.c) {
            Handler handler = this.f;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f = null;
        }
    }

    public final void b() {
        try {
            my myVar = this.h;
            if (myVar != null) {
                myVar.a();
            }
        } catch (Throwable th) {
            try {
                nl.a(th, "MapLocationManager", "doGetLocation");
                if (this.g.isOnceLocation()) {
                    return;
                }
                a(1005, null, this.g.getInterval() >= 1000 ? this.g.getInterval() : 1000L);
            } finally {
                if (!this.g.isOnceLocation()) {
                    a(1005, null, this.g.getInterval() >= 1000 ? this.g.getInterval() : 1000L);
                }
            }
        }
    }

    public final void c() {
        try {
            this.j = false;
            a(1004);
            a(1005);
            my myVar = this.h;
            if (myVar != null) {
                myVar.c();
            }
        } catch (Throwable th) {
            nl.a(th, "MapLocationManager", "doStopLocation");
        }
    }

    public final void d() {
        c();
        my myVar = this.h;
        if (myVar != null) {
            myVar.d();
        }
        ArrayList<Inner_3dMap_locationListener> arrayList = this.b;
        if (arrayList != null) {
            arrayList.clear();
            this.b = null;
        }
        f();
        a aVar = this.e;
        if (aVar != null) {
            try {
                nn.a(aVar, (Class<?>) HandlerThread.class, "quitSafely", new Object[0]);
            } catch (Throwable unused) {
                this.e.quit();
            }
        }
        this.e = null;
        Handler handler = this.d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.d = null;
        }
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase
    public void destroy() {
        try {
            a(1007, null, 0L);
        } catch (Throwable th) {
            nl.a(th, "MapLocationManager", "stopLocation");
        }
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase
    public Inner_3dMap_location getLastKnownLocation() {
        return ms.f3012a;
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase
    public void setLocationListener(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            a(1002, inner_3dMap_locationListener, 0L);
        } catch (Throwable th) {
            nl.a(th, "MapLocationManager", "setLocationListener");
        }
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase
    public void setLocationOption(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        try {
            a(1001, inner_3dMap_locationOption, 0L);
        } catch (Throwable th) {
            nl.a(th, "LocationClientManager", "setLocationOption");
        }
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase
    public void startLocation() {
        try {
            a(1004, null, 0L);
        } catch (Throwable th) {
            nl.a(th, "MapLocationManager", "startLocation");
        }
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase
    public void stopLocation() {
        try {
            a(1006, null, 0L);
        } catch (Throwable th) {
            nl.a(th, "MapLocationManager", "stopLocation");
        }
    }

    @Override // com.autonavi.amap.mapcore2d.Inner_3dMap_locationManagerBase
    public void unRegisterLocationListener(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            a(1003, inner_3dMap_locationListener, 0L);
        } catch (Throwable th) {
            nl.a(th, "MapLocationManager", "stopLocation");
        }
    }

    public final void a() {
        try {
            if (this.j) {
                return;
            }
            this.j = true;
            a(1005, null, 0L);
        } catch (Throwable th) {
            nl.a(th, "MapLocationManager", "doStartLocation");
        }
    }

    public final void b(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        if (inner_3dMap_locationListener != null) {
            try {
                if (!this.b.isEmpty() && this.b.contains(inner_3dMap_locationListener)) {
                    this.b.remove(inner_3dMap_locationListener);
                }
            } catch (Throwable th) {
                nl.a(th, "MapLocationManager", "doUnregisterListener");
                return;
            }
        }
        if (this.b.isEmpty()) {
            c();
        }
    }

    private void a(int i) {
        synchronized (this.c) {
            Handler handler = this.f;
            if (handler != null) {
                handler.removeMessages(i);
            }
        }
    }

    private void a(int i, Object obj, long j) {
        synchronized (this.c) {
            if (this.f != null) {
                Message messageObtain = Message.obtain();
                messageObtain.what = i;
                messageObtain.obj = obj;
                this.f.sendMessageDelayed(messageObtain, j);
            }
        }
    }

    public final void a(Inner_3dMap_location inner_3dMap_location) {
        if (inner_3dMap_location != null) {
            try {
                if (nb.a(inner_3dMap_location)) {
                    ms.f3012a = inner_3dMap_location;
                }
            } catch (Throwable th) {
                nl.a(th, "MapLocationManager", "callBackLocation");
                return;
            }
        }
        if (this.j) {
            if (!GeocodeSearch.GPS.equalsIgnoreCase(inner_3dMap_location.getProvider())) {
                inner_3dMap_location.setProvider("lbs");
            }
            inner_3dMap_location.setAltitude(np.b(inner_3dMap_location.getAltitude()));
            inner_3dMap_location.setBearing(np.a(inner_3dMap_location.getBearing()));
            inner_3dMap_location.setSpeed(np.a(inner_3dMap_location.getSpeed()));
            Iterator<Inner_3dMap_locationListener> it = this.b.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onLocationChanged(inner_3dMap_location);
                } catch (Throwable unused) {
                }
            }
        }
        if (this.g.isOnceLocation()) {
            c();
        }
    }

    public final void a(Inner_3dMap_locationListener inner_3dMap_locationListener) {
        try {
            if (inner_3dMap_locationListener == null) {
                throw new IllegalArgumentException("listener参数不能为null");
            }
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            if (this.b.contains(inner_3dMap_locationListener)) {
                return;
            }
            this.b.add(inner_3dMap_locationListener);
        } catch (Throwable th) {
            nl.a(th, "MapLocationManager", "doSetLocationListener");
        }
    }

    public final void a(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.g = inner_3dMap_locationOption;
        if (inner_3dMap_locationOption == null) {
            this.g = new Inner_3dMap_locationOption();
        }
        my myVar = this.h;
        if (myVar != null) {
            myVar.a(this.g);
        }
        if (this.j && !this.i.equals(inner_3dMap_locationOption.getLocationMode())) {
            c();
            a();
        }
        this.i = this.g.getLocationMode();
    }
}
