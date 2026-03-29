package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.umeng.analytics.pro.dn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final short[] f9385a = {512, 512, 456, 512, 328, 456, 335, 512, 405, 328, 271, 456, 388, 335, 292, 512, 454, 405, 364, 328, 298, 271, 496, 456, 420, 388, 360, 335, 312, 292, 273, 512, 482, 454, 428, 405, 383, 364, 345, 328, 312, 298, 284, 271, 259, 496, 475, 456, 437, 420, 404, 388, 374, 360, 347, 335, 323, 312, 302, 292, 282, 273, 265, 512, 497, 482, 468, 454, 441, 428, 417, 405, 394, 383, 373, 364, 354, 345, 337, 328, 320, 312, 305, 298, 291, 284, 278, 271, 265, 259, 507, 496, 485, 475, 465, 456, 446, 437, 428, 420, 412, 404, 396, 388, 381, 374, 367, 360, 354, 347, 341, 335, 329, 323, 318, 312, 307, 302, 297, 292, 287, 282, 278, 273, 269, 265, 261, 512, 505, 497, 489, 482, 475, 468, 461, 454, 447, 441, 435, 428, 422, 417, 411, 405, 399, 394, 389, 383, 378, 373, 368, 364, 359, 354, 350, 345, 341, 337, 332, 328, 324, 320, 316, 312, 309, 305, 301, 298, 294, 291, 287, 284, 281, 278, 274, 271, 268, 265, 262, 259, 257, 507, 501, 496, 491, 485, 480, 475, 470, 465, 460, 456, 451, 446, 442, 437, 433, 428, 424, 420, 416, 412, 408, 404, 400, 396, 392, 388, 385, 381, 377, 374, 370, 367, 363, 360, 357, 354, 350, 347, 344, 341, 338, 335, 332, 329, 326, 323, 320, 318, 315, 312, 310, 307, 304, 302, 299, 297, 294, 292, 289, 287, 285, 282, 280, 278, 275, 273, 271, 269, 267, 265, 263, 261, 259};
    private static final byte[] b = {9, 11, 12, dn.k, dn.k, dn.l, dn.l, 15, 15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24};

    /* JADX INFO: renamed from: com.opos.mobad.template.cmn.f$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9388a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f9388a = iArr;
            try {
                iArr[Bitmap.Config.RGB_565.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9388a[Bitmap.Config.ALPHA_8.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9388a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9388a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a();

        void a(Bitmap bitmap);
    }

    public static Bitmap a(Context context, Bitmap bitmap, int i, float f, float f2) {
        if (context == null || bitmap == null) {
            return null;
        }
        try {
            int width = (bitmap.getWidth() * i) / 100;
            int height = (bitmap.getHeight() * i) / 100;
            Bitmap bitmapB = b(a(bitmap, (bitmap.getWidth() - width) / 2, (bitmap.getHeight() - height) / 2, width, height), f);
            if (bitmapB != null) {
                return a(bitmapB, f2);
            }
            return null;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("GaussianBlur", "", th);
            return null;
        }
    }

    private static Bitmap b(Bitmap bitmap, float f) {
        Bitmap bitmapCreateScaledBitmap = null;
        if (bitmap != null) {
            try {
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * f), Math.round(bitmap.getHeight() * f), true);
                if (bitmap != bitmapCreateScaledBitmap) {
                    com.opos.cmn.an.f.a.b("GaussianBlur", "src != dst,src.recycle()");
                    bitmap.recycle();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("GaussianBlur", "", (Throwable) e);
            }
        }
        return bitmapCreateScaledBitmap;
    }

    private static Bitmap a(Bitmap bitmap, float f) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i = (int) f;
        a(iArr, width, height, i, 1, 0, 1);
        a(iArr, width, height, i, 1, 0, 2);
        return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
    }

    private static Bitmap a(Bitmap bitmap, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (i < 0 || i2 < 0 || i3 < 1 || i4 < 1 || (i5 = i + i3) > bitmap.getWidth() || (i6 = i2 + i4) > bitmap.getHeight()) {
            return bitmap;
        }
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        Bitmap.Config config2 = bitmap.getConfig();
        if (config2 != null) {
            int i7 = AnonymousClass2.f9388a[config2.ordinal()];
            config = i7 != 1 ? i7 != 2 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.ALPHA_8 : Bitmap.Config.RGB_565;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3, i4, config);
        bitmapCreateBitmap.setDensity(bitmap.getDensity());
        Rect rect = new Rect(i, i2, i5, i6);
        RectF rectF = new RectF(0.0f, 0.0f, i3, i4);
        Canvas canvas = new Canvas();
        canvas.setBitmap(bitmapCreateBitmap);
        canvas.drawColor(-1);
        canvas.drawBitmap(bitmap, rect, rectF, (Paint) null);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    public static void a(final Context context, final Bitmap bitmap, final int i, final float f, final float f2, final a aVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.template.cmn.f.1
            @Override // java.lang.Runnable
            public void run() {
                final Bitmap bitmapA = f.a(context, bitmap, i, f, f2);
                com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.cmn.f.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            Bitmap bitmap2 = bitmapA;
                            if (bitmap2 != null) {
                                aVar2.a(bitmap2);
                            } else {
                                aVar2.a();
                            }
                        }
                    }
                });
            }
        });
    }

    private static void a(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i;
        int i8 = i2;
        int i9 = i3;
        int i10 = i7 - 1;
        int i11 = i8 - 1;
        int i12 = (i9 * 2) + 1;
        short s = f9385a[i9];
        byte b2 = b[i9];
        int[] iArr2 = new int[i12];
        if (i6 == 1) {
            int i13 = (i5 * i8) / i4;
            int i14 = ((i5 + 1) * i8) / i4;
            while (i13 < i14) {
                int i15 = i7 * i13;
                int i16 = 0;
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                long j6 = 0;
                while (i16 <= i9) {
                    iArr2[i16] = iArr[i15];
                    int i17 = iArr[i15];
                    i16++;
                    j += (long) (((i17 >>> 16) & 255) * i16);
                    j2 += (long) (((i17 >>> 8) & 255) * i16);
                    j3 += (long) ((i17 & 255) * i16);
                    j4 += (long) ((i17 >>> 16) & 255);
                    j5 += (long) ((i17 >>> 8) & 255);
                    j6 += (long) (i17 & 255);
                }
                int i18 = i15;
                int i19 = 1;
                long j7 = 0;
                long j8 = 0;
                long j9 = 0;
                while (i19 <= i9) {
                    if (i19 <= i10) {
                        i18++;
                    }
                    iArr2[i19 + i9] = iArr[i18];
                    int i20 = iArr[i18];
                    int i21 = (i9 + 1) - i19;
                    j += (long) (((i20 >>> 16) & 255) * i21);
                    j2 += (long) (((i20 >>> 8) & 255) * i21);
                    j3 += (long) ((i20 & 255) * i21);
                    j7 += (long) ((i20 >>> 16) & 255);
                    j8 += (long) ((i20 >>> 8) & 255);
                    j9 += (long) (i20 & 255);
                    i19++;
                    i18 = i18;
                }
                int i22 = i9 > i10 ? i10 : i9;
                int i23 = i22 + i15;
                int i24 = i9;
                int i25 = 0;
                while (i25 < i7) {
                    int i26 = i14;
                    long j10 = j7;
                    int i27 = i25;
                    int i28 = i13;
                    int i29 = i10;
                    long j11 = s;
                    iArr[i15] = (int) ((((j11 * j3) >>> b2) & 255) | ((long) (iArr[i15] & (-16777216))) | ((((j * j11) >>> b2) & 255) << 16) | ((((j2 * j11) >>> b2) & 255) << 8));
                    int i30 = i15 + 1;
                    long j12 = j - j4;
                    long j13 = j2 - j5;
                    long j14 = j3 - j6;
                    int i31 = (i24 + i12) - i9;
                    if (i31 >= i12) {
                        i31 -= i12;
                    }
                    int i32 = iArr2[i31];
                    long j15 = j4 - ((long) ((i32 >>> 16) & 255));
                    long j16 = j5 - ((long) ((i32 >>> 8) & 255));
                    long j17 = j6 - ((long) (i32 & 255));
                    i10 = i29;
                    if (i22 < i10) {
                        i23++;
                        i22++;
                    }
                    iArr2[i31] = iArr[i23];
                    int i33 = iArr[i23];
                    long j18 = j10 + ((long) ((i33 >>> 16) & 255));
                    int i34 = i22;
                    short s2 = s;
                    long j19 = j8 + ((long) ((i33 >>> 8) & 255));
                    long j20 = j9 + ((long) (i33 & 255));
                    j = j12 + j18;
                    j2 = j13 + j19;
                    j3 = j14 + j20;
                    i24++;
                    if (i24 >= i12) {
                        i24 = 0;
                    }
                    int i35 = iArr2[i24];
                    j4 = j15 + ((long) ((i35 >>> 16) & 255));
                    j5 = j16 + ((long) ((i35 >>> 8) & 255));
                    j6 = j17 + ((long) (i35 & 255));
                    long j21 = j18 - ((long) ((i35 >>> 16) & 255));
                    j8 = j19 - ((long) ((i35 >>> 8) & 255));
                    j9 = j20 - ((long) (i35 & 255));
                    i25 = i27 + 1;
                    i15 = i30;
                    i13 = i28;
                    j7 = j21;
                    s = s2;
                    i14 = i26;
                    i22 = i34;
                }
                i13++;
                i14 = i14;
            }
            return;
        }
        short s3 = s;
        if (i6 == 2) {
            int i36 = (i5 * i7) / i4;
            int i37 = ((i5 + 1) * i7) / i4;
            while (i36 < i37) {
                int i38 = 0;
                long j22 = 0;
                long j23 = 0;
                long j24 = 0;
                long j25 = 0;
                long j26 = 0;
                long j27 = 0;
                while (i38 <= i9) {
                    iArr2[i38] = iArr[i36];
                    int i39 = iArr[i36];
                    i38++;
                    j22 += (long) (((i39 >>> 16) & 255) * i38);
                    j23 += (long) (((i39 >>> 8) & 255) * i38);
                    j24 += (long) ((i39 & 255) * i38);
                    j25 += (long) ((i39 >>> 16) & 255);
                    j26 += (long) ((i39 >>> 8) & 255);
                    j27 += (long) (i39 & 255);
                    i37 = i37;
                    i12 = i12;
                }
                int i40 = i12;
                int i41 = i37;
                int i42 = i36;
                int i43 = 1;
                long j28 = 0;
                long j29 = 0;
                long j30 = 0;
                while (i43 <= i9) {
                    if (i43 <= i11) {
                        i42 += i7;
                    }
                    iArr2[i43 + i9] = iArr[i42];
                    int i44 = iArr[i42];
                    int i45 = (i9 + 1) - i43;
                    j22 += (long) (((i44 >>> 16) & 255) * i45);
                    j23 += (long) (((i44 >>> 8) & 255) * i45);
                    j24 += (long) ((i44 & 255) * i45);
                    j28 += (long) ((i44 >>> 16) & 255);
                    j29 += (long) ((i44 >>> 8) & 255);
                    j30 += (long) (i44 & 255);
                    i43++;
                    i42 = i42;
                    b2 = b2;
                    iArr2 = iArr2;
                }
                byte b3 = b2;
                int[] iArr3 = iArr2;
                int i46 = i9 > i11 ? i11 : i9;
                int i47 = (i46 * i7) + i36;
                int i48 = i9;
                int i49 = i36;
                int i50 = 0;
                while (i50 < i8) {
                    long j31 = j28;
                    int i51 = i36;
                    short s4 = s3;
                    int i52 = i46;
                    long j32 = s4;
                    iArr[i49] = (int) ((((j32 * j24) >>> b3) & 255) | ((long) (iArr[i49] & (-16777216))) | ((((j22 * j32) >>> b3) & 255) << 16) | ((((j23 * j32) >>> b3) & 255) << 8));
                    i49 += i7;
                    long j33 = j22 - j25;
                    long j34 = j23 - j26;
                    long j35 = j24 - j27;
                    int i53 = (i48 + i40) - i9;
                    int i54 = i40;
                    if (i53 >= i54) {
                        i53 -= i54;
                    }
                    int i55 = iArr3[i53];
                    long j36 = j25 - ((long) ((i55 >>> 16) & 255));
                    long j37 = j26 - ((long) ((i55 >>> 8) & 255));
                    long j38 = j27 - ((long) (i55 & 255));
                    int i56 = i52;
                    if (i56 < i11) {
                        i47 += i7;
                        i56++;
                    }
                    iArr3[i53] = iArr[i47];
                    int i57 = iArr[i47];
                    long j39 = j31 + ((long) ((i57 >>> 16) & 255));
                    int i58 = i56;
                    long j40 = j29 + ((long) ((i57 >>> 8) & 255));
                    long j41 = j30 + ((long) (i57 & 255));
                    j22 = j33 + j39;
                    j23 = j34 + j40;
                    j24 = j35 + j41;
                    i48++;
                    if (i48 >= i54) {
                        i48 = 0;
                    }
                    int i59 = iArr3[i48];
                    j25 = j36 + ((long) ((i59 >>> 16) & 255));
                    j26 = j37 + ((long) ((i59 >>> 8) & 255));
                    j27 = j38 + ((long) (i59 & 255));
                    j28 = j39 - ((long) ((i59 >>> 16) & 255));
                    j29 = j40 - ((long) ((i59 >>> 8) & 255));
                    j30 = j41 - ((long) (i59 & 255));
                    i50++;
                    i7 = i;
                    i8 = i2;
                    i9 = i3;
                    s3 = s4;
                    i36 = i51;
                    i40 = i54;
                    i46 = i58;
                }
                i36++;
                i7 = i;
                i8 = i2;
                i9 = i3;
                i37 = i41;
                i12 = i40;
                b2 = b3;
                iArr2 = iArr3;
            }
        }
    }
}
