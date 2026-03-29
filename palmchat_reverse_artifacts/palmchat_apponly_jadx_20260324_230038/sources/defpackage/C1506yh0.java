package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.qq.gdt.action.ActionUtils;
import defpackage.l55;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: yh0, reason: from Kotlin metadata and case insensitive filesystem */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0092\u0001\u0010\u000e\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0018\u00010\u00030\u000629\u0010\r\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fH\u0081@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f*\u001c\b\u0002\u0010\u0011\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00102\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Lfy1;", "", "Ldy1;", "flows", "Lkotlin/Function0;", "arrayFactory", "Lkotlin/Function3;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "transform", "a", "(Lfy1;[Ldy1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/collections/IndexedValue;", "Update", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0})
public final class C1506yh0 {

    /* JADX INFO: renamed from: yh0$a, reason: from Kotlin metadata and collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Lrq0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {57, 79, 82}, m = "invokeSuspend", n = {"latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch", "latestValues", "resultChannel", "lastReceivedEpoch", "remainingAbsentValues", "currentEpoch"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
    public static final class C1291a extends SuspendLambda implements Function2<rq0, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f22196a;
        public Object b;
        public int c;
        public int d;
        public int e;
        public /* synthetic */ Object f;
        public final /* synthetic */ dy1<T>[] g;
        public final /* synthetic */ Function0<T[]> h;
        public final /* synthetic */ Function3<fy1<? super R>, T[], Continuation<? super Unit>, Object> i;
        public final /* synthetic */ fy1<R> j;

        /* JADX INFO: renamed from: yh0$a$a, reason: from Kotlin metadata and collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        @Metadata(d1 = {"\u0000\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Lrq0;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
        public static final class C1292a extends SuspendLambda implements Function2<rq0, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f22197a;
            public final /* synthetic */ dy1<T>[] b;
            public final /* synthetic */ int c;
            public final /* synthetic */ AtomicInteger d;
            public final /* synthetic */ l00<IndexedValue<Object>> e;

            /* JADX INFO: renamed from: yh0$a$a$a */
            /* JADX INFO: compiled from: SearchBox */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, ActionUtils.PAYMENT_AMOUNT, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            public static final class a<T> implements fy1 {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ l00<IndexedValue<Object>> f22198a;
                public final /* synthetic */ int b;

                /* JADX INFO: renamed from: yh0$a$a$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: SearchBox */
                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1", f = "Combine.kt", i = {}, l = {35, 36}, m = "emit", n = {}, s = {})
                public static final class C1293a extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public /* synthetic */ Object f22199a;
                    public final /* synthetic */ a<T> b;
                    public int c;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    public C1293a(a<? super T> aVar, Continuation<? super C1293a> continuation) {
                        super(continuation);
                        this.b = aVar;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f22199a = obj;
                        this.c |= Integer.MIN_VALUE;
                        return this.b.emit(null, this);
                    }
                }

