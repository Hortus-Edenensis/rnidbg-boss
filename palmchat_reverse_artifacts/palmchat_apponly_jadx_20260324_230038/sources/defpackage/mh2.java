package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class mh2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f19217a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static byte[] a(char[] cArr) throws Exception {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new Exception("Odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int iF = f(cArr[i], i) << 4;
            int i3 = i + 1;
            int iF2 = iF | f(cArr[i3], i3);
            i = i3 + 1;
            bArr[i2] = (byte) (iF2 & 255);
            i2++;
        }
        return bArr;
    }

    public static char[] b(byte[] bArr) {
        return c(bArr, true);
    }

    public static char[] c(byte[] bArr, boolean z) {
        return d(bArr, z ? f19217a : b);
    }

    public static char[] d(byte[] bArr, char[] cArr) {
        char[] cArr2 = new char[bArr.length << 1];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b2 & 240) >>> 4];
            i = i2 + 1;
            cArr2[i2] = cArr[b2 & 15];
        }
        return cArr2;
    }

    public static String e(byte[] bArr) {
        return new String(b(bArr));
    }

    public static int f(char c, int i) throws Exception {
        int iDigit = Character.digit(c, 16);
        if (iDigit != -1) {
            return iDigit;
        }
        throw new Exception("Illegal hexadecimal character " + c + " at index " + i);
    }
}
