package defpackage;

import java.util.Arrays;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.enums.AesKeyStrength;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class d implements tw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f16953a;
    public wb3 b;
    public int c = 1;
    public byte[] d = new byte[16];
    public byte[] e = new byte[16];

    public d(f fVar, char[] cArr, byte[] bArr, byte[] bArr2) throws ZipException {
        c(bArr, bArr2, cArr, fVar);
    }

    @Override // defpackage.tw0
    public int a(byte[] bArr, int i, int i2) throws ZipException {
        int i3 = i;
        while (true) {
            int i4 = i + i2;
            if (i3 >= i4) {
                return i2;
            }
            int i5 = i3 + 16;
            int i6 = i5 <= i4 ? 16 : i4 - i3;
            this.b.e(bArr, i3, i6);
            i8.e(this.d, this.c);
            this.f16953a.e(this.d, this.e);
            for (int i7 = 0; i7 < i6; i7++) {
                int i8 = i3 + i7;
                bArr[i8] = (byte) (bArr[i8] ^ this.e[i7]);
            }
            this.c++;
            i3 = i5;
        }
    }

    public byte[] b() {
        return this.b.d();
    }

    public final void c(byte[] bArr, byte[] bArr2, char[] cArr, f fVar) throws ZipException {
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("empty or null password provided for AES decryption");
        }
        AesKeyStrength aesKeyStrengthB = fVar.b();
        byte[] bArrA = i8.a(bArr, cArr, aesKeyStrengthB);
        if (!Arrays.equals(bArr2, i8.b(bArrA, aesKeyStrengthB))) {
            throw new ZipException("Wrong Password", ZipException.Type.WRONG_PASSWORD);
        }
        this.f16953a = i8.c(bArrA, aesKeyStrengthB);
        this.b = i8.d(bArrA, aesKeyStrengthB);
    }
}
