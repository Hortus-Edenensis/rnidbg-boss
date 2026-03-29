package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.JobCancellationException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B-\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u001f\u001a\u00020\u0007\u0012\u0006\u0010 \u001a\u00020\u0007¢\u0006\u0004\b!\u0010\"J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0001J\"\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096Aø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0001ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0013\u001a\u00020\u00032\u000e\u0010\u0006\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00078\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006#"}, d2 = {"Lm00;", ExifInterface.LONGITUDE_EAST, "La1;", "", "Ll00;", "", "cause", "", "o", "Lq00;", "g", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "element", "q", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "()Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "a", WkAdxAdConfigMg.DSP_NAME_CSJ, "c", "Ll00;", "C0", "()Ll00;", "_channel", "i", "()Z", "isClosedForSend", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Ll00;ZZ)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class m00<E> extends a1<Unit> implements l00<E> {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final l00<E> _channel;

    public m00(CoroutineContext coroutineContext, l00<E> l00Var, boolean z, boolean z2) {
        super(coroutineContext, z, z2);
        this._channel = l00Var;
    }

    @Override // defpackage.oy2
    public void C(Throwable cause) {
        CancellationException cancellationExceptionR0 = oy2.r0(this, cause, null, 1, null);
        this._channel.a(cancellationExceptionR0);
        z(cancellationExceptionR0);
    }

    public final l00<E> C0() {
        return this._channel;
    }

    @Override // defpackage.oy2, defpackage.cy2, defpackage.ut4
    public final void a(CancellationException cause) {
        if (X()) {
            return;
        }
        if (cause == null) {
            cause = new JobCancellationException(F(), null, this);
        }
        C(cause);
    }

    @Override // defpackage.ut4
    public Object f() {
        return this._channel.f();
    }

    @Override // defpackage.ut4
    public Object g(Continuation<? super q00<? extends E>> continuation) {
        Object objG = this._channel.g(continuation);
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return objG;
    }

    @Override // defpackage.l55
    public boolean i() {
        return this._channel.i();
    }

    @Override // defpackage.l55
    public boolean o(Throwable cause) {
        return this._channel.o(cause);
    }

    @Override // defpackage.l55
    public Object q(E e, Continuation<? super Unit> continuation) {
        return this._channel.q(e, continuation);
    }
}
