package defpackage;

import defpackage.n54;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class uz4 {
    public static <T> zm5 c(n54.a<T> aVar, final dv0<T> dv0Var) {
        n54<T> n54VarI = n54.a(aVar).u(b35.c()).i(wc.a());
        Objects.requireNonNull(dv0Var);
        return n54VarI.q(new c5() { // from class: sz4
            @Override // defpackage.c5
            public final void call(Object obj) {
                dv0Var.onResponse(obj);
            }
        }, new c5() { // from class: tz4
            @Override // defpackage.c5
            public final void call(Object obj) {
                dv0Var.onResponse(null);
            }
        });
    }
}
