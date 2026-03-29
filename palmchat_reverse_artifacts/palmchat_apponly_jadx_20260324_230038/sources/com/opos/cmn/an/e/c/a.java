package com.opos.cmn.an.e.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.opos.cmn.an.d.b;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    private static int a(BitmapFactory.Options options, int i, int i2) {
        int i3 = 1;
        if (options != null) {
            try {
                int i4 = options.outHeight;
                int i5 = options.outWidth;
                if (i4 > i2 || i5 > i) {
                    int i6 = i4 / 2;
                    int i7 = i5 / 2;
                    while (i6 / i3 > i2 && i7 / i3 > i) {
                        i3 *= 2;
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("BitmapTool", "", e);
            }
        }
        return i3;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        Bitmap bitmapCreateScaledBitmap = null;
        if (bitmap != null) {
            try {
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
                if (bitmap != bitmapCreateScaledBitmap) {
                    bitmap.recycle();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("BitmapTool", "", e);
            }
        }
        return bitmapCreateScaledBitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2, int i3) {
        return a(bitmap, i, i2);
    }

    public static Bitmap a(String str, int i, int i2) {
        try {
            if (b.a(str)) {
                return null;
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = a(options, i, i2);
            options.inJustDecodeBounds = false;
            return a(BitmapFactory.decodeFile(str, options), i, i2, options.inSampleSize);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("BitmapTool", "", e);
            return null;
        }
    }
}
