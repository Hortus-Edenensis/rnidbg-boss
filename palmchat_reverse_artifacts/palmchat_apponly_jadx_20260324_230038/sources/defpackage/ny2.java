package defpackage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lny2;", "Lsj0;", "Lne1;", "Lks2;", "", "dispose", "", "toString", "Loy2;", "d", "Loy2;", "y", "()Loy2;", "z", "(Loy2;)V", "job", "", "isActive", "()Z", "Lpy3;", "c", "()Lpy3;", "list", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class ny2 extends sj0 implements ne1, ks2 {

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public oy2 job;

    @Override // defpackage.ks2
    /* JADX INFO: renamed from: c */
    public py3 getList() {
        return null;
    }

    @Override // defpackage.ne1
    public void dispose() {
        y().m0(this);
    }

    @Override // defpackage.ks2
    /* JADX INFO: renamed from: isActive */
    public boolean getIsActive() {
        return true;
    }

    @Override // defpackage.v53
    public String toString() {
        return pv0.a(this) + '@' + pv0.b(this) + "[job@" + pv0.b(y()) + ']';
    }

    public final oy2 y() {
        oy2 oy2Var = this.job;
        if (oy2Var != null) {
            return oy2Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("job");
        return null;
    }

    public final void z(oy2 oy2Var) {
        this.job = oy2Var;
    }
}
