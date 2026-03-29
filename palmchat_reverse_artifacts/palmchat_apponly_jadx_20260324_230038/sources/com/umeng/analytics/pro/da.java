package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class da extends dg {
    private static final dl d = new dl("");
    private static final db e = new db("", (byte) 0, 0);
    private static final byte[] f = {0, 0, 1, 3, 7, 0, 4, 0, 5, 0, 6, 8, 12, 11, 10, 9};
    private static final byte h = -126;
    private static final byte i = 1;
    private static final byte j = 31;
    private static final byte k = -32;
    private static final int l = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    byte[] f10923a;
    byte[] b;
    byte[] c;
    private cf m;
    private short n;
    private db o;
    private Boolean p;
    private final long q;
    private byte[] r;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte f10925a = 1;
        public static final byte b = 2;
        public static final byte c = 3;
        public static final byte d = 4;
        public static final byte e = 5;
        public static final byte f = 6;
        public static final byte g = 7;
        public static final byte h = 8;
        public static final byte i = 9;
        public static final byte j = 10;
        public static final byte k = 11;
        public static final byte l = 12;

        private b() {
        }
    }

    public da(du duVar, long j2) {
        super(duVar);
        this.m = new cf(15);
        this.n = (short) 0;
        this.o = null;
        this.p = null;
        this.f10923a = new byte[5];
        this.b = new byte[10];
        this.r = new byte[1];
        this.c = new byte[1];
        this.q = j2;
    }

    private int E() throws cn {
        int i2 = 0;
        if (this.g.h() >= 5) {
            byte[] bArrF = this.g.f();
            int iG = this.g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                i3 |= (b2 & ByteCompanionObject.MAX_VALUE) << i4;
                if ((b2 & ByteCompanionObject.MIN_VALUE) != 128) {
                    this.g.a(i2 + 1);
                    return i3;
                }
                i4 += 7;
                i2++;
            }
        } else {
            int i5 = 0;
            while (true) {
                byte bU = u();
                i2 |= (bU & ByteCompanionObject.MAX_VALUE) << i5;
                if ((bU & ByteCompanionObject.MIN_VALUE) != 128) {
                    return i2;
                }
                i5 += 7;
            }
        }
    }

    private long F() throws cn {
        int i2 = 0;
        long j2 = 0;
        if (this.g.h() >= 10) {
            byte[] bArrF = this.g.f();
            int iG = this.g.g();
            long j3 = 0;
            int i3 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                j3 |= ((long) (b2 & ByteCompanionObject.MAX_VALUE)) << i3;
                if ((b2 & ByteCompanionObject.MIN_VALUE) != 128) {
                    this.g.a(i2 + 1);
                    return j3;
                }
                i3 += 7;
                i2++;
            }
        } else {
            while (true) {
                byte bU = u();
                j2 |= ((long) (bU & ByteCompanionObject.MAX_VALUE)) << i2;
                if ((bU & ByteCompanionObject.MIN_VALUE) != 128) {
                    return j2;
                }
                i2 += 7;
            }
        }
    }

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private long d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    @Override // com.umeng.analytics.pro.dg
    public ByteBuffer A() throws cn {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[iE];
        this.g.d(bArr, 0, iE);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.dg
    public void B() {
        this.m.c();
        this.n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.dg
    public void a() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public void b() throws cn {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.dg
    public void e() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public void f() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public de h() throws cn {
        byte bU = u();
        if (bU != -126) {
            throw new dh("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(bU));
        }
        byte bU2 = u();
        byte b2 = (byte) (bU2 & 31);
        if (b2 == 1) {
            return new de(z(), (byte) ((bU2 >> 5) & 3), E());
        }
        throw new dh("Expected version 1 but got " + ((int) b2));
    }

    @Override // com.umeng.analytics.pro.dg
    public dl j() throws cn {
        this.m.a(this.n);
        this.n = (short) 0;
        return d;
    }

    @Override // com.umeng.analytics.pro.dg
    public void k() throws cn {
        this.n = this.m.a();
    }

    @Override // com.umeng.analytics.pro.dg
    public db l() throws cn {
        byte bU = u();
        if (bU == 0) {
            return e;
        }
        short s = (short) ((bU & 240) >> 4);
        byte b2 = (byte) (bU & 15);
        db dbVar = new db("", d(b2), s == 0 ? v() : (short) (this.n + s));
        if (c(bU)) {
            this.p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.n = dbVar.c;
        return dbVar;
    }

    @Override // com.umeng.analytics.pro.dg
    public dd n() throws cn {
        int iE = E();
        byte bU = iE == 0 ? (byte) 0 : u();
        return new dd(d((byte) (bU >> 4)), d((byte) (bU & 15)), iE);
    }

    @Override // com.umeng.analytics.pro.dg
    public dc p() throws cn {
        byte bU = u();
        int iE = (bU >> 4) & 15;
        if (iE == 15) {
            iE = E();
        }
        return new dc(d(bU), iE);
    }

    @Override // com.umeng.analytics.pro.dg
    public dk r() throws cn {
        return new dk(p());
    }

    @Override // com.umeng.analytics.pro.dg
    public boolean t() throws cn {
        Boolean bool = this.p;
        if (bool == null) {
            return u() == 1;
        }
        boolean zBooleanValue = bool.booleanValue();
        this.p = null;
        return zBooleanValue;
    }

    @Override // com.umeng.analytics.pro.dg
    public byte u() throws cn {
        if (this.g.h() <= 0) {
            this.g.d(this.c, 0, 1);
            return this.c[0];
        }
        byte b2 = this.g.f()[this.g.g()];
        this.g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.dg
    public short v() throws cn {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.dg
    public int w() throws cn {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.dg
    public long x() throws cn {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.dg
    public double y() throws cn {
        byte[] bArr = new byte[8];
        this.g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.dg
    public String z() throws cn {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return "";
        }
        try {
            if (this.g.h() < iE) {
                return new String(e(iE), "UTF-8");
            }
            String str = new String(this.g.f(), this.g.g(), iE, "UTF-8");
            this.g.a(iE);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new cn("UTF-8 not supported!");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements di {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f10924a;

        public a() {
            this.f10924a = -1L;
        }

        @Override // com.umeng.analytics.pro.di
        public dg a(du duVar) {
            return new da(duVar, this.f10924a);
        }

        public a(int i) {
            this.f10924a = i;
        }
    }

    private void b(int i2) throws cn {
        int i3 = 0;
        while ((i2 & (-128)) != 0) {
            this.f10923a[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i3++;
        }
        byte[] bArr = this.f10923a;
        bArr[i3] = (byte) i2;
        this.g.b(bArr, 0, i3 + 1);
    }

    private long c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    private byte[] e(int i2) throws cn {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) throws dh {
        if (i2 < 0) {
            throw new dh("Negative length: " + i2);
        }
        long j2 = this.q;
        if (j2 == -1 || i2 <= j2) {
            return;
        }
        throw new dh("Length exceeded max allowed: " + i2);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(de deVar) throws cn {
        b(h);
        d(((deVar.b << 5) & (-32)) | 1);
        b(deVar.c);
        a(deVar.f10929a);
    }

    @Override // com.umeng.analytics.pro.dg
    public void d() throws cn {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.dg
    public void g() throws cn {
    }

    private void d(int i2) throws cn {
        b((byte) i2);
    }

    @Override // com.umeng.analytics.pro.dg
    public void c() throws cn {
    }

    private boolean c(byte b2) {
        int i2 = b2 & 15;
        return i2 == 1 || i2 == 2;
    }

    private byte d(byte b2) throws dh {
        byte b3 = (byte) (b2 & 15);
        switch (b3) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return (byte) 15;
            case 10:
                return dn.l;
            case 11:
                return dn.k;
            case 12:
                return (byte) 12;
            default:
                throw new dh("don't know what type: " + ((int) b3));
        }
    }

    private byte e(byte b2) {
        return f[b2];
    }

    private void b(long j2) throws cn {
        int i2 = 0;
        while (((-128) & j2) != 0) {
            this.b[i2] = (byte) ((127 & j2) | 128);
            j2 >>>= 7;
            i2++;
        }
        byte[] bArr = this.b;
        bArr[i2] = (byte) j2;
        this.g.b(bArr, 0, i2 + 1);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dl dlVar) throws cn {
        this.m.a(this.n);
        this.n = (short) 0;
    }

    private void b(byte b2) throws cn {
        byte[] bArr = this.r;
        bArr[0] = b2;
        this.g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(db dbVar) throws cn {
        if (dbVar.b == 2) {
            this.o = dbVar;
        } else {
            a(dbVar, (byte) -1);
        }
    }

    public da(du duVar) {
        this(duVar, -1L);
    }

    private void a(db dbVar, byte b2) throws cn {
        if (b2 == -1) {
            b2 = e(dbVar.b);
        }
        short s = dbVar.c;
        short s2 = this.n;
        if (s > s2 && s - s2 <= 15) {
            d(b2 | ((s - s2) << 4));
        } else {
            b(b2);
            a(dbVar.c);
        }
        this.n = dbVar.c;
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dd ddVar) throws cn {
        int i2 = ddVar.c;
        if (i2 == 0) {
            d(0);
            return;
        }
        b(i2);
        d(e(ddVar.b) | (e(ddVar.f10928a) << 4));
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dc dcVar) throws cn {
        a(dcVar.f10927a, dcVar.b);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dk dkVar) throws cn {
        a(dkVar.f10933a, dkVar.b);
    }

    @Override // com.umeng.analytics.pro.dg
    public void i() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public void m() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public void o() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public void q() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public void s() throws cn {
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(boolean z) throws cn {
        db dbVar = this.o;
        if (dbVar != null) {
            a(dbVar, z ? (byte) 1 : (byte) 2);
            this.o = null;
        } else {
            b(z ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(byte b2) throws cn {
        b(b2);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(short s) throws cn {
        b(c((int) s));
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(int i2) throws cn {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(long j2) throws cn {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(double d2) throws cn {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(String str) throws cn {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new cn("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(ByteBuffer byteBuffer) throws cn {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i2, int i3) throws cn {
        b(i3);
        this.g.b(bArr, i2, i3);
    }

    public void a(byte b2, int i2) throws cn {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
        } else {
            d(e(b2) | 240);
            b(i2);
        }
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >> 56) & 255);
    }

    private long a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (255 & ((long) bArr[0]));
    }
}
