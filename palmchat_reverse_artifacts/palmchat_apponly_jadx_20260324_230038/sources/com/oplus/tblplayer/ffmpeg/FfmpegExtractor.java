package com.oplus.tblplayer.ffmpeg;

import android.net.Uri;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.igexin.push.g.o;
import com.oplus.tbl.exoplayer2.C;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.extractor.Extractor;
import com.oplus.tbl.exoplayer2.extractor.ExtractorInput;
import com.oplus.tbl.exoplayer2.extractor.ExtractorOutput;
import com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory;
import com.oplus.tbl.exoplayer2.extractor.PositionHolder;
import com.oplus.tbl.exoplayer2.extractor.SeekMap;
import com.oplus.tbl.exoplayer2.extractor.SeekPoint;
import com.oplus.tbl.exoplayer2.extractor.TrackOutput;
import com.oplus.tbl.exoplayer2.util.NalUnitUtil;
import com.oplus.tbl.exoplayer2.util.ParsableByteArray;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.ffmpeg.FfmpegExtractor;
import com.oplus.tblplayer.utils.FormatUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class FfmpegExtractor implements Extractor {
    private static final long AUDIO_MAX_PTS_GAP = 13000000;
    private static final int AUDIO_PTS_ERR = 1;
    private static final long AUDIO_PTS_MAX_UP_JUMP_COUNT = 4;
    private static final int MAX_AUDIO_WAV_DURATION = 30000;
    private static final long MAX_PTS_GAP = 8000000;
    private static final int MIN_AUDIO_BITRATE = 10000;
    private static final int PTS_OK = 0;
    private static final long SEARCH_LENGTH = 131072;
    private static final int STATE_READING_FRAME_DATA = 2;
    private static final int STATE_READING_HEADER = 1;
    public static final String TAG = "FfmpegExtractor";
    private static final int VIDEO_PTS_DOWN_JUMP = 3;
    private static final int VIDEO_PTS_MAX_UP_JUMP_TIMES = 100;
    private static final int VIDEO_PTS_UP_JUMP = 2;
    private long audioPtsUpJumpCount;
    private long durationUs;
    private ExtractorOutput extractorOutput;
    private FfmpegParserJni ffmpegParserJni;
    private final int flags;
    private long lastAudioTimeUs;
    private long lastVideoFrameDuration;
    private long lastVideoTimeUs;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private boolean needRecalculateDuration;
    private boolean needReselectExtractor;
    private boolean pendingExtractorSeek;
    private FfmpegSeekMap seekMap;
    private int state;
    private final SparseArray<Track> tracks;
    private boolean upstreamKeyframeRequired;
    private final ParsableByteArray vorbisNumPageSamples;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: bu1
        @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return FfmpegExtractor.lambda$static$0();
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory
        public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
            return ws1.a(this, uri, map);
        }
    };
    private static int videoUpJumpTimes = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class FfmpegSeekMap implements SeekMap {
        private long durationUs;
        private FfmpegParserJni ffmpegParserJni;
        private long position = 0;

        public FfmpegSeekMap(long j, FfmpegParserJni ffmpegParserJni) {
            this.durationUs = j;
            this.ffmpegParserJni = ffmpegParserJni;
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.SeekMap
        public long getDurationUs() {
            return this.durationUs;
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.SeekMap
        @NonNull
        public SeekMap.SeekPoints getSeekPoints(long j) {
            SeekMap.SeekPoints seekPoints = this.ffmpegParserJni.getSeekPoints(j);
            return seekPoints == null ? new SeekMap.SeekPoints(new SeekPoint(j, this.position)) : seekPoints;
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.SeekMap
        public boolean isSeekable() {
            return this.ffmpegParserJni.isSeekable();
        }

        public void setCurrentPosition(long j) {
            this.position = j;
        }
    }

    public FfmpegExtractor() {
        this(0);
    }

    private void createBcapMetaDataTrack(int i, String str) {
        ExtractorOutput extractorOutput = this.extractorOutput;
        if (extractorOutput == null || this.tracks == null) {
            return;
        }
        TrackOutput trackOutputTrack = extractorOutput.track(i, 5);
        this.tracks.put(i, new Track(i, 5, str, trackOutputTrack));
        trackOutputTrack.format(new Format.Builder().setId(i).setSampleMimeType(str).build());
    }

    private static boolean isBcapMetaDataTrack(String str) {
        return str != null && str.toLowerCase().contains("mett");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new FfmpegExtractor()};
    }

    private int maybeReadTrackInfoForBcap(String str, int i) throws IOException {
        Uri uri;
        String mimeTypeWithMediaExtractor;
        if ((this.flags & 1) != 0 && (uri = this.ffmpegParserJni.getUri()) != null && !uri.equals(Uri.EMPTY) && str.equals(Constants.BCP_VIDEO_CONTAINER_MIME)) {
            for (int i2 = 0; i2 < i; i2++) {
                if (this.ffmpegParserJni.getTrackType(i2) == -1 && !this.ffmpegParserJni.isCoverTrack(i2) && isBcapMetaDataTrack(this.ffmpegParserJni.getTrackCodecTag(i2)) && (mimeTypeWithMediaExtractor = FormatUtil.getMimeTypeWithMediaExtractor(uri, i2)) != null) {
                    if (mimeTypeWithMediaExtractor.contains(Constants.APPLICATION_BCP1) || mimeTypeWithMediaExtractor.contains(Constants.APPLICATION_BCP2)) {
                        createBcapMetaDataTrack(i2, mimeTypeWithMediaExtractor);
                        return 2;
                    }
                    if (mimeTypeWithMediaExtractor.contains(Constants.APPLICATION_BINAURAL)) {
                        return 1;
                    }
                }
            }
            String mimeTypeWithMediaRetriever = FormatUtil.getMimeTypeWithMediaRetriever(uri);
            if (mimeTypeWithMediaRetriever != null && mimeTypeWithMediaRetriever.contains("binaural")) {
                return 1;
            }
        }
        return 0;
    }

    private int processErrPts(long j, long j2, Track track) {
        int i;
        if (this.tracks.size() > 2) {
            return 0;
        }
        if (track.getType() == 1) {
            long j3 = this.lastAudioTimeUs;
            if (j3 != -9223372036854775807L) {
                if (j <= j3) {
                    FfmpegUtil.d(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "Ffmpeg extractor will drop rollback audio frame. current: " + j + ", last: " + this.lastAudioTimeUs);
                    this.audioPtsUpJumpCount = 0L;
                    return 1;
                }
                if (j >= j3 + AUDIO_MAX_PTS_GAP && this.audioPtsUpJumpCount <= 4) {
                    FfmpegUtil.d(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "Ffmpeg extractor will drop pts up jump audio frame. current: " + j + ", last: " + this.lastAudioTimeUs);
                    this.audioPtsUpJumpCount = this.audioPtsUpJumpCount + 1;
                    return 1;
                }
            }
            this.audioPtsUpJumpCount = 0L;
            this.lastAudioTimeUs = j;
        } else if (track.getType() == 2) {
            long j4 = this.lastVideoTimeUs;
            if (j4 == -9223372036854775807L || j4 <= 0 || j <= 0) {
                i = 0;
            } else {
                if (j > j4 + MAX_PTS_GAP && this.lastVideoFrameDuration < MAX_PTS_GAP) {
                    FfmpegUtil.e(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "Ffmpeg extractor will fix incorrect video up jump frame. current: " + j + ", last: " + this.lastVideoTimeUs);
                    videoUpJumpTimes = videoUpJumpTimes + 1;
                    this.lastVideoFrameDuration = j2;
                    return 2;
                }
                if (j < j4 - MAX_PTS_GAP) {
                    FfmpegUtil.e(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "Ffmpeg extractor will fix incorrect video down jump frame. current: " + j + ", last: " + this.lastVideoTimeUs);
                    this.lastVideoFrameDuration = j2;
                    return 3;
                }
                i = 0;
                videoUpJumpTimes = 0;
            }
            this.lastVideoTimeUs = j;
            this.lastVideoFrameDuration = j2;
            return i;
        }
        return 0;
    }

    private boolean readSampleData(byte[] bArr) {
        int iProcessErrPts;
        int frameIndex = this.ffmpegParserJni.getFrameIndex();
        long frameTimeUs = this.ffmpegParserJni.getFrameTimeUs();
        boolean zIsKeyFrame = this.ffmpegParserJni.isKeyFrame();
        long frameDuration = this.ffmpegParserJni.getFrameDuration();
        Track track = this.tracks.get(frameIndex);
        if (track != null && track.getType() == 1 && this.ffmpegParserJni.getContainerMime().equals("wav") && this.ffmpegParserJni.getFrameTimeUs() == 0 && this.ffmpegParserJni.getFrameDuration() < 30000 && this.ffmpegParserJni.getFramePacketPos() == 0) {
            return false;
        }
        if (track != null && track.getType() == 2 && this.upstreamKeyframeRequired) {
            if (!zIsKeyFrame) {
                FfmpegUtil.d(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "Continue load samples until read a key frame.");
                return false;
            }
            this.upstreamKeyframeRequired = false;
        }
        if (track != null && (iProcessErrPts = processErrPts(frameTimeUs, frameDuration, track)) != 1) {
            try {
                int iWriteSampleData = writeSampleData(track, new ParsableByteArray(bArr));
                if (iProcessErrPts == 2) {
                    frameTimeUs = this.lastVideoTimeUs + frameDuration;
                    if (videoUpJumpTimes > 100) {
                        videoUpJumpTimes = 0;
                        this.lastVideoTimeUs = this.ffmpegParserJni.getFrameTimeUs();
                    } else {
                        this.lastVideoTimeUs = frameTimeUs;
                    }
                } else if (iProcessErrPts == 3) {
                    videoUpJumpTimes = 0;
                    this.lastVideoTimeUs = frameTimeUs;
                }
                writeSampleMetadata(track, frameTimeUs, zIsKeyFrame ? 1 : 0, iWriteSampleData);
                return true;
            } catch (ArrayIndexOutOfBoundsException | IllegalStateException e) {
                FfmpegUtil.e(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "Caught a exception at time: " + frameTimeUs + ", read position: " + this.ffmpegParserJni.getCurrentReadPosition(), e);
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x030f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean readStreamInfo() throws IOException {
        int trackType;
        boolean z;
        boolean z2;
        long trackDuration;
        boolean z3;
        boolean z4;
        String str;
        int i;
        int i2;
        String str2;
        String str3;
        ColorInfo colorInfo;
        String str4;
        int i3;
        String containerMime = this.ffmpegParserJni.getContainerMime();
        int trackCount = this.ffmpegParserJni.getTrackCount();
        long duration = this.ffmpegParserJni.getDuration();
        this.durationUs = duration;
        if (duration < -9223372036854775807L) {
            this.durationUs = -9223372036854775807L;
        }
        int iMaybeReadTrackInfoForBcap = maybeReadTrackInfoForBcap(containerMime, trackCount);
        boolean z5 = this.needReselectExtractor;
        String str5 = Constants.DOLBY_VISION_CODECS_PROFILE_12;
        boolean z6 = true;
        if (!z5) {
            int i4 = 0;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            while (i4 < trackCount) {
                if (!this.ffmpegParserJni.isCoverTrack(i4)) {
                    if (this.ffmpegParserJni.getTrackCodecTag(i4) != null && this.ffmpegParserJni.getTrackCodecTag(i4).toUpperCase().contains("AC-4")) {
                        FfmpegUtil.d(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "Ffmpeg extractor readStreamInfo: AC-4 codec_tag");
                        this.needReselectExtractor = z6;
                        return false;
                    }
                    int trackType2 = this.ffmpegParserJni.getTrackType(i4);
                    if (trackType2 == -1 && this.ffmpegParserJni.getTrackMime(i4) != null && this.ffmpegParserJni.getTrackMime(i4).contains("unknown/bin-data")) {
                        i3 = 2;
                        z7 = true;
                    } else if (trackType2 == 1) {
                        String trackMime = this.ffmpegParserJni.getTrackMime(i4);
                        if (trackMime != null) {
                            long trackBitrate = this.ffmpegParserJni.getTrackBitrate(i4);
                            if (!trackMime.contains("audio/mp4a-latm") || trackBitrate <= 0 || trackBitrate >= 10000) {
                                z8 = true;
                            } else {
                                z8 = true;
                                z10 = true;
                            }
                        }
                        i3 = 2;
                    } else {
                        i3 = 2;
                        if (trackType2 == 2) {
                            z9 = true;
                        }
                    }
                    if (trackType2 == i3 && this.ffmpegParserJni.getTrackCodecTag(i4) != null) {
                        HashMap<String, String> fileMetadata = this.ffmpegParserJni.getFileMetadata();
                        if (fileMetadata != null && fileMetadata.containsKey("major_brand") && "qt  ".equals(fileMetadata.get("major_brand"))) {
                            z11 = true;
                        }
                        String dolbyVisionCodecs = this.ffmpegParserJni.getDolbyVisionCodecs(i4);
                        if (dolbyVisionCodecs != null && !dolbyVisionCodecs.contains(Constants.DOLBY_VISION_CODECS_PROFILE_12)) {
                            z12 = true;
                        }
                    }
                }
                i4++;
                z6 = true;
            }
            if (z7 && !z8) {
                this.needReselectExtractor = true;
                return false;
            }
            if (z10 && !z9) {
                this.needRecalculateDuration = true;
            }
            if (iMaybeReadTrackInfoForBcap == 2) {
                this.needReselectExtractor = true;
                return false;
            }
            if (z11 && z12) {
                this.needReselectExtractor = true;
                return false;
            }
        }
        int i5 = 0;
        while (i5 < trackCount) {
            if (!this.ffmpegParserJni.isCoverTrack(i5) && (((trackType = this.ffmpegParserJni.getTrackType(i5)) == 1 || trackType == 2) && !(trackType == 1 && this.ffmpegParserJni.getTrackCodecTag(i5) != null && this.ffmpegParserJni.getTrackCodecTag(i5).toUpperCase().contains("APAC")))) {
                if (trackType != 2 || this.ffmpegParserJni.getTrackCodecTag(i5) == null) {
                    z = false;
                } else {
                    if (this.ffmpegParserJni.getTrackCodecTag(i5).toUpperCase().contains("XVID") || this.ffmpegParserJni.getTrackCodecTag(i5).toUpperCase().contains("DIVX") || this.ffmpegParserJni.getTrackCodecTag(i5).toUpperCase().contains("DX50")) {
                        FfmpegUtil.d(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "Ffmpeg extractor : video codec need sw decoder.");
                        z = true;
                    } else {
                        z = false;
                    }
                    HashMap<String, String> fileMetadata2 = this.ffmpegParserJni.getFileMetadata();
                    if (fileMetadata2 != null && fileMetadata2.containsKey("major_brand") && "XAVC".equals(fileMetadata2.get("major_brand")) && this.ffmpegParserJni.getTrackCodecTag(i5).toUpperCase().contains("AVC1")) {
                        FfmpegUtil.d(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "Ffmpeg extractor :AVC1 video brand is unsupported.");
                        z2 = true;
                    }
                    String trackMime2 = this.ffmpegParserJni.getTrackMime(i5);
                    TrackOutput trackOutputTrack = this.extractorOutput.track(i5, trackType);
                    Track track = new Track(i5, trackType, trackMime2, trackOutputTrack);
                    FfmpegUtil.i(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, track.toString());
                    this.tracks.put(i5, track);
                    trackDuration = this.ffmpegParserJni.getTrackDuration(i5);
                    if (trackDuration == Long.MIN_VALUE) {
                        z3 = z;
                        z4 = z2;
                        this.durationUs = Math.max(this.durationUs, trackDuration);
                    } else {
                        z3 = z;
                        z4 = z2;
                    }
                    FfmpegUtil.i(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "trackType: " + trackType + ", trackDuration: " + trackDuration + "us, duration: " + this.durationUs + o.f7373a);
                    track.parseMediaCodecSpecificData(this.ffmpegParserJni.getTrackExtraData(i5));
                    track.setTrackCodecParametersData(this.ffmpegParserJni.getTrackCodecParametersData(i5));
                    long trackBitrate2 = this.ffmpegParserJni.getTrackBitrate(i5);
                    Format formatBuild = new Format.Builder().setId(i5).setLabel(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL).setContainerMimeType(containerMime).setSampleMimeType(trackMime2).setAverageBitrate((int) trackBitrate2).setInitializationData(track.initializationData).setSelectionFlags(this.ffmpegParserJni.isDefaultTrack(i5) ? 1 : 0).build();
                    if (trackType != 1) {
                        int trackChannels = this.ffmpegParserJni.getTrackChannels(i5);
                        int trackSampleRate = this.ffmpegParserJni.getTrackSampleRate(i5);
                        if (iMaybeReadTrackInfoForBcap == 1) {
                            str4 = Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL + ",binaural";
                        } else {
                            str4 = Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL;
                        }
                        trackOutputTrack.format((trackMime2.contains(FfmpegUtil.PCM_24BIT) ? formatBuild.buildUpon().setLabel(str4).setSampleMimeType("audio/raw").setChannelCount(trackChannels).setSampleRate(trackSampleRate).setPcmEncoding(536870912).setInitializationData(null) : trackMime2.contains(FfmpegUtil.PCM_32BIT) ? formatBuild.buildUpon().setLabel(str4).setSampleMimeType("audio/raw").setChannelCount(trackChannels).setSampleRate(trackSampleRate).setPcmEncoding(C.ENCODING_PCM_32BIT).setInitializationData(null) : formatBuild.buildUpon().setLabel(str4).setChannelCount(trackChannels).setSampleRate(trackSampleRate)).build());
                    } else if (trackType == 2) {
                        int trackVideoWidth = this.ffmpegParserJni.getTrackVideoWidth(i5);
                        int trackVideoHeight = this.ffmpegParserJni.getTrackVideoHeight(i5);
                        float trackVideoFrameRate = this.ffmpegParserJni.getTrackVideoFrameRate(i5);
                        int trackVideoRotation = this.ffmpegParserJni.getTrackVideoRotation(i5);
                        str = containerMime;
                        float pixelWidthHeightRatio = this.ffmpegParserJni.getPixelWidthHeightRatio(i5);
                        i = trackCount;
                        ColorInfo trackVideoColorInfo = this.ffmpegParserJni.getTrackVideoColorInfo(i5);
                        String dolbyVisionCodecs2 = this.ffmpegParserJni.getDolbyVisionCodecs(i5);
                        if (dolbyVisionCodecs2 == null || dolbyVisionCodecs2.contains(str5)) {
                            i2 = iMaybeReadTrackInfoForBcap;
                            str2 = str5;
                            str3 = Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL;
                            colorInfo = trackVideoColorInfo;
                        } else {
                            i2 = iMaybeReadTrackInfoForBcap;
                            formatBuild = formatBuild.buildUpon().setSampleMimeType("video/dolby-vision").setCodecs(dolbyVisionCodecs2).build();
                            if (dolbyVisionCodecs2.contains(Constants.DOLBY_VISION_CODECS_PROFILE_20)) {
                                str3 = Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL + Constants.UNSUPPORTED_DOLBY_VISION_PROFILE_LABEL;
                                str2 = str5;
                            } else {
                                str2 = str5;
                                str3 = Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL;
                            }
                            colorInfo = null;
                        }
                        FfmpegUtil.dfmt(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "video [resolution: %d x %d, frameRate: %f, bitrate: %d, rotationDegrees: %d, pixelWidthAspectRatio: %f, colorInfo: %s]", Integer.valueOf(trackVideoWidth), Integer.valueOf(trackVideoHeight), Float.valueOf(trackVideoFrameRate), Long.valueOf(trackBitrate2), Integer.valueOf(trackVideoRotation), Float.valueOf(pixelWidthHeightRatio), colorInfo);
                        if (!this.ffmpegParserJni.isVideoPixelFormatHwSupported()) {
                            str3 = str3 + ",VideoPixelFormatHwNotSupported";
                        }
                        if (z3) {
                            str3 = str3 + ",specialVideoCodec";
                        }
                        if (z4) {
                            str3 = str3 + ",UnsupportedAvc1Brand";
                        }
                        trackOutputTrack.format(formatBuild.buildUpon().setWidth(trackVideoWidth).setHeight(trackVideoHeight).setLabel(str3).setFrameRate(trackVideoFrameRate).setRotationDegrees(trackVideoRotation).setPixelWidthHeightRatio(pixelWidthHeightRatio).setColorInfo(colorInfo).build());
                    }
                    str = containerMime;
                    i = trackCount;
                    i2 = iMaybeReadTrackInfoForBcap;
                    str2 = str5;
                }
                z2 = false;
                String trackMime22 = this.ffmpegParserJni.getTrackMime(i5);
                TrackOutput trackOutputTrack2 = this.extractorOutput.track(i5, trackType);
                Track track2 = new Track(i5, trackType, trackMime22, trackOutputTrack2);
                FfmpegUtil.i(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, track2.toString());
                this.tracks.put(i5, track2);
                trackDuration = this.ffmpegParserJni.getTrackDuration(i5);
                if (trackDuration == Long.MIN_VALUE) {
                }
                FfmpegUtil.i(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "trackType: " + trackType + ", trackDuration: " + trackDuration + "us, duration: " + this.durationUs + o.f7373a);
                track2.parseMediaCodecSpecificData(this.ffmpegParserJni.getTrackExtraData(i5));
                track2.setTrackCodecParametersData(this.ffmpegParserJni.getTrackCodecParametersData(i5));
                long trackBitrate22 = this.ffmpegParserJni.getTrackBitrate(i5);
                Format formatBuild2 = new Format.Builder().setId(i5).setLabel(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL).setContainerMimeType(containerMime).setSampleMimeType(trackMime22).setAverageBitrate((int) trackBitrate22).setInitializationData(track2.initializationData).setSelectionFlags(this.ffmpegParserJni.isDefaultTrack(i5) ? 1 : 0).build();
                if (trackType != 1) {
                }
                str = containerMime;
                i = trackCount;
                i2 = iMaybeReadTrackInfoForBcap;
                str2 = str5;
            } else {
                str = containerMime;
                i = trackCount;
                i2 = iMaybeReadTrackInfoForBcap;
                str2 = str5;
            }
            i5++;
            str5 = str2;
            containerMime = str;
            trackCount = i;
            iMaybeReadTrackInfoForBcap = i2;
        }
        this.extractorOutput.endTracks();
        if (!this.needRecalculateDuration) {
            FfmpegSeekMap ffmpegSeekMap = new FfmpegSeekMap(this.durationUs, this.ffmpegParserJni);
            this.seekMap = ffmpegSeekMap;
            this.extractorOutput.seekMap(ffmpegSeekMap);
        }
        this.state = 2;
        return true;
    }

    private int writeConvertAnnexBSampleData(Track track, ParsableByteArray parsableByteArray) {
        TrackOutput trackOutput = track.getTrackOutput();
        byte[] data = this.nalLength.getData();
        data[0] = 0;
        data[1] = 0;
        data[2] = 0;
        int i = track.nalUnitLengthFieldLength;
        int i2 = 4 - i;
        int i3 = 0;
        while (parsableByteArray.bytesLeft() > 0) {
            parsableByteArray.readBytes(this.nalLength.getData(), i2, i);
            this.nalLength.setPosition(0);
            int unsignedIntToInt = this.nalLength.readUnsignedIntToInt();
            if (unsignedIntToInt > parsableByteArray.bytesLeft()) {
                throw new ArrayIndexOutOfBoundsException("Write bytes length too large.");
            }
            this.nalStartCode.setPosition(0);
            trackOutput.sampleData(this.nalStartCode, 4);
            trackOutput.sampleData(parsableByteArray, unsignedIntToInt);
            i3 = i3 + 4 + unsignedIntToInt;
        }
        return i3;
    }

    private int writeSampleData(Track track, ParsableByteArray parsableByteArray) {
        if (FfmpegUtil.shouldRequireConvert2AnnexB(track)) {
            return writeConvertAnnexBSampleData(track, parsableByteArray);
        }
        int iLimit = parsableByteArray.limit();
        TrackOutput trackOutput = track.getTrackOutput();
        trackOutput.sampleData(parsableByteArray, iLimit);
        if (!FfmpegUtil.isVorbisTrack(track)) {
            return iLimit;
        }
        this.vorbisNumPageSamples.setPosition(0);
        trackOutput.sampleData(this.vorbisNumPageSamples, 4);
        return iLimit + 4;
    }

    private void writeSampleMetadata(Track track, long j, int i, int i2) {
        track.getTrackOutput().sampleMetadata(j, i, i2, 0, null);
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.Extractor
    public void init(@NonNull ExtractorOutput extractorOutput) {
        this.ffmpegParserJni.init();
        this.extractorOutput = extractorOutput;
        this.state = 1;
    }

    public void maybeThrowReadError() throws IOException {
        FfmpegParserJni ffmpegParserJni = this.ffmpegParserJni;
        if (ffmpegParserJni != null) {
            try {
                ffmpegParserJni.maybeThrowReadError();
            } catch (IOException e) {
                throw e;
            } catch (Throwable th) {
                throw new RuntimeException(th);
            }
        }
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        FfmpegUtil.d(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "******* Loadable thread read: input.getPosition = " + extractorInput.getPosition() + ", seekPosition = " + positionHolder.position);
        this.ffmpegParserJni.advance(extractorInput);
        updateSeekMapPosition();
        maybeThrowReadError();
        byte[] frameBuffer = this.ffmpegParserJni.getFrameBuffer();
        if (frameBuffer == null) {
            if (this.state == 1) {
                throw new IOException("Invalid data found when processing input.");
            }
            if (!this.needRecalculateDuration) {
                return -1;
            }
            FfmpegSeekMap ffmpegSeekMap = new FfmpegSeekMap(this.ffmpegParserJni.getFrameTimeUs(), this.ffmpegParserJni);
            this.seekMap = ffmpegSeekMap;
            this.extractorOutput.seekMap(ffmpegSeekMap);
            return -1;
        }
        if (this.state == 1 && !readStreamInfo()) {
            FfmpegUtil.e(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "Ffmpeg extractor get AC4 or bcap track, currently not supported, will try exo extractor");
            return 2;
        }
        if (!readSampleData(frameBuffer) || !this.pendingExtractorSeek) {
            return 0;
        }
        positionHolder.position = this.ffmpegParserJni.getCurrentReadPosition();
        this.pendingExtractorSeek = false;
        return 1;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.Extractor
    public void release() {
        FfmpegUtil.d(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "release");
        this.ffmpegParserJni.release();
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        FfmpegUtil.d(Constants.FFMPEG_EXTRACTOR_FORMAT_LABEL, "seek: position = " + j + ", timeUs = " + j2);
        FfmpegParserJni ffmpegParserJni = this.ffmpegParserJni;
        if (ffmpegParserJni != null) {
            ffmpegParserJni.seekTo(-1, j2);
            this.pendingExtractorSeek = true;
            this.upstreamKeyframeRequired = true;
            this.lastVideoTimeUs = -9223372036854775807L;
            this.lastAudioTimeUs = -9223372036854775807L;
        }
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        long length = extractorInput.getLength();
        if (length == -1 || length > 131072) {
            length = 131072;
        }
        int i = (int) length;
        int iNativeProbePaddingSize = FfmpegParserJni.nativeProbePaddingSize() + i;
        byte[] bArr = new byte[iNativeProbePaddingSize];
        Arrays.fill(bArr, i, iNativeProbePaddingSize, (byte) 0);
        extractorInput.peekFully(bArr, 0, i);
        return this.ffmpegParserJni.sniff(bArr);
    }

    public void updateSeekMapPosition() {
        FfmpegParserJni ffmpegParserJni = this.ffmpegParserJni;
        if (ffmpegParserJni == null || this.seekMap == null || this.state == 1) {
            return;
        }
        this.seekMap.setCurrentPosition(ffmpegParserJni.isEnd() ? 0L : this.ffmpegParserJni.getCurrentReadPosition());
    }

    public FfmpegExtractor(int i) {
        this.audioPtsUpJumpCount = 0L;
        this.needRecalculateDuration = false;
        this.durationUs = -9223372036854775807L;
        this.lastVideoTimeUs = -9223372036854775807L;
        this.lastVideoFrameDuration = -9223372036854775807L;
        this.lastAudioTimeUs = -9223372036854775807L;
        this.flags = i;
        this.needReselectExtractor = false;
        this.state = 1;
        this.tracks = new SparseArray<>();
        this.ffmpegParserJni = new FfmpegParserJni();
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
    }
}
