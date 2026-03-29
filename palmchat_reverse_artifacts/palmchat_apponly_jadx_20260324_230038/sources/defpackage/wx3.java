package defpackage;

import defpackage.x25;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class wx3 extends x25 {
    public final ThreadFactory b;

    public wx3(ThreadFactory threadFactory) {
        this.b = threadFactory;
    }

    @Override // defpackage.x25
    public x25.a a() {
        return new xx3(this.b);
    }
}
