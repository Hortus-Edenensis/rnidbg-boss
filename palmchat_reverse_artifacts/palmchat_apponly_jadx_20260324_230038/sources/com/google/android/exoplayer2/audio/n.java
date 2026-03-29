package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import defpackage.g86;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class n extends f {
    public int i;
    public int j;
    public boolean k;
    public int l;
    public byte[] m = g86.f;
    public int n;
    public long o;

    @Override // com.google.android.exoplayer2.audio.f
    public AudioProcessor.a c(AudioProcessor.a aVar) throws AudioProcessor.UnhandledAudioFormatException {
        if (aVar.c != 2) {
            throw new AudioProcessor.UnhandledAudioFormatException(aVar);
        }
        this.k = true;
        return (this.i == 0 && this.j == 0) ? AudioProcessor.a.e : aVar;
    }

    @Override // com.google.android.exoplayer2.audio.f
    public void d() {
        if (this.k) {
            this.k = false;
            int i = this.j;
            int i2 = this.b.d;
            this.m = new byte[i * i2];
            this.l = this.i * i2;
        }
        this.n = 0;
    }

    @Override // com.google.android.exoplayer2.audio.f
    public void e() {
        if (this.k) {
            int i = this.n;
            if (i > 0) {
                this.o += (long) (i / this.b.d);
            }
            this.n = 0;
        }
    }

    @Override // com.google.android.exoplayer2.audio.f
    public void f() {
        this.m = g86.f;
    }

    @Override // com.google.android.exoplayer2.audio.f, com.google.android.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        int i;
        if (super.isEnded() && (i = this.n) > 0) {
            g(i).put(this.m, 0, this.n).flip();
            this.n = 0;
        }
        return super.getOutput();
    }

    public long h() {
        return this.o;
    }

    public void i() {
        this.o = 0L;
    }

    @Override // com.google.android.exoplayer2.audio.f, com.google.android.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        return super.isEnded() && this.n == 0;
    }

    public void j(int i, int i2) {
        this.i = i;
        this.j = i2;
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i = iLimit - iPosition;
        if (i == 0) {
            return;
        }
        int iMin = Math.min(i, this.l);
        this.o += (long) (iMin / this.b.d);
        this.l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.l > 0) {
            return;
        }
        int i2 = i - iMin;
        int length = (this.n + i2) - this.m.length;
        ByteBuffer byteBufferG = g(length);
        int iQ = g86.q(length, 0, this.n);
        byteBufferG.put(this.m, 0, iQ);
        int iQ2 = g86.q(length - iQ, 0, i2);
        byteBuffer.limit(byteBuffer.position() + iQ2);
        byteBufferG.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i3 = i2 - iQ2;
        int i4 = this.n - iQ;
        this.n = i4;
        byte[] bArr = this.m;
        System.arraycopy(bArr, iQ, bArr, 0, i4);
        byteBuffer.get(this.m, this.n, i3);
        this.n += i3;
        byteBufferG.flip();
    }
}
