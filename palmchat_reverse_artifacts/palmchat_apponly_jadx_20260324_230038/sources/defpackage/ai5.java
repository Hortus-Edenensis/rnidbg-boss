package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.tag.config.FindFriendFilterGuideConfig;
import com.zenmen.square.tag.config.SquareChatConfig;
import com.zenmen.square.tag.config.SquareConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ai5 {
    public static ai5 o;
    public static final String p = nl0.z + "/guide.cfg.v1";
    public long i;
    public long j;
    public FindFriendFilterGuideConfig l;
    public long m;
    public jj5 n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1233a = "SquareConfigManger";
    public long b = -1;
    public final long c = 300000;
    public SquareConfig d = null;
    public SquareChatConfig e = null;
    public final int f = 50;
    public final int g = 100;
    public JSONObject h = null;
    public long k = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends yw4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1234a;

        public a(boolean z) {
            this.f1234a = z;
        }

        @Override // defpackage.yw4
        public void onFail(Exception exc) {
            exc.printStackTrace();
            LogUtil.i("SquareConfigManger", "onFail" + exc);
        }

        @Override // defpackage.yw4
        public void onSuccess(JSONObject jSONObject, yy2 yy2Var) {
            LogUtil.i("SquareConfigManger", "onSuccess" + jSONObject);
            LogUtil.i("logsquare", "onSuccess: " + jSONObject);
            if (yy2Var == null || !yy2Var.f22300a || yy2Var.d == null) {
                return;
            }
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.SQUARE_CONFIG;
            sPUtil.t(scene, "key_square_config_updatetime", Long.valueOf(ai5.this.b));
            try {
                SquareConfig squareConfig = (SquareConfig) az2.a(yy2Var.d.toString(), SquareConfig.class);
                LogUtil.i("SquareConfigManger", "ConfigInfo" + squareConfig);
                if (ai5.this.q(squareConfig)) {
                    if (this.f1234a) {
                        ai5.this.d = squareConfig;
                    } else {
                        ai5.this.j().setTags(squareConfig.getTags());
                    }
                    sPUtil.t(scene, "key_square_config_guide", az2.c(ai5.this.d));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ai5() {
        p();
    }

    public static ai5 k() {
        if (o == null) {
            synchronized (ai5.class) {
                if (o == null) {
                    o = new ai5();
                }
            }
        }
        return o;
    }

    public void e(List<SquareTagBean> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (SquareTagBean squareTagBean : list) {
            SquareTagBean squareTagBeanN = n(squareTagBean.getId());
            if (squareTagBeanN != null) {
                squareTagBean.setName(squareTagBeanN.getName());
                squareTagBean.setPicUrl(squareTagBeanN.getPicUrl());
            }
        }
    }

    public yh5 f(String str) {
        yh5 yh5Var;
        JSONObject config = vs0.a().getConfig(str);
        if (config != null) {
            try {
                yh5Var = (yh5) az2.a(config.toString(), yh5.class);
            } catch (Exception e) {
                e.printStackTrace();
                yh5Var = null;
            }
        } else {
            yh5Var = null;
        }
        if (yh5Var == null) {
            yh5Var = new yh5();
        }
        yh5Var.d(str);
        return yh5Var;
    }

    public SquareChatConfig g() {
        if (this.e == null || System.currentTimeMillis() - this.j > 5000) {
            this.j = System.currentTimeMillis();
            JSONObject config = vs0.a().getConfig("squarePrivateChatButtonName");
            if (config != null) {
                try {
                    this.e = (SquareChatConfig) az2.a(config.toString(), SquareChatConfig.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.e == null) {
                this.e = new SquareChatConfig();
            }
        }
        return this.e;
    }

    public void h() {
        if (this.h == null || System.currentTimeMillis() - this.i > 300000) {
            JSONObject config = vs0.a().getConfig("Square_Preview");
            this.h = config;
            if (config != null) {
                this.i = System.currentTimeMillis();
            }
        }
    }

    public FindFriendFilterGuideConfig i() {
        if (System.currentTimeMillis() - this.k > 60000) {
            String strB = vs0.a().b("ffriend_popup");
            if (!TextUtils.isEmpty(strB)) {
                try {
                    this.l = (FindFriendFilterGuideConfig) az2.a(strB, FindFriendFilterGuideConfig.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.k = System.currentTimeMillis();
        }
        if (this.l == null) {
            this.l = new FindFriendFilterGuideConfig();
        }
        return this.l;
    }

    public SquareConfig j() {
        if (this.d == null) {
            String strN = SPUtil.f14322a.n(SPUtil.SCENE.SQUARE_CONFIG, "key_square_config_guide", "");
            this.d = new SquareConfig();
            LogUtil.i("SquareConfigManger", "init   configstr=" + strN);
            if (!TextUtils.isEmpty(strN)) {
                try {
                    SquareConfig squareConfig = (SquareConfig) az2.a(strN, SquareConfig.class);
                    if (q(squareConfig)) {
                        this.d = squareConfig;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return this.d;
    }

    public final long l() {
        if (this.b == -1) {
            this.b = SPUtil.f14322a.i(SPUtil.SCENE.SQUARE_CONFIG, "key_square_config_updatetime", 0L);
        }
        return this.b;
    }

    public jj5 m() {
        if (this.n == null || System.currentTimeMillis() - this.m > 5000) {
            this.m = System.currentTimeMillis();
            try {
                this.n = new jj5(vs0.a().getConfig("post_config").toString());
            } catch (Exception e) {
                e.printStackTrace();
                if (this.n == null) {
                    this.n = new jj5();
                }
            }
        }
        return this.n;
    }

    public SquareTagBean n(int i) {
        SquareConfig squareConfigJ = j();
        if (squareConfigJ == null) {
            return null;
        }
        for (SquareTagBean squareTagBean : squareConfigJ.getTags()) {
            if (squareTagBean.getId() == i) {
                return squareTagBean;
            }
        }
        return null;
    }

    public List<SquareTagBean> o(List<Integer> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            SquareTagBean squareTagBeanN = n(it.next().intValue());
            if (squareTagBeanN != null) {
                arrayList.add(squareTagBeanN);
            }
        }
        return arrayList;
    }

    public final boolean q(SquareConfig squareConfig) {
        return (squareConfig == null || squareConfig.getTags() == null || squareConfig.getTags().size() <= 0) ? false : true;
    }

    public void r(Context context, String str, boolean z) {
        LogUtil.i("SquareConfigManger", "update start " + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - l()) > 300000) {
            LogUtil.i("SquareConfigManger", "update start1");
            this.b = jCurrentTimeMillis;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("guide", z ? 1 : 0);
                LogUtil.i("SquareConfigManger", "update params = " + jSONObject);
                zw4.a().c(p, 1, jSONObject, new a(z), true, false);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public final void p() {
    }
}
