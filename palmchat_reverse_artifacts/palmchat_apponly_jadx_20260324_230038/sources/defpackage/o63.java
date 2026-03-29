package defpackage;

import android.os.Looper;
import java.util.logging.Level;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public interface o63 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        public static o63 a() {
            return (!vc.c() || b() == null) ? new b() : new vc("EventBus");
        }

        public static Object b() {
            try {
                return Looper.getMainLooper();
            } catch (RuntimeException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements o63 {
        @Override // defpackage.o63
        public void a(Level level, String str) {
            System.out.println("[" + level + "] " + str);
        }

        @Override // defpackage.o63
        public void b(Level level, String str, Throwable th) {
            System.out.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    void a(Level level, String str);

    void b(Level level, String str, Throwable th);
}
