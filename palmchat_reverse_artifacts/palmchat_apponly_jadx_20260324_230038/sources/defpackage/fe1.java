package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.location.LocationConst;
import com.kuaishou.weapon.p0.t;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutinesInternalError;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0004H ¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\bH\u0010¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000e\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0010¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0010¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\nJ\u001a\u0010\u0015\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\bR\u0016\u0010\u0018\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00198 X \u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lfe1;", ExifInterface.GPS_DIRECTION_TRUE, "Let5;", "Lkotlinx/coroutines/SchedulerTask;", "", "g", "()Ljava/lang/Object;", "takenState", "", "cause", "", "a", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", LocationConst.HDYawConst.KEY_HD_YAW_STATE, "e", "(Ljava/lang/Object;)Ljava/lang/Object;", "c", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "run", "exception", "finallyException", "f", "", "I", "resumeMode", "Lkotlin/coroutines/Continuation;", t.l, "()Lkotlin/coroutines/Continuation;", "delegate", "<init>", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class fe1<T> extends et5 {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    @JvmField
    public int resumeMode;

    public fe1(int i) {
        this.resumeMode = i;
    }

    public abstract Continuation<T> b();

    public Throwable c(Object state) {
        qj0 qj0Var = state instanceof qj0 ? (qj0) state : null;
        if (qj0Var != null) {
            return qj0Var.cause;
        }
        return null;
    }

    public final void f(Throwable exception, Throwable finallyException) {
        if (exception == null && finallyException == null) {
            return;
        }
        if (exception != null && finallyException != null) {
            ExceptionsKt__ExceptionsKt.addSuppressed(exception, finallyException);
        }
        if (exception == null) {
            exception = finallyException;
        }
        Intrinsics.checkNotNull(exception);
        oq0.a(b().get$context(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", exception));
    }

    public abstract Object g();

    /* JADX WARN: Removed duplicated region for block: B:25:0x0083 A[Catch: all -> 0x00b0, DONT_GENERATE, TRY_LEAVE, TryCatch #1 {all -> 0x00b0, blocks: (B:3:0x0002, B:5:0x0019, B:23:0x007d, B:25:0x0083, B:33:0x00a6, B:36:0x00af, B:35:0x00ac, B:8:0x001f, B:10:0x002d, B:12:0x0035, B:15:0x0041, B:17:0x0047, B:21:0x0079, B:19:0x005e, B:20:0x006c), top: B:46:0x0002, inners: #2 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Object objM840constructorimpl;
        Object objM840constructorimpl2;
        jt5 jt5Var = this.taskContext;
        try {
            ce1 ce1Var = (ce1) b();
            Continuation<T> continuation = ce1Var.continuation;
            Object obj = ce1Var.countOrElement;
            CoroutineContext context = continuation.get$context();
            Object objC = lw5.c(context, obj);
            i46<?> i46VarG = objC != lw5.f19091a ? kq0.g(continuation, context, objC) : null;
            try {
                CoroutineContext context2 = continuation.get$context();
                Object objG = g();
                Throwable thC = c(objG);
                cy2 cy2Var = (thC == null && C1405ge1.b(this.resumeMode)) ? (cy2) context2.get(cy2.INSTANCE) : null;
                if (cy2Var != null && !cy2Var.isActive()) {
                    CancellationException cancellationExceptionS = cy2Var.s();
                    a(objG, cancellationExceptionS);
                    Result.Companion companion = Result.INSTANCE;
                    continuation.resumeWith(Result.m840constructorimpl(ResultKt.createFailure(cancellationExceptionS)));
                } else if (thC != null) {
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation.resumeWith(Result.m840constructorimpl(ResultKt.createFailure(thC)));
                } else {
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation.resumeWith(Result.m840constructorimpl(e(objG)));
                }
                Unit unit = Unit.INSTANCE;
                try {
                    jt5Var.a();
                    objM840constructorimpl2 = Result.m840constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM840constructorimpl2 = Result.m840constructorimpl(ResultKt.createFailure(th));
                }
                f(null, Result.m843exceptionOrNullimpl(objM840constructorimpl2));
            } finally {
                if (i46VarG == null || i46VarG.D0()) {
                    lw5.a(context, objC);
                }
            }
        } catch (Throwable th2) {
            try {
                Result.Companion companion5 = Result.INSTANCE;
                jt5Var.a();
                objM840constructorimpl = Result.m840constructorimpl(Unit.INSTANCE);
            } catch (Throwable th3) {
                Result.Companion companion6 = Result.INSTANCE;
                objM840constructorimpl = Result.m840constructorimpl(ResultKt.createFailure(th3));
            }
            f(th2, Result.m843exceptionOrNullimpl(objM840constructorimpl));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T e(Object state) {
        return state;
    }

    public void a(Object takenState, Throwable cause) {
    }
}
