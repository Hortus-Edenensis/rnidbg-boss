package defpackage;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.VideoFrameProcessingException;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface ac6 {

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        ac6 a(Context context, List<jk1> list, vv0 vv0Var, xg0 xg0Var, xg0 xg0Var2, boolean z, Executor executor, b bVar) throws VideoFrameProcessingException;
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
    }

    void a(@Nullable bp5 bp5Var);

    void b(int i);

    void c(c32 c32Var);

    void flush();

    Surface getInputSurface();

    int getPendingInputFrameCount();

    void registerInputFrame();

    void release();

    void renderOutputFrame(long j);
}
