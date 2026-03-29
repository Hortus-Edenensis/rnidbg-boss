package com.google.android.exoplayer2.extractor.flv;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.m;
import defpackage.c06;
import defpackage.f0;
import defpackage.gc4;
import java.util.Collections;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class a extends TagPayloadReader {
    public static final int[] e = {AVMDLDataLoader.KeyIsIsMaxTlsVersion, 11025, 22050, 44100};
    public boolean b;
    public boolean c;
    public int d;

    public a(c06 c06Var) {
        super(c06Var);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(gc4 gc4Var) throws TagPayloadReader.UnsupportedFormatException {
        if (this.b) {
            gc4Var.V(1);
        } else {
            int iH = gc4Var.H();
            int i = (iH >> 4) & 15;
            this.d = i;
            if (i == 2) {
                this.f5872a.b(new m.b().g0("audio/mpeg").J(1).h0(e[(iH >> 2) & 3]).G());
                this.c = true;
            } else if (i == 7 || i == 8) {
                this.f5872a.b(new m.b().g0(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").J(1).h0(8000).G());
                this.c = true;
            } else if (i != 10) {
                throw new TagPayloadReader.UnsupportedFormatException("Audio format not supported: " + this.d);
            }
            this.b = true;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(gc4 gc4Var, long j) throws ParserException {
        if (this.d == 2) {
            int iA = gc4Var.a();
            this.f5872a.d(gc4Var, iA);
            this.f5872a.e(j, 1, iA, 0, null);
            return true;
        }
        int iH = gc4Var.H();
        if (iH != 0 || this.c) {
            if (this.d == 10 && iH != 1) {
                return false;
            }
            int iA2 = gc4Var.a();
            this.f5872a.d(gc4Var, iA2);
            this.f5872a.e(j, 1, iA2, 0, null);
            return true;
        }
        int iA3 = gc4Var.a();
        byte[] bArr = new byte[iA3];
        gc4Var.l(bArr, 0, iA3);
        f0.b bVarE = f0.e(bArr);
        this.f5872a.b(new m.b().g0("audio/mp4a-latm").K(bVarE.c).J(bVarE.b).h0(bVarE.f17401a).V(Collections.singletonList(bArr)).G());
        this.c = true;
        return false;
    }
}
