package defpackage;

import android.text.TextUtils;
import com.zenmen.palmchat.framework.network.LXBaseNetBean;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import com.zenmen.palmchat.utils.dialogmanager.config.DhidRuleConfig;
import com.zenmen.palmchat.utils.dialogmanager.config.PopRuleConfig;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class ca3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PopRuleConfig f1934a = null;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends go2<LXBaseNetBean<PopRuleConfig>> {
        public a() {
        }

        @Override // defpackage.ho2
        public sw4 getRequestArgs() {
            return sw4.b(1, nl0.z + "/app.dialog.rule.config", new HashMap());
        }

        @Override // defpackage.io2
        public void onResult(boolean z, LXBaseNetBean<PopRuleConfig> lXBaseNetBean, Exception exc) {
            PopRuleConfig popRuleConfig;
            LogUtil.i("LxDialogConfigHelper", "updateConfig request result" + az2.c(lXBaseNetBean));
            if (lXBaseNetBean == null || !lXBaseNetBean.isSuccess() || (popRuleConfig = lXBaseNetBean.data) == null) {
                return;
            }
            ca3.this.f1934a = popRuleConfig;
            SPUtil.f14322a.v(SPUtil.SCENE.APP_COMMON, "key_pop_rule_config", az2.c(lXBaseNetBean.data));
        }
    }

    public final PopRuleConfig b() {
        String strP = SPUtil.f14322a.p(SPUtil.SCENE.APP_COMMON, "key_pop_rule_config", "");
        PopRuleConfig popRuleConfig = !TextUtils.isEmpty(strP) ? (PopRuleConfig) az2.a(strP, PopRuleConfig.class) : null;
        return popRuleConfig == null ? DhidRuleConfig.getConfig().convert() : popRuleConfig;
    }

    public PopRuleConfig c() {
        if (this.f1934a == null) {
            this.f1934a = b();
        }
        LogUtil.i("LxDialogConfigHelper", "getPopRuleConfig" + az2.c(this.f1934a));
        return this.f1934a;
    }

    public void d() {
        SPUtil sPUtil = SPUtil.f14322a;
        SPUtil.SCENE scene = SPUtil.SCENE.APP_COMMON;
        if (Math.abs(sPUtil.k(scene, "key_pop_rule_config_update_time", 0L) - ir5.b()) < 1800000) {
            return;
        }
        sPUtil.v(scene, "key_pop_rule_config_update_time", Long.valueOf(ir5.b()));
        zw4.e(new a());
    }
}
