package defpackage;

import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class j63 implements z83 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f18334a = new HashSet();

    @Override // defpackage.z83
    public void a(String str) {
        c(str, null);
    }

    @Override // defpackage.z83
    public void b(String str, Throwable th) {
        if (m03.f19114a) {
            Log.d("LOTTIE", str, th);
        }
    }

    @Override // defpackage.z83
    public void c(String str, Throwable th) {
        Set<String> set = f18334a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }

    @Override // defpackage.z83
    public void d(String str) {
        e(str, null);
    }

    public void e(String str, Throwable th) {
        if (m03.f19114a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
