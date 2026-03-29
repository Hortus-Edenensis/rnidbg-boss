package com.oplus.tbl.exoplayer2.extractor.flv;

import com.oplus.tbl.exoplayer2.ParserException;
import com.oplus.tbl.exoplayer2.extractor.TrackOutput;
import com.oplus.tbl.exoplayer2.util.ParsableByteArray;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
abstract class TagPayloadReader {
    protected final TrackOutput output;

    /* JADX INFO: compiled from: SearchBox */
    public static final class UnsupportedFormatException extends ParserException {
        public UnsupportedFormatException(String str) {
            super(str);
        }
    }

    public TagPayloadReader(TrackOutput trackOutput) {
        this.output = trackOutput;
    }

    public final boolean consume(ParsableByteArray parsableByteArray, long j) throws ParserException {
        return parseHeader(parsableByteArray) && parsePayload(parsableByteArray, j);
    }

    public abstract boolean parseHeader(ParsableByteArray parsableByteArray) throws ParserException;

    public abstract boolean parsePayload(ParsableByteArray parsableByteArray, long j) throws ParserException;

    public abstract void seek();
}
