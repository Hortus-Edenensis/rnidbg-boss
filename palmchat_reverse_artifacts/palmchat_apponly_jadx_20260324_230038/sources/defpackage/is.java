package defpackage;

import androidx.annotation.IntRange;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class is extends DecoderInputBuffer {
    public long i;
    public int j;
    public int k;

    public is() {
        super(2);
        this.k = 32;
    }

    @Override // com.google.android.exoplayer2.decoder.DecoderInputBuffer, defpackage.yu
    public void b() {
        super.b();
        this.j = 0;
    }

    public boolean r(DecoderInputBuffer decoderInputBuffer) {
        vh.a(!decoderInputBuffer.o());
        vh.a(!decoderInputBuffer.e());
        vh.a(!decoderInputBuffer.g());
        if (!s(decoderInputBuffer)) {
            return false;
        }
        int i = this.j;
        this.j = i + 1;
        if (i == 0) {
            this.e = decoderInputBuffer.e;
            if (decoderInputBuffer.i()) {
                k(1);
            }
        }
        if (decoderInputBuffer.f()) {
            k(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer = decoderInputBuffer.c;
        if (byteBuffer != null) {
            m(byteBuffer.remaining());
            this.c.put(byteBuffer);
        }
        this.i = decoderInputBuffer.e;
        return true;
    }

    public final boolean s(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (!w()) {
            return true;
        }
        if (this.j >= this.k || decoderInputBuffer.f() != f()) {
            return false;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer.c;
        return byteBuffer2 == null || (byteBuffer = this.c) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    public long t() {
        return this.e;
    }

    public long u() {
        return this.i;
    }

    public int v() {
        return this.j;
    }

    public boolean w() {
        return this.j > 0;
    }

    public void x(@IntRange(from = 1) int i) {
        vh.a(i > 0);
        this.k = i;
    }
}
