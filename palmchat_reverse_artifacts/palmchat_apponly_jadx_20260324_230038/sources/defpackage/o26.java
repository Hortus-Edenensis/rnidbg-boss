package defpackage;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.baidu.mapapi.http.HttpClient;
import java.util.ArrayDeque;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class o26 {
    public static void a(Spannable spannable, int i, int i2, p26 p26Var, @Nullable m26 m26Var, Map<String, p26> map, int i3) {
        m26 m26VarE;
        p26 p26VarF;
        int i4;
        if (p26Var.l() != -1) {
            spannable.setSpan(new StyleSpan(p26Var.l()), i, i2, 33);
        }
        if (p26Var.s()) {
            spannable.setSpan(new StrikethroughSpan(), i, i2, 33);
        }
        if (p26Var.t()) {
            spannable.setSpan(new UnderlineSpan(), i, i2, 33);
        }
        if (p26Var.q()) {
            ng5.a(spannable, new ForegroundColorSpan(p26Var.c()), i, i2, 33);
        }
        if (p26Var.p()) {
            ng5.a(spannable, new BackgroundColorSpan(p26Var.b()), i, i2, 33);
        }
        if (p26Var.d() != null) {
            ng5.a(spannable, new TypefaceSpan(p26Var.d()), i, i2, 33);
        }
        if (p26Var.o() != null) {
            qu5 qu5Var = (qu5) vh.e(p26Var.o());
            int i5 = qu5Var.f20324a;
            if (i5 == -1) {
                i5 = (i3 == 2 || i3 == 1) ? 3 : 1;
                i4 = 1;
            } else {
                i4 = qu5Var.b;
            }
            int i6 = qu5Var.c;
            if (i6 == -2) {
                i6 = 1;
            }
            ng5.a(spannable, new ru5(i5, i4, i6), i, i2, 33);
        }
        int iJ = p26Var.j();
        if (iJ == 2) {
            m26 m26VarD = d(m26Var, map);
            if (m26VarD != null && (m26VarE = e(m26VarD, map)) != null) {
                if (m26VarE.g() != 1 || m26VarE.f(0).b == null) {
                    y53.f("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                } else {
                    String str = (String) g86.j(m26VarE.f(0).b);
                    p26 p26VarF2 = f(m26VarE.f, m26VarE.l(), map);
                    int i7 = p26VarF2 != null ? p26VarF2.i() : -1;
                    if (i7 == -1 && (p26VarF = f(m26VarD.f, m26VarD.l(), map)) != null) {
                        i7 = p26VarF.i();
                    }
                    spannable.setSpan(new cz4(str, i7), i, i2, 33);
                }
            }
        } else if (iJ == 3 || iJ == 4) {
            spannable.setSpan(new wa1(), i, i2, 33);
        }
        if (p26Var.n()) {
            ng5.a(spannable, new si2(), i, i2, 33);
        }
        int iF = p26Var.f();
        if (iF == 1) {
            ng5.a(spannable, new AbsoluteSizeSpan((int) p26Var.e(), true), i, i2, 33);
        } else if (iF == 2) {
            ng5.a(spannable, new RelativeSizeSpan(p26Var.e()), i, i2, 33);
        } else {
            if (iF != 3) {
                return;
            }
            ng5.a(spannable, new RelativeSizeSpan(p26Var.e() / 100.0f), i, i2, 33);
        }
    }

    public static String b(String str) {
        return str.replaceAll(HttpClient.NEWLINE, "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " ");
    }

    public static void c(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length < 0 || spannableStringBuilder.charAt(length) == '\n') {
            return;
        }
        spannableStringBuilder.append('\n');
    }

    @Nullable
    public static m26 d(@Nullable m26 m26Var, Map<String, p26> map) {
        while (m26Var != null) {
            p26 p26VarF = f(m26Var.f, m26Var.l(), map);
            if (p26VarF != null && p26VarF.j() == 1) {
                return m26Var;
            }
            m26Var = m26Var.j;
        }
        return null;
    }

    @Nullable
    public static m26 e(m26 m26Var, Map<String, p26> map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(m26Var);
        while (!arrayDeque.isEmpty()) {
            m26 m26Var2 = (m26) arrayDeque.pop();
            p26 p26VarF = f(m26Var2.f, m26Var2.l(), map);
            if (p26VarF != null && p26VarF.j() == 3) {
                return m26Var2;
            }
            for (int iG = m26Var2.g() - 1; iG >= 0; iG--) {
                arrayDeque.push(m26Var2.f(iG));
            }
        }
        return null;
    }

    @Nullable
    public static p26 f(@Nullable p26 p26Var, @Nullable String[] strArr, Map<String, p26> map) {
        int i = 0;
        if (p26Var == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                p26 p26Var2 = new p26();
                int length = strArr.length;
                while (i < length) {
                    p26Var2.a(map.get(strArr[i]));
                    i++;
                }
                return p26Var2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                return p26Var.a(map.get(strArr[0]));
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i < length2) {
                    p26Var.a(map.get(strArr[i]));
                    i++;
                }
            }
        }
        return p26Var;
    }
}
