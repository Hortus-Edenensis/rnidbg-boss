package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.zenmen.palmchat.messaging.smack.ManualException;
import com.zenmen.palmchat.utils.log.LogUtil;
import im.youni.iccs.iprotobuf.domain.PingProto;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class mi4 implements Handler.Callback {
    public static long j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HandlerThread f19226a;
    public xo6 b;
    public Handler c;
    public boolean d;
    public int e;
    public int f;
    public long g;
    public Runnable h = new a();
    public ArrayList<String> i = new ArrayList<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.d("TAG_MESSAGING", "pingRunnable start done=" + mi4.this.d, 3);
            if (mi4.this.d || mi4.this.b == null || !mi4.this.b.u()) {
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = mi4.j;
            if (j > 0 && jCurrentTimeMillis - j > mi4.this.f) {
                if (jCurrentTimeMillis - mi4.this.g < r0.f) {
                    LogUtil.d("TAG_MESSAGING", "pingRunnable timeout", 3);
                    mi4.this.d = true;
                    mi4.this.b.r.b(new ManualException("ping time out"));
                    return;
                }
            }
            mi4.this.g = jCurrentTimeMillis;
            String strA = kb4.a();
            mi4.this.b.k(PingProto.Ping.newBuilder().setMid(strA).build(), strA);
            LogUtil.d("TAG_MESSAGING", "send ping packet" + strA, 3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends HashMap<String, Object> {
        public b() {
            put("action", LogUtil.NETWORK_LOG);
            put("status", "disconnect connection on ping detect failed");
        }
    }

    public mi4(xo6 xo6Var) {
        this.e = 240000;
        this.f = 720000;
        this.b = xo6Var;
        if (xo6Var.e() != null) {
            this.e = (int) this.b.e().b();
            this.f = (int) this.b.e().c();
        }
        f();
    }

    public void e() {
        if (!this.f19226a.isAlive() || this.c == null) {
            LogUtil.i("ping_detect", "ping thread is not alive", 1);
            return;
        }
        this.i.clear();
        this.c.removeMessages(0);
        this.c.removeMessages(1);
        Handler handler = this.c;
        handler.sendMessageDelayed(handler.obtainMessage(0, 3, 0, null), 0L);
        this.c.sendEmptyMessageDelayed(1, 10000L);
        LogUtil.i("ping_detect", "detect connection start", 1);
    }

    public void f() {
        this.d = false;
        this.f19226a = new HandlerThread(mi4.class.getSimpleName());
    }

    public void g(String str) {
        boolean zContains = this.i.contains(str);
        LogUtil.i("ping_detect", "onReceivePingReply mid=" + str + "isContain =" + zContains, 1);
        if (zContains) {
            this.c.removeMessages(0);
            this.c.removeMessages(1);
            this.i.clear();
        }
    }

    public void h() {
        Handler handler;
        if (!this.f19226a.isAlive() || (handler = this.c) == null) {
            LogUtil.d("TAG_MESSAGING", "ping thread is not alive", 3);
        } else {
            handler.post(this.h);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        xo6 xo6Var;
        xo6 xo6Var2;
        jb4 jb4Var;
        int i = message.what;
        if (i == 0) {
            int i2 = message.arg1;
            LogUtil.i("ping_detect", "handleMessage MSG_WHAT_DETECT_CONNECTION index=" + i2, 1);
            if (!this.d && (xo6Var = this.b) != null && xo6Var.u()) {
                LogUtil.i("ping_detect", "handleMessage MSG_WHAT_DETECT_CONNECTION ping", 1);
                String strA = kb4.a();
                this.i.add(strA);
                this.b.k(PingProto.Ping.newBuilder().setMid(strA).build(), strA);
                if (i2 > 0) {
                    Handler handler = this.c;
                    handler.sendMessageDelayed(handler.obtainMessage(0, i2 - 1, 0, null), 500L);
                }
            }
        } else if (i == 1) {
            LogUtil.i("ping_detect", "handleMessage MSG_WHAT_RECONNECT reconnect", 1);
            if (!this.d && (xo6Var2 = this.b) != null && xo6Var2.u() && (jb4Var = this.b.r) != null) {
                jb4Var.b(new ManualException("disconnect connection on ping detect failed"));
                LogUtil.i("ping_detect", LogUtil.LogType.LOG_TYPE_BACKGROUND_NETWORK, 3, new b(), (Throwable) null);
            }
        }
        return true;
    }

    public void i() {
        this.d = true;
        this.f19226a.quit();
    }

    public void j() {
        try {
            this.f19226a.start();
            this.c = new Handler(this.f19226a.getLooper(), this);
            j = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
