package defpackage;

import com.google.zxing.NotFoundException;

/* JADX INFO: renamed from: r, reason: case insensitive filesystem */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class AbstractC1492r extends u {
    public AbstractC1492r(et etVar) {
        super(etVar);
    }

    @Override // defpackage.b1
    public String d() throws NotFoundException {
        if (c().k() != 60) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        f(sb, 5);
        j(sb, 45, 15);
        return sb.toString();
    }
}
