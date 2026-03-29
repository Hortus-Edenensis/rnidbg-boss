package com.bytedance.adsdk.u.u.nr;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b implements x {
    protected ByteBuffer u;

    public b() {
        fx(10240);
    }

    public void b(int i) {
        this.u.position(i + u());
    }

    public void fx(int i) {
        ByteBuffer byteBuffer = this.u;
        if (byteBuffer == null || i > byteBuffer.capacity()) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            this.u = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        }
        this.u.clear();
    }

    public byte[] nr() {
        return this.u.array();
    }

    public void u(byte b) {
        this.u.put(b);
    }

    public void u(byte[] bArr) {
        this.u.put(bArr);
    }

    public int u() {
        return this.u.position();
    }
}
