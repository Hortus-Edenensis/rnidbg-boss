package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import ms.bz.bd.c.Pgl.pblk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pblp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19333a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1024);
    public ServiceConnection c = new pgla();

    public pblp(Context context) {
        this.f19333a = context;
    }

    public final void a(pblk.pblb pblbVar) {
        int i = Build.VERSION.SDK_INT;
        if (i != 28 && i < 33) {
            try {
                this.f19333a.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "34b28c", new byte[]{33, 57, 28, 8, 15, 97, 49, 2, 54, 107, 108, 62, 6, 79, 3}), 0);
            } catch (Exception unused) {
            }
            Intent intent = new Intent((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d37128", new byte[]{118, 62, 73, 11, 24, 32, 99, 27, 117, 47, 122, 33, 65, 75, 9, 42, 113, 27, 101, 100, 59, 30, 116, 96, 35, 6, 67, 33, 89, 82, 80, 3, 114, 108, 46, 10}));
            intent.setPackage((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "5e312d", new byte[]{39, 104, 77, 11, 5, 102, 55, 83, 103, 104, 106, 111, 87, 76, 9}));
            if (this.f19333a.bindService(intent, this.c, 1)) {
                try {
                    String strU = new pbla(this.b.take()).u();
                    if (pblbVar != null) {
                        pblbVar.u(strU);
                    }
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    this.f19333a.unbindService(this.c);
                    throw th;
                }
                this.f19333a.unbindService(this.c);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pgla implements ServiceConnection {
        public pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                pblp.this.b.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
