package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import com.wifi.ad.core.config.adx.WkAdxAdConfigMg;
import com.zenmen.palmchat.config.userdivide.bean.ConfigItem;
import com.zenmen.palmchat.config.userdivide.bean.Configs;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class t66 {
    public static t66 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f20914a;
    public long b;
    public ConcurrentHashMap<String, String> c = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<Configs>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f20915a;
        public final /* synthetic */ String b;

        public a(boolean z, String str) {
            this.f20915a = z;
            this.b = str;
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            HashMap map = new HashMap();
            if (!this.f20915a) {
                map.put("version", this.b);
            }
            sw4 sw4VarF = sw4.b(1, t66.this.k(), map).f(false);
            sw4VarF.g = true;
            sw4VarF.h = false;
            return sw4VarF;
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<Configs> lXBaseNetBean, Exception exc) {
            if (!z || lXBaseNetBean == null || !lXBaseNetBean.isSuccess()) {
                LogUtil.logCurrentStack("UserDivideManager");
                return;
            }
            LogUtil.json("UserDivideManager", az2.c(lXBaseNetBean.data), "onResult success ");
            Configs configs = lXBaseNetBean.data;
            if (configs != null) {
                t66.this.n(configs, this.f20915a);
                SPUtil.f14322a.t(SPUtil.SCENE.USER_DIVIDE, "key_user_divide_config", new JSONObject(t66.this.c).toString());
            }
            SPUtil sPUtil = SPUtil.f14322a;
            SPUtil.SCENE scene = SPUtil.SCENE.USER_DIVIDE;
            sPUtil.t(scene, "key_user_divide_update_time", Long.valueOf(ir5.b()));
            if (this.f20915a) {
                sPUtil.t(scene, "key_user_divide_update_reset_time", Long.valueOf(ir5.b()));
            }
        }
    }

    public static t66 h() {
        if (d == null) {
            synchronized (t66.class) {
                if (d == null) {
                    d = new t66();
                }
            }
        }
        return d;
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.c.entrySet()) {
            sb.append(entry.getKey() + "," + entry.getValue() + "\n");
        }
        return sb.toString();
    }

    public String e(String str, String str2) {
        String str3 = this.c.get(str);
        return str3 == null ? str2 : str3;
    }

    public boolean f(String str, boolean z) {
        String str2 = this.c.get(str);
        return str2 == null ? z : str2.equals(WkAdxAdConfigMg.DSP_NAME_BAIDU);
    }

    public boolean g(String str) {
        String strE = e(str, "A");
        return (strE == null || strE.equals("A")) ? false : true;
    }

    public final long i() {
        String str = this.c.get("UD_PREFIX_request_interval");
        if (!TextUtils.isEmpty(str)) {
            long j = Long.parseLong(str);
            if (j > 0) {
                return j * 1000;
            }
        }
        return 300000L;
    }

    public final long j() {
        String str = this.c.get("UD_PREFIX_request_reset_interval");
        if (!TextUtils.isEmpty(str)) {
            long j = Long.parseLong(str);
            if (j > 0) {
                return j * 1000;
            }
        }
        return 86400000L;
    }

    public final String k() {
        Uri.Builder builderBuildUpon = Uri.parse(nl0.z + "/exp-distr.query.exp.list.v2").buildUpon();
        String strA = xn3.a();
        String str = ac1.h;
        builderBuildUpon.appendQueryParameter("requestId", strA);
        String str2 = strA.substring(0, strA.length() - 1) + str + strA.substring(strA.length() - 1);
        builderBuildUpon.appendQueryParameter("sign", rb3.c(str2));
        LogUtil.e("UserDivideManager", "getUrl" + str2 + " requestId=" + strA);
        return builderBuildUpon.build().toString();
    }

    public void l() {
        LogUtil.i("UserDivideManager", "init");
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.USER_DIVIDE;
        this.f20914a = sPUtil.i(scene, "key_user_divide_update_time", 0L);
        this.b = sPUtil.i(scene, "key_user_divide_update_reset_time", 0L);
        String strN = sPUtil.n(scene, "key_user_divide_config", "");
        if (!TextUtils.isEmpty(strN)) {
            try {
                JSONObject jSONObject = new JSONObject(strN);
                LogUtil.i("UserDivideManager", "init jsonObject=" + jSONObject);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    this.c.put(next, jSONObject.getString(next));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                LogUtil.i("UserDivideManager", "init error", e);
            }
        }
        LogUtil.i("UserDivideManager", "init end");
    }

    public void m(String str, boolean z) {
        boolean z2;
        LogUtil.i("UserDivideManager", "update1111 start reason =" + str + " force =" + z);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ((Math.abs(jCurrentTimeMillis - this.f20914a) <= i() || !ap3.a().i()) && !z) {
            return;
        }
        this.f20914a = jCurrentTimeMillis;
        if ((Math.abs(jCurrentTimeMillis - this.b) <= j() || !ap3.a().i()) && !z) {
            z2 = false;
        } else {
            this.b = jCurrentTimeMillis;
            z2 = true;
        }
        String str2 = this.c.get("UD_PREFIX_version");
        if (str2 == null || z2) {
            str2 = "0";
        }
        boolean zEquals = "0".equals(str2);
        LogUtil.i("UserDivideManager", "update start reason =" + str + " force =" + z + "requestVersion=" + str2 + " isreset =" + zEquals);
        zw4.e(new a(zEquals, str2));
    }

    public final void n(Configs configs, boolean z) {
        if (configs != null) {
            if (z) {
                this.c.clear();
                this.c.put("UD_PREFIX_request_interval", String.valueOf(configs.incrementSyncTime));
                this.c.put("UD_PREFIX_request_reset_interval", String.valueOf(configs.fullSyncTime));
            }
            this.c.put("UD_PREFIX_version", String.valueOf(configs.version));
            ArrayList<ConfigItem> arrayList = configs.userExpGroupRespList;
            if (arrayList != null) {
                for (ConfigItem configItem : arrayList) {
                    if (!TextUtils.isEmpty(configItem.expKey) && !TextUtils.isEmpty(configItem.expVal)) {
                        this.c.put(configItem.expKey, configItem.expVal);
                    }
                }
            }
        }
    }
}
