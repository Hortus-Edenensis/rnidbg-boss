package com.kwad.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class bz {
    public static boolean a(View view, int i, boolean z) {
        return view != null && b(view, i, z) && dx(view.getContext());
    }

    private static boolean b(View view, int i, boolean z) {
        if (view == null || view.getParent() == null) {
            return false;
        }
        Activity activityFromContext = com.kwad.sdk.o.m.getActivityFromContext(view.getContext());
        if ((activityFromContext != null && activityFromContext.isFinishing()) || !view.isShown() || view.getVisibility() != 0 || (z && !view.hasWindowFocus())) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            long jHeight = ((long) rect.height()) * ((long) rect.width());
            long height = ((long) view.getHeight()) * ((long) view.getWidth());
            if (height > 0 && jHeight * 100 >= ((long) i) * height) {
                return true;
            }
        }
        return false;
    }

    private static boolean dx(Context context) {
        return aw.SX().dx(context);
    }

    public static double k(View view, boolean z) {
        if (view == null) {
            return -1.0d;
        }
        if (!dx(view.getContext())) {
            return -2.0d;
        }
        if (view.getParent() == null) {
            return -3.0d;
        }
        Activity activityFromContext = com.kwad.sdk.o.m.getActivityFromContext(view.getContext());
        if (activityFromContext != null && activityFromContext.isFinishing()) {
            return -4.0d;
        }
        if (!view.isShown() || view.getVisibility() != 0) {
            return -5.0d;
        }
        if (!view.hasWindowFocus()) {
            return -6.0d;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return -8.0d;
        }
        long jHeight = ((long) rect.height()) * ((long) rect.width());
        long height = ((long) view.getHeight()) * ((long) view.getWidth());
        if (height <= 0) {
            return -7.0d;
        }
        return (jHeight * 100.0d) / height;
    }

    public static boolean q(View view, int i) {
        return view != null && b(view, i, true) && view.hasWindowFocus() && dx(view.getContext());
    }
}
