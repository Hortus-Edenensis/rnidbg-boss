package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import com.zenmen.palmchat.lxvoip.vertc.R$layout;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@SuppressLint({"SoonBlockedPrivateApi"})
public class hg5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f17952a;
    public static Field b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f17953a;

        public a(Handler handler) {
            this.f17953a = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(@NonNull Message message) {
            try {
                super.dispatchMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            try {
                this.f17953a.handleMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static {
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            f17952a = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = f17952a.getType().getDeclaredField("mHandler");
            b = declaredField2;
            declaredField2.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(Toast toast) {
        if (Build.VERSION.SDK_INT < 26) {
            try {
                Object obj = f17952a.get(toast);
                b.set(obj, new a((Handler) b.get(obj)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void c(Context context, CharSequence charSequence, int i) {
        View viewInflate = View.inflate(context, R$layout.solution_toast, null);
        Toast toast = new Toast(context);
        toast.setView(viewInflate);
        ((TextView) viewInflate).setText(charSequence);
        b(toast);
        toast.setDuration(i);
        toast.setGravity(17, 0, 0);
        toast.show();
    }

    public static void d(@StringRes int i) {
        e(fh.a(), i, 0);
    }

    public static void e(Context context, int i, int i2) {
        Toast toastMakeText = Toast.makeText(context.getApplicationContext(), i, i2);
        b(toastMakeText);
        toastMakeText.show();
    }

    public static void f(final Context context, final CharSequence charSequence, final int i) {
        rg.b().execute(new Runnable() { // from class: gg5
            @Override // java.lang.Runnable
            public final void run() {
                hg5.c(context, charSequence, i);
            }
        });
    }

    public static void g(CharSequence charSequence) {
        f(fh.a(), charSequence, 0);
    }
}
