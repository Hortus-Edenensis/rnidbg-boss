package com.zenmen.palmchat.utils.traceroutePing;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class ReportVo {
    public String address;
    public String car;
    public String clientIpInfo;
    public List<DownloadResResult> downloadResResults;
    public String localDnsInfo;
    public boolean locationPermissionGranted;
    public String modelND;

    /* JADX INFO: renamed from: net, reason: collision with root package name */
    public String f15766net;
    public String osVerND;
    public List<PingResult> pingResults;
    public String platformND;
    public String uidND;
    public String versionNameND;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class DownloadResResult {
        public long costTime;
        public boolean success;
        public String url;
    }

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class PingResult {
        public float costTime;
        public String host;
        public String ip;
        public String result;
        public boolean success;

        public PingResult(boolean z, String str, String str2, String str3, float f) {
            this.success = z;
            this.host = str;
            this.result = str2;
            this.ip = str3;
            this.costTime = f;
        }
    }
}
