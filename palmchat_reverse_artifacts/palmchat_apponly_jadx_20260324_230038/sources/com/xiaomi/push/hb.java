package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hb implements hq<hb, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gf f655a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gs f656a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f657a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f658a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer f659a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f662b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f654a = new Cif("XmPushActionContainer");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11621a = new hx("", (byte) 8, 1);
    private static final hx b = new hx("", (byte) 2, 2);
    private static final hx c = new hx("", (byte) 2, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 11, 5);
    private static final hx f = new hx("", (byte) 11, 6);
    private static final hx g = new hx("", (byte) 12, 7);
    private static final hx h = new hx("", (byte) 12, 8);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f660a = new BitSet(2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f661a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f663b = true;

    public gf a() {
        return this.f655a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m561b() {
        return this.f661a;
    }

    public boolean c() {
        return this.f660a.get(0);
    }

    public boolean d() {
        return this.f660a.get(1);
    }

    public boolean e() {
        return this.f659a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hb)) {
            return m558a((hb) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f658a != null;
    }

    public boolean g() {
        return this.f662b != null;
    }

    public boolean h() {
        return this.f657a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f656a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        gf gfVar = this.f655a;
        if (gfVar == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(gfVar);
        }
        sb.append(", ");
        sb.append("encryptAction:");
        sb.append(this.f661a);
        sb.append(", ");
        sb.append("isRequest:");
        sb.append(this.f663b);
        if (f()) {
            sb.append(", ");
            sb.append("appid:");
            String str = this.f658a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str2 = this.f662b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("target:");
        gu guVar = this.f657a;
        if (guVar == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(guVar);
        }
        if (i()) {
            sb.append(", ");
            sb.append("metaInfo:");
            gs gsVar = this.f656a;
            if (gsVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(gsVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public hb a(gf gfVar) {
        this.f655a = gfVar;
        return this;
    }

    public hb b(boolean z) {
        this.f663b = z;
        m560b(true);
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m557a() {
        return this.f655a != null;
    }

    public hb a(boolean z) {
        this.f661a = z;
        m556a(true);
        return this;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m560b(boolean z) {
        this.f660a.set(1, z);
    }

    public String b() {
        return this.f662b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m556a(boolean z) {
        this.f660a.set(0, z);
    }

    public hb b(String str) {
        this.f662b = str;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m559a() {
        a(hr.a(this.f659a));
        return this.f659a.array();
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m555a();
        iaVar.a(f654a);
        if (this.f655a != null) {
            iaVar.a(f11621a);
            iaVar.mo636a(this.f655a.a());
            iaVar.b();
        }
        iaVar.a(b);
        iaVar.a(this.f661a);
        iaVar.b();
        iaVar.a(c);
        iaVar.a(this.f663b);
        iaVar.b();
        if (this.f659a != null) {
            iaVar.a(d);
            iaVar.a(this.f659a);
            iaVar.b();
        }
        if (this.f658a != null && f()) {
            iaVar.a(e);
            iaVar.a(this.f658a);
            iaVar.b();
        }
        if (this.f662b != null && g()) {
            iaVar.a(f);
            iaVar.a(this.f662b);
            iaVar.b();
        }
        if (this.f657a != null) {
            iaVar.a(g);
            this.f657a.b(iaVar);
            iaVar.b();
        }
        if (this.f656a != null && i()) {
            iaVar.a(h);
            this.f656a.b(iaVar);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    public hb a(ByteBuffer byteBuffer) {
        this.f659a = byteBuffer;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m554a() {
        return this.f658a;
    }

    public hb a(String str) {
        this.f658a = str;
        return this;
    }

    public hb a(gu guVar) {
        this.f657a = guVar;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public gs m553a() {
        return this.f656a;
    }

    public hb a(gs gsVar) {
        this.f656a = gsVar;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m558a(hb hbVar) {
        if (hbVar == null) {
            return false;
        }
        boolean zM557a = m557a();
        boolean zM557a2 = hbVar.m557a();
        if (((zM557a || zM557a2) && (!zM557a || !zM557a2 || !this.f655a.equals(hbVar.f655a))) || this.f661a != hbVar.f661a || this.f663b != hbVar.f663b) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = hbVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f659a.equals(hbVar.f659a))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = hbVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f658a.equals(hbVar.f658a))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = hbVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f662b.equals(hbVar.f662b))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = hbVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f657a.m531a(hbVar.f657a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = hbVar.i();
        if (zI || zI2) {
            return zI && zI2 && this.f656a.m523a(hbVar.f656a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hb hbVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        if (!getClass().equals(hbVar.getClass())) {
            return getClass().getName().compareTo(hbVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m557a()).compareTo(Boolean.valueOf(hbVar.m557a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m557a() && (iA8 = hr.a(this.f655a, hbVar.f655a)) != 0) {
            return iA8;
        }
        int iCompareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hbVar.c()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (c() && (iA7 = hr.a(this.f661a, hbVar.f661a)) != 0) {
            return iA7;
        }
        int iCompareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hbVar.d()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (d() && (iA6 = hr.a(this.f663b, hbVar.f663b)) != 0) {
            return iA6;
        }
        int iCompareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hbVar.e()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (e() && (iA5 = hr.a(this.f659a, hbVar.f659a)) != 0) {
            return iA5;
        }
        int iCompareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hbVar.f()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (f() && (iA4 = hr.a(this.f658a, hbVar.f658a)) != 0) {
            return iA4;
        }
        int iCompareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hbVar.g()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (g() && (iA3 = hr.a(this.f662b, hbVar.f662b)) != 0) {
            return iA3;
        }
        int iCompareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hbVar.h()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (h() && (iA2 = hr.a(this.f657a, hbVar.f657a)) != 0) {
            return iA2;
        }
        int iCompareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hbVar.i()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (!i() || (iA = hr.a(this.f656a, hbVar.f656a)) == 0) {
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
                if (c()) {
                    if (d()) {
                        m555a();
                        return;
                    }
                    throw new ib("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
                throw new ib("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo627a.f836a) {
                case 1:
                    if (b2 == 8) {
                        this.f655a = gf.a(iaVar.mo625a());
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 2) {
                        this.f661a = iaVar.mo637a();
                        m556a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f663b = iaVar.mo637a();
                        m560b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f659a = iaVar.mo633a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f658a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f662b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f657a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        gs gsVar = new gs();
                        this.f656a = gsVar;
                        gsVar.a(iaVar);
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

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m555a() throws ib {
        if (this.f655a != null) {
            if (this.f659a != null) {
                if (this.f657a != null) {
                    return;
                }
                throw new ib("Required field 'target' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'pushAction' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'action' was not present! Struct: " + toString());
    }
}
