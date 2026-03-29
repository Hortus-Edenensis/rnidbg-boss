package androidx.media3.muxer;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface Muxer extends AutoCloseable {

    /* JADX INFO: compiled from: SearchBox */
    public interface Factory {
        Muxer create(String str) throws MuxerException;

        ImmutableList<String> getSupportedSampleMimeTypes(int i);

        boolean supportsWritingNegativeTimestampsInEditList();
    }

    void addMetadataEntry(Metadata.Entry entry);

    int addTrack(Format format) throws MuxerException;

    @Override // java.lang.AutoCloseable
    void close() throws MuxerException;

    void writeSampleData(int i, ByteBuffer byteBuffer, BufferInfo bufferInfo) throws MuxerException;
}
