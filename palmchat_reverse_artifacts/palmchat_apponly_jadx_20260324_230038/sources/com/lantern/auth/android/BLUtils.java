package com.lantern.auth.android;

import android.R;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;
import com.igexin.push.core.b;
import com.lantern.auth.core.BLCallback;
import com.lantern.auth.core.BLFile;
import com.lantern.auth.core.BLLog;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.cordova.jssdk.RedPacketPullNewPlugin;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class BLUtils {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        char[] cArr = new char[2];
        for (int i = 0; i < bArr.length; i++) {
            cArr[0] = Character.forDigit((bArr[i] >>> 4) & 15, 16);
            cArr[1] = Character.forDigit(bArr[i] & 15, 16);
            sb.append(cArr);
        }
        return sb.toString();
    }

    public static void closeSilently(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Throwable unused) {
        }
    }

    public static Bitmap convertViewToBitmap(View view, int i, int i2) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        invokeBooleanMethod(bitmapCreateBitmap, "setHasAlpha", false);
        view.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public static View create(Context context, int i) {
        return LayoutInflater.from(context).inflate(i, (ViewGroup) null);
    }

    public static Drawable createActivityIcon(Context context, String str, int i) {
        Context contextCreatePackageContext;
        if (str != null && i != 0) {
            try {
                contextCreatePackageContext = context.createPackageContext(str, 2);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                contextCreatePackageContext = null;
            }
            if (contextCreatePackageContext != null) {
                return contextCreatePackageContext.getResources().getDrawable(i);
            }
        }
        return null;
    }

    public static Bitmap createBitmapFromAsset(Context context, String str) {
        if (str != null && str.length() != 0) {
            try {
                return BitmapFactory.decodeStream(context.getAssets().open(str));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Bitmap createBitmapFromPath(Context context, String str) {
        if (context == null || str == null) {
            return null;
        }
        if (str.startsWith("file://")) {
            str = str.substring(7);
        }
        return str.startsWith("/android_asset/") ? createBitmapFromAsset(context, str.substring(15)) : BitmapFactory.decodeFile(str);
    }

    public static Drawable createDrawableFromAsset(Context context, String str) {
        if (str != null && str.length() != 0) {
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(str));
                if (bitmapDecodeStream != null) {
                    return new BitmapDrawable(context.getResources(), bitmapDecodeStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static Drawable createDrawableFromPath(Context context, String str) {
        Bitmap bitmapCreateBitmapFromPath = createBitmapFromPath(context, str);
        if (bitmapCreateBitmapFromPath != null) {
            return new BitmapDrawable(context.getResources(), bitmapCreateBitmapFromPath);
        }
        return null;
    }

    public static Context createPackageContext(Context context, String str) {
        try {
            return context.createPackageContext(str, 2);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap createScreenshot(Context context) {
        int height;
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Matrix matrix = new Matrix();
        defaultDisplay.getMetrics(displayMetrics);
        float[] fArr = {displayMetrics.widthPixels, displayMetrics.heightPixels};
        float degreesForRotation = getDegreesForRotation(defaultDisplay.getRotation());
        int iDip2px = dip2px(context, 25.0f);
        boolean z = degreesForRotation > 0.0f;
        if (z) {
            matrix.reset();
            matrix.preRotate(-degreesForRotation);
            matrix.mapPoints(fArr);
            fArr[0] = Math.abs(fArr[0]);
            fArr[1] = Math.abs(fArr[1]);
        }
        Bitmap bitmap = (Bitmap) invokeStaticMethod("android.view.Surface", RedPacketPullNewPlugin.ACTION_SCREENSHOT, Integer.valueOf((int) fArr[0]), Integer.valueOf((int) fArr[1]));
        if (bitmap == null) {
            return null;
        }
        if (z) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(displayMetrics.widthPixels, displayMetrics.heightPixels, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            canvas.translate(bitmapCreateBitmap.getWidth() / 2, bitmapCreateBitmap.getHeight() / 2);
            canvas.rotate(360.0f - degreesForRotation);
            canvas.translate((-fArr[0]) / 2.0f, (-fArr[1]) / 2.0f);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            bitmap = bitmapCreateBitmap;
        }
        int width = bitmap.getWidth();
        bitmap.getHeight();
        if (bitmap.getWidth() < bitmap.getHeight()) {
            height = (bitmap.getHeight() - iDip2px) - 0;
        } else {
            height = bitmap.getHeight() - iDip2px;
            width = bitmap.getWidth() - 0;
        }
        return Bitmap.createBitmap(bitmap, 0, iDip2px, width, height);
    }

    public static StateListDrawable createStateDrawable(Context context, int i, int i2, int i3) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable drawable = i == -1 ? null : context.getResources().getDrawable(i);
        Drawable drawable2 = i2 == -1 ? null : context.getResources().getDrawable(i2);
        Drawable drawable3 = i3 != -1 ? context.getResources().getDrawable(i3) : null;
        stateListDrawable.addState(new int[]{R.attr.state_enabled, R.attr.state_focused}, drawable3);
        stateListDrawable.addState(new int[]{R.attr.state_pressed, R.attr.state_enabled}, drawable2);
        stateListDrawable.addState(new int[]{R.attr.state_focused}, drawable3);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, drawable2);
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, drawable);
        stateListDrawable.addState(new int[0], drawable);
        return stateListDrawable;
    }

    public static String createStringFromAsset(Context context, String str) {
        try {
            return inputStream2String(context.getAssets().open(str));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int dip2px(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        BLLog.d("scale = " + f2, new Object[0]);
        return (int) ((f * f2) + 0.5f);
    }

    public static KeyguardManager.KeyguardLock disableKeyguard(Context context) {
        KeyguardManager.KeyguardLock keyguardLockNewKeyguardLock = ((KeyguardManager) context.getSystemService("keyguard")).newKeyguardLock("");
        keyguardLockNewKeyguardLock.disableKeyguard();
        return keyguardLockNewKeyguardLock;
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        return drawableToBitmap(drawable, false);
    }

    public static String getAppNameByPID(Context context, int i) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    public static boolean getBooleanValue(Context context, String str, boolean z) {
        return context.getSharedPreferences(b.Y, 0).getBoolean(str, z);
    }

    public static float getDegreesForRotation(int i) {
        if (i == 1) {
            return 90.0f;
        }
        if (i != 2) {
            return i != 3 ? 0.0f : 270.0f;
        }
        return 180.0f;
    }

    public static int getIntValue(Context context, String str, int i) {
        return context.getSharedPreferences(b.Y, 0).getInt(str, i);
    }

    public static long getLongValue(Context context, String str, long j) {
        return context.getSharedPreferences(b.Y, 0).getLong(str, j);
    }

    public static String getMD5Str(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
            return toHexString(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static Bundle getMetaData(Context context) {
        return getMetaData(context, context.getPackageName());
    }

    public static Drawable getPackageReource(Context context, String str, String str2) {
        try {
            Context contextCreatePackageContext = context.createPackageContext(str2, 2);
            return contextCreatePackageContext.getResources().getDrawable(contextCreatePackageContext.getResources().getIdentifier(str2 + ":drawable/" + str, null, null));
        } catch (Exception unused) {
            return null;
        }
    }

    public static int getScreenDensityDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    public static int getScreenHeightPixels(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidthPixels(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static String getStringValue(Context context, String str, String str2) {
        return context.getSharedPreferences(b.Y, 0).getString(str, str2);
    }

    public static String getSystemProperties(String str, String str2) {
        Object objInvokeStaticMethod = invokeStaticMethod("android.os.SystemProperties", "get", str, str2);
        return objInvokeStaticMethod instanceof String ? (String) objInvokeStaticMethod : str2;
    }

    public static boolean hasKeyValue(Context context, String str) {
        return context.getSharedPreferences(b.Y, 0).contains(str);
    }

    public static String inputStream2String(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read();
            if (i == -1) {
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(i);
        }
    }

    public static Object invokeBooleanMethod(Object obj, String str, boolean z) {
        try {
            return obj.getClass().getMethod(str, Boolean.TYPE).invoke(obj, Boolean.valueOf(z));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            return null;
        } catch (SecurityException e4) {
            e4.printStackTrace();
            return null;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static Field invokeField(Class<?> cls, String str) throws NoSuchFieldException {
        if (str != null) {
            return cls.getDeclaredField(str);
        }
        throw new NoSuchFieldException("Error field !");
    }

    public static Object invokeFieldValue(Object obj, Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static Object invokeMethod(Object obj, String str, Object... objArr) {
        Class<?> cls = obj.getClass();
        if (objArr.length == 0) {
            try {
                return cls.getMethod(str, new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
                return null;
            } catch (SecurityException e4) {
                e4.printStackTrace();
                return null;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                return null;
            }
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj2 = objArr[i];
            if (obj2 instanceof Boolean) {
                clsArr[i] = Boolean.TYPE;
            } else if (obj2 instanceof Integer) {
                clsArr[i] = Integer.TYPE;
            } else if (obj2 instanceof Long) {
                clsArr[i] = Long.TYPE;
            } else if (obj2 instanceof Context) {
                clsArr[i] = Context.class;
            } else {
                clsArr[i] = obj2.getClass();
            }
        }
        try {
            return cls.getMethod(str, clsArr).invoke(obj, objArr);
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
            return null;
        } catch (IllegalArgumentException e7) {
            e7.printStackTrace();
            return null;
        } catch (NoSuchMethodException e8) {
            e8.printStackTrace();
            return null;
        } catch (SecurityException e9) {
            e9.printStackTrace();
            return null;
        } catch (InvocationTargetException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static Object invokeMethodWithNullArgs(Object obj, String str, String str2, Object obj2) {
        Class<?> cls = obj.getClass();
        Class<?>[] clsArr = new Class[2];
        try {
            clsArr[0] = Class.forName(str2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (obj2 instanceof Boolean) {
            clsArr[1] = Boolean.TYPE;
        } else if (obj2 instanceof Integer) {
            clsArr[1] = Integer.TYPE;
        } else if (obj2 instanceof Long) {
            clsArr[1] = Long.TYPE;
        } else {
            clsArr[1] = obj2.getClass();
        }
        try {
            return cls.getMethod(str, clsArr).invoke(obj, null, obj2);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return null;
        } catch (SecurityException e5) {
            e5.printStackTrace();
            return null;
        } catch (InvocationTargetException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    public static Object invokePrivateMethod(Object obj, Class<?> cls, String str, Object... objArr) {
        if (objArr.length == 0) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, new Class[0]);
                declaredMethod.setAccessible(true);
                return declaredMethod.invoke(obj, new Object[0]);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return null;
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
                return null;
            } catch (SecurityException e4) {
                e4.printStackTrace();
                return null;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                return null;
            }
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            Object obj2 = objArr[i];
            if (obj2 instanceof Boolean) {
                clsArr[i] = Boolean.TYPE;
            } else if (obj2 instanceof Integer) {
                clsArr[i] = Integer.TYPE;
            } else if (obj2 instanceof Long) {
                clsArr[i] = Long.TYPE;
            } else if (obj2 instanceof Context) {
                clsArr[i] = Context.class;
            } else {
                clsArr[i] = obj2.getClass();
            }
        }
        try {
            Method declaredMethod2 = cls.getDeclaredMethod(str, clsArr);
            declaredMethod2.setAccessible(true);
            return declaredMethod2.invoke(obj, objArr);
        } catch (IllegalAccessException e6) {
            e6.printStackTrace();
            return null;
        } catch (IllegalArgumentException e7) {
            e7.printStackTrace();
            return null;
        } catch (NoSuchMethodException e8) {
            e8.printStackTrace();
            return null;
        } catch (SecurityException e9) {
            e9.printStackTrace();
            return null;
        } catch (InvocationTargetException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static Object invokePrivateStaticValue(Class<?> cls, String str) {
        try {
            Field fieldInvokeField = invokeField(cls, str);
            fieldInvokeField.setAccessible(true);
            return fieldInvokeField.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Object invokePrivateValue(Object obj, String str) {
        try {
            Field fieldInvokeField = invokeField(obj.getClass(), str);
            fieldInvokeField.setAccessible(true);
            return fieldInvokeField.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static Object invokePublicValue(Object obj, String str) {
        try {
            Field fieldInvokeField = invokeField(obj.getClass(), str);
            fieldInvokeField.setAccessible(true);
            return fieldInvokeField.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Object... objArr) {
        Class<?> cls;
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        if (objArr.length == 0) {
            try {
                return cls.getMethod(str2, new Class[0]).invoke(null, new Object[0]);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (SecurityException e5) {
                e5.printStackTrace();
            } catch (InvocationTargetException e6) {
                e6.printStackTrace();
            }
        } else {
            Class<?>[] clsArr = new Class[objArr.length];
            for (int i = 0; i < objArr.length; i++) {
                Object obj = objArr[i];
                if (obj instanceof Boolean) {
                    clsArr[i] = Boolean.TYPE;
                } else if (obj instanceof Integer) {
                    clsArr[i] = Integer.TYPE;
                } else if (obj instanceof Long) {
                    clsArr[i] = Long.TYPE;
                } else if (obj instanceof Context) {
                    clsArr[i] = Context.class;
                } else {
                    clsArr[i] = obj.getClass();
                }
            }
            try {
                return cls.getMethod(str2, clsArr).invoke(null, objArr);
            } catch (IllegalAccessException e7) {
                e7.printStackTrace();
            } catch (IllegalArgumentException e8) {
                e8.printStackTrace();
            } catch (NoSuchMethodException e9) {
                e9.printStackTrace();
            } catch (SecurityException e10) {
                e10.printStackTrace();
            } catch (InvocationTargetException e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }

    public static Object invokeStaticPublicValue(String str, String str2) {
        try {
            return Class.forName(str).getField(str2).get(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return null;
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static boolean isMobileNetwork(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
    }

    public static boolean isMonkeyRunning() {
        return ActivityManager.isUserAMonkey();
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static void launcherBrowser(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        if (str != null) {
            intent.setData(Uri.parse(str));
        }
        intent.setClassName(BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO, "com.android.browser.BrowserActivity");
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            show(context, e.getMessage());
        }
    }

    public static String[] listAsset(Context context, String str, String str2) {
        try {
            return createPackageContext(context, str).getAssets().list(str2);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int px2dip(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        BLLog.d("scale = " + f2, new Object[0]);
        return (int) ((f / f2) + 0.5f);
    }

    public static byte[] readZipData(String str, String str2) {
        try {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                if (!zipEntryNextElement.isDirectory() && zipEntryNextElement.getName().equals(str2)) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    BLFile.copy(zipFile.getInputStream(zipEntryNextElement), byteArrayOutputStream);
                    return byteArrayOutputStream.toByteArray();
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static InputStream readZipStream(String str, String str2) {
        try {
            ZipFile zipFile = new ZipFile(str);
            Enumeration<? extends ZipEntry> enumerationEntries = zipFile.entries();
            while (enumerationEntries.hasMoreElements()) {
                ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                if (!zipEntryNextElement.isDirectory() && zipEntryNextElement.getName().equals(str2)) {
                    return zipFile.getInputStream(zipEntryNextElement);
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void reenableKeyguard(Context context, KeyguardManager.KeyguardLock keyguardLock) {
        keyguardLock.reenableKeyguard();
    }

    public static boolean removeKeyValue(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(b.Y, 0).edit();
        editorEdit.remove(str);
        return editorEdit.commit();
    }

    public static void safeStartActivity(Context context, Intent intent) {
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            BLLog.e(e.getMessage());
        } catch (SecurityException e2) {
            BLLog.e(e2.getMessage());
        }
    }

    public static boolean saveBitmapToFile(Bitmap bitmap, String str) {
        if (bitmap == null || str == null) {
            return false;
        }
        Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
        if (str.endsWith(".png")) {
            compressFormat = Bitmap.CompressFormat.PNG;
        }
        if (str.startsWith("file://")) {
            str = str.substring(7);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            bitmap.compress(compressFormat, 100, fileOutputStream);
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static Bitmap scale(Bitmap bitmap, float f, float f2) {
        if (bitmap == null) {
            return null;
        }
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        if (((int) f) / width == 1.0f && ((int) f2) / height == 1.0f) {
            return bitmap;
        }
        float f3 = f / width;
        float f4 = f2 / height;
        if (f3 == 0.0f) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f3, f4);
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            if (bitmap == bitmapCreateBitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return bitmapCreateBitmap;
        } catch (OutOfMemoryError unused) {
            return bitmap;
        }
    }

    public static Bitmap scaleBitmap(Context context, String str, int i, int i2) {
        boolean z;
        if (str.startsWith("file://")) {
            str = str.substring(7);
        }
        if (str.startsWith("/android_asset/")) {
            str = str.substring(15);
            z = true;
        } else {
            z = false;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        if (z) {
            try {
                InputStream inputStreamOpen = context.getAssets().open(str);
                BitmapFactory.decodeStream(inputStreamOpen, null, options);
                inputStreamOpen.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            BitmapFactory.decodeFile(str, options);
        }
        int i3 = options.outWidth / i;
        options.inSampleSize = i3 > 0 ? i3 : 1;
        options.inJustDecodeBounds = false;
        if (!z) {
            return BitmapFactory.decodeFile(str, options);
        }
        try {
            return BitmapFactory.decodeStream(context.getAssets().open(str), null, options);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean setBooleanValue(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(b.Y, 0).edit();
        editorEdit.putBoolean(str, z);
        return editorEdit.commit();
    }

    public static boolean setIntValue(Context context, String str, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(b.Y, 0).edit();
        editorEdit.putInt(str, i);
        return editorEdit.commit();
    }

    public static boolean setLongValue(Context context, String str, long j) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(b.Y, 0).edit();
        editorEdit.putLong(str, j);
        return editorEdit.commit();
    }

    public static boolean setStringValue(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(b.Y, 0).edit();
        editorEdit.putString(str, str2);
        return editorEdit.commit();
    }

    public static void setSystemProperty(String str, String str2) {
        invokeStaticMethod("android.os.SystemProperties", "set", str, str2);
        BLLog.d("invokeMethod set OK", new Object[0]);
    }

    public static void show(Context context, String str) {
        Toast.makeText(context, str, 0).show();
    }

    public static String toHexString(byte[] bArr) {
        return bArr == null ? "" : toHexString(bArr, 0, bArr.length);
    }

    public static Drawable zoomDrawable(Context context, Drawable drawable, int i, int i2) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap bitmapDrawableToBitmap = drawableToBitmap(drawable);
        Matrix matrix = new Matrix();
        matrix.postScale(i / intrinsicWidth, i2 / intrinsicHeight);
        return new BitmapDrawable(context.getResources(), Bitmap.createBitmap(bitmapDrawableToBitmap, 0, 0, intrinsicWidth, intrinsicHeight, matrix, true));
    }

    public static void closeSilently(ParcelFileDescriptor parcelFileDescriptor) {
        if (parcelFileDescriptor == null) {
            return;
        }
        try {
            parcelFileDescriptor.close();
        } catch (Throwable unused) {
        }
    }

    public static View create(Context context, int i, ViewGroup viewGroup, boolean z) {
        return LayoutInflater.from(context).inflate(i, viewGroup, z);
    }

    public static Bitmap drawableToBitmap(Drawable drawable, boolean z) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap.Config config = drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        if (z) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static Bundle getMetaData(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            BLLog.e(e);
            return null;
        }
    }

    public static void show(Context context, int i) {
        Toast.makeText(context, i, 0).show();
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        char[] cArr = new char[i2 * 2];
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            byte b = bArr[i4];
            int i5 = i3 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i3] = cArr2[(b >>> 4) & 15];
            i3 = i5 + 1;
            cArr[i5] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static void safeStartActivity(Context context, Intent intent, BLCallback bLCallback) {
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            BLLog.e(e.getMessage());
            if (bLCallback != null) {
                bLCallback.run(1000, null, null);
            }
        } catch (SecurityException e2) {
            BLLog.e(e2.getMessage());
            if (bLCallback != null) {
                bLCallback.run(1001, null, null);
            }
        }
    }
}
