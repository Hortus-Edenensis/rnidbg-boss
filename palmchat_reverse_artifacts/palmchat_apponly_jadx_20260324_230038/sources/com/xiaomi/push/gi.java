package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class gi implements hq<gi, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<gj> f504a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f503a = new Cif("ClientUploadData");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11601a = new hx("", (byte) 15, 1);

    public int a() {
        List<gj> list = this.f504a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m484a();
        iaVar.a(f503a);
        if (this.f504a != null) {
            iaVar.a(f11601a);
            iaVar.a(new hy((byte) 12, this.f504a.size()));
            Iterator<gj> it = this.f504a.iterator();
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
        if (obj != null && (obj instanceof gi)) {
            return m486a((gi) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<gj> list = this.f504a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public void a(gj gjVar) {
        if (this.f504a == null) {
            this.f504a = new ArrayList();
        }
        this.f504a.add(gjVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m485a() {
        return this.f504a != null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m486a(gi giVar) {
        if (giVar == null) {
            return false;
        }
        boolean zM485a = m485a();
        boolean zM485a2 = giVar.m485a();
        if (zM485a || zM485a2) {
            return zM485a && zM485a2 && this.f504a.equals(giVar.f504a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gi giVar) {
        int iA;
        if (!getClass().equals(giVar.getClass())) {
            return getClass().getName().compareTo(giVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m485a()).compareTo(Boolean.valueOf(giVar.m485a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m485a() || (iA = hr.a(this.f504a, giVar.f504a)) == 0) {
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
                m484a();
                return;
            }
            if (hxVarMo627a.f836a != 1) {
                id.a(iaVar, b);
            } else if (b == 15) {
                hy hyVarMo628a = iaVar.mo628a();
                this.f504a = new ArrayList(hyVarMo628a.f837a);
                for (int i = 0; i < hyVarMo628a.f837a; i++) {
                    gj gjVar = new gj();
                    gjVar.a(iaVar);
                    this.f504a.add(gjVar);
                }
                iaVar.i();
            } else {
                id.a(iaVar, b);
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m484a() throws ib {
        if (this.f504a != null) {
            return;
        }
        throw new ib("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }
}
