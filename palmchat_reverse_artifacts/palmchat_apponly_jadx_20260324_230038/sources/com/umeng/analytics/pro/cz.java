package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class cz extends dg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final int f10919a = -65536;
    protected static final int b = -2147418112;
    private static final dl h = new dl();
    protected boolean c;
    protected boolean d;
    protected int e;
    protected boolean f;
    private byte[] i;
    private byte[] j;
    private byte[] k;
    private byte[] l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements di {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected boolean f10920a;
        protected boolean b;
        protected int c;

        public a() {
            this(false, true);
        }

        @Override // com.umeng.analytics.pro.di
        public dg a(du duVar) {
            cz czVar = new cz(duVar, this.f10920a, this.b);
            int i = this.c;
            if (i != 0) {
                czVar.c(i);
            }
            return czVar;
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f10920a = z;
            this.b = z2;
            this.c = i;
        }
    }

    public cz(du duVar) {
        this(duVar, false, true);
    }

    @Override // com.umeng.analytics.pro.dg
    public ByteBuffer A() throws cn {
        int iW = w();
        d(iW);
        if (this.g.h() >= iW) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.g.f(), this.g.g(), iW);
            this.g.a(iW);
            return byteBufferWrap;
        }
        byte[] bArr = new byte[iW];
        this.g.d(bArr, 0, iW);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void b() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void c() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void d() throws cn {
        a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.dg
    public de h() throws cn {
        int iW = w();
        if (iW < 0) {
            if (((-65536) & iW) == b) {
                return new de(z(), (byte) (iW & 255), w());
            }
            throw new dh(4, "Bad version in readMessageBegin");
        }
        if (this.c) {
            throw new dh(4, "Missing version in readMessageBegin, old client?");
        }
        return new de(b(iW), u(), w());
    }

    @Override // com.umeng.analytics.pro.dg
    public dl j() {
        return h;
    }

    @Override // com.umeng.analytics.pro.dg
    public db l() throws cn {
        byte bU = u();
        return new db("", bU, bU == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.dg
    public dd n() throws cn {
        return new dd(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.dg
    public dc p() throws cn {
        return new dc(u(), w());
    }

    @Override // com.umeng.analytics.pro.dg
    public dk r() throws cn {
        return new dk(u(), w());
    }

    @Override // com.umeng.analytics.pro.dg
    public boolean t() throws cn {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.dg
    public byte u() throws cn {
        if (this.g.h() < 1) {
            a(this.m, 0, 1);
            return this.m[0];
        }
        byte b2 = this.g.f()[this.g.g()];
        this.g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.dg
    public short v() throws cn {
        int iG;
        byte[] bArrF = this.n;
        if (this.g.h() >= 2) {
            bArrF = this.g.f();
            iG = this.g.g();
            this.g.a(2);
        } else {
            a(this.n, 0, 2);
            iG = 0;
        }
        return (short) ((bArrF[iG + 1] & UByte.MAX_VALUE) | ((bArrF[iG] & UByte.MAX_VALUE) << 8));
    }

    @Override // com.umeng.analytics.pro.dg
    public int w() throws cn {
        int iG;
        byte[] bArrF = this.o;
        if (this.g.h() >= 4) {
            bArrF = this.g.f();
            iG = this.g.g();
            this.g.a(4);
        } else {
            a(this.o, 0, 4);
            iG = 0;
        }
        return (bArrF[iG + 3] & UByte.MAX_VALUE) | ((bArrF[iG] & UByte.MAX_VALUE) << 24) | ((bArrF[iG + 1] & UByte.MAX_VALUE) << 16) | ((bArrF[iG + 2] & UByte.MAX_VALUE) << 8);
    }

    @Override // com.umeng.analytics.pro.dg
    public long x() throws cn {
        int iG;
        byte[] bArrF = this.p;
        if (this.g.h() >= 8) {
            bArrF = this.g.f();
            iG = this.g.g();
            this.g.a(8);
        } else {
            a(this.p, 0, 8);
            iG = 0;
        }
        return ((long) (bArrF[iG + 7] & UByte.MAX_VALUE)) | (((long) (bArrF[iG] & UByte.MAX_VALUE)) << 56) | (((long) (bArrF[iG + 1] & UByte.MAX_VALUE)) << 48) | (((long) (bArrF[iG + 2] & UByte.MAX_VALUE)) << 40) | (((long) (bArrF[iG + 3] & UByte.MAX_VALUE)) << 32) | (((long) (bArrF[iG + 4] & UByte.MAX_VALUE)) << 24) | (((long) (bArrF[iG + 5] & UByte.MAX_VALUE)) << 16) | (((long) (bArrF[iG + 6] & UByte.MAX_VALUE)) << 8);
    }

    @Override // com.umeng.analytics.pro.dg
    public double y() throws cn {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.dg
    public String z() throws cn {
        int iW = w();
        if (this.g.h() < iW) {
            return b(iW);
        }
        try {
            String str = new String(this.g.f(), this.g.g(), iW, "UTF-8");
            this.g.a(iW);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public cz(du duVar, boolean z, boolean z2) {
        super(duVar);
        this.f = false;
        this.i = new byte[1];
        this.j = new byte[2];
        this.k = new byte[4];
        this.l = new byte[8];
        this.m = new byte[1];
        this.n = new byte[2];
        this.o = new byte[4];
        this.p = new byte[8];
        this.c = z;
        this.d = z2;
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dl dlVar) {
    }

    public String b(int i) throws cn {
        try {
            d(i);
            byte[] bArr = new byte[i];
            this.g.d(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void c(int i) {
        this.e = i;
        this.f = true;
    }

    public void d(int i) throws cn {
        if (i < 0) {
            throw new dh("Negative length: " + i);
        }
        if (this.f) {
            int i2 = this.e - i;
            this.e = i2;
            if (i2 >= 0) {
                return;
            }
            throw new dh("Message length exceeded: " + i);
        }
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(de deVar) throws cn {
        if (this.d) {
            a(deVar.b | b);
            a(deVar.f10929a);
            a(deVar.c);
        } else {
            a(deVar.f10929a);
            a(deVar.b);
            a(deVar.c);
        }
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(db dbVar) throws cn {
        a(dbVar.b);
        a(dbVar.c);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dd ddVar) throws cn {
        a(ddVar.f10928a);
        a(ddVar.b);
        a(ddVar.c);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dc dcVar) throws cn {
        a(dcVar.f10927a);
        a(dcVar.b);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(dk dkVar) throws cn {
        a(dkVar.f10933a);
        a(dkVar.b);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(boolean z) throws cn {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(byte b2) throws cn {
        byte[] bArr = this.i;
        bArr[0] = b2;
        this.g.b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.dg
    public void e() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void f() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void g() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void i() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void k() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void m() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void o() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void q() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void s() {
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(short s) throws cn {
        byte[] bArr = this.j;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.g.b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(int i) throws cn {
        byte[] bArr = this.k;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.g.b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(long j) throws cn {
        byte[] bArr = this.l;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        this.g.b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(double d) throws cn {
        a(Double.doubleToLongBits(d));
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(String str) throws cn {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.dg
    public void a(ByteBuffer byteBuffer) throws cn {
        int iLimit = byteBuffer.limit() - byteBuffer.position();
        a(iLimit);
        this.g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), iLimit);
    }

    private int a(byte[] bArr, int i, int i2) throws cn {
        d(i2);
        return this.g.d(bArr, i, i2);
    }
}
