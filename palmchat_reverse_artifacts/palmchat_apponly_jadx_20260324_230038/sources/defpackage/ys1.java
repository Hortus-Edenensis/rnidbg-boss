package defpackage;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface ys1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ys1 f22262a = new ys1() { // from class: ss1
        @Override // defpackage.ys1
        public final os1[] createExtractors() {
            return vs1.b();
        }

        @Override // defpackage.ys1
        public /* synthetic */ os1[] createExtractors(Uri uri, Map map) {
            return vs1.a(this, uri, map);
        }
    };

    os1[] createExtractors();

    os1[] createExtractors(Uri uri, Map<String, List<String>> map);
}
