package defpackage;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class mp0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f19283a = new HashMap();
    public final List<String> b = new ArrayList();

    public static mp0 g(mp0 mp0Var, long j) {
        return mp0Var.e("exo_len", j);
    }

    public static mp0 h(mp0 mp0Var, @Nullable Uri uri) {
        return uri == null ? mp0Var.d("exo_redir") : mp0Var.f("exo_redir", uri.toString());
    }

    public final mp0 a(String str, Object obj) {
        this.f19283a.put((String) vh.e(str), vh.e(obj));
        this.b.remove(str);
        return this;
    }

    public Map<String, Object> b() {
        HashMap map = new HashMap(this.f19283a);
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(map);
    }

    public List<String> c() {
        return Collections.unmodifiableList(new ArrayList(this.b));
    }

    public mp0 d(String str) {
        this.b.add(str);
        this.f19283a.remove(str);
        return this;
    }

    public mp0 e(String str, long j) {
        return a(str, Long.valueOf(j));
    }

    public mp0 f(String str, String str2) {
        return a(str, str2);
    }
}
