package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class n extends AbstractC1492r {
    public n(et etVar) {
        super(etVar);
    }

    @Override // defpackage.u
    public void h(StringBuilder sb, int i) {
        if (i < 10000) {
            sb.append("(3202)");
        } else {
            sb.append("(3203)");
        }
    }

    @Override // defpackage.u
    public int i(int i) {
        return i < 10000 ? i : i - 10000;
    }
}
