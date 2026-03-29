package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class gr implements hq<gr, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f546a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gs f547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f549a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f550a = new BitSet(4);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f551a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f552b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f553b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f554c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f555c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f556d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f557e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f558f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f559g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f560h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f561i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public String f562j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public String f563k;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public String f564l;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f545a = new Cif("PushMessage");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11610a = new hx("", (byte) 12, 1);
    private static final hx b = new hx("", (byte) 11, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 10, 5);
    private static final hx f = new hx("", (byte) 10, 6);
    private static final hx g = new hx("", (byte) 11, 7);
    private static final hx h = new hx("", (byte) 11, 8);
    private static final hx i = new hx("", (byte) 11, 9);
    private static final hx j = new hx("", (byte) 11, 10);
    private static final hx k = new hx("", (byte) 11, 11);
    private static final hx l = new hx("", (byte) 12, 12);
    private static final hx m = new hx("", (byte) 11, 13);
    private static final hx n = new hx("", (byte) 2, 14);
    private static final hx o = new hx("", (byte) 11, 15);
    private static final hx p = new hx("", (byte) 10, 16);
    private static final hx q = new hx("", (byte) 11, 20);
    private static final hx r = new hx("", (byte) 11, 21);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m513a() {
        return this.f548a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m515b() {
        return this.f549a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m516c() {
        return this.f553b != null;
    }

    public boolean d() {
        return this.f555c != null;
    }

    public boolean e() {
        return this.f550a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gr)) {
            return m514a((gr) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f550a.get(1);
    }

    public boolean g() {
        return this.f556d != null;
    }

    public boolean h() {
        return this.f557e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f558f != null;
    }

    public boolean j() {
        return this.f559g != null;
    }

    public boolean k() {
        return this.f560h != null;
    }

    public boolean l() {
        return this.f547a != null;
    }

    public boolean m() {
        return this.f561i != null;
    }

    public boolean n() {
        return this.f550a.get(2);
    }

    public boolean o() {
        return this.f562j != null;
    }

    public boolean p() {
        return this.f550a.get(3);
    }

    public boolean q() {
        return this.f563k != null;
    }

    public boolean r() {
        return this.f564l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (m513a()) {
            sb.append("to:");
            gu guVar = this.f548a;
            if (guVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(guVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f549a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f553b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("payload:");
        String str3 = this.f555c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("createAt:");
            sb.append(this.f546a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("ttl:");
            sb.append(this.f552b);
        }
        if (g()) {
            sb.append(", ");
            sb.append("collapseKey:");
            String str4 = this.f556d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f557e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("regId:");
            String str6 = this.f558f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f559g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("topic:");
            String str8 = this.f560h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("metaInfo:");
            gs gsVar = this.f547a;
            if (gsVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(gsVar);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f561i;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("isOnline:");
            sb.append(this.f551a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str10 = this.f562j;
            if (str10 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(", ");
            sb.append("miid:");
            sb.append(this.f554c);
        }
        if (q()) {
            sb.append(", ");
            sb.append("imeiMd5:");
            String str11 = this.f563k;
            if (str11 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str12 = this.f564l;
            if (str12 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str12);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m511a() {
        return this.f549a;
    }

    public String b() {
        return this.f553b;
    }

    public String c() {
        return this.f555c;
    }

    public void d(boolean z) {
        this.f550a.set(3, z);
    }

    public long a() {
        return this.f546a;
    }

    public void b(boolean z) {
        this.f550a.set(1, z);
    }

    public void c(boolean z) {
        this.f550a.set(2, z);
    }

    public void a(boolean z) {
        this.f550a.set(0, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m512a();
        iaVar.a(f545a);
        if (this.f548a != null && m513a()) {
            iaVar.a(f11610a);
            this.f548a.b(iaVar);
            iaVar.b();
        }
        if (this.f549a != null) {
            iaVar.a(b);
            iaVar.a(this.f549a);
            iaVar.b();
        }
        if (this.f553b != null) {
            iaVar.a(c);
            iaVar.a(this.f553b);
            iaVar.b();
        }
        if (this.f555c != null) {
            iaVar.a(d);
            iaVar.a(this.f555c);
            iaVar.b();
        }
        if (e()) {
            iaVar.a(e);
            iaVar.a(this.f546a);
            iaVar.b();
        }
        if (f()) {
            iaVar.a(f);
            iaVar.a(this.f552b);
            iaVar.b();
        }
        if (this.f556d != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f556d);
            iaVar.b();
        }
        if (this.f557e != null && h()) {
            iaVar.a(h);
            iaVar.a(this.f557e);
            iaVar.b();
        }
        if (this.f558f != null && i()) {
            iaVar.a(i);
            iaVar.a(this.f558f);
            iaVar.b();
        }
        if (this.f559g != null && j()) {
            iaVar.a(j);
            iaVar.a(this.f559g);
            iaVar.b();
        }
        if (this.f560h != null && k()) {
            iaVar.a(k);
            iaVar.a(this.f560h);
            iaVar.b();
        }
        if (this.f547a != null && l()) {
            iaVar.a(l);
            this.f547a.b(iaVar);
            iaVar.b();
        }
        if (this.f561i != null && m()) {
            iaVar.a(m);
            iaVar.a(this.f561i);
            iaVar.b();
        }
        if (n()) {
            iaVar.a(n);
            iaVar.a(this.f551a);
            iaVar.b();
        }
        if (this.f562j != null && o()) {
            iaVar.a(o);
            iaVar.a(this.f562j);
            iaVar.b();
        }
        if (p()) {
            iaVar.a(p);
            iaVar.a(this.f554c);
            iaVar.b();
        }
        if (this.f563k != null && q()) {
            iaVar.a(q);
            iaVar.a(this.f563k);
            iaVar.b();
        }
        if (this.f564l != null && r()) {
            iaVar.a(r);
            iaVar.a(this.f564l);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m514a(gr grVar) {
        if (grVar == null) {
            return false;
        }
        boolean zM513a = m513a();
        boolean zM513a2 = grVar.m513a();
        if ((zM513a || zM513a2) && !(zM513a && zM513a2 && this.f548a.m531a(grVar.f548a))) {
            return false;
        }
        boolean zM515b = m515b();
        boolean zM515b2 = grVar.m515b();
        if ((zM515b || zM515b2) && !(zM515b && zM515b2 && this.f549a.equals(grVar.f549a))) {
            return false;
        }
        boolean zM516c = m516c();
        boolean zM516c2 = grVar.m516c();
        if ((zM516c || zM516c2) && !(zM516c && zM516c2 && this.f553b.equals(grVar.f553b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = grVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f555c.equals(grVar.f555c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = grVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f546a == grVar.f546a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = grVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f552b == grVar.f552b)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = grVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f556d.equals(grVar.f556d))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = grVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f557e.equals(grVar.f557e))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = grVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f558f.equals(grVar.f558f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = grVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f559g.equals(grVar.f559g))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = grVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f560h.equals(grVar.f560h))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = grVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f547a.m523a(grVar.f547a))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = grVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f561i.equals(grVar.f561i))) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = grVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f551a == grVar.f551a)) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = grVar.o();
        if ((zO || zO2) && !(zO && zO2 && this.f562j.equals(grVar.f562j))) {
            return false;
        }
        boolean zP = p();
        boolean zP2 = grVar.p();
        if ((zP || zP2) && !(zP && zP2 && this.f554c == grVar.f554c)) {
            return false;
        }
        boolean zQ = q();
        boolean zQ2 = grVar.q();
        if ((zQ || zQ2) && !(zQ && zQ2 && this.f563k.equals(grVar.f563k))) {
            return false;
        }
        boolean zR = r();
        boolean zR2 = grVar.r();
        if (zR || zR2) {
            return zR && zR2 && this.f564l.equals(grVar.f564l);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gr grVar) {
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
        if (!getClass().equals(grVar.getClass())) {
            return getClass().getName().compareTo(grVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m513a()).compareTo(Boolean.valueOf(grVar.m513a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m513a() && (iA18 = hr.a(this.f548a, grVar.f548a)) != 0) {
            return iA18;
        }
        int iCompareTo2 = Boolean.valueOf(m515b()).compareTo(Boolean.valueOf(grVar.m515b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m515b() && (iA17 = hr.a(this.f549a, grVar.f549a)) != 0) {
            return iA17;
        }
        int iCompareTo3 = Boolean.valueOf(m516c()).compareTo(Boolean.valueOf(grVar.m516c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m516c() && (iA16 = hr.a(this.f553b, grVar.f553b)) != 0) {
            return iA16;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(grVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA15 = hr.a(this.f555c, grVar.f555c)) != 0) {
            return iA15;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(grVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA14 = hr.a(this.f546a, grVar.f546a)) != 0) {
            return iA14;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(grVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA13 = hr.a(this.f552b, grVar.f552b)) != 0) {
            return iA13;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(grVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA12 = hr.a(this.f556d, grVar.f556d)) != 0) {
            return iA12;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(grVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA11 = hr.a(this.f557e, grVar.f557e)) != 0) {
            return iA11;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(grVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA10 = hr.a(this.f558f, grVar.f558f)) != 0) {
            return iA10;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(grVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA9 = hr.a(this.f559g, grVar.f559g)) != 0) {
            return iA9;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(grVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA8 = hr.a(this.f560h, grVar.f560h)) != 0) {
            return iA8;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(grVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA7 = hr.a(this.f547a, grVar.f547a)) != 0) {
            return iA7;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(grVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA6 = hr.a(this.f561i, grVar.f561i)) != 0) {
            return iA6;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(grVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA5 = hr.a(this.f551a, grVar.f551a)) != 0) {
            return iA5;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(grVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (o() && (iA4 = hr.a(this.f562j, grVar.f562j)) != 0) {
            return iA4;
        }
        int iCompareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(grVar.p()));
        if (iCompareTo16 != 0) {
            return iCompareTo16;
        }
        if (p() && (iA3 = hr.a(this.f554c, grVar.f554c)) != 0) {
            return iA3;
        }
        int iCompareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(grVar.q()));
        if (iCompareTo17 != 0) {
            return iCompareTo17;
        }
        if (q() && (iA2 = hr.a(this.f563k, grVar.f563k)) != 0) {
            return iA2;
        }
        int iCompareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(grVar.r()));
        if (iCompareTo18 != 0) {
            return iCompareTo18;
        }
        if (!r() || (iA = hr.a(this.f564l, grVar.f564l)) == 0) {
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
                m512a();
                return;
            }
            short s = hxVarMo627a.f836a;
            if (s != 20) {
                if (s != 21) {
                    switch (s) {
                        case 1:
                            if (b2 == 12) {
                                gu guVar = new gu();
                                this.f548a = guVar;
                                guVar.a(iaVar);
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 2:
                            if (b2 == 11) {
                                this.f549a = iaVar.mo632a();
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 3:
                            if (b2 == 11) {
                                this.f553b = iaVar.mo632a();
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 4:
                            if (b2 == 11) {
                                this.f555c = iaVar.mo632a();
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 5:
                            if (b2 == 10) {
                                this.f546a = iaVar.mo626a();
                                a(true);
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 6:
                            if (b2 == 10) {
                                this.f552b = iaVar.mo626a();
                                b(true);
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 7:
                            if (b2 == 11) {
                                this.f556d = iaVar.mo632a();
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 8:
                            if (b2 == 11) {
                                this.f557e = iaVar.mo632a();
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 9:
                            if (b2 == 11) {
                                this.f558f = iaVar.mo632a();
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 10:
                            if (b2 == 11) {
                                this.f559g = iaVar.mo632a();
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 11:
                            if (b2 == 11) {
                                this.f560h = iaVar.mo632a();
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 12:
                            if (b2 == 12) {
                                gs gsVar = new gs();
                                this.f547a = gsVar;
                                gsVar.a(iaVar);
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 13:
                            if (b2 == 11) {
                                this.f561i = iaVar.mo632a();
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 14:
                            if (b2 == 2) {
                                this.f551a = iaVar.mo637a();
                                c(true);
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 15:
                            if (b2 == 11) {
                                this.f562j = iaVar.mo632a();
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        case 16:
                            if (b2 == 10) {
                                this.f554c = iaVar.mo626a();
                                d(true);
                            } else {
                                id.a(iaVar, b2);
                            }
                            break;
                        default:
                            id.a(iaVar, b2);
                            break;
                    }
                } else if (b2 == 11) {
                    this.f564l = iaVar.mo632a();
                } else {
                    id.a(iaVar, b2);
                }
            } else if (b2 == 11) {
                this.f563k = iaVar.mo632a();
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m512a() throws ib {
        if (this.f549a != null) {
            if (this.f553b != null) {
                if (this.f555c != null) {
                    return;
                }
                throw new ib("Required field 'payload' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
