package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.g;
import defpackage.mv1;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class ov1<T extends mv1<T>> implements g.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.a<? extends T> f19881a;

    @Nullable
    public final List<StreamKey> b;

    public ov1(g.a<? extends T> aVar, @Nullable List<StreamKey> list) {
        this.f19881a = aVar;
        this.b = list;
    }

    @Override // com.google.android.exoplayer2.upstream.g.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public T parse(Uri uri, InputStream inputStream) throws IOException {
        T t = this.f19881a.parse(uri, inputStream);
        List<StreamKey> list = this.b;
        return (list == null || list.isEmpty()) ? t : (T) t.copy(this.b);
    }
}
