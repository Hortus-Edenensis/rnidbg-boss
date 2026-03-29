package com.beizi.ad.internal.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.beizi.ad.model.BeiZiLocation;
import com.beizi.ad.model.f;
import com.beizi.fusion.model.EnvInfo;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.tool.an;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class q {
    private static q i;
    public String b;
    public String c;
    public long e;
    private EnvInfo j;
    private Context k;
    private boolean l;
    private boolean m;
    private boolean n;
    private long o;
    private long p;
    private f.d f = f.d.NET_OTHER;
    private f.c g = f.c.ISP_OTHER;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4432a = true;
    private int h = -1;
    public String d = AMapLocation.COORD_TYPE_WGS84;

    private q() {
        RequestInfo requestInfo;
        this.o = 86400000L;
        Context contextE = com.beizi.fusion.c.b.a().e();
        this.k = contextE;
        if (contextE == null || (requestInfo = RequestInfo.getInstance(contextE)) == null) {
            return;
        }
        if (!requestInfo.isInit) {
            requestInfo.init();
        }
        this.m = com.beizi.fusion.c.b.a().t();
        this.n = com.beizi.fusion.c.b.a().u();
        if (this.m) {
            long locationFrequency = ResponseInfo.getInstance(this.k).getLocationFrequency();
            if (locationFrequency > 0) {
                this.o = locationFrequency;
            }
        }
        this.j = requestInfo.getEnvInfo();
    }

    public static synchronized q a() {
        if (i == null) {
            synchronized (q.class) {
                if (i == null) {
                    i = new q();
                }
            }
        }
        return i;
    }

    @SuppressLint({"MissingPermission"})
    private synchronized void e() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c)) {
            if (this.l) {
                return;
            }
            this.l = true;
            if (com.beizi.ad.b.a() == null || com.beizi.ad.b.a().a()) {
                Context contextC = com.beizi.ad.internal.c.a().c();
                if (contextC.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.g) == 0 || contextC.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.h) == 0) {
                    if (this.p == 0) {
                        this.p = ((Long) an.b(this.k, "LOCATION_TIME", 0L)).longValue();
                    }
                    if (this.p > 0 && System.currentTimeMillis() - this.p < this.o) {
                        this.b = (String) an.b(this.k, "LOCATION_LONGITUDE", "");
                        this.c = (String) an.b(this.k, "LOCATION_LATITUDE", "");
                        this.e = ((Long) an.b(this.k, "LOCATION_TIMESTAMP", 0L)).longValue();
                        this.l = false;
                        return;
                    }
                    LocationManager locationManager = (LocationManager) contextC.getSystemService("location");
                    if (locationManager == null) {
                        f();
                        this.l = false;
                        return;
                    }
                    String bestProvider = locationManager.getBestProvider(new Criteria(), true);
                    if (TextUtils.isEmpty(bestProvider)) {
                        f();
                        this.l = false;
                        return;
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    this.p = jCurrentTimeMillis;
                    an.a(this.k, "LOCATION_TIME", (Object) Long.valueOf(jCurrentTimeMillis));
                    Location lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                    if (lastKnownLocation != null) {
                        this.b = String.valueOf(lastKnownLocation.getLongitude());
                        this.c = String.valueOf(lastKnownLocation.getLatitude());
                        this.e = lastKnownLocation.getTime();
                        an.a(this.k, "LOCATION_LONGITUDE", (Object) this.b);
                        an.a(this.k, "LOCATION_LATITUDE", (Object) this.c);
                        an.a(this.k, "LOCATION_TIMESTAMP", (Object) Long.valueOf(this.e));
                    } else {
                        f();
                    }
                } else {
                    f();
                }
            } else {
                f();
            }
            this.l = false;
        }
    }

    private void f() {
        BeiZiLocation beiZiLocationB;
        if (com.beizi.ad.b.a() == null || (beiZiLocationB = com.beizi.ad.b.a().b()) == null) {
            return;
        }
        this.b = beiZiLocationB.getLongitude();
        this.c = beiZiLocationB.getLatitude();
        this.d = beiZiLocationB.getType();
        this.e = beiZiLocationB.getTime();
    }

    public f.d b() {
        f.d dVar = this.f;
        f.d dVar2 = f.d.NET_OTHER;
        if (dVar == dVar2) {
            EnvInfo envInfo = this.j;
            if (envInfo != null) {
                String net2 = envInfo.getNet();
                if ("1".equals(net2)) {
                    this.f = f.d.NET_3G;
                } else if ("2".equals(net2)) {
                    this.f = f.d.NET_4G;
                } else if ("3".equals(net2)) {
                    this.f = f.d.NET_5G;
                } else if ("4".equals(net2)) {
                    this.f = f.d.NET_WIFI;
                } else if ("5".equals(net2)) {
                    this.f = dVar2;
                } else if ("6".equals(net2)) {
                    this.f = f.d.NET_2G;
                }
            } else {
                this.f = r.a(com.beizi.ad.internal.c.a().j);
            }
        }
        return this.f;
    }

    public f.c c() {
        f.c cVar = this.g;
        f.c cVar2 = f.c.ISP_OTHER;
        if (cVar == cVar2) {
            EnvInfo envInfo = this.j;
            if (envInfo != null) {
                String isp = envInfo.getIsp();
                if ("0".equals(isp)) {
                    this.g = f.c.ISP_UNKNOWN;
                } else if ("1".equals(isp)) {
                    this.g = f.c.ISP_CN_MOBILE;
                } else if ("2".equals(isp)) {
                    this.g = f.c.ISP_CN_UNICOM;
                } else if ("3".equals(isp)) {
                    this.g = f.c.ISP_CN_TEL;
                }
            } else if (cVar == cVar2) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) com.beizi.ad.internal.c.a().j.getSystemService("phone");
                    if (telephonyManager != null && 5 == telephonyManager.getSimState()) {
                        String simOperator = telephonyManager.getSimOperator();
                        if (simOperator == null) {
                            this.g = f.c.ISP_UNKNOWN;
                        } else if (simOperator.equals("46000") || simOperator.equals("46002") || simOperator.equals("46007")) {
                            this.g = f.c.ISP_CN_MOBILE;
                        } else if (simOperator.equals("46001")) {
                            this.g = f.c.ISP_CN_UNICOM;
                        } else if (simOperator.equals("46003")) {
                            this.g = f.c.ISP_CN_TEL;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return this.g;
    }

    @SuppressLint({"MissingPermission"})
    public void d() {
        try {
            if (TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.c) && !this.l) {
                if (this.m) {
                    e();
                    return;
                }
                this.l = true;
                if (com.beizi.ad.b.a() != null && !com.beizi.ad.b.a().a()) {
                    f();
                    return;
                }
                Context contextC = com.beizi.ad.internal.c.a().c();
                boolean z = contextC.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.g) == 0;
                boolean z2 = contextC.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.h) == 0;
                if (!z && !z2) {
                    f();
                    return;
                }
                LocationManager locationManager = (LocationManager) contextC.getSystemService("location");
                if (locationManager == null) {
                    this.l = false;
                    f();
                    return;
                }
                Location lastKnownLocation = null;
                if (this.n) {
                    String bestProvider = locationManager.getBestProvider(new Criteria(), true);
                    if (!TextUtils.isEmpty(bestProvider)) {
                        lastKnownLocation = locationManager.getLastKnownLocation(bestProvider);
                    } else if (z) {
                        lastKnownLocation = locationManager.getLastKnownLocation(GeocodeSearch.GPS);
                    } else if (z2) {
                        lastKnownLocation = locationManager.getLastKnownLocation("network");
                    }
                } else {
                    Iterator<String> it = locationManager.getProviders(true).iterator();
                    while (it.hasNext()) {
                        Location lastKnownLocation2 = locationManager.getLastKnownLocation(it.next());
                        if (lastKnownLocation2 != null && (lastKnownLocation == null || (lastKnownLocation2.getTime() > 0 && lastKnownLocation.getTime() > 0 && lastKnownLocation2.getTime() > lastKnownLocation.getTime()))) {
                            lastKnownLocation = lastKnownLocation2;
                        }
                    }
                    this.l = false;
                }
                if (lastKnownLocation == null) {
                    f();
                    return;
                }
                this.b = String.valueOf(lastKnownLocation.getLongitude());
                this.c = String.valueOf(lastKnownLocation.getLatitude());
                this.e = lastKnownLocation.getTime();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
