package androidx.media3.transformer;

import androidx.annotation.Nullable;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.muxer.MuxerException;
import androidx.media3.transformer.MuxerWrapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
abstract class SampleExporter {

    @Nullable
    private final Metadata metadata;
    private final MuxerWrapper muxerWrapper;
    private boolean muxerWrapperTrackAdded;
    private final int outputTrackType;

    public SampleExporter(Format format, MuxerWrapper muxerWrapper) {
        this.muxerWrapper = muxerWrapper;
        this.metadata = format.metadata;
        this.outputTrackType = TransformerUtil.getProcessedTrackType(format.sampleMimeType);
    }

    private boolean feedMuxer() throws ExportException {
        if (!this.muxerWrapperTrackAdded) {
            Format muxerInputFormat = getMuxerInputFormat();
            if (muxerInputFormat == null) {
                return false;
            }
            if (this.metadata != null) {
                muxerInputFormat = muxerInputFormat.buildUpon().setMetadata(this.metadata).build();
            }
            if (!this.muxerWrapper.supportsSampleMimeType(muxerInputFormat.sampleMimeType)) {
                String alternativeCodecMimeType = MediaCodecUtil.getAlternativeCodecMimeType(muxerInputFormat);
                if (this.muxerWrapper.supportsSampleMimeType(alternativeCodecMimeType)) {
                    muxerInputFormat = muxerInputFormat.buildUpon().setSampleMimeType(alternativeCodecMimeType).build();
                }
            }
            try {
                this.muxerWrapper.addTrackFormat(muxerInputFormat);
                this.muxerWrapperTrackAdded = true;
            } catch (MuxerException e) {
                throw ExportException.createForMuxer(e, 7001);
            } catch (MuxerWrapper.AppendTrackFormatException e2) {
                throw ExportException.createForMuxer(e2, ExportException.ERROR_CODE_MUXING_APPEND);
            }
        }
        if (isMuxerInputEnded()) {
            this.muxerWrapper.endTrack(this.outputTrackType);
            return false;
        }
        DecoderInputBuffer muxerInputBuffer = getMuxerInputBuffer();
        if (muxerInputBuffer == null) {
            return false;
        }
        try {
            if (!this.muxerWrapper.writeSample(this.outputTrackType, (ByteBuffer) Assertions.checkStateNotNull(muxerInputBuffer.data), muxerInputBuffer.isKeyFrame(), muxerInputBuffer.timeUs)) {
                return false;
            }
            releaseMuxerInputBuffer();
            return true;
        } catch (MuxerException e3) {
            throw ExportException.createForMuxer(e3, 7001);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static String findSupportedMimeTypeForEncoderAndMuxer(Format format, List<String> list) {
        boolean zIsVideo = MimeTypes.isVideo((String) Assertions.checkNotNull(format.sampleMimeType));
        ImmutableSet.a aVarA = new ImmutableSet.a().a(format.sampleMimeType);
        if (zIsVideo) {
            aVarA.a("video/hevc").a("video/avc");
        }
        aVarA.l(list);
        ImmutableList immutableListAsList = aVarA.e().asList();
        for (int i = 0; i < immutableListAsList.size(); i++) {
            String str = (String) immutableListAsList.get(i);
            if (list.contains(str)) {
                if (zIsVideo && ColorInfo.isTransferHdr(format.colorInfo)) {
                    if (!EncoderUtil.getSupportedEncodersForHdrEditing(str, format.colorInfo).isEmpty()) {
                        return str;
                    }
                } else if (!EncoderUtil.getSupportedEncoders(str).isEmpty()) {
                    return str;
                }
            }
        }
        return null;
    }

    public abstract GraphInput getInput(EditedMediaItem editedMediaItem, Format format, int i) throws ExportException;

    @Nullable
    public abstract DecoderInputBuffer getMuxerInputBuffer() throws ExportException;

    @Nullable
    public abstract Format getMuxerInputFormat() throws ExportException;

    public abstract boolean isMuxerInputEnded();

    public final boolean processData() throws ExportException {
        return feedMuxer() || (!isMuxerInputEnded() && processDataUpToMuxer());
    }

    public boolean processDataUpToMuxer() throws ExportException {
        return false;
    }

    public abstract void release();

    public abstract void releaseMuxerInputBuffer() throws ExportException;
}
