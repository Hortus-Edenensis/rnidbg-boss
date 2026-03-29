package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class ti6 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<a> f21004a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(Message message);
    }

    public ti6(a aVar) {
        this(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f21004a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.a(message);
    }

    public ti6(Looper looper, a aVar) {
        super(looper);
        this.f21004a = new WeakReference<>(aVar);
    }
}
