package com.bytedance.sdk.component.fx.u;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
final class mv implements b {
    boolean fx;
    public final sx nr;
    public final fx u = new fx();

    public mv(sx sxVar) {
        if (sxVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.nr = sxVar;
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    public b a(int i) throws IOException {
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        this.u.a(i);
        return dw();
    }

    @Override // com.bytedance.sdk.component.fx.u.sx
    public void a_(fx fxVar, long j) throws IOException {
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        this.u.a_(fxVar, j);
        dw();
    }

    @Override // com.bytedance.sdk.component.fx.u.sx, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.fx) {
            return;
        }
        try {
            fx fxVar = this.u;
            long j = fxVar.nr;
            if (j > 0) {
                this.nr.a_(fxVar, j);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.nr.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.fx = true;
        if (th != null) {
            dw.u(th);
        }
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    public b dw() throws IOException {
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        long jX = this.u.x();
        if (jX > 0) {
            this.nr.a_(this.u, jX);
        }
        return this;
    }

    @Override // com.bytedance.sdk.component.fx.u.b, com.bytedance.sdk.component.fx.u.sx, java.io.Flushable
    public void flush() throws IOException {
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        fx fxVar = this.u;
        long j = fxVar.nr;
        if (j > 0) {
            this.nr.a_(fxVar, j);
        }
        this.nr.flush();
    }

    @Override // com.bytedance.sdk.component.fx.u.b, com.bytedance.sdk.component.fx.u.pn
    public fx fx() {
        return this.u;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.fx;
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    public b l(long j) throws IOException {
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        this.u.l(j);
        return dw();
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    public b n(int i) throws IOException {
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        this.u.n(i);
        return dw();
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    public b nr(iz izVar) throws IOException {
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        this.u.nr(izVar);
        return dw();
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    public b t(long j) throws IOException {
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        this.u.t(j);
        return dw();
    }

    public String toString() {
        return "buffer(" + this.nr + ")";
    }

    @Override // com.bytedance.sdk.component.fx.u.sx
    public bq u() {
        return this.nr.u();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.u.write(byteBuffer);
        dw();
        return iWrite;
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    public b x(int i) throws IOException {
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        this.u.x(i);
        return dw();
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    public b fx(byte[] bArr) throws IOException {
        if (this.fx) {
            throw new IllegalStateException("closed");
        }
        this.u.fx(bArr);
        return dw();
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    public b nr(String str) throws IOException {
        if (!this.fx) {
            this.u.nr(str);
            return dw();
        }
        throw new IllegalStateException("closed");
    }

    @Override // com.bytedance.sdk.component.fx.u.b
    public b fx(byte[] bArr, int i, int i2) throws IOException {
        if (!this.fx) {
            this.u.fx(bArr, i, i2);
            return dw();
        }
        throw new IllegalStateException("closed");
    }
}
