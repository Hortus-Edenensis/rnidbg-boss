package com.xiaomi.push;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11463a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final OutputStream f182a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final byte[] f183a;
    private int b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends IOException {
        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private c(byte[] bArr, int i, int i2) {
        this.f182a = null;
        this.f183a = bArr;
        this.b = i;
        this.f11463a = i + i2;
    }

    public static int a(boolean z) {
        return 1;
    }

    public static int c(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int d(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m236b(int i, long j) throws IOException {
        c(i, 0);
        m237b(j);
    }

    public static c a(OutputStream outputStream) {
        return a(outputStream, 4096);
    }

    private void c() throws IOException {
        OutputStream outputStream = this.f182a;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f183a, 0, this.b);
        this.b = 0;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public void m240d(int i) throws IOException {
        while ((i & (-128)) != 0) {
            m238c((i & 127) | 128);
            i >>>= 7;
        }
        m238c(i);
    }

    public static c a(OutputStream outputStream, int i) {
        return new c(outputStream, new byte[i]);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m235b(int i, int i2) throws IOException {
        c(i, 0);
        m234b(i2);
    }

    public static c a(byte[] bArr, int i, int i2) {
        return new c(bArr, i, i2);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m223a(int i, long j) throws IOException {
        c(i, 0);
        m228a(j);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m237b(long j) throws IOException {
        m239c(j);
    }

    private c(OutputStream outputStream, byte[] bArr) {
        this.f182a = outputStream;
        this.f183a = bArr;
        this.b = 0;
        this.f11463a = bArr.length;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m234b(int i) throws IOException {
        m240d(i);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m238c(int i) throws IOException {
        a((byte) i);
    }

    public static int b(int i, long j) {
        return c(i) + b(j);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m222a(int i, int i2) throws IOException {
        c(i, 0);
        m221a(i2);
    }

    public void c(int i, int i2) throws IOException {
        m240d(f.a(i, i2));
    }

    public static int b(int i, int i2) {
        return c(i) + b(i2);
    }

    public static int c(int i) {
        return d(f.a(i, 0));
    }

    public static int b(long j) {
        return c(j);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m227a(int i, boolean z) throws IOException {
        c(i, 0);
        m232a(z);
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m239c(long j) throws IOException {
        while (((-128) & j) != 0) {
            m238c((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m238c((int) j);
    }

    public static int b(int i) {
        return d(i);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m226a(int i, String str) throws IOException {
        c(i, 2);
        m231a(str);
    }

    public void b() {
        if (a() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m225a(int i, e eVar) throws IOException {
        c(i, 2);
        m230a(eVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m224a(int i, com.xiaomi.push.a aVar) throws IOException {
        c(i, 2);
        m229a(aVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m228a(long j) throws IOException {
        m239c(j);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m221a(int i) throws IOException {
        if (i >= 0) {
            m240d(i);
        } else {
            m239c(i);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m232a(boolean z) throws IOException {
        m238c(z ? 1 : 0);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m231a(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        m240d(bytes.length);
        a(bytes);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m230a(e eVar) throws IOException {
        m240d(eVar.a());
        eVar.a(this);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m229a(com.xiaomi.push.a aVar) throws IOException {
        byte[] bArrM151a = aVar.m151a();
        m240d(bArrM151a.length);
        a(bArrM151a);
    }

    public static int a(int i, long j) {
        return c(i) + a(j);
    }

    public static int a(int i, int i2) {
        return c(i) + a(i2);
    }

    public static int a(int i, boolean z) {
        return c(i) + a(z);
    }

    public static int a(int i, String str) {
        return c(i) + a(str);
    }

    public static int a(int i, e eVar) {
        return c(i) + a(eVar);
    }

    public static int a(int i, com.xiaomi.push.a aVar) {
        return c(i) + a(aVar);
    }

    public static int a(long j) {
        return c(j);
    }

    public static int a(int i) {
        if (i >= 0) {
            return d(i);
        }
        return 10;
    }

    public static int a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return d(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static int a(e eVar) {
        int iB = eVar.b();
        return d(iB) + iB;
    }

    public static int a(com.xiaomi.push.a aVar) {
        return d(aVar.a()) + aVar.a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m220a() throws IOException {
        if (this.f182a != null) {
            c();
        }
    }

    public int a() {
        if (this.f182a == null) {
            return this.f11463a - this.b;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void a(byte b) throws IOException {
        if (this.b == this.f11463a) {
            c();
        }
        byte[] bArr = this.f183a;
        int i = this.b;
        this.b = i + 1;
        bArr[i] = b;
    }

    public void a(byte[] bArr) throws IOException {
        m233a(bArr, 0, bArr.length);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m233a(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f11463a;
        int i4 = this.b;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f183a, i4, i2);
            this.b += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f183a, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.b = this.f11463a;
        c();
        if (i7 <= this.f11463a) {
            System.arraycopy(bArr, i6, this.f183a, 0, i7);
            this.b = i7;
        } else {
            this.f182a.write(bArr, i6, i7);
        }
    }
}
