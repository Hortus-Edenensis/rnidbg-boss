package com.bytedance.sdk.openadsdk.my.u.nr;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import defpackage.wc7;
import j$.util.function.Function$CC;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u implements Function<SparseArray<Object>, Object> {
    private final ExitInstallListener u;

    public u(ExitInstallListener exitInstallListener) {
        this.u = exitInstallListener;
    }

    @Override // java.util.function.Function
    public /* synthetic */ Function andThen(Function function) {
        return Function$CC.$default$andThen(this, function);
    }

    public /* synthetic */ Function compose(Function function) {
        return Function$CC.$default$compose(this, function);
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (this.u != null && wc7.k(sparseArray).a().intValue(-99999987) == 223101) {
            this.u.onExitInstall();
        }
        return null;
    }
}
