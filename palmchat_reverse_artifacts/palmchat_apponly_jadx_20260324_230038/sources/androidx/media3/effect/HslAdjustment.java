package androidx.media3.effect;

import android.content.Context;
import androidx.annotation.FloatRange;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.efs.sdk.base.core.config.remote.RemoteConfig;
import defpackage.ik1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class HslAdjustment implements GlEffect {
    public final float hueAdjustmentDegrees;
    public final float lightnessAdjustment;
    public final float saturationAdjustment;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {
        private float hueAdjustment;
        private float lightnessAdjustment;
        private float saturationAdjustment;

        public Builder adjustHue(float f) {
            this.hueAdjustment = f % 360.0f;
            return this;
        }

        public Builder adjustLightness(@FloatRange(from = -100.0d, to = RemoteConfig.FULL_RATE) float f) {
            Assertions.checkArgument(-100.0f <= f && f <= 100.0f, "Can adjust the lightness by only 100 in either direction, but provided " + f);
            this.lightnessAdjustment = f;
            return this;
        }

        public Builder adjustSaturation(@FloatRange(from = -100.0d, to = RemoteConfig.FULL_RATE) float f) {
            Assertions.checkArgument(-100.0f <= f && f <= 100.0f, "Can adjust the saturation by only 100 in either direction, but provided " + f);
            this.saturationAdjustment = f;
            return this;
        }

        public HslAdjustment build() {
            return new HslAdjustment(this.hueAdjustment, this.saturationAdjustment, this.lightnessAdjustment);
        }
    }

    @Override // androidx.media3.common.Effect
    public /* synthetic */ long getDurationAfterEffectApplied(long j) {
        return ik1.a(this, j);
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return this.hueAdjustmentDegrees == 0.0f && this.saturationAdjustment == 0.0f && this.lightnessAdjustment == 0.0f;
    }

    private HslAdjustment(float f, float f2, float f3) {
        this.hueAdjustmentDegrees = f;
        this.saturationAdjustment = f2;
        this.lightnessAdjustment = f3;
    }

    @Override // androidx.media3.effect.GlEffect
    public BaseGlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new HslShaderProgram(context, this, z);
    }
}
