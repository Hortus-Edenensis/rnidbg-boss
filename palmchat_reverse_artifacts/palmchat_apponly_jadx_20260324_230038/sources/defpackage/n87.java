package defpackage;

import android.util.Log;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class n87 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f19460a = false;

    public static void a(String str, @NonNull la7<String> la7Var) {
        Log.e("OplusTrack-" + str, la7Var.get());
    }

    public static void b(boolean z) {
        f19460a = z;
    }

    public static void c(String str, @NonNull la7<String> la7Var) {
        Log.w("OplusTrack-" + str, la7Var.get());
    }

    public static void d(String str, @NonNull la7<String> la7Var) {
        if (f19460a) {
            Log.i("OplusTrack-" + str, la7Var.get());
        }
    }

    public static void e(String str, @NonNull la7<String> la7Var) {
        if (f19460a) {
            Log.d("OplusTrack-" + str, la7Var.get());
        }
    }

    public static void f(String str, @NonNull la7<String> la7Var) {
        if (f19460a) {
            Log.v("OplusTrack-" + str, la7Var.get());
        }
    }
}
