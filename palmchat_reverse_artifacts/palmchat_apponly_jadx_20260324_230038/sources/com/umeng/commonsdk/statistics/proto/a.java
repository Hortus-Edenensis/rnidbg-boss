package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.Cdo;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.co;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cu;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.dg;
import com.umeng.analytics.pro.dh;
import com.umeng.analytics.pro.dj;
import com.umeng.analytics.pro.dl;
import com.umeng.analytics.pro.dm;
import com.umeng.analytics.pro.dp;
import com.umeng.analytics.pro.dq;
import com.umeng.analytics.pro.dr;
import com.umeng.analytics.pro.ds;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a implements ch<a, e>, Serializable, Cloneable {
    public static final Map<e, ct> e;
    private static final long f = 9132678615281394583L;
    private static final dl g = new dl("IdJournal");
    private static final db h = new db("domain", (byte) 11, 1);
    private static final db i = new db("old_id", (byte) 11, 2);
    private static final db j = new db("new_id", (byte) 11, 3);
    private static final db k = new db("ts", (byte) 10, 4);
    private static final Map<Class<? extends Cdo>, dp> l;
    private static final int m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11094a;
    public String b;
    public String c;
    public long d;
    private byte n;
    private e[] o;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0907a extends dq<a> {
        private C0907a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, a aVar) throws cn {
            dgVar.j();
            while (true) {
                db dbVarL = dgVar.l();
                byte b = dbVarL.b;
                if (b == 0) {
                    break;
                }
                short s = dbVarL.c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            if (s != 4) {
                                dj.a(dgVar, b);
                            } else if (b == 10) {
                                aVar.d = dgVar.x();
                                aVar.d(true);
                            } else {
                                dj.a(dgVar, b);
                            }
                        } else if (b == 11) {
                            aVar.c = dgVar.z();
                            aVar.c(true);
                        } else {
                            dj.a(dgVar, b);
                        }
                    } else if (b == 11) {
                        aVar.b = dgVar.z();
                        aVar.b(true);
                    } else {
                        dj.a(dgVar, b);
                    }
                } else if (b == 11) {
                    aVar.f11094a = dgVar.z();
                    aVar.a(true);
                } else {
                    dj.a(dgVar, b);
                }
                dgVar.m();
            }
            dgVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new dh("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, a aVar) throws cn {
            aVar.n();
            dgVar.a(a.g);
            if (aVar.f11094a != null) {
                dgVar.a(a.h);
                dgVar.a(aVar.f11094a);
                dgVar.c();
            }
            if (aVar.b != null && aVar.g()) {
                dgVar.a(a.i);
                dgVar.a(aVar.b);
                dgVar.c();
            }
            if (aVar.c != null) {
                dgVar.a(a.j);
                dgVar.a(aVar.c);
                dgVar.c();
            }
            dgVar.a(a.k);
            dgVar.a(aVar.d);
            dgVar.c();
            dgVar.d();
            dgVar.b();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements dp {
        private b() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0907a b() {
            return new C0907a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends dr<a> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, a aVar) throws cn {
            dm dmVar = (dm) dgVar;
            dmVar.a(aVar.f11094a);
            dmVar.a(aVar.c);
            dmVar.a(aVar.d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            dmVar.a(bitSet, 1);
            if (aVar.g()) {
                dmVar.a(aVar.b);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, a aVar) throws cn {
            dm dmVar = (dm) dgVar;
            aVar.f11094a = dmVar.z();
            aVar.a(true);
            aVar.c = dmVar.z();
            aVar.c(true);
            aVar.d = dmVar.x();
            aVar.d(true);
            if (dmVar.b(1).get(0)) {
                aVar.b = dmVar.z();
                aVar.b(true);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d implements dp {
        private d() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap map = new HashMap();
        l = map;
        map.put(dq.class, new b());
        map.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.DOMAIN, new ct("domain", (byte) 1, new cu((byte) 11)));
        enumMap.put(e.OLD_ID, new ct("old_id", (byte) 2, new cu((byte) 11)));
        enumMap.put(e.NEW_ID, new ct("new_id", (byte) 1, new cu((byte) 11)));
        enumMap.put(e.TS, new ct("ts", (byte) 1, new cu((byte) 10)));
        Map<e, ct> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        e = mapUnmodifiableMap;
        ct.a(a.class, mapUnmodifiableMap);
    }

    public a() {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.ch
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a deepCopy() {
        return new a(this);
    }

    public String b() {
        return this.f11094a;
    }

    public void c() {
        this.f11094a = null;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.f11094a = null;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0L;
    }

    public boolean d() {
        return this.f11094a != null;
    }

    public String e() {
        return this.b;
    }

    public void f() {
        this.b = null;
    }

    public boolean g() {
        return this.b != null;
    }

    public String h() {
        return this.c;
    }

    public void i() {
        this.c = null;
    }

    public boolean j() {
        return this.c != null;
    }

    public long k() {
        return this.d;
    }

    public void l() {
        this.n = ce.b(this.n, 0);
    }

    public boolean m() {
        return ce.a(this.n, 0);
    }

    public void n() throws cn {
        if (this.f11094a == null) {
            throw new dh("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.c != null) {
            return;
        }
        throw new dh("Required field 'new_id' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) throws cn {
        l.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.f11094a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.b;
            if (str2 == null) {
                sb.append(com.igexin.push.core.b.m);
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) throws cn {
        l.get(dgVar.D()).b().a(dgVar, this);
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum e implements co {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");

        private static final Map<String, e> e = new HashMap();
        private final short f;
        private final String g;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                e.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f = s;
            this.g = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return DOMAIN;
            }
            if (i == 2) {
                return OLD_ID;
            }
            if (i == 3) {
                return NEW_ID;
            }
            if (i != 4) {
                return null;
            }
            return TS;
        }

        public static e b(int i) {
            e eVarA = a(i);
            if (eVarA != null) {
                return eVarA;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.co
        public String b() {
            return this.g;
        }

        public static e a(String str) {
            return e.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.f;
        }
    }

    public a a(String str) {
        this.f11094a = str;
        return this;
    }

    public a b(String str) {
        this.b = str;
        return this;
    }

    public a c(String str) {
        this.c = str;
        return this;
    }

    public void d(boolean z) {
        this.n = ce.a(this.n, 0, z);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f11094a = null;
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.c = null;
    }

    public a(String str, String str2, long j2) {
        this();
        this.f11094a = str;
        this.c = str2;
        this.d = j2;
        d(true);
    }

    public a a(long j2) {
        this.d = j2;
        d(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.ch
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new da(new ds(objectOutputStream)));
        } catch (cn e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public a(a aVar) {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.f11094a = aVar.f11094a;
        }
        if (aVar.g()) {
            this.b = aVar.b;
        }
        if (aVar.j()) {
            this.c = aVar.c;
        }
        this.d = aVar.d;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.n = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
