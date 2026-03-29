package com.oplus.tbl.exoplayer2.source.ads;

import androidx.annotation.VisibleForTesting;
import com.oplus.tbl.exoplayer2.Timeline;
import com.oplus.tbl.exoplayer2.source.ForwardingTimeline;
import com.oplus.tbl.exoplayer2.util.Assertions;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@VisibleForTesting(otherwise = 3)
public final class SinglePeriodAdTimeline extends ForwardingTimeline {
    private final AdPlaybackState adPlaybackState;

    public SinglePeriodAdTimeline(Timeline timeline, AdPlaybackState adPlaybackState) {
        super(timeline);
        Assertions.checkState(timeline.getPeriodCount() == 1);
        Assertions.checkState(timeline.getWindowCount() == 1);
        this.adPlaybackState = adPlaybackState;
    }

    @Override // com.oplus.tbl.exoplayer2.source.ForwardingTimeline, com.oplus.tbl.exoplayer2.Timeline
    public Timeline.Period getPeriod(int i, Timeline.Period period, boolean z) {
        this.timeline.getPeriod(i, period, z);
        long j = period.durationUs;
        if (j == -9223372036854775807L) {
            j = this.adPlaybackState.contentDurationUs;
        }
        period.set(period.id, period.uid, period.windowIndex, j, period.getPositionInWindowUs(), this.adPlaybackState);
        return period;
    }
}
