package com.opos.mobad.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.opos.mobad.service.d.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile e f8625a;
    private volatile String c;
    private volatile String d;
    private volatile d.c e;
    private volatile String b = "";
    private volatile String f = "";
    private volatile int g = 0;
    private volatile int h = 0;
    private volatile int i = 0;

    public void a(e eVar, String str, d.c cVar, int i, int i2, int i3) {
        this.f8625a = eVar;
        this.c = str;
        this.e = cVar;
        this.g = i;
        this.h = i2;
        this.i = i3;
    }

    public String b() {
        e eVar = this.f8625a;
        return !a(eVar) ? "" : eVar.b;
    }

    public String c() {
        e eVar = this.f8625a;
        return !a(eVar) ? "" : eVar.c;
    }

    public int d() {
        e eVar = this.f8625a;
        if (a(eVar)) {
            return eVar.d;
        }
        return -1;
    }

    public String e() {
        e eVar = this.f8625a;
        return !a(eVar) ? "" : eVar.e;
    }

    public boolean f() {
        e eVar = this.f8625a;
        if (a(eVar)) {
            return eVar.h;
        }
        return false;
    }

    public String g() {
        e eVar = this.f8625a;
        String str = a(eVar) ? eVar.m : "";
        com.opos.cmn.an.f.a.b("InfoProvider", "getEnterSource()=", str);
        return str;
    }

    public String h() {
        return this.b;
    }

    public String i() {
        return this.d;
    }

    public String j() {
        return this.c;
    }

    public String k() {
        d.c cVar = this.e;
        if (this.e == null) {
            return "";
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.f = cVar.a();
        if (TextUtils.isEmpty(this.f) || (!"ADULT".equals(this.f) && !"CHILD".equals(this.f) && !"TEEN".equals(this.f))) {
            this.f = GrsBaseInfo.CountryCodeSource.UNKNOWN;
        }
        com.opos.cmn.an.f.a.b("InfoProvider", "getClassifyByAgeProvider() mAgeGrading=", this.f, ", time=", Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        return this.f;
    }

    public String l() {
        if (this.e == null) {
            return "";
        }
        if (TextUtils.isEmpty(this.f)) {
            k();
        }
        return this.f;
    }

    public int m() {
        return this.g;
    }

    public int n() {
        return this.h;
    }

    public int o() {
        return this.i;
    }

    public void p() {
        this.f8625a = null;
        this.c = "";
        this.b = "";
        this.e = null;
        this.f = "";
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }

    public boolean a() {
        return a(this.f8625a);
    }

    private boolean a(e eVar) {
        return eVar != null;
    }
}
