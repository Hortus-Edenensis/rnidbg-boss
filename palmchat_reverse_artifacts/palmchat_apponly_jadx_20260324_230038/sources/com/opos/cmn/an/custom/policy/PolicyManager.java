package com.opos.cmn.an.custom.policy;

import android.text.TextUtils;
import com.opos.cmn.an.f.a;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PolicyManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f7739a = new byte[0];
    private static volatile PolicyManager b;
    private PolicyConfig c = null;

    private PolicyManager() {
    }

    public static PolicyManager getInstance() {
        if (b == null) {
            synchronized (f7739a) {
                if (b == null) {
                    b = new PolicyManager();
                }
            }
        }
        return b;
    }

    public boolean canReadUserData(String str) {
        PolicyConfig policyConfig;
        Map<String, Boolean> map;
        boolean zBooleanValue = (TextUtils.isEmpty(str) || (policyConfig = this.c) == null || (map = policyConfig.canReadUserDataMap) == null || !map.containsKey(str)) ? true : this.c.canReadUserDataMap.get(str).booleanValue();
        a.b("PolicyManager", "canReadUserData key=" + str + ",value=" + zBooleanValue);
        return zBooleanValue;
    }

    public PolicyConfig getPolicyConfig() {
        return this.c;
    }

    public synchronized void setPolicyConfig(PolicyConfig policyConfig) {
        if (this.c == null && policyConfig != null) {
            this.c = policyConfig;
        }
        a.b("PolicyManager", "setPolicyConfig mPolicyConfig=" + this.c);
    }
}
