package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface z50 {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        @Nullable
        z50 a(int i, m mVar, boolean z, List<m> list, @Nullable c06 c06Var, bk4 bk4Var);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        c06 track(int i, int i2);
    }

    boolean a(ps1 ps1Var) throws IOException;

    void b(@Nullable b bVar, long j, long j2);

    @Nullable
    b60 getChunkIndex();

    @Nullable
    m[] getSampleFormats();

    void release();
}
