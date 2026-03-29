package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hf implements hq<hf, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f687a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gt f688a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f689a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f692a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f694b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f695b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f696b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f698c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f699c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f701d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f702e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f703f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f704g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f705h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f706i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public String f707j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public String f708k;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public String f709l;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public String f710m;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    public String f711n;

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    public String f712o;

    /* JADX INFO: renamed from: p, reason: collision with other field name */
    public String f713p;

    /* JADX INFO: renamed from: q, reason: collision with other field name */
    public String f714q;

    /* JADX INFO: renamed from: r, reason: collision with other field name */
    public String f715r;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f685a = new Cif("XmPushActionRegistration");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11625a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 12, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 11, 5);
    private static final hx f = new hx("", (byte) 11, 6);
    private static final hx g = new hx("", (byte) 11, 7);
    private static final hx h = new hx("", (byte) 11, 8);
    private static final hx i = new hx("", (byte) 11, 9);
    private static final hx j = new hx("", (byte) 11, 10);
    private static final hx k = new hx("", (byte) 11, 11);
    private static final hx l = new hx("", (byte) 11, 12);
    private static final hx m = new hx("", (byte) 8, 13);
    private static final hx n = new hx("", (byte) 8, 14);
    private static final hx o = new hx("", (byte) 11, 15);
    private static final hx p = new hx("", (byte) 11, 16);
    private static final hx q = new hx("", (byte) 11, 17);
    private static final hx r = new hx("", (byte) 11, 18);
    private static final hx s = new hx("", (byte) 8, 19);
    private static final hx t = new hx("", (byte) 8, 20);
    private static final hx u = new hx("", (byte) 2, 21);
    private static final hx v = new hx("", (byte) 10, 22);
    private static final hx w = new hx("", (byte) 10, 23);
    private static final hx x = new hx("", (byte) 11, 24);
    private static final hx y = new hx("", (byte) 11, 25);
    private static final hx z = new hx("", (byte) 2, 26);
    private static final hx A = new hx("", com.umeng.analytics.pro.dn.k, 100);
    private static final hx B = new hx("", (byte) 2, 101);
    private static final hx C = new hx("", (byte) 11, 102);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f691a = new BitSet(8);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f693a = true;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f700c = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f697b = false;

    public boolean A() {
        return this.f692a != null;
    }

    public boolean B() {
        return this.f691a.get(7);
    }

    public boolean C() {
        return this.f715r != null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m579a() {
        return this.f690a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m581b() {
        return this.f689a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m582c() {
        return this.f696b != null;
    }

    public boolean d() {
        return this.f699c != null;
    }

    public boolean e() {
        return this.f701d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hf)) {
            return m580a((hf) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f702e != null;
    }

    public boolean g() {
        return this.f703f != null;
    }

    public boolean h() {
        return this.f704g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f705h != null;
    }

    public boolean j() {
        return this.f706i != null;
    }

    public boolean k() {
        return this.f707j != null;
    }

    public boolean l() {
        return this.f708k != null;
    }

    public boolean m() {
        return this.f691a.get(0);
    }

    public boolean n() {
        return this.f691a.get(1);
    }

    public boolean o() {
        return this.f709l != null;
    }

    public boolean p() {
        return this.f710m != null;
    }

    public boolean q() {
        return this.f711n != null;
    }

    public boolean r() {
        return this.f712o != null;
    }

    public boolean s() {
        return this.f691a.get(2);
    }

    public boolean t() {
        return this.f688a != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z3 = false;
        if (m579a()) {
            sb.append("debug:");
            String str = this.f690a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (m581b()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f689a;
            if (guVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(guVar);
            }
        } else {
            z3 = z2;
        }
        if (!z3) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f696b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f699c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str4 = this.f701d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f702e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        sb.append(", ");
        sb.append("token:");
        String str6 = this.f703f;
        if (str6 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str6);
        }
        if (h()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str7 = this.f704g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str8 = this.f705h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("sdkVersion:");
            String str9 = this.f706i;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str10 = this.f707j;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str10);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("pushSdkVersionName:");
            String str11 = this.f708k;
            if (str11 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str11);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f686a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f694b);
        }
        if (o()) {
            sb.append(", ");
            sb.append("androidId:");
            String str12 = this.f709l;
            if (str12 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str12);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("imei:");
            String str13 = this.f710m;
            if (str13 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str13);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("serial:");
            String str14 = this.f711n;
            if (str14 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str14);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str15 = this.f712o;
            if (str15 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str15);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("spaceId:");
            sb.append(this.f698c);
        }
        if (t()) {
            sb.append(", ");
            sb.append("reason:");
            gt gtVar = this.f688a;
            if (gtVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(gtVar);
            }
        }
        if (u()) {
            sb.append(", ");
            sb.append("validateToken:");
            sb.append(this.f693a);
        }
        if (v()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f687a);
        }
        if (w()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f695b);
        }
        if (x()) {
            sb.append(", ");
            sb.append("subImei:");
            String str16 = this.f713p;
            if (str16 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str16);
            }
        }
        if (y()) {
            sb.append(", ");
            sb.append("subImeiMd5:");
            String str17 = this.f714q;
            if (str17 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str17);
            }
        }
        if (z()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f697b);
        }
        if (A()) {
            sb.append(", ");
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f692a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map);
            }
        }
        if (B()) {
            sb.append(", ");
            sb.append("cleanOldRegInfo:");
            sb.append(this.f700c);
        }
        if (C()) {
            sb.append(", ");
            sb.append("oldRegId:");
            String str18 = this.f715r;
            if (str18 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str18);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean u() {
        return this.f691a.get(3);
    }

    public boolean v() {
        return this.f691a.get(4);
    }

    public boolean w() {
        return this.f691a.get(5);
    }

    public boolean x() {
        return this.f713p != null;
    }

    public boolean y() {
        return this.f714q != null;
    }

    public boolean z() {
        return this.f691a.get(6);
    }

    public String a() {
        return this.f696b;
    }

    public String b() {
        return this.f699c;
    }

    public hf c(String str) {
        this.f701d = str;
        return this;
    }

    public hf d(String str) {
        this.f702e = str;
        return this;
    }

    public hf e(String str) {
        this.f703f = str;
        return this;
    }

    public hf f(String str) {
        this.f704g = str;
        return this;
    }

    public hf g(String str) {
        this.f705h = str;
        return this;
    }

    public hf h(String str) {
        this.f708k = str;
        return this;
    }

    public hf i(String str) {
        this.f712o = str;
        return this;
    }

    public hf a(String str) {
        this.f696b = str;
        return this;
    }

    public hf b(String str) {
        this.f699c = str;
        return this;
    }

    public String c() {
        return this.f703f;
    }

    public void d(boolean z2) {
        this.f691a.set(3, z2);
    }

    public void e(boolean z2) {
        this.f691a.set(4, z2);
    }

    public void f(boolean z2) {
        this.f691a.set(5, z2);
    }

    public void g(boolean z2) {
        this.f691a.set(6, z2);
    }

    public void h(boolean z2) {
        this.f691a.set(7, z2);
    }

    public hf a(int i2) {
        this.f686a = i2;
        a(true);
        return this;
    }

    public hf b(int i2) {
        this.f694b = i2;
        b(true);
        return this;
    }

    public hf c(int i2) {
        this.f698c = i2;
        c(true);
        return this;
    }

    public void a(boolean z2) {
        this.f691a.set(0, z2);
    }

    public void b(boolean z2) {
        this.f691a.set(1, z2);
    }

    public void c(boolean z2) {
        this.f691a.set(2, z2);
    }

    public hf a(gt gtVar) {
        this.f688a = gtVar;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m578a();
        iaVar.a(f685a);
        if (this.f690a != null && m579a()) {
            iaVar.a(f11625a);
            iaVar.a(this.f690a);
            iaVar.b();
        }
        if (this.f689a != null && m581b()) {
            iaVar.a(b);
            this.f689a.b(iaVar);
            iaVar.b();
        }
        if (this.f696b != null) {
            iaVar.a(c);
            iaVar.a(this.f696b);
            iaVar.b();
        }
        if (this.f699c != null) {
            iaVar.a(d);
            iaVar.a(this.f699c);
            iaVar.b();
        }
        if (this.f701d != null && e()) {
            iaVar.a(e);
            iaVar.a(this.f701d);
            iaVar.b();
        }
        if (this.f702e != null && f()) {
            iaVar.a(f);
            iaVar.a(this.f702e);
            iaVar.b();
        }
        if (this.f703f != null) {
            iaVar.a(g);
            iaVar.a(this.f703f);
            iaVar.b();
        }
        if (this.f704g != null && h()) {
            iaVar.a(h);
            iaVar.a(this.f704g);
            iaVar.b();
        }
        if (this.f705h != null && i()) {
            iaVar.a(i);
            iaVar.a(this.f705h);
            iaVar.b();
        }
        if (this.f706i != null && j()) {
            iaVar.a(j);
            iaVar.a(this.f706i);
            iaVar.b();
        }
        if (this.f707j != null && k()) {
            iaVar.a(k);
            iaVar.a(this.f707j);
            iaVar.b();
        }
        if (this.f708k != null && l()) {
            iaVar.a(l);
            iaVar.a(this.f708k);
            iaVar.b();
        }
        if (m()) {
            iaVar.a(m);
            iaVar.mo636a(this.f686a);
            iaVar.b();
        }
        if (n()) {
            iaVar.a(n);
            iaVar.mo636a(this.f694b);
            iaVar.b();
        }
        if (this.f709l != null && o()) {
            iaVar.a(o);
            iaVar.a(this.f709l);
            iaVar.b();
        }
        if (this.f710m != null && p()) {
            iaVar.a(p);
            iaVar.a(this.f710m);
            iaVar.b();
        }
        if (this.f711n != null && q()) {
            iaVar.a(q);
            iaVar.a(this.f711n);
            iaVar.b();
        }
        if (this.f712o != null && r()) {
            iaVar.a(r);
            iaVar.a(this.f712o);
            iaVar.b();
        }
        if (s()) {
            iaVar.a(s);
            iaVar.mo636a(this.f698c);
            iaVar.b();
        }
        if (this.f688a != null && t()) {
            iaVar.a(t);
            iaVar.mo636a(this.f688a.a());
            iaVar.b();
        }
        if (u()) {
            iaVar.a(u);
            iaVar.a(this.f693a);
            iaVar.b();
        }
        if (v()) {
            iaVar.a(v);
            iaVar.a(this.f687a);
            iaVar.b();
        }
        if (w()) {
            iaVar.a(w);
            iaVar.a(this.f695b);
            iaVar.b();
        }
        if (this.f713p != null && x()) {
            iaVar.a(x);
            iaVar.a(this.f713p);
            iaVar.b();
        }
        if (this.f714q != null && y()) {
            iaVar.a(y);
            iaVar.a(this.f714q);
            iaVar.b();
        }
        if (z()) {
            iaVar.a(z);
            iaVar.a(this.f697b);
            iaVar.b();
        }
        if (this.f692a != null && A()) {
            iaVar.a(A);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f692a.size()));
            for (Map.Entry<String, String> entry : this.f692a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (B()) {
            iaVar.a(B);
            iaVar.a(this.f700c);
            iaVar.b();
        }
        if (this.f715r != null && C()) {
            iaVar.a(C);
            iaVar.a(this.f715r);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m580a(hf hfVar) {
        if (hfVar == null) {
            return false;
        }
        boolean zM579a = m579a();
        boolean zM579a2 = hfVar.m579a();
        if ((zM579a || zM579a2) && !(zM579a && zM579a2 && this.f690a.equals(hfVar.f690a))) {
            return false;
        }
        boolean zM581b = m581b();
        boolean zM581b2 = hfVar.m581b();
        if ((zM581b || zM581b2) && !(zM581b && zM581b2 && this.f689a.m531a(hfVar.f689a))) {
            return false;
        }
        boolean zM582c = m582c();
        boolean zM582c2 = hfVar.m582c();
        if ((zM582c || zM582c2) && !(zM582c && zM582c2 && this.f696b.equals(hfVar.f696b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hfVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f699c.equals(hfVar.f699c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hfVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f701d.equals(hfVar.f701d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hfVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f702e.equals(hfVar.f702e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hfVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f703f.equals(hfVar.f703f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hfVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f704g.equals(hfVar.f704g))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hfVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f705h.equals(hfVar.f705h))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = hfVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f706i.equals(hfVar.f706i))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = hfVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f707j.equals(hfVar.f707j))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = hfVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f708k.equals(hfVar.f708k))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = hfVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f686a == hfVar.f686a)) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = hfVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f694b == hfVar.f694b)) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = hfVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f709l.equals(hfVar.f709l))) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = hfVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f710m.equals(hfVar.f710m))) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = hfVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f711n.equals(hfVar.f711n))) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = hfVar.r();
        if ((zR || zR2) && !(zR && zR2 && this.f712o.equals(hfVar.f712o))) {
            return false;
        }
        boolean zS = s();
        boolean zS2 = hfVar.s();
        if ((zS || zS2) && !(zS && zS2 && this.f698c == hfVar.f698c)) {
            return false;
        }
        boolean zT = t();
        boolean zT2 = hfVar.t();
        if ((zT || zT2) && !(zT && zT2 && this.f688a.equals(hfVar.f688a))) {
            return false;
        }
        boolean zU = u();
        boolean zU2 = hfVar.u();
        if ((zU || zU2) && !(zU && zU2 && this.f693a == hfVar.f693a)) {
            return false;
        }
        boolean zV = v();
        boolean zV2 = hfVar.v();
        if ((zV || zV2) && !(zV && zV2 && this.f687a == hfVar.f687a)) {
            return false;
        }
        boolean zW = w();
        boolean zW2 = hfVar.w();
        if ((zW || zW2) && !(zW && zW2 && this.f695b == hfVar.f695b)) {
            return false;
        }
        boolean zX = x();
        boolean zX2 = hfVar.x();
        if ((zX || zX2) && !(zX && zX2 && this.f713p.equals(hfVar.f713p))) {
            return false;
        }
        boolean zY = y();
        boolean zY2 = hfVar.y();
        if ((zY || zY2) && !(zY && zY2 && this.f714q.equals(hfVar.f714q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = hfVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f697b == hfVar.f697b)) {
            return false;
        }
        boolean zA = A();
        boolean zA2 = hfVar.A();
        if ((zA || zA2) && !(zA && zA2 && this.f692a.equals(hfVar.f692a))) {
            return false;
        }
        boolean zB = B();
        boolean zB2 = hfVar.B();
        if ((zB || zB2) && !(zB && zB2 && this.f700c == hfVar.f700c)) {
            return false;
        }
        boolean zC = C();
        boolean zC2 = hfVar.C();
        if (zC || zC2) {
            return zC && zC2 && this.f715r.equals(hfVar.f715r);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hf hfVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        int iA10;
        int iA11;
        int iA12;
        int iA13;
        int iA14;
        int iA15;
        int iA16;
        int iA17;
        int iA18;
        int iA19;
        int iA20;
        int iA21;
        int iA22;
        int iA23;
        int iA24;
        int iA25;
        int iA26;
        int iA27;
        int iA28;
        int iA29;
        if (!getClass().equals(hfVar.getClass())) {
            return getClass().getName().compareTo(hfVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m579a()).compareTo(Boolean.valueOf(hfVar.m579a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m579a() && (iA29 = hr.a(this.f690a, hfVar.f690a)) != 0) {
            return iA29;
        }
        int iCompareTo2 = Boolean.valueOf(m581b()).compareTo(Boolean.valueOf(hfVar.m581b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m581b() && (iA28 = hr.a(this.f689a, hfVar.f689a)) != 0) {
            return iA28;
        }
        int iCompareTo3 = Boolean.valueOf(m582c()).compareTo(Boolean.valueOf(hfVar.m582c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m582c() && (iA27 = hr.a(this.f696b, hfVar.f696b)) != 0) {
            return iA27;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hfVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA26 = hr.a(this.f699c, hfVar.f699c)) != 0) {
            return iA26;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hfVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA25 = hr.a(this.f701d, hfVar.f701d)) != 0) {
            return iA25;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hfVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA24 = hr.a(this.f702e, hfVar.f702e)) != 0) {
            return iA24;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hfVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA23 = hr.a(this.f703f, hfVar.f703f)) != 0) {
            return iA23;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hfVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA22 = hr.a(this.f704g, hfVar.f704g)) != 0) {
            return iA22;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hfVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA21 = hr.a(this.f705h, hfVar.f705h)) != 0) {
            return iA21;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hfVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA20 = hr.a(this.f706i, hfVar.f706i)) != 0) {
            return iA20;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hfVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA19 = hr.a(this.f707j, hfVar.f707j)) != 0) {
            return iA19;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hfVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA18 = hr.a(this.f708k, hfVar.f708k)) != 0) {
            return iA18;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hfVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA17 = hr.a(this.f686a, hfVar.f686a)) != 0) {
            return iA17;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hfVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA16 = hr.a(this.f694b, hfVar.f694b)) != 0) {
            return iA16;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hfVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA15 = hr.a(this.f709l, hfVar.f709l)) != 0) {
            return iA15;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hfVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA14 = hr.a(this.f710m, hfVar.f710m)) != 0) {
            return iA14;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hfVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA13 = hr.a(this.f711n, hfVar.f711n)) != 0) {
            return iA13;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hfVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (r() && (iA12 = hr.a(this.f712o, hfVar.f712o)) != 0) {
            return iA12;
        }
        int iCompareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hfVar.s()));
        if (iCompareTo19 != 0) {
            return iCompareTo19;
        }
        if (s() && (iA11 = hr.a(this.f698c, hfVar.f698c)) != 0) {
            return iA11;
        }
        int iCompareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hfVar.t()));
        if (iCompareTo20 != 0) {
            return iCompareTo20;
        }
        if (t() && (iA10 = hr.a(this.f688a, hfVar.f688a)) != 0) {
            return iA10;
        }
        int iCompareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(hfVar.u()));
        if (iCompareTo21 != 0) {
            return iCompareTo21;
        }
        if (u() && (iA9 = hr.a(this.f693a, hfVar.f693a)) != 0) {
            return iA9;
        }
        int iCompareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(hfVar.v()));
        if (iCompareTo22 != 0) {
            return iCompareTo22;
        }
        if (v() && (iA8 = hr.a(this.f687a, hfVar.f687a)) != 0) {
            return iA8;
        }
        int iCompareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(hfVar.w()));
        if (iCompareTo23 != 0) {
            return iCompareTo23;
        }
        if (w() && (iA7 = hr.a(this.f695b, hfVar.f695b)) != 0) {
            return iA7;
        }
        int iCompareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(hfVar.x()));
        if (iCompareTo24 != 0) {
            return iCompareTo24;
        }
        if (x() && (iA6 = hr.a(this.f713p, hfVar.f713p)) != 0) {
            return iA6;
        }
        int iCompareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(hfVar.y()));
        if (iCompareTo25 != 0) {
            return iCompareTo25;
        }
        if (y() && (iA5 = hr.a(this.f714q, hfVar.f714q)) != 0) {
            return iA5;
        }
        int iCompareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(hfVar.z()));
        if (iCompareTo26 != 0) {
            return iCompareTo26;
        }
        if (z() && (iA4 = hr.a(this.f697b, hfVar.f697b)) != 0) {
            return iA4;
        }
        int iCompareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(hfVar.A()));
        if (iCompareTo27 != 0) {
            return iCompareTo27;
        }
        if (A() && (iA3 = hr.a(this.f692a, hfVar.f692a)) != 0) {
            return iA3;
        }
        int iCompareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(hfVar.B()));
        if (iCompareTo28 != 0) {
            return iCompareTo28;
        }
        if (B() && (iA2 = hr.a(this.f700c, hfVar.f700c)) != 0) {
            return iA2;
        }
        int iCompareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(hfVar.C()));
        if (iCompareTo29 != 0) {
            return iCompareTo29;
        }
        if (!C() || (iA = hr.a(this.f715r, hfVar.f715r)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.hq
    public void a(ia iaVar) throws ib {
        iaVar.mo631a();
        while (true) {
            hx hxVarMo627a = iaVar.mo627a();
            byte b2 = hxVarMo627a.f11640a;
            if (b2 == 0) {
                iaVar.f();
                m578a();
                return;
            }
            short s2 = hxVarMo627a.f836a;
            switch (s2) {
                case 1:
                    if (b2 == 11) {
                        this.f690a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f689a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f696b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f699c = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f701d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f702e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f703f = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f704g = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f705h = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f706i = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f707j = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f708k = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 13:
                    if (b2 == 8) {
                        this.f686a = iaVar.mo625a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 14:
                    if (b2 == 8) {
                        this.f694b = iaVar.mo625a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f709l = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 16:
                    if (b2 == 11) {
                        this.f710m = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f711n = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 18:
                    if (b2 == 11) {
                        this.f712o = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 19:
                    if (b2 == 8) {
                        this.f698c = iaVar.mo625a();
                        c(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 20:
                    if (b2 == 8) {
                        this.f688a = gt.a(iaVar.mo625a());
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 21:
                    if (b2 == 2) {
                        this.f693a = iaVar.mo637a();
                        d(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 22:
                    if (b2 == 10) {
                        this.f687a = iaVar.mo626a();
                        e(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 23:
                    if (b2 == 10) {
                        this.f695b = iaVar.mo626a();
                        f(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 24:
                    if (b2 == 11) {
                        this.f713p = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 25:
                    if (b2 == 11) {
                        this.f714q = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 26:
                    if (b2 == 2) {
                        this.f697b = iaVar.mo637a();
                        g(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                default:
                    switch (s2) {
                        case 100:
                            if (b2 == 13) {
                                hz hzVarMo629a = iaVar.mo629a();
                                this.f692a = new HashMap(hzVarMo629a.f838a * 2);
                                for (int i2 = 0; i2 < hzVarMo629a.f838a; i2++) {
                                    this.f692a.put(iaVar.mo632a(), iaVar.mo632a());
                                }
                                iaVar.h();
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 101:
                            if (b2 == 2) {
                                this.f700c = iaVar.mo637a();
                                h(true);
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 102:
                            if (b2 == 11) {
                                this.f715r = iaVar.mo632a();
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        default:
                            id.a(iaVar, b2);
                            break;
                    }
                    break;
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m578a() throws ib {
        if (this.f696b != null) {
            if (this.f699c != null) {
                if (this.f703f != null) {
                    return;
                }
                throw new ib("Required field 'token' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
