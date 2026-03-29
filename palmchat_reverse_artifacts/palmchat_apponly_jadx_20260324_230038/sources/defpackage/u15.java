package defpackage;

import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001\u001a\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0080\u0010¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "Lkotlin/coroutines/CoroutineContext;", "currentContext", "", "a", "Lcy2;", "collectJob", t.l, "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class u15 {

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "count", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "a", "(ILkotlin/coroutines/CoroutineContext$Element;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function2<Integer, CoroutineContext.Element, Integer> {
        public final /* synthetic */ SafeCollector<?> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SafeCollector<?> safeCollector) {
            super(2);
            this.b = safeCollector;
        }

        public final Integer a(int i, CoroutineContext.Element element) {
            CoroutineContext.Key<?> key = element.getKey();
            CoroutineContext.Element element2 = this.b.collectContext.get(key);
            if (key != cy2.INSTANCE) {
                return Integer.valueOf(element != element2 ? Integer.MIN_VALUE : i + 1);
            }
            cy2 cy2Var = (cy2) element2;
            cy2 cy2VarB = u15.b((cy2) element, cy2Var);
            if (cy2VarB == cy2Var) {
                if (cy2Var != null) {
                    i++;
                }
                return Integer.valueOf(i);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + cy2VarB + ", expected child of " + cy2Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Integer mo5invoke(Integer num, CoroutineContext.Element element) {
            return a(num.intValue(), element);
        }
    }

    @JvmName(name = "checkContext")
    public static final void a(SafeCollector<?> safeCollector, CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.fold(0, new a(safeCollector))).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final cy2 b(cy2 cy2Var, cy2 cy2Var2) {
        while (cy2Var != null) {
            if (cy2Var == cy2Var2) {
                return cy2Var;
            }
            if (!(cy2Var instanceof c35)) {
                return cy2Var;
            }
            cy2Var = ((c35) cy2Var).C0();
        }
        return null;
    }
}
