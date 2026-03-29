package defpackage;

import android.app.Activity;
import android.os.SystemClock;
import android.util.Pair;
import com.igexin.push.core.b;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.modulemanager.lifecircle.AppLifeCircleManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class dp4 {
    public static dp4 i = new dp4();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Class> f17117a = new ArrayList();
    public Pair<Long, String> b = new Pair<>(0L, b.m);
    public Pair<Long, String> c = new Pair<>(0L, b.m);
    public Pair<Pair<Long, String>, Pair<Long, String>> d = new Pair<>(new Pair(0L, b.m), new Pair(0L, b.m));
    public long e = -1;
    public long f = 0;
    public long g = 0;
    public long h = -1;

    public static dp4 a() {
        return i;
    }

    public Pair<Pair<Long, String>, Pair<Long, String>> b() {
        return new Pair<>(this.b, this.c);
    }

    public void c(Activity activity) {
        if (activity != null) {
            this.b = new Pair<>(Long.valueOf(ir5.b()), activity.getClass().getName());
        }
    }

    public void d(Activity activity) {
        if (activity != null) {
            this.c = new Pair<>(Long.valueOf(ir5.b()), activity.getClass().getName());
        }
    }

    public void e() {
        this.e = ir5.b();
    }

    public void f(int i2, int i3, Exception exc) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i2);
            jSONObject.put("action", i3);
            if (exc != null) {
                jSONObject.put("exception", exc.getMessage());
            }
            jSONObject.put("floatingwin_enable", AppContext.isFloatWindowOpAllowed(AppContext.getContext()) ? 1 : 0);
            jSONObject.put("sysVersion", ac1.d);
            jSONObject.put("manufacturer", ac1.f1194a);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("2p1", "1", null, jSONObject.toString());
    }

    public void g(int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i2);
            jSONObject.put("floatingwin_enable", AppContext.isFloatWindowOpAllowed(AppContext.getContext()) ? 1 : 0);
            Object obj = this.d.first;
            if (obj != null) {
                jSONObject.put("lastCreateActivityName", ((Pair) obj).second);
                jSONObject.put("lastCreateActivityPastTime", ir5.e(((Long) ((Pair) this.d.first).first).longValue()));
            }
            Object obj2 = this.d.second;
            if (obj2 != null) {
                jSONObject.put("lastResumeActivityName", ((Pair) obj2).second);
                jSONObject.put("lastResumeActivityPastTime", ir5.e(((Long) ((Pair) this.d.second).first).longValue()));
            }
            jSONObject.put("lastScreenOffMoveBackGapTime", this.f);
            long j = this.h;
            jSONObject.put("pullWakeCostTime", j == -1 ? 0L : ir5.e(j));
            jSONObject.put("processCreatePastTime", this.g);
            jSONObject.put("sysVersion", ac1.d);
            jSONObject.put("manufacturer", ac1.f1194a);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LogUtil.uploadInfoImmediate("2p12", "1", null, jSONObject.toString());
    }

    public void h(Pair<Pair<Long, String>, Pair<Long, String>> pair) {
        this.d = pair;
        if (this.e <= 0 || AppLifeCircleManager.getInstance().getBackgroundTime() <= 0) {
            this.f = 0L;
        } else {
            this.f = this.e - AppLifeCircleManager.getInstance().getBackgroundTime();
        }
        this.g = SystemClock.elapsedRealtime() - kc3.c().b();
        this.h = ir5.b();
    }
}
