package androidx.media3.exoplayer.source.preload;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface TargetPreloadStatusControl<T, PreloadStatusT> {
    @Nullable
    PreloadStatusT getTargetPreloadStatus(T t);
}
