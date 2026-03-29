package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.mediacodec.a;
import com.google.android.exoplayer2.mediacodec.c;
import defpackage.C1499ui;
import defpackage.hz5;
import defpackage.ir0;
import defpackage.qo5;
import defpackage.ri;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(23)
@Deprecated
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec f5898a;
    public final C1499ui b;
    public final ri c;
    public final boolean d;
    public boolean e;
    public int f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final qo5<HandlerThread> f5899a;
        public final qo5<HandlerThread> b;
        public final boolean c;

        public b(final int i, boolean z) {
            this(new qo5() { // from class: ki
                @Override // defpackage.qo5
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return a.b.e(i);
                }
            }, new qo5() { // from class: ni
                @Override // defpackage.qo5
                /* JADX INFO: renamed from: get */
                public final Object get2() {
                    return a.b.f(i);
                }
            }, z);
        }

        public static /* synthetic */ HandlerThread e(int i) {
            return new HandlerThread(a.g(i));
        }

        public static /* synthetic */ HandlerThread f(int i) {
            return new HandlerThread(a.h(i));
        }

        @Override // com.google.android.exoplayer2.mediacodec.c.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public a a(c.a aVar) throws Exception {
            MediaCodec mediaCodecCreateByCodecName;
            a aVar2;
            String str = aVar.f5901a.f5902a;
            a aVar3 = null;
            try {
                hz5.a("createCodec:" + str);
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    aVar2 = new a(mediaCodecCreateByCodecName, this.f5899a.get2(), this.b.get2(), this.c);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Exception e2) {
                e = e2;
                mediaCodecCreateByCodecName = null;
            }
            try {
                hz5.c();
                aVar2.j(aVar.b, aVar.d, aVar.e, aVar.f);
                return aVar2;
            } catch (Exception e3) {
                e = e3;
                aVar3 = aVar2;
                if (aVar3 != null) {
                    aVar3.release();
                } else if (mediaCodecCreateByCodecName != null) {
                    mediaCodecCreateByCodecName.release();
                }
                throw e;
            }
        }

        @VisibleForTesting
        public b(qo5<HandlerThread> qo5Var, qo5<HandlerThread> qo5Var2, boolean z) {
            this.f5899a = qo5Var;
            this.b = qo5Var2;
            this.c = z;
        }
    }

    public static String g(int i) {
        return i(i, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    public static String h(int i) {
        return i(i, "ExoPlayer:MediaCodecQueueingThread:");
    }

    public static String i(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(c.InterfaceC0353c interfaceC0353c, MediaCodec mediaCodec, long j, long j2) {
        interfaceC0353c.a(this, j, j2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void a(int i, int i2, ir0 ir0Var, long j, int i3) {
        this.c.n(i, i2, ir0Var, j, i3);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void b(final c.InterfaceC0353c interfaceC0353c, Handler handler) {
        l();
        this.f5898a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: ii
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
                this.f18170a.k(interfaceC0353c, mediaCodec, j, j2);
            }
        }, handler);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public int dequeueInputBufferIndex() {
        this.c.l();
        return this.b.c();
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        this.c.l();
        return this.b.d(bufferInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void flush() {
        this.c.i();
        this.f5898a.flush();
        this.b.e();
        this.f5898a.start();
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @Nullable
    public ByteBuffer getInputBuffer(int i) {
        return this.f5898a.getInputBuffer(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    @Nullable
    public ByteBuffer getOutputBuffer(int i) {
        return this.f5898a.getOutputBuffer(i);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public MediaFormat getOutputFormat() {
        return this.b.g();
    }

    public final void j(@Nullable MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i) {
        this.b.h(this.f5898a);
        hz5.a("configureCodec");
        this.f5898a.configure(mediaFormat, surface, mediaCrypto, i);
        hz5.c();
        this.c.q();
        hz5.a("startCodec");
        this.f5898a.start();
        hz5.c();
        this.f = 1;
    }

    public final void l() {
        if (this.d) {
            try {
                this.c.r();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public boolean needsReconfiguration() {
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void queueInputBuffer(int i, int i2, int i3, long j, int i4) {
        this.c.m(i, i2, i3, j, i4);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void release() {
        try {
            if (this.f == 1) {
                this.c.p();
                this.b.o();
            }
            this.f = 2;
        } finally {
            if (!this.e) {
                this.f5898a.release();
                this.e = true;
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void releaseOutputBuffer(int i, boolean z) {
        this.f5898a.releaseOutputBuffer(i, z);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void setOutputSurface(Surface surface) {
        l();
        this.f5898a.setOutputSurface(surface);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void setParameters(Bundle bundle) {
        l();
        this.f5898a.setParameters(bundle);
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void setVideoScalingMode(int i) {
        l();
        this.f5898a.setVideoScalingMode(i);
    }

    public a(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z) {
        this.f5898a = mediaCodec;
        this.b = new C1499ui(handlerThread);
        this.c = new ri(mediaCodec, handlerThread2);
        this.d = z;
        this.f = 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.c
    public void releaseOutputBuffer(int i, long j) {
        this.f5898a.releaseOutputBuffer(i, j);
    }
}
