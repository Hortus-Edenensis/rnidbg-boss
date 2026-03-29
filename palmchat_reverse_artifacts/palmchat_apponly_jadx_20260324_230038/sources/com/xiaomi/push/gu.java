package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class gu implements hq<gu, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f584a;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f589d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f582a = new Cif("Target");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11613a = new hx("", (byte) 10, 1);
    private static final hx b = new hx("", (byte) 11, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 2, 5);
    private static final hx f = new hx("", (byte) 11, 7);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f585a = new BitSet(2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f583a = 5;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f587b = "xiaomi.com";

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f588c = "";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f586a = false;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m530a() {
        return this.f585a.get(0);
    }

    public boolean b() {
        return this.f584a != null;
    }

    public boolean c() {
        return this.f587b != null;
    }

    public boolean d() {
        return this.f588c != null;
    }

    public boolean e() {
        return this.f585a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gu)) {
            return m531a((gu) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f589d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f583a);
        sb.append(", ");
        sb.append("userId:");
        String str = this.f584a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(", ");
            sb.append("server:");
            String str2 = this.f587b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(", ");
            sb.append("resource:");
            String str3 = this.f588c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("isPreview:");
            sb.append(this.f586a);
        }
        if (f()) {
            sb.append(", ");
            sb.append("token:");
            String str4 = this.f589d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(boolean z) {
        this.f585a.set(0, z);
    }

    public void b(boolean z) {
        this.f585a.set(1, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m531a(gu guVar) {
        if (guVar == null || this.f583a != guVar.f583a) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = guVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f584a.equals(guVar.f584a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = guVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f587b.equals(guVar.f587b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = guVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f588c.equals(guVar.f588c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = guVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f586a == guVar.f586a)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = guVar.f();
        if (zF || zF2) {
            return zF && zF2 && this.f589d.equals(guVar.f589d);
        }
        return true;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        a();
        iaVar.a(f582a);
        iaVar.a(f11613a);
        iaVar.a(this.f583a);
        iaVar.b();
        if (this.f584a != null) {
            iaVar.a(b);
            iaVar.a(this.f584a);
            iaVar.b();
        }
        if (this.f587b != null && c()) {
            iaVar.a(c);
            iaVar.a(this.f587b);
            iaVar.b();
        }
        if (this.f588c != null && d()) {
            iaVar.a(d);
            iaVar.a(this.f588c);
            iaVar.b();
        }
        if (e()) {
            iaVar.a(e);
            iaVar.a(this.f586a);
            iaVar.b();
        }
        if (this.f589d != null && f()) {
            iaVar.a(f);
            iaVar.a(this.f589d);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gu guVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        if (!getClass().equals(guVar.getClass())) {
            return getClass().getName().compareTo(guVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m530a()).compareTo(Boolean.valueOf(guVar.m530a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m530a() && (iA6 = hr.a(this.f583a, guVar.f583a)) != 0) {
            return iA6;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(guVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA5 = hr.a(this.f584a, guVar.f584a)) != 0) {
            return iA5;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(guVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA4 = hr.a(this.f587b, guVar.f587b)) != 0) {
            return iA4;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(guVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA3 = hr.a(this.f588c, guVar.f588c)) != 0) {
            return iA3;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(guVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA2 = hr.a(this.f586a, guVar.f586a)) != 0) {
            return iA2;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(guVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (!f() || (iA = hr.a(this.f589d, guVar.f589d)) == 0) {
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
                break;
            }
            short s = hxVarMo627a.f836a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        if (s != 4) {
                            if (s != 5) {
                                if (s != 7) {
                                    id.a(iaVar, b2);
                                } else if (b2 == 11) {
                                    this.f589d = iaVar.mo632a();
                                } else {
                                    id.a(iaVar, b2);
                                }
                            } else if (b2 == 2) {
                                this.f586a = iaVar.mo637a();
                                b(true);
                            } else {
                                id.a(iaVar, b2);
                            }
                        } else if (b2 == 11) {
                            this.f588c = iaVar.mo632a();
                        } else {
                            id.a(iaVar, b2);
                        }
                    } else if (b2 == 11) {
                        this.f587b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                } else if (b2 == 11) {
                    this.f584a = iaVar.mo632a();
                } else {
                    id.a(iaVar, b2);
                }
            } else if (b2 == 10) {
                this.f583a = iaVar.mo626a();
                a(true);
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
        iaVar.f();
        if (m530a()) {
            a();
            return;
        }
        throw new ib("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a() throws ib {
        if (this.f584a != null) {
            return;
        }
        throw new ib("Required field 'userId' was not present! Struct: " + toString());
    }
}
