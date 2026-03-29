package androidx.media3.transformer;

import android.content.Context;
import android.hardware.DataSpace;
import android.media.metrics.EditingEndedEvent;
import android.media.metrics.EditingSession;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaItemInfo;
import android.media.metrics.MediaMetricsManager;
import android.util.Size;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.transformer.ExportResult;
import com.google.common.collect.ImmutableList;
import defpackage.bj3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(35)
final class EditingMetricsCollector {
    private static final SparseIntArray DATA_SPACE_RANGE_CONVERSION_MAP;
    private static final SparseIntArray DATA_SPACE_STANDARD_CONVERSION_MAP;
    private static final SparseIntArray DATA_SPACE_TRANSFER_CONVERSION_MAP;
    private static final SparseIntArray ERROR_CODE_CONVERSION_MAP;
    private static final int SUCCESS_PROGRESS_PERCENTAGE = 100;
    private static final String TAG = "EditingMetricsCollector";
    private final String exporterName;
    private final MetricsReporter metricsReporter;

    @Nullable
    private final String muxerName;
    private final long startTimeMs = Clock.DEFAULT.elapsedRealtime();

    /* JADX INFO: compiled from: SearchBox */
    public static final class DefaultMetricsReporter implements MetricsReporter {

        @Nullable
        private EditingSession editingSession;
        private boolean metricsReported;

        /* JADX INFO: compiled from: SearchBox */
        public static final class Factory implements MetricsReporter.Factory {
            private final Context context;

            public Factory(Context context) {
                this.context = context;
            }

            @Override // androidx.media3.transformer.EditingMetricsCollector.MetricsReporter.Factory
            public MetricsReporter create() {
                return new DefaultMetricsReporter(this.context);
            }
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            EditingSession editingSession = this.editingSession;
            if (editingSession != null) {
                editingSession.close();
                this.editingSession = null;
            }
        }

        @Nullable
        public LogSessionId getLogSessionId() {
            EditingSession editingSession = this.editingSession;
            if (editingSession != null) {
                return editingSession.getSessionId();
            }
            return null;
        }

        @Override // androidx.media3.transformer.EditingMetricsCollector.MetricsReporter
        public void reportMetrics(EditingEndedEvent editingEndedEvent) {
            EditingSession editingSession;
            if (this.metricsReported || (editingSession = this.editingSession) == null) {
                return;
            }
            editingSession.reportEditingEndedEvent(editingEndedEvent);
            this.metricsReported = true;
        }

