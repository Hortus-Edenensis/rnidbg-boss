package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import pl.droidsonroids.gif.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes5.dex */
public class mu2 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<a> f19368a;

    public mu2(a aVar) {
        super(Looper.getMainLooper());
        this.f19368a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        a aVar = this.f19368a.get();
        if (aVar == null) {
            return;
        }
        if (message.what == -1) {
            aVar.invalidateSelf();
            return;
        }
        Iterator<fe> it = aVar.h.iterator();
        while (it.hasNext()) {
            it.next().a(message.what);
        }
    }
}
