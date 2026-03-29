package defpackage;

import android.content.Context;
import android.os.Handler;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class zc7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<rl7> f22395a;

    public zc7(Handler handler, Context context) {
        ArrayList arrayList = new ArrayList(3);
        this.f22395a = arrayList;
        arrayList.add(new pi7(handler, 0L, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS));
    }

    public static zc7 a(Handler handler, Context context) {
        return new zc7(handler, context);
    }

    public void b() {
        mf7.b("[ScheduleTaskManager] execute, task size=" + this.f22395a.size());
        Iterator<rl7> it = this.f22395a.iterator();
        while (it.hasNext()) {
            try {
                it.next().c();
            } catch (Throwable unused) {
            }
        }
    }
}
