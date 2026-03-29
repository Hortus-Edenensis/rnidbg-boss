package androidx.media3.transformer;

import android.media.MediaCodec;
import android.media.metrics.LogSessionId;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface Codec {

    /* JADX INFO: compiled from: SearchBox */
    public interface DecoderFactory {
        Codec createForAudioDecoding(Format format, @Nullable LogSessionId logSessionId) throws ExportException;

        Codec createForVideoDecoding(Format format, Surface surface, boolean z, @Nullable LogSessionId logSessionId) throws ExportException;
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface EncoderFactory {
        boolean audioNeedsEncoding();

        Codec createForAudioEncoding(Format format, @Nullable LogSessionId logSessionId) throws ExportException;

        Codec createForVideoEncoding(Format format, @Nullable LogSessionId logSessionId) throws ExportException;

        boolean videoNeedsEncoding();
    }

    Format getConfigurationFormat();

    Format getInputFormat() throws ExportException;

    Surface getInputSurface();

    int getMaxPendingFrameCount();

    String getName();

    @Nullable
    ByteBuffer getOutputBuffer() throws ExportException;

    @Nullable
    MediaCodec.BufferInfo getOutputBufferInfo() throws ExportException;

    @Nullable
    Format getOutputFormat() throws ExportException;

    boolean isEnded();

    boolean maybeDequeueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExportException;

    void queueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExportException;

    void release();

    void releaseOutputBuffer(long j) throws ExportException;

    void releaseOutputBuffer(boolean z) throws ExportException;

    void signalEndOfInputStream() throws ExportException;
}
