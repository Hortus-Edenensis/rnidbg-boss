package defpackage;

import com.cdo.oaps.ad.Launcher;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00010\u0002:\u0004\b\n\u000f\u0005B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lht3;", "Lgt3;", "", "owner", "", "d", "(Ljava/lang/Object;)Z", "", "a", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", t.l, "(Ljava/lang/Object;)V", "", "toString", "()Ljava/lang/String;", "c", "locked", "<init>", "(Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class ht3 implements gt3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f18047a = AtomicReferenceFieldUpdater.newUpdater(ht3.class, Object.class, "_state");
    volatile /* synthetic */ Object _state;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0011"}, d2 = {"Lht3$a;", "Lht3$b;", "Lht3;", "", "z", "", "x", "", "toString", "Laz;", "g", "Laz;", "cont", "", "owner", "<init>", "(Lht3;Ljava/lang/Object;Laz;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public final class a extends b {

        /* JADX INFO: renamed from: g, reason: from kotlin metadata */
        public final az<Unit> cont;

        /* JADX INFO: renamed from: ht3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", o.f, "", Launcher.Method.INVOKE_CALLBACK}, k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class C1208a extends Lambda implements Function1<Throwable, Unit> {
            public final /* synthetic */ ht3 b;
            public final /* synthetic */ a c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1208a(ht3 ht3Var, a aVar) {
                super(1);
                this.b = ht3Var;
                this.c = aVar;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                this.b.b(this.c.owner);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Object obj, az<? super Unit> azVar) {
            super(obj);
            this.cont = azVar;
        }

        @Override // defpackage.v53
        public String toString() {
            return "LockCont[" + this.owner + ", " + this.cont + "] for " + ht3.this;
        }

        @Override // ht3.b
        public void x() {
            this.cont.j(cz.f16950a);
        }

        @Override // ht3.b
        public boolean z() {
            return y() && this.cont.n(Unit.INSTANCE, null, new C1208a(ht3.this, this)) != null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0006\b¢\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0003H&¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lht3$b;", "Lv53;", "Lne1;", "", "y", "()Z", "", "dispose", "()V", "z", "x", "", "d", "Ljava/lang/Object;", "owner", "<init>", "(Lht3;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public abstract class b extends v53 implements ne1 {
        public static final /* synthetic */ AtomicIntegerFieldUpdater f = AtomicIntegerFieldUpdater.newUpdater(b.class, "isTaken");

        /* JADX INFO: renamed from: d, reason: from kotlin metadata */
        @JvmField
        public final Object owner;
        private volatile /* synthetic */ int isTaken = 0;

        public b(Object obj) {
            this.owner = obj;
        }

        @Override // defpackage.ne1
        public final void dispose() {
            s();
        }

        public abstract void x();

        public final boolean y() {
            return f.compareAndSet(this, 0, 1);
        }

        public abstract boolean z();
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lht3$c;", "Lt53;", "", "toString", "", "owner", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class c extends t53 {

        @JvmField
        public volatile Object owner;

        public c(Object obj) {
            this.owner = obj;
        }

        @Override // defpackage.v53
        public String toString() {
            return "LockedQueue[" + this.owner + ']';
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lht3$d;", "Lzi;", "Lht3;", "affected", "", "i", "failure", "", "h", "Lht3$c;", t.l, "Lht3$c;", "queue", "<init>", "(Lht3$c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class d extends zi<ht3> {

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @JvmField
        public final c queue;

        public d(c cVar) {
            this.queue = cVar;
        }

        @Override // defpackage.zi
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(ht3 affected, Object failure) {
            p1.a(ht3.f18047a, affected, this, failure == null ? it3.f : this.queue);
        }

        @Override // defpackage.zi
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(ht3 affected) {
            if (this.queue.x()) {
                return null;
            }
            return it3.b;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", o.f, "", Launcher.Method.INVOKE_CALLBACK}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class e extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ Object c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Object obj) {
            super(1);
            this.c = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            ht3.this.b(this.c);
        }
    }

    public ht3(boolean z) {
        this._state = z ? it3.e : it3.f;
    }

    @Override // defpackage.gt3
    public Object a(Object obj, Continuation<? super Unit> continuation) {
        if (d(obj)) {
            return Unit.INSTANCE;
        }
        Object objC = c(obj, continuation);
        return objC == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objC : Unit.INSTANCE;
    }

    @Override // defpackage.gt3
    public void b(Object owner) {
        while (true) {
            Object obj = this._state;
            if (obj instanceof yl1) {
                if (owner == null) {
                    if (!(((yl1) obj).locked != it3.d)) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    yl1 yl1Var = (yl1) obj;
                    if (!(yl1Var.locked == owner)) {
                        throw new IllegalStateException(("Mutex is locked by " + yl1Var.locked + " but expected " + owner).toString());
                    }
                }
                if (p1.a(f18047a, this, obj, it3.f)) {
                    return;
                }
            } else if (obj instanceof d84) {
                ((d84) obj).c(this);
            } else {
                if (!(obj instanceof c)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                if (owner != null) {
                    c cVar = (c) obj;
                    if (!(cVar.owner == owner)) {
                        throw new IllegalStateException(("Mutex is locked by " + cVar.owner + " but expected " + owner).toString());
                    }
                }
                c cVar2 = (c) obj;
                v53 v53VarT = cVar2.t();
                if (v53VarT == null) {
                    d dVar = new d(cVar2);
                    if (p1.a(f18047a, this, obj, dVar) && dVar.c(this) == null) {
                        return;
                    }
                } else {
                    b bVar = (b) v53VarT;
                    if (bVar.z()) {
                        Object obj2 = bVar.owner;
                        if (obj2 == null) {
                            obj2 = it3.c;
                        }
                        cVar2.owner = obj2;
                        bVar.x();
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x006e, code lost:
    
        defpackage.C1403dz.b(r0, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0071, code lost:
    
        r7 = r0.v();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0079, code lost:
    
        if (r7 != kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007b, code lost:
    
        kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
    
        if (r7 != kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0084, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0087, code lost:
    
        return kotlin.Unit.INSTANCE;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object c(Object obj, Continuation<? super Unit> continuation) {
        bz bzVarA = C1403dz.a(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        a aVar = new a(obj, bzVarA);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof yl1) {
                yl1 yl1Var = (yl1) obj2;
                if (yl1Var.locked != it3.d) {
                    p1.a(f18047a, this, obj2, new c(yl1Var.locked));
                } else {
                    if (p1.a(f18047a, this, obj2, obj == null ? it3.e : new yl1(obj))) {
                        bzVarA.d(Unit.INSTANCE, new e(obj));
                        break;
                    }
                }
            } else if (obj2 instanceof c) {
                c cVar = (c) obj2;
                if (!(cVar.owner != obj)) {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
                cVar.g(aVar);
                if (this._state == obj2 || !aVar.y()) {
                    break;
                }
                aVar = new a(obj, bzVarA);
            } else {
                if (!(obj2 instanceof d84)) {
                    throw new IllegalStateException(("Illegal state " + obj2).toString());
                }
                ((d84) obj2).c(this);
            }
        }
    }

    public boolean d(Object owner) {
        while (true) {
            Object obj = this._state;
            if (obj instanceof yl1) {
                if (((yl1) obj).locked != it3.d) {
                    return false;
                }
                if (p1.a(f18047a, this, obj, owner == null ? it3.e : new yl1(owner))) {
                    return true;
                }
            } else {
                if (obj instanceof c) {
                    if (((c) obj).owner != owner) {
                        return false;
                    }
                    throw new IllegalStateException(("Already locked by " + owner).toString());
                }
                if (!(obj instanceof d84)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                ((d84) obj).c(this);
            }
        }
    }

    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof yl1) {
                return "Mutex[" + ((yl1) obj).locked + ']';
            }
            if (!(obj instanceof d84)) {
                if (!(obj instanceof c)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                return "Mutex[" + ((c) obj).owner + ']';
            }
            ((d84) obj).c(this);
        }
    }
}
