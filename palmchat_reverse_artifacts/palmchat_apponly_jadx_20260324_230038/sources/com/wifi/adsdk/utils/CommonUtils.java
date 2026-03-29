package com.wifi.adsdk.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Color;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class CommonUtils {
    private static final int MIN_DELAY_TIME = 600;
    private static long lastClickTime;

    public static boolean canShowDialog(Dialog dialog) {
        return canShowDialog(dialog.getContext());
    }

    public static Activity getActivity(Context context) {
        if (context instanceof ContextWrapper) {
            return context instanceof Activity ? (Activity) context : getActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static int getDarkerColor(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = fArr[1] + 0.1f;
        fArr[2] = fArr[2] - 0.1f;
        return Color.HSVToColor(fArr);
    }

    public static double getDouble(int i) {
        return ((double) i) / 100.0d;
    }

    public static String getResourceUrlWithOutToken(String str) {
        String token = getToken(str);
        return !TextUtils.isEmpty(token) ? str.replace(token, "") : str;
    }

    private static String getToken(String str) {
        if (!TextUtils.isEmpty(str)) {
            int iIndexOf = str.indexOf(str.indexOf("?token=") < 0 ? "&token=" : "?token=");
            if (iIndexOf != -1) {
                int i = iIndexOf + 1;
                int iIndexOf2 = str.indexOf(ContainerUtils.FIELD_DELIMITER, i);
                return iIndexOf2 != -1 ? str.substring(i, iIndexOf2 + 1) : str.substring(iIndexOf);
            }
        }
        return null;
    }

    public static long getVideoCacheSize(float f) {
        if (f == -1.0f) {
            return -1L;
        }
        return (long) (f * 1024.0f * 1024.0f);
    }

    public static boolean isFastClick() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - lastClickTime < 600) {
                return true;
            }
            lastClickTime = jCurrentTimeMillis;
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean isViewVisibility(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    public static void setViewVisibility(View view, int i) {
        if (view == null || view.getVisibility() == i || !isViewVisibility(i)) {
            return;
        }
        view.setVisibility(i);
    }

    public static boolean canShowDialog(Context context) {
        if (getActivity(context) != null) {
            return !r0.isFinishing();
        }
        return false;
    }
}
