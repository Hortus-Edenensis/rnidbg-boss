package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hm implements hq<hm, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f796a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f798a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f799a = new BitSet(3);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f800b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f801b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f802c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f803c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f804d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f805e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f795a = new Cif("XmPushActionUnRegistrationResult");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11632a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 12, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 10, 6);
    private static final hx f = new hx("", (byte) 11, 7);
    private static final hx g = new hx("", (byte) 11, 8);
    private static final hx h = new hx("", (byte) 10, 9);
    private static final hx i = new hx("", (byte) 10, 10);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m611a() {
        return this.f798a != null;
    }

    public boolean b() {
        return this.f797a != null;
    }

    public boolean c() {
        return this.f801b != null;
    }

    public boolean d() {
        return this.f803c != null;
    }

    public boolean e() {
        return this.f799a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hm)) {
            return m612a((hm) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f804d != null;
    }

    public boolean g() {
        return this.f805e != null;
    }

    public boolean h() {
        return this.f799a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f799a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = false;
        if (m611a()) {
            sb.append("debug:");
            String str = this.f798a;
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
            gu guVar = this.f797a;
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
        String str2 = this.f801b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f803c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f796a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f804d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f805e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("unRegisteredAt:");
            sb.append(this.f800b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("costTime:");
            sb.append(this.f802c);
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f799a.set(0, z);
    }

    public void b(boolean z) {
        this.f799a.set(1, z);
    }

    public void c(boolean z) {
        this.f799a.set(2, z);
    }

    public String a() {
        return this.f805e;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m610a();
        iaVar.a(f795a);
        if (this.f798a != null && m611a()) {
            iaVar.a(f11632a);
            iaVar.a(this.f798a);
            iaVar.b();
        }
        if (this.f797a != null && b()) {
            iaVar.a(b);
            this.f797a.b(iaVar);
            iaVar.b();
        }
        if (this.f801b != null) {
            iaVar.a(c);
            iaVar.a(this.f801b);
            iaVar.b();
        }
        if (this.f803c != null) {
            iaVar.a(d);
            iaVar.a(this.f803c);
            iaVar.b();
        }
        iaVar.a(e);
        iaVar.a(this.f796a);
        iaVar.b();
        if (this.f804d != null && f()) {
            iaVar.a(f);
            iaVar.a(this.f804d);
            iaVar.b();
        }
        if (this.f805e != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f805e);
            iaVar.b();
        }
        if (h()) {
            iaVar.a(h);
            iaVar.a(this.f800b);
            iaVar.b();
        }
        if (i()) {
            iaVar.a(i);
            iaVar.a(this.f802c);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m612a(hm hmVar) {
        if (hmVar == null) {
            return false;
        }
        boolean zM611a = m611a();
        boolean zM611a2 = hmVar.m611a();
        if ((zM611a || zM611a2) && !(zM611a && zM611a2 && this.f798a.equals(hmVar.f798a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hmVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f797a.m531a(hmVar.f797a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hmVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f801b.equals(hmVar.f801b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hmVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f803c.equals(hmVar.f803c))) || this.f796a != hmVar.f796a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hmVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f804d.equals(hmVar.f804d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hmVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f805e.equals(hmVar.f805e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hmVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f800b == hmVar.f800b)) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hmVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f802c == hmVar.f802c;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hm hmVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        if (!getClass().equals(hmVar.getClass())) {
            return getClass().getName().compareTo(hmVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m611a()).compareTo(Boolean.valueOf(hmVar.m611a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m611a() && (iA9 = hr.a(this.f798a, hmVar.f798a)) != 0) {
            return iA9;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hmVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA8 = hr.a(this.f797a, hmVar.f797a)) != 0) {
            return iA8;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hmVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA7 = hr.a(this.f801b, hmVar.f801b)) != 0) {
            return iA7;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hmVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA6 = hr.a(this.f803c, hmVar.f803c)) != 0) {
            return iA6;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hmVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA5 = hr.a(this.f796a, hmVar.f796a)) != 0) {
            return iA5;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hmVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA4 = hr.a(this.f804d, hmVar.f804d)) != 0) {
            return iA4;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hmVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA3 = hr.a(this.f805e, hmVar.f805e)) != 0) {
            return iA3;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hmVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA2 = hr.a(this.f800b, hmVar.f800b)) != 0) {
            return iA2;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hmVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (!i() || (iA = hr.a(this.f802c, hmVar.f802c)) == 0) {
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
                if (e()) {
                    m610a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo627a.f836a) {
                case 1:
                    if (b2 == 11) {
                        this.f798a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f797a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f801b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f803c = iaVar.mo632a();
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
                        this.f796a = iaVar.mo626a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f804d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f805e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 10) {
                        this.f800b = iaVar.mo626a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 10) {
                        this.f802c = iaVar.mo626a();
                        c(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m610a() throws ib {
        if (this.f801b != null) {
            if (this.f803c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
