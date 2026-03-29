package defpackage;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ak6 {
    public static final Pattern c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    public static final Pattern d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gc4 f1247a = new gc4();
    public final StringBuilder b = new StringBuilder();

    public static boolean b(gc4 gc4Var) {
        int iF = gc4Var.f();
        int iG = gc4Var.g();
        byte[] bArrE = gc4Var.e();
        if (iF + 2 > iG) {
            return false;
        }
        int i = iF + 1;
        if (bArrE[iF] != 47) {
            return false;
        }
        int i2 = i + 1;
        if (bArrE[i] != 42) {
            return false;
        }
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iG) {
                gc4Var.V(iG - gc4Var.f());
                return true;
            }
            if (((char) bArrE[i2]) == '*' && ((char) bArrE[i3]) == '/') {
                i2 = i3 + 1;
                iG = i2;
            } else {
                i2 = i3;
            }
        }
    }

    public static boolean c(gc4 gc4Var) {
        char cK = k(gc4Var, gc4Var.f());
        if (cK != '\t' && cK != '\n' && cK != '\f' && cK != '\r' && cK != ' ') {
            return false;
        }
        gc4Var.V(1);
        return true;
    }

    public static void e(String str, bk6 bk6Var) {
        Matcher matcher = d.matcher(th.e(str));
        if (!matcher.matches()) {
            y53.i("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) vh.e(matcher.group(2));
        str2.hashCode();
        switch (str2) {
            case "%":
                bk6Var.t(3);
                break;
            case "em":
                bk6Var.t(2);
                break;
            case "px":
                bk6Var.t(1);
                break;
            default:
                throw new IllegalStateException();
        }
        bk6Var.s(Float.parseFloat((String) vh.e(matcher.group(1))));
    }

    public static String f(gc4 gc4Var, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int iF = gc4Var.f();
        int iG = gc4Var.g();
        while (iF < iG && !z) {
            char c2 = (char) gc4Var.e()[iF];
            if ((c2 < 'A' || c2 > 'Z') && ((c2 < 'a' || c2 > 'z') && !((c2 >= '0' && c2 <= '9') || c2 == '#' || c2 == '-' || c2 == '.' || c2 == '_'))) {
                z = true;
            } else {
                iF++;
                sb.append(c2);
            }
        }
        gc4Var.V(iF - gc4Var.f());
        return sb.toString();
    }

    @Nullable
    public static String g(gc4 gc4Var, StringBuilder sb) {
        n(gc4Var);
        if (gc4Var.a() == 0) {
            return null;
        }
        String strF = f(gc4Var, sb);
        if (!"".equals(strF)) {
            return strF;
        }
        return "" + ((char) gc4Var.H());
    }

    @Nullable
    public static String h(gc4 gc4Var, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int iF = gc4Var.f();
            String strG = g(gc4Var, sb);
            if (strG == null) {
                return null;
            }
            if ("}".equals(strG) || x.aQ.equals(strG)) {
                gc4Var.U(iF);
                z = true;
            } else {
                sb2.append(strG);
            }
        }
        return sb2.toString();
    }

    @Nullable
    public static String i(gc4 gc4Var, StringBuilder sb) {
        n(gc4Var);
        if (gc4Var.a() < 5 || !"::cue".equals(gc4Var.E(5))) {
            return null;
        }
        int iF = gc4Var.f();
        String strG = g(gc4Var, sb);
        if (strG == null) {
            return null;
        }
        if ("{".equals(strG)) {
            gc4Var.U(iF);
            return "";
        }
        String strL = "(".equals(strG) ? l(gc4Var) : null;
        if (")".equals(g(gc4Var, sb))) {
            return strL;
        }
        return null;
    }

    public static void j(gc4 gc4Var, bk6 bk6Var, StringBuilder sb) {
        n(gc4Var);
        String strF = f(gc4Var, sb);
        if (!"".equals(strF) && ":".equals(g(gc4Var, sb))) {
            n(gc4Var);
            String strH = h(gc4Var, sb);
            if (strH == null || "".equals(strH)) {
                return;
            }
            int iF = gc4Var.f();
            String strG = g(gc4Var, sb);
            if (!x.aQ.equals(strG)) {
                if (!"}".equals(strG)) {
                    return;
                } else {
                    gc4Var.U(iF);
                }
            }
            if ("color".equals(strF)) {
                bk6Var.q(qh0.b(strH));
                return;
            }
            if ("background-color".equals(strF)) {
                bk6Var.n(qh0.b(strH));
                return;
            }
            boolean z = true;
            if ("ruby-position".equals(strF)) {
                if ("over".equals(strH)) {
                    bk6Var.v(1);
                    return;
                } else {
                    if ("under".equals(strH)) {
                        bk6Var.v(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(strF)) {
                if (!"all".equals(strH) && !strH.startsWith("digits")) {
                    z = false;
                }
                bk6Var.p(z);
                return;
            }
            if ("text-decoration".equals(strF)) {
                if ("underline".equals(strH)) {
                    bk6Var.A(true);
                    return;
                }
                return;
            }
            if ("font-family".equals(strF)) {
                bk6Var.r(strH);
                return;
            }
            if ("font-weight".equals(strF)) {
                if ("bold".equals(strH)) {
                    bk6Var.o(true);
                }
            } else if ("font-style".equals(strF)) {
                if ("italic".equals(strH)) {
                    bk6Var.u(true);
                }
            } else if ("font-size".equals(strF)) {
                e(strH, bk6Var);
            }
        }
    }

    public static char k(gc4 gc4Var, int i) {
        return (char) gc4Var.e()[i];
    }

    public static String l(gc4 gc4Var) {
        int iF = gc4Var.f();
        int iG = gc4Var.g();
        boolean z = false;
        while (iF < iG && !z) {
            int i = iF + 1;
            z = ((char) gc4Var.e()[iF]) == ')';
            iF = i;
        }
        return gc4Var.E((iF - 1) - gc4Var.f()).trim();
    }

    public static void m(gc4 gc4Var) {
        while (!TextUtils.isEmpty(gc4Var.s())) {
        }
    }

    public static void n(gc4 gc4Var) {
        while (true) {
            for (boolean z = true; gc4Var.a() > 0 && z; z = false) {
                if (c(gc4Var) || b(gc4Var)) {
                    break;
                }
            }
            return;
        }
    }

    public final void a(bk6 bk6Var, String str) {
        if ("".equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            Matcher matcher = c.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                bk6Var.z((String) vh.e(matcher.group(1)));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrZ0 = g86.Z0(str, "\\.");
        String str2 = strArrZ0[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            bk6Var.y(str2.substring(0, iIndexOf2));
            bk6Var.x(str2.substring(iIndexOf2 + 1));
        } else {
            bk6Var.y(str2);
        }
        if (strArrZ0.length > 1) {
            bk6Var.w((String[]) g86.N0(strArrZ0, 1, strArrZ0.length));
        }
    }

    public List<bk6> d(gc4 gc4Var) {
        this.b.setLength(0);
        int iF = gc4Var.f();
        m(gc4Var);
        this.f1247a.S(gc4Var.e(), gc4Var.f());
        this.f1247a.U(iF);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strI = i(this.f1247a, this.b);
            if (strI == null) {
                return arrayList;
            }
            if (!"{".equals(g(this.f1247a, this.b))) {
                return arrayList;
            }
            bk6 bk6Var = new bk6();
            a(bk6Var, strI);
            String str = null;
            boolean z = false;
            while (!z) {
                int iF2 = this.f1247a.f();
                String strG = g(this.f1247a, this.b);
                boolean z2 = strG == null || "}".equals(strG);
                if (!z2) {
                    this.f1247a.U(iF2);
                    j(this.f1247a, bk6Var, this.b);
                }
                str = strG;
                z = z2;
            }
            if ("}".equals(str)) {
                arrayList.add(bk6Var);
            }
        }
    }
}
