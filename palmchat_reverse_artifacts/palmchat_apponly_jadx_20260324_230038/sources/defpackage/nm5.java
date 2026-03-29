package defpackage;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import defpackage.pr0;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class nm5 extends md5 {
    public static final Pattern q = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    public static final Pattern r = Pattern.compile("\\{\\\\.*?\\}");
    public final StringBuilder o;
    public final ArrayList<String> p;

    public nm5() {
        super("SubripDecoder");
        this.o = new StringBuilder();
        this.p = new ArrayList<>();
    }

    public static long A(Matcher matcher, int i) {
        String strGroup = matcher.group(i + 1);
        long j = (strGroup != null ? Long.parseLong(strGroup) * 60 * 60 * 1000 : 0L) + (Long.parseLong((String) vh.e(matcher.group(i + 2))) * 60 * 1000) + (Long.parseLong((String) vh.e(matcher.group(i + 3))) * 1000);
        String strGroup2 = matcher.group(i + 4);
        if (strGroup2 != null) {
            j += Long.parseLong(strGroup2);
        }
        return j * 1000;
    }

    public static float z(int i) {
        if (i == 0) {
            return 0.08f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    public final String B(String str, ArrayList<String> arrayList) {
        String strTrim = str.trim();
        StringBuilder sb = new StringBuilder(strTrim);
        Matcher matcher = r.matcher(strTrim);
        int i = 0;
        while (matcher.find()) {
            String strGroup = matcher.group();
            arrayList.add(strGroup);
            int iStart = matcher.start() - i;
            int length = strGroup.length();
            sb.replace(iStart, iStart + length, "");
            i += length;
        }
        return sb.toString();
    }

    @Override // defpackage.md5
    public dn5 v(byte[] bArr, int i, boolean z) {
        String str;
        ArrayList arrayList = new ArrayList();
        l73 l73Var = new l73();
        gc4 gc4Var = new gc4(bArr, i);
        Charset charsetY = y(gc4Var);
        while (true) {
            String strT = gc4Var.t(charsetY);
            int i2 = 0;
            if (strT == null) {
                break;
            }
            if (strT.length() != 0) {
                try {
                    Integer.parseInt(strT);
                    String strT2 = gc4Var.t(charsetY);
                    if (strT2 == null) {
                        y53.i("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = q.matcher(strT2);
                    if (matcher.matches()) {
                        l73Var.a(A(matcher, 1));
                        l73Var.a(A(matcher, 6));
                        this.o.setLength(0);
                        this.p.clear();
                        for (String strT3 = gc4Var.t(charsetY); !TextUtils.isEmpty(strT3); strT3 = gc4Var.t(charsetY)) {
                            if (this.o.length() > 0) {
                                this.o.append("<br>");
                            }
                            this.o.append(B(strT3, this.p));
                        }
                        Spanned spannedFromHtml = Html.fromHtml(this.o.toString());
                        while (true) {
                            if (i2 >= this.p.size()) {
                                str = null;
                                break;
                            }
                            str = this.p.get(i2);
                            if (str.matches("\\{\\\\an[1-9]\\}")) {
                                break;
                            }
                            i2++;
                        }
                        arrayList.add(x(spannedFromHtml, str));
                        arrayList.add(pr0.r);
                    } else {
                        y53.i("SubripDecoder", "Skipping invalid timing: " + strT2);
                    }
                } catch (NumberFormatException unused) {
                    y53.i("SubripDecoder", "Skipping invalid index: " + strT);
                }
            }
        }
        return new om5((pr0[]) arrayList.toArray(new pr0[0]), l73Var.d());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final pr0 x(Spanned spanned, @Nullable String str) {
        byte b;
        byte b2;
        pr0.b bVarO = new pr0.b().o(spanned);
        if (str == null) {
            return bVarO.a();
        }
        switch (str.hashCode()) {
            case -685620710:
                b = !str.equals("{\\an1}") ? (byte) -1 : (byte) 0;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    b = 6;
                    break;
                }
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    b = 3;
                    break;
                }
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    b = 1;
                    break;
                }
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    b = 7;
                    break;
                }
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    b = 4;
                    break;
                }
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    b = 2;
                    break;
                }
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    b = 8;
                    break;
                }
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    b = 5;
                    break;
                }
                break;
        }
        if (b == 0 || b == 1 || b == 2) {
            bVarO.l(0);
        } else if (b == 3 || b == 4 || b == 5) {
            bVarO.l(2);
        } else {
            bVarO.l(1);
        }
        switch (str.hashCode()) {
            case -685620710:
                b2 = !str.equals("{\\an1}") ? (byte) -1 : (byte) 0;
                break;
            case -685620679:
                if (str.equals("{\\an2}")) {
                    b2 = 1;
                    break;
                }
                break;
            case -685620648:
                if (str.equals("{\\an3}")) {
                    b2 = 2;
                    break;
                }
                break;
            case -685620617:
                if (str.equals("{\\an4}")) {
                    b2 = 6;
                    break;
                }
                break;
            case -685620586:
                if (str.equals("{\\an5}")) {
                    b2 = 7;
                    break;
                }
                break;
            case -685620555:
                if (str.equals("{\\an6}")) {
                    b2 = 8;
                    break;
                }
                break;
            case -685620524:
                if (str.equals("{\\an7}")) {
                    b2 = 3;
                    break;
                }
                break;
            case -685620493:
                if (str.equals("{\\an8}")) {
                    b2 = 4;
                    break;
                }
                break;
            case -685620462:
                if (str.equals("{\\an9}")) {
                    b2 = 5;
                    break;
                }
                break;
        }
        if (b2 == 0 || b2 == 1 || b2 == 2) {
            bVarO.i(2);
        } else if (b2 == 3 || b2 == 4 || b2 == 5) {
            bVarO.i(0);
        } else {
            bVarO.i(1);
        }
        return bVarO.k(z(bVarO.d())).h(z(bVarO.c()), 0).a();
    }

    public final Charset y(gc4 gc4Var) {
        Charset charsetP = gc4Var.P();
        return charsetP != null ? charsetP : f10.c;
    }
}
