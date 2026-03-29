package defpackage;

import defpackage.ei;
import java.io.IOException;
import net.lingala.zip4j.progress.ProgressMonitor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ls1 extends c1<a> {
    public final char[] f;
    public ih5 g;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends b2 {
        public final String b;

        public a(String str, vq6 vq6Var) {
            super(vq6Var);
            this.b = str;
        }
    }

    public ls1(fr6 fr6Var, char[] cArr, y46 y46Var, ei.a aVar) {
        super(fr6Var, y46Var, aVar);
        this.f = cArr;
    }

    @Override // defpackage.ei
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public long b(a aVar) {
        return ah2.c(o().a().a());
    }

    @Override // defpackage.ei
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void d(a aVar, ProgressMonitor progressMonitor) throws IOException {
        try {
            er6 er6VarW = w(aVar.f1629a);
            try {
                for (eu1 eu1Var : o().a().a()) {
                    if (eu1Var.i().startsWith("__MACOSX")) {
                        progressMonitor.l(eu1Var.l());
                    } else {
                        this.g.d(eu1Var);
                        m(er6VarW, eu1Var, aVar.b, null, progressMonitor, new byte[aVar.f1629a.a()]);
                        i();
                    }
                }
                if (er6VarW != null) {
                    er6VarW.close();
                }
            } finally {
            }
        } finally {
            ih5 ih5Var = this.g;
            if (ih5Var != null) {
                ih5Var.close();
            }
        }
    }

    public final eu1 v(fr6 fr6Var) {
        if (fr6Var.a() == null || fr6Var.a().a() == null || fr6Var.a().a().size() == 0) {
            return null;
        }
        return fr6Var.a().a().get(0);
    }

    public final er6 w(vq6 vq6Var) throws IOException {
        this.g = z46.b(o());
        eu1 eu1VarV = v(o());
        if (eu1VarV != null) {
            this.g.d(eu1VarV);
        }
        return new er6(this.g, this.f, vq6Var);
    }
}
