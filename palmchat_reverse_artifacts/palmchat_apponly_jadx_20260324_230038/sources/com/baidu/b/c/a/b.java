package com.baidu.b.c.a;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.reflect.Array;
import java.security.InvalidKeyException;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class b implements a {
    private static int[] b;
    private static int[] c;
    private static final byte[] d = new byte[256];
    private static final byte[] e = new byte[256];
    private static final int[] f = new int[256];
    private static final int[] g = new int[256];
    private static final int[] h = new int[256];
    private static final int[] i = new int[256];
    private static final int[] j = new int[256];
    private static final int[] k = new int[256];
    private static final int[] l = new int[256];
    private static final int[] m = new int[256];
    private static final int[] n = new int[256];
    private static final int[] o = new int[256];
    private static final int[] p = new int[256];
    private static final int[] q = new int[256];
    private static final byte[] r = new byte[30];
    private boolean s = false;
    private boolean t = false;
    private Object[] u = null;
    private int[] v = null;
    private int w = 0;

    static {
        int[] iArr = new int[256];
        b = iArr;
        c = new int[256];
        iArr[0] = 1;
        for (int i2 = 1; i2 < 256; i2++) {
            int[] iArr2 = b;
            int i3 = iArr2[i2 - 1];
            int i4 = i3 ^ (i3 << 1);
            if ((i4 & 256) != 0) {
                i4 ^= MediaPlayer.MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS;
            }
            iArr2[i2] = i4;
        }
        for (int i5 = 1; i5 < 255; i5++) {
            c[b[i5]] = i5;
        }
        byte[][] bArr = {new byte[]{1, 1, 1, 1, 1, 0, 0, 0}, new byte[]{0, 1, 1, 1, 1, 1, 0, 0}, new byte[]{0, 0, 1, 1, 1, 1, 1, 0}, new byte[]{0, 0, 0, 1, 1, 1, 1, 1}, new byte[]{1, 0, 0, 0, 1, 1, 1, 1}, new byte[]{1, 1, 0, 0, 0, 1, 1, 1}, new byte[]{1, 1, 1, 0, 0, 0, 1, 1}, new byte[]{1, 1, 1, 1, 0, 0, 0, 1}};
        byte[] bArr2 = {0, 1, 1, 0, 0, 0, 1, 1};
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 256, 8);
        bArr3[1][7] = 1;
        for (int i6 = 2; i6 < 256; i6++) {
            int i7 = b[255 - c[i6]];
            for (int i8 = 0; i8 < 8; i8++) {
                bArr3[i6][i8] = (byte) ((i7 >>> (7 - i8)) & 1);
            }
        }
        byte[][] bArr4 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 256, 8);
        for (int i9 = 0; i9 < 256; i9++) {
            for (int i10 = 0; i10 < 8; i10++) {
                bArr4[i9][i10] = bArr2[i10];
                for (int i11 = 0; i11 < 8; i11++) {
                    byte[] bArr5 = bArr4[i9];
                    bArr5[i10] = (byte) (bArr5[i10] ^ (bArr[i10][i11] * bArr3[i9][i11]));
                }
            }
        }
        for (int i12 = 0; i12 < 256; i12++) {
            d[i12] = (byte) (bArr4[i12][0] << 7);
            for (int i13 = 1; i13 < 8; i13++) {
                byte[] bArr6 = d;
                bArr6[i12] = (byte) (bArr6[i12] ^ (bArr4[i12][i13] << (7 - i13)));
            }
            e[d[i12] & UByte.MAX_VALUE] = (byte) i12;
        }
        byte[][] bArr7 = {new byte[]{2, 1, 1, 3}, new byte[]{3, 2, 1, 1}, new byte[]{1, 3, 2, 1}, new byte[]{1, 1, 3, 2}};
        byte[][] bArr8 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 8);
        for (int i14 = 0; i14 < 4; i14++) {
            for (int i15 = 0; i15 < 4; i15++) {
                bArr8[i14][i15] = bArr7[i14][i15];
            }
            bArr8[i14][i14 + 4] = 1;
        }
        byte[][] bArr9 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 4);
        for (int i16 = 0; i16 < 4; i16++) {
            byte b2 = bArr8[i16][i16];
            if (b2 == 0) {
                int i17 = i16 + 1;
                while (bArr8[i17][i16] == 0 && i17 < 4) {
                    i17++;
                }
                if (i17 == 4) {
                    throw new RuntimeException("G matrix is not invertible");
                }
                for (int i18 = 0; i18 < 8; i18++) {
                    byte[] bArr10 = bArr8[i16];
                    byte b3 = bArr10[i18];
                    byte[] bArr11 = bArr8[i17];
                    bArr10[i18] = bArr11[i18];
                    bArr11[i18] = b3;
                }
                b2 = bArr8[i16][i16];
            }
            for (int i19 = 0; i19 < 8; i19++) {
                byte[] bArr12 = bArr8[i16];
                byte b4 = bArr12[i19];
                if (b4 != 0) {
                    int[] iArr3 = b;
                    int[] iArr4 = c;
                    bArr12[i19] = (byte) iArr3[((iArr4[b4 & UByte.MAX_VALUE] + 255) - iArr4[b2 & UByte.MAX_VALUE]) % 255];
                }
            }
            for (int i20 = 0; i20 < 4; i20++) {
                if (i16 != i20) {
                    for (int i21 = i16 + 1; i21 < 8; i21++) {
                        byte[] bArr13 = bArr8[i20];
                        bArr13[i21] = (byte) (bArr13[i21] ^ a(bArr8[i16][i21], bArr13[i16]));
                    }
                    bArr8[i20][i16] = 0;
                }
            }
        }
        for (int i22 = 0; i22 < 4; i22++) {
            for (int i23 = 0; i23 < 4; i23++) {
                bArr9[i22][i23] = bArr8[i22][i23 + 4];
            }
        }
        for (int i24 = 0; i24 < 256; i24++) {
            byte b5 = d[i24];
            f[i24] = a(b5, bArr7[0]);
            g[i24] = a(b5, bArr7[1]);
            h[i24] = a(b5, bArr7[2]);
            i[i24] = a(b5, bArr7[3]);
            byte b6 = e[i24];
            j[i24] = a(b6, bArr9[0]);
            k[i24] = a(b6, bArr9[1]);
            l[i24] = a(b6, bArr9[2]);
            m[i24] = a(b6, bArr9[3]);
            n[i24] = a(i24, bArr9[0]);
            o[i24] = a(i24, bArr9[1]);
            p[i24] = a(i24, bArr9[2]);
            q[i24] = a(i24, bArr9[3]);
        }
        r[0] = 1;
        int iA = 1;
        for (int i25 = 1; i25 < 30; i25++) {
            iA = a(2, iA);
            r[i25] = (byte) iA;
        }
        c = null;
        b = null;
    }

    private static int b(int i2) {
        return (i2 >> 2) + 6;
    }

    public int a() {
        return 16;
    }

    private static final int a(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = b;
        int[] iArr2 = c;
        return iArr[(iArr2[i2 & 255] + iArr2[i3 & 255]) % 255];
    }

    public void b(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i2 + 1;
        int i10 = i9 + 1;
        int i11 = ((bArr[i9] & UByte.MAX_VALUE) << 16) | (bArr[i2] << 24);
        int i12 = i10 + 1;
        int i13 = i11 | ((bArr[i10] & UByte.MAX_VALUE) << 8);
        int i14 = i12 + 1;
        int i15 = i13 | (bArr[i12] & UByte.MAX_VALUE);
        int[] iArr = this.v;
        int i16 = i15 ^ iArr[4];
        int i17 = i14 + 1;
        int i18 = i17 + 1;
        int i19 = (bArr[i14] << 24) | ((bArr[i17] & UByte.MAX_VALUE) << 16);
        int i20 = i18 + 1;
        int i21 = i19 | ((bArr[i18] & UByte.MAX_VALUE) << 8);
        int i22 = i20 + 1;
        int i23 = (i21 | (bArr[i20] & UByte.MAX_VALUE)) ^ iArr[5];
        int i24 = i22 + 1;
        int i25 = i24 + 1;
        int i26 = ((bArr[i24] & UByte.MAX_VALUE) << 16) | (bArr[i22] << 24);
        int i27 = i25 + 1;
        int i28 = i26 | ((bArr[i25] & UByte.MAX_VALUE) << 8);
        int i29 = i27 + 1;
        int i30 = (i28 | (bArr[i27] & UByte.MAX_VALUE)) ^ iArr[6];
        int i31 = i29 + 1;
        int i32 = i31 + 1;
        int i33 = (((((bArr[i31] & UByte.MAX_VALUE) << 16) | (bArr[i29] << 24)) | ((bArr[i32] & UByte.MAX_VALUE) << 8)) | (bArr[i32 + 1] & UByte.MAX_VALUE)) ^ iArr[7];
        if (this.s) {
            int[] iArr2 = j;
            int i34 = iArr2[i16 >>> 24];
            int[] iArr3 = k;
            int i35 = i34 ^ iArr3[(i33 >>> 16) & 255];
            int[] iArr4 = l;
            int i36 = i35 ^ iArr4[(i30 >>> 8) & 255];
            int[] iArr5 = m;
            int i37 = (i36 ^ iArr5[i23 & 255]) ^ iArr[8];
            int i38 = (((iArr2[i23 >>> 24] ^ iArr3[(i16 >>> 16) & 255]) ^ iArr4[(i33 >>> 8) & 255]) ^ iArr5[i30 & 255]) ^ iArr[9];
            int i39 = (((iArr3[(i23 >>> 16) & 255] ^ iArr2[i30 >>> 24]) ^ iArr4[(i16 >>> 8) & 255]) ^ iArr5[i33 & 255]) ^ iArr[10];
            int i40 = (iArr5[i16 & 255] ^ (iArr4[(i23 >>> 8) & 255] ^ (iArr3[(i30 >>> 16) & 255] ^ iArr2[i33 >>> 24]))) ^ iArr[11];
            i7 = (((iArr2[i37 >>> 24] ^ iArr3[(i40 >>> 16) & 255]) ^ iArr4[(i39 >>> 8) & 255]) ^ iArr5[i38 & 255]) ^ iArr[12];
            i6 = (((iArr2[i38 >>> 24] ^ iArr3[(i37 >>> 16) & 255]) ^ iArr4[(i40 >>> 8) & 255]) ^ iArr5[i39 & 255]) ^ iArr[13];
            i5 = (((iArr2[i39 >>> 24] ^ iArr3[(i38 >>> 16) & 255]) ^ iArr4[(i37 >>> 8) & 255]) ^ iArr5[i40 & 255]) ^ iArr[14];
            int i41 = (((iArr2[i40 >>> 24] ^ iArr3[(i39 >>> 16) & 255]) ^ iArr4[(i38 >>> 8) & 255]) ^ iArr5[i37 & 255]) ^ iArr[15];
            if (this.t) {
                int i42 = (((iArr2[i7 >>> 24] ^ iArr3[(i41 >>> 16) & 255]) ^ iArr4[(i5 >>> 8) & 255]) ^ iArr5[i6 & 255]) ^ iArr[16];
                int i43 = (((iArr2[i6 >>> 24] ^ iArr3[(i7 >>> 16) & 255]) ^ iArr4[(i41 >>> 8) & 255]) ^ iArr5[i5 & 255]) ^ iArr[17];
                int i44 = (((iArr2[i5 >>> 24] ^ iArr3[(i6 >>> 16) & 255]) ^ iArr4[(i7 >>> 8) & 255]) ^ iArr5[i41 & 255]) ^ iArr[18];
                int i45 = (((iArr2[i41 >>> 24] ^ iArr3[(i5 >>> 16) & 255]) ^ iArr4[(i6 >>> 8) & 255]) ^ iArr5[i7 & 255]) ^ iArr[19];
                i7 = (((iArr2[i42 >>> 24] ^ iArr3[(i45 >>> 16) & 255]) ^ iArr4[(i44 >>> 8) & 255]) ^ iArr5[i43 & 255]) ^ iArr[20];
                i6 = (((iArr2[i43 >>> 24] ^ iArr3[(i42 >>> 16) & 255]) ^ iArr4[(i45 >>> 8) & 255]) ^ iArr5[i44 & 255]) ^ iArr[21];
                i5 = (((iArr2[i44 >>> 24] ^ iArr3[(i43 >>> 16) & 255]) ^ iArr4[(i42 >>> 8) & 255]) ^ iArr5[i45 & 255]) ^ iArr[22];
                i4 = (((iArr2[i45 >>> 24] ^ iArr3[(i44 >>> 16) & 255]) ^ iArr4[(i43 >>> 8) & 255]) ^ iArr5[i42 & 255]) ^ iArr[23];
                i8 = 24;
            } else {
                i4 = i41;
                i8 = 16;
            }
        } else {
            i4 = i33;
            i5 = i30;
            i6 = i23;
            i7 = i16;
            i8 = 8;
        }
        int[] iArr6 = j;
        int i46 = iArr6[i7 >>> 24];
        int[] iArr7 = k;
        int i47 = i46 ^ iArr7[(i4 >>> 16) & 255];
        int[] iArr8 = l;
        int i48 = i47 ^ iArr8[(i5 >>> 8) & 255];
        int[] iArr9 = m;
        int i49 = i8 + 1;
        int i50 = iArr[i8] ^ (i48 ^ iArr9[i6 & 255]);
        int i51 = i49 + 1;
        int i52 = (((iArr6[i6 >>> 24] ^ iArr7[(i7 >>> 16) & 255]) ^ iArr8[(i4 >>> 8) & 255]) ^ iArr9[i5 & 255]) ^ iArr[i49];
        int i53 = ((iArr7[(i6 >>> 16) & 255] ^ iArr6[i5 >>> 24]) ^ iArr8[(i7 >>> 8) & 255]) ^ iArr9[i4 & 255];
        int i54 = i51 + 1;
        int i55 = i53 ^ iArr[i51];
        int i56 = iArr9[i7 & 255] ^ ((iArr6[i4 >>> 24] ^ iArr7[(i5 >>> 16) & 255]) ^ iArr8[(i6 >>> 8) & 255]);
        int i57 = i54 + 1;
        int i58 = i56 ^ iArr[i54];
        int i59 = i57 + 1;
        int i60 = iArr[i57] ^ (((iArr6[i50 >>> 24] ^ iArr7[(i58 >>> 16) & 255]) ^ iArr8[(i55 >>> 8) & 255]) ^ iArr9[i52 & 255]);
        int i61 = i59 + 1;
        int i62 = (((iArr6[i52 >>> 24] ^ iArr7[(i50 >>> 16) & 255]) ^ iArr8[(i58 >>> 8) & 255]) ^ iArr9[i55 & 255]) ^ iArr[i59];
        int i63 = i61 + 1;
        int i64 = (((iArr6[i55 >>> 24] ^ iArr7[(i52 >>> 16) & 255]) ^ iArr8[(i50 >>> 8) & 255]) ^ iArr9[i58 & 255]) ^ iArr[i61];
        int i65 = iArr9[i50 & 255] ^ ((iArr6[i58 >>> 24] ^ iArr7[(i55 >>> 16) & 255]) ^ iArr8[(i52 >>> 8) & 255]);
        int i66 = i63 + 1;
        int i67 = i65 ^ iArr[i63];
        int i68 = i66 + 1;
        int i69 = iArr[i66] ^ (((iArr6[i60 >>> 24] ^ iArr7[(i67 >>> 16) & 255]) ^ iArr8[(i64 >>> 8) & 255]) ^ iArr9[i62 & 255]);
        int i70 = i68 + 1;
        int i71 = (((iArr6[i62 >>> 24] ^ iArr7[(i60 >>> 16) & 255]) ^ iArr8[(i67 >>> 8) & 255]) ^ iArr9[i64 & 255]) ^ iArr[i68];
        int i72 = i70 + 1;
        int i73 = (((iArr6[i64 >>> 24] ^ iArr7[(i62 >>> 16) & 255]) ^ iArr8[(i60 >>> 8) & 255]) ^ iArr9[i67 & 255]) ^ iArr[i70];
        int i74 = ((iArr6[i67 >>> 24] ^ iArr7[(i64 >>> 16) & 255]) ^ iArr8[(i62 >>> 8) & 255]) ^ iArr9[i60 & 255];
        int i75 = i72 + 1;
        int i76 = i74 ^ iArr[i72];
        int i77 = i75 + 1;
        int i78 = iArr[i75] ^ (((iArr6[i69 >>> 24] ^ iArr7[(i76 >>> 16) & 255]) ^ iArr8[(i73 >>> 8) & 255]) ^ iArr9[i71 & 255]);
        int i79 = i77 + 1;
        int i80 = (((iArr6[i71 >>> 24] ^ iArr7[(i69 >>> 16) & 255]) ^ iArr8[(i76 >>> 8) & 255]) ^ iArr9[i73 & 255]) ^ iArr[i77];
        int i81 = i79 + 1;
        int i82 = (((iArr6[i73 >>> 24] ^ iArr7[(i71 >>> 16) & 255]) ^ iArr8[(i69 >>> 8) & 255]) ^ iArr9[i76 & 255]) ^ iArr[i79];
        int i83 = ((iArr6[i76 >>> 24] ^ iArr7[(i73 >>> 16) & 255]) ^ iArr8[(i71 >>> 8) & 255]) ^ iArr9[i69 & 255];
        int i84 = i81 + 1;
        int i85 = i83 ^ iArr[i81];
        int i86 = i84 + 1;
        int i87 = iArr[i84] ^ (((iArr6[i78 >>> 24] ^ iArr7[(i85 >>> 16) & 255]) ^ iArr8[(i82 >>> 8) & 255]) ^ iArr9[i80 & 255]);
        int i88 = i86 + 1;
        int i89 = (((iArr6[i80 >>> 24] ^ iArr7[(i78 >>> 16) & 255]) ^ iArr8[(i85 >>> 8) & 255]) ^ iArr9[i82 & 255]) ^ iArr[i86];
        int i90 = i88 + 1;
        int i91 = (((iArr6[i82 >>> 24] ^ iArr7[(i80 >>> 16) & 255]) ^ iArr8[(i78 >>> 8) & 255]) ^ iArr9[i85 & 255]) ^ iArr[i88];
        int i92 = ((iArr6[i85 >>> 24] ^ iArr7[(i82 >>> 16) & 255]) ^ iArr8[(i80 >>> 8) & 255]) ^ iArr9[i78 & 255];
        int i93 = i90 + 1;
        int i94 = i92 ^ iArr[i90];
        int i95 = i93 + 1;
        int i96 = iArr[i93] ^ (((iArr6[i87 >>> 24] ^ iArr7[(i94 >>> 16) & 255]) ^ iArr8[(i91 >>> 8) & 255]) ^ iArr9[i89 & 255]);
        int i97 = i95 + 1;
        int i98 = (((iArr6[i89 >>> 24] ^ iArr7[(i87 >>> 16) & 255]) ^ iArr8[(i94 >>> 8) & 255]) ^ iArr9[i91 & 255]) ^ iArr[i95];
        int i99 = i97 + 1;
        int i100 = (((iArr6[i91 >>> 24] ^ iArr7[(i89 >>> 16) & 255]) ^ iArr8[(i87 >>> 8) & 255]) ^ iArr9[i94 & 255]) ^ iArr[i97];
        int i101 = ((iArr6[i94 >>> 24] ^ iArr7[(i91 >>> 16) & 255]) ^ iArr8[(i89 >>> 8) & 255]) ^ iArr9[i87 & 255];
        int i102 = i99 + 1;
        int i103 = i101 ^ iArr[i99];
        int i104 = i102 + 1;
        int i105 = iArr[i102] ^ (((iArr6[i96 >>> 24] ^ iArr7[(i103 >>> 16) & 255]) ^ iArr8[(i100 >>> 8) & 255]) ^ iArr9[i98 & 255]);
        int i106 = i104 + 1;
        int i107 = (((iArr6[i98 >>> 24] ^ iArr7[(i96 >>> 16) & 255]) ^ iArr8[(i103 >>> 8) & 255]) ^ iArr9[i100 & 255]) ^ iArr[i104];
        int i108 = i106 + 1;
        int i109 = (((iArr6[i100 >>> 24] ^ iArr7[(i98 >>> 16) & 255]) ^ iArr8[(i96 >>> 8) & 255]) ^ iArr9[i103 & 255]) ^ iArr[i106];
        int i110 = ((iArr6[i103 >>> 24] ^ iArr7[(i100 >>> 16) & 255]) ^ iArr8[(i98 >>> 8) & 255]) ^ iArr9[i96 & 255];
        int i111 = i108 + 1;
        int i112 = i110 ^ iArr[i108];
        int i113 = i111 + 1;
        int i114 = iArr[i111] ^ (((iArr6[i105 >>> 24] ^ iArr7[(i112 >>> 16) & 255]) ^ iArr8[(i109 >>> 8) & 255]) ^ iArr9[i107 & 255]);
        int i115 = i113 + 1;
        int i116 = (((iArr6[i107 >>> 24] ^ iArr7[(i105 >>> 16) & 255]) ^ iArr8[(i112 >>> 8) & 255]) ^ iArr9[i109 & 255]) ^ iArr[i113];
        int i117 = i115 + 1;
        int i118 = (((iArr6[i109 >>> 24] ^ iArr7[(i107 >>> 16) & 255]) ^ iArr8[(i105 >>> 8) & 255]) ^ iArr9[i112 & 255]) ^ iArr[i115];
        int i119 = ((iArr6[i112 >>> 24] ^ iArr7[(i109 >>> 16) & 255]) ^ iArr8[(i107 >>> 8) & 255]) ^ iArr9[i105 & 255];
        int i120 = i117 + 1;
        int i121 = i119 ^ iArr[i117];
        int i122 = i120 + 1;
        int i123 = iArr[i120] ^ (((iArr6[i114 >>> 24] ^ iArr7[(i121 >>> 16) & 255]) ^ iArr8[(i118 >>> 8) & 255]) ^ iArr9[i116 & 255]);
        int i124 = i122 + 1;
        int i125 = (((iArr6[i116 >>> 24] ^ iArr7[(i114 >>> 16) & 255]) ^ iArr8[(i121 >>> 8) & 255]) ^ iArr9[i118 & 255]) ^ iArr[i122];
        int i126 = (((iArr6[i118 >>> 24] ^ iArr7[(i116 >>> 16) & 255]) ^ iArr8[(i114 >>> 8) & 255]) ^ iArr9[i121 & 255]) ^ iArr[i124];
        int i127 = (((iArr6[i121 >>> 24] ^ iArr7[(i118 >>> 16) & 255]) ^ iArr8[(i116 >>> 8) & 255]) ^ iArr9[i114 & 255]) ^ iArr[i124 + 1];
        int i128 = iArr[0];
        int i129 = i3 + 1;
        byte[] bArr3 = e;
        bArr2[i3] = (byte) (bArr3[i123 >>> 24] ^ (i128 >>> 24));
        int i130 = i129 + 1;
        bArr2[i129] = (byte) (bArr3[(i127 >>> 16) & 255] ^ (i128 >>> 16));
        int i131 = i130 + 1;
        bArr2[i130] = (byte) (bArr3[(i126 >>> 8) & 255] ^ (i128 >>> 8));
        int i132 = i131 + 1;
        bArr2[i131] = (byte) (i128 ^ bArr3[i125 & 255]);
        int i133 = iArr[1];
        int i134 = i132 + 1;
        bArr2[i132] = (byte) (bArr3[i125 >>> 24] ^ (i133 >>> 24));
        int i135 = i134 + 1;
        bArr2[i134] = (byte) (bArr3[(i123 >>> 16) & 255] ^ (i133 >>> 16));
        int i136 = i135 + 1;
        bArr2[i135] = (byte) (bArr3[(i127 >>> 8) & 255] ^ (i133 >>> 8));
        int i137 = i136 + 1;
        bArr2[i136] = (byte) (i133 ^ bArr3[i126 & 255]);
        int i138 = iArr[2];
        int i139 = i137 + 1;
        bArr2[i137] = (byte) (bArr3[i126 >>> 24] ^ (i138 >>> 24));
        int i140 = i139 + 1;
        bArr2[i139] = (byte) (bArr3[(i125 >>> 16) & 255] ^ (i138 >>> 16));
        int i141 = i140 + 1;
        bArr2[i140] = (byte) (bArr3[(i123 >>> 8) & 255] ^ (i138 >>> 8));
        int i142 = i141 + 1;
        bArr2[i141] = (byte) (i138 ^ bArr3[i127 & 255]);
        int i143 = iArr[3];
        int i144 = i142 + 1;
        bArr2[i142] = (byte) (bArr3[i127 >>> 24] ^ (i143 >>> 24));
        int i145 = i144 + 1;
        bArr2[i144] = (byte) (bArr3[(i126 >>> 16) & 255] ^ (i143 >>> 16));
        bArr2[i145] = (byte) (bArr3[(i125 >>> 8) & 255] ^ (i143 >>> 8));
        bArr2[i145 + 1] = (byte) (bArr3[i123 & 255] ^ i143);
    }

    private static final int a(int i2, byte[] bArr) {
        if (i2 == 0) {
            return 0;
        }
        int[] iArr = c;
        int i3 = iArr[i2 & 255];
        byte b2 = bArr[0];
        int i4 = b2 != 0 ? b[(iArr[b2 & UByte.MAX_VALUE] + i3) % 255] & 255 : 0;
        byte b3 = bArr[1];
        int i5 = b3 != 0 ? b[(iArr[b3 & UByte.MAX_VALUE] + i3) % 255] & 255 : 0;
        byte b4 = bArr[2];
        int i6 = b4 != 0 ? b[(iArr[b4 & UByte.MAX_VALUE] + i3) % 255] & 255 : 0;
        byte b5 = bArr[3];
        return (i4 << 24) | (i5 << 16) | (i6 << 8) | (b5 != 0 ? b[(i3 + iArr[b5 & UByte.MAX_VALUE]) % 255] & 255 : 0);
    }

    private void a(boolean z) {
        int[][] iArr = (int[][]) this.u[z ? 1 : 0];
        int length = iArr.length;
        this.v = new int[length * 4];
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < 4; i3++) {
                this.v[(i2 * 4) + i3] = iArr[i2][i3];
            }
        }
        if (z) {
            int[] iArr2 = this.v;
            int i4 = iArr2[iArr2.length - 4];
            int i5 = iArr2[iArr2.length - 3];
            int i6 = iArr2[iArr2.length - 2];
            int i7 = iArr2[iArr2.length - 1];
            for (int length2 = iArr2.length - 1; length2 > 3; length2--) {
                int[] iArr3 = this.v;
                iArr3[length2] = iArr3[length2 - 4];
            }
            int[] iArr4 = this.v;
            iArr4[0] = i4;
            iArr4[1] = i5;
            iArr4[2] = i6;
            iArr4[3] = i7;
        }
        this.s = length >= 13;
        this.t = length == 15;
        this.w = (length - 1) * 4;
    }

    public void a(boolean z, String str, byte[] bArr) throws InvalidKeyException {
        if (a(bArr.length)) {
            this.u = a(bArr);
            a(z);
        } else {
            throw new InvalidKeyException("Invalid AES key length: " + bArr.length + " bytes");
        }
    }

    public void a(byte[] bArr, int i2, byte[] bArr2, int i3) {
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i4] & UByte.MAX_VALUE) << 16) | (bArr[i2] << 24);
        int i7 = i5 + 1;
        int i8 = i6 | ((bArr[i5] & UByte.MAX_VALUE) << 8);
        int i9 = i7 + 1;
        int i10 = i8 | (bArr[i7] & UByte.MAX_VALUE);
        int[] iArr = this.v;
        int i11 = i10 ^ iArr[0];
        int i12 = i9 + 1;
        int i13 = i12 + 1;
        int i14 = (bArr[i9] << 24) | ((bArr[i12] & UByte.MAX_VALUE) << 16);
        int i15 = i13 + 1;
        int i16 = i14 | ((bArr[i13] & UByte.MAX_VALUE) << 8);
        int i17 = i15 + 1;
        int i18 = (i16 | (bArr[i15] & UByte.MAX_VALUE)) ^ iArr[1];
        int i19 = i17 + 1;
        int i20 = i19 + 1;
        int i21 = ((bArr[i19] & UByte.MAX_VALUE) << 16) | (bArr[i17] << 24);
        int i22 = i20 + 1;
        int i23 = i21 | ((bArr[i20] & UByte.MAX_VALUE) << 8);
        int i24 = i22 + 1;
        int i25 = (i23 | (bArr[i22] & UByte.MAX_VALUE)) ^ iArr[2];
        int i26 = i24 + 1;
        int i27 = i26 + 1;
        int i28 = iArr[3] ^ (((((bArr[i26] & UByte.MAX_VALUE) << 16) | (bArr[i24] << 24)) | ((bArr[i27] & UByte.MAX_VALUE) << 8)) | (bArr[i27 + 1] & UByte.MAX_VALUE));
        int i29 = 4;
        while (i29 < this.w) {
            int[] iArr2 = f;
            int i30 = iArr2[i11 >>> 24];
            int[] iArr3 = g;
            int i31 = i30 ^ iArr3[(i18 >>> 16) & 255];
            int[] iArr4 = h;
            int i32 = i31 ^ iArr4[(i25 >>> 8) & 255];
            int[] iArr5 = i;
            int i33 = i32 ^ iArr5[i28 & 255];
            int[] iArr6 = this.v;
            int i34 = i29 + 1;
            int i35 = iArr6[i29] ^ i33;
            int i36 = i34 + 1;
            int i37 = (((iArr2[i18 >>> 24] ^ iArr3[(i25 >>> 16) & 255]) ^ iArr4[(i28 >>> 8) & 255]) ^ iArr5[i11 & 255]) ^ iArr6[i34];
            int i38 = i36 + 1;
            int i39 = (((iArr2[i25 >>> 24] ^ iArr3[(i28 >>> 16) & 255]) ^ iArr4[(i11 >>> 8) & 255]) ^ iArr5[i18 & 255]) ^ iArr6[i36];
            int i40 = (((iArr3[(i11 >>> 16) & 255] ^ iArr2[i28 >>> 24]) ^ iArr4[(i18 >>> 8) & 255]) ^ iArr5[i25 & 255]) ^ iArr6[i38];
            i18 = i37;
            i25 = i39;
            i28 = i40;
            i11 = i35;
            i29 = i38 + 1;
        }
        int[] iArr7 = this.v;
        int i41 = i29 + 1;
        int i42 = iArr7[i29];
        int i43 = i3 + 1;
        byte[] bArr3 = d;
        bArr2[i3] = (byte) (bArr3[i11 >>> 24] ^ (i42 >>> 24));
        int i44 = i43 + 1;
        bArr2[i43] = (byte) (bArr3[(i18 >>> 16) & 255] ^ (i42 >>> 16));
        int i45 = i44 + 1;
        bArr2[i44] = (byte) (bArr3[(i25 >>> 8) & 255] ^ (i42 >>> 8));
        int i46 = i45 + 1;
        bArr2[i45] = (byte) (i42 ^ bArr3[i28 & 255]);
        int i47 = i41 + 1;
        int i48 = iArr7[i41];
        int i49 = i46 + 1;
        bArr2[i46] = (byte) (bArr3[i18 >>> 24] ^ (i48 >>> 24));
        int i50 = i49 + 1;
        bArr2[i49] = (byte) (bArr3[(i25 >>> 16) & 255] ^ (i48 >>> 16));
        int i51 = i50 + 1;
        bArr2[i50] = (byte) (bArr3[(i28 >>> 8) & 255] ^ (i48 >>> 8));
        int i52 = i51 + 1;
        bArr2[i51] = (byte) (i48 ^ bArr3[i11 & 255]);
        int i53 = i47 + 1;
        int i54 = iArr7[i47];
        int i55 = i52 + 1;
        bArr2[i52] = (byte) (bArr3[i25 >>> 24] ^ (i54 >>> 24));
        int i56 = i55 + 1;
        bArr2[i55] = (byte) (bArr3[(i28 >>> 16) & 255] ^ (i54 >>> 16));
        int i57 = i56 + 1;
        bArr2[i56] = (byte) (bArr3[(i11 >>> 8) & 255] ^ (i54 >>> 8));
        int i58 = i57 + 1;
        bArr2[i57] = (byte) (i54 ^ bArr3[i18 & 255]);
        int i59 = iArr7[i53];
        int i60 = i58 + 1;
        bArr2[i58] = (byte) (bArr3[i28 >>> 24] ^ (i59 >>> 24));
        int i61 = i60 + 1;
        bArr2[i60] = (byte) (bArr3[(i11 >>> 16) & 255] ^ (i59 >>> 16));
        bArr2[i61] = (byte) (bArr3[(i18 >>> 8) & 255] ^ (i59 >>> 8));
        bArr2[i61 + 1] = (byte) (bArr3[i25 & 255] ^ i59);
    }

    public static final boolean a(int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = a.f3320a;
            if (i3 >= iArr.length) {
                return false;
            }
            if (i2 == iArr[i3]) {
                return true;
            }
            i3++;
        }
    }

    private static Object[] a(byte[] bArr) throws InvalidKeyException {
        int i2;
        if (bArr == null) {
            throw new InvalidKeyException("Empty key");
        }
        if (a(bArr.length)) {
            int iB = b(bArr.length);
            int i3 = iB + 1;
            int i4 = i3 * 4;
            Class cls = Integer.TYPE;
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) cls, i3, 4);
            int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) cls, i3, 4);
            int length = bArr.length / 4;
            int[] iArr3 = new int[length];
            char c2 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                iArr3[i5] = ((bArr[i6 + 2] & UByte.MAX_VALUE) << 8) | (bArr[i6] << 24) | ((bArr[i6 + 1] & UByte.MAX_VALUE) << 16) | (bArr[i6 + 3] & UByte.MAX_VALUE);
                i5++;
                i6 += 4;
            }
            int i7 = 0;
            int i8 = 0;
            while (i7 < length && i8 < i4) {
                int i9 = i8 / 4;
                int i10 = i8 % 4;
                iArr[i9][i10] = iArr3[i7];
                iArr2[iB - i9][i10] = iArr3[i7];
                i7++;
                i8++;
            }
            int i11 = 0;
            while (i8 < i4) {
                int i12 = iArr3[length - 1];
                int i13 = iArr3[c2];
                byte[] bArr2 = d;
                int i14 = ((((bArr2[(i12 >>> 8) & 255] & UByte.MAX_VALUE) << 16) ^ (bArr2[(i12 >>> 16) & 255] << 24)) ^ ((bArr2[i12 & 255] & UByte.MAX_VALUE) << 8)) ^ (bArr2[i12 >>> 24] & UByte.MAX_VALUE);
                int i15 = i11 + 1;
                iArr3[c2] = ((r[i11] << 24) ^ i14) ^ i13;
                int i16 = 1;
                int i17 = 0;
                if (length != 8) {
                    while (i16 < length) {
                        iArr3[i16] = iArr3[i16] ^ iArr3[i17];
                        i16++;
                        i17++;
                    }
                } else {
                    while (true) {
                        i2 = length / 2;
                        if (i16 >= i2) {
                            break;
                        }
                        iArr3[i16] = iArr3[i16] ^ iArr3[i17];
                        i16++;
                        i17++;
                    }
                    int i18 = iArr3[i2 - 1];
                    int i19 = iArr3[i2];
                    byte[] bArr3 = d;
                    iArr3[i2] = ((bArr3[i18 >>> 24] << 24) ^ ((((bArr3[(i18 >>> 8) & 255] & UByte.MAX_VALUE) << 8) ^ (bArr3[i18 & 255] & UByte.MAX_VALUE)) ^ ((bArr3[(i18 >>> 16) & 255] & UByte.MAX_VALUE) << 16))) ^ i19;
                    int i20 = i2 + 1;
                    while (i20 < length) {
                        iArr3[i20] = iArr3[i20] ^ iArr3[i2];
                        i20++;
                        i2++;
                    }
                }
                int i21 = 0;
                while (i21 < length && i8 < i4) {
                    int i22 = i8 / 4;
                    int i23 = i8 % 4;
                    iArr[i22][i23] = iArr3[i21];
                    iArr2[iB - i22][i23] = iArr3[i21];
                    i21++;
                    i8++;
                }
                i11 = i15;
                c2 = 0;
            }
            for (int i24 = 1; i24 < iB; i24++) {
                for (int i25 = 0; i25 < 4; i25++) {
                    int[] iArr4 = iArr2[i24];
                    int i26 = iArr4[i25];
                    iArr4[i25] = q[i26 & 255] ^ ((n[(i26 >>> 24) & 255] ^ o[(i26 >>> 16) & 255]) ^ p[(i26 >>> 8) & 255]);
                }
            }
            return new Object[]{iArr, iArr2};
        }
        throw new InvalidKeyException("Invalid AES key length: " + bArr.length + " bytes");
    }
}
