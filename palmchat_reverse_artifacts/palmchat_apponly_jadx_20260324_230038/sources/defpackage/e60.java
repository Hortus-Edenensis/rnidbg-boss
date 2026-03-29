package defpackage;

import com.google.android.exoplayer2.upstream.f;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface e60 {
    long a(long j, w45 w45Var);

    boolean b(long j, x50 x50Var, List<? extends te3> list);

    void d(long j, long j2, List<? extends te3> list, a60 a60Var);

    void e(x50 x50Var);

    boolean f(x50 x50Var, boolean z, f.c cVar, f fVar);

    int getPreferredQueueSize(long j, List<? extends te3> list);

    void maybeThrowError() throws IOException;

    void release();
}
