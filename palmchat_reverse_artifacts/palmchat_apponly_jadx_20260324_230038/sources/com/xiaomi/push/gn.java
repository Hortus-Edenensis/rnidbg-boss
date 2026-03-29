package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class gn implements hq<gn, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gh f526a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f527a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f528a = new BitSet(1);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f524a = new Cif("DataCollectionItem");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11606a = new hx("", (byte) 10, 1);
    private static final hx b = new hx("", (byte) 8, 2);
    private static final hx c = new hx("", (byte) 11, 3);

    public gn a(long j) {
        this.f525a = j;
        a(true);
        return this;
    }

    public boolean b() {
        return this.f526a != null;
    }

    public boolean c() {
        return this.f527a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gn)) {
            return m499a((gn) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataCollectionItem(");
        sb.append("collectedAt:");
        sb.append(this.f525a);
        sb.append(", ");
        sb.append("collectionType:");
        gh ghVar = this.f526a;
        if (ghVar == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(ghVar);
        }
        sb.append(", ");
        sb.append("content:");
        String str = this.f527a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m497a();
        iaVar.a(f524a);
        iaVar.a(f11606a);
        iaVar.a(this.f525a);
        iaVar.b();
        if (this.f526a != null) {
            iaVar.a(b);
            iaVar.mo636a(this.f526a.a());
            iaVar.b();
        }
        if (this.f527a != null) {
            iaVar.a(c);
            iaVar.a(this.f527a);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m498a() {
        return this.f528a.get(0);
    }

    public void a(boolean z) {
        this.f528a.set(0, z);
    }

    public gn a(gh ghVar) {
        this.f526a = ghVar;
        return this;
    }

    public String a() {
        return this.f527a;
    }

    public gn a(String str) {
        this.f527a = str;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m499a(gn gnVar) {
        if (gnVar == null || this.f525a != gnVar.f525a) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = gnVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f526a.equals(gnVar.f526a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = gnVar.c();
        if (zC || zC2) {
            return zC && zC2 && this.f527a.equals(gnVar.f527a);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gn gnVar) {
        int iA;
        int iA2;
        int iA3;
        if (!getClass().equals(gnVar.getClass())) {
            return getClass().getName().compareTo(gnVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m498a()).compareTo(Boolean.valueOf(gnVar.m498a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m498a() && (iA3 = hr.a(this.f525a, gnVar.f525a)) != 0) {
            return iA3;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gnVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA2 = hr.a(this.f526a, gnVar.f526a)) != 0) {
            return iA2;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gnVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (!c() || (iA = hr.a(this.f527a, gnVar.f527a)) == 0) {
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
                    } else if (b2 == 11) {
                        this.f527a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                } else if (b2 == 8) {
                    this.f526a = gh.a(iaVar.mo625a());
                } else {
                    id.a(iaVar, b2);
                }
            } else if (b2 == 10) {
                this.f525a = iaVar.mo626a();
                a(true);
            } else {
                id.a(iaVar, b2);
            }
            iaVar.g();
        }
        iaVar.f();
        if (m498a()) {
            m497a();
            return;
        }
        throw new ib("Required field 'collectedAt' was not found in serialized data! Struct: " + toString());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m497a() throws ib {
        if (this.f526a != null) {
            if (this.f527a != null) {
                return;
            }
            throw new ib("Required field 'content' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'collectionType' was not present! Struct: " + toString());
    }
}
