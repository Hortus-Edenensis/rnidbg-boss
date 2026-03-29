package androidx.media3.transformer;

import android.content.Context;
import android.media.MediaCodec;
import android.media.metrics.LogSessionId;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.video.PlaceholderSurface;
import androidx.media3.transformer.Codec;
import androidx.media3.transformer.NoWriteMuxer;
import androidx.media3.transformer.Transformer;
import com.google.common.collect.ImmutableList;
import defpackage.ae0;
import defpackage.be0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class ExperimentalAnalyzerModeFactory {

    /* JADX INFO: compiled from: SearchBox */
    public static final class DroppingEncoder implements Codec {
        private static final int INTERNAL_BUFFER_SIZE = 8196;
        private static final String TAG = "DroppingEncoder";
        private final ByteBuffer buffer = ByteBuffer.allocateDirect(8196).order(ByteOrder.nativeOrder());
        private final Format configurationFormat;
        private boolean inputStreamEnded;
        private final Surface placeholderSurface;

        /* JADX INFO: compiled from: SearchBox */
        public static final class Factory implements Codec.EncoderFactory {
            private final Context context;

            public Factory(Context context) {
                this.context = context;
            }

            @Override // androidx.media3.transformer.Codec.EncoderFactory
            public /* synthetic */ boolean audioNeedsEncoding() {
                return be0.a(this);
            }

            @Override // androidx.media3.transformer.Codec.EncoderFactory
            public Codec createForAudioEncoding(Format format, @Nullable LogSessionId logSessionId) {
                return new DroppingEncoder(this.context, format);
            }

            @Override // androidx.media3.transformer.Codec.EncoderFactory
            public Codec createForVideoEncoding(Format format, @Nullable LogSessionId logSessionId) {
                return new DroppingEncoder(this.context, format);
            }

            @Override // androidx.media3.transformer.Codec.EncoderFactory
            public /* synthetic */ boolean videoNeedsEncoding() {
                return be0.b(this);
            }
        }

        public DroppingEncoder(Context context, Format format) {
            this.configurationFormat = format;
            this.placeholderSurface = PlaceholderSurface.newInstance(context, false);
        }

        @Override // androidx.media3.transformer.Codec
        public Format getConfigurationFormat() {
            return this.configurationFormat;
        }

        @Override // androidx.media3.transformer.Codec
        public Format getInputFormat() {
            return this.configurationFormat;
        }

        @Override // androidx.media3.transformer.Codec
        public Surface getInputSurface() {
            return this.placeholderSurface;
        }

        @Override // androidx.media3.transformer.Codec
        public /* synthetic */ int getMaxPendingFrameCount() {
            return ae0.a(this);
        }

        @Override // androidx.media3.transformer.Codec
        public String getName() {
            return TAG;
        }

        @Override // androidx.media3.transformer.Codec
        @Nullable
        public ByteBuffer getOutputBuffer() {
            return null;
        }

        @Override // androidx.media3.transformer.Codec
        @Nullable
        public MediaCodec.BufferInfo getOutputBufferInfo() {
            return null;
        }

        @Override // androidx.media3.transformer.Codec
        @Nullable
        public Format getOutputFormat() {
            return this.configurationFormat;
        }

        @Override // androidx.media3.transformer.Codec
        public boolean isEnded() {
            return this.inputStreamEnded;
        }

        @Override // androidx.media3.transformer.Codec
        public boolean maybeDequeueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
            if (this.inputStreamEnded) {
                return false;
            }
            decoderInputBuffer.data = this.buffer;
            return true;
        }

        @Override // androidx.media3.transformer.Codec
        public void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
            Assertions.checkState(!this.inputStreamEnded, "Input buffer can not be queued after the input stream has ended.");
            if (decoderInputBuffer.isEndOfStream()) {
                this.inputStreamEnded = true;
            }
            decoderInputBuffer.clear();
            decoderInputBuffer.data = null;
        }

        @Override // androidx.media3.transformer.Codec
        public void release() {
            this.placeholderSurface.release();
        }

        @Override // androidx.media3.transformer.Codec
        public void releaseOutputBuffer(long j) {
        }

        @Override // androidx.media3.transformer.Codec
        public void signalEndOfInputStream() {
            this.inputStreamEnded = true;
        }

        @Override // androidx.media3.transformer.Codec
        public void releaseOutputBuffer(boolean z) {
        }
    }

    private ExperimentalAnalyzerModeFactory() {
    }

    public static Transformer buildAnalyzer(Context context) {
        return buildAnalyzer(context, new Transformer.Builder(context).build());
    }

    public static Transformer buildAnalyzer(Context context, Transformer transformer) {
        return transformer.buildUpon().experimentalSetTrimOptimizationEnabled(false).experimentalSetMaxFramesInEncoder(-1).setEncoderFactory(new DroppingEncoder.Factory(context)).setMaxDelayBetweenMuxerSamplesMs(-9223372036854775807L).setMuxerFactory(new NoWriteMuxer.Factory(ImmutableList.of("audio/mp4a-latm"), ImmutableList.of("video/avc"))).setAudioMimeType("audio/mp4a-latm").setVideoMimeType("video/avc").build();
    }
}
