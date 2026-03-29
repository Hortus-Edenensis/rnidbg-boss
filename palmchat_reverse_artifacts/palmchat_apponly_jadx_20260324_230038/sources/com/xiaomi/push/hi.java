package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hi implements hq<hi, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gr f748a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f749a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f750a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f752a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f754b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f755c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f756d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f757e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f758f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f759g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f760h;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f747a = new Cif("XmPushActionSendMessage");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11628a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 12, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 11, 5);
    private static final hx f = new hx("", (byte) 11, 6);
    private static final hx g = new hx("", (byte) 11, 7);
    private static final hx h = new hx("", (byte) 12, 8);
    private static final hx i = new hx("", (byte) 2, 9);
    private static final hx j = new hx("", com.umeng.analytics.pro.dn.k, 10);
    private static final hx k = new hx("", (byte) 11, 11);
    private static final hx l = new hx("", (byte) 11, 12);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f751a = new BitSet(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f753a = true;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m594a() {
        return this.f750a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m596b() {
        return this.f749a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m597c() {
        return this.f754b != null;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m598d() {
        return this.f755c != null;
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public boolean m599e() {
        return this.f756d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hi)) {
            return m595a((hi) obj);
        }
        return false;
    }

    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    public boolean m600f() {
        return this.f757e != null;
    }

    public boolean g() {
        return this.f758f != null;
    }

    public boolean h() {
        return this.f748a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f751a.get(0);
    }

    public boolean j() {
        return this.f752a != null;
    }

    public boolean k() {
        return this.f759g != null;
    }

    public boolean l() {
        return this.f760h != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = false;
        if (m594a()) {
            sb.append("debug:");
            String str = this.f750a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m596b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f749a;
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
        String str2 = this.f754b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f755c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        if (m599e()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f756d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (m600f()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f757e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str6 = this.f758f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("message:");
            gr grVar = this.f748a;
            if (grVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(grVar);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f753a);
        }
        if (j()) {
            sb.append(", ");
            sb.append("params:");
            Map<String, String> map = this.f752a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f759g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("userAccount:");
            String str8 = this.f760h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str8);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m592a() {
        return this.f754b;
    }

    public String b() {
        return this.f755c;
    }

    public String c() {
        return this.f757e;
    }

    public String d() {
        return this.f758f;
    }

    public String e() {
        return this.f759g;
    }

    public String f() {
        return this.f760h;
    }

    public gr a() {
        return this.f748a;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m593a();
        iaVar.a(f747a);
        if (this.f750a != null && m594a()) {
            iaVar.a(f11628a);
            iaVar.a(this.f750a);
            iaVar.b();
        }
        if (this.f749a != null && m596b()) {
            iaVar.a(b);
            this.f749a.b(iaVar);
            iaVar.b();
        }
        if (this.f754b != null) {
            iaVar.a(c);
            iaVar.a(this.f754b);
            iaVar.b();
        }
        if (this.f755c != null) {
            iaVar.a(d);
            iaVar.a(this.f755c);
            iaVar.b();
        }
        if (this.f756d != null && m599e()) {
            iaVar.a(e);
            iaVar.a(this.f756d);
            iaVar.b();
        }
        if (this.f757e != null && m600f()) {
            iaVar.a(f);
            iaVar.a(this.f757e);
            iaVar.b();
        }
        if (this.f758f != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f758f);
            iaVar.b();
        }
        if (this.f748a != null && h()) {
            iaVar.a(h);
            this.f748a.b(iaVar);
            iaVar.b();
        }
        if (i()) {
            iaVar.a(i);
            iaVar.a(this.f753a);
            iaVar.b();
        }
        if (this.f752a != null && j()) {
            iaVar.a(j);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f752a.size()));
            for (Map.Entry<String, String> entry : this.f752a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (this.f759g != null && k()) {
            iaVar.a(k);
            iaVar.a(this.f759g);
            iaVar.b();
        }
        if (this.f760h != null && l()) {
            iaVar.a(l);
            iaVar.a(this.f760h);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    public void a(boolean z) {
        this.f751a.set(0, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m595a(hi hiVar) {
        if (hiVar == null) {
            return false;
        }
        boolean zM594a = m594a();
        boolean zM594a2 = hiVar.m594a();
        if ((zM594a || zM594a2) && !(zM594a && zM594a2 && this.f750a.equals(hiVar.f750a))) {
            return false;
        }
        boolean zM596b = m596b();
        boolean zM596b2 = hiVar.m596b();
        if ((zM596b || zM596b2) && !(zM596b && zM596b2 && this.f749a.m531a(hiVar.f749a))) {
            return false;
        }
        boolean zM597c = m597c();
        boolean zM597c2 = hiVar.m597c();
        if ((zM597c || zM597c2) && !(zM597c && zM597c2 && this.f754b.equals(hiVar.f754b))) {
            return false;
        }
        boolean zM598d = m598d();
        boolean zM598d2 = hiVar.m598d();
        if ((zM598d || zM598d2) && !(zM598d && zM598d2 && this.f755c.equals(hiVar.f755c))) {
            return false;
        }
        boolean zM599e = m599e();
        boolean zM599e2 = hiVar.m599e();
        if ((zM599e || zM599e2) && !(zM599e && zM599e2 && this.f756d.equals(hiVar.f756d))) {
            return false;
        }
        boolean zM600f = m600f();
        boolean zM600f2 = hiVar.m600f();
        if ((zM600f || zM600f2) && !(zM600f && zM600f2 && this.f757e.equals(hiVar.f757e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hiVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f758f.equals(hiVar.f758f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hiVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f748a.m514a(hiVar.f748a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hiVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f753a == hiVar.f753a)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = hiVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f752a.equals(hiVar.f752a))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = hiVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f759g.equals(hiVar.f759g))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = hiVar.l();
        if (zL || zL2) {
            return zL && zL2 && this.f760h.equals(hiVar.f760h);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hi hiVar) {
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
        if (!getClass().equals(hiVar.getClass())) {
            return getClass().getName().compareTo(hiVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m594a()).compareTo(Boolean.valueOf(hiVar.m594a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m594a() && (iA12 = hr.a(this.f750a, hiVar.f750a)) != 0) {
            return iA12;
        }
        int iCompareTo2 = Boolean.valueOf(m596b()).compareTo(Boolean.valueOf(hiVar.m596b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m596b() && (iA11 = hr.a(this.f749a, hiVar.f749a)) != 0) {
            return iA11;
        }
        int iCompareTo3 = Boolean.valueOf(m597c()).compareTo(Boolean.valueOf(hiVar.m597c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m597c() && (iA10 = hr.a(this.f754b, hiVar.f754b)) != 0) {
            return iA10;
        }
        int iCompareTo4 = Boolean.valueOf(m598d()).compareTo(Boolean.valueOf(hiVar.m598d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m598d() && (iA9 = hr.a(this.f755c, hiVar.f755c)) != 0) {
            return iA9;
        }
        int iCompareTo5 = Boolean.valueOf(m599e()).compareTo(Boolean.valueOf(hiVar.m599e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (m599e() && (iA8 = hr.a(this.f756d, hiVar.f756d)) != 0) {
            return iA8;
        }
        int iCompareTo6 = Boolean.valueOf(m600f()).compareTo(Boolean.valueOf(hiVar.m600f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (m600f() && (iA7 = hr.a(this.f757e, hiVar.f757e)) != 0) {
            return iA7;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hiVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA6 = hr.a(this.f758f, hiVar.f758f)) != 0) {
            return iA6;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hiVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA5 = hr.a(this.f748a, hiVar.f748a)) != 0) {
            return iA5;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hiVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA4 = hr.a(this.f753a, hiVar.f753a)) != 0) {
            return iA4;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hiVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA3 = hr.a(this.f752a, hiVar.f752a)) != 0) {
            return iA3;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hiVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA2 = hr.a(this.f759g, hiVar.f759g)) != 0) {
            return iA2;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hiVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (!l() || (iA = hr.a(this.f760h, hiVar.f760h)) == 0) {
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
                m593a();
                return;
            }
            switch (hxVarMo627a.f836a) {
                case 1:
                    if (b2 == 11) {
                        this.f750a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f749a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f754b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f755c = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f756d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f757e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f758f = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        gr grVar = new gr();
                        this.f748a = grVar;
                        grVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f753a = iaVar.mo637a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        hz hzVarMo629a = iaVar.mo629a();
                        this.f752a = new HashMap(hzVarMo629a.f838a * 2);
                        for (int i2 = 0; i2 < hzVarMo629a.f838a; i2++) {
                            this.f752a.put(iaVar.mo632a(), iaVar.mo632a());
                        }
                        iaVar.h();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f759g = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f760h = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                default:
                    id.a(iaVar, b2);
                    break;
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m593a() throws ib {
        if (this.f754b != null) {
            if (this.f755c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
