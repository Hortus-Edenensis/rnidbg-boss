package defpackage;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import defpackage.pr0;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class r26 extends md5 {
    public final gc4 o;
    public final boolean p;
    public final int q;
    public final int r;
    public final String s;
    public final float t;
    public final int u;

    public r26(List<byte[]> list) {
        super("Tx3gDecoder");
        this.o = new gc4();
        if (list.size() != 1 || (list.get(0).length != 48 && list.get(0).length != 53)) {
            this.q = 0;
            this.r = -1;
            this.s = "sans-serif";
            this.p = false;
            this.t = 0.85f;
            this.u = -1;
            return;
        }
        byte[] bArr = list.get(0);
        this.q = bArr[24];
        this.r = ((bArr[26] & UByte.MAX_VALUE) << 24) | ((bArr[27] & UByte.MAX_VALUE) << 16) | ((bArr[28] & UByte.MAX_VALUE) << 8) | (bArr[29] & UByte.MAX_VALUE);
        this.s = "Serif".equals(g86.E(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
        int i = bArr[25] * 20;
        this.u = i;
        boolean z = (bArr[0] & 32) != 0;
        this.p = z;
        if (z) {
            this.t = g86.p(((bArr[11] & UByte.MAX_VALUE) | ((bArr[10] & UByte.MAX_VALUE) << 8)) / i, 0.0f, 0.95f);
        } else {
            this.t = 0.85f;
        }
    }

    public static void A(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z = (i & 1) != 0;
            boolean z2 = (i & 2) != 0;
            if (z) {
                if (z2) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i3, i4, i6);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i3, i4, i6);
                }
            } else if (z2) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i3, i4, i6);
            }
            boolean z3 = (i & 4) != 0;
            if (z3) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
            }
            if (z3 || z || z2) {
                return;
            }
            spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
        }
    }

    public static void B(SpannableStringBuilder spannableStringBuilder, String str, int i, int i2) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i2, 16711713);
        }
    }

    public static String C(gc4 gc4Var) throws SubtitleDecoderException {
        y(gc4Var.a() >= 2);
        int iN = gc4Var.N();
        if (iN == 0) {
            return "";
        }
        int iF = gc4Var.f();
        Charset charsetP = gc4Var.P();
        int iF2 = iN - (gc4Var.f() - iF);
        if (charsetP == null) {
            charsetP = f10.c;
        }
        return gc4Var.F(iF2, charsetP);
    }

    public static void y(boolean z) throws SubtitleDecoderException {
        if (!z) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    public static void z(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    @Override // defpackage.md5
    public dn5 v(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.o.S(bArr, i);
        String strC = C(this.o);
        if (strC.isEmpty()) {
            return s26.b;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strC);
        A(spannableStringBuilder, this.q, 0, 0, spannableStringBuilder.length(), 16711680);
        z(spannableStringBuilder, this.r, -1, 0, spannableStringBuilder.length(), 16711680);
        B(spannableStringBuilder, this.s, 0, spannableStringBuilder.length());
        float fP = this.t;
        while (this.o.a() >= 8) {
            int iF = this.o.f();
            int iQ = this.o.q();
            int iQ2 = this.o.q();
            if (iQ2 == 1937013100) {
                y(this.o.a() >= 2);
                int iN = this.o.N();
                for (int i2 = 0; i2 < iN; i2++) {
                    x(this.o, spannableStringBuilder);
                }
            } else if (iQ2 == 1952608120 && this.p) {
                y(this.o.a() >= 2);
                fP = g86.p(this.o.N() / this.u, 0.0f, 0.95f);
            }
            this.o.U(iF + iQ);
        }
        return new s26(new pr0.b().o(spannableStringBuilder).h(fP, 0).i(0).a());
    }

    public final void x(gc4 gc4Var, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        y(gc4Var.a() >= 12);
        int iN = gc4Var.N();
        int iN2 = gc4Var.N();
        gc4Var.V(2);
        int iH = gc4Var.H();
        gc4Var.V(1);
        int iQ = gc4Var.q();
        if (iN2 > spannableStringBuilder.length()) {
            y53.i("Tx3gDecoder", "Truncating styl end (" + iN2 + ") to cueText.length() (" + spannableStringBuilder.length() + ").");
            iN2 = spannableStringBuilder.length();
        }
        if (iN < iN2) {
            int i = iN2;
            A(spannableStringBuilder, iH, this.q, iN, i, 0);
            z(spannableStringBuilder, iQ, this.r, iN, i, 0);
            return;
        }
        y53.i("Tx3gDecoder", "Ignoring styl with start (" + iN + ") >= end (" + iN2 + ").");
    }
}
