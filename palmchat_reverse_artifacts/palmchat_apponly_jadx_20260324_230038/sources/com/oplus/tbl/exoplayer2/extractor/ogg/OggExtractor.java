package com.oplus.tbl.exoplayer2.extractor.ogg;

import android.net.Uri;
import com.oplus.tbl.exoplayer2.ParserException;
import com.oplus.tbl.exoplayer2.extractor.Extractor;
import com.oplus.tbl.exoplayer2.extractor.ExtractorInput;
import com.oplus.tbl.exoplayer2.extractor.ExtractorOutput;
import com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory;
import com.oplus.tbl.exoplayer2.extractor.PositionHolder;
import com.oplus.tbl.exoplayer2.extractor.TrackOutput;
import com.oplus.tbl.exoplayer2.extractor.ogg.OggExtractor;
import com.oplus.tbl.exoplayer2.util.Assertions;
import com.oplus.tbl.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class OggExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: e64
        @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory
        public final Extractor[] createExtractors() {
            return OggExtractor.lambda$static$0();
        }

        @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorsFactory
        public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
            return ws1.a(this, uri, map);
        }
    };
    private static final int MAX_VERIFICATION_BYTES = 8;
    private ExtractorOutput output;
    private StreamReader streamReader;
    private boolean streamReaderInitialized;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new OggExtractor()};
    }

    private static ParsableByteArray resetPosition(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(0);
        return parsableByteArray;
    }

    private boolean sniffInternal(ExtractorInput extractorInput) throws IOException {
        StreamReader opusReader;
        OggPageHeader oggPageHeader = new OggPageHeader();
        if (oggPageHeader.populate(extractorInput, true) && (oggPageHeader.type & 2) == 2) {
            int iMin = Math.min(oggPageHeader.bodySize, 8);
            ParsableByteArray parsableByteArray = new ParsableByteArray(iMin);
            extractorInput.peekFully(parsableByteArray.getData(), 0, iMin);
            if (FlacReader.verifyBitstreamType(resetPosition(parsableByteArray))) {
                opusReader = new FlacReader();
            } else if (VorbisReader.verifyBitstreamType(resetPosition(parsableByteArray))) {
                opusReader = new VorbisReader();
            } else if (OpusReader.verifyBitstreamType(resetPosition(parsableByteArray))) {
                opusReader = new OpusReader();
            }
            this.streamReader = opusReader;
            return true;
        }
        return false;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.checkStateNotNull(this.output);
        if (this.streamReader == null) {
            if (!sniffInternal(extractorInput)) {
                throw new ParserException("Failed to determine bitstream type");
            }
            extractorInput.resetPeekPosition();
        }
        if (!this.streamReaderInitialized) {
            TrackOutput trackOutputTrack = this.output.track(0, 1);
            this.output.endTracks();
            this.streamReader.init(this.output, trackOutputTrack);
            this.streamReaderInitialized = true;
        }
        return this.streamReader.read(extractorInput, positionHolder);
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.Extractor
    public void seek(long j, long j2) {
        StreamReader streamReader = this.streamReader;
        if (streamReader != null) {
            streamReader.seek(j, j2);
        }
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        try {
            return sniffInternal(extractorInput);
        } catch (ParserException unused) {
            return false;
        }
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.Extractor
    public void release() {
    }
}
