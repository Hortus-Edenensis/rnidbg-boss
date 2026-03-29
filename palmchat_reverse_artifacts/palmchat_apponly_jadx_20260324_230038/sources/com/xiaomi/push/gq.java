package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class gq implements hq<gq, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f539a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f540a = new BitSet(6);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f541a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f542b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f543b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f544c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f536a = new Cif("OnlineConfigItem");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11609a = new hx("", (byte) 8, 1);
    private static final hx b = new hx("", (byte) 8, 2);
    private static final hx c = new hx("", (byte) 2, 3);
    private static final hx d = new hx("", (byte) 8, 4);
    private static final hx e = new hx("", (byte) 10, 5);
    private static final hx f = new hx("", (byte) 11, 6);
    private static final hx g = new hx("", (byte) 2, 7);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m506a() {
    }

    public int b() {
        return this.f542b;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m510c() {
        return this.f540a.get(2);
    }

    public boolean d() {
        return this.f540a.get(3);
    }

    public boolean e() {
        return this.f540a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gq)) {
            return m508a((gq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f539a != null;
    }

    public boolean g() {
        return this.f543b;
    }

    public boolean h() {
        return this.f540a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = false;
        if (m507a()) {
            sb.append("key:");
            sb.append(this.f537a);
            z = false;
        } else {
            z = true;
        }
        if (m509b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("type:");
            sb.append(this.f542b);
            z = false;
        }
        if (m510c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("clear:");
            sb.append(this.f541a);
            z = false;
        }
        if (d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("intValue:");
            sb.append(this.f544c);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("longValue:");
            sb.append(this.f538a);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("stringValue:");
            String str = this.f539a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
        } else {
            z2 = z;
        }
        if (h()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("boolValue:");
            sb.append(this.f543b);
        }
        sb.append(")");
        return sb.toString();
    }

    public int a() {
        return this.f537a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m509b() {
        return this.f540a.get(1);
    }

    public void c(boolean z) {
        this.f540a.set(2, z);
    }

    public void d(boolean z) {
        this.f540a.set(3, z);
    }

    public void e(boolean z) {
        this.f540a.set(4, z);
    }

    public void f(boolean z) {
        this.f540a.set(5, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m507a() {
        return this.f540a.get(0);
    }

    public void b(boolean z) {
        this.f540a.set(1, z);
    }

    public int c() {
        return this.f544c;
    }

    public void a(boolean z) {
        this.f540a.set(0, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m506a();
        iaVar.a(f536a);
        if (m507a()) {
            iaVar.a(f11609a);
            iaVar.mo636a(this.f537a);
            iaVar.b();
        }
        if (m509b()) {
            iaVar.a(b);
            iaVar.mo636a(this.f542b);
            iaVar.b();
        }
        if (m510c()) {
            iaVar.a(c);
            iaVar.a(this.f541a);
            iaVar.b();
        }
        if (d()) {
            iaVar.a(d);
            iaVar.mo636a(this.f544c);
            iaVar.b();
        }
        if (e()) {
            iaVar.a(e);
            iaVar.a(this.f538a);
            iaVar.b();
        }
        if (this.f539a != null && f()) {
            iaVar.a(f);
            iaVar.a(this.f539a);
            iaVar.b();
        }
        if (h()) {
            iaVar.a(g);
            iaVar.a(this.f543b);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m504a() {
        return this.f538a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m505a() {
        return this.f539a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m508a(gq gqVar) {
        if (gqVar == null) {
            return false;
        }
        boolean zM507a = m507a();
        boolean zM507a2 = gqVar.m507a();
        if ((zM507a || zM507a2) && !(zM507a && zM507a2 && this.f537a == gqVar.f537a)) {
            return false;
        }
        boolean zM509b = m509b();
        boolean zM509b2 = gqVar.m509b();
        if ((zM509b || zM509b2) && !(zM509b && zM509b2 && this.f542b == gqVar.f542b)) {
            return false;
        }
        boolean zM510c = m510c();
        boolean zM510c2 = gqVar.m510c();
        if ((zM510c || zM510c2) && !(zM510c && zM510c2 && this.f541a == gqVar.f541a)) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = gqVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f544c == gqVar.f544c)) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = gqVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f538a == gqVar.f538a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gqVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f539a.equals(gqVar.f539a))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gqVar.h();
        if (zH || zH2) {
            return zH && zH2 && this.f543b == gqVar.f543b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gq gqVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        if (!getClass().equals(gqVar.getClass())) {
            return getClass().getName().compareTo(gqVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m507a()).compareTo(Boolean.valueOf(gqVar.m507a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m507a() && (iA7 = hr.a(this.f537a, gqVar.f537a)) != 0) {
            return iA7;
        }
        int iCompareTo2 = Boolean.valueOf(m509b()).compareTo(Boolean.valueOf(gqVar.m509b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m509b() && (iA6 = hr.a(this.f542b, gqVar.f542b)) != 0) {
            return iA6;
        }
        int iCompareTo3 = Boolean.valueOf(m510c()).compareTo(Boolean.valueOf(gqVar.m510c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m510c() && (iA5 = hr.a(this.f541a, gqVar.f541a)) != 0) {
            return iA5;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gqVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA4 = hr.a(this.f544c, gqVar.f544c)) != 0) {
            return iA4;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gqVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA3 = hr.a(this.f538a, gqVar.f538a)) != 0) {
            return iA3;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gqVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA2 = hr.a(this.f539a, gqVar.f539a)) != 0) {
            return iA2;
        }
        int iCompareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gqVar.h()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (!h() || (iA = hr.a(this.f543b, gqVar.f543b)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.hq
    public void a(ia iaVar) {
        iaVar.mo631a();
        while (true) {
            hx hxVarMo627a = iaVar.mo627a();
            byte b2 = hxVarMo627a.f11640a;
            if (b2 == 0) {
                iaVar.f();
                m506a();
                return;
            }
            switch (hxVarMo627a.f836a) {
                case 1:
                    if (b2 == 8) {
                        this.f537a = iaVar.mo625a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f542b = iaVar.mo625a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f541a = iaVar.mo637a();
                        c(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 8) {
                        this.f544c = iaVar.mo625a();
                        d(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f538a = iaVar.mo626a();
                        e(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f539a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 2) {
                        this.f543b = iaVar.mo637a();
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
}
