package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ek implements hq<ek, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f379a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<ej> f380a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f381b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f378a = new Cif("StatsEvents");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11540a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 11, 2);
    private static final hx c = new hx("", (byte) 15, 3);

    public ek() {
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m401a() {
        return this.f379a != null;
    }

    public boolean b() {
        return this.f381b != null;
    }

    public boolean c() {
        return this.f380a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ek)) {
            return m402a((ek) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f379a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(", ");
            sb.append("operator:");
            String str2 = this.f381b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("events:");
        List<ej> list = this.f380a;
        if (list == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(list);
        }
        sb.append(")");
        return sb.toString();
    }

    public ek(String str, List<ej> list) {
        this();
        this.f379a = str;
        this.f380a = list;
    }

    public ek a(String str) {
        this.f381b = str;
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        a();
        iaVar.a(f378a);
        if (this.f379a != null) {
            iaVar.a(f11540a);
            iaVar.a(this.f379a);
            iaVar.b();
        }
        if (this.f381b != null && b()) {
            iaVar.a(b);
            iaVar.a(this.f381b);
            iaVar.b();
        }
        if (this.f380a != null) {
            iaVar.a(c);
            iaVar.a(new hy((byte) 12, this.f380a.size()));
            Iterator<ej> it = this.f380a.iterator();
            while (it.hasNext()) {
                it.next().b(iaVar);
            }
            iaVar.e();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m402a(ek ekVar) {
        if (ekVar == null) {
            return false;
        }
        boolean zM401a = m401a();
        boolean zM401a2 = ekVar.m401a();
        if ((zM401a || zM401a2) && !(zM401a && zM401a2 && this.f379a.equals(ekVar.f379a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = ekVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f381b.equals(ekVar.f381b))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = ekVar.c();
        if (zC || zC2) {
            return zC && zC2 && this.f380a.equals(ekVar.f380a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ek ekVar) {
        int iA;
        int iA2;
        int iA3;
        if (!getClass().equals(ekVar.getClass())) {
            return getClass().getName().compareTo(ekVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m401a()).compareTo(Boolean.valueOf(ekVar.m401a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m401a() && (iA3 = hr.a(this.f379a, ekVar.f379a)) != 0) {
            return iA3;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ekVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA2 = hr.a(this.f381b, ekVar.f381b)) != 0) {
            return iA2;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ekVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (!c() || (iA = hr.a(this.f380a, ekVar.f380a)) == 0) {
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
                a();
                return;
            }
            short s = hxVarMo627a.f836a;
            if (s != 1) {
                if (s != 2) {
                    if (s != 3) {
                        id.a(iaVar, b2);
                    } else if (b2 == 15) {
                        hy hyVarMo628a = iaVar.mo628a();
                        this.f380a = new ArrayList(hyVarMo628a.f837a);
                        for (int i = 0; i < hyVarMo628a.f837a; i++) {
                            ej ejVar = new ej();
                            ejVar.a(iaVar);
                            this.f380a.add(ejVar);
                        }
                        iaVar.i();
                    } else {
                        id.a(iaVar, b2);
                    }
                } else if (b2 == 11) {
                    this.f381b = iaVar.mo632a();
                } else {
                    id.a(iaVar, b2);
                }
            } else if (b2 == 11) {
                this.f379a = iaVar.mo632a();
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
    }

    public void a() throws ib {
        if (this.f379a != null) {
            if (this.f380a != null) {
                return;
            }
            throw new ib("Required field 'events' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'uuid' was not present! Struct: " + toString());
    }
}
