package defpackage;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"ty1", "uy1", "xy1", "dz1", "qz1", "h02"}, d2 = {}, k = 4, mv = {1, 6, 0})
public final class iy1 {
    public static final <T> mk5<T> a(ft3<T> ft3Var) {
        return C1491qz1.a(ft3Var);
    }

    public static final <T> dy1<T> b(@BuilderInference Function2<? super mn4<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return C1497ty1.a(function2);
    }

    public static final <T> Object c(fy1<? super T> fy1Var, dy1<? extends T> dy1Var, Continuation<? super Unit> continuation) {
        return C1504xy1.a(fy1Var, dy1Var, continuation);
    }

    public static final <T> Object d(fy1<? super T> fy1Var, ut4<? extends T> ut4Var, Continuation<? super Unit> continuation) {
        return C1500uy1.b(fy1Var, ut4Var, continuation);
    }

    public static final void e(fy1<?> fy1Var) throws Throwable {
        dz1.a(fy1Var);
    }
}
