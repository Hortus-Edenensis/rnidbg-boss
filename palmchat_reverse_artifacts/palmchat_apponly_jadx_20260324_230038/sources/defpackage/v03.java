package defpackage;

import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.ParcelPair;
import com.zenmen.palmchat.Vo.SyncKeys;
import com.zenmen.palmchat.messaging.b;
import com.zenmen.palmchat.utils.log.LogUtil;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class v03 implements fn2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fn2 f21336a;

    @Override // defpackage.fn2
    public void A() throws RemoteException {
        this.f21336a.A();
    }

    @Override // defpackage.fn2
    public void E() throws RemoteException {
        this.f21336a.E();
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this.f21336a.asBinder();
    }

    @Override // defpackage.fn2
    public ParcelPair h() throws RemoteException {
        return this.f21336a.h();
    }

    @Override // defpackage.fn2
    public void i(String str, String str2) throws RemoteException {
        this.f21336a.i(str, str2);
    }

    @Override // defpackage.fn2
    public boolean isConnected() throws RemoteException {
        return this.f21336a.isConnected();
    }

    @Override // defpackage.fn2
    public void j() throws RemoteException {
        this.f21336a.j();
    }

    @Override // defpackage.fn2
    public boolean k(boolean z, boolean z2, SyncKeys syncKeys) throws RemoteException {
        return this.f21336a.k(z, z2, syncKeys);
    }

    @Override // defpackage.fn2
    public void l(MessageVo messageVo) throws RemoteException {
        this.f21336a.l(messageVo);
    }

    @Override // defpackage.fn2
    public void q() throws RemoteException {
        this.f21336a.q();
    }

    @Override // defpackage.fn2
    public void r(MessageVo messageVo) throws RemoteException {
        try {
            this.f21336a.r(messageVo);
        } catch (DeadObjectException e) {
            HashMap map = new HashMap();
            map.put("action", "sendText");
            map.put("status", "DeadObjectException");
            LogUtil.i("LXMessageBindWrapper", LogUtil.LogType.LOG_TYPE_ANR_NEW, 3, (HashMap<String, Object>) map, e);
            try {
                b.d().e().N(messageVo);
            } catch (Exception e2) {
                e2.printStackTrace();
                HashMap map2 = new HashMap();
                map2.put("action", "sendText");
                map2.put("status", "UnExpectedException");
                LogUtil.i("LXMessageBindWrapper", LogUtil.LogType.LOG_TYPE_ANR_NEW, 3, (HashMap<String, Object>) map2, e2);
            }
        }
    }

    @Override // defpackage.fn2
    public void s(String str) throws RemoteException {
        this.f21336a.s(str);
    }

    @Override // defpackage.fn2
    public boolean w() throws RemoteException {
        return this.f21336a.w();
    }

    @Override // defpackage.fn2
    public void x(long j) throws RemoteException {
        this.f21336a.x(j);
    }
}
