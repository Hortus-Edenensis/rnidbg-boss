package com.bytedance.sdk.openadsdk.core.y;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private static volatile long b = 0;
    private static volatile fx fx = null;
    private static long nr = 60000;
    private static volatile long pn = 0;
    private static long u = 1800000;

    /* JADX INFO: compiled from: SearchBox */
    public static class nr implements Callable<Location> {
        private String nr;
        private LocationManager u;

        public nr(LocationManager locationManager, String str) {
            this.u = locationManager;
            this.nr = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            System.currentTimeMillis();
            Location lastKnownLocation = this.u.getLastKnownLocation(this.nr);
            System.currentTimeMillis();
            return lastKnownLocation;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u implements Callable<com.bytedance.sdk.openadsdk.my.fx.fx.fx> {
        private u() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.bytedance.sdk.openadsdk.my.fx.fx.fx call() throws Exception {
            return com.bytedance.sdk.openadsdk.core.n.o().sx().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context) {
        com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("getLocation c") { // from class: com.bytedance.sdk.openadsdk.core.y.b.3
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                fx fxVarPn = b.pn(context2 == null ? com.bytedance.sdk.openadsdk.core.dw.getContext() : context2.getApplicationContext());
                long unused = b.b = 0L;
                if (fxVarPn != null) {
                    fx unused2 = b.fx = fxVarPn;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("latitude", Float.toString(fxVarPn.u));
                        jSONObject.put("longitude", Float.toString(fxVarPn.nr));
                        jSONObject.put("lbstime", fxVarPn.fx);
                        String string = jSONObject.toString();
                        String strNr = com.bytedance.sdk.component.utils.u.nr(string);
                        com.bytedance.sdk.openadsdk.core.fx.b.u().b("sdk_ad_location", string);
                        com.bytedance.sdk.openadsdk.core.fx.b.u().b("new_sdk_ad_location", strNr);
                    } catch (JSONException unused3) {
                    }
                }
            }
        });
    }

    private static LocationManager iz(Context context) {
        try {
            return (LocationManager) context.getSystemService("location");
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static fx pn(final Context context) {
        fx fxVar = null;
        if (!com.bytedance.sdk.openadsdk.core.n.o().sx().u()) {
            try {
                com.bytedance.sdk.openadsdk.my.fx.fx.fx fxVarFx = fx();
                if (fxVarFx != null) {
                    return new fx(Double.valueOf(fxVarFx.u()).floatValue(), Double.valueOf(fxVarFx.nr()).floatValue(), System.currentTimeMillis());
                }
            } catch (Throwable unused) {
            }
            return null;
        }
        final LocationManager locationManagerIz = iz(context);
        if (locationManagerIz != null) {
            try {
                Location locationU = u(locationManagerIz);
                if (locationU != null && nr(locationU)) {
                    fxVar = new fx((float) locationU.getLatitude(), (float) locationU.getLongitude(), System.currentTimeMillis());
                }
                com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        b.nr(context, locationManagerIz);
                    }
                });
            } catch (Throwable unused2) {
            }
        }
        return fxVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static com.bytedance.sdk.openadsdk.my.fx.fx.fx fx() {
        try {
            final com.bytedance.sdk.component.jk.n nVar = new com.bytedance.sdk.component.jk.n(new u(), 1, 2);
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("getLastKnownLocation") { // from class: com.bytedance.sdk.openadsdk.core.y.b.6
                @Override // java.lang.Runnable
                public void run() {
                    nVar.run();
                }
            });
            return (com.bytedance.sdk.openadsdk.my.fx.fx.fx) nVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean nr() {
        return System.currentTimeMillis() - b > nr;
    }

    private static String nr(LocationManager locationManager) {
        if (locationManager.isProviderEnabled(GeocodeSearch.GPS)) {
            return GeocodeSearch.GPS;
        }
        if (locationManager.isProviderEnabled("network")) {
            return "network";
        }
        if (locationManager.isProviderEnabled("passive")) {
            return "passive";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(Context context, final LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        final LocationListener locationListener = new LocationListener() { // from class: com.bytedance.sdk.openadsdk.core.y.b.7
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                if (location != null) {
                    b.nr(location);
                }
                b.nr(locationManager, this);
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i, Bundle bundle) {
            }
        };
        try {
            if (TextUtils.isEmpty(nr(locationManager))) {
                return;
            }
            locationManager.requestSingleUpdate("network", locationListener, Looper.myLooper());
            com.bytedance.sdk.component.utils.jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.b.8
                @Override // java.lang.Runnable
                public void run() {
                    b.nr(locationManager, locationListener);
                }
            }, 30000L);
        } catch (Throwable unused) {
            nr(locationManager, locationListener);
        }
    }

    public static com.bytedance.sdk.component.b.u.fx u(Context context) {
        return u(context, !com.bytedance.sdk.openadsdk.core.fx.u.nr());
    }

    public static fx u(final Context context, boolean z) {
        if ((fx != null && !u()) || !nr()) {
            return fx;
        }
        String strFx = com.bytedance.sdk.component.utils.u.fx(com.bytedance.sdk.openadsdk.core.fx.b.u().b("new_sdk_ad_location", 2147483647L));
        if (strFx != null) {
            try {
                JSONObject jSONObject = new JSONObject(strFx);
                String strOptString = jSONObject.optString("latitude");
                String strOptString2 = jSONObject.optString("longitude");
                long jOptLong = jSONObject.optLong("lbstime");
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                    fx = new fx(Float.valueOf(strOptString).floatValue(), Float.valueOf(strOptString2).floatValue(), jOptLong);
                    pn = jOptLong;
                }
            } catch (Throwable unused) {
            }
            if (z) {
                return fx;
            }
        }
        if (fx != null && !u()) {
            return fx;
        }
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = com.bytedance.sdk.openadsdk.core.n.o().sx();
        if (!bVarSx.u()) {
            com.bytedance.sdk.openadsdk.my.fx.fx.fx fxVarA = bVarSx.a();
            if (fxVarA != null) {
                pn = System.currentTimeMillis();
                fx = new fx((float) fxVarA.u(), (float) fxVarA.nr(), System.currentTimeMillis());
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (fx != null) {
                    jSONObject2.put("latitude", Float.toString(fx.u));
                    jSONObject2.put("longitude", Float.toString(fx.nr));
                    jSONObject2.put("lbstime", fx.fx);
                }
                String string = jSONObject2.toString();
                String strNr = com.bytedance.sdk.component.utils.u.nr(string);
                com.bytedance.sdk.openadsdk.core.fx.b.u().b("sdk_ad_location", string);
                com.bytedance.sdk.openadsdk.core.fx.b.u().b("new_sdk_ad_location", strNr);
            } catch (Exception unused2) {
            }
            return fx;
        }
        pn = System.currentTimeMillis();
        b = System.currentTimeMillis();
        if (com.bytedance.sdk.openadsdk.core.b.u.n()) {
            new com.bytedance.sdk.openadsdk.core.b.nr("device_locate").u(5).u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.b.2
                @Override // java.lang.Runnable
                public void run() {
                    long unused3 = b.b = 0L;
                }
            }).nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.b(context);
                }
            });
        } else {
            b(context);
        }
        return fx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean nr(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }

    private static boolean u() {
        return System.currentTimeMillis() - pn > u;
    }

    private static Location u(LocationManager locationManager) {
        Location locationU = u(locationManager, GeocodeSearch.GPS);
        if (locationU == null) {
            locationU = u(locationManager, "network");
        }
        return locationU == null ? u(locationManager, "passive") : locationU;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Location u(LocationManager locationManager, String str) {
        try {
            final com.bytedance.sdk.component.jk.n nVar = new com.bytedance.sdk.component.jk.n(new nr(locationManager, str), 1, 2);
            com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("getLastKnownLocation") { // from class: com.bytedance.sdk.openadsdk.core.y.b.5
                @Override // java.lang.Runnable
                public void run() {
                    nVar.run();
                }
            });
            return (Location) nVar.get(1L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }
}
