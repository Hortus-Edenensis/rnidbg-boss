package defpackage;

import com.google.common.hash.Funnel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class g1 implements qg2 {
    @Override // defpackage.qg2
    public <T> pg2 a(T t, Funnel<? super T> funnel) {
        return b().a(t, funnel).hash();
    }
}
