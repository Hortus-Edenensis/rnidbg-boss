package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class d0 implements hm1 {
    public static char b(char c, char c2) {
        if (uh2.f(c) && uh2.f(c2)) {
            return (char) (((c - '0') * 10) + (c2 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c + c2);
    }

    @Override // defpackage.hm1
    public void a(km1 km1Var) {
        if (uh2.a(km1Var.d(), km1Var.f) >= 2) {
            km1Var.r(b(km1Var.d().charAt(km1Var.f), km1Var.d().charAt(km1Var.f + 1)));
            km1Var.f += 2;
            return;
        }
        char c = km1Var.c();
        int iN = uh2.n(km1Var.d(), km1Var.f, c());
        if (iN == c()) {
            if (!uh2.g(c)) {
                km1Var.r((char) (c + 1));
                km1Var.f++;
                return;
            } else {
                km1Var.r((char) 235);
                km1Var.r((char) ((c - 128) + 1));
                km1Var.f++;
                return;
            }
        }
        if (iN == 1) {
            km1Var.r((char) 230);
            km1Var.o(1);
            return;
        }
        if (iN == 2) {
            km1Var.r((char) 239);
            km1Var.o(2);
            return;
        }
        if (iN == 3) {
            km1Var.r((char) 238);
            km1Var.o(3);
        } else if (iN == 4) {
            km1Var.r((char) 240);
            km1Var.o(4);
        } else if (iN == 5) {
            km1Var.r((char) 231);
            km1Var.o(5);
        } else {
            throw new IllegalStateException("Illegal mode: " + iN);
        }
    }

    public int c() {
        return 0;
    }
}
