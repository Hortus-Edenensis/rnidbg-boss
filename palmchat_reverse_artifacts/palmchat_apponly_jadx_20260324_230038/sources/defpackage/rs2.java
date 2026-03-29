package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class rs2 extends pw0 {
    public Inflater c;
    public byte[] d;
    public byte[] e;
    public int f;

    public rs2(f60 f60Var, int i) {
        super(f60Var);
        this.e = new byte[1];
        this.c = new Inflater(true);
        this.d = new byte[i];
    }

    @Override // defpackage.pw0
    public void a(InputStream inputStream) throws IOException {
        Inflater inflater = this.c;
        if (inflater != null) {
            inflater.end();
            this.c = null;
        }
        super.a(inputStream);
    }

    @Override // defpackage.pw0, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Inflater inflater = this.c;
        if (inflater != null) {
            inflater.end();
        }
        super.close();
    }

    @Override // defpackage.pw0
    public void d(PushbackInputStream pushbackInputStream) throws IOException {
        int remaining = this.c.getRemaining();
        if (remaining > 0) {
            pushbackInputStream.unread(c(), this.f - remaining, remaining);
        }
    }

    public final void e() throws IOException {
        byte[] bArr = this.d;
        int i = super.read(bArr, 0, bArr.length);
        this.f = i;
        if (i == -1) {
            throw new EOFException("Unexpected end of input stream");
        }
        this.c.setInput(this.d, 0, i);
    }

    @Override // defpackage.pw0, java.io.InputStream
    public int read() throws IOException {
        if (read(this.e) == -1) {
            return -1;
        }
        return this.e[0];
    }

    @Override // defpackage.pw0, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // defpackage.pw0, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        while (true) {
            try {
                int iInflate = this.c.inflate(bArr, i, i2);
                if (iInflate != 0) {
                    return iInflate;
                }
                if (!this.c.finished() && !this.c.needsDictionary()) {
                    if (this.c.needsInput()) {
                        e();
                    }
                }
                return -1;
            } catch (DataFormatException e) {
                throw new IOException(e);
            }
        }
    }
}
