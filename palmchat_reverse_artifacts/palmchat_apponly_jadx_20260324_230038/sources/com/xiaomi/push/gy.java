package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class gy implements hq<gy, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<gn> f629a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f628a = new Cif("XmPushActionCollectData");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11617a = new hx("", (byte) 15, 1);

    public gy a(List<gn> list) {
        this.f629a = list;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f628a);
        if (this.f629a != null) {
            iaVar.a(f11617a);
            iaVar.a(new hy((byte) 12, this.f629a.size()));
            Iterator<gn> it = this.f629a.iterator();
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
        if (obj != null && (obj instanceof gy)) {
            return m542a((gy) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<gn> list = this.f629a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m541a() {
        return this.f629a != null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m542a(gy gyVar) {
        if (gyVar == null) {
            return false;
        }
        boolean zM541a = m541a();
        boolean zM541a2 = gyVar.m541a();
        if (zM541a || zM541a2) {
            return zM541a && zM541a2 && this.f629a.equals(gyVar.f629a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gy gyVar) {
        int iA;
        if (!getClass().equals(gyVar.getClass())) {
            return getClass().getName().compareTo(gyVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m541a()).compareTo(Boolean.valueOf(gyVar.m541a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m541a() || (iA = hr.a(this.f629a, gyVar.f629a)) == 0) {
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
                a();
                return;
            }
            if (hxVarMo627a.f836a != 1) {
                id.a(iaVar, b);
            } else if (b == 15) {
                hy hyVarMo628a = iaVar.mo628a();
                this.f629a = new ArrayList(hyVarMo628a.f837a);
                for (int i = 0; i < hyVarMo628a.f837a; i++) {
                    gn gnVar = new gn();
                    gnVar.a(iaVar);
                    this.f629a.add(gnVar);
                }
                iaVar.i();
            } else {
                id.a(iaVar, b);
            }
            iaVar.g();
        }
    }

    public void a() throws ib {
        if (this.f629a != null) {
            return;
        }
        throw new ib("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }
}
