package defpackage;

import android.content.Context;
import android.os.Message;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class sx2 {
    public static volatile sx2 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kx2 f20866a;
    public lx2 b;
    public tx2 c;
    public long d = System.currentTimeMillis();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends ArrayList<rx2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rx2 f20867a;

        public a(rx2 rx2Var) {
            this.f20867a = rx2Var;
            add(rx2Var);
        }
    }

    public static sx2 d() {
        if (e == null) {
            synchronized (sx2.class) {
                if (e == null) {
                    e = new sx2();
                }
            }
        }
        return e;
    }

    public void a(Context context, kx2 kx2Var, List<rx2> list) {
        this.f20866a = kx2Var;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (rx2 rx2Var : list) {
                if (h(rx2Var.i * 1000)) {
                    arrayList.add(rx2Var);
                    g(context, rx2Var);
                }
            }
            if (!arrayList.isEmpty()) {
                list.removeAll(arrayList);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("start w task, wakeTarget size: ");
        sb.append(list != null ? list.size() : 0);
        sb.append(", dWakeTarget size: ");
        sb.append(arrayList.size());
        p63.a("JWakeTaskHelper", sb.toString());
        if (mx2.c()) {
            mx2.s(context, this.f20866a, gx2.m(context, list));
        } else {
            LogUtil.d("JWakeTaskHelper", "lx forbidden launcher other app c");
        }
    }

    public final synchronized lx2 b(Context context) {
        tx2 tx2Var = this.c;
        if (tx2Var == null || tx2Var.getState() == Thread.State.TERMINATED) {
            this.c = new tx2("jg_wk_thread");
        }
        if (this.c.getState() == Thread.State.NEW) {
            this.c.start();
            this.b = null;
        }
        if (this.b == null) {
            this.b = new lx2(context, this.c.getLooper());
        }
        return this.b;
    }

    public void c(Context context, boolean z) {
        if (z) {
            this.d = System.currentTimeMillis();
        }
    }

    public void e(Context context, int i, Object obj) {
        if (i == 1000 && (obj instanceof rx2)) {
            f(context, (rx2) obj);
        }
    }

    public final void f(Context context, rx2 rx2Var) {
        if (!mx2.c()) {
            LogUtil.d("JWakeTaskHelper", "lx forbidden launcher other app d");
            return;
        }
        p63.a("JWakeTaskHelper", "the delay w task time up, start to process it, tPkg: " + rx2Var.f20619a);
        List<qx2> listM = gx2.m(context, new a(rx2Var));
        if (listM == null || listM.isEmpty()) {
            return;
        }
        mx2.s(context, this.f20866a, listM);
    }

    public final void g(Context context, rx2 rx2Var) {
        long jMax = Math.max(0L, ((long) (rx2Var.i * 1000)) - Math.max(0L, System.currentTimeMillis() - this.d));
        Message messageObtain = Message.obtain();
        messageObtain.what = 1000;
        messageObtain.obj = rx2Var;
        b(context).sendMessageDelayed(messageObtain, jMax);
        p63.a("JWakeTaskHelper", "add delay w task, delayTime: " + jMax + ", tPkg: " + rx2Var.f20619a);
    }

    public boolean h(int i) {
        return rv2.y() && i > 0 && System.currentTimeMillis() - this.d < ((long) i);
    }
}
