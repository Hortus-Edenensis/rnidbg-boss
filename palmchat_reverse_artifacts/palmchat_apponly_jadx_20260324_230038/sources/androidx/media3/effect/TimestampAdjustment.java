package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.audio.SpeedProvider;
import androidx.media3.common.util.SpeedProviderUtil;
import androidx.media3.common.util.TimestampConsumer;
import androidx.media3.common.util.UnstableApi;
import defpackage.zb2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class TimestampAdjustment implements GlEffect {
    public final SpeedProvider speedProvider;
    public final TimestampMap timestampMap;

    /* JADX INFO: compiled from: SearchBox */
    public interface TimestampMap {
        void calculateOutputTimeUs(long j, TimestampConsumer timestampConsumer);
    }

    public TimestampAdjustment(TimestampMap timestampMap, SpeedProvider speedProvider) {
        this.timestampMap = timestampMap;
        this.speedProvider = speedProvider;
    }

    @Override // androidx.media3.common.Effect
    public long getDurationAfterEffectApplied(long j) {
        return SpeedProviderUtil.getDurationAfterSpeedProviderApplied(this.speedProvider, j);
    }

    @Override // androidx.media3.effect.GlEffect
    public /* synthetic */ boolean isNoOp(int i, int i2) {
        return zb2.a(this, i, i2);
    }

    @Override // androidx.media3.effect.GlEffect
    public GlShaderProgram toGlShaderProgram(Context context, boolean z) {
        return new TimestampAdjustmentShaderProgram(this.timestampMap);
    }
}
