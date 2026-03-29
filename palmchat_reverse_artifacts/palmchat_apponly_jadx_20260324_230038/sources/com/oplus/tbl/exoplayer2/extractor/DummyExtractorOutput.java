package com.oplus.tbl.exoplayer2.extractor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class DummyExtractorOutput implements ExtractorOutput {
    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorOutput
    public TrackOutput track(int i, int i2) {
        return new DummyTrackOutput();
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorOutput
    public void endTracks() {
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ExtractorOutput
    public void seekMap(SeekMap seekMap) {
    }
}
