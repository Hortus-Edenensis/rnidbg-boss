package defpackage;

import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.framework.R$id;
import com.zenmen.palmchat.framework.R$layout;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ez2 {
    public static final ez2 c = new ez2();
    public static final int d = me1.g() / 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f17396a;
    public View b;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f17397a;

        public a(String str) {
            this.f17397a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            sy5.f(c.b(), this.f17397a, 1).g();
        }
    }

    public ez2() {
        View viewC = l36.c(R$layout.kit_layout_toast);
        this.b = viewC;
        this.f17396a = (TextView) viewC.findViewById(R$id.toast_content);
    }

    public static void a(String str) {
        if (Looper.myLooper() != null) {
            sy5.f(c.b(), str, 1).g();
        } else {
            l36.d(new a(str));
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "网络异常，请稍后再试";
        }
        a(str);
    }
}
