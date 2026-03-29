package com.squareup.okhttp.internal;

import java.io.UnsupportedEncodingException;
import kotlin.UByte;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Base64 {
    private static final byte[] MAP = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    private Base64() {
    }

    public static byte[] decode(byte[] bArr) {
        return decode(bArr, bArr.length);
    }

    public static String encode(byte[] bArr) {
        byte[] bArr2 = new byte[((bArr.length + 2) * 4) / 3];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int i3 = i + 1;
            byte[] bArr3 = MAP;
            bArr2[i] = bArr3[(bArr[i2] & UByte.MAX_VALUE) >> 2];
            int i4 = i3 + 1;
            int i5 = i2 + 1;
            bArr2[i3] = bArr3[((bArr[i2] & 3) << 4) | ((bArr[i5] & UByte.MAX_VALUE) >> 4)];
            int i6 = i4 + 1;
            int i7 = (bArr[i5] & 15) << 2;
            int i8 = i2 + 2;
            bArr2[i4] = bArr3[i7 | ((bArr[i8] & UByte.MAX_VALUE) >> 6)];
            i = i6 + 1;
            bArr2[i6] = bArr3[bArr[i8] & Utf8.REPLACEMENT_BYTE];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i9 = i + 1;
            byte[] bArr4 = MAP;
            bArr2[i] = bArr4[(bArr[length] & UByte.MAX_VALUE) >> 2];
            int i10 = i9 + 1;
            bArr2[i9] = bArr4[(bArr[length] & 3) << 4];
            int i11 = i10 + 1;
            bArr2[i10] = kotlin.io.encoding.Base64.padSymbol;
            i = i11 + 1;
            bArr2[i11] = kotlin.io.encoding.Base64.padSymbol;
        } else if (length2 == 2) {
            int i12 = i + 1;
            byte[] bArr5 = MAP;
            bArr2[i] = bArr5[(bArr[length] & UByte.MAX_VALUE) >> 2];
            int i13 = i12 + 1;
            int i14 = (bArr[length] & 3) << 4;
            int i15 = length + 1;
            bArr2[i12] = bArr5[((bArr[i15] & UByte.MAX_VALUE) >> 4) | i14];
            int i16 = i13 + 1;
            bArr2[i13] = bArr5[(bArr[i15] & 15) << 2];
            i = i16 + 1;
            bArr2[i16] = kotlin.io.encoding.Base64.padSymbol;
        }
        try {
            return new String(bArr2, 0, i, "US-ASCII");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public static byte[] decode(byte[] bArr, int i) {
        int i2;
        int i3 = (i / 4) * 3;
        if (i3 == 0) {
            return Util.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr2 = new byte[i3];
        int i4 = 0;
        while (true) {
            byte b = bArr[i - 1];
            if (b != 10 && b != 13 && b != 32 && b != 9) {
                if (b != 61) {
                    break;
                }
                i4++;
            }
            i--;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < i; i8++) {
            byte b2 = bArr[i8];
            if (b2 != 10 && b2 != 13 && b2 != 32 && b2 != 9) {
                if (b2 >= 65 && b2 <= 90) {
                    i2 = b2 - 65;
                } else if (b2 >= 97 && b2 <= 122) {
                    i2 = b2 - 71;
                } else if (b2 >= 48 && b2 <= 57) {
                    i2 = b2 + 4;
                } else if (b2 == 43) {
                    i2 = 62;
                } else {
                    if (b2 != 47) {
                        return null;
                    }
                    i2 = 63;
                }
                i5 = (i5 << 6) | ((byte) i2);
                if (i7 % 4 == 3) {
                    int i9 = i6 + 1;
                    bArr2[i6] = (byte) (i5 >> 16);
                    int i10 = i9 + 1;
                    bArr2[i9] = (byte) (i5 >> 8);
                    bArr2[i10] = (byte) i5;
                    i6 = i10 + 1;
                }
                i7++;
            }
        }
        if (i4 > 0) {
            int i11 = i5 << (i4 * 6);
            int i12 = i6 + 1;
            bArr2[i6] = (byte) (i11 >> 16);
            if (i4 == 1) {
                i6 = i12 + 1;
                bArr2[i12] = (byte) (i11 >> 8);
            } else {
                i6 = i12;
            }
        }
        byte[] bArr3 = new byte[i6];
        System.arraycopy(bArr2, 0, bArr3, 0, i6);
        return bArr3;
    }
}
