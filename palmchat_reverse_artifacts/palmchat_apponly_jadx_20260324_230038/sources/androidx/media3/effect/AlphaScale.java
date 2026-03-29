package androidx.media3.effect;

import android.content.Context;
import androidx.annotation.FloatRange;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import defpackage.ik1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class AlphaScale implements GlEffect {
    private final float alphaScale;

    public AlphaScale(@FloatRange(from = 0.0d) float f) {
        Assertions.checkArgument(0.0f <= f);
        this.alphaScale = f;
    }

    @Override // androidx.media3.common.Effect
    public /* synthetic */ long getDurationAfterEffectApplied(long j) {
        return ik1.a(this, j);
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return this.alphaScale == 1.0f;
    }

    @Override // androidx.media3.effect.GlEffect
    public AlphaScaleShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new AlphaScaleShaderProgram(context, z, this.alphaScale);
    }
}
