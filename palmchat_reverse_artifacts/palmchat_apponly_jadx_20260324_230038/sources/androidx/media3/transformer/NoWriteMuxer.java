package androidx.media3.transformer;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.muxer.BufferInfo;
import androidx.media3.muxer.Muxer;
import com.google.common.collect.ImmutableList;
import defpackage.jt3;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
final class NoWriteMuxer implements Muxer {

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements Muxer.Factory {
        private final ImmutableList<String> audioMimeTypes;
        private final ImmutableList<String> videoMimeTypes;

        public Factory(ImmutableList<String> immutableList, ImmutableList<String> immutableList2) {
            this.audioMimeTypes = immutableList;
            this.videoMimeTypes = immutableList2;
        }

        @Override // androidx.media3.muxer.Muxer.Factory
        public Muxer create(String str) {
            return new NoWriteMuxer();
        }

        @Override // androidx.media3.muxer.Muxer.Factory
        public ImmutableList<String> getSupportedSampleMimeTypes(int i) {
            return i == 1 ? this.audioMimeTypes : i == 2 ? this.videoMimeTypes : ImmutableList.of();
        }

        @Override // androidx.media3.muxer.Muxer.Factory
        public /* synthetic */ boolean supportsWritingNegativeTimestampsInEditList() {
            return jt3.a(this);
        }
    }

    @Override // androidx.media3.muxer.Muxer
    public int addTrack(Format format) {
        return 0;
    }

    @Override // androidx.media3.muxer.Muxer, java.lang.AutoCloseable
    public void close() {
    }

    @Override // androidx.media3.muxer.Muxer
    public void addMetadataEntry(Metadata.Entry entry) {
    }

    @Override // androidx.media3.muxer.Muxer
    public void writeSampleData(int i, ByteBuffer byteBuffer, BufferInfo bufferInfo) {
    }
}
