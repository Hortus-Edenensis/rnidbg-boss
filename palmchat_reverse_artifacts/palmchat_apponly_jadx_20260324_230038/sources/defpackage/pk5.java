package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\rJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b0\u00072\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lpk5;", "Lu1;", "Lnk5;", "flow", "", "c", "(Lnk5;)Z", "", "Lkotlin/coroutines/Continuation;", "", "e", "(Lnk5;)[Lkotlin/coroutines/Continuation;", "f", "()V", "g", "()Z", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class pk5 extends u1<nk5<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f20034a = AtomicReferenceFieldUpdater.newUpdater(pk5.class, Object.class, "_state");
    volatile /* synthetic */ Object _state = null;

    @Override // defpackage.u1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(nk5<?> flow) {
        if (this._state != null) {
            return false;
        }
        this._state = C1482ok5.f19784a;
        return true;
    }

    public final Object d(Continuation<? super Unit> continuation) {
        bz bzVar = new bz(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        bzVar.y();
        if (!p1.a(f20034a, this, C1482ok5.f19784a, bzVar)) {
            Result.Companion companion = Result.INSTANCE;
            bzVar.resumeWith(Result.m840constructorimpl(Unit.INSTANCE));
        }
        Object objV = bzVar.v();
        if (objV == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objV == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objV : Unit.INSTANCE;
    }

    @Override // defpackage.u1
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Continuation<Unit>[] b(nk5<?> flow) {
        this._state = null;
        return t1.f20883a;
    }

    public final void f() {
        while (true) {
            Object obj = this._state;
            if (obj == null || obj == C1482ok5.b) {
                return;
            }
            if (obj == C1482ok5.f19784a) {
                if (p1.a(f20034a, this, obj, C1482ok5.b)) {
                    return;
                }
            } else if (p1.a(f20034a, this, obj, C1482ok5.f19784a)) {
                Result.Companion companion = Result.INSTANCE;
                ((bz) obj).resumeWith(Result.m840constructorimpl(Unit.INSTANCE));
                return;
            }
        }
    }

    public final boolean g() {
        Object andSet = f20034a.getAndSet(this, C1482ok5.f19784a);
        Intrinsics.checkNotNull(andSet);
        return andSet == C1482ok5.b;
    }
}
