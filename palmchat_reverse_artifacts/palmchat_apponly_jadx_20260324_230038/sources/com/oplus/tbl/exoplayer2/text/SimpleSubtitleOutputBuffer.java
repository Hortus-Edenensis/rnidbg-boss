package com.oplus.tbl.exoplayer2.text;

import com.oplus.tbl.exoplayer2.decoder.OutputBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class SimpleSubtitleOutputBuffer extends SubtitleOutputBuffer {
    private final OutputBuffer.Owner<SubtitleOutputBuffer> owner;

    public SimpleSubtitleOutputBuffer(OutputBuffer.Owner<SubtitleOutputBuffer> owner) {
        this.owner = owner;
    }

    @Override // com.oplus.tbl.exoplayer2.decoder.OutputBuffer
    public final void release() {
        this.owner.releaseOutputBuffer(this);
    }
}
