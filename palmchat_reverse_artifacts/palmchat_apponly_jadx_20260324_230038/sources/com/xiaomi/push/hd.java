package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hd implements hq<hd, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<go> f667a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f666a = new Cif("XmPushActionNormalConfig");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11623a = new hx("", (byte) 15, 1);

    public List<go> a() {
        return this.f667a;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m565a();
        iaVar.a(f666a);
        if (this.f667a != null) {
            iaVar.a(f11623a);
            iaVar.a(new hy((byte) 12, this.f667a.size()));
            Iterator<go> it = this.f667a.iterator();
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
        if (obj != null && (obj instanceof hd)) {
            return m567a((hd) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<go> list = this.f667a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m566a() {
        return this.f667a != null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m567a(hd hdVar) {
        if (hdVar == null) {
            return false;
        }
        boolean zM566a = m566a();
        boolean zM566a2 = hdVar.m566a();
        if (zM566a || zM566a2) {
            return zM566a && zM566a2 && this.f667a.equals(hdVar.f667a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hd hdVar) {
        int iA;
        if (!getClass().equals(hdVar.getClass())) {
            return getClass().getName().compareTo(hdVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m566a()).compareTo(Boolean.valueOf(hdVar.m566a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (!m566a() || (iA = hr.a(this.f667a, hdVar.f667a)) == 0) {
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
                m565a();
                return;
            }
            if (hxVarMo627a.f836a != 1) {
                id.a(iaVar, b);
            } else if (b == 15) {
                hy hyVarMo628a = iaVar.mo628a();
                this.f667a = new ArrayList(hyVarMo628a.f837a);
                for (int i = 0; i < hyVarMo628a.f837a; i++) {
                    go goVar = new go();
                    goVar.a(iaVar);
                    this.f667a.add(goVar);
                }
                iaVar.i();
            } else {
                id.a(iaVar, b);
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m565a() throws ib {
        if (this.f667a != null) {
            return;
        }
        throw new ib("Required field 'normalConfigs' was not present! Struct: " + toString());
    }
}
