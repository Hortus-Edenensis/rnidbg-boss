package com.bytedance.sdk.component.adexpress.b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    public static Drawable u(Context context, com.bytedance.sdk.component.adexpress.dynamic.fx.x xVar) {
        if (context == null || xVar == null) {
            return null;
        }
        return u(context, (int) n.u(context, xVar.o()), xVar.my(), xVar.d());
    }

    public static Drawable u(Context context, int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        if (context != null) {
            gradientDrawable.setStroke(i, i2);
        }
        gradientDrawable.setColor(i3);
        return gradientDrawable;
    }
}
