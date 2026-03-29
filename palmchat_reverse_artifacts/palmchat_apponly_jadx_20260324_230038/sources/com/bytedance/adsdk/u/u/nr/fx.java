package com.bytedance.adsdk.u.u.nr;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx implements iz {
    private final ByteBuffer u;

    public fx(ByteBuffer byteBuffer) {
        this.u = byteBuffer;
        byteBuffer.position(0);
    }

    @Override // com.bytedance.adsdk.u.u.nr.iz
    public int b() throws IOException {
        return this.u.limit() - this.u.position();
    }

    @Override // com.bytedance.adsdk.u.u.nr.iz
    public byte c_() throws IOException {
        return this.u.get();
    }

    @Override // com.bytedance.adsdk.u.u.nr.iz
    public void d_() throws IOException {
        this.u.position(0);
    }

    @Override // com.bytedance.adsdk.u.u.nr.iz
    public int fx() {
        return this.u.position();
    }

    @Override // com.bytedance.adsdk.u.u.nr.iz
    public InputStream pn() throws IOException {
        return new ByteArrayInputStream(this.u.array());
    }

    @Override // com.bytedance.adsdk.u.u.nr.iz
    public long u(long j) throws IOException {
        ByteBuffer byteBuffer = this.u;
        byteBuffer.position((int) (((long) byteBuffer.position()) + j));
        return j;
    }

    @Override // com.bytedance.adsdk.u.u.nr.iz
    public int u(byte[] bArr, int i, int i2) throws IOException {
        this.u.get(bArr, i, i2);
        return i2;
    }
}
