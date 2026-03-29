package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import cn.jiguang.api.JCoreManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class wt5 {
    public static volatile wt5 c = null;
    public static final Object d = new Object();
    public static long e = 1;
    public gt5 b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Long, bt2> f21797a = new HashMap();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends gt5 {
        public a() {
        }

        @Override // defpackage.gt5
        public void a(Message message) {
            long j = message.what - 100000;
            Bundle bundle = new Bundle();
            bundle.putLong("rid", j);
            tt5.u().r(JCoreManager.getAppContext(null), "tcp_a6", bundle);
        }
    }

    public static long a() {
        long j = e + 1;
        e = j;
        if (j >= 2147483647L) {
            e = 1L;
        }
        return e;
    }

    public static wt5 c() {
        if (c == null) {
            synchronized (d) {
                if (c == null) {
                    c = new wt5();
                }
            }
        }
        return c;
    }

    public bt2 b(long j) {
        return this.f21797a.get(Long.valueOf(j));
    }

    public void d(Context context, long j) {
        bt2 bt2VarRemove = this.f21797a.remove(Long.valueOf(j));
        if (bt2VarRemove != null) {
            if (bt2VarRemove.j) {
                nt5.b().f((int) (j + SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US));
            }
            k63.a("TcpRequestManager", "handle reponse :" + bt2VarRemove);
        }
    }

    public final byte[] e(Context context, bt2 bt2Var) {
        return cw2.k(context, bt2Var.d, bt2Var.e, bt2Var.f, bt2Var.g, 0L);
    }

    public void f(Context context, long j) {
        bt2 bt2VarRemove = this.f21797a.remove(Long.valueOf(j));
        if (bt2VarRemove == null) {
            k63.l("TcpRequestManager", "not found requst by rid:" + j);
            return;
        }
        k63.a("TcpRequestManager", "request time out:" + bt2VarRemove);
        zd1.e().d(context, bt2VarRemove.c, bt2VarRemove.b, bt2VarRemove.d);
    }

    public void g(Context context) {
        if (this.f21797a.isEmpty()) {
            k63.a("TcpRequestManager", "no cache request");
            return;
        }
        for (Map.Entry<Long, bt2> entry : this.f21797a.entrySet()) {
            if (entry.getValue().j) {
                long jNanoTime = System.nanoTime() - entry.getValue().h;
                if (entry.getValue().i - jNanoTime >= 10000) {
                    entry.getValue().a();
                    k63.a("TcpRequestManager", "send again:" + entry.getValue());
                    tt5.u().w().c().h(e(context, entry.getValue()));
                } else {
                    k63.a("TcpRequestManager", "shoud not send again by 10000ms,hasRequestTime:" + jNanoTime + ",timeout:" + entry.getValue().i);
                }
            }
        }
    }

    public void h(Context context, long j, int i, int i2, byte[] bArr, String str) {
        long jL = jm0.l(context);
        if (this.f21797a.containsKey(Long.valueOf(jL))) {
            k63.n("TcpRequestManager", "Generator same rid,not do this msg");
            return;
        }
        bt2 bt2Var = new bt2(j, str, i, i2, jL, 0L, bArr);
        if (tt5.u().C()) {
            tt5.u().w().c().h(e(context, bt2Var));
        }
        this.f21797a.put(Long.valueOf(jL), bt2Var);
    }

    public void i(Context context, long j, int i, int i2, byte[] bArr, String str, long j2) {
        long j3;
        if (i == 10) {
            j3 = j;
        } else {
            long jL = jm0.l(context);
            k63.a("TcpRequestManager", "Generator new rid:" + jL);
            if (this.f21797a.containsKey(Long.valueOf(jL))) {
                k63.n("TcpRequestManager", "Generator same rid,not do this msg");
                return;
            }
            j3 = jL;
        }
        long j4 = j2 <= 0 ? 10000L : j2;
        bt2 bt2Var = new bt2(j, str, i, i2, j3, j4, bArr);
        if (tt5.u().C()) {
            tt5.u().w().c().h(e(context, bt2Var));
        }
        bt2Var.h = System.nanoTime();
        this.f21797a.put(Long.valueOf(j3), bt2Var);
        nt5.b().g((int) (j3 + SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US), j4, this.b);
    }
}
