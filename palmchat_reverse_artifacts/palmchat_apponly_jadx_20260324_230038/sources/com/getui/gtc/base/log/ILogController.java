package com.getui.gtc.base.log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public interface ILogController {
    boolean isLoggable(int i, String str);

    void log(int i, String str, String str2, Throwable th);
}
