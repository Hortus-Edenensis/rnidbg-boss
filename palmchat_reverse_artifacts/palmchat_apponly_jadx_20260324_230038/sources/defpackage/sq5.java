package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import defpackage.mg2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class sq5 implements mg2 {

    @GuardedBy("messagePool")
    public static final List<b> b = new ArrayList(50);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f20823a;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b implements mg2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Message f20824a;

        @Nullable
        public sq5 b;

        public b() {
        }

        public final void a() {
            this.f20824a = null;
            this.b = null;
            sq5.d(this);
        }

        public boolean b(Handler handler) {
            boolean zSendMessageAtFrontOfQueue = handler.sendMessageAtFrontOfQueue((Message) vh.e(this.f20824a));
            a();
            return zSendMessageAtFrontOfQueue;
        }

        public b c(Message message, sq5 sq5Var) {
            this.f20824a = message;
            this.b = sq5Var;
            return this;
        }

        @Override // mg2.a
        public void sendToTarget() {
            ((Message) vh.e(this.f20824a)).sendToTarget();
            a();
        }
    }

    public sq5(Handler handler) {
        this.f20823a = handler;
    }

    public static b c() {
        b bVar;
        List<b> list = b;
        synchronized (list) {
            bVar = list.isEmpty() ? new b() : list.remove(list.size() - 1);
        }
        return bVar;
    }

    public static void d(b bVar) {
        List<b> list = b;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(bVar);
            }
        }
    }

    @Override // defpackage.mg2
    public boolean a(mg2.a aVar) {
        return ((b) aVar).b(this.f20823a);
    }

    @Override // defpackage.mg2
    public Looper getLooper() {
        return this.f20823a.getLooper();
    }

    @Override // defpackage.mg2
    public boolean hasMessages(int i) {
        return this.f20823a.hasMessages(i);
    }

    @Override // defpackage.mg2
    public mg2.a obtainMessage(int i) {
        return c().c(this.f20823a.obtainMessage(i), this);
    }

    @Override // defpackage.mg2
    public boolean post(Runnable runnable) {
        return this.f20823a.post(runnable);
    }

    @Override // defpackage.mg2
    public void removeCallbacksAndMessages(@Nullable Object obj) {
        this.f20823a.removeCallbacksAndMessages(obj);
    }

    @Override // defpackage.mg2
    public void removeMessages(int i) {
        this.f20823a.removeMessages(i);
    }

    @Override // defpackage.mg2
    public boolean sendEmptyMessage(int i) {
        return this.f20823a.sendEmptyMessage(i);
    }

    @Override // defpackage.mg2
    public boolean sendEmptyMessageAtTime(int i, long j) {
        return this.f20823a.sendEmptyMessageAtTime(i, j);
    }

    @Override // defpackage.mg2
    public mg2.a obtainMessage(int i, @Nullable Object obj) {
        return c().c(this.f20823a.obtainMessage(i, obj), this);
    }

    @Override // defpackage.mg2
    public mg2.a obtainMessage(int i, int i2, int i3) {
        return c().c(this.f20823a.obtainMessage(i, i2, i3), this);
    }
}
