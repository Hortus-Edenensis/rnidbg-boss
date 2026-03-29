package defpackage;

import android.os.Handler;
import androidx.annotation.Nullable;
import defpackage.dp;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface dp {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {

        /* JADX INFO: renamed from: dp$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static final class C1184a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CopyOnWriteArrayList<C1185a> f17107a = new CopyOnWriteArrayList<>();

            /* JADX INFO: renamed from: dp$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public static final class C1185a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final Handler f17108a;
                public final a b;
                public boolean c;

                public C1185a(Handler handler, a aVar) {
                    this.f17108a = handler;
                    this.b = aVar;
                }

                public void d() {
                    this.c = true;
                }
            }

            public static /* synthetic */ void d(C1185a c1185a, int i, long j, long j2) {
                c1185a.b.onBandwidthSample(i, j, j2);
            }

            public void b(Handler handler, a aVar) {
                vh.e(handler);
                vh.e(aVar);
                e(aVar);
                this.f17107a.add(new C1185a(handler, aVar));
            }

            public void c(final int i, final long j, final long j2) {
                for (final C1185a c1185a : this.f17107a) {
                    if (!c1185a.c) {
                        c1185a.f17108a.post(new Runnable() { // from class: cp
                            @Override // java.lang.Runnable
                            public final void run() {
                                dp.a.C1184a.d(c1185a, i, j, j2);
                            }
                        });
                    }
                }
            }

            public void e(a aVar) {
                for (C1185a c1185a : this.f17107a) {
                    if (c1185a.b == aVar) {
                        c1185a.d();
                        this.f17107a.remove(c1185a);
                    }
                }
            }
        }

        void onBandwidthSample(int i, long j, long j2);
    }

    void d(a aVar);

    void e(Handler handler, a aVar);

    long getBitrateEstimate();

    long getTimeToFirstByteEstimateUs();

    @Nullable
    u06 getTransferListener();
}
