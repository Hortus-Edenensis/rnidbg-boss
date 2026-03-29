package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.p0002sl.hb;
import com.kuaishou.weapon.p0.t;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.v53;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001a\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001/B)\u0012 \u00101\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010-j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`.¢\u0006\u0004\bJ\u0010KJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J+\u0010\n\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0010\u001a\u00020\u00042\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001b2\u0006\u0010\u0003\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0006J\u0019\u0010 \u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020\u0018H\u0014¢\u0006\u0004\b \u0010!J\u0019\u0010#\u001a\u00020\"2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020%H\u0014¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001bH\u0014¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,R.\u00101\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0004\u0018\u00010-j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`.8\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001a\u00107\u001a\u0002028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0014\u0010:\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b8\u00109R\u0014\u0010<\u001a\u00020*8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b;\u0010,R\u0014\u0010>\u001a\u00020\"8$X¤\u0004¢\u0006\u0006\u001a\u0004\b=\u00109R\u0014\u0010@\u001a\u00020\"8$X¤\u0004¢\u0006\u0006\u001a\u0004\b?\u00109R\u001a\u0010C\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u001a\u0010E\u001a\b\u0012\u0002\b\u0003\u0018\u00010\b8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bD\u0010BR\u0011\u0010G\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\bF\u00109R\u0014\u0010I\u001a\u00020*8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\bH\u0010,\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006L"}, d2 = {"Lq1;", ExifInterface.LONGITUDE_EAST, "Ll55;", "element", "", "y", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/Continuation;", "Lfd0;", "closed", "p", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lfd0;)V", "", "cause", t.k, "(Ljava/lang/Throwable;)V", "n", "(Lfd0;)V", "", "d", "()I", "", "v", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lj55;", "A", "()Lj55;", "Lvt4;", "x", "(Ljava/lang/Object;)Lvt4;", "q", LogUtil.VALUE_SEND, "e", "(Lj55;)Ljava/lang/Object;", "", "o", "(Ljava/lang/Throwable;)Z", "Lv53;", RXScreenCaptureService.KEY_WIDTH, "(Lv53;)V", "z", "()Lvt4;", "", "toString", "()Ljava/lang/String;", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "a", "Lkotlin/jvm/functions/Function1;", "onUndeliveredElement", "Lt53;", t.l, "Lt53;", "l", "()Lt53;", "queue", "u", "()Z", "isFullImpl", "m", "queueDebugStateString", "s", "isBufferAlwaysFull", "t", "isBufferFull", t.f7496a, "()Lfd0;", "closedForSend", hb.j, "closedForReceive", "i", "isClosedForSend", "h", "bufferDebugString", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class q1<E> implements l55<E> {
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(q1.class, Object.class, "onCloseHandler");

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    public final Function1<E, Unit> onUndeliveredElement;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final t53 queue = new t53();
    private volatile /* synthetic */ Object onCloseHandler = null;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0007"}, d2 = {"q1$b", "Lv53$a;", "Lv53;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "i", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class b extends v53.a {
        public final /* synthetic */ q1 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(v53 v53Var, q1 q1Var) {
            super(v53Var);
            this.d = q1Var;
        }

        @Override // defpackage.zi
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(v53 affected) {
            if (this.d.t()) {
                return null;
            }
            return u53.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q1(Function1<? super E, Unit> function1) {
        this.onUndeliveredElement = function1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final j55 A() {
        v53 v53Var;
        v53 v53VarU;
        t53 t53Var = this.queue;
        while (true) {
            v53Var = (v53) t53Var.m();
            if (v53Var == t53Var || !(v53Var instanceof j55)) {
                break;
            }
            if (((((j55) v53Var) instanceof fd0) && !v53Var.r()) || (v53VarU = v53Var.u()) == null) {
                break;
            }
            v53VarU.q();
        }
        return (j55) v53Var;
    }

    public final int d() {
        t53 t53Var = this.queue;
        int i = 0;
        for (v53 v53VarN = (v53) t53Var.m(); !Intrinsics.areEqual(v53VarN, t53Var); v53VarN = v53VarN.n()) {
            if (v53VarN instanceof v53) {
                i++;
            }
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0034, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0038, code lost:
    
        return defpackage.z0.e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object e(j55 send) {
        v53 v53VarO;
        if (!s()) {
            v53 v53Var = this.queue;
            b bVar = new b(send, this);
            while (true) {
                v53 v53VarO2 = v53Var.o();
                if (!(v53VarO2 instanceof vt4)) {
                    int iW = v53VarO2.w(send, v53Var, bVar);
                    boolean z = true;
                    if (iW != 1) {
                        if (iW == 2) {
                            z = false;
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    return v53VarO2;
                }
            }
        } else {
            v53 v53Var2 = this.queue;
            do {
                v53VarO = v53Var2.o();
                if (v53VarO instanceof vt4) {
                    return v53VarO;
                }
            } while (!v53VarO.h(send, v53Var2));
            return null;
        }
    }

    public String h() {
        return "";
    }

    @Override // defpackage.l55
    public final boolean i() {
        return k() != null;
    }

    public final fd0<?> j() {
        v53 v53VarN = this.queue.n();
        fd0<?> fd0Var = v53VarN instanceof fd0 ? (fd0) v53VarN : null;
        if (fd0Var == null) {
            return null;
        }
        n(fd0Var);
        return fd0Var;
    }

    public final fd0<?> k() {
        v53 v53VarO = this.queue.o();
        fd0<?> fd0Var = v53VarO instanceof fd0 ? (fd0) v53VarO : null;
        if (fd0Var == null) {
            return null;
        }
        n(fd0Var);
        return fd0Var;
    }

    /* JADX INFO: renamed from: l, reason: from getter */
    public final t53 getQueue() {
        return this.queue;
    }

    public final String m() {
        String string;
        v53 v53VarN = this.queue.n();
        if (v53VarN == this.queue) {
            return "EmptyQueue";
        }
        if (v53VarN instanceof fd0) {
            string = v53VarN.toString();
        } else if (v53VarN instanceof tt4) {
            string = "ReceiveQueued";
        } else if (v53VarN instanceof j55) {
            string = "SendQueued";
        } else {
            string = "UNEXPECTED:" + v53VarN;
        }
        v53 v53VarO = this.queue.o();
        if (v53VarO == v53VarN) {
            return string;
        }
        String str = string + ",queueSize=" + d();
        if (!(v53VarO instanceof fd0)) {
            return str;
        }
        return str + ",closedForSend=" + v53VarO;
    }

    public final void n(fd0<?> closed) {
        Object objB = zs2.b(null, 1, null);
        while (true) {
            v53 v53VarO = closed.o();
            tt4 tt4Var = v53VarO instanceof tt4 ? (tt4) v53VarO : null;
            if (tt4Var == null) {
                break;
            } else if (tt4Var.s()) {
                objB = zs2.c(objB, tt4Var);
            } else {
                tt4Var.p();
            }
        }
        if (objB != null) {
            if (objB instanceof ArrayList) {
                ArrayList arrayList = (ArrayList) objB;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    ((tt4) arrayList.get(size)).z(closed);
                }
            } else {
                ((tt4) objB).z(closed);
            }
        }
        w(closed);
    }

    @Override // defpackage.l55
    public boolean o(Throwable cause) {
        boolean z;
        fd0<?> fd0Var = new fd0<>(cause);
        v53 v53Var = this.queue;
        while (true) {
            v53 v53VarO = v53Var.o();
            z = true;
            if (!(!(v53VarO instanceof fd0))) {
                z = false;
                break;
            }
            if (v53VarO.h(fd0Var, v53Var)) {
                break;
            }
        }
        if (!z) {
            fd0Var = (fd0) this.queue.o();
        }
        n(fd0Var);
        if (z) {
            r(cause);
        }
        return z;
    }

    public final void p(Continuation<?> continuation, E e, fd0<?> fd0Var) {
        UndeliveredElementException undeliveredElementExceptionD;
        n(fd0Var);
        Throwable thF = fd0Var.F();
        Function1<E, Unit> function1 = this.onUndeliveredElement;
        if (function1 == null || (undeliveredElementExceptionD = C1503w74.d(function1, e, null, 2, null)) == null) {
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m840constructorimpl(ResultKt.createFailure(thF)));
        } else {
            ExceptionsKt__ExceptionsKt.addSuppressed(undeliveredElementExceptionD, thF);
            Result.Companion companion2 = Result.INSTANCE;
            continuation.resumeWith(Result.m840constructorimpl(ResultKt.createFailure(undeliveredElementExceptionD)));
        }
    }

    @Override // defpackage.l55
    public final Object q(E e, Continuation<? super Unit> continuation) {
        if (v(e) == z0.b) {
            return Unit.INSTANCE;
        }
        Object objY = y(e, continuation);
        return objY == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objY : Unit.INSTANCE;
    }

    public final void r(Throwable cause) {
        yp5 yp5Var;
        Object obj = this.onCloseHandler;
        if (obj == null || obj == (yp5Var = z0.f) || !p1.a(c, this, obj, yp5Var)) {
            return;
        }
        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(cause);
    }

    public abstract boolean s();

    public abstract boolean t();

    public String toString() {
        return pv0.a(this) + '@' + pv0.b(this) + '{' + m() + '}' + h();
    }

    public final boolean u() {
        return !(this.queue.n() instanceof vt4) && t();
    }

    public Object v(E element) {
        vt4<E> vt4VarZ;
        do {
            vt4VarZ = z();
            if (vt4VarZ == null) {
                return z0.c;
            }
        } while (vt4VarZ.e(element, null) == null);
        vt4VarZ.d(element);
        return vt4VarZ.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final vt4<?> x(E element) {
        v53 v53VarO;
        t53 t53Var = this.queue;
        a aVar = new a(element);
        do {
            v53VarO = t53Var.o();
            if (v53VarO instanceof vt4) {
                return (vt4) v53VarO;
            }
        } while (!v53VarO.h(aVar, t53Var));
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object y(E e, Continuation<? super Unit> continuation) {
        Object objV;
        bz bzVarA = C1403dz.a(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        while (true) {
            if (u()) {
                j55 m55Var = this.onUndeliveredElement == null ? new m55(e, bzVarA) : new n55(e, bzVarA, this.onUndeliveredElement);
                Object objE = e(m55Var);
                if (objE == null) {
                    C1403dz.b(bzVarA, m55Var);
                    break;
                }
                if (objE instanceof fd0) {
                    p(bzVarA, e, (fd0) objE);
                    break;
                }
                if (objE != z0.e && !(objE instanceof tt4)) {
                    throw new IllegalStateException(("enqueueSend returned " + objE).toString());
                }
                objV = v(e);
                if (objV != z0.b) {
                }
            } else {
                objV = v(e);
                if (objV != z0.b) {
                    Result.Companion companion = Result.INSTANCE;
                    bzVarA.resumeWith(Result.m840constructorimpl(Unit.INSTANCE));
                    break;
                }
                if (objV != z0.c) {
                    if (!(objV instanceof fd0)) {
                        throw new IllegalStateException(("offerInternal returned " + objV).toString());
                    }
                    p(bzVarA, e, (fd0) objV);
                }
            }
        }
        Object objV2 = bzVarA.v();
        if (objV2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return objV2 == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objV2 : Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        r1 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [v53] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public vt4<E> z() {
        ?? r1;
        v53 v53VarU;
        t53 t53Var = this.queue;
        while (true) {
            r1 = (v53) t53Var.m();
            if (r1 == t53Var || !(r1 instanceof vt4)) {
                break;
            }
            if (((((vt4) r1) instanceof fd0) && !r1.r()) || (v53VarU = r1.u()) == null) {
                break;
            }
            v53VarU.q();
        }
        return (vt4) r1;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0014\u0010\u000b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lq1$a;", ExifInterface.LONGITUDE_EAST, "Lj55;", "Lv53$b;", "otherOp", "Lyp5;", "A", "", "x", "Lfd0;", "closed", "z", "", "toString", "d", "Ljava/lang/Object;", "element", "", "y", "()Ljava/lang/Object;", "pollResult", "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class a<E> extends j55 {

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        @JvmField
        public final E element;

        public a(E e) {
            this.element = e;
        }

        @Override // defpackage.j55
        public yp5 A(v53.b otherOp) {
            return cz.f16950a;
        }

        @Override // defpackage.v53
        public String toString() {
            return "SendBuffered@" + pv0.b(this) + '(' + this.element + ')';
        }

        @Override // defpackage.j55
        /* JADX INFO: renamed from: y, reason: from getter */
        public Object getElement() {
            return this.element;
        }

        @Override // defpackage.j55
        public void x() {
        }

        @Override // defpackage.j55
        public void z(fd0<?> closed) {
        }
    }

    public void w(v53 closed) {
    }
}
