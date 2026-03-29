package defpackage;

import com.google.gson.annotations.SerializedName;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.account.AccountUtils;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class yb0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static yb0 f22168a;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<b>> {
        public a() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, nl0.z + "/muc.function.show.v1", new HashMap());
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<b> lXBaseNetBean, Exception exc) {
            LogUtil.i("CircleRiskManager", "onResult " + az2.c(lXBaseNetBean));
            if (z && lXBaseNetBean.isSuccess() && lXBaseNetBean.data != null) {
                SPUtil.f14322a.t(SPUtil.SCENE.APP_COMMON, "key_circle_risk_state" + AccountUtils.p(AppContext.getContext()), Boolean.valueOf(lXBaseNetBean.data.f22170a));
                ch.s().H();
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("funShow")
        public boolean f22170a;
    }

    public static yb0 a() {
        if (f22168a == null) {
            f22168a = new yb0();
        }
        return f22168a;
    }

    public boolean b() {
        boolean zA = SPUtil.f14322a.a(SPUtil.SCENE.APP_COMMON, "key_circle_risk_state" + AccountUtils.p(AppContext.getContext()), true);
        LogUtil.i("CircleRiskManager", "isEnable " + zA);
        return zA;
    }

    public void c(String str) {
        LogUtil.i("CircleRiskManager", "update " + str);
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        if (Math.abs(sPUtil.i(scene, "key_circle_risk_update_time" + AccountUtils.p(AppContext.getContext()), 0L) - ir5.b()) >= 300000) {
            sPUtil.t(scene, "key_circle_risk_update_time" + AccountUtils.p(AppContext.getContext()), Long.valueOf(ir5.b()));
            zw4.e(new a());
        }
    }
}
