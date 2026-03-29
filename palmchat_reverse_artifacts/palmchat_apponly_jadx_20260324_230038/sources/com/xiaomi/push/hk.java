package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hk implements hq<hk, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f771a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f773a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f774a = new BitSet(1);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f775b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f776c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f777d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f778e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f779f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f780g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f770a = new Cif("XmPushActionSubscriptionResult");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11630a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 12, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 10, 6);
    private static final hx f = new hx("", (byte) 11, 7);
    private static final hx g = new hx("", (byte) 11, 8);
    private static final hx h = new hx("", (byte) 11, 9);
    private static final hx i = new hx("", (byte) 11, 10);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m604a() {
        return this.f773a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m606b() {
        return this.f772a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m607c() {
        return this.f775b != null;
    }

    public boolean d() {
        return this.f776c != null;
    }

    public boolean e() {
        return this.f774a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hk)) {
            return m605a((hk) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f777d != null;
    }

    public boolean g() {
        return this.f778e != null;
    }

    public boolean h() {
        return this.f779f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f780g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = false;
        if (m604a()) {
            sb.append("debug:");
            String str = this.f773a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m606b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f772a;
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
        String str2 = this.f775b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f776c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f771a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f777d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f778e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f779f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f780g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public String a() {
        return this.f775b;
    }

    public String b() {
        return this.f778e;
    }

    public String c() {
        return this.f780g;
    }

    public void a(boolean z) {
        this.f774a.set(0, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m603a();
        iaVar.a(f770a);
        if (this.f773a != null && m604a()) {
            iaVar.a(f11630a);
            iaVar.a(this.f773a);
            iaVar.b();
        }
        if (this.f772a != null && m606b()) {
            iaVar.a(b);
            this.f772a.b(iaVar);
            iaVar.b();
        }
        if (this.f775b != null) {
            iaVar.a(c);
            iaVar.a(this.f775b);
            iaVar.b();
        }
        if (this.f776c != null && d()) {
            iaVar.a(d);
            iaVar.a(this.f776c);
            iaVar.b();
        }
        if (e()) {
            iaVar.a(e);
            iaVar.a(this.f771a);
            iaVar.b();
        }
        if (this.f777d != null && f()) {
            iaVar.a(f);
            iaVar.a(this.f777d);
            iaVar.b();
        }
        if (this.f778e != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f778e);
            iaVar.b();
        }
        if (this.f779f != null && h()) {
            iaVar.a(h);
            iaVar.a(this.f779f);
            iaVar.b();
        }
        if (this.f780g != null && i()) {
            iaVar.a(i);
            iaVar.a(this.f780g);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m605a(hk hkVar) {
        if (hkVar == null) {
            return false;
        }
        boolean zM604a = m604a();
        boolean zM604a2 = hkVar.m604a();
        if ((zM604a || zM604a2) && !(zM604a && zM604a2 && this.f773a.equals(hkVar.f773a))) {
            return false;
        }
        boolean zM606b = m606b();
        boolean zM606b2 = hkVar.m606b();
        if ((zM606b || zM606b2) && !(zM606b && zM606b2 && this.f772a.m531a(hkVar.f772a))) {
            return false;
        }
        boolean zM607c = m607c();
        boolean zM607c2 = hkVar.m607c();
        if ((zM607c || zM607c2) && !(zM607c && zM607c2 && this.f775b.equals(hkVar.f775b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hkVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f776c.equals(hkVar.f776c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hkVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f771a == hkVar.f771a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hkVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f777d.equals(hkVar.f777d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hkVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f778e.equals(hkVar.f778e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hkVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f779f.equals(hkVar.f779f))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hkVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f780g.equals(hkVar.f780g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hk hkVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        if (!getClass().equals(hkVar.getClass())) {
            return getClass().getName().compareTo(hkVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m604a()).compareTo(Boolean.valueOf(hkVar.m604a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m604a() && (iA9 = hr.a(this.f773a, hkVar.f773a)) != 0) {
            return iA9;
        }
        int iCompareTo2 = Boolean.valueOf(m606b()).compareTo(Boolean.valueOf(hkVar.m606b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m606b() && (iA8 = hr.a(this.f772a, hkVar.f772a)) != 0) {
            return iA8;
        }
        int iCompareTo3 = Boolean.valueOf(m607c()).compareTo(Boolean.valueOf(hkVar.m607c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m607c() && (iA7 = hr.a(this.f775b, hkVar.f775b)) != 0) {
            return iA7;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hkVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA6 = hr.a(this.f776c, hkVar.f776c)) != 0) {
            return iA6;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hkVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA5 = hr.a(this.f771a, hkVar.f771a)) != 0) {
            return iA5;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hkVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA4 = hr.a(this.f777d, hkVar.f777d)) != 0) {
            return iA4;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hkVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA3 = hr.a(this.f778e, hkVar.f778e)) != 0) {
            return iA3;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hkVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA2 = hr.a(this.f779f, hkVar.f779f)) != 0) {
            return iA2;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hkVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (!i() || (iA = hr.a(this.f780g, hkVar.f780g)) == 0) {
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
                m603a();
                return;
            }
            switch (hxVarMo627a.f836a) {
                case 1:
                    if (b2 == 11) {
                        this.f773a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f772a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f775b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f776c = iaVar.mo632a();
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
                        this.f771a = iaVar.mo626a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f777d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f778e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f779f = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f780g = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m603a() throws ib {
        if (this.f775b != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
