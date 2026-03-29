package defpackage;

import kotlin.text.Typography;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class nd5 extends wy5 {
    public final short c;
    public final short d;

    public nd5(wy5 wy5Var, int i, int i2) {
        super(wy5Var);
        this.c = (short) i;
        this.d = (short) i2;
    }

    @Override // defpackage.wy5
    public void c(et etVar, byte[] bArr) {
        etVar.c(this.c, this.d);
    }

    public String toString() {
        short s = this.c;
        short s2 = this.d;
        return "<" + Integer.toBinaryString((s & ((1 << s2) - 1)) | (1 << s2) | (1 << this.d)).substring(1) + Typography.greater;
    }
}
