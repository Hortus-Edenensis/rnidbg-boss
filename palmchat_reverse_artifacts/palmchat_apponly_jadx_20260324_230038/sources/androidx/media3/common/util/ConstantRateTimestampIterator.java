package androidx.media3.common.util;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class ConstantRateTimestampIterator implements TimestampIterator {
    private final long endPositionUs;
    private final float frameRate;
    private int framesAdded;
    private final double framesDurationUs;
    private final long startPositionUs;
    private final int totalNumberOfFramesToAdd;

    public ConstantRateTimestampIterator(@IntRange(from = 1) long j, @FloatRange(from = 0.0d, fromInclusive = false) float f) {
        this(0L, j, f);
    }

    private long getTimestampUsAfter(int i) {
        long jRound = this.startPositionUs + Math.round(this.framesDurationUs * ((double) i));
        Assertions.checkState(jRound >= 0);
        return jRound;
    }

    @Override // androidx.media3.common.util.TimestampIterator
    public long getLastTimestampUs() {
        int i = this.totalNumberOfFramesToAdd;
        if (i == 0) {
            return -9223372036854775807L;
        }
        return getTimestampUsAfter(i - 1);
    }

    @Override // androidx.media3.common.util.TimestampIterator
    public boolean hasNext() {
        return this.framesAdded < this.totalNumberOfFramesToAdd;
    }

    @Override // androidx.media3.common.util.TimestampIterator
    public long next() {
        Assertions.checkState(hasNext());
        int i = this.framesAdded;
        this.framesAdded = i + 1;
        return getTimestampUsAfter(i);
    }

    public ConstantRateTimestampIterator(@IntRange(from = 0) long j, @IntRange(from = 1) long j2, @FloatRange(from = 0.0d, fromInclusive = false) float f) {
        boolean z = false;
        Assertions.checkArgument(j2 > 0);
        Assertions.checkArgument(f > 0.0f);
        if (0 <= j && j < j2) {
            z = true;
        }
        Assertions.checkArgument(z);
        this.startPositionUs = j;
        this.endPositionUs = j2;
        this.frameRate = f;
        this.totalNumberOfFramesToAdd = Math.max(Math.round(((j2 - j) / 1000000.0f) * f), 1);
        this.framesDurationUs = 1000000.0f / f;
    }

    @Override // androidx.media3.common.util.TimestampIterator
    public ConstantRateTimestampIterator copyOf() {
        return new ConstantRateTimestampIterator(this.startPositionUs, this.endPositionUs, this.frameRate);
    }
}
