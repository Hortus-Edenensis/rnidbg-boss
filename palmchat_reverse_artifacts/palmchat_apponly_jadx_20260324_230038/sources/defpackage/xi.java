package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class xi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f21965a;
    public final File b;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends OutputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FileOutputStream f21966a;
        public boolean b = false;

        public a(File file) throws FileNotFoundException {
            this.f21966a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            this.b = true;
            flush();
            try {
                this.f21966a.getFD().sync();
            } catch (IOException e) {
                y53.j("AtomicFile", "Failed to sync file descriptor:", e);
            }
            this.f21966a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.f21966a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f21966a.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f21966a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f21966a.write(bArr, i, i2);
        }
    }

    public xi(File file) {
        this.f21965a = file;
        this.b = new File(file.getPath() + ".bak");
    }

    public void a() {
        this.f21965a.delete();
        this.b.delete();
    }

    public void b(OutputStream outputStream) throws IOException {
        outputStream.close();
        this.b.delete();
    }

    public boolean c() {
        return this.f21965a.exists() || this.b.exists();
    }

    public InputStream d() throws FileNotFoundException {
        e();
        return new FileInputStream(this.f21965a);
    }

    public final void e() {
        if (this.b.exists()) {
            this.f21965a.delete();
            this.b.renameTo(this.f21965a);
        }
    }

    public OutputStream f() throws IOException {
        if (this.f21965a.exists()) {
            if (this.b.exists()) {
                this.f21965a.delete();
            } else if (!this.f21965a.renameTo(this.b)) {
                y53.i("AtomicFile", "Couldn't rename file " + this.f21965a + " to backup file " + this.b);
            }
        }
        try {
            return new a(this.f21965a);
        } catch (FileNotFoundException e) {
            File parentFile = this.f21965a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.f21965a, e);
            }
            try {
                return new a(this.f21965a);
            } catch (FileNotFoundException e2) {
                throw new IOException("Couldn't create " + this.f21965a, e2);
            }
        }
    }
}
