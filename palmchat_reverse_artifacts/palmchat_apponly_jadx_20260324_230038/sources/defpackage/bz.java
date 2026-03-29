package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.p0002sl.hb;
import com.baidu.location.LocationConst;
import com.kuaishou.weapon.p0.t;
import com.qq.gdt.action.ActionUtils;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import defpackage.cy2;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletionHandlerException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0011\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005B\u001d\u0012\f\u0010i\u001a\b\u0012\u0004\u0012\u00028\u00000e\u0012\u0006\u0010)\u001a\u00020#¢\u0006\u0004\bz\u0010{J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJB\u0010\u0013\u001a\u00020\u00102'\u0010\u0012\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\rj\u0002`\u00112\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\bJ\u0011\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJB\u0010\u001e\u001a\u00020\u00102'\u0010\u0012\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\rj\u0002`\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ8\u0010!\u001a\u00020 2'\u0010\u0012\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\rj\u0002`\u0011H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00102\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b%\u0010&JZ\u0010,\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001c2\u0006\u0010)\u001a\u00020#2#\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\r2\b\u0010+\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b,\u0010-JH\u0010.\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010\u001c2\u0006\u0010)\u001a\u00020#2%\b\u0002\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH\u0002¢\u0006\u0004\b.\u0010/JJ\u00101\u001a\u0004\u0018\u0001002\b\u0010(\u001a\u0004\u0018\u00010\u001c2\b\u0010+\u001a\u0004\u0018\u00010\u001c2#\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH\u0002¢\u0006\u0004\b1\u00102J\u0019\u00104\u001a\u0002032\b\u0010(\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0010H\u0002¢\u0006\u0004\b6\u0010\u001bJ\u000f\u00107\u001a\u00020\u0010H\u0016¢\u0006\u0004\b7\u0010\u001bJ\u000f\u00108\u001a\u00020\u0006H\u0001¢\u0006\u0004\b8\u0010\bJ\u0017\u0010;\u001a\n\u0018\u000109j\u0004\u0018\u0001`:H\u0016¢\u0006\u0004\b;\u0010<J\u0011\u0010=\u001a\u0004\u0018\u00010\u001cH\u0010¢\u0006\u0004\b=\u0010>J!\u0010@\u001a\u00020\u00102\b\u0010?\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\n\u001a\u00020\tH\u0010¢\u0006\u0004\b@\u0010AJ\u0019\u0010B\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\bB\u0010\fJ\u0017\u0010C\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0004\bC\u0010DJ\u001f\u0010E\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020 2\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bE\u0010FJ8\u0010G\u001a\u00020\u00102!\u0010*\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\r2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\bG\u0010\u0014J\u0017\u0010J\u001a\u00020\t2\u0006\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bJ\u0010KJ\u0011\u0010L\u001a\u0004\u0018\u00010\u001cH\u0001¢\u0006\u0004\bL\u0010>J \u0010O\u001a\u00020\u00102\f\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000MH\u0016ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ<\u0010R\u001a\u00020\u00102\u0006\u0010Q\u001a\u00028\u00002#\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH\u0016¢\u0006\u0004\bR\u0010SJ8\u0010T\u001a\u00020\u00102'\u0010\u0012\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00100\rj\u0002`\u0011H\u0016¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\u0010H\u0000¢\u0006\u0004\bV\u0010\u001bJ#\u0010W\u001a\u0004\u0018\u00010\u001c2\u0006\u0010Q\u001a\u00028\u00002\b\u0010+\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\bW\u0010XJH\u0010Y\u001a\u0004\u0018\u00010\u001c2\u0006\u0010Q\u001a\u00028\u00002\b\u0010+\u001a\u0004\u0018\u00010\u001c2#\u0010*\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\rH\u0016¢\u0006\u0004\bY\u0010ZJ\u0017\u0010\\\u001a\u00020\u00102\u0006\u0010[\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\\\u0010PJ\u001f\u0010]\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0010¢\u0006\u0004\b]\u0010^J\u001b\u0010_\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0010¢\u0006\u0004\b_\u0010`J\u000f\u0010b\u001a\u00020aH\u0016¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020aH\u0014¢\u0006\u0004\bd\u0010cR \u0010i\u001a\b\u0012\u0004\u0012\u00028\u00000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bR\u0010f\u001a\u0004\bg\u0010hR\u001a\u0010n\u001a\u00020j8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b]\u0010k\u001a\u0004\bl\u0010mR\u0018\u0010q\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010pR\u0014\u0010s\u001a\u00020a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\br\u0010cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bt\u0010>R\u0014\u0010v\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bu\u0010\bR\u001c\u0010y\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bw\u0010x\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006|"}, d2 = {"Lbz;", ExifInterface.GPS_DIRECTION_TRUE, "Lfe1;", "Laz;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "", WkAdxAdConfigMg.DSP_NAME_BAIDU, "()Z", "", "cause", "q", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "l", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)V", "N", "L", "Lne1;", "z", "()Lne1;", WkAdxAdConfigMg.DSP_NAME_GDT, "()V", "", LocationConst.HDYawConst.KEY_HD_YAW_STATE, "D", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "Lwy;", WkAdxAdConfigMg.DSP_NAME_CSJ, "(Lkotlin/jvm/functions/Function1;)Lwy;", "", "mode", "t", "(I)V", "Lxy3;", "proposedUpdate", "resumeMode", "onCancellation", "idempotent", "K", "(Lxy3;Ljava/lang/Object;ILkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/lang/Object;", "I", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)V", "Lyp5;", "M", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lyp5;", "", "h", "(Ljava/lang/Object;)Ljava/lang/Void;", "s", "y", "H", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "g", "()Ljava/lang/Object;", "takenState", "a", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "p", "F", "(Ljava/lang/Throwable;)V", "i", "(Lwy;Ljava/lang/Throwable;)V", "o", "Lcy2;", "parent", "u", "(Lcy2;)Ljava/lang/Throwable;", "v", "Lkotlin/Result;", "result", "resumeWith", "(Ljava/lang/Object;)V", ActionUtils.PAYMENT_AMOUNT, "d", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "m", "(Lkotlin/jvm/functions/Function1;)V", t.k, t.f7496a, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "n", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "token", hb.j, "e", "(Ljava/lang/Object;)Ljava/lang/Object;", "c", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "", "toString", "()Ljava/lang/String;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/Continuation;", t.l, "()Lkotlin/coroutines/Continuation;", "delegate", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "f", "Lne1;", "parentHandle", "x", "stateDebugRepresentation", RXScreenCaptureService.KEY_WIDTH, "A", "isCompleted", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "<init>", "(Lkotlin/coroutines/Continuation;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
@PublishedApi
public class bz<T> extends fe1<T> implements az<T>, CoroutineStackFrame {
    public static final /* synthetic */ AtomicIntegerFieldUpdater g = AtomicIntegerFieldUpdater.newUpdater(bz.class, "_decision");
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(bz.class, Object.class, "_state");
    private volatile /* synthetic */ int _decision;
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Continuation<T> delegate;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final CoroutineContext context;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public ne1 parentHandle;

