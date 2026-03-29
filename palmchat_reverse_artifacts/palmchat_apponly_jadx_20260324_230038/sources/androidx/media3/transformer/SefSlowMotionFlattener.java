package androidx.media3.transformer;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.extractor.metadata.mp4.SlowMotionData;
import androidx.media3.extractor.metadata.mp4.SmtaMetadataEntry;
import com.google.common.collect.ImmutableList;
import com.ss.android.ttvecamera.TELogUtils;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class SefSlowMotionFlattener {

    @VisibleForTesting
    static final int INPUT_FRAME_RATE = 30;
    private static final int NAL_START_CODE_LENGTH = NalUnitUtil.NAL_START_CODE.length;
    private static final int TARGET_OUTPUT_FRAME_RATE = 30;
    private final float captureFrameRate;

    @Nullable
    private SegmentInfo currentSegmentInfo;
    private long frameTimeDeltaUs;
    private final int inputMaxLayer;
    private final String mimeType;

    @Nullable
    private SegmentInfo nextSegmentInfo;
    private final int normalSpeedMaxLayer;
    private final Iterator<SlowMotionData.Segment> segmentIterator;

    @Nullable
    private final SlowMotionData slowMotionData;
    private final byte[] scratch = new byte[NAL_START_CODE_LENGTH];
    private long lastSamplePresentationTimeUs = -9223372036854775807L;

    /* JADX INFO: compiled from: SearchBox */
    public static final class MetadataInfo {
        public float captureFrameRate = -3.4028235E38f;
        public int inputMaxLayer = -1;
        public int normalSpeedMaxLayer = -1;

        @Nullable
        public SlowMotionData slowMotionData;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class SegmentInfo {
        public final long endTimeUs;
        public final int maxLayer;
        public final int speedDivisor;
        public final long startTimeUs;

        public SegmentInfo(SlowMotionData.Segment segment, int i, int i2) {
            this.startTimeUs = Util.msToUs(segment.startTimeMs);
            this.endTimeUs = Util.msToUs(segment.endTimeMs);
            int i3 = segment.speedDivisor;
            this.speedDivisor = i3;
            this.maxLayer = getSlowMotionMaxLayer(i3, i, i2);
        }

        private static int getSlowMotionMaxLayer(int i, int i2, int i3) {
            int i4 = i;
            while (true) {
                if (i4 <= 0) {
                    break;
                }
                if ((i4 & 1) == 1) {
                    Assertions.checkState((i4 >> 1) == 0, "Invalid speed divisor: " + i);
                } else {
                    i3++;
                    i4 >>= 1;
                }
            }
            return Math.min(i3, i2);
        }
    }

    public SefSlowMotionFlattener(Format format) {
        MetadataInfo metadataInfo = getMetadataInfo(format.metadata);
        SlowMotionData slowMotionData = metadataInfo.slowMotionData;
        this.slowMotionData = slowMotionData;
        String str = (String) Assertions.checkNotNull(format.sampleMimeType);
        this.mimeType = str;
        if (slowMotionData != null) {
            Assertions.checkArgument(str.equals("video/avc") || str.equals("video/hevc"), "Unsupported MIME type for SEF slow motion video track: " + str);
        }
        Iterator<SlowMotionData.Segment> it = (slowMotionData != null ? slowMotionData.segments : ImmutableList.of()).iterator();
        this.segmentIterator = it;
        this.captureFrameRate = metadataInfo.captureFrameRate;
        int i = metadataInfo.inputMaxLayer;
        this.inputMaxLayer = i;
        int i2 = metadataInfo.normalSpeedMaxLayer;
        this.normalSpeedMaxLayer = i2;
        this.nextSegmentInfo = it.hasNext() ? new SegmentInfo(it.next(), i, i2) : null;
    }

    private void enterNextSegment() {
        if (this.currentSegmentInfo != null) {
            leaveCurrentSegment();
        }
        this.currentSegmentInfo = this.nextSegmentInfo;
        this.nextSegmentInfo = this.segmentIterator.hasNext() ? new SegmentInfo(this.segmentIterator.next(), this.inputMaxLayer, this.normalSpeedMaxLayer) : null;
    }

    private static MetadataInfo getMetadataInfo(@Nullable Metadata metadata) {
        MetadataInfo metadataInfo = new MetadataInfo();
        if (metadata == null) {
            return metadataInfo;
        }
        for (int i = 0; i < metadata.length(); i++) {
            Metadata.Entry entry = metadata.get(i);
            if (entry instanceof SmtaMetadataEntry) {
                SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) entry;
                metadataInfo.captureFrameRate = smtaMetadataEntry.captureFrameRate;
                metadataInfo.inputMaxLayer = smtaMetadataEntry.svcTemporalLayerCount - 1;
            } else if (entry instanceof SlowMotionData) {
                metadataInfo.slowMotionData = (SlowMotionData) entry;
            }
        }
        if (metadataInfo.slowMotionData == null) {
            return metadataInfo;
        }
        Assertions.checkState(metadataInfo.inputMaxLayer != -1, "SVC temporal layer count not found.");
        Assertions.checkState(metadataInfo.captureFrameRate != -3.4028235E38f, "Capture frame rate not found.");
        float f = metadataInfo.captureFrameRate;
        Assertions.checkState(f % 1.0f == 0.0f && f % 30.0f == 0.0f, "Invalid capture frame rate: " + metadataInfo.captureFrameRate);
        int i2 = ((int) metadataInfo.captureFrameRate) / 30;
        int i3 = metadataInfo.inputMaxLayer;
        while (true) {
            if (i3 < 0) {
                break;
            }
            if ((i2 & 1) == 1) {
                Assertions.checkState((i2 >> 1) == 0, "Could not compute normal speed max SVC layer for capture frame rate  " + metadataInfo.captureFrameRate);
                metadataInfo.normalSpeedMaxLayer = i3;
            } else {
                i2 >>= 1;
                i3--;
            }
        }
        return metadataInfo;
    }

    private void leaveCurrentSegment() {
        long j = this.frameTimeDeltaUs;
        SegmentInfo segmentInfo = this.currentSegmentInfo;
        this.frameTimeDeltaUs = j + ((segmentInfo.endTimeUs - segmentInfo.startTimeUs) * ((long) (segmentInfo.speedDivisor - 1)));
        this.currentSegmentInfo = null;
    }

    private boolean shouldKeepFrameForOutputValidity(int i, long j) {
        int i2;
        SegmentInfo segmentInfo = this.nextSegmentInfo;
        if (segmentInfo != null && i < (i2 = segmentInfo.maxLayer)) {
            long j2 = ((segmentInfo.startTimeUs - j) * 30) / 1000000;
            float f = (-(1 << (this.inputMaxLayer - i2))) + 0.45f;
            for (int i3 = 1; i3 < this.nextSegmentInfo.maxLayer && j2 < (1 << (this.inputMaxLayer - i3)) + f; i3++) {
                if (i <= i3) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dropOrTransformSample(ByteBuffer byteBuffer, long j) {
        int i;
        if (this.slowMotionData == null) {
            this.lastSamplePresentationTimeUs = j;
            return false;
        }
        int iPosition = byteBuffer.position();
        byteBuffer.position(NAL_START_CODE_LENGTH + iPosition);
        byteBuffer.get(this.scratch, 0, 4);
        if (this.mimeType.equals("video/avc")) {
            byte[] bArr = this.scratch;
            Assertions.checkState((bArr[0] & TELogUtils.DEBUG_LEVEL_V) == 14 && (((bArr[1] & UByte.MAX_VALUE) >> 7) == 1), "Missing SVC extension prefix NAL unit.");
            i = (this.scratch[3] & UByte.MAX_VALUE) >> 5;
        } else {
            if (!this.mimeType.equals("video/hevc")) {
                throw new IllegalStateException();
            }
            i = (this.scratch[1] & 7) - 1;
        }
        boolean zProcessCurrentFrame = processCurrentFrame(i, j);
        this.lastSamplePresentationTimeUs = getCurrentFrameOutputTimeUs(j);
        if (!zProcessCurrentFrame) {
            return true;
        }
        byteBuffer.position(iPosition);
        return false;
    }

    @VisibleForTesting
    public long getCurrentFrameOutputTimeUs(long j) {
        long j2 = this.frameTimeDeltaUs + j;
        SegmentInfo segmentInfo = this.currentSegmentInfo;
        if (segmentInfo != null) {
            j2 += (j - segmentInfo.startTimeUs) * ((long) (segmentInfo.speedDivisor - 1));
        }
        return Math.round((j2 * 30) / this.captureFrameRate);
    }

    public long getSamplePresentationTimeUs() {
        Assertions.checkState(this.lastSamplePresentationTimeUs != -9223372036854775807L);
        return this.lastSamplePresentationTimeUs;
    }

    @VisibleForTesting
    public boolean processCurrentFrame(int i, long j) {
        SegmentInfo segmentInfo;
        while (true) {
            segmentInfo = this.nextSegmentInfo;
            if (segmentInfo == null || j < segmentInfo.endTimeUs) {
                break;
            }
            enterNextSegment();
        }
        if (segmentInfo == null || j < segmentInfo.startTimeUs) {
            SegmentInfo segmentInfo2 = this.currentSegmentInfo;
            if (segmentInfo2 != null && j >= segmentInfo2.endTimeUs) {
                leaveCurrentSegment();
            }
        } else {
            enterNextSegment();
        }
        SegmentInfo segmentInfo3 = this.currentSegmentInfo;
        return i <= (segmentInfo3 != null ? segmentInfo3.maxLayer : this.normalSpeedMaxLayer) || shouldKeepFrameForOutputValidity(i, j);
    }
}
