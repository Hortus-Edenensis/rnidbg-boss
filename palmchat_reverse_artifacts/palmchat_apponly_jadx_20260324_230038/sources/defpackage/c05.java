package defpackage;

import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class c05 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f1865a = {-42, -112, -23, -2, -52, -31, Base64.padSymbol, -73, 22, -74, 20, -62, 40, -5, 44, 5, 43, 103, -102, 118, 42, -66, 4, -61, -86, 68, 19, 38, 73, -122, 6, -103, -100, 66, 80, -12, -111, -17, -104, 122, 51, 84, 11, 67, -19, -49, -84, 98, -28, -77, 28, -87, -55, 8, -24, -107, ByteCompanionObject.MIN_VALUE, -33, -108, -6, 117, -113, Utf8.REPLACEMENT_BYTE, -90, 71, 7, -89, -4, -13, 115, 23, -70, -125, 89, 60, 25, -26, -123, 79, -88, 104, 107, -127, -78, 113, 100, -38, -117, -8, -21, 15, 75, 112, 86, -99, 53, 30, 36, dn.l, 94, 99, 88, -47, -94, 37, 34, 124, 59, 1, 33, 120, -121, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, -96, -60, -56, -98, -22, -65, -118, -46, 64, -57, 56, -75, -93, -9, -14, -50, -7, 97, 21, -95, -32, -82, 93, -92, -101, 52, 26, 85, -83, -109, 50, 48, -11, -116, -79, -29, 29, -10, -30, 46, -126, 102, -54, 96, -64, 41, 35, -85, dn.k, 83, 78, 111, -43, -37, 55, 69, -34, -3, -114, 47, 3, -1, 106, 114, 109, 108, 91, 81, -115, 27, -81, -110, -69, -35, -68, ByteCompanionObject.MAX_VALUE, 17, -39, 92, 65, TELogUtils.DEBUG_LEVEL_V, 16, 90, -40, 10, -63, 49, -120, -91, -51, 123, -67, 45, 116, -48, 18, -72, -27, -76, -80, -119, 105, -105, 74, 12, -106, 119, 126, 101, -71, -15, 9, -59, 110, -58, -124, 24, -16, 125, -20, 58, -36, 77, 32, 121, -18, 95, 62, -41, -53, 57, 72};
    public int[] b = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};

    public static void f(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    public static byte[] k(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toLowerCase().toCharArray();
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (p(charArray[i2 + 1]) | (p(charArray[i2]) << 4));
        }
        return bArr;
    }

    public static byte[] l(byte[] bArr) {
        int length = 16 - (bArr.length % 16);
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length + length);
        for (int i = 0; i < length; i++) {
            bArrCopyOf[bArr.length + i] = (byte) length;
        }
        return bArrCopyOf;
    }

    public static byte[] m(byte[] bArr) {
        int length = bArr.length - bArr[bArr.length - 1];
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public static int p(char c) {
        return (byte) "0123456789abcdef".indexOf(c);
    }

    public final int a(int i) {
        byte[] bArr = this.f1865a;
        return (bArr[i & 255] & UByte.MAX_VALUE) | ((bArr[(i >>> 24) & 255] & UByte.MAX_VALUE) << 24) | ((bArr[(i >>> 16) & 255] & UByte.MAX_VALUE) << 16) | ((bArr[(i >>> 8) & 255] & UByte.MAX_VALUE) << 8);
    }

    public final int b(int i) {
        return e(i, 24) ^ (((e(i, 2) ^ i) ^ e(i, 10)) ^ e(i, 18));
    }

    public final int c(int i) {
        return e(i, 23) ^ (e(i, 13) ^ i);
    }

    public final int[] d(byte[] bArr) {
        int[] iArr = new int[4];
        for (int i = 0; i < 4; i++) {
            int i2 = i * 4;
            iArr[i] = (bArr[i2 + 3] & UByte.MAX_VALUE) | ((bArr[i2] & UByte.MAX_VALUE) << 24) | ((bArr[i2 + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i2 + 2] & UByte.MAX_VALUE) << 8);
        }
        return iArr;
    }

    public final int e(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    public byte[] g(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (bArr3 != null && bArr3.length != 16) {
            bArr3 = null;
        }
        int[] iArrO = o(bArr2, true);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[16];
        byte[] bArr6 = new byte[bArr.length];
        int i = 0;
        while (true) {
            int i2 = i + 16;
            if (i2 > bArr.length) {
                return m(bArr6);
            }
            System.arraycopy(bArr, i, bArr4, 0, 16);
            n(bArr4, bArr5, iArrO);
            if (bArr3 != null) {
                f(bArr5, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            System.arraycopy(bArr, i, bArr3, 0, 16);
            System.arraycopy(bArr5, 0, bArr6, i, 16);
            i = i2;
        }
    }

    public byte[] h(byte[] bArr, String str) throws Exception {
        return g(bArr, k(str), str.substring(0, 16).getBytes("utf-8"));
    }

    public byte[] i(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (bArr3 != null && bArr3.length != 16) {
            bArr3 = null;
        }
        byte[] bArrL = l(bArr);
        int[] iArrO = o(bArr2, false);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[bArrL.length];
        int i = 0;
        while (true) {
            int i2 = i + 16;
            if (i2 > bArrL.length) {
                return bArr5;
            }
            System.arraycopy(bArrL, i, bArr4, 0, 16);
            if (bArr3 != null) {
                f(bArr4, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            n(bArr4, bArr3, iArrO);
            System.arraycopy(bArr3, 0, bArr5, i, bArr3.length);
            i = i2;
        }
    }

    public byte[] j(byte[] bArr, String str) throws Exception {
        byte[] bArrK = k(str);
        String strSubstring = str.substring(0, 16);
        k63.a("SM4", "seed=" + str);
        return i(bArr, bArrK, strSubstring.getBytes("utf-8"));
    }

    public void n(byte[] bArr, byte[] bArr2, int[] iArr) {
        int[] iArrD = d(bArr);
        for (int i = 0; i < 32; i += 4) {
            int iB = iArrD[0] ^ b(a(((iArrD[1] ^ iArrD[2]) ^ iArrD[3]) ^ iArr[i]));
            iArrD[0] = iB;
            int iB2 = b(a((iB ^ (iArrD[2] ^ iArrD[3])) ^ iArr[i + 1])) ^ iArrD[1];
            iArrD[1] = iB2;
            int iB3 = b(a((iB2 ^ (iArrD[3] ^ iArrD[0])) ^ iArr[i + 2])) ^ iArrD[2];
            iArrD[2] = iB3;
            iArrD[3] = b(a((iB3 ^ (iArrD[1] ^ iArrD[0])) ^ iArr[i + 3])) ^ iArrD[3];
        }
        for (int i2 = 0; i2 < 16; i2 += 4) {
            int i3 = iArrD[3 - (i2 / 4)];
            bArr2[i2] = (byte) ((i3 >>> 24) & 255);
            bArr2[i2 + 1] = (byte) ((i3 >>> 16) & 255);
            bArr2[i2 + 2] = (byte) ((i3 >>> 8) & 255);
            bArr2[i2 + 3] = (byte) (i3 & 255);
        }
    }

    public int[] o(byte[] bArr, boolean z) {
        int[] iArrD = d(bArr);
        iArrD[0] = iArrD[0] ^ (-1548633402);
        iArrD[1] = iArrD[1] ^ 1453994832;
        iArrD[2] = iArrD[2] ^ 1736282519;
        iArrD[3] = iArrD[3] ^ (-1301273892);
        int[] iArr = new int[32];
        for (int i = 0; i < 32; i += 4) {
            int iC = iArrD[0] ^ c(a(((iArrD[1] ^ iArrD[2]) ^ iArrD[3]) ^ this.b[i]));
            iArrD[0] = iC;
            iArr[i] = iC;
            int i2 = i + 1;
            int iC2 = iArrD[1] ^ c(a(((iArrD[2] ^ iArrD[3]) ^ iArrD[0]) ^ this.b[i2]));
            iArrD[1] = iC2;
            iArr[i2] = iC2;
            int i3 = i + 2;
            int iC3 = iArrD[2] ^ c(a(((iArrD[3] ^ iArrD[0]) ^ iArrD[1]) ^ this.b[i3]));
            iArrD[2] = iC3;
            iArr[i3] = iC3;
            int i4 = i + 3;
            int iC4 = iArrD[3] ^ c(a(((iArrD[0] ^ iArrD[1]) ^ iArrD[2]) ^ this.b[i4]));
            iArrD[3] = iC4;
            iArr[i4] = iC4;
        }
        if (z) {
            for (int i5 = 0; i5 < 16; i5++) {
                int i6 = iArr[i5];
                int i7 = 31 - i5;
                iArr[i5] = iArr[i7];
                iArr[i7] = i6;
            }
        }
        return iArr;
    }
}
