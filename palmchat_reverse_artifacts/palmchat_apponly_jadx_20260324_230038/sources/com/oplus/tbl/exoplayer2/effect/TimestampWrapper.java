package com.oplus.tbl.exoplayer2.effect;

import android.content.Context;
import androidx.annotation.IntRange;
import com.oplus.tbl.exoplayer2.VideoFrameProcessingException;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public final class TimestampWrapper implements GlEffect {
    public final long endTimeUs;
    public final GlEffect glEffect;
    public final long startTimeUs;

    public TimestampWrapper(GlEffect glEffect, @IntRange(from = 0) long j, @IntRange(from = 0) long j2) {
        Assertions.checkArgument(j >= 0 && j2 >= 0, "startTimeUs and endTimeUs must be non-negative.");
        Assertions.checkArgument(j2 > j, "endTimeUs should be after startTimeUs.");
        this.glEffect = glEffect;
        this.startTimeUs = j;
        this.endTimeUs = j2;
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return this.glEffect.isNoOp(i, i2);
    }

    @Override // com.oplus.tbl.exoplayer2.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new TimestampWrapperShaderProgram(context, z, this);
    }
}
