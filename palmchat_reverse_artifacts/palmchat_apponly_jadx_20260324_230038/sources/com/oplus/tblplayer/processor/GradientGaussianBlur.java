package com.oplus.tblplayer.processor;

import android.animation.TimeInterpolator;
import androidx.annotation.RequiresApi;
import com.oplus.tbl.exoplayer2.effect.ConvolutionFunction1D;
import com.oplus.tbl.exoplayer2.effect.GaussianFunction;
import com.oplus.tbl.exoplayer2.effect.SeparableConvolution;
import com.oplus.tbl.exoplayer2.util.Log;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tblplayer.processor.util.GradientBlurParameters;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@RequiresApi(26)
@UnstableApi
public final class GradientGaussianBlur extends SeparableConvolution {
    private static final float DEFAULT_DEALT_TIME_STEP = 0.01f;
    private static final float DEFAULT_NUM_STANDARD_DEVIATIONS = 2.0f;
    private static final float MAX_TIME_SCALE_VALUE = 1.0f;
    private static final String TAG = "GradientGaussianBlur";
    private GradientBlurParameters mFirstBlurPeriod;
    private GradientBlurParameters mFsecondBlurPeriod;
    private final TimeInterpolator mTimeInterpolator;

    public GradientGaussianBlur(GradientBlurParameters gradientBlurParameters, GradientBlurParameters gradientBlurParameters2, TimeInterpolator timeInterpolator) {
        GradientBlurParameters gradientBlurParameters3 = GradientBlurParameters.DEFAULT;
        this.mFirstBlurPeriod = gradientBlurParameters;
        this.mFsecondBlurPeriod = gradientBlurParameters2;
        this.mTimeInterpolator = timeInterpolator;
    }

    private synchronized float getCurrentGradientBlurSigma(float f, GradientBlurParameters gradientBlurParameters) {
        float interpolation;
        if (f <= 1.0f) {
            float f2 = gradientBlurParameters.endBlurriness;
            float f3 = gradientBlurParameters.startBlurriness;
            interpolation = f2 >= f3 ? ((f2 - f3) * this.mTimeInterpolator.getInterpolation(f)) + gradientBlurParameters.startBlurriness : f3 - ((f3 - f2) * this.mTimeInterpolator.getInterpolation(f));
        } else {
            interpolation = 0.01f;
        }
        return interpolation;
    }

    private synchronized float getTimeScaleValue(long j, GradientBlurParameters gradientBlurParameters) {
        long j2;
        j2 = gradientBlurParameters.startTimeUs;
        return ((j - j2) / (gradientBlurParameters.endTimeUs - j2)) + 0.01f;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.SeparableConvolution
    public ConvolutionFunction1D getConvolution(long j) {
        float currentGradientBlurSigma;
        float timeScaleValue;
        GradientBlurParameters gradientBlurParameters;
        GradientBlurParameters gradientBlurParameters2 = this.mFirstBlurPeriod;
        if (gradientBlurParameters2.startTimeUs > j || j > gradientBlurParameters2.endTimeUs) {
            GradientBlurParameters gradientBlurParameters3 = this.mFsecondBlurPeriod;
            if (gradientBlurParameters3.startTimeUs > j || j > gradientBlurParameters3.endTimeUs) {
                currentGradientBlurSigma = 0.0f;
                Log.d(TAG, "current blurriness value is: " + currentGradientBlurSigma);
                return new GaussianFunction(currentGradientBlurSigma, 2.0f);
            }
            timeScaleValue = getTimeScaleValue(j, gradientBlurParameters3);
            gradientBlurParameters = this.mFsecondBlurPeriod;
        } else {
            timeScaleValue = getTimeScaleValue(j, gradientBlurParameters2);
            gradientBlurParameters = this.mFirstBlurPeriod;
        }
        currentGradientBlurSigma = getCurrentGradientBlurSigma(timeScaleValue, gradientBlurParameters);
        Log.d(TAG, "current blurriness value is: " + currentGradientBlurSigma);
        return new GaussianFunction(currentGradientBlurSigma, 2.0f);
    }

    public synchronized void setCurrentBlurParameters(GradientBlurParameters gradientBlurParameters, GradientBlurParameters gradientBlurParameters2) {
        this.mFirstBlurPeriod = gradientBlurParameters;
        this.mFsecondBlurPeriod = gradientBlurParameters2;
    }
}
