package io.togoto.imagezoomcrop.cropoverlay.utils;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ImageViewUtil {
    public static Rect getBitmapRectCenterInside(Bitmap bitmap, View view) {
        return getBitmapRectCenterInsideHelper(bitmap.getWidth(), bitmap.getHeight(), view.getWidth(), view.getHeight());
    }

    private static Rect getBitmapRectCenterInsideHelper(int i, int i2, int i3, int i4) {
        double d;
        double d2;
        long jRound;
        int i5;
        double d3 = i3 < i ? ((double) i3) / ((double) i) : Double.POSITIVE_INFINITY;
        double d4 = i4 < i2 ? ((double) i4) / ((double) i2) : Double.POSITIVE_INFINITY;
        if (d3 == Double.POSITIVE_INFINITY && d4 == Double.POSITIVE_INFINITY) {
            d = i2;
            d2 = i;
        } else if (d3 <= d4) {
            double d5 = i3;
            double d6 = (((double) i2) * d5) / ((double) i);
            d2 = d5;
            d = d6;
        } else {
            d = i4;
            d2 = (((double) i) * d) / ((double) i2);
        }
        double d7 = i3;
        int iRound = 0;
        if (d2 == d7) {
            jRound = Math.round((((double) i4) - d) / 2.0d);
        } else {
            double d8 = i4;
            if (d == d8) {
                iRound = (int) Math.round((d7 - d2) / 2.0d);
                i5 = 0;
                return new Rect(iRound, i5, ((int) Math.ceil(d2)) + iRound, ((int) Math.ceil(d)) + i5);
            }
            iRound = (int) Math.round((d7 - d2) / 2.0d);
            jRound = Math.round((d8 - d) / 2.0d);
        }
        i5 = (int) jRound;
        return new Rect(iRound, i5, ((int) Math.ceil(d2)) + iRound, ((int) Math.ceil(d)) + i5);
    }

    public static Rect getBitmapRectCenterInside(int i, int i2, int i3, int i4) {
        return getBitmapRectCenterInsideHelper(i, i2, i3, i4);
    }
}
