package androidx.media3.transformer;

import android.util.SparseLongArray;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.MediaClock;
import defpackage.we3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class TransformerMediaClock implements MediaClock {
    private long minTrackTimeUs;
    private final SparseLongArray trackTypeToTimeUs = new SparseLongArray();

    @Override // androidx.media3.exoplayer.MediaClock
    public PlaybackParameters getPlaybackParameters() {
        return PlaybackParameters.DEFAULT;
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public long getPositionUs() {
        return this.minTrackTimeUs;
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public /* synthetic */ boolean hasSkippedSilenceSinceLastCall() {
        return we3.a(this);
    }

    public void updateTimeForTrackType(int i, long j) {
        long j2 = this.trackTypeToTimeUs.get(i, -9223372036854775807L);
        if (j2 == -9223372036854775807L || j > j2) {
            this.trackTypeToTimeUs.put(i, j);
            if (j2 == -9223372036854775807L || j2 == this.minTrackTimeUs) {
                this.minTrackTimeUs = Util.minValue(this.trackTypeToTimeUs);
            }
        }
    }

    @Override // androidx.media3.exoplayer.MediaClock
    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
    }
}
