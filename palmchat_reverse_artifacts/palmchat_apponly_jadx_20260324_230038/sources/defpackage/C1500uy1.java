package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: renamed from: uy1, reason: from Kotlin metadata and case insensitive filesystem */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a1\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\t\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lfy1;", "Lut4;", "channel", "", t.l, "(Lfy1;Lut4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "consume", "c", "(Lfy1;Lut4;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
public final /* synthetic */ class C1500uy1 {

    /* JADX INFO: renamed from: uy1$a */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", i = {0, 0, 0, 1, 1, 1}, l = {51, 62}, m = "emitAllImpl$FlowKt__ChannelsKt", n = {"$this$emitAllImpl", "channel", "consume", "$this$emitAllImpl", "channel", "consume"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"})
    public static final class a<T> extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f21322a;
        public Object b;
        public boolean c;
        public /* synthetic */ Object d;
        public int e;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return C1500uy1.c(null, null, false, this);
        }
    }

    public static final <T> Object b(fy1<? super T> fy1Var, ut4<? extends T> ut4Var, Continuation<? super Unit> continuation) throws Throwable {
        Object objC = c(fy1Var, ut4Var, true, continuation);
        return objC == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objC : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #0 {all -> 0x0055, blocks: (B:13:0x0032, B:27:0x006f, B:29:0x0075, B:35:0x0084, B:36:0x0085, B:18:0x004b), top: B:46:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0085 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #0 {all -> 0x0055, blocks: (B:13:0x0032, B:27:0x006f, B:29:0x0075, B:35:0x0084, B:36:0x0085, B:18:0x004b), top: B:46:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r6v0, types: [fy1, fy1<? super T>] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v19, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v3, types: [fy1, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0095 -> B:14:0x0035). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object c(fy1<? super T> fy1Var, ut4<? extends T> ut4Var, boolean z, Continuation<? super Unit> continuation) throws Throwable {
        a aVar;
        Object objG;
        ?? r8;
        ?? r82;
        ?? r6;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.e;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.e = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        }
        Object obj = aVar.d;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.e;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (i2 != 0) {
            if (i2 == 1) {
                boolean z2 = (fy1<? super T>) aVar.c;
                ut4Var = (ut4) aVar.b;
                fy1 fy1Var2 = (fy1) aVar.f21322a;
                ResultKt.throwOnFailure(obj);
                objG = ((q00) obj).getHolder();
                fy1Var = z2;
                r8 = fy1Var2;
                if (!q00.i(objG)) {
                }
                throw th;
            }
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z3 = (fy1<? super T>) aVar.c;
            ut4Var = (ut4) aVar.b;
            fy1 fy1Var3 = (fy1) aVar.f21322a;
            ResultKt.throwOnFailure(obj);
            ?? r62 = z3;
            ?? r83 = fy1Var3;
            ?? r5 = r83;
            r82 = r62;
            r6 = (fy1<? super T>) r5;
            try {
                aVar.f21322a = r6;
                aVar.b = ut4Var;
                aVar.c = r82;
                aVar.e = 1;
                objG = ut4Var.g(aVar);
            } catch (Throwable th2) {
                ?? r52 = r82;
                th = th2;
                fy1Var = r52 == true ? 1 : 0;
            }
            if (objG == coroutine_suspended) {
                return coroutine_suspended;
            }
            ?? r53 = r82;
            r8 = r6;
            fy1Var = (fy1<? super T>) (r53 == true ? 1 : 0 ? 1 : 0);
            if (!q00.i(objG)) {
                Throwable thE = q00.e(objG);
                if (thE != null) {
                    throw thE;
                }
                if (fy1Var != 0) {
                    r00.a(ut4Var, null);
                }
                return Unit.INSTANCE;
            }
            Object objG2 = q00.g(objG);
            aVar.f21322a = r8;
            aVar.b = ut4Var;
            aVar.c = (boolean) fy1Var;
            aVar.e = 2;
            Object objEmit = r8.emit(objG2, aVar);
            r62 = fy1Var;
            r83 = r8;
            if (objEmit == coroutine_suspended) {
                return coroutine_suspended;
            }
            ?? r54 = r83;
            r82 = r62;
            r6 = (fy1<? super T>) r54;
            aVar.f21322a = r6;
            aVar.b = ut4Var;
            aVar.c = r82;
            aVar.e = 1;
            objG = ut4Var.g(aVar);
            if (objG == coroutine_suspended) {
            }
            try {
                throw th;
            } catch (Throwable th3) {
                if (fy1Var != 0) {
                    r00.a(ut4Var, th);
                }
                throw th3;
            }
        }
        ResultKt.throwOnFailure(obj);
        iy1.e(fy1Var);
        r6 = fy1Var;
        r82 = z;
        aVar.f21322a = r6;
        aVar.b = ut4Var;
        aVar.c = r82;
        aVar.e = 1;
        objG = ut4Var.g(aVar);
        if (objG == coroutine_suspended) {
        }
    }
}
