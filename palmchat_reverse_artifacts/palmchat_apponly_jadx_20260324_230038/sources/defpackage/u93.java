package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.zenmen.palmchat.thread.worker.TaskType;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public final class u93 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f21162a = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: SearchBox */
    public class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f21163a;

        public a(Runnable runnable) {
            this.f21163a = runnable;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            l13.a(TaskType.NORMAL_TASK, this.f21163a);
            cancel();
        }
    }

    public static void a(int i, TimerTask timerTask) {
        new Timer().schedule(timerTask, i);
    }

    public static void b(int i, Runnable runnable) {
        f21162a.postDelayed(runnable, i);
    }

    public static void c(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            f21162a.post(runnable);
        }
    }

    public static void d(int i, Runnable runnable) {
        a(i, new a(runnable));
    }

    public static void e(Runnable runnable) {
        l13.a(TaskType.NORMAL_TASK, runnable);
    }
}
