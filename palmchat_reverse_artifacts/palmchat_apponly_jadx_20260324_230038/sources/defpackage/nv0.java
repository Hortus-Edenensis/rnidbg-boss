package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.p0002sl.hb;
import com.kuaishou.weapon.p0.t;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001/B\t\b\u0002¢\u0006\u0004\b-\u0010.J\u001d\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0013\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00030\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010%\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\"\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R \u0010,\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010\u0012¨\u00060"}, d2 = {"Lnv0;", "", "Lkotlin/Function1;", "", "", "c", "()Lkotlin/jvm/functions/Function1;", "Lnv0$a;", "d", "(Lnv0$a;)Z", "owner", "e", "(Lnv0$a;)V", "Ljava/text/SimpleDateFormat;", t.l, "Ljava/text/SimpleDateFormat;", "dateFormat", "Lil0;", "Lil0;", "capturedCoroutinesMap", "", "installations", "I", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "f", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "coroutineStateLock", "g", "Z", "getSanitizeStackTraces", "()Z", "setSanitizeStackTraces", "(Z)V", "sanitizeStackTraces", "h", "getEnableCreationStackTraces", "setEnableCreationStackTraces", "enableCreationStackTraces", "i", "Lkotlin/jvm/functions/Function1;", "dynamicAttach", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lmv0;", hb.j, "callerInfoCache", "<init>", "()V", "a", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class nv0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final nv0 f19623a;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final SimpleDateFormat dateFormat;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static final il0<a<?>, Boolean> capturedCoroutinesMap;
    public static final /* synthetic */ ov0 d;
    public static final /* synthetic */ AtomicLongFieldUpdater e;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public static final ReentrantReadWriteLock coroutineStateLock;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public static boolean sanitizeStackTraces;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public static boolean enableCreationStackTraces;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public static final Function1<Boolean, Unit> dynamicAttach;
    private static volatile int installations;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public static final il0<CoroutineStackFrame, mv0> callerInfoCache;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\u000bH\u0016R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lnv0$a;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "Lkotlin/Result;", "result", "", "resumeWith", "(Ljava/lang/Object;)V", "", "toString", "a", "Lkotlin/coroutines/Continuation;", "delegate", t.l, "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "frame", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "callerFrame", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class a<T> implements Continuation<T>, CoroutineStackFrame {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public final Continuation<T> delegate;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final CoroutineStackFrame frame;

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public CoroutineStackFrame getCallerFrame() {
            CoroutineStackFrame coroutineStackFrame = this.frame;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.getCallerFrame();
            }
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        public StackTraceElement getStackTraceElement() {
            CoroutineStackFrame coroutineStackFrame = this.frame;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.getStackTraceElement();
            }
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(Object result) {
            nv0.f19623a.e(this);
            this.delegate.resumeWith(result);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [ov0] */
    static {
        nv0 nv0Var = new nv0();
        f19623a = nv0Var;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        capturedCoroutinesMap = new il0<>(false, 1, null);
        final long j = 0;
        d = new Object(j) { // from class: ov0
            volatile long sequenceNumber;

            {
                this.sequenceNumber = j;
            }
        };
        coroutineStateLock = new ReentrantReadWriteLock();
        sanitizeStackTraces = true;
        enableCreationStackTraces = true;
        dynamicAttach = nv0Var.c();
        callerInfoCache = new il0<>(true);
        e = AtomicLongFieldUpdater.newUpdater(ov0.class, "sequenceNumber");
    }

    public final Function1<Boolean, Unit> c() {
        Object objM840constructorimpl;
        Object objNewInstance;
        try {
            Result.Companion companion = Result.INSTANCE;
            objNewInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM840constructorimpl = Result.m840constructorimpl(ResultKt.createFailure(th));
        }
        if (objNewInstance == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
        }
        objM840constructorimpl = Result.m840constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(objNewInstance, 1));
        if (Result.m846isFailureimpl(objM840constructorimpl)) {
            objM840constructorimpl = null;
        }
        return (Function1) objM840constructorimpl;
    }

    public final boolean d(a<?> aVar) {
        aVar.getClass();
        throw null;
    }

    public final void e(a<?> owner) {
        capturedCoroutinesMap.remove(owner);
        owner.getClass();
        throw null;
    }
}
