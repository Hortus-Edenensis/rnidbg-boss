package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hc implements hq<hc, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<gq> f665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f664a = new Cif("XmPushActionCustomConfig");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11622a = new hx("", (byte) 15, 1);

    public List<gq> a() {
        return this.f665a;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m562a();
        iaVar.a(f664a);
        if (this.f665a != null) {
            iaVar.a(f11622a);
            iaVar.a(new hy((byte) 12, this.f665a.size()));
            Iterator<gq> it = this.f665a.iterator();
            while (it.hasNext()) {
                it.next().b(iaVar);
            }
            iaVar.e();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hc)) {
            return m564a((hc) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<gq> list = this.f665a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m563a() {
        return this.f665a != null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m564a(hc hcVar) {
        if (hcVar == null) {
            return false;
        }
        boolean zM563a = m563a();
        boolean zM563a2 = hcVar.m563a();
        if (zM563a || zM563a2) {
            return zM563a && zM563a2 && this.f665a.equals(hcVar.f665a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hc hcVar) {
        int iA;
        if (!getClass().equals(hcVar.getClass())) {
            return getClass().getName().compareTo(hcVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m563a()).compareTo(Boolean.valueOf(hcVar.m563a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m563a() || (iA = hr.a(this.f665a, hcVar.f665a)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.hq
    public void a(ia iaVar) throws ib {
        iaVar.mo631a();
        while (true) {
            hx hxVarMo627a = iaVar.mo627a();
            byte b = hxVarMo627a.f11640a;
            if (b == 0) {
                iaVar.f();
                m562a();
                return;
            }
            if (hxVarMo627a.f836a != 1) {
                id.a(iaVar, b);
            } else if (b == 15) {
                hy hyVarMo628a = iaVar.mo628a();
                this.f665a = new ArrayList(hyVarMo628a.f837a);
                for (int i = 0; i < hyVarMo628a.f837a; i++) {
                    gq gqVar = new gq();
                    gqVar.a(iaVar);
                    this.f665a.add(gqVar);
                }
                iaVar.i();
            } else {
                id.a(iaVar, b);
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m562a() throws ib {
        if (this.f665a != null) {
            return;
        }
        throw new ib("Required field 'customConfigs' was not present! Struct: " + toString());
    }
}
