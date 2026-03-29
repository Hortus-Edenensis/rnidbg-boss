package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Nullable;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class k36 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f18567a;

        public a(View view) {
            this.f18567a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            k36.h(this.f18567a);
        }
    }

    public static void a(String str) {
        sy5.f(c.b(), str, 1).g();
    }

    public static int b(float f) {
        return (int) ((f * c.b().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(@Nullable Context context) {
        if (context == null) {
            context = c.b();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int d(@Nullable Context context) {
        if (context == null) {
            context = c.b();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int e(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void f(View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void g(View view, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin = i;
        view.setLayoutParams(marginLayoutParams);
    }

    public static void h(View view) {
        KeyboardKt.e(view, Keyboard$SHOW_FLAG.IMPLICIT, 0L);
    }

    public static void i(View view, long j) {
        if (view != null) {
            view.postDelayed(new a(view), j);
        }
    }

    public static int j(float f) {
        return (int) ((f * c.b().getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
