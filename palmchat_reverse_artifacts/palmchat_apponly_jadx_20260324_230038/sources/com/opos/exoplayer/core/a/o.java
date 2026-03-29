package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.a.d;
import com.opos.exoplayer.core.util.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class o implements d {
    private boolean b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private ByteBuffer h;
    private ByteBuffer i;
    private byte[] j;
    private int k;
    private boolean l;

    public o() {
        ByteBuffer byteBuffer = d.f8090a;
        this.h = byteBuffer;
        this.i = byteBuffer;
        this.e = -1;
    }

    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int b() {
        return this.e;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int c() {
        return 2;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int d() {
        return this.f;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void e() {
        this.l = true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.i;
        this.i = d.f8090a;
        return byteBuffer;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean g() {
        return this.l && this.i == d.f8090a;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void h() {
        this.i = d.f8090a;
        this.l = false;
        this.g = 0;
        this.k = 0;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void i() {
        h();
        this.h = d.f8090a;
        this.e = -1;
        this.f = -1;
        this.j = null;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        int iMin = Math.min(i, this.g);
        this.g -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.g > 0) {
            return;
        }
        int i2 = i - iMin;
        int length = (this.k + i2) - this.j.length;
        if (this.h.capacity() < length) {
            this.h = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.h.clear();
        }
        int iA = y.a(length, 0, this.k);
        this.h.put(this.j, 0, iA);
        int iA2 = y.a(length - iA, 0, i2);
        byteBuffer.limit(byteBuffer.position() + iA2);
        this.h.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i3 = i2 - iA2;
        int i4 = this.k - iA;
        this.k = i4;
        byte[] bArr = this.j;
        System.arraycopy(bArr, iA, bArr, 0, i4);
        byteBuffer.get(this.j, this.k, i3);
        this.k += i3;
        this.h.flip();
        this.i = this.h;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a() {
        return this.b;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a(int i, int i2, int i3) throws d.a {
        if (i3 != 2) {
            throw new d.a(i, i2, i3);
        }
        this.e = i2;
        this.f = i;
        int i4 = this.d;
        this.j = new byte[i4 * i2 * 2];
        this.k = 0;
        int i5 = this.c;
        this.g = i2 * i5 * 2;
        boolean z = this.b;
        boolean z2 = (i5 == 0 && i4 == 0) ? false : true;
        this.b = z2;
        return z != z2;
    }
}
