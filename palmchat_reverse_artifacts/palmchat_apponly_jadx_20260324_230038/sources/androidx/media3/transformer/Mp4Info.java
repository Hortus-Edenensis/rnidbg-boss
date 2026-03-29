package androidx.media3.transformer;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import androidx.media3.extractor.TrackOutput;
import androidx.media3.extractor.mp4.Mp4Extractor;
import androidx.media3.extractor.text.SubtitleParser;
import defpackage.b06;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class Mp4Info {

    @Nullable
    public final Format audioFormat;
    public final long durationUs;
    public final long firstSyncSampleTimestampUsAfterTimeUs;
    public final long firstVideoSampleTimestampUs;
    public final boolean isFirstVideoSampleAfterTimeUsSyncSample;
    public final long lastSyncSampleTimestampUs;

    @Nullable
    public final Format videoFormat;

    private Mp4Info(long j, long j2, long j3, long j4, boolean z, @Nullable Format format, @Nullable Format format2) {
        this.durationUs = j;
        this.lastSyncSampleTimestampUs = j2;
        this.firstVideoSampleTimestampUs = j3;
        this.firstSyncSampleTimestampUsAfterTimeUs = j4;
        this.isFirstVideoSampleAfterTimeUsSyncSample = z;
        this.videoFormat = format;
        this.audioFormat = format2;
    }

    public static Mp4Info create(Context context, String str) throws IOException {
        return create(context, str, -9223372036854775807L);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x014f A[Catch: all -> 0x017e, TryCatch #0 {all -> 0x017e, blocks: (B:3:0x0029, B:7:0x0037, B:8:0x0052, B:10:0x0057, B:12:0x005d, B:14:0x007d, B:15:0x0080, B:18:0x0095, B:21:0x009a, B:22:0x009f, B:24:0x00a3, B:26:0x00b1, B:30:0x00d3, B:32:0x00e5, B:39:0x00ff, B:41:0x0108, B:43:0x0110, B:45:0x0117, B:53:0x014a, B:55:0x014f, B:57:0x016e, B:35:0x00f4), top: B:63:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Mp4Info create(Context context, String str, long j) throws IOException {
        long j2;
        Format format;
        long j3;
        long j4;
        long j5;
        boolean z;
        PositionHolder positionHolder;
        Mp4Extractor mp4Extractor = new Mp4Extractor(SubtitleParser.Factory.UNSUPPORTED, 16);
        ExtractorOutputImpl extractorOutputImpl = new ExtractorOutputImpl();
        DefaultDataSource defaultDataSource = new DefaultDataSource(context, false);
        try {
            long jOpen = defaultDataSource.open(new DataSpec.Builder().setUri(str).build());
            Assertions.checkState(jOpen != 0);
            DefaultExtractorInput defaultExtractorInput = new DefaultExtractorInput(defaultDataSource, 0L, jOpen);
            Assertions.checkState(mp4Extractor.sniff(defaultExtractorInput), "The MP4 file is invalid");
            mp4Extractor.init(extractorOutputImpl);
            PositionHolder positionHolder2 = new PositionHolder();
            while (!extractorOutputImpl.seekMapInitialized) {
                int i = mp4Extractor.read(defaultExtractorInput, positionHolder2);
                if (i == 1) {
                    defaultDataSource.close();
                    long jOpen2 = defaultDataSource.open(new DataSpec.Builder().setUri(str).setPosition(positionHolder2.position).build());
                    if (jOpen2 != -1) {
                        jOpen2 += positionHolder2.position;
                    }
                    positionHolder = positionHolder2;
                    defaultExtractorInput = new DefaultExtractorInput(defaultDataSource, positionHolder2.position, jOpen2);
                } else {
                    positionHolder = positionHolder2;
                    if (i == -1 && !extractorOutputImpl.seekMapInitialized) {
                        throw new IllegalStateException("The MP4 file is invalid");
                    }
                }
                positionHolder2 = positionHolder;
            }
            long durationUs = mp4Extractor.getDurationUs();
            if (extractorOutputImpl.videoTrackId != -1) {
                Format format2 = (Format) Assertions.checkNotNull(((ExtractorOutputImpl.TrackOutputImpl) Assertions.checkNotNull(extractorOutputImpl.trackTypeToTrackOutput.get(2))).format);
                Assertions.checkState(durationUs != -9223372036854775807L);
                j2 = durationUs;
                long j6 = mp4Extractor.getSeekPoints(durationUs, extractorOutputImpl.videoTrackId).first.timeUs;
                if (j != -9223372036854775807L) {
                    SeekMap.SeekPoints seekPoints = mp4Extractor.getSeekPoints(j, extractorOutputImpl.videoTrackId);
                    long j7 = seekPoints.first.timeUs;
                    if (j != j7) {
                        j7 = seekPoints.second.timeUs;
                        if (j > j7) {
                            j7 = Long.MIN_VALUE;
                        }
                    }
                    long[] sampleTimestampsUs = mp4Extractor.getSampleTimestampsUs(extractorOutputImpl.videoTrackId);
                    long j8 = sampleTimestampsUs.length > 0 ? sampleTimestampsUs[0] : -9223372036854775807L;
                    int iBinarySearchCeil = Util.binarySearchCeil(sampleTimestampsUs, j, true, false);
                    if (iBinarySearchCeil >= sampleTimestampsUs.length || sampleTimestampsUs[iBinarySearchCeil] != j7) {
                        format = format2;
                        j3 = j6;
                        j5 = j7;
                        j4 = j8;
                        z = false;
                        return new Mp4Info(j2, j3, j4, j5, z, format, extractorOutputImpl.audioTrackId != -1 ? (Format) Assertions.checkNotNull(((ExtractorOutputImpl.TrackOutputImpl) Assertions.checkNotNull(extractorOutputImpl.trackTypeToTrackOutput.get(1))).format) : null);
                    }
                    format = format2;
                    j3 = j6;
                    j5 = j7;
                    j4 = j8;
                    z = true;
                    return new Mp4Info(j2, j3, j4, j5, z, format, extractorOutputImpl.audioTrackId != -1 ? (Format) Assertions.checkNotNull(((ExtractorOutputImpl.TrackOutputImpl) Assertions.checkNotNull(extractorOutputImpl.trackTypeToTrackOutput.get(1))).format) : null);
                }
                format = format2;
                j3 = j6;
            } else {
                j2 = durationUs;
                format = null;
                j3 = -9223372036854775807L;
            }
            j4 = -9223372036854775807L;
            j5 = -9223372036854775807L;
            z = false;
            return new Mp4Info(j2, j3, j4, j5, z, format, extractorOutputImpl.audioTrackId != -1 ? (Format) Assertions.checkNotNull(((ExtractorOutputImpl.TrackOutputImpl) Assertions.checkNotNull(extractorOutputImpl.trackTypeToTrackOutput.get(1))).format) : null);
        } finally {
            DataSourceUtil.closeQuietly(defaultDataSource);
            mp4Extractor.release();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class ExtractorOutputImpl implements ExtractorOutput {
        public boolean seekMapInitialized;
        public int videoTrackId = -1;
        public int audioTrackId = -1;
        final Map<Integer, TrackOutputImpl> trackTypeToTrackOutput = new HashMap();

        /* JADX INFO: compiled from: SearchBox */
        public static final class TrackOutputImpl implements TrackOutput {
            private static final int FIXED_BYTE_ARRAY_SIZE = 16000;
            private final byte[] byteArray = new byte[16000];
            public Format format;

            @Override // androidx.media3.extractor.TrackOutput
            public /* synthetic */ void durationUs(long j) {
                b06.a(this, j);
            }

            @Override // androidx.media3.extractor.TrackOutput
            public void format(Format format) {
                this.format = format;
            }

            @Override // androidx.media3.extractor.TrackOutput
            public /* synthetic */ int sampleData(DataReader dataReader, int i, boolean z) {
                return b06.b(this, dataReader, i, z);
            }

            @Override // androidx.media3.extractor.TrackOutput
            public /* synthetic */ void sampleData(ParsableByteArray parsableByteArray, int i) {
                b06.c(this, parsableByteArray, i);
            }

            @Override // androidx.media3.extractor.TrackOutput
            public int sampleData(DataReader dataReader, int i, boolean z, int i2) throws IOException {
                int i3 = i;
                while (i3 > 0) {
                    boolean z2 = false;
                    int i4 = dataReader.read(this.byteArray, 0, Math.min(i3, this.byteArray.length));
                    if (i4 != -1) {
                        z2 = true;
                    }
                    Assertions.checkState(z2);
                    i3 -= i4;
                }
                return i;
            }

            @Override // androidx.media3.extractor.TrackOutput
            public void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
                while (i > 0) {
                    int iMin = Math.min(i, this.byteArray.length);
                    parsableByteArray.readBytes(this.byteArray, 0, iMin);
                    i -= iMin;
                }
            }

            @Override // androidx.media3.extractor.TrackOutput
            public void sampleMetadata(long j, int i, int i2, int i3, @Nullable TrackOutput.CryptoData cryptoData) {
            }
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public void seekMap(SeekMap seekMap) {
            this.seekMapInitialized = true;
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public TrackOutput track(int i, int i2) {
            if (i2 == 2) {
                this.videoTrackId = i;
            } else if (i2 == 1) {
                this.audioTrackId = i;
            }
            TrackOutputImpl trackOutputImpl = this.trackTypeToTrackOutput.get(Integer.valueOf(i2));
            if (trackOutputImpl != null) {
                return trackOutputImpl;
            }
            TrackOutputImpl trackOutputImpl2 = new TrackOutputImpl();
            this.trackTypeToTrackOutput.put(Integer.valueOf(i2), trackOutputImpl2);
            return trackOutputImpl2;
        }

        @Override // androidx.media3.extractor.ExtractorOutput
        public void endTracks() {
        }
    }
}
