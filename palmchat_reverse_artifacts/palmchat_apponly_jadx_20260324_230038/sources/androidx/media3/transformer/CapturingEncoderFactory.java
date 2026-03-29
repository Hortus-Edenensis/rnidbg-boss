package androidx.media3.transformer;

import android.media.metrics.LogSessionId;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.transformer.Codec;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class CapturingEncoderFactory implements Codec.EncoderFactory {

    @Nullable
    private String audioEncoderName;
    private final Codec.EncoderFactory encoderFactory;

    @Nullable
    private String videoEncoderName;

    public CapturingEncoderFactory(Codec.EncoderFactory encoderFactory) {
        this.encoderFactory = encoderFactory;
    }

    @Override // androidx.media3.transformer.Codec.EncoderFactory
    public boolean audioNeedsEncoding() {
        return this.encoderFactory.audioNeedsEncoding();
    }

    @Override // androidx.media3.transformer.Codec.EncoderFactory
    public Codec createForAudioEncoding(Format format, @Nullable LogSessionId logSessionId) throws ExportException {
        Codec codecCreateForAudioEncoding = this.encoderFactory.createForAudioEncoding(format, logSessionId);
        this.audioEncoderName = codecCreateForAudioEncoding.getName();
        return codecCreateForAudioEncoding;
    }

    @Override // androidx.media3.transformer.Codec.EncoderFactory
    public Codec createForVideoEncoding(Format format, @Nullable LogSessionId logSessionId) throws ExportException {
        Codec codecCreateForVideoEncoding = this.encoderFactory.createForVideoEncoding(format, logSessionId);
        this.videoEncoderName = codecCreateForVideoEncoding.getName();
        return codecCreateForVideoEncoding;
    }

    @Nullable
    public String getAudioEncoderName() {
        return this.audioEncoderName;
    }

    @Nullable
    public String getVideoEncoderName() {
        return this.videoEncoderName;
    }

    @Override // androidx.media3.transformer.Codec.EncoderFactory
    public boolean videoNeedsEncoding() {
        return this.encoderFactory.videoNeedsEncoding();
    }
}
