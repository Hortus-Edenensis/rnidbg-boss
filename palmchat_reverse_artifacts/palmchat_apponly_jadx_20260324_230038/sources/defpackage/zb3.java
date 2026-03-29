package defpackage;

import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0005R\u0014\u0010\n\u001a\u00020\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lzb3;", "Llq0;", "", "toString", "", "parallelism", "limitedParallelism", "f", "d", "()Lzb3;", "immediate", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0})
public abstract class zb3 extends lq0 {
    public abstract zb3 d();

    public final String f() {
        zb3 zb3VarD;
        zb3 zb3VarC = he1.c();
        if (this == zb3VarC) {
            return "Dispatchers.Main";
        }
        try {
            zb3VarD = zb3VarC.d();
        } catch (UnsupportedOperationException unused) {
            zb3VarD = null;
        }
        if (this == zb3VarD) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // defpackage.lq0
    public lq0 limitedParallelism(int parallelism) {
        n23.a(parallelism);
        return this;
    }

    @Override // defpackage.lq0
    public String toString() {
        String strF = f();
        if (strF != null) {
            return strF;
        }
        return pv0.a(this) + '@' + pv0.b(this);
    }
}
