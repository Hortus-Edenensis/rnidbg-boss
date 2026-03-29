package defpackage;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class jj2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f18422a = new HashMap();

    @Nullable
    public Map<String, String> b;

    public synchronized Map<String, String> a() {
        if (this.b == null) {
            this.b = Collections.unmodifiableMap(new HashMap(this.f18422a));
        }
        return this.b;
    }
}
