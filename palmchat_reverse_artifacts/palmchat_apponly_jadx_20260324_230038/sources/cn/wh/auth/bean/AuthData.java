package cn.wh.auth.bean;

import com.fort.andJni.JniLib1716343241;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class AuthData {
    private String certPwdData;
    private String extrasData;
    private String idCardAuthData;
    private String verifyData;

    public AuthData() {
        JniLib1716343241.cV(this, 10);
    }

    public String getCertPwdData() {
        return this.certPwdData;
    }

    public String getExtrasData() {
        return this.extrasData;
    }

    public String getIdCardAuthData() {
        return this.idCardAuthData;
    }

    public String getVerifyData() {
        return this.verifyData;
    }

    public void setCertPwdData(String str) {
        this.certPwdData = str;
    }

    public void setExtrasData(String str) {
        this.extrasData = str;
    }

    public void setIdCardAuthData(String str) {
        this.idCardAuthData = str;
    }

    public void setVerifyData(String str) {
        this.verifyData = str;
    }

    public String toString() {
        return (String) JniLib1716343241.cL(this, 9);
    }
}
