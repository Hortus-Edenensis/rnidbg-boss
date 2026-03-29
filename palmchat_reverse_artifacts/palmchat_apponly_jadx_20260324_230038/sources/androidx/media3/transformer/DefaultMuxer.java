package androidx.media3.transformer;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.muxer.BufferInfo;
import androidx.media3.muxer.Muxer;
import androidx.media3.muxer.MuxerException;
import androidx.media3.transformer.FrameworkMuxer;
import com.google.common.collect.ImmutableList;
import defpackage.jt3;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class DefaultMuxer implements Muxer {
    public static final String MUXER_NAME = FrameworkMuxer.MUXER_NAME;
    private final Muxer muxer;

    @Override // androidx.media3.muxer.Muxer
    public void addMetadataEntry(Metadata.Entry entry) {
        this.muxer.addMetadataEntry(entry);
    }

    @Override // androidx.media3.muxer.Muxer
    public int addTrack(Format format) throws MuxerException {
        return this.muxer.addTrack(format);
    }

    @Override // androidx.media3.muxer.Muxer, java.lang.AutoCloseable
    public void close() throws MuxerException {
        this.muxer.close();
    }

    @Override // androidx.media3.muxer.Muxer
    public void writeSampleData(int i, ByteBuffer byteBuffer, BufferInfo bufferInfo) throws MuxerException {
        this.muxer.writeSampleData(i, byteBuffer, bufferInfo);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class Factory implements Muxer.Factory {
        private final FrameworkMuxer.Factory muxerFactory;

        public Factory() {
            this.muxerFactory = new FrameworkMuxer.Factory();
        }

        @Override // androidx.media3.muxer.Muxer.Factory
        public Muxer create(String str) throws MuxerException {
            return new DefaultMuxer(this.muxerFactory.create(str));
        }

        @Override // androidx.media3.muxer.Muxer.Factory
        public ImmutableList<String> getSupportedSampleMimeTypes(int i) {
            return this.muxerFactory.getSupportedSampleMimeTypes(i);
        }

        public Factory setVideoDurationUs(long j) {
            this.muxerFactory.setVideoDurationUs(j);
            return this;
        }

        @Override // androidx.media3.muxer.Muxer.Factory
        public /* synthetic */ boolean supportsWritingNegativeTimestampsInEditList() {
            return jt3.a(this);
        }

        @Deprecated
        public Factory(long j) {
            this.muxerFactory = new FrameworkMuxer.Factory().setVideoDurationUs(Util.msToUs(j));
        }
    }

    private DefaultMuxer(Muxer muxer) {
        this.muxer = muxer;
    }
}
