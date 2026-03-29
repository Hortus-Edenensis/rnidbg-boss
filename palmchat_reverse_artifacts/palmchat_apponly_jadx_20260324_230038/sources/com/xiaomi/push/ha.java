package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class ha implements hq<ha, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f644a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f645a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<String> f647a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f649b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f650c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f651d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f652e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f653f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f642a = new Cif("XmPushActionCommandResult");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11620a = new hx("", (byte) 12, 2);
    private static final hx b = new hx("", (byte) 11, 3);
    private static final hx c = new hx("", (byte) 11, 4);
    private static final hx d = new hx("", (byte) 11, 5);
    private static final hx e = new hx("", (byte) 10, 7);
    private static final hx f = new hx("", (byte) 11, 8);
    private static final hx g = new hx("", (byte) 11, 9);
    private static final hx h = new hx("", (byte) 15, 10);
    private static final hx i = new hx("", (byte) 11, 12);
    private static final hx j = new hx("", (byte) 2, 13);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f646a = new BitSet(2);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f648a = true;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m549a() {
        return this.f644a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m551b() {
        return this.f645a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m552c() {
        return this.f649b != null;
    }

    public boolean d() {
        return this.f650c != null;
    }

    public boolean e() {
        return this.f646a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ha)) {
            return m550a((ha) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f651d != null;
    }

    public boolean g() {
        return this.f652e != null;
    }

    public boolean h() {
        return this.f647a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f653f != null;
    }

    public boolean j() {
        return this.f646a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m549a()) {
            sb.append("target:");
            gu guVar = this.f644a;
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
        String str = this.f645a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("appId:");
        String str2 = this.f649b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("cmdName:");
        String str3 = this.f650c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("errorCode:");
        sb.append(this.f643a);
        if (f()) {
            sb.append(", ");
            sb.append("reason:");
            String str4 = this.f651d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(", ");
            sb.append("packageName:");
            String str5 = this.f652e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("cmdArgs:");
            List<String> list = this.f647a;
            if (list == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("category:");
            String str6 = this.f653f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("response2Client:");
            sb.append(this.f648a);
        }
        sb.append(")");
        return sb.toString();
    }

    public String a() {
        return this.f645a;
    }

    public String b() {
        return this.f650c;
    }

    public String c() {
        return this.f653f;
    }

    public void a(boolean z) {
        this.f646a.set(0, z);
    }

    public void b(boolean z) {
        this.f646a.set(1, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public List<String> m547a() {
        return this.f647a;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m548a();
        iaVar.a(f642a);
        if (this.f644a != null && m549a()) {
            iaVar.a(f11620a);
            this.f644a.b(iaVar);
            iaVar.b();
        }
        if (this.f645a != null) {
            iaVar.a(b);
            iaVar.a(this.f645a);
            iaVar.b();
        }
        if (this.f649b != null) {
            iaVar.a(c);
            iaVar.a(this.f649b);
            iaVar.b();
        }
        if (this.f650c != null) {
            iaVar.a(d);
            iaVar.a(this.f650c);
            iaVar.b();
        }
        iaVar.a(e);
        iaVar.a(this.f643a);
        iaVar.b();
        if (this.f651d != null && f()) {
            iaVar.a(f);
            iaVar.a(this.f651d);
            iaVar.b();
        }
        if (this.f652e != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f652e);
            iaVar.b();
        }
        if (this.f647a != null && h()) {
            iaVar.a(h);
            iaVar.a(new hy((byte) 11, this.f647a.size()));
            Iterator<String> it = this.f647a.iterator();
            while (it.hasNext()) {
                iaVar.a(it.next());
            }
            iaVar.e();
            iaVar.b();
        }
        if (this.f653f != null && i()) {
            iaVar.a(i);
            iaVar.a(this.f653f);
            iaVar.b();
        }
        if (j()) {
            iaVar.a(j);
            iaVar.a(this.f648a);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m550a(ha haVar) {
        if (haVar == null) {
            return false;
        }
        boolean zM549a = m549a();
        boolean zM549a2 = haVar.m549a();
        if ((zM549a || zM549a2) && !(zM549a && zM549a2 && this.f644a.m531a(haVar.f644a))) {
            return false;
        }
        boolean zM551b = m551b();
        boolean zM551b2 = haVar.m551b();
        if ((zM551b || zM551b2) && !(zM551b && zM551b2 && this.f645a.equals(haVar.f645a))) {
            return false;
        }
        boolean zM552c = m552c();
        boolean zM552c2 = haVar.m552c();
        if ((zM552c || zM552c2) && !(zM552c && zM552c2 && this.f649b.equals(haVar.f649b))) {
            return false;
        }
        boolean zD = d();
        boolean zD2 = haVar.d();
        if (((zD || zD2) && !(zD && zD2 && this.f650c.equals(haVar.f650c))) || this.f643a != haVar.f643a) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = haVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f651d.equals(haVar.f651d))) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = haVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f652e.equals(haVar.f652e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = haVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f647a.equals(haVar.f647a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = haVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f653f.equals(haVar.f653f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = haVar.j();
        if (zJ || zJ2) {
            return zJ && zJ2 && this.f648a == haVar.f648a;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(ha haVar) {
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
        if (!getClass().equals(haVar.getClass())) {
            return getClass().getName().compareTo(haVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m549a()).compareTo(Boolean.valueOf(haVar.m549a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m549a() && (iA10 = hr.a(this.f644a, haVar.f644a)) != 0) {
            return iA10;
        }
        int iCompareTo2 = Boolean.valueOf(m551b()).compareTo(Boolean.valueOf(haVar.m551b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m551b() && (iA9 = hr.a(this.f645a, haVar.f645a)) != 0) {
            return iA9;
        }
        int iCompareTo3 = Boolean.valueOf(m552c()).compareTo(Boolean.valueOf(haVar.m552c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m552c() && (iA8 = hr.a(this.f649b, haVar.f649b)) != 0) {
            return iA8;
        }
        int iCompareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(haVar.d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (d() && (iA7 = hr.a(this.f650c, haVar.f650c)) != 0) {
            return iA7;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(haVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA6 = hr.a(this.f643a, haVar.f643a)) != 0) {
            return iA6;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(haVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA5 = hr.a(this.f651d, haVar.f651d)) != 0) {
            return iA5;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(haVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA4 = hr.a(this.f652e, haVar.f652e)) != 0) {
            return iA4;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(haVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA3 = hr.a(this.f647a, haVar.f647a)) != 0) {
            return iA3;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(haVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA2 = hr.a(this.f653f, haVar.f653f)) != 0) {
            return iA2;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(haVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (!j() || (iA = hr.a(this.f648a, haVar.f648a)) == 0) {
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
                if (e()) {
                    m548a();
                    return;
                }
                throw new ib("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo627a.f836a) {
                case 2:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f644a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f645a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f649b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f650c = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                case 11:
                default:
                    id.a(iaVar, b2);
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f643a = iaVar.mo626a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f651d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f652e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 15) {
                        hy hyVarMo628a = iaVar.mo628a();
                        this.f647a = new ArrayList(hyVarMo628a.f837a);
                        for (int i2 = 0; i2 < hyVarMo628a.f837a; i2++) {
                            this.f647a.add(iaVar.mo632a());
                        }
                        iaVar.i();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f653f = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 13:
                    if (b2 == 2) {
                        this.f648a = iaVar.mo637a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
            }
            iaVar.g();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m548a() throws ib {
        if (this.f645a != null) {
            if (this.f649b != null) {
                if (this.f650c != null) {
                    return;
                }
                throw new ib("Required field 'cmdName' was not present! Struct: " + toString());
            }
            throw new ib("Required field 'appId' was not present! Struct: " + toString());
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
