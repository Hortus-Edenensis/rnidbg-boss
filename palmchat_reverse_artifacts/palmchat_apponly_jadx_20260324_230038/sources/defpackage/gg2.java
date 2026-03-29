package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.api.model.AdnName;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B#\b\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\b$\u0010%B\u001d\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b$\u0010&J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001c\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u001c\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\t\u001a\u00060\u0007j\u0002`\bH\u0002R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001a\u0010#\u001a\u00020\u00008\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010\u001f\u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lgg2;", "Lhg2;", "Lua1;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "isDispatchNeeded", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "", "dispatch", "", "toString", "", AdnName.OTHER, "equals", "", "hashCode", "g", "Landroid/os/Handler;", "a", "Landroid/os/Handler;", "handler", t.l, "Ljava/lang/String;", "name", "c", "Z", "invokeImmediately", "_immediate", "Lgg2;", "d", "i", "()Lgg2;", "immediate", "<init>", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "(Landroid/os/Handler;Ljava/lang/String;)V", "kotlinx-coroutines-android"}, k = 1, mv = {1, 6, 0})
public final class gg2 extends hg2 {
    private volatile gg2 _immediate;

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final Handler handler;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String name;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final boolean invokeImmediately;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final gg2 immediate;

    public gg2(Handler handler, String str, boolean z) {
        super(null);
        this.handler = handler;
        this.name = str;
        this.invokeImmediately = z;
        this._immediate = z ? this : null;
        gg2 gg2Var = this._immediate;
        if (gg2Var == null) {
            gg2Var = new gg2(handler, str, true);
            this._immediate = gg2Var;
        }
        this.immediate = gg2Var;
    }

    @Override // defpackage.lq0
    public void dispatch(CoroutineContext context, Runnable block) {
        if (this.handler.post(block)) {
            return;
        }
        g(context, block);
    }

    public boolean equals(Object other) {
        return (other instanceof gg2) && ((gg2) other).handler == this.handler;
    }

    public final void g(CoroutineContext context, Runnable block) {
        ly2.a(context, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        he1.b().dispatch(context, block);
    }

    public int hashCode() {
        return System.identityHashCode(this.handler);
    }

    @Override // defpackage.zb3
    /* JADX INFO: renamed from: i, reason: from getter and merged with bridge method [inline-methods] */
    public gg2 d() {
        return this.immediate;
    }

    @Override // defpackage.lq0
    public boolean isDispatchNeeded(CoroutineContext context) {
        return (this.invokeImmediately && Intrinsics.areEqual(Looper.myLooper(), this.handler.getLooper())) ? false : true;
    }

    @Override // defpackage.zb3, defpackage.lq0
    public String toString() {
        String strF = f();
        if (strF != null) {
            return strF;
        }
        String string = this.name;
        if (string == null) {
            string = this.handler.toString();
        }
        if (!this.invokeImmediately) {
            return string;
        }
        return string + ".immediate";
    }

    public /* synthetic */ gg2(Handler handler, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public gg2(Handler handler, String str) {
        this(handler, str, false);
    }
}
