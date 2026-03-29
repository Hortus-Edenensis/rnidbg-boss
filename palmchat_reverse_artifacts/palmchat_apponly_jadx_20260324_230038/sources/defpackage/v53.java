package defpackage;

import com.amap.api.col.p0002sl.hb;
import com.kuaishou.weapon.p0.t;
import com.lantern.core.configuration.ConfigConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0017\u0018\u00002\u00020\u0001:\u000212B\u0007¢\u0006\u0004\b0\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00060\u0000j\u0002`\u00052\n\u0010\u0006\u001a\u00060\u0000j\u0002`\u0005H\u0082\u0010¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\n2\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u000f\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0082\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\n2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u0005¢\u0006\u0004\b\u0015\u0010\fJ'\u0010\u0016\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u0005H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J/\u0010\u001b\u001a\u00020\u001a2\n\u0010\u0011\u001a\u00060\u0000j\u0002`\u00052\n\u0010\t\u001a\u00060\u0000j\u0002`\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005H\u0001¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\n¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\nH\u0001¢\u0006\u0004\b#\u0010\"J\u0015\u0010$\u001a\n\u0018\u00010\u0000j\u0004\u0018\u0001`\u0005¢\u0006\u0004\b$\u0010 J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u001eR\u0011\u0010\t\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0015\u0010-\u001a\u00060\u0000j\u0002`\u00058F¢\u0006\u0006\u001a\u0004\b,\u0010 R\u0015\u0010/\u001a\u00060\u0000j\u0002`\u00058F¢\u0006\u0006\u001a\u0004\b.\u0010 ¨\u00063"}, d2 = {"Lv53;", "", "Lkv4;", "v", "()Lkv4;", "Lkotlinx/coroutines/internal/Node;", "current", t.f7496a, "(Lv53;)Lv53;", "next", "", "l", "(Lv53;)V", "Ld84;", ConfigConstant.COLUMN_OP, hb.j, "(Ld84;)Lv53;", "node", "", "i", "(Lv53;)Z", "g", "h", "(Lv53;Lv53;)Z", "Lv53$a;", "condAdd", "", RXScreenCaptureService.KEY_WIDTH, "(Lv53;Lv53;Lv53$a;)I", "s", "()Z", "u", "()Lv53;", "p", "()V", "q", "t", "", "toString", "()Ljava/lang/String;", t.k, "isRemoved", "m", "()Ljava/lang/Object;", "n", "nextNode", "o", "prevNode", "<init>", "a", t.l, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class v53 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f21360a = AtomicReferenceFieldUpdater.newUpdater(v53.class, Object.class, "_next");
    public static final /* synthetic */ AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(v53.class, Object.class, "_prev");
    public static final /* synthetic */ AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(v53.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b!\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0013\u0012\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\b\u001a\u00020\u00072\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0018\u0010\u000b\u001a\u00060\u0002j\u0002`\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\r\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\n¨\u0006\u0010"}, d2 = {"Lv53$a;", "Lzi;", "Lv53;", "Lkotlinx/coroutines/internal/Node;", "affected", "", "failure", "", "h", t.l, "Lv53;", "newNode", "c", "oldNext", "<init>", "(Lv53;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    @PublishedApi
    public static abstract class a extends zi<v53> {

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        @JvmField
        public final v53 newNode;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        @JvmField
        public v53 oldNext;

        public a(v53 v53Var) {
            this.newNode = v53Var;
        }

        @Override // defpackage.zi
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(v53 affected, Object failure) {
            boolean z = failure == null;
            v53 v53Var = z ? this.newNode : this.oldNext;
            if (v53Var != null && p1.a(v53.f21360a, affected, this, v53Var) && z) {
                v53 v53Var2 = this.newNode;
                v53 v53Var3 = this.oldNext;
                Intrinsics.checkNotNull(v53Var3);
                v53Var2.l(v53Var3);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lv53$b;", "Ld84;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
    public static final class b extends d84 {
    }

    public final void g(v53 node) {
        while (!o().h(node, this)) {
        }
    }

    @PublishedApi
    public final boolean h(v53 node, v53 next) {
        b.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21360a;
        atomicReferenceFieldUpdater.lazySet(node, next);
        if (!p1.a(atomicReferenceFieldUpdater, this, next, node)) {
            return false;
        }
        node.l(next);
        return true;
    }

    public final boolean i(v53 node) {
        b.lazySet(node, this);
        f21360a.lazySet(node, this);
        while (m() == this) {
            if (p1.a(f21360a, this, this, node)) {
                node.l(this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0048, code lost:
    
        if (defpackage.p1.a(defpackage.v53.f21360a, r3, r2, ((defpackage.kv4) r4).f18837a) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final v53 j(d84 op) {
        while (true) {
            v53 v53Var = (v53) this._prev;
            v53 v53Var2 = v53Var;
            while (true) {
                v53 v53Var3 = null;
                while (true) {
                    Object obj = v53Var2._next;
                    if (obj == this) {
                        if (v53Var == v53Var2) {
                            return v53Var2;
                        }
                        if (p1.a(b, this, v53Var, v53Var2)) {
                            return v53Var2;
                        }
                    } else {
                        if (r()) {
                            return null;
                        }
                        if (obj == op) {
                            return v53Var2;
                        }
                        if (obj instanceof d84) {
                            if (op != null && op.b((d84) obj)) {
                                return null;
                            }
                            ((d84) obj).c(v53Var2);
                        } else if (!(obj instanceof kv4)) {
                            v53Var3 = v53Var2;
                            v53Var2 = (v53) obj;
                        } else {
                            if (v53Var3 != null) {
                                break;
                            }
                            v53Var2 = (v53) v53Var2._prev;
                        }
                    }
                }
                v53Var2 = v53Var3;
            }
        }
    }

    public final v53 k(v53 current) {
        while (current.r()) {
            current = (v53) current._prev;
        }
        return current;
    }

    public final void l(v53 next) {
        v53 v53Var;
        do {
            v53Var = (v53) next._prev;
            if (m() != next) {
                return;
            }
        } while (!p1.a(b, next, v53Var, this));
        if (r()) {
            next.j(null);
        }
    }

    public final Object m() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof d84)) {
                return obj;
            }
            ((d84) obj).c(this);
        }
    }

    public final v53 n() {
        return u53.b(m());
    }

    public final v53 o() {
        v53 v53VarJ = j(null);
        return v53VarJ == null ? k((v53) this._prev) : v53VarJ;
    }

    public final void p() {
        ((kv4) m()).ref.q();
    }

    @PublishedApi
    public final void q() {
        v53 v53Var = this;
        while (true) {
            Object objM = v53Var.m();
            if (!(objM instanceof kv4)) {
                v53Var.j(null);
                return;
            }
            v53Var = ((kv4) objM).ref;
        }
    }

    public boolean r() {
        return m() instanceof kv4;
    }

    public boolean s() {
        return u() == null;
    }

    public final v53 t() {
        while (true) {
            v53 v53Var = (v53) m();
            if (v53Var == this) {
                return null;
            }
            if (v53Var.s()) {
                return v53Var;
            }
            v53Var.p();
        }
    }

    public String toString() {
        return new PropertyReference0Impl(this) { // from class: v53.c
            @Override // kotlin.jvm.internal.PropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return pv0.a(this.receiver);
            }
        } + '@' + pv0.b(this);
    }

    @PublishedApi
    public final v53 u() {
        Object objM;
        v53 v53Var;
        do {
            objM = m();
            if (objM instanceof kv4) {
                return ((kv4) objM).ref;
            }
            if (objM == this) {
                return (v53) objM;
            }
            v53Var = (v53) objM;
        } while (!p1.a(f21360a, this, objM, v53Var.v()));
        v53Var.j(null);
        return null;
    }

    public final kv4 v() {
        kv4 kv4Var = (kv4) this._removedRef;
        if (kv4Var != null) {
            return kv4Var;
        }
        kv4 kv4Var2 = new kv4(this);
        c.lazySet(this, kv4Var2);
        return kv4Var2;
    }

    @PublishedApi
    public final int w(v53 node, v53 next, a condAdd) {
        b.lazySet(node, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f21360a;
        atomicReferenceFieldUpdater.lazySet(node, next);
        condAdd.oldNext = next;
        if (p1.a(atomicReferenceFieldUpdater, this, next, condAdd)) {
            return condAdd.c(this) == null ? 1 : 2;
        }
        return 0;
    }
}
