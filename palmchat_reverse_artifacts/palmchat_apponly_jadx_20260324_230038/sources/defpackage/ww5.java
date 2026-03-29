package defpackage;

import com.zenmen.palmchat.thread.worker.TaskType;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ww5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ww5 f21825a;

    public static ww5 b() {
        if (f21825a == null) {
            synchronized (ww5.class) {
                if (f21825a == null) {
                    f21825a = new ww5();
                }
            }
        }
        return f21825a;
    }

    public Executor a() {
        return l13.b(TaskType.CACHE);
    }
}
