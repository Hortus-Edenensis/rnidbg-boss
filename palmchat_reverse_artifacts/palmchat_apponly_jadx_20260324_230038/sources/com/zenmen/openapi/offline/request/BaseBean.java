package com.zenmen.openapi.offline.request;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class BaseBean {
    public static final String SUCCESS = "0";
    private String retCd;
    private String retMsg;

    public static boolean isSuccess(BaseBean baseBean) {
        if (baseBean != null) {
            return "0".equals(baseBean.getRetCd());
        }
        return false;
    }

    public String getRetCd() {
        return this.retCd;
    }

    public String getRetMsg() {
        return this.retMsg;
    }

    public void setRetCd(String str) {
        this.retCd = str;
    }

    public void setRetMsg(String str) {
        this.retMsg = str;
    }
}
