package defpackage;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.view.View;
import com.efs.sdk.base.core.util.NetworkUtil;
import java.io.File;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class g47 {
    public static long a(File file) {
        if (file == null) {
            return -1L;
        }
        return file.getUsableSpace();
    }

    public static Bitmap b(Activity activity) {
        Bitmap bitmapCreateBitmap;
        View rootView = activity.getWindow().getDecorView().getRootView();
        try {
            Method declaredMethod = View.class.getDeclaredMethod("createSnapshot", Bitmap.Config.class, Integer.TYPE, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            bitmapCreateBitmap = (Bitmap) declaredMethod.invoke(rootView, Bitmap.Config.RGB_565, -1, Boolean.FALSE);
        } catch (Throwable th) {
            if (k17.k()) {
                th.printStackTrace();
            }
            bitmapCreateBitmap = null;
        }
        if (bitmapCreateBitmap != null) {
            return bitmapCreateBitmap;
        }
        try {
            rootView.setDrawingCacheEnabled(true);
            rootView.buildDrawingCache(true);
            bitmapCreateBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
            rootView.setDrawingCacheEnabled(false);
            return bitmapCreateBitmap;
        } catch (Throwable th2) {
            if (!k17.k()) {
                return bitmapCreateBitmap;
            }
            th2.printStackTrace();
            return bitmapCreateBitmap;
        }
    }

    public static String c() {
        return d(o17.a());
    }

    public static String d(Context context) {
        NetworkInfo activeNetworkInfo;
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            if (k17.k()) {
                th.printStackTrace();
            }
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                sb.append("wifi");
                return sb.toString();
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            sb.append(telephonyManager.getNetworkOperatorName());
            sb.append("_");
            int networkType = telephonyManager.getNetworkType();
            switch (networkType) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    str = "2G";
                    sb.append(str);
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    str = "3G";
                    sb.append(str);
                    break;
                case 13:
                    str = "4G";
                    sb.append(str);
                    break;
                default:
                    sb.append("unknown:");
                    sb.append(networkType);
                    break;
            }
            return sb.toString();
        }
        sb.append(NetworkUtil.NETWORK_CLASS_DISCONNECTED);
        return sb.toString();
    }

    public static boolean e() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) o17.a().getSystemService("connectivity");
            if (connectivityManager != null) {
                return NetworkInfo.State.CONNECTED == connectivityManager.getNetworkInfo(1).getState();
            }
            return false;
        } catch (Throwable th) {
            if (!k17.k()) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }
}
