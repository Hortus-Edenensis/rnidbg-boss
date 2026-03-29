package defpackage;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;
import kotlin.UByte;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;
import net.lingala.zip4j.model.enums.EncryptionMethod;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class er6 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PushbackInputStream f17347a;
    public pw0 b;
    public char[] d;
    public u43 e;
    public byte[] g;
    public vq6 i;
    public zg2 c = new zg2();
    public CRC32 f = new CRC32();
    public boolean h = false;
    public boolean j = false;
    public boolean k = false;

    public er6(InputStream inputStream, char[] cArr, vq6 vq6Var) {
        if (vq6Var.a() < 512) {
            throw new IllegalArgumentException("Buffer size cannot be less than 512 bytes");
        }
        this.f17347a = new PushbackInputStream(inputStream, vq6Var.a());
        this.d = cArr;
        this.i = vq6Var;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        c();
        return !this.k ? 1 : 0;
    }

    public final void c() throws IOException {
        if (this.j) {
            throw new IOException("Stream closed");
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        pw0 pw0Var = this.b;
        if (pw0Var != null) {
            pw0Var.close();
        }
        this.j = true;
    }

    public final boolean d(List<is1> list) {
        if (list == null) {
            return false;
        }
        Iterator<is1> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().c() == HeaderSignature.ZIP64_EXTRA_FIELD_SIGNATURE.getValue()) {
                return true;
            }
        }
        return false;
    }

    public final void e() throws IOException {
        this.b.d(this.f17347a);
        this.b.a(this.f17347a);
        p();
        s();
        r();
        this.k = true;
    }

    public final long f(u43 u43Var) {
        if (wq6.e(u43Var).equals(CompressionMethod.STORE)) {
            return u43Var.l();
        }
        if (!u43Var.n() || this.h) {
            return u43Var.c() - ((long) g(u43Var));
        }
        return -1L;
    }

    public final int g(u43 u43Var) {
        if (u43Var.p()) {
            return u43Var.f().equals(EncryptionMethod.AES) ? u43Var.b().b().getSaltLength() + 12 : u43Var.f().equals(EncryptionMethod.ZIP_STANDARD) ? 12 : 0;
        }
        return 0;
    }

    public u43 h(eu1 eu1Var) throws IOException {
        if (this.e != null) {
            q();
        }
        u43 u43VarQ = this.c.q(this.f17347a, this.i.b());
        this.e = u43VarQ;
        if (u43VarQ == null) {
            return null;
        }
        t(u43VarQ);
        this.f.reset();
        if (eu1Var != null) {
            this.e.u(eu1Var.e());
            this.e.s(eu1Var.c());
            this.e.G(eu1Var.l());
            this.e.w(eu1Var.o());
            this.h = true;
        } else {
            this.h = false;
        }
        this.b = k(this.e);
        this.k = false;
        return this.e;
    }

    public final f60 i(br6 br6Var, u43 u43Var) throws IOException {
        if (!u43Var.p()) {
            return new hy3(br6Var, u43Var, this.d, this.i.a());
        }
        if (u43Var.f() == EncryptionMethod.AES) {
            return new h8(br6Var, u43Var, this.d, this.i.a());
        }
        if (u43Var.f() == EncryptionMethod.ZIP_STANDARD) {
            return new gr6(br6Var, u43Var, this.d, this.i.a());
        }
        throw new ZipException(String.format("Entry [%s] Strong Encryption not supported", u43Var.i()), ZipException.Type.UNSUPPORTED_ENCRYPTION);
    }

    public final pw0 j(f60 f60Var, u43 u43Var) {
        return wq6.e(u43Var) == CompressionMethod.DEFLATE ? new rs2(f60Var, this.i.a()) : new yk5(f60Var);
    }

    public final pw0 k(u43 u43Var) throws IOException {
        return j(i(new br6(this.f17347a, f(u43Var)), u43Var), u43Var);
    }

    public final boolean l(u43 u43Var) {
        return u43Var.p() && EncryptionMethod.ZIP_STANDARD.equals(u43Var.f());
    }

    public final boolean m(String str) {
        return str.endsWith("/") || str.endsWith("\\");
    }

    public final void p() throws IOException {
        if (!this.e.n() || this.h) {
            return;
        }
        mu0 mu0VarK = this.c.k(this.f17347a, d(this.e.g()));
        this.e.s(mu0VarK.b());
        this.e.G(mu0VarK.d());
        this.e.u(mu0VarK.c());
    }

    public final void q() throws IOException {
        if ((this.e.o() || this.e.c() == 0) && !this.e.n()) {
            return;
        }
        if (this.g == null) {
            this.g = new byte[512];
        }
        while (read(this.g) != -1) {
        }
        this.k = true;
    }

    public final void r() {
        this.e = null;
        this.f.reset();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        byte[] bArr = new byte[1];
        if (read(bArr) == -1) {
            return -1;
        }
        return bArr[0] & UByte.MAX_VALUE;
    }

    public final void s() throws IOException {
        if ((this.e.f() == EncryptionMethod.AES && this.e.b().c().equals(AesVersion.TWO)) || this.e.e() == this.f.getValue()) {
            return;
        }
        ZipException.Type type = ZipException.Type.CHECKSUM_MISMATCH;
        if (l(this.e)) {
            type = ZipException.Type.WRONG_PASSWORD;
        }
        throw new ZipException("Reached end of entry, but crc verification failed for " + this.e.i(), type);
    }

    public final void t(u43 u43Var) throws IOException {
        if (m(u43Var.i()) || u43Var.d() != CompressionMethod.STORE || u43Var.l() >= 0) {
            return;
        }
        throw new IOException("Invalid local file header for: " + u43Var.i() + ". Uncompressed size has to be set for entry of compression type store which is not a directory");
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 < 0) {
            throw new IllegalArgumentException("Negative read length");
        }
        if (i2 == 0) {
            return 0;
        }
        u43 u43Var = this.e;
        if (u43Var == null || u43Var.o()) {
            return -1;
        }
        try {
            int i3 = this.b.read(bArr, i, i2);
            if (i3 == -1) {
                e();
            } else {
                this.f.update(bArr, i, i3);
            }
            return i3;
        } catch (IOException e) {
            if (l(this.e)) {
                throw new ZipException(e.getMessage(), e.getCause(), ZipException.Type.WRONG_PASSWORD);
            }
            throw e;
        }
    }
}
