package com.cdo.oaps.ad;

import com.baidu.mapapi.http.HttpClient;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f5453a = 255;
    static final int c = 76;
    static final int d = 8;
    static final int e = 4;
    static final int f = 64;
    static final byte g = 61;
    static final int h = -128;
    static final int i = 16;
    static final int j = 24;
    private static byte[] k = new byte[255];
    static final byte[] b = HttpClient.NEWLINE.getBytes();
    private static byte[] l = new byte[64];

    static {
        int i2;
        int i3;
        int i4 = 0;
        for (int i5 = 0; i5 < 255; i5++) {
            k[i5] = -1;
        }
        for (int i6 = 90; i6 >= 65; i6--) {
            k[i6] = (byte) (i6 - 65);
        }
        int i7 = 122;
        while (true) {
            i2 = 26;
            if (i7 < 97) {
                break;
            }
            k[i7] = (byte) ((i7 - 97) + 26);
            i7--;
        }
        int i8 = 57;
        while (true) {
            i3 = 52;
            if (i8 < 48) {
                break;
            }
            k[i8] = (byte) ((i8 - 48) + 52);
            i8--;
        }
        byte[] bArr = k;
        bArr[43] = 62;
        bArr[47] = Utf8.REPLACEMENT_BYTE;
        for (int i9 = 0; i9 <= 25; i9++) {
            l[i9] = (byte) (i9 + 65);
        }
        int i10 = 0;
        while (i2 <= 51) {
            l[i2] = (byte) (i10 + 97);
            i2++;
            i10++;
        }
        while (i3 <= 61) {
            l[i3] = (byte) (i4 + 48);
            i3++;
            i4++;
        }
        byte[] bArr2 = l;
        bArr2[62] = 43;
        bArr2[63] = 47;
    }

    public static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i2 = 0;
        for (byte b2 : bArr) {
            if (b2 != 9 && b2 != 10 && b2 != 13 && b2 != 32) {
                bArr2[i2] = b2;
                i2++;
            }
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr3, 0, i2);
        return bArr3;
    }

    public static byte[] d(byte[] bArr) {
        return a(bArr, false);
    }

    public static byte[] e(byte[] bArr) {
        return a(bArr, true);
    }

    public static boolean f(byte[] bArr) {
        byte[] bArrC = c(bArr);
        if (bArrC.length == 0) {
            return true;
        }
        for (byte b2 : bArrC) {
            if (!a(b2)) {
                return false;
            }
        }
        return true;
    }

    public Object a(Object obj) throws d {
        if (obj instanceof byte[]) {
            return g((byte[]) obj);
        }
        throw new d("Parameter supplied to Base64 decode is not a byte[]");
    }

    public Object b(Object obj) throws e {
        if (obj instanceof byte[]) {
            return h((byte[]) obj);
        }
        throw new e("Parameter supplied to Base64 encode is not a byte[]");
    }

    public byte[] g(byte[] bArr) {
        return a(bArr);
    }

    public byte[] h(byte[] bArr) {
        return a(bArr, false);
    }

    private static boolean a(byte b2) {
        return b2 == 61 || k[b2] != -1;
    }

    public static byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i2 = 0;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (a(bArr[i3])) {
                bArr2[i2] = bArr[i3];
                i2++;
            }
        }
        byte[] bArr3 = new byte[i2];
        System.arraycopy(bArr2, 0, bArr3, 0, i2);
        return bArr3;
    }

    public static byte[] a(byte[] bArr) {
        byte[] bArrB = b(bArr);
        if (bArrB.length == 0) {
            return new byte[0];
        }
        int length = bArrB.length / 4;
        int length2 = bArrB.length;
        while (bArrB[length2 - 1] == 61) {
            length2--;
            if (length2 == 0) {
                return new byte[0];
            }
        }
        byte[] bArr2 = new byte[length2 - length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 4;
            byte b2 = bArrB[i4 + 2];
            byte b3 = bArrB[i4 + 3];
            byte[] bArr3 = k;
            byte b4 = bArr3[bArrB[i4]];
            byte b5 = bArr3[bArrB[i4 + 1]];
            if (b2 != 61 && b3 != 61) {
                byte b6 = bArr3[b2];
                byte b7 = bArr3[b3];
                bArr2[i2] = (byte) ((b4 << 2) | (b5 >> 4));
                bArr2[i2 + 1] = (byte) (((b5 & 15) << 4) | ((b6 >> 2) & 15));
                bArr2[i2 + 2] = (byte) ((b6 << 6) | b7);
            } else if (b2 == 61) {
                bArr2[i2] = (byte) ((b5 >> 4) | (b4 << 2));
            } else if (b3 == 61) {
                byte b8 = bArr3[b2];
                bArr2[i2] = (byte) ((b4 << 2) | (b5 >> 4));
                bArr2[i2 + 1] = (byte) (((b5 & 15) << 4) | ((b8 >> 2) & 15));
            }
            i2 += 3;
        }
        return bArr2;
    }

    public static byte[] a(byte[] bArr, boolean z) {
        int iCeil;
        int length = bArr.length * 8;
        int i2 = length % 24;
        int i3 = length / 24;
        int length2 = i2 != 0 ? (i3 + 1) * 4 : i3 * 4;
        if (z) {
            byte[] bArr2 = b;
            iCeil = bArr2.length == 0 ? 0 : (int) Math.ceil(length2 / 76.0f);
            length2 += bArr2.length * iCeil;
        } else {
            iCeil = 0;
        }
        byte[] bArr3 = new byte[length2];
        int i4 = 0;
        int length3 = 0;
        int i5 = 0;
        int length4 = 76;
        while (i4 < i3) {
            int i6 = i4 * 3;
            byte b2 = bArr[i6];
            byte b3 = bArr[i6 + 1];
            byte b4 = bArr[i6 + 2];
            byte b5 = (byte) (b3 & 15);
            byte b6 = (byte) (b2 & 3);
            int i7 = b2 & ByteCompanionObject.MIN_VALUE;
            int i8 = b2 >> 2;
            if (i7 != 0) {
                i8 ^= 192;
            }
            byte b7 = (byte) i8;
            int i9 = b3 & ByteCompanionObject.MIN_VALUE;
            int i10 = b3 >> 4;
            if (i9 != 0) {
                i10 ^= 240;
            }
            byte b8 = (byte) i10;
            int i11 = b4 >> 6;
            if ((b4 & ByteCompanionObject.MIN_VALUE) != 0) {
                i11 ^= MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF;
            }
            byte[] bArr4 = l;
            bArr3[length3] = bArr4[b7];
            bArr3[length3 + 1] = bArr4[(b6 << 4) | b8];
            bArr3[length3 + 2] = bArr4[(b5 << 2) | ((byte) i11)];
            bArr3[length3 + 3] = bArr4[b4 & Utf8.REPLACEMENT_BYTE];
            length3 += 4;
            if (z && length3 == length4) {
                byte[] bArr5 = b;
                System.arraycopy(bArr5, 0, bArr3, length3, bArr5.length);
                i5++;
                length4 = (bArr5.length * i5) + ((i5 + 1) * 76);
                length3 += bArr5.length;
            }
            i4++;
        }
        int i12 = i4 * 3;
        if (i2 == 8) {
            byte b9 = bArr[i12];
            byte b10 = (byte) (b9 & 3);
            int i13 = b9 & ByteCompanionObject.MIN_VALUE;
            int i14 = b9 >> 2;
            if (i13 != 0) {
                i14 ^= 192;
            }
            byte[] bArr6 = l;
            bArr3[length3] = bArr6[(byte) i14];
            bArr3[length3 + 1] = bArr6[b10 << 4];
            bArr3[length3 + 2] = 61;
            bArr3[length3 + 3] = 61;
        } else if (i2 == 16) {
            byte b11 = bArr[i12];
            byte b12 = bArr[i12 + 1];
            byte b13 = (byte) (b12 & 15);
            byte b14 = (byte) (b11 & 3);
            int i15 = b11 & ByteCompanionObject.MIN_VALUE;
            int i16 = b11 >> 2;
            if (i15 != 0) {
                i16 ^= 192;
            }
            byte b15 = (byte) i16;
            int i17 = b12 & ByteCompanionObject.MIN_VALUE;
            int i18 = b12 >> 4;
            if (i17 != 0) {
                i18 ^= 240;
            }
            byte[] bArr7 = l;
            bArr3[length3] = bArr7[b15];
            bArr3[length3 + 1] = bArr7[((byte) i18) | (b14 << 4)];
            bArr3[length3 + 2] = bArr7[b13 << 2];
            bArr3[length3 + 3] = 61;
        }
        if (z && i5 < iCeil) {
            byte[] bArr8 = b;
            System.arraycopy(bArr8, 0, bArr3, length2 - bArr8.length, bArr8.length);
        }
        return bArr3;
    }
}
