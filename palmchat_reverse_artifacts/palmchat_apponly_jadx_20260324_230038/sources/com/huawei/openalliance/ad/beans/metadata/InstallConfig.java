package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class InstallConfig implements Serializable {
    private static final long serialVersionUID = 546555599564481045L;
    private String appBtnInstallWay;
    private String contentBtnInstallWay;
    private String creativeInstallWay;

    public String Code() {
        return this.creativeInstallWay;
    }

    public String I() {
        return this.contentBtnInstallWay;
    }

    public String V() {
        return this.appBtnInstallWay;
    }

    public void Code(String str) {
        this.creativeInstallWay = str;
    }

    public void I(String str) {
        this.contentBtnInstallWay = str;
    }

    public void V(String str) {
        this.appBtnInstallWay = str;
    }
}
