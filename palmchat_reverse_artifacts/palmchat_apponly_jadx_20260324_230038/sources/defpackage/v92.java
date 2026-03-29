package defpackage;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public final class v92 extends ScheduledThreadPoolExecutor {

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v92 f21385a = new v92();
    }

    public static v92 a() {
        return b.f21385a;
    }

    public v92() {
        super(1, new ThreadPoolExecutor.DiscardPolicy());
    }
}
