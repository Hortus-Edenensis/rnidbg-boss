package defpackage;

import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u00032\u00020\u0004B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b \u0010!J\u0010\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0017J\b\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u001c\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003H\u0017J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0014\u0010\u0011\u001a\u00020\u000f2\n\u0010\f\u001a\u00060\u0002j\u0002`\u0003H\u0002R\u0014\u0010\u0014\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u001e\u0010\u001a\u001a\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0019R\u0018\u0010\u001f\u001a\u00060\u001bj\u0002`\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lm23;", "Llq0;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lua1;", "", "parallelism", "limitedParallelism", "", "run", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "dispatchYield", "", "f", "d", "a", "Llq0;", "dispatcher", t.l, "I", "runningWorkers", "Lw53;", "Lw53;", "queue", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "e", "Ljava/lang/Object;", "workerAllocationLock", "<init>", "(Llq0;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class m23 extends lq0 implements Runnable, ua1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final lq0 dispatcher;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int parallelism;
    public final /* synthetic */ ua1 c;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final w53<Runnable> queue;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final Object workerAllocationLock;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public m23(lq0 lq0Var, int i) {
        this.dispatcher = lq0Var;
        this.parallelism = i;
        ua1 ua1Var = lq0Var instanceof ua1 ? (ua1) lq0Var : null;
        this.c = ua1Var == null ? d51.a() : ua1Var;
        this.queue = new w53<>(false);
        this.workerAllocationLock = new Object();
    }

    public final boolean d(Runnable block) {
        this.queue.a(block);
        return this.runningWorkers >= this.parallelism;
    }

    @Override // defpackage.lq0
    public void dispatch(CoroutineContext context, Runnable block) {
        if (d(block) || !f()) {
            return;
        }
        this.dispatcher.dispatch(this, this);
    }

    @Override // defpackage.lq0
    public void dispatchYield(CoroutineContext context, Runnable block) {
        if (d(block) || !f()) {
            return;
        }
        this.dispatcher.dispatchYield(this, this);
    }

    public final boolean f() {
        synchronized (this.workerAllocationLock) {
            if (this.runningWorkers >= this.parallelism) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    @Override // defpackage.lq0
    public lq0 limitedParallelism(int parallelism) {
        n23.a(parallelism);
        return parallelism >= this.parallelism ? this : super.limitedParallelism(parallelism);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002a, code lost:
    
        r1 = r4.workerAllocationLock;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002d, code lost:
    
        r4.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
    
        if (r4.queue.c() != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
    
        r4.runningWorkers++;
        r2 = kotlin.Unit.INSTANCE;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        Object obj;
        while (true) {
            int i = 0;
            while (true) {
                Runnable runnableD = this.queue.d();
                if (runnableD == null) {
                    break;
                }
                try {
                    runnableD.run();
                } catch (Throwable th) {
                    oq0.a(EmptyCoroutineContext.INSTANCE, th);
                }
                i++;
                if (i >= 16 && this.dispatcher.isDispatchNeeded(this)) {
                    this.dispatcher.dispatch(this, this);
                    return;
                }
            }
        }
    }
}