    /* JADX WARN: Multi-variable type inference failed */
    public bz(Continuation<? super T> continuation, int i) {
        super(i);
        this.delegate = continuation;
        this.context = continuation.get$context();
        this._decision = 0;
        this._state = k5.f18573a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void J(bz bzVar, Object obj, int i, Function1 function1, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        bzVar.I(obj, i, function1);
    }

    public boolean A() {
        return !(get_state() instanceof xy3);
    }

    public final boolean B() {
        return C1405ge1.c(this.resumeMode) && ((ce1) this.delegate).p();
    }

    public final wy C(Function1<? super Throwable, Unit> handler) {
        return handler instanceof wy ? (wy) handler : new ru2(handler);
    }

    public final void D(Function1<? super Throwable, Unit> handler, Object state) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + handler + ", already has " + state).toString());
    }

    public String E() {
        return "CancellableContinuation";
    }

    public final void F(Throwable cause) {
        if (q(cause)) {
            return;
        }
        p(cause);
        s();
    }

    public final void G() {
        Throwable thS;
        Continuation<T> continuation = this.delegate;
        ce1 ce1Var = continuation instanceof ce1 ? (ce1) continuation : null;
        if (ce1Var == null || (thS = ce1Var.s(this)) == null) {
            return;
        }
        r();
        p(thS);
    }

    @JvmName(name = "resetStateReusable")
    public final boolean H() {
        Object obj = this._state;
        if ((obj instanceof CompletedContinuation) && ((CompletedContinuation) obj).idempotentResume != null) {
            r();
            return false;
        }
        this._decision = 0;
        this._state = k5.f18573a;
        return true;
    }

    public final void I(Object proposedUpdate, int resumeMode, Function1<? super Throwable, Unit> onCancellation) {
        Object obj;
        do {
            obj = this._state;
            if (!(obj instanceof xy3)) {
                if (obj instanceof gz) {
                    gz gzVar = (gz) obj;
                    if (gzVar.c()) {
                        if (onCancellation != null) {
                            o(onCancellation, gzVar.cause);
                            return;
                        }
                        return;
                    }
                }
                h(proposedUpdate);
                throw new KotlinNothingValueException();
            }
        } while (!p1.a(h, this, obj, K((xy3) obj, proposedUpdate, resumeMode, onCancellation, null)));
        s();
        t(resumeMode);
    }

    public final Object K(xy3 state, Object proposedUpdate, int resumeMode, Function1<? super Throwable, Unit> onCancellation, Object idempotent) {
        if (proposedUpdate instanceof qj0) {
            return proposedUpdate;
        }
        if (!C1405ge1.b(resumeMode) && idempotent == null) {
            return proposedUpdate;
        }
        if (onCancellation != null || (((state instanceof wy) && !(state instanceof ps)) || idempotent != null)) {
            return new CompletedContinuation(proposedUpdate, state instanceof wy ? (wy) state : null, onCancellation, idempotent, null, 16, null);
        }
        return proposedUpdate;
    }

    public final boolean L() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!g.compareAndSet(this, 0, 2));
        return true;
    }

    public final yp5 M(Object proposedUpdate, Object idempotent, Function1<? super Throwable, Unit> onCancellation) {
        Object obj;
        do {
            obj = this._state;
            if (!(obj instanceof xy3)) {
                if ((obj instanceof CompletedContinuation) && idempotent != null && ((CompletedContinuation) obj).idempotentResume == idempotent) {
                    return cz.f16950a;
                }
                return null;
            }
        } while (!p1.a(h, this, obj, K((xy3) obj, proposedUpdate, this.resumeMode, onCancellation, idempotent)));
        s();
        return cz.f16950a;
    }

    public final boolean N() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!g.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // defpackage.fe1
    public void a(Object takenState, Throwable cause) {
        while (true) {
            Object obj = this._state;
            if (obj instanceof xy3) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj instanceof qj0) {
                return;
            }
            if (obj instanceof CompletedContinuation) {
                CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                if (!(!completedContinuation.c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (p1.a(h, this, obj, CompletedContinuation.b(completedContinuation, null, null, null, null, cause, 15, null))) {
                    completedContinuation.d(this, cause);
                    return;
                }
            } else if (p1.a(h, this, obj, new CompletedContinuation(obj, null, null, null, cause, 14, null))) {
                return;
            }
        }
    }

    @Override // defpackage.fe1
    public final Continuation<T> b() {
        return this.delegate;
    }

    @Override // defpackage.fe1
    public Throwable c(Object state) {
        Throwable thC = super.c(state);
        if (thC != null) {
            return thC;
        }
        return null;
    }

    @Override // defpackage.az
    public void d(T value, Function1<? super Throwable, Unit> onCancellation) {
        I(value, this.resumeMode, onCancellation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.fe1
    public <T> T e(Object state) {
        return state instanceof CompletedContinuation ? (T) ((CompletedContinuation) state).result : state;
    }

    @Override // defpackage.fe1
    public Object g() {
        return get_state();
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<T> continuation = this.delegate;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.Continuation
    /* JADX INFO: renamed from: getContext, reason: from getter */
    public CoroutineContext get$context() {
        return this.context;
    }

    @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public final Void h(Object proposedUpdate) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + proposedUpdate).toString());
    }

    public final void i(wy handler, Throwable cause) {
        try {
            handler.a(cause);
        } catch (Throwable th) {
            oq0.a(get$context(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    @Override // defpackage.az
    public void j(Object token) {
        t(this.resumeMode);
    }

    @Override // defpackage.az
    public Object k(T value, Object idempotent) {
        return M(value, idempotent, null);
    }

    public final void l(Function1<? super Throwable, Unit> handler, Throwable cause) {
        try {
            handler.invoke(cause);
        } catch (Throwable th) {
            oq0.a(get$context(), new CompletionHandlerException("Exception in invokeOnCancellation handler for " + this, th));
        }
    }

    @Override // defpackage.az
    public void m(Function1<? super Throwable, Unit> handler) {
        wy wyVarC = C(handler);
        while (true) {
            Object obj = this._state;
            if (obj instanceof k5) {
                if (p1.a(h, this, obj, wyVarC)) {
                    return;
                }
            } else if (obj instanceof wy) {
                D(handler, obj);
            } else {
                boolean z = obj instanceof qj0;
                if (z) {
                    qj0 qj0Var = (qj0) obj;
                    if (!qj0Var.b()) {
                        D(handler, obj);
                    }
                    if (obj instanceof gz) {
                        if (!z) {
                            qj0Var = null;
                        }
                        l(handler, qj0Var != null ? qj0Var.cause : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof CompletedContinuation) {
                    CompletedContinuation completedContinuation = (CompletedContinuation) obj;
                    if (completedContinuation.cancelHandler != null) {
                        D(handler, obj);
                    }
                    if (wyVarC instanceof ps) {
                        return;
                    }
                    if (completedContinuation.c()) {
                        l(handler, completedContinuation.cancelCause);
                        return;
                    } else {
                        if (p1.a(h, this, obj, CompletedContinuation.b(completedContinuation, null, wyVarC, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (wyVarC instanceof ps) {
                        return;
                    }
                    if (p1.a(h, this, obj, new CompletedContinuation(obj, wyVarC, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    @Override // defpackage.az
    public Object n(T value, Object idempotent, Function1<? super Throwable, Unit> onCancellation) {
        return M(value, idempotent, onCancellation);
    }

    public final void o(Function1<? super Throwable, Unit> onCancellation, Throwable cause) {
        try {
            onCancellation.invoke(cause);
        } catch (Throwable th) {
            oq0.a(get$context(), new CompletionHandlerException("Exception in resume onCancellation handler for " + this, th));
        }
    }

    public boolean p(Throwable cause) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof xy3)) {
                return false;
            }
            z = obj instanceof wy;
        } while (!p1.a(h, this, obj, new gz(this, cause, z)));
        wy wyVar = z ? (wy) obj : null;
        if (wyVar != null) {
            i(wyVar, cause);
        }
        s();
        t(this.resumeMode);
        return true;
    }

    public final boolean q(Throwable cause) {
        if (B()) {
            return ((ce1) this.delegate).q(cause);
        }
        return false;
    }

    public final void r() {
        ne1 ne1Var = this.parentHandle;
        if (ne1Var == null) {
            return;
        }
        ne1Var.dispose();
        this.parentHandle = ty3.f21092a;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        J(this, C1496tj0.b(result, this), this.resumeMode, null, 4, null);
    }

    public final void s() {
        if (B()) {
            return;
        }
        r();
    }

    public final void t(int mode) {
        if (L()) {
            return;
        }
        C1405ge1.a(this, mode);
    }

    public String toString() {
        return E() + '(' + pv0.c(this.delegate) + "){" + x() + "}@" + pv0.b(this);
    }

    public Throwable u(cy2 parent) {
        return parent.s();
    }

    @PublishedApi
    public final Object v() {
        cy2 cy2Var;
        boolean zB = B();
        if (N()) {
            if (this.parentHandle == null) {
                z();
            }
            if (zB) {
                G();
            }
            return IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        }
        if (zB) {
            G();
        }
        Object obj = get_state();
        if (obj instanceof qj0) {
            throw ((qj0) obj).cause;
        }
        if (!C1405ge1.b(this.resumeMode) || (cy2Var = (cy2) get$context().get(cy2.INSTANCE)) == null || cy2Var.isActive()) {
            return e(obj);
        }
        CancellationException cancellationExceptionS = cy2Var.s();
        a(obj, cancellationExceptionS);
        throw cancellationExceptionS;
    }

    /* JADX INFO: renamed from: w, reason: from getter */
    public final Object get_state() {
        return this._state;
    }

    public final String x() {
        Object obj = get_state();
        return obj instanceof xy3 ? "Active" : obj instanceof gz ? "Cancelled" : "Completed";
    }

    public void y() {
        ne1 ne1VarZ = z();
        if (ne1VarZ != null && A()) {
            ne1VarZ.dispose();
            this.parentHandle = ty3.f21092a;
        }
    }

    public final ne1 z() {
        cy2 cy2Var = (cy2) get$context().get(cy2.INSTANCE);
        if (cy2Var == null) {
            return null;
        }
        ne1 ne1VarD = cy2.a.d(cy2Var, true, false, new p50(this), 2, null);
        this.parentHandle = ne1VarD;
        return ne1VarD;
    }
}
