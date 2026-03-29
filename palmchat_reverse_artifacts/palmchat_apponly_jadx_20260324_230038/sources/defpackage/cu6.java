package defpackage;

import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class cu6 extends au6 {
    public static final /* synthetic */ boolean b = true;

    public cu6(byte[] bArr) {
        super(bArr);
    }

    public static cu6 b(String str, long j, n27 n27Var, short s, qa7 qa7Var) throws Exception {
        byte[] bArrC = u47.c((byte) 1);
        boolean z = b;
        if (!z && bArrC.length != 1) {
            throw new AssertionError();
        }
        byte[] bArrD = u47.d(str.charAt(0), str.charAt(1));
        if (!z && bArrD.length != 2) {
            throw new AssertionError();
        }
        byte[] bArrE = u47.e(j);
        if (!z && bArrE.length != 8) {
            throw new AssertionError();
        }
        byte[] bArrH = u47.h();
        if (!z && bArrH.length != 2) {
            throw new AssertionError();
        }
        n27Var.a();
        byte[] bArrC2 = u47.c(n27Var.f19426a);
        if (!z && bArrC2.length != 1) {
            throw new AssertionError();
        }
        byte[] bArrC3 = u47.c(n27Var.b);
        if (!z && bArrC3.length != 1) {
            throw new AssertionError();
        }
        byte[] bArr = (byte[]) n27Var.c.clone();
        if (!z && bArr.length != (n27Var.b & UByte.MAX_VALUE)) {
            throw new AssertionError();
        }
        byte[] bArrF = u47.f(s);
        if (!z && bArrF.length != 2) {
            throw new AssertionError();
        }
        byte[] bArrH2 = u47.h();
        if (!z && bArrH2.length != 2) {
            throw new AssertionError();
        }
        qa7Var.a();
        byte[] bArrC4 = u47.c(qa7Var.f20216a);
        if (!z && bArrC4.length != 1) {
            throw new AssertionError();
        }
        byte[] bArr2 = (byte[]) qa7Var.b.clone();
        if (!z && bArr2.length != (qa7Var.f20216a & UByte.MAX_VALUE)) {
            throw new AssertionError();
        }
        byte[] bArrI = u47.i();
        if (z || bArrI.length == 4) {
            return new cu6(u47.g(bArrC, bArrD, bArrE, bArrH, bArrC2, bArrC3, bArr, bArrF, bArrH2, bArrC4, bArr2, bArrI));
        }
        throw new AssertionError();
    }

    public static cu6 c() {
        try {
            return b("EX", 0L, new v47(""), (short) 0, new ic7());
        } catch (Exception unused) {
            return null;
        }
    }
}
