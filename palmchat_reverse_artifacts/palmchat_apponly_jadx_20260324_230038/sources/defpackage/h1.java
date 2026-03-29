package defpackage;

import com.google.common.hash.Funnel;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class h1 implements tg2 {
    @Override // defpackage.tg2
    public <T> tg2 a(T t, Funnel<? super T> funnel) {
        funnel.funnel(t, this);
        return this;
    }
}
