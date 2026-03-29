package androidx.media3.transformer;

import android.media.MediaCodec;
import android.media.metrics.LogSessionId;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.transformer.AssetLoader;
import androidx.media3.transformer.Codec;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class ExoAssetLoaderAudioRenderer extends ExoAssetLoaderBaseRenderer {
    private static final String TAG = "ExoAssetLoaderAudioRenderer";
    private final Codec.DecoderFactory decoderFactory;
    private boolean hasPendingConsumerInput;

    @Nullable
    private final LogSessionId logSessionId;

    public ExoAssetLoaderAudioRenderer(Codec.DecoderFactory decoderFactory, TransformerMediaClock transformerMediaClock, AssetLoader.Listener listener, @Nullable LogSessionId logSessionId) {
        super(1, transformerMediaClock, listener);
        this.decoderFactory = decoderFactory;
        this.logSessionId = logSessionId;
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    public boolean feedConsumerFromDecoder() throws ExportException {
        DecoderInputBuffer inputBuffer = this.sampleConsumer.getInputBuffer();
        if (inputBuffer == null) {
            return false;
        }
        if (!this.hasPendingConsumerInput) {
            if (this.decoder.isEnded()) {
                ((ByteBuffer) Assertions.checkNotNull(inputBuffer.data)).limit(0);
                inputBuffer.addFlag(4);
                this.isEnded = this.sampleConsumer.queueInputBuffer();
                return false;
            }
            ByteBuffer outputBuffer = this.decoder.getOutputBuffer();
            if (outputBuffer == null) {
                return false;
            }
            inputBuffer.ensureSpaceForWrite(outputBuffer.limit());
            inputBuffer.data.put(outputBuffer).flip();
            MediaCodec.BufferInfo bufferInfo = (MediaCodec.BufferInfo) Assertions.checkNotNull(this.decoder.getOutputBufferInfo());
            inputBuffer.timeUs = bufferInfo.presentationTimeUs;
            inputBuffer.setFlags(bufferInfo.flags);
            this.decoder.releaseOutputBuffer(false);
            this.hasPendingConsumerInput = true;
        }
        if (!this.sampleConsumer.queueInputBuffer()) {
            return false;
        }
        this.hasPendingConsumerInput = false;
        return true;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public String getName() {
        return TAG;
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    public void initDecoder(Format format) throws ExportException {
        this.decoder = this.decoderFactory.createForAudioDecoding(format, this.logSessionId);
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    public boolean shouldDropInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (decoderInputBuffer.isEndOfStream()) {
            return false;
        }
        long j = decoderInputBuffer.timeUs - this.streamStartPositionUs;
        decoderInputBuffer.timeUs = j;
        if (this.decoder == null || j >= 0) {
            return false;
        }
        decoderInputBuffer.clear();
        return true;
    }
}
