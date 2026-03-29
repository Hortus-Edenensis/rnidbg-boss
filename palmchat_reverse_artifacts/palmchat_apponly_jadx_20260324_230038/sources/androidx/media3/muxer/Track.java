package androidx.media3.muxer;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class Track {
    public long endOfStreamTimestampUs;
    public final Format format;
    public boolean hadKeyframe;
    public final int id;

    @Nullable
    public byte[] parsedCsd;
    public final Deque<BufferInfo> pendingSamplesBufferInfo;
    public final Deque<ByteBuffer> pendingSamplesByteBuffer;
    private final boolean sampleCopyEnabled;
    public final int sortKey;
    public final List<Long> writtenChunkOffsets;
    public final List<Integer> writtenChunkSampleCounts;
    public final List<BufferInfo> writtenSamples;

    public Track(int i, Format format, boolean z) {
        this(i, format, 1, z);
    }

    public int videoUnitTimebase() {
        return MimeTypes.isAudio(this.format.sampleMimeType) ? 48000 : 90000;
    }

    public void writeSampleData(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        Assertions.checkArgument(this.endOfStreamTimestampUs == -9223372036854775807L, "Samples can not be written after writing a sample with MediaCodec.BUFFER_FLAG_END_OF_STREAM flag");
        if (bufferInfo.size == 0 || byteBuffer.remaining() == 0) {
            if ((bufferInfo.flags & 4) != 0) {
                this.endOfStreamTimestampUs = bufferInfo.presentationTimeUs;
                return;
            }
            return;
        }
        if ((bufferInfo.flags & 1) > 0) {
            this.hadKeyframe = true;
        }
        if (this.hadKeyframe || !MimeTypes.isVideo(this.format.sampleMimeType)) {
            if (this.sampleCopyEnabled) {
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteBuffer.remaining());
                byteBufferAllocateDirect.put(byteBuffer);
                byteBufferAllocateDirect.rewind();
                byteBuffer = byteBufferAllocateDirect;
            }
            this.pendingSamplesBufferInfo.addLast(new BufferInfo(bufferInfo.presentationTimeUs, byteBuffer.remaining(), bufferInfo.flags));
            this.pendingSamplesByteBuffer.addLast(byteBuffer);
        }
    }

    public Track(int i, Format format, int i2, boolean z) {
        this.id = i;
        this.format = format;
        this.sortKey = i2;
        this.sampleCopyEnabled = z;
        this.writtenSamples = new ArrayList();
        this.writtenChunkOffsets = new ArrayList();
        this.writtenChunkSampleCounts = new ArrayList();
        this.pendingSamplesBufferInfo = new ArrayDeque();
        this.pendingSamplesByteBuffer = new ArrayDeque();
        this.endOfStreamTimestampUs = -9223372036854775807L;
    }
}
