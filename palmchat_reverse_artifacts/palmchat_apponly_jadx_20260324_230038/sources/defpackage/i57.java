package defpackage;

import com.umeng.analytics.pro.dn;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import kotlin.UByte;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class i57 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f18110a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    public static final int[] b = new int[128];

    static {
        int i = 0;
        int i2 = 0;
        while (true) {
            int[] iArr = b;
            if (i2 >= iArr.length) {
                break;
            }
            iArr[i2] = -1;
            i2++;
        }
        while (true) {
            char[] cArr = f18110a;
            if (i >= cArr.length) {
                return;
            }
            b[cArr[i]] = i;
            i++;
        }
    }

    public static byte[] a(String str, int i) {
        try {
            return b(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] b(byte[] bArr) {
        if (bArr == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b2 : bArr) {
            if (b2 >= 0 && b2 < 128 && (b[b2] != -1 || b2 == 61)) {
                byteArrayOutputStream.write(b2);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        int i = 0;
        for (int i2 = length - 1; i2 >= 0 && byteArray[i2] == 61; i2--) {
            i++;
        }
        byte[] bArr2 = new byte[((length * 3) / 4) - i];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (byte b3 : byteArray) {
            if (b3 == 61) {
                break;
            }
            int i6 = b[b3 & ByteCompanionObject.MAX_VALUE];
            if (i6 == -1) {
                throw new IllegalArgumentException("Invalid Base64 character: " + ((int) b3));
            }
            i3 = (i3 << 6) | i6;
            i4 += 6;
            if (i4 >= 8) {
                i4 -= 8;
                bArr2[i5] = (byte) (i3 >> i4);
                i5++;
            }
        }
        return bArr2;
    }

    public static byte[] c(byte[] bArr, int i) {
        if (bArr == null) {
            return new byte[0];
        }
        int length = bArr.length;
        int i2 = (length * 4) / 3;
        int i3 = length % 3;
        if (i3 != 0) {
            i2 += 4;
        }
        int i4 = i & 2;
        if (i4 == 0) {
            i2 += i2 / 76;
        }
        int i5 = i & 1;
        if (i5 == 0) {
            if (i3 == 1) {
                i2 += 2;
            } else if (i3 == 2) {
                i2++;
            }
        }
        byte[] bArr2 = new byte[i2];
        int i6 = length - i3;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i6; i9 += 3) {
            int i10 = ((bArr[i9] & UByte.MAX_VALUE) << 16) | ((bArr[i9 + 1] & UByte.MAX_VALUE) << 8) | (bArr[i9 + 2] & UByte.MAX_VALUE);
            int i11 = i7 + 1;
            char[] cArr = f18110a;
            bArr2[i7] = (byte) cArr[(i10 >> 18) & 63];
            int i12 = i11 + 1;
            bArr2[i11] = (byte) cArr[(i10 >> 12) & 63];
            int i13 = i12 + 1;
            bArr2[i12] = (byte) cArr[(i10 >> 6) & 63];
            int i14 = i13 + 1;
            bArr2[i13] = (byte) cArr[i10 & 63];
            i8 += 4;
            if (i4 != 0 || i8 < 76) {
                i7 = i14;
            } else {
                i7 = i14 + 1;
                bArr2[i14] = (i & 4) != 0 ? dn.k : (byte) 10;
                i8 = 0;
            }
        }
        if (i3 == 1) {
            int i15 = (bArr[i6] & UByte.MAX_VALUE) << 8;
            int i16 = i7 + 1;
            char[] cArr2 = f18110a;
            bArr2[i7] = (byte) cArr2[(i15 >> 10) & 63];
            i7 = i16 + 1;
            bArr2[i16] = (byte) cArr2[(i15 >> 4) & 63];
            if (i5 == 0) {
                int i17 = i7 + 1;
                bArr2[i7] = Base64.padSymbol;
                i7 = i17 + 1;
                bArr2[i17] = Base64.padSymbol;
            }
        } else if (i3 == 2) {
            int i18 = ((bArr[i6 + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i6] & UByte.MAX_VALUE) << 16);
            int i19 = i7 + 1;
            char[] cArr3 = f18110a;
            bArr2[i7] = (byte) cArr3[(i18 >> 18) & 63];
            int i20 = i19 + 1;
            bArr2[i19] = (byte) cArr3[(i18 >> 12) & 63];
            i7 = i20 + 1;
            bArr2[i20] = (byte) cArr3[(i18 >> 6) & 63];
            if (i5 == 0) {
                bArr2[i7] = Base64.padSymbol;
                i7++;
            }
        }
        if (i7 >= i2) {
            return bArr2;
        }
        byte[] bArr3 = new byte[i7];
        System.arraycopy(bArr2, 0, bArr3, 0, i7);
        return bArr3;
    }
}
