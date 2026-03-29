package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class vu2 {
    public static volatile vu2 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21530a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<String>> {
        public a() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            sw4 sw4VarB = sw4.b(0, "https://openapi-ipv6.lianxinapp.com/outerchannel/requestInfo", new HashMap());
            sw4VarB.h = false;
            sw4VarB.g = true;
            return sw4VarB;
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<String> lXBaseNetBean, Exception exc) {
            JSONObject jSONObject;
            if (!z || lXBaseNetBean == null || (jSONObject = lXBaseNetBean.originData) == null) {
                return;
            }
            String string = jSONObject.toString();
            vu2.this.f21530a = string;
            SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_ip_info", string);
            LogUtil.i("IpInfoManager", "onResult ipInfo=" + vu2.this.f21530a);
        }
    }

    public vu2() {
        this.f21530a = null;
        this.f21530a = SPUtil.f14322a.n(SPUtil.SCENE.APP_COMMON, "key_ip_info", "");
        LogUtil.i("IpInfoManager", "init ipInfo=" + this.f21530a);
    }

    public static vu2 c() {
        if (b == null) {
            synchronized (vu2.class) {
                if (b == null) {
                    b = new vu2();
                }
            }
        }
        return b;
    }

    public String d() {
        LogUtil.i("IpInfoManager", "getIpInfo ipInfo=" + this.f21530a);
        return this.f21530a;
    }

    public void e() {
        boolean zIsEmpty = TextUtils.isEmpty(v4.e(AppContext.getContext()));
        LogUtil.i("IpInfoManager", "request ipInfo=" + this.f21530a + " needLogin=" + zIsEmpty);
        if (zIsEmpty) {
            zw4.e(new a());
        }
    }
}
