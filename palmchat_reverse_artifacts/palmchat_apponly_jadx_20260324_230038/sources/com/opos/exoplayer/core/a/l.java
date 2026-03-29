package com.opos.exoplayer.core.a;

import com.opos.exoplayer.core.a.d;
import com.opos.exoplayer.core.util.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class l implements d {
    private static final int b = Float.floatToIntBits(Float.NaN);
    private int c = -1;
    private int d = -1;
    private int e = 0;
    private ByteBuffer f;
    private ByteBuffer g;
    private boolean h;

    public l() {
        ByteBuffer byteBuffer = d.f8090a;
        this.f = byteBuffer;
        this.g = byteBuffer;
    }

    private static void a(int i, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i) * 4.656612875245797E-10d));
        if (iFloatToIntBits == b) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // com.opos.exoplayer.core.a.d
    public int b() {
        return this.d;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int c() {
        return 4;
    }

    @Override // com.opos.exoplayer.core.a.d
    public int d() {
        return this.c;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void e() {
        this.h = true;
    }

    @Override // com.opos.exoplayer.core.a.d
    public ByteBuffer f() {
        ByteBuffer byteBuffer = this.g;
        this.g = d.f8090a;
        return byteBuffer;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean g() {
        return this.h && this.g == d.f8090a;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void h() {
        this.g = d.f8090a;
        this.h = false;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void i() {
        h();
        this.f = d.f8090a;
        this.c = -1;
        this.d = -1;
        this.e = 0;
    }

    @Override // com.opos.exoplayer.core.a.d
    public void a(ByteBuffer byteBuffer) {
        com.opos.exoplayer.core.util.a.b(a());
        boolean z = this.e == 1073741824;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        if (!z) {
            i = (i / 3) * 4;
        }
        if (this.f.capacity() < i) {
            this.f = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f.clear();
        }
        if (z) {
            while (iPosition < iLimit) {
                a((byteBuffer.get(iPosition) & UByte.MAX_VALUE) | ((byteBuffer.get(iPosition + 1) & UByte.MAX_VALUE) << 8) | ((byteBuffer.get(iPosition + 2) & UByte.MAX_VALUE) << 16) | ((byteBuffer.get(iPosition + 3) & UByte.MAX_VALUE) << 24), this.f);
                iPosition += 4;
            }
        } else {
            while (iPosition < iLimit) {
                a(((byteBuffer.get(iPosition) & UByte.MAX_VALUE) << 8) | ((byteBuffer.get(iPosition + 1) & UByte.MAX_VALUE) << 16) | ((byteBuffer.get(iPosition + 2) & UByte.MAX_VALUE) << 24), this.f);
                iPosition += 3;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        this.f.flip();
        this.g = this.f;
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a() {
        return y.c(this.e);
    }

    @Override // com.opos.exoplayer.core.a.d
    public boolean a(int i, int i2, int i3) throws d.a {
        if (!y.c(i3)) {
            throw new d.a(i, i2, i3);
        }
        if (this.c == i && this.d == i2 && this.e == i3) {
            return false;
        }
        this.c = i;
        this.d = i2;
        this.e = i3;
        return true;
    }
}
