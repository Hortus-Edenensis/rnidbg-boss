package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.oplus.tbl.exoplayer2.upstream.cache.ContentMetadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class jp0 {
    public static long a(ContentMetadata contentMetadata) {
        return contentMetadata.get("exo_len", -1L);
    }

    @Nullable
    public static Uri b(ContentMetadata contentMetadata) {
        String str = contentMetadata.get("exo_redir", (String) null);
        if (str == null) {
            return null;
        }
        return Uri.parse(str);
    }
}
