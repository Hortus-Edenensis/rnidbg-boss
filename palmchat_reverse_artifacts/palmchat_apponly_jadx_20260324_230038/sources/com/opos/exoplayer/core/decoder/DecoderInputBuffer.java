package com.opos.exoplayer.core.decoder;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class DecoderInputBuffer extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f8130a = new b();
    public ByteBuffer b;
    public long c;
    private final int d;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BufferReplacementMode {
    }

    public DecoderInputBuffer(int i) {
        this.d = i;
    }

    public static DecoderInputBuffer e() {
        return new DecoderInputBuffer(0);
    }

    private ByteBuffer f(int i) {
        int i2 = this.d;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.b;
        throw new IllegalStateException("Buffer too small (" + (byteBuffer == null ? 0 : byteBuffer.capacity()) + " < " + i + ")");
    }

    @Override // com.opos.exoplayer.core.decoder.a
    public void a() {
        super.a();
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    public final boolean g() {
        return d(1073741824);
    }

    public final void h() {
        this.b.flip();
    }

    public void e(int i) {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer == null) {
            this.b = f(i);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = this.b.position();
        int i2 = i + iPosition;
        if (iCapacity >= i2) {
            return;
        }
        ByteBuffer byteBufferF = f(i2);
        if (iPosition > 0) {
            this.b.position(0);
            this.b.limit(iPosition);
            byteBufferF.put(this.b);
        }
        this.b = byteBufferF;
    }

    public final boolean f() {
        return this.b == null && this.d == 0;
    }
}
