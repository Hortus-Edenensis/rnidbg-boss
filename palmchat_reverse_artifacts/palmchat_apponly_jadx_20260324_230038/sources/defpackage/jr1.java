package defpackage;

import java.util.HashSet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class jr1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashSet<String> f18484a = new HashSet<>();
    public static String b = "goog.exo.core";

    public static synchronized void a(String str) {
        if (f18484a.add(str)) {
            b += ", " + str;
        }
    }

    public static synchronized String b() {
        return b;
    }
}
