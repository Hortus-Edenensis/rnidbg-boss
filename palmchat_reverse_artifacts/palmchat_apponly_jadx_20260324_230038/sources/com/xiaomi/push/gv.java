package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class gv implements hq<gv, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f591a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f592a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f593a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hi f594a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f595a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f597a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public short f598a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f600b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public short f601b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f602c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f603d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f604e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f605f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f606g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f607h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f608i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public String f609j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public String f610k;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public String f611l;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f590a = new Cif("XmPushActionAckMessage");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11614a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 12, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 10, 5);
    private static final hx f = new hx("", (byte) 11, 6);
    private static final hx g = new hx("", (byte) 11, 7);
    private static final hx h = new hx("", (byte) 12, 8);
    private static final hx i = new hx("", (byte) 11, 9);
    private static final hx j = new hx("", (byte) 11, 10);
    private static final hx k = new hx("", (byte) 2, 11);
    private static final hx l = new hx("", (byte) 11, 12);
    private static final hx m = new hx("", (byte) 11, 13);
    private static final hx n = new hx("", (byte) 11, 14);
    private static final hx o = new hx("", (byte) 6, 15);
    private static final hx p = new hx("", (byte) 6, 16);
    private static final hx q = new hx("", (byte) 11, 20);
    private static final hx r = new hx("", (byte) 11, 21);
    private static final hx s = new hx("", (byte) 8, 22);
    private static final hx t = new hx("", com.umeng.analytics.pro.dn.k, 23);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f596a = new BitSet(5);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f599a = false;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m532a() {
        return this.f595a != null;
    }

    public boolean b() {
        return this.f593a != null;
    }

    public boolean c() {
        return this.f600b != null;
    }

    public boolean d() {
        return this.f602c != null;
    }

    public boolean e() {
        return this.f596a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gv)) {
            return m533a((gv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f603d != null;
    }

    public boolean g() {
        return this.f604e != null;
    }

    public boolean h() {
        return this.f594a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f605f != null;
    }

    public boolean j() {
        return this.f606g != null;
    }

    public boolean k() {
        return this.f596a.get(1);
    }

    public boolean l() {
        return this.f607h != null;
    }

    public boolean m() {
        return this.f608i != null;
    }

    public boolean n() {
        return this.f609j != null;
    }

    public boolean o() {
        return this.f596a.get(2);
    }

    public boolean p() {
        return this.f596a.get(3);
    }

    public boolean q() {
        return this.f610k != null;
    }

    public boolean r() {
        return this.f611l != null;
    }

    public boolean s() {
        return this.f596a.get(4);
    }

    public boolean t() {
        return this.f597a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = false;
        if (m532a()) {
            sb.append("debug:");
            String str = this.f595a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f593a;
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
        String str2 = this.f600b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f602c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f592a);
        if (f()) {
            sb.append(", ");
            sb.append("topic:");
            String str4 = this.f603d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str5 = this.f604e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("request:");
            hi hiVar = this.f594a;
            if (hiVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(hiVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f605f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f606g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f599a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f607h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("callbackUrl:");
            String str9 = this.f608i;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f609j;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(", ");
            sb.append("deviceStatus:");
            sb.append((int) this.f598a);
        }
        if (p()) {
            sb.append(", ");
            sb.append("geoMsgStatus:");
            sb.append((int) this.f601b);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f610k;
            if (str11 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f611l;
            if (str12 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f591a);
        }
        if (t()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f597a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public gv a(String str) {
        this.f600b = str;
        return this;
    }

    public gv b(String str) {
        this.f602c = str;
        return this;
    }

    public gv c(String str) {
        this.f603d = str;
        return this;
    }

    public gv d(String str) {
        this.f604e = str;
        return this;
    }

    public void e(boolean z) {
        this.f596a.set(4, z);
    }

    public gv a(long j2) {
        this.f592a = j2;
        a(true);
        return this;
    }

    public void b(boolean z) {
        this.f596a.set(1, z);
    }

    public void c(boolean z) {
        this.f596a.set(2, z);
    }

    public void d(boolean z) {
        this.f596a.set(3, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f590a);
        if (this.f595a != null && m532a()) {
            iaVar.a(f11614a);
            iaVar.a(this.f595a);
            iaVar.b();
        }
        if (this.f593a != null && b()) {
            iaVar.a(b);
            this.f593a.b(iaVar);
            iaVar.b();
        }
        if (this.f600b != null) {
            iaVar.a(c);
            iaVar.a(this.f600b);
            iaVar.b();
        }
        if (this.f602c != null) {
            iaVar.a(d);
            iaVar.a(this.f602c);
            iaVar.b();
        }
        iaVar.a(e);
        iaVar.a(this.f592a);
        iaVar.b();
        if (this.f603d != null && f()) {
            iaVar.a(f);
            iaVar.a(this.f603d);
            iaVar.b();
        }
        if (this.f604e != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f604e);
            iaVar.b();
        }
        if (this.f594a != null && h()) {
            iaVar.a(h);
            this.f594a.b(iaVar);
            iaVar.b();
        }
        if (this.f605f != null && i()) {
            iaVar.a(i);
            iaVar.a(this.f605f);
            iaVar.b();
        }
        if (this.f606g != null && j()) {
            iaVar.a(j);
            iaVar.a(this.f606g);
            iaVar.b();
        }
        if (k()) {
            iaVar.a(k);
            iaVar.a(this.f599a);
            iaVar.b();
        }
        if (this.f607h != null && l()) {
            iaVar.a(l);
            iaVar.a(this.f607h);
            iaVar.b();
        }
        if (this.f608i != null && m()) {
            iaVar.a(m);
            iaVar.a(this.f608i);
            iaVar.b();
        }
        if (this.f609j != null && n()) {
            iaVar.a(n);
            iaVar.a(this.f609j);
            iaVar.b();
        }
        if (o()) {
            iaVar.a(o);
            iaVar.a(this.f598a);
            iaVar.b();
        }
        if (p()) {
            iaVar.a(p);
            iaVar.a(this.f601b);
            iaVar.b();
        }
        if (this.f610k != null && q()) {
            iaVar.a(q);
            iaVar.a(this.f610k);
            iaVar.b();
        }
        if (this.f611l != null && r()) {
            iaVar.a(r);
            iaVar.a(this.f611l);
            iaVar.b();
        }
        if (s()) {
            iaVar.a(s);
            iaVar.mo636a(this.f591a);
            iaVar.b();
        }
        if (this.f597a != null && t()) {
            iaVar.a(t);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f597a.size()));
            for (Map.Entry<String, String> entry : this.f597a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    public void a(boolean z) {
        this.f596a.set(0, z);
    }

    public gv a(short s2) {
        this.f598a = s2;
        c(true);
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m533a(gv gvVar) {
        if (gvVar == null) {
            return false;
        }
        boolean zM532a = m532a();
        boolean zM532a2 = gvVar.m532a();
        if ((zM532a || zM532a2) && !(zM532a && zM532a2 && this.f595a.equals(gvVar.f595a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = gvVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f593a.m531a(gvVar.f593a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = gvVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f600b.equals(gvVar.f600b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = gvVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f602c.equals(gvVar.f602c))) || this.f592a != gvVar.f592a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gvVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f603d.equals(gvVar.f603d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = gvVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f604e.equals(gvVar.f604e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gvVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f594a.m595a(gvVar.f594a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = gvVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f605f.equals(gvVar.f605f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = gvVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f606g.equals(gvVar.f606g))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = gvVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f599a == gvVar.f599a)) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = gvVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f607h.equals(gvVar.f607h))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = gvVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f608i.equals(gvVar.f608i))) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = gvVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f609j.equals(gvVar.f609j))) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = gvVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f598a == gvVar.f598a)) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = gvVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f601b == gvVar.f601b)) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = gvVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f610k.equals(gvVar.f610k))) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = gvVar.r();
        if ((zR || zR2) && !(zR && zR2 && this.f611l.equals(gvVar.f611l))) {
            return false;
        }
        boolean zS = s();
        boolean zS2 = gvVar.s();
        if ((zS || zS2) && !(zS && zS2 && this.f591a == gvVar.f591a)) {
            return false;
        }
        boolean zT = t();
        boolean zT2 = gvVar.t();
        if (zT || zT2) {
            return zT && zT2 && this.f597a.equals(gvVar.f597a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gv gvVar) {
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
        if (!getClass().equals(gvVar.getClass())) {
            return getClass().getName().compareTo(gvVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m532a()).compareTo(Boolean.valueOf(gvVar.m532a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m532a() && (iA20 = hr.a(this.f595a, gvVar.f595a)) != 0) {
            return iA20;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gvVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA19 = hr.a(this.f593a, gvVar.f593a)) != 0) {
            return iA19;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gvVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA18 = hr.a(this.f600b, gvVar.f600b)) != 0) {
            return iA18;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gvVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA17 = hr.a(this.f602c, gvVar.f602c)) != 0) {
            return iA17;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gvVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA16 = hr.a(this.f592a, gvVar.f592a)) != 0) {
            return iA16;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gvVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA15 = hr.a(this.f603d, gvVar.f603d)) != 0) {
            return iA15;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gvVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA14 = hr.a(this.f604e, gvVar.f604e)) != 0) {
            return iA14;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gvVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA13 = hr.a(this.f594a, gvVar.f594a)) != 0) {
            return iA13;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gvVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA12 = hr.a(this.f605f, gvVar.f605f)) != 0) {
            return iA12;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gvVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA11 = hr.a(this.f606g, gvVar.f606g)) != 0) {
            return iA11;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gvVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA10 = hr.a(this.f599a, gvVar.f599a)) != 0) {
            return iA10;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(gvVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA9 = hr.a(this.f607h, gvVar.f607h)) != 0) {
            return iA9;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gvVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA8 = hr.a(this.f608i, gvVar.f608i)) != 0) {
            return iA8;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gvVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA7 = hr.a(this.f609j, gvVar.f609j)) != 0) {
            return iA7;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(gvVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA6 = hr.a(this.f598a, gvVar.f598a)) != 0) {
            return iA6;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(gvVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA5 = hr.a(this.f601b, gvVar.f601b)) != 0) {
            return iA5;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(gvVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA4 = hr.a(this.f610k, gvVar.f610k)) != 0) {
            return iA4;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(gvVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (r() && (iA3 = hr.a(this.f611l, gvVar.f611l)) != 0) {
            return iA3;
        }
        int iCompareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(gvVar.s()));
        if (iCompareTo19 != 0) {
            return iCompareTo19;
        }
        if (s() && (iA2 = hr.a(this.f591a, gvVar.f591a)) != 0) {
            return iA2;
        }
        int iCompareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(gvVar.t()));
        if (iCompareTo20 != 0) {
            return iCompareTo20;
        }
        if (!t() || (iA = hr.a(this.f597a, gvVar.f597a)) == 0) {
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
                    a();
                    return;
                }
                throw new ib("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo627a.f836a) {
                case 1:
                    if (b2 == 11) {
                        this.f595a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f593a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f600b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f602c = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f592a = iaVar.mo626a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f603d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f604e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hi hiVar = new hi();
                        this.f594a = hiVar;
                        hiVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f605f = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f606g = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f599a = iaVar.mo637a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f607h = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f608i = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f609j = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 15:
                    if (b2 == 6) {
                        this.f598a = iaVar.mo634a();
                        c(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 16:
                    if (b2 == 6) {
                        this.f601b = iaVar.mo634a();
                        d(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 17:
                case 18:
                case 19:
                default:
                    id.a(iaVar, b2);
                    break;
                case 20:
                    if (b2 == 11) {
                        this.f610k = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 21:
                    if (b2 == 11) {
                        this.f611l = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 22:
                    if (b2 == 8) {
                        this.f591a = iaVar.mo625a();
                        e(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 23:
                    if (b2 == 13) {
                        hz hzVarMo629a = iaVar.mo629a();
                        this.f597a = new HashMap(hzVarMo629a.f838a * 2);
                        for (int i2 = 0; i2 < hzVarMo629a.f838a; i2++) {
                            this.f597a.put(iaVar.mo632a(), iaVar.mo632a());
                        }
                        iaVar.h();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
            }
            iaVar.g();
        }
    }

    public void a() throws ib {
        if (this.f600b != null) {
            if (this.f602c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
