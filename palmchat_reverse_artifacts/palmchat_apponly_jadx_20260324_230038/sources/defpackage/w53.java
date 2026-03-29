package defpackage;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p0.t;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u000f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lw53;", "", ExifInterface.LONGITUDE_EAST, "", t.l, "()V", "element", "", "a", "(Ljava/lang/Object;)Z", "d", "()Ljava/lang/Object;", "", "c", "()I", "size", "singleConsumer", "<init>", "(Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public class w53<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f21626a = AtomicReferenceFieldUpdater.newUpdater(w53.class, Object.class, "_cur");
    private volatile /* synthetic */ Object _cur;

    public w53(boolean z) {
        this._cur = new x53(8, z);
    }

    public final boolean a(E element) {
        while (true) {
            x53 x53Var = (x53) this._cur;
            int iA = x53Var.a(element);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                p1.a(f21626a, this, x53Var, x53Var.i());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            x53 x53Var = (x53) this._cur;
            if (x53Var.d()) {
                return;
            } else {
                p1.a(f21626a, this, x53Var, x53Var.i());
            }
        }
    }

    public final int c() {
        return ((x53) this._cur).f();
    }

    public final E d() {
        while (true) {
            x53 x53Var = (x53) this._cur;
            E e = (E) x53Var.j();
            if (e != x53.h) {
                return e;
            }
            p1.a(f21626a, this, x53Var, x53Var.i());
        }
    }
}
