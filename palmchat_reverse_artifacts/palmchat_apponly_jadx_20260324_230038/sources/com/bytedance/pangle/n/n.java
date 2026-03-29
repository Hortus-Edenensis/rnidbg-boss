package com.bytedance.pangle.n;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.DigestException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
class n implements t {
    private final ByteBuffer u;

    public n(ByteBuffer byteBuffer) {
        this.u = byteBuffer.slice();
    }

    @Override // com.bytedance.pangle.n.t
    public long u() {
        return this.u.capacity();
    }

    @Override // com.bytedance.pangle.n.t
    public void u(jk jkVar, long j, int i) throws DigestException, IOException {
        ByteBuffer byteBufferSlice;
        synchronized (this.u) {
            this.u.position(0);
            int i2 = (int) j;
            this.u.limit(i + i2);
            this.u.position(i2);
            byteBufferSlice = this.u.slice();
        }
        jkVar.u(byteBufferSlice);
    }
}
