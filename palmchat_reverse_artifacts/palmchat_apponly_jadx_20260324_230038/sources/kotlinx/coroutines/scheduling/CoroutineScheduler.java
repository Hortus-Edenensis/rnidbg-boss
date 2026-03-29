package kotlinx.coroutines.scheduling;

import android.support.v4.media.session.PlaybackStateCompat;
import com.amap.api.col.p0002sl.hb;
import com.baidu.location.LocationConst;
import com.huawei.hms.ads.ContentClassification;
import com.kuaishou.weapon.p0.t;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import defpackage.a2;
import defpackage.et5;
import defpackage.gx4;
import defpackage.jt5;
import defpackage.no6;
import defpackage.ot5;
import defpackage.pc2;
import defpackage.pv0;
import defpackage.st5;
import defpackage.yp5;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt___RangesKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0003\u0006\u0019OB+\u0012\u0006\u0010=\u001a\u00020\f\u0012\u0006\u0010?\u001a\u00020\f\u0012\b\b\u0002\u0010A\u001a\u00020\u0013\u0012\b\b\u0002\u0010C\u001a\u000207¢\u0006\u0004\bM\u0010NJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\bR\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001c\u001a\u0004\u0018\u00010\u0003*\b\u0018\u00010\bR\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\b\u0018\u00010\bR\u00020\u0000H\u0002¢\u0006\u0004\b\u001e\u0010\nJ)\u0010!\u001a\u00020\u00102\n\u0010\u000b\u001a\u00060\bR\u00020\u00002\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\f¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\u00052\n\u0010\u000b\u001a\u00060\bR\u00020\u0000¢\u0006\u0004\b#\u0010$J\u001b\u0010(\u001a\u00020\u00102\n\u0010'\u001a\u00060%j\u0002`&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0010H\u0016¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0013¢\u0006\u0004\b-\u0010.J-\u00102\u001a\u00020\u00102\n\u0010/\u001a\u00060%j\u0002`&2\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b2\u00103J!\u00104\u001a\u00020\u00032\n\u0010/\u001a\u00060%j\u0002`&2\u0006\u00101\u001a\u000200¢\u0006\u0004\b4\u00105J\r\u00106\u001a\u00020\u0010¢\u0006\u0004\b6\u0010+J\u000f\u00108\u001a\u000207H\u0016¢\u0006\u0004\b8\u00109J\u0015\u0010:\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010<R\u0014\u0010?\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b>\u0010<R\u0014\u0010A\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010@R\u0014\u0010C\u001a\u0002078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b4\u0010BR\u0014\u0010F\u001a\u00020D8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010ER\u0014\u0010G\u001a\u00020D8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b2\u0010ER\u001e\u0010K\u001a\f\u0012\b\u0012\u00060\bR\u00020\u00000H8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0011\u0010L\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bL\u0010\u0018¨\u0006P"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "Ljava/util/concurrent/Executor;", "Ljava/io/Closeable;", "Let5;", "task", "", "a", "(Let5;)Z", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;", "i", "()Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;", "worker", "", "h", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;)I", "skipUnpark", "", "n", "(Z)V", "", LocationConst.HDYawConst.KEY_HD_YAW_STATE, t.k, "(J)Z", "x", "()Z", "c", "()I", "tailDispatch", "q", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;Let5;Z)Let5;", "e", "oldIndex", "newIndex", t.f7496a, "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;II)V", hb.j, "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;)Z", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", com.heytap.mcssdk.constant.b.y, "execute", "(Ljava/lang/Runnable;)V", "close", "()V", WkAdConfigModel.TAG_TIMEOUT, "m", "(J)V", "block", "Ljt5;", "taskContext", "f", "(Ljava/lang/Runnable;Ljt5;Z)V", "d", "(Ljava/lang/Runnable;Ljt5;)Let5;", "p", "", "toString", "()Ljava/lang/String;", "l", "(Let5;)V", "I", "corePoolSize", t.l, "maxPoolSize", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "idleWorkerKeepAliveNs", "Ljava/lang/String;", "schedulerName", "Lpc2;", "Lpc2;", "globalCpuQueue", "globalBlockingQueue", "Lgx4;", "g", "Lgx4;", "workers", "isTerminated", "<init>", "(IIJLjava/lang/String;)V", "WorkerState", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class CoroutineScheduler implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public final int corePoolSize;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    @JvmField
    public final int maxPoolSize;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @JvmField
    public final long idleWorkerKeepAliveNs;
    volatile /* synthetic */ long controlState;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @JvmField
    public final String schedulerName;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @JvmField
    public final pc2 globalCpuQueue;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @JvmField
    public final pc2 globalBlockingQueue;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @JvmField
    public final gx4<c> workers;
    private volatile /* synthetic */ long parkedWorkersStack;

    @JvmField
    public static final yp5 l = new yp5("NOT_IN_STACK");
    public static final /* synthetic */ AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");
    public static final /* synthetic */ AtomicLongFieldUpdater j = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");
    public static final /* synthetic */ AtomicIntegerFieldUpdater k = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "", "(Ljava/lang/String;I)V", "CPU_ACQUIRED", "BLOCKING", "PARKING", "DORMANT", "TERMINATED", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WorkerState.values().length];
            iArr[WorkerState.PARKING.ordinal()] = 1;
            iArr[WorkerState.BLOCKING.ordinal()] = 2;
            iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[WorkerState.DORMANT.ordinal()] = 4;
            iArr[WorkerState.TERMINATED.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public CoroutineScheduler(int i2, int i3, long j2, String str) {
        this.corePoolSize = i2;
        this.maxPoolSize = i3;
        this.idleWorkerKeepAliveNs = j2;
        this.schedulerName = str;
        if (!(i2 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i2 + " should be at least 1").toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should be greater than or equals to core pool size " + i2).toString());
        }
        if (!(i3 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i3 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j2 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.globalCpuQueue = new pc2();
        this.globalBlockingQueue = new pc2();
        this.parkedWorkersStack = 0L;
        this.workers = new gx4<>(i2 + 1);
        this.controlState = ((long) i2) << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void g(CoroutineScheduler coroutineScheduler, Runnable runnable, jt5 jt5Var, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            jt5Var = st5.f;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        coroutineScheduler.f(runnable, jt5Var, z);
    }

    public static /* synthetic */ boolean s(CoroutineScheduler coroutineScheduler, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.r(j2);
    }

    public final boolean a(et5 task) {
        return task.taskContext.getTaskMode() == 1 ? this.globalBlockingQueue.a(task) : this.globalCpuQueue.a(task);
    }

    public final int c() {
        synchronized (this.workers) {
            if (isTerminated()) {
                return -1;
            }
            long j2 = this.controlState;
            int i2 = (int) (j2 & 2097151);
            int iCoerceAtLeast = RangesKt___RangesKt.coerceAtLeast(i2 - ((int) ((j2 & 4398044413952L) >> 21)), 0);
            if (iCoerceAtLeast >= this.corePoolSize) {
                return 0;
            }
            if (i2 >= this.maxPoolSize) {
                return 0;
            }
            int i3 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i3 > 0 && this.workers.b(i3) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c cVar = new c(this, i3);
            this.workers.c(i3, cVar);
            if (!(i3 == ((int) (2097151 & j.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            cVar.start();
            return iCoerceAtLeast + 1;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        m(10000L);
    }

    public final et5 d(Runnable block, jt5 taskContext) {
        long jA = st5.e.a();
        if (!(block instanceof et5)) {
            return new ot5(block, jA, taskContext);
        }
        et5 et5Var = (et5) block;
        et5Var.submissionTime = jA;
        et5Var.taskContext = taskContext;
        return et5Var;
    }

    public final c e() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar == null || !Intrinsics.areEqual(CoroutineScheduler.this, this)) {
            return null;
        }
        return cVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        g(this, command, null, false, 6, null);
    }

    public final void f(Runnable block, jt5 taskContext, boolean tailDispatch) {
        a2.a();
        et5 et5VarD = d(block, taskContext);
        c cVarE = e();
        et5 et5VarQ = q(cVarE, et5VarD, tailDispatch);
        if (et5VarQ != null && !a(et5VarQ)) {
            throw new RejectedExecutionException(this.schedulerName + " was terminated");
        }
        boolean z = tailDispatch && cVarE != null;
        if (et5VarD.taskContext.getTaskMode() != 0) {
            n(z);
        } else {
            if (z) {
                return;
            }
            p();
        }
    }

    public final int h(c worker) {
        Object nextParkedWorker = worker.getNextParkedWorker();
        while (nextParkedWorker != l) {
            if (nextParkedWorker == null) {
                return 0;
            }
            c cVar = (c) nextParkedWorker;
            int indexInArray = cVar.getIndexInArray();
            if (indexInArray != 0) {
                return indexInArray;
            }
            nextParkedWorker = cVar.getNextParkedWorker();
        }
        return -1;
    }

    public final c i() {
        while (true) {
            long j2 = this.parkedWorkersStack;
            c cVarB = this.workers.b((int) (2097151 & j2));
            if (cVarB == null) {
                return null;
            }
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            int iH = h(cVarB);
            if (iH >= 0 && i.compareAndSet(this, j2, ((long) iH) | j3)) {
                cVarB.p(l);
                return cVarB;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final boolean j(c worker) {
        long j2;
        long j3;
        int indexInArray;
        if (worker.getNextParkedWorker() != l) {
            return false;
        }
        do {
            j2 = this.parkedWorkersStack;
            j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            indexInArray = worker.getIndexInArray();
            worker.p(this.workers.b((int) (2097151 & j2)));
        } while (!i.compareAndSet(this, j2, j3 | ((long) indexInArray)));
        return true;
    }

    public final void k(c worker, int oldIndex, int newIndex) {
        while (true) {
            long j2 = this.parkedWorkersStack;
            int iH = (int) (2097151 & j2);
            long j3 = (PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE + j2) & (-2097152);
            if (iH == oldIndex) {
                iH = newIndex == 0 ? h(worker) : newIndex;
            }
            if (iH >= 0 && i.compareAndSet(this, j2, j3 | ((long) iH))) {
                return;
            }
        }
    }

    public final void l(et5 task) {
        try {
            task.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m(long timeout) throws InterruptedException {
        int i2;
        et5 et5VarD;
        if (k.compareAndSet(this, 0, 1)) {
            c cVarE = e();
            synchronized (this.workers) {
                i2 = (int) (this.controlState & 2097151);
            }
            if (1 <= i2) {
                int i3 = 1;
                while (true) {
                    c cVarB = this.workers.b(i3);
                    Intrinsics.checkNotNull(cVarB);
                    c cVar = cVarB;
                    if (cVar != cVarE) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(timeout);
                        }
                        cVar.localQueue.g(this.globalBlockingQueue);
                    }
                    if (i3 == i2) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            this.globalBlockingQueue.b();
            this.globalCpuQueue.b();
            while (true) {
                if (cVarE == null) {
                    et5VarD = this.globalCpuQueue.d();
                    if (et5VarD == null && (et5VarD = this.globalBlockingQueue.d()) == null) {
                        break;
                    }
                } else {
                    et5VarD = cVarE.f(true);
                    if (et5VarD != null) {
                        continue;
                    }
                }
                l(et5VarD);
            }
            if (cVarE != null) {
                cVarE.s(WorkerState.TERMINATED);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void n(boolean skipUnpark) {
        long jAddAndGet = j.addAndGet(this, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE);
        if (skipUnpark || x() || r(jAddAndGet)) {
            return;
        }
        x();
    }

    public final void p() {
        if (x() || s(this, 0L, 1, null)) {
            return;
        }
        x();
    }

    public final et5 q(c cVar, et5 et5Var, boolean z) {
        if (cVar == null || cVar.state == WorkerState.TERMINATED) {
            return et5Var;
        }
        if (et5Var.taskContext.getTaskMode() == 0 && cVar.state == WorkerState.BLOCKING) {
            return et5Var;
        }
        cVar.mayHaveLocalTasks = true;
        return cVar.localQueue.a(et5Var, z);
    }

    public final boolean r(long state) {
        if (RangesKt___RangesKt.coerceAtLeast(((int) (2097151 & state)) - ((int) ((state & 4398044413952L) >> 21)), 0) < this.corePoolSize) {
            int iC = c();
            if (iC == 1 && this.corePoolSize > 1) {
                c();
            }
            if (iC > 0) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.workers.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < iA; i7++) {
            c cVarB = this.workers.b(i7);
            if (cVarB != null) {
                int iF = cVarB.localQueue.f();
                int i8 = b.$EnumSwitchMapping$0[cVarB.state.ordinal()];
                if (i8 == 1) {
                    i4++;
                } else if (i8 == 2) {
                    i3++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iF);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i8 == 3) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iF);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i8 == 4) {
                    i5++;
                    if (iF > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iF);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i8 == 5) {
                    i6++;
                }
            }
        }
        long j2 = this.controlState;
        return this.schedulerName + '@' + pv0.b(this) + "[Pool Size {core = " + this.corePoolSize + ", max = " + this.maxPoolSize + "}, Worker States {CPU = " + i2 + ", blocking = " + i3 + ", parked = " + i4 + ", dormant = " + i5 + ", terminated = " + i6 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.globalCpuQueue.c() + ", global blocking queue size = " + this.globalBlockingQueue.c() + ", Control State {created workers= " + ((int) (2097151 & j2)) + ", blocking tasks = " + ((int) ((4398044413952L & j2) >> 21)) + ", CPUs acquired = " + (this.corePoolSize - ((int) ((9223367638808264704L & j2) >> 42))) + "}]";
    }

    public final boolean x() {
        c cVarI;
        do {
            cVarI = i();
            if (cVarI == null) {
                return false;
            }
        } while (!c.h.compareAndSet(cVarI, -1, 0));
        LockSupport.unpark(cVarI);
        return true;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000e\b\u0080\u0004\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bA\u0010BB\u0011\b\u0016\u0012\u0006\u0010'\u001a\u00020\n¢\u0006\u0004\bA\u0010CJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\tJ\u000f\u0010\u0015\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0015\u0010\tJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001e\u0010\tJ\u000f\u0010\u001f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001f\u0010\tJ\u0017\u0010!\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\nH\u0002¢\u0006\u0004\b!\u0010\u001cJ\u0019\u0010\"\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0011J\u0011\u0010#\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010&\u001a\u0004\u0018\u00010\u000f2\u0006\u0010%\u001a\u00020\u0004H\u0002¢\u0006\u0004\b&\u0010\u0011R*\u0010(\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010\u001cR\u0014\u00100\u001a\u00020-8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u00101R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u00104R$\u00107\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010=\u001a\u0002038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u00104R\u0016\u0010>\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010)R\u0016\u0010@\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010?¨\u0006D"}, d2 = {"Lkotlinx/coroutines/scheduling/CoroutineScheduler$c;", "Ljava/lang/Thread;", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", "newState", "", "s", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;)Z", "", "run", "()V", "", "upperBound", t.f7496a, "(I)I", "scanLocalQueue", "Let5;", "f", "(Z)Let5;", "q", "()Z", "n", t.k, hb.j, "task", "d", "(Let5;)V", "taskMode", "c", "(I)V", t.l, "l", "u", "mode", "i", "e", "m", "()Let5;", "blockingOnly", "t", "index", "indexInArray", "I", "g", "()I", "o", "Lno6;", "a", "Lno6;", "localQueue", "Lkotlinx/coroutines/scheduling/CoroutineScheduler$WorkerState;", LocationConst.HDYawConst.KEY_HD_YAW_STATE, "", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "terminationDeadline", "", "nextParkedWorker", "Ljava/lang/Object;", "h", "()Ljava/lang/Object;", "p", "(Ljava/lang/Object;)V", "minDelayUntilStealableTaskNs", "rngState", "Z", "mayHaveLocalTasks", "<init>", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;)V", "(Lkotlinx/coroutines/scheduling/CoroutineScheduler;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public final class c extends Thread {
        public static final /* synthetic */ AtomicIntegerFieldUpdater h = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public final no6 localQueue;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @JvmField
        public WorkerState state;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        public long terminationDeadline;

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        public long minDelayUntilStealableTaskNs;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        public int rngState;

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        @JvmField
        public boolean mayHaveLocalTasks;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        public c() {
            setDaemon(true);
            this.localQueue = new no6();
            this.state = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.l;
            this.rngState = Random.INSTANCE.nextInt();
        }

        public final void b(int taskMode) {
            if (taskMode == 0) {
                return;
            }
            CoroutineScheduler.j.addAndGet(CoroutineScheduler.this, -2097152L);
            if (this.state != WorkerState.TERMINATED) {
                this.state = WorkerState.DORMANT;
            }
        }

        public final void c(int taskMode) {
            if (taskMode != 0 && s(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.p();
            }
        }

        public final void d(et5 task) {
            int taskMode = task.taskContext.getTaskMode();
            i(taskMode);
            c(taskMode);
            CoroutineScheduler.this.l(task);
            b(taskMode);
        }

        public final et5 e(boolean scanLocalQueue) {
            et5 et5VarM;
            et5 et5VarM2;
            if (scanLocalQueue) {
                boolean z = k(CoroutineScheduler.this.corePoolSize * 2) == 0;
                if (z && (et5VarM2 = m()) != null) {
                    return et5VarM2;
                }
                et5 et5VarH = this.localQueue.h();
                if (et5VarH != null) {
                    return et5VarH;
                }
                if (!z && (et5VarM = m()) != null) {
                    return et5VarM;
                }
            } else {
                et5 et5VarM3 = m();
                if (et5VarM3 != null) {
                    return et5VarM3;
                }
            }
            return t(false);
        }

        public final et5 f(boolean scanLocalQueue) {
            et5 et5VarD;
            if (q()) {
                return e(scanLocalQueue);
            }
            if (!scanLocalQueue || (et5VarD = this.localQueue.h()) == null) {
                et5VarD = CoroutineScheduler.this.globalBlockingQueue.d();
            }
            return et5VarD == null ? t(true) : et5VarD;
        }

        /* JADX INFO: renamed from: g, reason: from getter */
        public final int getIndexInArray() {
            return this.indexInArray;
        }

        /* JADX INFO: renamed from: h, reason: from getter */
        public final Object getNextParkedWorker() {
            return this.nextParkedWorker;
        }

        public final void i(int mode) {
            this.terminationDeadline = 0L;
            if (this.state == WorkerState.PARKING) {
                this.state = WorkerState.BLOCKING;
            }
        }

        public final boolean j() {
            return this.nextParkedWorker != CoroutineScheduler.l;
        }

        public final int k(int upperBound) {
            int i = this.rngState;
            int i2 = i ^ (i << 13);
            int i3 = i2 ^ (i2 >> 17);
            int i4 = i3 ^ (i3 << 5);
            this.rngState = i4;
            int i5 = upperBound - 1;
            return (i5 & upperBound) == 0 ? i4 & i5 : (i4 & Integer.MAX_VALUE) % upperBound;
        }

        public final void l() {
            if (this.terminationDeadline == 0) {
                this.terminationDeadline = System.nanoTime() + CoroutineScheduler.this.idleWorkerKeepAliveNs;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.idleWorkerKeepAliveNs);
            if (System.nanoTime() - this.terminationDeadline >= 0) {
                this.terminationDeadline = 0L;
                u();
            }
        }

        public final et5 m() {
            if (k(2) == 0) {
                et5 et5VarD = CoroutineScheduler.this.globalCpuQueue.d();
                return et5VarD != null ? et5VarD : CoroutineScheduler.this.globalBlockingQueue.d();
            }
            et5 et5VarD2 = CoroutineScheduler.this.globalBlockingQueue.d();
            return et5VarD2 != null ? et5VarD2 : CoroutineScheduler.this.globalCpuQueue.d();
        }

        public final void n() {
            loop0: while (true) {
                boolean z = false;
                while (!CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                    et5 et5VarF = f(this.mayHaveLocalTasks);
                    if (et5VarF != null) {
                        this.minDelayUntilStealableTaskNs = 0L;
                        d(et5VarF);
                    } else {
                        this.mayHaveLocalTasks = false;
                        if (this.minDelayUntilStealableTaskNs == 0) {
                            r();
                        } else if (z) {
                            s(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.minDelayUntilStealableTaskNs);
                            this.minDelayUntilStealableTaskNs = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
                break loop0;
            }
            s(WorkerState.TERMINATED);
        }

        public final void o(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.schedulerName);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void p(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean q() {
            boolean z;
            if (this.state == WorkerState.CPU_ACQUIRED) {
                return true;
            }
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            while (true) {
                long j = coroutineScheduler.controlState;
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    z = false;
                    break;
                }
                if (CoroutineScheduler.j.compareAndSet(coroutineScheduler, j, j - 4398046511104L)) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                return false;
            }
            this.state = WorkerState.CPU_ACQUIRED;
            return true;
        }

        public final void r() {
            if (!j()) {
                CoroutineScheduler.this.j(this);
                return;
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !CoroutineScheduler.this.isTerminated() && this.state != WorkerState.TERMINATED) {
                s(WorkerState.PARKING);
                Thread.interrupted();
                l();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n();
        }

        public final boolean s(WorkerState newState) {
            WorkerState workerState = this.state;
            boolean z = workerState == WorkerState.CPU_ACQUIRED;
            if (z) {
                CoroutineScheduler.j.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState != newState) {
                this.state = newState;
            }
            return z;
        }

        public final et5 t(boolean blockingOnly) {
            int i = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i < 2) {
                return null;
            }
            int iK = k(i);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long jMin = Long.MAX_VALUE;
            for (int i2 = 0; i2 < i; i2++) {
                iK++;
                if (iK > i) {
                    iK = 1;
                }
                c cVarB = coroutineScheduler.workers.b(iK);
                if (cVarB != null && cVarB != this) {
                    long jK = blockingOnly ? this.localQueue.k(cVarB.localQueue) : this.localQueue.l(cVarB.localQueue);
                    if (jK == -1) {
                        return this.localQueue.h();
                    }
                    if (jK > 0) {
                        jMin = Math.min(jMin, jK);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.minDelayUntilStealableTaskNs = jMin;
            return null;
        }

        public final void u() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.workers) {
                if (coroutineScheduler.isTerminated()) {
                    return;
                }
                if (((int) (coroutineScheduler.controlState & 2097151)) <= coroutineScheduler.corePoolSize) {
                    return;
                }
                if (h.compareAndSet(this, -1, 1)) {
                    int i = this.indexInArray;
                    o(0);
                    coroutineScheduler.k(this, i, 0);
                    int andDecrement = (int) (CoroutineScheduler.j.getAndDecrement(coroutineScheduler) & 2097151);
                    if (andDecrement != i) {
                        c cVarB = coroutineScheduler.workers.b(andDecrement);
                        Intrinsics.checkNotNull(cVarB);
                        c cVar = cVarB;
                        coroutineScheduler.workers.c(i, cVar);
                        cVar.o(i);
                        coroutineScheduler.k(cVar, andDecrement, i);
                    }
                    coroutineScheduler.workers.c(andDecrement, null);
                    Unit unit = Unit.INSTANCE;
                    this.state = WorkerState.TERMINATED;
                }
            }
        }

        public c(CoroutineScheduler coroutineScheduler, int i) {
            this();
            o(i);
        }
    }
}
