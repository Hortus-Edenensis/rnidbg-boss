package com.oplus.tbl.exoplayer2.extractor.jpeg;

import com.oplus.tbl.exoplayer2.extractor.ExtractorInput;
import com.oplus.tbl.exoplayer2.extractor.ForwardingExtractorInput;
import com.oplus.tbl.exoplayer2.util.Assertions;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class StartOffsetExtractorInput extends ForwardingExtractorInput {
    private final long startOffset;

    public StartOffsetExtractorInput(ExtractorInput extractorInput, long j) {
        super(extractorInput);
        Assertions.checkArgument(extractorInput.getPosition() >= j);
        this.startOffset = j;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ForwardingExtractorInput, com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public long getLength() {
        return super.getLength() - this.startOffset;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ForwardingExtractorInput, com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public long getPeekPosition() {
        return super.getPeekPosition() - this.startOffset;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ForwardingExtractorInput, com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public long getPosition() {
        return super.getPosition() - this.startOffset;
    }

    @Override // com.oplus.tbl.exoplayer2.extractor.ForwardingExtractorInput, com.oplus.tbl.exoplayer2.extractor.ExtractorInput
    public <E extends Throwable> void setRetryPosition(long j, E e) throws Throwable {
        super.setRetryPosition(j + this.startOffset, e);
    }
}
