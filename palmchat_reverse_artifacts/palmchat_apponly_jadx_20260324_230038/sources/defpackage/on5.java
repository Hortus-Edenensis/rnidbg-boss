package defpackage;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import defpackage.pr0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class on5 {
    public static /* synthetic */ boolean c(Object obj) {
        return !(obj instanceof m13);
    }

    public static /* synthetic */ boolean d(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    public static void e(pr0.b bVar) {
        bVar.b();
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.o(SpannableString.valueOf(bVar.e()));
            }
            g((Spannable) vh.e(bVar.e()), new em4() { // from class: nn5
                @Override // defpackage.em4
                public final boolean apply(Object obj) {
                    return on5.c(obj);
                }
            });
        }
        f(bVar);
    }

    public static void f(pr0.b bVar) {
        bVar.q(-3.4028235E38f, Integer.MIN_VALUE);
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.o(SpannableString.valueOf(bVar.e()));
            }
            g((Spannable) vh.e(bVar.e()), new em4() { // from class: mn5
                @Override // defpackage.em4
                public final boolean apply(Object obj) {
                    return on5.d(obj);
                }
            });
        }
    }

    public static void g(Spannable spannable, em4<Object> em4Var) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (em4Var.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static float h(int i, float f, int i2, int i3) {
        float f2;
        if (f == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i == 0) {
            f2 = i3;
        } else {
            if (i != 1) {
                if (i != 2) {
                    return -3.4028235E38f;
                }
                return f;
            }
            f2 = i2;
        }
        return f * f2;
    }
}
