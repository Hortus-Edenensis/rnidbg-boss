package com.opos.mobad.model.c;

import com.opos.mobad.b.a.d;
import com.opos.mobad.b.a.w;
import com.opos.mobad.model.data.InstantData;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9068a = com.opos.cmn.an.b.b.a("b3Bwb19hZHg=");
    public static final String b = com.opos.cmn.an.b.b.a("b3Bwb19mZWVk");
    public static final String c = com.opos.cmn.an.b.b.a("b3Bwb19jcGQ=");
    private int d;
    private String e;
    private List<com.opos.mobad.b.a.b> f;
    private long g;
    private String h;
    private InstantData i;
    private int j;
    private int k;
    private int l;
    private boolean m;
    private int n;
    private boolean o;
    private com.opos.mobad.b.a.d p;
    private boolean q;
    private int r;
    private int s;
    private int t;
    private String u;
    private String v;
    private String w;

    /* JADX INFO: renamed from: com.opos.mobad.model.c.d$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9069a;

        static {
            int[] iArr = new int[d.b.values().length];
            f9069a = iArr;
            try {
                iArr[d.b.NO_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9069a[d.b.GAME_BOX_BANNER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9069a[d.b.GAME_BOX_INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d() {
        this.o = true;
        this.q = false;
        this.r = 0;
        this.s = 0;
        this.t = 0;
    }

    private int a(d.b bVar) {
        int i;
        if (bVar == null || (i = AnonymousClass1.f9069a[bVar.ordinal()]) == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    public int b() {
        return this.r;
    }

    public com.opos.mobad.b.a.d c() {
        return this.p;
    }

    public boolean d() {
        return this.o;
    }

    public int e() {
        return this.n;
    }

    public int f() {
        return this.d;
    }

    public String g() {
        return this.e;
    }

    public List<com.opos.mobad.b.a.b> h() {
        return this.f;
    }

    public long i() {
        return this.g;
    }

    public String j() {
        return this.h;
    }

    public InstantData k() {
        return this.i;
    }

    public int l() {
        return this.j;
    }

    public int m() {
        return this.k;
    }

    public int n() {
        return this.l;
    }

    public boolean o() {
        return this.m;
    }

    public boolean p() {
        return this.t == 1;
    }

    public String q() {
        return this.u;
    }

    public String r() {
        return this.v;
    }

    public String s() {
        return this.w;
    }

    public String toString() {
        return "FetchAdResponse{code=" + this.d + ", msg='" + this.e + "', requestInterval='" + this.j + "', adEntityList=" + this.f + ", expireTime=" + this.g + ", respId='" + this.h + "', instantIdsEntity=" + this.i + ", dispatchMode=" + this.k + ", gameBoxType=" + this.l + "', customSkip=" + this.m + "', cacheNum=" + this.r + "', recordShowEvent=" + this.o + "', cmType=" + this.s + "', strategyState=" + this.t + "', clkScore='" + this.w + "'}";
    }

    public d(com.opos.mobad.b.a.d dVar) {
        this(dVar, null, 0L);
    }

    public void a(int i) {
        this.d = i;
    }

    public d(com.opos.mobad.b.a.d dVar, List<com.opos.mobad.b.a.b> list, long j) {
        this.o = true;
        this.q = false;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        if (dVar == null) {
            return;
        }
        Integer num = dVar.p;
        this.d = num != null ? num.intValue() : -1;
        String str = dVar.q;
        this.e = str == null ? "" : str;
        if (j > 0) {
            this.g = j;
        } else {
            Integer num2 = dVar.y;
            int iIntValue = (num2 == null ? com.opos.mobad.b.a.d.h : num2).intValue();
            if (iIntValue <= 0) {
                Long l = dVar.t;
                j = l != null ? l.longValue() : System.currentTimeMillis();
                this.g = j;
            } else {
                this.g = System.currentTimeMillis() + ((long) iIntValue);
            }
        }
        this.j = dVar.w.intValue();
        Integer num3 = dVar.x;
        this.k = (num3 == null ? com.opos.mobad.b.a.d.g : num3).intValue();
        if (list == null) {
            this.f = dVar.s;
            this.q = false;
        } else {
            this.f = list;
            this.q = true;
        }
        Integer num4 = dVar.A;
        this.r = (num4 == null ? com.opos.mobad.b.a.d.j : num4).intValue();
        String str2 = dVar.u;
        this.h = str2 != null ? str2 : "";
        if (dVar.v != null) {
            w wVar = dVar.v;
            this.i = new InstantData(wVar.d, wVar.e);
        }
        d.b bVar = dVar.z;
        bVar = bVar == null ? com.opos.mobad.b.a.d.i : bVar;
        Boolean bool = dVar.B;
        this.m = (bool == null ? com.opos.mobad.b.a.d.k : bool).booleanValue();
        this.l = a(bVar);
        Integer num5 = dVar.C;
        this.n = (num5 == null ? com.opos.mobad.b.a.d.l : num5).intValue();
        Boolean bool2 = dVar.D;
        this.o = (bool2 == null ? com.opos.mobad.b.a.b.p : bool2).booleanValue();
        this.p = dVar;
        Integer num6 = dVar.E;
        this.s = (num6 == null ? com.opos.mobad.b.a.d.n : num6).intValue();
        Integer num7 = dVar.F;
        this.t = (num7 == null ? com.opos.mobad.b.a.d.o : num7).intValue();
        this.u = dVar.G;
        this.v = dVar.H;
        this.w = dVar.I;
    }

    public void a(String str) {
        this.e = str;
    }

    public boolean a() {
        return this.q;
    }
}
