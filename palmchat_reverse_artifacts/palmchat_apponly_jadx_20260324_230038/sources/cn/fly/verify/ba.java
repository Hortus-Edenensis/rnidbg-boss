package cn.fly.verify;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import cn.fly.verify.fp;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ba f2089a;
    private volatile Handler c;
    private volatile long f;
    private final HashSet<dv> b = new HashSet<>();
    private String d = null;
    private volatile long e = -1;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements fp.b {
        public a() {
        }

        @Override // cn.fly.verify.fp.b
        public void a(Activity activity) {
        }

        @Override // cn.fly.verify.fp.b
        public void b(Activity activity) {
            try {
                ba.this.f = SystemClock.elapsedRealtime();
                if (ba.this.e == 0) {
                    ba.this.e = SystemClock.elapsedRealtime();
                    if (ba.this.c != null) {
                        ba.this.c.sendEmptyMessage(1);
                    }
                }
                ba.this.d = activity == null ? null : activity.toString();
            } catch (Throwable unused) {
            }
        }

        @Override // cn.fly.verify.fp.b
        public void d(Activity activity) {
            try {
                if (ba.this.d != null) {
                    if (!ba.this.d.equals(activity == null ? null : activity.toString())) {
                        return;
                    }
                }
                if (ba.this.c != null) {
                    long jElapsedRealtime = ba.this.e > 0 ? SystemClock.elapsedRealtime() - ba.this.e : 0L;
                    Message message = new Message();
                    message.what = 2;
                    message.obj = Long.valueOf(jElapsedRealtime);
                    ba.this.c.sendMessage(message);
                }
                ba.this.e = 0L;
                ba.this.d = null;
            } catch (Throwable unused) {
            }
        }

        @Override // cn.fly.verify.fp.b
        public void e(Activity activity) {
            if (ba.this.e > 0) {
                d(activity);
            }
        }

        @Override // cn.fly.verify.fp.b
        public void a(Activity activity, Bundle bundle) {
        }

        @Override // cn.fly.verify.fp.b
        public void b(Activity activity, Bundle bundle) {
        }

        @Override // cn.fly.verify.fp.b
        public void c(Activity activity) {
        }
    }

    private ba() {
        String str = null;
        this.f = 0L;
        this.f = SystemClock.elapsedRealtime();
        if (!TextUtils.isEmpty("M-")) {
            str = ek.f2243a + a("0049hnhkjmjh");
        }
        this.c = em.a(str, new Handler.Callback() { // from class: cn.fly.verify.ba.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int i = message.what;
                if (i == 0) {
                    ba.this.e = SystemClock.elapsedRealtime();
                    ba.this.a(false);
                    ba.this.d();
                } else if (i == 1) {
                    ba.this.a(true);
                } else if (i == 2) {
                    ba.this.a(((Long) message.obj).longValue(), true);
                } else if (i == 3) {
                    try {
                        dv dvVar = (dv) message.obj;
                        if (dvVar != null) {
                            ba.this.b.add(dvVar);
                            dvVar.a(ba.this.e > 0, true, 0L);
                        }
                    } catch (Throwable th) {
                        en.a().a(th);
                    }
                }
                return false;
            }
        });
    }

    public long c() {
        return this.f;
    }

    public static synchronized ba a() {
        if (f2089a == null) {
            ba baVar = new ba();
            f2089a = baVar;
            if (baVar.c != null) {
                f2089a.c.sendEmptyMessage(0);
            }
        }
        return f2089a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        fp.a(ax.g()).a(new a());
    }

    public boolean b() {
        return this.e == 0;
    }

    public static String a(String str) {
        return eg.a(str, 101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, boolean z) {
        if (z) {
            a(false, false, j);
        }
    }

    public void a(dv dvVar) {
        if (dvVar == null) {
            return;
        }
        synchronized (this.b) {
            if (this.b.contains(dvVar)) {
                return;
            }
            if (this.c != null) {
                Message message = new Message();
                message.what = 3;
                message.obj = dvVar;
                this.c.sendMessage(message);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            a(true, false, 0L);
        }
    }

    private void a(boolean z, boolean z2, long j) {
        synchronized (this.b) {
            Iterator<dv> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a(z, z2, j);
            }
        }
    }
}