                public a(l00<IndexedValue<Object>> l00Var, int i) {
                    this.f22198a = l00Var;
                    this.b = i;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // defpackage.fy1
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(T t, Continuation<? super Unit> continuation) {
                    C1293a c1293a;
                    if (continuation instanceof C1293a) {
                        c1293a = (C1293a) continuation;
                        int i = c1293a.c;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            c1293a.c = i - Integer.MIN_VALUE;
                        } else {
                            c1293a = new C1293a(this, continuation);
                        }
                    }
                    Object obj = c1293a.f22199a;
                    Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = c1293a.c;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        l00<IndexedValue<Object>> l00Var = this.f22198a;
                        IndexedValue<Object> indexedValue = new IndexedValue<>(this.b, t);
                        c1293a.c = 1;
                        if (l00Var.q(indexedValue, c1293a) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    c1293a.c = 2;
                    if (np6.a(c1293a) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C1292a(dy1<? extends T>[] dy1VarArr, int i, AtomicInteger atomicInteger, l00<IndexedValue<Object>> l00Var, Continuation<? super C1292a> continuation) {
                super(2, continuation);
                this.b = dy1VarArr;
                this.c = i;
                this.d = atomicInteger;
                this.e = l00Var;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C1292a(this.b, this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo5invoke(rq0 rq0Var, Continuation<? super Unit> continuation) {
                return ((C1292a) create(rq0Var, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                AtomicInteger atomicInteger;
                Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f22197a;
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        dy1[] dy1VarArr = this.b;
                        int i2 = this.c;
                        dy1 dy1Var = dy1VarArr[i2];
                        a aVar = new a(this.e, i2);
                        this.f22197a = 1;
                        if (dy1Var.a(aVar, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    if (atomicInteger.decrementAndGet() == 0) {
                        l55.a.a(this.e, null, 1, null);
                    }
                    return Unit.INSTANCE;
                } finally {
                    if (this.d.decrementAndGet() == 0) {
                        l55.a.a(this.e, null, 1, null);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C1291a(dy1<? extends T>[] dy1VarArr, Function0<T[]> function0, Function3<? super fy1<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, fy1<? super R> fy1Var, Continuation<? super C1291a> continuation) {
            super(2, continuation);
            this.g = dy1VarArr;
            this.h = function0;
            this.i = function3;
            this.j = fy1Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C1291a c1291a = new C1291a(this.g, this.h, this.i, this.j, continuation);
            c1291a.f = obj;
            return c1291a;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo5invoke(rq0 rq0Var, Continuation<? super Unit> continuation) {
            return ((C1291a) create(rq0Var, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00e2  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e5 A[LOOP:0: B:28:0x00e5->B:51:?, LOOP_START, PHI: r6 r10
          0x00e5: PHI (r6v6 int) = (r6v5 int), (r6v7 int) binds: [B:25:0x00e0, B:51:?] A[DONT_GENERATE, DONT_INLINE]
          0x00e5: PHI (r10v8 kotlin.collections.IndexedValue) = (r10v7 kotlin.collections.IndexedValue), (r10v21 kotlin.collections.IndexedValue) binds: [B:25:0x00e0, B:51:?] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x012d -> B:20:0x00c2). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object[] objArr;
            int i;
            byte[] bArr;
            C1291a c1291a;
            int i2;
            l00 l00Var;
            int i3;
            Object objG;
            Object[] objArr2;
            IndexedValue indexedValue;
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.e;
            int i5 = 2;
            if (i4 == 0) {
                ResultKt.throwOnFailure(obj);
                rq0 rq0Var = (rq0) this.f;
                int length = this.g.length;
                if (length == 0) {
                    return Unit.INSTANCE;
                }
                objArr = new Object[length];
                ArraysKt___ArraysJvmKt.fill$default(objArr, z34.b, 0, 0, 6, (Object) null);
                l00 l00VarB = C1490p00.b(length, null, null, 6, null);
                AtomicInteger atomicInteger = new AtomicInteger(length);
                i = 0;
                int i6 = 0;
                while (i6 < length) {
                    int i7 = i6;
                    cv.b(rq0Var, null, null, new C1292a(this.g, i7, atomicInteger, l00VarB, null), 3, null);
                    i6 = i7 + 1;
                    atomicInteger = atomicInteger;
                }
                bArr = new byte[length];
                c1291a = this;
                i2 = length;
                l00Var = l00VarB;
            } else if (i4 == 1) {
                int i8 = this.d;
                i2 = this.c;
                byte[] bArr2 = (byte[]) this.b;
                l00 l00Var2 = (l00) this.f22196a;
                objArr2 = (Object[]) this.f;
                ResultKt.throwOnFailure(obj);
                objG = ((q00) obj).getHolder();
                i3 = i8;
                bArr = bArr2;
                l00Var = l00Var2;
                c1291a = this;
                indexedValue = (IndexedValue) q00.f(objG);
                if (indexedValue != null) {
                    return Unit.INSTANCE;
                }
                do {
                    int index = indexedValue.getIndex();
                    Object obj2 = objArr2[index];
                    objArr2[index] = indexedValue.getValue();
                    if (obj2 == z34.b) {
                        i2--;
                    }
                    if (bArr[index] == i3) {
                        break;
                    }
                    bArr[index] = (byte) i3;
                    indexedValue = (IndexedValue) q00.f(l00Var.f());
                } while (indexedValue != null);
                if (i2 != 0) {
                    i = i3;
                    objArr = objArr2;
                } else {
                    Object[] objArr3 = (Object[]) c1291a.h.invoke();
                    if (objArr3 == null) {
                        Function3<fy1<? super R>, T[], Continuation<? super Unit>, Object> function3 = c1291a.i;
                        Object obj3 = c1291a.j;
                        c1291a.f = objArr2;
                        c1291a.f22196a = l00Var;
                        c1291a.b = bArr;
                        c1291a.c = i2;
                        c1291a.d = i3;
                        c1291a.e = i5;
                        if (function3.invoke(obj3, objArr2, c1291a) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objArr = objArr2;
                        i = i3;
                    } else {
                        int i9 = i3;
                        ArraysKt___ArraysJvmKt.copyInto$default(objArr2, objArr3, 0, 0, 0, 14, (Object) null);
                        Function3<fy1<? super R>, T[], Continuation<? super Unit>, Object> function32 = c1291a.i;
                        Object obj4 = c1291a.j;
                        c1291a.f = objArr2;
                        c1291a.f22196a = l00Var;
                        c1291a.b = bArr;
                        c1291a.c = i2;
                        c1291a.d = i9;
                        c1291a.e = 3;
                        if (function32.invoke(obj4, objArr3, c1291a) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i = i9;
                        objArr = objArr2;
                    }
                }
                i5 = 2;
            } else if (i4 == 2) {
                int i10 = this.d;
                i2 = this.c;
                byte[] bArr3 = (byte[]) this.b;
                l00 l00Var3 = (l00) this.f22196a;
                Object[] objArr4 = (Object[]) this.f;
                ResultKt.throwOnFailure(obj);
                i = i10;
                bArr = bArr3;
                l00Var = l00Var3;
                objArr = objArr4;
                c1291a = this;
            } else {
                if (i4 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i11 = this.d;
                i2 = this.c;
                byte[] bArr4 = (byte[]) this.b;
                l00 l00Var4 = (l00) this.f22196a;
                Object[] objArr5 = (Object[]) this.f;
                ResultKt.throwOnFailure(obj);
                i = i11;
                bArr = bArr4;
                l00Var = l00Var4;
                objArr = objArr5;
                c1291a = this;
                i5 = 2;
            }
            byte b = (byte) (i + 1);
            c1291a.f = objArr;
            c1291a.f22196a = l00Var;
            c1291a.b = bArr;
            c1291a.c = i2;
            c1291a.d = b;
            c1291a.e = 1;
            objG = l00Var.g(c1291a);
            if (objG == coroutine_suspended) {
                return coroutine_suspended;
            }
            i3 = b;
            objArr2 = objArr;
            indexedValue = (IndexedValue) q00.f(objG);
            if (indexedValue != null) {
            }
        }
    }

    @PublishedApi
    public static final <R, T> Object a(fy1<? super R> fy1Var, dy1<? extends T>[] dy1VarArr, Function0<T[]> function0, Function3<? super fy1<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object objA = R.a(new C1291a(dy1VarArr, function0, function3, fy1Var, null), continuation);
        return objA == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }
}
