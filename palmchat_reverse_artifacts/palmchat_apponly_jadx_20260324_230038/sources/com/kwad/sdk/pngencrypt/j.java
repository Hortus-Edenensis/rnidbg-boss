package com.kwad.sdk.pngencrypt;

import java.util.Arrays;
import java.util.zip.Inflater;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class j extends DeflatedChunksSet {
    protected final e aYY;
    protected byte[] aZS;
    protected byte[] aZT;
    protected final k aZU;
    final p aZV;
    protected int[] aZW;

    /* JADX INFO: renamed from: com.kwad.sdk.pngencrypt.j$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] aZX;

        static {
            int[] iArr = new int[FilterType.values().length];
            aZX = iArr;
            try {
                iArr[FilterType.FILTER_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aZX[FilterType.FILTER_SUB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aZX[FilterType.FILTER_UP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                aZX[FilterType.FILTER_AVERAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                aZX[FilterType.FILTER_PAETH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public j(String str, boolean z, k kVar, e eVar) {
        this(str, z, kVar, eVar, null, null);
    }

    private void Qe() {
        eB(this.aZV.baC);
    }

    private int Qf() {
        int iQd;
        e eVar = this.aYY;
        int i = 0;
        if (eVar == null) {
            int iPV = PV();
            k kVar = this.aZU;
            if (iPV < kVar.aZF - 1) {
                iQd = kVar.bag;
                i = iQd + 1;
            }
        } else if (eVar.PW()) {
            iQd = this.aYY.Qd();
            i = iQd + 1;
        }
        if (!this.aZb) {
            ex(i);
        }
        return i;
    }

    private void eB(int i) {
        byte[] bArr = this.aZS;
        if (bArr == null || bArr.length < this.aZr.length) {
            byte[] bArr2 = this.aZr;
            this.aZS = new byte[bArr2.length];
            this.aZT = new byte[bArr2.length];
        }
        if (this.aZV.baz == 0) {
            Arrays.fill(this.aZS, (byte) 0);
        }
        byte[] bArr3 = this.aZS;
        this.aZS = this.aZT;
        this.aZT = bArr3;
        byte b = this.aZr[0];
        if (!FilterType.isValidStandard(b)) {
            throw new PngjException("Filter type " + ((int) b) + " invalid");
        }
        FilterType byVal = FilterType.getByVal(b);
        int[] iArr = this.aZW;
        iArr[b] = iArr[b] + 1;
        this.aZS[0] = this.aZr[0];
        int i2 = AnonymousClass1.aZX[byVal.ordinal()];
        if (i2 == 1) {
            eD(i);
            return;
        }
        if (i2 == 2) {
            eF(i);
            return;
        }
        if (i2 == 3) {
            eG(i);
            return;
        }
        if (i2 == 4) {
            eC(i);
        } else {
            if (i2 == 5) {
                eE(i);
                return;
            }
            throw new PngjException("Filter type " + ((int) b) + " not implemented");
        }
    }

    private void eC(int i) {
        int i2 = 1;
        int i3 = 1 - this.aZU.baf;
        while (i2 <= i) {
            this.aZS[i2] = (byte) (this.aZr[i2] + (((i3 > 0 ? this.aZS[i3] & UByte.MAX_VALUE : 0) + (this.aZT[i2] & UByte.MAX_VALUE)) / 2));
            i2++;
            i3++;
        }
    }

    private void eD(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.aZS[i2] = this.aZr[i2];
        }
    }

    private void eE(int i) {
        int i2 = 1;
        int i3 = 1 - this.aZU.baf;
        while (i2 <= i) {
            int i4 = 0;
            int i5 = i3 > 0 ? this.aZS[i3] & UByte.MAX_VALUE : 0;
            if (i3 > 0) {
                i4 = this.aZT[i3] & UByte.MAX_VALUE;
            }
            this.aZS[i2] = (byte) (this.aZr[i2] + n.d(i5, this.aZT[i2] & UByte.MAX_VALUE, i4));
            i2++;
            i3++;
        }
    }

    private void eF(int i) {
        int i2;
        int i3 = 1;
        while (true) {
            i2 = this.aZU.baf;
            if (i3 > i2) {
                break;
            }
            this.aZS[i3] = this.aZr[i3];
            i3++;
        }
        int i4 = i2 + 1;
        int i5 = 1;
        while (i4 <= i) {
            byte[] bArr = this.aZS;
            bArr[i4] = (byte) (this.aZr[i4] + bArr[i5]);
            i4++;
            i5++;
        }
    }

    private void eG(int i) {
        for (int i2 = 1; i2 <= i; i2++) {
            this.aZS[i2] = (byte) (this.aZr[i2] + this.aZT[i2]);
        }
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void PS() {
        super.PS();
        this.aZV.update(PV());
        Qe();
        p pVar = this.aZV;
        pVar.h(this.aZS, pVar.baC + 1);
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final int PT() {
        return Qf();
    }

    @Override // com.kwad.sdk.pngencrypt.DeflatedChunksSet
    public final void close() {
        super.close();
        this.aZS = null;
        this.aZT = null;
    }

    private j(String str, boolean z, k kVar, e eVar, Inflater inflater, byte[] bArr) {
        super(str, z, (eVar != null ? eVar.Qd() : kVar.bag) + 1, kVar.bag + 1, null, null);
        this.aZW = new int[5];
        this.aZU = kVar;
        this.aYY = eVar;
        this.aZV = new p(kVar, eVar);
    }
}
