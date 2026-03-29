package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.opengl.GLES10;
import android.text.TextUtils;
import android.util.Log;
import com.igexin.push.f.b.d;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class xt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f22044a = 0;
    public static int b = -1;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends HashMap<String, Object> {
        public a() {
            put("action", "BitmapUtil_decode");
            put("status", "OutOfMemoryError");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("action", "BitmapUtil_decode");
            put("status", "OutOfMemoryError");
        }
    }

    public static String a(Context context, long j) {
        float f = j / 1024;
        float f2 = f / 1024.0f;
        return (f2 >= 1.0f ? String.format("%10.2fMB", Float.valueOf(f2)) : String.format("%10.0fKB", Float.valueOf(f))).replace(" ", "");
    }

    public static Bitmap b(Bitmap bitmap, int i, int i2) {
        return l(bitmap, i, i2, 0.5f, 0.5f);
    }

    public static synchronized File c(String str, boolean z) {
        File file;
        if (TextUtils.isEmpty(str)) {
            file = null;
        } else {
            try {
                file = z ? new File(str) : e(str);
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.e("BitmapUtil", "fileName=" + str + "compressBitmapFailed=" + e, 2);
                file = null;
                return file;
            }
        }
        return file;
    }

    public static synchronized File d(String str, int i) {
        File file;
        Bitmap bitmapDecodeFile;
        File file2 = new File(str);
        StringBuilder sb = new StringBuilder();
        sb.append("Before path:");
        sb.append(str);
        sb.append(" size:");
        long length = file2.length();
        file = null;
        sb.append(a(null, length));
        LogUtil.i("BitmapUtil", sb.toString());
        u();
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(str, new BitmapFactory.Options());
        } catch (OutOfMemoryError e) {
            LogUtil.i("BitmapUtil", 3, new a(), e);
            bitmapDecodeFile = null;
        }
        if (bitmapDecodeFile != null) {
            Log.i("BitmapUtil", "bitmap size = " + bitmapDecodeFile.getWidth() + "  " + bitmapDecodeFile.getHeight());
            try {
                try {
                    pu1.s();
                    String absolutePath = pu1.f + File.separator + ir5.b() + ".temp";
                    File file3 = new File(absolutePath);
                    if (!file3.canWrite()) {
                        File fileL = pu1.l(c.b());
                        if (!fileL.exists()) {
                            fileL.mkdirs();
                        }
                        file3 = new File(fileL, ir5.b() + ".temp");
                        absolutePath = file3.getAbsolutePath();
                    }
                    if (file3.exists()) {
                        file3.delete();
                    }
                    file3.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file3);
                    bitmapDecodeFile.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
                    fileOutputStream.close();
                    k(str, absolutePath);
                    File file4 = new File(absolutePath);
                    try {
                        LogUtil.i("BitmapUtil", "After path:" + absolutePath + " size:" + a(null, file4.length()));
                        try {
                            if (!bitmapDecodeFile.isRecycled()) {
                                bitmapDecodeFile.recycle();
                            }
                        } catch (Exception unused) {
                        }
                        file = file4;
                    } catch (Exception e2) {
                        file = file4;
                        e = e2;
                        e.printStackTrace();
                    }
                } finally {
                    try {
                        if (!bitmapDecodeFile.isRecycled()) {
                            bitmapDecodeFile.recycle();
                        }
                    } catch (Exception unused2) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        return file;
    }

    public static File e(String str) {
        return f(str, 1280, 60);
    }

    public static synchronized File f(String str, int i, int i2) {
        File file;
        Bitmap bitmapDecodeFile;
        File file2;
        u();
        or2 or2VarM = m(str);
        file = null;
        file = null;
        bitmap = null;
        Bitmap bitmap = null;
        file = null;
        file = null;
        file = null;
        if (or2VarM != null && or2VarM.b() > 0 && or2VarM.a() > 0) {
            int iJ = j(or2VarM, i);
            if (or2VarM.b() > i || or2VarM.a() > i) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                options.inSampleSize = iJ;
                try {
                    bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
                } catch (OutOfMemoryError e) {
                    LogUtil.i("BitmapUtil", 3, new b(), e);
                    bitmapDecodeFile = null;
                }
                if (bitmapDecodeFile != null) {
                    Log.i("BitmapUtil", "simple size = " + iJ + "src size = " + or2VarM.b() + " " + or2VarM.a() + "bitmap size = " + bitmapDecodeFile.getWidth() + "  " + bitmapDecodeFile.getHeight());
                    try {
                        try {
                            Bitmap bitmapY = y(bitmapDecodeFile, i);
                            if (bitmapY != null) {
                                try {
                                    try {
                                        pu1.s();
                                        String absolutePath = pu1.f + File.separator + ir5.b() + ".temp";
                                        File file3 = new File(absolutePath);
                                        if (!file3.canWrite()) {
                                            File fileL = pu1.l(c.b());
                                            if (!fileL.exists()) {
                                                fileL.mkdirs();
                                            }
                                            file3 = new File(fileL, ir5.b() + ".temp");
                                            absolutePath = file3.getAbsolutePath();
                                        }
                                        if (file3.exists()) {
                                            file3.delete();
                                        }
                                        file3.createNewFile();
                                        FileOutputStream fileOutputStream = new FileOutputStream(file3);
                                        bitmapY.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
                                        fileOutputStream.close();
                                        try {
                                            k(str, absolutePath);
                                        } catch (IOException unused) {
                                        }
                                        File file4 = new File(absolutePath);
                                        try {
                                            LogUtil.i("BitmapUtil", "compressBitmap2FileWithSize newPath=" + absolutePath + "   size=" + a(null, file4.length()));
                                            file = file4;
                                        } catch (Exception e2) {
                                            bitmap = bitmapY;
                                            file2 = file4;
                                            e = e2;
                                            e.printStackTrace();
                                            if (bitmap != null) {
                                                try {
                                                    if (!bitmap.isRecycled()) {
                                                        bitmap.recycle();
                                                    }
                                                } catch (Exception unused2) {
                                                    file = file2;
                                                    return file;
                                                }
                                            }
                                            if (!bitmapDecodeFile.isRecycled()) {
                                                bitmapDecodeFile.recycle();
                                            }
                                            file = file2;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        bitmap = bitmapY;
                                        if (bitmap != null) {
                                            try {
                                                if (!bitmap.isRecycled()) {
                                                    bitmap.recycle();
                                                }
                                            } catch (Exception unused3) {
                                                throw th;
                                            }
                                        }
                                        if (!bitmapDecodeFile.isRecycled()) {
                                            bitmapDecodeFile.recycle();
                                        }
                                        throw th;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    bitmap = bitmapY;
                                    file2 = null;
                                }
                            }
                            if (bitmapY != null) {
                                try {
                                    if (!bitmapY.isRecycled()) {
                                        bitmapY.recycle();
                                    }
                                } catch (Exception unused4) {
                                }
                            }
                            if (!bitmapDecodeFile.isRecycled()) {
                                bitmapDecodeFile.recycle();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        file2 = null;
                    }
                }
            } else {
                file = new File(str);
            }
        }
        return file;
    }

    public static boolean g(Bitmap bitmap, OutputStream outputStream) {
        return bitmap.compress(Bitmap.CompressFormat.JPEG, 80, outputStream);
    }

    public static boolean h(Bitmap bitmap, OutputStream outputStream, int i) {
        return (bitmap.getWidth() > i || bitmap.getHeight() > i) ? y(bitmap, i).compress(Bitmap.CompressFormat.JPEG, 80, outputStream) : bitmap.compress(Bitmap.CompressFormat.JPEG, 80, outputStream);
    }

    public static boolean i(Bitmap bitmap, OutputStream outputStream) {
        return (bitmap.getWidth() > 959 || bitmap.getHeight() > 959) ? y(bitmap, 959).compress(Bitmap.CompressFormat.JPEG, 80, outputStream) : bitmap.compress(Bitmap.CompressFormat.JPEG, 80, outputStream);
    }

    public static int j(or2 or2Var, int i) {
        int i2;
        if (or2Var != null && or2Var.a() > 0 && or2Var.b() > 0) {
            int iB = or2Var.b() / 2;
            int iA = or2Var.a() / 2;
            i2 = 1;
            while (true) {
                if (iB / i2 <= i && iA / i2 <= i) {
                    break;
                }
                i2 *= 2;
            }
        } else {
            i2 = 1;
        }
        return Math.max(i2, 1);
    }

    public static void k(String str, String str2) throws IOException {
        ExifInterface exifInterface = new ExifInterface(str);
        int attributeInt = exifInterface.getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        String attribute = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_DATETIME);
        String attribute2 = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_MODEL);
        String attribute3 = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ISO_SPEED_RATINGS);
        String attribute4 = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE);
        String attribute5 = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE);
        String attribute6 = exifInterface.getAttribute(androidx.exifinterface.media.ExifInterface.TAG_MAKE);
        ExifInterface exifInterface2 = new ExifInterface(str2);
        exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, String.valueOf(attributeInt));
        if (TextUtils.isEmpty(attribute)) {
            exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_DATETIME, "2015:01:01 00:00:00");
        } else {
            exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_DATETIME, attribute);
        }
        if (!TextUtils.isEmpty(attribute2)) {
            exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_MODEL, attribute2);
        }
        if (!TextUtils.isEmpty(attribute3)) {
            exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ISO_SPEED_RATINGS, attribute3);
        }
        if (!TextUtils.isEmpty(attribute4)) {
            exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_ALTITUDE, attribute4);
        }
        if (!TextUtils.isEmpty(attribute5)) {
            exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE, attribute5);
        }
        if (!TextUtils.isEmpty(attribute6)) {
            exifInterface2.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_MAKE, attribute6);
        }
        exifInterface2.saveAttributes();
    }

    public static Bitmap l(Bitmap bitmap, int i, int i2, float f, float f2) {
        if (f < 0.0f || f > 1.0f || f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("horizontalCenterPercent and verticalCenterPercent must be between 0.0f and 1.0f, inclusive.");
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i == width && i2 == height) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f3 = i;
        float f4 = width;
        float f5 = i2;
        float f6 = height;
        float fMax = Math.max(f3 / f4, f5 / f6);
        matrix.setScale(fMax, fMax);
        int iRound = Math.round(f3 / fMax);
        int iRound2 = Math.round(f5 / fMax);
        return Bitmap.createBitmap(bitmap, Math.max(Math.min((int) ((f4 * f) - (iRound / 2)), width - iRound), 0), Math.max(Math.min((int) ((f6 * f2) - (iRound2 / 2)), height - iRound2), 0), iRound, iRound2, matrix, true);
    }

    public static or2 m(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (Exception e) {
            LogUtil.e("BitmapUtil", e);
        }
        or2 or2Var = new or2(options.outWidth, options.outHeight);
        LogUtil.i("BitmapUtil", "getBitmapSize =" + or2Var);
        return or2Var;
    }

    public static or2 n(int i, int i2) {
        or2 or2Var = new or2(i, i2);
        if (i <= 0 || i2 <= 0) {
            return or2Var;
        }
        float f = i / i2;
        return f >= 2.0f ? new or2(100, 50) : f <= 0.5f ? new or2(50, 100) : or2Var;
    }

    public static final String o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.replace(".temp", ".jpg");
    }

    public static int p() {
        if (b < 0) {
            int[] iArr = new int[1];
            GLES10.glGetIntegerv(3379, iArr, 0);
            b = Math.max(iArr[0], 2048);
        }
        return b;
    }

    public static boolean q(String str) {
        int attributeInt;
        try {
            attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        } catch (IOException e) {
            e.printStackTrace();
            attributeInt = 0;
        }
        return attributeInt == 6 || attributeInt == 8 || attributeInt == 3;
    }

    public static boolean r(String str) {
        int attributeInt;
        if (str == null) {
            return false;
        }
        try {
            attributeInt = new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        } catch (IOException e) {
            e.printStackTrace();
            attributeInt = 0;
        }
        return attributeInt == 6 || attributeInt == 8;
    }

    public static boolean s(Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            InputStream inputStreamOpenInputStream = c.b().getContentResolver().openInputStream(uri);
            BitmapFactory.decodeStream(inputStreamOpenInputStream, new Rect(), options);
            inputStreamOpenInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return options.outWidth > 0;
    }

    public static boolean t(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        return options.outWidth > 0;
    }

    public static void u() {
        File[] fileArrListFiles;
        if (ir5.b() - f22044a > d.b) {
            try {
                f22044a = ir5.b();
                File file = new File(pu1.f);
                if (!file.exists() || (fileArrListFiles = file.listFiles()) == null) {
                    return;
                }
                for (File file2 : fileArrListFiles) {
                    String name = file2.getName();
                    if (name.endsWith(".temp")) {
                        if (f22044a - Long.valueOf(name.substring(0, name.indexOf("."))).longValue() > d.b) {
                            file2.delete();
                        }
                    }
                }
            } catch (Exception e) {
                LogUtil.e("BitmapUtil", e);
            }
        }
    }

    public static String v(Bitmap bitmap, int i, String str, String str2) {
        String str3 = str + File.separator;
        String str4 = str3 + str2 + ".jpg";
        try {
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str4);
            if (file2.exists()) {
                file2.delete();
            }
            file2.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, fileOutputStream);
            fileOutputStream.close();
            return str4;
        } catch (Exception e) {
            e.printStackTrace();
            return str3;
        }
    }

    public static String w(Bitmap bitmap, String str) {
        return v(bitmap, 80, pu1.e, str);
    }

    public static String x(Bitmap bitmap, String str) {
        return v(bitmap, 80, pu1.m(), str);
    }

    public static Bitmap y(Bitmap bitmap, int i) {
        int i2;
        Bitmap bitmapCreateScaledBitmap = null;
        if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return null;
        }
        float width = bitmap.getWidth() / bitmap.getHeight();
        if (width >= 1.0f) {
            i2 = (int) (i / width);
        } else {
            int i3 = (int) (i * width);
            i2 = i;
            i = i3;
        }
        try {
            bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true);
            LogUtil.i("BitmapUtil", "scaleBitmapToSize size=" + i + "*" + i2);
            return bitmapCreateScaledBitmap;
        } catch (OutOfMemoryError e) {
            LogUtil.e("BitmapUtil", e);
            return bitmapCreateScaledBitmap;
        }
    }
}
