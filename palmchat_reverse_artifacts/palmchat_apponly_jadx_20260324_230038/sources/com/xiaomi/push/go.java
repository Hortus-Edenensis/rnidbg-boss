package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class go implements hq<go, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f530a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gl f531a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f532a = new BitSet(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<gq> f533a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f529a = new Cif("NormalConfig");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11607a = new hx("", (byte) 8, 1);
    private static final hx b = new hx("", (byte) 15, 2);
    private static final hx c = new hx("", (byte) 8, 3);

    public int a() {
        return this.f530a;
    }

    public boolean b() {
        return this.f533a != null;
    }

    public boolean c() {
        return this.f531a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof go)) {
            return m503a((go) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f530a);
        sb.append(", ");
        sb.append("configItems:");
        List<gq> list = this.f533a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(", ");
            sb.append("type:");
            gl glVar = this.f531a;
            if (glVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(glVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m502a() {
        return this.f532a.get(0);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m501a();
        iaVar.a(f529a);
        iaVar.a(f11607a);
        iaVar.mo636a(this.f530a);
        iaVar.b();
        if (this.f533a != null) {
            iaVar.a(b);
            iaVar.a(new hy((byte) 12, this.f533a.size()));
            Iterator<gq> it = this.f533a.iterator();
            while (it.hasNext()) {
                it.next().b(iaVar);
            }
            iaVar.e();
            iaVar.b();
        }
        if (this.f531a != null && c()) {
            iaVar.a(c);
            iaVar.mo636a(this.f531a.a());
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    public void a(boolean z) {
        this.f532a.set(0, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public gl m500a() {
        return this.f531a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m503a(go goVar) {
        if (goVar == null || this.f530a != goVar.f530a) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = goVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f533a.equals(goVar.f533a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = goVar.c();
        if (zC || zC2) {
            return zC && zC2 && this.f531a.equals(goVar.f531a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(go goVar) {
        int iA;
        int iA2;
        int iA3;
        if (!getClass().equals(goVar.getClass())) {
            return getClass().getName().compareTo(goVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m502a()).compareTo(Boolean.valueOf(goVar.m502a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m502a() && (iA3 = hr.a(this.f530a, goVar.f530a)) != 0) {
            return iA3;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(goVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA2 = hr.a(this.f533a, goVar.f533a)) != 0) {
            return iA2;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(goVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (!c() || (iA = hr.a(this.f531a, goVar.f531a)) == 0) {
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
                break;
            }
            short s = hxVarMo627a.f836a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        id.a(iaVar, b2);
                    } else if (b2 == 8) {
                        this.f531a = gl.a(iaVar.mo625a());
                    } else {
                        id.a(iaVar, b2);
                    }
                } else if (b2 == 15) {
                    hy hyVarMo628a = iaVar.mo628a();
                    this.f533a = new ArrayList(hyVarMo628a.f837a);
                    for (int i = 0; i < hyVarMo628a.f837a; i++) {
                        gq gqVar = new gq();
                        gqVar.a(iaVar);
                        this.f533a.add(gqVar);
                    }
                    iaVar.i();
                } else {
                    id.a(iaVar, b2);
                }
            } else if (b2 == 8) {
                this.f530a = iaVar.mo625a();
                a(true);
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
        iaVar.f();
        if (m502a()) {
            m501a();
            return;
        }
        throw new ib("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m501a() throws ib {
        if (this.f533a != null) {
            return;
        }
        throw new ib("Required field 'configItems' was not present! Struct: " + toString());
    }
}
