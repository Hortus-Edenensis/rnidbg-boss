package com.amap.api.col.p0002sl;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import com.amap.api.maps2d.CoordinateConverter;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.f;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class mr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f3010a;
    LocationManager b;
    Object g;
    volatile long c = 0;
    volatile boolean d = false;
    boolean e = false;
    volatile Inner_3dMap_location f = null;
    boolean h = false;
    boolean i = false;
    LocationListener j = new LocationListener() { // from class: com.amap.api.col.2sl.mr.1
        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            if (location == null) {
                return;
            }
            try {
                Inner_3dMap_location inner_3dMap_location = new Inner_3dMap_location(location);
                inner_3dMap_location.setProvider(GeocodeSearch.GPS);
                inner_3dMap_location.setLocationType(1);
                Bundle extras = location.getExtras();
                inner_3dMap_location.setSatellites(extras != null ? extras.getInt("satellites") : 0);
                inner_3dMap_location.setTime(nm.a(inner_3dMap_location.getTime(), System.currentTimeMillis()));
                mr.this.f = inner_3dMap_location;
                mr.this.c = np.b();
                mr.this.d = true;
            } catch (Throwable th) {
                nl.a(th, "MAPGPSLocation", "onLocationChanged");
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                if (GeocodeSearch.GPS.equals(str)) {
                    mr.this.d = false;
                }
            } catch (Throwable th) {
                nl.a(th, "MAPGPSLocation", "onProviderDisabled");
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
        }
    };

    public mr(Context context) {
        this.g = null;
        if (context == null) {
            return;
        }
        this.f3010a = context;
        e();
        try {
            if (this.g == null && !this.i) {
                this.g = this.h ? Class.forName("com.amap.api.maps.CoordinateConverter").getConstructor(Context.class).newInstance(context) : CoordinateConverter.class.getConstructor(new Class[0]).newInstance(new Object[0]);
            }
        } catch (Throwable unused) {
        }
        if (this.b == null) {
            this.b = (LocationManager) this.f3010a.getSystemService("location");
        }
    }

    private void e() {
        try {
            Class.forName("com.amap.api.maps.CoordinateConverter");
            this.h = true;
        } catch (Throwable unused) {
        }
    }

    private void f() {
        try {
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper == null) {
                looperMyLooper = this.f3010a.getMainLooper();
            }
            Looper looper = looperMyLooper;
            try {
                this.b.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", new Bundle());
            } catch (Throwable unused) {
            }
            this.b.requestLocationUpdates(GeocodeSearch.GPS, 800L, 0.0f, this.j, looper);
        } catch (SecurityException unused2) {
        } catch (Throwable th) {
            nl.a(th, "MAPGPSLocation", "requestLocationUpdates");
        }
    }

    private void g() {
        this.d = false;
        this.c = 0L;
        this.f = null;
    }

    public final void a() {
        if (this.e) {
            return;
        }
        f();
        this.e = true;
    }

    public final void b() {
        LocationListener locationListener;
        this.e = false;
        g();
        LocationManager locationManager = this.b;
        if (locationManager == null || (locationListener = this.j) == null) {
            return;
        }
        locationManager.removeUpdates(locationListener);
    }

    public final boolean c() {
        if (!this.d) {
            return false;
        }
        if (np.b() - this.c <= 10000) {
            return true;
        }
        this.f = null;
        return false;
    }

    public final Inner_3dMap_location d() {
        Object objA;
        Object objNewInstance;
        if (this.f == null) {
            return null;
        }
        Inner_3dMap_location inner_3dMap_locationM41clone = this.f.m41clone();
        if (inner_3dMap_locationM41clone != null && inner_3dMap_locationM41clone.getErrorCode() == 0) {
            try {
                if (this.g != null) {
                    if (nl.a(inner_3dMap_locationM41clone.getLatitude(), inner_3dMap_locationM41clone.getLongitude())) {
                        Object[] objArr = {"GPS"};
                        Class[] clsArr = {String.class};
                        if (this.h) {
                            objA = nn.a("com.amap.api.maps.CoordinateConverter$CoordType", "valueOf", objArr, (Class<?>[]) clsArr);
                            Class<?> cls = Class.forName("com.amap.api.maps.model.LatLng");
                            Class<?> cls2 = Double.TYPE;
                            objNewInstance = cls.getConstructor(cls2, cls2).newInstance(Double.valueOf(inner_3dMap_locationM41clone.getLatitude()), Double.valueOf(inner_3dMap_locationM41clone.getLongitude()));
                        } else {
                            objA = nn.a("com.amap.api.maps2d.CoordinateConverter$CoordType", "valueOf", objArr, (Class<?>[]) clsArr);
                            f fVar = LatLng.CREATOR;
                            Class cls3 = Double.TYPE;
                            objNewInstance = LatLng.class.getConstructor(cls3, cls3).newInstance(Double.valueOf(inner_3dMap_locationM41clone.getLatitude()), Double.valueOf(inner_3dMap_locationM41clone.getLongitude()));
                        }
                        nn.a(this.g, "coord", objNewInstance);
                        nn.a(this.g, "from", objA);
                        Object objA2 = nn.a(this.g, "convert", new Object[0]);
                        double dDoubleValue = ((Double) objA2.getClass().getDeclaredField("latitude").get(objA2)).doubleValue();
                        double dDoubleValue2 = ((Double) objA2.getClass().getDeclaredField("longitude").get(objA2)).doubleValue();
                        inner_3dMap_locationM41clone.setLatitude(dDoubleValue);
                        inner_3dMap_locationM41clone.setLongitude(dDoubleValue2);
                    }
                } else if (this.i && nl.a(inner_3dMap_locationM41clone.getLatitude(), inner_3dMap_locationM41clone.getLongitude())) {
                    double[] dArrA = mn.a(inner_3dMap_locationM41clone.getLongitude(), inner_3dMap_locationM41clone.getLatitude());
                    inner_3dMap_locationM41clone.setLatitude(dArrA[1]);
                    inner_3dMap_locationM41clone.setLongitude(dArrA[0]);
                }
            } catch (Throwable unused) {
            }
        }
        return inner_3dMap_locationM41clone;
    }
}
