package com.zenmen.palmchat.location;

import android.content.Context;
import android.location.LocationManager;
import com.amap.api.services.geocoder.GeocodeSearch;
import defpackage.ad3;
import defpackage.ap3;
import defpackage.b05;
import defpackage.b92;
import defpackage.i53;
import defpackage.xo;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {
    public static Boolean c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LocationClientOption f14363a;
    public Set<i53> b = new CopyOnWriteArraySet();

    public b(LocationClientOption locationClientOption) {
        this.f14363a = locationClientOption;
    }

    public static b a(Context context, LocationClientOption locationClientOption, LocationScene locationScene) {
        Boolean bool = c;
        if (bool != null) {
            if (bool.booleanValue()) {
                b05.a("使用百度地图");
                if (locationClientOption == null) {
                    locationClientOption = new LocationClientOption();
                }
                return new xo(context, locationClientOption, locationScene);
            }
            b05.a("使用高德地图");
            if (locationClientOption == null) {
                locationClientOption = new LocationClientOption();
            }
            return new a(context, locationClientOption, locationScene);
        }
        if (ap3.h()) {
            c = Boolean.TRUE;
            b05.a("使用百度地图");
            if (locationClientOption == null) {
                locationClientOption = new LocationClientOption();
            }
            return new xo(context, locationClientOption, locationScene);
        }
        b05.a("使用高德地图");
        c = Boolean.FALSE;
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        return new a(context, locationClientOption, locationScene);
    }

    public static boolean f(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        return locationManager == null || locationManager.isProviderEnabled(GeocodeSearch.GPS);
    }

    public abstract void b(LocationEx locationEx, b92 b92Var);

    public abstract LocationEx c(long j);

    public abstract ad3 d();

    public abstract String e(LocationEx locationEx);

    public abstract boolean g();

    public abstract void h(LocationEx locationEx);

    public void i(i53 i53Var) {
        this.b.add(i53Var);
    }

    public abstract void j(String str, LocationEx locationEx, int i, int i2, String str2);

    public abstract void k(int i, String str, LocationEx locationEx, int i2, int i3, String str2);

    public abstract void l(LocationEx locationEx, int i, int i2);

    public abstract void m(LocationEx locationEx, int i, int i2, String str);

    public abstract void n(String str, int i, String str2);

    public abstract void o();

    public abstract void p(LocationScene locationScene);

    public abstract void q();

    public void r(i53 i53Var) {
        this.b.remove(i53Var);
    }
}
