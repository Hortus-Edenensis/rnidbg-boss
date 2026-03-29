package androidx.media3.effect;

import android.content.Context;
import androidx.annotation.IntRange;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import defpackage.ik1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
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

    @Override // androidx.media3.common.Effect
    public /* synthetic */ long getDurationAfterEffectApplied(long j) {
        return ik1.a(this, j);
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return this.glEffect.isNoOp(i, i2);
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new TimestampWrapperShaderProgram(context, z, this);
    }
}
