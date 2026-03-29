package com.oplus.tblplayer.render;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.ExoPlaybackException;
import com.oplus.tbl.exoplayer2.Format;
import com.oplus.tbl.exoplayer2.audio.AudioCapabilities;
import com.oplus.tbl.exoplayer2.audio.AudioProcessor;
import com.oplus.tbl.exoplayer2.audio.AudioRendererEventListener;
import com.oplus.tbl.exoplayer2.audio.AudioSink;
import com.oplus.tbl.exoplayer2.audio.DefaultAudioSink;
import com.oplus.tbl.exoplayer2.audio.MediaCodecAudioRenderer;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecAdapter;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecInfo;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecSelector;
import com.oplus.tbl.exoplayer2.mediacodec.MediaCodecUtil;
import com.oplus.tbl.exoplayer2.metadata.Metadata;
import com.oplus.tbl.exoplayer2.util.MimeTypes;
import com.oplus.tblplayer.managers.BcapManager;
import com.oplus.tblplayer.misc.DeviceModelDetection;
import com.oplus.tblplayer.utils.DetectCodecsCopyrightUtil;
import com.oplus.tblplayer.utils.FormatUtil;
import com.oplus.tblplayer.utils.LogUtil;
import defpackage.rv4;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class TBLMediaCodecAudioRenderer extends MediaCodecAudioRenderer implements FallbackRenderer, IMetadataOutput, RollupRenderer {
    private String TAG;
    private AtomicBoolean fallbackRenderer;
    private Context mAppContext;
    private BcapManager mBcapManager;
    private AtomicBoolean rollupRenderer;
    private boolean streamingMode;

    public TBLMediaCodecAudioRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, boolean z, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(context, factory, mediaCodecSelector, z, handler, audioRendererEventListener, audioSink);
        this.TAG = "TBLMediaCodecAudioRenderer_ins_" + Thread.currentThread().getId();
        this.streamingMode = false;
        this.mBcapManager = null;
        this.mAppContext = context;
        this.fallbackRenderer = new AtomicBoolean(false);
        this.rollupRenderer = new AtomicBoolean(false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0055 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean codecNeedsUseFfmpegCodecWorkaround(Format format) {
        String str;
        if (format != null && (str = format.sampleMimeType) != null) {
            str.hashCode();
            switch (str) {
                case "audio/vorbis":
                case "audio/opus":
                    if (DeviceModelDetection.deviceNeedsUseFfmpegAudioDecoderWorkaround()) {
                        return true;
                    }
                    break;
                case "audio/mp4a-latm":
                    if (FormatUtil.getFormatTagForSpecialVideo(format) != 1) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    @Override // com.oplus.tbl.exoplayer2.audio.MediaCodecAudioRenderer, com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodecAdapter mediaCodecAdapter, Format format, @Nullable MediaCrypto mediaCrypto, float f) {
        Format formatMaybeRemoveFfmpegCodecParameters = FormatUtil.maybeRemoveFfmpegCodecParameters(format);
        int formatTagForSpecialVideo = FormatUtil.getFormatTagForSpecialVideo(format);
        if (formatTagForSpecialVideo == 1 || formatTagForSpecialVideo == 2) {
            BcapManager bcapManager = new BcapManager(this.mAppContext, formatTagForSpecialVideo);
            this.mBcapManager = bcapManager;
            bcapManager.start();
        }
        super.configureCodec(mediaCodecInfo, mediaCodecAdapter, formatMaybeRemoveFfmpegCodecParameters, mediaCrypto, f);
    }

    public void enablePostEnhanceAudio(boolean z) {
        BcapManager bcapManager = this.mBcapManager;
        if (bcapManager == null || bcapManager.getBcapType() != 2) {
            return;
        }
        this.mBcapManager.enablePostEnhanceAudio(z);
    }

    @Override // com.oplus.tbl.exoplayer2.audio.MediaCodecAudioRenderer, com.oplus.tbl.exoplayer2.BaseRenderer, com.oplus.tbl.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, @Nullable Object obj) throws ExoPlaybackException {
        if (i == 10002) {
            if (obj != null) {
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                this.streamingMode = zBooleanValue;
                if (zBooleanValue) {
                    this.fallbackRenderer.set(true);
                    return;
                }
                return;
            }
        } else if (i == 10005 && obj != null) {
            enablePostEnhanceAudio(((Boolean) obj).booleanValue());
            return;
        }
        super.handleMessage(i, obj);
    }

    @Override // com.oplus.tblplayer.render.FallbackRenderer
    public boolean isFallback() {
        return this.fallbackRenderer.get();
    }

    @Override // com.oplus.tblplayer.render.RollupRenderer
    public boolean isRollup() {
        return this.rollupRenderer.get();
    }

    @Override // com.oplus.tbl.exoplayer2.BaseRenderer
    public boolean isSourceReady() {
        return this.streamingMode || super.isSourceReady();
    }

    @Override // com.oplus.tbl.exoplayer2.audio.MediaCodecAudioRenderer, com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer, com.oplus.tbl.exoplayer2.BaseRenderer
    public void onDisabled() {
        if (this.mBcapManager != null) {
            this.mBcapManager = null;
        }
        super.onDisabled();
    }

    @Override // com.oplus.tblplayer.render.IMetadataOutput, com.oplus.tbl.exoplayer2.metadata.MetadataOutput
    public void onMetadata(@NonNull Metadata metadata) {
        BcapManager bcapManager = this.mBcapManager;
        if (bcapManager == null || bcapManager.getBcapType() != 2) {
            return;
        }
        this.mBcapManager.OnMetadata(metadata);
    }

    @Override // com.oplus.tblplayer.render.IMetadataOutput
    public final void onMetadataReset() {
        BcapManager bcapManager = this.mBcapManager;
        if (bcapManager == null || bcapManager.getBcapType() != 2) {
            return;
        }
        this.mBcapManager.OnMetadataReset();
    }

    @Override // com.oplus.tbl.exoplayer2.audio.MediaCodecAudioRenderer, com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public void onOutputFormatChanged(@NonNull Format format, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
        BcapManager bcapManager = this.mBcapManager;
        if (bcapManager == null || bcapManager.getBcapType() != 2) {
            super.onOutputFormatChanged(format, mediaFormat);
            LogUtil.d(this.TAG, "onOutputFormatChanged: format = " + format);
            return;
        }
        Format formatCopy = FormatUtil.copy(format, true);
        super.onOutputFormatChanged(formatCopy, mediaFormat);
        LogUtil.d(this.TAG, "onOutputFormatChanged: with altered encode delay [" + format.encoderDelay + " -> " + formatCopy.encoderDelay + "], format " + format + ", new " + formatCopy);
        if (this.mBcapManager.getAudioFormat() != null && !this.mBcapManager.getAudioFormat().equals(formatCopy)) {
            throw new IllegalStateException("Unsupported audio format change during playback.");
        }
        if (this.mBcapManager.getAudioFormat() == null) {
            this.mBcapManager.initProcessorMethod();
            this.mBcapManager.setAudioFormat(formatCopy);
            this.mBcapManager.initBcapProcessorIfNecessary();
        }
    }

    @Override // com.oplus.tbl.exoplayer2.audio.MediaCodecAudioRenderer
    public void onPositionDiscontinuity() {
        super.onPositionDiscontinuity();
        BcapManager bcapManager = this.mBcapManager;
        if (bcapManager == null || bcapManager.getBcapType() != 2) {
            return;
        }
        this.mBcapManager.OnMetadataReset();
    }

    @Override // com.oplus.tbl.exoplayer2.audio.MediaCodecAudioRenderer, com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer, com.oplus.tbl.exoplayer2.BaseRenderer
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        BcapManager bcapManager = this.mBcapManager;
        if (bcapManager == null || bcapManager.getBcapType() != 2) {
            return;
        }
        this.mBcapManager.onPositionReset(j, z);
    }

    @Override // com.oplus.tbl.exoplayer2.audio.MediaCodecAudioRenderer, com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer, com.oplus.tbl.exoplayer2.BaseRenderer
    public void onStarted() {
        BcapManager bcapManager = this.mBcapManager;
        if (bcapManager != null) {
            bcapManager.start();
        }
        super.onStarted();
    }

    @Override // com.oplus.tbl.exoplayer2.audio.MediaCodecAudioRenderer, com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer, com.oplus.tbl.exoplayer2.BaseRenderer
    public void onStopped() {
        BcapManager bcapManager = this.mBcapManager;
        if (bcapManager != null) {
            bcapManager.stop();
        }
        super.onStopped();
    }

    @Override // com.oplus.tbl.exoplayer2.audio.MediaCodecAudioRenderer, com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public boolean processOutputBuffer(long j, long j2, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, @NonNull Format format) throws ExoPlaybackException {
        BcapManager bcapManager = this.mBcapManager;
        if (bcapManager == null || bcapManager.getBcapType() != 2 || this.mBcapManager.processOutputBcapBuffer(j3, byteBuffer, getOutputStreamOffsetUs())) {
            return super.processOutputBuffer(j, j2, mediaCodecAdapter, byteBuffer, i, i2, i3, j3, z, z2, format);
        }
        return false;
    }

    @Override // com.oplus.tblplayer.render.FallbackRenderer
    public void setFallbackRenderer(boolean z) {
        if (this.fallbackRenderer.get() != z) {
            this.fallbackRenderer.set(z);
        }
    }

    @Override // com.oplus.tblplayer.render.RollupRenderer
    public void setRollupRenderer(boolean z) {
        if (this.rollupRenderer.get() != z) {
            this.rollupRenderer.set(z);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.audio.MediaCodecAudioRenderer, com.oplus.tbl.exoplayer2.mediacodec.MediaCodecRenderer
    public int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        String str = format.sampleMimeType;
        if (!MimeTypes.isAudio(str)) {
            return rv4.a(0);
        }
        if (isFallback()) {
            return rv4.a(0);
        }
        if (DetectCodecsCopyrightUtil.isUnsupportedAudioCopyrightCodec(str)) {
            LogUtil.d(this.TAG, "Audio format has no copyright,mime type: " + str);
            return rv4.a(5);
        }
        int iSupportsFormat = super.supportsFormat(mediaCodecSelector, format);
        LogUtil.d(this.TAG, "Audio format support with mime type: " + str + ", support: " + iSupportsFormat);
        return (FormatUtil.isFfmpegExtractor(format) && !isRollup() && codecNeedsUseFfmpegCodecWorkaround(format)) ? rv4.a(0) : iSupportsFormat;
    }

    public TBLMediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, null, null);
    }

    public TBLMediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
        this(context, mediaCodecSelector, handler, audioRendererEventListener, (AudioCapabilities) null, new AudioProcessor[0]);
    }

    public TBLMediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, @Nullable AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        this(context, mediaCodecSelector, handler, audioRendererEventListener, new DefaultAudioSink(audioCapabilities, audioProcessorArr));
    }

    public TBLMediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        this(context, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, false, handler, audioRendererEventListener, audioSink);
    }

    public TBLMediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, boolean z, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        this(context, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, z, handler, audioRendererEventListener, audioSink);
    }
}
