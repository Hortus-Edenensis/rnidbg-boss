package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class l extends p {
    private long bbi;
    private long bbj;
    private int bbk;

    public l(com.kwad.sdk.pngencrypt.k kVar) {
        super("oFFs", kVar);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 9) {
            throw new PngjException("bad chunk length " + dVar);
        }
        long jG = com.kwad.sdk.pngencrypt.n.g(dVar.data, 0);
        this.bbi = jG;
        if (jG < 0) {
            this.bbi = jG + 4294967296L;
        }
        long jG2 = com.kwad.sdk.pngencrypt.n.g(dVar.data, 4);
        this.bbj = jG2;
        if (jG2 < 0) {
            this.bbj = jG2 + 4294967296L;
        }
        this.bbk = com.kwad.sdk.pngencrypt.n.e(dVar.data, 8);
    }
}
