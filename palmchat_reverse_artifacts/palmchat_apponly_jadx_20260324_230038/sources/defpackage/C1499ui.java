package defpackage;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.ArrayDeque;

/* JADX INFO: renamed from: ui, reason: case insensitive filesystem */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(23)
@Deprecated
public final class C1499ui extends MediaCodec.Callback {
    public final HandlerThread b;
    public Handler c;

    @Nullable
    @GuardedBy("lock")
    public MediaFormat h;

    @Nullable
    @GuardedBy("lock")
    public MediaFormat i;

    @Nullable
    @GuardedBy("lock")
    public MediaCodec.CodecException j;

    @GuardedBy("lock")
    public long k;

    @GuardedBy("lock")
    public boolean l;

    @Nullable
    @GuardedBy("lock")
    public IllegalStateException m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21216a = new Object();

    @GuardedBy("lock")
    public final nt2 d = new nt2();

    @GuardedBy("lock")
    public final nt2 e = new nt2();

    @GuardedBy("lock")
    public final ArrayDeque<MediaCodec.BufferInfo> f = new ArrayDeque<>();

    @GuardedBy("lock")
    public final ArrayDeque<MediaFormat> g = new ArrayDeque<>();

    public C1499ui(HandlerThread handlerThread) {
        this.b = handlerThread;
    }

    @GuardedBy("lock")
    public final void b(MediaFormat mediaFormat) {
        this.e.a(-2);
        this.g.add(mediaFormat);
    }

    public int c() {
        synchronized (this.f21216a) {
            j();
            int iE = -1;
            if (i()) {
                return -1;
            }
            if (!this.d.d()) {
                iE = this.d.e();
            }
            return iE;
        }
    }

    public int d(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f21216a) {
            j();
            if (i()) {
                return -1;
            }
            if (this.e.d()) {
                return -1;
            }
            int iE = this.e.e();
            if (iE >= 0) {
                vh.i(this.h);
                MediaCodec.BufferInfo bufferInfoRemove = this.f.remove();
                bufferInfo.set(bufferInfoRemove.offset, bufferInfoRemove.size, bufferInfoRemove.presentationTimeUs, bufferInfoRemove.flags);
            } else if (iE == -2) {
                this.h = this.g.remove();
            }
            return iE;
        }
    }

    public void e() {
        synchronized (this.f21216a) {
            this.k++;
            ((Handler) g86.j(this.c)).post(new Runnable() { // from class: ti
                @Override // java.lang.Runnable
                public final void run() {
                    this.f20993a.m();
                }
            });
        }
    }

    @GuardedBy("lock")
    public final void f() {
        if (!this.g.isEmpty()) {
            this.i = this.g.getLast();
        }
        this.d.b();
        this.e.b();
        this.f.clear();
        this.g.clear();
    }

    public MediaFormat g() {
        MediaFormat mediaFormat;
        synchronized (this.f21216a) {
            mediaFormat = this.h;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public void h(MediaCodec mediaCodec) {
        vh.g(this.c == null);
        this.b.start();
        Handler handler = new Handler(this.b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.c = handler;
    }

    @GuardedBy("lock")
    public final boolean i() {
        return this.k > 0 || this.l;
    }

    @GuardedBy("lock")
    public final void j() {
        k();
        l();
    }

    @GuardedBy("lock")
    public final void k() {
        IllegalStateException illegalStateException = this.m;
        if (illegalStateException == null) {
            return;
        }
        this.m = null;
        throw illegalStateException;
    }

    @GuardedBy("lock")
    public final void l() {
        MediaCodec.CodecException codecException = this.j;
        if (codecException == null) {
            return;
        }
        this.j = null;
        throw codecException;
    }

    public final void m() {
        synchronized (this.f21216a) {
            if (this.l) {
                return;
            }
            long j = this.k - 1;
            this.k = j;
            if (j > 0) {
                return;
            }
            if (j < 0) {
                n(new IllegalStateException());
            } else {
                f();
            }
        }
    }

    public final void n(IllegalStateException illegalStateException) {
        synchronized (this.f21216a) {
            this.m = illegalStateException;
        }
    }

    public void o() {
        synchronized (this.f21216a) {
            this.l = true;
            this.b.quit();
            f();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f21216a) {
            this.j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        synchronized (this.f21216a) {
            this.d.a(i);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f21216a) {
            MediaFormat mediaFormat = this.i;
            if (mediaFormat != null) {
                b(mediaFormat);
                this.i = null;
            }
            this.e.a(i);
            this.f.add(bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f21216a) {
            b(mediaFormat);
            this.i = null;
        }
    }
}
