package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ej implements hq<ej, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte f367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f368a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f369a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f370a = new BitSet(6);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f371b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f372b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f373c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f374c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f375d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f376d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f377e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f366a = new Cif("StatsEvent");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11539a = new hx("", (byte) 3, 1);
    private static final hx b = new hx("", (byte) 8, 2);
    private static final hx c = new hx("", (byte) 8, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 11, 5);
    private static final hx f = new hx("", (byte) 8, 6);
    private static final hx g = new hx("", (byte) 11, 7);
    private static final hx h = new hx("", (byte) 11, 8);
    private static final hx i = new hx("", (byte) 8, 9);
    private static final hx j = new hx("", (byte) 8, 10);

    public ej a(byte b2) {
        this.f367a = b2;
        a(true);
        return this;
    }

    public boolean b() {
        return this.f370a.get(1);
    }

    public boolean c() {
        return this.f370a.get(2);
    }

    public boolean d() {
        return this.f369a != null;
    }

    public boolean e() {
        return this.f372b != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ej)) {
            return m400a((ej) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f370a.get(3);
    }

    public boolean g() {
        return this.f374c != null;
    }

    public boolean h() {
        return this.f376d != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f370a.get(4);
    }

    public boolean j() {
        return this.f370a.get(5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvent(");
        sb.append("chid:");
        sb.append((int) this.f367a);
        sb.append(", ");
        sb.append("type:");
        sb.append(this.f368a);
        sb.append(", ");
        sb.append("value:");
        sb.append(this.f371b);
        sb.append(", ");
        sb.append("connpt:");
        String str = this.f369a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        if (e()) {
            sb.append(", ");
            sb.append("host:");
            String str2 = this.f372b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str2);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("subvalue:");
            sb.append(this.f373c);
        }
        if (g()) {
            sb.append(", ");
            sb.append("annotation:");
            String str3 = this.f374c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str3);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("user:");
            String str4 = this.f376d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("time:");
            sb.append(this.f375d);
        }
        if (j()) {
            sb.append(", ");
            sb.append("clientIp:");
            sb.append(this.f377e);
        }
        sb.append(")");
        return sb.toString();
    }

    public void b(boolean z) {
        this.f370a.set(1, z);
    }

    public void c(boolean z) {
        this.f370a.set(2, z);
    }

    public void d(boolean z) {
        this.f370a.set(3, z);
    }

    public void e(boolean z) {
        this.f370a.set(4, z);
    }

    public void f(boolean z) {
        this.f370a.set(5, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m399a() {
        return this.f370a.get(0);
    }

    public ej b(int i2) {
        this.f371b = i2;
        c(true);
        return this;
    }

    public ej c(int i2) {
        this.f373c = i2;
        d(true);
        return this;
    }

    public ej d(String str) {
        this.f376d = str;
        return this;
    }

    public void a(boolean z) {
        this.f370a.set(0, z);
    }

    public ej d(int i2) {
        this.f375d = i2;
        e(true);
        return this;
    }

    public ej a(int i2) {
        this.f368a = i2;
        b(true);
        return this;
    }

    public ej b(String str) {
        this.f372b = str;
        return this;
    }

    public ej c(String str) {
        this.f374c = str;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f366a);
        iaVar.a(f11539a);
        iaVar.a(this.f367a);
        iaVar.b();
        iaVar.a(b);
        iaVar.mo636a(this.f368a);
        iaVar.b();
        iaVar.a(c);
        iaVar.mo636a(this.f371b);
        iaVar.b();
        if (this.f369a != null) {
            iaVar.a(d);
            iaVar.a(this.f369a);
            iaVar.b();
        }
        if (this.f372b != null && e()) {
            iaVar.a(e);
            iaVar.a(this.f372b);
            iaVar.b();
        }
        if (f()) {
            iaVar.a(f);
            iaVar.mo636a(this.f373c);
            iaVar.b();
        }
        if (this.f374c != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f374c);
            iaVar.b();
        }
        if (this.f376d != null && h()) {
            iaVar.a(h);
            iaVar.a(this.f376d);
            iaVar.b();
        }
        if (i()) {
            iaVar.a(i);
            iaVar.mo636a(this.f375d);
            iaVar.b();
        }
        if (j()) {
            iaVar.a(j);
            iaVar.mo636a(this.f377e);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    public ej a(String str) {
        this.f369a = str;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m400a(ej ejVar) {
        if (ejVar == null || this.f367a != ejVar.f367a || this.f368a != ejVar.f368a || this.f371b != ejVar.f371b) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = ejVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f369a.equals(ejVar.f369a))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = ejVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f372b.equals(ejVar.f372b))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = ejVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f373c == ejVar.f373c)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = ejVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f374c.equals(ejVar.f374c))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = ejVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f376d.equals(ejVar.f376d))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = ejVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f375d == ejVar.f375d)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = ejVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f377e == ejVar.f377e;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ej ejVar) {
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
        if (!getClass().equals(ejVar.getClass())) {
            return getClass().getName().compareTo(ejVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m399a()).compareTo(Boolean.valueOf(ejVar.m399a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m399a() && (iA10 = hr.a(this.f367a, ejVar.f367a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ejVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA9 = hr.a(this.f368a, ejVar.f368a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ejVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA8 = hr.a(this.f371b, ejVar.f371b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ejVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = hr.a(this.f369a, ejVar.f369a)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ejVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = hr.a(this.f372b, ejVar.f372b)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ejVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = hr.a(this.f373c, ejVar.f373c)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ejVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = hr.a(this.f374c, ejVar.f374c)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ejVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = hr.a(this.f376d, ejVar.f376d)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ejVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = hr.a(this.f375d, ejVar.f375d)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ejVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = hr.a(this.f377e, ejVar.f377e)) == 0) {
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
                if (m399a()) {
                    if (b()) {
                        if (c()) {
                            a();
                            return;
                        }
                        throw new ib("Required field 'value' was not found in serialized data! Struct: " + toString());
                    }
                    throw new ib("Required field 'type' was not found in serialized data! Struct: " + toString());
                }
                throw new ib("Required field 'chid' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo627a.f836a) {
                case 1:
                    if (b2 == 3) {
                        this.f367a = iaVar.a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f368a = iaVar.mo625a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 8) {
                        this.f371b = iaVar.mo625a();
                        c(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f369a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f372b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f373c = iaVar.mo625a();
                        d(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f374c = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f376d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f375d = iaVar.mo625a();
                        e(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 8) {
                        this.f377e = iaVar.mo625a();
                        f(true);
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
        if (this.f369a != null) {
            return;
        }
        throw new ib("Required field 'connpt' was not present! Struct: " + toString());
    }
}
