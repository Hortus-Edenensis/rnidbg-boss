package defpackage;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.wft.wknet.e;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class t87 {
    public static final t87 c = new t87();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f20923a = new g27();
    public sb7 b = new sb7(new Handler(Looper.getMainLooper()));

    public static t87 a() {
        return c;
    }

    public void b(co6 co6Var) {
        c(co6Var, e.NORMAL);
    }

    public void c(co6 co6Var, e eVar) {
        if (this.f20923a == null) {
            this.f20923a = new g27();
        }
        if (this.b == null) {
            this.b = new sb7(new Handler(Looper.getMainLooper()));
        }
        o47 o47Var = new o47(co6Var, this.b, eVar);
        String host = Uri.parse(co6Var.l()).getHost();
        Map<String, List<String>> mapG = co6Var.g();
        if (mapG != null && !TextUtils.isEmpty(host)) {
            o47Var.f(mapG.get(host));
        }
        this.f20923a.submit(o47Var);
    }
}
