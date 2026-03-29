package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.ByteCompanionObject;
import ms.bz.bd.c.Pgl.pblk;
import okio.Utf8;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pgla {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19344a;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1024);
    public ServiceConnection c = new ServiceConnectionC1249pgla();

    public pgla(Context context) {
        this.f19344a = context;
    }

    public final void a(pblk.pblb pblbVar) {
        try {
            this.f19344a.getPackageManager().getPackageInfo((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "822441", new byte[]{42, Utf8.REPLACEMENT_BYTE, 76, dn.l, 10, 53, 46, 0, 45, 105, 58, 49, 15, 115, 30, 54, 43, TELogUtils.DEBUG_LEVEL_V, 102, 105, 44, 62, 85, 65, 25, Utf8.REPLACEMENT_BYTE, TELogUtils.DEBUG_LEVEL_V, 58, 71}), 0);
        } catch (Exception unused) {
        }
        Intent intent = new Intent();
        intent.setAction((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "6bde26", new byte[]{36, 111, 26, 95, 12, 50, 32, 80, 123, 56, 52, 97, 89, 16, dn.l, 53, 60, 76, 59, 123, 6, 67, 52, 52, 62, 18, 10, 103, 28, 17}));
        intent.setComponent(new ComponentName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "718235", new byte[]{37, 60, 70, 8, dn.k, 49, 33, 3, 39, 111, 53, 50, 5, 117, 25, 50, 36, 28, 108, 111, 35, Base64.padSymbol, 95, 71, 30, 59, 16, 57, 77}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "96d91a", new byte[]{43, 59, 26, 3, 15, 101, 47, 4, 123, 100, 59, 53, 89, 126, 27, 102, 42, 27, 48, 100, 45, 58, 3, 76, 28, 111, 30, 62, 17, 39, 27, 33, 7, 93, 2, 115, 55, 18, 59, 125, 41, 38, dn.l, 105, 39, 82, 9, 18, 39, ByteCompanionObject.MAX_VALUE, 33, 55, 18})));
        if (this.f19344a.bindService(intent, this.c, 1)) {
            try {
                String strU = new pblb(this.b.take()).u();
                if (pblbVar != null) {
                    pblbVar.u(strU);
                }
            } catch (Exception unused2) {
            } catch (Throwable th) {
                this.f19344a.unbindService(this.c);
                throw th;
            }
            this.f19344a.unbindService(this.c);
        }
    }

    /* JADX INFO: renamed from: ms.bz.bd.c.Pgl.pgla$pgla, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class ServiceConnectionC1249pgla implements ServiceConnection {
        public ServiceConnectionC1249pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                pgla.this.b.put(iBinder);
            } catch (Exception unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
