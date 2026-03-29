package defpackage;

import androidx.media3.muxer.MuxerUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import kotlin.UByte;
import kotlin.UShort;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class lt0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f19069a;
    public int b = -1;
    public int c = -1;

    public lt0(byte[] bArr) {
        this.f19069a = ByteBuffer.wrap(bArr);
    }

    public void a() {
        ByteBuffer byteBuffer = this.f19069a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public int b() {
        return this.f19069a.position();
    }

    public void c(int i) {
        if (i >= this.f19069a.capacity()) {
            throw new IllegalArgumentException("cannot jump past end of input");
        }
        this.f19069a.position(i);
        ByteBuffer byteBuffer = this.f19069a;
        byteBuffer.limit(byteBuffer.capacity());
    }

    public void d(byte[] bArr, int i, int i2) throws IOException {
        i(i2);
        this.f19069a.get(bArr, i, i2);
    }

    public int e() throws IOException {
        i(2);
        return this.f19069a.getShort() & UShort.MAX_VALUE;
    }

    public long f() throws IOException {
        i(4);
        return ((long) this.f19069a.getInt()) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
    }

    public int g() throws IOException {
        i(1);
        return this.f19069a.get() & UByte.MAX_VALUE;
    }

    public int h() {
        return this.f19069a.remaining();
    }

    public final void i(int i) throws IOException {
        if (i > h()) {
            throw new IOException("end of input");
        }
    }

    public void j() {
        int i = this.b;
        if (i < 0) {
            throw new IllegalStateException("no previous state");
        }
        this.f19069a.position(i);
        this.f19069a.limit(this.c);
        this.b = -1;
        this.c = -1;
    }

    public void k() {
        this.b = this.f19069a.position();
        this.c = this.f19069a.limit();
    }

    public void l(int i) {
        if (i > this.f19069a.capacity() - this.f19069a.position()) {
            throw new IllegalArgumentException("cannot set active region past end of input");
        }
        ByteBuffer byteBuffer = this.f19069a;
        byteBuffer.limit(byteBuffer.position() + i);
    }
}
