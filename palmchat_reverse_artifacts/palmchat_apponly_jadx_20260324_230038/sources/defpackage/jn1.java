package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.ads.ContentClassification;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.api.model.AdnName;
import com.qq.gdt.action.ActionUtils;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0011\b \u0018\u00002\u00020\u00012\u00020\u0002:\u000201B\u0007¢\u0006\u0004\b/\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000e\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\n\u0010\r\u001a\u00060\u000bj\u0002`\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\u00032\n\u0010\u0010\u001a\u00060\u000bj\u0002`\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u001a\u001a\u00020\u00192\n\u0010\u0010\u001a\u00060\u000bj\u0002`\fH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001e\u0010\u0005J\u0017\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010\"\u001a\u00020!2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0003H\u0002¢\u0006\u0004\b$\u0010\u0005R$\u0010*\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00198B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00198TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b+\u0010'R\u0014\u0010.\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\b¨\u00062"}, d2 = {"Ljn1;", "Lkn1;", "Lua1;", "", "shutdown", "()V", "", "K", "()J", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", WkAdxAdConfigMg.DSP_NAME_GDT, "(Ljava/lang/Runnable;)V", "now", "Ljn1$a;", "delayedTask", "N", "(JLjn1$a;)V", "M", "", "H", "(Ljava/lang/Runnable;)Z", "F", "()Ljava/lang/Runnable;", ExifInterface.LONGITUDE_EAST, "Q", "(Ljn1$a;)Z", "", "O", "(JLjn1$a;)I", "L", ActionUtils.PAYMENT_AMOUNT, "I", "()Z", "P", "(Z)V", "isCompleted", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "isEmpty", "i", "nextTime", "<init>", "a", t.l, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class jn1 extends kn1 implements ua1 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(jn1.class, Object.class, "_queue");
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(jn1.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005J\u0011\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0096\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u001e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010\u0018\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\"\u0010\"\u001a\u00020\u00078\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010#2\f\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010#8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010%\"\u0004\b&\u0010'¨\u0006)"}, d2 = {"Ljn1$a;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "", "Lne1;", "Lyw5;", AdnName.OTHER, "", "d", "", "now", "", "f", "Ljn1$b;", "delayed", "Ljn1;", "eventLoop", "e", "", "dispose", "", "toString", "a", ContentClassification.AD_CONTENT_CLASSIFICATION_J, "nanoTime", "", "_heap", "Ljava/lang/Object;", t.l, "I", "getIndex", "()I", "setIndex", "(I)V", "index", "Lxw5;", ActionUtils.PAYMENT_AMOUNT, "()Lxw5;", "c", "(Lxw5;)V", "heap", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static abstract class a implements Runnable, Comparable<a>, ne1, yw5 {
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long nanoTime;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public int index;

        @Override // defpackage.yw5
        public xw5<?> a() {
            Object obj = this._heap;
            if (obj instanceof xw5) {
                return (xw5) obj;
            }
            return null;
        }

        @Override // defpackage.yw5
        public void c(xw5<?> xw5Var) {
            if (!(this._heap != mn1.f19277a)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this._heap = xw5Var;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compareTo(a other) {
            long j = this.nanoTime - other.nanoTime;
            if (j > 0) {
                return 1;
            }
            return j < 0 ? -1 : 0;
        }

        @Override // defpackage.ne1
        public final synchronized void dispose() {
            Object obj = this._heap;
            if (obj == mn1.f19277a) {
                return;
            }
            b bVar = obj instanceof b ? (b) obj : null;
            if (bVar != null) {
                bVar.g(this);
            }
            this._heap = mn1.f19277a;
        }

        public final synchronized int e(long now, b delayed, jn1 eventLoop) {
            if (this._heap == mn1.f19277a) {
                return 2;
            }
            synchronized (delayed) {
                a aVarB = delayed.b();
                if (eventLoop.I()) {
                    return 1;
                }
                if (aVarB == null) {
                    delayed.timeNow = now;
                } else {
                    long j = aVarB.nanoTime;
                    if (j - now < 0) {
                        now = j;
                    }
                    if (now - delayed.timeNow > 0) {
                        delayed.timeNow = now;
                    }
                }
                long j2 = this.nanoTime;
                long j3 = delayed.timeNow;
                if (j2 - j3 < 0) {
                    this.nanoTime = j3;
                }
                delayed.a(this);
                return 0;
            }
        }

        public final boolean f(long now) {
            return now - this.nanoTime >= 0;
        }

        @Override // defpackage.yw5
        public int getIndex() {
            return this.index;
        }

        @Override // defpackage.yw5
        public void setIndex(int i) {
            this.index = i;
        }

        public String toString() {
            return "Delayed[nanos=" + this.nanoTime + ']';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Ljn1$b;", "Lxw5;", "Ljn1$a;", "", t.l, ContentClassification.AD_CONTENT_CLASSIFICATION_J, "timeNow", "<init>", "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class b extends xw5<a> {

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @JvmField
        public long timeNow;

        public b(long j) {
            this.timeNow = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean I() {
        return this._isCompleted;
    }

    private final void P(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    public final void E() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                if (p1.a(d, this, null, mn1.b)) {
                    return;
                }
            } else if (obj instanceof x53) {
                ((x53) obj).d();
                return;
            } else {
                if (obj == mn1.b) {
                    return;
                }
                x53 x53Var = new x53(8, true);
                x53Var.a((Runnable) obj);
                if (p1.a(d, this, obj, x53Var)) {
                    return;
                }
            }
        }
    }

    public final Runnable F() {
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof x53) {
                x53 x53Var = (x53) obj;
                Object objJ = x53Var.j();
                if (objJ != x53.h) {
                    return (Runnable) objJ;
                }
                p1.a(d, this, obj, x53Var.i());
            } else {
                if (obj == mn1.b) {
                    return null;
                }
                if (p1.a(d, this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    public void G(Runnable task) {
        if (H(task)) {
            C();
        } else {
            c51.f.G(task);
        }
    }

    public final boolean H(Runnable task) {
        while (true) {
            Object obj = this._queue;
            if (I()) {
                return false;
            }
            if (obj == null) {
                if (p1.a(d, this, null, task)) {
                    return true;
                }
            } else if (obj instanceof x53) {
                x53 x53Var = (x53) obj;
                int iA = x53Var.a(task);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    p1.a(d, this, obj, x53Var.i());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == mn1.b) {
                    return false;
                }
                x53 x53Var2 = new x53(8, true);
                x53Var2.a((Runnable) obj);
                x53Var2.a(task);
                if (p1.a(d, this, obj, x53Var2)) {
                    return true;
                }
            }
        }
    }

    public boolean J() {
        if (!q()) {
            return false;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof x53) {
                return ((x53) obj).g();
            }
            if (obj != mn1.b) {
                return false;
            }
        }
        return true;
    }

    public long K() {
        a aVarH;
        if (x()) {
            return 0L;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            a2.a();
            long jNanoTime = System.nanoTime();
            do {
                synchronized (bVar) {
                    a aVarB = bVar.b();
                    if (aVarB != null) {
                        a aVar = aVarB;
                        aVarH = aVar.f(jNanoTime) ? H(aVar) : false ? bVar.h(0) : null;
                    }
                }
            } while (aVarH != null);
        }
        Runnable runnableF = F();
        if (runnableF == null) {
            return i();
        }
        runnableF.run();
        return 0L;
    }

    public final void L() {
        a aVarI;
        a2.a();
        long jNanoTime = System.nanoTime();
        while (true) {
            b bVar = (b) this._delayed;
            if (bVar == null || (aVarI = bVar.i()) == null) {
                return;
            } else {
                B(jNanoTime, aVarI);
            }
        }
    }

    public final void M() {
        this._queue = null;
        this._delayed = null;
    }

    public final void N(long now, a delayedTask) {
        int iO = O(now, delayedTask);
        if (iO == 0) {
            if (Q(delayedTask)) {
                C();
            }
        } else if (iO == 1) {
            B(now, delayedTask);
        } else if (iO != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    public final int O(long now, a delayedTask) {
        if (I()) {
            return 1;
        }
        b bVar = (b) this._delayed;
        if (bVar == null) {
            p1.a(e, this, null, new b(now));
            Object obj = this._delayed;
            Intrinsics.checkNotNull(obj);
            bVar = (b) obj;
        }
        return delayedTask.e(now, bVar, this);
    }

    public final boolean Q(a task) {
        b bVar = (b) this._delayed;
        return (bVar != null ? bVar.e() : null) == task;
    }

    @Override // defpackage.lq0
    public final void dispatch(CoroutineContext context, Runnable block) {
        G(block);
    }

    @Override // defpackage.in1
    public long i() {
        a aVarE;
        if (super.i() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof x53)) {
                return obj == mn1.b ? Long.MAX_VALUE : 0L;
            }
            if (!((x53) obj).g()) {
                return 0L;
            }
        }
        b bVar = (b) this._delayed;
        if (bVar == null || (aVarE = bVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j = aVarE.nanoTime;
        a2.a();
        return RangesKt___RangesKt.coerceAtLeast(j - System.nanoTime(), 0L);
    }

    @Override // defpackage.in1
    public void shutdown() {
        sw5.f20863a.b();
        P(true);
        E();
        while (K() <= 0) {
        }
        L();
    }
}
