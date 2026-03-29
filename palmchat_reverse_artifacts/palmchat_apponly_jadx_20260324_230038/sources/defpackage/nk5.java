package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.gdt.action.ActionUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\b\u0012\u0004\u0012\u00028\u00000\u0005B\u000f\u0012\u0006\u0010$\u001a\u00020\u0005¢\u0006\u0004\b%\u0010!J\u001b\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ!\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0019\u001a\u00020\u00182\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR*\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lnk5;", ExifInterface.GPS_DIRECTION_TRUE, "Ls1;", "Lpk5;", "Lft3;", "", ActionUtils.PAYMENT_AMOUNT, "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lfy1;", "collector", "", "a", "(Lfy1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "()Lpk5;", "", "size", "", "h", "(I)[Lpk5;", "expectedState", "newState", "", "i", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "d", "I", "sequence", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "getValue$annotations", "()V", "initialState", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class nk5<T> extends s1<pk5> implements ft3<T>, dy1 {
    private volatile /* synthetic */ Object _state;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public int sequence;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND, 403}, m = "collect", n = {"this", "collector", "slot", "this", "collector", "slot", "collectorJob", "newState", "this", "collector", "slot", "collectorJob", "oldState"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f19549a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public /* synthetic */ Object f;
        public final /* synthetic */ nk5<T> g;
        public int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(nk5<T> nk5Var, Continuation<? super a> continuation) {
            super(continuation);
            this.g = nk5Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return this.g.a(null, this);
        }
    }

    public nk5(Object obj) {
        this._state = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:38:0x00af, B:40:0x00b5], limit reached: 57 */
    /* JADX WARN: Path cross not found for [B:40:0x00b5, B:38:0x00af], limit reached: 57 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00aa A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:48:0x00d0, B:50:0x00d6, B:40:0x00b5, B:44:0x00bc, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:48:0x00d0, B:50:0x00d6, B:40:0x00b5, B:44:0x00bc, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d6 A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:14:0x003e, B:34:0x00a6, B:36:0x00aa, B:38:0x00af, B:48:0x00d0, B:50:0x00d6, B:40:0x00b5, B:44:0x00bc, B:19:0x005c, B:22:0x006f, B:33:0x0097), top: B:57:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v2, types: [u1] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object, pk5] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v2, types: [fy1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00d4 -> B:34:0x00a6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x00e6 -> B:34:0x00a6). Please report as a decompilation issue!!! */
    @Override // defpackage.q75, defpackage.dy1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(fy1<? super T> fy1Var, Continuation<?> continuation) throws Throwable {
        a aVar;
        nk5<T> nk5Var;
        pk5 pk5Var;
        ?? r7;
        cy2 cy2Var;
        Object obj;
        ?? r72;
        ?? r6;
        boolean zG;
        Object obj2;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.h;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.h = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(this, continuation);
            }
        }
        Object obj3 = aVar.f;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.h;
        ?? r62 = 1;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj3);
                pk5 pk5VarB = b();
                try {
                    if (fy1Var instanceof rm5) {
                        aVar.f19549a = this;
                        aVar.b = fy1Var;
                        aVar.c = pk5VarB;
                        aVar.h = 1;
                        if (((rm5) fy1Var).a(aVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    nk5Var = this;
                    pk5Var = pk5VarB;
                } catch (Throwable th) {
                    th = th;
                    nk5Var = this;
                    r62 = pk5VarB;
                    nk5Var.e(r62);
                    throw th;
                }
            } else if (i2 == 1) {
                pk5 pk5Var2 = (pk5) aVar.c;
                fy1Var = (fy1) aVar.b;
                nk5Var = (nk5) aVar.f19549a;
                ResultKt.throwOnFailure(obj3);
                pk5Var = pk5Var2;
            } else if (i2 == 2) {
                obj = aVar.e;
                cy2Var = (cy2) aVar.d;
                pk5 pk5Var3 = (pk5) aVar.c;
                fy1 fy1Var2 = (fy1) aVar.b;
                nk5Var = (nk5) aVar.f19549a;
                ResultKt.throwOnFailure(obj3);
                r6 = pk5Var3;
                r72 = fy1Var2;
                zG = r6.g();
                r62 = r6;
                r7 = r72;
                if (!zG) {
                }
                Object obj4 = nk5Var._state;
                if (cy2Var != null) {
                }
                if (obj != null) {
                }
                if (obj4 != z34.f22337a) {
                }
                aVar.f19549a = nk5Var;
                aVar.b = r7;
                aVar.c = r62;
                aVar.d = cy2Var;
                aVar.e = obj4;
                aVar.h = 2;
                if (r7.emit(obj2, aVar) != coroutine_suspended) {
                }
            } else {
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = aVar.e;
                cy2Var = (cy2) aVar.d;
                pk5 pk5Var4 = (pk5) aVar.c;
                fy1 fy1Var3 = (fy1) aVar.b;
                nk5Var = (nk5) aVar.f19549a;
                ResultKt.throwOnFailure(obj3);
                r62 = pk5Var4;
                r7 = fy1Var3;
                Object obj42 = nk5Var._state;
                if (cy2Var != null) {
                    ly2.c(cy2Var);
                }
                if (obj != null) {
                    r6 = r62;
                    r72 = r7;
                    if (!Intrinsics.areEqual(obj, obj42)) {
                    }
                    zG = r6.g();
                    r62 = r6;
                    r7 = r72;
                    if (!zG) {
                        aVar.f19549a = nk5Var;
                        aVar.b = r72;
                        aVar.c = r6;
                        aVar.d = cy2Var;
                        aVar.e = obj;
                        aVar.h = 3;
                        Object objD = r6.d(aVar);
                        r62 = r6;
                        r7 = r72;
                        if (objD == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    Object obj422 = nk5Var._state;
                    if (cy2Var != null) {
                    }
                    if (obj != null) {
                    }
                }
                obj2 = obj422 != z34.f22337a ? null : obj422;
                aVar.f19549a = nk5Var;
                aVar.b = r7;
                aVar.c = r62;
                aVar.d = cy2Var;
                aVar.e = obj422;
                aVar.h = 2;
                if (r7.emit(obj2, aVar) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = obj422;
                r6 = r62;
                r72 = r7;
                zG = r6.g();
                r62 = r6;
                r7 = r72;
                if (!zG) {
                }
                Object obj4222 = nk5Var._state;
                if (cy2Var != null) {
                }
                if (obj != null) {
                }
                if (obj4222 != z34.f22337a) {
                }
                aVar.f19549a = nk5Var;
                aVar.b = r7;
                aVar.c = r62;
                aVar.d = cy2Var;
                aVar.e = obj4222;
                aVar.h = 2;
                if (r7.emit(obj2, aVar) != coroutine_suspended) {
                }
            }
            r7 = fy1Var;
            cy2Var = (cy2) aVar.getContext().get(cy2.INSTANCE);
            obj = null;
            r62 = pk5Var;
            Object obj42222 = nk5Var._state;
            if (cy2Var != null) {
            }
            if (obj != null) {
            }
            if (obj42222 != z34.f22337a) {
            }
            aVar.f19549a = nk5Var;
            aVar.b = r7;
            aVar.c = r62;
            aVar.d = cy2Var;
            aVar.e = obj42222;
            aVar.h = 2;
            if (r7.emit(obj2, aVar) != coroutine_suspended) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // defpackage.fy1
    public Object emit(T t, Continuation<? super Unit> continuation) {
        setValue(t);
        return Unit.INSTANCE;
    }

    @Override // defpackage.s1
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public pk5 c() {
        return new pk5();
    }

    @Override // defpackage.s1
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public pk5[] d(int size) {
        return new pk5[size];
    }

    public final boolean i(Object expectedState, Object newState) {
        int i;
        pk5[] pk5VarArrF;
        f();
        synchronized (this) {
            Object obj = this._state;
            if (expectedState != null && !Intrinsics.areEqual(obj, expectedState)) {
                return false;
            }
            if (Intrinsics.areEqual(obj, newState)) {
                return true;
            }
            this._state = newState;
            int i2 = this.sequence;
            if ((i2 & 1) != 0) {
                this.sequence = i2 + 2;
                return true;
            }
            int i3 = i2 + 1;
            this.sequence = i3;
            pk5[] pk5VarArrF2 = f();
            Unit unit = Unit.INSTANCE;
            while (true) {
                pk5[] pk5VarArr = pk5VarArrF2;
                if (pk5VarArr != null) {
                    for (pk5 pk5Var : pk5VarArr) {
                        if (pk5Var != null) {
                            pk5Var.f();
                        }
                    }
                }
                synchronized (this) {
                    i = this.sequence;
                    if (i == i3) {
                        this.sequence = i3 + 1;
                        return true;
                    }
                    pk5VarArrF = f();
                    Unit unit2 = Unit.INSTANCE;
                }
                pk5VarArrF2 = pk5VarArrF;
                i3 = i;
            }
        }
    }

    @Override // defpackage.ft3
    public void setValue(T t) {
        if (t == null) {
            t = (T) z34.f22337a;
        }
        i(null, t);
    }
}
