package com.xiaomi.push;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class hw extends ia {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Cif f11638a = new Cif();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected int f829a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected boolean f830a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f831a;
    protected boolean b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private byte[] f832b;
    protected boolean c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private byte[] f833c;
    private byte[] d;
    private byte[] e;
    private byte[] f;
    private byte[] g;
    private byte[] h;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements ic {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected int f11639a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        protected boolean f834a;
        protected boolean b;

        public a() {
            this(false, true);
        }

        @Override // com.xiaomi.push.ic
        public ia a(ik ikVar) {
            hw hwVar = new hw(ikVar, this.f834a, this.b);
            int i = this.f11639a;
            if (i != 0) {
                hwVar.b(i);
            }
            return hwVar;
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f834a = z;
            this.b = z2;
            this.f11639a = i;
        }
    }

    public hw(ik ikVar, boolean z, boolean z2) {
        super(ikVar);
        this.c = false;
        this.f831a = new byte[1];
        this.f832b = new byte[2];
        this.f833c = new byte[4];
        this.d = new byte[8];
        this.e = new byte[1];
        this.f = new byte[2];
        this.g = new byte[4];
        this.h = new byte[8];
        this.f830a = z;
        this.b = z2;
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo635a() {
    }

    @Override // com.xiaomi.push.ia
    public void b() {
    }

    @Override // com.xiaomi.push.ia
    public void c() {
        a((byte) 0);
    }

    @Override // com.xiaomi.push.ia
    public void a(Cif cif) {
    }

    public void b(int i) {
        this.f829a = i;
        this.c = true;
    }

    public void c(int i) throws hu {
        if (i < 0) {
            throw new hu("Negative length: " + i);
        }
        if (this.c) {
            int i2 = this.f829a - i;
            this.f829a = i2;
            if (i2 >= 0) {
                return;
            }
            throw new hu("Message length exceeded: " + i);
        }
    }

    @Override // com.xiaomi.push.ia
    public void a(hx hxVar) {
        a(hxVar.f11640a);
        a(hxVar.f836a);
    }

    @Override // com.xiaomi.push.ia
    public void a(hz hzVar) {
        a(hzVar.f11642a);
        a(hzVar.b);
        mo636a(hzVar.f838a);
    }

    @Override // com.xiaomi.push.ia
    public void a(hy hyVar) {
        a(hyVar.f11641a);
        mo636a(hyVar.f837a);
    }

    @Override // com.xiaomi.push.ia
    public void a(boolean z) {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.xiaomi.push.ia
    public void a(byte b) {
        byte[] bArr = this.f831a;
        bArr[0] = b;
        ((ia) this).f11644a.mo646a(bArr, 0, 1);
    }

    @Override // com.xiaomi.push.ia
    public void a(short s) {
        byte[] bArr = this.f832b;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        ((ia) this).f11644a.mo646a(bArr, 0, 2);
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void mo636a(int i) {
        byte[] bArr = this.f833c;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        ((ia) this).f11644a.mo646a(bArr, 0, 4);
    }

    @Override // com.xiaomi.push.ia
    public void a(long j) {
        byte[] bArr = this.d;
        bArr[0] = (byte) ((j >> 56) & 255);
        bArr[1] = (byte) ((j >> 48) & 255);
        bArr[2] = (byte) ((j >> 40) & 255);
        bArr[3] = (byte) ((j >> 32) & 255);
        bArr[4] = (byte) ((j >> 24) & 255);
        bArr[5] = (byte) ((j >> 16) & 255);
        bArr[6] = (byte) ((j >> 8) & 255);
        bArr[7] = (byte) (j & 255);
        ((ia) this).f11644a.mo646a(bArr, 0, 8);
    }

    @Override // com.xiaomi.push.ia
    public void a(String str) throws hu {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo636a(bytes.length);
            ((ia) this).f11644a.mo646a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new hu("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ia
    public void a(ByteBuffer byteBuffer) {
        int iLimit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        mo636a(iLimit);
        ((ia) this).f11644a.mo646a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), iLimit);
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Cif mo631a() {
        return f11638a;
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public hx mo627a() throws hu {
        byte bA = a();
        return new hx("", bA, bA == 0 ? (short) 0 : mo634a());
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public hz mo629a() {
        return new hz(a(), a(), mo625a());
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public hy mo628a() {
        return new hy(a(), mo625a());
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ie mo630a() {
        return new ie(a(), mo625a());
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean mo637a() {
        return a() == 1;
    }

    @Override // com.xiaomi.push.ia
    public byte a() throws hu {
        if (((ia) this).f11644a.b() >= 1) {
            byte b = ((ia) this).f11644a.a()[((ia) this).f11644a.a_()];
            ((ia) this).f11644a.a(1);
            return b;
        }
        a(this.e, 0, 1);
        return this.e[0];
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public short mo634a() throws hu {
        int iA_;
        byte[] bArrA = this.f;
        if (((ia) this).f11644a.b() >= 2) {
            bArrA = ((ia) this).f11644a.a();
            iA_ = ((ia) this).f11644a.a_();
            ((ia) this).f11644a.a(2);
        } else {
            a(this.f, 0, 2);
            iA_ = 0;
        }
        return (short) ((bArrA[iA_ + 1] & UByte.MAX_VALUE) | ((bArrA[iA_] & UByte.MAX_VALUE) << 8));
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int mo625a() throws hu {
        int iA_;
        byte[] bArrA = this.g;
        if (((ia) this).f11644a.b() >= 4) {
            bArrA = ((ia) this).f11644a.a();
            iA_ = ((ia) this).f11644a.a_();
            ((ia) this).f11644a.a(4);
        } else {
            a(this.g, 0, 4);
            iA_ = 0;
        }
        return (bArrA[iA_ + 3] & UByte.MAX_VALUE) | ((bArrA[iA_] & UByte.MAX_VALUE) << 24) | ((bArrA[iA_ + 1] & UByte.MAX_VALUE) << 16) | ((bArrA[iA_ + 2] & UByte.MAX_VALUE) << 8);
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long mo626a() throws hu {
        int iA_;
        byte[] bArrA = this.h;
        if (((ia) this).f11644a.b() >= 8) {
            bArrA = ((ia) this).f11644a.a();
            iA_ = ((ia) this).f11644a.a_();
            ((ia) this).f11644a.a(8);
        } else {
            a(this.h, 0, 8);
            iA_ = 0;
        }
        return ((long) (bArrA[iA_ + 7] & UByte.MAX_VALUE)) | (((long) (bArrA[iA_] & UByte.MAX_VALUE)) << 56) | (((long) (bArrA[iA_ + 1] & UByte.MAX_VALUE)) << 48) | (((long) (bArrA[iA_ + 2] & UByte.MAX_VALUE)) << 40) | (((long) (bArrA[iA_ + 3] & UByte.MAX_VALUE)) << 32) | (((long) (bArrA[iA_ + 4] & UByte.MAX_VALUE)) << 24) | (((long) (bArrA[iA_ + 5] & UByte.MAX_VALUE)) << 16) | (((long) (bArrA[iA_ + 6] & UByte.MAX_VALUE)) << 8);
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public double mo624a() {
        return Double.longBitsToDouble(mo626a());
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String mo632a() throws hu {
        int iMo625a = mo625a();
        if (((ia) this).f11644a.b() >= iMo625a) {
            try {
                String str = new String(((ia) this).f11644a.a(), ((ia) this).f11644a.a_(), iMo625a, "UTF-8");
                ((ia) this).f11644a.a(iMo625a);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new hu("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return a(iMo625a);
    }

    public String a(int i) throws hu {
        try {
            c(i);
            byte[] bArr = new byte[i];
            ((ia) this).f11644a.b(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new hu("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.xiaomi.push.ia
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public ByteBuffer mo633a() throws hu {
        int iMo625a = mo625a();
        c(iMo625a);
        if (((ia) this).f11644a.b() >= iMo625a) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(((ia) this).f11644a.a(), ((ia) this).f11644a.a_(), iMo625a);
            ((ia) this).f11644a.a(iMo625a);
            return byteBufferWrap;
        }
        byte[] bArr = new byte[iMo625a];
        ((ia) this).f11644a.b(bArr, 0, iMo625a);
        return ByteBuffer.wrap(bArr);
    }

    private int a(byte[] bArr, int i, int i2) throws hu {
        c(i2);
        return ((ia) this).f11644a.b(bArr, i, i2);
    }

    @Override // com.xiaomi.push.ia
    public void d() {
    }

    @Override // com.xiaomi.push.ia
    public void e() {
    }

    @Override // com.xiaomi.push.ia
    public void f() {
    }

    @Override // com.xiaomi.push.ia
    public void g() {
    }

    @Override // com.xiaomi.push.ia
    public void h() {
    }

    @Override // com.xiaomi.push.ia
    public void i() {
    }

    @Override // com.xiaomi.push.ia
    public void j() {
    }
}
