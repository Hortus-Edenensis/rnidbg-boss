package defpackage;

import android.view.View;
import com.zenmen.palmchat.zx.compat.Keyboard$SHOW_FLAG;
import com.zenmen.palmchat.zx.compat.KeyboardKt;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class lt2 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f19072a;

        public a(View view) {
            this.f19072a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            lt2.a(this.f19072a);
        }
    }

    public static void a(View view) {
        KeyboardKt.e(view, Keyboard$SHOW_FLAG.IMPLICIT, 0L);
    }

    public static void b(View view, long j) {
        if (view == null) {
            return;
        }
        view.postDelayed(new a(view), j);
    }
}
