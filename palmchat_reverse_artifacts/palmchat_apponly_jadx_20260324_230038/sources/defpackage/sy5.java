package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class sy5 {
    public static Handler b = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Toast f20872a;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20873a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public a(Context context, String str, int i) {
            this.f20873a = context;
            this.b = str;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            sy5.f(this.f20873a, this.b, this.c).g();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f20874a;

        public b(Runnable runnable) {
            this.f20874a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20874a.run();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Handler f20875a;

        public c(Handler handler) {
            this.f20875a = handler;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                this.f20875a.handleMessage(message);
            } catch (WindowManager.BadTokenException unused) {
            }
        }
    }

    public sy5(Toast toast) {
        this.f20872a = toast;
    }

    public static Toast a(String str, int i, int i2, int i3, int i4) {
        Toast toastMakeText = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                if (com.zenmen.palmchat.c.a().isBackground()) {
                    toastMakeText = Toast.makeText(com.zenmen.palmchat.c.b(), str, i);
                } else {
                    Toast toast = new Toast(com.zenmen.palmchat.c.b());
                    try {
                        View viewInflate = LayoutInflater.from(com.zenmen.palmchat.c.b()).inflate(R$layout.layout_toast_view, (ViewGroup) null);
                        ((TextView) viewInflate.findViewById(R$id.toast_content)).setText(str);
                        toast.setGravity(i2, i3, i4);
                        toast.setView(viewInflate);
                        toast.setDuration(i);
                        toastMakeText = toast;
                    } catch (Exception e) {
                        e = e;
                        toastMakeText = toast;
                        e.printStackTrace();
                        LogUtil.log4ClientError("toastExt", e);
                    }
                }
                c(toastMakeText);
            } catch (Exception e2) {
                e = e2;
            }
        }
        return toastMakeText;
    }

    public static void c(Toast toast) {
        if (Build.VERSION.SDK_INT != 25) {
            return;
        }
        try {
            Field declaredField = Toast.class.getDeclaredField("mTN");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(toast);
            Field declaredField2 = obj.getClass().getDeclaredField("mHandler");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, new c((Handler) declaredField2.get(obj)));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
    }

    public static sy5 d(Context context, int i, int i2) {
        return new sy5(a(com.zenmen.palmchat.c.b().getString(i), i2, 17, 0, 80));
    }

    public static sy5 e(Context context, int i, int i2) {
        return new sy5(a(com.zenmen.palmchat.c.b().getString(i), i2, 81, 0, 80));
    }

    public static sy5 f(Context context, CharSequence charSequence, int i) {
        return new sy5(a(charSequence.toString(), i, 81, 0, 80));
    }

    public static void h(Context context, String str, int i) {
        a aVar = new a(context, str, i);
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            b.post(new b(aVar));
        } else {
            aVar.run();
        }
    }

    public void g() {
        Toast toast = this.f20872a;
        if (toast != null) {
            try {
                toast.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void b() {
    }
}
