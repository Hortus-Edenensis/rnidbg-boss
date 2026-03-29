package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class gw implements hq<gw, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f614a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f615a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f617a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f618b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f619c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f620d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f621e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f622f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f623g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f612a = new Cif("XmPushActionAckNotification");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11615a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 12, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 11, 5);
    private static final hx f = new hx("", (byte) 10, 7);
    private static final hx g = new hx("", (byte) 11, 8);
    private static final hx h = new hx("", com.umeng.analytics.pro.dn.k, 9);
    private static final hx i = new hx("", (byte) 11, 10);
    private static final hx j = new hx("", (byte) 11, 11);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f616a = new BitSet(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f613a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m536a() {
        return this.f615a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m538b() {
        return this.f614a != null;
    }

    public boolean c() {
        return this.f618b != null;
    }

    public boolean d() {
        return this.f619c != null;
    }

    public boolean e() {
        return this.f620d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gw)) {
            return m537a((gw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f616a.get(0);
    }

    public boolean g() {
        return this.f621e != null;
    }

    public boolean h() {
        return this.f617a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f622f != null;
    }

    public boolean j() {
        return this.f623g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckNotification(");
        boolean z2 = false;
        if (m536a()) {
            sb.append("debug:");
            String str = this.f615a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m538b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f614a;
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
        String str2 = this.f618b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f619c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f620d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("errorCode:");
            sb.append(this.f613a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("reason:");
            String str5 = this.f621e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f617a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f622f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f623g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public gw a(gu guVar) {
        this.f614a = guVar;
        return this;
    }

    public gw b(String str) {
        this.f619c = str;
        return this;
    }

    public gw c(String str) {
        this.f620d = str;
        return this;
    }

    public gw d(String str) {
        this.f621e = str;
        return this;
    }

    public gw e(String str) {
        this.f622f = str;
        return this;
    }

    public String a() {
        return this.f618b;
    }

    public String b() {
        return this.f620d;
    }

    public gw a(String str) {
        this.f618b = str;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m535a();
        iaVar.a(f612a);
        if (this.f615a != null && m536a()) {
            iaVar.a(f11615a);
            iaVar.a(this.f615a);
            iaVar.b();
        }
        if (this.f614a != null && m538b()) {
            iaVar.a(b);
            this.f614a.b(iaVar);
            iaVar.b();
        }
        if (this.f618b != null) {
            iaVar.a(c);
            iaVar.a(this.f618b);
            iaVar.b();
        }
        if (this.f619c != null && d()) {
            iaVar.a(d);
            iaVar.a(this.f619c);
            iaVar.b();
        }
        if (this.f620d != null && e()) {
            iaVar.a(e);
            iaVar.a(this.f620d);
            iaVar.b();
        }
        if (f()) {
            iaVar.a(f);
            iaVar.a(this.f613a);
            iaVar.b();
        }
        if (this.f621e != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f621e);
            iaVar.b();
        }
        if (this.f617a != null && h()) {
            iaVar.a(h);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f617a.size()));
            for (Map.Entry<String, String> entry : this.f617a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (this.f622f != null && i()) {
            iaVar.a(i);
            iaVar.a(this.f622f);
            iaVar.b();
        }
        if (this.f623g != null && j()) {
            iaVar.a(j);
            iaVar.a(this.f623g);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    public gw a(long j2) {
        this.f613a = j2;
        a(true);
        return this;
    }

    public void a(boolean z) {
        this.f616a.set(0, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> m534a() {
        return this.f617a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m537a(gw gwVar) {
        if (gwVar == null) {
            return false;
        }
        boolean zM536a = m536a();
        boolean zM536a2 = gwVar.m536a();
        if ((zM536a || zM536a2) && !(zM536a && zM536a2 && this.f615a.equals(gwVar.f615a))) {
            return false;
        }
        boolean zM538b = m538b();
        boolean zM538b2 = gwVar.m538b();
        if ((zM538b || zM538b2) && !(zM538b && zM538b2 && this.f614a.m531a(gwVar.f614a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = gwVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f618b.equals(gwVar.f618b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = gwVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f619c.equals(gwVar.f619c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = gwVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f620d.equals(gwVar.f620d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gwVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f613a == gwVar.f613a)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = gwVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f621e.equals(gwVar.f621e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gwVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f617a.equals(gwVar.f617a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = gwVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f622f.equals(gwVar.f622f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = gwVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f623g.equals(gwVar.f623g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gw gwVar) {
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
        if (!getClass().equals(gwVar.getClass())) {
            return getClass().getName().compareTo(gwVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m536a()).compareTo(Boolean.valueOf(gwVar.m536a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m536a() && (iA10 = hr.a(this.f615a, gwVar.f615a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(m538b()).compareTo(Boolean.valueOf(gwVar.m538b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m538b() && (iA9 = hr.a(this.f614a, gwVar.f614a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gwVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA8 = hr.a(this.f618b, gwVar.f618b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gwVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = hr.a(this.f619c, gwVar.f619c)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gwVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = hr.a(this.f620d, gwVar.f620d)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gwVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = hr.a(this.f613a, gwVar.f613a)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gwVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = hr.a(this.f621e, gwVar.f621e)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gwVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = hr.a(this.f617a, gwVar.f617a)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gwVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = hr.a(this.f622f, gwVar.f622f)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gwVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = hr.a(this.f623g, gwVar.f623g)) == 0) {
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
                m535a();
                return;
            }
            switch (hxVarMo627a.f836a) {
                case 1:
                    if (b2 == 11) {
                        this.f615a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f614a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f618b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f619c = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f620d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                default:
                    id.a(iaVar, b2);
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f613a = iaVar.mo626a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f621e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 13) {
                        hz hzVarMo629a = iaVar.mo629a();
                        this.f617a = new HashMap(hzVarMo629a.f838a * 2);
                        for (int i2 = 0; i2 < hzVarMo629a.f838a; i2++) {
                            this.f617a.put(iaVar.mo632a(), iaVar.mo632a());
                        }
                        iaVar.h();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f622f = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f623g = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m535a() throws ib {
        if (this.f618b != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
