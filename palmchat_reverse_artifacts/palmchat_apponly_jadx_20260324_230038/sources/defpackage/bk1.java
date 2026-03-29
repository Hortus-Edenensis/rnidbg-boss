package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class bk1 implements hm1 {
    public static void b(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c < '@' || c > '^') {
            uh2.e(c);
        } else {
            sb.append((char) (c - '@'));
        }
    }

    public static String c(CharSequence charSequence, int i) {
        int length = charSequence.length() - i;
        if (length == 0) {
            throw new IllegalStateException("StringBuilder must not be empty");
        }
        int iCharAt = (charSequence.charAt(i) << 18) + ((length >= 2 ? charSequence.charAt(i + 1) : (char) 0) << '\f') + ((length >= 3 ? charSequence.charAt(i + 2) : (char) 0) << 6) + (length >= 4 ? charSequence.charAt(i + 3) : (char) 0);
        char c = (char) ((iCharAt >> 16) & 255);
        char c2 = (char) ((iCharAt >> 8) & 255);
        char c3 = (char) (iCharAt & 255);
        StringBuilder sb = new StringBuilder(3);
        sb.append(c);
        if (length >= 2) {
            sb.append(c2);
        }
        if (length >= 3) {
            sb.append(c3);
        }
        return sb.toString();
    }

    public static void e(km1 km1Var, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length == 0) {
                return;
            }
            boolean z = true;
            if (length == 1) {
                km1Var.p();
                int iA = km1Var.g().a() - km1Var.a();
                if (km1Var.f() == 0 && iA <= 2) {
                    return;
                }
            }
            if (length > 4) {
                throw new IllegalStateException("Count must not exceed 4");
            }
            int i = length - 1;
            String strC = c(charSequence, 0);
            if (!(!km1Var.i()) || i > 2) {
                z = false;
            }
            if (i <= 2) {
                km1Var.q(km1Var.a() + i);
                if (km1Var.g().a() - km1Var.a() >= 3) {
                    km1Var.q(km1Var.a() + strC.length());
                    z = false;
                }
            }
            if (z) {
                km1Var.k();
                km1Var.f -= i;
            } else {
                km1Var.s(strC);
            }
        } finally {
            km1Var.o(0);
        }
    }

    @Override // defpackage.hm1
    public void a(km1 km1Var) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!km1Var.i()) {
                break;
            }
            b(km1Var.c(), sb);
            km1Var.f++;
            if (sb.length() >= 4) {
                km1Var.s(c(sb, 0));
                sb.delete(0, 4);
                if (uh2.n(km1Var.d(), km1Var.f, d()) != d()) {
                    km1Var.o(0);
                    break;
                }
            }
        }
        sb.append((char) 31);
        e(km1Var, sb);
    }

    public int d() {
        return 4;
    }
}
