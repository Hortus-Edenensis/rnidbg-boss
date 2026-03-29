package com.huawei.openalliance.ad.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import com.huawei.hms.ads.fh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class bm {
    private static final String Code = "ViewUtil";
    private static final int V = 300;

    public static void Code(ViewGroup viewGroup) {
        boolean z;
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 < childCount) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt != null && childAt.getVisibility() == 0) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                z = false;
                break;
            }
        }
        if (!z || viewGroup.getVisibility() == 0) {
            if (z) {
                return;
            }
            i = 8;
            if (viewGroup.getVisibility() == 8) {
                return;
            }
        }
        viewGroup.setVisibility(i);
    }

    public static boolean Code(int i, int i2, float f, float f2) {
        fh.Code(Code, "checkSwipe, diffX: %s, diffY: %s, limitSwipeDp: %s, swipeDirection: %s.", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i));
        if (i != 0 || f2 < i2 || f2 < Math.abs(f)) {
            return 1 == i && Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) i2);
        }
        return true;
    }

    public static boolean Code(View view, int i) {
        return Code(view, i, 300, 0);
    }

    public static boolean Code(View view, int i, int i2, int i3) {
        if (view == null || view.getVisibility() == i) {
            return false;
        }
        view.setVisibility(i);
        boolean z = i == 0;
        float f = z ? 0.0f : 1.0f;
        float f2 = z ? 1.0f : 0.0f;
        Animation animation = view.getAnimation();
        if (animation != null) {
            animation.cancel();
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration(i2);
        alphaAnimation.setInterpolator(new DecelerateInterpolator());
        if (i3 > 0) {
            alphaAnimation.setStartOffset(i3);
        }
        view.startAnimation(alphaAnimation);
        return true;
    }

    public static boolean Code(View view, boolean z) {
        int i = z ? 0 : 8;
        if (view == null || view.getVisibility() == i) {
            return false;
        }
        view.setVisibility(i);
        return true;
    }
}
