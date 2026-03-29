package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class gz implements hq<gz, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f631a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f632a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f633a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f635a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f637b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f639c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f640d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f641e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f630a = new Cif("XmPushActionCommand");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11618a = new hx("", (byte) 12, 2);
    private static final hx b = new hx("", (byte) 11, 3);
    private static final hx c = new hx("", (byte) 11, 4);
    private static final hx d = new hx("", (byte) 11, 5);
    private static final hx e = new hx("", (byte) 15, 6);
    private static final hx f = new hx("", (byte) 11, 7);
    private static final hx g = new hx("", (byte) 11, 9);
    private static final hx h = new hx("", (byte) 2, 10);
    private static final hx i = new hx("", (byte) 2, 11);
    private static final hx j = new hx("", (byte) 10, 12);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f634a = new BitSet(3);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f636a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f638b = true;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m545a() {
        return this.f632a != null;
    }

    public boolean b() {
        return this.f633a != null;
    }

    public boolean c() {
        return this.f637b != null;
    }

    public boolean d() {
        return this.f639c != null;
    }

    public boolean e() {
        return this.f635a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gz)) {
            return m546a((gz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f640d != null;
    }

    public boolean g() {
        return this.f641e != null;
    }

    public boolean h() {
        return this.f634a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f634a.get(1);
    }

    public boolean j() {
        return this.f634a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m545a()) {
            sb.append("target:");
            gu guVar = this.f632a;
            if (guVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(guVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("id:");
        String str = this.f633a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f637b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f639c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f635a;
            if (list == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("packageName:");
            String str4 = this.f640d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("category:");
            String str5 = this.f641e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("updateCache:");
            sb.append(this.f636a);
        }
        if (i()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f638b);
        }
        if (j()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f631a);
        }
        sb.append(")");
        return sb.toString();
    }

    public gz a(String str) {
        this.f633a = str;
        return this;
    }

    public gz b(String str) {
        this.f637b = str;
        return this;
    }

    public gz c(String str) {
        this.f639c = str;
        return this;
    }

    public gz d(String str) {
        this.f640d = str;
        return this;
    }

    public gz e(String str) {
        this.f641e = str;
        return this;
    }

    public String a() {
        return this.f639c;
    }

    public void b(boolean z) {
        this.f634a.set(1, z);
    }

    public void c(boolean z) {
        this.f634a.set(2, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m544a(String str) {
        if (this.f635a == null) {
            this.f635a = new ArrayList();
        }
        this.f635a.add(str);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m543a();
        iaVar.a(f630a);
        if (this.f632a != null && m545a()) {
            iaVar.a(f11618a);
            this.f632a.b(iaVar);
            iaVar.b();
        }
        if (this.f633a != null) {
            iaVar.a(b);
            iaVar.a(this.f633a);
            iaVar.b();
        }
        if (this.f637b != null) {
            iaVar.a(c);
            iaVar.a(this.f637b);
            iaVar.b();
        }
        if (this.f639c != null) {
            iaVar.a(d);
            iaVar.a(this.f639c);
            iaVar.b();
        }
        if (this.f635a != null && e()) {
            iaVar.a(e);
            iaVar.a(new hy((byte) 11, this.f635a.size()));
            Iterator<String> it = this.f635a.iterator();
            while (it.hasNext()) {
                iaVar.a(it.next());
            }
            iaVar.e();
            iaVar.b();
        }
        if (this.f640d != null && f()) {
            iaVar.a(f);
            iaVar.a(this.f640d);
            iaVar.b();
        }
        if (this.f641e != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f641e);
            iaVar.b();
        }
        if (h()) {
            iaVar.a(h);
            iaVar.a(this.f636a);
            iaVar.b();
        }
        if (i()) {
            iaVar.a(i);
            iaVar.a(this.f638b);
            iaVar.b();
        }
        if (j()) {
            iaVar.a(j);
            iaVar.a(this.f631a);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    public void a(boolean z) {
        this.f634a.set(0, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m546a(gz gzVar) {
        if (gzVar == null) {
            return false;
        }
        boolean zM545a = m545a();
        boolean zM545a2 = gzVar.m545a();
        if ((zM545a || zM545a2) && !(zM545a && zM545a2 && this.f632a.m531a(gzVar.f632a))) {
            return false;
        }
        boolean zB = b();
        boolean zB2 = gzVar.b();
        if ((zB || zB2) && !(zB && zB2 && this.f633a.equals(gzVar.f633a))) {
            return false;
        }
        boolean zC = c();
        boolean zC2 = gzVar.c();
        if ((zC || zC2) && !(zC && zC2 && this.f637b.equals(gzVar.f637b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = gzVar.d();
        if ((zD || zD2) && !(zD && zD2 && this.f639c.equals(gzVar.f639c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = gzVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f635a.equals(gzVar.f635a))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gzVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f640d.equals(gzVar.f640d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = gzVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f641e.equals(gzVar.f641e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gzVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f636a == gzVar.f636a)) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = gzVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f638b == gzVar.f638b)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = gzVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f631a == gzVar.f631a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gz gzVar) {
        int iA;
        int iA2;
        int iA3;
        int iA4;
        int iA5;
        int iA6;
        int iA7;
        int iA8;
        int iA9;
        int iA10;
        if (!getClass().equals(gzVar.getClass())) {
            return getClass().getName().compareTo(gzVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m545a()).compareTo(Boolean.valueOf(gzVar.m545a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m545a() && (iA10 = hr.a(this.f632a, gzVar.f632a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(gzVar.b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (b() && (iA9 = hr.a(this.f633a, gzVar.f633a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(gzVar.c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (c() && (iA8 = hr.a(this.f637b, gzVar.f637b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(gzVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = hr.a(this.f639c, gzVar.f639c)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gzVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = hr.a(this.f635a, gzVar.f635a)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gzVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = hr.a(this.f640d, gzVar.f640d)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gzVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = hr.a(this.f641e, gzVar.f641e)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gzVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = hr.a(this.f636a, gzVar.f636a)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gzVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = hr.a(this.f638b, gzVar.f638b)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gzVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = hr.a(this.f631a, gzVar.f631a)) == 0) {
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
                m543a();
                return;
            }
            switch (hxVarMo627a.f836a) {
                case 2:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f632a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f633a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f637b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f639c = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 15) {
                        hy hyVarMo628a = iaVar.mo628a();
                        this.f635a = new ArrayList(hyVarMo628a.f837a);
                        for (int i2 = 0; i2 < hyVarMo628a.f837a; i2++) {
                            this.f635a.add(iaVar.mo632a());
                        }
                        iaVar.i();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f640d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                default:
                    id.a(iaVar, b2);
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f641e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 2) {
                        this.f636a = iaVar.mo637a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f638b = iaVar.mo637a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f631a = iaVar.mo626a();
                        c(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m543a() throws ib {
        if (this.f633a != null) {
            if (this.f637b != null) {
                if (this.f639c != null) {
                    return;
                }
                throw new ib("Required field 'cmdName' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
