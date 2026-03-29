package com.opos.exoplayer.core.text.f;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.opos.exoplayer.core.text.Cue;
import com.opos.exoplayer.core.text.d;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends com.opos.exoplayer.core.text.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f8344a = y.f("styl");
    private static final int b = y.f("tbox");
    private final p c;
    private boolean d;
    private int e;
    private int f;
    private String g;
    private float h;
    private int i;

    public a(List<byte[]> list) {
        super("Tx3gDecoder");
        this.c = new p();
        a(list);
    }

    private static void b(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        if (i != i2) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i >>> 8) | ((i & 255) << 24)), i3, i4, i5 | 33);
        }
    }

    @Override // com.opos.exoplayer.core.text.a
    public com.opos.exoplayer.core.text.b a(byte[] bArr, int i, boolean z) throws d {
        this.c.a(bArr, i);
        String strA = a(this.c);
        if (strA.isEmpty()) {
            return b.f8345a;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(strA);
        a(spannableStringBuilder, this.e, 0, 0, spannableStringBuilder.length(), 16711680);
        b(spannableStringBuilder, this.f, -1, 0, spannableStringBuilder.length(), 16711680);
        a(spannableStringBuilder, this.g, "sans-serif", 0, spannableStringBuilder.length(), 16711680);
        float fA = this.h;
        while (this.c.b() >= 8) {
            int iD = this.c.d();
            int iO = this.c.o();
            int iO2 = this.c.o();
            if (iO2 == f8344a) {
                a(this.c.b() >= 2);
                int iH = this.c.h();
                for (int i2 = 0; i2 < iH; i2++) {
                    a(this.c, spannableStringBuilder);
                }
            } else if (iO2 == b && this.d) {
                a(this.c.b() >= 2);
                fA = y.a(this.c.h() / this.i, 0.0f, 0.95f);
            }
            this.c.c(iD + iO);
        }
        return new b(new Cue(spannableStringBuilder, null, fA, 0, 0, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE));
    }

    private static String a(p pVar) throws d {
        char cF;
        a(pVar.b() >= 2);
        int iH = pVar.h();
        if (iH == 0) {
            return "";
        }
        return pVar.a(iH, Charset.forName((pVar.b() < 2 || !((cF = pVar.f()) == 65279 || cF == 65534)) ? "UTF-8" : "UTF-16"));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3, int i4, int i5) {
        StyleSpan styleSpan;
        boolean z;
        if (i != i2) {
            int i6 = i5 | 33;
            boolean z2 = (i & 1) != 0;
            boolean z3 = (i & 2) != 0;
            if (!z2) {
                if (z3) {
                    styleSpan = new StyleSpan(2);
                }
                z = (i & 4) != 0;
                if (z) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i3, i4, i6);
                }
                if (!z || z2 || z3) {
                    return;
                }
                spannableStringBuilder.setSpan(new StyleSpan(0), i3, i4, i6);
                return;
            }
            styleSpan = z3 ? new StyleSpan(3) : new StyleSpan(1);
            spannableStringBuilder.setSpan(styleSpan, i3, i4, i6);
            if ((i & 4) != 0) {
            }
            if (z) {
            }
            if (z) {
            }
        }
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, String str, String str2, int i, int i2, int i3) {
        if (str != str2) {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i, i2, i3 | 33);
        }
    }

    private void a(p pVar, SpannableStringBuilder spannableStringBuilder) throws d {
        a(pVar.b() >= 12);
        int iH = pVar.h();
        int iH2 = pVar.h();
        pVar.d(2);
        int iG = pVar.g();
        pVar.d(1);
        int iO = pVar.o();
        a(spannableStringBuilder, iG, this.e, iH, iH2, 0);
        b(spannableStringBuilder, iO, this.f, iH, iH2, 0);
    }

    private void a(List<byte[]> list) {
        if (list != null && list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.e = bArr[24];
            this.f = ((bArr[26] & UByte.MAX_VALUE) << 24) | ((bArr[27] & UByte.MAX_VALUE) << 16) | ((bArr[28] & UByte.MAX_VALUE) << 8) | (bArr[29] & UByte.MAX_VALUE);
            this.g = "Serif".equals(new String(bArr, 43, bArr.length - 43)) ? "serif" : "sans-serif";
            int i = bArr[25] * 20;
            this.i = i;
            boolean z = (bArr[0] & 32) != 0;
            this.d = z;
            if (z) {
                float f = ((bArr[11] & UByte.MAX_VALUE) | ((bArr[10] & UByte.MAX_VALUE) << 8)) / i;
                this.h = f;
                this.h = y.a(f, 0.0f, 0.95f);
                return;
            }
        } else {
            this.e = 0;
            this.f = -1;
            this.g = "sans-serif";
            this.d = false;
        }
        this.h = 0.85f;
    }

    private static void a(boolean z) throws d {
        if (!z) {
            throw new d("Unexpected subtitle format.");
        }
    }
}
