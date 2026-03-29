package com.bytedance.sdk.openadsdk.mediation.ad;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class MediationNativeAdAppInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Object> f5422a;
    private String b;
    private long fx;
    private String iz;
    private String jk;
    private String n;
    private String nr;
    private Map<String, String> pn;
    private String u;
    private String x;

    public Map<String, Object> getAppInfoExtra() {
        return this.f5422a;
    }

    public String getAppName() {
        return this.u;
    }

    public String getAuthorName() {
        return this.nr;
    }

    public String getFunctionDescUrl() {
        return this.n;
    }

    public long getPackageSizeBytes() {
        return this.fx;
    }

    public Map<String, String> getPermissionsMap() {
        return this.pn;
    }

    public String getPermissionsUrl() {
        return this.b;
    }

    public String getPrivacyAgreement() {
        return this.iz;
    }

    public String getRegUrl() {
        return this.jk;
    }

    public String getVersionName() {
        return this.x;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.f5422a = map;
    }

    public void setAppName(String str) {
        this.u = str;
    }

    public void setAuthorName(String str) {
        this.nr = str;
    }

    public void setFunctionDescUrl(String str) {
        this.n = str;
    }

    public void setPackageSizeBytes(long j) {
        this.fx = j;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.pn = map;
    }

    public void setPermissionsUrl(String str) {
        this.b = str;
    }

    public void setPrivacyAgreement(String str) {
        this.iz = str;
    }

    public void setRegUrl(String str) {
        this.jk = str;
    }

    public void setVersionName(String str) {
        this.x = str;
    }
}
