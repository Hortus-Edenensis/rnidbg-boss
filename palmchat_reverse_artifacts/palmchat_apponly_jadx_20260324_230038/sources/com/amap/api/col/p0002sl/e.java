package com.amap.api.col.p0002sl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.huawei.hms.ads.ex;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class e {
    static boolean g = false;
    Context e;
    private List<Messenger> w;
    private boolean o = false;
    private boolean p = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f2715a = null;
    b b = null;
    private long q = 0;
    private long r = 0;
    private lh s = null;
    AMapLocation c = null;
    private long t = 0;
    private int u = 0;
    a d = null;
    private j v = null;
    lc f = null;
    HashMap<Messenger, Long> h = new HashMap<>();
    mk i = null;
    long j = 0;
    long k = 0;
    private long x = 0;
    private HashMap<String, Boolean> y = new HashMap<>();
    String l = null;
    private boolean z = true;
    private String A = "";
    AMapLocationClientOption m = null;
    AMapLocationClientOption n = new AMapLocationClientOption();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Messenger messenger;
            Throwable th;
            Bundle data;
            try {
                data = message.getData();
                try {
                    messenger = message.replyTo;
                    if (data != null) {
                        try {
                            if (!data.isEmpty()) {
                                if (!e.this.a(data.getString("c"))) {
                                    if (message.what == 1) {
                                        mk.a((String) null, 2102);
                                        lh lhVarB = e.b("invalid handlder scode!!!#1002");
                                        lb lbVar = new lb();
                                        lbVar.f("#1002");
                                        lbVar.e("conitue");
                                        e.this.a(messenger, lhVarB, lhVarB.k(), lbVar);
                                        return;
                                    }
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                me.a(th, "ApsServiceCore", "ActionHandler handlerMessage");
                            } catch (Throwable th3) {
                                me.a(th3, "actionHandler", "handleMessage");
                                return;
                            }
                        }
                    }
                } catch (Throwable th4) {
                    messenger = null;
                    th = th4;
                }
            } catch (Throwable th5) {
                messenger = null;
                th = th5;
                data = null;
            }
            int i = message.what;
            if (i == 0) {
                e.this.a(data);
                e.this.a(messenger, data);
            } else if (i != 1) {
                switch (i) {
                    case 9:
                        e.this.a(data);
                        e.this.g();
                        break;
                    case 10:
                        e.this.a(data);
                        e.this.a(messenger, data, "FINE_LOC", 1);
                        break;
                    case 11:
                        e.this.d();
                        break;
                    case 12:
                        e.this.a(messenger);
                        break;
                    case 13:
                        Messenger messenger2 = message.replyTo;
                        if (messenger2 != null && e.this.w != null && !e.this.w.contains(messenger2)) {
                            e.this.w.add(messenger2);
                            if (e.this.w.size() == 1) {
                                e.this.f();
                            }
                        }
                        break;
                    case 14:
                        Messenger messenger3 = message.replyTo;
                        if (messenger3 != null && e.this.w != null && e.this.w.contains(messenger3)) {
                            e.this.w.remove(messenger3);
                        }
                        if (e.this.w != null && e.this.w.size() == 0) {
                            e.this.f.h();
                        }
                        break;
                    case 15:
                        e.this.a(data);
                        e.this.a(messenger, data, "COARSE_LOC", 1);
                        break;
                    case 16:
                        if (data != null && !data.isEmpty()) {
                            e.this.y.put(data.getString("objHash"), Boolean.TRUE);
                            e.this.c();
                        }
                        break;
                    case 17:
                        if (data != null && !data.isEmpty()) {
                            e.this.y.put(data.getString("objHash"), Boolean.FALSE);
                            e.this.c();
                        }
                        break;
                    case 18:
                        e.this.a(data);
                        e.this.a(messenger, data, "FINE_LOC", 12);
                        break;
                }
            } else {
                e.this.a(data);
                e.this.b(messenger, data);
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HandlerThread {
        public b(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            try {
                try {
                    e.this.v = new j(e.this.e);
                } catch (Throwable th) {
                    me.a(th, "APSManager$ActionThread", "init 2");
                }
                try {
                    md.b(e.this.e);
                    md.a(e.this.e);
                } catch (Throwable th2) {
                    me.a(th2, "APSManager$ActionThread", "init 3");
                }
                e.this.f = new lc(false);
                super.onLooperPrepared();
            } catch (Throwable th3) {
                me.a(th3, "APSManager$ActionThread", "onLooperPrepared");
            }
        }

        @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                super.run();
            } catch (Throwable th) {
                me.a(th, "APSManager$ActionThread", "run");
            }
        }
    }

    public e(Context context) {
        this.e = null;
        this.e = context;
    }

    public static /* synthetic */ lh b(String str) {
        return a(10, str);
    }

    public static void e() {
        g = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (mm.m(this.e)) {
            mg.a();
            return;
        }
        try {
            lc lcVar = this.f;
            if (lcVar == null || lcVar == null) {
                return;
            }
            lcVar.a(this.d);
            this.f.g();
        } catch (Throwable th) {
            me.a(th, "ApsServiceCore", "startColl");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            md.c(this.e);
        } catch (Throwable th) {
            me.a(th, "ApsServiceCore", "doCallOtherSer");
        }
    }

    public final void c() {
        HashMap<String, Boolean> map;
        if (this.f == null || (map = this.y) == null || map.isEmpty()) {
            return;
        }
        Iterator<Boolean> it = this.y.values().iterator();
        while (it.hasNext()) {
            if (it.next().booleanValue()) {
                this.f.a(true);
                return;
            }
        }
        this.f.a(false);
    }

    public final void d() {
        try {
            HashMap<Messenger, Long> map = this.h;
            if (map != null) {
                map.clear();
                this.h = null;
            }
            try {
                List<Messenger> list = this.w;
                if (list != null) {
                    list.clear();
                }
            } catch (Throwable th) {
                me.a(th, "apm", "des1");
            }
            j jVar = this.v;
            if (jVar != null) {
                jVar.c();
                this.v = null;
            }
            this.o = false;
            this.p = false;
            this.f.e();
            a aVar = this.d;
            if (aVar != null) {
                aVar.removeCallbacksAndMessages(null);
            }
            this.d = null;
            b bVar = this.b;
            if (bVar != null) {
                try {
                    mi.a(bVar, (Class<?>) HandlerThread.class, "quitSafely", new Object[0]);
                } catch (Throwable unused) {
                    this.b.quit();
                }
            }
            this.b = null;
            if (this.i != null && this.j != 0 && this.k != 0) {
                long jB = mm.b() - this.j;
                mk.a(this.e, this.i.c(this.e), this.i.d(this.e), this.k, jB);
                this.i.e(this.e);
            }
            HashMap<String, Boolean> map2 = this.y;
            if (map2 != null) {
                map2.clear();
                this.y = null;
            }
            mk.a(this.e);
            hd.b();
            if (g) {
                Process.killProcess(Process.myPid());
            }
        } catch (Throwable th2) {
            me.a(th2, "apm", "tdest");
        }
    }

    public final Handler b() {
        return this.d;
    }

    private void b(Messenger messenger) {
        try {
            this.f.f();
            if (md.l()) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("installMockApp", true);
                a(messenger, 9, bundle);
            }
        } catch (Throwable th) {
            me.a(th, "ApsServiceCore", "initAuth");
        }
    }

    public final void a() {
        try {
            this.i = new mk();
            b bVar = new b("amapLocCoreThread");
            this.b = bVar;
            bVar.setPriority(5);
            this.b.start();
            this.d = new a(this.b.getLooper());
            this.w = new ArrayList();
        } catch (Throwable th) {
            me.a(th, "ApsServiceCore", "onCreate");
        }
    }

    private static AMapLocationClientOption b(Bundle bundle) {
        AMapLocationClientOption aMapLocationClientOptionA = null;
        try {
            aMapLocationClientOptionA = me.a(bundle.getBundle("optBundle"));
            try {
                String string = bundle.getString("d");
                if (!TextUtils.isEmpty(string)) {
                    fv.a(string);
                }
            } catch (Throwable th) {
                me.a(th, "APSManager", "doLocation setUmidToken");
            }
        } catch (Throwable th2) {
            me.a(th2, "APSManager", "parseBundle");
        }
        return aMapLocationClientOptionA;
    }

    public final void a(Intent intent) {
        a aVar;
        if (!ex.Code.equals(intent.getStringExtra("as")) || (aVar = this.d) == null) {
            return;
        }
        aVar.sendEmptyMessageDelayed(9, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Messenger messenger) {
        this.h.remove(messenger);
    }

    private static lh a(int i, String str) {
        try {
            lh lhVar = new lh("");
            lhVar.setErrorCode(i);
            lhVar.setLocationDetail(str);
            return lhVar;
        } catch (Throwable th) {
            me.a(th, "ApsServiceCore", "newInstanceAMapLoc");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Messenger messenger, Bundle bundle) {
        String str;
        j jVar;
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                lb lbVar = new lb();
                lbVar.e("conitue");
                AMapLocationClientOption aMapLocationClientOptionB = b(bundle);
                a(aMapLocationClientOptionB);
                if (this.h.containsKey(messenger) && !aMapLocationClientOptionB.isOnceLocation()) {
                    if (mm.b() - this.h.get(messenger).longValue() < 800) {
                        return;
                    }
                }
                AMapLocation aMapLocationA = null;
                if (!this.z) {
                    this.s = a(9, "init error : " + this.A + "#0901");
                    lbVar.f("#0901");
                    lh lhVar = this.s;
                    a(messenger, lhVar, lhVar.k(), lbVar);
                    mk.a((String) null, 2091);
                    return;
                }
                long jB = mm.b();
                if (mm.a(this.s) && jB - this.r < 600) {
                    lh lhVar2 = this.s;
                    a(messenger, lhVar2, lhVar2.k(), lbVar);
                    this.f.a(this.s, 3);
                    return;
                }
                lbVar.c(mm.b());
                try {
                    lh lhVarA = this.f.a(lbVar);
                    this.s = lhVarA;
                    if (lhVarA.getLocationType() != 6 && this.s.getLocationType() != 5) {
                        if (this.s.getLocationType() == 2) {
                            this.f.a(this.s, 3);
                        } else if (this.s.getLocationType() == 4) {
                            this.f.a(this.s, 4);
                        }
                    } else {
                        this.f.a(this.s, 2);
                    }
                    this.s = this.f.a(this.s);
                } catch (Throwable th) {
                    mk.a((String) null, 2081);
                    lbVar.f("#0801");
                    this.s = a(8, "loc error : " + th.getMessage() + "#0801");
                    me.a(th, "ApsServiceCore", "run part2");
                }
                if (mm.a(this.s)) {
                    this.r = mm.b();
                }
                if (this.s == null) {
                    this.s = a(8, "loc is null#0801");
                    lbVar.f("#0801");
                }
                lh lhVar3 = this.s;
                if (lhVar3 != null) {
                    String strK = lhVar3.k();
                    aMapLocationA = this.s.m10clone();
                    str = strK;
                } else {
                    str = null;
                }
                try {
                    if (aMapLocationClientOptionB.isLocationCacheEnable() && (jVar = this.v) != null) {
                        aMapLocationA = jVar.a(aMapLocationA, str, aMapLocationClientOptionB.getLastLocationLifeCycle());
                    }
                } catch (Throwable th2) {
                    me.a(th2, "ApsServiceCore", "fixLastLocation");
                }
                a(messenger, aMapLocationA, str, lbVar);
            } catch (Throwable th3) {
                me.a(th3, "ApsServiceCore", "doLocation");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        try {
            if (this.o) {
                lc lcVar = this.f;
                if (lcVar != null) {
                    lcVar.a();
                    return;
                }
                return;
            }
            me.a(this.e);
            if (bundle != null) {
                this.n = me.a(bundle.getBundle("optBundle"));
            }
            this.f.a(this.e);
            this.f.b();
            a(this.n);
            this.f.c();
            this.o = true;
            this.z = true;
            this.A = "";
            List<Messenger> list = this.w;
            if (list == null || list.size() <= 0) {
                return;
            }
            f();
        } catch (Throwable th) {
            this.z = false;
            th.printStackTrace();
            this.A = th.getMessage();
            me.a(th, "ApsServiceCore", "init");
        }
    }

    private void a(AMapLocationClientOption aMapLocationClientOption) {
        try {
            lc lcVar = this.f;
            if (lcVar != null) {
                lcVar.a(aMapLocationClientOption);
            }
            if (aMapLocationClientOption != null) {
                g = aMapLocationClientOption.isKillProcess();
                if (this.m != null) {
                    if (aMapLocationClientOption.isOffset() != this.m.isOffset() || aMapLocationClientOption.isNeedAddress() != this.m.isNeedAddress() || aMapLocationClientOption.isLocationCacheEnable() != this.m.isLocationCacheEnable() || this.m.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.r = 0L;
                    }
                    if (aMapLocationClientOption.isOffset() != this.m.isOffset() || this.m.getGeoLanguage() != aMapLocationClientOption.getGeoLanguage()) {
                        this.c = null;
                    }
                }
                this.m = aMapLocationClientOption;
            }
        } catch (Throwable th) {
            me.a(th, "ApsServiceCore", "setExtra");
        }
    }

    private static void a(Messenger messenger, int i, Bundle bundle) {
        if (messenger != null) {
            try {
                Message messageObtain = Message.obtain();
                messageObtain.setData(bundle);
                messageObtain.what = i;
                messenger.send(messageObtain);
            } catch (Throwable th) {
                me.a(th, "ApsServiceCore", "sendMessage");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Messenger messenger, Bundle bundle) {
        if (bundle != null) {
            try {
                if (bundle.isEmpty() || this.p) {
                    return;
                }
                this.p = true;
                b(messenger);
            } catch (Throwable th) {
                me.a(th, "ApsServiceCore", "doInitAuth");
            }
        }
    }

    public final void b(Intent intent) {
        String stringExtra = intent.getStringExtra("a");
        if (!TextUtils.isEmpty(stringExtra)) {
            fs.a(this.e, stringExtra);
        }
        String stringExtra2 = intent.getStringExtra(t.l);
        this.f2715a = stringExtra2;
        fr.a(stringExtra2);
        String stringExtra3 = intent.getStringExtra("d");
        if (TextUtils.isEmpty(stringExtra3)) {
            return;
        }
        fv.a(stringExtra3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Messenger messenger, AMapLocation aMapLocation, String str, lb lbVar) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putParcelable("loc", aMapLocation);
        bundle.putString("nb", str);
        bundle.putParcelable("statics", lbVar);
        this.h.put(messenger, Long.valueOf(mm.b()));
        a(messenger, 1, bundle);
    }

    public final void a(Messenger messenger, Bundle bundle, String str, int i) {
        AMapLocationClientOption aMapLocationClientOptionB;
        float fA;
        AMapLocation aMapLocation;
        if (bundle != null) {
            try {
                if (bundle.isEmpty()) {
                    return;
                }
                double d = bundle.getDouble(f.C);
                double d2 = bundle.getDouble("lon");
                float f = bundle.getFloat("radius");
                long j = bundle.getLong("time");
                if ("FINE_LOC".equals(str)) {
                    if (i == 1) {
                        aMapLocation = new AMapLocation(GeocodeSearch.GPS);
                        aMapLocation.setLocationType(1);
                    } else if (i == 12) {
                        AMapLocation aMapLocation2 = new AMapLocation("network");
                        aMapLocation2.setLocationType(12);
                        aMapLocation = aMapLocation2;
                    } else {
                        aMapLocation = null;
                    }
                    aMapLocation.setLatitude(d);
                    aMapLocation.setLongitude(d2);
                    aMapLocation.setAccuracy(f);
                    aMapLocation.setTime(j);
                    this.f.a(aMapLocation);
                }
                if (md.h() && (aMapLocationClientOptionB = b(bundle)) != null && aMapLocationClientOptionB.isNeedAddress()) {
                    a(aMapLocationClientOptionB);
                    AMapLocation aMapLocation3 = this.c;
                    if (aMapLocation3 != null) {
                        fA = mm.a(new double[]{d, d2, aMapLocation3.getLatitude(), this.c.getLongitude()});
                        if (fA < md.i() * 3) {
                            a(messenger, str, i);
                        }
                    } else {
                        fA = -1.0f;
                    }
                    if (fA == -1.0f || (fA > md.i() && mm.b() - this.x > md.j() * 1000)) {
                        a(bundle);
                        this.c = this.f.a(d, d2);
                        this.x = mm.b();
                        AMapLocation aMapLocation4 = this.c;
                        if (aMapLocation4 == null || TextUtils.isEmpty(aMapLocation4.getAdCode())) {
                            return;
                        }
                        a(messenger, str, i);
                    }
                }
            } catch (Throwable th) {
                me.a(th, "ApsServiceCore", "doLocationGeo");
            }
        }
    }

    private void a(Messenger messenger, String str, int i) {
        Bundle bundle = new Bundle();
        bundle.setClassLoader(AMapLocation.class.getClassLoader());
        bundle.putInt("I_MAX_GEO_DIS", md.i() * 3);
        bundle.putInt("I_MIN_GEO_DIS", md.i());
        bundle.putParcelable("loc", this.c);
        if ("COARSE_LOC".equals(str)) {
            a(messenger, 103, bundle);
        } else if (i == 1) {
            a(messenger, 6, bundle);
        } else if (i == 12) {
            a(messenger, 18, bundle);
        }
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(this.l)) {
            this.l = me.b(this.e);
        }
        return !TextUtils.isEmpty(str) && str.equals(this.l);
    }
}
