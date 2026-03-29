package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.upstream.b;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class xt5 implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f22051a;
    public final uu0 b;
    public boolean c;
    public long d;

    public xt5(a aVar, uu0 uu0Var) {
        this.f22051a = (a) vh.e(aVar);
        this.b = (uu0) vh.e(uu0Var);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws IOException {
        long jA = this.f22051a.a(bVar);
        this.d = jA;
        if (jA == 0) {
            return 0L;
        }
        if (bVar.h == -1 && jA != -1) {
            bVar = bVar.f(0L, jA);
        }
        this.c = true;
        this.b.a(bVar);
        return this.d;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void b(u06 u06Var) {
        vh.e(u06Var);
        this.f22051a.b(u06Var);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        try {
            this.f22051a.close();
        } finally {
            if (this.c) {
                this.c = false;
                this.b.close();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> getResponseHeaders() {
        return this.f22051a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri getUri() {
        return this.f22051a.getUri();
    }

    @Override // defpackage.ru0
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.d == 0) {
            return -1;
        }
        int i3 = this.f22051a.read(bArr, i, i2);
        if (i3 > 0) {
            this.b.write(bArr, i, i3);
            long j = this.d;
            if (j != -1) {
                this.d = j - ((long) i3);
            }
        }
        return i3;
    }
}
