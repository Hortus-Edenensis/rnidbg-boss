package defpackage;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.conversations.threadbubble.bean.ThreadsBubbleBean;
import com.zenmen.palmchat.conversations.threadbubble.bean.ThreadsBubbleEvent;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.sync.dynamic.DynamicConfig;
import com.zenmen.palmchat.sync.dynamic.DynamicItem;
import com.zenmen.palmchat.teenagersmode.TeenagersModeManager;
import com.zenmen.palmchat.utils.log.LogUtil;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class ux3 {
    public static final String e = "ux3";
    public static ux3 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f21314a;
    public ThreadsBubbleBean b;
    public long c;
    public k92 d;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Response.Listener<JSONObject> {
        public a() {
        }

        @Override // com.android.volley.Response.Listener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResponse(JSONObject jSONObject) {
            try {
                LogUtil.d(ux3.e, "getBubble: " + jSONObject.toString());
                ux3.this.c = System.currentTimeMillis();
                ux3.this.f21314a = false;
                int iOptInt = jSONObject.optInt("resultCode", -1);
                if (iOptInt == 0) {
                    ThreadsBubbleBean threadsBubbleBean = (ThreadsBubbleBean) az2.a(jSONObject.optString("data"), ThreadsBubbleBean.class);
                    if (threadsBubbleBean != null) {
                        ux3.this.b = threadsBubbleBean;
                    }
                } else if (iOptInt == -2) {
                    SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, k86.a("key_new_task_done"), Boolean.TRUE);
                    ux3.this.b = null;
                } else {
                    ux3.this.b = null;
                }
                ds0.a().b(new ThreadsBubbleEvent());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements Response.ErrorListener {
        public b() {
        }

        @Override // com.android.volley.Response.ErrorListener
        public void onErrorResponse(VolleyError volleyError) {
            ux3.this.f21314a = false;
            ds0.a().b(new ThreadsBubbleEvent());
        }
    }

    public static ux3 h() {
        if (f == null) {
            synchronized (ux3.class) {
                if (f == null) {
                    f = new ux3();
                }
            }
        }
        return f;
    }

    public void e() {
        this.b = null;
        this.c = 0L;
        this.f21314a = false;
    }

    public void f() {
        if (!k() || this.f21314a || SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, k86.a("key_new_task_done"), false) || !hx3.m(AppContext.getContext()) || Math.abs(System.currentTimeMillis() - this.c) < 1800000) {
            return;
        }
        a aVar = new a();
        b bVar = new b();
        if (this.d == null) {
            this.d = new k92();
        }
        this.d.n(aVar, bVar);
        this.f21314a = true;
    }

    public ThreadsBubbleBean g() {
        return this.b;
    }

    public boolean i() {
        ThreadsBubbleBean threadsBubbleBean;
        return k() && !TeenagersModeManager.a().d() && (threadsBubbleBean = this.b) != null && threadsBubbleBean.isEnable() && this.b.getExpiredTime() > ir5.c(true);
    }

    public boolean j() {
        return this.f21314a;
    }

    public boolean k() {
        DynamicItem dynamicConfig = rl0.h().d().getDynamicConfig(DynamicConfig.Type.NEWTASK);
        return dynamicConfig != null && dynamicConfig.isEnable();
    }

    public void l(String str, ThreadsBubbleBean threadsBubbleBean) {
        LogUtil.d(e, "receiveBubbleMessage, missionId ：" + str + " ，bean ：" + az2.c(threadsBubbleBean));
        if (threadsBubbleBean != null) {
            this.b = threadsBubbleBean;
            ds0.a().b(new ThreadsBubbleEvent());
        }
    }
}
