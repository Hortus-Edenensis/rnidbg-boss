package com.oplus.tbl.exoplayer2.mediacodec;

import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.audio.MpegAudioUtil;
import com.oplus.tbl.exoplayer2.decoder.DecoderInputBuffer;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.Log;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class C2Mp3TimestampTracker {
    private static final long DECODER_DELAY_SAMPLES = 529;
    private static final String TAG = "C2Mp3TimestampTracker";
    private long anchorTimestampUs;
    private long processedSamples;
    private boolean seenInvalidMpegAudioHeader;

    private long getProcessedDurationUs(Format format) {
        return (this.processedSamples * 1000000) / ((long) format.sampleRate);
    }

    public void reset() {
        this.processedSamples = 0L;
        this.anchorTimestampUs = 0L;
        this.seenInvalidMpegAudioHeader = false;
    }

    public long updateAndGetPresentationTimeUs(Format format, DecoderInputBuffer decoderInputBuffer) {
        if (this.seenInvalidMpegAudioHeader) {
            return decoderInputBuffer.timeUs;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.data);
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            i = (i << 8) | (byteBuffer.get(i2) & UByte.MAX_VALUE);
        }
        int mpegAudioFrameSampleCount = MpegAudioUtil.parseMpegAudioFrameSampleCount(i);
        if (mpegAudioFrameSampleCount == -1) {
            this.seenInvalidMpegAudioHeader = true;
            Log.w(TAG, "MPEG audio header is invalid.");
            return decoderInputBuffer.timeUs;
        }
        if (this.processedSamples != 0) {
            long processedDurationUs = getProcessedDurationUs(format);
            this.processedSamples += (long) mpegAudioFrameSampleCount;
            return this.anchorTimestampUs + processedDurationUs;
        }
        long j = decoderInputBuffer.timeUs;
        this.anchorTimestampUs = j;
        this.processedSamples = ((long) mpegAudioFrameSampleCount) - DECODER_DELAY_SAMPLES;
        return j;
    }
}
