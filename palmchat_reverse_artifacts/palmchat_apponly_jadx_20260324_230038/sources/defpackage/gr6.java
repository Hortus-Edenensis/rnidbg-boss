package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class gr6 extends f60<hk5> {
    public gr6(br6 br6Var, u43 u43Var, char[] cArr, int i) throws IOException {
        super(br6Var, u43Var, cArr, i);
    }

    public final byte[] h() throws IOException {
        byte[] bArr = new byte[12];
        g(bArr);
        return bArr;
    }

    @Override // defpackage.f60
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public hk5 f(u43 u43Var, char[] cArr) throws IOException {
        return new hk5(cArr, u43Var.e(), u43Var.k(), h());
    }
}
