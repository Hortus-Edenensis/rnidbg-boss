package com.oplus.tbl.exoplayer2.source;

import com.oplus.tbl.exoplayer2.SeekParameters;
import com.oplus.tbl.exoplayer2.offline.StreamKey;
import com.oplus.tbl.exoplayer2.source.SequenceableLoader;
import com.oplus.tbl.exoplayer2.trackselection.ExoTrackSelection;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface MediaPeriod extends SequenceableLoader {

    /* JADX INFO: compiled from: SearchBox */
    public interface Callback extends SequenceableLoader.Callback<MediaPeriod> {
        void onPrepared(MediaPeriod mediaPeriod);
    }

    @Override // com.oplus.tbl.exoplayer2.source.SequenceableLoader
    boolean continueLoading(long j);

    void discardBuffer(long j, boolean z);

    long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters);

    @Override // com.oplus.tbl.exoplayer2.source.SequenceableLoader
    long getBufferedPositionUs();

    long getLargestQueuedTimeUsByType(int i);

    long getNextKeyFramePositionUs(long j);

    @Override // com.oplus.tbl.exoplayer2.source.SequenceableLoader
    long getNextLoadPositionUs();

    List<StreamKey> getStreamKeys(List<ExoTrackSelection> list);

    TrackGroupArray getTrackGroups();

    @Override // com.oplus.tbl.exoplayer2.source.SequenceableLoader
    boolean isLoading();

    void maybeThrowPrepareError() throws IOException;

    void prepare(Callback callback, long j);

    long readDiscontinuity();

    @Override // com.oplus.tbl.exoplayer2.source.SequenceableLoader
    void reevaluateBuffer(long j);

    long seekToUs(long j);

    boolean seekToUsInGop(long j, boolean z);

    long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j);
}
