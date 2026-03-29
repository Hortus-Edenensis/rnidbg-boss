package androidx.media3.exoplayer.util;

import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.UnstableApi;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface ReleasableExecutor extends Executor {

    /* JADX INFO: renamed from: androidx.media3.exoplayer.util.ReleasableExecutor$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public final /* synthetic */ class CC {
        public static <T extends Executor> ReleasableExecutor a(final T t, final Consumer<T> consumer) {
            return new ReleasableExecutor() { // from class: androidx.media3.exoplayer.util.ReleasableExecutor.1
                @Override // java.util.concurrent.Executor
                public void execute(Runnable runnable) {
                    t.execute(runnable);
                }

                @Override // androidx.media3.exoplayer.util.ReleasableExecutor
                public void release() {
                    consumer.accept(t);
                }
            };
        }
    }

    void release();
}
