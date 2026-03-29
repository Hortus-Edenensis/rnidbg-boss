package com.bytedance.adsdk.u.u.u;

import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class l extends pn {
    static final int u = pn.u("IHDR");
    int fx;
    byte[] n = new byte[5];
    int nr;

    @Override // com.bytedance.adsdk.u.u.u.pn
    public void u(com.bytedance.adsdk.u.u.nr.u uVar) throws IOException {
        this.nr = uVar.nr();
        this.fx = uVar.nr();
        byte[] bArr = this.n;
        uVar.u(bArr, 0, bArr.length);
    }
}
