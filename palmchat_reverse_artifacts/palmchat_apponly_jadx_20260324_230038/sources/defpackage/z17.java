package defpackage;

import android.content.Context;
import defpackage.d37;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class z17 extends k27 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final z17 f22322a = new z17();
    }

    @Override // defpackage.k27
    public void c(Context context, List<String> list, boolean z) {
        g(list, "OUID", "");
        g(list, "OUID_STATUS", "FALSE");
        d37.b.f16969a.d(context, list, z);
    }

    public final void g(List<String> list, String str, String str2) {
        if (list.contains(str)) {
            this.f18561a.put(str, new gc7(str2, System.currentTimeMillis() + lx6.j(str)));
            list.remove(str);
        }
    }
}
