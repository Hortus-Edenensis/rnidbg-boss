package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.m;
import defpackage.ir0;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface c {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f5901a;
        public final MediaFormat b;
        public final m c;

        @Nullable
        public final Surface d;

        @Nullable
        public final MediaCrypto e;
        public final int f;

        public a(d dVar, MediaFormat mediaFormat, m mVar, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i) {
            this.f5901a = dVar;
            this.b = mediaFormat;
            this.c = mVar;
            this.d = surface;
            this.e = mediaCrypto;
            this.f = i;
        }

        public static a a(d dVar, MediaFormat mediaFormat, m mVar, @Nullable MediaCrypto mediaCrypto) {
            return new a(dVar, mediaFormat, mVar, null, mediaCrypto, 0);
        }

        public static a b(d dVar, MediaFormat mediaFormat, m mVar, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto) {
            return new a(dVar, mediaFormat, mVar, surface, mediaCrypto, 0);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        c a(a aVar) throws IOException;
    }

    /* JADX INFO: renamed from: com.google.android.exoplayer2.mediacodec.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0353c {
        void a(c cVar, long j, long j2);
    }

    void a(int i, int i2, ir0 ir0Var, long j, int i3);

    @RequiresApi(23)
    void b(InterfaceC0353c interfaceC0353c, Handler handler);

    int dequeueInputBufferIndex();

    int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo);

    void flush();

    @Nullable
    ByteBuffer getInputBuffer(int i);

    @Nullable
    ByteBuffer getOutputBuffer(int i);

    MediaFormat getOutputFormat();

    boolean needsReconfiguration();

    void queueInputBuffer(int i, int i2, int i3, long j, int i4);

    void release();

    @RequiresApi(21)
    void releaseOutputBuffer(int i, long j);

    void releaseOutputBuffer(int i, boolean z);

    @RequiresApi(23)
    void setOutputSurface(Surface surface);

    @RequiresApi(19)
    void setParameters(Bundle bundle);

    void setVideoScalingMode(int i);
}
