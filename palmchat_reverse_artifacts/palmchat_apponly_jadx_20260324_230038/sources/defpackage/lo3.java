package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.zenmen.palmchat.utils.log.LogUtil;
import defpackage.fn2;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class lo3 {
    public static final String g = "lo3";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fn2 f19041a;
    public Context b;
    public ServiceConnection c;
    public int d = 0;
    public ServiceConnection f = new a();
    public v03 e = new v03();

    /* JADX INFO: compiled from: SearchBox */
    public class a implements ServiceConnection {

        /* JADX INFO: renamed from: lo3$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class C1245a extends HashMap<String, Object> {
            public C1245a() {
                put("action", "bind_service");
                put("status", "onServiceDisconnected");
            }
        }

        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            lo3.this.f19041a = fn2.a.g(iBinder);
            if (lo3.this.c != null) {
                lo3.this.c.onServiceConnected(componentName, iBinder);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            LogUtil.i(lo3.g, 3, new C1245a(), (Throwable) null);
            lo3.this.f19041a = null;
            if (lo3.this.c != null) {
                lo3.this.c.onServiceDisconnected(componentName);
            }
        }
    }

    public lo3(Context context, ServiceConnection serviceConnection) {
        this.b = context;
        this.c = serviceConnection;
    }

    public int d() {
        return this.d;
    }

    public fn2 e() {
        return x03.d().c();
    }

    public void c() {
    }

    public void f() {
    }
}
