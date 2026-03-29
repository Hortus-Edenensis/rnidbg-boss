package com.baidu.b.a;

import androidx.media3.muxer.MuxerUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class j extends g {
    public j(int i, int i2) {
        this.f3299a = MuxerUtil.UNSIGNED_INT_MAX_VALUE;
        this.b = 4;
        this.c = 32;
        this.d = i;
        this.e = i2;
    }

    @Override // com.baidu.b.a.g
    public b a(byte[] bArr, int i, int i2) {
        k kVar = new k();
        kVar.a(bArr, i, i2);
        return b.a(new long[]{kVar.a()});
    }
}
