package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.R$dimen;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class g03 {
    public static void a(View view, int i) {
        WeakReference weakReference = new WeakReference(view);
        if (weakReference.get() != null) {
            ViewGroup.LayoutParams layoutParams = ((View) weakReference.get()).getLayoutParams();
            layoutParams.height = c(i, an.a(1123), an.a(705));
            ((View) weakReference.get()).setLayoutParams(layoutParams);
        }
    }

    public static void b(View view, int i) {
        WeakReference weakReference = new WeakReference(view);
        if (weakReference.get() != null) {
            ViewGroup.LayoutParams layoutParams = ((View) weakReference.get()).getLayoutParams();
            layoutParams.height = i;
            ((View) weakReference.get()).setLayoutParams(layoutParams);
        }
    }

    public static int c(int i, int i2, int i3) {
        return Math.min(Math.max(i, i3), i2);
    }

    public static int d() {
        return c(e(c.b()), an.a(1123), an.a(705));
    }

    public static int e(Context context) {
        return r75.g(context, "soft_input_height_n2", (int) context.getResources().getDimension(R$dimen.default_soft_input_height));
    }

    public static int f(Context context) {
        return r75.g(context, "soft_input_height_b", (int) context.getResources().getDimension(R$dimen.default_soft_input_height));
    }

    public static boolean g(int i) {
        return i < an.a(705) || i > an.a(1123);
    }

    public static void h(Context context, int i) {
        r75.p(context, "soft_input_height_n2", i);
    }
}
