package defpackage;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class se1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20728a;
    public final int b;
    public final String c;

    public se1(int i, int i2, String str) {
        this.f20728a = i;
        this.b = i2;
        this.c = str;
    }

    @Nullable
    public static se1 a(gc4 gc4Var) {
        String str;
        gc4Var.V(2);
        int iH = gc4Var.H();
        int i = iH >> 1;
        int iH2 = ((gc4Var.H() >> 3) & 31) | ((iH & 1) << 5);
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = "avc3";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".0");
        sb.append(i);
        sb.append(iH2 >= 10 ? "." : ".0");
        sb.append(iH2);
        return new se1(i, iH2, sb.toString());
    }
}
