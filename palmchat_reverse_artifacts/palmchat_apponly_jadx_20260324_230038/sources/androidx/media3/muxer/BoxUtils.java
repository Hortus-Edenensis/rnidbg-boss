package androidx.media3.muxer;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class BoxUtils {
    private static final int BOX_SIZE_BYTES = 4;
    private static final int BOX_TYPE_BYTES = 4;

    private BoxUtils() {
    }

    public static ByteBuffer concatenateBuffers(ByteBuffer... byteBufferArr) {
        int iRemaining = 0;
        for (ByteBuffer byteBuffer : byteBufferArr) {
            iRemaining += byteBuffer.remaining();
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iRemaining);
        for (ByteBuffer byteBuffer2 : byteBufferArr) {
            byteBufferAllocate.put(byteBuffer2);
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static ByteBuffer wrapBoxesIntoBox(String str, List<ByteBuffer> list) {
        int iRemaining = 8;
        for (int i = 0; i < list.size(); i++) {
            iRemaining += list.get(i).remaining();
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(iRemaining);
        byteBufferAllocate.putInt(iRemaining);
        byteBufferAllocate.put(str.getBytes(StandardCharsets.UTF_8), 0, 4);
        for (int i2 = 0; i2 < list.size(); i2++) {
            byteBufferAllocate.put(list.get(i2));
        }
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }

    public static ByteBuffer wrapIntoBox(String str, ByteBuffer byteBuffer) {
        return wrapIntoBox(str.getBytes(StandardCharsets.UTF_8), byteBuffer);
    }

    public static ByteBuffer wrapIntoBox(byte[] bArr, ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining() + 4 + 4);
        byteBufferAllocate.putInt(byteBuffer.remaining() + 4 + 4);
        byteBufferAllocate.put(bArr, 0, 4);
        byteBufferAllocate.put(byteBuffer);
        byteBufferAllocate.flip();
        return byteBufferAllocate;
    }
}
