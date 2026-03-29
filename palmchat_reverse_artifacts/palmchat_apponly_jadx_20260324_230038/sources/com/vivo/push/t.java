package com.vivo.push;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.C;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f11284a = new Handler(Looper.getMainLooper());
    private static final HandlerThread b;
    private static final Handler c;

    static {
        HandlerThread handlerThread = new HandlerThread("push_client_thread");
        b = handlerThread;
        handlerThread.start();
        c = new u(handlerThread.getLooper());
    }

    public static void a(s sVar) {
        if (sVar == null) {
            com.vivo.push.util.t.a("PushClientThread", "client thread error, task is null!");
            return;
        }
        int iA = sVar.a();
        Message message = new Message();
        message.what = iA;
        message.obj = sVar;
        c.sendMessageDelayed(message, 0L);
    }

    public static void b(Runnable runnable) {
        f11284a.post(runnable);
    }

    public static void c(Runnable runnable) {
        Handler handler = c;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public static void a(Runnable runnable) {
        Handler handler = c;
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
    }
}
