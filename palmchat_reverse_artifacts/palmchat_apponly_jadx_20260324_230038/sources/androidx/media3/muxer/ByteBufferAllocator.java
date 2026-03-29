package androidx.media3.muxer;

import androidx.media3.common.util.UnstableApi;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface ByteBufferAllocator {
    public static final ByteBufferAllocator DEFAULT = new ByteBufferAllocator() { // from class: rv
        @Override // androidx.media3.muxer.ByteBufferAllocator
        public final ByteBuffer allocate(int i) {
            return ByteBuffer.allocateDirect(i);
        }
    };

    ByteBuffer allocate(int i);
}
