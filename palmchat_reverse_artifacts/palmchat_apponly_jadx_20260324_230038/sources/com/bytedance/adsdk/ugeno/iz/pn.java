package com.bytedance.adsdk.ugeno.iz;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn {
    private static boolean nr;
    private static Field u;

    public static Drawable u(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!nr) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                u = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            nr = true;
        }
        Field field = u;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException unused2) {
                u = null;
            }
        }
        return null;
    }
}
