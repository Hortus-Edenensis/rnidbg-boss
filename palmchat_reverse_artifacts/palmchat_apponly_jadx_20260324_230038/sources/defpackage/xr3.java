package defpackage;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import defpackage.pr0;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class xr3 extends md5 {
    public final gc4 o;

    public xr3() {
        super("Mp4WebvttDecoder");
        this.o = new gc4();
    }

    public static pr0 x(gc4 gc4Var, int i) throws SubtitleDecoderException {
        CharSequence charSequenceQ = null;
        pr0.b bVarO = null;
        while (i > 0) {
            if (i < 8) {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
            int iQ = gc4Var.q();
            int iQ2 = gc4Var.q();
            int i2 = iQ - 8;
            String strE = g86.E(gc4Var.e(), gc4Var.f(), i2);
            gc4Var.V(i2);
            i = (i - 8) - i2;
            if (iQ2 == 1937011815) {
                bVarO = dk6.o(strE);
            } else if (iQ2 == 1885436268) {
                charSequenceQ = dk6.q(null, strE.trim(), Collections.emptyList());
            }
        }
        if (charSequenceQ == null) {
            charSequenceQ = "";
        }
        return bVarO != null ? bVarO.o(charSequenceQ).a() : dk6.l(charSequenceQ);
    }

    @Override // defpackage.md5
    public dn5 v(byte[] bArr, int i, boolean z) throws SubtitleDecoderException {
        this.o.S(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.o.a() > 0) {
            if (this.o.a() < 8) {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
            int iQ = this.o.q();
            if (this.o.q() == 1987343459) {
                arrayList.add(x(this.o, iQ - 8));
            } else {
                this.o.V(iQ - 8);
            }
        }
        return new yr3(arrayList);
    }
}
