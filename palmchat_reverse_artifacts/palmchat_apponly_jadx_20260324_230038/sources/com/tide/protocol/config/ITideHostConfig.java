package com.tide.protocol.config;

import com.tide.protocol.report.IFdaReporter;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITideHostConfig {
    String getAndroidId();

    String getAppId();

    IFdaReporter getFdaReporter();

    String getHostVersion();

    int getHostVersionCode();

    double getLatitude();

    double getLongitude();

    String getOaId();

    String getPluginName();
}
