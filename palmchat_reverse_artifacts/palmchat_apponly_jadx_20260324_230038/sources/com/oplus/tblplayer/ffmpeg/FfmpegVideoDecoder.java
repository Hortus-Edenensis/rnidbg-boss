package com.oplus.tblplayer.ffmpeg;

import android.view.Surface;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.util.Util;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.ffmpeg.FrameOutputBuffer;
import com.oplus.tblplayer.misc.DeviceModelDetection;
import com.oplus.tblplayer.utils.FormatUtil;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class FfmpegVideoDecoder extends SimpleDecoder<FfmpegVideoInputBuffer, FrameOutputBuffer, FfmpegDecoderException> implements FrameOutputBuffer.Owner {
    private static final int AV_PKT_FLAG_CORRUPT = 2;
    private static final int AV_PKT_FLAG_DISCARD = 4;
    private static final int AV_PKT_FLAG_DISPOSABLE = 16;
    private static final int AV_PKT_FLAG_KEY = 1;
    private static final int AV_PKT_FLAG_TRUSTED = 8;
    private static final int DECODER_ERROR_EAGAIN = -3;
    private static final int DECODER_ERROR_EOF = -4;
    private static final int DECODER_ERROR_INVALID_DATA = -2;
    private static final int DECODER_ERROR_OTHER = -1;
    private static final int DECODER_SUCCESS = 0;
    private static final int ERROR_RENDERING = 6;
    public static final int OUTPUT_MODE_NONE = -1;
    public static final int OUTPUT_MODE_RGB = 1;
    public static final int OUTPUT_MODE_YUV = 0;
    private static final String TAG = "FfmpegVideoDecoder";
    private final String codecName;

    @Nullable
    private final byte[] codecParametersData;
    private boolean draining;
    private final byte[] extraData;
    private long nativeContext;
    private int outputMode;
    private int rotationDegrees;
    private int videoRenderMode;

    public FfmpegVideoDecoder(int i, int i2, int i3, Format format, int i4, int i5) throws FfmpegDecoderException {
        super(new FfmpegVideoInputBuffer[i], new FrameOutputBuffer[i2]);
        FfmpegUtil.i(TAG, "FfmpegVideoDecoder create.");
        if (!FfmpegLibrary.isAvailable()) {
            throw new FfmpegDecoderException("Failed to load decoder native libraries.");
        }
        if (format == null) {
            throw new FfmpegDecoderException("Create ffmpeg decoder fail with format is null.");
        }
        if (FormatUtil.isUnSupportBrand(format)) {
            throw new FfmpegDecoderException(Constants.UNSUPPORTED_AVC1_BRAND_LABEL);
        }
        String codecName = FfmpegLibrary.getCodecName(format.sampleMimeType);
        this.codecName = codecName;
        if (codecName == null) {
            throw new FfmpegDecoderException("NULL codec name for mime type: " + format.sampleMimeType);
        }
        byte[] extraData = getExtraData(format);
        this.extraData = extraData;
        byte[] codecParametersData = getCodecParametersData(format);
        this.codecParametersData = codecParametersData;
        this.rotationDegrees = format.rotationDegrees;
        if (DeviceModelDetection.deviceNeedsRotationConvertErrorWorkaround()) {
            this.rotationDegrees = 0;
        }
        this.outputMode = i4;
        this.videoRenderMode = i5;
        try {
            long jFfmpegInitialize = ffmpegInitialize(codecName, extraData, codecParametersData, this.rotationDegrees, 0, i5);
            this.nativeContext = jFfmpegInitialize;
            if (jFfmpegInitialize == 0) {
                throw new FfmpegDecoderException(Constants.DECODER_INIT_FAILED);
            }
            try {
                setInitialInputBufferSize(i3);
            } catch (OutOfMemoryError e) {
                FfmpegUtil.e(TAG, "setInitialInputBufferSize outOfMemory", e);
                throw new FfmpegDecoderException(message);
            }
        } finally {
            FfmpegDecoderException ffmpegDecoderException = new FfmpegDecoderException(e.getMessage());
        }
    }

    private native long ffmpegInitialize(String str, @Nullable byte[] bArr, byte[] bArr2, int i, int i2, int i3);

    private native int ffmpegReceiveFrame(long j, int i, FrameOutputBuffer frameOutputBuffer, boolean z);

    private native void ffmpegRelease(long j);

    private native int ffmpegReleaseFrame(long j, FrameOutputBuffer frameOutputBuffer);

    private native int ffmpegRenderFrame(long j, Surface surface, FrameOutputBuffer frameOutputBuffer, int i, int i2, int i3);

    private native int ffmpegRenderFrameEGL(long j, Surface surface, FrameOutputBuffer frameOutputBuffer, int i, int i2, int i3);

    private native long ffmpegReset(long j);

    private native int ffmpegSendPacket(long j, ByteBuffer byteBuffer, int i, long j2, int i2);

    private native void ffmpegUpdateSurface(long j, Surface surface);

    public static byte[] getCodecParametersData(Format format) {
        return FfmpegUtil.getFfmpegCodecParametersData(format);
    }

    private static byte[] getExtraData(Format format) {
        return FfmpegUtil.getFfmpegExtraData(format);
    }

    @Override // com.oplus.tbl.exoplayer2.decoder.Decoder
    public String getName() {
        return "Ffmpeg." + FfmpegLibrary.getVersion() + "." + this.codecName;
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public boolean isDraining() {
        return this.draining;
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder, com.oplus.tbl.exoplayer2.decoder.Decoder
    public void release() {
        super.release();
        ffmpegRelease(this.nativeContext);
        this.nativeContext = 0L;
    }

    public void renderToSurface(FrameOutputBuffer frameOutputBuffer, Surface surface) throws FfmpegDecoderException {
        int iFfmpegRenderFrameEGL = this.videoRenderMode == 1 ? ffmpegRenderFrameEGL(this.nativeContext, surface, frameOutputBuffer, frameOutputBuffer.width, frameOutputBuffer.height, frameOutputBuffer.rgbLineSize) : ffmpegRenderFrame(this.nativeContext, surface, frameOutputBuffer, frameOutputBuffer.width, frameOutputBuffer.height, frameOutputBuffer.rgbLineSize);
        if (iFfmpegRenderFrameEGL == 0) {
            return;
        }
        FfmpegUtil.e(TAG, "renderToSurface error videoRenderMode: " + this.videoRenderMode + " ret: " + iFfmpegRenderFrameEGL);
        throw new FfmpegDecoderException("Buffer render error: " + iFfmpegRenderFrameEGL);
    }

    public void setOutputMode(int i) {
        this.outputMode = i;
    }

    public void updateRenderSurface(Surface surface) {
        ffmpegUpdateSurface(this.nativeContext, surface);
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public FfmpegVideoInputBuffer createInputBuffer() {
        return new FfmpegVideoInputBuffer();
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public FrameOutputBuffer createOutputBuffer() {
        return new FrameOutputBuffer(this);
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public FfmpegDecoderException createUnexpectedDecodeException(Throwable th) {
        return new FfmpegDecoderException("video decode failed", th);
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public FfmpegDecoderException decode(FfmpegVideoInputBuffer ffmpegVideoInputBuffer, FrameOutputBuffer frameOutputBuffer, boolean z) {
        int i;
        int i2;
        int i3;
        ByteBuffer byteBuffer;
        int iLimit;
        int i4;
        if (z) {
            FfmpegUtil.d(TAG, "Decode context reset.");
            long jFfmpegReset = ffmpegReset(this.nativeContext);
            this.nativeContext = jFfmpegReset;
            if (jFfmpegReset == 0) {
                return new FfmpegDecoderException("Error resetting (see logcat).");
            }
            this.draining = false;
        }
        if (this.draining || ffmpegVideoInputBuffer == null) {
            i = -2;
            i2 = -1;
            i3 = -3;
        } else {
            if (ffmpegVideoInputBuffer.isEndOfStream()) {
                ffmpegVideoInputBuffer.timeUs = 0L;
                this.draining = true;
                FfmpegUtil.i(TAG, "The decoder entering the draining mode.");
                byteBuffer = null;
                iLimit = 0;
                i4 = 0;
            } else {
                ByteBuffer byteBuffer2 = (ByteBuffer) Util.castNonNull(ffmpegVideoInputBuffer.data);
                byteBuffer = byteBuffer2;
                iLimit = byteBuffer2.limit();
                i4 = (ffmpegVideoInputBuffer.isDecodeOnly() ? 4 : 0) | 0;
            }
            i = -2;
            i3 = -3;
            i2 = -1;
            int iFfmpegSendPacket = ffmpegSendPacket(this.nativeContext, byteBuffer, iLimit, ffmpegVideoInputBuffer.timeUs, i4);
            if (iFfmpegSendPacket == -3) {
                FfmpegUtil.d(TAG, "DECODER_ERROR_EAGAIN: timeUs = " + ffmpegVideoInputBuffer.timeUs);
            } else {
                if (iFfmpegSendPacket == -2) {
                    ffmpegVideoInputBuffer.setFlags(Integer.MIN_VALUE);
                    return null;
                }
                if (iFfmpegSendPacket == -1) {
                    return new FfmpegDecoderException("ffmpegDecode error: (see logcat)");
                }
            }
        }
        int iFfmpegReceiveFrame = ffmpegReceiveFrame(this.nativeContext, this.outputMode, frameOutputBuffer, false);
        if (iFfmpegReceiveFrame == -4) {
            frameOutputBuffer.addFlag(4);
            this.draining = false;
        } else if (iFfmpegReceiveFrame == i3) {
            frameOutputBuffer.addFlag(Integer.MIN_VALUE);
        } else if (iFfmpegReceiveFrame == i) {
            FfmpegUtil.e(TAG, "Invalid data found when processing input in draining mode.");
            frameOutputBuffer.addFlag(4);
            this.draining = false;
        } else if (iFfmpegReceiveFrame == i2) {
            return new FfmpegDecoderException("ffmpegDecode error: (see logcat)");
        }
        return null;
    }

    @Override // com.oplus.tblplayer.ffmpeg.SimpleDecoder
    public void releaseOutputBuffer(FrameOutputBuffer frameOutputBuffer) {
        if (frameOutputBuffer.mode == 1 && !frameOutputBuffer.isDecodeOnly()) {
            ffmpegReleaseFrame(this.nativeContext, frameOutputBuffer);
        }
        super.releaseOutputBuffer(frameOutputBuffer);
    }
}
