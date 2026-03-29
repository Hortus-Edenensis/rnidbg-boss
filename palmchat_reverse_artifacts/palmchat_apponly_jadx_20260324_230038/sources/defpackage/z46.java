package defpackage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class z46 {
    public static void a(eu1 eu1Var, File file) {
        try {
            Path path = file.toPath();
            jv1.p(path, eu1Var.K());
            jv1.q(path, eu1Var.k());
        } catch (NoSuchMethodError unused) {
            jv1.r(file, eu1Var.k());
        }
    }

    public static ih5 b(fr6 fr6Var) throws IOException {
        return fr6Var.f().getName().endsWith(".zip.001") ? new d44(fr6Var.f(), true, fr6Var.c().b()) : new hr6(fr6Var.f(), fr6Var.g(), fr6Var.c().b());
    }
}
