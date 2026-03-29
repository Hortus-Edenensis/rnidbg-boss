package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.m;
import defpackage.c06;
import defpackage.dn;
import defpackage.gc4;
import defpackage.ot3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class b extends TagPayloadReader {
    public final gc4 b;
    public final gc4 c;
    public int d;
    public boolean e;
    public boolean f;
    public int g;

    public b(c06 c06Var) {
        super(c06Var);
        this.b = new gc4(ot3.f19869a);
        this.c = new gc4(4);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean b(gc4 gc4Var) throws TagPayloadReader.UnsupportedFormatException {
        int iH = gc4Var.H();
        int i = (iH >> 4) & 15;
        int i2 = iH & 15;
        if (i2 == 7) {
            this.g = i;
            return i != 5;
        }
        throw new TagPayloadReader.UnsupportedFormatException("Video format not supported: " + i2);
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public boolean c(gc4 gc4Var, long j) throws ParserException {
        int iH = gc4Var.H();
        long jR = j + (((long) gc4Var.r()) * 1000);
        if (iH == 0 && !this.e) {
            gc4 gc4Var2 = new gc4(new byte[gc4Var.a()]);
            gc4Var.l(gc4Var2.e(), 0, gc4Var.a());
            dn dnVarB = dn.b(gc4Var2);
            this.d = dnVarB.b;
            this.f5872a.b(new m.b().g0("video/avc").K(dnVarB.i).n0(dnVarB.c).S(dnVarB.d).c0(dnVarB.h).V(dnVarB.f17083a).G());
            this.e = true;
            return false;
        }
        if (iH != 1 || !this.e) {
            return false;
        }
        int i = this.g == 1 ? 1 : 0;
        if (!this.f && i == 0) {
            return false;
        }
        byte[] bArrE = this.c.e();
        bArrE[0] = 0;
        bArrE[1] = 0;
        bArrE[2] = 0;
        int i2 = 4 - this.d;
        int i3 = 0;
        while (gc4Var.a() > 0) {
            gc4Var.l(this.c.e(), i2, this.d);
            this.c.U(0);
            int iL = this.c.L();
            this.b.U(0);
            this.f5872a.d(this.b, 4);
            this.f5872a.d(gc4Var, iL);
            i3 = i3 + 4 + iL;
        }
        this.f5872a.e(jR, i, i3, 0, null);
        this.f = true;
        return true;
    }
}
