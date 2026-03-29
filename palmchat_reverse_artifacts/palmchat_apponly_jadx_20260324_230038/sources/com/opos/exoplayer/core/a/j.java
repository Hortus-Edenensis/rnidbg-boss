package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.a.d;
import com.opos.exoplayer.core.util.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class j implements d {
    private int b;
    private n e;
    private ByteBuffer i;
    private ShortBuffer j;
    private ByteBuffer k;
    private long l;
    private long m;
    private boolean n;
    private float f = 1.0f;
    private float g = 1.0f;
    private int c = -1;
    private int d = -1;
    private int h = -1;

    public j() {
        ByteBuffer byteBuffer = d.f8090a;
        this.i = byteBuffer;
        this.j = byteBuffer.asShortBuffer();
        this.k = byteBuffer;
        this.b = -1;
    }

    public float a(float f) {
        float fA = y.a(f, 0.1f, 8.0f);
        this.f = fA;
        return fA;
    }

    public float b(float f) {
        this.g = y.a(f, 0.1f, 8.0f);
        return f;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int c() {
        return 2;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int d() {
        return this.h;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void e() {
        this.e.a();
        this.n = true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.k;
        this.k = d.f8090a;
        return byteBuffer;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean g() {
        n nVar;
        return this.n && ((nVar = this.e) == null || nVar.b() == 0);
    }

    @Override // com.opos.exoplayer.core.a.d
    public void h() {
        this.e = new n(this.d, this.c, this.f, this.g, this.h);
        this.k = d.f8090a;
        this.l = 0L;
        this.m = 0L;
        this.n = false;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void i() {
        this.e = null;
        ByteBuffer byteBuffer = d.f8090a;
        this.i = byteBuffer;
        this.j = byteBuffer.asShortBuffer();
        this.k = byteBuffer;
        this.c = -1;
        this.d = -1;
        this.h = -1;
        this.l = 0L;
        this.m = 0L;
        this.n = false;
        this.b = -1;
    }

    public long a(long j) {
        long j2 = this.m;
        if (j2 < 1024) {
            return (long) (((double) this.f) * j);
        }
        int i = this.h;
        int i2 = this.d;
        long j3 = this.l;
        return i == i2 ? y.d(j, j3, j2) : y.d(j, j3 * ((long) i), j2 * ((long) i2));
    }

    @Override // com.opos.exoplayer.core.a.d
    public int b() {
        return this.c;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void a(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.l += (long) iRemaining;
            this.e.a(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
        int iB = this.e.b() * this.c * 2;
        if (iB > 0) {
            if (this.i.capacity() < iB) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iB).order(ByteOrder.nativeOrder());
                this.i = byteBufferOrder;
                this.j = byteBufferOrder.asShortBuffer();
            } else {
                this.i.clear();
                this.j.clear();
            }
            this.e.b(this.j);
            this.m += (long) iB;
            this.i.limit(iB);
            this.k = this.i;
        }
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a() {
        return Math.abs(this.f - 1.0f) >= 0.01f || Math.abs(this.g - 1.0f) >= 0.01f || this.h != this.d;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a(int i, int i2, int i3) throws d.a {
        if (i3 != 2) {
            throw new d.a(i, i2, i3);
        }
        int i4 = this.b;
        if (i4 == -1) {
            i4 = i;
        }
        if (this.d == i && this.c == i2 && this.h == i4) {
            return false;
        }
        this.d = i;
        this.c = i2;
        this.h = i4;
        return true;
    }
}
