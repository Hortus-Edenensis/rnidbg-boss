package com.xiaomi.push;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class he implements hq<he, Object>, Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f669a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gu f670a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f671a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer f672a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private BitSet f673a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f674a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f675a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f676b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f677b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f678c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public String f679d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public String f680e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public String f681f;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public String f682g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public String f683h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public String f684i;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final Cif f668a = new Cif("XmPushActionNotification");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final hx f11624a = new hx("", (byte) 11, 1);
    private static final hx b = new hx("", (byte) 12, 2);
    private static final hx c = new hx("", (byte) 11, 3);
    private static final hx d = new hx("", (byte) 11, 4);
    private static final hx e = new hx("", (byte) 11, 5);
    private static final hx f = new hx("", (byte) 2, 6);
    private static final hx g = new hx("", (byte) 11, 7);
    private static final hx h = new hx("", com.umeng.analytics.pro.dn.k, 8);
    private static final hx i = new hx("", (byte) 11, 9);
    private static final hx j = new hx("", (byte) 11, 10);
    private static final hx k = new hx("", (byte) 11, 12);
    private static final hx l = new hx("", (byte) 11, 13);
    private static final hx m = new hx("", (byte) 11, 14);
    private static final hx n = new hx("", (byte) 10, 15);
    private static final hx o = new hx("", (byte) 2, 20);

    public he() {
        this.f673a = new BitSet(3);
        this.f675a = true;
        this.f677b = false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m572a() {
        return this.f671a != null;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m575b() {
        return this.f670a != null;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m576c() {
        return this.f676b != null;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m577d() {
        return this.f678c != null;
    }

    public boolean e() {
        return this.f679d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof he)) {
            return m573a((he) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f673a.get(0);
    }

    public boolean g() {
        return this.f680e != null;
    }

    public boolean h() {
        return this.f674a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f681f != null;
    }

    public boolean j() {
        return this.f682g != null;
    }

    public boolean k() {
        return this.f683h != null;
    }

    public boolean l() {
        return this.f684i != null;
    }

    public boolean m() {
        return this.f672a != null;
    }

    public boolean n() {
        return this.f673a.get(1);
    }

    public boolean o() {
        return this.f673a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = false;
        if (m572a()) {
            sb.append("debug:");
            String str = this.f671a;
            if (str == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m575b()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append("target:");
            gu guVar = this.f670a;
            if (guVar == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(guVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(", ");
        }
        sb.append("id:");
        String str2 = this.f676b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        if (m577d()) {
            sb.append(", ");
            sb.append("appId:");
            String str3 = this.f678c;
            if (str3 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(", ");
            sb.append("type:");
            String str4 = this.f679d;
            if (str4 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str4);
            }
        }
        sb.append(", ");
        sb.append("requireAck:");
        sb.append(this.f675a);
        if (g()) {
            sb.append(", ");
            sb.append("payload:");
            String str5 = this.f680e;
            if (str5 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(", ");
            sb.append("extra:");
            Map<String, String> map = this.f674a;
            if (map == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(", ");
            sb.append("packageName:");
            String str6 = this.f681f;
            if (str6 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(", ");
            sb.append("category:");
            String str7 = this.f682g;
            if (str7 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(", ");
            sb.append("regId:");
            String str8 = this.f683h;
            if (str8 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(", ");
            sb.append("aliasName:");
            String str9 = this.f684i;
            if (str9 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f672a;
            if (byteBuffer == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                hr.a(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(", ");
            sb.append("createdTs:");
            sb.append(this.f669a);
        }
        if (o()) {
            sb.append(", ");
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f677b);
        }
        sb.append(")");
        return sb.toString();
    }

    public gu a() {
        return this.f670a;
    }

    public String b() {
        return this.f678c;
    }

    public String c() {
        return this.f679d;
    }

    public String d() {
        return this.f681f;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m568a() {
        return this.f676b;
    }

    public he b(String str) {
        this.f678c = str;
        return this;
    }

    public he c(String str) {
        this.f679d = str;
        return this;
    }

    public he d(String str) {
        this.f681f = str;
        return this;
    }

    public he a(String str) {
        this.f676b = str;
        return this;
    }

    public void b(boolean z) {
        this.f673a.set(1, z);
    }

    public void c(boolean z) {
        this.f673a.set(2, z);
    }

    public he(String str, boolean z) {
        this();
        this.f676b = str;
        this.f675a = z;
        m571a(true);
    }

    public he a(boolean z) {
        this.f675a = z;
        m571a(true);
        return this;
    }

    @Override // com.xiaomi.push.hq
    public void b(ia iaVar) throws ib {
        m570a();
        iaVar.a(f668a);
        if (this.f671a != null && m572a()) {
            iaVar.a(f11624a);
            iaVar.a(this.f671a);
            iaVar.b();
        }
        if (this.f670a != null && m575b()) {
            iaVar.a(b);
            this.f670a.b(iaVar);
            iaVar.b();
        }
        if (this.f676b != null) {
            iaVar.a(c);
            iaVar.a(this.f676b);
            iaVar.b();
        }
        if (this.f678c != null && m577d()) {
            iaVar.a(d);
            iaVar.a(this.f678c);
            iaVar.b();
        }
        if (this.f679d != null && e()) {
            iaVar.a(e);
            iaVar.a(this.f679d);
            iaVar.b();
        }
        iaVar.a(f);
        iaVar.a(this.f675a);
        iaVar.b();
        if (this.f680e != null && g()) {
            iaVar.a(g);
            iaVar.a(this.f680e);
            iaVar.b();
        }
        if (this.f674a != null && h()) {
            iaVar.a(h);
            iaVar.a(new hz((byte) 11, (byte) 11, this.f674a.size()));
            for (Map.Entry<String, String> entry : this.f674a.entrySet()) {
                iaVar.a(entry.getKey());
                iaVar.a(entry.getValue());
            }
            iaVar.d();
            iaVar.b();
        }
        if (this.f681f != null && i()) {
            iaVar.a(i);
            iaVar.a(this.f681f);
            iaVar.b();
        }
        if (this.f682g != null && j()) {
            iaVar.a(j);
            iaVar.a(this.f682g);
            iaVar.b();
        }
        if (this.f683h != null && k()) {
            iaVar.a(k);
            iaVar.a(this.f683h);
            iaVar.b();
        }
        if (this.f684i != null && l()) {
            iaVar.a(l);
            iaVar.a(this.f684i);
            iaVar.b();
        }
        if (this.f672a != null && m()) {
            iaVar.a(m);
            iaVar.a(this.f672a);
            iaVar.b();
        }
        if (n()) {
            iaVar.a(n);
            iaVar.a(this.f669a);
            iaVar.b();
        }
        if (o()) {
            iaVar.a(o);
            iaVar.a(this.f677b);
            iaVar.b();
        }
        iaVar.c();
        iaVar.mo635a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m571a(boolean z) {
        this.f673a.set(0, z);
    }

    public void a(String str, String str2) {
        if (this.f674a == null) {
            this.f674a = new HashMap();
        }
        this.f674a.put(str, str2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Map<String, String> m569a() {
        return this.f674a;
    }

    public he a(Map<String, String> map) {
        this.f674a = map;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m574a() {
        a(hr.a(this.f672a));
        return this.f672a.array();
    }

    public he a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    public he a(ByteBuffer byteBuffer) {
        this.f672a = byteBuffer;
        return this;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m573a(he heVar) {
        if (heVar == null) {
            return false;
        }
        boolean zM572a = m572a();
        boolean zM572a2 = heVar.m572a();
        if ((zM572a || zM572a2) && !(zM572a && zM572a2 && this.f671a.equals(heVar.f671a))) {
            return false;
        }
        boolean zM575b = m575b();
        boolean zM575b2 = heVar.m575b();
        if ((zM575b || zM575b2) && !(zM575b && zM575b2 && this.f670a.m531a(heVar.f670a))) {
            return false;
        }
        boolean zM576c = m576c();
        boolean zM576c2 = heVar.m576c();
        if ((zM576c || zM576c2) && !(zM576c && zM576c2 && this.f676b.equals(heVar.f676b))) {
            return false;
        }
        boolean zM577d = m577d();
        boolean zM577d2 = heVar.m577d();
        if ((zM577d || zM577d2) && !(zM577d && zM577d2 && this.f678c.equals(heVar.f678c))) {
            return false;
        }
        boolean zE = e();
        boolean zE2 = heVar.e();
        if (((zE || zE2) && !(zE && zE2 && this.f679d.equals(heVar.f679d))) || this.f675a != heVar.f675a) {
            return false;
        }
        boolean zG = g();
        boolean zG2 = heVar.g();
        if ((zG || zG2) && !(zG && zG2 && this.f680e.equals(heVar.f680e))) {
            return false;
        }
        boolean zH = h();
        boolean zH2 = heVar.h();
        if ((zH || zH2) && !(zH && zH2 && this.f674a.equals(heVar.f674a))) {
            return false;
        }
        boolean zI = i();
        boolean zI2 = heVar.i();
        if ((zI || zI2) && !(zI && zI2 && this.f681f.equals(heVar.f681f))) {
            return false;
        }
        boolean zJ = j();
        boolean zJ2 = heVar.j();
        if ((zJ || zJ2) && !(zJ && zJ2 && this.f682g.equals(heVar.f682g))) {
            return false;
        }
        boolean zK = k();
        boolean zK2 = heVar.k();
        if ((zK || zK2) && !(zK && zK2 && this.f683h.equals(heVar.f683h))) {
            return false;
        }
        boolean zL = l();
        boolean zL2 = heVar.l();
        if ((zL || zL2) && !(zL && zL2 && this.f684i.equals(heVar.f684i))) {
            return false;
        }
        boolean zM = m();
        boolean zM2 = heVar.m();
        if ((zM || zM2) && !(zM && zM2 && this.f672a.equals(heVar.f672a))) {
            return false;
        }
        boolean zN = n();
        boolean zN2 = heVar.n();
        if ((zN || zN2) && !(zN && zN2 && this.f669a == heVar.f669a)) {
            return false;
        }
        boolean zO = o();
        boolean zO2 = heVar.o();
        if (zO || zO2) {
            return zO && zO2 && this.f677b == heVar.f677b;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(he heVar) {
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
        int iA14;
        int iA15;
        if (!getClass().equals(heVar.getClass())) {
            return getClass().getName().compareTo(heVar.getClass().getName());
        }
        int iCompareTo = Boolean.valueOf(m572a()).compareTo(Boolean.valueOf(heVar.m572a()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (m572a() && (iA15 = hr.a(this.f671a, heVar.f671a)) != 0) {
            return iA15;
        }
        int iCompareTo2 = Boolean.valueOf(m575b()).compareTo(Boolean.valueOf(heVar.m575b()));
        if (iCompareTo2 != 0) {
            return iCompareTo2;
        }
        if (m575b() && (iA14 = hr.a(this.f670a, heVar.f670a)) != 0) {
            return iA14;
        }
        int iCompareTo3 = Boolean.valueOf(m576c()).compareTo(Boolean.valueOf(heVar.m576c()));
        if (iCompareTo3 != 0) {
            return iCompareTo3;
        }
        if (m576c() && (iA13 = hr.a(this.f676b, heVar.f676b)) != 0) {
            return iA13;
        }
        int iCompareTo4 = Boolean.valueOf(m577d()).compareTo(Boolean.valueOf(heVar.m577d()));
        if (iCompareTo4 != 0) {
            return iCompareTo4;
        }
        if (m577d() && (iA12 = hr.a(this.f678c, heVar.f678c)) != 0) {
            return iA12;
        }
        int iCompareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(heVar.e()));
        if (iCompareTo5 != 0) {
            return iCompareTo5;
        }
        if (e() && (iA11 = hr.a(this.f679d, heVar.f679d)) != 0) {
            return iA11;
        }
        int iCompareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(heVar.f()));
        if (iCompareTo6 != 0) {
            return iCompareTo6;
        }
        if (f() && (iA10 = hr.a(this.f675a, heVar.f675a)) != 0) {
            return iA10;
        }
        int iCompareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(heVar.g()));
        if (iCompareTo7 != 0) {
            return iCompareTo7;
        }
        if (g() && (iA9 = hr.a(this.f680e, heVar.f680e)) != 0) {
            return iA9;
        }
        int iCompareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(heVar.h()));
        if (iCompareTo8 != 0) {
            return iCompareTo8;
        }
        if (h() && (iA8 = hr.a(this.f674a, heVar.f674a)) != 0) {
            return iA8;
        }
        int iCompareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(heVar.i()));
        if (iCompareTo9 != 0) {
            return iCompareTo9;
        }
        if (i() && (iA7 = hr.a(this.f681f, heVar.f681f)) != 0) {
            return iA7;
        }
        int iCompareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(heVar.j()));
        if (iCompareTo10 != 0) {
            return iCompareTo10;
        }
        if (j() && (iA6 = hr.a(this.f682g, heVar.f682g)) != 0) {
            return iA6;
        }
        int iCompareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(heVar.k()));
        if (iCompareTo11 != 0) {
            return iCompareTo11;
        }
        if (k() && (iA5 = hr.a(this.f683h, heVar.f683h)) != 0) {
            return iA5;
        }
        int iCompareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(heVar.l()));
        if (iCompareTo12 != 0) {
            return iCompareTo12;
        }
        if (l() && (iA4 = hr.a(this.f684i, heVar.f684i)) != 0) {
            return iA4;
        }
        int iCompareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(heVar.m()));
        if (iCompareTo13 != 0) {
            return iCompareTo13;
        }
        if (m() && (iA3 = hr.a(this.f672a, heVar.f672a)) != 0) {
            return iA3;
        }
        int iCompareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(heVar.n()));
        if (iCompareTo14 != 0) {
            return iCompareTo14;
        }
        if (n() && (iA2 = hr.a(this.f669a, heVar.f669a)) != 0) {
            return iA2;
        }
        int iCompareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(heVar.o()));
        if (iCompareTo15 != 0) {
            return iCompareTo15;
        }
        if (!o() || (iA = hr.a(this.f677b, heVar.f677b)) == 0) {
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
                if (f()) {
                    m570a();
                    return;
                }
                throw new ib("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (hxVarMo627a.f836a) {
                case 1:
                    if (b2 == 11) {
                        this.f671a = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        gu guVar = new gu();
                        this.f670a = guVar;
                        guVar.a(iaVar);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f676b = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f678c = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f679d = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f675a = iaVar.mo637a();
                        m571a(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f680e = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 8:
                    if (b2 == 13) {
                        hz hzVarMo629a = iaVar.mo629a();
                        this.f674a = new HashMap(hzVarMo629a.f838a * 2);
                        for (int i2 = 0; i2 < hzVarMo629a.f838a; i2++) {
                            this.f674a.put(iaVar.mo632a(), iaVar.mo632a());
                        }
                        iaVar.h();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f681f = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f682g = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 11:
                case 16:
                case 17:
                case 18:
                case 19:
                default:
                    id.a(iaVar, b2);
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f683h = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f684i = iaVar.mo632a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f672a = iaVar.mo633a();
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 15:
                    if (b2 == 10) {
                        this.f669a = iaVar.mo626a();
                        b(true);
                    } else {
                        id.a(iaVar, b2);
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f677b = iaVar.mo637a();
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
    public void m570a() throws ib {
        if (this.f676b != null) {
            return;
        }
        throw new ib("Required field 'id' was not present! Struct: " + toString());
    }
}
