package com.zenmen.imageeditengine.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.Log;
import defpackage.er2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class PhotoProcessing {
    private static final String TAG = "PhotoProcessing";

    static {
        System.loadLibrary("photoprocessing");
    }

    public static Bitmap combineImages(Bitmap bitmap, Bitmap bitmap2, int i) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Log.i("hasAlpha", bitmap2.hasAlpha() + "");
        canvas.drawBitmap(bitmap, new Matrix(), null);
        Paint paint = new Paint();
        paint.setAlpha(i);
        canvas.drawBitmap(bitmap2, 0.0f, 0.0f, paint);
        return bitmapCreateBitmap;
    }

    public static Bitmap filterPhoto(Bitmap bitmap, er2 er2Var) {
        if (bitmap != null) {
            sendBitmapToNative(bitmap);
        }
        throw null;
    }

    public static Bitmap flipHorizontally(Bitmap bitmap) {
        nativeInitBitmap(bitmap.getWidth(), bitmap.getHeight());
        sendBitmapToNative(bitmap);
        nativeFlipHorizontally();
        Bitmap bitmapFromNative = getBitmapFromNative(bitmap);
        nativeDeleteBitmap();
        return bitmapFromNative;
    }

    public static native void freeBeautifyMatrix();

    private static Bitmap getBitmapFromNative(Bitmap bitmap) {
        int iNativeGetBitmapWidth = nativeGetBitmapWidth();
        int iNativeGetBitmapHeight = nativeGetBitmapHeight();
        if (bitmap == null || iNativeGetBitmapWidth != bitmap.getWidth() || iNativeGetBitmapHeight != bitmap.getHeight() || !bitmap.isMutable()) {
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            if (bitmap != null) {
                config = bitmap.getConfig();
                bitmap.recycle();
            }
            bitmap = Bitmap.createBitmap(iNativeGetBitmapWidth, iNativeGetBitmapHeight, config);
        }
        int[] iArr = new int[iNativeGetBitmapWidth];
        for (int i = 0; i < iNativeGetBitmapHeight; i++) {
            nativeGetBitmapRow(i, iArr);
            bitmap.setPixels(iArr, 0, iNativeGetBitmapWidth, 0, i, iNativeGetBitmapWidth, 1);
        }
        return bitmap;
    }

    public static native void handleSmooth(Bitmap bitmap, float f);

    public static native void handleSmoothAndWhiteSkin(Bitmap bitmap, float f, float f2);

    public static native void handleWhiteSkin(Bitmap bitmap, float f);

    public static Bitmap makeBitmapMutable(Bitmap bitmap) {
        sendBitmapToNative(bitmap);
        return getBitmapFromNative(bitmap);
    }

    public static native void nativeApplyAnsel();

    public static native void nativeApplyBW();

    public static native void nativeApplyCustomFilter(int i);

    public static native void nativeApplyCyano();

    public static native void nativeApplyGeorgia();

    public static native void nativeApplyHDR();

    public static native void nativeApplyInstafix();

    public static native void nativeApplyRetro();

    public static native void nativeApplySahara();

    public static native void nativeApplySepia();

    public static native void nativeApplyTestino();

    public static native void nativeApplyXPro();

    public static native void nativeDeleteBitmap();

    public static native void nativeFlipHorizontally();

    public static native int nativeGetBitmapHeight();

    public static native void nativeGetBitmapRow(int i, int[] iArr);

    public static native int nativeGetBitmapWidth();

    public static native int nativeInitBitmap(int i, int i2);

    public static native void nativeLoadResizedJpegBitmap(byte[] bArr, int i, int i2);

    public static native void nativeResizeBitmap(int i, int i2);

    public static native void nativeRotate180();

    public static native int nativeRotate90();

    public static native void nativeSetBitmapRow(int i, int[] iArr);

    public static Bitmap rotate(Bitmap bitmap, int i) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap.Config config = bitmap.getConfig();
        nativeInitBitmap(width, height);
        sendBitmapToNative(bitmap);
        if (i == 90) {
            nativeRotate90();
            bitmap.recycle();
            Bitmap bitmapFromNative = getBitmapFromNative(Bitmap.createBitmap(height, width, config));
            nativeDeleteBitmap();
            return bitmapFromNative;
        }
        if (i == 180) {
            nativeRotate180();
            bitmap.recycle();
            Bitmap bitmapFromNative2 = getBitmapFromNative(Bitmap.createBitmap(width, height, config));
            nativeDeleteBitmap();
            return bitmapFromNative2;
        }
        if (i != 270) {
            return bitmap;
        }
        nativeRotate180();
        nativeRotate90();
        bitmap.recycle();
        Bitmap bitmapFromNative3 = getBitmapFromNative(Bitmap.createBitmap(height, width, config));
        nativeDeleteBitmap();
        return bitmapFromNative3;
    }

    private static void sendBitmapToNative(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        nativeInitBitmap(width, height);
        int[] iArr = new int[width];
        for (int i = 0; i < height; i++) {
            bitmap.getPixels(iArr, 0, width, 0, i, width, 1);
            nativeSetBitmapRow(i, iArr);
        }
    }
}
