package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class yv implements hm1 {
    public static String d(CharSequence charSequence, int i) {
        int iCharAt = (charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * '(') + charSequence.charAt(i + 2) + 1;
        return new String(new char[]{(char) (iCharAt / 256), (char) (iCharAt % 256)});
    }

    public static void g(km1 km1Var, StringBuilder sb) {
        km1Var.s(d(sb, 0));
        sb.delete(0, 3);
    }

    @Override // defpackage.hm1
    public void a(km1 km1Var) {
        int iN;
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!km1Var.i()) {
                break;
            }
            char c = km1Var.c();
            km1Var.f++;
            int iC = c(c, sb);
            int iA = km1Var.a() + ((sb.length() / 3) << 1);
            km1Var.q(iA);
            int iA2 = km1Var.g().a() - iA;
            if (!km1Var.i()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (iA2 < 2 || iA2 > 2)) {
                    iC = b(km1Var, sb, sb2, iC);
                }
                while (sb.length() % 3 == 1 && ((iC <= 3 && iA2 != 1) || iC > 3)) {
                    iC = b(km1Var, sb, sb2, iC);
                }
            } else if (sb.length() % 3 == 0 && (iN = uh2.n(km1Var.d(), km1Var.f, e())) != e()) {
                km1Var.o(iN);
                break;
            }
        }
        f(km1Var, sb);
    }

    public final int b(km1 km1Var, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        km1Var.f--;
        int iC = c(km1Var.c(), sb2);
        km1Var.k();
        return iC;
    }

    public int c(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        }
        if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        }
        if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
            return 1;
        }
        if (c >= 0 && c <= 31) {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        }
        if (c >= '!' && c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        }
        if (c >= ':' && c <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        }
        if (c >= '[' && c <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        }
        if (c >= '`' && c <= 127) {
            sb.append((char) 2);
            sb.append((char) (c - '`'));
            return 2;
        }
        if (c >= 128) {
            sb.append("\u0001\u001e");
            return c((char) (c - 128), sb) + 2;
        }
        throw new IllegalArgumentException("Illegal character: " + c);
    }

    public int e() {
        return 1;
    }

    public void f(km1 km1Var, StringBuilder sb) {
        int length = (sb.length() / 3) << 1;
        int length2 = sb.length() % 3;
        int iA = km1Var.a() + length;
        km1Var.q(iA);
        int iA2 = km1Var.g().a() - iA;
        if (length2 == 2) {
            sb.append((char) 0);
            while (sb.length() >= 3) {
                g(km1Var, sb);
            }
            if (km1Var.i()) {
                km1Var.r((char) 254);
            }
        } else if (iA2 == 1 && length2 == 1) {
            while (sb.length() >= 3) {
                g(km1Var, sb);
            }
            if (km1Var.i()) {
                km1Var.r((char) 254);
            }
            km1Var.f--;
        } else {
            if (length2 != 0) {
                throw new IllegalStateException("Unexpected case. Please report!");
            }
            while (sb.length() >= 3) {
                g(km1Var, sb);
            }
            if (iA2 > 0 || km1Var.i()) {
                km1Var.r((char) 254);
            }
        }
        km1Var.o(0);
    }
}
