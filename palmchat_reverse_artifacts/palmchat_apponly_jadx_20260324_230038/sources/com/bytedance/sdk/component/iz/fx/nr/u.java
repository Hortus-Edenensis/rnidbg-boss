package com.bytedance.sdk.component.iz.fx.nr;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.oplus.tblplayer.config.PreCacheConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private int b;
    private final Bitmap.Config fx;
    private final int iz;
    private final ImageView.ScaleType n;
    private int pn;
    private final int x;
    public static final ImageView.ScaleType u = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config nr = Bitmap.Config.ARGB_4444;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5144a = 3840;
    private final int jk = PreCacheConfig.DEFAULT_MAX_CACHE_DIR_SIZE;

    public u(int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, int i3, int i4) {
        this.fx = config;
        this.b = i;
        this.pn = i2;
        this.n = scaleType;
        this.iz = i3;
        this.x = i4;
        u(i, i2);
    }

    public static int u(int i, int i2, int i3, int i4, int i5, int i6) {
        double dMin = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        if (i5 > 0 && i6 > 0) {
            dMin = Math.max(dMin, Math.min(((double) Math.max(i, i2)) / ((double) Math.max(i5, i6)), ((double) Math.min(i, i2)) / ((double) Math.min(i5, i6))));
        }
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > dMin) {
                return (int) f;
            }
            f = f2;
        }
    }

    private static int u(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        }
        if (i2 == 0) {
            return i;
        }
        double d = ((double) i4) / ((double) i3);
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d2 = i2;
            return ((double) i) * d < d2 ? (int) (d2 / d) : i;
        }
        double d3 = i2;
        return ((double) i) * d > d3 ? (int) (d3 / d) : i;
    }

    public Bitmap u(byte[] bArr) {
        Bitmap bitmapDecodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.b == 0 && this.pn == 0) {
            options.inPreferredConfig = this.fx;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int iU = u(this.b, this.pn, i, i2, this.n);
            int iU2 = u(this.pn, this.b, i2, i, this.n);
            options.inJustDecodeBounds = false;
            options.inSampleSize = u(i, i2, iU, iU2, this.iz, this.x);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iU || bitmapDecodeByteArray.getHeight() > iU2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iU, iU2, true);
                if (bitmapCreateScaledBitmap != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        if (bitmapDecodeByteArray != null && bitmapDecodeByteArray.getByteCount() > 104857600) {
            int width = bitmapDecodeByteArray.getWidth() / 2;
            int height = bitmapDecodeByteArray.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeByteArray, width, height, true);
                if (bitmapCreateScaledBitmap2 != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                return bitmapCreateScaledBitmap2;
            }
        }
        return bitmapDecodeByteArray;
    }

    private void u(int i, int i2) {
        if (i > 3840 && i2 > 3840) {
            if (i > i2) {
                this.b = 3840;
                this.pn = (i2 * 3840) / i;
                return;
            } else {
                this.b = (i * 3840) / i2;
                this.pn = 3840;
                return;
            }
        }
        if (i > 3840) {
            this.b = 3840;
            this.pn = (i2 * 3840) / i;
        } else if (i2 > 3840) {
            this.b = (i * 3840) / i2;
            this.pn = 3840;
        }
    }
}
