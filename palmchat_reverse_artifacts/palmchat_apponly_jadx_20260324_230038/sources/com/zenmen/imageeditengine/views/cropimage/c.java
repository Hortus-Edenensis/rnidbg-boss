package com.zenmen.imageeditengine.views.cropimage;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import com.baidu.mapapi.http.HttpClient;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.zenmen.imageeditengine.views.cropimage.CropImageView;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Rect f11831a = new Rect();
    public static final RectF b = new RectF();
    public static final RectF c = new RectF();
    public static final float[] d = new float[6];
    public static final float[] e = new float[6];
    public static int f;
    public static Pair<String, WeakReference<Bitmap>> g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f11832a;
        public final int b;

        public a(Bitmap bitmap, int i) {
            this.f11832a = bitmap;
            this.b = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bitmap f11833a;
        public final int b;

        public b(Bitmap bitmap, int i) {
            this.f11833a = bitmap;
            this.b = i;
        }
    }

    public static b A(Bitmap bitmap, Context context, Uri uri) {
        ExifInterface exifInterface = null;
        try {
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            File file = new File(uri.toString());
            if (inputStreamOpenInputStream != null) {
                ExifInterface exifInterface2 = new ExifInterface(file.getAbsolutePath());
                try {
                    inputStreamOpenInputStream.close();
                } catch (Exception unused) {
                }
                exifInterface = exifInterface2;
            }
        } catch (Exception unused2) {
        }
        return exifInterface != null ? B(bitmap, exifInterface) : new b(bitmap, 0);
    }

    public static b B(Bitmap bitmap, ExifInterface exifInterface) {
        int attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        return new b(bitmap, attributeInt != 3 ? attributeInt != 6 ? attributeInt != 8 ? 0 : 270 : 90 : EffectConstants.ROTATION_DEGREES_180);
    }

    public static void C(Context context, Bitmap bitmap, Uri uri, Bitmap.CompressFormat compressFormat, int i) throws FileNotFoundException {
        OutputStream outputStreamOpenOutputStream = null;
        try {
            outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uri);
            bitmap.compress(compressFormat, i, outputStreamOpenOutputStream);
        } finally {
            c(outputStreamOpenOutputStream);
        }
    }

    public static Uri D(Context context, Bitmap bitmap, Uri uri) {
        boolean z = true;
        try {
            if (uri == null) {
                uri = Uri.fromFile(File.createTempFile("aic_state_store_temp", ".jpg", context.getCacheDir()));
            } else if (new File(uri.getPath()).exists()) {
                z = false;
            }
            if (z) {
                C(context, bitmap, uri, Bitmap.CompressFormat.JPEG, 95);
            }
            return uri;
        } catch (Exception e2) {
            Log.w("AIC", "Failed to write bitmap to temp file for image-cropper save instance state", e2);
            return null;
        }
    }

    public static int a(int i, int i2) {
        if (f == 0) {
            f = o();
        }
        int i3 = 1;
        if (f > 0) {
            while (true) {
                int i4 = i2 / i3;
                int i5 = f;
                if (i4 <= i5 && i / i3 <= i5) {
                    break;
                }
                i3 *= 2;
            }
        }
        return i3;
    }

    public static int b(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            while ((i2 / 2) / i5 > i4 && (i / 2) / i5 > i3) {
                i5 *= 2;
            }
        }
        return i5;
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static a d(Context context, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3) {
        int i8 = 1;
        do {
            try {
                return e(context, uri, fArr, i, i2, i3, z, i4, i5, i6, i7, z2, z3, i8);
            } catch (OutOfMemoryError e2) {
                i8 *= 2;
            }
        } while (i8 <= 16);
        throw new RuntimeException("Failed to handle OOM by sampling (" + i8 + "): " + uri + HttpClient.NEWLINE + e2.getMessage(), e2);
    }

    public static a e(Context context, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, boolean z2, boolean z3, int i8) throws Throwable {
        int i9;
        Rect rectS = s(fArr, i2, i3, z, i4, i5);
        int iWidth = i6 > 0 ? i6 : rectS.width();
        int iHeight = i7 > 0 ? i7 : rectS.height();
        Bitmap bitmap = null;
        try {
            a aVarM = m(context, uri, rectS, iWidth, iHeight, i8);
            bitmap = aVarM.f11832a;
            i9 = aVarM.b;
        } catch (Exception unused) {
            i9 = 1;
        }
        if (bitmap == null) {
            return f(context, uri, fArr, i, z, i4, i5, i8, rectS, iWidth, iHeight, z2, z3);
        }
        try {
            Bitmap bitmapZ = z(bitmap, i, z2, z3);
            try {
                if (i % 90 != 0) {
                    bitmapZ = i(bitmapZ, fArr, rectS, i, z, i4, i5);
                }
                return new a(bitmapZ, i9);
            } catch (OutOfMemoryError e2) {
                e = e2;
                bitmap = bitmapZ;
                if (bitmap != null) {
                    bitmap.recycle();
                }
                throw e;
            }
        } catch (OutOfMemoryError e3) {
            e = e3;
        }
    }

    public static a f(Context context, Uri uri, float[] fArr, int i, boolean z, int i2, int i3, int i4, Rect rect, int i5, int i6, boolean z2, boolean z3) {
        Bitmap bitmapH = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int iB = b(rect.width(), rect.height(), i5, i6) * i4;
            options.inSampleSize = iB;
            Bitmap bitmapJ = j(context.getContentResolver(), uri, options);
            if (bitmapJ != null) {
                try {
                    int length = fArr.length;
                    float[] fArr2 = new float[length];
                    System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                    for (int i7 = 0; i7 < length; i7++) {
                        fArr2[i7] = fArr2[i7] / options.inSampleSize;
                    }
                    bitmapH = h(bitmapJ, fArr2, i, z, i2, i3, 1.0f, z2, z3);
                    if (bitmapH != bitmapJ) {
                        bitmapJ.recycle();
                    }
                } catch (Throwable th) {
                    bitmapJ.recycle();
                    throw th;
                }
            }
            return new a(bitmapH, iB);
        } catch (Exception e2) {
            throw new RuntimeException("Failed to load sampled bitmap: " + uri + HttpClient.NEWLINE + e2.getMessage(), e2);
        } catch (OutOfMemoryError e3) {
            if (0 != 0) {
                bitmapH.recycle();
            }
            throw e3;
        }
    }

    public static a g(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, boolean z2, boolean z3) {
        if (bitmap == null) {
            return null;
        }
        int i4 = 1;
        do {
            try {
                return new a(h(bitmap, fArr, i, z, i2, i3, 1.0f / i4, z2, z3), i4);
            } catch (OutOfMemoryError e2) {
                i4 *= 2;
            }
        } while (i4 <= 8);
        throw e2;
    }

    public static Bitmap h(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, float f2, boolean z2, boolean z3) {
        float f3 = f2;
        Rect rectS = s(fArr, bitmap.getWidth(), bitmap.getHeight(), z, i2, i3);
        Matrix matrix = new Matrix();
        matrix.setRotate(i, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        float f4 = z2 ? -f3 : f3;
        if (z3) {
            f3 = -f3;
        }
        matrix.postScale(f4, f3);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rectS.left, rectS.top, rectS.width(), rectS.height(), matrix, true);
        if (bitmapCreateBitmap == bitmap) {
            try {
                bitmapCreateBitmap = bitmap.copy(bitmap.getConfig(), false);
            } catch (Exception unused) {
                return bitmapCreateBitmap;
            }
        }
        return i % 90 != 0 ? i(bitmapCreateBitmap, fArr, rectS, i, z, i2, i3) : bitmapCreateBitmap;
    }

    public static Bitmap i(Bitmap bitmap, float[] fArr, Rect rect, int i, boolean z, int i2, int i3) {
        int iAbs;
        int iAbs2;
        int iAbs3;
        if (i % 90 == 0) {
            return bitmap;
        }
        double radians = Math.toRadians(i);
        int i4 = (i < 90 || (i > 180 && i < 270)) ? rect.left : rect.right;
        int iAbs4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= fArr.length) {
                iAbs = 0;
                iAbs2 = 0;
                iAbs3 = 0;
                break;
            }
            float f2 = fArr[i5];
            if (f2 >= i4 - 1 && f2 <= i4 + 1) {
                int i6 = i5 + 1;
                iAbs4 = (int) Math.abs(Math.sin(radians) * ((double) (rect.bottom - fArr[i6])));
                iAbs2 = (int) Math.abs(Math.cos(radians) * ((double) (fArr[i6] - rect.top)));
                iAbs3 = (int) Math.abs(((double) (fArr[i6] - rect.top)) / Math.sin(radians));
                iAbs = (int) Math.abs(((double) (rect.bottom - fArr[i6])) / Math.cos(radians));
                break;
            }
            i5 += 2;
        }
        rect.set(iAbs4, iAbs2, iAbs3 + iAbs4, iAbs + iAbs2);
        if (z) {
            n(rect, i2, i3);
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
        if (bitmap != bitmapCreateBitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    public static Bitmap j(ContentResolver contentResolver, Uri uri, BitmapFactory.Options options) throws FileNotFoundException {
        do {
            InputStream inputStreamOpenInputStream = null;
            try {
                try {
                    inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                    return BitmapFactory.decodeStream(inputStreamOpenInputStream, f11831a, options);
                } catch (OutOfMemoryError unused) {
                    options.inSampleSize *= 2;
                    c(inputStreamOpenInputStream);
                }
            } finally {
                c(inputStreamOpenInputStream);
            }
        } while (options.inSampleSize <= 512);
        throw new RuntimeException("Failed to decode image: " + uri);
    }

    public static BitmapFactory.Options k(ContentResolver contentResolver, Uri uri) throws Throwable {
        InputStream inputStreamOpenInputStream;
        try {
            inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStreamOpenInputStream, f11831a, options);
                options.inJustDecodeBounds = false;
                c(inputStreamOpenInputStream);
                return options;
            } catch (Throwable th) {
                th = th;
                c(inputStreamOpenInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenInputStream = null;
        }
    }

    public static a l(Context context, Uri uri, int i, int i2) throws Throwable {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            BitmapFactory.Options optionsK = k(contentResolver, uri);
            optionsK.inSampleSize = Math.max(b(optionsK.outWidth, optionsK.outHeight, i, i2), a(optionsK.outWidth, optionsK.outHeight));
            return new a(j(contentResolver, uri, optionsK), optionsK.inSampleSize);
        } catch (Exception e2) {
            throw new RuntimeException("Failed to load sampled bitmap: " + uri + HttpClient.NEWLINE + e2.getMessage(), e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a m(Context context, Uri uri, Rect rect, int i, int i2, int i3) throws Throwable {
        BitmapRegionDecoder bitmapRegionDecoderNewInstance;
        int i4;
        InputStream inputStream = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i3 * b(rect.width(), rect.height(), i, i2);
            InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
            try {
                bitmapRegionDecoderNewInstance = BitmapRegionDecoder.newInstance(inputStreamOpenInputStream, false);
                do {
                    try {
                        try {
                            a aVar = new a(bitmapRegionDecoderNewInstance.decodeRegion(rect, options), options.inSampleSize);
                            c(inputStreamOpenInputStream);
                            bitmapRegionDecoderNewInstance.recycle();
                            return aVar;
                        } catch (OutOfMemoryError unused) {
                            i4 = options.inSampleSize * 2;
                            options.inSampleSize = i4;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        inputStream = inputStreamOpenInputStream;
                        try {
                            throw new RuntimeException("Failed to load sampled bitmap: " + uri + HttpClient.NEWLINE + e.getMessage(), e);
                        } catch (Throwable th) {
                            th = th;
                            c(inputStream);
                            if (bitmapRegionDecoderNewInstance != null) {
                                bitmapRegionDecoderNewInstance.recycle();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStreamOpenInputStream;
                        c(inputStream);
                        if (bitmapRegionDecoderNewInstance != null) {
                        }
                        throw th;
                    }
                } while (i4 <= 512);
                c(inputStreamOpenInputStream);
                if (bitmapRegionDecoderNewInstance != null) {
                    bitmapRegionDecoderNewInstance.recycle();
                }
                return new a(null, 1);
            } catch (Exception e3) {
                e = e3;
                bitmapRegionDecoderNewInstance = null;
            } catch (Throwable th3) {
                th = th3;
                bitmapRegionDecoderNewInstance = null;
            }
        } catch (Exception e4) {
            e = e4;
            bitmapRegionDecoderNewInstance = null;
        } catch (Throwable th4) {
            th = th4;
            bitmapRegionDecoderNewInstance = null;
        }
    }

    public static void n(Rect rect, int i, int i2) {
        if (i != i2 || rect.width() == rect.height()) {
            return;
        }
        if (rect.height() > rect.width()) {
            rect.bottom -= rect.height() - rect.width();
        } else {
            rect.right -= rect.width() - rect.height();
        }
    }

    public static int o() {
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eGLDisplayEglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            egl10.eglGetConfigs(eGLDisplayEglGetDisplay, null, 0, iArr);
            int i = iArr[0];
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            egl10.eglGetConfigs(eGLDisplayEglGetDisplay, eGLConfigArr, i, iArr);
            int[] iArr2 = new int[1];
            int i2 = 0;
            for (int i3 = 0; i3 < iArr[0]; i3++) {
                egl10.eglGetConfigAttrib(eGLDisplayEglGetDisplay, eGLConfigArr[i3], 12332, iArr2);
                int i4 = iArr2[0];
                if (i2 < i4) {
                    i2 = i4;
                }
            }
            egl10.eglTerminate(eGLDisplayEglGetDisplay);
            return Math.max(i2, 2048);
        } catch (Exception unused) {
            return 2048;
        }
    }

    public static float p(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    public static float q(float[] fArr) {
        return (v(fArr) + u(fArr)) / 2.0f;
    }

    public static float r(float[] fArr) {
        return (p(fArr) + w(fArr)) / 2.0f;
    }

    public static Rect s(float[] fArr, int i, int i2, boolean z, int i3, int i4) {
        Rect rect = new Rect(Math.round(Math.max(0.0f, u(fArr))), Math.round(Math.max(0.0f, w(fArr))), Math.round(Math.min(i, v(fArr))), Math.round(Math.min(i2, p(fArr))));
        if (z) {
            n(rect, i3, i4);
        }
        return rect;
    }

    public static float t(float[] fArr) {
        return p(fArr) - w(fArr);
    }

    public static float u(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    public static float v(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    public static float w(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    public static float x(float[] fArr) {
        return v(fArr) - u(fArr);
    }

    public static Bitmap y(Bitmap bitmap, int i, int i2, CropImageView.RequestSizeOptions requestSizeOptions) {
        Bitmap bitmapCreateScaledBitmap;
        if (i > 0 && i2 > 0) {
            try {
                CropImageView.RequestSizeOptions requestSizeOptions2 = CropImageView.RequestSizeOptions.RESIZE_FIT;
                if (requestSizeOptions == requestSizeOptions2 || requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_INSIDE || requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_EXACT) {
                    if (requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_EXACT) {
                        bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
                    } else {
                        float width = bitmap.getWidth();
                        float height = bitmap.getHeight();
                        float fMax = Math.max(width / i, height / i2);
                        bitmapCreateScaledBitmap = (fMax > 1.0f || requestSizeOptions == requestSizeOptions2) ? Bitmap.createScaledBitmap(bitmap, (int) (width / fMax), (int) (height / fMax), false) : null;
                    }
                    if (bitmapCreateScaledBitmap != null) {
                        if (bitmapCreateScaledBitmap != bitmap) {
                            bitmap.recycle();
                        }
                        return bitmapCreateScaledBitmap;
                    }
                }
            } catch (Exception e2) {
                Log.w("AIC", "Failed to resize cropped image, return bitmap before resize", e2);
            }
        }
        return bitmap;
    }

    public static Bitmap z(Bitmap bitmap, int i, boolean z, boolean z2) {
        if (i <= 0 && !z && !z2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i);
        matrix.postScale(z ? -1.0f : 1.0f, z2 ? -1.0f : 1.0f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        if (bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }
}
