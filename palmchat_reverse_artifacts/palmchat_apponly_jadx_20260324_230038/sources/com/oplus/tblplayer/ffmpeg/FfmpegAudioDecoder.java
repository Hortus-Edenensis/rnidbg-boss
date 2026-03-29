package com.oplus.tblplayer.ffmpeg;

import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.decoder.DecoderInputBuffer;
import com.oplus.tbl.exoplayer2.decoder.OutputBuffer;
import com.oplus.tbl.exoplayer2.decoder.SimpleOutputBuffer;
import com.oplus.tbl.exoplayer2.util.ParsableByteArray;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class FfmpegAudioDecoder extends com.oplus.tbl.exoplayer2.decoder.SimpleDecoder<DecoderInputBuffer, SimpleOutputBuffer, FfmpegDecoderException> {
    private static final int DEFAULT_OUTPUT_BUFFER_SIZE = 368640;
    private static final int ERROR_DECODING = 3;
    private static final int ERROR_INIT = 2;
    private static final int ERROR_LOAD_LIB = 1;
    private static final int ERROR_OTHER = 5;
    private static final int ERROR_RESETTING = 4;
    private static final int OUTPUT_BUFFER_SIZE_INCREASE = 12288;
    private volatile int channelCount;
    private final String codecName;

    @Nullable
    private final byte[] codecParametersData;
    private final byte[] extraData;
    private boolean hasOutputFormat;
    private long nativeContext;
    private volatile int sampleRate;

    public FfmpegAudioDecoder(int i, int i2, int i3, Format format) throws FfmpegDecoderException {
        super(new DecoderInputBuffer[i], new SimpleOutputBuffer[i2]);
        if (!FfmpegLibrary.isAvailable()) {
            throw new FfmpegDecoderException("Failed to load decoder native libraries.");
        }
        String codecName = FfmpegLibrary.getCodecName(format.sampleMimeType);
        this.codecName = codecName;
        byte[] extraData = getExtraData(format);
        this.extraData = extraData;
        byte[] codecParametersData = getCodecParametersData(format);
        this.codecParametersData = codecParametersData;
        long jFfmpegInitialize = ffmpegInitialize(codecName, extraData, codecParametersData);
        this.nativeContext = jFfmpegInitialize;
        if (jFfmpegInitialize == 0) {
            throw new FfmpegDecoderException("Initialization failed.");
        }
        setInitialInputBufferSize(i3);
    }

    private static native byte[] ffmpegCreateCodecParametersData(int i, int i2);

    private native int ffmpegDecode(long j, ByteBuffer byteBuffer, int i, ByteBuffer byteBuffer2, int i2);

    private native int ffmpegGetChannelCount(long j);

    private native int ffmpegGetSampleRate(long j);

    private native long ffmpegInitialize(String str, byte[] bArr, byte[] bArr2);

    private native void ffmpegRelease(long j);

    private native long ffmpegReset(long j, byte[] bArr, byte[] bArr2);

    private static byte[] getCodecParametersData(Format format) {
        byte[] ffmpegCodecParametersData = FfmpegUtil.getFfmpegCodecParametersData(format);
        return ffmpegCodecParametersData != null ? ffmpegCodecParametersData : ffmpegCreateCodecParametersData(format.channelCount, format.sampleRate);
    }

    private static byte[] getExtraData(Format format) {
        return FfmpegUtil.getFfmpegExtraData(format);
    }

    @Override // com.oplus.tbl.exoplayer2.decoder.SimpleDecoder
    public DecoderInputBuffer createInputBuffer() {
        return new DecoderInputBuffer(2);
    }

    public int getChannelCount() {
        return this.channelCount;
    }

    @Override // com.oplus.tbl.exoplayer2.decoder.Decoder
    public String getName() {
        return "Ffmpeg." + FfmpegLibrary.getVersion() + "." + this.codecName;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    @Override // com.oplus.tbl.exoplayer2.decoder.SimpleDecoder, com.oplus.tbl.exoplayer2.decoder.Decoder
    public void release() {
        super.release();
        ffmpegRelease(this.nativeContext);
        this.nativeContext = 0L;
    }

    @Override // com.oplus.tbl.exoplayer2.decoder.SimpleDecoder
    public SimpleOutputBuffer createOutputBuffer() {
        return new SimpleOutputBuffer(new OutputBuffer.Owner() { // from class: com.oplus.tblplayer.ffmpeg.a
            @Override // com.oplus.tbl.exoplayer2.decoder.OutputBuffer.Owner
            public final void releaseOutputBuffer(OutputBuffer outputBuffer) {
                this.f7687a.releaseOutputBuffer((SimpleOutputBuffer) outputBuffer);
            }
        });
    }

    @Override // com.oplus.tbl.exoplayer2.decoder.SimpleDecoder
    public FfmpegDecoderException createUnexpectedDecodeException(Throwable th) {
        return new FfmpegDecoderException("Unexpected decode error", th);
    }

    @Override // com.oplus.tbl.exoplayer2.decoder.SimpleDecoder
    @Nullable
    public FfmpegDecoderException decode(DecoderInputBuffer decoderInputBuffer, SimpleOutputBuffer simpleOutputBuffer, boolean z) {
        if (z) {
            long jFfmpegReset = ffmpegReset(this.nativeContext, this.extraData, this.codecParametersData);
            this.nativeContext = jFfmpegReset;
            if (jFfmpegReset == 0) {
                return new FfmpegDecoderException("Error resetting (see logcat).");
            }
        }
        int i = "wmapro".equals(this.codecName) ? 380928 : DEFAULT_OUTPUT_BUFFER_SIZE;
        ByteBuffer byteBuffer = decoderInputBuffer.data;
        int iFfmpegDecode = ffmpegDecode(this.nativeContext, byteBuffer, byteBuffer.limit(), simpleOutputBuffer.init(decoderInputBuffer.timeUs, i), i);
        if (iFfmpegDecode < 0) {
            return new FfmpegDecoderException("Error decoding (see logcat).");
        }
        if (!this.hasOutputFormat) {
            this.channelCount = ffmpegGetChannelCount(this.nativeContext);
            this.sampleRate = ffmpegGetSampleRate(this.nativeContext);
            if (this.sampleRate == 0 && "alac".equals(this.codecName)) {
                ParsableByteArray parsableByteArray = new ParsableByteArray(this.extraData);
                parsableByteArray.setPosition(this.extraData.length - 4);
                this.sampleRate = parsableByteArray.readUnsignedIntToInt();
            }
            this.hasOutputFormat = true;
        }
        simpleOutputBuffer.data.position(0);
        simpleOutputBuffer.data.limit(iFfmpegDecode);
        return null;
    }
}
