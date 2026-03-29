package com.opos.exoplayer.core.video;

import com.opos.exoplayer.core.m;
import com.opos.exoplayer.core.util.n;
import com.opos.exoplayer.core.util.p;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<byte[]> f8415a;
    public final int b;

    private b(List<byte[]> list, int i) {
        this.f8415a = list;
        this.b = i;
    }

    public static b a(p pVar) throws m {
        try {
            pVar.d(21);
            int iG = pVar.g() & 3;
            int iG2 = pVar.g();
            int iD = pVar.d();
            int i = 0;
            for (int i2 = 0; i2 < iG2; i2++) {
                pVar.d(1);
                int iH = pVar.h();
                for (int i3 = 0; i3 < iH; i3++) {
                    int iH2 = pVar.h();
                    i += iH2 + 4;
                    pVar.d(iH2);
                }
            }
            pVar.c(iD);
            byte[] bArr = new byte[i];
            int i4 = 0;
            for (int i5 = 0; i5 < iG2; i5++) {
                pVar.d(1);
                int iH3 = pVar.h();
                for (int i6 = 0; i6 < iH3; i6++) {
                    int iH4 = pVar.h();
                    byte[] bArr2 = n.f8396a;
                    System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
                    int length = i4 + bArr2.length;
                    System.arraycopy(pVar.f8400a, pVar.d(), bArr, length, iH4);
                    i4 = length + iH4;
                    pVar.d(iH4);
                }
            }
            return new b(i == 0 ? null : Collections.singletonList(bArr), iG + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new m("Error parsing HEVC config", e);
        }
    }
}
