package com.oplus.tbl.exoplayer2.extractor.mp3;

import com.oplus.tbl.exoplayer2.audio.MpegAudioUtil;
import com.oplus.tbl.exoplayer2.extractor.ConstantBitrateSeekMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class ConstantBitrateSeeker extends ConstantBitrateSeekMap implements Seeker {
    public ConstantBitrateSeeker(long j, long j2, MpegAudioUtil.Header header) {
        super(j, j2, header.bitrate, header.frameSize);
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return -1L;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        return getTimeUsAtPosition(j);
    }
}
