package androidx.media3.effect;

import android.content.Context;
import androidx.media3.common.VideoFrameProcessingException;
import defpackage.ik1;
import defpackage.zb2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class ThumbnailStripEffect implements GlEffect {
    private int currentThumbnailIndex;
    final int stripHeight;
    final int stripWidth;
    private final List<Long> timestampsMs = new ArrayList();

    public ThumbnailStripEffect(int i, int i2) {
        this.stripWidth = i;
        this.stripHeight = i2;
    }

    @Override // androidx.media3.common.Effect
    public /* synthetic */ long getDurationAfterEffectApplied(long j) {
        return ik1.a(this, j);
    }

    public int getNextThumbnailIndex() {
        return this.currentThumbnailIndex;
    }

    public long getNextTimestampMs() {
        if (isDone()) {
            return Long.MIN_VALUE;
        }
        return this.timestampsMs.get(this.currentThumbnailIndex).longValue();
    }

    public int getNumberOfThumbnails() {
        return this.timestampsMs.size();
    }

    public boolean isDone() {
        return this.currentThumbnailIndex >= this.timestampsMs.size();
    }

    @Override // androidx.media3.effect.GlEffect
    public /* synthetic */ boolean isNoOp(int i, int i2) {
        return zb2.a(this, i, i2);
    }

    public void onThumbnailDrawn() {
        this.currentThumbnailIndex++;
    }

    public void setTimestampsMs(List<Long> list) {
        this.timestampsMs.clear();
        this.timestampsMs.addAll(list);
        this.currentThumbnailIndex = 0;
    }

    @Override // androidx.media3.effect.GlEffect
    public ThumbnailStripShaderProgram toGlShaderProgram(Context context, boolean z) throws VideoFrameProcessingException {
        return new ThumbnailStripShaderProgram(context, z, this);
    }
}
