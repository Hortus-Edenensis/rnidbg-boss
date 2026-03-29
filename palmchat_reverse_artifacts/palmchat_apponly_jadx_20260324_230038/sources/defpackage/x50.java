package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class x50 implements Loader.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f21879a = m43.a();
    public final b b;
    public final int c;
    public final m d;
    public final int e;

    @Nullable
    public final Object f;
    public final long g;
    public final long h;
    public final rk5 i;

    public x50(a aVar, b bVar, int i, m mVar, int i2, @Nullable Object obj, long j, long j2) {
        this.i = new rk5(aVar);
        this.b = (b) vh.e(bVar);
        this.c = i;
        this.d = mVar;
        this.e = i2;
        this.f = obj;
        this.g = j;
        this.h = j2;
    }

    public final long a() {
        return this.i.c();
    }

    public final long b() {
        return this.h - this.g;
    }

    public final Map<String, List<String>> c() {
        return this.i.e();
    }

    public final Uri d() {
        return this.i.d();
    }
}
