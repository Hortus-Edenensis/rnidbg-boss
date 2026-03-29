package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.zenmen.palmchat.R;
import com.zenmen.palmchat.c;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class oy5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Toast f19901a;
    public boolean b;
    public final a c = new a(this);

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<oy5> f19902a;

        public a(oy5 oy5Var) {
            this.f19902a = new WeakReference<>(oy5Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.f19902a.get() != null) {
                this.f19902a.get().b = false;
            }
        }
    }

    public void b() {
        Toast toast = this.f19901a;
        if (toast != null) {
            toast.cancel();
            this.c.removeCallbacksAndMessages(null);
        }
    }

    public void c() {
        Toast toast = this.f19901a;
        if (toast != null) {
            try {
                toast.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void d(Context context, int i, int i2) {
        if (this.f19901a == null || !this.b) {
            View viewInflate = LayoutInflater.from(c.b()).inflate(R.layout.layout_toast_view, (ViewGroup) null);
            ((TextView) viewInflate.findViewById(R.id.toast_content)).setText(i);
            Toast toast = new Toast(context != null ? context.getApplicationContext() : c.b());
            this.f19901a = toast;
            toast.setGravity(81, 0, 80);
            this.f19901a.setDuration(1);
            this.f19901a.setView(viewInflate);
            this.f19901a.setDuration(i2);
            this.b = true;
            this.c.sendEmptyMessageDelayed(0, this.f19901a.getDuration() == 0 ? 2000 : 3500);
            c();
        }
    }
}
