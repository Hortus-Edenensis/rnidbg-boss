package org.greenrobot.greendao.rx;

import defpackage.n54;
import defpackage.sm5;
import defpackage.x25;
import defpackage.yn1;
import java.util.List;
import java.util.concurrent.Callable;
import org.greenrobot.greendao.annotation.apihint.Experimental;
import org.greenrobot.greendao.query.LazyList;
import org.greenrobot.greendao.query.Query;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
@Experimental
public class RxQuery<T> extends RxBase {
    private final Query<T> query;

    public RxQuery(Query<T> query) {
        this.query = query;
    }

    @Override // org.greenrobot.greendao.rx.RxBase
    @Experimental
    public /* bridge */ /* synthetic */ x25 getScheduler() {
        return super.getScheduler();
    }

    @Experimental
    public n54<List<T>> list() {
        return (n54<List<T>>) wrap(new Callable<List<T>>() { // from class: org.greenrobot.greendao.rx.RxQuery.1
            @Override // java.util.concurrent.Callable
            public List<T> call() throws Exception {
                return RxQuery.this.query.forCurrentThread().list();
            }
        });
    }

    public n54<T> oneByOne() {
        return (n54<T>) wrap(n54.a(new n54.a<T>() { // from class: org.greenrobot.greendao.rx.RxQuery.3
            @Override // defpackage.c5
            public void call(sm5<? super T> sm5Var) {
                try {
                    LazyList<T> lazyListListLazyUncached = RxQuery.this.query.forCurrentThread().listLazyUncached();
                    try {
                        for (T t : lazyListListLazyUncached) {
                            if (sm5Var.isUnsubscribed()) {
                                break;
                            } else {
                                sm5Var.onNext(t);
                            }
                        }
                        lazyListListLazyUncached.close();
                        if (sm5Var.isUnsubscribed()) {
                            return;
                        }
                        sm5Var.onCompleted();
                    } catch (Throwable th) {
                        lazyListListLazyUncached.close();
                        throw th;
                    }
                } catch (Throwable th2) {
                    yn1.d(th2);
                    sm5Var.onError(th2);
                }
            }
        }));
    }

    @Experimental
    public n54<T> unique() {
        return (n54<T>) wrap(new Callable<T>() { // from class: org.greenrobot.greendao.rx.RxQuery.2
            @Override // java.util.concurrent.Callable
            public T call() throws Exception {
                return RxQuery.this.query.forCurrentThread().unique();
            }
        });
    }

    public RxQuery(Query<T> query, x25 x25Var) {
        super(x25Var);
        this.query = query;
    }
}
