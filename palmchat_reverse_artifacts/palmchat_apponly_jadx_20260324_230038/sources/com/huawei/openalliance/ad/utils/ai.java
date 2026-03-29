package com.huawei.openalliance.ad.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.huawei.hms.ads.RequestOptions;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.eh;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.beans.metadata.Location;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.utils.ah;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ai {
    private static Location B = null;
    private static final byte[] C = new byte[0];
    private static final String Code = "LocationUtils";
    private static final int D = 2;
    private static final int F = 1;
    private static LocationManager I = null;
    private static final int L = 1;
    private static long S = -1;
    private static final long V = 30000;
    private static String Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f6956a = 1800000;
    private static volatile boolean b = false;

    private static void B(final Context context) {
        fh.V(Code, "loc_tag sendAsyncLocation go!");
        if (I(context)) {
            S = System.currentTimeMillis();
            fh.V(Code, "update lastRefreshTime");
            i.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ai.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ai.Z(context);
                    } catch (Throwable th) {
                        fh.Z(ai.Code, "loc_tag asyncLocation exception: " + th.getClass().getSimpleName());
                    }
                }
            });
        }
    }

    private static void C(final Context context) {
        fh.Code(Code, "loc_tag getLocationByKit");
        try {
            new ah(context, new ah.a() { // from class: com.huawei.openalliance.ad.utils.ai.5
                @Override // com.huawei.openalliance.ad.utils.ah.a
                public void Code() {
                    try {
                        ai.V(context, 2);
                    } catch (Throwable th) {
                        fh.V(ai.Code, "onLocationAcquireFailed ex: %s", th.getClass().getSimpleName());
                    }
                }

                @Override // com.huawei.openalliance.ad.utils.ah.a
                public void Code(android.location.Location location) {
                    try {
                        ai.Code(location);
                    } catch (Throwable th) {
                        fh.V(ai.Code, "onLocationAcquired ex: %s", th.getClass().getSimpleName());
                    }
                }
            }).Code();
        } catch (Throwable th) {
            fh.Z(Code, "loc_tag getLocationByKit, exception = " + th.getClass().getSimpleName());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v8 */
    private static com.huawei.openalliance.ad.beans.inner.b D(Context context) {
        ?? A;
        boolean zI = cn.Code(context).I();
        boolean zB = b(context);
        boolean z = false;
        try {
            A = a(context);
        } catch (Throwable th) {
            fh.Z(Code, "loc_tag hasLocationPermission = " + th.getClass().getSimpleName());
            A = 0;
        }
        if (fh.Code()) {
            fh.Code(Code, "loc_tag isBaseLocationSwitch = %s", Boolean.valueOf(zI));
            fh.Code(Code, "loc_tag isGpsSwitchOpen = %s", Boolean.valueOf(zB));
            fh.Code(Code, "loc_tag hasLocationPermission = %s", Boolean.valueOf((boolean) A));
        }
        com.huawei.openalliance.ad.beans.inner.b bVar = new com.huawei.openalliance.ad.beans.inner.b();
        bVar.Code(zI ? 1 : 0);
        bVar.V(zB ? 1 : 0);
        bVar.I(A);
        if (zI && zB && A != 0) {
            z = true;
        }
        bVar.V(z);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.huawei.openalliance.ad.beans.inner.b F(Context context) {
        com.huawei.openalliance.ad.beans.inner.b bVarD = D(context);
        boolean z = false;
        if (bVarD.B()) {
            boolean zC = eh.Code(context).C();
            fh.Code(Code, "loc_tag isSdkServerLocationSwitch = %s", Boolean.valueOf(zC));
            z = zC;
        }
        bVarD.Code(z);
        return bVarD;
    }

    private static boolean I(Context context) {
        long jAbs = Math.abs(System.currentTimeMillis() - S);
        f6956a = eh.Code(context).F();
        fh.Code(Code, "loc_tag isRefreshOk intervalRefreshTime = " + f6956a + ", intervalTime = " + jAbs);
        if (jAbs >= f6956a) {
            return true;
        }
        fh.Code(Code, "loc_tag isRefreshOk = false, too frequently (no ok)");
        return false;
    }

    private static boolean L(Context context) {
        String str;
        if (context == null) {
            str = "loc_tag isGpsSwitchOpen Context is null";
        } else {
            try {
                int i = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
                fh.V(Code, "loc_tag isGpsSwitchOpen locationMode is " + i);
                return i == 3;
            } catch (Settings.SettingNotFoundException unused) {
                str = "loc_tag isGpsSwitchOpen SettingNotFoundException";
            }
        }
        fh.Z(Code, str);
        return false;
    }

    private static boolean S(Context context) {
        boolean z;
        try {
            Class.forName("com.huawei.hms.location.LocationServices");
            Class.forName("com.huawei.hms.location.FusedLocationProviderClient");
            z = true;
        } catch (Throwable unused) {
            fh.Z(Code, "loc_tag check location sdk available error");
            z = false;
        }
        return z && h.Code(context, h.I(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Z(Context context) {
        if (S(context)) {
            fh.V(Code, "loc_tag asyncLocation has location-sdk");
            try {
                C(context);
                return;
            } catch (Throwable th) {
                fh.I(Code, "loc_tag get location by kit error, " + th.getClass().getSimpleName());
                fh.Code(5, th);
            }
        } else {
            fh.V(Code, "loc_tag asyncLocation has not location-sdk");
        }
        V(context, 2);
    }

    @TargetApi(23)
    private static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (!V()) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.kuaishou.weapon.p0.g.g);
        arrayList.add(com.kuaishou.weapon.p0.g.h);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!as.Code(context, (String) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(Context context) {
        try {
            return L(context);
        } catch (Throwable th) {
            fh.I(Code, "get location service switch exception: " + th.getClass().getSimpleName());
            return false;
        }
    }

    public static Location Code(Context context, RequestOptions requestOptions, Location location) {
        boolean zV = V(context, requestOptions);
        boolean z = false;
        fh.V(Code, "loc_tag media allow: %s", Boolean.valueOf(zV));
        com.huawei.openalliance.ad.beans.inner.b bVarF = F(context);
        if (zV && bVarF.Z()) {
            z = true;
        }
        Location location2 = null;
        if (!z) {
            fh.V(Code, "loc_tag isLocationAvailable = false, return null");
        } else if (location == null) {
            B(context);
            Location location3 = B;
            if (location3 != null) {
                location2 = location3.Code();
            }
        } else {
            location2 = location.Code();
            location2.Code(Long.valueOf(System.currentTimeMillis()));
            location2.Code(1);
        }
        if (location2 == null) {
            location2 = new Location();
        }
        location2.Code(bVarF);
        return location2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(Context context, int i) {
        fh.Code(Code, "loc_tag getLocationByNative");
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        I = locationManager;
        if (locationManager == null) {
            fh.Z(Code, "loc_tag getLocationByNative, nativeLocationManager is null, return");
            return;
        }
        List<String> providers = locationManager.getProviders(true);
        String str = "network";
        if (!providers.contains("network")) {
            str = GeocodeSearch.GPS;
            if (!providers.contains(GeocodeSearch.GPS)) {
                fh.I(Code, "loc_tag nativeLocationProvider wrong, return");
                return;
            }
        }
        Z = str;
        if (fh.Code()) {
            fh.Code(Code, "loc_tag native location provider is: %s", Z);
        }
        try {
            String str2 = Z;
            if (str2 != null) {
                if (1 == i) {
                    android.location.Location lastKnownLocation = I.getLastKnownLocation(str2);
                    if (lastKnownLocation == null) {
                        fh.I(Code, "loc_tag getLocationByNative, but location is null");
                        return;
                    } else {
                        fh.Code(Code, "loc_tag getLocationByNative getLastKnownLocation lat = %s, lon = %s", bl.Code(String.valueOf(lastKnownLocation.getLatitude())), bl.Code(String.valueOf(lastKnownLocation.getLongitude())));
                        Code(lastKnownLocation);
                        return;
                    }
                }
                if (2 != i) {
                    fh.Code(Code, "loc_tag requestLocationByNative not correct type");
                    return;
                }
                fh.V(Code, "loc_tag getLocationByNative requestLocationUpdates");
                b = false;
                final LocationListener locationListener = new LocationListener() { // from class: com.huawei.openalliance.ad.utils.ai.3
                    @Override // android.location.LocationListener
                    public void onLocationChanged(android.location.Location location) {
                        try {
                            if (location != null) {
                                fh.Code(ai.Code, "loc_tag getLocationByNative Listener lat = %s, lon = %s", bl.Code(String.valueOf(location.getLatitude())), bl.Code(String.valueOf(location.getLongitude())));
                                ai.Code(location);
                            } else {
                                fh.I(ai.Code, "loc_tag getLocationByNative Listener, but location is null");
                            }
                        } catch (Throwable th) {
                            fh.V(ai.Code, "onLocationChanged ex: %s", th.getClass().getSimpleName());
                        }
                        ai.V(this);
                    }

                    @Override // android.location.LocationListener
                    public void onProviderDisabled(String str3) {
                        fh.Code(ai.Code, "loc_tag getLocationByNative onProviderDisabled");
                        ai.V(this);
                    }

                    @Override // android.location.LocationListener
                    public void onProviderEnabled(String str3) {
                        fh.Code(ai.Code, "loc_tag getLocationByNative onProviderEnabled");
                        ai.V(this);
                    }

                    @Override // android.location.LocationListener
                    public void onStatusChanged(String str3, int i2, Bundle bundle) {
                        fh.Code(ai.Code, "loc_tag getLocationByNative onStatusChanged");
                        ai.V(this);
                    }
                };
                I.requestSingleUpdate(Z, locationListener, Looper.getMainLooper());
                bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ai.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (ai.b) {
                            return;
                        }
                        ai.V(locationListener);
                    }
                }, 30000L);
            }
        } catch (Throwable th) {
            fh.Z(Code, "loc_tag getLocationByNative, exception = " + th.getClass().getSimpleName());
        }
    }

    public static Location Code(android.location.Location location) {
        if (location == null) {
            return null;
        }
        synchronized (C) {
            if (B == null) {
                B = new Location();
            }
            B.Code(Double.valueOf(location.getLongitude()));
            B.V(Double.valueOf(location.getLatitude()));
            B.Code(Long.valueOf(System.currentTimeMillis()));
        }
        return B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void V(LocationListener locationListener) {
        if (b || I == null || locationListener == null) {
            return;
        }
        fh.V(Code, "loc_tag remove native location updates");
        try {
            I.removeUpdates(locationListener);
        } catch (Throwable th) {
            fh.V(Code, "loc_tag remove native location updates ex: %s", th.getClass().getSimpleName());
        }
        b = true;
    }

    private static boolean V() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static void Code(final Context context, RequestOptions requestOptions) {
        if (V(context, requestOptions) && I(context)) {
            if (fh.Code()) {
                fh.Code(Code, "loc_tag sendAsyncLocationByNative go!");
            }
            i.I(new Runnable() { // from class: com.huawei.openalliance.ad.utils.ai.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ai.F(context).Z()) {
                        ai.V(context, 1);
                    } else {
                        fh.V(ai.Code, "loc_tag sendAsyncLocationByNative failed because switch is off");
                    }
                }
            });
        }
    }

    private static boolean V(Context context, RequestOptions requestOptions) {
        Boolean boolB;
        if (requestOptions == null || requestOptions.B() == null) {
            RequestOptions requestConfiguration = HiAd.getInstance(context).getRequestConfiguration();
            if (requestConfiguration == null || requestConfiguration.B() == null) {
                return true;
            }
            boolB = requestConfiguration.B();
        } else {
            boolB = requestOptions.B();
        }
        return boolB.booleanValue();
    }
}
