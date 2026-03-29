package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class j {
    static lv b;
    static hh e;
    static long g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f2921a = null;
    lv c = null;
    lv d = null;
    long f = 0;
    boolean h = false;
    private Context i;

    public j(Context context) {
        this.i = context.getApplicationContext();
    }

    private void e() {
        if (b == null || mm.b() - g > 180000) {
            lv lvVarF = f();
            g = mm.b();
            if (lvVarF == null || !mm.a(lvVarF.a())) {
                return;
            }
            b = lvVarF;
        }
    }

    private lv f() {
        Throwable th;
        lv lvVar;
        hh hhVar;
        byte[] bArrB;
        byte[] bArrB2;
        String str = null;
        if (this.i == null) {
            return null;
        }
        a();
        try {
            hhVar = e;
        } catch (Throwable th2) {
            th = th2;
            lvVar = null;
        }
        if (hhVar == null) {
            return null;
        }
        List listA = hhVar.a("_id=1", lv.class);
        if (listA == null || listA.size() <= 0) {
            lvVar = null;
        } else {
            lvVar = (lv) listA.get(0);
            try {
                byte[] bArrB3 = fw.b(lvVar.c());
                String str2 = (bArrB3 == null || bArrB3.length <= 0 || (bArrB2 = lt.b(bArrB3, this.f2921a)) == null || bArrB2.length <= 0) ? null : new String(bArrB2, "UTF-8");
                byte[] bArrB4 = fw.b(lvVar.b());
                if (bArrB4 != null && bArrB4.length > 0 && (bArrB = lt.b(bArrB4, this.f2921a)) != null && bArrB.length > 0) {
                    str = new String(bArrB, "UTF-8");
                }
                lvVar.a(str);
                str = str2;
            } catch (Throwable th3) {
                th = th3;
                me.a(th, "LastLocationManager", "readLastFix");
            }
        }
        if (!TextUtils.isEmpty(str)) {
            AMapLocation aMapLocation = new AMapLocation("");
            me.a(aMapLocation, new JSONObject(str));
            if (mm.b(aMapLocation)) {
                lvVar.a(aMapLocation);
            }
        }
        return lvVar;
        me.a(th, "LastLocationManager", "readLastFix");
        return lvVar;
    }

    public final void a() {
        if (this.h) {
            return;
        }
        try {
            if (this.f2921a == null) {
                this.f2921a = lt.a("MD5", fv.k());
            }
            if (e == null) {
                e = new hh(this.i, hh.a((Class<? extends hg>) lw.class));
            }
        } catch (Throwable th) {
            me.a(th, "LastLocationManager", "<init>:DBOperation");
        }
        this.h = true;
    }

    public final AMapLocation b() {
        e();
        lv lvVar = b;
        if (lvVar != null && mm.a(lvVar.a())) {
            return b.a();
        }
        return null;
    }

    public final void c() {
        try {
            d();
            this.f = 0L;
            this.h = false;
            this.c = null;
            this.d = null;
        } catch (Throwable th) {
            me.a(th, "LastLocationManager", "destroy");
        }
    }

    public final void d() {
        lv lvVar;
        String strB;
        try {
            a();
            lv lvVar2 = this.c;
            if (lvVar2 != null && mm.a(lvVar2.a()) && e != null && (lvVar = this.c) != this.d && lvVar.d() == 0) {
                String str = this.c.a().toStr();
                String strB2 = this.c.b();
                this.d = this.c;
                if (TextUtils.isEmpty(str)) {
                    strB = null;
                } else {
                    String strB3 = fw.b(lt.a(str.getBytes("UTF-8"), this.f2921a));
                    strB = TextUtils.isEmpty(strB2) ? null : fw.b(lt.a(strB2.getBytes("UTF-8"), this.f2921a));
                    str = strB3;
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                lv lvVar3 = new lv();
                lvVar3.b(str);
                lvVar3.a(mm.b());
                lvVar3.a(strB);
                e.a(lvVar3, "_id=1");
                this.f = mm.b();
                lv lvVar4 = b;
                if (lvVar4 != null) {
                    lvVar4.a(mm.b());
                }
            }
        } catch (Throwable th) {
            me.a(th, "LastLocationManager", "saveLastFix");
        }
    }

    public final boolean a(AMapLocation aMapLocation, String str) {
        if (this.i != null && aMapLocation != null && mm.a(aMapLocation) && aMapLocation.getLocationType() != 2 && !aMapLocation.isMock() && !aMapLocation.isFixLastLocation()) {
            lv lvVar = new lv();
            lvVar.a(aMapLocation);
            if (aMapLocation.getLocationType() == 1) {
                lvVar.a((String) null);
            } else {
                lvVar.a(str);
            }
            try {
                b = lvVar;
                g = mm.b();
                this.c = lvVar;
                lv lvVar2 = this.d;
                if (lvVar2 != null && mm.a(lvVar2.a(), lvVar.a()) <= 500.0f) {
                    return false;
                }
                if (mm.b() - this.f > 30000) {
                    return true;
                }
            } catch (Throwable th) {
                me.a(th, "LastLocationManager", "setLastFix");
            }
        }
        return false;
    }

    public final AMapLocation a(AMapLocation aMapLocation, String str, long j) {
        lv lvVar;
        boolean zA;
        if (aMapLocation == null || aMapLocation.getErrorCode() == 0 || aMapLocation.getLocationType() == 1 || aMapLocation.getErrorCode() == 7) {
            return aMapLocation;
        }
        try {
            e();
            lvVar = b;
        } catch (Throwable th) {
            th = th;
        }
        if (lvVar != null && lvVar.a() != null) {
            if (TextUtils.isEmpty(str)) {
                long jB = mm.b() - b.d();
                zA = jB >= 0 && jB <= j;
                aMapLocation.setTrustedLevel(3);
            } else {
                zA = mm.a(b.b(), str);
                aMapLocation.setTrustedLevel(2);
            }
            if (!zA) {
                return aMapLocation;
            }
            AMapLocation aMapLocationA = b.a();
            try {
                aMapLocationA.setLocationType(9);
                aMapLocationA.setFixLastLocation(true);
                aMapLocationA.setLocationDetail(aMapLocation.getLocationDetail());
                return aMapLocationA;
            } catch (Throwable th2) {
                th = th2;
                aMapLocation = aMapLocationA;
            }
            me.a(th, "LastLocationManager", "fixLastLocation");
            return aMapLocation;
        }
        return aMapLocation;
    }
}
