package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.mediacodec.c;
import defpackage.g86;
import defpackage.hz5;
import defpackage.ir0;
import defpackage.vh;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec f5904a;

    @Nullable
    public ByteBuffer[] b;

    @Nullable
    public ByteBuffer[] c;

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements c.b {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.exoplayer2.mediacodec.f$a] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // com.google.android.exoplayer2.mediacodec.c.b
        public c a(c.a aVar) throws Throwable {
            MediaCodec mediaCodecB;
            MediaCodec mediaCodec = 0;
            mediaCodec = 0;
            try {
                mediaCodecB = b(aVar);
            } catch (IOException e) {
                e = e;
            } catch (RuntimeException e2) {
                e = e2;
            }
            try {
                hz5.a("configureCodec");
                mediaCodecB.configure(aVar.b, aVar.d, aVar.e, aVar.f);
                hz5.c();
                hz5.a("startCodec");
                mediaCodecB.start();
                hz5.c();
                return new f(mediaCodecB);
            } catch (IOException | RuntimeException e3) {
                e = e3;
                mediaCodec = mediaCodecB;
                if (mediaCodec != 0) {
                    mediaCodec.release();
                }
                throw e;
            }
        }

        public MediaCodec b(c.a aVar) throws IOException {
            vh.e(aVar.f5901a);
            String str = aVar.f5901a.f5902a;
            hz5.a("createCodec:" + str);
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            hz5.c();
            return mediaCodecCreateByCodecName;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(c.InterfaceC0353c interfaceC0353c, MediaCodec mediaCodec, long j, long j2) {
        interfaceC0353c.a(this, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void a(int i, int i2, ir0 ir0Var, long j, int i3) {
        this.f5904a.queueSecureInputBuffer(i, i2, ir0Var.a(), j, i3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @RequiresApi(23)
    public void b(final c.InterfaceC0353c interfaceC0353c, Handler handler) {
        this.f5904a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: lq5
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                this.f19061a.d(interfaceC0353c, mediaCodec, j, j2);
            }
        }, handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public int dequeueInputBufferIndex() {
        return this.f5904a.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.f5904a.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && g86.f17680a < 21) {
                this.c = this.f5904a.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void flush() {
        this.f5904a.flush();
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @Nullable
    public ByteBuffer getInputBuffer(int i) {
        return g86.f17680a >= 21 ? this.f5904a.getInputBuffer(i) : ((ByteBuffer[]) g86.j(this.b))[i];
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @Nullable
    public ByteBuffer getOutputBuffer(int i) {
        return g86.f17680a >= 21 ? this.f5904a.getOutputBuffer(i) : ((ByteBuffer[]) g86.j(this.c))[i];
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public MediaFormat getOutputFormat() {
        return this.f5904a.getOutputFormat();
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public boolean needsReconfiguration() {
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.f5904a.queueInputBuffer(i, i2, i3, j, i4);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void release() {
        this.b = null;
        this.c = null;
        this.f5904a.release();
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void releaseOutputBuffer(int i, boolean z) {
        this.f5904a.releaseOutputBuffer(i, z);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @RequiresApi(23)
    public void setOutputSurface(Surface surface) {
        this.f5904a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @RequiresApi(19)
    public void setParameters(Bundle bundle) {
        this.f5904a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void setVideoScalingMode(int i) {
        this.f5904a.setVideoScalingMode(i);
    }

    public f(MediaCodec mediaCodec) {
        this.f5904a = mediaCodec;
        if (g86.f17680a < 21) {
            this.b = mediaCodec.getInputBuffers();
            this.c = mediaCodec.getOutputBuffers();
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @RequiresApi(21)
    public void releaseOutputBuffer(int i, long j) {
        this.f5904a.releaseOutputBuffer(i, j);
    }
}
