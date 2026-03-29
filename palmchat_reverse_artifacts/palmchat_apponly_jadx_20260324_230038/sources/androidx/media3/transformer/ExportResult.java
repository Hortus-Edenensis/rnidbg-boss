package androidx.media3.transformer;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import j$.util.Objects;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class ExportResult {
    public static final int CONVERSION_PROCESS_NA = 0;
    public static final int CONVERSION_PROCESS_TRANSCODED = 1;
    public static final int CONVERSION_PROCESS_TRANSMUXED = 2;
    public static final int CONVERSION_PROCESS_TRANSMUXED_AND_TRANSCODED = 3;
    public static final int OPTIMIZATION_ABANDONED_KEYFRAME_PLACEMENT_OPTIMAL_FOR_TRIM = 2;
    public static final int OPTIMIZATION_ABANDONED_OTHER = 4;
    public static final int OPTIMIZATION_ABANDONED_TRIM_AND_TRANSCODING_TRANSFORMATION_REQUESTED = 3;
    public static final int OPTIMIZATION_FAILED_EXTRACTION_FAILED = 5;
    public static final int OPTIMIZATION_FAILED_FORMAT_MISMATCH = 6;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_SUCCEEDED = 1;
    public final int audioConversionProcess;

    @Nullable
    public final String audioEncoderName;

    @Nullable
    public final String audioMimeType;
    public final int averageAudioBitrate;
    public final int averageVideoBitrate;
    public final int channelCount;

    @Nullable
    public final ColorInfo colorInfo;
    public final long durationMs;

    @Nullable
    public final ExportException exportException;
    public final long fileSizeBytes;
    public final int height;
    public final int optimizationResult;
    final ImmutableList<ProcessedInput> processedInputs;
    public final int sampleRate;
    public final int videoConversionProcess;

    @Nullable
    public final String videoEncoderName;
    public final int videoFrameCount;

    @Nullable
    public final String videoMimeType;
    public final int width;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Builder {

        @Nullable
        private String audioEncoderName;

        @Nullable
        private String audioMimeType;
        private int averageAudioBitrate;
        private int averageVideoBitrate;
        private int channelCount;

        @Nullable
        private ColorInfo colorInfo;
        private long durationMs;

        @Nullable
        private ExportException exportException;
        private long fileSizeBytes;
        private int height;
        private int optimizationResult;
        private ImmutableList.a<ProcessedInput> processedInputsBuilder;
        private int sampleRate;

        @Nullable
        private String videoEncoderName;
        private int videoFrameCount;

        @Nullable
        private String videoMimeType;
        private int width;

        public Builder() {
            reset();
        }

        public Builder addProcessedInputs(List<ProcessedInput> list) {
            this.processedInputsBuilder.l(list);
            return this;
        }

        public ExportResult build() {
            return new ExportResult(this.processedInputsBuilder.e(), this.durationMs, this.fileSizeBytes, this.averageAudioBitrate, this.channelCount, this.sampleRate, this.audioEncoderName, this.audioMimeType, this.averageVideoBitrate, this.colorInfo, this.height, this.width, this.videoFrameCount, this.videoEncoderName, this.videoMimeType, this.optimizationResult, this.exportException);
        }

        public void reset() {
            this.processedInputsBuilder = new ImmutableList.a<>();
            this.durationMs = -9223372036854775807L;
            this.fileSizeBytes = -1L;
            this.averageAudioBitrate = C.RATE_UNSET_INT;
            this.channelCount = -1;
            this.sampleRate = C.RATE_UNSET_INT;
            this.audioEncoderName = null;
            this.averageVideoBitrate = C.RATE_UNSET_INT;
            this.colorInfo = null;
            this.height = -1;
            this.width = -1;
            this.videoFrameCount = 0;
            this.videoEncoderName = null;
            this.optimizationResult = 0;
            this.exportException = null;
        }

        public Builder setAudioEncoderName(@Nullable String str) {
            this.audioEncoderName = str;
            return this;
        }

        public Builder setAudioMimeType(@Nullable String str) {
            this.audioMimeType = str;
            return this;
        }

        public Builder setAverageAudioBitrate(int i) {
            Assertions.checkArgument(i > 0 || i == -2147483647);
            this.averageAudioBitrate = i;
            return this;
        }

        public Builder setAverageVideoBitrate(int i) {
            Assertions.checkArgument(i > 0 || i == -2147483647);
            this.averageVideoBitrate = i;
            return this;
        }

        public Builder setChannelCount(int i) {
            Assertions.checkArgument(i > 0 || i == -1);
            this.channelCount = i;
            return this;
        }

        public Builder setColorInfo(@Nullable ColorInfo colorInfo) {
            this.colorInfo = colorInfo;
            return this;
        }

        public Builder setDurationMs(long j) {
            Assertions.checkArgument(j >= 0 || j == -9223372036854775807L);
            this.durationMs = j;
            return this;
        }

        public Builder setExportException(@Nullable ExportException exportException) {
            this.exportException = exportException;
            return this;
        }

        public Builder setFileSizeBytes(long j) {
            Assertions.checkArgument(j > 0 || j == -1, "Invalid file size = " + j);
            this.fileSizeBytes = j;
            return this;
        }

        public Builder setHeight(int i) {
            Assertions.checkArgument(i > 0 || i == -1);
            this.height = i;
            return this;
        }

        public Builder setOptimizationResult(int i) {
            this.optimizationResult = i;
            return this;
        }

        public Builder setSampleRate(int i) {
            Assertions.checkArgument(i > 0 || i == -2147483647);
            this.sampleRate = i;
            return this;
        }

        public Builder setVideoEncoderName(@Nullable String str) {
            this.videoEncoderName = str;
            return this;
        }

        public Builder setVideoFrameCount(int i) {
            Assertions.checkArgument(i >= 0);
            this.videoFrameCount = i;
            return this;
        }

        public Builder setVideoMimeType(@Nullable String str) {
            this.videoMimeType = str;
            return this;
        }

        public Builder setWidth(int i) {
            Assertions.checkArgument(i > 0 || i == -1);
            this.width = i;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class ProcessedInput {

        @Nullable
        public final String audioDecoderName;

        @Nullable
        public final Format audioFormat;
        public final long durationUs;
        public final MediaItem mediaItem;

        @Nullable
        public final String videoDecoderName;

        @Nullable
        public final Format videoFormat;

        public ProcessedInput(MediaItem mediaItem, long j, @Nullable Format format, @Nullable Format format2, @Nullable String str, @Nullable String str2) {
            this.mediaItem = mediaItem;
            this.durationUs = j;
            this.audioFormat = format;
            this.videoFormat = format2;
            this.audioDecoderName = str;
            this.videoDecoderName = str2;
        }
    }

    private static int getConversionProcess(@Nullable String str, int i, List<ProcessedInput> list, int i2) {
        int i3 = 0;
        if (str == null) {
            return 0;
        }
        if (i == 1) {
            return i2 == 1 ? 2 : 3;
        }
        for (ProcessedInput processedInput : list) {
            if ((i2 == 1 ? processedInput.audioDecoderName : processedInput.videoDecoderName) == null) {
                if (i3 == 1) {
                    return 3;
                }
                i3 = 2;
            } else {
                if (i3 == 2) {
                    return 3;
                }
                i3 = 1;
            }
        }
        return i3;
    }

    public Builder buildUpon() {
        return new Builder().addProcessedInputs(this.processedInputs).setDurationMs(this.durationMs).setFileSizeBytes(this.fileSizeBytes).setAverageAudioBitrate(this.averageAudioBitrate).setChannelCount(this.channelCount).setSampleRate(this.sampleRate).setAudioEncoderName(this.audioEncoderName).setAudioMimeType(this.audioMimeType).setAverageVideoBitrate(this.averageVideoBitrate).setColorInfo(this.colorInfo).setHeight(this.height).setWidth(this.width).setVideoFrameCount(this.videoFrameCount).setVideoEncoderName(this.videoEncoderName).setVideoMimeType(this.videoMimeType).setOptimizationResult(this.optimizationResult).setExportException(this.exportException);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExportResult)) {
            return false;
        }
        ExportResult exportResult = (ExportResult) obj;
        return Objects.equals(this.processedInputs, exportResult.processedInputs) && this.durationMs == exportResult.durationMs && this.fileSizeBytes == exportResult.fileSizeBytes && this.averageAudioBitrate == exportResult.averageAudioBitrate && this.channelCount == exportResult.channelCount && this.sampleRate == exportResult.sampleRate && Objects.equals(this.audioEncoderName, exportResult.audioEncoderName) && Objects.equals(this.audioMimeType, exportResult.audioMimeType) && this.averageVideoBitrate == exportResult.averageVideoBitrate && Objects.equals(this.colorInfo, exportResult.colorInfo) && this.height == exportResult.height && this.width == exportResult.width && this.videoFrameCount == exportResult.videoFrameCount && Objects.equals(this.videoEncoderName, exportResult.videoEncoderName) && Objects.equals(this.videoMimeType, exportResult.videoMimeType) && this.optimizationResult == exportResult.optimizationResult && Objects.equals(this.exportException, exportResult.exportException);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((Objects.hashCode(this.processedInputs) * 31) + ((int) this.durationMs)) * 31) + ((int) this.fileSizeBytes)) * 31) + this.averageAudioBitrate) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + Objects.hashCode(this.audioEncoderName)) * 31) + Objects.hashCode(this.audioMimeType)) * 31) + this.averageVideoBitrate) * 31) + Objects.hashCode(this.colorInfo)) * 31) + this.height) * 31) + this.width) * 31) + this.videoFrameCount) * 31) + Objects.hashCode(this.videoEncoderName)) * 31) + Objects.hashCode(this.videoMimeType)) * 31) + this.optimizationResult) * 31) + Objects.hashCode(this.exportException);
    }

    private ExportResult(ImmutableList<ProcessedInput> immutableList, long j, long j2, int i, int i2, int i3, @Nullable String str, @Nullable String str2, int i4, @Nullable ColorInfo colorInfo, int i5, int i6, int i7, @Nullable String str3, @Nullable String str4, int i8, @Nullable ExportException exportException) {
        this.processedInputs = immutableList;
        this.durationMs = j;
        this.fileSizeBytes = j2;
        this.averageAudioBitrate = i;
        this.channelCount = i2;
        this.sampleRate = i3;
        this.audioEncoderName = str;
        this.audioMimeType = str2;
        this.averageVideoBitrate = i4;
        this.colorInfo = colorInfo;
        this.height = i5;
        this.width = i6;
        this.videoFrameCount = i7;
        this.videoEncoderName = str3;
        this.videoMimeType = str4;
        this.optimizationResult = i8;
        this.exportException = exportException;
        this.audioConversionProcess = getConversionProcess(str2, i8, immutableList, 1);
        this.videoConversionProcess = getConversionProcess(str4, i8, immutableList, 2);
    }
}
