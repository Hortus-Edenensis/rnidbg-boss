package defpackage;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import defpackage.ck5;
import defpackage.pr0;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ak5 extends md5 {
    public static final Pattern t = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    public final boolean o;

    @Nullable
    public final bk5 p;
    public Map<String, ck5> q;
    public float r;
    public float s;

    public ak5(@Nullable List<byte[]> list) {
        super("SsaDecoder");
        this.r = -3.4028235E38f;
        this.s = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.o = false;
            this.p = null;
            return;
        }
        this.o = true;
        String strD = g86.D(list.get(0));
        vh.a(strD.startsWith("Format:"));
        this.p = (bk5) vh.e(bk5.a(strD));
        D(new gc4(list.get(1)), f10.c);
    }

    public static Map<String, ck5> F(gc4 gc4Var, Charset charset) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ck5.a aVarA = null;
        while (true) {
            String strT = gc4Var.t(charset);
            if (strT == null || (gc4Var.a() != 0 && gc4Var.h(charset) == '[')) {
                break;
            }
            if (strT.startsWith("Format:")) {
                aVarA = ck5.a.a(strT);
            } else if (strT.startsWith("Style:")) {
                if (aVarA == null) {
                    y53.i("SsaDecoder", "Skipping 'Style:' line before 'Format:' line: " + strT);
                } else {
                    ck5 ck5VarB = ck5.b(strT, aVarA);
                    if (ck5VarB != null) {
                        linkedHashMap.put(ck5VarB.f2000a, ck5VarB);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static long G(String str) {
        Matcher matcher = t.matcher(str.trim());
        if (matcher.matches()) {
            return (Long.parseLong((String) g86.j(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) g86.j(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) g86.j(matcher.group(3))) * 1000000) + (Long.parseLong((String) g86.j(matcher.group(4))) * 10000);
        }
        return -9223372036854775807L;
    }

    public static int H(int i) {
        switch (i) {
            case -1:
                break;
            case 0:
            default:
                y53.i("SsaDecoder", "Unknown alignment: " + i);
                break;
            case 1:
            case 2:
            case 3:
                break;
            case 4:
            case 5:
            case 6:
                break;
            case 7:
            case 8:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    public static int I(int i) {
        switch (i) {
            case -1:
                break;
            case 0:
            default:
                y53.i("SsaDecoder", "Unknown alignment: " + i);
                break;
            case 1:
            case 4:
            case 7:
                break;
            case 2:
            case 5:
            case 8:
                break;
            case 3:
            case 6:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    @Nullable
    public static Layout.Alignment J(int i) {
        switch (i) {
            case -1:
                return null;
            case 0:
            default:
                y53.i("SsaDecoder", "Unknown alignment: " + i);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    public static int x(long j, List<Long> list, List<List<pr0>> list2) {
        int i;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i = 0;
                break;
            }
            if (list.get(size).longValue() == j) {
                return size;
            }
            if (list.get(size).longValue() < j) {
                i = size + 1;
                break;
            }
            size--;
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList(list2.get(i - 1)));
        return i;
    }

    public static float y(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    public static pr0 z(String str, @Nullable ck5 ck5Var, ck5.b bVar, float f, float f2) {
        SpannableString spannableString = new SpannableString(str);
        pr0.b bVarO = new pr0.b().o(spannableString);
        if (ck5Var != null) {
            if (ck5Var.c != null) {
                spannableString.setSpan(new ForegroundColorSpan(ck5Var.c.intValue()), 0, spannableString.length(), 33);
            }
            if (ck5Var.j == 3 && ck5Var.d != null) {
                spannableString.setSpan(new BackgroundColorSpan(ck5Var.d.intValue()), 0, spannableString.length(), 33);
            }
            float f3 = ck5Var.e;
            if (f3 != -3.4028235E38f && f2 != -3.4028235E38f) {
                bVarO.q(f3 / f2, 1);
            }
            boolean z = ck5Var.f;
            if (z && ck5Var.g) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (ck5Var.g) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (ck5Var.h) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (ck5Var.i) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i = bVar.f2002a;
        if (i == -1) {
            i = ck5Var != null ? ck5Var.b : -1;
        }
        bVarO.p(J(i)).l(I(i)).i(H(i));
        PointF pointF = bVar.b;
        if (pointF == null || f2 == -3.4028235E38f || f == -3.4028235E38f) {
            bVarO.k(y(bVarO.d()));
            bVarO.h(y(bVarO.c()), 0);
        } else {
            bVarO.k(pointF.x / f);
            bVarO.h(bVar.b.y / f2, 0);
        }
        return bVarO.a();
    }

    public final Charset A(gc4 gc4Var) {
        Charset charsetP = gc4Var.P();
        return charsetP != null ? charsetP : f10.c;
    }

    public final void B(String str, bk5 bk5Var, List<List<pr0>> list, List<Long> list2) {
        int i;
        vh.a(str.startsWith("Dialogue:"));
        String[] strArrSplit = str.substring(9).split(",", bk5Var.e);
        if (strArrSplit.length != bk5Var.e) {
            y53.i("SsaDecoder", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long jG = G(strArrSplit[bk5Var.f1740a]);
        if (jG == -9223372036854775807L) {
            y53.i("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        long jG2 = G(strArrSplit[bk5Var.b]);
        if (jG2 == -9223372036854775807L) {
            y53.i("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        Map<String, ck5> map = this.q;
        ck5 ck5Var = (map == null || (i = bk5Var.c) == -1) ? null : map.get(strArrSplit[i].trim());
        String str2 = strArrSplit[bk5Var.d];
        pr0 pr0VarZ = z(ck5.b.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), ck5Var, ck5.b.b(str2), this.r, this.s);
        int iX = x(jG2, list2, list);
        for (int iX2 = x(jG, list2, list); iX2 < iX; iX2++) {
            list.get(iX2).add(pr0VarZ);
        }
    }

    public final void C(gc4 gc4Var, List<List<pr0>> list, List<Long> list2, Charset charset) {
        bk5 bk5VarA = this.o ? this.p : null;
        while (true) {
            String strT = gc4Var.t(charset);
            if (strT == null) {
                return;
            }
            if (strT.startsWith("Format:")) {
                bk5VarA = bk5.a(strT);
            } else if (strT.startsWith("Dialogue:")) {
                if (bk5VarA == null) {
                    y53.i("SsaDecoder", "Skipping dialogue line before complete format: " + strT);
                } else {
                    B(strT, bk5VarA, list, list2);
                }
            }
        }
    }

    public final void D(gc4 gc4Var, Charset charset) {
        while (true) {
            String strT = gc4Var.t(charset);
            if (strT == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strT)) {
                E(gc4Var, charset);
            } else if ("[V4+ Styles]".equalsIgnoreCase(strT)) {
                this.q = F(gc4Var, charset);
            } else if ("[V4 Styles]".equalsIgnoreCase(strT)) {
                y53.f("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strT)) {
                return;
            }
        }
    }

    public final void E(gc4 gc4Var, Charset charset) {
        while (true) {
            String strT = gc4Var.t(charset);
            if (strT == null) {
                return;
            }
            if (gc4Var.a() != 0 && gc4Var.h(charset) == '[') {
                return;
            }
            String[] strArrSplit = strT.split(":");
            if (strArrSplit.length == 2) {
                String strE = th.e(strArrSplit[0].trim());
                strE.hashCode();
                if (strE.equals("playresx")) {
                    this.r = Float.parseFloat(strArrSplit[1].trim());
                } else if (strE.equals("playresy")) {
                    try {
                        this.s = Float.parseFloat(strArrSplit[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    @Override // defpackage.md5
    public dn5 v(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        gc4 gc4Var = new gc4(bArr, i);
        Charset charsetA = A(gc4Var);
        if (!this.o) {
            D(gc4Var, charsetA);
        }
        C(gc4Var, arrayList, arrayList2, charsetA);
        return new dk5(arrayList, arrayList2);
    }
}
