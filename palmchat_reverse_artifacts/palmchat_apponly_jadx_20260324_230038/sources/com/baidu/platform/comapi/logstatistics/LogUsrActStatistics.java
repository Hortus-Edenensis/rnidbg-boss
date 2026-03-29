package com.baidu.platform.comapi.logstatistics;

import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class LogUsrActStatistics extends com.baidu.platform.comapi.logstatistics.a {

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final LogUsrActStatistics f4143a = new LogUsrActStatistics();
    }

    public static LogUsrActStatistics getInstance() {
        return b.f4143a;
    }

    public void addLogWithLowLevel(String str, String str2, String str3, Map<String, Object> map) {
        LogStatistics.getInstance().a(1200, 1, appendLogTag(str, str2, str3), map);
    }

    private LogUsrActStatistics() {
    }
}
