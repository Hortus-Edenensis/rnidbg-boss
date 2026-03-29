package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.upstream.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class u51 implements fi2 {
    @Override // defpackage.fi2
    public g.a<ei2> a(c cVar, @Nullable b bVar) {
        return new HlsPlaylistParser(cVar, bVar);
    }

    @Override // defpackage.fi2
    public g.a<ei2> b() {
        return new HlsPlaylistParser();
    }
}
