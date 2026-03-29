package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.oplus.tbl.exoplayer2.audio.SilenceSkippingAudioProcessor;
import defpackage.g86;
import defpackage.vh;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class j extends f {
    public final long i;
    public final long j;
    public final short k;
    public int l;
    public boolean m;
    public byte[] n;
    public byte[] o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public long t;

    public j() {
        this(SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US, 20000L, (short) 1024);
    }

    @Override // com.google.android.exoplayer2.audio.f
    public AudioProcessor.a c(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.c == 2) {
            return this.m ? aVar : AudioProcessor.a.e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.f
    public void d() {
        if (this.m) {
            this.l = this.b.d;
            int iH = h(this.i) * this.l;
            if (this.n.length != iH) {
                this.n = new byte[iH];
            }
            int iH2 = h(this.j) * this.l;
            this.r = iH2;
            if (this.o.length != iH2) {
                this.o = new byte[iH2];
            }
        }
        this.p = 0;
        this.t = 0L;
        this.q = 0;
        this.s = false;
    }

    @Override // com.google.android.exoplayer2.audio.f
    public void e() {
        int i = this.q;
        if (i > 0) {
            m(this.n, i);
        }
        if (this.s) {
            return;
        }
        this.t += (long) (this.r / this.l);
    }

    @Override // com.google.android.exoplayer2.audio.f
    public void f() {
        this.m = false;
        this.r = 0;
        byte[] bArr = g86.f;
        this.n = bArr;
        this.o = bArr;
    }

    public final int h(long j) {
        return (int) ((j * ((long) this.b.f5818a)) / 1000000);
    }

    public final int i(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        do {
            iLimit -= 2;
            if (iLimit < byteBuffer.position()) {
                return byteBuffer.position();
            }
        } while (Math.abs((int) byteBuffer.getShort(iLimit)) <= this.k);
        int i = this.l;
        return ((iLimit / i) * i) + i;
    }

    @Override // com.google.android.exoplayer2.audio.f, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.m;
    }

    public final int j(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position(); iPosition < byteBuffer.limit(); iPosition += 2) {
            if (Math.abs((int) byteBuffer.getShort(iPosition)) > this.k) {
                int i = this.l;
                return i * (iPosition / i);
            }
        }
        return byteBuffer.limit();
    }

    public long k() {
        return this.t;
    }

    public final void l(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        g(iRemaining).put(byteBuffer).flip();
        if (iRemaining > 0) {
            this.s = true;
        }
    }

    public final void m(byte[] bArr, int i) {
        g(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.s = true;
        }
    }

    public final void n(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iJ = j(byteBuffer);
        int iPosition = iJ - byteBuffer.position();
        byte[] bArr = this.n;
        int length = bArr.length;
        int i = this.q;
        int i2 = length - i;
        if (iJ < iLimit && iPosition < i2) {
            m(bArr, i);
            this.q = 0;
            this.p = 0;
            return;
        }
        int iMin = Math.min(iPosition, i2);
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(this.n, this.q, iMin);
        int i3 = this.q + iMin;
        this.q = i3;
        byte[] bArr2 = this.n;
        if (i3 == bArr2.length) {
            if (this.s) {
                m(bArr2, this.r);
                this.t += (long) ((this.q - (this.r * 2)) / this.l);
            } else {
                this.t += (long) ((i3 - this.r) / this.l);
            }
            r(byteBuffer, this.n, this.q);
            this.q = 0;
            this.p = 2;
        }
        byteBuffer.limit(iLimit);
    }

    public final void o(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.n.length));
        int i = i(byteBuffer);
        if (i == byteBuffer.position()) {
            this.p = 1;
        } else {
            byteBuffer.limit(i);
            l(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    public final void p(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iJ = j(byteBuffer);
        byteBuffer.limit(iJ);
        this.t += (long) (byteBuffer.remaining() / this.l);
        r(byteBuffer, this.o, this.r);
        if (iJ < iLimit) {
            m(this.o, this.r);
            this.p = 0;
            byteBuffer.limit(iLimit);
        }
    }

    public void q(boolean z) {
        this.m = z;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !b()) {
            int i = this.p;
            if (i == 0) {
                o(byteBuffer);
            } else if (i == 1) {
                n(byteBuffer);
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                p(byteBuffer);
            }
        }
    }

    public final void r(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int iMin = Math.min(byteBuffer.remaining(), this.r);
        int i2 = this.r - iMin;
        System.arraycopy(bArr, i - i2, this.o, 0, i2);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.o, i2, iMin);
    }

    public j(long j, long j2, short s) {
        vh.a(j2 <= j);
        this.i = j;
        this.j = j2;
        this.k = s;
        byte[] bArr = g86.f;
        this.n = bArr;
        this.o = bArr;
    }
}
