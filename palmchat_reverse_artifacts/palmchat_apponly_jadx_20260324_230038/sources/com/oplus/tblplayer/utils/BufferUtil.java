package com.oplus.tblplayer.utils;

import androidx.annotation.NonNull;
import com.oplus.tbl.exoplayer2.metadata.MetadataInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class BufferUtil {
    @NonNull
    public static ByteBuffer copyMetadataBuffer(@NonNull MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = metadataInputBuffer.data;
        if (byteBuffer == null) {
            throw new IllegalStateException("Metadata input buffer contains null data!");
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteBuffer.limit());
        byteBufferAllocateDirect.put(byteBuffer);
        byteBufferAllocateDirect.flip();
        return byteBufferAllocateDirect;
    }
}
