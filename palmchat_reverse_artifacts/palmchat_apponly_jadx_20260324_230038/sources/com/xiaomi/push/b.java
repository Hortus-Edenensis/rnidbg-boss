package com.xiaomi.push;

import java.io.InputStream;
import java.util.Vector;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11433a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final InputStream f144a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final byte[] f145a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;

    private b(byte[] bArr, int i, int i2) {
        this.f = Integer.MAX_VALUE;
        this.h = 64;
        this.i = 67108864;
        this.f145a = bArr;
        this.f11433a = i2 + i;
        this.c = i;
        this.f144a = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public long m196b() {
        return m198c();
    }

    public int c() {
        return d();
    }

    public int d() throws d {
        int i;
        byte bA = a();
        if (bA >= 0) {
            return bA;
        }
        int i2 = bA & ByteCompanionObject.MAX_VALUE;
        byte bA2 = a();
        if (bA2 >= 0) {
            i = bA2 << 7;
        } else {
            i2 |= (bA2 & ByteCompanionObject.MAX_VALUE) << 7;
            byte bA3 = a();
            if (bA3 >= 0) {
                i = bA3 << com.umeng.analytics.pro.dn.l;
            } else {
                i2 |= (bA3 & ByteCompanionObject.MAX_VALUE) << 14;
                byte bA4 = a();
                if (bA4 < 0) {
                    int i3 = i2 | ((bA4 & ByteCompanionObject.MAX_VALUE) << 21);
                    byte bA5 = a();
                    int i4 = i3 | (bA5 << 28);
                    if (bA5 >= 0) {
                        return i4;
                    }
                    for (int i5 = 0; i5 < 5; i5++) {
                        if (a() >= 0) {
                            return i4;
                        }
                    }
                    throw d.c();
                }
                i = bA4 << 21;
            }
        }
        return i2 | i;
    }

    public int e() throws d {
        return (a() & UByte.MAX_VALUE) | ((a() & UByte.MAX_VALUE) << 8) | ((a() & UByte.MAX_VALUE) << 16) | ((a() & UByte.MAX_VALUE) << 24);
    }

    public static b a(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public int m195b() {
        return d();
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public long m198c() throws d {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bA = a();
            j |= ((long) (bA & ByteCompanionObject.MAX_VALUE)) << i;
            if ((bA & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw d.c();
    }

    private void b() {
        int i = this.f11433a + this.b;
        this.f11433a = i;
        int i2 = this.e + i;
        int i3 = this.f;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.b = i4;
            this.f11433a = i - i4;
            return;
        }
        this.b = 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public int m186a() throws d {
        if (m197b()) {
            this.d = 0;
            return 0;
        }
        int iD = d();
        this.d = iD;
        if (iD != 0) {
            return iD;
        }
        throw d.d();
    }

    public void c(int i) throws d {
        if (i >= 0) {
            int i2 = this.e;
            int i3 = this.c;
            int i4 = i2 + i3 + i;
            int i5 = this.f;
            if (i4 <= i5) {
                int i6 = this.f11433a;
                if (i <= i6 - i3) {
                    this.c = i3 + i;
                    return;
                }
                int i7 = i6 - i3;
                this.e = i2 + i6;
                this.c = 0;
                this.f11433a = 0;
                while (i7 < i) {
                    InputStream inputStream = this.f144a;
                    int iSkip = inputStream == null ? -1 : (int) inputStream.skip(i - i7);
                    if (iSkip > 0) {
                        i7 += iSkip;
                        this.e += iSkip;
                    } else {
                        throw d.a();
                    }
                }
                return;
            }
            c((i5 - i2) - i3);
            throw d.a();
        }
        throw d.b();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m191a(int i) throws d {
        if (this.d != i) {
            throw d.e();
        }
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public long m199d() throws d {
        byte bA = a();
        return ((((long) a()) & 255) << 8) | (((long) bA) & 255) | ((((long) a()) & 255) << 16) | ((((long) a()) & 255) << 24) | ((((long) a()) & 255) << 32) | ((((long) a()) & 255) << 40) | ((((long) a()) & 255) << 48) | ((((long) a()) & 255) << 56);
    }

    private b(InputStream inputStream) {
        this.f = Integer.MAX_VALUE;
        this.h = 64;
        this.i = 67108864;
        this.f145a = new byte[4096];
        this.f11433a = 0;
        this.c = 0;
        this.f144a = inputStream;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m193a(int i) throws d {
        int iA = f.a(i);
        if (iA == 0) {
            m195b();
            return true;
        }
        if (iA == 1) {
            m199d();
            return true;
        }
        if (iA == 2) {
            c(d());
            return true;
        }
        if (iA == 3) {
            m190a();
            m191a(f.a(f.b(i), 4));
            return true;
        }
        if (iA == 4) {
            return false;
        }
        if (iA == 5) {
            e();
            return true;
        }
        throw d.f();
    }

    public void b(int i) {
        this.f = i;
        b();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m197b() {
        return this.c == this.f11433a && !a(false);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m190a() throws d {
        int iM186a;
        do {
            iM186a = m186a();
            if (iM186a == 0) {
                return;
            }
        } while (m193a(iM186a));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m187a() {
        return m198c();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m192a() {
        return d() != 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m189a() throws d {
        int iD = d();
        int i = this.f11433a;
        int i2 = this.c;
        if (iD <= i - i2 && iD > 0) {
            String str = new String(this.f145a, i2, iD, "UTF-8");
            this.c += iD;
            return str;
        }
        return new String(m194a(iD), "UTF-8");
    }

    public void a(e eVar) throws d {
        int iD = d();
        if (this.g < this.h) {
            int iA = a(iD);
            this.g++;
            eVar.a(this);
            m191a(0);
            this.g--;
            b(iA);
            return;
        }
        throw d.g();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public a m188a() throws d {
        int iD = d();
        int i = this.f11433a;
        int i2 = this.c;
        if (iD <= i - i2 && iD > 0) {
            a aVarA = a.a(this.f145a, i2, iD);
            this.c += iD;
            return aVarA;
        }
        return a.a(m194a(iD));
    }

    public int a(int i) throws d {
        if (i >= 0) {
            int i2 = i + this.e + this.c;
            int i3 = this.f;
            if (i2 <= i3) {
                this.f = i2;
                b();
                return i3;
            }
            throw d.a();
        }
        throw d.b();
    }

    private boolean a(boolean z) throws d {
        int i = this.c;
        int i2 = this.f11433a;
        if (i >= i2) {
            int i3 = this.e;
            if (i3 + i2 == this.f) {
                if (z) {
                    throw d.a();
                }
                return false;
            }
            this.e = i3 + i2;
            this.c = 0;
            InputStream inputStream = this.f144a;
            int i4 = inputStream == null ? -1 : inputStream.read(this.f145a);
            this.f11433a = i4;
            if (i4 == 0 || i4 < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f11433a + "\nThe InputStream implementation is buggy.");
            }
            if (i4 == -1) {
                this.f11433a = 0;
                if (z) {
                    throw d.a();
                }
                return false;
            }
            b();
            int i5 = this.e + this.f11433a + this.b;
            if (i5 > this.i || i5 < 0) {
                throw d.h();
            }
            return true;
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    public byte a() throws d {
        if (this.c == this.f11433a) {
            a(true);
        }
        byte[] bArr = this.f145a;
        int i = this.c;
        this.c = i + 1;
        return bArr[i];
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public byte[] m194a(int i) throws d {
        if (i >= 0) {
            int i2 = this.e;
            int i3 = this.c;
            int i4 = i2 + i3 + i;
            int i5 = this.f;
            if (i4 <= i5) {
                int i6 = this.f11433a;
                if (i <= i6 - i3) {
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.f145a, i3, bArr, 0, i);
                    this.c += i;
                    return bArr;
                }
                if (i < 4096) {
                    byte[] bArr2 = new byte[i];
                    int i7 = i6 - i3;
                    System.arraycopy(this.f145a, i3, bArr2, 0, i7);
                    this.c = this.f11433a;
                    a(true);
                    while (true) {
                        int i8 = i - i7;
                        int i9 = this.f11433a;
                        if (i8 > i9) {
                            System.arraycopy(this.f145a, 0, bArr2, i7, i9);
                            int i10 = this.f11433a;
                            i7 += i10;
                            this.c = i10;
                            a(true);
                        } else {
                            System.arraycopy(this.f145a, 0, bArr2, i7, i8);
                            this.c = i8;
                            return bArr2;
                        }
                    }
                } else {
                    this.e = i2 + i6;
                    this.c = 0;
                    this.f11433a = 0;
                    int length = i6 - i3;
                    int i11 = i - length;
                    Vector vector = new Vector();
                    while (i11 > 0) {
                        int iMin = Math.min(i11, 4096);
                        byte[] bArr3 = new byte[iMin];
                        int i12 = 0;
                        while (i12 < iMin) {
                            InputStream inputStream = this.f144a;
                            int i13 = inputStream == null ? -1 : inputStream.read(bArr3, i12, iMin - i12);
                            if (i13 == -1) {
                                throw d.a();
                            }
                            this.e += i13;
                            i12 += i13;
                        }
                        i11 -= iMin;
                        vector.addElement(bArr3);
                    }
                    byte[] bArr4 = new byte[i];
                    System.arraycopy(this.f145a, i3, bArr4, 0, length);
                    for (int i14 = 0; i14 < vector.size(); i14++) {
                        byte[] bArr5 = (byte[]) vector.elementAt(i14);
                        System.arraycopy(bArr5, 0, bArr4, length, bArr5.length);
                        length += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                c((i5 - i2) - i3);
                throw d.a();
            }
        } else {
            throw d.b();
        }
    }
}
