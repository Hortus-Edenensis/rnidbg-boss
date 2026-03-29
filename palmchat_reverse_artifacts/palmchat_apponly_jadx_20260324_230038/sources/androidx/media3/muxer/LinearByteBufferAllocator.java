package androidx.media3.muxer;

import androidx.media3.common.util.Assertions;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class LinearByteBufferAllocator implements ByteBufferAllocator {
    private ByteBuffer memoryPool;

    public LinearByteBufferAllocator(int i) {
        Assertions.checkArgument(i >= 0);
        this.memoryPool = ByteBuffer.allocateDirect(i);
    }

    @Override // androidx.media3.muxer.ByteBufferAllocator
    public ByteBuffer allocate(int i) {
        Assertions.checkArgument(i >= 0);
        if (this.memoryPool.remaining() < i) {
            this.memoryPool = ByteBuffer.allocateDirect(Math.max(i, this.memoryPool.capacity() * 2));
        }
        ByteBuffer byteBufferSlice = this.memoryPool.slice();
        ByteBuffer byteBuffer = this.memoryPool;
        byteBuffer.position(byteBuffer.position() + i);
        byteBufferSlice.limit(i);
        return byteBufferSlice;
    }

    public void reset() {
        this.memoryPool.clear();
    }
}
