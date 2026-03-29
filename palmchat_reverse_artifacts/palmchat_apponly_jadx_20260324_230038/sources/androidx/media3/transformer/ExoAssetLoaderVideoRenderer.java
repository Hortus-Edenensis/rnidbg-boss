package androidx.media3.transformer;

import android.media.MediaCodec;
import android.media.metrics.LogSessionId;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.transformer.AssetLoader;
import androidx.media3.transformer.Codec;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class ExoAssetLoaderVideoRenderer extends ExoAssetLoaderBaseRenderer {
    private static final String TAG = "ExoAssetLoaderVideoRenderer";
    private final List<Long> decodeOnlyPresentationTimestamps;
    private final Codec.DecoderFactory decoderFactory;
    private final boolean flattenForSlowMotion;
    private final int hdrMode;

    @Nullable
    private final LogSessionId logSessionId;
    private int maxDecoderPendingFrameCount;
    private SefSlowMotionFlattener sefVideoSlowMotionFlattener;

    public ExoAssetLoaderVideoRenderer(boolean z, Codec.DecoderFactory decoderFactory, int i, TransformerMediaClock transformerMediaClock, AssetLoader.Listener listener, @Nullable LogSessionId logSessionId) {
        super(2, transformerMediaClock, listener);
        this.flattenForSlowMotion = z;
        this.decoderFactory = decoderFactory;
        this.hdrMode = i;
        this.logSessionId = logSessionId;
        this.decodeOnlyPresentationTimestamps = new ArrayList();
        this.maxDecoderPendingFrameCount = -1;
    }

    private boolean isDecodeOnlyBuffer(long j) {
        int size = this.decodeOnlyPresentationTimestamps.size();
        for (int i = 0; i < size; i++) {
            if (this.decodeOnlyPresentationTimestamps.get(i).longValue() == j) {
                this.decodeOnlyPresentationTimestamps.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    public boolean feedConsumerFromDecoder() throws ExportException {
        if (this.decoder.isEnded()) {
            this.sampleConsumer.signalEndOfVideoInput();
            this.isEnded = true;
            return false;
        }
        MediaCodec.BufferInfo outputBufferInfo = this.decoder.getOutputBufferInfo();
        if (outputBufferInfo == null) {
            return false;
        }
        long j = outputBufferInfo.presentationTimeUs;
        long j2 = j - this.streamStartPositionUs;
        if (j2 < 0 || isDecodeOnlyBuffer(j)) {
            this.decoder.releaseOutputBuffer(false);
            return true;
        }
        if (this.sampleConsumer.getPendingVideoFrameCount() == this.maxDecoderPendingFrameCount || !this.sampleConsumer.registerVideoFrame(j2)) {
            return false;
        }
        this.decoder.releaseOutputBuffer(j2);
        return true;
    }

    @Override // androidx.media3.exoplayer.BaseRenderer, androidx.media3.exoplayer.Renderer
    public long getDurationToProgressUs(long j, long j2) {
        if (getState() == 1) {
            return 1000000L;
        }
        int i = this.maxDecoderPendingFrameCount;
        if (i == -1) {
            return 10000L;
        }
        return ((long) i) * 2000;
    }

    @Override // androidx.media3.exoplayer.Renderer
    public String getName() {
        return TAG;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initDecoder(Format format) throws ExportException {
        boolean z;
        Assertions.checkStateNotNull(this.sampleConsumer);
        if (ColorInfo.isTransferHdr(format.colorInfo)) {
            z = this.hdrMode == 1;
        }
        Codec codecCreateForVideoDecoding = this.decoderFactory.createForVideoDecoding(format, (Surface) Assertions.checkNotNull(this.sampleConsumer.getInputSurface()), z, this.logSessionId);
        this.decoder = codecCreateForVideoDecoding;
        this.maxDecoderPendingFrameCount = codecCreateForVideoDecoding.getMaxPendingFrameCount();
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    public void onDecoderInputReady(DecoderInputBuffer decoderInputBuffer) {
        if (decoderInputBuffer.timeUs < getLastResetPositionUs()) {
            this.decodeOnlyPresentationTimestamps.add(Long.valueOf(decoderInputBuffer.timeUs));
        }
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    public void onInputFormatRead(Format format) {
        if (this.flattenForSlowMotion) {
            this.sefVideoSlowMotionFlattener = new SefSlowMotionFlattener(format);
        }
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    public Format overrideInputFormat(Format format) {
        return (this.hdrMode == 3 && ColorInfo.isTransferHdr(format.colorInfo)) ? format.buildUpon().setColorInfo(ColorInfo.SDR_BT709_LIMITED).build() : format;
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    public Format overrideOutputFormat(Format format) {
        return format.buildUpon().setColorInfo(TransformerUtil.getDecoderOutputColor(TransformerUtil.getValidColor(format.colorInfo), this.hdrMode == 1)).build();
    }

    @Override // androidx.media3.transformer.ExoAssetLoaderBaseRenderer
    public boolean shouldDropInputBuffer(DecoderInputBuffer decoderInputBuffer) {
        if (decoderInputBuffer.isEndOfStream()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.data);
        if (this.sefVideoSlowMotionFlattener != null) {
            long streamOffsetUs = getStreamOffsetUs();
            if (this.sefVideoSlowMotionFlattener.dropOrTransformSample(byteBuffer, decoderInputBuffer.timeUs - streamOffsetUs)) {
                byteBuffer.clear();
                return true;
            }
            decoderInputBuffer.timeUs = streamOffsetUs + this.sefVideoSlowMotionFlattener.getSamplePresentationTimeUs();
        }
        if (this.decoder == null) {
            decoderInputBuffer.timeUs -= this.streamStartPositionUs;
        }
        return false;
    }
}
