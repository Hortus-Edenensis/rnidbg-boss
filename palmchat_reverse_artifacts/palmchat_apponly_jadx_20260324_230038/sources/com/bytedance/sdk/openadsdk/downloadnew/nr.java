package com.bytedance.sdk.openadsdk.downloadnew;

import android.content.Context;
import com.bytedance.sdk.openadsdk.api.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    public static int fx(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "id", context.getPackageName());
        } catch (Exception e) {
            iz.u(e);
            return 0;
        }
    }

    public static int nr(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "style", context.getPackageName());
        } catch (Exception e) {
            iz.u(e);
            return 0;
        }
    }

    public static int u(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        } catch (Exception e) {
            iz.u(e);
            return 0;
        }
    }

    public static int nr(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, "attr", str2);
        } catch (Exception e) {
            iz.u(e);
            return 0;
        }
    }

    public static int u(Context context, String str, String str2) {
        try {
            return context.getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e) {
            iz.u(e);
            return 0;
        }
    }
}
