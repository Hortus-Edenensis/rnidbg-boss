package defpackage;

import android.app.Activity;
import android.content.Context;
import com.zenmen.palmchat.settings.cert.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class iu4 implements fo2 {

    /* JADX INFO: compiled from: SearchBox */
    public class a implements a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pt4 f18267a;

        public a(pt4 pt4Var) {
            this.f18267a = pt4Var;
        }

        @Override // com.zenmen.palmchat.settings.cert.a.b
        public void onResult(boolean z) {
            pt4 pt4Var = this.f18267a;
            if (pt4Var != null) {
                if (z) {
                    pt4Var.success();
                } else {
                    pt4Var.failed(-1, null);
                }
            }
        }
    }

    @Override // defpackage.fo2
    public void a(Activity activity, pt4 pt4Var) {
        com.zenmen.palmchat.settings.cert.a.a().d(activity, new a(pt4Var));
    }

    @Override // defpackage.fo2
    public void c(Context context) {
        nb3.j(context);
    }

    @Override // defpackage.fo2
    public void b(Context context) {
    }
}
