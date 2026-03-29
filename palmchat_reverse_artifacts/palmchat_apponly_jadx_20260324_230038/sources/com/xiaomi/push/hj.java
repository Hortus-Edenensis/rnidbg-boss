package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hj implements hq<hj, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f762a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f763a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f764a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f765b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f766c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f767d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f768e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f769f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f761a = new Cif("XmPushActionSubscription");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11629a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 12, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 11, 5);
    private static final hx f = new hx("", (byte) 11, 6);
    private static final hx g = new hx("", (byte) 11, 7);
    private static final hx h = new hx("", (byte) 15, 8);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m601a() {
        return this.f763a != null;
    }

    public boolean b() {
        return this.f762a != null;
    }

    public boolean c() {
        return this.f765b != null;
    }

    public boolean d() {
        return this.f766c != null;
    }

    public boolean e() {
        return this.f767d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hj)) {
            return m602a((hj) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f768e != null;
    }

    public boolean g() {
        return this.f769f != null;
    }

    public boolean h() {
        return this.f764a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = false;
        if (m601a()) {
            sb.append("debug:");
            String str = this.f763a;
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
            gu guVar = this.f762a;
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
        String str2 = this.f765b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f766c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f767d;
        if (str4 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f768e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f769f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f764a;
            if (list == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public hj a(String str) {
        this.f765b = str;
        return this;
    }

    public hj b(String str) {
        this.f766c = str;
        return this;
    }

    public hj c(String str) {
        this.f767d = str;
        return this;
    }

    public hj d(String str) {
        this.f768e = str;
        return this;
    }

    public hj e(String str) {
        this.f769f = str;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m602a(hj hjVar) {
        if (hjVar == null) {
            return false;
        }
        boolean zM601a = m601a();
        boolean zM601a2 = hjVar.m601a();
        if ((zM601a || zM601a2) && !(zM601a && zM601a2 && this.f763a.equals(hjVar.f763a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hjVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f762a.m531a(hjVar.f762a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hjVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f765b.equals(hjVar.f765b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hjVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f766c.equals(hjVar.f766c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hjVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f767d.equals(hjVar.f767d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hjVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f768e.equals(hjVar.f768e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hjVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f769f.equals(hjVar.f769f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hjVar.h();
        if (zH || zH2) {
            return zH && zH2 && this.f764a.equals(hjVar.f764a);
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f761a);
        if (this.f763a != null && m601a()) {
            iaVar.a(f11629a);
            iaVar.a(this.f763a);
            iaVar.b();
        }
        if (this.f762a != null && b()) {
            iaVar.a(b);
            this.f762a.b(iaVar);
            iaVar.b();
        }
        if (this.f765b != null) {
            iaVar.a(c);
            iaVar.a(this.f765b);
            iaVar.b();
        }
        if (this.f766c != null) {
            iaVar.a(d);
            iaVar.a(this.f766c);
            iaVar.b();
        }
        if (this.f767d != null) {
            iaVar.a(e);
            iaVar.a(this.f767d);
            iaVar.b();
        }
        if (this.f768e != null && f()) {
            iaVar.a(f);
            iaVar.a(this.f768e);
            iaVar.b();
        }
        if (this.f769f != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f769f);
            iaVar.b();
        }
        if (this.f764a != null && h()) {
            iaVar.a(h);
            iaVar.a(new hy((byte) 11, this.f764a.size()));
            Iterator<String> it = this.f764a.iterator();
            while (it.hasNext()) {
                iaVar.a(it.next());
            }
            iaVar.e();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hj hjVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (!getClass().equals(hjVar.getClass())) {
            return getClass().getName().compareTo(hjVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m601a()).compareTo(Boolean.valueOf(hjVar.m601a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m601a() && (iA8 = hr.a(this.f763a, hjVar.f763a)) != 0) {
            return iA8;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hjVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA7 = hr.a(this.f762a, hjVar.f762a)) != 0) {
            return iA7;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hjVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA6 = hr.a(this.f765b, hjVar.f765b)) != 0) {
            return iA6;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hjVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA5 = hr.a(this.f766c, hjVar.f766c)) != 0) {
            return iA5;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hjVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA4 = hr.a(this.f767d, hjVar.f767d)) != 0) {
            return iA4;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hjVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA3 = hr.a(this.f768e, hjVar.f768e)) != 0) {
            return iA3;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hjVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA2 = hr.a(this.f769f, hjVar.f769f)) != 0) {
            return iA2;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hjVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (!h() || (iA = hr.a(this.f764a, hjVar.f764a)) == 0) {
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
                a();
                return;
            }
            switch (hxVarMo627a.f836a) {
                case 1:
                    if (b2 == 11) {
                        this.f763a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f762a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f765b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f766c = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f767d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f768e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f769f = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        hy hyVarMo628a = iaVar.mo628a();
                        this.f764a = new ArrayList(hyVarMo628a.f837a);
                        for (int i = 0; i < hyVarMo628a.f837a; i++) {
                            this.f764a.add(iaVar.mo632a());
                        }
                        iaVar.i();
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

    public void a() throws ib {
        if (this.f765b != null) {
            if (this.f766c != null) {
                if (this.f767d != null) {
                    return;
                }
                throw new ib("Required field 'topic' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
