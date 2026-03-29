package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hl implements hq<hl, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f782a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f783a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f784a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f785a = new BitSet(2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f786a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f787b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f788c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f789d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f790e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f791f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f792g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f793h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f794i;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f781a = new Cif("XmPushActionUnRegistration");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11631a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 12, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 11, 5);
    private static final hx f = new hx("", (byte) 11, 6);
    private static final hx g = new hx("", (byte) 11, 7);
    private static final hx h = new hx("", (byte) 11, 8);
    private static final hx i = new hx("", (byte) 11, 9);
    private static final hx j = new hx("", (byte) 11, 10);
    private static final hx k = new hx("", (byte) 2, 11);
    private static final hx l = new hx("", (byte) 10, 12);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m608a() {
        return this.f784a != null;
    }

    public boolean b() {
        return this.f783a != null;
    }

    public boolean c() {
        return this.f787b != null;
    }

    public boolean d() {
        return this.f788c != null;
    }

    public boolean e() {
        return this.f789d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hl)) {
            return m609a((hl) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f790e != null;
    }

    public boolean g() {
        return this.f791f != null;
    }

    public boolean h() {
        return this.f792g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f793h != null;
    }

    public boolean j() {
        return this.f794i != null;
    }

    public boolean k() {
        return this.f785a.get(0);
    }

    public boolean l() {
        return this.f785a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = false;
        if (m608a()) {
            sb.append("debug:");
            String str = this.f784a;
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
            gu guVar = this.f783a;
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
        String str2 = this.f787b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f788c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("regId:");
            String str4 = this.f789d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("appVersion:");
            String str5 = this.f790e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f791f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("token:");
            String str7 = this.f792g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("deviceId:");
            String str8 = this.f793h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f794i;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("needAck:");
            sb.append(this.f786a);
        }
        if (l()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f782a);
        }
        sb.append(")");
        return sb.toString();
    }

    public hl a(String str) {
        this.f787b = str;
        return this;
    }

    public hl b(String str) {
        this.f788c = str;
        return this;
    }

    public hl c(String str) {
        this.f789d = str;
        return this;
    }

    public hl d(String str) {
        this.f791f = str;
        return this;
    }

    public hl e(String str) {
        this.f792g = str;
        return this;
    }

    public void a(boolean z) {
        this.f785a.set(0, z);
    }

    public void b(boolean z) {
        this.f785a.set(1, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m609a(hl hlVar) {
        if (hlVar == null) {
            return false;
        }
        boolean zM608a = m608a();
        boolean zM608a2 = hlVar.m608a();
        if ((zM608a || zM608a2) && !(zM608a && zM608a2 && this.f784a.equals(hlVar.f784a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hlVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f783a.m531a(hlVar.f783a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hlVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f787b.equals(hlVar.f787b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hlVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f788c.equals(hlVar.f788c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hlVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f789d.equals(hlVar.f789d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hlVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f790e.equals(hlVar.f790e))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hlVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f791f.equals(hlVar.f791f))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hlVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f792g.equals(hlVar.f792g))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hlVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f793h.equals(hlVar.f793h))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = hlVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f794i.equals(hlVar.f794i))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = hlVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f786a == hlVar.f786a)) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = hlVar.l();
        if (zL || zL2) {
            return zL && zL2 && this.f782a == hlVar.f782a;
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f781a);
        if (this.f784a != null && m608a()) {
            iaVar.a(f11631a);
            iaVar.a(this.f784a);
            iaVar.b();
        }
        if (this.f783a != null && b()) {
            iaVar.a(b);
            this.f783a.b(iaVar);
            iaVar.b();
        }
        if (this.f787b != null) {
            iaVar.a(c);
            iaVar.a(this.f787b);
            iaVar.b();
        }
        if (this.f788c != null) {
            iaVar.a(d);
            iaVar.a(this.f788c);
            iaVar.b();
        }
        if (this.f789d != null && e()) {
            iaVar.a(e);
            iaVar.a(this.f789d);
            iaVar.b();
        }
        if (this.f790e != null && f()) {
            iaVar.a(f);
            iaVar.a(this.f790e);
            iaVar.b();
        }
        if (this.f791f != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f791f);
            iaVar.b();
        }
        if (this.f792g != null && h()) {
            iaVar.a(h);
            iaVar.a(this.f792g);
            iaVar.b();
        }
        if (this.f793h != null && i()) {
            iaVar.a(i);
            iaVar.a(this.f793h);
            iaVar.b();
        }
        if (this.f794i != null && j()) {
            iaVar.a(j);
            iaVar.a(this.f794i);
            iaVar.b();
        }
        if (k()) {
            iaVar.a(k);
            iaVar.a(this.f786a);
            iaVar.b();
        }
        if (l()) {
            iaVar.a(l);
            iaVar.a(this.f782a);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hl hlVar) {
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
        if (!getClass().equals(hlVar.getClass())) {
            return getClass().getName().compareTo(hlVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m608a()).compareTo(Boolean.valueOf(hlVar.m608a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m608a() && (iA12 = hr.a(this.f784a, hlVar.f784a)) != 0) {
            return iA12;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hlVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA11 = hr.a(this.f783a, hlVar.f783a)) != 0) {
            return iA11;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hlVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA10 = hr.a(this.f787b, hlVar.f787b)) != 0) {
            return iA10;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hlVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA9 = hr.a(this.f788c, hlVar.f788c)) != 0) {
            return iA9;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hlVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA8 = hr.a(this.f789d, hlVar.f789d)) != 0) {
            return iA8;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hlVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA7 = hr.a(this.f790e, hlVar.f790e)) != 0) {
            return iA7;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hlVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA6 = hr.a(this.f791f, hlVar.f791f)) != 0) {
            return iA6;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hlVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA5 = hr.a(this.f792g, hlVar.f792g)) != 0) {
            return iA5;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hlVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA4 = hr.a(this.f793h, hlVar.f793h)) != 0) {
            return iA4;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hlVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA3 = hr.a(this.f794i, hlVar.f794i)) != 0) {
            return iA3;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hlVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA2 = hr.a(this.f786a, hlVar.f786a)) != 0) {
            return iA2;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hlVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (!l() || (iA = hr.a(this.f782a, hlVar.f782a)) == 0) {
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
                        this.f784a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f783a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f787b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f788c = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f789d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f790e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f791f = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f792g = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f793h = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f794i = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f786a = iaVar.mo637a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f782a = iaVar.mo626a();
                        b(true);
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
        if (this.f787b != null) {
            if (this.f788c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
