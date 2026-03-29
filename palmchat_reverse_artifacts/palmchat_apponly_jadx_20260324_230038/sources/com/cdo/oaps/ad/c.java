package com.cdo.oaps.ad;

import androidx.media3.muxer.MuxerUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Random f5447a = new Random();
    private int c;
    private int d;
    private int e;
    private byte[] g;
    private byte[] h;
    private int i;
    private byte[] j;
    private int k;
    private byte[] l;
    private boolean f = true;
    private ByteArrayOutputStream b = new ByteArrayOutputStream(8);

    private static long a(byte[] bArr, int i, int i2) {
        long j = 0;
        int i3 = i2 > 8 ? i + 8 : i2 + i;
        while (i < i3) {
            j = (j << 8) | ((long) (bArr[i] & UByte.MAX_VALUE));
            i++;
        }
        return (MuxerUtil.UNSIGNED_INT_MAX_VALUE & j) | (j >>> 32);
    }

    private int b() {
        return f5447a.nextInt();
    }

    private void a() {
        this.k = 0;
        while (true) {
            int i = this.k;
            if (i >= 8) {
                break;
            }
            if (this.f) {
                byte[] bArr = this.j;
                bArr[i] = (byte) (bArr[i] ^ this.l[i]);
            } else {
                byte[] bArr2 = this.j;
                bArr2[i] = (byte) (bArr2[i] ^ this.h[this.e + i]);
            }
            this.k = i + 1;
        }
        System.arraycopy(b(this.j), 0, this.h, this.d, 8);
        this.k = 0;
        while (true) {
            int i2 = this.k;
            if (i2 >= 8) {
                System.arraycopy(this.j, 0, this.l, 0, 8);
                int i3 = this.d;
                this.e = i3;
                this.d = i3 + 8;
                this.k = 0;
                this.f = false;
                return;
            }
            byte[] bArr3 = this.h;
            int i4 = this.d + i2;
            bArr3[i4] = (byte) (bArr3[i4] ^ this.l[i2]);
            this.k = i2 + 1;
        }
    }

    private boolean b(byte[] bArr, int i, int i2) {
        this.k = 0;
        while (true) {
            int i3 = this.k;
            if (i3 >= 8) {
                this.l = a(this.l);
                this.c += 8;
                this.d += 8;
                this.k = 0;
                return true;
            }
            if (this.c + i3 >= i2) {
                return true;
            }
            byte[] bArr2 = this.l;
            bArr2[i3] = (byte) (bArr2[i3] ^ bArr[(this.d + i) + i3]);
            this.k = i3 + 1;
        }
    }

    private void a(int i) {
        this.b.write(i >>> 24);
        this.b.write(i >>> 16);
        this.b.write(i >>> 8);
        this.b.write(i);
    }

    private byte[] b(byte[] bArr) {
        long jA = a(bArr, 0, 4);
        long jA2 = a(bArr, 4, 4);
        long jA3 = a(this.g, 0, 4);
        long jA4 = a(this.g, 4, 4);
        long jA5 = a(this.g, 8, 4);
        long jA6 = a(this.g, 12, 4);
        int i = 16;
        long j = 0;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                this.b.reset();
                a((int) jA);
                a((int) jA2);
                return this.b.toByteArray();
            }
            j = (j + 2654435769L) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
            jA = (jA + ((((jA2 << 4) + jA3) ^ (jA2 + j)) ^ ((jA2 >>> 5) + jA4))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
            jA2 = (jA2 + ((((jA << 4) + jA5) ^ (jA + j)) ^ ((jA >>> 5) + jA6))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
            i = i2;
        }
    }

    private byte[] a(byte[] bArr) {
        return a(bArr, 0);
    }

    public byte[] b(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3;
        if (bArr2 == null) {
            return bArr;
        }
        byte[] bArr3 = new byte[8];
        this.j = bArr3;
        this.l = new byte[8];
        this.k = 1;
        this.i = 0;
        this.e = 0;
        this.d = 0;
        this.g = bArr2;
        this.f = true;
        int i4 = (i2 + 10) % 8;
        this.k = i4;
        if (i4 != 0) {
            this.k = 8 - i4;
        }
        this.h = new byte[this.k + i2 + 10];
        bArr3[0] = (byte) ((b() & MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT) | this.k);
        int i5 = 1;
        while (true) {
            i3 = this.k;
            if (i5 > i3) {
                break;
            }
            this.j[i5] = (byte) (b() & 255);
            i5++;
        }
        this.k = i3 + 1;
        for (int i6 = 0; i6 < 8; i6++) {
            this.l[i6] = 0;
        }
        this.i = 1;
        while (this.i <= 2) {
            int i7 = this.k;
            if (i7 < 8) {
                byte[] bArr4 = this.j;
                this.k = i7 + 1;
                bArr4[i7] = (byte) (b() & 255);
                this.i++;
            }
            if (this.k == 8) {
                a();
            }
        }
        while (i2 > 0) {
            int i8 = this.k;
            if (i8 < 8) {
                byte[] bArr5 = this.j;
                this.k = i8 + 1;
                bArr5[i8] = bArr[i];
                i2--;
                i++;
            }
            if (this.k == 8) {
                a();
            }
        }
        this.i = 1;
        while (true) {
            int i9 = this.i;
            if (i9 > 7) {
                return (byte[]) this.h.clone();
            }
            int i10 = this.k;
            if (i10 < 8) {
                byte[] bArr6 = this.j;
                this.k = i10 + 1;
                bArr6[i10] = 0;
                this.i = i9 + 1;
            }
            if (this.k == 8) {
                a();
            }
        }
    }

    private byte[] a(byte[] bArr, int i) {
        long jA = a(bArr, i, 4);
        long jA2 = a(bArr, i + 4, 4);
        long jA3 = a(this.g, 0, 4);
        long jA4 = a(this.g, 4, 4);
        long jA5 = a(this.g, 8, 4);
        long jA6 = a(this.g, 12, 4);
        int i2 = 16;
        long j = 3816266640L;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                this.b.reset();
                a((int) jA);
                a((int) jA2);
                return this.b.toByteArray();
            }
            jA2 = (jA2 - ((((jA << 4) + jA5) ^ (jA + j)) ^ ((jA >>> 5) + jA6))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
            jA = (jA - ((((jA2 << 4) + jA3) ^ (jA2 + j)) ^ ((jA2 >>> 5) + jA4))) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
            j = (j - 2654435769L) & MuxerUtil.UNSIGNED_INT_MAX_VALUE;
            i2 = i3;
        }
    }

    public byte[] b(byte[] bArr, byte[] bArr2) {
        return b(bArr, 0, bArr.length, bArr2);
    }

    public byte[] a(byte[] bArr, int i, int i2, byte[] bArr2) {
        if (bArr2 == null) {
            return null;
        }
        int i3 = 0;
        this.e = 0;
        this.d = 0;
        this.g = bArr2;
        int i4 = i + 8;
        byte[] bArr3 = new byte[i4];
        if (i2 % 8 != 0 || i2 < 16) {
            return null;
        }
        byte[] bArrA = a(bArr, i);
        this.l = bArrA;
        int i5 = bArrA[0] & 7;
        this.k = i5;
        int i6 = (i2 - i5) - 10;
        if (i6 < 0) {
            return null;
        }
        for (int i7 = i; i7 < i4; i7++) {
            bArr3[i7] = 0;
        }
        this.h = new byte[i6];
        this.e = 0;
        this.d = 8;
        this.c = 8;
        this.k++;
        this.i = 1;
        while (true) {
            int i8 = this.i;
            if (i8 > 2) {
                while (i6 != 0) {
                    int i9 = this.k;
                    if (i9 < 8) {
                        this.h[i3] = (byte) (bArr3[(this.e + i) + i9] ^ this.l[i9]);
                        i3++;
                        i6--;
                        this.k = i9 + 1;
                    }
                    if (this.k == 8) {
                        this.e = this.d - 8;
                        if (!b(bArr, i, i2)) {
                            return null;
                        }
                        bArr3 = bArr;
                    }
                }
                this.i = 1;
                while (this.i < 8) {
                    int i10 = this.k;
                    if (i10 < 8) {
                        if ((bArr3[(this.e + i) + i10] ^ this.l[i10]) != 0) {
                            return null;
                        }
                        this.k = i10 + 1;
                    }
                    if (this.k == 8) {
                        this.e = this.d;
                        if (!b(bArr, i, i2)) {
                            return null;
                        }
                        bArr3 = bArr;
                    }
                    this.i++;
                }
                return (byte[]) this.h.clone();
            }
            int i11 = this.k;
            if (i11 < 8) {
                this.k = i11 + 1;
                this.i = i8 + 1;
            }
            if (this.k == 8) {
                if (!b(bArr, i, i2)) {
                    return null;
                }
                bArr3 = bArr;
            }
        }
    }

    public byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, 0, bArr.length, bArr2);
    }
}
