package defpackage;

import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.b;
import java.util.Comparator;
import java.util.TreeSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class z13 implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f22321a;
    public final TreeSet<nw> b = new TreeSet<>(new Comparator() { // from class: w13
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return z13.f((nw) obj, (nw) obj2);
        }
    });
    public long c;

    public z13(long j) {
        this.f22321a = j;
    }

    public static int f(nw nwVar, nw nwVar2) {
        long j = nwVar.f;
        long j2 = nwVar2.f;
        return j - j2 == 0 ? nwVar.compareTo(nwVar2) : j < j2 ? -1 : 1;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void a(Cache cache, nw nwVar, nw nwVar2) {
        d(cache, nwVar);
        c(cache, nwVar2);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.b
    public void b(Cache cache, String str, long j, long j2) {
        if (j2 != -1) {
            g(cache, j2);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void c(Cache cache, nw nwVar) {
        this.b.add(nwVar);
        this.c += nwVar.c;
        g(cache, 0L);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache.a
    public void d(Cache cache, nw nwVar) {
        this.b.remove(nwVar);
        this.c -= nwVar.c;
    }

    public final void g(Cache cache, long j) {
        while (this.c + j > this.f22321a && !this.b.isEmpty()) {
            cache.a(this.b.first());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.b
    public boolean requiresCacheSpanTouches() {
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.b
    public void onCacheInitialized() {
    }
}
