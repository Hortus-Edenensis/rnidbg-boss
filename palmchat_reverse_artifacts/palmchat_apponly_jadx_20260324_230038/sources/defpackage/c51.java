package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.ads.ContentClassification;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import defpackage.jn1;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.ranges.RangesKt___RangesKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b&\u0010\u001aJ\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002R\u0014\u0010\u0016\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u000f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"¨\u0006'"}, d2 = {"Lc51;", "Ljn1;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "task", "", WkAdxAdConfigMg.DSP_NAME_GDT, "", "now", "Ljn1$a;", "delayedTask", WkAdxAdConfigMg.DSP_NAME_BAIDU, "shutdown", "run", "W", "Ljava/lang/Thread;", ExifInterface.LATITUDE_SOUTH, "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "R", "g", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "KEEP_ALIVE_NANOS", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "()V", "", "debugStatus", "I", "y", "()Ljava/lang/Thread;", "thread", ExifInterface.GPS_DIRECTION_TRUE, "()Z", "isShutDown", "U", "isShutdownRequested", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class c51 extends jn1 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final c51 f;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public static final long KEEP_ALIVE_NANOS;

    static {
        Long l;
        c51 c51Var = new c51();
        f = c51Var;
        in1.k(c51Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        KEEP_ALIVE_NANOS = timeUnit.toNanos(l.longValue());
    }

    @Override // defpackage.kn1
    public void B(long now, jn1.a delayedTask) {
        W();
    }

    @Override // defpackage.jn1
    public void G(Runnable task) {
        if (T()) {
            W();
        }
        super.G(task);
    }

    public final synchronized void R() {
        if (U()) {
            debugStatus = 3;
            M();
            notifyAll();
        }
    }

    public final synchronized Thread S() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean T() {
        return debugStatus == 4;
    }

    public final boolean U() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    public final synchronized boolean V() {
        if (U()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    public final void W() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zJ;
        sw5.f20863a.c(this);
        a2.a();
        try {
            if (!V()) {
                if (zJ) {
                    return;
                } else {
                    return;
                }
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jK = K();
                if (jK == Long.MAX_VALUE) {
                    a2.a();
                    long jNanoTime = System.nanoTime();
                    if (j == Long.MAX_VALUE) {
                        j = KEEP_ALIVE_NANOS + jNanoTime;
                    }
                    long j2 = j - jNanoTime;
                    if (j2 <= 0) {
                        _thread = null;
                        R();
                        a2.a();
                        if (J()) {
                            return;
                        }
                        getThread();
                        return;
                    }
                    jK = RangesKt___RangesKt.coerceAtMost(jK, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (jK > 0) {
                    if (U()) {
                        _thread = null;
                        R();
                        a2.a();
                        if (J()) {
                            return;
                        }
                        getThread();
                        return;
                    }
                    a2.a();
                    LockSupport.parkNanos(this, jK);
                }
            }
        } finally {
            _thread = null;
            R();
            a2.a();
            if (!J()) {
                getThread();
            }
        }
    }

    @Override // defpackage.jn1, defpackage.in1
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // defpackage.kn1
    /* JADX INFO: renamed from: y */
    public Thread getThread() {
        Thread thread = _thread;
        return thread == null ? S() : thread;
    }
}
