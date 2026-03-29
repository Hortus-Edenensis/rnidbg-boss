package com.oplus.tblplayer.ffmpeg;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.ColorInfo;
import com.oplus.tbl.exoplayer2.ParserException;
import com.oplus.tbl.exoplayer2.extractor.ExtractorInput;
import com.oplus.tbl.exoplayer2.extractor.SeekMap;
import com.oplus.tbl.exoplayer2.extractor.SeekPoint;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class FfmpegParserJni {
    private static final int AVSEEK_SIZE = 65536;
    private static final int BUFFER_LENGTH = 32768;
    private static final int SEEK_CUR = 1;
    private static final int SEEK_END = 2;
    private static final int SEEK_SET = 0;
    private static final String TAG = "FfmpegParserJni";
    private FfmpegExtractorInput ffmpegExtractorInput;
    private byte[] frameBuffer;
    private byte[] inputBuffer;
    private long nativeContext;
    private Throwable readError;

    public FfmpegParserJni() {
        FfmpegLibrary.isAvailable();
    }

    private native String nativeGetContainerMime(long j);

    private native String nativeGetDolbyVisionCodecs(long j, int i);

    private native long nativeGetDuration(long j);

    private native HashMap<String, String> nativeGetFileMetadata(long j);

    private native long nativeGetLastPacketDuration(long j);

    private native boolean nativeGetLastPacketEndOfStream(long j);

    private native boolean nativeGetLastPacketIsKeyframe(long j);

    private native long nativeGetLastPacketPos(long j);

    private native int nativeGetLastPacketStreamIndex(long j);

    private native long nativeGetLastPacketTimeUs(long j);

    private native long nativeGetLastReadPosition(long j);

    private native boolean nativeGetSeekPoints(long j, long j2, long[] jArr);

    private native long nativeGetTrackBitrate(long j, int i);

    private native int nativeGetTrackChannels(long j, int i);

    private native byte[] nativeGetTrackCodecParameters(long j, int i);

    private native String nativeGetTrackCodecTag(long j, int i);

    private native int nativeGetTrackCount(long j);

    private native long nativeGetTrackDuration(long j, int i);

    private native byte[] nativeGetTrackExtraData(long j, int i);

    private native String nativeGetTrackMime(long j, int i);

    private native int nativeGetTrackPcmEncoding(long j, int i);

    private native int nativeGetTrackSampleRate(long j, int i);

    private native int nativeGetTrackType(long j, int i);

    private native ColorInfo nativeGetTrackVideoColorInfo(long j, int i);

    private native float nativeGetTrackVideoFrameRate(long j, int i);

    private native int nativeGetTrackVideoHeight(long j, int i);

    private native int nativeGetTrackVideoRotation(long j, int i);

    private native int nativeGetTrackVideoSarHeight(long j, int i);

    private native int nativeGetTrackVideoSarWidth(long j, int i);

    private native int nativeGetTrackVideoWidth(long j, int i);

    private native long nativeInit();

    private native boolean nativeIsCoverTrack(long j, int i);

    private native boolean nativeIsDefaultTrack(long j, int i);

    private native boolean nativeIsSeekable(long j);

    private native boolean nativeIsUnsupportedSoftWareCodec(long j);

    private native boolean nativeIsVideoPixelFormatHwSupported(long j);

    public static native int nativeProbePaddingSize();

    private native byte[] nativeReadFrame(long j);

    private native void nativeRelease(long j);

    private native int nativeSeekTo(long j, int i, long j2);

    private native String nativeSniff(byte[] bArr);

    public byte[] advance(ExtractorInput extractorInput) throws IOException {
        this.readError = null;
        setExtractorInput(extractorInput);
        FfmpegUtil.d(TAG, "nativeReadFrame will exec");
        this.frameBuffer = nativeReadFrame(this.nativeContext);
        FfmpegUtil.d(TAG, "nativeReadFrame end exec");
        if (this.frameBuffer == null && isUnsupportedSoftWareCodec()) {
            FfmpegUtil.e(TAG, "Read frame failed, maybe unsupported encoder");
            this.readError = new ParserException("read error");
        }
        return this.frameBuffer;
    }

    public String getContainerMime() {
        return nativeGetContainerMime(this.nativeContext);
    }

    public long getCurrentReadPosition() {
        long jNativeGetLastReadPosition = nativeGetLastReadPosition(this.nativeContext);
        return jNativeGetLastReadPosition < 0 ? this.ffmpegExtractorInput.getPosition() : jNativeGetLastReadPosition;
    }

    public String getDolbyVisionCodecs(int i) {
        return nativeGetDolbyVisionCodecs(this.nativeContext, i);
    }

    public long getDuration() {
        return nativeGetDuration(this.nativeContext);
    }

    public HashMap<String, String> getFileMetadata() {
        return nativeGetFileMetadata(this.nativeContext);
    }

    public byte[] getFrameBuffer() {
        return this.frameBuffer;
    }

    public long getFrameDuration() {
        return nativeGetLastPacketDuration(this.nativeContext);
    }

    public int getFrameIndex() {
        return nativeGetLastPacketStreamIndex(this.nativeContext);
    }

    public long getFramePacketPos() {
        return nativeGetLastPacketPos(this.nativeContext);
    }

    public long getFrameTimeUs() {
        return nativeGetLastPacketTimeUs(this.nativeContext);
    }

    public float getPixelWidthHeightRatio(int i) {
        int iNativeGetTrackVideoSarWidth = nativeGetTrackVideoSarWidth(this.nativeContext, i);
        int iNativeGetTrackVideoSarHeight = nativeGetTrackVideoSarHeight(this.nativeContext, i);
        if (iNativeGetTrackVideoSarWidth == 0 && iNativeGetTrackVideoSarHeight == 1) {
            return 1.0f;
        }
        return iNativeGetTrackVideoSarWidth / iNativeGetTrackVideoSarHeight;
    }

    public SeekMap.SeekPoints getSeekPoints(long j) {
        long[] jArr = new long[4];
        if (!nativeGetSeekPoints(this.nativeContext, j, jArr)) {
            return null;
        }
        SeekPoint seekPoint = new SeekPoint(jArr[0], jArr[1]);
        SeekPoint seekPoint2 = jArr[2] == jArr[0] ? seekPoint : new SeekPoint(jArr[2], jArr[3]);
        FfmpegUtil.dfmt(TAG, "getSeekPoints: timeUs is %d, firstSeekPoint is [%d, %d], secondSeekPoint is [%d, %d]", Long.valueOf(j), Long.valueOf(jArr[0]), Long.valueOf(jArr[1]), Long.valueOf(jArr[2]), Long.valueOf(jArr[3]));
        return new SeekMap.SeekPoints(seekPoint, seekPoint2);
    }

    public long getTrackBitrate(int i) {
        return nativeGetTrackBitrate(this.nativeContext, i);
    }

    public int getTrackChannels(int i) {
        return nativeGetTrackChannels(this.nativeContext, i);
    }

    public byte[] getTrackCodecParametersData(int i) {
        return nativeGetTrackCodecParameters(this.nativeContext, i);
    }

    public String getTrackCodecTag(int i) {
        return nativeGetTrackCodecTag(this.nativeContext, i);
    }

    public int getTrackCount() {
        return nativeGetTrackCount(this.nativeContext);
    }

    public long getTrackDuration(int i) {
        return nativeGetTrackDuration(this.nativeContext, i);
    }

    public byte[] getTrackExtraData(int i) {
        return nativeGetTrackExtraData(this.nativeContext, i);
    }

    public String getTrackMime(int i) {
        return nativeGetTrackMime(this.nativeContext, i);
    }

    public int getTrackPcmEncoding(int i) {
        return nativeGetTrackPcmEncoding(this.nativeContext, i);
    }

    public int getTrackSampleRate(int i) {
        return nativeGetTrackSampleRate(this.nativeContext, i);
    }

    public int getTrackType(int i) {
        return nativeGetTrackType(this.nativeContext, i);
    }

    public ColorInfo getTrackVideoColorInfo(int i) {
        return nativeGetTrackVideoColorInfo(this.nativeContext, i);
    }

    public float getTrackVideoFrameRate(int i) {
        return nativeGetTrackVideoFrameRate(this.nativeContext, i);
    }

    public int getTrackVideoHeight(int i) {
        return nativeGetTrackVideoHeight(this.nativeContext, i);
    }

    public int getTrackVideoRotation(int i) {
        return nativeGetTrackVideoRotation(this.nativeContext, i);
    }

    public int getTrackVideoWidth(int i) {
        return nativeGetTrackVideoWidth(this.nativeContext, i);
    }

    @Nullable
    public Uri getUri() {
        return this.ffmpegExtractorInput.getUri();
    }

    public void init() {
        this.nativeContext = nativeInit();
        this.ffmpegExtractorInput = new FfmpegExtractorInput();
        this.inputBuffer = new byte[32768];
    }

    public boolean isCoverTrack(int i) {
        return nativeIsCoverTrack(this.nativeContext, i);
    }

    public boolean isDefaultTrack(int i) {
        return nativeIsDefaultTrack(this.nativeContext, i);
    }

    public boolean isEnd() {
        return this.ffmpegExtractorInput.getPosition() >= this.ffmpegExtractorInput.getLength();
    }

    public boolean isEndOfStream() {
        return nativeGetLastPacketEndOfStream(this.nativeContext);
    }

    public boolean isKeyFrame() {
        return nativeGetLastPacketIsKeyframe(this.nativeContext);
    }

    public boolean isSeekable() {
        return nativeIsSeekable(this.nativeContext);
    }

    public boolean isUnsupportedSoftWareCodec() {
        return nativeIsUnsupportedSoftWareCodec(this.nativeContext);
    }

    public boolean isVideoPixelFormatHwSupported() {
        return nativeIsVideoPixelFormatHwSupported(this.nativeContext);
    }

    public void maybeThrowReadError() throws Throwable {
        Throwable th = this.readError;
        if (th != null) {
            throw th;
        }
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        FfmpegUtil.d(TAG, "------- read callback from native.");
        int iMin = Math.min(byteBuffer.remaining(), 32768);
        try {
            FfmpegUtil.d(TAG, "Current position is " + this.ffmpegExtractorInput.getPosition() + ", will read size is " + iMin);
            if (this.readError != null) {
                FfmpegUtil.e(TAG, "Read callback from native has error.");
                return 0;
            }
            int i = this.ffmpegExtractorInput.read(this.inputBuffer, 0, iMin);
            if (i != -1) {
                byteBuffer.put(this.inputBuffer, 0, i);
            }
            return i;
        } catch (Throwable th) {
            this.readError = th;
            throw new IOException(th);
        }
    }

    public void release() {
        nativeRelease(this.nativeContext);
    }

    public long seek(long j, int i) throws IOException {
        FfmpegUtil.d(TAG, "Seek callback from native offset = " + j + ", whence = " + FfmpegUtil.getSeekWhenceString(i));
        try {
            if (i == 0) {
                return this.ffmpegExtractorInput.seekToReadPosition(j);
            }
            if (i == 1) {
                this.ffmpegExtractorInput.skipFully((int) j, true);
                return this.ffmpegExtractorInput.getPosition();
            }
            if (i == 2) {
                throw new IOException("Seek end not implement.");
            }
            if (i == 65536) {
                return this.ffmpegExtractorInput.getLength();
            }
            throw new IOException("Seek callback unknown whence.");
        } catch (Throwable th) {
            this.readError = th instanceof InterruptedIOException ? th : new ParserException(th);
            throw new IOException(th);
        }
    }

    public int seekTo(int i, long j) {
        return nativeSeekTo(this.nativeContext, -1, j);
    }

    public void setExtractorInput(ExtractorInput extractorInput) throws IOException {
        FfmpegExtractorInput ffmpegExtractorInput = this.ffmpegExtractorInput;
        if (ffmpegExtractorInput != null) {
            ffmpegExtractorInput.setExtractorInput(extractorInput);
        }
    }

    public boolean sniff(byte[] bArr) {
        return nativeSniff(bArr) != null;
    }
}
