package defpackage;

import com.baidu.location.LocationConst;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0000\u001a\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0000\"\u0014\u0010\u000b\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\b\u0010\n\"*\u0010\u000f\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000e\"2\u0010\u0011\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0010\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00100\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000e\"&\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u000e¨\u0006\u0015"}, d2 = {"Lkotlin/coroutines/CoroutineContext;", "context", "", t.l, "countOrElement", "c", "oldState", "", "a", "Lyp5;", "Lyp5;", "NO_THREAD_ELEMENTS", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/jvm/functions/Function2;", "countAll", "Lkw5;", "findOne", "Lax5;", "d", "updateState", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class lw5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public static final yp5 f19091a = new yp5("NO_THREAD_ELEMENTS");
    public static final Function2<Object, CoroutineContext.Element, Object> b = a.b;
    public static final Function2<kw5<?>, CoroutineContext.Element, kw5<?>> c = b.b;
    public static final Function2<ax5, CoroutineContext.Element, ax5> d = c.b;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "countOrElement", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "a", "(Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext$Element;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0})
    public static final class a extends Lambda implements Function2<Object, CoroutineContext.Element, Object> {
        public static final a b = new a();

        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object mo5invoke(Object obj, CoroutineContext.Element element) {
            if (!(element instanceof kw5)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? element : Integer.valueOf(iIntValue + 1);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00002\f\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkw5;", "found", "Lkotlin/coroutines/CoroutineContext$Element;", "element", "a", "(Lkw5;Lkotlin/coroutines/CoroutineContext$Element;)Lkw5;"}, k = 3, mv = {1, 6, 0})
    public static final class b extends Lambda implements Function2<kw5<?>, CoroutineContext.Element, kw5<?>> {
        public static final b b = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final kw5<?> mo5invoke(kw5<?> kw5Var, CoroutineContext.Element element) {
            if (kw5Var != null) {
                return kw5Var;
            }
            if (element instanceof kw5) {
                return (kw5) element;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lax5;", LocationConst.HDYawConst.KEY_HD_YAW_STATE, "Lkotlin/coroutines/CoroutineContext$Element;", "element", "a", "(Lax5;Lkotlin/coroutines/CoroutineContext$Element;)Lax5;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function2<ax5, CoroutineContext.Element, ax5> {
        public static final c b = new c();

        public c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ax5 mo5invoke(ax5 ax5Var, CoroutineContext.Element element) {
            if (element instanceof kw5) {
                kw5<?> kw5Var = (kw5) element;
                ax5Var.a(kw5Var, kw5Var.r(ax5Var.context));
            }
            return ax5Var;
        }
    }

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj == f19091a) {
            return;
        }
        if (obj instanceof ax5) {
            ((ax5) obj).b(coroutineContext);
            return;
        }
        Object objFold = coroutineContext.fold(null, c);
        if (objFold == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        ((kw5) objFold).c(coroutineContext, obj);
    }

    public static final Object b(CoroutineContext coroutineContext) {
        Object objFold = coroutineContext.fold(0, b);
        Intrinsics.checkNotNull(objFold);
        return objFold;
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        return obj == 0 ? f19091a : obj instanceof Integer ? coroutineContext.fold(new ax5(coroutineContext, ((Number) obj).intValue()), d) : ((kw5) obj).r(coroutineContext);
    }
}
