package defpackage;

import android.content.Intent;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.messaging.MessagingService;
import com.zenmen.palmchat.utils.log.LogUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class x03 {
    public static volatile x03 c;
    public volatile boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gs3 f21849a = new yd5();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i("LXMsgCoreClient", "init start");
            x03.this.f();
            x03.this.g(false, "STASRT_REASON_INIT");
        }
    }

    public static x03 d() {
        if (c == null) {
            synchronized (x03.class) {
                if (c == null) {
                    c = new x03();
                }
            }
        }
        return c;
    }

    public fn2 c() {
        return this.f21849a.b();
    }

    public void e() {
        LogUtil.i("LXMsgCoreClient", "init");
        de5.b().c().execute(new a());
    }

    public final void f() {
        this.f21849a.a();
        this.b = true;
    }

    public void g(boolean z, String str) {
        LogUtil.i("LXMsgCoreClient", "initMessagingService" + z + "  " + this.b + "  " + str);
        if (this.b) {
            try {
                Intent intent = new Intent(AppContext.getContext(), (Class<?>) MessagingService.class);
                intent.putExtra("extra_reset_sk", z);
                intent.putExtra("extra_reason", str);
                AppContext.getContext().startService(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void b() {
    }
}
