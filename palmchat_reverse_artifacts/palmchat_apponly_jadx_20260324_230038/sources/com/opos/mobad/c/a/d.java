package com.opos.mobad.c.a;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import com.oplus.tblplayer.monitor.ErrorCode;
import com.opos.cmn.func.a.a.d;
import com.opos.cmn.i.a;
import com.opos.mobad.c.a.c;
import com.opos.mobad.n.a.aa;
import com.opos.mobad.n.a.b;
import com.opos.mobad.n.a.g;
import com.opos.mobad.n.a.h;
import com.opos.mobad.n.a.i;
import com.opos.mobad.n.a.j;
import com.opos.mobad.n.a.k;
import com.opos.mobad.n.a.l;
import com.opos.mobad.n.a.m;
import com.opos.mobad.n.a.n;
import com.opos.mobad.n.a.o;
import com.opos.mobad.n.a.p;
import com.opos.mobad.n.a.q;
import com.opos.mobad.n.a.r;
import com.opos.mobad.n.a.s;
import com.opos.mobad.n.a.t;
import com.opos.mobad.n.a.u;
import com.opos.mobad.n.a.v;
import com.opos.mobad.n.a.w;
import com.opos.mobad.n.a.z;
import com.opos.mobad.provider.strategy.PosInfo;
import com.opos.mobad.service.c.a;
import com.opos.mobad.service.d.d;
import defpackage.g23;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f8579a = q.HORIZONTAL.a();
    public static final int b = q.VERTICAL.a();
    private Context c;
    private int d;
    private String e;
    private String f;
    private int g;
    private com.opos.mobad.c.a.c h;
    private com.opos.cmn.i.a i;
    private InterfaceC0721d m;
    private com.opos.mobad.c.d s;
    private Bundle u;
    private Integer j = null;
    private volatile c k = new c();
    private AtomicReference<Map<String, e>> l = new AtomicReference<>(null);
    private AtomicBoolean n = new AtomicBoolean(false);
    private long o = 0;
    private Map<String, String> p = new ConcurrentHashMap();
    private Map<String, String> q = new ConcurrentHashMap();
    private Map<String, String> r = new ConcurrentHashMap();
    private long t = -1;

    /* JADX INFO: renamed from: com.opos.mobad.c.a.d$5, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8584a;

        static {
            int[] iArr = new int[l.values().length];
            f8584a = iArr;
            try {
                iArr[l.BIDDING_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8584a[l.PERCENTAGE_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8584a[l.UNKNOWN_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8584a[l.RANKER_MODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f8585a = com.opos.mobad.n.a.e.UNION.a();
        public static final int b = com.opos.mobad.n.a.e.TT.a();
        public static final int c = com.opos.mobad.n.a.e.GDT.a();
        public static final int d = com.opos.mobad.n.a.e.MIX.a();
        public static final int e = com.opos.mobad.n.a.e.KS.a();
        public final int f;
        public final String g;
        public final long h;
        public final int i;
        public final int j;
        public final int k;
        public final int l;
        public final long m;
        private final float n;

        public a(int i, String str, int i2, long j, int i3, int i4) {
            this(i, str, i2, j, i3, i4, 0, 1.0f, 0L);
        }

        public float a() {
            float f = this.n;
            if (f < 0.0f || f > 1.0f) {
                return 0.8f;
            }
            return f;
        }

        public String toString() {
            return "channel:" + this.f + ",posId:" + this.g + ",percnet:" + this.k + ",timeout:" + this.h + ",factor:" + this.n + ",ecpmFilterThreshold:" + this.m;
        }

        public a(int i, String str, int i2, long j, int i3, int i4, int i5, float f, long j2) {
            this.f = i;
            this.g = str;
            this.h = j;
            this.i = i3;
            this.j = i4;
            this.k = i2;
            this.l = i5;
            this.n = f;
            this.m = j2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<a> f8586a;
        public final a b;
        public final long c;
        public final long d;
        public final int e;

        public b(List<a> list, int i, a aVar, long j, long j2) {
            this.f8586a = list;
            this.b = aVar;
            this.c = j;
            this.d = j2;
            this.e = i;
        }

        public String toString() {
            return "DispatchChannelStrategy{channelList=" + this.f8586a + ", baseChannel=" + this.b + ", unionTimeout=" + this.c + ", strategyVersion=" + this.d + ", dispatch=" + this.e + '}';
        }

        public b(List<a> list, a aVar, long j, long j2) {
            this(list, 2, aVar, j, j2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Integer, g> f8587a;
        private final com.opos.mobad.n.a.c b;
        private final long c;
        private final long d;
        private final long e;
        private final String f;
        private final Map<Integer, String> g;
        private final String h;
        private final String i;
        private final m j;

        public c() {
            this(null, null, Long.MIN_VALUE, Long.MIN_VALUE, 0L, "", null, "", "", null);
        }

        public c(List<g> list, com.opos.mobad.n.a.c cVar, long j, long j2, long j3, String str, List<r> list2, String str2, String str3, m mVar) {
            this.f8587a = new HashMap();
            if (list != null && list.size() > 0) {
                for (g gVar : list) {
                    if (d.b(gVar.e)) {
                        this.f8587a.put(Integer.valueOf(gVar.e.a()), gVar);
                    }
                }
            }
            this.b = cVar;
            this.c = j;
            this.d = j2;
            this.e = j3;
            this.f = str;
            this.g = a(list2);
            this.h = str2;
            this.i = str3;
            this.j = mVar;
        }

        private Map<Integer, String> a(List<r> list) {
            Integer num;
            HashMap map = new HashMap();
            if (list != null && list.size() > 0) {
                for (r rVar : list) {
                    if (rVar != null && !TextUtils.isEmpty(rVar.f) && (num = rVar.e) != null) {
                        map.put(num, rVar.f);
                    }
                }
            }
            return map;
        }

        public boolean b() {
            com.opos.cmn.an.f.a.b("DispatchController", "isAdEnable() current=", Long.valueOf(System.currentTimeMillis()), "adEnableTime=" + this.d);
            return System.currentTimeMillis() >= this.d;
        }

        public boolean a() {
            com.opos.cmn.an.f.a.b("DispatchController", "isExpired() current=", Long.valueOf(System.currentTimeMillis()), "expiredTime=" + this.c);
            return System.currentTimeMillis() >= this.c;
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.c.a.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0721d {
        void a(boolean z);
    }

    public d(com.opos.mobad.c.d dVar) {
        this.s = dVar;
    }

    private void D() {
        com.opos.cmn.an.f.a.b("DispatchController", "readStrategyFromLocal");
        this.h.a(new c.b() { // from class: com.opos.mobad.c.a.d.2
            @Override // com.opos.mobad.c.a.c.b
            public void a() {
                com.opos.cmn.an.f.a.a("DispatchController", "read strategy local fail");
            }

            @Override // com.opos.mobad.c.a.c.b
            public void a(Bundle bundle) {
                d.this.a(bundle);
            }
        });
    }

    private void E() {
        this.i = new com.opos.cmn.i.a(new a.b() { // from class: com.opos.mobad.c.a.d.3
            @Override // com.opos.cmn.i.a.b
            public void a(a.InterfaceC0673a interfaceC0673a) {
                if (d.this.n.get() || !d.this.n.compareAndSet(false, true)) {
                    d.this.b(interfaceC0673a);
                } else {
                    d.this.a(interfaceC0673a);
                }
            }
        }, 30000, ErrorCode.REASON_RD_VIDEO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String F() {
        return "https://uapi.ads.heytapmobi.com/union/strategy/v3/select";
    }

    private void G() {
        if (this.c == null || !this.k.a() || this.i == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("DispatchController", com.alipay.sdk.m.x.d.w);
        this.i.a();
    }

    public boolean A() {
        return (y() & 2) == 2;
    }

    public boolean B() {
        return (y() & 64) == 64;
    }

    public boolean C() {
        return (y() & 128) == 128;
    }

    public int a(String str) {
        q qVar;
        q qVar2;
        Map<String, e> map = this.l.get();
        if (map == null) {
            e eVarG = g(str);
            if (eVarG != null && (qVar2 = eVarG.f8588a.t) != null) {
                return qVar2.a();
            }
        } else {
            e eVar = map.get(str);
            if (eVar != null && (qVar = eVar.f8588a.t) != null) {
                return qVar.a();
            }
        }
        return q.HORIZONTAL.a();
    }

    public String b(int i) {
        if (a.f8585a == i) {
            return this.e;
        }
        g gVar = (g) this.k.f8587a.get(Integer.valueOf(i));
        if (gVar == null) {
            return null;
        }
        return gVar.f;
    }

    public int d() {
        return ((this.k.b == null || this.k.b.q == null) ? com.opos.mobad.n.a.c.e : this.k.b.q).intValue();
    }

    public long g() {
        if (this.k != null) {
            return this.k.e;
        }
        return 0L;
    }

    public String h() {
        return this.k != null ? this.k.f : "";
    }

    public int i() {
        if (this.k.b == null || this.k.b.n == null) {
            return 30000;
        }
        return this.k.b.n.h.intValue();
    }

    public int j() {
        return ((this.k.b == null || this.k.b.n == null || this.k.b.n.i == null) ? com.opos.mobad.n.a.a.e : this.k.b.n.i).intValue();
    }

    public int k() {
        if (this.k.b == null || this.k.b.o == null) {
            return 30000;
        }
        return this.k.b.o.h.intValue();
    }

    public int l() {
        return ((this.k.b == null || this.k.b.o == null || this.k.b.o.i == null) ? com.opos.mobad.n.a.a.e : this.k.b.o.i).intValue();
    }

    public com.opos.mobad.c.a.a m() {
        return (this.k.b == null || this.k.b.u == null) ? new com.opos.mobad.c.a.a() : new com.opos.mobad.c.a.a(this.k.b.u);
    }

    public int n() {
        if (this.k.b == null || this.k.b.i == null) {
            return 30000;
        }
        return this.k.b.i.h.intValue();
    }

    public int o() {
        return ((this.k.b == null || this.k.b.i == null || this.k.b.i.i == null) ? com.opos.mobad.n.a.a.e : this.k.b.i.i).intValue();
    }

    public int p() {
        if (this.k.b == null || this.k.b.j == null) {
            return 30000;
        }
        return this.k.b.j.h.intValue();
    }

    public int q() {
        if (this.k.b == null || this.k.b.k == null) {
            return 30000;
        }
        return this.k.b.k.h.intValue();
    }

    public int r() {
        return ((this.k.b == null || this.k.b.k == null || this.k.b.k.i == null) ? com.opos.mobad.n.a.a.e : this.k.b.k.i).intValue();
    }

    public int s() {
        if (this.k.b == null || this.k.b.l == null) {
            return 30000;
        }
        return this.k.b.l.h.intValue();
    }

    public int t() {
        return ((this.k.b == null || this.k.b.l == null || this.k.b.l.i == null) ? com.opos.mobad.n.a.a.e : this.k.b.l.i).intValue();
    }

    public int u() {
        if (this.k.b == null || this.k.b.m == null) {
            return 30000;
        }
        return this.k.b.m.h.intValue();
    }

    public int v() {
        if (this.k.j != null) {
            return this.k.j.g.intValue();
        }
        return 0;
    }

    public int w() {
        if (this.k.j != null) {
            return this.k.j.f.intValue();
        }
        return 0;
    }

    public String x() {
        return this.k == null ? "" : this.k.h;
    }

    public int y() {
        if (this.k == null || this.k.b == null || this.k.b.t == null) {
            return 1;
        }
        return this.k.b.t.intValue();
    }

    public boolean z() {
        return (y() & 1) == 1;
    }

    private e g(String str) {
        Bundle bundle = this.u;
        if (bundle != null) {
            com.opos.cmn.an.f.a.b("DispatchController", "getCacheStrategy");
            PosInfo posInfo = (PosInfo) bundle.getParcelable(str);
            if (!TextUtils.isEmpty(str) && posInfo != null) {
                try {
                    return new e(posInfo.b, v.c.a(posInfo.f9177a));
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("DispatchController", "decode pos fail" + str, e);
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b a(String str, boolean z) {
        e eVarG;
        int i;
        G();
        ArrayList arrayList = new ArrayList();
        Map<String, e> map = this.l.get();
        a aVar = null;
        if (map == null) {
            com.opos.cmn.an.f.a.b("DispatchController", "strategyInfo map null");
            eVarG = z ? g(str) : null;
        } else {
            eVarG = map.get(str);
        }
        if (eVarG == null) {
            return null;
        }
        if (eVarG.b != g()) {
            com.opos.cmn.an.f.a.a("DispatchController", "stg ver fail");
            return null;
        }
        v vVar = eVarG.f8588a;
        List<h> list = vVar != null ? vVar.r : null;
        Long l = vVar.v;
        if (l == null) {
            l = v.g;
        }
        long jLongValue = l.longValue();
        if (list == null || list.size() <= 0) {
            return new b(null, null, jLongValue, g());
        }
        for (h hVar : list) {
            if (b(hVar.o)) {
                int iA = hVar.o.a();
                String str2 = hVar.l;
                int iIntValue = hVar.m.intValue();
                long jLongValue2 = hVar.n.longValue();
                Integer num = hVar.p;
                int iIntValue2 = num != null ? num.intValue() : 0;
                Integer num2 = hVar.q;
                int iIntValue3 = num2 != null ? num2.intValue() : 0;
                Integer num3 = hVar.r;
                int iIntValue4 = num3 != null ? num3.intValue() : 0;
                Float f = hVar.s;
                float fFloatValue = f != null ? f.floatValue() : 0.8f;
                Long l2 = hVar.t;
                a aVar2 = new a(iA, str2, iIntValue, jLongValue2, iIntValue2, iIntValue3, iIntValue4, fFloatValue, l2 != null ? l2.longValue() : -1L);
                Long l3 = hVar.t;
                this.t = l3 != null ? l3.longValue() : -1L;
                if (aVar2.f == a.c) {
                    Map<String, String> map2 = this.q;
                    String str3 = aVar2.g;
                    map2.put(str3, str3);
                }
                if (aVar2.f == a.b) {
                    Map<String, String> map3 = this.p;
                    String str4 = aVar2.g;
                    map3.put(str4, str4);
                }
                if (aVar2.f == a.e) {
                    Map<String, String> map4 = this.r;
                    String str5 = aVar2.g;
                    map4.put(str5, str5);
                }
                arrayList.add(aVar2);
                com.opos.mobad.n.a.e eVar = vVar.u;
                if (eVar != null && eVar == hVar.o) {
                    aVar = aVar2;
                }
            }
        }
        l lVar = vVar.y;
        if (lVar != null) {
            int i2 = AnonymousClass5.f8584a[lVar.ordinal()];
            i = i2 != 1 ? i2 != 2 ? 2 : 1 : 3;
        } else if (vVar.s.booleanValue()) {
        }
        com.opos.cmn.an.f.a.b("DispatchController", "getChannelStrategy(), dispatch=", Integer.valueOf(i), ", posId=", str, ", sync=", Boolean.valueOf(z));
        return new b(arrayList, i, aVar, jLongValue, eVarG.b);
    }

    public String c(int i) {
        g gVar = (g) this.k.f8587a.get(Integer.valueOf(i));
        if (gVar == null) {
            return null;
        }
        return gVar.g;
    }

    public boolean e() {
        if (this.k.b == null || this.k.b.r == null) {
            return true;
        }
        return this.k.b.r.booleanValue();
    }

    public boolean f() {
        if (this.k.b == null || this.k.b.s == null) {
            return true;
        }
        return this.k.b.s.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final a.InterfaceC0673a interfaceC0673a) {
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.c.a.d.4
            /* JADX WARN: Finally extract failed */
            @Override // java.lang.Runnable
            public void run() throws IOException {
                w wVarB;
                s.a aVarC = new s.a().a(d.this.e).b(d.this.f).a(Integer.valueOf(d.this.d)).b(Integer.valueOf(d.this.g)).a(Long.valueOf(d.this.o)).c(d.this.c.getPackageName());
                try {
                    i.a aVarB = new i.a().b(com.opos.mobad.service.d.b.a().getAndroidId()).c(com.opos.cmn.f.c.b()).d(com.opos.mobad.service.c.a.a().h()).e(com.opos.mobad.service.c.a.a().i()).f(com.opos.mobad.service.c.a.a().j()).a(Boolean.valueOf(com.opos.mobad.service.c.a.a().l())).b(Boolean.valueOf(com.opos.mobad.service.c.a.a().f()));
                    a.C0768a c0768aM = com.opos.mobad.service.c.a.a().m();
                    if (c0768aM != null) {
                        aVarB.a(c0768aM.f9210a).a((Integer) 1);
                    } else {
                        aVarB.a("");
                    }
                    j jVarB = new j.a().a(aVarB.b()).a(new k.a().c(com.opos.cmn.an.c.c.c()).a(com.opos.cmn.an.c.d.b()).b(com.opos.cmn.an.c.d.a()).b()).b(com.opos.cmn.an.c.a.a(d.this.c)).a(com.opos.cmn.an.c.c.a()).b();
                    n nVarB = new n.a().a(Boolean.valueOf(com.opos.mobad.service.d.d.a().c())).b(com.opos.mobad.service.d.d.a().b()).a(com.opos.mobad.service.d.d.a().d()).b();
                    aa aaVarB = new aa.a().a(Boolean.valueOf(com.opos.mobad.service.d.d.a().e())).b(com.opos.mobad.service.d.d.a().g()).a(com.opos.mobad.service.d.d.a().f()).b();
                    p pVarB = new p.a().a(Integer.valueOf(com.opos.cmn.i.i.a(d.this.c))).a(com.opos.cmn.i.i.b(d.this.c)).b();
                    String strB = d.this.s.b().b();
                    int i = -1;
                    t tVarA = null;
                    if (TextUtils.isEmpty(strB)) {
                        wVarB = null;
                    } else {
                        w.a aVarA = new w.a().a(strB);
                        int iC = d.this.s.b().c();
                        aVarA.a(iC != -1 ? iC != 0 ? iC != 1 ? z.UNKNOWN_STATUS : z.VIP : z.NORMAL : z.UNKNOWN_STATUS);
                        wVarB = aVarA.b();
                        i = iC;
                    }
                    o.a aVarA2 = new o.a().a(com.opos.cmn.a.a.b());
                    d.b bVarL = com.opos.mobad.service.d.d.a().l();
                    if (bVarL != null) {
                        aVarC.a(new b.a().a(bVarL.b).a(Integer.valueOf(bVarL.f9228a)).b());
                    }
                    try {
                        aVarA2.b(com.opos.cmn.an.c.b.a());
                        aVarA2.c(com.opos.cmn.an.c.b.b());
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.c("DispatchController", "local fail", e);
                    }
                    s sVarB = aVarC.a(jVarB).a(nVarB).a(aaVarB).a(pVarB).a(aVarA2.b()).b(Long.valueOf(d.this.g())).a(wVarB).c(Long.valueOf(com.opos.mobad.o.d.a(d.this.c, "adCacheTime", 0L))).b();
                    com.opos.cmn.an.f.a.a("DispatchController", "refresh request", sVarB);
                    HashMap map = new HashMap();
                    map.put("Content-Type", "application/x-protobuf");
                    map.put("Route-Data", com.opos.cmn.biz.a.e.a(d.this.c));
                    d.a aVarB2 = new d.a().a(s.c.b(sVarB)).a(map).b(d.this.F());
                    aVarB2.a("POST");
                    com.opos.cmn.func.a.a.e eVarA = com.opos.cmn.func.a.a.b.a().a(d.this.c, aVarB2.a());
                    if (eVarA != null) {
                        try {
                            if (200 == eVarA.f7934a) {
                                try {
                                    tVarA = t.c.a(eVarA.c);
                                } catch (Throwable th) {
                                    com.opos.cmn.an.f.a.c("DispatchController", "decode fail", th);
                                    d.this.s.e().b(th);
                                }
                                if (tVarA == null) {
                                    com.opos.cmn.an.f.a.a("DispatchController", "get dispatch parse fail");
                                    interfaceC0673a.b();
                                    eVarA.a();
                                    return;
                                } else {
                                    com.opos.cmn.an.f.a.a("DispatchController", "response dispatch strategy:", tVarA);
                                    d.this.a(tVarA);
                                    d.this.j = Integer.valueOf(i);
                                    com.opos.mobad.service.e.a(d.this.B());
                                    interfaceC0673a.a();
                                    eVarA.a();
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            if (eVarA != null) {
                                eVarA.a();
                            }
                            throw th2;
                        }
                    }
                    com.opos.cmn.an.f.a.a("DispatchController", "get dispatch fail code:", eVarA);
                    if (eVarA != null) {
                        eVarA.a();
                    }
                } catch (Throwable th3) {
                    com.opos.cmn.an.f.a.c("DispatchController", "refresh() fail", th3);
                }
                interfaceC0673a.b();
            }
        });
    }

    public boolean c() {
        if (this.k.b == null || this.k.b.p == null) {
            return false;
        }
        return this.k.b.p.booleanValue();
    }

    public Point d(String str) {
        v vVar;
        Map<String, e> map = this.l.get();
        e eVarG = map == null ? g(str) : map.get(str);
        if (eVarG == null || (vVar = eVarG.f8588a) == null || vVar.C == null || vVar.B == null) {
            return null;
        }
        return new Point(eVarG.f8588a.C.intValue(), eVarG.f8588a.B.intValue());
    }

    public boolean e(String str) {
        v vVar;
        Boolean bool;
        Map<String, e> map = this.l.get();
        e eVarG = map == null ? g(str) : map.get(str);
        if (eVarG == null || (vVar = eVarG.f8588a) == null || (bool = vVar.D) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean f(String str) {
        v vVar;
        Boolean bool;
        Map<String, e> map = this.l.get();
        e eVarG = map == null ? g(str) : map.get(str);
        boolean zBooleanValue = v.p.booleanValue();
        return (eVarG == null || (vVar = eVarG.f8588a) == null || (bool = vVar.E) == null) ? zBooleanValue : bool.booleanValue();
    }

    public boolean c(String str) {
        Boolean bool;
        Map<String, e> map = this.l.get();
        e eVarG = map == null ? g(str) : map.get(str);
        return (eVarG == null || (bool = eVarG.f8588a.A) == null) ? v.l.booleanValue() : bool.booleanValue();
    }

    public String d(int i) {
        return "";
    }

    public void a() {
        com.opos.cmn.i.a aVar;
        if (this.c == null || (aVar = this.i) == null) {
            return;
        }
        aVar.a();
    }

    public boolean b() {
        return this.k.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(com.opos.mobad.n.a.e eVar) {
        return eVar == com.opos.mobad.n.a.e.TT || eVar == com.opos.mobad.n.a.e.GDT || eVar == com.opos.mobad.n.a.e.UNION || eVar == com.opos.mobad.n.a.e.MIX || eVar == com.opos.mobad.n.a.e.FB || eVar == com.opos.mobad.n.a.e.GG || eVar == com.opos.mobad.n.a.e.JD || eVar == com.opos.mobad.n.a.e.MTG || eVar == com.opos.mobad.n.a.e.PANGLE || eVar == com.opos.mobad.n.a.e.KS || eVar == com.opos.mobad.n.a.e.TOPON;
    }

    public void a(Context context, String str, String str2, int i, int i2, long j) {
        this.c = context;
        this.e = str;
        this.f = str2;
        this.d = i;
        this.g = i2;
        this.o = j;
        this.h = new com.opos.mobad.c.a.c(context, str, str2);
        E();
        this.i.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        com.opos.cmn.an.f.a.a("DispatchController", "read local strategy size:" + bundle.size());
        this.u = bundle;
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            PosInfo posInfo = (PosInfo) bundle.getParcelable(str);
            try {
                map.put(str, new e(posInfo.b, v.c.a(posInfo.f9177a)));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("DispatchController", "decode local fail", e);
            }
        }
        com.opos.cmn.an.f.a.b("DispatchController", "decode local strategy size:" + map.size());
        if (g23.a(this.l, null, map)) {
            com.opos.cmn.an.f.a.b("DispatchController", "local strategy size:" + map.size());
            InterfaceC0721d interfaceC0721d = this.m;
            if (interfaceC0721d != null) {
                interfaceC0721d.a(true);
            }
        }
        this.u = null;
    }

    public boolean b(String str) {
        Boolean bool;
        Map<String, e> map = this.l.get();
        e eVarG = map == null ? g(str) : map.get(str);
        return (eVarG == null || (bool = eVarG.f8588a.z) == null) ? v.k.booleanValue() : bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.InterfaceC0673a interfaceC0673a) {
        com.opos.cmn.an.f.a.a("DispatchController", "init from local");
        this.h.a(new c.a() { // from class: com.opos.mobad.c.a.d.1
            @Override // com.opos.mobad.c.a.c.a
            public void a() {
                com.opos.cmn.an.f.a.a("DispatchController", "read app info local fail");
                interfaceC0673a.b();
                d.this.a();
            }

            @Override // com.opos.mobad.c.a.c.a
            public void a(u uVar, long j) {
                com.opos.cmn.an.f.a.a("DispatchController", "read app info local succ:", uVar);
                Long l = uVar.j;
                d.this.a(uVar.f, uVar.i, j, uVar.h.longValue(), l != null ? l.longValue() : 0L, uVar.k, uVar.l, uVar.m, uVar.n, uVar.o);
                com.opos.mobad.service.e.a(d.this.B());
                if (d.this.k != null && d.this.k.a()) {
                    d.this.b(interfaceC0673a);
                } else {
                    com.opos.cmn.an.f.a.a("DispatchController", "do not need to refresh");
                    interfaceC0673a.b();
                }
            }
        });
        D();
    }

    public void a(InterfaceC0721d interfaceC0721d) {
        this.m = interfaceC0721d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar) throws JSONException {
        if (tVar.f.intValue() != 0) {
            com.opos.cmn.an.f.a.a("DispatchController", "handleResponse() fail code=", tVar.f, "msg=" + tVar.g);
            return;
        }
        u uVar = tVar.h;
        if (uVar == null) {
            com.opos.cmn.an.f.a.a("DispatchController", "response data null");
            return;
        }
        Long l = uVar.j;
        long jLongValue = l != null ? l.longValue() : 0L;
        HashMap map = new HashMap();
        for (v vVar : uVar.g) {
            map.put(vVar.q, new e(jLongValue, vVar));
        }
        this.h.a(uVar, tVar.i.longValue());
        this.k = new c(uVar.f, uVar.i, tVar.i.longValue(), uVar.h.longValue(), jLongValue, uVar.k, uVar.l, uVar.m, uVar.n, uVar.o);
        a(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<g> list, com.opos.mobad.n.a.c cVar, long j, long j2, long j3, String str, List<r> list2, String str2, String str3, m mVar) {
        this.k = new c(list, cVar, j, j2, j3, str, list2, str2, str3, mVar);
        InterfaceC0721d interfaceC0721d = this.m;
        if (interfaceC0721d != null) {
            interfaceC0721d.a(true);
        }
    }

    private void a(Map<String, e> map) {
        com.opos.cmn.an.f.a.b("DispatchController", "refresh strategy size:" + map.size());
        this.l.set(map);
        InterfaceC0721d interfaceC0721d = this.m;
        if (interfaceC0721d != null) {
            interfaceC0721d.a(false);
        }
    }

    public boolean a(int i) {
        boolean zA = i == a.b ? this.s.c().a() : i == a.c ? this.s.c().b() : i == 1001 ? this.s.c().d() : i == a.e ? this.s.c().e() : true;
        com.opos.cmn.an.f.a.b("DispatchController", "isChannelEnable() channel=", Integer.valueOf(i), "result=", Boolean.valueOf(zA));
        return zA;
    }
}
