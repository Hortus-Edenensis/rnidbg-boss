package defpackage;

import android.os.SystemClock;
import android.util.LruCache;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class y17 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22097a;
    public final long b;
    public final LruCache<String, Queue<Long>> c;

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f22098a;
        public final long b;

        public b(@IntRange(from = 0) int i, @IntRange(from = 0) long j) {
            this.f22098a = Math.max(i, 0);
            this.b = Math.max(j, 0L);
        }

        public y17 b() {
            return new y17(this);
        }
    }

    public y17(b bVar) {
        this.f22097a = bVar.f22098a;
        this.b = bVar.b;
        this.c = new LruCache<>(100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String c(String str, long j) {
        return "Chatty!!! Allow " + this.f22097a + "/" + this.b + "ms, but " + str + " request " + j + " in the recent period.";
    }

    public final long b(@NonNull Queue<Long> queue, long j) {
        while (true) {
            Long lPeek = queue.peek();
            if (lPeek == null || lPeek.longValue() >= j - this.b) {
                break;
            }
            queue.poll();
        }
        return queue.size();
    }

    public boolean d(final String str) {
        Queue<Long> queueE = e(str);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        queueE.add(Long.valueOf(jElapsedRealtime));
        final long jB = b(queueE, jElapsedRealtime);
        boolean z = jB <= ((long) this.f22097a);
        if (!z && jB % ((long) 10) == 1) {
            n87.c("FireWall", new la7() { // from class: bz6
                @Override // defpackage.la7
                public final Object get() {
                    return this.f1858a.c(str, jB);
                }
            });
        }
        return z;
    }

    @NonNull
    public final Queue<Long> e(String str) {
        Queue<Long> queue = this.c.get(str);
        if (queue != null) {
            return queue;
        }
        LinkedList linkedList = new LinkedList();
        this.c.put(str, linkedList);
        return linkedList;
    }
}
