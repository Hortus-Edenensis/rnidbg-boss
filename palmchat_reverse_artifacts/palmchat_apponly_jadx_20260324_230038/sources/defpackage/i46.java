package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.location.LocationConst;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\n\u001a\u00020\tJ\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0014R*\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000e0\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Li46;", ExifInterface.GPS_DIRECTION_TRUE, "Lc35;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "oldValue", "", "E0", "", "D0", LocationConst.HDYawConst.KEY_HD_YAW_STATE, "y0", "Ljava/lang/ThreadLocal;", "Lkotlin/Pair;", "d", "Ljava/lang/ThreadLocal;", "threadStateToRecover", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class i46<T> extends c35<T> {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public ThreadLocal<Pair<CoroutineContext, Object>> threadStateToRecover;

    /* JADX WARN: Illegal instructions before constructor call */
    public i46(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        k46 k46Var = k46.f18572a;
        super(coroutineContext.get(k46Var) == null ? coroutineContext.plus(k46Var) : coroutineContext, continuation);
        this.threadStateToRecover = new ThreadLocal<>();
        if (continuation.getContext().get(ContinuationInterceptor.INSTANCE) instanceof lq0) {
            return;
        }
        Object objC = lw5.c(coroutineContext, null);
        lw5.a(coroutineContext, objC);
        E0(coroutineContext, objC);
    }

    public final boolean D0() {
        if (this.threadStateToRecover.get() == null) {
            return false;
        }
        this.threadStateToRecover.set(null);
        return true;
    }

    public final void E0(CoroutineContext context, Object oldValue) {
        this.threadStateToRecover.set(TuplesKt.to(context, oldValue));
    }

    @Override // defpackage.c35, defpackage.a1
    public void y0(Object state) {
        Pair<CoroutineContext, Object> pair = this.threadStateToRecover.get();
        if (pair != null) {
            lw5.a(pair.component1(), pair.component2());
            this.threadStateToRecover.set(null);
        }
        Object objA = C1496tj0.a(state, this.uCont);
        Continuation<T> continuation = this.uCont;
        CoroutineContext coroutineContext = continuation.getContext();
        Object objC = lw5.c(coroutineContext, null);
        i46<?> i46VarG = objC != lw5.f19091a ? kq0.g(continuation, coroutineContext, objC) : null;
        try {
            this.uCont.resumeWith(objA);
            Unit unit = Unit.INSTANCE;
        } finally {
            if (i46VarG == null || i46VarG.D0()) {
                lw5.a(coroutineContext, objC);
            }
        }
    }
}
