package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.upstream.f;
import defpackage.fi2;
import defpackage.yh2;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface HlsPlaylistTracker {

    /* JADX INFO: compiled from: SearchBox */
    public static final class PlaylistResetException extends IOException {
        public final Uri url;

        public PlaylistResetException(Uri uri) {
            this.url = uri;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class PlaylistStuckException extends IOException {
        public final Uri url;

        public PlaylistStuckException(Uri uri) {
            this.url = uri;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        HlsPlaylistTracker a(yh2 yh2Var, f fVar, fi2 fi2Var);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void c();

        boolean d(Uri uri, f.c cVar, boolean z);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c {
        void d(com.google.android.exoplayer2.source.hls.playlist.b bVar);
    }

    void a(b bVar);

    long b();

    void c(Uri uri, j.a aVar, c cVar);

    void d(Uri uri) throws IOException;

    @Nullable
    com.google.android.exoplayer2.source.hls.playlist.c g();

    void h(Uri uri);

    void i(b bVar);

    boolean k(Uri uri);

    boolean l();

    boolean m(Uri uri, long j);

    void n() throws IOException;

    @Nullable
    com.google.android.exoplayer2.source.hls.playlist.b o(Uri uri, boolean z);

    void stop();
}
