package androidx.media3.transformer;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Build;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Util;
import androidx.media3.container.Mp4LocationData;
import androidx.media3.muxer.BufferInfo;
import androidx.media3.muxer.Muxer;
import androidx.media3.muxer.MuxerException;
import com.google.common.collect.ImmutableList;
import com.oplus.tblplayer.misc.IMediaFormat;
import defpackage.jt3;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class FrameworkMuxer implements Muxer {
    public static final String MUXER_STOPPING_FAILED_ERROR_MESSAGE = "Failed to stop the MediaMuxer";
    private static final String TAG = "FrameworkMuxer";
    private static final int TRACK_ID_UNSET = -1;
    private boolean isReleased;
    private boolean isStarted;
    private final MediaMuxer mediaMuxer;
    private final SparseArray<Long> trackIdToLastPresentationTimeUs;
    private final SparseArray<Long> trackIdToPresentationTimeOffsetUs;
    private final long videoDurationUs;
    private int videoTrackId;
    public static final String MUXER_NAME = "android.media:" + Build.VERSION.SDK_INT;
    private static final ImmutableList<String> SUPPORTED_VIDEO_SAMPLE_MIME_TYPES = getSupportedVideoSampleMimeTypes();
    private static final ImmutableList<String> SUPPORTED_AUDIO_SAMPLE_MIME_TYPES = ImmutableList.of("audio/mp4a-latm", "audio/3gpp", "audio/amr-wb");

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements Muxer.Factory {
        private long videoDurationUs = -9223372036854775807L;

        @Override // androidx.media3.muxer.Muxer.Factory
        public ImmutableList<String> getSupportedSampleMimeTypes(int i) {
            return i == 2 ? FrameworkMuxer.SUPPORTED_VIDEO_SAMPLE_MIME_TYPES : i == 1 ? FrameworkMuxer.SUPPORTED_AUDIO_SAMPLE_MIME_TYPES : ImmutableList.of();
        }

        public Factory setVideoDurationUs(long j) {
            this.videoDurationUs = j;
            return this;
        }

        @Override // androidx.media3.muxer.Muxer.Factory
        public /* synthetic */ boolean supportsWritingNegativeTimestampsInEditList() {
            return jt3.a(this);
        }

        @Override // androidx.media3.muxer.Muxer.Factory
        public FrameworkMuxer create(String str) throws MuxerException {
            try {
                return new FrameworkMuxer(new MediaMuxer(str, 0), this.videoDurationUs);
            } catch (IOException e) {
                throw new MuxerException("Error creating muxer", e);
            }
        }
    }

    @RequiresApi(33)
    private static int getDvLevel(Format format) {
        if (format.codecs != null) {
            return ((Integer) ((Pair) Assertions.checkNotNull(CodecSpecificDataUtil.getCodecProfileAndLevel(format))).second).intValue();
        }
        int iMax = Math.max(format.width, format.height);
        Assertions.checkState(iMax <= 7680);
        float f = format.width * format.height * format.frameRate;
        if (iMax <= 1280) {
            return f <= 2.21184E7f ? 1 : 2;
        }
        if (iMax <= 1920 && f <= 4.97664E7f) {
            return 4;
        }
        if (iMax <= 2560 && f <= 6.2208E7f) {
            return 8;
        }
        if (iMax > 3840) {
            if (iMax <= 7680) {
                return f <= 9.95328E8f ? 1024 : 2048;
            }
            return -1;
        }
        if (f <= 1.24416E8f) {
            return 16;
        }
        if (f <= 1.990656E8f) {
            return 32;
        }
        if (f <= 2.48832E8f) {
            return 64;
        }
        if (f <= 3.981312E8f) {
            return 128;
        }
        return f <= 4.97664E8f ? 256 : 512;
    }

    @RequiresApi(33)
    private static int getDvProfile() {
        return 256;
    }

    private static ImmutableList<String> getSupportedVideoSampleMimeTypes() {
        ImmutableList.a aVarK = new ImmutableList.a().k("video/avc", "video/3gpp", "video/mp4v-es");
        int i = Build.VERSION.SDK_INT;
        if (i >= 24) {
            aVarK.a("video/hevc");
        }
        if (i >= 33) {
            aVarK.a("video/dolby-vision");
        }
        if (i >= 34) {
            aVarK.a("video/av01");
        }
        if (i >= 36) {
            aVarK.a(MimeTypes.VIDEO_APV);
        }
        return aVarK.e();
    }

    private void startMuxer() throws MuxerException {
        try {
            this.mediaMuxer.start();
            this.isStarted = true;
        } catch (RuntimeException e) {
            throw new MuxerException("Failed to start the muxer", e);
        }
    }

    @SuppressLint({"PrivateApi"})
    private static void stopMuxer(MediaMuxer mediaMuxer) {
        try {
            mediaMuxer.stop();
        } catch (RuntimeException e) {
            if (Build.VERSION.SDK_INT < 30) {
                try {
                    Field declaredField = MediaMuxer.class.getDeclaredField("MUXER_STATE_STOPPED");
                    declaredField.setAccessible(true);
                    int iIntValue = ((Integer) Util.castNonNull((Integer) declaredField.get(mediaMuxer))).intValue();
                    Field declaredField2 = MediaMuxer.class.getDeclaredField("mState");
                    declaredField2.setAccessible(true);
                    declaredField2.set(mediaMuxer, Integer.valueOf(iIntValue));
                } catch (Exception unused) {
                }
            }
            throw e;
        }
    }

    @Override // androidx.media3.muxer.Muxer
    public void addMetadataEntry(Metadata.Entry entry) {
        if (entry instanceof Mp4LocationData) {
            Mp4LocationData mp4LocationData = (Mp4LocationData) entry;
            this.mediaMuxer.setLocation(mp4LocationData.latitude, mp4LocationData.longitude);
        }
    }

    @Override // androidx.media3.muxer.Muxer
    public int addTrack(Format format) throws MuxerException {
        MediaFormat mediaFormatCreateAudioFormat;
        String str = (String) Assertions.checkNotNull(format.sampleMimeType);
        boolean zIsVideo = MimeTypes.isVideo(str);
        if (zIsVideo) {
            mediaFormatCreateAudioFormat = MediaFormat.createVideoFormat(str, format.width, format.height);
            MediaFormatUtil.maybeSetColorInfo(mediaFormatCreateAudioFormat, format.colorInfo);
            if (str.equals("video/dolby-vision") && Build.VERSION.SDK_INT >= 33) {
                mediaFormatCreateAudioFormat.setInteger(IMediaFormat.KEY_PROFILE, getDvProfile());
                mediaFormatCreateAudioFormat.setInteger("level", getDvLevel(format));
            }
            try {
                this.mediaMuxer.setOrientationHint(format.rotationDegrees);
            } catch (RuntimeException e) {
                throw new MuxerException("Failed to set orientation hint with rotationDegrees=" + format.rotationDegrees, e);
            }
        } else {
            mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(str, format.sampleRate, format.channelCount);
            MediaFormatUtil.maybeSetString(mediaFormatCreateAudioFormat, "language", format.language);
        }
        MediaFormatUtil.setCsdBuffers(mediaFormatCreateAudioFormat, format.initializationData);
        try {
            int iAddTrack = this.mediaMuxer.addTrack(mediaFormatCreateAudioFormat);
            if (zIsVideo) {
                this.videoTrackId = iAddTrack;
            }
            return iAddTrack;
        } catch (RuntimeException e2) {
            throw new MuxerException("Failed to add track with format=" + format, e2);
        }
    }

    @Override // androidx.media3.muxer.Muxer, java.lang.AutoCloseable
    public void close() throws MuxerException {
        if (this.isReleased) {
            return;
        }
        if (!this.isStarted) {
            startMuxer();
        }
        long j = this.videoDurationUs;
        if (j != -9223372036854775807L && this.videoTrackId != -1) {
            writeSampleData(this.videoTrackId, ByteBuffer.allocateDirect(0), new BufferInfo(j, 0, 4));
        }
        this.isStarted = false;
        try {
            try {
                stopMuxer(this.mediaMuxer);
            } catch (RuntimeException e) {
                throw new MuxerException(MUXER_STOPPING_FAILED_ERROR_MESSAGE, e);
            }
        } finally {
            this.mediaMuxer.release();
            this.isReleased = true;
        }
    }

    @Override // androidx.media3.muxer.Muxer
    public void writeSampleData(int i, ByteBuffer byteBuffer, BufferInfo bufferInfo) throws MuxerException {
        long j = bufferInfo.presentationTimeUs;
        long j2 = this.videoDurationUs;
        if (j2 != -9223372036854775807L && i == this.videoTrackId && j > j2) {
            Log.w(TAG, String.format(Locale.US, "Skipped sample with presentation time (%d) > video duration (%d)", Long.valueOf(j), Long.valueOf(this.videoDurationUs)));
            return;
        }
        if (!this.isStarted) {
            if (Build.VERSION.SDK_INT < 30 && j < 0) {
                this.trackIdToPresentationTimeOffsetUs.put(i, Long.valueOf(-j));
            }
            startMuxer();
        }
        long jLongValue = this.trackIdToPresentationTimeOffsetUs.get(i, 0L).longValue();
        long j3 = j + jLongValue;
        long jLongValue2 = Util.contains(this.trackIdToLastPresentationTimeUs, i) ? this.trackIdToLastPresentationTimeUs.get(i).longValue() : 0L;
        Assertions.checkState(Build.VERSION.SDK_INT > 24 || j3 >= jLongValue2, "Samples not in presentation order (" + j3 + " < " + jLongValue2 + ") unsupported on this API version");
        this.trackIdToLastPresentationTimeUs.put(i, Long.valueOf(j3));
        Assertions.checkState(jLongValue == 0 || j3 >= 0, String.format(Locale.US, "Sample presentation time (%d) < first sample presentation time (%d). Ensure the first sample has the smallest timestamp when using the negative PTS workaround.", Long.valueOf(j3 - jLongValue), Long.valueOf(-jLongValue)));
        MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
        bufferInfo2.set(byteBuffer.position(), bufferInfo.size, j3, TransformerUtil.getMediaCodecFlags(bufferInfo.flags));
        try {
            this.mediaMuxer.writeSampleData(i, byteBuffer, bufferInfo2);
        } catch (RuntimeException e) {
            throw new MuxerException("Failed to write sample for presentationTimeUs=" + j3 + ", size=" + bufferInfo.size, e);
        }
    }

    private FrameworkMuxer(MediaMuxer mediaMuxer, long j) {
        this.mediaMuxer = mediaMuxer;
        this.videoDurationUs = j;
        this.trackIdToLastPresentationTimeUs = new SparseArray<>();
        this.trackIdToPresentationTimeOffsetUs = new SparseArray<>();
        this.videoTrackId = -1;
    }
}
