package com.kwad.sdk.pngencrypt.chunk;

import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class f extends e {
    private final List<PngChunk> baT;

    @Override // com.kwad.sdk.pngencrypt.chunk.e
    public final String toString() {
        return "ChunkList: written: " + Qs().size() + " queue: " + this.baT.size();
    }
}