        private DefaultMetricsReporter(Context context) {
            MediaMetricsManager mediaMetricsManagerA = bj3.a(context.getSystemService("media_metrics"));
            if (mediaMetricsManagerA != null) {
                this.editingSession = mediaMetricsManagerA.createEditingSession();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface MetricsReporter extends AutoCloseable {

        /* JADX INFO: compiled from: SearchBox */
        public interface Factory {
            MetricsReporter create();
        }

        void reportMetrics(EditingEndedEvent editingEndedEvent);
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ERROR_CODE_CONVERSION_MAP = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        DATA_SPACE_STANDARD_CONVERSION_MAP = sparseIntArray2;
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        DATA_SPACE_RANGE_CONVERSION_MAP = sparseIntArray3;
        SparseIntArray sparseIntArray4 = new SparseIntArray();
        DATA_SPACE_TRANSFER_CONVERSION_MAP = sparseIntArray4;
        sparseIntArray.put(1000, 1);
        sparseIntArray.put(1001, 2);
        sparseIntArray.put(2000, 3);
        sparseIntArray.put(2001, 4);
        sparseIntArray.put(2002, 5);
        sparseIntArray.put(2003, 3);
        sparseIntArray.put(2004, 6);
        sparseIntArray.put(2005, 7);
        sparseIntArray.put(2006, 8);
        sparseIntArray.put(2007, 9);
        sparseIntArray.put(2008, 10);
        sparseIntArray.put(3001, 11);
        sparseIntArray.put(3002, 12);
        sparseIntArray.put(3003, 13);
        sparseIntArray.put(4001, 14);
        sparseIntArray.put(4002, 15);
        sparseIntArray.put(4003, 16);
        sparseIntArray.put(5001, 17);
        sparseIntArray.put(6001, 18);
        sparseIntArray.put(7001, 19);
        sparseIntArray.put(ExportException.ERROR_CODE_MUXING_TIMEOUT, 2);
        sparseIntArray2.put(-1, 0);
        sparseIntArray2.put(2, 131072);
        sparseIntArray2.put(1, 65536);
        sparseIntArray2.put(6, 393216);
        sparseIntArray3.put(-1, 0);
        sparseIntArray3.put(2, 268435456);
        sparseIntArray3.put(1, 134217728);
        sparseIntArray4.put(-1, 0);
        sparseIntArray4.put(1, 4194304);
        sparseIntArray4.put(3, 12582912);
        sparseIntArray4.put(2, 8388608);
        sparseIntArray4.put(10, 16777216);
        sparseIntArray4.put(6, 29360128);
        sparseIntArray4.put(7, 33554432);
    }

    public EditingMetricsCollector(MetricsReporter metricsReporter, String str, @Nullable String str2) {
        this.metricsReporter = metricsReporter;
        this.exporterName = str;
        this.muxerName = str2;
    }

    private EditingEndedEvent.Builder createEditingEndedEventBuilder(int i) {
        EditingEndedEvent.Builder exporterName = new EditingEndedEvent.Builder(i).setTimeSinceCreatedMillis(Clock.DEFAULT.elapsedRealtime() - this.startTimeMs).setExporterName(this.exporterName);
        String str = this.muxerName;
        if (str != null) {
            exporterName.setMuxerName(str);
        }
        return exporterName;
    }

    private static long getDataTypes(@Nullable String str) {
        long j = MimeTypes.isAudio(str) ? 4L : 0L;
        if (MimeTypes.isVideo(str)) {
            j |= 2;
        }
        return MimeTypes.isImage(str) ? j | 1 : j;
    }

    private static int getEditingEndedEventErrorCode(int i) {
        return ERROR_CODE_CONVERSION_MAP.get(i, 1);
    }

    private static List<MediaItemInfo> getInputMediaItemInfos(ImmutableList<ExportResult.ProcessedInput> immutableList) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < immutableList.size(); i++) {
            ExportResult.ProcessedInput processedInput = immutableList.get(i);
            MediaItemInfo.Builder builder = new MediaItemInfo.Builder();
            builder.setClipDurationMillis(Util.usToMs(processedInput.durationUs));
            String str = processedInput.videoDecoderName;
            if (str != null) {
                builder.addCodecName(str);
            }
            String str2 = processedInput.audioDecoderName;
            if (str2 != null) {
                builder.addCodecName(str2);
            }
            Format format = processedInput.videoFormat;
            if (format != null) {
                String str3 = format.containerMimeType;
                if (str3 != null) {
                    builder.setContainerMimeType(str3);
                }
                String str4 = format.sampleMimeType;
                if (str4 != null) {
                    builder.addSampleMimeType(str4);
                    builder.addDataType(getDataTypes(format.sampleMimeType));
                }
                float f = format.frameRate;
                if (f != -1.0f) {
                    builder.setVideoFrameRate(f);
                }
                int i2 = format.width;
                if (i2 == -1) {
                    i2 = -1;
                }
                int i3 = format.height;
                if (i3 == -1) {
                    i3 = -1;
                }
                builder.setVideoSize(new Size(i2, i3));
                ColorInfo colorInfo = format.colorInfo;
                if (colorInfo != null) {
                    builder.setVideoDataSpace(getVideoDataSpace(colorInfo));
                }
            }
            Format format2 = processedInput.audioFormat;
            if (format2 != null) {
                String str5 = format2.sampleMimeType;
                if (str5 != null) {
                    builder.addSampleMimeType(str5);
                    builder.addDataType(getDataTypes(format2.sampleMimeType));
                }
                int i4 = format2.channelCount;
                if (i4 != -1) {
                    builder.setAudioChannelCount(i4);
                }
                int i5 = format2.sampleRate;
                if (i5 != -1) {
                    builder.setAudioSampleRateHz(i5);
                }
            }
            arrayList.add(builder.build());
        }
        return arrayList;
    }

