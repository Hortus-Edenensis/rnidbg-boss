package com.amap.api.col.p0002sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.util.Log;
import com.amap.api.col.p0002sl.gd;
import com.amap.api.maps2d.MapsInitializer;
import com.amap.api.maps2d.model.BitmapDescriptorFactory;
import com.amap.api.maps2d.model.LatLng;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static double[] f2681a = {7453.642d, 3742.9905d, 1873.333d, 936.89026d, 468.472d, 234.239d, 117.12d, 58.56d, 29.28d, 14.64d, 7.32d, 3.66d, 1.829d, 0.915d, 0.4575d, 0.228d, 0.1144d};

    private static double a(double d, double d2, double d3, double d4, double d5, double d6) {
        return ((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2));
    }

    public static float b(float f) {
        int i = z.c;
        if (f <= i) {
            i = z.d;
            if (f >= i) {
                return f;
            }
        }
        return i;
    }

    public static float a(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 45.0f) {
            return 45.0f;
        }
        return f;
    }

    private static boolean a(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        double d8 = d3 - d;
        double d9 = d7 - d6;
        double d10 = d4 - d2;
        double d11 = 180.0d - d5;
        double d12 = (d8 * d9) - (d10 * d11);
        if (d12 != 0.0d) {
            double d13 = d2 - d6;
            double d14 = d - d5;
            double d15 = ((d11 * d13) - (d9 * d14)) / d12;
            double d16 = ((d13 * d8) - (d14 * d10)) / d12;
            if (d15 >= 0.0d && d15 <= 1.0d && d16 >= 0.0d && d16 <= 1.0d) {
                return true;
            }
        }
        return false;
    }

    private static boolean b(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.abs(a(d, d2, d3, d4, d5, d6)) < 1.0E-9d && (d - d3) * (d - d5) <= 0.0d && (d2 - d4) * (d2 - d6) <= 0.0d;
    }

    public static Bitmap a(String str) {
        try {
            if (ba.f2628a != null) {
                InputStream inputStreamOpen = ba.f2628a.getAssets().open(str);
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                inputStreamOpen.close();
                return bitmapDecodeStream;
            }
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/".concat(String.valueOf(str)));
            Bitmap bitmapDecodeStream2 = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return bitmapDecodeStream2;
        } catch (Throwable th) {
            a(th, "Util", "fromAsset");
            return null;
        }
    }

    public static String b(Context context) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return context.getFilesDir().getPath();
        }
        String str = MapsInitializer.sdcardDir;
        if (str != null && !str.equals("")) {
            File file = new File(MapsInitializer.sdcardDir);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "Amap");
            if (!file2.exists()) {
                file2.mkdir();
            }
            return file2.toString() + "/";
        }
        File file3 = new File(Environment.getExternalStorageDirectory(), "AMap");
        if (!file3.exists()) {
            file3.mkdir();
        }
        return file3.toString() + "/";
    }

    public static String a(String str, Object obj) {
        return str + ContainerUtils.KEY_VALUE_DELIMITER + String.valueOf(obj);
    }

    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : strArr) {
            sb.append(str);
            if (i != strArr.length - 1) {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    public static int a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * f), (int) (bitmap.getHeight() * f), true);
    }

    public static double a(LatLng latLng, LatLng latLng2) {
        double d = latLng.longitude;
        double d2 = d * 0.01745329251994329d;
        double d3 = latLng.latitude * 0.01745329251994329d;
        double d4 = latLng2.longitude * 0.01745329251994329d;
        double d5 = latLng2.latitude * 0.01745329251994329d;
        double dSin = Math.sin(d2);
        double dSin2 = Math.sin(d3);
        double dCos = Math.cos(d2);
        double dCos2 = Math.cos(d3);
        double dSin3 = Math.sin(d4);
        double dSin4 = Math.sin(d5);
        double dCos3 = Math.cos(d4);
        double dCos4 = Math.cos(d5);
        double[] dArr = {dCos * dCos2, dCos2 * dSin, dSin2};
        double d6 = dCos3 * dCos4;
        double d7 = dCos4 * dSin3;
        double d8 = dArr[0];
        double d9 = (d8 - d6) * (d8 - d6);
        double d10 = dArr[1];
        double d11 = d9 + ((d10 - d7) * (d10 - d7));
        double d12 = dArr[2];
        return Math.asin(Math.sqrt(d11 + ((d12 - dSin4) * (d12 - dSin4))) / 2.0d) * 1.27420015798544E7d;
    }

    public static String a(int i) {
        if (i < 1000) {
            return i + "m";
        }
        return (i / 1000) + "km";
    }

    public static af a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new af((int) (latLng.latitude * 1000000.0d), (int) (latLng.longitude * 1000000.0d));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(LatLng latLng, List<LatLng> list) {
        double d;
        double d2 = latLng.longitude;
        double d3 = latLng.latitude;
        if (list.size() < 3) {
            return false;
        }
        if (!list.get(0).equals(list.get(list.size() - 1))) {
            list.add(list.get(0));
        }
        int i = 0;
        int i2 = 0;
        while (i < list.size() - 1) {
            double d4 = list.get(i).longitude;
            double d5 = list.get(i).latitude;
            i++;
            double d6 = list.get(i).longitude;
            double d7 = list.get(i).latitude;
            double d8 = d3;
            if (b(d2, d3, d4, d5, d6, d7)) {
                return true;
            }
            if (Math.abs(d7 - d5) < 1.0E-9d) {
                d = d2;
            } else if (b(d4, d5, d2, d8, 180.0d, d8)) {
                if (d5 > d7) {
                    i2++;
                }
                d = d2;
            } else if (b(d6, d7, d2, d8, 180.0d, d8)) {
                if (d7 > d5) {
                }
                d = d2;
            } else {
                d = d2;
                if (a(d4, d5, d6, d7, d2, d8, d8)) {
                    i2++;
                }
            }
            d2 = d;
            d3 = d8;
        }
        return i2 % 2 != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0028, code lost:
    
        if (r3 == android.net.NetworkInfo.State.DISCONNECTING) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            NetworkInfo.State state = activeNetworkInfo.getState();
            if (state != null && state != NetworkInfo.State.DISCONNECTED) {
            }
            return false;
        } catch (Throwable unused) {
        }
        return true;
    }

    public static void a(Throwable th, String str, String str2) {
        try {
            hd hdVarD = hd.d();
            if (hdVarD != null) {
                hdVarD.b(th, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a(File file) throws Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return true;
        }
        for (int i = 0; i < fileArrListFiles.length; i++) {
            if (fileArrListFiles[i].isFile()) {
                if (!fileArrListFiles[i].delete()) {
                    return false;
                }
            } else {
                if (!a(fileArrListFiles[i])) {
                    return false;
                }
                fileArrListFiles[i].delete();
            }
        }
        return true;
    }

    public static gd a() {
        try {
            if (z.p == null) {
                return new gd.a("2dmap", "6.0.0", "AMAP_SDK_Android_2DMap_6.0.0").a(new String[]{"com.amap.api.maps2d", "com.amap.api.mapcore2d"}).a("6.0.0").a();
            }
            return z.p;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean a(int i, int i2) {
        if (i > 0 && i2 > 0) {
            return true;
        }
        Log.w("2dmap", "the map must have a size");
        return false;
    }
}
