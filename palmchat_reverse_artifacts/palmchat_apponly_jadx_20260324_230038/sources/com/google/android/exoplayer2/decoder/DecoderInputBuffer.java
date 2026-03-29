package com.google.android.exoplayer2.decoder;

import androidx.annotation.Nullable;
import defpackage.ir0;
import defpackage.jr1;
import defpackage.yu;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class DecoderInputBuffer extends yu {
    public final ir0 b;

    @Nullable
    public ByteBuffer c;
    public boolean d;
    public long e;

    @Nullable
    public ByteBuffer f;
    public final int g;
    public final int h;

    /* JADX INFO: compiled from: SearchBox */
    public static final class InsufficientCapacityException extends IllegalStateException {
        public final int currentCapacity;
        public final int requiredCapacity;

        public InsufficientCapacityException(int i, int i2) {
            super("Buffer too small (" + i + " < " + i2 + ")");
            this.currentCapacity = i;
            this.requiredCapacity = i2;
        }
    }

    static {
        jr1.a("goog.exo.decoder");
    }

    public DecoderInputBuffer(int i) {
        this(i, 0);
    }

    public static DecoderInputBuffer p() {
        return new DecoderInputBuffer(0);
    }

    @Override // defpackage.yu
    public void b() {
        super.b();
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.d = false;
    }

    public final ByteBuffer l(int i) {
        int i2 = this.g;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.c;
        throw new InsufficientCapacityException(byteBuffer == null ? 0 : byteBuffer.capacity(), i);
    }

    public void m(int i) {
        int i2 = i + this.h;
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer == null) {
            this.c = l(i2);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i3 = i2 + iPosition;
        if (iCapacity >= i3) {
            this.c = byteBuffer;
            return;
        }
        ByteBuffer byteBufferL = l(i3);
        byteBufferL.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferL.put(byteBuffer);
        }
        this.c = byteBufferL;
    }

    public final void n() {
        ByteBuffer byteBuffer = this.c;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean o() {
        return d(1073741824);
    }

    public void q(int i) {
        ByteBuffer byteBuffer = this.f;
        if (byteBuffer == null || byteBuffer.capacity() < i) {
            this.f = ByteBuffer.allocate(i);
        } else {
            this.f.clear();
        }
    }

    public DecoderInputBuffer(int i, int i2) {
        this.b = new ir0();
        this.g = i;
        this.h = i2;
    }
}
