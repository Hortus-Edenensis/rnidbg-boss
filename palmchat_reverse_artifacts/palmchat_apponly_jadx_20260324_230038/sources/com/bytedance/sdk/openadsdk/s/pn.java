package com.bytedance.sdk.openadsdk.s;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.kuaishou.weapon.p0.g;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f5433a = 4;
    protected static int b = 30;
    protected static int fx = 1;
    public static int iz = 0;
    public static int jk = 8;
    public static int l = 32;
    public static int n = 2;
    protected static String nr = null;
    protected static long pn = 15360;
    public static int t = 16;
    protected static String u = "images";
    public static int x = 1;

    public static Bitmap nr(String str) {
        byte[] bArrDecode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    public static boolean u(Context context, String str) {
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr.length > 0) {
                for (String str2 : strArr) {
                    if (str.equals(str2)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    @RequiresApi(api = 23)
    public static boolean nr(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }

    public static File u() {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + u);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "JPG_Playable_Photo.jpg");
            if (!file2.exists()) {
                file2.createNewFile();
            }
            nr = file2.getAbsolutePath();
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    public static File u(String str) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(), Environment.DIRECTORY_DCIM + File.separator + "Camera");
            if (!file.exists()) {
                file.mkdirs();
            }
            Calendar calendar = Calendar.getInstance();
            File file2 = new File(file, (calendar.get(12) + "_" + calendar.get(13) + "_" + calendar.get(14)) + "_" + str);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            return file2;
        } catch (IOException unused) {
            return null;
        }
    }

    public static File u(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            File fileU = u(str);
            if (fileU != null && fileU.exists()) {
                byte[] bArrDecode = Base64.decode(str2, 2);
                fileOutputStream = new FileOutputStream(fileU);
                try {
                    fileOutputStream.write(bArrDecode, 0, bArrDecode.length);
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                    return fileU;
                } catch (IOException unused2) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused4) {
                        }
                    }
                    throw th;
                }
            }
            return null;
        } catch (IOException unused5) {
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean u(Context context, int i) {
        boolean zU;
        boolean zU2;
        if (iz == 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                zU = u(context, "android.permission.READ_MEDIA_IMAGES");
                zU2 = true;
            } else {
                zU = u(context, g.i);
                zU2 = u(context, g.j);
            }
            boolean zU3 = u(context, "android.permission.CAMERA");
            boolean zU4 = u(context, "android.permission.RECORD_AUDIO");
            PackageManager packageManager = context.getPackageManager();
            if (zU && zU2) {
                iz |= x;
            }
            if (zU3 && packageManager.hasSystemFeature("android.hardware.camera")) {
                iz |= n;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
                iz |= f5433a;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                iz |= jk;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                iz |= t;
            }
            if (zU4 && packageManager.hasSystemFeature("android.hardware.microphone")) {
                iz |= l;
            }
        }
        return (iz & i) != 0;
    }

    @RequiresApi(api = 23)
    public static boolean u(Context context) {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT >= 33) {
            z = context.checkSelfPermission("android.permission.READ_MEDIA_IMAGES") == 0;
        } else {
            z = context.checkSelfPermission(g.i) == 0;
            if (context.checkSelfPermission(g.j) != 0) {
                z2 = false;
            }
            return !z2 && z;
        }
        z2 = true;
        if (z2) {
        }
    }
}
