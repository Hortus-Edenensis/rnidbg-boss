package io.togoto.imagezoomcrop.cropoverlay.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class PaintUtil {
    private static final String DEFAULT_BACKGROUND_COLOR_ID = "#B029303F";
    private static final int DEFAULT_CORNER_COLOR = -1;
    private static final float DEFAULT_CORNER_THICKNESS_DP = 5.0f;
    private static final float DEFAULT_GUIDELINE_THICKNESS_PX = 2.0f;
    private static final float DEFAULT_LINE_THICKNESS_DP = 1.0f;
    private static final String SEMI_TRANSPARENT = "#AAFFFFFF";

    public static float getCornerThickness() {
        return 5.0f;
    }

    public static float getLineThickness() {
        return 1.0f;
    }

    public static Paint newBackgroundPaint(Context context) {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor(DEFAULT_BACKGROUND_COLOR_ID));
        return paint;
    }

    public static Paint newBorderPaint(Context context) {
        float fApplyDimension = TypedValue.applyDimension(1, 1.0f, context.getResources().getDisplayMetrics());
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.parseColor(SEMI_TRANSPARENT));
        paint.setStrokeWidth(fApplyDimension);
        paint.setStyle(Paint.Style.STROKE);
        return paint;
    }

    public static Paint newCornerPaint(Context context) {
        float fApplyDimension = TypedValue.applyDimension(1, 5.0f, context.getResources().getDisplayMetrics());
        Paint paint = new Paint();
        paint.setColor(-1);
        paint.setStrokeWidth(fApplyDimension);
        paint.setStyle(Paint.Style.STROKE);
        return paint;
    }

    public static Paint newGuidelinePaint() {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor(SEMI_TRANSPARENT));
        paint.setStrokeWidth(2.0f);
        return paint;
    }
}
