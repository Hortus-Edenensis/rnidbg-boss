package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hn implements hq<hn, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f807a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f808a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f809a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f810b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f811c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f812d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f813e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f814f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f806a = new Cif("XmPushActionUnSubscription");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11633a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 12, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 11, 5);
    private static final hx f = new hx("", (byte) 11, 6);
    private static final hx g = new hx("", (byte) 11, 7);
    private static final hx h = new hx("", (byte) 15, 8);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m613a() {
        return this.f808a != null;
    }

    public boolean b() {
        return this.f807a != null;
    }

    public boolean c() {
        return this.f810b != null;
    }

    public boolean d() {
        return this.f811c != null;
    }

    public boolean e() {
        return this.f812d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hn)) {
            return m614a((hn) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f813e != null;
    }

    public boolean g() {
        return this.f814f != null;
    }

    public boolean h() {
        return this.f809a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = false;
        if (m613a()) {
            sb.append("debug:");
            String str = this.f808a;
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
            gu guVar = this.f807a;
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
        String str2 = this.f810b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f811c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("topic:");
        String str4 = this.f812d;
        if (str4 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f813e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f814f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("aliases:");
            List<String> list = this.f809a;
            if (list == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(list);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public hn a(String str) {
        this.f810b = str;
        return this;
    }

    public hn b(String str) {
        this.f811c = str;
        return this;
    }

    public hn c(String str) {
        this.f812d = str;
        return this;
    }

    public hn d(String str) {
        this.f813e = str;
        return this;
    }

    public hn e(String str) {
        this.f814f = str;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m614a(hn hnVar) {
        if (hnVar == null) {
            return false;
        }
        boolean zM613a = m613a();
        boolean zM613a2 = hnVar.m613a();
        if ((zM613a || zM613a2) && !(zM613a && zM613a2 && this.f808a.equals(hnVar.f808a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hnVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f807a.m531a(hnVar.f807a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hnVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f810b.equals(hnVar.f810b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hnVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f811c.equals(hnVar.f811c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hnVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f812d.equals(hnVar.f812d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hnVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f813e.equals(hnVar.f813e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hnVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f814f.equals(hnVar.f814f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hnVar.h();
        if (zH || zH2) {
            return zH && zH2 && this.f809a.equals(hnVar.f809a);
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f806a);
        if (this.f808a != null && m613a()) {
            iaVar.a(f11633a);
            iaVar.a(this.f808a);
            iaVar.b();
        }
        if (this.f807a != null && b()) {
            iaVar.a(b);
            this.f807a.b(iaVar);
            iaVar.b();
        }
        if (this.f810b != null) {
            iaVar.a(c);
            iaVar.a(this.f810b);
            iaVar.b();
        }
        if (this.f811c != null) {
            iaVar.a(d);
            iaVar.a(this.f811c);
            iaVar.b();
        }
        if (this.f812d != null) {
            iaVar.a(e);
            iaVar.a(this.f812d);
            iaVar.b();
        }
        if (this.f813e != null && f()) {
            iaVar.a(f);
            iaVar.a(this.f813e);
            iaVar.b();
        }
        if (this.f814f != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f814f);
            iaVar.b();
        }
        if (this.f809a != null && h()) {
            iaVar.a(h);
            iaVar.a(new hy((byte) 11, this.f809a.size()));
            Iterator<String> it = this.f809a.iterator();
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
    public int compareTo(hn hnVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (!getClass().equals(hnVar.getClass())) {
            return getClass().getName().compareTo(hnVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m613a()).compareTo(Boolean.valueOf(hnVar.m613a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m613a() && (iA8 = hr.a(this.f808a, hnVar.f808a)) != 0) {
            return iA8;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hnVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA7 = hr.a(this.f807a, hnVar.f807a)) != 0) {
            return iA7;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hnVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA6 = hr.a(this.f810b, hnVar.f810b)) != 0) {
            return iA6;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hnVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA5 = hr.a(this.f811c, hnVar.f811c)) != 0) {
            return iA5;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hnVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA4 = hr.a(this.f812d, hnVar.f812d)) != 0) {
            return iA4;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hnVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA3 = hr.a(this.f813e, hnVar.f813e)) != 0) {
            return iA3;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hnVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA2 = hr.a(this.f814f, hnVar.f814f)) != 0) {
            return iA2;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hnVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (!h() || (iA = hr.a(this.f809a, hnVar.f809a)) == 0) {
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
                        this.f808a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f807a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f810b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f811c = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f812d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f813e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f814f = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        hy hyVarMo628a = iaVar.mo628a();
                        this.f809a = new ArrayList(hyVarMo628a.f837a);
                        for (int i = 0; i < hyVarMo628a.f837a; i++) {
                            this.f809a.add(iaVar.mo632a());
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
        if (this.f810b != null) {
            if (this.f811c != null) {
                if (this.f812d != null) {
                    return;
                }
                throw new ib("Required field 'topic' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
