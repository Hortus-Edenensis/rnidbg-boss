package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class gx implements hq<gx, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f625a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f626a = new BitSet(2);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f627b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f624a = new Cif("XmPushActionCheckClientInfo");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11616a = new hx("", (byte) 8, 1);
    private static final hx b = new hx("", (byte) 8, 2);

    public void a() {
    }

    public gx b(int i) {
        this.f627b = i;
        b(true);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gx)) {
            return m540a((gx) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f625a + ", pluginConfigVersion:" + this.f627b + ")";
    }

    public gx a(int i) {
        this.f625a = i;
        a(true);
        return this;
    }

    public boolean b() {
        return this.f626a.get(1);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m539a() {
        return this.f626a.get(0);
    }

    public void b(boolean z) {
        this.f626a.set(1, z);
    }

    public void a(boolean z) {
        this.f626a.set(0, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        a();
        iaVar.a(f624a);
        iaVar.a(f11616a);
        iaVar.mo636a(this.f625a);
        iaVar.b();
        iaVar.a(b);
        iaVar.mo636a(this.f627b);
        iaVar.b();
        iaVar.c();
        iaVar.mo635a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m540a(gx gxVar) {
        return gxVar != null && this.f625a == gxVar.f625a && this.f627b == gxVar.f627b;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gx gxVar) {
        int iA;
        int iA2;
        if (!getClass().equals(gxVar.getClass())) {
            return getClass().getName().compareTo(gxVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m539a()).compareTo(Boolean.valueOf(gxVar.m539a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m539a() && (iA2 = hr.a(this.f625a, gxVar.f625a)) != 0) {
            return iA2;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gxVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (!b() || (iA = hr.a(this.f627b, gxVar.f627b)) == 0) {
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
                    id.a(iaVar, b2);
                } else if (b2 == 8) {
                    this.f627b = iaVar.mo625a();
                    b(true);
                } else {
                    id.a(iaVar, b2);
                }
            } else if (b2 == 8) {
                this.f625a = iaVar.mo625a();
                a(true);
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
        iaVar.f();
        if (m539a()) {
            if (b()) {
                a();
                return;
            }
            throw new ib("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
        throw new ib("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
    }
}
