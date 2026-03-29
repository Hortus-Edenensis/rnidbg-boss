package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class o42 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<Uri, byte[]> f19690a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends LinkedHashMap<Uri, byte[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f19691a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i, float f, boolean z, int i2) {
            super(i, f, z);
            this.f19691a = i2;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<Uri, byte[]> entry) {
            return size() > this.f19691a;
        }
    }

    public o42(int i) {
        this.f19690a = new a(i + 1, 1.0f, false, i);
    }

    @Nullable
    public byte[] a(@Nullable Uri uri) {
        if (uri == null) {
            return null;
        }
        return this.f19690a.get(uri);
    }

    @Nullable
    public byte[] b(Uri uri, byte[] bArr) {
        return this.f19690a.put((Uri) vh.e(uri), (byte[]) vh.e(bArr));
    }

    @Nullable
    public byte[] c(Uri uri) {
        return this.f19690a.remove(vh.e(uri));
    }
}
