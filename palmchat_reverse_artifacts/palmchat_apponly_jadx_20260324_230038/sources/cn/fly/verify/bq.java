package cn.fly.verify;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import cn.fly.verify.cn;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class bq implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static bq f2111a = new bq();
    private Handler b;

    private bq() {
        String str;
        if (TextUtils.isEmpty("M-")) {
            str = null;
        } else {
            str = ek.f2243a + a("004Rflidilig");
        }
        this.b = em.a(str, this);
    }

    private <T extends bh> int a(T t) {
        int iK = t.k();
        return iK > 0 ? iK + 10000 : iK - 10000;
    }

    public Looper b() {
        Handler handler = this.b;
        if (handler != null) {
            return handler.getLooper();
        }
        return null;
    }

    public void c() {
        this.b.removeMessages(1002);
    }

    public boolean d(long j, Runnable runnable) {
        return b(1005, j, runnable);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Runnable runnable;
        ThreadPoolExecutor threadPoolExecutor;
        bh bhVar;
        try {
        } catch (Throwable th) {
            en.a().a(th);
        }
        if (!by.d()) {
            Message messageObtain = Message.obtain();
            messageObtain.copyFrom(message);
            this.b.sendMessageDelayed(messageObtain, 60000L);
            return false;
        }
        int i = message.what;
        if (i == 1003 || i == 1004 || i == 1006) {
            runnable = (Runnable) message.obj;
            if (runnable != null) {
                threadPoolExecutor = ek.d;
                threadPoolExecutor.execute(runnable);
            }
        } else if (i == 1002) {
            cn.b bVar = (cn.b) message.obj;
            if (bVar != null) {
                if (!bVar.f2158a) {
                    bVar.f2158a = true;
                }
                ek.d.execute(bVar);
                int i2 = message.arg1;
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 1002;
                messageObtain2.obj = bVar;
                messageObtain2.arg1 = i2;
                a(messageObtain2, i2 * 1000);
            }
        } else if (i == 1005) {
            runnable = (Runnable) message.obj;
            if (runnable != null) {
                threadPoolExecutor = ek.c;
                threadPoolExecutor.execute(runnable);
            }
        } else if ((i >= 10000 || i < -10000) && (bhVar = (bh) message.obj) != null) {
            bhVar.h();
        }
        return false;
    }

    public static bq a() {
        return f2111a;
    }

    private boolean b(int i, long j, Runnable runnable) {
        Message messageObtain = Message.obtain();
        messageObtain.what = i;
        messageObtain.obj = runnable;
        a(messageObtain, j);
        return true;
    }

    public boolean c(long j, Runnable runnable) {
        return a(1006, j * 1000, runnable);
    }

    public static String a(String str) {
        return eg.a(str, 100);
    }

    public boolean b(long j, Runnable runnable) {
        return a(1004, j * 1000, runnable);
    }

    public void a(long j, int i, cn.b bVar) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1002;
        messageObtain.arg1 = i;
        messageObtain.obj = bVar;
        a(messageObtain, j * 1000);
    }

    public <T extends bh> void a(long j, T t, int i) {
        int iA = a(t);
        if (i == 1) {
            this.b.removeMessages(iA);
        } else if (i == 2 && this.b.hasMessages(iA)) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = iA;
        messageObtain.obj = t;
        a(messageObtain, j * 1000);
    }

    private void a(Message message, long j) {
        if (j > 0) {
            this.b.sendMessageDelayed(message, j);
        } else {
            this.b.sendMessage(message);
        }
    }

    private boolean a(int i, long j, Runnable runnable) {
        if (this.b.hasMessages(i)) {
            return false;
        }
        b(i, j, runnable);
        return true;
    }

    public boolean a(long j, Runnable runnable) {
        return a(1003, j * 1000, runnable);
    }
}
