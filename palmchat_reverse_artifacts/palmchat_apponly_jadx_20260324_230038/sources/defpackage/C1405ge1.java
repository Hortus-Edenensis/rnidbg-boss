package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: renamed from: ge1, reason: from Kotlin metadata and case insensitive filesystem */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u001a \u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000\u001a.\u0010\n\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0010\u0010\u000b\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u0001H\u0002\"\u0018\u0010\u000e\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u0018\u0010\u0010\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\r¨\u0006\u0011"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lfe1;", "", "mode", "", "a", "Lkotlin/coroutines/Continuation;", "delegate", "", "undispatched", "d", "e", t.l, "(I)Z", "isCancellableMode", "c", "isReusableMode", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class C1405ge1 {
    public static final <T> void a(fe1<? super T> fe1Var, int i) {
        Continuation<? super T> continuationB = fe1Var.b();
        boolean z = i == 4;
        if (z || !(continuationB instanceof ce1) || b(i) != b(fe1Var.resumeMode)) {
            d(fe1Var, continuationB, z);
            return;
        }
        lq0 lq0Var = ((ce1) continuationB).dispatcher;
        CoroutineContext coroutineContext = continuationB.get$context();
        if (lq0Var.isDispatchNeeded(coroutineContext)) {
            lq0Var.dispatch(coroutineContext, fe1Var);
        } else {
            e(fe1Var);
        }
    }

    public static final boolean b(int i) {
        return i == 1 || i == 2;
    }

    public static final boolean c(int i) {
        return i == 2;
    }

    public static final <T> void d(fe1<? super T> fe1Var, Continuation<? super T> continuation, boolean z) {
        Object objE;
        Object objG = fe1Var.g();
        Throwable thC = fe1Var.c(objG);
        if (thC != null) {
            Result.Companion companion = Result.INSTANCE;
            objE = ResultKt.createFailure(thC);
        } else {
            Result.Companion companion2 = Result.INSTANCE;
            objE = fe1Var.e(objG);
        }
        Object objM840constructorimpl = Result.m840constructorimpl(objE);
        if (!z) {
            continuation.resumeWith(objM840constructorimpl);
            return;
        }
        ce1 ce1Var = (ce1) continuation;
        Continuation<T> continuation2 = ce1Var.continuation;
        Object obj = ce1Var.countOrElement;
        CoroutineContext coroutineContext = continuation2.get$context();
        Object objC = lw5.c(coroutineContext, obj);
        i46<?> i46VarG = objC != lw5.f19091a ? kq0.g(continuation2, coroutineContext, objC) : null;
        try {
            ce1Var.continuation.resumeWith(objM840constructorimpl);
            Unit unit = Unit.INSTANCE;
        } finally {
            if (i46VarG == null || i46VarG.D0()) {
                lw5.a(coroutineContext, objC);
            }
        }
    }

    public static final void e(fe1<?> fe1Var) {
        in1 in1VarA = sw5.f20863a.a();
        if (in1VarA.m()) {
            in1VarA.g(fe1Var);
            return;
        }
        in1VarA.j(true);
        try {
            d(fe1Var, fe1Var.b(), true);
            do {
            } while (in1VarA.x());
        } finally {
            try {
            } finally {
            }
        }
    }
}
