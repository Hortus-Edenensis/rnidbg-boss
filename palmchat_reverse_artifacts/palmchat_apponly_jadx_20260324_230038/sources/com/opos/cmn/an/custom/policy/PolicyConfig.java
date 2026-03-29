package com.opos.cmn.an.custom.policy;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class PolicyConfig {
    public final Map<String, Boolean> canReadUserDataMap;

    /* JADX INFO: compiled from: SearchBox */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map<String, Boolean> f7738a;

        public PolicyConfig build() {
            return new PolicyConfig(this);
        }

        public Builder setCanReadUserDataMap(Map<String, Boolean> map) {
            if (map != null && map.size() > 0) {
                Map<String, Boolean> map2 = this.f7738a;
                if (map2 == null) {
                    this.f7738a = new HashMap();
                } else {
                    map2.clear();
                }
                this.f7738a.putAll(map);
            }
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class UserData {
        public static final String KEY_ANDROID_ID = "opos_android_id";
        public static final String KEY_IMEI = "opos_imei";
        public static final String KEY_SN = "opos_sn";
    }

    private PolicyConfig(Builder builder) {
        this.canReadUserDataMap = builder.f7738a;
    }

    public String toString() {
        return "PolicyConfig{canReadUserDataMap=" + this.canReadUserDataMap + '}';
    }
}
