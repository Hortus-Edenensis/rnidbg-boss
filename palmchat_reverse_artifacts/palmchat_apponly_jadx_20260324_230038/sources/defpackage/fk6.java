package defpackage;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class fk6 extends md5 {
    public final gc4 o;
    public final ak6 p;

    public fk6() {
        super("WebvttDecoder");
        this.o = new gc4();
        this.p = new ak6();
    }

    public static int x(gc4 gc4Var) {
        int i = -1;
        int iF = 0;
        while (i == -1) {
            iF = gc4Var.f();
            String strS = gc4Var.s();
            i = strS == null ? 0 : "STYLE".equals(strS) ? 2 : strS.startsWith("NOTE") ? 1 : 3;
        }
        gc4Var.U(iF);
        return i;
    }

    public static void y(gc4 gc4Var) {
        while (!TextUtils.isEmpty(gc4Var.s())) {
        }
    }

    @Override // defpackage.md5
    public dn5 v(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        ck6 ck6VarM;
        this.o.S(bArr, i);
        ArrayList arrayList = new ArrayList();
        try {
            hk6.e(this.o);
            while (!TextUtils.isEmpty(this.o.s())) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int iX = x(this.o);
                if (iX == 0) {
                    return new jk6(arrayList2);
                }
                if (iX == 1) {
                    y(this.o);
                } else if (iX == 2) {
                    if (!arrayList2.isEmpty()) {
                        throw new SubtitleDecoderException("A style block was found after the first cue.");
                    }
                    this.o.s();
                    arrayList.addAll(this.p.d(this.o));
                } else if (iX == 3 && (ck6VarM = dk6.m(this.o, arrayList)) != null) {
                    arrayList2.add(ck6VarM);
                }
            }
        } catch (ParserException e) {
            throw new SubtitleDecoderException(e);
        }
    }
}
