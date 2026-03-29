package defpackage;

import android.content.Context;
import android.os.Handler;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class x77 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<iv6> f21896a = new ArrayList(3);

    public x77(Handler handler, Context context) {
        if (kv6.k(context)) {
            this.f21896a.add(new t37(handler, 0L, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS));
        }
    }

    public static x77 a(Handler handler, Context context) {
        return new x77(handler, context);
    }

    public void b() {
        kj7.a("[ScheduleTaskManager] execute, task size=" + this.f21896a.size());
        Iterator<iv6> it = this.f21896a.iterator();
        while (it.hasNext()) {
            try {
                it.next().a();
            } catch (Throwable unused) {
            }
        }
    }
}
