package com.oplus.tbl.exoplayer2.extractor.mkv;

import com.oplus.tbl.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
interface EbmlReader {
    void init(EbmlProcessor ebmlProcessor);

    boolean read(ExtractorInput extractorInput) throws IOException;

    void reset();
}
