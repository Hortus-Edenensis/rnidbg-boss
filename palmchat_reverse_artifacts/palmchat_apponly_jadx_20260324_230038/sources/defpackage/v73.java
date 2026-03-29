package defpackage;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.LruCache;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class v73 {
    public static final v73 b = new v73();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<String, u73> f21371a = new LruCache<>(20);

    @VisibleForTesting
    public v73() {
    }

    public static v73 b() {
        return b;
    }

    @Nullable
    public u73 a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return this.f21371a.get(str);
    }

    public void c(@Nullable String str, u73 u73Var) {
        if (str == null) {
            return;
        }
        this.f21371a.put(str, u73Var);
    }
}
