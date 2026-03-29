package com.opos.exoplayer.core.extractor.a;

import android.util.Pair;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.a.b;
import com.opos.exoplayer.core.extractor.n;
import com.opos.exoplayer.core.util.f;
import com.opos.exoplayer.core.util.p;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class c extends b {
    private static final int[] b = {AVMDLDataLoader.KeyIsIsMaxTlsVersion, 11025, 22050, 44100};
    private boolean c;
    private boolean d;
    private int e;

    public c(n nVar) {
        super(nVar);
    }

    @Override // com.opos.exoplayer.core.extractor.a.b
    public boolean a(p pVar) throws b.a {
        Format formatA;
        if (this.c) {
            pVar.d(1);
        } else {
            int iG = pVar.g();
            int i = (iG >> 4) & 15;
            this.e = i;
            if (i == 2) {
                formatA = Format.a(null, "audio/mpeg", null, -1, -1, 1, b[(iG >> 2) & 3], null, null, 0, null);
            } else if (i == 7 || i == 8) {
                formatA = Format.a((String) null, i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", (String) null, -1, -1, 1, 8000, (iG & 1) == 1 ? 2 : 3, (List<byte[]>) null, (DrmInitData) null, 0, (String) null);
            } else {
                if (i != 10) {
                    throw new b.a("Audio format not supported: " + this.e);
                }
                this.c = true;
            }
            this.f8157a.a(formatA);
            this.d = true;
            this.c = true;
        }
        return true;
    }

    @Override // com.opos.exoplayer.core.extractor.a.b
    public void b(p pVar, long j) {
        if (this.e == 2) {
            int iB = pVar.b();
            this.f8157a.a(pVar, iB);
            this.f8157a.a(j, 1, iB, 0, null);
            return;
        }
        int iG = pVar.g();
        if (iG != 0 || this.d) {
            if (this.e != 10 || iG == 1) {
                int iB2 = pVar.b();
                this.f8157a.a(pVar, iB2);
                this.f8157a.a(j, 1, iB2, 0, null);
                return;
            }
            return;
        }
        int iB3 = pVar.b();
        byte[] bArr = new byte[iB3];
        pVar.a(bArr, 0, iB3);
        Pair<Integer, Integer> pairA = f.a(bArr);
        this.f8157a.a(Format.a(null, "audio/mp4a-latm", null, -1, -1, ((Integer) pairA.second).intValue(), ((Integer) pairA.first).intValue(), Collections.singletonList(bArr), null, 0, null));
        this.d = true;
    }
}
