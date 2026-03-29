package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class bu implements ch<bu, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;
    public static final Map<e, ct> k;
    private static final long l = 420342210744516016L;
    private static final dl m = new dl("UMEnvelope");
    private static final db n = new db("version", (byte) 11, 1);
    private static final db o = new db("address", (byte) 11, 2);
    private static final db p = new db(com.umeng.ccg.a.A, (byte) 11, 3);
    private static final db q = new db("serial_num", (byte) 8, 4);
    private static final db r = new db("ts_secs", (byte) 8, 5);
    private static final db s = new db("length", (byte) 8, 6);
    private static final db t = new db("entity", (byte) 11, 7);
    private static final db u = new db("guid", (byte) 11, 8);
    private static final db v = new db("checksum", (byte) 11, 9);
    private static final db w = new db("codex", (byte) 8, 10);
    private static final Map<Class<? extends Cdo>, dp> x;
    private static final int y = 0;
    private static final int z = 1;
    private byte C;
    private e[] D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f10890a;
    public String b;
    public String c;
    public int d;
    public int e;
    public int f;
    public ByteBuffer g;
    public String h;
    public String i;
    public int j;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends dq<bu> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(dg dgVar, bu buVar) throws cn {
            dgVar.j();
            while (true) {
                db dbVarL = dgVar.l();
                byte b = dbVarL.b;
                if (b == 0) {
                    dgVar.k();
                    if (!buVar.m()) {
                        throw new dh("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!buVar.p()) {
                        throw new dh("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (buVar.s()) {
                        buVar.G();
                        return;
                    }
                    throw new dh("Required field 'length' was not found in serialized data! Struct: " + toString());
                }
                switch (dbVarL.c) {
                    case 1:
                        if (b != 11) {
                            dj.a(dgVar, b);
                        } else {
                            buVar.f10890a = dgVar.z();
                            buVar.a(true);
                        }
                        break;
                    case 2:
                        if (b != 11) {
                            dj.a(dgVar, b);
                        } else {
                            buVar.b = dgVar.z();
                            buVar.b(true);
                        }
                        break;
                    case 3:
                        if (b != 11) {
                            dj.a(dgVar, b);
                        } else {
                            buVar.c = dgVar.z();
                            buVar.c(true);
                        }
                        break;
                    case 4:
                        if (b != 8) {
                            dj.a(dgVar, b);
                        } else {
                            buVar.d = dgVar.w();
                            buVar.d(true);
                        }
                        break;
                    case 5:
                        if (b != 8) {
                            dj.a(dgVar, b);
                        } else {
                            buVar.e = dgVar.w();
                            buVar.e(true);
                        }
                        break;
                    case 6:
                        if (b != 8) {
                            dj.a(dgVar, b);
                        } else {
                            buVar.f = dgVar.w();
                            buVar.f(true);
                        }
                        break;
                    case 7:
                        if (b != 11) {
                            dj.a(dgVar, b);
                        } else {
                            buVar.g = dgVar.A();
                            buVar.g(true);
                        }
                        break;
                    case 8:
                        if (b != 11) {
                            dj.a(dgVar, b);
                        } else {
                            buVar.h = dgVar.z();
                            buVar.h(true);
                        }
                        break;
                    case 9:
                        if (b != 11) {
                            dj.a(dgVar, b);
                        } else {
                            buVar.i = dgVar.z();
                            buVar.i(true);
                        }
                        break;
                    case 10:
                        if (b != 8) {
                            dj.a(dgVar, b);
                        } else {
                            buVar.j = dgVar.w();
                            buVar.j(true);
                        }
                        break;
                    default:
                        dj.a(dgVar, b);
                        break;
                }
                dgVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(dg dgVar, bu buVar) throws cn {
            buVar.G();
            dgVar.a(bu.m);
            if (buVar.f10890a != null) {
                dgVar.a(bu.n);
                dgVar.a(buVar.f10890a);
                dgVar.c();
            }
            if (buVar.b != null) {
                dgVar.a(bu.o);
                dgVar.a(buVar.b);
                dgVar.c();
            }
            if (buVar.c != null) {
                dgVar.a(bu.p);
                dgVar.a(buVar.c);
                dgVar.c();
            }
            dgVar.a(bu.q);
            dgVar.a(buVar.d);
            dgVar.c();
            dgVar.a(bu.r);
            dgVar.a(buVar.e);
            dgVar.c();
            dgVar.a(bu.s);
            dgVar.a(buVar.f);
            dgVar.c();
            if (buVar.g != null) {
                dgVar.a(bu.t);
                dgVar.a(buVar.g);
                dgVar.c();
            }
            if (buVar.h != null) {
                dgVar.a(bu.u);
                dgVar.a(buVar.h);
                dgVar.c();
            }
            if (buVar.i != null) {
                dgVar.a(bu.v);
                dgVar.a(buVar.i);
                dgVar.c();
            }
            if (buVar.F()) {
                dgVar.a(bu.w);
                dgVar.a(buVar.j);
                dgVar.c();
            }
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
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends dr<bu> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void a(dg dgVar, bu buVar) throws cn {
            dm dmVar = (dm) dgVar;
            dmVar.a(buVar.f10890a);
            dmVar.a(buVar.b);
            dmVar.a(buVar.c);
            dmVar.a(buVar.d);
            dmVar.a(buVar.e);
            dmVar.a(buVar.f);
            dmVar.a(buVar.g);
            dmVar.a(buVar.h);
            dmVar.a(buVar.i);
            BitSet bitSet = new BitSet();
            if (buVar.F()) {
                bitSet.set(0);
            }
            dmVar.a(bitSet, 1);
            if (buVar.F()) {
                dmVar.a(buVar.j);
            }
        }

        @Override // com.umeng.analytics.pro.Cdo
        public void b(dg dgVar, bu buVar) throws cn {
            dm dmVar = (dm) dgVar;
            buVar.f10890a = dmVar.z();
            buVar.a(true);
            buVar.b = dmVar.z();
            buVar.b(true);
            buVar.c = dmVar.z();
            buVar.c(true);
            buVar.d = dmVar.w();
            buVar.d(true);
            buVar.e = dmVar.w();
            buVar.e(true);
            buVar.f = dmVar.w();
            buVar.f(true);
            buVar.g = dmVar.A();
            buVar.g(true);
            buVar.h = dmVar.z();
            buVar.h(true);
            buVar.i = dmVar.z();
            buVar.i(true);
            if (dmVar.b(1).get(0)) {
                buVar.j = dmVar.w();
                buVar.j(true);
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
        x = map;
        map.put(dq.class, new b());
        map.put(dr.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put(e.VERSION, new ct("version", (byte) 1, new cu((byte) 11)));
        enumMap.put(e.ADDRESS, new ct("address", (byte) 1, new cu((byte) 11)));
        enumMap.put(e.SIGNATURE, new ct(com.umeng.ccg.a.A, (byte) 1, new cu((byte) 11)));
        enumMap.put(e.SERIAL_NUM, new ct("serial_num", (byte) 1, new cu((byte) 8)));
        enumMap.put(e.TS_SECS, new ct("ts_secs", (byte) 1, new cu((byte) 8)));
        enumMap.put(e.LENGTH, new ct("length", (byte) 1, new cu((byte) 8)));
        enumMap.put(e.ENTITY, new ct("entity", (byte) 1, new cu((byte) 11, true)));
        enumMap.put(e.GUID, new ct("guid", (byte) 1, new cu((byte) 11)));
        enumMap.put(e.CHECKSUM, new ct("checksum", (byte) 1, new cu((byte) 11)));
        enumMap.put(e.CODEX, new ct("codex", (byte) 2, new cu((byte) 8)));
        Map<e, ct> mapUnmodifiableMap = Collections.unmodifiableMap(enumMap);
        k = mapUnmodifiableMap;
        ct.a(bu.class, mapUnmodifiableMap);
    }

    public bu() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public String A() {
        return this.i;
    }

    public void B() {
        this.i = null;
    }

    public boolean C() {
        return this.i != null;
    }

    public int D() {
        return this.j;
    }

    public void E() {
        this.C = ce.b(this.C, 3);
    }

    public boolean F() {
        return ce.a(this.C, 3);
    }

    public void G() throws cn {
        if (this.f10890a == null) {
            throw new dh("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.b == null) {
            throw new dh("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.c == null) {
            throw new dh("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.g == null) {
            throw new dh("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.h == null) {
            throw new dh("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.i != null) {
            return;
        }
        throw new dh("Required field 'checksum' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.ch
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public bu deepCopy() {
        return new bu(this);
    }

    public String b() {
        return this.f10890a;
    }

    public void c() {
        this.f10890a = null;
    }

    @Override // com.umeng.analytics.pro.ch
    public void clear() {
        this.f10890a = null;
        this.b = null;
        this.c = null;
        d(false);
        this.d = 0;
        e(false);
        this.e = 0;
        f(false);
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
        j(false);
        this.j = 0;
    }

    public boolean d() {
        return this.f10890a != null;
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

    public int k() {
        return this.d;
    }

    public void l() {
        this.C = ce.b(this.C, 0);
    }

    public boolean m() {
        return ce.a(this.C, 0);
    }

    public int n() {
        return this.e;
    }

    public void o() {
        this.C = ce.b(this.C, 1);
    }

    public boolean p() {
        return ce.a(this.C, 1);
    }

    public int q() {
        return this.f;
    }

    public void r() {
        this.C = ce.b(this.C, 2);
    }

    @Override // com.umeng.analytics.pro.ch
    public void read(dg dgVar) throws cn {
        x.get(dgVar.D()).b().b(dgVar, this);
    }

    public boolean s() {
        return ce.a(this.C, 2);
    }

    public byte[] t() {
        a(ci.c(this.g));
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f10890a;
        if (str == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.b;
        if (str2 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.c;
        if (str3 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.g;
        if (byteBuffer == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            ci.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.h;
        if (str4 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.i;
        if (str5 == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.j);
        }
        sb.append(")");
        return sb.toString();
    }

    public ByteBuffer u() {
        return this.g;
    }

    public void v() {
        this.g = null;
    }

    public boolean w() {
        return this.g != null;
    }

    @Override // com.umeng.analytics.pro.ch
    public void write(dg dgVar) throws cn {
        x.get(dgVar.D()).b().a(dgVar, this);
    }

    public String x() {
        return this.h;
    }

    public void y() {
        this.h = null;
    }

    public boolean z() {
        return this.h != null;
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum e implements co {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, com.umeng.ccg.a.A),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");

        private static final Map<String, e> k = new HashMap();
        private final short l;
        private final String m;

        static {
            for (e eVar : EnumSet.allOf(e.class)) {
                k.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.l = s;
            this.m = str;
        }

        public static e a(int i) {
            switch (i) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
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
            return this.m;
        }

        public static e a(String str) {
            return k.get(str);
        }

        @Override // com.umeng.analytics.pro.co
        public short a() {
            return this.l;
        }
    }

    public bu a(String str) {
        this.f10890a = str;
        return this;
    }

    public bu b(String str) {
        this.b = str;
        return this;
    }

    public bu c(String str) {
        this.c = str;
        return this;
    }

    public void d(boolean z2) {
        this.C = ce.a(this.C, 0, z2);
    }

    public void e(boolean z2) {
        this.C = ce.a(this.C, 1, z2);
    }

    public void f(boolean z2) {
        this.C = ce.a(this.C, 2, z2);
    }

    public void g(boolean z2) {
        if (z2) {
            return;
        }
        this.g = null;
    }

    public void h(boolean z2) {
        if (z2) {
            return;
        }
        this.h = null;
    }

    public void i(boolean z2) {
        if (z2) {
            return;
        }
        this.i = null;
    }

    public void j(boolean z2) {
        this.C = ce.a(this.C, 3, z2);
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.f10890a = null;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.b = null;
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.c = null;
    }

    public bu d(String str) {
        this.h = str;
        return this;
    }

    public bu e(String str) {
        this.i = str;
        return this;
    }

    public bu(String str, String str2, String str3, int i, int i2, int i3, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f10890a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        d(true);
        this.e = i2;
        e(true);
        this.f = i3;
        f(true);
        this.g = byteBuffer;
        this.h = str4;
        this.i = str5;
    }

    public bu a(int i) {
        this.d = i;
        d(true);
        return this;
    }

    public bu b(int i) {
        this.e = i;
        e(true);
        return this;
    }

    public bu c(int i) {
        this.f = i;
        f(true);
        return this;
    }

    public bu d(int i) {
        this.j = i;
        j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.ch
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public e fieldForId(int i) {
        return e.a(i);
    }

    public bu a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public bu a(ByteBuffer byteBuffer) {
        this.g = byteBuffer;
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new da(new ds(objectOutputStream)));
        } catch (cn e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.C = (byte) 0;
            read(new da(new ds(objectInputStream)));
        } catch (cn e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public bu(bu buVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = buVar.C;
        if (buVar.d()) {
            this.f10890a = buVar.f10890a;
        }
        if (buVar.g()) {
            this.b = buVar.b;
        }
        if (buVar.j()) {
            this.c = buVar.c;
        }
        this.d = buVar.d;
        this.e = buVar.e;
        this.f = buVar.f;
        if (buVar.w()) {
            this.g = ci.d(buVar.g);
        }
        if (buVar.z()) {
            this.h = buVar.h;
        }
        if (buVar.C()) {
            this.i = buVar.i;
        }
        this.j = buVar.j;
    }
}
