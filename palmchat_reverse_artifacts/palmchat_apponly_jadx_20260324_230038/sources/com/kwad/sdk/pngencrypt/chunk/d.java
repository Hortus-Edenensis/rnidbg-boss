package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d {
    public final String asJ;
    public final byte[] baL;
    private CRC32 baO;
    public final int len;
    public byte[] data = null;
    private long baM = 0;
    public byte[] baN = new byte[4];

    public d(int i, String str, boolean z) {
        this.len = i;
        this.asJ = str;
        this.baL = b.gO(str);
        for (int i2 = 0; i2 < 4; i2++) {
            byte b = this.baL[i2];
            if (b < 65 || b > 122 || (b > 90 && b < 97)) {
                new PngjException("Bad id chunk: must be ascii letters " + str);
            }
        }
        if (z) {
            Qp();
        }
    }

    private void Qp() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    public final ByteArrayInputStream Qq() {
        return new ByteArrayInputStream(this.data);
    }

    public final long Qr() {
        return this.baM;
    }

    public final void aU(long j) {
        this.baM = j;
    }

    public final void bW(boolean z) {
        int value = (int) this.baO.getValue();
        int iG = com.kwad.sdk.pngencrypt.n.g(this.baN, 0);
        if (value != iG) {
            String str = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.asJ, Long.valueOf(this.baM), Integer.valueOf(iG), Integer.valueOf(value));
            if (z) {
                new PngjException(str);
            }
        }
    }

    public final void e(byte[] bArr, int i, int i2) {
        if (this.baO == null) {
            this.baO = new CRC32();
        }
        this.baO.update(bArr, i, i2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.asJ;
        if (str == null) {
            if (dVar.asJ != null) {
                return false;
            }
        } else if (!str.equals(dVar.asJ)) {
            return false;
        }
        return this.baM == dVar.baM;
    }

    public final int hashCode() {
        String str = this.asJ;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j = this.baM;
        return ((iHashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "chunkid=" + b.h(this.baL) + " len=" + this.len;
    }
}
