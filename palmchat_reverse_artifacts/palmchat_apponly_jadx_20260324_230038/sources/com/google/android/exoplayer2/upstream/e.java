package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.f;
import defpackage.j43;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6023a;

    public e() {
        this(-1);
    }

    @Override // com.google.android.exoplayer2.upstream.f
    public long a(f.c cVar) {
        IOException iOException = cVar.c;
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource$CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException) || DataSourceException.isCausedByPositionOutOfRange(iOException)) {
            return -9223372036854775807L;
        }
        return Math.min((cVar.d - 1) * 1000, 5000);
    }

    @Override // com.google.android.exoplayer2.upstream.f
    @Nullable
    public f.b b(f.a aVar, f.c cVar) {
        if (!c(cVar.c)) {
            return null;
        }
        if (aVar.a(1)) {
            return new f.b(1, 300000L);
        }
        if (aVar.a(2)) {
            return new f.b(2, 60000L);
        }
        return null;
    }

    public boolean c(IOException iOException) {
        if (!(iOException instanceof HttpDataSource$InvalidResponseCodeException)) {
            return false;
        }
        int i = ((HttpDataSource$InvalidResponseCodeException) iOException).responseCode;
        return i == 403 || i == 404 || i == 410 || i == 416 || i == 500 || i == 503;
    }

    @Override // com.google.android.exoplayer2.upstream.f
    public int getMinimumLoadableRetryCount(int i) {
        int i2 = this.f6023a;
        return i2 == -1 ? i == 7 ? 6 : 3 : i2;
    }

    @Override // com.google.android.exoplayer2.upstream.f
    public /* synthetic */ void onLoadTaskConcluded(long j) {
        j43.a(this, j);
    }

    public e(int i) {
        this.f6023a = i;
    }
}
