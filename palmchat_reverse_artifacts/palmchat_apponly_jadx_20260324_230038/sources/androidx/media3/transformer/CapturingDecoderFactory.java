package androidx.media3.transformer;

import android.media.metrics.LogSessionId;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.transformer.Codec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class CapturingDecoderFactory implements Codec.DecoderFactory {

    @Nullable
    private String audioDecoderName;
    private final Codec.DecoderFactory decoderFactory;

    @Nullable
    private String videoDecoderName;

    public CapturingDecoderFactory(Codec.DecoderFactory decoderFactory) {
        this.decoderFactory = decoderFactory;
    }

    @Override // androidx.media3.transformer.Codec.DecoderFactory
    public Codec createForAudioDecoding(Format format, @Nullable LogSessionId logSessionId) throws ExportException {
        Codec codecCreateForAudioDecoding = this.decoderFactory.createForAudioDecoding(format, logSessionId);
        this.audioDecoderName = codecCreateForAudioDecoding.getName();
        return codecCreateForAudioDecoding;
    }

    @Override // androidx.media3.transformer.Codec.DecoderFactory
    public Codec createForVideoDecoding(Format format, Surface surface, boolean z, @Nullable LogSessionId logSessionId) throws ExportException {
        Codec codecCreateForVideoDecoding = this.decoderFactory.createForVideoDecoding(format, surface, z, logSessionId);
        this.videoDecoderName = codecCreateForVideoDecoding.getName();
        return codecCreateForVideoDecoding;
    }

    @Nullable
    public String getAudioDecoderName() {
        return this.audioDecoderName;
    }

    @Nullable
    public String getVideoDecoderName() {
        return this.videoDecoderName;
    }
}
