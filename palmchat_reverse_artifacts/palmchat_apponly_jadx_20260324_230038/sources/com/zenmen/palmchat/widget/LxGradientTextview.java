package com.zenmen.palmchat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class LxGradientTextview extends TextView {
    public static final String TAG = "LxGradientTextview";
    private int[] gradientColors;
    private float gradientRatio;

    public LxGradientTextview(Context context) {
        super(context);
        this.gradientColors = new int[]{0, 0, -1, -1};
        this.gradientRatio = 0.5f;
    }

    private float[] getPositions() {
        int height = getLayout().getHeight();
        int height2 = getHeight();
        float[] fArr = new float[4];
        fArr[0] = 0.0f;
        if (height > height2) {
            float f = (height - height2) * 1.0f;
            float f2 = height;
            fArr[1] = f / f2;
            fArr[2] = (f2 - (height2 * (1.0f - this.gradientRatio))) / f2;
        } else {
            fArr[1] = 0.0f;
            fArr[2] = 1.0f;
        }
        LogUtil.i(TAG, "result =  " + fArr[1] + " " + fArr[2]);
        fArr[3] = 1.0f;
        return fArr;
    }

    public float[] getAngleXY(float f) {
        float fSignum;
        float fSignum2;
        Layout layout = getLayout();
        int height = layout.getHeight();
        int width = layout.getWidth();
        float f2 = f % 360.0f;
        if (f2 < 0.0f) {
            f2 += 360.0f;
        }
        if ((f2 < 0.0f || f2 >= 90.0f) && (f2 < 180.0f || f2 >= 270.0f)) {
            float f3 = height;
            float f4 = 180.0f - f2;
            float f5 = width;
            float f6 = f2;
            fSignum = (float) (((double) (f3 / 2.0f)) + (((double) ((Math.signum(f4) * f5) / 2.0f)) * Math.tan(Math.toRadians(f2 - (f2 < 180.0f ? 90 : 270)))));
            if (fSignum >= f3 || fSignum <= 0.0f) {
                f = f2 < 180.0f ? f3 : 0.0f;
                fSignum2 = (float) (((double) (width / 2)) + (((double) ((Math.signum(f4) * f3) / 2.0f)) * Math.tan(Math.toRadians((f2 < 180.0f ? EffectConstants.ROTATION_DEGREES_180 : 360) - f6))));
            } else {
                if (f2 < 180.0f) {
                    f = f5;
                }
                float f7 = f;
                f = fSignum;
                fSignum2 = f7;
            }
        } else {
            float f8 = 90.0f - f2;
            float f9 = height;
            fSignum2 = (float) (((double) (width / 2)) + (((double) ((Math.signum(f8) * f9) / 2.0f)) * Math.tan(Math.toRadians(f2 - (f2 >= 180.0f ? EffectConstants.ROTATION_DEGREES_180 : 0)))));
            float f10 = width;
            if (fSignum2 >= f10 || fSignum2 <= 0.0f) {
                f = f2 < 90.0f ? f10 : 0.0f;
                fSignum = (float) (((double) (height / 2)) - (((double) ((Math.signum(f8) * f10) / 2.0f)) * Math.tan(Math.toRadians((f2 >= 180.0f ? 270 : 90) - f2))));
                float f72 = f;
                f = fSignum;
                fSignum2 = f72;
            } else if (f2 >= 90.0f) {
                f = f9;
            }
        }
        return new float[]{fSignum2, f, width - fSignum2, height - f};
    }

    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        float[] angleXY = getAngleXY(0.0f);
        paint.setShader(new LinearGradient(angleXY[0], angleXY[1], angleXY[2], angleXY[3], this.gradientColors, getPositions(), Shader.TileMode.CLAMP));
        super.onDraw(canvas);
    }

    public void setWidgetHeightAndRatio(int i, float f) {
        this.gradientRatio = f;
    }

    public LxGradientTextview(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gradientColors = new int[]{0, 0, -1, -1};
        this.gradientRatio = 0.5f;
    }

    public LxGradientTextview(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gradientColors = new int[]{0, 0, -1, -1};
        this.gradientRatio = 0.5f;
    }

    public LxGradientTextview(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.gradientColors = new int[]{0, 0, -1, -1};
        this.gradientRatio = 0.5f;
    }
}
