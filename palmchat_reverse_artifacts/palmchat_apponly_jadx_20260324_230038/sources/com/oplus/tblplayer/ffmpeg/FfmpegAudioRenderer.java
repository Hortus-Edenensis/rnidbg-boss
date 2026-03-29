package com.oplus.tblplayer.ffmpeg;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.ExoPlaybackException;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.audio.AudioProcessor;
import com.oplus.tbl.exoplayer2.audio.AudioRendererEventListener;
import com.oplus.tbl.exoplayer2.audio.AudioSink;
import com.oplus.tbl.exoplayer2.audio.DecoderAudioRenderer;
import com.oplus.tbl.exoplayer2.decoder.DecoderException;
import com.oplus.tbl.exoplayer2.drm.ExoMediaCrypto;
import com.oplus.tbl.exoplayer2.util.MimeTypes;
import com.oplus.tblplayer.utils.DetectCodecsCopyrightUtil;
import com.oplus.tblplayer.utils.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class FfmpegAudioRenderer extends DecoderAudioRenderer<FfmpegAudioDecoder> {
    private static final int INITIAL_INPUT_BUFFER_SIZE = 5760;
    private static final int NUM_BUFFERS = 16;
    private static final String TAG = "FfmpegAudioRenderer";
    private FfmpegAudioDecoder decoder;

    public FfmpegAudioRenderer() {
        this((Handler) null, (AudioRendererEventListener) null, new AudioProcessor[0]);
    }

    @Override // com.oplus.tbl.exoplayer2.Renderer, com.oplus.tbl.exoplayer2.RendererCapabilities
    public String getName() {
        return null;
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public void onPositionResetInGop(long j, boolean z) throws ExoPlaybackException {
        onPositionReset(j, z);
    }

    @Override // com.oplus.tbl.exoplayer2.audio.DecoderAudioRenderer
    public int supportsFormatInternal(Format format) {
        String str = format.sampleMimeType;
        LogUtil.d(TAG, "supportsFormatInternal sampleMimeType is " + str);
        if (!FfmpegLibrary.isAvailable() || !MimeTypes.isAudio(str)) {
            return 0;
        }
        if (DetectCodecsCopyrightUtil.isUnsupportedAudioCopyrightCodec(str)) {
            return 5;
        }
        return !FfmpegLibrary.supportsFormat(format) ? 0 : 4;
    }

    public FfmpegAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(handler, audioRendererEventListener, audioSink);
    }

    @Override // com.oplus.tbl.exoplayer2.audio.DecoderAudioRenderer
    public FfmpegAudioDecoder createDecoder(Format format, @Nullable ExoMediaCrypto exoMediaCrypto) throws DecoderException {
        FfmpegAudioDecoder ffmpegAudioDecoder = new FfmpegAudioDecoder(16, 16, INITIAL_INPUT_BUFFER_SIZE, format);
        this.decoder = ffmpegAudioDecoder;
        return ffmpegAudioDecoder;
    }

    @Override // com.oplus.tbl.exoplayer2.audio.DecoderAudioRenderer
    public Format getOutputFormat(FfmpegAudioDecoder ffmpegAudioDecoder) {
        return Format.createAudioSampleFormat(null, "audio/raw", null, -1, -1, this.decoder.getChannelCount(), this.decoder.getSampleRate(), 2, null, null, 0, null);
    }

    public FfmpegAudioRenderer(Handler handler, AudioRendererEventListener audioRendererEventListener, AudioProcessor... audioProcessorArr) {
        super(handler, audioRendererEventListener, audioProcessorArr);
    }
}
