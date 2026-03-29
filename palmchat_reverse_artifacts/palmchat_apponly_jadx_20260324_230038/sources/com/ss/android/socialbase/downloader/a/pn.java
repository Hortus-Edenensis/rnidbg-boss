package com.ss.android.socialbase.downloader.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class pn implements Handler.Callback {
    private volatile Handler u = new Handler(u.u, this);

    /* JADX INFO: compiled from: SearchBox */
    public interface nr {
        long u();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static final Looper u;

        static {
            HandlerThread handlerThread = new HandlerThread("DownloadWatchDog");
            handlerThread.start();
            u = handlerThread.getLooper();
        }
    }

    public static Looper u() {
        return u.u;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        if (message.what != 0) {
            return true;
        }
        try {
            nr nrVar = (nr) message.obj;
            long jU = nrVar.u();
            if (jU <= 0) {
                return true;
            }
            u(nrVar, jU);
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public void nr() {
        Handler handler = this.u;
        if (handler == null) {
            return;
        }
        this.u = null;
        handler.removeCallbacksAndMessages(null);
    }

    public void u(nr nrVar, long j) {
        Handler handler = this.u;
        if (handler == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = nrVar;
        handler.sendMessageDelayed(messageObtain, j);
    }
}
