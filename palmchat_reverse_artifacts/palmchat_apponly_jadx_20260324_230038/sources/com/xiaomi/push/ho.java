package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ho implements hq<ho, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f816a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f817a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f818a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f819a = new BitSet(1);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f820b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f821c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f822d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f823e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f824f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f825g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f815a = new Cif("XmPushActionUnSubscriptionResult");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11634a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 12, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 10, 6);
    private static final hx f = new hx("", (byte) 11, 7);
    private static final hx g = new hx("", (byte) 11, 8);
    private static final hx h = new hx("", (byte) 11, 9);
    private static final hx i = new hx("", (byte) 11, 10);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m616a() {
        return this.f818a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m618b() {
        return this.f817a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m619c() {
        return this.f820b != null;
    }

    public boolean d() {
        return this.f821c != null;
    }

    public boolean e() {
        return this.f819a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ho)) {
            return m617a((ho) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f822d != null;
    }

    public boolean g() {
        return this.f823e != null;
    }

    public boolean h() {
        return this.f824f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f825g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscriptionResult(");
        boolean z2 = false;
        if (m616a()) {
            sb.append("debug:");
            String str = this.f818a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m618b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f817a;
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
        String str2 = this.f820b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f821c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f816a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f822d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("topic:");
            String str5 = this.f823e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f824f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f825g;
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
        return this.f820b;
    }

    public String b() {
        return this.f823e;
    }

    public String c() {
        return this.f825g;
    }

    public void a(boolean z) {
        this.f819a.set(0, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m615a();
        iaVar.a(f815a);
        if (this.f818a != null && m616a()) {
            iaVar.a(f11634a);
            iaVar.a(this.f818a);
            iaVar.b();
        }
        if (this.f817a != null && m618b()) {
            iaVar.a(b);
            this.f817a.b(iaVar);
            iaVar.b();
        }
        if (this.f820b != null) {
            iaVar.a(c);
            iaVar.a(this.f820b);
            iaVar.b();
        }
        if (this.f821c != null && d()) {
            iaVar.a(d);
            iaVar.a(this.f821c);
            iaVar.b();
        }
        if (e()) {
            iaVar.a(e);
            iaVar.a(this.f816a);
            iaVar.b();
        }
        if (this.f822d != null && f()) {
            iaVar.a(f);
            iaVar.a(this.f822d);
            iaVar.b();
        }
        if (this.f823e != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f823e);
            iaVar.b();
        }
        if (this.f824f != null && h()) {
            iaVar.a(h);
            iaVar.a(this.f824f);
            iaVar.b();
        }
        if (this.f825g != null && i()) {
            iaVar.a(i);
            iaVar.a(this.f825g);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m617a(ho hoVar) {
        if (hoVar == null) {
            return false;
        }
        boolean zM616a = m616a();
        boolean zM616a2 = hoVar.m616a();
        if ((zM616a || zM616a2) && !(zM616a && zM616a2 && this.f818a.equals(hoVar.f818a))) {
            return false;
        }
        boolean zM618b = m618b();
        boolean zM618b2 = hoVar.m618b();
        if ((zM618b || zM618b2) && !(zM618b && zM618b2 && this.f817a.m531a(hoVar.f817a))) {
            return false;
        }
        boolean zM619c = m619c();
        boolean zM619c2 = hoVar.m619c();
        if ((zM619c || zM619c2) && !(zM619c && zM619c2 && this.f820b.equals(hoVar.f820b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hoVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f821c.equals(hoVar.f821c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hoVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f816a == hoVar.f816a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hoVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f822d.equals(hoVar.f822d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hoVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f823e.equals(hoVar.f823e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hoVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f824f.equals(hoVar.f824f))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hoVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f825g.equals(hoVar.f825g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ho hoVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        if (!getClass().equals(hoVar.getClass())) {
            return getClass().getName().compareTo(hoVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m616a()).compareTo(Boolean.valueOf(hoVar.m616a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m616a() && (iA9 = hr.a(this.f818a, hoVar.f818a)) != 0) {
            return iA9;
        }
        int iCompareTo2 = Boolean.valueOf(m618b()).compareTo(Boolean.valueOf(hoVar.m618b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m618b() && (iA8 = hr.a(this.f817a, hoVar.f817a)) != 0) {
            return iA8;
        }
        int iCompareTo3 = Boolean.valueOf(m619c()).compareTo(Boolean.valueOf(hoVar.m619c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m619c() && (iA7 = hr.a(this.f820b, hoVar.f820b)) != 0) {
            return iA7;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hoVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA6 = hr.a(this.f821c, hoVar.f821c)) != 0) {
            return iA6;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hoVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA5 = hr.a(this.f816a, hoVar.f816a)) != 0) {
            return iA5;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hoVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA4 = hr.a(this.f822d, hoVar.f822d)) != 0) {
            return iA4;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hoVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA3 = hr.a(this.f823e, hoVar.f823e)) != 0) {
            return iA3;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hoVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA2 = hr.a(this.f824f, hoVar.f824f)) != 0) {
            return iA2;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hoVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (!i() || (iA = hr.a(this.f825g, hoVar.f825g)) == 0) {
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
                m615a();
                return;
            }
            switch (hxVarMo627a.f836a) {
                case 1:
                    if (b2 == 11) {
                        this.f818a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f817a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f820b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f821c = iaVar.mo632a();
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
                        this.f816a = iaVar.mo626a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f822d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f823e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f824f = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f825g = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m615a() throws ib {
        if (this.f820b != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
