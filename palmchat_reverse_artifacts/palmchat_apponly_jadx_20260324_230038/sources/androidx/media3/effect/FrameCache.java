package androidx.media3.effect;

import android.content.Context;
import androidx.annotation.IntRange;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import defpackage.ik1;
import defpackage.zb2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class FrameCache implements GlEffect {
    public final int capacity;

    public FrameCache(@IntRange(from = 1, to = 8) int i) {
        Assertions.checkArgument(i > 0 && i < 9);
        this.capacity = i;
    }

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
        return new FrameCacheGlShaderProgram(context, this.capacity, z);
    }
}
