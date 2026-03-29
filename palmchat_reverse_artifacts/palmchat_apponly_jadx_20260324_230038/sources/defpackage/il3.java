package defpackage;

import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.source.MediaSource;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class il3 {
    @UnstableApi
    public static boolean a(MediaSource mediaSource, MediaItem mediaItem) {
        return false;
    }

    @Nullable
    @UnstableApi
    public static Timeline b(MediaSource mediaSource) {
        return null;
    }

    @UnstableApi
    public static boolean c(MediaSource mediaSource) {
        return true;
    }

    @UnstableApi
    @Deprecated
    public static void d(MediaSource mediaSource, MediaSource.MediaSourceCaller mediaSourceCaller, @Nullable TransferListener transferListener) {
        mediaSource.prepareSource(mediaSourceCaller, transferListener, PlayerId.UNSET);
    }

    @UnstableApi
    public static void e(MediaSource mediaSource, MediaItem mediaItem) {
    }
}
