package com.heytap.mspsdk.log;

import android.util.Log;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class DefaultLog implements ILog {
    @Override // com.heytap.mspsdk.log.ILog
    public void d(String str, String str2) {
        d(str, str2, null);
    }

    @Override // com.heytap.mspsdk.log.ILog
    public void e(String str, String str2) {
        e(str, str2, null);
    }

    @Override // com.heytap.mspsdk.log.ILog
    public void i(String str, String str2) {
        i(str, str2, null);
    }

    @Override // com.heytap.mspsdk.log.ILog
    public void log(int i, String str, String str2) {
        log(i, str, str2, false);
    }

    @Override // com.heytap.mspsdk.log.ILog
    public void v(String str, String str2) {
        v(str, str2, null);
    }

    @Override // com.heytap.mspsdk.log.ILog
    public void w(String str, String str2) {
        w(str, str2, null);
    }

    @Override // com.heytap.mspsdk.log.ILog
    public void d(String str, String str2, Throwable th) {
        Log.d(str, str2, th);
    }

    @Override // com.heytap.mspsdk.log.ILog
    public void e(String str, String str2, Throwable th) {
        Log.e(str, str2, th);
    }

    @Override // com.heytap.mspsdk.log.ILog
    public void i(String str, String str2, Throwable th) {
        Log.i(str, str2, th);
    }

    @Override // com.heytap.mspsdk.log.ILog
    public void log(int i, String str, String str2, boolean z) {
        if (z || Log.isLoggable(str, i)) {
            Log.println(i, str, str2);
        }
    }

    @Override // com.heytap.mspsdk.log.ILog
    public void v(String str, String str2, Throwable th) {
        Log.v(str, str2, th);
    }

    @Override // com.heytap.mspsdk.log.ILog
    public void w(String str, String str2, Throwable th) {
        Log.w(str, str2, th);
    }
}
