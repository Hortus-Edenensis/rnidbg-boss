package defpackage;

import com.amap.api.col.p0002sl.hb;
import com.huawei.hms.ads.ContentClassification;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b#\u0010$J\u0006\u0010\u0003\u001a\u00020\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004J\u0010\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0002H\u0002R\u0016\u0010\u0013\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u000f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010 \u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\"\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b!\u0010\u001f¨\u0006%"}, d2 = {"Lin1;", "Llq0;", "", "x", "Lfe1;", "task", "", "g", "unconfined", hb.j, "d", "", "parallelism", "limitedParallelism", "shutdown", "", "f", "a", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "useCount", t.l, "Z", "shared", "Lrh;", "c", "Lrh;", "unconfinedQueue", "i", "()J", "nextTime", "m", "()Z", "isUnconfinedLoopActive", "q", "isUnconfinedQueueEmpty", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class in1 extends lq0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public long useCount;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public boolean shared;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public rh<fe1<?>> unconfinedQueue;

    public static /* synthetic */ void k(in1 in1Var, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        in1Var.j(z);
    }

    public final void d(boolean unconfined) {
        long jF = this.useCount - f(unconfined);
        this.useCount = jF;
        if (jF <= 0 && this.shared) {
            shutdown();
        }
    }

    public final long f(boolean unconfined) {
        return unconfined ? 4294967296L : 1L;
    }

    public final void g(fe1<?> task) {
        rh<fe1<?>> rhVar = this.unconfinedQueue;
        if (rhVar == null) {
            rhVar = new rh<>();
            this.unconfinedQueue = rhVar;
        }
        rhVar.a(task);
    }

    public long i() {
        rh<fe1<?>> rhVar = this.unconfinedQueue;
        return (rhVar == null || rhVar.c()) ? Long.MAX_VALUE : 0L;
    }

    public final void j(boolean unconfined) {
        this.useCount += f(unconfined);
        if (unconfined) {
            return;
        }
        this.shared = true;
    }

    @Override // defpackage.lq0
    public final lq0 limitedParallelism(int parallelism) {
        n23.a(parallelism);
        return this;
    }

    public final boolean m() {
        return this.useCount >= f(true);
    }

    public final boolean q() {
        rh<fe1<?>> rhVar = this.unconfinedQueue;
        if (rhVar != null) {
            return rhVar.c();
        }
        return true;
    }

    public final boolean x() {
        fe1<?> fe1VarD;
        rh<fe1<?>> rhVar = this.unconfinedQueue;
        if (rhVar == null || (fe1VarD = rhVar.d()) == null) {
            return false;
        }
        fe1VarD.run();
        return true;
    }

    public void shutdown() {
    }
}
