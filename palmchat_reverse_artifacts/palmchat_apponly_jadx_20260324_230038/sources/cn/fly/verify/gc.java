package cn.fly.verify;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f2384a;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Message f2385a;
        public final Handler.Callback b;

        public a(Message message, Handler.Callback callback) {
            this.f2385a = message;
            this.b = callback;
        }
    }

    private static Message a(Message message, Handler.Callback callback) {
        Message message2 = new Message();
        message2.obj = new a(message, callback);
        return message2;
    }

    private static Message b(int i, Handler.Callback callback) {
        Message message = new Message();
        message.what = i;
        return a(message, callback);
    }

    private static synchronized void a() {
        if (f2384a == null) {
            b();
        }
    }

    private static void b() {
        f2384a = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: cn.fly.verify.gc.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                gc.b(message);
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Message message) {
        a aVar = (a) message.obj;
        Message message2 = aVar.f2385a;
        Handler.Callback callback = aVar.b;
        if (callback != null) {
            callback.handleMessage(message2);
        }
    }

    public static boolean a(int i, Handler.Callback callback) {
        a();
        return f2384a.sendMessage(b(i, callback));
    }
}
