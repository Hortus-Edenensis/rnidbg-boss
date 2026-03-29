package defpackage;

import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@RequiresApi(23)
@Deprecated
public class ri {

    @GuardedBy("MESSAGE_PARAMS_INSTANCE_POOL")
    public static final ArrayDeque<b> g = new ArrayDeque<>();
    public static final Object h = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaCodec f20480a;
    public final HandlerThread b;
    public Handler c;
    public final AtomicReference<RuntimeException> d;
    public final ml0 e;
    public boolean f;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ri.this.f(message);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20482a;
        public int b;
        public int c;
        public final MediaCodec.CryptoInfo d = new MediaCodec.CryptoInfo();
        public long e;
        public int f;

        public void a(int i, int i2, int i3, long j, int i4) {
            this.f20482a = i;
            this.b = i2;
            this.c = i3;
            this.e = j;
            this.f = i4;
        }
    }

    public ri(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new ml0());
    }

    public static void c(ir0 ir0Var, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = ir0Var.f;
        cryptoInfo.numBytesOfClearData = e(ir0Var.d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = e(ir0Var.e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) vh.e(d(ir0Var.b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) vh.e(d(ir0Var.f18240a, cryptoInfo.iv));
        cryptoInfo.mode = ir0Var.c;
        if (g86.f17680a >= 24) {
            qi.a();
            cryptoInfo.setPattern(lr0.a(ir0Var.g, ir0Var.h));
        }
    }

    @Nullable
    public static byte[] d(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Nullable
    public static int[] e(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static b k() {
        ArrayDeque<b> arrayDeque = g;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new b();
            }
            return arrayDeque.removeFirst();
        }
    }

    public static void o(b bVar) {
        ArrayDeque<b> arrayDeque = g;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }

    public final void b() throws InterruptedException {
        this.e.c();
        ((Handler) vh.e(this.c)).obtainMessage(2).sendToTarget();
        this.e.a();
    }

    public final void f(Message message) {
        b bVar;
        int i = message.what;
        if (i == 0) {
            bVar = (b) message.obj;
            g(bVar.f20482a, bVar.b, bVar.c, bVar.e, bVar.f);
        } else if (i != 1) {
            bVar = null;
            if (i != 2) {
                g23.a(this.d, null, new IllegalStateException(String.valueOf(message.what)));
            } else {
                this.e.e();
            }
        } else {
            bVar = (b) message.obj;
            h(bVar.f20482a, bVar.b, bVar.d, bVar.e, bVar.f);
        }
        if (bVar != null) {
            o(bVar);
        }
    }

    public final void g(int i, int i2, int i3, long j, int i4) {
        try {
            this.f20480a.queueInputBuffer(i, i2, i3, j, i4);
        } catch (RuntimeException e) {
            g23.a(this.d, null, e);
        }
    }

    public final void h(int i, int i2, MediaCodec.CryptoInfo cryptoInfo, long j, int i3) {
        try {
            synchronized (h) {
                this.f20480a.queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
            }
        } catch (RuntimeException e) {
            g23.a(this.d, null, e);
        }
    }

    public void i() {
        if (this.f) {
            try {
                j();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    public final void j() throws InterruptedException {
        ((Handler) vh.e(this.c)).removeCallbacksAndMessages(null);
        b();
    }

    public void l() {
        RuntimeException andSet = this.d.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }

    public void m(int i, int i2, int i3, long j, int i4) {
        l();
        b bVarK = k();
        bVarK.a(i, i2, i3, j, i4);
        ((Handler) g86.j(this.c)).obtainMessage(0, bVarK).sendToTarget();
    }

    public void n(int i, int i2, ir0 ir0Var, long j, int i3) {
        l();
        b bVarK = k();
        bVarK.a(i, i2, 0, j, i3);
        c(ir0Var, bVarK.d);
        ((Handler) g86.j(this.c)).obtainMessage(1, bVarK).sendToTarget();
    }

    public void p() {
        if (this.f) {
            i();
            this.b.quit();
        }
        this.f = false;
    }

    public void q() {
        if (this.f) {
            return;
        }
        this.b.start();
        this.c = new a(this.b.getLooper());
        this.f = true;
    }

    public void r() throws InterruptedException {
        b();
    }

    @VisibleForTesting
    public ri(MediaCodec mediaCodec, HandlerThread handlerThread, ml0 ml0Var) {
        this.f20480a = mediaCodec;
        this.b = handlerThread;
        this.e = ml0Var;
        this.d = new AtomicReference<>();
    }
}
