package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class d extends ChunkReader {
    protected final DeflatedChunksSet aZm;
    protected boolean aZn;
    protected boolean aZo;
    protected byte[] aZp;
    protected int aZq;

    public d(int i, String str, long j, DeflatedChunksSet deflatedChunksSet) {
        super(i, str, j, ChunkReader.ChunkReaderMode.PROCESS);
        this.aZn = false;
        this.aZo = false;
        this.aZq = -1;
        this.aZm = deflatedChunksSet;
        deflatedChunksSet.a(this);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public void PF() {
        int iG;
        if (!this.aZo || this.aZq < 0 || (iG = n.g(this.aZp, 0)) == this.aZq) {
            return;
        }
        new PngjException("bad chunk sequence for fDAT chunk " + iG + " expected " + this.aZq);
    }

    @Override // com.kwad.sdk.pngencrypt.ChunkReader
    public final void a(int i, byte[] bArr, int i2, int i3) {
        if (this.aZo && i < 4) {
            while (i < 4 && i3 > 0) {
                this.aZp[i] = bArr[i2];
                i++;
                i2++;
                i3--;
            }
        }
        if (i3 > 0) {
            this.aZm.b(bArr, i2, i3);
            if (this.aZn) {
                System.arraycopy(bArr, i2, PE().data, this.aYF, i3);
            }
        }
    }

    public final void ew(int i) {
        this.aZq = i;
    }
}
