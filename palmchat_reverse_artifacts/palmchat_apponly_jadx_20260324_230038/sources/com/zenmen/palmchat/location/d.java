package com.zenmen.palmchat.location;

import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.Log;
import com.zenmen.palmchat.framework.BaseActivityPermissionDispatcher;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.location.LocationClientOption;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.az2;
import defpackage.b92;
import defpackage.hx3;
import defpackage.i53;
import defpackage.ir5;
import defpackage.n53;
import defpackage.tg4;
import defpackage.u93;
import defpackage.zn6;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static d k = null;
    public static boolean l = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LocationEx f14365a;
    public com.zenmen.palmchat.location.b c;
    public LocationScene e;
    public long f;
    public CountDownTimer g;
    public long h;
    public boolean i;
    public HashSet<i53> j;
    public long b = 0;
    public i53 d = null;

    /* JADX INFO: compiled from: SearchBox */
    public class b extends CountDownTimer {
        public b(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            LogUtil.i("SimpleLocationHelper", "mCountDownTimer onFinish");
            d.this.s();
            d.this.n(null, -10010, "location_timeout");
            HashMap map = new HashMap();
            map.put("platform", String.valueOf(1));
            map.put("Service", String.valueOf(LocationServiceType.LOCATION.value));
            if (d.this.e != null) {
                map.put("scene", String.valueOf(d.this.e.value));
            }
            zn6.i("location_fail_timeout", map);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            LogUtil.i("SimpleLocationHelper", "mCountDownTimer onTick");
        }
    }

    public d() {
        LocationScene locationScene = LocationScene.DEFAULT;
        this.e = locationScene;
        this.f = 10000L;
        this.g = null;
        this.i = false;
        this.j = new HashSet<>();
        LocationClientOption locationClientOption = new LocationClientOption();
        locationClientOption.e(LocationClientOption.LocationMode.High_Accuracy);
        locationClientOption.f(true);
        locationClientOption.d(10000);
        this.c = com.zenmen.palmchat.location.b.a(com.zenmen.palmchat.c.b(), locationClientOption, locationScene);
        p();
        q();
    }

    public static d g() {
        if (k == null) {
            synchronized (d.class) {
                if (k == null) {
                    k = new d();
                }
            }
        }
        return k;
    }

    public final CountDownTimer f() {
        if (this.g == null) {
            try {
                this.g = new b(this.f, 1000L);
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.i("SimpleLocationHelper", "new timer error", e);
            }
        }
        return this.g;
    }

    public LocationEx h() {
        return this.f14365a;
    }

    public LocationEx i(long j) {
        LocationEx locationExC;
        if (m(j)) {
            locationExC = this.f14365a;
        } else {
            try {
                if (!o() || System.currentTimeMillis() - this.h <= 300000) {
                    locationExC = null;
                } else {
                    locationExC = this.c.c(j);
                    try {
                        this.h = System.currentTimeMillis();
                        if (locationExC != null) {
                            t(locationExC);
                        }
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e = e2;
                locationExC = null;
            }
        }
        if (locationExC != null) {
            this.f14365a = locationExC;
            LogUtil.d("SimpleLocationHelper", "getLastLocation :" + locationExC.toString());
        } else {
            LogUtil.d("SimpleLocationHelper", "getLastLocation : null");
        }
        return locationExC;
    }

    public void j(LocationScene locationScene, long j, i53 i53Var) {
        if (i53Var == null) {
            return;
        }
        if (m(j * 1000)) {
            LogUtil.i("SimpleLocationHelper", "getLastLocation hitCache " + this.f14365a);
            i53Var.onLocationReceived(this.f14365a, 0, "");
            return;
        }
        if (!q()) {
            i53Var.onLocationReceived(null, -1, "");
            return;
        }
        if (!tg4.b(com.zenmen.palmchat.c.b(), BaseActivityPermissionDispatcher.PermissionType.LOCATION.permissionList)) {
            i53Var.onLocationReceived(null, -10, "没有权限");
            return;
        }
        if (!hx3.m(com.zenmen.palmchat.c.b())) {
            i53Var.onLocationReceived(null, -1, "网络断开");
            return;
        }
        synchronized (d.class) {
            Log.d("LxLog", i53Var.hashCode() + "增加到回调");
            this.j.add(i53Var);
            if (!this.i) {
                this.i = true;
                r(locationScene);
            }
        }
    }

    public void k(LocationScene locationScene, i53 i53Var) {
        j(locationScene, c.a(locationScene), i53Var);
    }

    public String l(LocationEx locationEx) {
        String strE = null;
        try {
            if (o()) {
                strE = this.c.e(locationEx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtil.d("SimpleLocationHelper", "getStaticMapImageUrl : " + strE);
        return strE;
    }

    public final boolean m(long j) {
        return this.f14365a != null && Math.abs(System.currentTimeMillis() - this.b) <= j;
    }

    public final void n(LocationEx locationEx, int i, String str) {
        synchronized (d.class) {
            this.i = false;
            LogUtil.d("SimpleLocationHelper", "process onLocationFinished mCacheListener size ======== " + this.j.size());
            for (i53 i53Var : this.j) {
                LogUtil.d("SimpleLocationHelper", "get l " + i53Var);
                if (i53Var != null) {
                    i53Var.onLocationReceived(locationEx, i, str);
                }
            }
            this.j.clear();
        }
    }

    public final boolean o() {
        if (!this.c.g()) {
            this.c = com.zenmen.palmchat.location.b.a(com.zenmen.palmchat.c.b(), null, LocationScene.DEFAULT);
        }
        return this.c.g();
    }

    public final void p() {
        String strN = SPUtil.f14322a.n(SPUtil.SCENE.LOCATION_CACHE, "key_location_cache_location", "");
        if (!TextUtils.isEmpty(strN)) {
            try {
                this.f14365a = (LocationEx) az2.a(strN, LocationEx.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.f14365a != null) {
            this.b = SPUtil.f14322a.i(SPUtil.SCENE.LOCATION_CACHE, "key_location_cache_time", 0L);
        }
    }

    public final boolean q() {
        if (this.d == null) {
            this.d = new a();
        }
        if (!o()) {
            return false;
        }
        this.c.i(this.d);
        return true;
    }

    public final void r(LocationScene locationScene) {
        LogUtil.i("SimpleLocationHelper", "start" + locationScene);
        if (locationScene != null) {
            this.e = locationScene;
        }
        this.c.q();
        this.c.p(locationScene);
        try {
            CountDownTimer countDownTimerF = f();
            LogUtil.i("SimpleLocationHelper", "start timer countDownTimer=" + countDownTimerF);
            if (countDownTimerF != null) {
                countDownTimerF.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i("SimpleLocationHelper", "start timer error", e);
        }
    }

    public final void s() {
        LogUtil.i("SimpleLocationHelper", "stop");
        try {
            LogUtil.i("SimpleLocationHelper", "cancel timer countDownTimer=" + this.g);
            CountDownTimer countDownTimer = this.g;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.i("SimpleLocationHelper", "cancel timer error", e);
        }
        this.c.q();
    }

    public final void t(LocationEx locationEx) {
        this.b = ir5.b();
        this.f14365a = locationEx;
        String strC = az2.c(locationEx);
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.LOCATION_CACHE;
        sPUtil.t(scene, "key_location_cache_location", strC);
        sPUtil.t(scene, "key_location_cache_time", Long.valueOf(this.b));
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements i53 {

        /* JADX INFO: renamed from: com.zenmen.palmchat.location.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC1064a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LocationEx f14367a;
            public final /* synthetic */ int b;
            public final /* synthetic */ String c;

            /* JADX INFO: renamed from: com.zenmen.palmchat.location.d$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class C1065a implements b92 {
                public C1065a() {
                }

                @Override // defpackage.b92
                public void a(LocationEx locationEx) {
                    d.this.t(locationEx);
                    RunnableC1064a runnableC1064a = RunnableC1064a.this;
                    d.this.n(locationEx, runnableC1064a.b, runnableC1064a.c);
                }
            }

            public RunnableC1064a(LocationEx locationEx, int i, String str) {
                this.f14367a = locationEx;
                this.b = i;
                this.c = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                LocationEx locationEx;
                LogUtil.i("SimpleLocationHelper", "onLocationReceived location=" + this.f14367a + " errorCode=" + this.b + " errorInfo=" + this.c);
                d.this.s();
                int i = this.b;
                if (i != 0 || (locationEx = this.f14367a) == null) {
                    d.this.n(this.f14367a, i, this.c);
                    return;
                }
                if (!TextUtils.isEmpty(locationEx.getCityCode()) || this.f14367a.getLatitude() == 0.0d || this.f14367a.getLongitude() == 0.0d) {
                    d.this.t(this.f14367a);
                    d.this.n(this.f14367a, this.b, this.c);
                } else {
                    LogUtil.log4ClientError("location_success_citycode_null", null, null, true);
                    d.this.c.b(this.f14367a, new C1065a());
                }
            }
        }

        public a() {
        }

        @Override // defpackage.i53
        public void onLocationReceived(LocationEx locationEx, int i, String str) {
            RunnableC1064a runnableC1064a = new RunnableC1064a(locationEx, i, str);
            if (d.l) {
                u93.b(10000, runnableC1064a);
            } else {
                runnableC1064a.run();
            }
        }

        @Override // defpackage.i53
        public void onRegeocodeSearched(String str) {
        }

        @Override // defpackage.i53
        public void onLocationSearchResultGot(int i, List<LocationEx> list, n53 n53Var) {
        }
    }
}
