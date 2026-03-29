package com.zm.fda.busi;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IPubParams extends Serializable {
    boolean collectCrash();

    String getAndroidId();

    String getAppId();

    String getCarrier();

    String getChanId();

    List<String> getCrashKeyword();

    String getDHID();

    String getIMEI();

    String getLati();

    String getLongi();

    String getMac();

    String getOaid();

    String getProjectId();

    long getProjectVerCode();

    String getProjectVerName();
}
