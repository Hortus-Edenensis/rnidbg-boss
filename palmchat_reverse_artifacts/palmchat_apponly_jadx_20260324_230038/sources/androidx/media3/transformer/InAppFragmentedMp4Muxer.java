package androidx.media3.transformer;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.container.Mp4OrientationData;
import androidx.media3.muxer.BufferInfo;
import androidx.media3.muxer.FragmentedMp4Muxer;
import androidx.media3.muxer.Muxer;
import androidx.media3.muxer.MuxerException;
import androidx.media3.muxer.MuxerUtil;
import com.google.common.collect.ImmutableList;
import defpackage.jt3;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class InAppFragmentedMp4Muxer implements Muxer {
    public static final String MUXER_NAME = "androidx.media3:media3-muxer:1.8.0";
    private static final String TAG = "InAppFragmentedMp4Muxer";
    private static final int TRACK_ID_UNSET = -1;
    private final FragmentedMp4Muxer muxer;
    private final long videoDurationUs;
    private int videoTrackId;

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements Muxer.Factory {
        private final long fragmentDurationMs;
        private long videoDurationUs;

        public Factory() {
            this(-9223372036854775807L);
        }

        @Override // androidx.media3.muxer.Muxer.Factory
        public ImmutableList<String> getSupportedSampleMimeTypes(int i) {
            return i == 2 ? FragmentedMp4Muxer.SUPPORTED_VIDEO_SAMPLE_MIME_TYPES : i == 1 ? FragmentedMp4Muxer.SUPPORTED_AUDIO_SAMPLE_MIME_TYPES : ImmutableList.of();
        }

        public Factory setVideoDurationUs(long j) {
            this.videoDurationUs = j;
            return this;
        }

        @Override // androidx.media3.muxer.Muxer.Factory
        public /* synthetic */ boolean supportsWritingNegativeTimestampsInEditList() {
            return jt3.a(this);
        }

        public Factory(long j) {
            this.fragmentDurationMs = j;
            this.videoDurationUs = -9223372036854775807L;
        }

        @Override // androidx.media3.muxer.Muxer.Factory
        public InAppFragmentedMp4Muxer create(String str) throws MuxerException {
            try {
                FragmentedMp4Muxer.Builder builder = new FragmentedMp4Muxer.Builder(new FileOutputStream(str));
                long j = this.fragmentDurationMs;
                if (j != -9223372036854775807L) {
                    builder.setFragmentDurationMs(j);
                }
                return new InAppFragmentedMp4Muxer(builder.build(), this.videoDurationUs);
            } catch (FileNotFoundException e) {
                throw new MuxerException("Error creating file output stream", e);
            }
        }
    }

    @Override // androidx.media3.muxer.Muxer
    public void addMetadataEntry(Metadata.Entry entry) {
        if (MuxerUtil.isMetadataSupported(entry)) {
            this.muxer.addMetadataEntry(entry);
        }
    }

    @Override // androidx.media3.muxer.Muxer
    public int addTrack(Format format) {
        int iAddTrack = this.muxer.addTrack(format);
        if (MimeTypes.isVideo(format.sampleMimeType)) {
            this.muxer.addMetadataEntry(new Mp4OrientationData(format.rotationDegrees));
            this.videoTrackId = iAddTrack;
        }
        return iAddTrack;
    }

    @Override // androidx.media3.muxer.Muxer, java.lang.AutoCloseable
    public void close() throws MuxerException {
        long j = this.videoDurationUs;
        if (j != -9223372036854775807L && this.videoTrackId != -1) {
            writeSampleData(this.videoTrackId, ByteBuffer.allocateDirect(0), new BufferInfo(j, 0, 4));
        }
        this.muxer.close();
    }

    @Override // androidx.media3.muxer.Muxer
    public void writeSampleData(int i, ByteBuffer byteBuffer, BufferInfo bufferInfo) throws MuxerException {
        long j = this.videoDurationUs;
        if (j != -9223372036854775807L && i == this.videoTrackId) {
            long j2 = bufferInfo.presentationTimeUs;
            if (j2 > j) {
                Log.w(TAG, String.format(Locale.US, "Skipped sample with presentation time (%d) > video duration (%d)", Long.valueOf(j2), Long.valueOf(this.videoDurationUs)));
                return;
            }
        }
        this.muxer.writeSampleData(i, byteBuffer, bufferInfo);
    }

    private InAppFragmentedMp4Muxer(FragmentedMp4Muxer fragmentedMp4Muxer, long j) {
        this.muxer = fragmentedMp4Muxer;
        this.videoDurationUs = j;
        this.videoTrackId = -1;
    }
}
