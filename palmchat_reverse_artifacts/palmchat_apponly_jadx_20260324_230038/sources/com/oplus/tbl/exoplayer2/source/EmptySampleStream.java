package com.oplus.tbl.exoplayer2.source;

import com.oplus.tbl.exoplayer2.FormatHolder;
import com.oplus.tbl.exoplayer2.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class EmptySampleStream implements SampleStream {
    @Override // com.oplus.tbl.exoplayer2.source.SampleStream
    public boolean isReady() {
        return true;
    }

    @Override // com.oplus.tbl.exoplayer2.source.SampleStream
    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z) {
        decoderInputBuffer.setFlags(4);
        return -4;
    }

    @Override // com.oplus.tbl.exoplayer2.source.SampleStream
    public int skipData(long j) {
        return 0;
    }

    @Override // com.oplus.tbl.exoplayer2.source.SampleStream
    public void maybeThrowError() {
    }
}
