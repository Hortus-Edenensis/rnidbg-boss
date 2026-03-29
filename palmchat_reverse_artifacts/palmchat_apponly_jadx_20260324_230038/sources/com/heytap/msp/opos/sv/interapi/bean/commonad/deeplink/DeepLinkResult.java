package com.heytap.msp.opos.sv.interapi.bean.commonad.deeplink;

import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class DeepLinkResult implements Serializable {
    private static final long serialVersionUID = 2189658255253768729L;
    private int code;
    private String msg;

    public DeepLinkResult(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isSuccess() {
        return getCode() == 0;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "DeepLinkResult{code=" + this.code + ", msg='" + this.msg + "'}";
    }
}
