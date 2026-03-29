package com.oplus.tblplayer.processor;

import android.animation.TimeInterpolator;
import android.content.Context;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.effect.GlEffect;
import com.oplus.tbl.exoplayer2.effect.GlShaderProgram;
import com.oplus.tblplayer.processor.util.GradientBlurParameters;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@RequiresApi(26)
public final class GradientBlurEffect implements GlEffect {
    private static final String TAG = "GradientBlurEffect";
    private GradientBlurParameters mFirstBlurPeriod;
    public GradientGaussianBlur mGlEffect;
    private GradientBlurParameters mSecondBlurPeriod;

    public GradientBlurEffect(GradientBlurParameters gradientBlurParameters, GradientBlurParameters gradientBlurParameters2, TimeInterpolator timeInterpolator) {
        GradientBlurParameters gradientBlurParameters3 = GradientBlurParameters.DEFAULT;
        this.mFirstBlurPeriod = gradientBlurParameters;
        this.mSecondBlurPeriod = gradientBlurParameters2;
        this.mGlEffect = new GradientGaussianBlur(gradientBlurParameters, gradientBlurParameters2, timeInterpolator);
    }

    public static GradientBlurEffect createGradientBlurEffect(GradientBlurParameters gradientBlurParameters, GradientBlurParameters gradientBlurParameters2, TimeInterpolator timeInterpolator) {
        return new GradientBlurEffect(gradientBlurParameters, gradientBlurParameters2, timeInterpolator);
    }

    public synchronized long getFirstEndTimeUs() {
        return this.mFirstBlurPeriod.endTimeUs;
    }

    public synchronized long getFirstStartTimeUs() {
        return this.mFirstBlurPeriod.startTimeUs;
    }

    public synchronized long getSecondEndTimeUs() {
        return this.mSecondBlurPeriod.endTimeUs;
    }

    public synchronized long getSecondStartTimeUs() {
        return this.mSecondBlurPeriod.startTimeUs;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return this.mGlEffect.isNoOp(i, i2);
    }

    public synchronized void setCurrentBlurParameters(GradientBlurParameters gradientBlurParameters, GradientBlurParameters gradientBlurParameters2) {
        this.mFirstBlurPeriod = gradientBlurParameters;
        this.mSecondBlurPeriod = gradientBlurParameters2;
        this.mGlEffect.setCurrentBlurParameters(gradientBlurParameters, gradientBlurParameters2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new GradientBlurShaderProgram(context, z, this);
    }
}
