package defpackage;

import android.content.Context;
import android.os.Handler;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class v07 extends iv6 {
    public static Runnable d = new a();

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            ih7.b().a().removeCallbacks(this);
            ih7.b().e(new v07(ih7.b().a(), 0L, 30000L, x97.m()));
        }
    }

    public v07(Handler handler, long j, long j2, Context context) {
        super(handler, j, j2);
    }

    public static void e() {
        ih7.b().f(d, 100L);
    }

    @Override // java.lang.Runnable
    public void run() {
        Map<String, Object> mapD;
        try {
            mapD = x97.a().d();
        } catch (Throwable unused) {
            mapD = null;
        }
        try {
            xi7.d().f(mapD, s07.j());
        } catch (Throwable unused2) {
        }
    }
}
