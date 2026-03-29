package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class i16 extends h16 {
    public i16(nf6 nf6Var) {
        super(nf6Var);
    }

    @Override // defpackage.h16
    public void l(boolean z) {
        this.b.reset();
        if (!z) {
            this.b.postTranslate(this.c.I(), this.c.m() - this.c.H());
        } else {
            this.b.setTranslate(-(this.c.n() - this.c.J()), this.c.m() - this.c.H());
            this.b.postScale(-1.0f, 1.0f);
        }
    }
}
