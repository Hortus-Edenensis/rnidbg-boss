package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class yn {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f22233a;
        public final /* synthetic */ EditText b;
        public final /* synthetic */ Context c;

        public a(boolean z, EditText editText, b bVar, Context context) {
            this.f22233a = z;
            this.b = editText;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.f22233a) {
                    this.b.requestFocus();
                }
                int length = this.b.length();
                if (length > 0 && this.b.getSelectionEnd() == 0) {
                    this.b.setSelection(length);
                }
                if (this.f22233a) {
                    return;
                }
                ((InputMethodManager) this.c.getSystemService("input_method")).showSoftInput(this.b, 0);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
    }

    public static void a(Activity activity) {
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus == null && (currentFocus = activity.getWindow().peekDecorView()) == null) {
            currentFocus = new View(activity);
        }
        c(activity, currentFocus);
    }

    public static void b(Dialog dialog) {
        View currentFocus = dialog.getCurrentFocus();
        Context context = dialog.getContext();
        if (currentFocus == null) {
            if (context instanceof Activity) {
                a((Activity) context);
                return;
            }
            currentFocus = new View(context);
        }
        c(context, currentFocus);
    }

    public static void c(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void d(Context context, View view) {
        InputMethodManager inputMethodManager;
        if (view == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void e(Context context, EditText editText) {
        f(context, editText, null, false);
    }

    public static void f(Context context, EditText editText, b bVar, boolean z) {
        if (editText == null) {
            return;
        }
        editText.postDelayed(new a(z, editText, bVar, context), 200L);
    }
}
