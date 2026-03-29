package ms.bz.bd.c.Pgl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.umeng.analytics.pro.dn;
import kotlin.io.encoding.Base64;
import ms.bz.bd.c.Pgl.pblk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class pblt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f19336a;
    public pblu b;
    public ServiceConnection c = new pgla();

    public pblt(Context context) {
        this.f19336a = context;
    }

    public final void a(pblk.pblb pblbVar) {
        Intent intent = new Intent();
        intent.setClassName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "dffb8a", new byte[]{118, 107, 24, 88, 29, 99, 110, 9, 51, 55, 99, 109, 22, 19, dn.l, 114, 116, 66, 37, 36, 124, 103, 16}), (String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "7a83fc", new byte[]{37, 108, 70, 9, 67, 97, Base64.padSymbol, dn.l, 109, 102, 48, 106, 72, 66, 80, 112, 39, 69, 123, 117, 47, 96, 78, 9, 125, 113, 34, 73, 106, 102, 47, 103, 120, 66, 75, 98, Base64.padSymbol, 67, 108}));
        if (this.f19336a.bindService(intent, this.c, 1)) {
            try {
                pblu pbluVar = this.b;
                if (pbluVar != null) {
                    String strU = pbluVar.u();
                    if (pblbVar != null) {
                        pblbVar.u(strU);
                    }
                }
            } catch (Throwable unused) {
            }
            this.f19336a.unbindService(this.c);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pgla implements ServiceConnection {
        public pgla() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            pblt.this.b = new pblu(iBinder);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
