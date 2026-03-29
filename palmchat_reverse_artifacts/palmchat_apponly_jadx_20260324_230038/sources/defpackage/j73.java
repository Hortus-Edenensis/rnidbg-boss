package defpackage;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class j73 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qo5<i73> f18339a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements qo5<i73> {
        @Override // defpackage.qo5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public i73 get() {
            return new k73();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements qo5<i73> {
        @Override // defpackage.qo5
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public i73 get() {
            return new c(null);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends AtomicLong implements i73 {
        public c() {
        }

        @Override // defpackage.i73
        public long b() {
            return get();
        }

        @Override // defpackage.i73
        public void c(long j) {
            getAndAdd(j);
        }

        @Override // defpackage.i73
        public void o() {
            getAndIncrement();
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    static {
        qo5<i73> bVar;
        try {
            new k73();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        f18339a = bVar;
    }

    public static i73 a() {
        return f18339a.get();
    }
}
