package com.opos.exoplayer.core.text.webvtt;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.opos.exoplayer.core.util.p;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f8362a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final p b = new p();
    private final StringBuilder c = new StringBuilder();

    private static char a(p pVar, int i) {
        return (char) pVar.f8400a[i];
    }

    private static String b(p pVar, StringBuilder sb) {
        a(pVar);
        if (pVar.b() < 5 || !"::cue".equals(pVar.e(5))) {
            return null;
        }
        int iD = pVar.d();
        String strA = a(pVar, sb);
        if (strA == null) {
            return null;
        }
        if ("{".equals(strA)) {
            pVar.c(iD);
            return "";
        }
        String strD = "(".equals(strA) ? d(pVar) : null;
        String strA2 = a(pVar, sb);
        if (!")".equals(strA2) || strA2 == null) {
            return null;
        }
        return strD;
    }

    private static String d(p pVar) {
        int i;
        int iD = pVar.d();
        int iC = pVar.c();
        loop0: while (true) {
            boolean z = false;
            while (iD < iC && !z) {
                i = iD + 1;
                if (((char) pVar.f8400a[iD]) == ')') {
                    z = true;
                    iD = i;
                }
            }
            iD = i;
        }
        return pVar.e((iD - 1) - pVar.d()).trim();
    }

    private static boolean e(p pVar) {
        char cA = a(pVar, pVar.d());
        if (cA != '\t' && cA != '\n' && cA != '\f' && cA != '\r' && cA != ' ') {
            return false;
        }
        pVar.d(1);
        return true;
    }

    private static boolean f(p pVar) {
        int iD = pVar.d();
        int iC = pVar.c();
        byte[] bArr = pVar.f8400a;
        if (iD + 2 > iC) {
            return false;
        }
        int i = iD + 1;
        if (bArr[iD] != 47) {
            return false;
        }
        int i2 = i + 1;
        if (bArr[i] != 42) {
            return false;
        }
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iC) {
                pVar.d(iC - pVar.d());
                return true;
            }
            if (((char) bArr[i2]) == '*' && ((char) bArr[i3]) == '/') {
                i2 = i3 + 1;
                iC = i2;
            } else {
                i2 = i3;
            }
        }
    }

    public WebvttCssStyle c(p pVar) {
        this.c.setLength(0);
        int iD = pVar.d();
        b(pVar);
        this.b.a(pVar.f8400a, pVar.d());
        this.b.c(iD);
        String strB = b(this.b, this.c);
        if (strB == null || !"{".equals(a(this.b, this.c))) {
            return null;
        }
        WebvttCssStyle webvttCssStyle = new WebvttCssStyle();
        a(webvttCssStyle, strB);
        String strA = null;
        boolean z = false;
        while (!z) {
            int iD2 = this.b.d();
            strA = a(this.b, this.c);
            boolean z2 = strA == null || "}".equals(strA);
            if (!z2) {
                this.b.c(iD2);
                a(this.b, webvttCssStyle, this.c);
            }
            z = z2;
        }
        if ("}".equals(strA)) {
            return webvttCssStyle;
        }
        return null;
    }

    public static String a(p pVar, StringBuilder sb) {
        a(pVar);
        if (pVar.b() == 0) {
            return null;
        }
        String strD = d(pVar, sb);
        if (!"".equals(strD)) {
            return strD;
        }
        return "" + ((char) pVar.g());
    }

    public static void b(p pVar) {
        while (!TextUtils.isEmpty(pVar.z())) {
        }
    }

    private static String c(p pVar, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        while (!z) {
            int iD = pVar.d();
            String strA = a(pVar, sb);
            if (strA == null) {
                return null;
            }
            if ("}".equals(strA) || x.aQ.equals(strA)) {
                pVar.c(iD);
                z = true;
            } else {
                sb2.append(strA);
            }
        }
        return sb2.toString();
    }

    private static String d(p pVar, StringBuilder sb) {
        boolean z = false;
        sb.setLength(0);
        int iD = pVar.d();
        int iC = pVar.c();
        while (iD < iC && !z) {
            char c = (char) pVar.f8400a[iD];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                z = true;
            } else {
                iD++;
                sb.append(c);
            }
        }
        pVar.d(iD - pVar.d());
        return sb.toString();
    }

    private void a(WebvttCssStyle webvttCssStyle, String str) {
        if ("".equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            Matcher matcher = f8362a.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                webvttCssStyle.c(matcher.group(1));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrSplit = str.split("\\.");
        String str2 = strArrSplit[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            webvttCssStyle.b(str2.substring(0, iIndexOf2));
            webvttCssStyle.a(str2.substring(iIndexOf2 + 1));
        } else {
            webvttCssStyle.b(str2);
        }
        if (strArrSplit.length > 1) {
            webvttCssStyle.a((String[]) Arrays.copyOfRange(strArrSplit, 1, strArrSplit.length));
        }
    }

    public static void a(p pVar) {
        while (true) {
            for (boolean z = true; pVar.b() > 0 && z; z = false) {
                if (e(pVar) || f(pVar)) {
                    break;
                }
            }
            return;
        }
    }

    private static void a(p pVar, WebvttCssStyle webvttCssStyle, StringBuilder sb) {
        a(pVar);
        String strD = d(pVar, sb);
        if (!"".equals(strD) && ":".equals(a(pVar, sb))) {
            a(pVar);
            String strC = c(pVar, sb);
            if (strC == null || "".equals(strC)) {
                return;
            }
            int iD = pVar.d();
            String strA = a(pVar, sb);
            if (!x.aQ.equals(strA)) {
                if (!"}".equals(strA)) {
                    return;
                } else {
                    pVar.c(iD);
                }
            }
            if ("color".equals(strD)) {
                webvttCssStyle.a(com.opos.exoplayer.core.util.g.b(strC));
                return;
            }
            if ("background-color".equals(strD)) {
                webvttCssStyle.b(com.opos.exoplayer.core.util.g.b(strC));
                return;
            }
            if ("text-decoration".equals(strD)) {
                if ("underline".equals(strC)) {
                    webvttCssStyle.a(true);
                }
            } else {
                if ("font-family".equals(strD)) {
                    webvttCssStyle.d(strC);
                    return;
                }
                if ("font-weight".equals(strD)) {
                    if ("bold".equals(strC)) {
                        webvttCssStyle.b(true);
                    }
                } else if ("font-style".equals(strD) && "italic".equals(strC)) {
                    webvttCssStyle.c(true);
                }
            }
        }
    }
}