    private static MediaItemInfo getOutputMediaItemInfo(ExportResult exportResult) {
        MediaItemInfo.Builder builder = new MediaItemInfo.Builder();
        long j = exportResult.durationMs;
        if (j != -9223372036854775807L) {
            builder.setDurationMillis(j);
        }
        String str = exportResult.audioMimeType;
        if (str != null) {
            builder.addSampleMimeType(str);
            builder.addDataType(getDataTypes(exportResult.audioMimeType));
        }
        String str2 = exportResult.videoMimeType;
        if (str2 != null) {
            builder.addSampleMimeType(str2);
            builder.addDataType(getDataTypes(exportResult.videoMimeType));
        }
        int i = exportResult.channelCount;
        if (i != -1) {
            builder.setAudioChannelCount(i);
        }
        int i2 = exportResult.sampleRate;
        if (i2 != -2147483647) {
            builder.setAudioSampleRateHz(i2);
        }
        String str3 = exportResult.audioEncoderName;
        if (str3 != null) {
            builder.addCodecName(str3);
        }
        String str4 = exportResult.videoEncoderName;
        if (str4 != null) {
            builder.addCodecName(str4);
        }
        builder.setVideoSampleCount(exportResult.videoFrameCount);
        int i3 = exportResult.width;
        if (i3 == -1) {
            i3 = -1;
        }
        int i4 = exportResult.height;
        builder.setVideoSize(new Size(i3, i4 != -1 ? i4 : -1));
        ColorInfo colorInfo = exportResult.colorInfo;
        if (colorInfo != null) {
            builder.setVideoDataSpace(getVideoDataSpace(colorInfo));
        }
        return builder.build();
    }

    private static int getVideoDataSpace(ColorInfo colorInfo) {
        return DataSpace.pack(DATA_SPACE_STANDARD_CONVERSION_MAP.get(colorInfo.colorSpace, 0), DATA_SPACE_TRANSFER_CONVERSION_MAP.get(colorInfo.colorTransfer, 0), DATA_SPACE_RANGE_CONVERSION_MAP.get(colorInfo.colorRange, 0));
    }

    public void onExportCancelled(int i) {
        EditingEndedEvent.Builder builderCreateEditingEndedEventBuilder = createEditingEndedEventBuilder(2);
        if (i != -1) {
            builderCreateEditingEndedEventBuilder.setFinalProgressPercent(i);
        }
        this.metricsReporter.reportMetrics(builderCreateEditingEndedEventBuilder.build());
        try {
            this.metricsReporter.close();
        } catch (Exception e) {
            Log.e(TAG, "error while closing the metrics reporter", e);
        }
    }

    public void onExportError(int i, ExportException exportException, ExportResult exportResult) {
        EditingEndedEvent.Builder errorCode = createEditingEndedEventBuilder(3).setErrorCode(getEditingEndedEventErrorCode(exportException.errorCode));
        if (i != -1) {
            errorCode.setFinalProgressPercent(i);
        }
        List<MediaItemInfo> inputMediaItemInfos = getInputMediaItemInfos(exportResult.processedInputs);
        for (int i2 = 0; i2 < inputMediaItemInfos.size(); i2++) {
            errorCode.addInputMediaItemInfo(inputMediaItemInfos.get(i2));
        }
        errorCode.setOutputMediaItemInfo(getOutputMediaItemInfo(exportResult));
        this.metricsReporter.reportMetrics(errorCode.build());
        try {
            this.metricsReporter.close();
        } catch (Exception e) {
            Log.e(TAG, "error while closing the metrics reporter", e);
        }
    }

    public void onExportSuccess(ExportResult exportResult) {
        EditingEndedEvent.Builder finalProgressPercent = createEditingEndedEventBuilder(1).setFinalProgressPercent(100.0f);
        List<MediaItemInfo> inputMediaItemInfos = getInputMediaItemInfos(exportResult.processedInputs);
        for (int i = 0; i < inputMediaItemInfos.size(); i++) {
            finalProgressPercent.addInputMediaItemInfo(inputMediaItemInfos.get(i));
        }
        finalProgressPercent.setOutputMediaItemInfo(getOutputMediaItemInfo(exportResult));
        this.metricsReporter.reportMetrics(finalProgressPercent.build());
        try {
            this.metricsReporter.close();
        } catch (Exception e) {
            Log.e(TAG, "error while closing the metrics reporter", e);
        }
    }
}
