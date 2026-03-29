package defpackage;

import com.kuaishou.weapon.p0.t;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lr50;", "Ldy2;", "Lq50;", "", "cause", "", "x", "", t.l, "Ls50;", "e", "Ls50;", "childJob", "Lcy2;", "getParent", "()Lcy2;", "parent", "<init>", "(Ls50;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public final class r50 extends dy2 implements q50 {

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    @JvmField
    public final s50 childJob;

    public r50(s50 s50Var) {
        this.childJob = s50Var;
    }

    @Override // defpackage.q50
    public boolean b(Throwable cause) {
        return y().G(cause);
    }

    @Override // defpackage.q50
    public cy2 getParent() {
        return y();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        x(th);
        return Unit.INSTANCE;
    }

    @Override // defpackage.sj0
    public void x(Throwable cause) {
        this.childJob.h(y());
    }
}
