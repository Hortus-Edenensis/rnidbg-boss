package com.bef.effectsdk;

import android.graphics.Bitmap;
import android.graphics.PointF;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ImgporcUtils {

    /* JADX INFO: compiled from: SearchBox */
    public static class InterpolationFlags {
        public static final int INTER_LINEAR = 1;
        public static final int INTER_NEAREST = 0;
        public static final int WARP_INVERSE_MAP = 16;
    }

    public static float calculateAspectRatio(PointF[] pointFArr, int i, int i2) {
        return nativeCalculateAspectRatio(pointFArr, i, i2);
    }

    public static Bitmap correctPerspective(Bitmap bitmap, PointF[] pointFArr, int i, int i2, int i3) {
        return nativeCorrectPerspective(bitmap, pointFArr, i, i2, i3);
    }

    private static native float nativeCalculateAspectRatio(PointF[] pointFArr, int i, int i2);

    private static native Bitmap nativeCorrectPerspective(Bitmap bitmap, PointF[] pointFArr, int i, int i2, int i3);

    public static Bitmap correctPerspective(Bitmap bitmap, PointF[] pointFArr, int i, int i2) {
        return nativeCorrectPerspective(bitmap, pointFArr, i, i2, 1);
    }
}
