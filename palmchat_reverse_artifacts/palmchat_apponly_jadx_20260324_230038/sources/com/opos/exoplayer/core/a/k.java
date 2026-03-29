package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.a.d;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class k implements d {
    private int b;
    private int c;
    private int[] d;
    private boolean e;
    private int[] f;
    private ByteBuffer g;
    private ByteBuffer h;
    private boolean i;

    public k() {
        ByteBuffer byteBuffer = d.f8090a;
        this.g = byteBuffer;
        this.h = byteBuffer;
        this.b = -1;
        this.c = -1;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void a(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int length = ((iLimit - iPosition) / (this.b * 2)) * this.f.length * 2;
        if (this.g.capacity() < length) {
            this.g = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.g.clear();
        }
        while (iPosition < iLimit) {
            for (int i : this.f) {
                this.g.putShort(byteBuffer.getShort((i * 2) + iPosition));
            }
            iPosition += this.b * 2;
        }
        byteBuffer.position(iLimit);
        this.g.flip();
        this.h = this.g;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int b() {
        int[] iArr = this.f;
        return iArr == null ? this.b : iArr.length;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int c() {
        return 2;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int d() {
        return this.c;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void e() {
        this.i = true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.h;
        this.h = d.f8090a;
        return byteBuffer;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean g() {
        return this.i && this.h == d.f8090a;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void h() {
        this.h = d.f8090a;
        this.i = false;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void i() {
        h();
        this.g = d.f8090a;
        this.b = -1;
        this.c = -1;
        this.f = null;
        this.e = false;
    }

    public void a(int[] iArr) {
        this.d = iArr;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a() {
        return this.e;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a(int i, int i2, int i3) throws d.a {
        boolean z = !Arrays.equals(this.d, this.f);
        int[] iArr = this.d;
        this.f = iArr;
        if (iArr == null) {
            this.e = false;
            return z;
        }
        if (i3 != 2) {
            throw new d.a(i, i2, i3);
        }
        if (!z && this.c == i && this.b == i2) {
            return false;
        }
        this.c = i;
        this.b = i2;
        this.e = i2 != iArr.length;
        int i4 = 0;
        while (true) {
            int[] iArr2 = this.f;
            if (i4 >= iArr2.length) {
                return true;
            }
            int i5 = iArr2[i4];
            if (i5 >= i2) {
                throw new d.a(i, i2, i3);
            }
            this.e = (i5 != i4) | this.e;
            i4++;
        }
    }
}
