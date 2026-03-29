package org.greenrobot.greendao.rx;

import defpackage.n54;
import defpackage.r42;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Internal;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
@Internal
class RxUtils {
    @Internal
    public static <T> n54<T> fromCallable(final Callable<T> callable) {
        return n54.b(new r42<n54<T>>() { // from class: org.greenrobot.greendao.rx.RxUtils.1
            @Override // defpackage.r42, java.util.concurrent.Callable
            public n54<T> call() {
                try {
                    return n54.f(callable.call());
                } catch (Exception e) {
                    return n54.e(e);
                }
            }
        });
    }
}
