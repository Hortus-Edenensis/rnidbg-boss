package com.kwad.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ba {
    public static int az(Context context, String str) {
        Resources resourcesDz = dz(context);
        if (resourcesDz == null) {
            resourcesDz = context.getResources();
        }
        return resourcesDz.getIdentifier(str, "drawable", context.getPackageName());
    }

    public static Resources dz(Context context) {
        if (context == null) {
            return null;
        }
        return ServiceProvider.Re().getResources();
    }

    public static int getAppIconId(Context context) {
        int i;
        try {
            i = y.getPackageInfo(context.getApplicationContext(), context.getPackageName(), 64).applicationInfo.icon;
        } catch (Throwable unused) {
            i = 0;
        }
        return i <= 0 ? az(context, "ksad_notification_small_icon") : i;
    }

    public static int getId(Context context, String str) {
        return getIdentifier(context, str, "id");
    }

    private static int getIdentifier(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, getPackageName(context));
    }

    private static String getPackageName(Context context) {
        return ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).CT() ? "com.kwad.sdk" : context.getPackageName();
    }
}
