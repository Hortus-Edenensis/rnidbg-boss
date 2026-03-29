package com.zenmen.palmchat.utils.dialogmanager.config;

import androidx.annotation.Keep;
import defpackage.az2;
import defpackage.vs0;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class DhidRuleConfig {
    public int cooltime = 10;
    public int maxtime = 10;
    public String[] vippop;

    public static DhidRuleConfig getConfig() {
        DhidRuleConfig dhidRuleConfig;
        JSONObject config = vs0.a().getConfig("poprule");
        return (config == null || (dhidRuleConfig = (DhidRuleConfig) az2.a(config.toString(), DhidRuleConfig.class)) == null) ? new DhidRuleConfig() : dhidRuleConfig;
    }

    public PopRuleConfig convert() {
        PopRuleConfig popRuleConfig = new PopRuleConfig();
        popRuleConfig.coolingTime = this.cooltime;
        popRuleConfig.newUserStatus = false;
        int i = this.maxtime;
        popRuleConfig.newUserShowTimes = i;
        popRuleConfig.oldUserShowTimes = i;
        popRuleConfig.excludeDialogList = this.vippop;
        return popRuleConfig;
    }
}
