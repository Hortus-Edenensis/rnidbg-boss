package com.bytedance.sdk.openadsdk.core.multipro.aidl.u;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.t;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends u {
    private static volatile fx nr;
    public static HashMap<String, RemoteCallbackList<t>> u = new HashMap<>();

    public static fx nr() {
        if (nr == null) {
            synchronized (fx.class) {
                if (nr == null) {
                    nr = new fx();
                }
            }
        }
        return nr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u, com.bytedance.sdk.openadsdk.core.s
    public void u(String str, t tVar) throws RemoteException {
        if (tVar == null) {
            return;
        }
        RemoteCallbackList<t> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(tVar);
        u.put(str, remoteCallbackList);
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u, com.bytedance.sdk.openadsdk.core.s
    public void u(String str, int i) throws RemoteException {
        RemoteCallbackList<t> remoteCallbackListRemove = u.remove(str);
        if (remoteCallbackListRemove == null) {
            return;
        }
        int iBeginBroadcast = remoteCallbackListRemove.beginBroadcast();
        for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
            t tVar = (t) remoteCallbackListRemove.getBroadcastItem(i2);
            if (tVar != null) {
                if (i == 1) {
                    tVar.u();
                } else if (i == 2) {
                    tVar.nr();
                } else if (i != 3) {
                    tVar.fx();
                } else {
                    tVar.fx();
                }
            }
        }
        remoteCallbackListRemove.finishBroadcast();
        remoteCallbackListRemove.kill();
    }
}
