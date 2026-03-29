package defpackage;

import com.amap.api.col.p0002sl.hb;
import com.kuaishou.weapon.p0.t;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0000¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u001c\u0010\u0004J\u0015\u0010\u001d\u001a\u00020\u0011*\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010 R\u0014\u0010%\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$¨\u0006*"}, d2 = {"Lno6;", "", "Let5;", "h", "()Let5;", "task", "", "fair", "a", "(Let5;Z)Let5;", "victim", "", "l", "(Lno6;)J", t.f7496a, "Lpc2;", "globalQueue", "", "g", "(Lpc2;)V", "c", "(Let5;)Let5;", "blockingOnly", "m", "(Lno6;Z)J", "queue", hb.j, "(Lpc2;)Z", "i", "d", "(Let5;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "", "e", "()I", "bufferSize", "f", "size", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class no6 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(no6.class, Object.class, "lastScheduledTask");
    public static final /* synthetic */ AtomicIntegerFieldUpdater c = AtomicIntegerFieldUpdater.newUpdater(no6.class, "producerIndex");
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(no6.class, "consumerIndex");
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = AtomicIntegerFieldUpdater.newUpdater(no6.class, "blockingTasksInBuffer");

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AtomicReferenceArray<et5> buffer = new AtomicReferenceArray<>(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ et5 b(no6 no6Var, et5 et5Var, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return no6Var.a(et5Var, z);
    }

    public final et5 a(et5 task, boolean fair) {
        if (fair) {
            return c(task);
        }
        et5 et5Var = (et5) b.getAndSet(this, task);
        if (et5Var == null) {
            return null;
        }
        return c(et5Var);
    }

    public final et5 c(et5 task) {
        if (task.taskContext.getTaskMode() == 1) {
            e.incrementAndGet(this);
        }
        if (e() == 127) {
            return task;
        }
        int i = this.producerIndex & 127;
        while (this.buffer.get(i) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(i, task);
        c.incrementAndGet(this);
        return null;
    }

    public final void d(et5 et5Var) {
        if (et5Var != null) {
            if (et5Var.taskContext.getTaskMode() == 1) {
                e.decrementAndGet(this);
            }
        }
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(pc2 globalQueue) {
        et5 et5Var = (et5) b.getAndSet(this, null);
        if (et5Var != null) {
            globalQueue.a(et5Var);
        }
        while (j(globalQueue)) {
        }
    }

    public final et5 h() {
        et5 et5Var = (et5) b.getAndSet(this, null);
        return et5Var == null ? i() : et5Var;
    }

    public final et5 i() {
        et5 andSet;
        while (true) {
            int i = this.consumerIndex;
            if (i - this.producerIndex == 0) {
                return null;
            }
            int i2 = i & 127;
            if (d.compareAndSet(this, i, i + 1) && (andSet = this.buffer.getAndSet(i2, null)) != null) {
                d(andSet);
                return andSet;
            }
        }
    }

    public final boolean j(pc2 queue) {
        et5 et5VarI = i();
        if (et5VarI == null) {
            return false;
        }
        queue.a(et5VarI);
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        return m(r9, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long k(no6 victim) {
        int i = victim.consumerIndex;
        int i2 = victim.producerIndex;
        AtomicReferenceArray<et5> atomicReferenceArray = victim.buffer;
        while (true) {
            if (i == i2) {
                break;
            }
            int i3 = i & 127;
            if (victim.blockingTasksInBuffer == 0) {
                break;
            }
            et5 et5Var = atomicReferenceArray.get(i3);
            if (et5Var != null) {
                if ((et5Var.taskContext.getTaskMode() == 1) && hl0.a(atomicReferenceArray, i3, et5Var, null)) {
                    e.decrementAndGet(victim);
                    b(this, et5Var, false, 2, null);
                    return -1L;
                }
            }
            i++;
        }
    }

    public final long l(no6 victim) {
        et5 et5VarI = victim.i();
        if (et5VarI == null) {
            return m(victim, false);
        }
        b(this, et5VarI, false, 2, null);
        return -1L;
    }

    public final long m(no6 victim, boolean blockingOnly) {
        et5 et5Var;
        do {
            et5Var = (et5) victim.lastScheduledTask;
            if (et5Var == null) {
                return -2L;
            }
            if (blockingOnly) {
                if (!(et5Var.taskContext.getTaskMode() == 1)) {
                    return -2L;
                }
            }
            long jA = st5.e.a() - et5Var.submissionTime;
            long j = st5.f20844a;
            if (jA < j) {
                return j - jA;
            }
        } while (!p1.a(b, victim, et5Var, null));
        b(this, et5Var, false, 2, null);
        return -1L;
    }
}
