package com.heytap.msp.opos.sv.interapi.bean.commonad.deeplink;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class DeepLinkRequest implements Serializable {
    private static final long serialVersionUID = 2349830737186081360L;
    private String deepLinkUrl;
    private String dpRequestId;
    private String dpToken;
    private String pkgName;
    private String reqId;

    public String getDeepLinkUrl() {
        return this.deepLinkUrl;
    }

    public String getDpRequestId() {
        return this.dpRequestId;
    }

    public String getDpToken() {
        return this.dpToken;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getReqId() {
        return this.reqId;
    }

    public void setDeepLinkUrl(String str) {
        this.deepLinkUrl = str;
    }

    public void setDpRequestId(String str) {
        this.dpRequestId = str;
    }

    public void setDpToken(String str) {
        this.dpToken = str;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setReqId(String str) {
        this.reqId = str;
    }

    public String toString() {
        return "DeepLinkRequest{deepLinkUrl='" + this.deepLinkUrl + "', dpToken='" + this.dpToken + "', reqId='" + this.reqId + "', pkgName='" + this.pkgName + "', dpRequestId='" + this.dpRequestId + "'}";
    }
}
