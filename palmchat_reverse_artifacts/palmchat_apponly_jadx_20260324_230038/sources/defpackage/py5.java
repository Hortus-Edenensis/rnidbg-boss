package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class py5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Toast f20137a;
    public boolean b;
    public final c c;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final py5 f20138a = new py5();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<py5> f20139a;

        public c(py5 py5Var) {
            this.f20139a = new WeakReference<>(py5Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.f20139a.get() != null) {
                this.f20139a.get().b = false;
            }
        }
    }

    public static py5 b() {
        return b.f20138a;
    }

    public void c() {
        Toast toast = this.f20137a;
        if (toast != null) {
            try {
                toast.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void d(Context context, String str, int i) {
        if ((this.f20137a == null || !this.b) && !TextUtils.isEmpty(str)) {
            View viewInflate = LayoutInflater.from(com.zenmen.palmchat.c.b()).inflate(R$layout.layout_toast_view, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R$id.toast_content)).setText("" + str);
            Toast toast = new Toast(context != null ? context.getApplicationContext() : com.zenmen.palmchat.c.b());
            this.f20137a = toast;
            toast.setGravity(81, 0, 80);
            this.f20137a.setDuration(1);
            this.f20137a.setView(viewInflate);
            this.f20137a.setDuration(i);
            this.b = true;
            this.c.sendEmptyMessageDelayed(0, this.f20137a.getDuration() == 0 ? 2000 : 3500);
            c();
        }
    }

    public py5() {
        this.c = new c(this);
    }
}
