package defpackage;

import android.os.Looper;
import android.text.TextUtils;
import com.zenmen.palmchat.crash.CrashWhiteListConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class br0 {
    public static br0 b = new br0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CrashWhiteListConfig f1803a = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Exception {
            while (true) {
                try {
                    Looper.loop();
                } catch (Exception e) {
                    e.printStackTrace();
                    boolean zG = br0.this.g(e);
                    LogUtil.i("CrashWhiteListProcessor", "onLoopException isInWhiteList=" + zG, e);
                    if (!zG) {
                        throw e;
                    }
                }
            }
        }
    }

    public static br0 d() {
        return b;
    }

    public final CrashWhiteListConfig b() {
        if (this.f1803a == null) {
            this.f1803a = c();
        }
        return this.f1803a;
    }

    public final CrashWhiteListConfig c() {
        JSONObject config = vs0.a().getConfig("android_crash_whitelist");
        CrashWhiteListConfig crashWhiteListConfig = config != null ? (CrashWhiteListConfig) az2.a(config.toString(), CrashWhiteListConfig.class) : null;
        return crashWhiteListConfig == null ? new CrashWhiteListConfig() : crashWhiteListConfig;
    }

    public void e() {
        if (f()) {
            LogUtil.i("CrashWhiteListProcessor", "init");
            u93.b(0, new a());
        }
    }

    public final boolean f() {
        CrashWhiteListConfig crashWhiteListConfigB = b();
        if (crashWhiteListConfigB != null) {
            return crashWhiteListConfigB.enable;
        }
        return false;
    }

    public final boolean g(Exception exc) {
        CrashWhiteListConfig crashWhiteListConfigB = b();
        if (crashWhiteListConfigB == null) {
            return false;
        }
        String strMatch = crashWhiteListConfigB.match(com.zenmen.palmchat.utils.log.a.b(exc));
        boolean z = !TextUtils.isEmpty(strMatch);
        if (!z) {
            return z;
        }
        HashMap map = new HashMap();
        map.put("tag", strMatch);
        LogUtil.log4ClientError("crash_whitelist", map, exc, true);
        return z;
    }
}
