package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.MediaItem;
import com.oplus.tbl.exoplayer2.source.MediaSource;
import com.oplus.tbl.exoplayer2.source.MediaSourceFactory;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class gm3 {
    @Deprecated
    public static MediaSource a(MediaSourceFactory mediaSourceFactory, Uri uri) {
        return mediaSourceFactory.createMediaSource(MediaItem.fromUri(uri));
    }

    @Deprecated
    public static MediaSourceFactory b(MediaSourceFactory mediaSourceFactory, @Nullable List list) {
        return mediaSourceFactory;
    }
}
