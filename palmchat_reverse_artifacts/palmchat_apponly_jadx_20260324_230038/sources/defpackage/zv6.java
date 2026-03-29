package defpackage;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.oplus.instant.router.callback.Callback;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class zv6 extends ContentObserver {
    public static Handler e;
    public static HandlerThread f;
    public static final Object g = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f22529a;
    public Map<String, Object> b;
    public Callback c;
    public Uri d;

    public zv6(Context context, Map<String, Object> map, Callback callback, Uri uri) {
        super(a());
        this.f22529a = context;
        this.b = map;
        this.c = callback;
        this.d = uri;
    }

    public static Handler a() {
        Handler handler;
        synchronized (g) {
            HandlerThread handlerThread = f;
            if (handlerThread == null || !handlerThread.isAlive()) {
                HandlerThread handlerThread2 = new HandlerThread("instant_callback");
                f = handlerThread2;
                handlerThread2.start();
                Looper looper = f.getLooper();
                e = looper != null ? new Handler(looper) : new Handler();
            }
            handler = e;
        }
        return handler;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Uri uri = this.d;
        if (uri != null) {
            onChange(z, uri);
            return;
        }
        Context context = this.f22529a;
        if (context != null) {
            context.getContentResolver().unregisterContentObserver(this);
        }
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z, Uri uri) {
        Context context;
        Uri uri2 = this.d;
        if (uri2 == null || !uri2.equals(uri) || (context = this.f22529a) == null) {
            return;
        }
        Callback callback = this.c;
        if (callback != null) {
            callback.onResponse(this.b, u97.b(context, uri));
        }
        this.f22529a.getContentResolver().unregisterContentObserver(this);
    }
}
