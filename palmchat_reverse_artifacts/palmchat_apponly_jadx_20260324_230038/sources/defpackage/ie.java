package defpackage;

import androidx.media3.muxer.AnnexBToAvccConverter;
import androidx.media3.muxer.ByteBufferAllocator;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ie {
    public static ByteBuffer a(AnnexBToAvccConverter annexBToAvccConverter, ByteBuffer byteBuffer, ByteBufferAllocator byteBufferAllocator) {
        return annexBToAvccConverter.process(byteBuffer);
    }
}
