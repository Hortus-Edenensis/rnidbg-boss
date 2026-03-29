package com.huawei.openalliance.ad.utils;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class v {
    private Handler Code;

    public v(Handler handler) {
        this.Code = handler;
    }

    public void Code(Runnable runnable) {
        Code(runnable, null, 0L);
    }

    public void Code(Runnable runnable, long j) {
        Code(runnable, null, j);
    }

    public void Code(Runnable runnable, String str) {
        Code(runnable, str, 0L);
    }

    public void Code(Runnable runnable, String str, long j) {
        if (this.Code == null || runnable == null) {
            return;
        }
        if (j < 0) {
            j = 0;
        }
        bh bhVar = new bh(runnable);
        if (j == 0 && Code()) {
            bhVar.run();
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis() + j;
        if (Build.VERSION.SDK_INT >= 22) {
            try {
                Message messageObtain = Message.obtain(this.Code, bhVar);
                messageObtain.setAsynchronous(true);
                messageObtain.obj = str;
                this.Code.sendMessageAtTime(messageObtain, jUptimeMillis);
                return;
            } catch (Throwable unused) {
            }
        }
        this.Code.postAtTime(bhVar, str, jUptimeMillis);
    }

    public void Code(String str) {
        Handler handler = this.Code;
        if (handler == null || str == null) {
            return;
        }
        handler.removeCallbacksAndMessages(str);
    }

    private boolean Code() {
        Looper looper;
        Handler handler = this.Code;
        if (handler == null || (looper = handler.getLooper()) == null) {
            return false;
        }
        return Thread.currentThread() == looper.getThread();
    }
}
