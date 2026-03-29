package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import com.qq.gdt.action.ActionUtils;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u0005B\u001d\u0012\u0006\u00101\u001a\u00020.\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\bC\u0010DJ\u0017\u0010\b\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\r\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0010¢\u0006\u0004\b\u001d\u0010\u001eJ \u0010!\u001a\u00020\r2\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b!\u0010\"J!\u0010$\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0019\u001a\u00020\u0016H\u0010¢\u0006\u0004\b$\u0010%J\u001f\u0010)\u001a\u00020\r2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00028\u0000H\u0000¢\u0006\u0004\b)\u0010*J\u000f\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b,\u0010-R\u0014\u00101\u001a\u00020.8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u001e\u00107\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0081\u000e¢\u0006\f\n\u0004\b4\u00105\u0012\u0004\b6\u0010\u000fR\u0014\u00108\u001a\u00020\u001c8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u001d\u00105R\u0014\u0010'\u001a\u00020&8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b9\u0010:R\u001c\u0010=\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u001a\u0010B\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006E"}, d2 = {"Lce1;", ExifInterface.GPS_DIRECTION_TRUE, "Lfe1;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/coroutines/Continuation;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "p", "()Z", "", "h", "()V", t.k, "Lbz;", "i", "()Lbz;", "Laz;", "continuation", "", "s", "(Laz;)Ljava/lang/Throwable;", "cause", "q", "(Ljava/lang/Throwable;)Z", "", "g", "()Ljava/lang/Object;", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", "takenState", "a", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "Lkotlin/coroutines/CoroutineContext;", "context", ActionUtils.PAYMENT_AMOUNT, "l", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "Llq0;", "d", "Llq0;", "dispatcher", "e", "Lkotlin/coroutines/Continuation;", "f", "Ljava/lang/Object;", "get_state$kotlinx_coroutines_core$annotations", "_state", "countOrElement", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", t.l, "()Lkotlin/coroutines/Continuation;", "delegate", "o", "reusableCancellableContinuation", "<init>", "(Llq0;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ce1<T> extends fe1<T> implements CoroutineStackFrame, Continuation<T> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(ce1.class, Object.class, "_reusableCancellableContinuation");
    private volatile /* synthetic */ Object _reusableCancellableContinuation;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    @JvmField
    public final lq0 dispatcher;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @JvmField
    public final Continuation<T> continuation;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    @JvmField
    public Object _state;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    @JvmField
    public final Object countOrElement;

    /* JADX WARN: Multi-variable type inference failed */
    public ce1(lq0 lq0Var, Continuation<? super T> continuation) {
        super(-1);
        this.dispatcher = lq0Var;
        this.continuation = continuation;
        this._state = C1402de1.f17028a;
        this.countOrElement = lw5.b(get$context());
        this._reusableCancellableContinuation = null;
    }

    @Override // defpackage.fe1
    public void a(Object takenState, Throwable cause) {
        if (takenState instanceof CompletedWithCancellation) {
            ((CompletedWithCancellation) takenState).onCancellation.invoke(cause);
        }
    }

    @Override // defpackage.fe1
    public Object g() {
        Object obj = this._state;
        this._state = C1402de1.f17028a;
        return obj;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.continuation;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    /* JADX INFO: renamed from: getContext */
    public CoroutineContext get$context() {
        return this.continuation.get$context();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final void h() {
        while (this._reusableCancellableContinuation == C1402de1.b) {
        }
    }

    public final bz<T> i() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = C1402de1.b;
                return null;
            }
            if (obj instanceof bz) {
                if (p1.a(h, this, obj, C1402de1.b)) {
                    return (bz) obj;
                }
            } else if (obj != C1402de1.b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final void l(CoroutineContext context, T value) {
        this._state = value;
        this.resumeMode = 1;
        this.dispatcher.dispatchYield(context, this);
    }

    public final bz<?> o() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof bz) {
            return (bz) obj;
        }
        return null;
    }

    public final boolean p() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean q(Throwable cause) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            yp5 yp5Var = C1402de1.b;
            if (Intrinsics.areEqual(obj, yp5Var)) {
                if (p1.a(h, this, yp5Var, cause)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (p1.a(h, this, obj, null)) {
                    return false;
                }
            }
        }
    }

    public final void r() {
        h();
        bz<?> bzVarO = o();
        if (bzVarO != null) {
            bzVarO.r();
        }
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        CoroutineContext context = this.continuation.get$context();
        Object objD = C1496tj0.d(result, null, 1, null);
        if (this.dispatcher.isDispatchNeeded(context)) {
            this._state = objD;
            this.resumeMode = 0;
            this.dispatcher.dispatch(context, this);
            return;
        }
        in1 in1VarA = sw5.f20863a.a();
        if (in1VarA.m()) {
            this._state = objD;
            this.resumeMode = 0;
            in1VarA.g(this);
            return;
        }
        in1VarA.j(true);
        try {
            CoroutineContext context2 = get$context();
            Object objC = lw5.c(context2, this.countOrElement);
            try {
                this.continuation.resumeWith(result);
                Unit unit = Unit.INSTANCE;
                while (in1VarA.x()) {
                }
            } finally {
                lw5.a(context2, objC);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final Throwable s(az<?> continuation) {
        yp5 yp5Var;
        do {
            Object obj = this._reusableCancellableContinuation;
            yp5Var = C1402de1.b;
            if (obj != yp5Var) {
                if (obj instanceof Throwable) {
                    if (p1.a(h, this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!p1.a(h, this, yp5Var, continuation));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.dispatcher + ", " + pv0.c(this.continuation) + ']';
    }

    @Override // defpackage.fe1
    public Continuation<T> b() {
        return this;
    }
}
