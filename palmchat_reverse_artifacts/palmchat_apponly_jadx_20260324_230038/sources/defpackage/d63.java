package defpackage;

import android.content.Context;
import com.wifi.ad.core.WifiNestAd;
import com.zenmen.palmchat.c;
import com.zenmen.palmchat.thread.worker.TaskType;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class d63 {
    public static d63 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Executor f16983a;
    public b45 b;

    /* JADX INFO: compiled from: SearchBox */
    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LogUtil.LogType f16984a;
        public String b;

        public a(LogUtil.LogType logType, String str) {
            this.f16984a = logType;
            this.b = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16985a = b.class.getSimpleName();
        public a b;

        public b(a aVar) {
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!hx3.m(null)) {
                d63.a().e(this.b);
                return;
            }
            try {
                g63 g63Var = new g63();
                String str = sk5.b;
                a aVar = this.b;
                JSONObject jSONObjectE = g63Var.e(str, aVar.f16984a.value, aVar.b, null);
                if (jSONObjectE == null || jSONObjectE.getInt("resultCode") != 0) {
                    d63.a().e(this.b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static d63 a() {
        if (c == null) {
            synchronized (d63.class) {
                if (c == null) {
                    c = new d63();
                }
            }
        }
        return c;
    }

    public final void b(LogUtil.LogType logType, String str) {
        Executor executor = this.f16983a;
        if (executor != null) {
            try {
                executor.execute(new b(new a(logType, str)));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void c(Context context) {
        if (context != null) {
            this.f16983a = l13.b(TaskType.LOG);
            this.b = new b45(context);
        }
    }

    public void d(LogUtil.LogType logType, String str, boolean z) {
        if (this.f16983a == null || this.b == null) {
            return;
        }
        int iA = b63.a().b().a(logType);
        if (z && logType == LogUtil.LogType.LOG_TYPE_BACKGROUP && iA == 0) {
            logType = LogUtil.LogType.LOG_TYPE_BACKGROUP_FAIL;
            iA = b63.a().b().a(logType);
        }
        if ((!ap3.a().i() || (c.a().isBackground() && ap3.a().F())) && iA == 2) {
            iA = 1;
        }
        if (iA == 2) {
            b(logType, str);
            return;
        }
        if (iA == 1) {
            if (!WifiNestAd.INSTANCE.getBackDoorResult() || logType != LogUtil.LogType.LOG_TYPE_ANR_NEW) {
                this.b.a(new a(logType, str));
            } else {
                LogUtil.d("", "log4ClientError CONFIG_IMMEDIATE_UPLOAD 8003");
                b(logType, str);
            }
        }
    }

    public void e(a aVar) {
        b45 b45Var = this.b;
        if (b45Var != null) {
            b45Var.a(aVar);
        }
    }

    public void f(boolean z) {
        b45 b45Var = this.b;
        if (b45Var != null) {
            b45Var.k(z);
        }
    }
}
