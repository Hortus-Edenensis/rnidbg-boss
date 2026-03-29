package com.bytedance.sdk.component.panglearmor.u.nr;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements nr {
    private final long fx;
    private final long nr;
    private final FileChannel u;

    public b(FileChannel fileChannel, long j, long j2) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j2)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        this.u = fileChannel;
        this.nr = j;
        this.fx = j2;
    }

    @Override // com.bytedance.sdk.component.panglearmor.u.nr.nr
    /* JADX INFO: renamed from: nr, reason: merged with bridge method [inline-methods] */
    public b u(long j, long j2) {
        long jU = u();
        u(j, j2, jU);
        return (j == 0 && j2 == jU) ? this : new b(this.u, this.nr + j, j2);
    }

    @Override // com.bytedance.sdk.component.panglearmor.u.nr.nr
    public long u() {
        long j = this.fx;
        if (j != -1) {
            return j;
        }
        try {
            return this.u.size();
        } catch (IOException unused) {
            return 0L;
        }
    }

    public void u(long j, int i, ByteBuffer byteBuffer) throws IOException {
        int i2;
        u(j, i, u());
        if (i == 0) {
            return;
        }
        if (i <= byteBuffer.remaining()) {
            long j2 = this.nr + j;
            int iLimit = byteBuffer.limit();
            try {
                byteBuffer.limit(byteBuffer.position() + i);
                while (i > 0) {
                    synchronized (this.u) {
                        this.u.position(j2);
                        i2 = this.u.read(byteBuffer);
                    }
                    j2 += (long) i2;
                    i -= i2;
                }
                return;
            } finally {
                byteBuffer.limit(iLimit);
            }
        }
        throw new BufferOverflowException();
    }

    @Override // com.bytedance.sdk.component.panglearmor.u.nr.nr
    public ByteBuffer u(long j, int i) throws IOException {
        if (i >= 0) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
            u(j, i, byteBufferAllocate);
            byteBufferAllocate.flip();
            return byteBufferAllocate;
        }
        throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(i)));
    }

    private static void u(long j, long j2, long j3) {
        if (j < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j)));
        }
        if (j2 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j2)));
        }
        if (j > j3) {
            throw new IndexOutOfBoundsException("offset (" + j + ") > source size (" + j3 + ")");
        }
        long j4 = j + j2;
        if (j4 < j) {
            throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") overflow");
        }
        if (j4 <= j3) {
            return;
        }
        throw new IndexOutOfBoundsException("offset (" + j + ") + size (" + j2 + ") > source size (" + j3 + ")");
    }
}
