package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.os.Build;
import ms.bz.bd.c.Pgl.pblk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class d1 {
    public static volatile boolean c = true;
    public static String d;
    public static volatile d1 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pblk f19309a;
    public String b = null;

    /* JADX INFO: compiled from: SearchBox */
    public class pgla implements pblk.pblb {
        public pgla() {
        }

        @Override // ms.bz.bd.c.Pgl.pblk.pblb
        public final void u(String str) {
            d1.this.b = str;
        }
    }

    public d1(Context context) {
        try {
            this.f19309a = new pblk(new pgla());
            if (!c || Build.VERSION.SDK_INT > 32) {
                return;
            }
            this.f19309a.f(context);
        } catch (Throwable unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "26aafd", new byte[]{44, 33, 17});
        }
    }

    public static d1 b(Context context) {
        if (e == null) {
            synchronized (d1.class) {
                if (e == null) {
                    e = new d1(context);
                }
            }
        }
        return e;
    }

    public final String a() {
        String str = d;
        return str != null ? str : this.b;
    }
}
