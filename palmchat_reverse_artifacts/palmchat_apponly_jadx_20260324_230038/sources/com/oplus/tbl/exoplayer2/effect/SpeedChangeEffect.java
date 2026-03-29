package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import androidx.annotation.FloatRange;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public final class SpeedChangeEffect implements GlEffect {
    private final float speed;

    public SpeedChangeEffect(@FloatRange(from = 0.0d, fromInclusive = false) float f) {
        Assertions.checkArgument(f > 0.0f);
        this.speed = f;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return this.speed == 1.0f;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new SpeedChangeShaderProgram(this.speed);
    }
}
