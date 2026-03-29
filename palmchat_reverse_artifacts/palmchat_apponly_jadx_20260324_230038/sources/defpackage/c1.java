package defpackage;

import defpackage.ei;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.regex.Matcher;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.progress.ProgressMonitor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c1<T> extends ei<T> {
    public final fr6 d;
    public final y46 e;

    public c1(fr6 fr6Var, y46 y46Var, ei.a aVar) {
        super(aVar);
        this.d = fr6Var;
        this.e = y46Var;
    }

    @Override // defpackage.ei
    public ProgressMonitor.Task e() {
        return ProgressMonitor.Task.EXTRACT_ENTRY;
    }

    public final void j(File file) throws ZipException {
        if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
            return;
        }
        throw new ZipException("Unable to create parent directories: " + file.getParentFile());
    }

    public final void k(er6 er6Var, eu1 eu1Var, File file, ProgressMonitor progressMonitor) throws IOException {
        String str = new String(q(er6Var, eu1Var, progressMonitor));
        if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
            throw new ZipException("Could not create parent directories");
        }
        try {
            Files.createSymbolicLink(file.toPath(), Paths.get(str, new String[0]), new FileAttribute[0]);
        } catch (NoSuchMethodError unused) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
    }

    public final File l(eu1 eu1Var, String str, String str2) {
        if (!wq6.f(str2)) {
            str2 = n(eu1Var.i());
        }
        return new File(str + au2.f1571a + str2);
    }

    public void m(er6 er6Var, eu1 eu1Var, String str, String str2, ProgressMonitor progressMonitor, byte[] bArr) throws Exception {
        if (!p(eu1Var) || this.e.a()) {
            String str3 = au2.f1571a;
            if (!str.endsWith(str3)) {
                str = str + str3;
            }
            File fileL = l(eu1Var, str, str2);
            progressMonitor.h(fileL.getAbsolutePath());
            if (!fileL.getCanonicalPath().startsWith(new File(str).getCanonicalPath() + File.separator)) {
                throw new ZipException("illegal file name that breaks out of the target directory: " + eu1Var.i());
            }
            s(er6Var, eu1Var);
            if (eu1Var.o()) {
                if (!fileL.exists() && !fileL.mkdirs()) {
                    throw new ZipException("Could not create directory: " + fileL);
                }
            } else if (p(eu1Var)) {
                k(er6Var, eu1Var, fileL, progressMonitor);
            } else {
                j(fileL);
                r(er6Var, fileL, progressMonitor, bArr);
            }
            z46.a(eu1Var, fileL);
        }
    }

    public final String n(String str) {
        return str.replaceAll("[/\\\\]", Matcher.quoteReplacement(au2.f1571a));
    }

    public fr6 o() {
        return this.d;
    }

    public final boolean p(eu1 eu1Var) {
        byte[] bArrK = eu1Var.K();
        if (bArrK == null || bArrK.length < 4) {
            return false;
        }
        return nt.a(bArrK[3], 5);
    }

    public final byte[] q(er6 er6Var, eu1 eu1Var, ProgressMonitor progressMonitor) throws IOException {
        int iL = (int) eu1Var.l();
        byte[] bArr = new byte[iL];
        if (er6Var.read(bArr) != iL) {
            throw new ZipException("Could not read complete entry");
        }
        progressMonitor.l(iL);
        return bArr;
    }

    public final void r(er6 er6Var, File file, ProgressMonitor progressMonitor, byte[] bArr) throws Exception {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            while (true) {
                try {
                    int i = er6Var.read(bArr);
                    if (i == -1) {
                        fileOutputStream.close();
                        return;
                    } else {
                        fileOutputStream.write(bArr, 0, i);
                        progressMonitor.l(i);
                        i();
                    }
                } finally {
                }
            }
        } catch (Exception e) {
            if (file.exists()) {
                file.delete();
            }
            throw e;
        }
    }

    public final void s(er6 er6Var, eu1 eu1Var) throws IOException {
        if (nt.a(eu1Var.j()[0], 6)) {
            throw new ZipException("Entry with name " + eu1Var.i() + " is encrypted with Strong Encryption. Zip4j does not support Strong Encryption, as this is patented.");
        }
        u43 u43VarH = er6Var.h(eu1Var);
        if (u43VarH != null) {
            if (!eu1Var.i().equals(u43VarH.i())) {
                throw new ZipException("File header and local file header mismatch");
            }
        } else {
            throw new ZipException("Could not read corresponding local file header for file header: " + eu1Var.i());
        }
    }
}
