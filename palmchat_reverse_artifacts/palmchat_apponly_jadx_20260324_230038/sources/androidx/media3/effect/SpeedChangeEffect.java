package androidx.media3.effect;

import android.content.Context;
import androidx.annotation.FloatRange;
import androidx.media3.common.audio.SpeedProvider;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.SpeedProviderUtil;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class SpeedChangeEffect implements GlEffect {
    private final SpeedProvider speedProvider;

    public SpeedChangeEffect(@FloatRange(from = 0.0d, fromInclusive = false) final float f) {
        Assertions.checkArgument(f > 0.0f);
        this.speedProvider = new SpeedProvider() { // from class: androidx.media3.effect.SpeedChangeEffect.1
            @Override // androidx.media3.common.audio.SpeedProvider
            public long getNextSpeedChangeTimeUs(long j) {
                return -9223372036854775807L;
            }

            @Override // androidx.media3.common.audio.SpeedProvider
            public float getSpeed(long j) {
                return f;
            }
        };
    }

    @Override // androidx.media3.common.Effect
    public long getDurationAfterEffectApplied(long j) {
        return SpeedProviderUtil.getDurationAfterSpeedProviderApplied(this.speedProvider, j);
    }

    @Override // androidx.media3.effect.GlEffect
    public boolean isNoOp(int i, int i2) {
        return this.speedProvider.getSpeed(0L) == 1.0f && this.speedProvider.getNextSpeedChangeTimeUs(0L) == -9223372036854775807L;
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return new SpeedChangeShaderProgram(this.speedProvider);
    }

    public SpeedChangeEffect(SpeedProvider speedProvider) {
        this.speedProvider = speedProvider;
    }
}
