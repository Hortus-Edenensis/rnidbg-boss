package com.opos.cmn.biz.web.b.b.a;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static void a(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        view.setBackground(drawable);
    }

    public static boolean b(Context context) {
        return c(context) && a(context);
    }

    private static boolean c(Context context) {
        boolean z;
        boolean z2;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.isLightTheme, R.attr.forceDarkAllowed});
                z = typedArrayObtainStyledAttributes.getBoolean(0, false);
                z2 = typedArrayObtainStyledAttributes.getBoolean(1, false);
                typedArrayObtainStyledAttributes.recycle();
            } else {
                z = false;
                z2 = false;
            }
            return z && z2;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("Utils", "", e);
            return false;
        }
    }

    public static void a(Object obj, String str, Object obj2) {
        com.opos.cmn.b.b.a aVar = new com.opos.cmn.b.b.a(obj.getClass());
        aVar.a(aVar.a(str), obj, obj2);
    }

    public static boolean a(Context context) {
        return context != null && 32 == (context.getResources().getConfiguration().uiMode & 48);
    }
}
