package com.amap.api.col.p0002sl;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.media3.common.C;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class k {
    static AMapLocation j = null;
    static long k = 0;
    static Object l = new Object();
    static long q = 0;
    static boolean t = false;
    static boolean u = false;
    public static volatile AMapLocation y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Handler f2937a;
    LocationManager b;
    AMapLocationClientOption c;
    lg f;
    private Context z;
    private String A = null;
    private int B = 0;
    private boolean C = false;
    private long D = 0;
    long d = 0;
    boolean e = false;
    private int E = 0;
    int g = 240;
    int h = 80;
    AMapLocation i = null;
    long m = 0;
    float n = 0.0f;
    Object o = new Object();
    Object p = new Object();
    AMapLocationClientOption.GeoLanguage r = AMapLocationClientOption.GeoLanguage.DEFAULT;
    boolean s = true;
    long v = 0;
    int w = 0;
    LocationListener x = null;

    public k(Context context, Handler handler) {
        this.f = null;
        this.z = context;
        this.f2937a = handler;
        try {
            this.b = (LocationManager) context.getSystemService("location");
        } catch (Throwable th) {
            me.a(th, "NetworkLocation", "<init>");
        }
        this.f = new lg();
    }

    private void b(AMapLocation aMapLocation) {
        if (mm.a(aMapLocation) && this.f2937a != null) {
            long jB = mm.b();
            if (this.c.getInterval() <= 8000 || jB - this.v > this.c.getInterval() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble(f.C, aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong("time", aMapLocation.getTime());
                Message messageObtain = Message.obtain();
                messageObtain.setData(bundle);
                messageObtain.what = 14;
                synchronized (this.o) {
                    if (y == null || mm.a(aMapLocation, y) > this.h) {
                        this.f2937a.sendMessage(messageObtain);
                    }
                }
            }
        }
    }

    private void c(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 15 || AMapLocationClientOption.AMapLocationMode.Battery_Saving.equals(this.c.getLocationMode())) {
            if (this.c.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Battery_Saving) && this.c.getDeviceModeDistanceFilter() > 0.0f) {
                d(aMapLocation);
            } else if (mm.b() - this.v >= this.c.getInterval() - 200) {
                this.v = mm.b();
                d(aMapLocation);
            }
        }
    }

    private void d() {
        if (this.b == null) {
            return;
        }
        try {
            e();
            this.s = true;
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper == null) {
                looperMyLooper = this.z.getMainLooper();
            }
            Looper looper = looperMyLooper;
            this.D = mm.b();
            if (!a(this.b)) {
                mg.a();
                a(17, 13, "no network provider#1402", 0L);
                return;
            }
            try {
                if (mm.a() - q >= 259200000) {
                    if (mm.c(this.z, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                        this.b.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", null);
                        q = mm.a();
                        SharedPreferences.Editor editorA = ml.a(this.z, "pref");
                        ml.a(editorA, "lagt", q);
                        ml.a(editorA);
                        mg.a();
                    } else {
                        me.a(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");
                    }
                }
            } catch (Throwable th) {
                new StringBuilder("GpsLocation | sendExtraCommand error: ").append(th.getMessage());
                mg.a();
            }
            if (this.x == null) {
                this.x = new a(this);
            }
            if (!this.c.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Battery_Saving) || this.c.getDeviceModeDistanceFilter() <= 0.0f) {
                this.b.requestLocationUpdates("network", 900L, 0.0f, this.x, looper);
            } else {
                this.b.requestLocationUpdates("network", this.c.getInterval(), this.c.getDeviceModeDistanceFilter(), this.x, looper);
            }
            a(17, 13, "no enough satellites#1401", this.c.getHttpTimeOut());
        } catch (SecurityException e) {
            mg.a();
            this.s = false;
            mk.a((String) null, 2121);
            a(15, 12, e.getMessage() + "#1201", 0L);
        } catch (Throwable th2) {
            new StringBuilder("NetworkLocation | requestLocationUpdates error: ").append(th2.getMessage());
            mg.a();
            me.a(th2, "NetworkLocation", "requestLocationUpdates part2");
        }
    }

    private void e(AMapLocation aMapLocation) {
        try {
            if (!me.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) || !this.c.isOffset()) {
                aMapLocation.setOffset(false);
                aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
                return;
            }
            DPoint dPointA = mh.a(this.z, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
            aMapLocation.setLatitude(dPointA.getLatitude());
            aMapLocation.setLongitude(dPointA.getLongitude());
            aMapLocation.setOffset(this.c.isOffset());
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
        } catch (Throwable unused) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        }
    }

    private AMapLocation f(AMapLocation aMapLocation) {
        if (!mm.a(aMapLocation) || this.E < 3) {
            return aMapLocation;
        }
        if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
            aMapLocation.setAccuracy(0.0f);
        }
        if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
            aMapLocation.setSpeed(0.0f);
        }
        return this.f.a(aMapLocation);
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.c = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.c = new AMapLocationClientOption();
        }
        try {
            q = ml.a(this.z, "pref", "lagt", q);
        } catch (Throwable unused) {
        }
        d();
    }

    public final void a() {
        LocationManager locationManager = this.b;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.x;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((a) this.x).a();
                this.x = null;
            }
        } catch (Throwable unused) {
        }
        try {
            Handler handler = this.f2937a;
            if (handler != null) {
                handler.removeMessages(17);
            }
        } catch (Throwable unused2) {
        }
        this.D = 0L;
        this.v = 0L;
        this.d = 0L;
        this.E = 0;
        this.w = 0;
        this.f.a();
        this.i = null;
        this.m = 0L;
        this.n = 0.0f;
        this.A = null;
    }

    public final boolean c() {
        return mm.b() - this.d <= 2800;
    }

    private void e() {
        if (mm.b() - k > 5000 || !mm.a(j)) {
            return;
        }
        if (this.c.isMockEnable() || !j.isMock()) {
            this.d = mm.b();
            c(j);
        }
    }

    public final boolean b() {
        AMapLocationClientOption aMapLocationClientOption = this.c;
        return (aMapLocationClientOption == null || aMapLocationClientOption.isOnceLocation() || mm.b() - this.d <= 300000) ? false : true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private k f2938a;

        public a(k kVar) {
            this.f2938a = kVar;
        }

        public final void a() {
            this.f2938a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                new StringBuilder("tid=").append(Thread.currentThread().getId());
                mg.a();
                k kVar = this.f2938a;
                if (kVar != null) {
                    kVar.a(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                k kVar = this.f2938a;
                if (kVar != null) {
                    kVar.a(str);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
            try {
                k kVar = this.f2938a;
                if (kVar != null) {
                    kVar.a(i);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }
    }

    private boolean b(String str) {
        try {
            ArrayList<String> arrayListB = mm.b(str);
            ArrayList<String> arrayListB2 = mm.b(this.A);
            if (arrayListB.size() < 8 || arrayListB2.size() < 8) {
                return false;
            }
            return mm.a(this.A, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean a(LocationManager locationManager) {
        try {
            if (t) {
                return u;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders != null && allProviders.size() > 0) {
                u = allProviders.contains("network");
            } else {
                u = false;
            }
            t = true;
            return u;
        } catch (Throwable th) {
            new StringBuilder("NetworkLocation | hasProvider error: ").append(th.getMessage());
            mg.a();
            return u;
        }
    }

    private void a(int i, int i2, String str, long j2) {
        try {
            if (this.f2937a == null || this.c.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Battery_Saving) {
                return;
            }
            Message messageObtain = Message.obtain();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setProvider("network");
            aMapLocation.setErrorCode(i2);
            aMapLocation.setLocationDetail(str);
            aMapLocation.setLocationType(12);
            messageObtain.obj = aMapLocation;
            messageObtain.what = i;
            this.f2937a.sendMessageDelayed(messageObtain, j2);
        } catch (Throwable unused) {
        }
    }

    private void d(AMapLocation aMapLocation) {
        if (this.f2937a != null) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = aMapLocation;
            messageObtain.what = 15;
            this.f2937a.sendMessage(messageObtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        Handler handler = this.f2937a;
        if (handler != null) {
            handler.removeMessages(17);
        }
        if (location == null) {
            return;
        }
        try {
            AMapLocation aMapLocation = new AMapLocation(location);
            if (mm.a(aMapLocation)) {
                aMapLocation.setProvider("network");
                aMapLocation.setLocationType(12);
                if (!this.e && mm.a(aMapLocation)) {
                    mk.a(this.z, mm.b() - this.D, me.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    this.e = true;
                }
                e(aMapLocation);
                AMapLocation aMapLocationF = f(aMapLocation);
                a(aMapLocationF);
                b(aMapLocationF);
                synchronized (this.o) {
                    a(aMapLocationF, y);
                }
                try {
                    if (mm.a(aMapLocationF)) {
                        if (this.i != null) {
                            this.m = location.getTime() - this.i.getTime();
                            this.n = mm.a(this.i, aMapLocationF);
                        }
                        synchronized (this.p) {
                            this.i = aMapLocationF.m10clone();
                        }
                        this.A = null;
                        this.C = false;
                        this.B = 0;
                    }
                } catch (Throwable th) {
                    me.a(th, "NetworkLocation", "onLocationChangedLast");
                }
                c(aMapLocationF);
            }
        } catch (Throwable th2) {
            me.a(th2, "NetworkLocation", "onLocationChanged");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            if ("network".equalsIgnoreCase(str)) {
                this.d = 0L;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 0) {
            try {
                this.d = 0L;
            } catch (Throwable unused) {
            }
        }
    }

    private void a(AMapLocation aMapLocation) {
        if (mm.a(aMapLocation)) {
            this.d = mm.b();
            synchronized (l) {
                k = mm.b();
                j = aMapLocation.m10clone();
            }
            this.E++;
        }
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.g = bundle.getInt("I_MAX_GEO_DIS");
                this.h = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.o) {
                    y = aMapLocation;
                }
            } catch (Throwable th) {
                me.a(th, "NetworkLocation", "setLastGeoLocation");
            }
        }
    }

    private void a(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.c.isNeedAddress() || mm.a(aMapLocation, aMapLocation2) >= this.g) {
            return;
        }
        me.a(aMapLocation, aMapLocation2);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AMapLocation a(AMapLocation aMapLocation, String str) {
        long j2;
        if (this.i == null) {
            return aMapLocation;
        }
        if ((!this.c.isMockEnable() && this.i.isMock()) || !mm.a(this.i)) {
            return aMapLocation;
        }
        float speed = this.i.getSpeed();
        if (speed == 0.0f) {
            long j3 = this.m;
            if (j3 > 0 && j3 < 8) {
                float f = this.n;
                if (f > 0.0f) {
                    speed = f / j3;
                }
            }
        }
        if (aMapLocation == null || !mm.a(aMapLocation)) {
            j2 = 30000;
        } else if (aMapLocation.getAccuracy() < 200.0f) {
            int i = this.B + 1;
            this.B = i;
            if (this.A == null && i >= 2) {
                this.C = true;
            }
            j2 = speed > 5.0f ? 10000L : C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
        } else {
            if (!TextUtils.isEmpty(this.A)) {
                this.C = false;
                this.B = 0;
            }
            if (speed > 5.0f) {
                j2 = 20000;
            }
        }
        long jB = mm.b() - this.d;
        if (jB > 30000) {
            return aMapLocation;
        }
        if (jB >= j2) {
            if (this.C && b(str)) {
                AMapLocation aMapLocationM10clone = this.i.m10clone();
                aMapLocationM10clone.setTrustedLevel(3);
                return aMapLocationM10clone;
            }
            this.A = null;
            this.B = 0;
            synchronized (this.p) {
                this.i = null;
            }
            this.m = 0L;
            this.n = 0.0f;
            return aMapLocation;
        }
        if (this.A == null && this.B >= 2) {
            this.A = str;
        }
        AMapLocation aMapLocationM10clone2 = this.i.m10clone();
        aMapLocationM10clone2.setTrustedLevel(2);
        return aMapLocationM10clone2;
    }
}
