package defpackage;

import android.text.TextUtils;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class r54 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f20391a = new HashSet();

    public static void a(Set<String> set) {
        if (set == null || set.size() <= 0) {
            return;
        }
        f20391a.addAll(set);
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Set<String> set = f20391a;
        if (set.size() > 0) {
            return set.contains(str);
        }
        return false;
    }
}
