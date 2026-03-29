package com.opos.mobad.d.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.sdk.m.x.d;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.kuaishou.weapon.p0.g;
import com.opos.mobad.d.c.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class b {
    private static b b;
    private Context d;
    private volatile CountDownLatch g;
    private volatile LocationManager h;
    private volatile a i;
    private volatile long j;
    private volatile a k;
    private HandlerThread m;
    private Handler n;
    private LocationListener c = new LocationListener() { // from class: com.opos.mobad.d.b.b.1
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            com.opos.cmn.an.f.a.a("LocationManager", "location onLocationChanged location");
            if (location != null) {
                b.this.a(location);
                CountDownLatch countDownLatch = b.this.g;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationListener onProviderDisabled provider=");
            if (str == null) {
                str = com.igexin.push.core.b.m;
            }
            sb.append(str);
            com.opos.cmn.an.f.a.a("LocationManager", sb.toString());
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationListener onProviderEnabled provider=");
            if (str == null) {
                str = com.igexin.push.core.b.m;
            }
            sb.append(str);
            com.opos.cmn.an.f.a.a("LocationManager", sb.toString());
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            StringBuilder sb = new StringBuilder();
            sb.append("LocationListener onStatusChanged provider=");
            String string = com.igexin.push.core.b.m;
            if (str == null) {
                str = com.igexin.push.core.b.m;
            }
            sb.append(str);
            sb.append(",status=");
            sb.append(i);
            sb.append(",extras=");
            if (bundle != null) {
                string = bundle.toString();
            }
            sb.append(string);
            com.opos.cmn.an.f.a.a("LocationManager", sb.toString());
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Application.ActivityLifecycleCallbacks f8745a = new AnonymousClass4();
    private a.b l = new a.b(Integer.MAX_VALUE, 30000);
    private a.c f = new a.c() { // from class: com.opos.mobad.d.b.b.2
        @Override // com.opos.mobad.d.c.a.c
        public void a(final a.InterfaceC0734a interfaceC0734a) {
            com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.mobad.d.b.b.2.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.a(interfaceC0734a);
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("LocationManager", "init fail", e);
                    }
                }
            });
        }
    };
    private a.c e = new a.c() { // from class: com.opos.mobad.d.b.b.3
        @Override // com.opos.mobad.d.c.a.c
        public void a(final a.InterfaceC0734a interfaceC0734a) {
            com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.mobad.d.b.b.3.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b.this.b(interfaceC0734a);
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("LocationManager", "locate fail", e);
                    }
                }
            });
        }
    };

    /* JADX INFO: renamed from: com.opos.mobad.d.b.b$4, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass4 implements Application.ActivityLifecycleCallbacks {
        private AtomicInteger b = new AtomicInteger(0);
        private Runnable c = new Runnable() { // from class: com.opos.mobad.d.b.b.4.1
            @Override // java.lang.Runnable
            @SuppressLint({"MissingPermission"})
            public void run() {
                boolean zA;
                int i = AnonymousClass4.this.b.get();
                boolean z = false;
                if (i < 0) {
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    zA = anonymousClass4.a(b.this.d);
                } else {
                    zA = i != 0;
                }
                if (!zA) {
                    try {
                        if (b.this.g != null) {
                            b.this.g.countDown();
                        }
                        if (b.this.h != null && b.this.g()) {
                            b.this.h.removeUpdates(b.this.c);
                            z = true;
                        }
                    } catch (Throwable th) {
                        com.opos.cmn.an.f.a.d("LocationManager", "onActivityStopped error,", th);
                    }
                }
                com.opos.cmn.an.f.a.b("LocationManager", "onActivityStopped,mCount=" + i + ",isFront=" + zA + ",doRemove=" + z);
            }
        };

        public AnonymousClass4() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
            com.opos.cmn.an.f.a.b("LocationManager", "onActivityStarted,mActivityCount=" + this.b.incrementAndGet());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            this.b.decrementAndGet();
            Handler handler = b.this.n;
            if (handler == null) {
                return;
            }
            handler.removeCallbacks(this.c);
            handler.post(this.c);
        }

        public boolean a(Context context) {
            if (context == null) {
                return true;
            }
            try {
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.d("LocationManager", "isAppBackground error", th);
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                    return runningAppProcessInfo.importance == 100;
                }
                return true;
            }
            return true;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }
    }

    private b() {
    }

    public static b a() {
        b bVar = b;
        if (bVar != null) {
            return bVar;
        }
        synchronized (b.class) {
            if (b == null) {
                b = new b();
            }
        }
        return b;
    }

    @SuppressLint({"MissingPermission"})
    private void e() {
        LocationManager locationManagerH = h();
        if (locationManagerH != null && i()) {
            com.opos.cmn.an.f.a.b("LocationManager", "location gps");
            this.j = SystemClock.elapsedRealtime();
            locationManagerH.requestLocationUpdates(GeocodeSearch.GPS, 60000L, 1.0f, this.c, Looper.getMainLooper());
            this.g = new CountDownLatch(1);
            try {
                try {
                    this.g.await(60000L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("LocationManager", "await fail", e);
                }
            } finally {
                locationManagerH.removeUpdates(this.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return this.d.checkCallingOrSelfPermission(g.g) == 0 && this.d.checkCallingOrSelfPermission(g.h) == 0;
    }

    private LocationManager h() {
        Context context;
        if (this.h == null && (context = this.d) != null) {
            this.h = (LocationManager) context.getSystemService("location");
        }
        return this.h;
    }

    private boolean i() {
        try {
            return h().isProviderEnabled(GeocodeSearch.GPS);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("LocationManager", "", (Throwable) e);
            return false;
        }
    }

    private boolean j() {
        try {
            return h().isProviderEnabled("network");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("LocationManager", "", (Throwable) e);
            return false;
        }
    }

    private a b(Location location) {
        a aVar = new a(location.getLatitude(), location.getLongitude(), location.getElapsedRealtimeNanos());
        aVar.a(Build.VERSION.SDK_INT <= 31 ? location.isFromMockProvider() : location.isMock());
        return aVar;
    }

    @SuppressLint({"MissingPermission"})
    private void f() {
        LocationManager locationManagerH = h();
        if (locationManagerH != null && j()) {
            com.opos.cmn.an.f.a.b("LocationManager", "location net");
            locationManagerH.requestLocationUpdates("network", 10000L, 1.0f, this.c, Looper.getMainLooper());
            this.g = new CountDownLatch(1);
            try {
                try {
                    this.g.await(10000L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("LocationManager", "await fail", e);
                }
            } finally {
                locationManagerH.removeUpdates(this.c);
            }
        }
    }

    public double[] c() {
        double[] dArr = {0.0d, 0.0d};
        if (this.d == null) {
            return dArr;
        }
        a aVar = this.i;
        a aVar2 = this.k;
        if (a(aVar) || a(aVar2)) {
            this.l.a(this.e);
        }
        return !a(aVar) ? a(aVar, dArr) : !a(aVar2) ? a(aVar2, dArr) : (aVar == null || aVar2 == null || aVar2.a() <= aVar.a() + 300000000000L) ? aVar != null ? a(aVar, dArr) : aVar2 != null ? a(aVar2, dArr) : dArr : a(aVar2, dArr);
    }

    public a d() {
        a aVar = new a(0.0d, 0.0d, 0L);
        if (this.d == null) {
            return aVar;
        }
        a aVar2 = this.i;
        a aVar3 = this.k;
        if (a(aVar2) || a(aVar3)) {
            this.l.a(this.e);
        }
        return !a(aVar2) ? aVar2 : !a(aVar3) ? aVar3 : (aVar2 == null || aVar3 == null || aVar3.a() <= aVar2.a() + 300000000000L) ? aVar2 != null ? aVar2 : aVar3 != null ? aVar3 : aVar : aVar3;
    }

    public void a(Context context) {
        if (context != null && this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    Context applicationContext = context.getApplicationContext();
                    this.d = applicationContext;
                    ((Application) applicationContext).registerActivityLifecycleCallbacks(this.f8745a);
                    HandlerThread handlerThread = new HandlerThread("LocationManagerThread");
                    this.m = handlerThread;
                    handlerThread.start();
                    this.n = new Handler(this.m.getLooper());
                }
            }
            this.l.a(this.f);
        }
    }

    @SuppressLint({"MissingPermission"})
    public void b() {
        if (this.d == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("LocationManager", d.z);
        try {
            LocationManager locationManagerH = g() ? h() : null;
            ((Application) this.d).unregisterActivityLifecycleCallbacks(this.f8745a);
            this.d = null;
            CountDownLatch countDownLatch = this.g;
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
            if (locationManagerH != null) {
                locationManagerH.removeUpdates(this.c);
            }
            HandlerThread handlerThread = this.m;
            if (handlerThread != null) {
                handlerThread.quit();
                this.m = null;
                this.n = null;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("LocationManager", "", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        if (GeocodeSearch.GPS.equals(location.getProvider())) {
            a aVar = this.i;
            if (aVar == null || aVar.a() < location.getElapsedRealtimeNanos()) {
                this.i = b(location);
            }
        } else if ("network".equals(location.getProvider())) {
            a aVar2 = this.k;
            if (aVar2 == null || aVar2.a() < location.getElapsedRealtimeNanos()) {
                this.k = b(location);
            }
        } else {
            com.opos.cmn.an.f.a.a("LocationManager", "location with unexpected provider");
        }
        com.opos.cmn.an.f.a.b("LocationManager", "reset location:" + this.i + "," + this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a.InterfaceC0734a interfaceC0734a) {
        if (this.d == null) {
            interfaceC0734a.b();
            return;
        }
        if (!g()) {
            interfaceC0734a.b();
            return;
        }
        if (a(this.k)) {
            f();
            interfaceC0734a.a();
        } else {
            if (this.d == null) {
                interfaceC0734a.b();
                return;
            }
            if (a(this.i) && this.j + 180000 < SystemClock.elapsedRealtime()) {
                e();
            }
            interfaceC0734a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void a(a.InterfaceC0734a interfaceC0734a) {
        if (this.d == null) {
            interfaceC0734a.b();
            return;
        }
        if (!g()) {
            com.opos.cmn.an.f.a.b("LocationManager", "init but not permission");
            interfaceC0734a.b();
            return;
        }
        LocationManager locationManagerH = h();
        if (locationManagerH == null) {
            interfaceC0734a.b();
            return;
        }
        Location lastKnownLocation = locationManagerH.getLastKnownLocation("network");
        if (lastKnownLocation != null) {
            a(lastKnownLocation);
        }
        interfaceC0734a.a();
    }

    private static final boolean a(a aVar) {
        return aVar == null || SystemClock.elapsedRealtimeNanos() - aVar.a() > 300000000000L;
    }

    private double[] a(a aVar, double[] dArr) {
        dArr[0] = ((double) ((int) (aVar.b() * 10000.0d))) / 10000.0d;
        dArr[1] = ((double) ((int) (aVar.c() * 10000.0d))) / 10000.0d;
        return dArr;
    }
}
