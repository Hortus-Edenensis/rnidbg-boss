package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class rk5 implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f20498a;
    public long b;
    public Uri c = Uri.EMPTY;
    public Map<String, List<String>> d = Collections.emptyMap();

    public rk5(a aVar) {
        this.f20498a = (a) vh.e(aVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws IOException {
        this.c = bVar.f6011a;
        this.d = Collections.emptyMap();
        long jA = this.f20498a.a(bVar);
        this.c = (Uri) vh.e(getUri());
        this.d = getResponseHeaders();
        return jA;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void b(u06 u06Var) {
        vh.e(u06Var);
        this.f20498a.b(u06Var);
    }

    public long c() {
        return this.b;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        this.f20498a.close();
    }

    public Uri d() {
        return this.c;
    }

    public Map<String, List<String>> e() {
        return this.d;
    }

    public void f() {
        this.b = 0L;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> getResponseHeaders() {
        return this.f20498a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri getUri() {
        return this.f20498a.getUri();
    }

    @Override // defpackage.ru0
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f20498a.read(bArr, i, i2);
        if (i3 != -1) {
            this.b += (long) i3;
        }
        return i3;
    }
}
