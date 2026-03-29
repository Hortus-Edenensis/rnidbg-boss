package defpackage;

import defpackage.ei;
import defpackage.ls1;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.enums.RandomAccessFileMode;
import net.lingala.zip4j.progress.ProgressMonitor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class cr6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f16904a;
    public fr6 b;
    public boolean c;
    public ProgressMonitor d;
    public boolean e;
    public char[] f;
    public bh2 g;
    public Charset h;
    public ThreadFactory i;
    public ExecutorService j;
    public int k;

    public cr6(String str) {
        this(new File(str), null);
    }

    public final ei.a a() {
        if (this.e) {
            if (this.i == null) {
                this.i = Executors.defaultThreadFactory();
            }
            this.j = Executors.newSingleThreadExecutor(this.i);
        }
        return new ei.a(this.j, this.e, this.d);
    }

    public final vq6 b() {
        return new vq6(this.h, this.k);
    }

    public final void c() {
        fr6 fr6Var = new fr6();
        this.b = fr6Var;
        fr6Var.o(this.f16904a);
    }

    public void d(String str) throws ZipException {
        e(str, new y46());
    }

    public void e(String str, y46 y46Var) throws ZipException {
        if (!wq6.f(str)) {
            throw new ZipException("output path is null or invalid");
        }
        if (!wq6.b(new File(str))) {
            throw new ZipException("invalid output path");
        }
        if (this.b == null) {
            j();
        }
        fr6 fr6Var = this.b;
        if (fr6Var == null) {
            throw new ZipException("Internal error occurred when extracting zip file");
        }
        new ls1(fr6Var, this.f, y46Var, a()).c(new ls1.a(str, b()));
    }

    public List<File> f() throws ZipException {
        j();
        return jv1.j(this.b);
    }

    public final RandomAccessFile g() throws IOException {
        if (!jv1.l(this.f16904a)) {
            return new RandomAccessFile(this.f16904a, RandomAccessFileMode.READ.getValue());
        }
        e44 e44Var = new e44(this.f16904a, RandomAccessFileMode.READ.getValue(), jv1.e(this.f16904a));
        e44Var.c();
        return e44Var;
    }

    public boolean h() throws ZipException {
        if (this.b == null) {
            j();
            if (this.b == null) {
                throw new ZipException("Zip Model is null");
            }
        }
        if (this.b.a() == null || this.b.a().a() == null) {
            throw new ZipException("invalid zip file");
        }
        Iterator<eu1> it = this.b.a().a().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            eu1 next = it.next();
            if (next != null && next.p()) {
                this.c = true;
                break;
            }
        }
        return this.c;
    }

    public boolean i() {
        if (!this.f16904a.exists()) {
            return false;
        }
        try {
            j();
            if (this.b.g()) {
                return l(f());
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void j() throws ZipException {
        if (this.b != null) {
            return;
        }
        if (!this.f16904a.exists()) {
            c();
            return;
        }
        if (!this.f16904a.canRead()) {
            throw new ZipException("no read access for the input zip file");
        }
        try {
            RandomAccessFile randomAccessFileG = g();
            try {
                fr6 fr6VarI = new zg2().i(randomAccessFileG, b());
                this.b = fr6VarI;
                fr6VarI.o(this.f16904a);
                if (randomAccessFileG != null) {
                    randomAccessFileG.close();
                }
            } finally {
            }
        } catch (ZipException e) {
            throw e;
        } catch (IOException e2) {
            throw new ZipException(e2);
        }
    }

    public void k(char[] cArr) {
        this.f = cArr;
    }

    public final boolean l(List<File> list) {
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().exists()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return this.f16904a.toString();
    }

    public cr6(File file, char[] cArr) {
        this.g = new bh2();
        this.h = null;
        this.k = 4096;
        if (file == null) {
            throw new IllegalArgumentException("input zip file parameter is null");
        }
        this.f16904a = file;
        this.f = cArr;
        this.e = false;
        this.d = new ProgressMonitor();
    }
}
