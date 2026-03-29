package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.UnstableApi;
import defpackage.ik1;
import defpackage.zb2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public abstract class SeparableConvolution implements GlEffect {
    private final float scaleHeight;
    private final float scaleWidth;

    public SeparableConvolution() {
        this(1.0f, 1.0f);
    }

    public abstract ConvolutionFunction1D getConvolution(long j);

    @Override // androidx.media3.common.Effect
    public /* synthetic */ long getDurationAfterEffectApplied(long j) {
        return ik1.a(this, j);
    }

    @Override // androidx.media3.effect.GlEffect
    public /* synthetic */ boolean isNoOp(int i, int i2) {
        return zb2.a(this, i, i2);
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new SeparableConvolutionShaderProgram(context, z, this, this.scaleWidth, this.scaleHeight);
    }

    public SeparableConvolution(float f, float f2) {
        this.scaleWidth = f;
        this.scaleHeight = f2;
    }
}
