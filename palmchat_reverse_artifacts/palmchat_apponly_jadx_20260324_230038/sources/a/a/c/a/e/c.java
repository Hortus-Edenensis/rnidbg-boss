package a.a.c.a.e;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public abstract class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile T f1122a;
    public final AtomicBoolean b = new AtomicBoolean(false);

    public abstract T a(Object... objArr);

    public final T b(Object... objArr) {
        if (!this.b.get() && this.f1122a == null) {
            synchronized (this) {
                if (!this.b.get() && this.f1122a == null) {
                    this.f1122a = a(objArr);
                    this.b.set(true);
                }
            }
        }
        return this.f1122a;
    }
}
