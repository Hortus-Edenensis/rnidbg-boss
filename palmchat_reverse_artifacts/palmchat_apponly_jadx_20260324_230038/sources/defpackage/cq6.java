package defpackage;

import com.zenmen.palmchat.framework.FrameworkBaseActivity;
import defpackage.bo2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class cq6 {
    public static bo2 a(FrameworkBaseActivity frameworkBaseActivity, String str, int i, bo2.a aVar) {
        if (str == null) {
            return null;
        }
        bo2 g7Var = str.startsWith("addfriend:") ? new g7(frameworkBaseActivity, aVar) : str.startsWith("webzx:") ? new zi6(frameworkBaseActivity, aVar) : el6.b(str) ? new el6(frameworkBaseActivity, aVar) : str.startsWith("groupqrcode:") ? new oe2(frameworkBaseActivity, aVar) : str.startsWith("smallvideo:") ? new mf5(frameworkBaseActivity, aVar) : le2.b(str) ? new le2(frameworkBaseActivity, aVar) : su.c(str) ? new su(frameworkBaseActivity, aVar) : new n71(frameworkBaseActivity, aVar, i);
        g7Var.a(str);
        return g7Var;
    }

    public static void b(FrameworkBaseActivity frameworkBaseActivity, String str, int i) {
        a(frameworkBaseActivity, str, i, new a());
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a implements bo2.a {
        @Override // bo2.a
        public void onFinish(boolean z) {
        }
    }
}
