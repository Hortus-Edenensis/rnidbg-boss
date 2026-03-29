package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class m extends p {
    private int bbl;
    private int[] bbm;

    public m(com.kwad.sdk.pngencrypt.k kVar) {
        super("PLTE", kVar);
        this.bbl = 0;
    }

    private void c(int i, int i2, int i3, int i4) {
        this.bbm[i] = (i2 << 16) | (i3 << 8) | i4;
    }

    private void eP(int i) {
        this.bbl = i;
        if (i <= 0 || i > 256) {
            throw new PngjException("invalid pallette - nentries=" + this.bbl);
        }
        int[] iArr = this.bbm;
        if (iArr == null || iArr.length != i) {
            this.bbm = new int[i];
        }
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        eP(dVar.len / 3);
        int i = 0;
        int i2 = 0;
        while (i < this.bbl) {
            byte[] bArr = dVar.data;
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            c(i, bArr[i2] & UByte.MAX_VALUE, bArr[i3] & UByte.MAX_VALUE, bArr[i4] & UByte.MAX_VALUE);
            i++;
            i2 = i4 + 1;
        }
    }
}
