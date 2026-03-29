package defpackage;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.framework.mediapick.MediaItem;
import defpackage.bn2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class tk3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static bn2 f21012a;

    public static void a(String str, bn2.d dVar) {
        bn2 bn2Var = f21012a;
        if (bn2Var != null) {
            bn2Var.e(str, dVar);
        }
    }

    public static void b(FrameworkBaseActivity frameworkBaseActivity, String str, int i, int i2) {
        bn2 bn2Var = f21012a;
        if (bn2Var != null) {
            bn2Var.d(frameworkBaseActivity, str, i, i2);
        }
    }

    public static Intent c(Activity activity) {
        bn2 bn2Var = f21012a;
        if (bn2Var != null) {
            return bn2Var.b(activity);
        }
        return null;
    }

    public static void d(bn2 bn2Var) {
        f21012a = bn2Var;
    }

    public static void e(Activity activity, int i, int i2) {
        bn2 bn2Var = f21012a;
        if (bn2Var != null) {
            bn2Var.i(activity, i, i2);
        }
    }

    public static void f(Activity activity, int i, int i2, int i3) {
        bn2 bn2Var = f21012a;
        if (bn2Var != null) {
            bn2Var.j(activity, i, i2, i3);
        }
    }

    public static void g(Fragment fragment, int i, int i2, int i3) {
        bn2 bn2Var = f21012a;
        if (bn2Var != null) {
            bn2Var.c(fragment, i, i2, i3);
        }
    }

    public static void h(Activity activity, int i, int i2, int i3, int i4) {
        bn2 bn2Var = f21012a;
        if (bn2Var != null) {
            bn2Var.g(activity, i, i2, i3, i4);
        }
    }

    public static void i(Activity activity, int i, int i2) {
        bn2 bn2Var = f21012a;
        if (bn2Var != null) {
            bn2Var.a(activity, i, i2);
        }
    }

    public static void j(Activity activity, int i) {
        bn2 bn2Var = f21012a;
        if (bn2Var != null) {
            bn2Var.f(activity, i);
        }
    }

    public static void k(Activity activity, MediaItem mediaItem, int i) {
        bn2 bn2Var = f21012a;
        if (bn2Var != null) {
            bn2Var.h(activity, mediaItem, i);
        }
    }
}
