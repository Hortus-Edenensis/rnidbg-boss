package defpackage;

import kotlin.UByte;
import net.lingala.zip4j.exception.ZipException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class hk5 implements tw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ar6 f17987a = new ar6();

    public hk5(char[] cArr, long j, long j2, byte[] bArr) throws ZipException {
        b(bArr, cArr, j2, j);
    }

    @Override // defpackage.tw0
    public int a(byte[] bArr, int i, int i2) throws ZipException {
        if (i < 0 || i2 < 0) {
            throw new ZipException("one of the input parameters were null in standard decrypt data");
        }
        for (int i3 = i; i3 < i + i2; i3++) {
            byte b = (byte) (((bArr[i3] & UByte.MAX_VALUE) ^ this.f17987a.b()) & 255);
            this.f17987a.d(b);
            bArr[i3] = b;
        }
        return i2;
    }

    public final void b(byte[] bArr, char[] cArr, long j, long j2) throws ZipException {
        byte b;
        if (cArr == null || cArr.length <= 0) {
            throw new ZipException("Wrong password!", ZipException.Type.WRONG_PASSWORD);
        }
        this.f17987a.c(cArr);
        int i = 0;
        byte b2 = bArr[0];
        while (i < 12) {
            i++;
            if (i == 12 && (b = (byte) (this.f17987a.b() ^ b2)) != ((byte) (j2 >> 24)) && b != ((byte) (j >> 8))) {
                throw new ZipException("Wrong password!", ZipException.Type.WRONG_PASSWORD);
            }
            ar6 ar6Var = this.f17987a;
            ar6Var.d((byte) (ar6Var.b() ^ b2));
            if (i != 12) {
                b2 = bArr[i];
            }
        }
    }
}
