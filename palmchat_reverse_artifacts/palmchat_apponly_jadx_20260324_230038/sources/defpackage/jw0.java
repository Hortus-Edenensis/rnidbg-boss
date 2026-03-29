package defpackage;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.util.Map;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class jw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nu4 f18524a = new nu4(w82.l);

    public final void a(byte[] bArr, int i) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & UByte.MAX_VALUE;
        }
        try {
            this.f18524a.a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public nw0 b(ht htVar, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        ChecksumException e;
        kt ktVar = new kt(htVar);
        FormatException formatException = null;
        try {
            return c(ktVar, map);
        } catch (ChecksumException e2) {
            e = e2;
            try {
                ktVar.f();
                ktVar.g(true);
                ktVar.e();
                ktVar.d();
                ktVar.b();
                nw0 nw0VarC = c(ktVar, map);
                nw0VarC.m(new lp4(true));
                return nw0VarC;
            } catch (ChecksumException | FormatException e3) {
                if (formatException != null) {
                    throw formatException;
                }
                if (e != null) {
                    throw e;
                }
                throw e3;
            }
        } catch (FormatException e4) {
            e = null;
            formatException = e4;
            ktVar.f();
            ktVar.g(true);
            ktVar.e();
            ktVar.d();
            ktVar.b();
            nw0 nw0VarC2 = c(ktVar, map);
            nw0VarC2.m(new lp4(true));
            return nw0VarC2;
        }
    }

    public final nw0 c(kt ktVar, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        t96 t96VarE = ktVar.e();
        ErrorCorrectionLevel errorCorrectionLevelD = ktVar.d().d();
        hu0[] hu0VarArrB = hu0.b(ktVar.c(), t96VarE, errorCorrectionLevelD);
        int iC = 0;
        for (hu0 hu0Var : hu0VarArrB) {
            iC += hu0Var.c();
        }
        byte[] bArr = new byte[iC];
        int i = 0;
        for (hu0 hu0Var2 : hu0VarArrB) {
            byte[] bArrA = hu0Var2.a();
            int iC2 = hu0Var2.c();
            a(bArrA, iC2);
            int i2 = 0;
            while (i2 < iC2) {
                bArr[i] = bArrA[i2];
                i2++;
                i++;
            }
        }
        return bw0.a(bArr, t96VarE, errorCorrectionLevelD, map);
    }
}
