package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hh implements hq<hh, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f740a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f741a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f742a = new BitSet(1);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f743b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f744c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f745d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f746e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f738a = new Cif("XmPushActionSendFeedbackResult");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11627a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 12, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 10, 6);
    private static final hx f = new hx("", (byte) 11, 7);
    private static final hx g = new hx("", (byte) 11, 8);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m590a() {
        return this.f741a != null;
    }

    public boolean b() {
        return this.f740a != null;
    }

    public boolean c() {
        return this.f743b != null;
    }

    public boolean d() {
        return this.f744c != null;
    }

    public boolean e() {
        return this.f742a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hh)) {
            return m591a((hh) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f745d != null;
    }

    public boolean g() {
        return this.f746e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = false;
        if (m590a()) {
            sb.append("debug:");
            String str = this.f741a;
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
            gu guVar = this.f740a;
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
        String str2 = this.f743b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("appId:");
        String str3 = this.f744c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f739a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f745d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f746e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f742a.set(0, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f738a);
        if (this.f741a != null && m590a()) {
            iaVar.a(f11627a);
            iaVar.a(this.f741a);
            iaVar.b();
        }
        if (this.f740a != null && b()) {
            iaVar.a(b);
            this.f740a.b(iaVar);
            iaVar.b();
        }
        if (this.f743b != null) {
            iaVar.a(c);
            iaVar.a(this.f743b);
            iaVar.b();
        }
        if (this.f744c != null) {
            iaVar.a(d);
            iaVar.a(this.f744c);
            iaVar.b();
        }
        iaVar.a(e);
        iaVar.a(this.f739a);
        iaVar.b();
        if (this.f745d != null && f()) {
            iaVar.a(f);
            iaVar.a(this.f745d);
            iaVar.b();
        }
        if (this.f746e != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f746e);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m591a(hh hhVar) {
        if (hhVar == null) {
            return false;
        }
        boolean zM590a = m590a();
        boolean zM590a2 = hhVar.m590a();
        if ((zM590a || zM590a2) && !(zM590a && zM590a2 && this.f741a.equals(hhVar.f741a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = hhVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f740a.m531a(hhVar.f740a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = hhVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f743b.equals(hhVar.f743b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = hhVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f744c.equals(hhVar.f744c))) || this.f739a != hhVar.f739a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hhVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f745d.equals(hhVar.f745d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hhVar.g();
        if (zG || zG2) {
            return zG && zG2 && this.f746e.equals(hhVar.f746e);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hh hhVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        if (!getClass().equals(hhVar.getClass())) {
            return getClass().getName().compareTo(hhVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m590a()).compareTo(Boolean.valueOf(hhVar.m590a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m590a() && (iA7 = hr.a(this.f741a, hhVar.f741a)) != 0) {
            return iA7;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hhVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA6 = hr.a(this.f740a, hhVar.f740a)) != 0) {
            return iA6;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hhVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA5 = hr.a(this.f743b, hhVar.f743b)) != 0) {
            return iA5;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hhVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA4 = hr.a(this.f744c, hhVar.f744c)) != 0) {
            return iA4;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hhVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA3 = hr.a(this.f739a, hhVar.f739a)) != 0) {
            return iA3;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hhVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA2 = hr.a(this.f745d, hhVar.f745d)) != 0) {
            return iA2;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hhVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (!g() || (iA = hr.a(this.f746e, hhVar.f746e)) == 0) {
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
                    a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo627a.f836a) {
                case 1:
                    if (b2 == 11) {
                        this.f741a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f740a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f743b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f744c = iaVar.mo632a();
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
                        this.f739a = iaVar.mo626a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f745d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f746e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
            }
            iaVar.g();
        }
    }

    public void a() throws ib {
        if (this.f743b != null) {
            if (this.f744c != null) {
                return;
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
