package defpackage;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.kuaishou.weapon.p0.t;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bJ\f\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H'J\b\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH'JE\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052'\u0010\u0015\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0010j\u0002`\u0014H'R\u0014\u0010\u0018\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcy2;", "Lkotlin/coroutines/CoroutineContext$Element;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "s", "", "start", "cause", "", "a", "Ls50;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "Lq50;", "t", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lne1;", "l", "isActive", "()Z", "d0", t.l, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public interface cy2 extends CoroutineContext.Element {

    /* JADX INFO: renamed from: d0, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.f16948a;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        public static /* synthetic */ void a(cy2 cy2Var, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            cy2Var.a(cancellationException);
        }

        public static <R> R b(cy2 cy2Var, R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.DefaultImpls.fold(cy2Var, r, function2);
        }

        public static <E extends CoroutineContext.Element> E c(cy2 cy2Var, CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.DefaultImpls.get(cy2Var, key);
        }

        public static /* synthetic */ ne1 d(cy2 cy2Var, boolean z, boolean z2, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            return cy2Var.l(z, z2, function1);
        }

        public static CoroutineContext e(cy2 cy2Var, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.minusKey(cy2Var, key);
        }

        public static CoroutineContext f(cy2 cy2Var, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.plus(cy2Var, coroutineContext);
        }
    }

    /* JADX INFO: renamed from: cy2$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcy2$b;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lcy2;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class Companion implements CoroutineContext.Key<cy2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f16948a = new Companion();
    }

    void a(CancellationException cause);

    boolean isActive();

    ne1 l(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler);

    CancellationException s();

    boolean start();

    q50 t(s50 child);
}
