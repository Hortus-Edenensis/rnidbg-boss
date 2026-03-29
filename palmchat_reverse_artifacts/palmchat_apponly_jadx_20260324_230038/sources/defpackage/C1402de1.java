package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: de1, reason: from Kotlin metadata and case insensitive filesystem */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001aW\u0010\u000b\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u0012\u0010\u000f\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020\t0\rH\u0000\"\u001a\u0010\u0015\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u0014\"\u001a\u0010\u0017\u001a\u00020\u00108\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0012\u0012\u0004\b\u0016\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "result", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "onCancellation", t.l, "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Lce1;", "", "d", "Lyp5;", "a", "Lyp5;", "getUNDEFINED$annotations", "()V", "UNDEFINED", "getREUSABLE_CLAIMED$annotations", "REUSABLE_CLAIMED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class C1402de1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yp5 f17028a = new yp5("UNDEFINED");

    @JvmField
    public static final yp5 b = new yp5("REUSABLE_CLAIMED");

    /* JADX WARN: Finally extract failed */
    public static final <T> void b(Continuation<? super T> continuation, Object obj, Function1<? super Throwable, Unit> function1) {
        boolean z;
        if (!(continuation instanceof ce1)) {
            continuation.resumeWith(obj);
            return;
        }
        ce1 ce1Var = (ce1) continuation;
        Object objC = C1496tj0.c(obj, function1);
        if (ce1Var.dispatcher.isDispatchNeeded(ce1Var.getContext())) {
            ce1Var._state = objC;
            ce1Var.resumeMode = 1;
            ce1Var.dispatcher.dispatch(ce1Var.getContext(), ce1Var);
            return;
        }
        in1 in1VarA = sw5.f20863a.a();
        if (in1VarA.m()) {
            ce1Var._state = objC;
            ce1Var.resumeMode = 1;
            in1VarA.g(ce1Var);
            return;
        }
        in1VarA.j(true);
        try {
            cy2 cy2Var = (cy2) ce1Var.getContext().get(cy2.INSTANCE);
            if (cy2Var == null || cy2Var.isActive()) {
                z = false;
            } else {
                CancellationException cancellationExceptionS = cy2Var.s();
                ce1Var.a(objC, cancellationExceptionS);
                Result.Companion companion = Result.INSTANCE;
                ce1Var.resumeWith(Result.m840constructorimpl(ResultKt.createFailure(cancellationExceptionS)));
                z = true;
            }
            if (!z) {
                Continuation<T> continuation2 = ce1Var.continuation;
                Object obj2 = ce1Var.countOrElement;
                CoroutineContext context = continuation2.getContext();
                Object objC2 = lw5.c(context, obj2);
                i46<?> i46VarG = objC2 != lw5.f19091a ? kq0.g(continuation2, context, objC2) : null;
                try {
                    ce1Var.continuation.resumeWith(obj);
                    Unit unit = Unit.INSTANCE;
                    if (i46VarG == null || i46VarG.D0()) {
                        lw5.a(context, objC2);
                    }
                } catch (Throwable th) {
                    if (i46VarG == null || i46VarG.D0()) {
                        lw5.a(context, objC2);
                    }
                    throw th;
                }
            }
            while (in1VarA.x()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void c(Continuation continuation, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        b(continuation, obj, function1);
    }

    public static final boolean d(ce1<? super Unit> ce1Var) {
        Unit unit = Unit.INSTANCE;
        in1 in1VarA = sw5.f20863a.a();
        if (in1VarA.q()) {
            return false;
        }
        if (in1VarA.m()) {
            ce1Var._state = unit;
            ce1Var.resumeMode = 1;
            in1VarA.g(ce1Var);
            return true;
        }
        in1VarA.j(true);
        try {
            ce1Var.run();
            do {
            } while (in1VarA.x());
        } finally {
            try {
            } finally {
            }
        }
        return false;
    }
}
