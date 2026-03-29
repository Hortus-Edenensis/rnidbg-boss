package defpackage;

import com.cdo.oaps.ad.OapsKey;
import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\bR(\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0005`\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lsw5;", "", "", t.l, "()V", "Lin1;", "eventLoop", "c", "(Lin1;)V", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "Ljava/lang/ThreadLocal;", OapsKey.KEY_REF, "a", "()Lin1;", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class sw5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sw5 f20863a = new sw5();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static final ThreadLocal<in1> ref = new ThreadLocal<>();

    public final in1 a() {
        ThreadLocal<in1> threadLocal = ref;
        in1 in1Var = threadLocal.get();
        if (in1Var != null) {
            return in1Var;
        }
        in1 in1VarA = ln1.a();
        threadLocal.set(in1VarA);
        return in1VarA;
    }

    public final void b() {
        ref.set(null);
    }

    public final void c(in1 eventLoop) {
        ref.set(eventLoop);
    }
}
