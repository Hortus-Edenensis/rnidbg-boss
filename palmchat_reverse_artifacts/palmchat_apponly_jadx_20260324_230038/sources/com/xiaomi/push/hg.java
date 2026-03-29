package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hg implements hq<hg, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f717a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f718a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f719a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f720a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f722a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f724b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f725b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f726b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f727c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f728c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f729d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f730e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f731f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f732g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f733h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f734i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public String f735j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public String f736k;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public String f737l;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f716a = new Cif("XmPushActionRegistrationResult");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11626a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 12, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 10, 6);
    private static final hx f = new hx("", (byte) 11, 7);
    private static final hx g = new hx("", (byte) 11, 8);
    private static final hx h = new hx("", (byte) 11, 9);
    private static final hx i = new hx("", (byte) 11, 10);
    private static final hx j = new hx("", (byte) 10, 11);
    private static final hx k = new hx("", (byte) 11, 12);
    private static final hx l = new hx("", (byte) 11, 13);
    private static final hx m = new hx("", (byte) 10, 14);
    private static final hx n = new hx("", (byte) 11, 15);
    private static final hx o = new hx("", (byte) 8, 16);
    private static final hx p = new hx("", (byte) 11, 17);
    private static final hx q = new hx("", (byte) 8, 18);
    private static final hx r = new hx("", (byte) 11, 19);
    private static final hx s = new hx("", (byte) 2, 20);
    private static final hx t = new hx("", (byte) 15, 21);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f721a = new BitSet(6);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f723a = false;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m586a() {
        return this.f720a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m588b() {
        return this.f719a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m589c() {
        return this.f726b != null;
    }

    public boolean d() {
        return this.f728c != null;
    }

    public boolean e() {
        return this.f721a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hg)) {
            return m587a((hg) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f729d != null;
    }

    public boolean g() {
        return this.f730e != null;
    }

    public boolean h() {
        return this.f731f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f732g != null;
    }

    public boolean j() {
        return this.f721a.get(1);
    }

    public boolean k() {
        return this.f733h != null;
    }

    public boolean l() {
        return this.f734i != null;
    }

    public boolean m() {
        return this.f721a.get(2);
    }

    public boolean n() {
        return this.f735j != null;
    }

    public boolean o() {
        return this.f721a.get(3);
    }

    public boolean p() {
        return this.f736k != null;
    }

    public boolean q() {
        return this.f721a.get(4);
    }

    public boolean r() {
        return this.f737l != null;
    }

    public boolean s() {
        return this.f721a.get(5);
    }

    public boolean t() {
        return this.f722a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = false;
        if (m586a()) {
            sb.append("debug:");
            String str = this.f720a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m588b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f719a;
            if (guVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(guVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f726b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str2));
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f728c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f718a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f729d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("regId:");
            String str5 = this.f730e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f732g;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("registeredAt:");
            sb.append(this.f725b);
        }
        if (k()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str7 = this.f733h;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("clientId:");
            String str8 = this.f734i;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f727c);
        }
        if (n()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str9 = this.f735j;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str9);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("pushSdkVersionCode:");
            sb.append(this.f717a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("hybridPushEndpoint:");
            String str10 = this.f736k;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str10);
            }
        }
        if (q()) {
            sb.append(", ");
            sb.append("appVersionCode:");
            sb.append(this.f724b);
        }
        if (r()) {
            sb.append(", ");
            sb.append("region:");
            String str11 = this.f737l;
            if (str11 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str11);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("isHybridFrame:");
            sb.append(this.f723a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("autoMarkPkgs:");
            List<String> list = this.f722a;
            if (list == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m583a() {
        return this.f726b;
    }

    public String b() {
        return this.f731f;
    }

    public String c() {
        return this.f732g;
    }

    public void d(boolean z) {
        this.f721a.set(3, z);
    }

    public void e(boolean z) {
        this.f721a.set(4, z);
    }

    public void f(boolean z) {
        this.f721a.set(5, z);
    }

    public long a() {
        return this.f718a;
    }

    public void b(boolean z) {
        this.f721a.set(1, z);
    }

    public void c(boolean z) {
        this.f721a.set(2, z);
    }

    public void a(boolean z) {
        this.f721a.set(0, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m585a();
        iaVar.a(f716a);
        if (this.f720a != null && m586a()) {
            iaVar.a(f11626a);
            iaVar.a(this.f720a);
            iaVar.b();
        }
        if (this.f719a != null && m588b()) {
            iaVar.a(b);
            this.f719a.b(iaVar);
            iaVar.b();
        }
        if (this.f726b != null) {
            iaVar.a(c);
            iaVar.a(this.f726b);
            iaVar.b();
        }
        if (this.f728c != null) {
            iaVar.a(d);
            iaVar.a(this.f728c);
            iaVar.b();
        }
        iaVar.a(e);
        iaVar.a(this.f718a);
        iaVar.b();
        if (this.f729d != null && f()) {
            iaVar.a(f);
            iaVar.a(this.f729d);
            iaVar.b();
        }
        if (this.f730e != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f730e);
            iaVar.b();
        }
        if (this.f731f != null && h()) {
            iaVar.a(h);
            iaVar.a(this.f731f);
            iaVar.b();
        }
        if (this.f732g != null && i()) {
            iaVar.a(i);
            iaVar.a(this.f732g);
            iaVar.b();
        }
        if (j()) {
            iaVar.a(j);
            iaVar.a(this.f725b);
            iaVar.b();
        }
        if (this.f733h != null && k()) {
            iaVar.a(k);
            iaVar.a(this.f733h);
            iaVar.b();
        }
        if (this.f734i != null && l()) {
            iaVar.a(l);
            iaVar.a(this.f734i);
            iaVar.b();
        }
        if (m()) {
            iaVar.a(m);
            iaVar.a(this.f727c);
            iaVar.b();
        }
        if (this.f735j != null && n()) {
            iaVar.a(n);
            iaVar.a(this.f735j);
            iaVar.b();
        }
        if (o()) {
            iaVar.a(o);
            iaVar.mo636a(this.f717a);
            iaVar.b();
        }
        if (this.f736k != null && p()) {
            iaVar.a(p);
            iaVar.a(this.f736k);
            iaVar.b();
        }
        if (q()) {
            iaVar.a(q);
            iaVar.mo636a(this.f724b);
            iaVar.b();
        }
        if (this.f737l != null && r()) {
            iaVar.a(r);
            iaVar.a(this.f737l);
            iaVar.b();
        }
        if (s()) {
            iaVar.a(s);
            iaVar.a(this.f723a);
            iaVar.b();
        }
        if (this.f722a != null && t()) {
            iaVar.a(t);
            iaVar.a(new hy((byte) 11, this.f722a.size()));
            Iterator<String> it = this.f722a.iterator();
            while (it.hasNext()) {
                iaVar.a(it.next());
            }
            iaVar.e();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public List<String> m584a() {
        return this.f722a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m587a(hg hgVar) {
        if (hgVar == null) {
            return false;
        }
        boolean zM586a = m586a();
        boolean zM586a2 = hgVar.m586a();
        if ((zM586a || zM586a2) && !(zM586a && zM586a2 && this.f720a.equals(hgVar.f720a))) {
            return false;
        }
        boolean zM588b = m588b();
        boolean zM588b2 = hgVar.m588b();
        if ((zM588b || zM588b2) && !(zM588b && zM588b2 && this.f719a.m531a(hgVar.f719a))) {
            return false;
        }
        boolean zM589c = m589c();
        boolean zM589c2 = hgVar.m589c();
        if ((zM589c || zM589c2) && !(zM589c && zM589c2 && this.f726b.equals(hgVar.f726b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hgVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f728c.equals(hgVar.f728c))) || this.f718a != hgVar.f718a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hgVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f729d.equals(hgVar.f729d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hgVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f730e.equals(hgVar.f730e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hgVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f731f.equals(hgVar.f731f))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hgVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f732g.equals(hgVar.f732g))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = hgVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f725b == hgVar.f725b)) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = hgVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f733h.equals(hgVar.f733h))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = hgVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f734i.equals(hgVar.f734i))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = hgVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f727c == hgVar.f727c)) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = hgVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f735j.equals(hgVar.f735j))) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = hgVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f717a == hgVar.f717a)) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = hgVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f736k.equals(hgVar.f736k))) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = hgVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f724b == hgVar.f724b)) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = hgVar.r();
        if ((zR || zR2) && !(zR && zR2 && this.f737l.equals(hgVar.f737l))) {
            return false;
        }
        boolean zS = s();
        boolean zS2 = hgVar.s();
        if ((zS || zS2) && !(zS && zS2 && this.f723a == hgVar.f723a)) {
            return false;
        }
        boolean zT = t();
        boolean zT2 = hgVar.t();
        if (zT || zT2) {
            return zT && zT2 && this.f722a.equals(hgVar.f722a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hg hgVar) {
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
        if (!getClass().equals(hgVar.getClass())) {
            return getClass().getName().compareTo(hgVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m586a()).compareTo(Boolean.valueOf(hgVar.m586a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m586a() && (iA20 = hr.a(this.f720a, hgVar.f720a)) != 0) {
            return iA20;
        }
        int iCompareTo2 = Boolean.valueOf(m588b()).compareTo(Boolean.valueOf(hgVar.m588b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m588b() && (iA19 = hr.a(this.f719a, hgVar.f719a)) != 0) {
            return iA19;
        }
        int iCompareTo3 = Boolean.valueOf(m589c()).compareTo(Boolean.valueOf(hgVar.m589c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m589c() && (iA18 = hr.a(this.f726b, hgVar.f726b)) != 0) {
            return iA18;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hgVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA17 = hr.a(this.f728c, hgVar.f728c)) != 0) {
            return iA17;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hgVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA16 = hr.a(this.f718a, hgVar.f718a)) != 0) {
            return iA16;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hgVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA15 = hr.a(this.f729d, hgVar.f729d)) != 0) {
            return iA15;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hgVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA14 = hr.a(this.f730e, hgVar.f730e)) != 0) {
            return iA14;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hgVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA13 = hr.a(this.f731f, hgVar.f731f)) != 0) {
            return iA13;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hgVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA12 = hr.a(this.f732g, hgVar.f732g)) != 0) {
            return iA12;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hgVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA11 = hr.a(this.f725b, hgVar.f725b)) != 0) {
            return iA11;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hgVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA10 = hr.a(this.f733h, hgVar.f733h)) != 0) {
            return iA10;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hgVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA9 = hr.a(this.f734i, hgVar.f734i)) != 0) {
            return iA9;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hgVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA8 = hr.a(this.f727c, hgVar.f727c)) != 0) {
            return iA8;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hgVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA7 = hr.a(this.f735j, hgVar.f735j)) != 0) {
            return iA7;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hgVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA6 = hr.a(this.f717a, hgVar.f717a)) != 0) {
            return iA6;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hgVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA5 = hr.a(this.f736k, hgVar.f736k)) != 0) {
            return iA5;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hgVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA4 = hr.a(this.f724b, hgVar.f724b)) != 0) {
            return iA4;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hgVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (r() && (iA3 = hr.a(this.f737l, hgVar.f737l)) != 0) {
            return iA3;
        }
        int iCompareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hgVar.s()));
        if (iCompareTo19 != 0) {
            return iCompareTo19;
        }
        if (s() && (iA2 = hr.a(this.f723a, hgVar.f723a)) != 0) {
            return iA2;
        }
        int iCompareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hgVar.t()));
        if (iCompareTo20 != 0) {
            return iCompareTo20;
        }
        if (!t() || (iA = hr.a(this.f722a, hgVar.f722a)) == 0) {
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
                if (e()) {
                    m585a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo627a.f836a) {
                case 1:
                    if (b2 == 11) {
                        this.f720a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f719a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f726b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f728c = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                default:
                    id.a(iaVar, b2);
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f718a = iaVar.mo626a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f729d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f730e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f731f = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f732g = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 11:
                    if (b2 == 10) {
                        this.f725b = iaVar.mo626a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f733h = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f734i = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 14:
                    if (b2 == 10) {
                        this.f727c = iaVar.mo626a();
                        c(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f735j = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 16:
                    if (b2 == 8) {
                        this.f717a = iaVar.mo625a();
                        d(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f736k = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 18:
                    if (b2 == 8) {
                        this.f724b = iaVar.mo625a();
                        e(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 19:
                    if (b2 == 11) {
                        this.f737l = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f723a = iaVar.mo637a();
                        f(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 21:
                    if (b2 == 15) {
                        hy hyVarMo628a = iaVar.mo628a();
                        this.f722a = new ArrayList(hyVarMo628a.f837a);
                        for (int i2 = 0; i2 < hyVarMo628a.f837a; i2++) {
                            this.f722a.add(iaVar.mo632a());
                        }
                        iaVar.i();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m585a() throws ib {
        if (this.f726b != null) {
            if (this.f728c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
