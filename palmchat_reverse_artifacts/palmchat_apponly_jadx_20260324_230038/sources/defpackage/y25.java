package defpackage;

import com.huawei.hms.ads.ContentClassification;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.scheduling.CoroutineScheduler;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0010\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b \u0010!J\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016J\u001c\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005H\u0016J+\u0010\r\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0010\u001a\u00020\u000fH\u0002R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u001e¨\u0006\""}, d2 = {"Ly25;", "Lio1;", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "dispatch", "dispatchYield", "Ljt5;", "", "tailDispatch", "f", "(Ljava/lang/Runnable;Ljt5;Z)V", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "d", "", t.l, "I", "corePoolSize", "c", "maxPoolSize", "", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "idleWorkerKeepAliveNs", "", "e", "Ljava/lang/String;", "schedulerName", "Lkotlinx/coroutines/scheduling/CoroutineScheduler;", "coroutineScheduler", "<init>", "(IIJLjava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class y25 extends io1 {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final int corePoolSize;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final int maxPoolSize;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final long idleWorkerKeepAliveNs;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final String schedulerName;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public CoroutineScheduler coroutineScheduler = d();

    public y25(int i, int i2, long j, String str) {
        this.corePoolSize = i;
        this.maxPoolSize = i2;
        this.idleWorkerKeepAliveNs = j;
        this.schedulerName = str;
    }

    public final CoroutineScheduler d() {
        return new CoroutineScheduler(this.corePoolSize, this.maxPoolSize, this.idleWorkerKeepAliveNs, this.schedulerName);
    }

    @Override // defpackage.lq0
    public void dispatch(CoroutineContext context, Runnable block) {
        CoroutineScheduler.g(this.coroutineScheduler, block, null, false, 6, null);
    }

    @Override // defpackage.lq0
    public void dispatchYield(CoroutineContext context, Runnable block) {
        CoroutineScheduler.g(this.coroutineScheduler, block, null, true, 2, null);
    }

    public final void f(Runnable block, jt5 context, boolean tailDispatch) {
        this.coroutineScheduler.f(block, context, tailDispatch);
    }
}
