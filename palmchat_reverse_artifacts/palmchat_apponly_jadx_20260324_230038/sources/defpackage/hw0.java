package defpackage;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class hw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nu4 f18061a = new nu4(w82.m);

    public final void a(byte[] bArr, int i) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & UByte.MAX_VALUE;
        }
        try {
            this.f18061a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public nw0 b(ht htVar) throws ChecksumException, FormatException {
        lt ltVar = new lt(htVar);
        iu0[] iu0VarArrB = iu0.b(ltVar.c(), ltVar.b());
        int length = iu0VarArrB.length;
        int iC = 0;
        for (iu0 iu0Var : iu0VarArrB) {
            iC += iu0Var.c();
        }
        byte[] bArr = new byte[iC];
        for (int i = 0; i < length; i++) {
            iu0 iu0Var2 = iu0VarArrB[i];
            byte[] bArrA = iu0Var2.a();
            int iC2 = iu0Var2.c();
            a(bArrA, iC2);
            for (int i2 = 0; i2 < iC2; i2++) {
                bArr[(i2 * length) + i] = bArrA[i2];
            }
        }
        return yv0.a(bArr);
    }
}
