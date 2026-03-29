package defpackage;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"cv"}, d2 = {}, k = 4, mv = {1, 6, 0})
public final class bv {
    public static final cy2 a(rq0 rq0Var, CoroutineContext coroutineContext, CoroutineStart coroutineStart, Function2<? super rq0, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return cv.a(rq0Var, coroutineContext, coroutineStart, function2);
    }

    public static final <T> Object c(CoroutineContext coroutineContext, Function2<? super rq0, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return cv.c(coroutineContext, function2, continuation);
    }
}
