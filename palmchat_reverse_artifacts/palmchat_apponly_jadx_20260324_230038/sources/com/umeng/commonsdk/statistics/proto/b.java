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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.HTTP;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b implements ch<b, e>, Serializable, Cloneable {
    public static final Map<e, ct> d;
    private static final long e = -6496538196005191531L;
    private static final dl f = new dl("IdSnapshot");
    private static final db g = new db(HTTP.IDENTITY_CODING, (byte) 11, 1);
    private static final db h = new db("ts", (byte) 10, 2);
    private static final db i = new db("version", (byte) 8, 3);
    private static final Map<Class<? extends Cdo>, dp> j;
    private static final int k = 0;
    private static final int l = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f11096a;
    public long b;
    public int c;
    private byte m;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends dq<b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, b bVar) throws cn {
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
                            dj.a(dgVar, b);
                        } else if (b == 8) {
                            bVar.c = dgVar.w();
                            bVar.c(true);
                        } else {
                            dj.a(dgVar, b);
                        }
                    } else if (b == 10) {
                        bVar.b = dgVar.x();
                        bVar.b(true);
                    } else {
                        dj.a(dgVar, b);
                    }
                } else if (b == 11) {
                    bVar.f11096a = dgVar.z();
                    bVar.a(true);
                } else {
                    dj.a(dgVar, b);
                }
                dgVar.m();
            }
            dgVar.k();
            if (!bVar.g()) {
                throw new dh("Required field 'ts' was not found in serialized data! Struct: " + toString());
            }
            if (bVar.j()) {
                bVar.k();
                return;
            }
            throw new dh("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, b bVar) throws cn {
            bVar.k();
            dgVar.a(b.f);
            if (bVar.f11096a != null) {
                dgVar.a(b.g);
                dgVar.a(bVar.f11096a);
                dgVar.c();
            }
            dgVar.a(b.h);
            dgVar.a(bVar.b);
            dgVar.c();
            dgVar.a(b.i);
            dgVar.a(bVar.c);
            dgVar.c();
            dgVar.d();
            dgVar.b();
        }
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.proto.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0908b implements dp {
        private C0908b() {
        }

        @Override // com.umeng.analytics.pro.dp
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends dr<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, b bVar) throws cn {
            dm dmVar = (dm) dgVar;
            dmVar.a(bVar.f11096a);
            dmVar.a(bVar.b);
            dmVar.a(bVar.c);
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, b bVar) throws cn {
            dm dmVar = (dm) dgVar;
            bVar.f11096a = dmVar.z();
            bVar.a(true);
            bVar.b = dmVar.x();
            bVar.b(true);
            bVar.c = dmVar.w();
            bVar.c(true);
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
        j = map;
        map.put(dq.class, new C0908b());
        map.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.IDENTITY, new ct(HTTP.IDENTITY_CODING, (byte) 1, new cu((byte) 11)));
        enumMap.put(e.TS, new ct("ts", (byte) 1, new cu((byte) 10)));
        enumMap.put(e.VERSION, new ct("version", (byte) 1, new cu((byte) 8)));
        Map<e, ct> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        d = mapUnmodifiableMap;
        ct.a(b.class, mapUnmodifiableMap);
    }

    public b() {
        this.m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.ch
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.f11096a;
    }

    public void c() {
        this.f11096a = null;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.f11096a = null;
        b(false);
        this.b = 0L;
        c(false);
        this.c = 0;
    }

    public boolean d() {
        return this.f11096a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.m = ce.b(this.m, 0);
    }

    public boolean g() {
        return ce.a(this.m, 0);
    }

    public int h() {
        return this.c;
    }

    public void i() {
        this.m = ce.b(this.m, 1);
    }

    public boolean j() {
        return ce.a(this.m, 1);
    }

    public void k() throws cn {
        if (this.f11096a != null) {
            return;
        }
        throw new dh("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) throws cn {
        j.get(dgVar.D()).b().b(dgVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.f11096a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) throws cn {
        j.get(dgVar.D()).b().a(dgVar, this);
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum e implements co {
        IDENTITY(1, HTTP.IDENTITY_CODING),
        TS(2, "ts"),
        VERSION(3, "version");

        private static final Map<String, e> d = new HashMap();
        private final short e;
        private final String f;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.e = s;
            this.f = str;
        }

        public static e a(int i) {
            if (i == 1) {
                return IDENTITY;
            }
            if (i == 2) {
                return TS;
            }
            if (i != 3) {
                return null;
            }
            return VERSION;
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
            return this.f;
        }

        public static e a(String str) {
            return d.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.e;
        }
    }

    public b a(String str) {
        this.f11096a = str;
        return this;
    }

    public void b(boolean z) {
        this.m = ce.a(this.m, 0, z);
    }

    public void c(boolean z) {
        this.m = ce.a(this.m, 1, z);
    }

    public b(String str, long j2, int i2) {
        this();
        this.f11096a = str;
        this.b = j2;
        b(true);
        this.c = i2;
        c(true);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.f11096a = null;
    }

    @Override // com.umeng.analytics.pro.ch
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public b a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public b a(int i2) {
        this.c = i2;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new da(new ds(objectOutputStream)));
        } catch (cn e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public b(b bVar) {
        this.m = (byte) 0;
        this.m = bVar.m;
        if (bVar.d()) {
            this.f11096a = bVar.f11096a;
        }
        this.b = bVar.b;
        this.c = bVar.c;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.m = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
