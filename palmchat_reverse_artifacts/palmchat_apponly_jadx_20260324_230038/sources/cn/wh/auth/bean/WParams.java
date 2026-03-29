package cn.wh.auth.bean;

import com.fort.andJni.JniLib1716343241;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class WParams {
    private String appID;
    private String bizSeq;
    private String extras;
    private String orgID;
    private int type;

    public WParams(String str, String str2, int i) {
        JniLib1716343241.cV(this, str, str2, Integer.valueOf(i), 18);
    }

    public String getAppID() {
        return this.appID;
    }

    public String getBizSeq() {
        return this.bizSeq;
    }

    public String getExtras() {
        return this.extras;
    }

    public String getOrgID() {
        return this.orgID;
    }

    public int getType() {
        return this.type;
    }

    public void setBizSeq(String str) {
        this.bizSeq = str;
    }

    public void setExtras(String str) {
        this.extras = str;
    }

    public String toString() {
        return (String) JniLib1716343241.cL(this, 17);
    }

    public WParams(String str, String str2, String str3, int i) {
        JniLib1716343241.cV(this, str, str2, str3, Integer.valueOf(i), 19);
    }

    public WParams(String str, String str2, String str3, int i, String str4) {
        JniLib1716343241.cV(this, str, str2, str3, Integer.valueOf(i), str4, 20);
    }
}
