package androidx.media3.common.util;

import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class BackgroundExecutor {

    @Nullable
    private static Executor staticInstance;

    private BackgroundExecutor() {
    }

    public static synchronized Executor get() {
        if (staticInstance == null) {
            staticInstance = Util.newSingleThreadExecutor("ExoPlayer:BackgroundExecutor");
        }
        return staticInstance;
    }

    public static synchronized void set(Executor executor) {
        staticInstance = executor;
    }
}
