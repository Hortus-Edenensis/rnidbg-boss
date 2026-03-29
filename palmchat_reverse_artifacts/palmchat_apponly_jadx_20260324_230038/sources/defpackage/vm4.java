package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class vm4 implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f21481a;
    public final PriorityTaskManager b;
    public final int c;

    public vm4(a aVar, PriorityTaskManager priorityTaskManager, int i) {
        this.f21481a = (a) vh.e(aVar);
        this.b = (PriorityTaskManager) vh.e(priorityTaskManager);
        this.c = i;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws IOException {
        this.b.b(this.c);
        return this.f21481a.a(bVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void b(u06 u06Var) {
        vh.e(u06Var);
        this.f21481a.b(u06Var);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        this.f21481a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> getResponseHeaders() {
        return this.f21481a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri getUri() {
        return this.f21481a.getUri();
    }

    @Override // defpackage.ru0
    public int read(byte[] bArr, int i, int i2) throws IOException {
        this.b.b(this.c);
        return this.f21481a.read(bArr, i, i2);
    }
}
