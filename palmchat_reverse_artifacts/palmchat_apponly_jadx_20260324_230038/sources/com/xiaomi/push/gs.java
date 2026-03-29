package com.xiaomi.push;

import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class gs implements hq<gs, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f567a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f568a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f569a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f570a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f571a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f572b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f573b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Map<String, String> f574b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f575c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f576c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Map<String, String> f577c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f578d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f579e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f565a = new Cif("PushMetaInfo");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11611a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 10, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 11, 5);
    private static final hx f = new hx("", (byte) 8, 6);
    private static final hx g = new hx("", (byte) 11, 7);
    private static final hx h = new hx("", (byte) 8, 8);
    private static final hx i = new hx("", (byte) 8, 9);
    private static final hx j = new hx("", com.umeng.analytics.pro.dn.k, 10);
    private static final hx k = new hx("", com.umeng.analytics.pro.dn.k, 11);
    private static final hx l = new hx("", (byte) 2, 12);
    private static final hx m = new hx("", com.umeng.analytics.pro.dn.k, 13);

    public gs() {
        this.f569a = new BitSet(5);
        this.f571a = false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public gs m518a() {
        return new gs(this);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m526b() {
        return this.f569a.get(0);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m528c() {
        return this.f573b != null;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m529d() {
        return this.f576c != null;
    }

    public boolean e() {
        return this.f578d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof gs)) {
            return m523a((gs) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f569a.get(1);
    }

    public boolean g() {
        return this.f579e != null;
    }

    public boolean h() {
        return this.f569a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f569a.get(3);
    }

    public boolean j() {
        return this.f570a != null;
    }

    public boolean k() {
        return this.f574b != null;
    }

    public boolean l() {
        return this.f571a;
    }

    public boolean m() {
        return this.f569a.get(4);
    }

    public boolean n() {
        return this.f577c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f568a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(com.xiaomi.push.service.aj.a(str));
        }
        sb.append(", ");
        sb.append("messageTs:");
        sb.append(this.f567a);
        if (m528c()) {
            sb.append(", ");
            sb.append("topic:");
            String str2 = this.f573b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str2);
            }
        }
        if (m529d()) {
            sb.append(", ");
            sb.append("title:");
            String str3 = this.f576c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("description:");
            String str4 = this.f578d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(", ");
            sb.append("notifyType:");
            sb.append(this.f566a);
        }
        if (g()) {
            sb.append(", ");
            sb.append("url:");
            String str5 = this.f579e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("passThrough:");
            sb.append(this.f572b);
        }
        if (i()) {
            sb.append(", ");
            sb.append("notifyId:");
            sb.append(this.f575c);
        }
        if (j()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f570a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("internal:");
            Map<String, String> map2 = this.f574b;
            if (map2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("ignoreRegInfo:");
            sb.append(this.f571a);
        }
        if (n()) {
            sb.append(", ");
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f577c;
            if (map3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map3);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m519a() {
        return this.f568a;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m524b() {
        return this.f573b;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public String m527c() {
        return this.f576c;
    }

    public String d() {
        return this.f578d;
    }

    public void e(boolean z) {
        this.f569a.set(4, z);
    }

    public gs a(String str) {
        this.f568a = str;
        return this;
    }

    public gs b(String str) {
        this.f573b = str;
        return this;
    }

    public gs c(String str) {
        this.f576c = str;
        return this;
    }

    public gs d(String str) {
        this.f578d = str;
        return this;
    }

    public gs(gs gsVar) {
        BitSet bitSet = new BitSet(5);
        this.f569a = bitSet;
        bitSet.clear();
        this.f569a.or(gsVar.f569a);
        if (gsVar.m522a()) {
            this.f568a = gsVar.f568a;
        }
        this.f567a = gsVar.f567a;
        if (gsVar.m528c()) {
            this.f573b = gsVar.f573b;
        }
        if (gsVar.m529d()) {
            this.f576c = gsVar.f576c;
        }
        if (gsVar.e()) {
            this.f578d = gsVar.f578d;
        }
        this.f566a = gsVar.f566a;
        if (gsVar.g()) {
            this.f579e = gsVar.f579e;
        }
        this.f572b = gsVar.f572b;
        this.f575c = gsVar.f575c;
        if (gsVar.j()) {
            HashMap map = new HashMap();
            for (Map.Entry<String, String> entry : gsVar.f570a.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
            this.f570a = map;
        }
        if (gsVar.k()) {
            HashMap map2 = new HashMap();
            for (Map.Entry<String, String> entry2 : gsVar.f574b.entrySet()) {
                map2.put(entry2.getKey(), entry2.getValue());
            }
            this.f574b = map2;
        }
        this.f571a = gsVar.f571a;
        if (gsVar.n()) {
            HashMap map3 = new HashMap();
            for (Map.Entry<String, String> entry3 : gsVar.f577c.entrySet()) {
                map3.put(entry3.getKey(), entry3.getValue());
            }
            this.f577c = map3;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m522a() {
        return this.f568a != null;
    }

    public void b(boolean z) {
        this.f569a.set(1, z);
    }

    public void c(boolean z) {
        this.f569a.set(2, z);
    }

    public void d(boolean z) {
        this.f569a.set(3, z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m517a() {
        return this.f567a;
    }

    public int b() {
        return this.f572b;
    }

    public int c() {
        return this.f575c;
    }

    public void a(boolean z) {
        this.f569a.set(0, z);
    }

    public gs b(int i2) {
        this.f572b = i2;
        c(true);
        return this;
    }

    public gs c(int i2) {
        this.f575c = i2;
        d(true);
        return this;
    }

    public int a() {
        return this.f566a;
    }

    public gs a(int i2) {
        this.f566a = i2;
        b(true);
        return this;
    }

    public void b(String str, String str2) {
        if (this.f574b == null) {
            this.f574b = new HashMap();
        }
        this.f574b.put(str, str2);
    }

    public void a(String str, String str2) {
        if (this.f570a == null) {
            this.f570a = new HashMap();
        }
        this.f570a.put(str, str2);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public Map<String, String> m525b() {
        return this.f574b;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m521a();
        iaVar.a(f565a);
        if (this.f568a != null) {
            iaVar.a(f11611a);
            iaVar.a(this.f568a);
            iaVar.b();
        }
        iaVar.a(b);
        iaVar.a(this.f567a);
        iaVar.b();
        if (this.f573b != null && m528c()) {
            iaVar.a(c);
            iaVar.a(this.f573b);
            iaVar.b();
        }
        if (this.f576c != null && m529d()) {
            iaVar.a(d);
            iaVar.a(this.f576c);
            iaVar.b();
        }
        if (this.f578d != null && e()) {
            iaVar.a(e);
            iaVar.a(this.f578d);
            iaVar.b();
        }
        if (f()) {
            iaVar.a(f);
            iaVar.mo636a(this.f566a);
            iaVar.b();
        }
        if (this.f579e != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f579e);
            iaVar.b();
        }
        if (h()) {
            iaVar.a(h);
            iaVar.mo636a(this.f572b);
            iaVar.b();
        }
        if (i()) {
            iaVar.a(i);
            iaVar.mo636a(this.f575c);
            iaVar.b();
        }
        if (this.f570a != null && j()) {
            iaVar.a(j);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f570a.size()));
            for (Map.Entry<String, String> entry : this.f570a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (this.f574b != null && k()) {
            iaVar.a(k);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f574b.size()));
            for (Map.Entry<String, String> entry2 : this.f574b.entrySet()) {
                iaVar.a(entry2.getKey());
                iaVar.a(entry2.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (m()) {
            iaVar.a(l);
            iaVar.a(this.f571a);
            iaVar.b();
        }
        if (this.f577c != null && n()) {
            iaVar.a(m);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f577c.size()));
            for (Map.Entry<String, String> entry3 : this.f577c.entrySet()) {
                iaVar.a(entry3.getKey());
                iaVar.a(entry3.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> m520a() {
        return this.f570a;
    }

    public gs a(Map<String, String> map) {
        this.f570a = map;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m523a(gs gsVar) {
        if (gsVar == null) {
            return false;
        }
        boolean zM522a = m522a();
        boolean zM522a2 = gsVar.m522a();
        if (((zM522a || zM522a2) && !(zM522a && zM522a2 && this.f568a.equals(gsVar.f568a))) || this.f567a != gsVar.f567a) {
            return false;
        }
        boolean zM528c = m528c();
        boolean zM528c2 = gsVar.m528c();
        if ((zM528c || zM528c2) && !(zM528c && zM528c2 && this.f573b.equals(gsVar.f573b))) {
            return false;
        }
        boolean zM529d = m529d();
        boolean zM529d2 = gsVar.m529d();
        if ((zM529d || zM529d2) && !(zM529d && zM529d2 && this.f576c.equals(gsVar.f576c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = gsVar.e();
        if ((zE || zE2) && !(zE && zE2 && this.f578d.equals(gsVar.f578d))) {
            return false;
        }
        boolean zF = f();
        boolean zF2 = gsVar.f();
        if ((zF || zF2) && !(zF && zF2 && this.f566a == gsVar.f566a)) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = gsVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f579e.equals(gsVar.f579e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = gsVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f572b == gsVar.f572b)) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = gsVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f575c == gsVar.f575c)) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = gsVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f570a.equals(gsVar.f570a))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = gsVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f574b.equals(gsVar.f574b))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = gsVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f571a == gsVar.f571a)) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = gsVar.n();
        if (zN || zN2) {
            return zN && zN2 && this.f577c.equals(gsVar.f577c);
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(gs gsVar) {
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
        int iA12;
        int iA13;
        if (!getClass().equals(gsVar.getClass())) {
            return getClass().getName().compareTo(gsVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m522a()).compareTo(Boolean.valueOf(gsVar.m522a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m522a() && (iA13 = hr.a(this.f568a, gsVar.f568a)) != 0) {
            return iA13;
        }
        int iCompareTo2 = Boolean.valueOf(m526b()).compareTo(Boolean.valueOf(gsVar.m526b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m526b() && (iA12 = hr.a(this.f567a, gsVar.f567a)) != 0) {
            return iA12;
        }
        int iCompareTo3 = Boolean.valueOf(m528c()).compareTo(Boolean.valueOf(gsVar.m528c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m528c() && (iA11 = hr.a(this.f573b, gsVar.f573b)) != 0) {
            return iA11;
        }
        int iCompareTo4 = Boolean.valueOf(m529d()).compareTo(Boolean.valueOf(gsVar.m529d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m529d() && (iA10 = hr.a(this.f576c, gsVar.f576c)) != 0) {
            return iA10;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(gsVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA9 = hr.a(this.f578d, gsVar.f578d)) != 0) {
            return iA9;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(gsVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA8 = hr.a(this.f566a, gsVar.f566a)) != 0) {
            return iA8;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(gsVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA7 = hr.a(this.f579e, gsVar.f579e)) != 0) {
            return iA7;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(gsVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA6 = hr.a(this.f572b, gsVar.f572b)) != 0) {
            return iA6;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(gsVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA5 = hr.a(this.f575c, gsVar.f575c)) != 0) {
            return iA5;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(gsVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA4 = hr.a(this.f570a, gsVar.f570a)) != 0) {
            return iA4;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(gsVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA3 = hr.a(this.f574b, gsVar.f574b)) != 0) {
            return iA3;
        }
        int iCompareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(gsVar.m()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (m() && (iA2 = hr.a(this.f571a, gsVar.f571a)) != 0) {
            return iA2;
        }
        int iCompareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(gsVar.n()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (!n() || (iA = hr.a(this.f577c, gsVar.f577c)) == 0) {
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
                if (m526b()) {
                    m521a();
                    return;
                }
                throw new ib("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (hxVarMo627a.f836a) {
                case 1:
                    if (b2 == 11) {
                        this.f568a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 10) {
                        this.f567a = iaVar.mo626a();
                        a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f573b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f576c = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f578d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f566a = iaVar.mo625a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f579e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 8) {
                        this.f572b = iaVar.mo625a();
                        c(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f575c = iaVar.mo625a();
                        d(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        hz hzVarMo629a = iaVar.mo629a();
                        this.f570a = new HashMap(hzVarMo629a.f838a * 2);
                        while (i2 < hzVarMo629a.f838a) {
                            this.f570a.put(iaVar.mo632a(), iaVar.mo632a());
                            i2++;
                        }
                        iaVar.h();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 11:
                    if (b2 == 13) {
                        hz hzVarMo629a2 = iaVar.mo629a();
                        this.f574b = new HashMap(hzVarMo629a2.f838a * 2);
                        while (i2 < hzVarMo629a2.f838a) {
                            this.f574b.put(iaVar.mo632a(), iaVar.mo632a());
                            i2++;
                        }
                        iaVar.h();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 12:
                    if (b2 == 2) {
                        this.f571a = iaVar.mo637a();
                        e(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 13:
                    if (b2 == 13) {
                        hz hzVarMo629a3 = iaVar.mo629a();
                        this.f577c = new HashMap(hzVarMo629a3.f838a * 2);
                        while (i2 < hzVarMo629a3.f838a) {
                            this.f577c.put(iaVar.mo632a(), iaVar.mo632a());
                            i2++;
                        }
                        iaVar.h();
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

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m521a() throws ib {
        if (this.f568a != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
