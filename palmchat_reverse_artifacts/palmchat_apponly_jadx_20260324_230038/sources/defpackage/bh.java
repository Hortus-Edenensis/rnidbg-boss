package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class bh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f1714a = new a(this, Looper.myLooper());
    public b b;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Handler {
        public a(bh bhVar, Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (bh.this.b != null) {
                bh.this.b.onEventNotify(message.what, message.arg1, message.arg2, message.obj);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void onEventNotify(int i, int i2, int i3, Object obj);
    }

    public void b(b bVar) {
        this.b = bVar;
    }
}
