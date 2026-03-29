package defpackage;

import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import com.zenmen.palmchat.friendcircle.R$string;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class uq3 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FrameworkBaseActivity f21272a;

        public a(FrameworkBaseActivity frameworkBaseActivity) {
            this.f21272a = frameworkBaseActivity;
        }

        @Override // java.lang.Runnable
        public void run() {
            new sd3(this.f21272a).j(R$string.service_error).O(R$string.string_publish_text_overflow_dialog_positive).e().show();
        }
    }

    public static void a(FrameworkBaseActivity frameworkBaseActivity) {
        frameworkBaseActivity.runOnUiThread(new a(frameworkBaseActivity));
    }
}
