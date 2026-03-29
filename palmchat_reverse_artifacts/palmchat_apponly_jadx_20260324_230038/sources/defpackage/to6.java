package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class to6 extends yv {
    @Override // defpackage.yv, defpackage.hm1
    public void a(km1 km1Var) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!km1Var.i()) {
                break;
            }
            char c = km1Var.c();
            km1Var.f++;
            c(c, sb);
            if (sb.length() % 3 == 0) {
                yv.g(km1Var, sb);
                int iN = uh2.n(km1Var.d(), km1Var.f, e());
                if (iN != e()) {
                    km1Var.o(iN);
                    break;
                }
            }
        }
        f(km1Var, sb);
    }

    @Override // defpackage.yv
    public int c(char c, StringBuilder sb) {
        if (c == '\r') {
            sb.append((char) 0);
        } else if (c == '*') {
            sb.append((char) 1);
        } else if (c == '>') {
            sb.append((char) 2);
        } else if (c == ' ') {
            sb.append((char) 3);
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
        } else if (c < 'A' || c > 'Z') {
            uh2.e(c);
        } else {
            sb.append((char) ((c - 'A') + 14));
        }
        return 1;
    }

    @Override // defpackage.yv
    public int e() {
        return 3;
    }

    @Override // defpackage.yv
    public void f(km1 km1Var, StringBuilder sb) {
        km1Var.p();
        int iA = km1Var.g().a() - km1Var.a();
        km1Var.f -= sb.length();
        if (km1Var.f() > 1 || iA > 1 || km1Var.f() != iA) {
            km1Var.r((char) 254);
        }
        if (km1Var.e() < 0) {
            km1Var.o(0);
        }
    }
}
