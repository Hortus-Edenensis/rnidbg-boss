package com.oplus.tbl.exoplayer2.video;

import android.view.Surface;
import com.oplus.tbl.exoplayer2.Effect;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.util.Clock;
import com.oplus.tbl.exoplayer2.util.Size;
import com.oplus.tbl.exoplayer2.util.UnstableApi;
import com.oplus.tbl.exoplayer2.video.VideoSink;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@UnstableApi
public interface VideoSinkProvider {
    void clearOutputSurfaceInfo();

    VideoSink getSink();

    VideoFrameReleaseControl getVideoFrameReleaseControl();

    void initialize(Format format) throws VideoSink.VideoSinkException;

    boolean isInitialized();

    boolean isReachedEndPosition();

    void release();

    void setClock(Clock clock);

    void setExpectedEndPresentationTimeUs(long j);

    void setOutputColorInfo(boolean z, int i);

    void setOutputSurfaceInfo(Surface surface, Size size);

    void setPendingVideoEffects(List<Effect> list);

    void setStreamOffsetUs(long j);

    void setVideoEffects(List<Effect> list);

    void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener);

    void setVideoFrameReleaseControl(VideoFrameReleaseControl videoFrameReleaseControl);
}
