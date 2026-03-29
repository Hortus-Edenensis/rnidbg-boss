package com.oplus.tbl.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.ParserException;
import com.oplus.tbl.exoplayer2.extractor.ExtractorOutput;
import com.oplus.tbl.exoplayer2.extractor.ts.TsPayloadReader;
import com.oplus.tbl.exoplayer2.util.ParsableByteArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PrivateDataReader implements ElementaryStreamReader {
    private static final int BUFFER_SIZE = 9400;

    @Nullable
    private XindxReader privateDataConsumer;
    private final ParsableByteArray privateDataScratch;
    private int sampleBytesRead;
    private boolean writingSample;

    public PrivateDataReader() {
        this(null);
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) throws ParserException {
        if (this.writingSample) {
            int iBytesLeft = parsableByteArray.bytesLeft();
            this.sampleBytesRead += iBytesLeft;
            if (this.privateDataScratch.capacity() < this.sampleBytesRead) {
                ParsableByteArray parsableByteArray2 = this.privateDataScratch;
                parsableByteArray2.ensureCapacity(Math.max(parsableByteArray2.capacity() * 2, this.sampleBytesRead));
            }
            parsableByteArray.readBytes(this.privateDataScratch.getData(), this.privateDataScratch.limit(), iBytesLeft);
            this.privateDataScratch.setLimit(this.sampleBytesRead);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        XindxReader xindxReader = this.privateDataConsumer;
        if (xindxReader != null) {
            xindxReader.init(extractorOutput, trackIdGenerator);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
        if (this.writingSample) {
            this.writingSample = false;
            XindxReader xindxReader = this.privateDataConsumer;
            if (xindxReader != null) {
                xindxReader.consume(this.privateDataScratch);
            }
        }
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.writingSample = true;
        this.sampleBytesRead = 0;
        this.privateDataScratch.setLimit(0);
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        this.writingSample = false;
    }

    public PrivateDataReader(@Nullable XindxReader xindxReader) {
        this.privateDataScratch = new ParsableByteArray(9400);
        this.privateDataConsumer = xindxReader;
    }
}
