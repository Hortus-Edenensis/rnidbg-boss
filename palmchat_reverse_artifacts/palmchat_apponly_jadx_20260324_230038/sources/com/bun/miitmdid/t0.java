package com.bun.miitmdid;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class t0 {
    public static boolean a(Activity activity, @NonNull String str) {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity, str);
    }

    public static native boolean a(Context context, String... strArr);

    public static native boolean a(int[] iArr);
}
