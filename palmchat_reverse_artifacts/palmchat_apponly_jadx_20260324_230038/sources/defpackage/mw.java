package defpackage;

import android.net.Uri;
import com.google.android.exoplayer2.source.d;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.upstream.b;
import com.google.android.exoplayer2.upstream.cache.a;
import com.google.android.exoplayer2.upstream.cache.c;
import com.google.android.exoplayer2.upstream.d;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.l64;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class mw {
    public static final mw c = new mw();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f19377a = new c(com.zenmen.palmchat.c.b().getCacheDir(), new z13(536870912), new fk5(com.zenmen.palmchat.c.b()));
    public i.a b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements lw {
        public a() {
        }

        @Override // defpackage.lw
        public String a(b bVar) {
            return mw.a(bVar.f6011a);
        }
    }

    public mw() {
        this.b = new d(new a.c().c(d()).d(new a()).e(kj2.a() ? new l64.b(lh3.a().b()) : new d.b()));
    }

    public static String a(Uri uri) {
        LogUtil.d("ExoPlayer", "uri:" + uri);
        return uri == null ? UUID.randomUUID().toString() : rb3.c(uri.getPath());
    }

    public static mw b() {
        return c;
    }

    public i.a c() {
        return this.b;
    }

    public c d() {
        return this.f19377a;
    }
}
