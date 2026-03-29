package androidx.media3.muxer;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.container.MdtaMetadataEntry;
import com.google.common.collect.Range;
import j$.util.Objects;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class Mp4Writer {
    private static final int DEFAULT_MOOV_BOX_SIZE_BYTES = 400000;
    private static final String FREE_BOX_TYPE = "free";
    private static final long INTERLEAVE_DURATION_US = 1000000;
    private static final long MOOV_BOX_UPDATE_INTERVAL_US = 1000000;
    private final AnnexBToAvccConverter annexBToAvccConverter;
    private final List<Track> auxiliaryTracks;
    private boolean canWriteMoovAtStart;
    private final int freeSpaceAfterFtypInBytes;
    private final AtomicBoolean hasWrittenSamples;
    private Range<Long> lastMoovWritten;
    private long lastMoovWrittenAtSampleTimestampUs;
    private final int lastSampleDurationBehavior;
    private final LinearByteBufferAllocator linearByteBufferAllocator;
    private long mdatDataEnd;
    private long mdatEnd;
    private long mdatStart;
    private final MetadataCollector metadataCollector;
    private final FileChannel outputFileChannel;
    private long reservedMoovSpaceEnd;
    private long reservedMoovSpaceStart;
    private final boolean sampleBatchingEnabled;
    private final boolean sampleCopyEnabled;
    private final List<Track> tracks;

    public Mp4Writer(FileChannel fileChannel, MetadataCollector metadataCollector, AnnexBToAvccConverter annexBToAvccConverter, int i, boolean z, boolean z2, boolean z3, int i2) {
        this.outputFileChannel = fileChannel;
        this.metadataCollector = metadataCollector;
        this.annexBToAvccConverter = annexBToAvccConverter;
        this.lastSampleDurationBehavior = i;
        this.sampleCopyEnabled = z;
        this.sampleBatchingEnabled = z2;
        this.freeSpaceAfterFtypInBytes = i2 <= 0 ? z3 ? 400000 : 0 : i2;
        this.tracks = new ArrayList();
        this.auxiliaryTracks = new ArrayList();
        this.hasWrittenSamples = new AtomicBoolean(false);
        this.canWriteMoovAtStart = z3;
        this.lastMoovWritten = Range.closed(0L, 0L);
        this.lastMoovWrittenAtSampleTimestampUs = 0L;
        this.linearByteBufferAllocator = new LinearByteBufferAllocator(0);
    }

    private ByteBuffer assembleCurrentMoovData() {
        return Boxes.moov(this.tracks, this.metadataCollector, false, this.lastSampleDurationBehavior);
    }

    private void doInterleave() throws IOException {
        boolean zMaybeWritePendingTrackSamples = maybeWritePendingTrackSamples(this.tracks);
        maybeWritePendingTrackSamples(this.auxiliaryTracks);
        if (zMaybeWritePendingTrackSamples && this.canWriteMoovAtStart) {
            maybeWriteMoovAtStart();
        }
    }

    private ByteBuffer getAxteBox() {
        ByteBuffer byteBufferFtyp = Boxes.ftyp();
        MetadataCollector metadataCollector = new MetadataCollector();
        MuxerUtil.populateAuxiliaryTracksMetadata(metadataCollector, this.metadataCollector.timestampData, true, this.auxiliaryTracks);
        return BoxUtils.concatenateBuffers(Boxes.getAxteBoxHeader(byteBufferFtyp.remaining() + r1.remaining()), byteBufferFtyp, Boxes.moov(this.auxiliaryTracks, metadataCollector, false, this.lastSampleDurationBehavior));
    }

    private long getMdatExtensionAmount(long j) {
        return Math.min(1000000000L, Math.max(500000L, (long) (j * 0.2f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$addAuxiliaryTrack$1(Track track, Track track2) {
        return Integer.compare(track.sortKey, track2.sortKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$addTrack$0(Track track, Track track2) {
        return Integer.compare(track.sortKey, track2.sortKey);
    }

    private void maybeExtendMdatAndRewriteMoov(long j) throws IOException {
        if (this.canWriteMoovAtStart) {
            return;
        }
        long j2 = this.mdatDataEnd;
        if (j2 + j >= this.mdatEnd) {
            rewriteMoovWithMdatEmptySpace(getMdatExtensionAmount(j2) + j);
        }
    }

    private void maybeWriteMoovAtStart() throws IOException {
        ByteBuffer byteBufferAssembleCurrentMoovData = assembleCurrentMoovData();
        int iRemaining = byteBufferAssembleCurrentMoovData.remaining();
        long jRemaining = byteBufferAssembleCurrentMoovData.remaining() + 8;
        long j = this.reservedMoovSpaceEnd;
        long j2 = this.reservedMoovSpaceStart;
        if (jRemaining <= j - j2) {
            this.outputFileChannel.position(j2);
            this.outputFileChannel.write(byteBufferAssembleCurrentMoovData);
            this.outputFileChannel.write(BoxUtils.wrapIntoBox(FREE_BOX_TYPE, ByteBuffer.allocate((int) ((this.reservedMoovSpaceEnd - this.outputFileChannel.position()) - 8))));
        } else {
            this.canWriteMoovAtStart = false;
            long j3 = this.mdatDataEnd;
            this.mdatEnd = j3;
            this.outputFileChannel.position(j3);
            this.outputFileChannel.write(byteBufferAssembleCurrentMoovData);
            this.lastMoovWritten = Range.closed(Long.valueOf(this.mdatEnd), Long.valueOf(this.mdatEnd + ((long) iRemaining)));
            this.outputFileChannel.write(BoxUtils.wrapIntoBox(FREE_BOX_TYPE, ByteBuffer.allocate((int) ((this.reservedMoovSpaceEnd - this.reservedMoovSpaceStart) - 8))), this.reservedMoovSpaceStart);
        }
        updateMdatSize(this.mdatDataEnd - this.mdatStart);
    }

    private boolean maybeWritePendingTrackSamples(List<Track> list) throws IOException {
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            Track track = list.get(i);
            if (track.pendingSamplesBufferInfo.size() > 2) {
                if (((BufferInfo) Assertions.checkNotNull(track.pendingSamplesBufferInfo.peekLast())).presentationTimeUs - ((BufferInfo) Assertions.checkNotNull(track.pendingSamplesBufferInfo.peekFirst())).presentationTimeUs > 1000000) {
                    writePendingTrackSamples(track);
                    z = true;
                }
            }
        }
        return z;
    }

    private void rewriteMoovWithMdatEmptySpace(long j) throws IOException {
        safelyReplaceMoovAtEnd(Math.max(this.mdatEnd + j, ((Long) this.lastMoovWritten.upperEndpoint()).longValue()), assembleCurrentMoovData());
    }

    private void safelyReplaceMoovAtEnd(long j, ByteBuffer byteBuffer) throws IOException {
        Assertions.checkState(j >= ((Long) this.lastMoovWritten.upperEndpoint()).longValue());
        Assertions.checkState(j >= this.mdatEnd);
        this.outputFileChannel.position(j);
        this.outputFileChannel.write(BoxUtils.wrapIntoBox(FREE_BOX_TYPE, byteBuffer.duplicate()));
        long j2 = 8 + j;
        this.mdatEnd = j2;
        updateMdatSize(j2 - this.mdatStart);
        this.lastMoovWritten = Range.closed(Long.valueOf(j), Long.valueOf(j + ((long) byteBuffer.remaining())));
    }

    private void updateMdatSize(long j) throws IOException {
        this.outputFileChannel.position(this.mdatStart + 8);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putLong(j);
        byteBufferAllocate.flip();
        this.outputFileChannel.write(byteBufferAllocate);
    }

    private void writeAxteBox() throws IOException {
        MdtaMetadataEntry auxiliaryTracksOffsetMetadata = MuxerUtil.getAuxiliaryTracksOffsetMetadata(0L);
        this.metadataCollector.addMetadata(auxiliaryTracksOffsetMetadata);
        ByteBuffer axteBox = getAxteBox();
        this.metadataCollector.addMetadata(MuxerUtil.getAuxiliaryTracksLengthMetadata(axteBox.remaining()));
        finalizeMoovBox();
        this.metadataCollector.removeMdtaMetadataEntry(auxiliaryTracksOffsetMetadata);
        this.metadataCollector.addMetadata(MuxerUtil.getAuxiliaryTracksOffsetMetadata(this.outputFileChannel.size()));
        long size = this.outputFileChannel.size();
        finalizeMoovBox();
        Assertions.checkState(size == this.outputFileChannel.size());
        FileChannel fileChannel = this.outputFileChannel;
        fileChannel.position(fileChannel.size());
        this.outputFileChannel.write(axteBox);
    }

    private void writeHeader() throws IOException {
        this.outputFileChannel.position(0L);
        this.outputFileChannel.write(Boxes.ftyp());
        if (this.freeSpaceAfterFtypInBytes > 0) {
            this.reservedMoovSpaceStart = this.outputFileChannel.position();
            this.outputFileChannel.write(BoxUtils.wrapIntoBox(FREE_BOX_TYPE, ByteBuffer.allocate(this.freeSpaceAfterFtypInBytes)));
            this.reservedMoovSpaceEnd = this.outputFileChannel.position();
        }
        this.mdatStart = this.outputFileChannel.position();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        byteBufferAllocate.putInt(1);
        byteBufferAllocate.put(Util.getUtf8Bytes("mdat"));
        byteBufferAllocate.putLong(16L);
        byteBufferAllocate.flip();
        this.outputFileChannel.write(byteBufferAllocate);
        long j = this.mdatStart + 16;
        this.mdatDataEnd = j;
        if (this.canWriteMoovAtStart) {
            j = Long.MAX_VALUE;
        }
        this.mdatEnd = j;
    }

    private void writePendingTrackSamples(Track track) throws IOException {
        Assertions.checkState(track.pendingSamplesByteBuffer.size() == track.pendingSamplesBufferInfo.size());
        if (track.pendingSamplesBufferInfo.isEmpty()) {
            return;
        }
        if (!this.hasWrittenSamples.getAndSet(true)) {
            writeHeader();
        }
        Iterator<ByteBuffer> it = track.pendingSamplesByteBuffer.iterator();
        long jLimit = 0;
        while (it.hasNext()) {
            jLimit += (long) it.next().limit();
        }
        maybeExtendMdatAndRewriteMoov(jLimit);
        track.writtenChunkOffsets.add(Long.valueOf(this.mdatDataEnd));
        track.writtenChunkSampleCounts.add(Integer.valueOf(track.pendingSamplesBufferInfo.size()));
        do {
            BufferInfo bufferInfoRemoveFirst = track.pendingSamplesBufferInfo.removeFirst();
            ByteBuffer byteBufferRemoveFirst = track.pendingSamplesByteBuffer.removeFirst();
            if (AnnexBUtils.doesSampleContainAnnexBNalUnits(track.format)) {
                byteBufferRemoveFirst = this.annexBToAvccConverter.process(byteBufferRemoveFirst, this.linearByteBufferAllocator);
                bufferInfoRemoveFirst = new BufferInfo(bufferInfoRemoveFirst.presentationTimeUs, byteBufferRemoveFirst.remaining(), bufferInfoRemoveFirst.flags);
            }
            maybeExtendMdatAndRewriteMoov(byteBufferRemoveFirst.remaining());
            long j = this.mdatDataEnd;
            this.mdatDataEnd = j + ((long) this.outputFileChannel.write(byteBufferRemoveFirst, j));
            this.linearByteBufferAllocator.reset();
            track.writtenSamples.add(bufferInfoRemoveFirst);
        } while (!track.pendingSamplesBufferInfo.isEmpty());
        Assertions.checkState(this.mdatDataEnd <= this.mdatEnd);
    }

    public Track addAuxiliaryTrack(int i, int i2, Format format) {
        Track track = new Track(i, format, i2, this.sampleCopyEnabled);
        this.auxiliaryTracks.add(track);
        Collections.sort(this.auxiliaryTracks, new Comparator() { // from class: androidx.media3.muxer.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Mp4Writer.lambda$addAuxiliaryTrack$1((Track) obj, (Track) obj2);
            }
        });
        return track;
    }

    public Track addTrack(int i, int i2, Format format) {
        Track track = new Track(i, format, i2, this.sampleCopyEnabled);
        this.tracks.add(track);
        Collections.sort(this.tracks, new Comparator() { // from class: androidx.media3.muxer.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Mp4Writer.lambda$addTrack$0((Track) obj, (Track) obj2);
            }
        });
        return track;
    }

    public void finalizeMoovBox() throws IOException {
        if (this.canWriteMoovAtStart) {
            maybeWriteMoovAtStart();
            return;
        }
        ByteBuffer byteBufferAssembleCurrentMoovData = assembleCurrentMoovData();
        int iRemaining = byteBufferAssembleCurrentMoovData.remaining();
        long j = iRemaining + 8;
        if (this.mdatEnd - this.mdatDataEnd < j) {
            safelyReplaceMoovAtEnd(((Long) this.lastMoovWritten.upperEndpoint()).longValue() + j, byteBufferAssembleCurrentMoovData);
            Assertions.checkState(this.mdatEnd - this.mdatDataEnd >= j);
        }
        long j2 = this.mdatDataEnd;
        this.outputFileChannel.position(j2);
        this.outputFileChannel.write(byteBufferAssembleCurrentMoovData);
        long j3 = ((long) iRemaining) + j2;
        long jLongValue = ((Long) this.lastMoovWritten.upperEndpoint()).longValue() - j3;
        Assertions.checkState(jLongValue < 2147483647L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.putInt((int) jLongValue);
        byteBufferAllocate.put(Util.getUtf8Bytes(FREE_BOX_TYPE));
        byteBufferAllocate.flip();
        this.outputFileChannel.write(byteBufferAllocate);
        this.mdatEnd = j2;
        updateMdatSize(j2 - this.mdatStart);
        this.lastMoovWritten = Range.closed(Long.valueOf(j2), Long.valueOf(j2 + ((long) byteBufferAssembleCurrentMoovData.limit())));
        this.outputFileChannel.truncate(j3);
    }

    public void finishWritingSamplesAndFinalizeMoovBox() throws IOException {
        for (int i = 0; i < this.tracks.size(); i++) {
            writePendingTrackSamples(this.tracks.get(i));
        }
        for (int i2 = 0; i2 < this.auxiliaryTracks.size(); i2++) {
            writePendingTrackSamples(this.auxiliaryTracks.get(i2));
        }
        if (this.hasWrittenSamples.get()) {
            finalizeMoovBox();
            if (this.auxiliaryTracks.isEmpty()) {
                return;
            }
            writeAxteBox();
        }
    }

    public void writeSampleData(Track track, ByteBuffer byteBuffer, BufferInfo bufferInfo) throws IOException {
        if (Objects.equals(track.format.sampleMimeType, "video/av01") && track.format.initializationData.isEmpty() && track.parsedCsd == null) {
            track.parsedCsd = Av1ConfigUtil.createAv1CodecConfigurationRecord(byteBuffer.duplicate());
        }
        track.writeSampleData(byteBuffer, bufferInfo);
        if (this.sampleBatchingEnabled) {
            doInterleave();
            return;
        }
        writePendingTrackSamples(track);
        boolean zContains = this.tracks.contains(track);
        long j = bufferInfo.presentationTimeUs;
        if (zContains && this.canWriteMoovAtStart && j - this.lastMoovWrittenAtSampleTimestampUs >= 1000000) {
            maybeWriteMoovAtStart();
            this.lastMoovWrittenAtSampleTimestampUs = j;
        }
    }
}
