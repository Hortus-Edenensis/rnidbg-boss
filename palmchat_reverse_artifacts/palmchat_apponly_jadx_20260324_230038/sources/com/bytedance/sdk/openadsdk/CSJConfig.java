package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class CSJConfig implements AdConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f5189a;
    private String b;
    private boolean fx;
    private int iz;
    private boolean jk;
    private int k;
    private TTCustomController l;
    private int mv;
    private boolean my;
    private boolean n;
    private String nr;
    private IMediationConfig o;
    private String pn;
    private int s;
    private Map<String, Object> t;
    private String u;
    private boolean x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int[] f5190a;
        private String b;
        private boolean k;
        private int l;
        private IMediationConfig my;
        private String nr;
        private String pn;
        private TTCustomController t;
        private String u;
        private boolean fx = false;
        private int iz = 0;
        private boolean x = true;
        private boolean n = false;
        private boolean jk = false;
        private int mv = 2;
        private int s = 0;
        private Map<String, Object> o = null;

        public u b(String str) {
            this.pn = str;
            return this;
        }

        public u fx(String str) {
            this.b = str;
            return this;
        }

        public u nr(String str) {
            this.nr = str;
            return this;
        }

        public u pn(boolean z) {
            this.k = z;
            return this;
        }

        public u u(String str) {
            this.u = str;
            return this;
        }

        public u b(boolean z) {
            this.jk = z;
            return this;
        }

        public u fx(boolean z) {
            this.n = z;
            return this;
        }

        public u nr(boolean z) {
            this.x = z;
            return this;
        }

        public u u(boolean z) {
            this.fx = z;
            return this;
        }

        public u b(int i) {
            this.s = i;
            return this;
        }

        public u fx(int i) {
            this.mv = i;
            return this;
        }

        public u nr(int i) {
            this.l = i;
            return this;
        }

        public u u(int i) {
            this.iz = i;
            return this;
        }

        public u u(int... iArr) {
            this.f5190a = iArr;
            return this;
        }

        public u u(TTCustomController tTCustomController) {
            this.t = tTCustomController;
            return this;
        }

        public u u(IMediationConfig iMediationConfig) {
            this.my = iMediationConfig;
            return this;
        }

        public u u(String str, Object obj) {
            if (this.o == null) {
                this.o = new HashMap();
            }
            this.o.put(str, obj);
            return this;
        }
    }

    public CSJConfig(u uVar) {
        this.fx = false;
        this.iz = 0;
        this.x = true;
        this.n = false;
        this.jk = false;
        this.u = uVar.u;
        this.nr = uVar.nr;
        this.fx = uVar.fx;
        this.b = uVar.b;
        this.pn = uVar.pn;
        this.iz = uVar.iz;
        this.x = uVar.x;
        this.n = uVar.n;
        this.f5189a = uVar.f5190a;
        this.jk = uVar.jk;
        this.l = uVar.t;
        this.mv = uVar.l;
        this.k = uVar.s;
        this.s = uVar.mv;
        this.my = uVar.k;
        this.o = uVar.my;
        this.t = uVar.o;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getAgeGroup() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.u;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.nr;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.l;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.pn;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.f5189a;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Object getExtra(String str) {
        Map<String, Object> map = this.t;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public Map<String, Object> getInitExtra() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public IMediationConfig getMediationConfig() {
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getPluginUpdateConfig() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getThemeStatus() {
        return this.mv;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.iz;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.fx;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.jk;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseMediation() {
        return this.my;
    }

    public void setAgeGroup(int i) {
        this.k = i;
    }

    public void setAllowShowNotify(boolean z) {
        this.x = z;
    }

    public void setAppId(String str) {
        this.u = str;
    }

    public void setAppName(String str) {
        this.nr = str;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.l = tTCustomController;
    }

    public void setData(String str) {
        this.pn = str;
    }

    public void setDebug(boolean z) {
        this.n = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.f5189a = iArr;
    }

    public void setKeywords(String str) {
        this.b = str;
    }

    public void setPaid(boolean z) {
        this.fx = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.jk = z;
    }

    public void setThemeStatus(int i) {
        this.mv = i;
    }

    public void setTitleBarTheme(int i) {
        this.iz = i;
    }
}
