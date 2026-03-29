package com.zenmen.openapi.offline.request;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class FetchPkgInfo {
    private String downloadUrl;
    private String extId;
    private String md5;
    private int verCode;

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getExtId() {
        return this.extId;
    }

    public String getMd5() {
        return this.md5;
    }

    public int getVerCode() {
        return this.verCode;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setExtId(String str) {
        this.extId = str;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setVerCode(int i) {
        this.verCode = i;
    }
}
