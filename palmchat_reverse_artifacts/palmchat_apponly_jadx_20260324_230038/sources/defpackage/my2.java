package defpackage;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002\u001a\n\u0010\u0007\u001a\u00020\u0004*\u00020\u0006\u001a\n\u0010\b\u001a\u00020\u0004*\u00020\u0000¨\u0006\t"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "", "a", "Lcy2;", "c", "d", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/JobKt")
public final /* synthetic */ class my2 {
    public static final void a(CoroutineContext coroutineContext, CancellationException cancellationException) {
        cy2 cy2Var = (cy2) coroutineContext.get(cy2.INSTANCE);
        if (cy2Var != null) {
            cy2Var.a(cancellationException);
        }
    }

    public static /* synthetic */ void b(CoroutineContext coroutineContext, CancellationException cancellationException, int i, Object obj) {
        if ((i & 1) != 0) {
            cancellationException = null;
        }
        ly2.a(coroutineContext, cancellationException);
    }

    public static final void c(cy2 cy2Var) {
        if (!cy2Var.isActive()) {
            throw cy2Var.s();
        }
    }

    public static final void d(CoroutineContext coroutineContext) {
        cy2 cy2Var = (cy2) coroutineContext.get(cy2.INSTANCE);
        if (cy2Var != null) {
            ly2.c(cy2Var);
        }
    }
}
