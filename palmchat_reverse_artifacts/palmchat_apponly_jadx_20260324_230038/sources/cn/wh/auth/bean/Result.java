package cn.wh.auth.bean;

import com.fort.andJni.JniLib1716343241;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class Result {
    private String resultCode;
    private AuthData resultData;
    private String resultDesc;

    public Result() {
        JniLib1716343241.cV(this, 16);
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public AuthData getResultData() {
        return this.resultData;
    }

    public String getResultDesc() {
        return this.resultDesc;
    }

    public void setResultCode(String str) {
        this.resultCode = str;
    }

    public void setResultDesc(String str) {
        this.resultDesc = str;
    }

    public String toString() {
        return (String) JniLib1716343241.cL(this, 15);
    }
}
