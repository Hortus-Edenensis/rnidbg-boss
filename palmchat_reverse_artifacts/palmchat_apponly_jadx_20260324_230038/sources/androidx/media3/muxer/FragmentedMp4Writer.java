package androidx.media3.muxer;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableList;
import j$.util.Objects;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class FragmentedMp4Writer {
    private final AnnexBToAvccConverter annexBToAvccConverter;
    private int currentFragmentSequenceNumber;
    private final long fragmentDurationUs;
    private boolean headerCreated;
    private final int lastSampleDurationBehavior;
    private final LinearByteBufferAllocator linearByteBufferAllocator;
    private long maxTrackDurationUs;
    private final MetadataCollector metadataCollector;
    private long minInputPresentationTimeUs;
    private int nextTrackId;
    private final WritableByteChannel outputChannel;
    private final PositionTrackingOutputStream outputStream;
    private final boolean sampleCopyEnabled;
    private final List<Track> tracks;
    private Track videoTrack;

    /* JADX INFO: compiled from: SearchBox */
    public static class ProcessedTrackInfo {
        public final boolean hasBFrame;
        public final ImmutableList<ByteBuffer> pendingSamplesByteBuffer;
        public final ImmutableList<SampleMetadata> pendingSamplesMetadata;
        public final int totalSamplesSize;
        public final Format trackFormat;
        public final int trackId;

        public ProcessedTrackInfo(int i, Format format, int i2, boolean z, ImmutableList<ByteBuffer> immutableList, ImmutableList<SampleMetadata> immutableList2) {
            this.trackId = i;
            this.trackFormat = format;
            this.totalSamplesSize = i2;
            this.hasBFrame = z;
            this.pendingSamplesByteBuffer = immutableList;
            this.pendingSamplesMetadata = immutableList2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SampleMetadata {
        public final int compositionTimeOffsetVu;
        public final int durationVu;
        public final int flags;
        public final int size;

        public SampleMetadata(int i, int i2, int i3, int i4) {
            this.durationVu = i;
            this.size = i2;
            this.flags = i3;
            this.compositionTimeOffsetVu = i4;
        }
    }

    public FragmentedMp4Writer(OutputStream outputStream, MetadataCollector metadataCollector, AnnexBToAvccConverter annexBToAvccConverter, long j, boolean z) {
        PositionTrackingOutputStream positionTrackingOutputStream = new PositionTrackingOutputStream(outputStream);
        this.outputStream = positionTrackingOutputStream;
        this.outputChannel = Channels.newChannel(positionTrackingOutputStream);
        this.metadataCollector = metadataCollector;
        this.annexBToAvccConverter = annexBToAvccConverter;
        this.fragmentDurationUs = j * 1000;
        this.sampleCopyEnabled = z;
        this.lastSampleDurationBehavior = 1;
        this.tracks = new ArrayList();
        this.minInputPresentationTimeUs = Long.MAX_VALUE;
        this.currentFragmentSequenceNumber = 1;
        this.linearByteBufferAllocator = new LinearByteBufferAllocator(0);
    }

    private static int calculateMoofBoxSize(List<ProcessedTrackInfo> list) {
        int trunBoxContentSize = 0;
        for (int i = 0; i < list.size(); i++) {
            ProcessedTrackInfo processedTrackInfo = list.get(i);
            trunBoxContentSize += 32 + 8 + Boxes.getTrunBoxContentSize(processedTrackInfo.pendingSamplesMetadata.size(), processedTrackInfo.hasBFrame);
        }
        return 24 + trunBoxContentSize;
    }

    private void createFragment() throws IOException {
        ImmutableList<ProcessedTrackInfo> immutableListProcessAllTracks = processAllTracks();
        ImmutableList<ByteBuffer> immutableListCreateTrafBoxes = createTrafBoxes(immutableListProcessAllTracks, this.outputStream.getPosition());
        if (immutableListCreateTrafBoxes.isEmpty()) {
            return;
        }
        this.outputChannel.write(Boxes.moof(Boxes.mfhd(this.currentFragmentSequenceNumber), immutableListCreateTrafBoxes));
        writeMdatBox(immutableListProcessAllTracks);
        this.currentFragmentSequenceNumber++;
        this.maxTrackDurationUs = 0L;
    }

    private void createHeader() throws IOException {
        this.outputChannel.write(Boxes.ftyp());
        this.outputChannel.write(Boxes.moov(this.tracks, this.metadataCollector, true, this.lastSampleDurationBehavior));
    }

    private static ImmutableList<ByteBuffer> createTrafBoxes(List<ProcessedTrackInfo> list, long j) {
        ImmutableList.a aVar = new ImmutableList.a();
        int iCalculateMoofBoxSize = calculateMoofBoxSize(list) + 8;
        for (int i = 0; i < list.size(); i++) {
            ProcessedTrackInfo processedTrackInfo = list.get(i);
            aVar.a(Boxes.traf(Boxes.tfhd(processedTrackInfo.trackId, j), Boxes.trun(processedTrackInfo.trackFormat, processedTrackInfo.pendingSamplesMetadata, iCalculateMoofBoxSize, processedTrackInfo.hasBFrame)));
            iCalculateMoofBoxSize += processedTrackInfo.totalSamplesSize;
        }
        return aVar.e();
    }

    private ImmutableList<ProcessedTrackInfo> processAllTracks() {
        ImmutableList.a aVar = new ImmutableList.a();
        for (int i = 0; i < this.tracks.size(); i++) {
            if (!this.tracks.get(i).pendingSamplesBufferInfo.isEmpty()) {
                aVar.a(processTrack(i + 1, this.tracks.get(i)));
            }
        }
        return aVar.e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ProcessedTrackInfo processTrack(int i, Track track) {
        Assertions.checkState(track.pendingSamplesByteBuffer.size() == track.pendingSamplesBufferInfo.size());
        ImmutableList.a aVar = new ImmutableList.a();
        ImmutableList.a aVar2 = new ImmutableList.a();
        if (AnnexBUtils.doesSampleContainAnnexBNalUnits(track.format)) {
            while (!track.pendingSamplesByteBuffer.isEmpty()) {
                ByteBuffer byteBufferProcess = this.annexBToAvccConverter.process(track.pendingSamplesByteBuffer.removeFirst(), this.linearByteBufferAllocator);
                aVar.a(byteBufferProcess);
                BufferInfo bufferInfoRemoveFirst = track.pendingSamplesBufferInfo.removeFirst();
                aVar2.a(new BufferInfo(bufferInfoRemoveFirst.presentationTimeUs, byteBufferProcess.remaining(), bufferInfoRemoveFirst.flags));
            }
        } else {
            aVar.l(track.pendingSamplesByteBuffer);
            track.pendingSamplesByteBuffer.clear();
            aVar2.l(track.pendingSamplesBufferInfo);
            track.pendingSamplesBufferInfo.clear();
        }
        ImmutableList immutableListE = aVar2.e();
        List<Integer> listConvertPresentationTimestampsToDurationsVu = Boxes.convertPresentationTimestampsToDurationsVu(immutableListE, track.videoUnitTimebase(), 1, track.endOfStreamTimestampUs);
        List<Integer> listCalculateSampleCompositionTimeOffsets = Boxes.calculateSampleCompositionTimeOffsets(immutableListE, listConvertPresentationTimestampsToDurationsVu, track.videoUnitTimebase());
        boolean z = !listCalculateSampleCompositionTimeOffsets.isEmpty();
        ImmutableList.a aVar3 = new ImmutableList.a();
        int i2 = 0;
        for (int i3 = 0; i3 < immutableListE.size(); i3++) {
            i2 += ((BufferInfo) immutableListE.get(i3)).size;
            aVar3.a(new SampleMetadata(listConvertPresentationTimestampsToDurationsVu.get(i3).intValue(), ((BufferInfo) immutableListE.get(i3)).size, ((BufferInfo) immutableListE.get(i3)).flags, z ? listCalculateSampleCompositionTimeOffsets.get(i3).intValue() : 0));
        }
        return new ProcessedTrackInfo(i, track.format, i2, z, aVar.e(), aVar3.e());
    }

    private boolean shouldFlushPendingSamples(Track track, BufferInfo bufferInfo) {
        Track track2 = this.videoTrack;
        if (track2 == null) {
            return this.maxTrackDurationUs >= this.fragmentDurationUs;
        }
        if (track.equals(track2) && track.hadKeyframe && (bufferInfo.flags & 1) > 0) {
            return ((BufferInfo) Assertions.checkNotNull(track.pendingSamplesBufferInfo.peekLast())).presentationTimeUs - ((BufferInfo) Assertions.checkNotNull(track.pendingSamplesBufferInfo.peekFirst())).presentationTimeUs >= this.fragmentDurationUs;
        }
        return false;
    }

    private void writeMdatBox(List<ProcessedTrackInfo> list) throws IOException {
        long jRemaining = 0;
        for (int i = 0; i < list.size(); i++) {
            ProcessedTrackInfo processedTrackInfo = list.get(i);
            for (int i2 = 0; i2 < processedTrackInfo.pendingSamplesByteBuffer.size(); i2++) {
                jRemaining += (long) processedTrackInfo.pendingSamplesByteBuffer.get(i2).remaining();
            }
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        long j = ((long) 8) + jRemaining;
        Assertions.checkArgument(j <= MuxerUtil.UNSIGNED_INT_MAX_VALUE, "Only 32-bit long mdat size supported in the fragmented MP4");
        byteBufferAllocate.putInt((int) j);
        byteBufferAllocate.put(Util.getUtf8Bytes("mdat"));
        byteBufferAllocate.flip();
        this.outputChannel.write(byteBufferAllocate);
        for (int i3 = 0; i3 < list.size(); i3++) {
            ProcessedTrackInfo processedTrackInfo2 = list.get(i3);
            for (int i4 = 0; i4 < processedTrackInfo2.pendingSamplesByteBuffer.size(); i4++) {
                this.outputChannel.write(processedTrackInfo2.pendingSamplesByteBuffer.get(i4));
            }
        }
        this.linearByteBufferAllocator.reset();
    }

    public Track addTrack(int i, Format format) {
        int i2 = this.nextTrackId;
        this.nextTrackId = i2 + 1;
        Track track = new Track(i2, format, this.sampleCopyEnabled);
        this.tracks.add(track);
        if (MimeTypes.isVideo(format.sampleMimeType)) {
            this.videoTrack = track;
        }
        return track;
    }

    public void close() throws IOException {
        try {
            createFragment();
        } finally {
            this.outputChannel.close();
            this.outputStream.close();
        }
    }

    public void writeSampleData(Track track, ByteBuffer byteBuffer, BufferInfo bufferInfo) throws IOException {
        if (Objects.equals(track.format.sampleMimeType, "video/av01") && track.format.initializationData.isEmpty() && track.parsedCsd == null) {
            track.parsedCsd = Av1ConfigUtil.createAv1CodecConfigurationRecord(byteBuffer.duplicate());
        }
        if (!this.headerCreated) {
            createHeader();
            this.headerCreated = true;
        }
        if (shouldFlushPendingSamples(track, bufferInfo)) {
            createFragment();
        }
        track.writeSampleData(byteBuffer, bufferInfo);
        BufferInfo bufferInfo2 = (BufferInfo) Assertions.checkNotNull(track.pendingSamplesBufferInfo.peekFirst());
        BufferInfo bufferInfo3 = (BufferInfo) Assertions.checkNotNull(track.pendingSamplesBufferInfo.peekLast());
        this.minInputPresentationTimeUs = Math.min(this.minInputPresentationTimeUs, bufferInfo2.presentationTimeUs);
        this.maxTrackDurationUs = Math.max(this.maxTrackDurationUs, bufferInfo3.presentationTimeUs - bufferInfo2.presentationTimeUs);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class PositionTrackingOutputStream extends OutputStream {
        private final OutputStream outputStream;
        private long position = 0;

        public PositionTrackingOutputStream(OutputStream outputStream) {
            this.outputStream = outputStream;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.outputStream.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            this.outputStream.flush();
        }

        public long getPosition() {
            return this.position;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.position++;
            this.outputStream.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.position += (long) bArr.length;
            this.outputStream.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.position += (long) i2;
            this.outputStream.write(bArr, i, i2);
        }
    }
}
