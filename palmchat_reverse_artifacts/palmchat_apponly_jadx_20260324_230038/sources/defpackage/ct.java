package defpackage;

import kotlin.text.Typography;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ct extends wy5 {
    public final short c;
    public final short d;

    public ct(wy5 wy5Var, int i, int i2) {
        super(wy5Var);
        this.c = (short) i;
        this.d = (short) i2;
    }

    @Override // defpackage.wy5
    public void c(et etVar, byte[] bArr) {
        int i = 0;
        while (true) {
            short s = this.d;
            if (i >= s) {
                return;
            }
            if (i == 0 || (i == 31 && s <= 62)) {
                etVar.c(31, 5);
                short s2 = this.d;
                if (s2 > 62) {
                    etVar.c(s2 - 31, 16);
                } else if (i == 0) {
                    etVar.c(Math.min((int) s2, 31), 5);
                } else {
                    etVar.c(s2 - 31, 5);
                }
            }
            etVar.c(bArr[this.c + i], 8);
            i++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append((int) this.c);
        sb.append("::");
        sb.append((this.c + this.d) - 1);
        sb.append(Typography.greater);
        return sb.toString();
    }
}
