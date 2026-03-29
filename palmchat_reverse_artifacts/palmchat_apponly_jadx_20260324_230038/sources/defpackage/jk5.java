package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class jk5 extends j12 {
    public final long b;

    public jk5(ps1 ps1Var, long j) {
        super(ps1Var);
        vh.a(ps1Var.getPosition() >= j);
        this.b = j;
    }

    @Override // defpackage.j12, defpackage.ps1
    public long getLength() {
        return super.getLength() - this.b;
    }

    @Override // defpackage.j12, defpackage.ps1
    public long getPeekPosition() {
        return super.getPeekPosition() - this.b;
    }

    @Override // defpackage.j12, defpackage.ps1
    public long getPosition() {
        return super.getPosition() - this.b;
    }
}
