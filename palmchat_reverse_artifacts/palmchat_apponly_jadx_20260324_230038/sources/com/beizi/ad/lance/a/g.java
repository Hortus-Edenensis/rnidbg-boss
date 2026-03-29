package com.beizi.ad.lance.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.lantern.auth.app.FunDC;
import com.ss.android.ttvecamera.TECameraUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class g {
    public static View a(int i, View view, View view2, String str) {
        if (view != null) {
            return a(i, view2, view, str, true);
        }
        return null;
    }

    private static int b(Context context) {
        return context instanceof Activity ? ((Activity) context).getResources().getDisplayMetrics().heightPixels : TECameraUtils.CAPTURE_NORMAL;
    }

    private static int c(Context context) {
        if (!(context instanceof Activity)) {
            return 0;
        }
        Resources resources = ((Activity) context).getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
        m.c("BeiZisAd", "Status height:" + dimensionPixelSize);
        return dimensionPixelSize;
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x03d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static View a(int i, View view, View view2, String str, boolean z) {
        int width;
        int height;
        double d;
        int i2;
        int i3;
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        int iMax;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        CharSequence charSequence5;
        int i9;
        int i10;
        if (view == null || view2 == null) {
            return null;
        }
        width = view2.getWidth();
        height = view2.getHeight();
        d = ((double) i) / 100.0d;
        m.c("BeiZisAd", "width = " + width + ",height = " + height);
        Rect rect = new Rect();
        view2.getHitRect(rect);
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        i2 = iArr[0];
        i3 = iArr[1];
        m.c("BeiZisAd", "delegateLeft = " + i2 + ",delegateTop = " + i3);
        int iA = a(view2.getContext());
        int iB = b(view2.getContext()) + c(view2.getContext());
        m.c("BeiZisAd", "screenWidth = " + iA + ",screenHeight = " + iB);
        str.hashCode();
        switch (str) {
            case "BOTTOMLEFT":
                charSequence = "LEFT";
                charSequence2 = "RIGHT";
                charSequence3 = "BOTTOM";
                charSequence4 = "TOP";
                double dSqrt = Math.sqrt(d) - 1.0d;
                int i11 = (int) (((double) width) * dSqrt);
                int iMax2 = Math.max(0, i3 + 0);
                iMax = Math.max(0, i2 - i11);
                i4 = iMax2;
                i5 = 0;
                i6 = 0;
                i7 = (int) (dSqrt * ((double) height));
                i8 = i11;
                break;
            case "TOPLEFT":
                charSequence = "LEFT";
                charSequence2 = "RIGHT";
                double dSqrt2 = Math.sqrt(d) - 1.0d;
                int i12 = (int) (((double) width) * dSqrt2);
                charSequence3 = "BOTTOM";
                charSequence4 = "TOP";
                int i13 = (int) (dSqrt2 * ((double) height));
                int iMax3 = Math.max(0, i3 - i13);
                iMax = Math.max(0, i2 - i12);
                i4 = iMax3;
                i8 = i12;
                i7 = 0;
                i6 = i13;
                i5 = 0;
                break;
            case "TOPRIGHT":
                charSequence = "LEFT";
                charSequence2 = "RIGHT";
                i8 = 0;
                double dSqrt3 = Math.sqrt(d) - 1.0d;
                int i14 = (int) (((double) width) * dSqrt3);
                int i15 = (int) (dSqrt3 * ((double) height));
                int iMax4 = Math.max(0, i3 - i15);
                i6 = i15;
                iMax = Math.max(0, i2 + 0);
                charSequence4 = "TOP";
                i5 = i14;
                i7 = 0;
                charSequence3 = "BOTTOM";
                i4 = iMax4;
                break;
            case "TOP":
                charSequence = "LEFT";
                charSequence2 = "RIGHT";
                i8 = 0;
                int i16 = (int) ((d - 1.0d) * ((double) height));
                int iMax5 = Math.max(0, i3 - i16);
                i6 = i16;
                iMax = Math.max(0, i2 + 0);
                charSequence3 = "BOTTOM";
                charSequence4 = "TOP";
                i4 = iMax5;
                i5 = 0;
                i7 = 0;
                break;
            case "LEFT":
                charSequence = "LEFT";
                charSequence2 = "RIGHT";
                int i17 = (int) ((d - 1.0d) * ((double) width));
                int iMax6 = Math.max(0, i3 + 0);
                i8 = i17;
                iMax = Math.max(0, i2 - i17);
                charSequence3 = "BOTTOM";
                charSequence4 = "TOP";
                i4 = iMax6;
                i5 = 0;
                i7 = 0;
                i6 = 0;
                break;
            case "RIGHT":
                charSequence = "LEFT";
                charSequence2 = "RIGHT";
                i8 = 0;
                i5 = (int) ((d - 1.0d) * ((double) width));
                int iMax7 = Math.max(0, i3 + 0);
                iMax = Math.max(0, i2 + 0);
                charSequence3 = "BOTTOM";
                charSequence4 = "TOP";
                i4 = iMax7;
                i7 = 0;
                i6 = 0;
                break;
            case "BOTTOMRIGHT":
                charSequence = "LEFT";
                charSequence2 = "RIGHT";
                double dSqrt4 = Math.sqrt(d) - 1.0d;
                i6 = 0;
                int iMax8 = Math.max(0, i3 + 0);
                iMax = Math.max(0, i2 + 0);
                i5 = (int) (((double) width) * dSqrt4);
                charSequence3 = "BOTTOM";
                charSequence4 = "TOP";
                i4 = iMax8;
                i7 = (int) (dSqrt4 * ((double) height));
                i8 = 0;
                break;
            case "BOTTOM":
                charSequence = "LEFT";
                charSequence2 = "RIGHT";
                int iMax9 = Math.max(0, i3 + 0);
                i7 = (int) ((d - 1.0d) * ((double) height));
                iMax = Math.max(0, i2 + 0);
                charSequence3 = "BOTTOM";
                charSequence4 = "TOP";
                i8 = 0;
                i6 = 0;
                i4 = iMax9;
                i5 = 0;
                break;
            case "CENTER":
                double dSqrt5 = Math.sqrt(d) - 1.0d;
                charSequence = "LEFT";
                charSequence2 = "RIGHT";
                int i18 = (int) ((((double) width) * dSqrt5) / 2.0d);
                int i19 = (int) ((dSqrt5 * ((double) height)) / 2.0d);
                m.c("BeiZisAd", "expandTop = " + i19);
                int iMax10 = Math.max(0, i3 - i19);
                iMax = Math.max(0, i2 - i18);
                m.c("BeiZisAd", "marginTop = " + iMax10 + ",marginLeft = " + iMax);
                i6 = i19;
                charSequence4 = "TOP";
                i8 = i18;
                i5 = i8;
                charSequence3 = "BOTTOM";
                i4 = iMax10;
                i7 = i6;
                break;
            default:
                charSequence = "LEFT";
                charSequence2 = "RIGHT";
                charSequence3 = "BOTTOM";
                charSequence4 = "TOP";
                i8 = 0;
                i5 = 0;
                i7 = 0;
                i6 = 0;
                iMax = 0;
                i4 = 0;
                break;
        }
        StringBuilder sb = new StringBuilder();
        CharSequence charSequence6 = charSequence;
        sb.append("area = ");
        sb.append(i);
        sb.append(",expandLeft = ");
        sb.append(i8);
        sb.append(",expandTop = ");
        sb.append(i6);
        sb.append(",expandRight = ");
        sb.append(i5);
        sb.append(",expandBottom = ");
        sb.append(i7);
        m.c("BeiZisAd", sb.toString());
        m.c("BeiZisAd", "delegateArea old = " + rect);
        int iMax11 = Math.max(iMax, 0);
        int iMin = Math.min(0, iA);
        int iMax12 = Math.max(i4, 0);
        int iMin2 = Math.min(0, iB);
        rect.left -= i8;
        rect.top -= i6;
        rect.right += i5;
        rect.bottom += i7;
        m.c("BeiZisAd", "delegateArea new = " + rect);
        FrameLayout frameLayout = new FrameLayout(view2.getContext());
        int iMin3 = rect.right - rect.left;
        int iMin4 = rect.bottom - rect.top;
        if (str.contains(charSequence4)) {
            i9 = i3 + height;
        } else {
            if (!str.contains(charSequence3)) {
                charSequence5 = charSequence6;
                i9 = 0;
                i10 = !str.contains(charSequence5) ? i2 + width : str.contains(charSequence2) ? iA - i2 : 0;
                if (i9 != 0) {
                    iMin4 = Math.min(iMin4, i9);
                }
                if (i10 != 0) {
                    iMin3 = Math.min(iMin3, i10);
                }
                m.c("BeiZisAd", "fHeight = " + iMin4 + ",remainHeight = " + i9 + ",fWidth = " + iMin3 + ",remainWidth = " + i10);
                frameLayout.setBackgroundColor(0);
                if (view instanceof ViewGroup) {
                    View rootView = view.getRootView();
                    m.c("BeiZisAd", "rootView = " + rootView);
                    if (rootView instanceof ViewGroup) {
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iMin3, iMin4);
                        m.c("BeiZisAd", "marginLeft = " + iMax11 + ",marginTop = " + iMax12 + ",marginRight = " + iMin + ",marginBottom = " + iMin2);
                        layoutParams.setMargins(iMax11, iMax12, iMin, iMin2);
                        ((ViewGroup) rootView).addView(frameLayout, layoutParams);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("fWidth = ");
                        sb2.append(iMin3);
                        sb2.append(",fHeight = ");
                        sb2.append(iMin4);
                        m.c("BeiZisAd", sb2.toString());
                    }
                }
                return frameLayout;
            }
            i9 = iB - i3;
        }
        charSequence5 = charSequence6;
        if (!str.contains(charSequence5)) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        m.c("BeiZisAd", "fHeight = " + iMin4 + ",remainHeight = " + i9 + ",fWidth = " + iMin3 + ",remainWidth = " + i10);
        frameLayout.setBackgroundColor(0);
        if (view instanceof ViewGroup) {
        }
        return frameLayout;
    }

    private static int a(Context context) {
        return context instanceof Activity ? ((Activity) context).getResources().getDisplayMetrics().widthPixels : FunDC.ID_AUTH_1080;
    }
}
