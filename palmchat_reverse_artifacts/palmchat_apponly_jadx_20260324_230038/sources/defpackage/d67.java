package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.cdadata.sdk.api.ZMDataSDKManager;
import com.kuaishou.weapon.p0.g;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class d67 {
    @SuppressLint({"MissingPermission"})
    public static void a(Context context, x57 x57Var) {
        if (ZMDataSDKManager.getInstance().zmConfigOptions.isGPSEnable) {
            if (ContextCompat.checkSelfPermission(context, g.g) != 0 && ContextCompat.checkSelfPermission(context, g.h) != 0) {
                g57.b("LocationUtils", "no location permission");
                return;
            }
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null) {
                g57.b("LocationUtils", "locationManager null");
                return;
            }
            List<String> providers = locationManager.getProviders(true);
            a aVar = new a(x57Var);
            if (providers == null || providers.isEmpty()) {
                g57.b("LocationUtils", "providers null");
                return;
            }
            String str = "network";
            if (!providers.contains("network")) {
                str = GeocodeSearch.GPS;
                if (!providers.contains(GeocodeSearch.GPS)) {
                    str = "passive";
                    if (!providers.contains("passive")) {
                        g57.b("LocationUtils", "providers contains null");
                        return;
                    }
                }
            }
            locationManager.requestSingleUpdate(str, aVar, Looper.getMainLooper());
            b(locationManager.getLastKnownLocation(str), x57Var);
        }
    }

    public static void b(Location location, x57 x57Var) {
        if (location == null) {
            g57.b("LocationUtils", "location null");
            return;
        }
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        if (x57Var != null) {
            x57Var.callBackLocation(String.valueOf(latitude), String.valueOf(longitude));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x57 f16988a;

        public a(x57 x57Var) {
            this.f16988a = x57Var;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            d67.b(location, this.f16988a);
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
    }
}
