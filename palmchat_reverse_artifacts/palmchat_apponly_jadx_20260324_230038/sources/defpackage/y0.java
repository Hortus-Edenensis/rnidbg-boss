package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.hms.ads.ContentClassification;
import com.kuaishou.weapon.p0.t;
import com.qq.gdt.action.ActionUtils;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import defpackage.v53;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0003\u001b89B)\u0012 \u00105\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u000103j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`4¢\u0006\u0004\b6\u00107J!\u0010\u0007\u001a\u00028\u0001\"\u0004\b\u0001\u0010\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0001\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002J \u0010\u000f\u001a\u00020\u000e2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0002J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0014J\u0016\u0010\u0012\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0014J\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013H\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u001b\u001a\u00020\u000e2\u000e\u0010\u001a\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`\u0019J\u0019\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001cH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000bH\u0014J/\u0010&\u001a\u00020\u000e2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\n\u0010%\u001a\u0006\u0012\u0002\b\u00030$H\u0014ø\u0001\u0000ø\u0001\u0002¢\u0006\u0004\b&\u0010'J\u0010\u0010)\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010(H\u0014J\b\u0010*\u001a\u00020\u000eH\u0014J\b\u0010+\u001a\u00020\u000eH\u0014R\u0014\u0010.\u001a\u00020\u000b8$X¤\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u000b8$X¤\u0004¢\u0006\u0006\u001a\u0004\b/\u0010-R\u0014\u00102\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010-\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006:"}, d2 = {"Ly0;", ExifInterface.LONGITUDE_EAST, "Lq1;", "Ll00;", "R", "", "receiveMode", "O", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ltt4;", "receive", "", "Laz;", "cont", "", "P", "", "N", "F", "Lq00;", "g", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "()Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cause", "a", "", "D", "(Ljava/lang/Throwable;)Z", "wasClosed", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "Lzs2;", "Lj55;", "list", "Lfd0;", "closed", "K", "(Ljava/lang/Object;Lfd0;)V", "Lvt4;", "z", "M", "L", WkAdxAdConfigMg.DSP_NAME_GDT, "()Z", "isBufferAlwaysEmpty", "H", "isBufferEmpty", "I", "isClosedForReceive", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V", t.l, "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class y0<E> extends q1<E> implements l00<E> {

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\u0012\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014\u0012\u0006\u0010\u0019\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00028\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0011\u001a\u00020\f2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u001c\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00148\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0018¨\u0006\u001c"}, d2 = {"Ly0$a;", ExifInterface.LONGITUDE_EAST, "Ltt4;", ActionUtils.PAYMENT_AMOUNT, "", "A", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lv53$b;", "otherOp", "Lyp5;", "e", "(Ljava/lang/Object;Lv53$b;)Lyp5;", "", "d", "(Ljava/lang/Object;)V", "Lfd0;", "closed", "z", "", "toString", "Laz;", "Laz;", "cont", "", "I", "receiveMode", "<init>", "(Laz;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static class a<E> extends tt4<E> {

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        @JvmField
        public final az<Object> cont;

        /* JADX INFO: renamed from: e, reason: from kotlin metadata */
        @JvmField
        public final int receiveMode;

        public a(az<Object> azVar, int i) {
            this.cont = azVar;
            this.receiveMode = i;
        }

        public final Object A(E value) {
            return this.receiveMode == 1 ? q00.b(q00.INSTANCE.c(value)) : value;
        }

        @Override // defpackage.vt4
        public void d(E value) {
            this.cont.j(cz.f16950a);
        }

        @Override // defpackage.vt4
        public yp5 e(E value, v53.b otherOp) {
            if (this.cont.n(A(value), null, y(value)) == null) {
                return null;
            }
            return cz.f16950a;
        }

        @Override // defpackage.v53
        public String toString() {
            return "ReceiveElement@" + pv0.b(this) + "[receiveMode=" + this.receiveMode + ']';
        }

        @Override // defpackage.tt4
        public void z(fd0<?> closed) {
            if (this.receiveMode == 1) {
                this.cont.resumeWith(Result.m840constructorimpl(q00.b(q00.INSTANCE.a(closed.closeCause))));
                return;
            }
            az<Object> azVar = this.cont;
            Result.Companion companion = Result.INSTANCE;
            azVar.resumeWith(Result.m840constructorimpl(ResultKt.createFailure(closed.E())));
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00010\u0002B=\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00028\u0001`\t¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\bR*\u0010\f\u001a\u0018\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00060\u0004j\b\u0012\u0004\u0012\u00028\u0001`\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Ly0$b;", ExifInterface.LONGITUDE_EAST, "Ly0$a;", ActionUtils.PAYMENT_AMOUNT, "Lkotlin/Function1;", "", "", "y", "(Ljava/lang/Object;)Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "f", "Lkotlin/jvm/functions/Function1;", "onUndeliveredElement", "Laz;", "", "cont", "", "receiveMode", "<init>", "(Laz;ILkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class b<E> extends a<E> {

        /* JADX INFO: renamed from: f, reason: from kotlin metadata */
        @JvmField
        public final Function1<E, Unit> onUndeliveredElement;

        /* JADX WARN: Multi-variable type inference failed */
        public b(az<Object> azVar, int i, Function1<? super E, Unit> function1) {
            super(azVar, i);
            this.onUndeliveredElement = function1;
        }

        @Override // defpackage.tt4
        public Function1<Throwable, Unit> y(E value) {
            return C1503w74.a(this.onUndeliveredElement, value, this.cont.getContext());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0018\u0010\n\u001a\u0006\u0012\u0002\b\u00030\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\t¨\u0006\r"}, d2 = {"Ly0$c;", "Lps;", "", "cause", "", "a", "", "toString", "Ltt4;", "Ltt4;", "receive", "<init>", "(Ly0;Ltt4;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public final class c extends ps {

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final tt4<?> receive;

        public c(tt4<?> tt4Var) {
            this.receive = tt4Var;
        }

        @Override // defpackage.xy
        public void a(Throwable cause) {
            if (this.receive.s()) {
                y0.this.L();
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.INSTANCE;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.receive + ']';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0007"}, d2 = {"y0$d", "Lv53$a;", "Lv53;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "i", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class d extends v53.a {
        public final /* synthetic */ y0 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(v53 v53Var, y0 y0Var) {
            super(v53Var);
            this.d = y0Var;
        }

        @Override // defpackage.zi
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(v53 affected) {
            if (this.d.H()) {
                return null;
            }
            return u53.a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS}, m = "receiveCatching-JP2dKIU", n = {}, s = {})
    public static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f22089a;
        public final /* synthetic */ y0<E> b;
        public int c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(y0<E> y0Var, Continuation<? super e> continuation) {
            super(continuation);
            this.b = y0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f22089a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objG = this.b.g(this);
            return objG == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objG : q00.b(objG);
        }
    }

    public y0(Function1<? super E, Unit> function1) {
        super(function1);
    }

    public final boolean D(Throwable cause) {
        boolean zO = o(cause);
        J(zO);
        return zO;
    }

    public final boolean E(tt4<? super E> receive) {
        boolean zF = F(receive);
        if (zF) {
            M();
        }
        return zF;
    }

    public boolean F(tt4<? super E> receive) {
        int iW;
        v53 v53VarO;
        if (!G()) {
            v53 queue = getQueue();
            d dVar = new d(receive, this);
            do {
                v53 v53VarO2 = queue.o();
                if (!(!(v53VarO2 instanceof j55))) {
                    return false;
                }
                iW = v53VarO2.w(receive, queue, dVar);
                if (iW != 1) {
                }
            } while (iW != 2);
            return false;
        }
        v53 queue2 = getQueue();
        do {
            v53VarO = queue2.o();
            if (!(!(v53VarO instanceof j55))) {
                return false;
            }
        } while (!v53VarO.h(receive, queue2));
        return true;
    }

    public abstract boolean G();

    public abstract boolean H();

    public boolean I() {
        return j() != null && H();
    }

    public void J(boolean wasClosed) {
        fd0<?> fd0VarK = k();
        if (fd0VarK == null) {
            throw new IllegalStateException("Cannot happen".toString());
        }
        Object objB = zs2.b(null, 1, null);
        while (true) {
            v53 v53VarO = fd0VarK.o();
            if (v53VarO instanceof t53) {
                K(objB, fd0VarK);
                return;
            } else if (v53VarO.s()) {
                objB = zs2.c(objB, (j55) v53VarO);
            } else {
                v53VarO.p();
            }
        }
    }

    public void K(Object list, fd0<?> closed) {
        if (list == null) {
            return;
        }
        if (!(list instanceof ArrayList)) {
            ((j55) list).z(closed);
            return;
        }
        ArrayList arrayList = (ArrayList) list;
        int size = arrayList.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            } else {
                ((j55) arrayList.get(size)).z(closed);
            }
        }
    }

    public Object N() {
        while (true) {
            j55 j55VarA = A();
            if (j55VarA == null) {
                return z0.d;
            }
            if (j55VarA.A(null) != null) {
                j55VarA.x();
                return j55VarA.getElement();
            }
            j55VarA.B();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> Object O(int i, Continuation<? super R> continuation) {
        bz bzVarA = C1403dz.a(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        a aVar = this.onUndeliveredElement == null ? new a(bzVarA, i) : new b(bzVarA, i, this.onUndeliveredElement);
        while (true) {
            if (E(aVar)) {
                P(bzVarA, aVar);
                break;
            }
            Object objN = N();
            if (objN instanceof fd0) {
                aVar.z((fd0) objN);
                break;
            }
            if (objN != z0.d) {
                bzVarA.d(aVar.A(objN), aVar.y(objN));
                break;
            }
        }
        Object objV = bzVarA.v();
        if (objV == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objV;
    }

    public final void P(az<?> cont, tt4<?> receive) {
        cont.m(new c(receive));
    }

    @Override // defpackage.ut4
    public final void a(CancellationException cause) {
        if (I()) {
            return;
        }
        if (cause == null) {
            cause = new CancellationException(pv0.a(this) + " was cancelled");
        }
        D(cause);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.ut4
    public final Object f() {
        Object objN = N();
        return objN == z0.d ? q00.INSTANCE.b() : objN instanceof fd0 ? q00.INSTANCE.a(((fd0) objN).closeCause) : q00.INSTANCE.c(objN);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // defpackage.ut4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(Continuation<? super q00<? extends E>> continuation) {
        e eVar;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i = eVar.c;
            if ((i & Integer.MIN_VALUE) != 0) {
                eVar.c = i - Integer.MIN_VALUE;
            } else {
                eVar = new e(this, continuation);
            }
        }
        Object objO = eVar.f22089a;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = eVar.c;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objO);
            Object objN = N();
            if (objN != z0.d) {
                return objN instanceof fd0 ? q00.INSTANCE.a(((fd0) objN).closeCause) : q00.INSTANCE.c(objN);
            }
            eVar.c = 1;
            objO = O(1, eVar);
            if (objO == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objO);
        }
        return ((q00) objO).getHolder();
    }

    @Override // defpackage.q1
    public vt4<E> z() {
        vt4<E> vt4VarZ = super.z();
        if (vt4VarZ != null && !(vt4VarZ instanceof fd0)) {
            L();
        }
        return vt4VarZ;
    }

    public void L() {
    }

    public void M() {
    }
}
