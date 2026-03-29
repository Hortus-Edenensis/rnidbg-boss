package defpackage;

import kotlin.Metadata;
import kotlin.jvm.JvmField;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B#\u0012\n\u0010\n\u001a\u00060\u0006j\u0002`\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0018\u0010\n\u001a\u00060\u0006j\u0002`\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lot5;", "Let5;", "", "run", "", "toString", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "c", "Ljava/lang/Runnable;", "block", "", "submissionTime", "Ljt5;", "taskContext", "<init>", "(Ljava/lang/Runnable;JLjt5;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ot5 extends et5 {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @JvmField
    public final Runnable block;

    public ot5(Runnable runnable, long j, jt5 jt5Var) {
        super(j, jt5Var);
        this.block = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.block.run();
        } finally {
            this.taskContext.a();
        }
    }

    public String toString() {
        return "Task[" + pv0.a(this.block) + '@' + pv0.b(this.block) + ", " + this.submissionTime + ", " + this.taskContext + ']';
    }
}
