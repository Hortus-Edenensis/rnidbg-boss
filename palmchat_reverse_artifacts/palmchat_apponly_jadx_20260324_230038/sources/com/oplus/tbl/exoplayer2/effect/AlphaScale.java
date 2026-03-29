package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import androidx.annotation.FloatRange;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public final class AlphaScale implements GlEffect {
    private final float alphaScale;

    public AlphaScale(@FloatRange(from = 0.0d) float f) {
        Assertions.checkArgument(0.0f <= f);
        this.alphaScale = f;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return this.alphaScale == 1.0f;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public AlphaScaleShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new AlphaScaleShaderProgram(context, z, this.alphaScale);
    }
}
