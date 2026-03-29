package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.hls.playlist.b;
import com.google.android.exoplayer2.source.hls.playlist.c;
import com.google.android.exoplayer2.upstream.g;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class nv1 implements fi2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fi2 f19625a;
    public final List<StreamKey> b;

    public nv1(fi2 fi2Var, List<StreamKey> list) {
        this.f19625a = fi2Var;
        this.b = list;
    }

    @Override // defpackage.fi2
    public g.a<ei2> a(c cVar, @Nullable b bVar) {
        return new ov1(this.f19625a.a(cVar, bVar), this.b);
    }

    @Override // defpackage.fi2
    public g.a<ei2> b() {
        return new ov1(this.f19625a.b(), this.b);
    }
}
