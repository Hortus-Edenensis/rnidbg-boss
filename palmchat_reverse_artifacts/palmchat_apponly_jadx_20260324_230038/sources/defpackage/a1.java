package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.location.LocationConst;
import com.kuaishou.weapon.p0.t;
import com.qq.gdt.action.ActionUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.text.Typography;
import kotlinx.coroutines.CoroutineStart;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\b'\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0005B\u001f\u0012\u0006\u00102\u001a\u00020&\u0012\u0006\u00103\u001a\u00020\f\u0012\u0006\u00104\u001a\u00020\f¢\u0006\u0004\b5\u00106J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0004J\u001e\u0010\u0016\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\tJ\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u0017\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000fH\u0010¢\u0006\u0004\b\u001b\u0010\u001cJO\u0010$\u001a\u00020\u0007\"\u0004\b\u0001\u0010\u001d2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00028\u00012'\u0010#\u001a#\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00110!¢\u0006\u0002\b\"ø\u0001\u0000¢\u0006\u0004\b$\u0010%R\u001d\u0010-\u001a\u00020&8\u0006¢\u0006\u0012\n\u0004\b'\u0010(\u0012\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u0014\u0010/\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u0014\u00100\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"La1;", ExifInterface.GPS_DIRECTION_TRUE, "Loy2;", "Lcy2;", "Lkotlin/coroutines/Continuation;", "Lrq0;", ActionUtils.PAYMENT_AMOUNT, "", "A0", "(Ljava/lang/Object;)V", "", "cause", "", "handled", "z0", "", "F", "", LocationConst.HDYawConst.KEY_HD_YAW_STATE, "i0", "Lkotlin/Result;", "result", "resumeWith", "y0", "exception", "U", "(Ljava/lang/Throwable;)V", "d0", "()Ljava/lang/String;", "R", "Lkotlinx/coroutines/CoroutineStart;", "start", "receiver", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "block", "B0", "(Lkotlinx/coroutines/CoroutineStart;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/coroutines/CoroutineContext;", t.l, "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getContext$annotations", "()V", "context", "getCoroutineContext", "coroutineContext", "isActive", "()Z", "parentContext", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;ZZ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class a1<T> extends oy2 implements Continuation<T>, rq0 {

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final CoroutineContext context;

    public a1(CoroutineContext coroutineContext, boolean z, boolean z2) {
        super(z2);
        if (z) {
            V((cy2) coroutineContext.get(cy2.INSTANCE));
        }
        this.context = coroutineContext.plus(this);
    }

    public final <R> void B0(CoroutineStart start, R receiver, Function2<? super R, ? super Continuation<? super T>, ? extends Object> block) throws Throwable {
        start.invoke(block, receiver, this);
    }

    @Override // defpackage.oy2
    public String F() {
        return pv0.a(this) + " was cancelled";
    }

    @Override // defpackage.oy2
    public final void U(Throwable exception) {
        oq0.a(this.context, exception);
    }

    @Override // defpackage.oy2
    public String d0() {
        String strB = kq0.b(this.context);
        if (strB == null) {
            return super.d0();
        }
        return Typography.quote + strB + "\":" + super.d0();
    }

    @Override // kotlin.coroutines.Continuation
    public final CoroutineContext getContext() {
        return this.context;
    }

    @Override // defpackage.rq0
    public CoroutineContext getCoroutineContext() {
        return this.context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.oy2
    public final void i0(Object state) {
        if (!(state instanceof qj0)) {
            A0(state);
        } else {
            qj0 qj0Var = (qj0) state;
            z0(qj0Var.cause, qj0Var.a());
        }
    }

    @Override // defpackage.oy2, defpackage.cy2
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object result) {
        Object objB0 = b0(C1496tj0.d(result, null, 1, null));
        if (objB0 == py2.b) {
            return;
        }
        y0(objB0);
    }

    public void y0(Object state) {
        y(state);
    }

    public void A0(T value) {
    }

    public void z0(Throwable cause, boolean handled) {
    }
}
