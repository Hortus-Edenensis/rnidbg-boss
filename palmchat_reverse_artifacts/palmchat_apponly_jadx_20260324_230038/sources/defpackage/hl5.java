package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class hl5 extends eq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Appendable f17991a;

    public hl5() {
        this(new StringBuilder());
    }

    public static String k(f55 f55Var) {
        return l(f55Var);
    }

    public static String l(f55 f55Var) {
        return new hl5().e(f55Var).toString();
    }

    @Override // defpackage.eq
    public void c(char c) {
        try {
            this.f17991a.append(c);
        } catch (IOException e) {
            throw new RuntimeException("Could not write description", e);
        }
    }

    @Override // defpackage.eq
    public void d(String str) {
        try {
            this.f17991a.append(str);
        } catch (IOException e) {
            throw new RuntimeException("Could not write description", e);
        }
    }

    public String toString() {
        return this.f17991a.toString();
    }

    public hl5(Appendable appendable) {
        this.f17991a = appendable;
    }
}
