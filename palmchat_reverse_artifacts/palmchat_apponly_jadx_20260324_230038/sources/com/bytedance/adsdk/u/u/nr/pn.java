package com.bytedance.adsdk.u.u.nr;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn implements iz {
    protected iz u;

    public pn(iz izVar) {
        this.u = izVar;
    }

    @Override // com.bytedance.adsdk.u.u.nr.iz
    public int b() throws IOException {
        return this.u.b();
    }

    @Override // com.bytedance.adsdk.u.u.nr.iz
    public byte c_() throws IOException {
        return this.u.c_();
    }

    @Override // com.bytedance.adsdk.u.u.nr.iz
    public void d_() throws IOException {
        this.u.d_();
    }

    @Override // com.bytedance.adsdk.u.u.nr.iz
    public int fx() {
        return this.u.fx();
    }

    @Override // com.bytedance.adsdk.u.u.nr.iz
    public InputStream pn() throws IOException {
        d_();
        return this.u.pn();
    }

    @Override // com.bytedance.adsdk.u.u.nr.iz
    public long u(long j) throws IOException {
        return this.u.u(j);
    }

    @Override // com.bytedance.adsdk.u.u.nr.iz
    public int u(byte[] bArr, int i, int i2) throws IOException {
        return this.u.u(bArr, i, i2);
    }
}
