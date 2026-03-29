package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class gj implements hq<gj, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f508a = new BitSet(3);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f510a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f511b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f512b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f513c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f514d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f515e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f516f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f517g;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f505a = new Cif("ClientUploadDataItem");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11602a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 11, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 10, 4);
    private static final hx e = new hx("", (byte) 10, 5);
    private static final hx f = new hx("", (byte) 2, 6);
    private static final hx g = new hx("", (byte) 11, 7);
    private static final hx h = new hx("", (byte) 11, 8);
    private static final hx i = new hx("", (byte) 11, 9);
    private static final hx j = new hx("", com.umeng.analytics.pro.dn.k, 10);
    private static final hx k = new hx("", (byte) 11, 11);

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m489a() {
    }

    public gj b(String str) {
        this.f512b = str;
        return this;
    }

    public gj c(String str) {
        this.f513c = str;
        return this;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m495d() {
        return this.f508a.get(0);
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public boolean m496e() {
        return this.f508a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gj)) {
            return m492a((gj) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f508a.get(2);
    }

    public boolean g() {
        return this.f514d != null;
    }

    public boolean h() {
        return this.f515e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f516f != null;
    }

    public boolean j() {
        return this.f509a != null;
    }

    public boolean k() {
        return this.f517g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ClientUploadDataItem(");
        boolean z2 = false;
        if (m491a()) {
            sb.append("channel:");
            String str = this.f507a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m493b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("data:");
            String str2 = this.f512b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str2);
            }
            z = false;
        }
        if (m494c()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("name:");
            String str3 = this.f513c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str3);
            }
            z = false;
        }
        if (m495d()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("counter:");
            sb.append(this.f506a);
            z = false;
        }
        if (m496e()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("timestamp:");
            sb.append(this.f511b);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("fromSdk:");
            sb.append(this.f510a);
            z = false;
        }
        if (g()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("category:");
            String str4 = this.f514d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
            z = false;
        }
        if (h()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("sourcePackage:");
            String str5 = this.f515e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
            z = false;
        }
        if (i()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("id:");
            String str6 = this.f516f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
            z = false;
        }
        if (j()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("extra:");
            Map<String, String> map = this.f509a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map);
            }
        } else {
            z2 = z;
        }
        if (k()) {
            if (!z2) {
                sb.append(", ");
            }
            sb.append("pkgName:");
            String str7 = this.f517g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m487a() {
        return this.f507a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m493b() {
        return this.f512b != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m494c() {
        return this.f513c != null;
    }

    public gj d(String str) {
        this.f514d = str;
        return this;
    }

    public gj e(String str) {
        this.f515e = str;
        return this;
    }

    public gj f(String str) {
        this.f516f = str;
        return this;
    }

    public gj g(String str) {
        this.f517g = str;
        return this;
    }

    public gj a(String str) {
        this.f507a = str;
        return this;
    }

    public String b() {
        return this.f513c;
    }

    public void c(boolean z) {
        this.f508a.set(2, z);
    }

    public String d() {
        return this.f516f;
    }

    public String e() {
        return this.f517g;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m491a() {
        return this.f507a != null;
    }

    public gj b(long j2) {
        this.f511b = j2;
        b(true);
        return this;
    }

    public String c() {
        return this.f515e;
    }

    public gj a(long j2) {
        this.f506a = j2;
        m490a(true);
        return this;
    }

    public void b(boolean z) {
        this.f508a.set(1, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m490a(boolean z) {
        this.f508a.set(0, z);
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) {
        m489a();
        iaVar.a(f505a);
        if (this.f507a != null && m491a()) {
            iaVar.a(f11602a);
            iaVar.a(this.f507a);
            iaVar.b();
        }
        if (this.f512b != null && m493b()) {
            iaVar.a(b);
            iaVar.a(this.f512b);
            iaVar.b();
        }
        if (this.f513c != null && m494c()) {
            iaVar.a(c);
            iaVar.a(this.f513c);
            iaVar.b();
        }
        if (m495d()) {
            iaVar.a(d);
            iaVar.a(this.f506a);
            iaVar.b();
        }
        if (m496e()) {
            iaVar.a(e);
            iaVar.a(this.f511b);
            iaVar.b();
        }
        if (f()) {
            iaVar.a(f);
            iaVar.a(this.f510a);
            iaVar.b();
        }
        if (this.f514d != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f514d);
            iaVar.b();
        }
        if (this.f515e != null && h()) {
            iaVar.a(h);
            iaVar.a(this.f515e);
            iaVar.b();
        }
        if (this.f516f != null && i()) {
            iaVar.a(i);
            iaVar.a(this.f516f);
            iaVar.b();
        }
        if (this.f509a != null && j()) {
            iaVar.a(j);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f509a.size()));
            for (Map.Entry<String, String> entry : this.f509a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (this.f517g != null && k()) {
            iaVar.a(k);
            iaVar.a(this.f517g);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    public long a() {
        return this.f511b;
    }

    public gj a(boolean z) {
        this.f510a = z;
        c(true);
        return this;
    }

    public void a(String str, String str2) {
        if (this.f509a == null) {
            this.f509a = new HashMap();
        }
        this.f509a.put(str, str2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> m488a() {
        return this.f509a;
    }

    public gj a(Map<String, String> map) {
        this.f509a = map;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m492a(gj gjVar) {
        if (gjVar == null) {
            return false;
        }
        boolean zM491a = m491a();
        boolean zM491a2 = gjVar.m491a();
        if ((zM491a || zM491a2) && !(zM491a && zM491a2 && this.f507a.equals(gjVar.f507a))) {
            return false;
        }
        boolean zM493b = m493b();
        boolean zM493b2 = gjVar.m493b();
        if ((zM493b || zM493b2) && !(zM493b && zM493b2 && this.f512b.equals(gjVar.f512b))) {
            return false;
        }
        boolean zM494c = m494c();
        boolean zM494c2 = gjVar.m494c();
        if ((zM494c || zM494c2) && !(zM494c && zM494c2 && this.f513c.equals(gjVar.f513c))) {
            return false;
        }
        boolean zM495d = m495d();
        boolean zM495d2 = gjVar.m495d();
        if ((zM495d || zM495d2) && !(zM495d && zM495d2 && this.f506a == gjVar.f506a)) {
            return false;
        }
        boolean zM496e = m496e();
        boolean zM496e2 = gjVar.m496e();
        if ((zM496e || zM496e2) && !(zM496e && zM496e2 && this.f511b == gjVar.f511b)) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gjVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f510a == gjVar.f510a)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = gjVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f514d.equals(gjVar.f514d))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gjVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f515e.equals(gjVar.f515e))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = gjVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f516f.equals(gjVar.f516f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = gjVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f509a.equals(gjVar.f509a))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = gjVar.k();
        if (zK || zK2) {
            return zK && zK2 && this.f517g.equals(gjVar.f517g);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gj gjVar) {
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
        int iA11;
        if (!getClass().equals(gjVar.getClass())) {
            return getClass().getName().compareTo(gjVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m491a()).compareTo(Boolean.valueOf(gjVar.m491a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m491a() && (iA11 = hr.a(this.f507a, gjVar.f507a)) != 0) {
            return iA11;
        }
        int iCompareTo2 = Boolean.valueOf(m493b()).compareTo(Boolean.valueOf(gjVar.m493b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m493b() && (iA10 = hr.a(this.f512b, gjVar.f512b)) != 0) {
            return iA10;
        }
        int iCompareTo3 = Boolean.valueOf(m494c()).compareTo(Boolean.valueOf(gjVar.m494c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m494c() && (iA9 = hr.a(this.f513c, gjVar.f513c)) != 0) {
            return iA9;
        }
        int iCompareTo4 = Boolean.valueOf(m495d()).compareTo(Boolean.valueOf(gjVar.m495d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m495d() && (iA8 = hr.a(this.f506a, gjVar.f506a)) != 0) {
            return iA8;
        }
        int iCompareTo5 = Boolean.valueOf(m496e()).compareTo(Boolean.valueOf(gjVar.m496e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (m496e() && (iA7 = hr.a(this.f511b, gjVar.f511b)) != 0) {
            return iA7;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gjVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA6 = hr.a(this.f510a, gjVar.f510a)) != 0) {
            return iA6;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gjVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA5 = hr.a(this.f514d, gjVar.f514d)) != 0) {
            return iA5;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gjVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA4 = hr.a(this.f515e, gjVar.f515e)) != 0) {
            return iA4;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gjVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA3 = hr.a(this.f516f, gjVar.f516f)) != 0) {
            return iA3;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gjVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA2 = hr.a(this.f509a, gjVar.f509a)) != 0) {
            return iA2;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gjVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (!k() || (iA = hr.a(this.f517g, gjVar.f517g)) == 0) {
            return 0;
        }
        return iA;
    }

    @Override // com.xiaomi.push.hq
    public void a(ia iaVar) {
        iaVar.mo631a();
        while (true) {
            hx hxVarMo627a = iaVar.mo627a();
            byte b2 = hxVarMo627a.f11640a;
            if (b2 == 0) {
                iaVar.f();
                m489a();
                return;
            }
            switch (hxVarMo627a.f836a) {
                case 1:
                    if (b2 == 11) {
                        this.f507a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 11) {
                        this.f512b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f513c = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 10) {
                        this.f506a = iaVar.mo626a();
                        m490a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f511b = iaVar.mo626a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f510a = iaVar.mo637a();
                        c(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f514d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f515e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f516f = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        hz hzVarMo629a = iaVar.mo629a();
                        this.f509a = new HashMap(hzVarMo629a.f838a * 2);
                        for (int i2 = 0; i2 < hzVarMo629a.f838a; i2++) {
                            this.f509a.put(iaVar.mo632a(), iaVar.mo632a());
                        }
                        iaVar.h();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f517g = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                default:
                    id.a(iaVar, b2);
                    break;
            }
            iaVar.g();
        }
    }
}
